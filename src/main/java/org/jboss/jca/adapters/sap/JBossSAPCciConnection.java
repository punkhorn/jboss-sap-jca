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

import com.sap.conn.jco.JCoAttributes;
import com.sap.conn.jco.JCoCustomDestination;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunctionUnitState;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.JCoRuntimeException;
import com.sap.conn.jco.JCoThroughput;
import com.sap.conn.jco.JCoUnitIdentifier;
import com.sap.conn.jco.monitor.JCoDestinationMonitor;

/**
 * JBossSAPCciConnection implements the Connection interface and encapsulates a JCoDestination instance.
 * 
 * @version $Revision: $
 */
public class JBossSAPCciConnection implements Connection, JCoDestination {

	public static enum State {
		ACTIVE, INACTIVE, CLOSED;
	}

	private JBossSAPConnectionSpec connectionRequestInfo;

	private final JBossSAPManagedConnectionFactory managedConnectionFactory;

	private ConnectionManager connectionManager;

	private JBossSAPManagedConnection managedConnection;

	private State state = State.ACTIVE;

	private final String id;

	private JCoDestination destination;

	/**
	 * Default constructor
	 * 
	 * @param connectionRequestInfo
	 *            ConnectionSpec
	 * @throws ResourceException
	 */
	public JBossSAPCciConnection(JBossSAPManagedConnection managedConnection,
			JBossSAPConnectionSpec connectionRequestInfo) throws ResourceException {
		this.id = UUID.randomUUID().toString();
		this.managedConnectionFactory = managedConnection.getManagedConnectionFactory();
		this.connectionRequestInfo = connectionRequestInfo;
		associateManagedConnection(managedConnection);
	}

	/**
	 * Initiates close of the connection handle at the application level.
	 * 
	 * @throws ResourceException
	 *             Exception thrown if close on a connection handle fails.
	 */
	public void close() throws ResourceException {
		state = State.CLOSED;
		managedConnection.getManagedConnectionFactory().getResourceAdapter().getDestinationDataProvider()
				.removeDestinationProperties(id);
		managedConnection.closeHandle(this);
		managedConnection = null;
		destination = null;
	}

	/**
	 * Creates an Interaction associated with this Connection.
	 * 
	 * @return Interaction instance
	 * @throws ResourceException
	 *             Failed to create an Interaction
	 */
	public Interaction createInteraction() throws ResourceException {
		checkState();
		return null;
	}

	/**
	 * Returns an LocalTransaction instance that enables a component to demarcate resource manager local transactions on
	 * the Connection.
	 * 
	 * @return LocalTransaction instance
	 * @throws ResourceException
	 *             Failed to return a LocalTransaction
	 * @throws javax.resource.NotSupportedException
	 *             Demarcation of Resource manager
	 */
	public LocalTransaction getLocalTransaction() throws ResourceException {
		checkState();
		throw new NotSupportedException("jboss-sap-cci-connection-txn-not-supported");
	}

	/**
	 * Gets the information on the underlying EIS instance represented through an active connection.
	 * 
	 * @return ConnectionMetaData instance representing information about the EIS instance
	 * @throws ResourceException
	 *             Failed to get information about the connected EIS instance.
	 */
	public ConnectionMetaData getMetaData() throws ResourceException {
		checkState();
		return new JBossSAPConnectionMetaData();
	}

	/**
	 * Gets the information on the ResultSet functionality supported by a connected EIS instance.
	 * 
	 * @return ResultSetInfo instance
	 * @throws ResourceException
	 *             Failed to get ResultSet related information
	 * @throws javax.resource.NotSupportedException
	 *             ResultSet functionality is not supported
	 */
	public ResultSetInfo getResultSetInfo() throws ResourceException {
		checkState();
		return null;
	}

	public void changePassword(String oldPassword, String newPassword) throws JCoException {
		destination.changePassword(oldPassword, newPassword);
	}

	public void confirmFunctionUnit(JCoUnitIdentifier unitIdentifier) throws JCoException {
		destination.confirmFunctionUnit(unitIdentifier);
	}

	public void confirmTID(String tid) throws JCoException {
		destination.confirmTID(tid);
	}

