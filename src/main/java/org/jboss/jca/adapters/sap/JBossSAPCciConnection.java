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
import com.sap.conn.jco.JCoContext;
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
 * Implements the {@link Connection } and {@link JCoDestination } interfaces for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
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

	private JBossSAPConnectionMetaData connectionMetaData;

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
	 * {@inheritDoc}
	 */
	public Interaction createInteraction() throws ResourceException {
		checkState();
		return new JBossSAPInteraction(this);
	}

	/**
	 * {@inheritDoc}
	 */
	public LocalTransaction getLocalTransaction() throws ResourceException {
		checkState();
		throw new NotSupportedException("jboss-sap-cci-connection-txn-not-supported");
	}

	/**
	 * {@inheritDoc}
	 */
	public ConnectionMetaData getMetaData() throws ResourceException {
		checkState();
		if (connectionMetaData == null)
			connectionMetaData = new JBossSAPConnectionMetaData(this);
		return connectionMetaData;
	}

	/**
	 * {@inheritDoc}
	 */
	public ResultSetInfo getResultSetInfo() throws ResourceException {
		checkState();
		throw new NotSupportedException("jboss-sap-cci-connection-result-set-info-not-supported");
	}

	/**
	 * Begins stateful call sequence for interactions made through this connection.
	 * 
	 * @see {@link JCoContext#begin(JCoDestination)}
	 * 
	 * @throws ResourceException
	 */
	public void begin() throws ResourceException {
		checkState();
		JCoContext.begin(destination);
	}

	/**
	 * Ends stateful call sequence for interactions through this connection
	 * 
	 * @see {@link JCoContext#end(JCoDestination)}
	 * 
	 * @throws ResourceException
	 */
	public void end() throws ResourceException {
		checkState();
		try {
			JCoContext.end(destination);
		} catch (JCoException e) {
			throw new ResourceException(e);
		}
	}

	/**
	 * Returns <code>true</code> if connection is closed; <code>false</code> otherwise
	 * 
	 * @return <code>true</code> if connection is closed; <code>false</code> otherwise
	 */
	public boolean isClosed() {
		return state == State.CLOSED;
	}

	/**
	 * Returns <code>true</code> if stateful call sequence was started and is not finished; <code>false</code> otherwise
	 * 
	 * @see {@link JCoContext#isStateful(JCoDestination)}
	 * 
	 * @return <code>true</code> if stateful call sequence was started and is not finished; <code>false</code> otherwise
	 */
	public boolean isStateful() {
		return JCoContext.isStateful(destination);
	}

	/**
	 * {@inheritDoc}
	 */
	public void changePassword(String oldPassword, String newPassword) throws JCoException {
		destination.changePassword(oldPassword, newPassword);
	}

	/**
	 * {@inheritDoc}
	 */
	public void confirmFunctionUnit(JCoUnitIdentifier unitIdentifier) throws JCoException {
		destination.confirmFunctionUnit(unitIdentifier);
	}

	/**
	 * {@inheritDoc}
	 */
	public void confirmTID(String tid) throws JCoException {
		destination.confirmTID(tid);
	}

	/**
	 * {@inheritDoc}
	 */
	public JCoCustomDestination createCustomDestination() {
		return destination.createCustomDestination();
	}

	/**
	 * {@inheritDoc}
	 */
	public String createTID() throws JCoException {
		return destination.createTID();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getAliasUser() {
		return destination.getAliasUser();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getApplicationServerHost() {
		return destination.getApplicationServerHost();
	}

	/**
	 * {@inheritDoc}
	 */
	public JCoAttributes getAttributes() throws JCoException {
		return destination.getAttributes();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getClient() {
		return destination.getClient();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDestinationID() {
		return destination.getDestinationID();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDestinationName() {
		return destination.getDestinationName();
	}

	/**
	 * {@inheritDoc}
	 */
	public long getExpirationCheckPeriod() {
		return destination.getExpirationCheckPeriod();
	}

	/**
	 * {@inheritDoc}
	 */
	public long getExpirationTime() {
		return destination.getExpirationTime();
	}

	/**
	 * {@inheritDoc}
	 */
	public JCoFunctionUnitState getFunctionUnitState(JCoUnitIdentifier unitIdentifier) throws JCoException {
		return destination.getFunctionUnitState(unitIdentifier);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getGatewayHost() {
		return destination.getGatewayHost();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getGatewayService() {
		return destination.getGatewayService();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLanguage() {
		return destination.getLanguage();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLogonCheck() {
		return destination.getLogonCheck();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLogonGroup() {
		return destination.getLogonGroup();
	}

	/**
	 * {@inheritDoc}
	 */
	public long getMaxGetClientTime() {
		return destination.getMaxGetClientTime();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getMessageServerHost() {
		return destination.getMessageServerHost();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getMessageServerService() {
		return destination.getMessageServerService();
	}

	/**
	 * {@inheritDoc}
	 */
	public JCoDestinationMonitor getMonitor() throws JCoRuntimeException {
		return destination.getMonitor();
	}

	/**
	 * {@inheritDoc}
	 */
	public int getPeakLimit() {
		return destination.getPeakLimit();
	}

	/**
	 * {@inheritDoc}
	 */
	public int getPoolCapacity() {
		return destination.getPoolCapacity();
	}

	/**
	 * {@inheritDoc}
	 */
	public Properties getProperties() {
		return destination.getProperties();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getR3Name() {
		return destination.getR3Name();
	}

	/**
	 * {@inheritDoc}
	 */
	public JCoRepository getRepository() throws JCoException {
		return destination.getRepository();
	}

	/**
	 * {@inheritDoc}
	 */
	public JCoDestinationMonitor getRepositoryDestinationMonitor() {
		return destination.getRepositoryDestinationMonitor();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getRepositoryUser() {
		return destination.getRepositoryUser();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getSAPRouterString() {
		return destination.getSAPRouterString();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getSncLibrary() {
		return destination.getSncLibrary();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getSncMode() {
		return destination.getSncMode();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getSncMyName() {
		return destination.getSncMyName();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getSncPartnerName() {
		return destination.getSncPartnerName();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getSncQOP() {
		return destination.getSncQOP();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getSystemNumber() {
		return destination.getSystemNumber();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getTPHost() {
		return destination.getTPHost();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getTPName() {
		return destination.getTPName();
	}

	/**
	 * {@inheritDoc}
	 */
	public JCoThroughput getThroughput() {
		return destination.getThroughput();
	}

	/**
	 * {@inheritDoc}
	 */
	public char getType() {
		return destination.getType();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getUser() {
		return destination.getUser();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isValid() {
		return destination.isValid();
	}

	/**
	 * {@inheritDoc}
	 */
	public void ping() throws JCoException {
		destination.ping();
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeThroughput() {
		destination.removeThroughput();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setThroughput(JCoThroughput throughput) {
		destination.setThroughput(throughput);
	}

	JCoDestination getDestination() {
		return destination;
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
			throw new ResourceException("jboss-sap-cci-connection-is-closed");

		if (state == State.INACTIVE) {
			if (connectionManager instanceof LazyAssociatableConnectionManager) {
				// Attempt to associate a managed connection with this connection handle.
				((LazyAssociatableConnectionManager) connectionManager).associateConnection(this,
						managedConnectionFactory, connectionRequestInfo);
			} else {
				throw new ResourceException("jboss-sap-cci-connection-is-inactive");
			}
		}
	}

}
