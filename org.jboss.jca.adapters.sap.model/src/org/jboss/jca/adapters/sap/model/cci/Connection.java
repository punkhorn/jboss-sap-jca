/**
 */
package org.jboss.jca.adapters.sap.model.cci;

import javax.resource.spi.ConnectionManager;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.Connection#getState <em>State</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.Connection#getConnectionName <em>Connection Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.Connection#getConnectionRequestInfo <em>Connection Request Info</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.Connection#getManagedConnection <em>Managed Connection</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.Connection#getConnectionManager <em>Connection Manager</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.Connection#getInteractions <em>Interactions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnection()
 * @model
 * @generated
 */
public interface Connection extends EObject {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The default value is <code>"INACTIVE"</code>.
	 * The literals are from the enumeration {@link org.jboss.jca.adapters.sap.model.cci.ConnectionState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionState
	 * @see #setState(ConnectionState)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnection_State()
	 * @model default="INACTIVE"
	 * @generated
	 */
	ConnectionState getState();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.Connection#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionState
	 * @see #getState()
	 * @generated
	 */
	void setState(ConnectionState value);

	/**
	 * Returns the value of the '<em><b>Connection Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Name</em>' attribute.
	 * @see #setConnectionName(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnection_ConnectionName()
	 * @model required="true"
	 * @generated
	 */
	String getConnectionName();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.Connection#getConnectionName <em>Connection Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Name</em>' attribute.
	 * @see #getConnectionName()
	 * @generated
	 */
	void setConnectionName(String value);

	/**
	 * Returns the value of the '<em><b>Managed Connection</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getConnectionHandles <em>Connection Handles</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Managed Connection</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Managed Connection</em>' container reference.
	 * @see #setManagedConnection(ManagedConnection)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnection_ManagedConnection()
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getConnectionHandles
	 * @model opposite="connectionHandles"
	 * @generated
	 */
	ManagedConnection getManagedConnection();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.Connection#getManagedConnection <em>Managed Connection</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Managed Connection</em>' container reference.
	 * @see #getManagedConnection()
	 * @generated
	 */
	void setManagedConnection(ManagedConnection value);

	/**
	 * Returns the value of the '<em><b>Connection Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Manager</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Manager</em>' attribute.
	 * @see #setConnectionManager(ConnectionManager)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnection_ConnectionManager()
	 * @model dataType="org.jboss.jca.adapters.sap.model.cci.ConnectionManager" transient="true"
	 * @generated
	 */
	ConnectionManager getConnectionManager();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.Connection#getConnectionManager <em>Connection Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Manager</em>' attribute.
	 * @see #getConnectionManager()
	 * @generated
	 */
	void setConnectionManager(ConnectionManager value);

	/**
	 * Returns the value of the '<em><b>Interactions</b></em>' containment reference list.
	 * The list contents are of type {@link org.jboss.jca.adapters.sap.model.cci.Interaction}.
	 * It is bidirectional and its opposite is '{@link org.jboss.jca.adapters.sap.model.cci.Interaction#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interactions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interactions</em>' containment reference list.
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnection_Interactions()
	 * @see org.jboss.jca.adapters.sap.model.cci.Interaction#getConnection
	 * @model opposite="connection" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Interaction> getInteractions();

	/**
	 * Returns the value of the '<em><b>Connection Request Info</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Request Info</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Request Info</em>' reference.
	 * @see #setConnectionRequestInfo(ConnectionRequestInfo)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnection_ConnectionRequestInfo()
	 * @model required="true"
	 * @generated
	 */
	ConnectionRequestInfo getConnectionRequestInfo();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.Connection#getConnectionRequestInfo <em>Connection Request Info</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Request Info</em>' reference.
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	void setConnectionRequestInfo(ConnectionRequestInfo value);

} // Connection
