/**
 */
package org.jboss.jca.adapters.sap.model.cci;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.Execution#getInteractionSpec <em>Interaction Spec</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.Execution#getInputRecord <em>Input Record</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.Execution#getOutputRecord <em>Output Record</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getExecution()
 * @model
 * @generated
 */
public interface Execution extends EObject {
	/**
	 * Returns the value of the '<em><b>Interaction Spec</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interaction Spec</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interaction Spec</em>' containment reference.
	 * @see #setInteractionSpec(InteractionSpec)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getExecution_InteractionSpec()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	InteractionSpec getInteractionSpec();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.Execution#getInteractionSpec <em>Interaction Spec</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interaction Spec</em>' containment reference.
	 * @see #getInteractionSpec()
	 * @generated
	 */
	void setInteractionSpec(InteractionSpec value);

	/**
	 * Returns the value of the '<em><b>Input Record</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Record</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Record</em>' reference.
	 * @see #setInputRecord(MappedRecord)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getExecution_InputRecord()
	 * @model
	 * @generated
	 */
	MappedRecord getInputRecord();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.Execution#getInputRecord <em>Input Record</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Record</em>' reference.
	 * @see #getInputRecord()
	 * @generated
	 */
	void setInputRecord(MappedRecord value);

	/**
	 * Returns the value of the '<em><b>Output Record</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Record</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Record</em>' reference.
	 * @see #setOutputRecord(MappedRecord)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getExecution_OutputRecord()
	 * @model
	 * @generated
	 */
	MappedRecord getOutputRecord();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.Execution#getOutputRecord <em>Output Record</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Record</em>' reference.
	 * @see #getOutputRecord()
	 * @generated
	 */
	void setOutputRecord(MappedRecord value);

} // Execution
