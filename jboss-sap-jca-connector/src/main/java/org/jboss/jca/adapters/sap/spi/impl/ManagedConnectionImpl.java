/**
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
 * 
 */
package org.jboss.jca.adapters.sap.spi.impl;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionEvent;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.LocalTransaction;
import javax.resource.spi.ManagedConnectionMetaData;
import javax.resource.spi.ResourceAdapterAssociation;
import javax.resource.spi.security.PasswordCredential;
import javax.security.auth.Subject;
import javax.transaction.xa.XAResource;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.jboss.jca.adapters.sap.cci.Connection;
import org.jboss.jca.adapters.sap.cci.impl.ConnectionImpl;
import org.jboss.jca.adapters.sap.spi.ManagedConnection;
import org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory;

import com.sap.conn.jco.JCoContext;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.ext.DestinationDataProvider;

/**
 * <!-- begin-user-doc -->
 * Implements the {@link ManagedConnectionFactory } and {@link ResourceAdapterAssociation } interfaces for the JBoss SAP
 * JCA Connector.
 * 
 * @author William Collins
 * 
 * @version $Id:  $
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ManagedConnectionImpl extends EObjectImpl implements ManagedConnection {
	
	/**
	 * Remote function module called to commit transaction
	 *
	 * @generated NOT
	 */
	private static final String COMMIT_FUNCTION = "BAPI_TRANSACTION_COMMIT";
	
	/**
	 * Name of import variable set in remote function call to commit transaction that causes synchronous commit 
	 *
	 * @generated NOT
	 */
	private static final String SYNC_COMMIT_PARAM = "WAIT";

	/**
	 * Value pass in remote function call to commit transaction that causes synchronous commit.
	 *
	 * @generated NOT
	 */
	private static final String SYNC_COMMIT_PARAM_VAL = "X";

	/**
	 * Remote function module called to rollback transaction
	 *
	 * @generated NOT
	 */
	private static final String ROLLBACK_FUNCTION = "BAPI_TRANSACTION_ROLLBACK";
	
	/**
	 * States of a manage connection.
	 *
	 * @generated NOT
	 */
	public static enum State {
		ACTIVE,		/* Valid managed connection with active physical connection to SAP system */ 
		DESTROYED;	/* Invalid managed connection */
	}
	
	/** 
	 * The logwriter set by application server 
	 *
	 * @generated NOT
	 */
	private PrintWriter logwriter;

	/** 
	 * The factory this managed connection is associated with 
	 *
	 * @generated NOT
	 */
	private ManagedConnectionFactoryImpl managedConnectionFactory;

	/** 
	 * The application server call backs observing this connection 
	 *
	 * @generated NOT
	 */
	private List<ConnectionEventListener> listeners;

	/** 
	 * Set of active connection handles associated with this managed connection 
	 *
	 * @generated NOT
	 */
	private final Set<Connection> handles = new HashSet<Connection>();

	/** 
	 * Unique name of destination associated with this managed connection in JCo runtime 
	 *
	 * @generated NOT
	 */
	private String destinationName;
	
	/** 
	 * Physical connection handle to SAP system in JCo runtime
	 *
	 * @generated NOT
	 */
	private JCoDestination destination;
	
	/** 
	 * Meta data describing this managed connection 
	 *
	 * @generated NOT
	 */
	private ManagedConnectionMetaDataImpl connectionMetaData = null;

	/** 
	 * State of connection.
	 * 
	 * Managed connection starts in <code>ACTIVE</code> state when created and transitions to final <code>DESTROYED</code> state 
	 * when destroyed by application server. 
	 *
	 * @generated NOT
	 */
	private State state = State.ACTIVE;
	
	/**
	 * The local transaction object that enables application server and clients to manage connections transaction context.
	 *
	 * @generated NOT
	 */
	private final LocalTransactionImpl localTransaction = new LocalTransactionImpl(this);
	
	/**
	 * Flag indicating whether this managed connection is in transaction.
	 *
	 * @generated NOT
	 */
	private boolean inTransaction = false;
	
	/**
	 * <!-- begin-user-doc -->
	 * Create an empty instance of a {@link ManagedConnection}.
	 * 
	 * <p> Note this should only be used for serialization
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ManagedConnectionImpl() {
		super();
	}

	/**
	 * Construct a managed connection with specified connection request info and associated with the specified managed
	 * connection factory.
	 * 
	 * @param mcf - the associated managed connection factory
	 * @param connectionRequestInfo - the connection request info configuration
	 * @throws ResourceException
	 * 
	 * @generated NOT
	 */
	public ManagedConnectionImpl(ManagedConnectionFactoryImpl mcf, ConnectionRequestInfoImpl connectionRequestInfo)
			throws ResourceException {
		this.managedConnectionFactory = mcf;
		this.logwriter = null;
		this.listeners = Collections.synchronizedList(new ArrayList<ConnectionEventListener>(1));

		// Create unique destination name for destination property configuration. 
		destinationName = UUID.randomUUID().toString();
		
		// Make destination configuration available to JCo runtime
		this.managedConnectionFactory.getResourceAdapter().getDestinationDataProvider()
				.addConnectionRequestInfo(destinationName, connectionRequestInfo);
		
		// Attempt to connect to SAP system.
		try {
			this.destination = JCoDestinationManager.getDestination(destinationName);
			if (connectionRequestInfo.getPingOnCreate().equals("true"))
				this.destination.ping();
		} catch (JCoException e) {
			this.destroy();
			throw ExceptionBundle.EXCEPTIONS.failedToCreateManagedConnection(e);
		}

		this.managedConnectionFactory.associateConnection(this);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpiPackageImpl.Literals.MANAGED_CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean equals(Object other) {
		if (state == State.DESTROYED)
			return false;
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof ManagedConnectionImpl))
			return false;
		ManagedConnectionImpl obj = (ManagedConnectionImpl) other;
		return destination.getProperties().equals(obj.destination.getProperties());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int hashCode() {
		if (state == State.DESTROYED) 
			return 7;
		return destination.getProperties().hashCode();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized Object getConnection(Subject subject, ConnectionRequestInfo connectionRequestInfo) throws ResourceException {
		checkState();
		if (connectionRequestInfo != null && !(connectionRequestInfo instanceof ConnectionRequestInfoImpl))
			throw new ResourceException("managed-connection-impl-invalid-connection-request-info-type");

		// Validate subject credentials match those of this connection.
		if (subject != null) {
			boolean foundMatchingCredential = false;
			searchPrivateCredentials: for (PasswordCredential credential : subject.getPrivateCredentials(PasswordCredential.class)) {
				if (credential.getManagedConnectionFactory().equals(this)) {
					if (!getConnectionRequestInfo().getUserName()
							.equals(credential.getUserName())) {
						continue searchPrivateCredentials;
					} else if (!getConnectionRequestInfo().getPassword()
							.equals(new String(credential.getPassword()))) {
						continue searchPrivateCredentials;
					}
					// Found matching credentials.
					foundMatchingCredential = true;
					break searchPrivateCredentials;
				}
			}
			if (!foundMatchingCredential) 
				throw ExceptionBundle.EXCEPTIONS.failedToFindMatchingSecurityCredentialsInSubject();
		}
		
		if (connectionRequestInfo != null) {
		ConnectionRequestInfoImpl jCxRequestInfo = (ConnectionRequestInfoImpl) connectionRequestInfo;
			searchConnectionRequestProperties: for (Entry<Object, Object> entry : jCxRequestInfo.getProperties().entrySet()) {
				if (subject != null
						&& (entry.getKey().equals(DestinationDataProvider.JCO_USER) || entry.getKey().equals(
								DestinationDataProvider.JCO_PASSWD)))
					// Already checked management credentials against subject credentials which override
					// connection request info credentials.
					continue searchConnectionRequestProperties;
	
				if (!getProperties().get(entry.getKey()).equals(entry.getValue()))
					throw ExceptionBundle.EXCEPTIONS.connectionRequestInfoParameterDoesNotMatch(entry.getValue().toString(), entry.getKey().toString(), getProperties().get(entry.getKey()).toString());
			}
		}

		Connection connection = new ConnectionImpl(this);

		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addConnectionEventListener(ConnectionEventListener listener) {
		if (listener == null)
			throw ExceptionBundle.EXCEPTIONS.connectionEventListenerIsNull();
		synchronized (listeners) {
			listeners.add(listener);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeConnectionEventListener(ConnectionEventListener listener) {
		if (listener == null)
			throw ExceptionBundle.EXCEPTIONS.connectionEventListenerIsNull();
		synchronized (listeners) {
			listeners.remove(listener);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LocalTransaction getLocalTransaction() throws ResourceException {
		return localTransaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public XAResource getXAResource() throws ResourceException {
		throw ExceptionBundle.EXCEPTIONS.xaResourceIsNotSupported();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized ManagedConnectionMetaData getMetaData() throws ResourceException {
		checkState();
		if (connectionMetaData == null) 
			connectionMetaData = new ManagedConnectionMetaDataImpl(destination); 
		return connectionMetaData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PrintWriter getLogWriter() throws ResourceException {
		return logwriter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setLogWriter(PrintWriter out) throws ResourceException {
		logwriter = out;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void associateConnection(Object connection) throws ResourceException {
		checkState();
		if (!(connection instanceof ConnectionImpl))
			throw ExceptionBundle.EXCEPTIONS.invalidConnectionTypeAssociatedWithManagedConnection(connection == null ? "null": connection.getClass().getName());

		ConnectionImpl cciConnection = (ConnectionImpl) connection;
		cciConnection.associateManagedConnection(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void dissociateConnections() throws ResourceException {
		checkState();

		Collection<Connection> copy = null;
		if (handles.size() > 0)
			copy = new HashSet<Connection>(handles);

		if (copy != null) {
			for (Connection cciConnection : copy) {
				((ConnectionImpl)cciConnection).dissociateManagedConnection();
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void cleanup() throws ResourceException {
		Collection<Connection> copy = null;
		if (handles.size() > 0)
			copy = new HashSet<Connection>(handles);

		if (copy != null) {
			for (Connection cciConnection : copy) {
				cciConnection.close();
			}
		}
		
		// End any stateful session.
		internalEndStatefulSession();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void destroy() throws ResourceException {
		if (state == State.DESTROYED)
			return;
		state = State.DESTROYED;

		// Cleanup any outstanding connection handles.
		cleanup();
		
		this.managedConnectionFactory.dissociateConnection(this);
		
		// Remove destination configuration from JCo runtime
		this.managedConnectionFactory.getResourceAdapter().getDestinationDataProvider()
				.removeConnectionRequestInfo(destinationName);
		
		managedConnectionFactory = null;
		destination = null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Properties getProperties() throws ResourceException {
		checkState();
		return managedConnectionFactory.getResourceAdapter().getDestinationDataProvider().getDestinationProperties(destinationName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo getConnectionRequestInfo() throws ResourceException {
		return managedConnectionFactory.getResourceAdapter().getDestinationDataProvider().getConnectionRequestInfo(destinationName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public JCoDestination getDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ManagedConnectionFactory getManagedConnectionFactory() throws ResourceException {
		checkState();
		return managedConnectionFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isStateful() {
		if (state == State.DESTROYED)
			return false;
		return JCoContext.isStateful(destination);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void beginStatefulSession() throws ResourceException {
		checkState();
		JCoContext.begin(destination);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public synchronized void endStatefulSession() throws ResourceException {
		checkState();
		
		if (inTransaction)
			throw ExceptionBundle.EXCEPTIONS.connectionHasOutstandingTransaction();
		
		internalEndStatefulSession();
	}

	/**
	 * Internal logic to end stateful session.
	 * <p>NB: logic refactored into internal method in order to call without state and transaction checks from {@link #cleanup() }.
	 * @throws ResourceException
	 * 
	 * @generated NOT
	 */
	protected void internalEndStatefulSession() throws ResourceException {
		if (!JCoContext.isStateful(destination))
			return;
		
		try {
			JCoContext.end(destination);
		} catch (JCoException e) {
			throw new ResourceException(e);
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void ping() throws ResourceException {
		checkState();
		try {
			destination.ping();
		} catch (JCoException e) {
			throw ExceptionBundle.EXCEPTIONS.pingFailed(e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public synchronized void associateHandle(Connection handle) throws ResourceException {
		checkState();
		handles.add(handle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public synchronized void dissociateHandle(Connection handle) throws ResourceException {
		checkState();
		handles.remove(handle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void closeHandle(Connection handle) throws ResourceException {

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
	 * Begins stateful session in SAP system and informs application server that transaction has begun.
	 * 
	 * @throws ResourceException If connection has already begun a transaction.
	 * 
	 * @generated NOT
	 */
	protected synchronized void beginLocalTransaction() throws ResourceException {
		checkState();
		
		if (inTransaction) 
			// JCA 1.5 Specification: 7.8.3
			throw ExceptionBundle.EXCEPTIONS.connectionHasOutstandingTransaction();
		inTransaction = true;
		
		// Start stateful session for transaction
		beginStatefulSession();

		// Notify connection event listeners of local transaction start.
		Collection<ConnectionEventListener> copy = null;
		synchronized (listeners) {
			if (listeners != null && listeners.size() > 0)
				copy = new ArrayList<ConnectionEventListener>(listeners);
		}
		if (copy != null) {
			// JCA 1.5 Specification: 7.7.2.1
			ConnectionEvent event = new ConnectionEvent(this, ConnectionEvent.LOCAL_TRANSACTION_STARTED);
			for (ConnectionEventListener cel : copy) {
				cel.localTransactionStarted(event);
			}
		}
		
	}
	
	/**
	 * Invokes commit RFM in SAP system, ends stateful session and informs application server that transaction has committed. 
	 * 
	 * @throws ResourceException If connection has not begun a transaction or error occurs in JCo runtime.
	 * 
	 * @generated NOT
	 */
	protected synchronized void commitLocalTransaction() throws ResourceException {
		checkState();
		
		if (!inTransaction) 
			// JCA 1.5 Specification: 7.8.3
			throw ExceptionBundle.EXCEPTIONS.connectionHasNoOutstandingTransaction();
		inTransaction = false;
		
		// Commit transaction synchronously in SAP system
		try {
			JCoFunction commit = destination.getRepository().getFunction(COMMIT_FUNCTION);
			commit.getImportParameterList().setValue(SYNC_COMMIT_PARAM, SYNC_COMMIT_PARAM_VAL);
			commit.execute(destination);
		} catch (JCoException e) {
			// Note transaction should be implicitly rolled back in SAP system on error.
			throw ExceptionBundle.EXCEPTIONS.commitFailed(e);
		} finally {
			// End stateful session for transaction.
			endStatefulSession();
		}
		
		// Notify connection event listeners of local transaction commit.
		Collection<ConnectionEventListener> copy = null;
		synchronized (listeners) {
			if (listeners != null && listeners.size() > 0)
				copy = new ArrayList<ConnectionEventListener>(listeners);
		}
		if (copy != null) {
			// JCA 1.5 Specification: 7.7.2.1
			ConnectionEvent event = new ConnectionEvent(this, ConnectionEvent.LOCAL_TRANSACTION_COMMITTED);
			for (ConnectionEventListener cel : copy) {
				cel.localTransactionCommitted(event);
			}
		}
		
		
	}
	
	/**
	 * Invokes rollback RFM in SAP system, ends stateful session and informs application server that transaction has rolled back. 
	 * 
	 * @throws ResourceException If connection has not begun a transaction or error occurs in JCo runtime.
	 * 
	 * @generated NOT
	 */
	protected synchronized void rollbackLocalTransaction() throws ResourceException {
		checkState();
		
		if (!inTransaction) 
			// JCA 1.5 Specification: 7.8.3
			throw ExceptionBundle.EXCEPTIONS.connectionHasNoOutstandingTransaction();
		inTransaction = false;
		
		// Commit transaction synchronously in SAP system
		try {
			JCoFunction rollback = destination.getRepository().getFunction(ROLLBACK_FUNCTION);
			rollback.execute(destination);
		} catch (JCoException e) {
			// Note transaction should be implicitly rolled back in SAP system on error.
			throw ExceptionBundle.EXCEPTIONS.rollBackFailed(e);
		} finally {
			// End stateful session for transaction.
			endStatefulSession();
		}
		
		// Notify connection event listeners of local transaction rollback.
		Collection<ConnectionEventListener> copy = null;
		synchronized (listeners) {
			if (listeners != null && listeners.size() > 0)
				copy = new ArrayList<ConnectionEventListener>(listeners);
		}
		if (copy != null) {
			// JCA 1.5 Specification: 7.7.2.1
			ConnectionEvent event = new ConnectionEvent(this, ConnectionEvent.LOCAL_TRANSACTION_ROLLEDBACK);
			for (ConnectionEventListener cel : copy) {
				cel.localTransactionRolledback(event);
			}
		}
		

	}
	
	/**
	 * Internal helper method used by public methods to check the state of this connection before performing an operation on it. This
	 * method prevents operations from being performed on a connection in a <code>DESTROYED</code> state.
	 * 
	 * @throws ResourceException if connection is in a <code>DESTROYED</code> state.
	 * 
	 * @generated NOT
	 */
	private void checkState() throws ResourceException {
		if (state == State.DESTROYED) {
			throw ExceptionBundle.EXCEPTIONS.connectionIsDestroyed();
		}
	}

} //ManagedConnectionImpl
