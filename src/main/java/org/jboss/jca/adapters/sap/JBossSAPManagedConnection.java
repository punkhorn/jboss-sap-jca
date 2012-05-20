/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.jca.adapters.sap;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.resource.NotSupportedException;
import javax.resource.ResourceException;
import javax.resource.spi.ConnectionEvent;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.DissociatableManagedConnection;
import javax.resource.spi.LocalTransaction;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionMetaData;
import javax.security.auth.Subject;
import javax.transaction.xa.XAResource;

/**
 * Implements the {@link ManagedConnection } and {@link DissociatableManagedConnection } interfaces for the JBoss SAP JCA
 * Connector.
 * 
 * @author William Collins
 * 
 * @version $Revision: $
 */
public class JBossSAPManagedConnection implements ManagedConnection, DissociatableManagedConnection {

	public static enum State {
		ACTIVE, DESTROYED;
	}

	/** The logger */
	private static Logger log = Logger.getLogger("JBossSAPManagedConnection");

	/** The logwriter */
	private PrintWriter logwriter;

	/** ManagedConnectionFactory */
	private JBossSAPManagedConnectionFactory managedConnectionFactory;

	/** Listeners */
	private List<ConnectionEventListener> listeners;

	private final Set<JBossSAPCciConnection> handles = new HashSet<JBossSAPCciConnection>();

	private JBossSAPConnectionSpec defaultConnectionRequestInfo;

	private State state = State.ACTIVE;

	/**
	 * Construct managed connection with specified connection request info and associated with specified managed
	 * connection factory.
	 * 
	 * @param mcf - the associated managed connection factory
	 * @param connectionRequestInfo - the connection request info configuration
	 * @throws ResourceException
	 */
	public JBossSAPManagedConnection(JBossSAPManagedConnectionFactory mcf, JBossSAPConnectionSpec connectionRequestInfo)
			throws ResourceException {
		this.managedConnectionFactory = mcf;
		this.logwriter = null;
		this.listeners = Collections.synchronizedList(new ArrayList<ConnectionEventListener>(1));
		this.defaultConnectionRequestInfo = connectionRequestInfo;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getConnection(Subject subject, ConnectionRequestInfo cxRequestInfo) throws ResourceException {
		log.finest("getConnection()");
		checkState();
		if (cxRequestInfo != null && !(cxRequestInfo instanceof JBossSAPConnectionSpec))
			throw new ResourceException("jboss-sap-managed-connection-invalid-connection-request-info-type");

		JBossSAPCciConnection connection = new JBossSAPCciConnection(this, (JBossSAPConnectionSpec) cxRequestInfo);

		return connection;
	}

	/**
	 * {@inheritDoc}
	 */
	public void associateConnection(Object connection) throws ResourceException {
		log.finest("associateConnection()");
		checkState();
		if (!(connection instanceof JBossSAPCciConnection))
			throw new ResourceException("jboss-sap-managed-connection-invalid-cci-connection-type");

		JBossSAPCciConnection cciConnection = (JBossSAPCciConnection) connection;
		cciConnection.associateManagedConnection(this);
	}

	/**
	 * {@inheritDoc}
	 */
	public void dissociateConnections() throws ResourceException {
		log.finest("dissociateConnection()");
		checkState();

		Collection<JBossSAPCciConnection> copy = null;
		synchronized (handles) {
			if (handles.size() > 0)
				copy = new HashSet<JBossSAPCciConnection>(handles);
		}

		if (copy != null) {
			for (JBossSAPCciConnection cciConnection : copy) {
				cciConnection.dissociateManagedConnection();
			}
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void cleanup() throws ResourceException

	{
		log.finest("cleanup()");

		Collection<JBossSAPCciConnection> copy = null;
		synchronized (handles) {
			if (handles.size() > 0)
				copy = new HashSet<JBossSAPCciConnection>(handles);
		}

		if (copy != null) {
			for (JBossSAPCciConnection cciConnection : copy) {
				cciConnection.close();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void destroy() throws ResourceException {
		log.finest("destroy()");

		synchronized (state) {
			if (state == State.DESTROYED)
				return;
			state = State.DESTROYED;
		}

		cleanup();
	}

	/**
	 * {@inheritDoc}
	 */
	public void addConnectionEventListener(ConnectionEventListener listener) {
		log.finest("addConnectionEventListener()");
		if (listener == null)
			throw new IllegalArgumentException("jboss-sap-managed-connection-connection-event-listener-is-null");
		synchronized (listeners) {
			listeners.add(listener);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeConnectionEventListener(ConnectionEventListener listener) {
		log.finest("removeConnectionEventListener()");
		if (listener == null)
			throw new IllegalArgumentException("jboss-sap-managed-connection-connection-event-listener-is-null");
		synchronized (listeners) {
			listeners.remove(listener);
		}
	}

	/**
	 * Close application level handle handle to this connection
	 * 
	 * @param handle -
	 *            The application handle
	 */
	public void closeHandle(JBossSAPCciConnection handle) {

		dissociateHandle(handle);

		Collection<ConnectionEventListener> copy = null;
		synchronized (listeners) {
			if (listeners != null && listeners.size() > 0)
				copy = new ArrayList<ConnectionEventListener>(listeners);
		}

		if (copy != null) {
			ConnectionEvent event = new ConnectionEvent(this, ConnectionEvent.CONNECTION_CLOSED);
			event.setConnectionHandle(handle);
			for (ConnectionEventListener cel : copy) {
				cel.connectionClosed(event);
			}
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public PrintWriter getLogWriter() throws ResourceException {
		log.finest("getLogWriter()");
		return logwriter;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setLogWriter(PrintWriter out) throws ResourceException {
		log.finest("setLogWriter()");
		logwriter = out;
	}

	/**
	 * {@inheritDoc}
	 */
	public LocalTransaction getLocalTransaction() throws ResourceException {
		throw new NotSupportedException("jboss-sap-managed-connection-local-transaction-not-supported");
	}

	/**
	 * {@inheritDoc}
	 */
	public XAResource getXAResource() throws ResourceException {
		throw new NotSupportedException("jboss-sap-managed-connection-get-xa-resource-not-supported");
	}

	/**
	 * {@inheritDoc}
	 */
	public ManagedConnectionMetaData getMetaData() throws ResourceException {
		log.finest("getMetaData()");
		return new JBossSAPManagedConnectionMetaData();
	}

	JBossSAPManagedConnectionFactory getManagedConnectionFactory() {
		return managedConnectionFactory;
	}

	JBossSAPConnectionSpec getDefaultConnectionRequestInfo() {
		return defaultConnectionRequestInfo;
	}

	void associateHandle(JBossSAPCciConnection handle) {
		synchronized (handles) {
			handles.add(handle);
		}
	}

	void dissociateHandle(JBossSAPCciConnection handle) {
		synchronized (handles) {
			handles.remove(handle);
		}
	}

	void checkState() throws ResourceException {
		if (state == State.DESTROYED) {
			throw new ResourceException("jboss-sap-managed-connection-is-destroyed");
		}
	}

}
