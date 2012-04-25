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

import javax.resource.NotSupportedException;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionMetaData;
import javax.resource.cci.Interaction;
import javax.resource.cci.LocalTransaction;
import javax.resource.cci.ResultSetInfo;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;

/**
 * JBossSAPCciConnection
 * 
 * @version $Revision: $
 */
public class JBossSAPCciConnection implements Connection {

	private JBossSAPManagedConnection managedConnection;
	
	private boolean closed = false;
	
	private JCoDestination destination;

	/**
	 * Default constructor
	 * 
	 * @param connSpec
	 *            ConnectionSpec
	 * @throws ResourceException
	 */
	public JBossSAPCciConnection(JBossSAPManagedConnection managedConnection, JBossSAPConnectionSpec connSpec)
			throws ResourceException {
		String destinationName = connSpec.getProperty(JBossSAPConnectionSpec.SAP_DESTINATION_NAME);
		if (destinationName == null)
			throw new ResourceException("jboss-sap-cci-connection-init-no-destination-name");

		this.managedConnection = managedConnection;
		managedConnection.getManagedConnectionFactory().getResourceAdapter().getDestinationDataProvider()
				.addDestinationProperties(destinationName, connSpec);
		try {
			destination = JCoDestinationManager.getDestination(destinationName);
		} catch (JCoException e) {
			throw new ResourceException("jboss-sap-cci-connection-init-failed", e);
		}
	}

	/**
	 * Initiates close of the connection handle at the application level.
	 * 
	 * @throws ResourceException
	 *             Exception thrown if close on a connection handle fails.
	 */
	public void close() throws ResourceException {
		closed = true;
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
		if (closed) 
			throw new ResourceException("jboss-sap-cci-connection-closed");
		return null;
	}

	/**
	 * Returns an LocalTransaction instance that enables a component to
	 * demarcate resource manager local transactions on the Connection.
	 * 
	 * @return LocalTransaction instance
	 * @throws ResourceException
	 *             Failed to return a LocalTransaction
	 * @throws javax.resource.NotSupportedException
	 *             Demarcation of Resource manager
	 */
	public LocalTransaction getLocalTransaction() throws ResourceException {
		if (closed) 
			throw new ResourceException("jboss-sap-cci-connection-closed");
		throw new NotSupportedException("jboss-sap-cci-connection-txn-not-supported");
	}

	/**
	 * Gets the information on the underlying EIS instance represented through
	 * an active connection.
	 * 
	 * @return ConnectionMetaData instance representing information about the
	 *         EIS instance
	 * @throws ResourceException
	 *             Failed to get information about the connected EIS instance.
	 */
	public ConnectionMetaData getMetaData() throws ResourceException {
		if (closed) 
			throw new ResourceException("jboss-sap-cci-connection-closed");
		return new JBossSAPConnectionMetaData();
	}

	/**
	 * Gets the information on the ResultSet functionality supported by a
	 * connected EIS instance.
	 * 
	 * @return ResultSetInfo instance
	 * @throws ResourceException
	 *             Failed to get ResultSet related information
	 * @throws javax.resource.NotSupportedException
	 *             ResultSet functionality is not supported
	 */
	public ResultSetInfo getResultSetInfo() throws ResourceException {
		if (closed) 
			throw new ResourceException("jboss-sap-cci-connection-closed");
		return null;
	}

	JBossSAPManagedConnection getManagedConnection() {
		return managedConnection;
	}

	void setManagedConnection(JBossSAPManagedConnection managedConnection) {
		this.managedConnection = managedConnection;
	}

}
