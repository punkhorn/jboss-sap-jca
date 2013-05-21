/**
 */
package org.jboss.jca.adapters.sap.model.spi;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage
 * @generated
 */
public interface SpiFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SpiFactory eINSTANCE = org.jboss.jca.adapters.sap.model.spi.impl.SpiFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Connection Request Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection Request Info</em>'.
	 * @generated
	 */
	ConnectionRequestInfo createConnectionRequestInfo();

	/**
	 * Returns a new object of class '<em>Connection Request Info Store</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection Request Info Store</em>'.
	 * @generated
	 */
	ConnectionRequestInfoStore createConnectionRequestInfoStore();

	/**
	 * Returns a new object of class '<em>Managed Connection Factory</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Managed Connection Factory</em>'.
	 * @generated
	 */
	ManagedConnectionFactory createManagedConnectionFactory();

	/**
	 * Returns a new object of class '<em>Managed Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Managed Connection</em>'.
	 * @generated
	 */
	ManagedConnection createManagedConnection();

	/**
	 * Returns a new object of class '<em>Resource Adapter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Adapter</em>'.
	 * @generated
	 */
	ResourceAdapter createResourceAdapter();

	/**
	 * Returns a new object of class '<em>Package Registry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package Registry</em>'.
	 * @generated
	 */
	PackageRegistry createPackageRegistry();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SpiPackage getSpiPackage();

} //SpiFactory
