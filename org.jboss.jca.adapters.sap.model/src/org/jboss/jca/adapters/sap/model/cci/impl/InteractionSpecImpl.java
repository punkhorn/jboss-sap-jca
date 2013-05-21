/**
 */
package org.jboss.jca.adapters.sap.model.cci.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.cci.InteractionSpec;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interaction Spec</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.InteractionSpecImpl#getFunctionName <em>Function Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.InteractionSpecImpl#getInteractionVerb <em>Interaction Verb</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.InteractionSpecImpl#getExecutionTimeout <em>Execution Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InteractionSpecImpl extends EObjectImpl implements InteractionSpec {
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
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InteractionSpecImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CciPackage.Literals.INTERACTION_SPEC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFunctionName() {
		return functionName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionName(String newFunctionName) {
		String oldFunctionName = functionName;
		functionName = newFunctionName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.INTERACTION_SPEC__FUNCTION_NAME, oldFunctionName, functionName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getInteractionVerb() {
		return interactionVerb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInteractionVerb(int newInteractionVerb) {
		int oldInteractionVerb = interactionVerb;
		interactionVerb = newInteractionVerb;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.INTERACTION_SPEC__INTERACTION_VERB, oldInteractionVerb, interactionVerb));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getExecutionTimeout() {
		return executionTimeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutionTimeout(int newExecutionTimeout) {
		int oldExecutionTimeout = executionTimeout;
		executionTimeout = newExecutionTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.INTERACTION_SPEC__EXECUTION_TIMEOUT, oldExecutionTimeout, executionTimeout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CciPackage.INTERACTION_SPEC__FUNCTION_NAME:
				return getFunctionName();
			case CciPackage.INTERACTION_SPEC__INTERACTION_VERB:
				return getInteractionVerb();
			case CciPackage.INTERACTION_SPEC__EXECUTION_TIMEOUT:
				return getExecutionTimeout();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CciPackage.INTERACTION_SPEC__FUNCTION_NAME:
				setFunctionName((String)newValue);
				return;
			case CciPackage.INTERACTION_SPEC__INTERACTION_VERB:
				setInteractionVerb((Integer)newValue);
				return;
			case CciPackage.INTERACTION_SPEC__EXECUTION_TIMEOUT:
				setExecutionTimeout((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CciPackage.INTERACTION_SPEC__FUNCTION_NAME:
				setFunctionName(FUNCTION_NAME_EDEFAULT);
				return;
			case CciPackage.INTERACTION_SPEC__INTERACTION_VERB:
				setInteractionVerb(INTERACTION_VERB_EDEFAULT);
				return;
			case CciPackage.INTERACTION_SPEC__EXECUTION_TIMEOUT:
				setExecutionTimeout(EXECUTION_TIMEOUT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CciPackage.INTERACTION_SPEC__FUNCTION_NAME:
				return FUNCTION_NAME_EDEFAULT == null ? functionName != null : !FUNCTION_NAME_EDEFAULT.equals(functionName);
			case CciPackage.INTERACTION_SPEC__INTERACTION_VERB:
				return interactionVerb != INTERACTION_VERB_EDEFAULT;
			case CciPackage.INTERACTION_SPEC__EXECUTION_TIMEOUT:
				return executionTimeout != EXECUTION_TIMEOUT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
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