	public JCoCustomDestination createCustomDestination() {
		return destination.createCustomDestination();
	}

	public String createTID() throws JCoException {
		return destination.createTID();
	}

	public String getAliasUser() {
		return destination.getAliasUser();
	}

	public String getApplicationServerHost() {
		return destination.getApplicationServerHost();
	}

	public JCoAttributes getAttributes() throws JCoException {
		return destination.getAttributes();
	}

	public String getClient() {
		return destination.getClient();
	}

	public String getDestinationID() {
		return destination.getDestinationID();
	}

	public String getDestinationName() {
		return destination.getDestinationName();
	}

	public long getExpirationCheckPeriod() {
		return destination.getExpirationCheckPeriod();
	}

	public long getExpirationTime() {
		return destination.getExpirationTime();
	}

	public JCoFunctionUnitState getFunctionUnitState(JCoUnitIdentifier unitIdentifier) throws JCoException {
		return destination.getFunctionUnitState(unitIdentifier);
	}

	public String getGatewayHost() {
		return destination.getGatewayHost();
	}

	public String getGatewayService() {
		return destination.getGatewayService();
	}

	public String getLanguage() {
		return destination.getLanguage();
	}

	public String getLogonCheck() {
		return destination.getLogonCheck();
	}

	public String getLogonGroup() {
		return destination.getLogonGroup();
	}

	public long getMaxGetClientTime() {
		return destination.getMaxGetClientTime();
	}

	public String getMessageServerHost() {
		return destination.getMessageServerHost();
	}

	public String getMessageServerService() {
		return destination.getMessageServerService();
	}

	public JCoDestinationMonitor getMonitor() throws JCoRuntimeException {
		return destination.getMonitor();
	}

	public int getPeakLimit() {
		return destination.getPeakLimit();
	}

	public int getPoolCapacity() {
		return destination.getPoolCapacity();
	}

	public Properties getProperties() {
		return destination.getProperties();
	}

	public String getR3Name() {
		return destination.getR3Name();
	}

	public JCoRepository getRepository() throws JCoException {
		return destination.getRepository();
	}

	public JCoDestinationMonitor getRepositoryDestinationMonitor() {
		return destination.getRepositoryDestinationMonitor();
	}

	public String getRepositoryUser() {
		return destination.getRepositoryUser();
	}

	public String getSAPRouterString() {
		return destination.getSAPRouterString();
	}

	public String getSncLibrary() {
		return destination.getSncLibrary();
	}

	public String getSncMode() {
		return destination.getSncMode();
	}

	public String getSncMyName() {
		return destination.getSncMyName();
	}

	public String getSncPartnerName() {
		return destination.getSncPartnerName();
	}

	public String getSncQOP() {
		return destination.getSncQOP();
	}

	public String getSystemNumber() {
		return destination.getSystemNumber();
	}

	public String getTPHost() {
		return destination.getTPHost();
	}

	public String getTPName() {
		return destination.getTPName();
	}

	public JCoThroughput getThroughput() {
		return destination.getThroughput();
	}

	public char getType() {
		return destination.getType();
	}

	public String getUser() {
		return destination.getUser();
	}

	public boolean isValid() {
		return destination.isValid();
	}

	public void ping() throws JCoException {
		destination.ping();
	}

	public void removeThroughput() {
		destination.removeThroughput();
	}

	public void setThroughput(JCoThroughput throughput) {
		destination.setThroughput(throughput);
	}

	JBossSAPManagedConnection getManagedConnection() {
		return managedConnection;
	}

	ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	void associateManagedConnection(JBossSAPManagedConnection managedConnection) throws ResourceException {
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
			throw new ResourceException("jboss-sap-cci-connection-assocate-managed-connection-failed", e);
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
			throw new ResourceException("jboss-sap-cci-connection-closed");

		if (state == State.INACTIVE) {
			if (connectionManager instanceof LazyAssociatableConnectionManager) {
				// Attempt to associate a managed connection with this connection handle.
				((LazyAssociatableConnectionManager) connectionManager).associateConnection(this,
						managedConnectionFactory, connectionRequestInfo);
			} else {
				throw new ResourceException("jboss-sap-cci-connection-inactive");
			}
		}
	}

}
