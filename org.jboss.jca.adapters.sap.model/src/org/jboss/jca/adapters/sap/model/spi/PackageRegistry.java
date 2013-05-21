/**
 */
package org.jboss.jca.adapters.sap.model.spi;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Registry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.PackageRegistry#getPackages <em>Packages</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.PackageRegistry#getManagedConnectionFactory <em>Managed Connection Factory</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getPackageRegistry()
 * @model
 * @generated
 */
public interface PackageRegistry extends EObject {
	/**
	 * Returns the value of the '<em><b>Packages</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.eclipse.emf.ecore.EPackage},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Packages</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Packages</em>' map.
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getPackageRegistry_Packages()
	 * @model mapType="org.jboss.jca.adapters.sap.model.spi.PackageRegistryEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EPackage>"
	 * @generated
	 */
	EMap<String, EPackage> getPackages();

	/**
	 * Returns the value of the '<em><b>Managed Connection Factory</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getPackageRegistry <em>Package Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Managed Connection Factory</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Managed Connection Factory</em>' container reference.
	 * @see #setManagedConnectionFactory(ManagedConnectionFactory)
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getPackageRegistry_ManagedConnectionFactory()
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getPackageRegistry
	 * @model opposite="packageRegistry" transient="false"
	 * @generated
	 */
	ManagedConnectionFactory getManagedConnectionFactory();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.spi.PackageRegistry#getManagedConnectionFactory <em>Managed Connection Factory</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Managed Connection Factory</em>' container reference.
	 * @see #getManagedConnectionFactory()
	 * @generated
	 */
	void setManagedConnectionFactory(ManagedConnectionFactory value);

} // PackageRegistry
