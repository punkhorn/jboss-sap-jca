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
import javax.resource.cci.ResourceWarning;

import javax.resource.cci.InteractionSpec;
import javax.resource.cci.Record;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interaction</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getInteraction()
 * @model superTypes="org.jboss.jca.adapters.sap.cci.CCIInteraction"
 * @generated
 */
public interface Interaction extends EObject, javax.resource.cci.Interaction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	void close() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Connection getConnection();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException" ispecType="org.jboss.jca.adapters.sap.cci.CCIInteractionSpec" inputType="org.jboss.jca.adapters.sap.cci.CCIRecord" outputType="org.jboss.jca.adapters.sap.cci.CCIRecord"
	 * @generated
	 */
	boolean execute(InteractionSpec ispec, Record input, Record output) throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model type="org.jboss.jca.adapters.sap.cci.CCIRecord" exceptions="org.jboss.jca.adapters.sap.cci.ResourceException" ispecType="org.jboss.jca.adapters.sap.cci.CCIInteractionSpec" inputType="org.jboss.jca.adapters.sap.cci.CCIRecord"
	 * @generated
	 */
	Record execute(InteractionSpec ispec, Record input) throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.jboss.jca.adapters.sap.cci.ResourceWarning" exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	ResourceWarning getWarnings() throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	void clearWarnings() throws ResourceException;

} // Interaction
