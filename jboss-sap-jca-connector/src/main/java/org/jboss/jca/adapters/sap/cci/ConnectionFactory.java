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

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.resource.ResourceException;
import javax.resource.cci.ConnectionSpec;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * Specializes the {@link javax.resource.cci.ConnectionFactory} interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionFactory#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @model superTypes="org.jboss.jca.adapters.sap.cci.CCIConnectionFactory"
 * @generated
 */
public interface ConnectionFactory extends EObject, javax.resource.cci.ConnectionFactory {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' attribute.
	 * @see #setReference(Reference)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionFactory_Reference()
	 * @model dataType="org.jboss.jca.adapters.sap.cci.Reference"
	 * @generated NOT
	 */
	Reference getReference() throws NamingException;

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionFactory#getReference <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' attribute.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(Reference value);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation" exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	Connection getConnection() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException" propertiesType="org.jboss.jca.adapters.sap.cci.CCIConnectionSpec"
	 * @generated
	 */
	Connection getConnection(ConnectionSpec properties) throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation" exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	RecordFactory getRecordFactory() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation" exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	ResourceAdapterMetaData getMetaData() throws ResourceException;

} // ConnectionFactory
