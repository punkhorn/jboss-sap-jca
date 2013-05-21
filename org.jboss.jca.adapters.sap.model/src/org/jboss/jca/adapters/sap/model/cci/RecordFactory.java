/**
 */
package org.jboss.jca.adapters.sap.model.cci;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record Factory</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.RecordFactory#getConnectionFactory <em>Connection Factory</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.RecordFactory#getIndexedRecords <em>Indexed Records</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.RecordFactory#getMappedRecords <em>Mapped Records</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getRecordFactory()
 * @model
 * @generated
 */
public interface RecordFactory extends EObject {
	/**
	 * Returns the value of the '<em><b>Connection Factory</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionFactory#getRecordFactory <em>Record Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Factory</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Factory</em>' container reference.
	 * @see #setConnectionFactory(ConnectionFactory)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getRecordFactory_ConnectionFactory()
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionFactory#getRecordFactory
	 * @model opposite="recordFactory" transient="false"
	 * @generated
	 */
	ConnectionFactory getConnectionFactory();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.RecordFactory#getConnectionFactory <em>Connection Factory</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Factory</em>' container reference.
	 * @see #getConnectionFactory()
	 * @generated
	 */
	void setConnectionFactory(ConnectionFactory value);

	/**
	 * Returns the value of the '<em><b>Indexed Records</b></em>' containment reference list.
	 * The list contents are of type {@link org.jboss.jca.adapters.sap.model.cci.IndexedRecord}&lt;?>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indexed Records</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indexed Records</em>' containment reference list.
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getRecordFactory_IndexedRecords()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<IndexedRecord<?>> getIndexedRecords();

	/**
	 * Returns the value of the '<em><b>Mapped Records</b></em>' containment reference list.
	 * The list contents are of type {@link org.jboss.jca.adapters.sap.model.cci.MappedRecord}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapped Records</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped Records</em>' containment reference list.
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getRecordFactory_MappedRecords()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<MappedRecord> getMappedRecords();

} // RecordFactory
