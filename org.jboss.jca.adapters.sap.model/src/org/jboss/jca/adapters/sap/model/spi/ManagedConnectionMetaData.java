/**
 */
package org.jboss.jca.adapters.sap.model.spi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Managed Connection Meta Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionMetaData#getEISProductName <em>EIS Product Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionMetaData#getEISProductVersion <em>EIS Product Version</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionMetaData#getUserName <em>User Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionMetaData#getMaxConnections <em>Max Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnectionMetaData()
 * @model features="managedConnection" 
 *        managedConnectionType="org.jboss.jca.adapters.sap.model.spi.ManagedConnection" managedConnectionOpposite="managedConnectionMetaData" managedConnectionRequired="true" managedConnectionTransient="false" managedConnectionSuppressedGetVisibility="true" managedConnectionSuppressedSetVisibility="true"
 * @generated
 */
public interface ManagedConnectionMetaData extends EObject {
	/**
	 * Returns the value of the '<em><b>EIS Product Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EIS Product Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EIS Product Name</em>' attribute.
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnectionMetaData_EISProductName()
	 * @model required="true" suppressedSetVisibility="true"
	 * @generated
	 */
	String getEISProductName();

	/**
	 * Returns the value of the '<em><b>EIS Product Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EIS Product Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EIS Product Version</em>' attribute.
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnectionMetaData_EISProductVersion()
	 * @model required="true" suppressedSetVisibility="true"
	 * @generated
	 */
	String getEISProductVersion();

	/**
	 * Returns the value of the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Name</em>' attribute.
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnectionMetaData_UserName()
	 * @model required="true" suppressedSetVisibility="true"
	 * @generated
	 */
	String getUserName();

	/**
	 * Returns the value of the '<em><b>Max Connections</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Connections</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Connections</em>' attribute.
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnectionMetaData_MaxConnections()
	 * @model required="true" suppressedSetVisibility="true"
	 * @generated
	 */
	int getMaxConnections();

} // ManagedConnectionMetaData
