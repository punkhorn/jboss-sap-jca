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

import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.resource.NotSupportedException;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionMetaData;
import javax.resource.cci.Interaction;
import javax.resource.cci.LocalTransaction;
import javax.resource.cci.ResultSetInfo;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.LazyAssociatableConnectionManager;

import org.jboss.jca.adapters.sap.cci.JBossSAPConnection;
import org.jboss.jca.adapters.sap.cci.JBossSAPConnectionSpec;

import com.sap.conn.jco.JCoDestination;

/**
 * Implements the {@link Connection } interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 * 
 * @version $Id$
 */
public class ConnectionImpl implements JBossSAPConnection {

	/**
	 * States of a connection handle.
	 */
	public static enum State {
		ACTIVE,		/* Valid connection handle and associated with a managed connection */ 
		INACTIVE, 	/* Valid connection handle but not associated with a managed connection */
		CLOSED;		/* Invalid connection handle */
	}

	/**
	 * The managed connection factory permanently associated with this handle.
	 */
	private final ManagedConnectionFactoryImpl managedConnectionFactory;

	/**
	 * The connection manager set by the managed connection when first constructing the connection handle. 
	 */
	private ConnectionManager connectionManager = null;

	/**
	 * The managed connection currently associated with this connection handle or null if not associated 
	 * with a managed connection.
	 */
	private ManagedConnectionImpl managedConnection;
	
	/** 
	 * The original connection request information used when creating this connection object  
	 * 
	 * Used when attempting to re-associate a dissociated connection. 
	 */
	private JBossSAPConnectionSpec connectionSpec;

	/** 
	 * The state of the connection handle
	 * 
	 * Connection handle starts in <code>ACTIVE<code> state when created and can transition back and forth between that state and 
	 * an <code>INACTIVE</code> state until placed in final <code>CLOSED</code> state by closing handle. 
	 */
	private State state = State.ACTIVE;
	
	/**
	 * The set of active outstanding interactions created by this connection
	 */
	private final Set<InteractionImpl> activeInteractions = new HashSet<InteractionImpl>(); 

	ConnectionImpl(ManagedConnectionImpl managedConnection)
			throws ResourceException {
		this.managedConnectionFactory = managedConnection.getManagedConnectionFactory();
		this.connectionSpec = managedConnection.getProperties();
		associateManagedConnection(managedConnection);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.jca.adapters.sap.impl.JBossSAPConnection#close()
	 */
	public void close() throws ResourceException {
		
		boolean wasInactive = false;
		
		synchronized (this) {
			if (state == State.INACTIVE) 
				return;
			if (state == State.INACTIVE)
				wasInactive = true;
			state = State.INACTIVE;
		}
		
		// Close all outstanding active interactions 
		Collection<InteractionImpl> copy = null;
		synchronized (activeInteractions) {
			if (activeInteractions.size() > 0)
				copy = new HashSet<InteractionImpl>(activeInteractions);
		}
		if (copy != null) {
			for (InteractionImpl interaction: copy) {
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
		
		managedConnection = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.jca.adapters.sap.impl.JBossSAPConnection#createInteraction()
	 */
	public Interaction createInteraction() throws ResourceException {
		checkState();
		InteractionImpl interaction = new InteractionImpl(this);
		activeInteractions.add(interaction);
		return interaction;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.jca.adapters.sap.impl.JBossSAPConnection#getLocalTransaction()
	 */
	public LocalTransaction getLocalTransaction() throws ResourceException {
		checkState();
		return (LocalTransaction) managedConnection.getLocalTransaction();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.jca.adapters.sap.impl.JBossSAPConnection#getMetaData()
	 */
	public ConnectionMetaData getMetaData() throws ResourceException {
		checkState();
		return (ConnectionMetaData) managedConnection.getMetaData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.jca.adapters.sap.impl.JBossSAPConnection#getResultSetInfo()
	 */
	public ResultSetInfo getResultSetInfo() throws ResourceException {
		checkState();
		throw new NotSupportedException("connection-impl-result-set-info-not-supported");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.jca.adapters.sap.impl.JBossSAPConnection#begin()
	 */
	public void begin() throws ResourceException {
		checkState();
		managedConnection.beginStatefulSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.jca.adapters.sap.impl.JBossSAPConnection#end()
	 */
	public void end() throws ResourceException {
		checkState();
		managedConnection.endStatefulSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.jca.adapters.sap.impl.JBossSAPConnection#isClosed()
	 */
	public boolean isClosed() {
		return state == State.CLOSED;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.jca.adapters.sap.impl.JBossSAPConnection#isStateful()
	 */
	public boolean isStateful() {
		return managedConnection.isStateful();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.jca.adapters.sap.impl.JBossSAPConnection#ping()
	 */
	public void ping() throws ResourceException {
		managedConnection.ping();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.jca.adapters.sap.impl.JBossSAPConnection#getProperties()
	 */
	public Properties getProperties() {
		return this.connectionSpec;
	}

	
	/**
	 * Called by {@link InteractionImpl} when creating and executing a JCo function.
	 * 
	 * @return The underlying destination of the managed connection associated with this connection handle.
	 */
	JCoDestination getDestination() {
		return managedConnection.getDestination();
	}

	/**
	 * Called by {@link ConnectionFactoryImpl} when it creates this connection handle.
	 * 
	 * @param connectionManager - the connection manager of the application server
	 */
	void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	/**
	 * Called during the construction of this connection handle and by a {@link ManagedConnectionImpl} when it associates with handle.
	 *  
	 * @param managedConnection - the managed connection to associate with.
	 */
	void associateManagedConnection(ManagedConnectionImpl managedConnection) {
		if (this.managedConnection != null) {
			dissociateManagedConnection();
		}
		this.managedConnection = managedConnection;
		this.managedConnection.associateHandle(this);
		state = State.ACTIVE;
	}

	/**
	 * Called by {@link ManagedConnectionImpl} when dissociating all of its connection handles. 
	 */
	void dissociateManagedConnection() {
		this.managedConnection.dissociateHandle(this);
		this.managedConnection = null;
		state = State.INACTIVE;
	}
	
	/**
	 * Called by {@link InteractionImpl} when the interaction is closed.
	 * 
	 * @param interaction the newly closed interaction.
	 */
	void interactionClosed(InteractionImpl interaction) {
		synchronized (activeInteractions) {
			activeInteractions.remove(interaction);
		}
	}

	/**
	 * Internal helper method used by public methods to check the state of this connection before performing an operation on it. This
	 * method prevents operations from being performed on a connection in a <code>CLOSED</code> state. It also ensures
	 * that a connection in an <code>INACTIVE</code> state is re-associated with a <code>ManagedConnection</code> before
	 * performing any operation on it; i.e. the connection is placed in an <code>ACTIVE</code> state first.
	 * 
	 * @throws ResourceException if connection is closed or can not be placed in an <code>ACTIVE</code> state.
	 */
	void checkState() throws ResourceException {
		if (state == State.CLOSED)
			throw new ResourceException("connection-impl-is-closed");

		if (state == State.INACTIVE) {
			if (connectionManager instanceof LazyAssociatableConnectionManager) {
				// Attempt to associate a managed connection with this connection handle.
				((LazyAssociatableConnectionManager) connectionManager).associateConnection(this,
						managedConnectionFactory, connectionSpec);
			} else {
				throw new ResourceException("connection-impl-is-inactive");
			}
		}
	}

}
