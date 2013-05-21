/**
 */
package org.jboss.jca.adapters.sap.model.spi;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Adapter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ResourceAdapter#getState <em>State</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ResourceAdapter#getConnectionRequestInfoStore <em>Connection Request Info Store</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ResourceAdapter#getManagedConnectionFactories <em>Managed Connection Factories</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getResourceAdapter()
 * @model
 * @generated
 */
public interface ResourceAdapter extends EObject {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.jboss.jca.adapters.sap.model.spi.ResourceAdapterState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.jboss.jca.adapters.sap.model.spi.ResourceAdapterState
	 * @see #setState(ResourceAdapterState)
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getResourceAdapter_State()
	 * @model required="true"
	 * @generated
	 */
	ResourceAdapterState getState();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.spi.ResourceAdapter#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.jboss.jca.adapters.sap.model.spi.ResourceAdapterState
	 * @see #getState()
	 * @generated
	 */
	void setState(ResourceAdapterState value);

	/**
	 * Returns the value of the '<em><b>Connection Request Info Store</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Request Info Store</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Request Info Store</em>' containment reference.
	 * @see #setConnectionRequestInfoStore(ConnectionRequestInfoStore)
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getResourceAdapter_ConnectionRequestInfoStore()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	ConnectionRequestInfoStore getConnectionRequestInfoStore();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.spi.ResourceAdapter#getConnectionRequestInfoStore <em>Connection Request Info Store</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Request Info Store</em>' containment reference.
	 * @see #getConnectionRequestInfoStore()
	 * @generated
	 */
	void setConnectionRequestInfoStore(ConnectionRequestInfoStore value);

	/**
	 * Returns the value of the '<em><b>Managed Connection Factories</b></em>' containment reference list.
	 * The list contents are of type {@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory}.
	 * It is bidirectional and its opposite is '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getResourceAdapter <em>Resource Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Managed Connection Factories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Managed Connection Factories</em>' containment reference list.
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getResourceAdapter_ManagedConnectionFactories()
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getResourceAdapter
	 * @model opposite="resourceAdapter" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ManagedConnectionFactory> getManagedConnectionFactories();

} // ResourceAdapter
