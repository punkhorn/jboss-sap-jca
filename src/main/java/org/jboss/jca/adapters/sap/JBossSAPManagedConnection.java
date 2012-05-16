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

import com.sap.conn.jco.JCoException;

/**
 * JBossSAPManagedConnection
 * 
 * @version $Revision: $
 */
public class JBossSAPManagedConnection implements ManagedConnection, DissociatableManagedConnection {
	
	public static enum State {
		ACTIVE,DESTROYED;
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
	 * Default constructor
	 * 
	 * @param mcf
	 *            mcf
	 * @throws JCoException
	 * @throws ResourceException
	 */
	public JBossSAPManagedConnection(JBossSAPManagedConnectionFactory mcf, JBossSAPConnectionSpec connectionRequestInfo)
			throws JCoException, ResourceException {
		this.managedConnectionFactory = mcf;
		this.logwriter = null;
		this.listeners = Collections.synchronizedList(new ArrayList<ConnectionEventListener>(1));
		this.defaultConnectionRequestInfo = connectionRequestInfo;
	}

	/**
	 * Creates a new connection handle for the underlying physical connection
	 * represented by the ManagedConnection instance.
	 * 
	 * @param subject
	 *            Security context as JAAS subject
	 * @param cxRequestInfo
	 *            ConnectionRequestInfo instance
	 * @return generic Object instance representing the connection handle.
	 * @throws ResourceException
	 *             generic exception if operation fails
	 */
	public Object getConnection(Subject subject, ConnectionRequestInfo cxRequestInfo) throws ResourceException {
		log.finest("getConnection()");
		checkState();
		if (cxRequestInfo != null && !(cxRequestInfo instanceof JBossSAPConnectionSpec))
			throw new ResourceException("jboss-sap-managed-connection-invalid-connection-request-info-type");

		JBossSAPCciConnection connection = new JBossSAPCciConnection(this, (JBossSAPConnectionSpec)cxRequestInfo);
		
		return connection;
	}

	/**
	 * Used by the container to change the association of an application-level
	 * connection handle with a ManagedConneciton instance.
	 * 
	 * @param connection
	 *            Application-level connection handle
	 * @throws ResourceException
	 *             generic exception if operation fails
	 */
	public void associateConnection(Object connection) throws ResourceException {
		log.finest("associateConnection()");
		checkState();
		if (!(connection instanceof JBossSAPCciConnection)) 
			throw new ResourceException("jboss-sap-managed-connection-invalid-cci-connection-type");
		
		JBossSAPCciConnection cciConnection = (JBossSAPCciConnection) connection;
		cciConnection.associateManagedConnection(this);
	}
	
	public void dissociateConnections() throws ResourceException {
		log.finest("dissociateConnection()");
		checkState();
		
		Collection<JBossSAPCciConnection> copy = null;
		synchronized (handles) {
			if (handles.size() > 0) 
				copy = new HashSet<JBossSAPCciConnection>(handles);
		}
		
		if (copy != null) {
			for (JBossSAPCciConnection cciConnection: copy) {
				cciConnection.dissociateManagedConnection();
			}
		}
		
	}

	/**
	 * Application server calls this method to force any cleanup on the
	 * ManagedConnection instance.
	 * 
	 * @throws ResourceException
	 *             generic exception if operation fails
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
			for (JBossSAPCciConnection cciConnection: copy) {
				cciConnection.close();
			}
		}
	}

	/**
	 * Destroys the physical connection to the underlying resource manager.
	 * 
	 * @throws ResourceException
	 *             generic exception if operation fails
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
	 * Adds a connection event listener to the ManagedConnection instance.
	 * 
	 * @param listener
	 *            A new ConnectionEventListener to be registered
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
	 * Removes an already registered connection event listener from the
	 * ManagedConnection instance.
	 * 
	 * @param listener
	 *            already registered connection event listener to be removed
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
	 * Close handle
	 * 
	 * @param handle
	 *            The handle
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
	 * Gets the log writer for this ManagedConnection instance.
	 * 
	 * @return Character ourput stream associated with this Managed-Connection
	 *         instance
	 * @throws ResourceException
	 *             generic exception if operation fails
	 */
	public PrintWriter getLogWriter() throws ResourceException {
		log.finest("getLogWriter()");
		return logwriter;
	}

	/**
	 * Sets the log writer for this ManagedConnection instance.
	 * 
	 * @param out
	 *            Character Output stream to be associated
	 * @throws ResourceException
	 *             generic exception if operation fails
	 */
	public void setLogWriter(PrintWriter out) throws ResourceException {
		log.finest("setLogWriter()");
		logwriter = out;
	}

	/**
	 * Returns an <code>javax.resource.spi.LocalTransaction</code> instance.
	 * 
	 * @return LocalTransaction instance
	 * @throws ResourceException
	 *             generic exception if operation fails
	 */
	public LocalTransaction getLocalTransaction() throws ResourceException {
		throw new NotSupportedException("jboss-sap-managed-connection-local-transaction-not-supported");
	}

	/**
	 * Returns an <code>javax.transaction.xa.XAresource</code> instance.
	 * 
	 * @return XAResource instance
	 * @throws ResourceException
	 *             generic exception if operation fails
	 */
	public XAResource getXAResource() throws ResourceException {
		throw new NotSupportedException("jboss-sap-managed-connection-get-xa-resource-not-supported");
	}

	/**
	 * Gets the metadata information for this connection's underlying EIS
	 * resource manager instance.
	 * 
	 * @return ManagedConnectionMetaData instance
	 * @throws ResourceException
	 *             generic exception if operation fails
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
		synchronized(handles) {
			handles.add(handle);
		}
	}

	void dissociateHandle(JBossSAPCciConnection handle) {
		synchronized(handles) {
			handles.remove(handle);
		}
	}
	
	void checkState() throws ResourceException {
		if (state == State.DESTROYED) {
			throw new ResourceException("jboss-sap-managed-connection-is-destroyed");
		}
	}

}
