/**
 */
package org.jboss.jca.adapters.sap.model.cci;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.Record#getRecordName <em>Record Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.Record#getRecordDescription <em>Record Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getRecord()
 * @model abstract="true"
 * @generated
 */
public interface Record extends EObject {
	/**
	 * Returns the value of the '<em><b>Record Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Record Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Record Name</em>' attribute.
	 * @see #setRecordName(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getRecord_RecordName()
	 * @model
	 * @generated
	 */
	String getRecordName();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.Record#getRecordName <em>Record Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Record Name</em>' attribute.
	 * @see #getRecordName()
	 * @generated
	 */
	void setRecordName(String value);

	/**
	 * Returns the value of the '<em><b>Record Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Record Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Record Description</em>' attribute.
	 * @see #setRecordDescription(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getRecord_RecordDescription()
	 * @model
	 * @generated
	 */
	String getRecordDescription();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.Record#getRecordDescription <em>Record Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Record Description</em>' attribute.
	 * @see #getRecordDescription()
	 * @generated
	 */
	void setRecordDescription(String value);

} // Record
