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
package org.jboss.jca.adapters.sap.cci.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.resource.ResourceException;
import javax.resource.cci.ResultSetInfo;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.LazyAssociatableConnectionManager;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.jboss.jca.adapters.sap.cci.Connection;
import org.jboss.jca.adapters.sap.cci.ConnectionMetaData;
import org.jboss.jca.adapters.sap.cci.ConnectionSpec;
import org.jboss.jca.adapters.sap.cci.Interaction;
import org.jboss.jca.adapters.sap.cci.LocalTransaction;
import org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.spi.ManagedConnection;
import org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory;

import com.sap.conn.jco.JCoDestination;

/**
 * <!-- begin-user-doc -->
 * Implements the {@link Connection } interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 * 
 * @version $Id: 8420451436bd443d1ba6ecbd08afc8ec93e23435 $
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ConnectionImpl extends EObjectImpl implements Connection {

	/**
	 * States of a connection handle.
	 * @generated NOT
	 */
	public static enum State {
		ACTIVE,		/* Valid connection handle and associated with a managed connection */ 
		INACTIVE, 	/* Valid connection handle but not associated with a managed connection */
		CLOSED;		/* Invalid connection handle */
	}

	/**
	 * The managed connection factory associated with this handle.
	 * @generated NOT
	 */
	private ManagedConnectionFactory managedConnectionFactory;

	/**
	 * The connection manager set by the managed connection when first constructing the connection handle. 
	 * @generated NOT
	 */
	private ConnectionManager connectionManager = null;

	/**
	 * The managed connection currently associated with this connection handle or null if not associated 
	 * with a managed connection.
	 * @generated NOT
	 */
	private ManagedConnection managedConnection;
	
	/** 
	 * The original connection request information used when creating this connection object  
	 * 
	 * Used when attempting to re-associate a dissociated connection. 
	 * @generated NOT
	 */
	private ConnectionRequestInfo connectionRequestInfo;

	/** 
	 * The state of the connection handle
	 * 
	 * Connection handle starts in <code>ACTIVE<code> state when created and can transition back and forth between that state and 
	 * an <code>INACTIVE</code> state until placed in final <code>CLOSED</code> state by closing handle. 
	 * @generated NOT
	 */
	private State state = State.ACTIVE;
	
	/**
	 * The set of active outstanding interactions created by this connection
	 * @generated NOT
	 */
	private final Set<Interaction> activeInteractions = new HashSet<Interaction>();
	
	private LocalTransaction localTransaction;

	private ConnectionMetaData connectionMetaData;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionImpl() {
		super();
	}

	/**
	 * @param managedConnection
	 * @throws ResourceException
	 * @generated NOT
	 */
	public ConnectionImpl(ManagedConnection managedConnection)
			throws ResourceException {
		super();
		this.managedConnectionFactory = managedConnection.getManagedConnectionFactory();
		this.connectionRequestInfo = managedConnection.getProperties();
		associateManagedConnection(managedConnection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CciPackageImpl.Literals.CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void begin() throws ResourceException {
		checkState();
		managedConnection.beginStatefulSession();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void end() throws ResourceException {
		checkState();
		managedConnection.endStatefulSession();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isClosed() {
		return state == State.CLOSED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean isStateful() {
		if (state == State.ACTIVE)
			return managedConnection.isStateful();
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws ResourceException 
	 * @generated NOT
	 */
	public synchronized ConnectionSpec getConnectionSpec() throws ResourceException {
		checkState();
		return managedConnectionFactory.convertConnectionRequestInfoToConnectionSpec(connectionRequestInfo);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized Interaction createInteraction() throws ResourceException {
		checkState();
		InteractionImpl interaction = new InteractionImpl(this);
		activeInteractions.add(interaction);
		return interaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized LocalTransaction getLocalTransaction() throws ResourceException {
		checkState();
		if (localTransaction == null) {
			localTransaction = new LocalTransactionImpl(managedConnection.getLocalTransaction());
		}
		return localTransaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized ConnectionMetaData getMetaData() throws ResourceException {
		checkState();
		if(connectionMetaData == null) {
			connectionMetaData = new ConnectionMetaDataImpl(managedConnection.getMetaData());
		}
		return connectionMetaData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ResultSetInfo getResultSetInfo() throws ResourceException {
		throw ExceptionBundle.EXCEPTIONS.resultSetInfoIsNotSupported();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void ping() throws ResourceException {
		checkState();
		managedConnection.ping();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void close() throws ResourceException {
		
		boolean wasInactive = false;
		
		if (state == State.CLOSED) 
			return;
		if (state == State.INACTIVE)
			wasInactive = true;
		state = State.CLOSED;
		
		// Close all outstanding active interactions 
		Collection<Interaction> copy = null;
		if (activeInteractions.size() > 0)
			copy = new HashSet<Interaction>(activeInteractions);
		if (copy != null) {
			for (Interaction interaction: copy) {
				interaction.close();
			}
		}
		
		if (wasInactive && connectionManager instanceof LazyAssociatableConnectionManager) {
			// Let application server know inactive handle was closed.
			((LazyAssociatableConnectionManager)connectionManager).inactiveConnectionClosed(this, managedConnectionFactory);
		} 

		if (managedConnection != null) {
			managedConnection.closeHandle(this);
		}
		
		this.managedConnection = null;
		this.managedConnectionFactory = null;
		this.localTransaction = null;
		this.connectionMetaData = null;
	}

	/**
	 * Called during the construction of this connection handle and by a {@link ManagedConnection} when it associates with handle.
	 *  
	 * @param managedConnection - the managed connection to associate with.
	 * @throws ResourceException 
	 * @generated NOT
	 */
	public synchronized void associateManagedConnection(ManagedConnection managedConnection) throws ResourceException {
		if (this.managedConnection != null) {
			dissociateManagedConnection();
		}
		this.managedConnection = managedConnection;
		this.managedConnection.associateHandle(this);
		state = State.ACTIVE;
	}

	/**
	 * Called by {@link ManagedConnection} when dissociating all of its connection handles. 
	 * @throws ResourceException 
	 * @generated NOT
	 */
	public synchronized void dissociateManagedConnection() throws ResourceException {
		this.managedConnection.dissociateHandle(this);
		this.managedConnection = null;
		this.localTransaction = null;
		this.connectionMetaData = null;
		state = State.INACTIVE;
	}
	
	/**
	 * Called by {@link InteractionImpl} when creating and executing a JCo function.
	 * 
	 * @return The underlying destination of the managed connection associated with this connection handle.
	 * @throws ResourceException 
	 * @generated NOT
	 */
	protected synchronized JCoDestination getDestination() throws ResourceException {
		checkState();
		return managedConnection.getDestination();
	}

	/**
	 * Called by {@link ConnectionFactoryImpl} when it creates this connection handle.
	 * 
	 * @param connectionManager - the connection manager of the application server
	 */
	public void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	/**
	 * Called by {@link InteractionImpl} when the interaction is closed.
	 * 
	 * @param interaction the newly closed interaction.
	 * @generated NOT
	 */
	protected synchronized void interactionClosed(InteractionImpl interaction) {
		activeInteractions.remove(interaction);
	}

	/**
	 * Internal helper method used by public methods to check the state of this connection before performing an operation on it. This
	 * method prevents operations from being performed on a connection in a <code>CLOSED</code> state. It also ensures
	 * that a connection in an <code>INACTIVE</code> state is re-associated with a <code>ManagedConnection</code> before
	 * performing any operation on it; i.e. the connection is placed in an <code>ACTIVE</code> state first.
	 * 
	 * @throws ResourceException if connection is closed or can not be placed in an <code>ACTIVE</code> state.
	 * @generated NOT
	 */
	private void checkState() throws ResourceException {
		if (state == State.CLOSED)
			throw ExceptionBundle.EXCEPTIONS.connectionIsClosed();

		if (state == State.INACTIVE) {
			if (connectionManager instanceof LazyAssociatableConnectionManager) {
				// Attempt to associate a managed connection with this connection handle.
				((LazyAssociatableConnectionManager) connectionManager).associateConnection(this,
						managedConnectionFactory, connectionRequestInfo);
			} else {
				throw ExceptionBundle.EXCEPTIONS.connectionIsInactive();
			}
		}
	}

} //ConnectionImpl
