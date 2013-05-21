/**
 */
package org.jboss.jca.adapters.sap.model.cci;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage
 * @generated
 */
public interface CciFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CciFactory eINSTANCE = org.jboss.jca.adapters.sap.model.cci.impl.CciFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Connection Factory</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection Factory</em>'.
	 * @generated
	 */
	ConnectionFactory createConnectionFactory();

	/**
	 * Returns a new object of class '<em>Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection</em>'.
	 * @generated
	 */
	Connection createConnection();

	/**
	 * Returns a new object of class '<em>Connection Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection Spec</em>'.
	 * @generated
	 */
	ConnectionSpec createConnectionSpec();

	/**
	 * Returns a new object of class '<em>Interaction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interaction</em>'.
	 * @generated
	 */
	Interaction createInteraction();

	/**
	 * Returns a new object of class '<em>Interaction Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interaction Spec</em>'.
	 * @generated
	 */
	InteractionSpec createInteractionSpec();

	/**
	 * Returns a new object of class '<em>Record Factory</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Record Factory</em>'.
	 * @generated
	 */
	RecordFactory createRecordFactory();

	/**
	 * Returns a new object of class '<em>Mapped Record</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapped Record</em>'.
	 * @generated
	 */
	MappedRecord createMappedRecord();

	/**
	 * Returns a new object of class '<em>Indexed Record</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Indexed Record</em>'.
	 * @generated
	 */
	<R extends MappedRecord> IndexedRecord<R> createIndexedRecord();

	/**
	 * Returns a new object of class '<em>Execution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution</em>'.
	 * @generated
	 */
	Execution createExecution();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CciPackage getCciPackage();

} //CciFactory
