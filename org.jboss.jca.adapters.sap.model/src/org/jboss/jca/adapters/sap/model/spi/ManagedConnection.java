/**
 */
package org.jboss.jca.adapters.sap.model.spi;

import java.io.PrintWriter;
import javax.resource.spi.ConnectionEventListener;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.jboss.jca.adapters.sap.model.cci.Connection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Managed Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getState <em>State</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getManagedConnectionFactory <em>Managed Connection Factory</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getConnectionName <em>Connection Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getConnectionRequestInfo <em>Connection Request Info</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getConnectionHandles <em>Connection Handles</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getLogWriter <em>Log Writer</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getConnectionEventListeners <em>Connection Event Listeners</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#isInTransaction <em>In Transaction</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnection()
 * @model
 * @generated
 */
public interface ManagedConnection extends EObject {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The default value is <code>"ACTIVE"</code>.
	 * The literals are from the enumeration {@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionState
	 * @see #setState(ManagedConnectionState)
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnection_State()
	 * @model default="ACTIVE"
	 * @generated
	 */
	ManagedConnectionState getState();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionState
	 * @see #getState()
	 * @generated
	 */
	void setState(ManagedConnectionState value);

	/**
	 * Returns the value of the '<em><b>Connection Request Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Request Info</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Request Info</em>' containment reference.
	 * @see #setConnectionRequestInfo(ConnectionRequestInfo)
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnection_ConnectionRequestInfo()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	ConnectionRequestInfo getConnectionRequestInfo();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getConnectionRequestInfo <em>Connection Request Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Request Info</em>' containment reference.
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	void setConnectionRequestInfo(ConnectionRequestInfo value);

	/**
	 * Returns the value of the '<em><b>Connection Handles</b></em>' containment reference list.
	 * The list contents are of type {@link org.jboss.jca.adapters.sap.model.cci.Connection}.
	 * It is bidirectional and its opposite is '{@link org.jboss.jca.adapters.sap.model.cci.Connection#getManagedConnection <em>Managed Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Handles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Handles</em>' containment reference list.
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnection_ConnectionHandles()
	 * @see org.jboss.jca.adapters.sap.model.cci.Connection#getManagedConnection
	 * @model opposite="managedConnection" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Connection> getConnectionHandles();

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
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnection_LogWriter()
	 * @model dataType="org.jboss.jca.adapters.sap.model.spi.PrintWriter" transient="true"
	 * @generated
	 */
	PrintWriter getLogWriter();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getLogWriter <em>Log Writer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Writer</em>' attribute.
	 * @see #getLogWriter()
	 * @generated
	 */
	void setLogWriter(PrintWriter value);

	/**
	 * Returns the value of the '<em><b>Connection Event Listeners</b></em>' attribute list.
	 * The list contents are of type {@link javax.resource.spi.ConnectionEventListener}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Event Listeners</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Event Listeners</em>' attribute list.
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnection_ConnectionEventListeners()
	 * @model dataType="org.jboss.jca.adapters.sap.model.spi.ConnectionEventListener" transient="true"
	 * @generated
	 */
	EList<ConnectionEventListener> getConnectionEventListeners();

	/**
	 * Returns the value of the '<em><b>In Transaction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Transaction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Transaction</em>' attribute.
	 * @see #setInTransaction(boolean)
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnection_InTransaction()
	 * @model
	 * @generated
	 */
	boolean isInTransaction();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#isInTransaction <em>In Transaction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Transaction</em>' attribute.
	 * @see #isInTransaction()
	 * @generated
	 */
	void setInTransaction(boolean value);

	/**
	 * Returns the value of the '<em><b>Managed Connection Factory</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getManagedConnections <em>Managed Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Managed Connection Factory</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Managed Connection Factory</em>' container reference.
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnection_ManagedConnectionFactory()
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getManagedConnections
	 * @model opposite="managedConnections" required="true" transient="false" suppressedSetVisibility="true"
	 * @generated
	 */
	ManagedConnectionFactory getManagedConnectionFactory();

	/**
	 * Returns the value of the '<em><b>Connection Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Name</em>' attribute.
	 * @see #setConnectionName(String)
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getManagedConnection_ConnectionName()
	 * @model default="" required="true"
	 * @generated
	 */
	String getConnectionName();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getConnectionName <em>Connection Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Name</em>' attribute.
	 * @see #getConnectionName()
	 * @generated
	 */
	void setConnectionName(String value);

} // ManagedConnection
