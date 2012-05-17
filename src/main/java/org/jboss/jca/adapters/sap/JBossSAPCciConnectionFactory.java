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

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.resource.NotSupportedException;
import javax.resource.ResourceException;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.ConnectionSpec;
import javax.resource.cci.RecordFactory;
import javax.resource.cci.ResourceAdapterMetaData;
import javax.resource.spi.ConnectionManager;

/**
 * JBossSAPCciConnectionFactory
 * 
 * @version $Revision: $
 */
public class JBossSAPCciConnectionFactory implements ConnectionFactory {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1529670235107410633L;

	private Reference reference;

	private JBossSAPManagedConnectionFactory managedConnectionFactory;

	private ConnectionManager connectionManager;

	/**
	 * Default constructor
	 */
	public JBossSAPCciConnectionFactory() {
	}

	/**
	 * Default constructor
	 * 
	 * @param connectionManager
	 *            ConnectionManager
	 */
	public JBossSAPCciConnectionFactory(JBossSAPManagedConnectionFactory managedConnectionFactory,
			ConnectionManager connectionManager) {
		this.managedConnectionFactory = managedConnectionFactory;
		this.connectionManager = connectionManager;
	}

	/**
	 * Gets a connection to an SAP instance.
	 * 
	 * @return JBossSAPCciConnection instance the SAP instance.
	 * @throws ResourceException
	 *             Failed to get a connection to
	 */
	public JBossSAPCciConnection getConnection() throws ResourceException {
		JBossSAPCciConnection newConnection = (JBossSAPCciConnection) connectionManager.allocateConnection(
				managedConnectionFactory, null);
		newConnection.setConnectionManager(connectionManager);

		return newConnection;
	}

	/**
	 * Gets a connection to an SAP instance.
	 * 
	 * @param connectionSpec
	 *            Connection parameters and security information specified as ConnectionSpec instance
	 * @return JBossSAPCciConnection instance the SAP instance.
	 * @throws ResourceException
	 *             Failed to get a connection to SAP instance
	 */
	public JBossSAPCciConnection getConnection(ConnectionSpec connectionSpec) throws ResourceException {
		if (!(connectionSpec instanceof JBossSAPConnectionSpec))
			throw new ResourceException("jboss-sap-cci-connection-factory-invalid-connection-spec-type");
		JBossSAPConnectionSpec connectionRequestInfo = (JBossSAPConnectionSpec) connectionSpec;

		JBossSAPCciConnection newConnection = (JBossSAPCciConnection) connectionManager.allocateConnection(
				managedConnectionFactory, connectionRequestInfo);
		newConnection.setConnectionManager(connectionManager);

		return newConnection;
	}

	/**
	 * Gets metadata for the Resource Adapter.
	 * 
	 * @return ResourceAdapterMetaData instance
	 * @throws ResourceException
	 *             Failed to get metadata information
	 */
	public ResourceAdapterMetaData getMetaData() throws ResourceException {
		return new JBossSAPResourceAdapterMetaData();
	}

	/**
	 * Gets a RecordFactory instance.
	 * 
	 * @return RecordFactory instance
	 * @throws ResourceException
	 *             Failed to create a RecordFactory
	 * @throws javax.resource.NotSupportedException
	 *             Operation not supported
	 */
	public RecordFactory getRecordFactory() throws ResourceException {
		throw new NotSupportedException();
	}

	/**
	 * Get the Reference instance.
	 * 
	 * @return Reference instance
	 */
	public Reference getReference() throws NamingException {
		return reference;
	}

	/**
	 * Set the Reference instance.
	 * 
	 * @param reference
	 *            A Reference instance
	 */
	public void setReference(Reference reference) {
		this.reference = reference;
	}

}
