/**
 */
package org.jboss.jca.adapters.sap.model.cci;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interaction Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.InteractionSpec#getFunctionName <em>Function Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.InteractionSpec#getInteractionVerb <em>Interaction Verb</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.InteractionSpec#getExecutionTimeout <em>Execution Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getInteractionSpec()
 * @model
 * @generated
 */
public interface InteractionSpec extends EObject {
	/**
	 * Returns the value of the '<em><b>Function Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Name</em>' attribute.
	 * @see #setFunctionName(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getInteractionSpec_FunctionName()
	 * @model
	 * @generated
	 */
	String getFunctionName();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.InteractionSpec#getFunctionName <em>Function Name</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Interaction Verb</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interaction Verb</em>' attribute.
	 * @see #setInteractionVerb(int)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getInteractionSpec_InteractionVerb()
	 * @model
	 * @generated
	 */
	int getInteractionVerb();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.InteractionSpec#getInteractionVerb <em>Interaction Verb</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Execution Timeout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Timeout</em>' attribute.
	 * @see #setExecutionTimeout(int)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getInteractionSpec_ExecutionTimeout()
	 * @model
	 * @generated
	 */
	int getExecutionTimeout();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.InteractionSpec#getExecutionTimeout <em>Execution Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Timeout</em>' attribute.
	 * @see #getExecutionTimeout()
	 * @generated
	 */
	void setExecutionTimeout(int value);

} // InteractionSpec
