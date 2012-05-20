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
 * Implements the {@link ConnectionFactory } interface for the JBoss SAP JCA Connector.
 *
 * @author William Collins
 * 
 * @version $Id: $
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
			ConnectionManager connectionManager) {	/**
		 * {@inheritDoc}
		 */

		this.managedConnectionFactory = managedConnectionFactory;
		this.connectionManager = connectionManager;
	}

	/**
	 * {@inheritDoc}
	 */
	public JBossSAPCciConnection getConnection() throws ResourceException {
		JBossSAPCciConnection newConnection = (JBossSAPCciConnection) connectionManager.allocateConnection(
				managedConnectionFactory, null);
		newConnection.setConnectionManager(connectionManager);

		return newConnection;
	}

	/**
	 * {@inheritDoc}
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
	 * {@inheritDoc}
	 */
	public ResourceAdapterMetaData getMetaData() throws ResourceException {
		return JBossSAPResourceAdapterMetaData.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	public RecordFactory getRecordFactory() throws ResourceException {
		throw new NotSupportedException();
	}

	/**
	 * {@inheritDoc}
	 */
	public Reference getReference() throws NamingException {
		return reference;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setReference(Reference reference) {
		this.reference = reference;
	}

}
