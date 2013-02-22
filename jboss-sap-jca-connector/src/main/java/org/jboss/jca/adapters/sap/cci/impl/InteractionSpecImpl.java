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
package org.jboss.jca.adapters.sap.cci.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.jboss.jca.adapters.sap.cci.InteractionSpec;

/**
 * <!-- begin-user-doc -->
 * Implements the {@link InteractionSpec } interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.InteractionSpecImpl#getFunctionName <em>Function Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.InteractionSpecImpl#getInteractionVerb <em>Interaction Verb</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.InteractionSpecImpl#getExecutionTimeout <em>Execution Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InteractionSpecImpl extends EObjectImpl implements InteractionSpec {
	/**
	 * @generated NOT 
	 */
	private static final long serialVersionUID = 5958772222336501606L;

	/**
	 * The default value of the '{@link #getFunctionName() <em>Function Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionName()
	 * @generated
	 * @ordered
	 */
	protected static final String FUNCTION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFunctionName() <em>Function Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionName()
	 * @generated
	 * @ordered
	 */
	protected String functionName = FUNCTION_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getInteractionVerb() <em>Interaction Verb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInteractionVerb()
	 * @generated
	 * @ordered
	 */
	protected static final int INTERACTION_VERB_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getInteractionVerb() <em>Interaction Verb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInteractionVerb()
	 * @generated
	 * @ordered
	 */
	protected int interactionVerb = INTERACTION_VERB_EDEFAULT;

	/**
	 * The default value of the '{@link #getExecutionTimeout() <em>Execution Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final int EXECUTION_TIMEOUT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getExecutionTimeout() <em>Execution Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionTimeout()
	 * @generated
	 * @ordered
	 */
	protected int executionTimeout = EXECUTION_TIMEOUT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * Create an {@link InteractionSpec} instance.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public InteractionSpecImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CciPackageImpl.Literals.INTERACTION_SPEC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFunctionName() {
		return functionName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionName(String newFunctionName) {
		String oldFunctionName = functionName;
		functionName = newFunctionName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackageImpl.INTERACTION_SPEC__FUNCTION_NAME, oldFunctionName, functionName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getInteractionVerb() {
		return interactionVerb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInteractionVerb(int newInteractionVerb) {
		int oldInteractionVerb = interactionVerb;
		interactionVerb = newInteractionVerb;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackageImpl.INTERACTION_SPEC__INTERACTION_VERB, oldInteractionVerb, interactionVerb));
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getExecutionTimeout() {
		return executionTimeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutionTimeout(int newExecutionTimeout) {
		int oldExecutionTimeout = executionTimeout;
		executionTimeout = newExecutionTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackageImpl.INTERACTION_SPEC__EXECUTION_TIMEOUT, oldExecutionTimeout, executionTimeout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CciPackageImpl.INTERACTION_SPEC__FUNCTION_NAME:
				return getFunctionName();
			case CciPackageImpl.INTERACTION_SPEC__INTERACTION_VERB:
				return getInteractionVerb();
			case CciPackageImpl.INTERACTION_SPEC__EXECUTION_TIMEOUT:
				return getExecutionTimeout();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CciPackageImpl.INTERACTION_SPEC__FUNCTION_NAME:
				setFunctionName((String)newValue);
				return;
			case CciPackageImpl.INTERACTION_SPEC__INTERACTION_VERB:
				setInteractionVerb((Integer)newValue);
				return;
			case CciPackageImpl.INTERACTION_SPEC__EXECUTION_TIMEOUT:
				setExecutionTimeout((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CciPackageImpl.INTERACTION_SPEC__FUNCTION_NAME:
				setFunctionName(FUNCTION_NAME_EDEFAULT);
				return;
			case CciPackageImpl.INTERACTION_SPEC__INTERACTION_VERB:
				setInteractionVerb(INTERACTION_VERB_EDEFAULT);
				return;
			case CciPackageImpl.INTERACTION_SPEC__EXECUTION_TIMEOUT:
				setExecutionTimeout(EXECUTION_TIMEOUT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CciPackageImpl.INTERACTION_SPEC__FUNCTION_NAME:
				return FUNCTION_NAME_EDEFAULT == null ? functionName != null : !FUNCTION_NAME_EDEFAULT.equals(functionName);
			case CciPackageImpl.INTERACTION_SPEC__INTERACTION_VERB:
				return interactionVerb != INTERACTION_VERB_EDEFAULT;
			case CciPackageImpl.INTERACTION_SPEC__EXECUTION_TIMEOUT:
				return executionTimeout != EXECUTION_TIMEOUT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (functionName: ");
		result.append(functionName);
		result.append(", interactionVerb: ");
		result.append(interactionVerb);
		result.append(", executionTimeout: ");
		result.append(executionTimeout);
		result.append(')');
		return result.toString();
	}

} //InteractionSpecImpl
