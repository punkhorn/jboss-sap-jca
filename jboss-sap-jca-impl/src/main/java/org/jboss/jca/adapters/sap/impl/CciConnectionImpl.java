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

import java.util.Properties;
import java.util.UUID;

import javax.resource.NotSupportedException;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionMetaData;
import javax.resource.cci.Interaction;
import javax.resource.cci.LocalTransaction;
import javax.resource.cci.ResultSetInfo;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.LazyAssociatableConnectionManager;

import org.jboss.jca.adapters.sap.cci.JBossSAPCciConnection;
import org.jboss.jca.adapters.sap.cci.JBossSAPConnectionSpec;

import com.sap.conn.jco.JCoContext;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;

/**
 * Implements the {@link Connection } interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 * 
 * @version $Id: $
 */
public class CciConnectionImpl implements JBossSAPCciConnection {

	public static enum State {
		ACTIVE, INACTIVE, CLOSED;
	}

	private JBossSAPConnectionSpec connectionRequestInfo;

	private final ManagedConnectionFactoryImpl managedConnectionFactory;

	private ConnectionManager connectionManager;

	private ManagedConnectionImpl managedConnection;

	private State state = State.ACTIVE;

	private final String id;

	private JCoDestination destination;

	private ConnectionMetaDataImpl connectionMetaData;

	CciConnectionImpl(ManagedConnectionImpl managedConnection,
			JBossSAPConnectionSpec connectionRequestInfo) throws ResourceException {
		this.id = UUID.randomUUID().toString();
		this.managedConnectionFactory = managedConnection.getManagedConnectionFactory();
		this.connectionRequestInfo = connectionRequestInfo;
		associateManagedConnection(managedConnection);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.jca.adapters.sap.impl.JBossSAPCciConnection#close()
	 */
	public void close() throws ResourceException {
		state = State.CLOSED;
		managedConnection.getManagedConnectionFactory().getResourceAdapter().getDestinationDataProvider()
				.removeDestinationProperties(id);
		managedConnection.closeHandle(this);
		managedConnection = null;
		destination = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.jca.adapters.sap.impl.JBossSAPCciConnection#createInteraction()
	 */
	public Interaction createInteraction() throws ResourceException {
		checkState();
		return new InteractionImpl(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.jca.adapters.sap.impl.JBossSAPCciConnection#getLocalTransaction()
	 */
	public LocalTransaction getLocalTransaction() throws ResourceException {
		checkState();
		throw new NotSupportedException("cci-connection-impl-txn-not-supported");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.jca.adapters.sap.impl.JBossSAPCciConnection#getMetaData()
	 */
	public ConnectionMetaData getMetaData() throws ResourceException {
		checkState();
		if (connectionMetaData == null)
			connectionMetaData = new ConnectionMetaDataImpl(this);
		return connectionMetaData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.jca.adapters.sap.impl.JBossSAPCciConnection#getResultSetInfo()
	 */
	public ResultSetInfo getResultSetInfo() throws ResourceException {
		checkState();
		throw new NotSupportedException("cci-connection-impl-result-set-info-not-supported");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.jca.adapters.sap.impl.JBossSAPCciConnection#begin()
	 */
	public void begin() throws ResourceException {
		checkState();
		JCoContext.begin(destination);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.jca.adapters.sap.impl.JBossSAPCciConnection#end()
	 */
	public void end() throws ResourceException {
		checkState();
		try {
			JCoContext.end(destination);
		} catch (JCoException e) {
			throw new ResourceException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.jca.adapters.sap.impl.JBossSAPCciConnection#isClosed()
	 */
	public boolean isClosed() {
		return state == State.CLOSED;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.jca.adapters.sap.impl.JBossSAPCciConnection#isStateful()
	 */
	public boolean isStateful() {
		return JCoContext.isStateful(destination);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.jca.adapters.sap.impl.JBossSAPCciConnection#ping()
	 */
	public void ping() throws ResourceException {
		try {
			destination.ping();
		} catch (JCoException e) {
			throw new ResourceException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jboss.jca.adapters.sap.impl.JBossSAPCciConnection#getProperties()
	 */
	public Properties getProperties() {
		return destination.getProperties();
	}

	/**
	 * Returns the product version of underlying EIS instance
	 * 
	 * @return the product version of underlying EIS instance
	 * @throws ResourceException
	 */
	public String getProductVersion() throws ResourceException {
		try {
			return destination.getAttributes().getPartnerRelease();
		} catch (JCoException e) {
			throw new ResourceException(e);
		}
	}

	/**
	 * Returns the user name for an active connection.as known to the underlying EIS instance. The name corresponds to
	 * the resource principal under whose security context a connection to the EIS instance has been established.
	 * 
	 * @return the user name for an active connection.as known to the underlying EIS instance.
	 * @throws ResourceException
	 */
	public String getUserName() throws ResourceException {
		try {
			return destination.getAttributes().getUser();
		} catch (JCoException e) {
			throw new ResourceException(e);
		}
	}
	
	JCoDestination getDestination() {
		return destination;
	}

	ManagedConnectionImpl getManagedConnection() {
		return managedConnection;
	}

	ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	void associateManagedConnection(ManagedConnectionImpl managedConnection) throws ResourceException {
		try {
			this.managedConnection = managedConnection;

			// merge client connection request info with defaults from managed connection.
			JBossSAPConnectionSpec mergedConnectionRequestInfo = new JBossSAPConnectionSpec(
					managedConnection.getDefaultConnectionRequestInfo());
			if (this.connectionRequestInfo != null)
				mergedConnectionRequestInfo.addProperties(this.connectionRequestInfo);

			managedConnection.getManagedConnectionFactory().getResourceAdapter().getDestinationDataProvider()
					.addDestinationProperties(id, mergedConnectionRequestInfo);
			this.destination = JCoDestinationManager.getDestination(id);

			this.managedConnection.associateHandle(this);
			state = State.ACTIVE;
		} catch (JCoException e) {
			throw new ResourceException("cci-connection-impl-assocate-managed-connection-failed", e);
		}
	}

	void dissociateManagedConnection() {
		managedConnection.getManagedConnectionFactory().getResourceAdapter().getDestinationDataProvider()
				.removeDestinationProperties(id);
		this.destination = null;
		this.managedConnection.dissociateHandle(this);
		this.managedConnection = null;
		state = State.INACTIVE;
	}

	void checkState() throws ResourceException {
		if (state == State.CLOSED)
			throw new ResourceException("cci-connection-impl-is-closed");

		if (state == State.INACTIVE) {
			if (connectionManager instanceof LazyAssociatableConnectionManager) {
				// Attempt to associate a managed connection with this connection handle.
				((LazyAssociatableConnectionManager) connectionManager).associateConnection(this,
						managedConnectionFactory, connectionRequestInfo);
			} else {
				throw new ResourceException("cci-connection-impl-is-inactive");
			}
		}
	}

}
