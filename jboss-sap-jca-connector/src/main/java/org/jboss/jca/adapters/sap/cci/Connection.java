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
package org.jboss.jca.adapters.sap.cci;

import javax.resource.ResourceException;
import javax.resource.cci.ResultSetInfo;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @model superTypes="org.jboss.jca.adapters.sap.cci.CCIConnection"
 * @generated
 */
public interface Connection extends EObject, javax.resource.cci.Connection {
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * Begins a stateful call sequence for calls through this connection. The connections will not be reset or closed between <code>begin()</code> and <code>end()</code>. As a consequence the user context in the ABAP backend will be kept.
	 * </p>
	 * <p>
	 * <b>Note</b>: As <code>begin()</code> reserves this connection for exclusive usage, you should only switch to stateful if this is really required. Stateless processing should be preferred if this is possible, i.e. avoid using <code>begin()/end()</code> sequences if the used function modules do not store state in the ABAP system. 	 * 
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	void begin() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * Ends a stateful call sequence for calls through this connection. The connection is now either returned for reuse to a pool or is at least no longer guaranteed to be kept open. Note: The number of invocations of begin() are not counted, i.e. a single invocation of end() will already release the context for the given destination. 
	 * </p>
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	void end() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * Returns <code>true</code> if this connection is in a closed state; <code>false</code> otherwise.
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isClosed();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * Returns true if in the current session the stateful sequence was started, i.e. begin() was invoked and not finished by end(). Returns false otherwise.  
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isStateful();

	/**
	 * <!-- begin-user-doc -->
	 * Returns the connection's properties
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	ConnectionSpec getConnectionSpec() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	Interaction createInteraction() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model kind="operation" exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	LocalTransaction getLocalTransaction() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model kind="operation" exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	ConnectionMetaData getMetaData() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.jboss.jca.adapters.sap.cci.ResultSetInfo" exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	ResultSetInfo getResultSetInfo() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * Executes a connection test for this connection.
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	void ping() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	void close() throws ResourceException;

} // Connection
