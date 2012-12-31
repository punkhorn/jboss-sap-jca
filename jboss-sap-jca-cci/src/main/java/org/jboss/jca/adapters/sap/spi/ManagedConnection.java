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
package org.jboss.jca.adapters.sap.spi;

import javax.resource.ResourceException;
import javax.resource.spi.DissociatableManagedConnection;

import org.jboss.jca.adapters.sap.cci.Connection;
import org.jboss.jca.adapters.sap.cci.impl.ConnectionImpl;

import com.sap.conn.jco.JCoDestination;

/**
 * Specializes the {@link javax.resource.spi.ManagedConnection} interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 *
 */
public interface ManagedConnection extends javax.resource.spi.ManagedConnection, DissociatableManagedConnection {

	/**
	 * Called by {@link Connection} when constructing itself.
	 * 
	 * @return the managed connection factory associated with this managed connection. 
	 */
	public ManagedConnectionFactory getManagedConnectionFactory();
	
	/**
	 * Called by {@link Connection} and {@link ManagedConnection} when constructing connection handle.
	 * @return
	 */
	ConnectionRequestInfo getProperties();
	
	/**
	 * Called by {@link Connection} when associating with this managed connection.
	 * 
	 * @param handle - The handle to be associated with managed connection.
	 */
	public void associateHandle(Connection handle);

	/**
	 * Called by {@link ManagedConnection} when closing handle and by {@link Connection} when dissociating from managed connection.
	 * 
	 * @param handle - The connection handle to be dissociated from managed connection.
	 */
	public void dissociateHandle(Connection handle);

	/**
	 * Close application level handle handle to this connection
	 * 
	 * @param handle -
	 *            The application handle
	 */
	void closeHandle(Connection handle);

	/**
	 * Called by {@link ConnectionImpl#getDestination()}
	 * 
	 * @return The underlying destination associated with this managed connection.
	 */
	JCoDestination getDestination();

	/**
	 * Called by {@link ConnectionImpl#begin()}
	 * 
	 * @throws ResourceException If connection is destroyed.
	 */
	void beginStatefulSession() throws ResourceException;

	/**
	 * Called by {@link ConnectionImpl#end()}
	 * 
	 * @throws ResourceException If connection is destroyed or has outstanding transaction or if error occurs in underlying JCo 
	 * runtime. 
	 */
	void endStatefulSession() throws ResourceException;
	
	/**
	 * Called by {@link ConnectionImpl#isStateful()}
	 * 
	 * @return <code>true</code> if connection is in a stateful state; <code>false</code> otherwise.
	 */
	boolean isStateful();

	/**
	 * Called by {@link ConnectionImpl#ping()} 
	 * 
	 * @throws ResourceException if underlying JCo runtime throws exception when pinging.
	 */
	void ping() throws ResourceException;
}
