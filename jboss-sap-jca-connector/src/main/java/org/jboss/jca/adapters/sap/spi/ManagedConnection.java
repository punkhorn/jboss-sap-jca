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
package org.jboss.jca.adapters.sap.spi;

import java.io.PrintWriter;
import java.util.Properties;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.DissociatableManagedConnection;
import javax.resource.spi.LocalTransaction;
import javax.resource.spi.ManagedConnectionMetaData;
import javax.security.auth.Subject;
import javax.transaction.xa.XAResource;

import org.eclipse.emf.ecore.EObject;
import org.jboss.jca.adapters.sap.cci.Connection;
import org.jboss.jca.adapters.sap.cci.impl.ConnectionImpl;

import com.sap.conn.jco.JCoDestination;

/**
 * <!-- begin-user-doc -->
 * Specializes the {@link javax.resource.spi.ManagedConnection} interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 * <!-- end-user-doc -->
 *
 *
 * @model superTypes="org.jboss.jca.adapters.sap.spi.SPIManagedConnection org.jboss.jca.adapters.sap.spi.SPIDissociatableManagedConnection"
 * @generated
 */
public interface ManagedConnection extends EObject, javax.resource.spi.ManagedConnection, DissociatableManagedConnection {
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean equals(Object other);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	int hashCode();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException" subjectDataType="org.jboss.jca.adapters.sap.spi.Subject" connectionRequestInfoType="org.jboss.jca.adapters.sap.spi.SPIConnectionRequestInfo"
	 * @generated
	 */
	Object getConnection(Subject subject, ConnectionRequestInfo connectionRequestInfo) throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model listenerDataType="org.jboss.jca.adapters.sap.spi.ConnectionEventListener"
	 * @generated
	 */
	void addConnectionEventListener(ConnectionEventListener listener);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model listenerDataType="org.jboss.jca.adapters.sap.spi.ConnectionEventListener"
	 * @generated
	 */
	void removeConnectionEventListener(ConnectionEventListener listener);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation" type="org.jboss.jca.adapters.sap.spi.SPILocalTransaction" exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	LocalTransaction getLocalTransaction() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.jboss.jca.adapters.sap.spi.XAResource" exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	XAResource getXAResource() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation" type="org.jboss.jca.adapters.sap.spi.SPIManagedConnectionMetaData" exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	ManagedConnectionMetaData getMetaData() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.jboss.jca.adapters.sap.spi.PrintWriter" exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	PrintWriter getLogWriter() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException" outDataType="org.jboss.jca.adapters.sap.spi.PrintWriter"
	 * @generated
	 */
	void setLogWriter(PrintWriter out) throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	void associateConnection(Object connection) throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	void dissociateConnections() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	void cleanup() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	void destroy() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * Called by {@link Connection} and {@link ManagedConnection} when constructing a connection handle.
	 * 
	 * @return The connection properties of this managed connection.
	 * @throws ResourceException 
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.jboss.jca.adapters.sap.cci.Properties" exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	Properties getProperties() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo getConnectionRequestInfo() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * Called by {@link ConnectionImpl#getDestination()}
	 * 
	 * <p><b>NB:</b> For internal use only.
	 * 
	 * @return The underlying destination associated with this managed connection.
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.jboss.jca.adapters.sap.spi.JCoDestination"
	 * @generated
	 */
	JCoDestination getDestination();

	/**
	 * <!-- begin-user-doc -->
	 * Called by {@link Connection} when constructing itself.
	 * 
	 * @return the managed connection factory associated with this managed connection. 
	 * @throws ResourceException 
	 * <!-- end-user-doc -->
	 * @model kind="operation" exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	ManagedConnectionFactory getManagedConnectionFactory() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * Called by {@link ConnectionImpl#isStateful()}
	 * 
	 * <p><b>NB:</b> For internal use only.
	 * 
	 * @return <code>true</code> if connection is in a stateful state; <code>false</code> otherwise.
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isStateful();

	/**
	 * <!-- begin-user-doc -->
	 * Called by {@link ConnectionImpl#begin()}
	 * 
	 * <p><b>NB:</b> For internal use only.
	 * 
	 * @throws ResourceException If connection is destroyed.
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	void beginStatefulSession() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * Called by {@link ConnectionImpl#end()}
	 * 
	 * <p><b>NB:</b> For internal use only.
	 * 
	 * @throws ResourceException If connection is destroyed or has outstanding transaction or if error occurs in underlying JCo 
	 * runtime. 
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	void endStatefulSession() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * Called by {@link ConnectionImpl#ping()} 
	 * 
	 * <p><b>NB:</b> For internal use only.
	 * 
	 * @throws ResourceException if underlying JCo runtime throws exception when pinging.
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	void ping() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * Called by {@link Connection} when associating with this managed connection.
	 * 
	 * <p><b>NB:</b> For internal use only.
	 * 
	 * @param handle - The handle to be associated with managed connection.
	 * @throws ResourceException 
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	void associateHandle(Connection handle) throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * Called by {@link ManagedConnection} when closing handle and by {@link Connection} when dissociating from managed connection.
	 * 
	 * <p><b>NB:</b> For internal use only.
	 * 
	 * @param handle - The connection handle to be dissociated from managed connection.
	 * @throws ResourceException 
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	void dissociateHandle(Connection handle) throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * Close application level handle handle to this connection
	 * 
	 * <p><b>NB:</b> For internal use only.
	 * 
	 * @param handle -
	 *            The application handle
	 * @throws ResourceException 
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	void closeHandle(Connection handle) throws ResourceException;

} // ManagedConnection
