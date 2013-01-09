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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interaction Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.InteractionSpec#getFunctionName <em>Function Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.InteractionSpec#getInteractionVerb <em>Interaction Verb</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.InteractionSpec#getExecutionTimeout <em>Execution Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @model superTypes="org.jboss.jca.adapters.sap.cci.CCIInteractionSpec"
 * @generated
 */
public interface InteractionSpec extends EObject, javax.resource.cci.InteractionSpec {
	/**
	 * Returns the value of the '<em><b>Function Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * A string representing the name of an ABAP Function Module.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Name</em>' attribute.
	 * @see #setFunctionName(String)
	 * @model
	 * @generated
	 */
	String getFunctionName();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.InteractionSpec#getFunctionName <em>Function Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * A string representing the name of an ABAP Function Module.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function Name</em>' attribute.
	 * @see #getFunctionName()
	 * @generated
	 */
	void setFunctionName(String value);

	/**
	 * Returns the value of the '<em><b>Interaction Verb</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * An integer representing the mode of interaction with an EIS instance as specified by the InteractionSpec.
	 * The values of the interaction verb may be one of the following: SYNC_SEND, SYNC_SEND_RECEIVE, SYNC_RECEIVE
	 * </p>
	 * <p>
	 * NB: currently not used.
	 * </p
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interaction Verb</em>' attribute.
	 * @see #setInteractionVerb(int)
	 * @model
	 * @generated
	 */
	int getInteractionVerb();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.InteractionSpec#getInteractionVerb <em>Interaction Verb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * An integer representing the mode of interaction with an EIS instance as specified by the InteractionSpec.
	 * The values of the interaction verb may be one of the following: SYNC_SEND, SYNC_SEND_RECEIVE, SYNC_RECEIVE
	 * </p>
	 * <p>
	 * NB: currently not used.
	 * </p
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interaction Verb</em>' attribute.
	 * @see #getInteractionVerb()
	 * @generated
	 */
	void setInteractionVerb(int value);

	/**
	 * Returns the value of the '<em><b>Execution Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * An integer representing the number of milliseconds an {@link Interaction} waits for an EIS to execute the specified function.
	 * </p>
	 * <p>
	 * NB: currently not used.
	 * </p
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Timeout</em>' attribute.
	 * @see #setExecutionTimeout(int)
	 * @model
	 * @generated
	 */
	int getExecutionTimeout();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.InteractionSpec#getExecutionTimeout <em>Execution Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * An integer representing the number of milliseconds an {@link Interaction} waits for an EIS to execute the specified function.
	 * </p>
	 * <p>
	 * NB: currently not used.
	 * </p
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Timeout</em>' attribute.
	 * @see #getExecutionTimeout()
	 * @generated
	 */
	void setExecutionTimeout(int value);

} // InteractionSpec
