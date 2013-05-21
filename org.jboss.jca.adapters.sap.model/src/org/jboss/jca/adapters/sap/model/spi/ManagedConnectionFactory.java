/**
 */
package org.jboss.jca.adapters.sap.model.spi;

import java.io.PrintWriter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.jboss.jca.adapters.sap.model.cci.ConnectionFactory;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Managed Connection Factory</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getState <em>State</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getResourceAdapter <em>Resource Adapter</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getDefaultConnectionName <em>Default Connection Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getDefaultConnectionRequestInfo <em>Default Connection Request Info</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getPackageRegistry <em>Package Registry</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getManagedConnections <em>Managed Connections</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getConnectionFactories <em>Connection Factories</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getLogWriter <em>Log Writer</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnectionFactory()
 * @model
 * @generated
 */
public interface ManagedConnectionFactory extends EObject {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The default value is <code>"ACTIVE"</code>.
	 * The literals are from the enumeration {@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactoryState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactoryState
	 * @see #setState(ManagedConnectionFactoryState)
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnectionFactory_State()
	 * @model default="ACTIVE"
	 * @generated
	 */
	ManagedConnectionFactoryState getState();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactoryState
	 * @see #getState()
	 * @generated
	 */
	void setState(ManagedConnectionFactoryState value);

	/**
	 * Returns the value of the '<em><b>Resource Adapter</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.jboss.jca.adapters.sap.model.spi.ResourceAdapter#getManagedConnectionFactories <em>Managed Connection Factories</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Adapter</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Adapter</em>' container reference.
	 * @see #setResourceAdapter(ResourceAdapter)
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnectionFactory_ResourceAdapter()
	 * @see org.jboss.jca.adapters.sap.model.spi.ResourceAdapter#getManagedConnectionFactories
	 * @model opposite="managedConnectionFactories" required="true" transient="false"
	 * @generated
	 */
	ResourceAdapter getResourceAdapter();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getResourceAdapter <em>Resource Adapter</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Adapter</em>' container reference.
	 * @see #getResourceAdapter()
	 * @generated
	 */
	void setResourceAdapter(ResourceAdapter value);

	/**
	 * Returns the value of the '<em><b>Default Connection Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Connection Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Connection Name</em>' attribute.
	 * @see #setDefaultConnectionName(String)
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnectionFactory_DefaultConnectionName()
	 * @model required="true"
	 * @generated
	 */
	String getDefaultConnectionName();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getDefaultConnectionName <em>Default Connection Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Connection Name</em>' attribute.
	 * @see #getDefaultConnectionName()
	 * @generated
	 */
	void setDefaultConnectionName(String value);

	/**
	 * Returns the value of the '<em><b>Managed Connections</b></em>' containment reference list.
	 * The list contents are of type {@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection}.
	 * It is bidirectional and its opposite is '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getManagedConnectionFactory <em>Managed Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Managed Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Managed Connections</em>' containment reference list.
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnectionFactory_ManagedConnections()
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getManagedConnectionFactory
	 * @model opposite="managedConnectionFactory" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ManagedConnection> getManagedConnections();

	/**
	 * Returns the value of the '<em><b>Connection Factories</b></em>' containment reference list.
	 * The list contents are of type {@link org.jboss.jca.adapters.sap.model.cci.ConnectionFactory}.
	 * It is bidirectional and its opposite is '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionFactory#getManagedConnectionFactory <em>Managed Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Factories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Factories</em>' containment reference list.
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnectionFactory_ConnectionFactories()
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionFactory#getManagedConnectionFactory
	 * @model opposite="managedConnectionFactory" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ConnectionFactory> getConnectionFactories();

	/**
	 * Returns the value of the '<em><b>Log Writer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Writer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Writer</em>' attribute.
	 * @see #setLogWriter(PrintWriter)
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnectionFactory_LogWriter()
	 * @model dataType="org.jboss.jca.adapters.sap.model.spi.PrintWriter" transient="true"
	 * @generated
	 */
	PrintWriter getLogWriter();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getLogWriter <em>Log Writer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Writer</em>' attribute.
	 * @see #getLogWriter()
	 * @generated
	 */
	void setLogWriter(PrintWriter value);

	/**
	 * Returns the value of the '<em><b>Package Registry</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.jboss.jca.adapters.sap.model.spi.PackageRegistry#getManagedConnectionFactory <em>Managed Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Registry</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Registry</em>' containment reference.
	 * @see #setPackageRegistry(PackageRegistry)
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnectionFactory_PackageRegistry()
	 * @see org.jboss.jca.adapters.sap.model.spi.PackageRegistry#getManagedConnectionFactory
	 * @model opposite="managedConnectionFactory" containment="true" resolveProxies="true"
	 * @generated
	 */
	PackageRegistry getPackageRegistry();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getPackageRegistry <em>Package Registry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Registry</em>' containment reference.
	 * @see #getPackageRegistry()
	 * @generated
	 */
	void setPackageRegistry(PackageRegistry value);

	/**
	 * Returns the value of the '<em><b>Default Connection Request Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Connection Request Info</em>' containment reference.
	 * @see #setDefaultConnectionRequestInfo(ConnectionRequestInfo)
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnectionFactory_DefaultConnectionRequestInfo()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	ConnectionRequestInfo getDefaultConnectionRequestInfo();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getDefaultConnectionRequestInfo <em>Default Connection Request Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Connection Request Info</em>' containment reference.
	 * @see #getDefaultConnectionRequestInfo()
	 * @generated
	 */
	void setDefaultConnectionRequestInfo(ConnectionRequestInfo value);

} // ManagedConnectionFactory
