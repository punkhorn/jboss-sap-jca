/**
 */
package org.jboss.jca.adapters.sap.model.cci;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Indexed Record</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.IndexedRecord#getRecords <em>Records</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getIndexedRecord()
 * @model
 * @generated
 */
public interface IndexedRecord<R extends MappedRecord> extends Record {
	/**
	 * Returns the value of the '<em><b>Records</b></em>' reference list.
	 * The list contents are of type {@link R}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Records</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Records</em>' reference list.
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getIndexedRecord_Records()
	 * @model
	 * @generated
	 */
	EList<R> getRecords();

} // IndexedRecord
