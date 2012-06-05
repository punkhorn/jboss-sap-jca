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
package org.jboss.jca.adapters.sap.impl;

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

import org.jboss.jca.adapters.sap.cci.JBossSAPCciConnection;
import org.jboss.jca.adapters.sap.cci.JBossSAPConnectionSpec;

/**
 * Implements the {@link ManagedConnection } and {@link DissociatableManagedConnection } interfaces for the JBoss SAP JCA
 * Connector.
 * 
 * @author William Collins
 * 
 * @version $Id: $
 */
public class ManagedConnectionImpl implements ManagedConnection, DissociatableManagedConnection {

	public static enum State {
		ACTIVE, DESTROYED;
	}

	/** The logger */
	private static Logger log = Logger.getLogger("JBossSAPManagedConnection");

	/** The logwriter */
	private PrintWriter logwriter;

	/** ManagedConnectionFactory */
	private ManagedConnectionFactoryImpl managedConnectionFactory;

	/** Listeners */
	private List<ConnectionEventListener> listeners;

	private final Set<CciConnectionImpl> handles = new HashSet<CciConnectionImpl>();

	private JBossSAPConnectionSpec defaultConnectionRequestInfo;
	
	private CciConnectionImpl defaultConnection;

	private State state = State.ACTIVE;

	/**
	 * Construct managed connection with specified connection request info and associated with specified managed
	 * connection factory.
	 * 
	 * @param mcf - the associated managed connection factory
	 * @param connectionRequestInfo - the connection request info configuration
	 * @throws ResourceException
	 */
	public ManagedConnectionImpl(ManagedConnectionFactoryImpl mcf, JBossSAPConnectionSpec connectionRequestInfo)
			throws ResourceException {
		this.managedConnectionFactory = mcf;
		this.logwriter = null;
		this.listeners = Collections.synchronizedList(new ArrayList<ConnectionEventListener>(1));
		this.defaultConnectionRequestInfo = connectionRequestInfo;
		this.managedConnectionFactory.associateConnection(this);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return this.defaultConnectionRequestInfo.hashCode();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof ManagedConnectionImpl))
			return false;
		ManagedConnectionImpl obj = (ManagedConnectionImpl) other;
		return this.defaultConnectionRequestInfo.equals(obj.defaultConnectionRequestInfo);
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getConnection(Subject subject, ConnectionRequestInfo cxRequestInfo) throws ResourceException {
		log.finest("getConnection()");
		checkState();
		if (cxRequestInfo != null && !(cxRequestInfo instanceof JBossSAPConnectionSpec))
			throw new ResourceException("managed-connection-impl-invalid-connection-request-info-type");

		JBossSAPCciConnection connection = new CciConnectionImpl(this, (JBossSAPConnectionSpec) cxRequestInfo);

		return connection;
	}

	/**
	 * {@inheritDoc}
	 */
	public void associateConnection(Object connection) throws ResourceException {
		log.finest("associateConnection()");
		checkState();
		if (!(connection instanceof CciConnectionImpl))
			throw new ResourceException("managed-connection-impl-invalid-cci-connection-type");

		CciConnectionImpl cciConnection = (CciConnectionImpl) connection;
		cciConnection.associateManagedConnection(this);
	}

	/**
	 * {@inheritDoc}
	 */
	public void dissociateConnections() throws ResourceException {
		log.finest("dissociateConnection()");
		checkState();

		Collection<CciConnectionImpl> copy = null;
		synchronized (handles) {
			if (handles.size() > 0)
				copy = new HashSet<CciConnectionImpl>(handles);
		}

		if (copy != null) {
			for (CciConnectionImpl cciConnection : copy) {
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

		Collection<CciConnectionImpl> copy = null;
		synchronized (handles) {
			if (handles.size() > 0)
				copy = new HashSet<CciConnectionImpl>(handles);
		}

		if (copy != null) {
			for (CciConnectionImpl cciConnection : copy) {
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
		this.managedConnectionFactory.dissociateConnection(this);
	}

	/**
	 * {@inheritDoc}
	 */
	public void addConnectionEventListener(ConnectionEventListener listener) {
		log.finest("addConnectionEventListener()");
		if (listener == null)
			throw new IllegalArgumentException("managed-connection-impl-connection-event-listener-is-null");
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
			throw new IllegalArgumentException("managed-connection-impl-connection-event-listener-is-null");
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
		throw new NotSupportedException("managed-connection-impl-local-transaction-not-supported");
	}

	/**
	 * {@inheritDoc}
	 */
	public XAResource getXAResource() throws ResourceException {
		throw new NotSupportedException("managed-connection-impl-get-xa-resource-not-supported");
	}

	/**
	 * {@inheritDoc}
	 */
	public ManagedConnectionMetaData getMetaData() throws ResourceException {
		log.finest("getMetaData()");

		if (defaultConnection == null) 
			defaultConnection = new CciConnectionImpl(this, null);

		return new ManagedConnectionMetaDataImpl(defaultConnection);
	}

	ManagedConnectionFactoryImpl getManagedConnectionFactory() {
		return managedConnectionFactory;
	}

	JBossSAPConnectionSpec getDefaultConnectionRequestInfo() {
		return defaultConnectionRequestInfo;
	}

	void associateHandle(CciConnectionImpl handle) {
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
			throw new ResourceException("managed-connection-impl-is-destroyed");
		}
	}

}
