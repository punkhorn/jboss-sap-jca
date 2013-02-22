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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * Specializes the {@link javax.resource.cci.ConnectionMetaData} interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 * <!-- end-user-doc -->
 *
 *
 * @model superTypes="org.jboss.jca.adapters.sap.cci.CCIConnectionMetaData"
 * @generated
 */
public interface ConnectionMetaData extends EObject, javax.resource.cci.ConnectionMetaData {
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation" exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	String getEISProductName() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation" exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	String getEISProductVersion() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation" exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	String getUserName() throws ResourceException;

} // ConnectionMetaData
