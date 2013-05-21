/**
 */
package org.jboss.jca.adapters.sap.model.cci;

import javax.naming.Reference;

import javax.resource.spi.ConnectionManager;

import org.eclipse.emf.ecore.EObject;

import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection Factory</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionFactory#getReference <em>Reference</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionFactory#getConnectionManager <em>Connection Manager</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionFactory#getRecordFactory <em>Record Factory</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionFactory#getManagedConnectionFactory <em>Managed Connection Factory</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionFactory()
 * @model
 * @generated
 */
public interface ConnectionFactory extends EObject {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' attribute.
	 * @see #setReference(Reference)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionFactory_Reference()
	 * @model dataType="org.jboss.jca.adapters.sap.model.cci.Reference" transient="true"
	 * @generated
	 */
	Reference getReference();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionFactory#getReference <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' attribute.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(Reference value);

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
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionFactory_ConnectionManager()
	 * @model dataType="org.jboss.jca.adapters.sap.model.cci.ConnectionManager" transient="true"
	 * @generated
	 */
	ConnectionManager getConnectionManager();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionFactory#getConnectionManager <em>Connection Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Manager</em>' attribute.
	 * @see #getConnectionManager()
	 * @generated
	 */
	void setConnectionManager(ConnectionManager value);

	/**
	 * Returns the value of the '<em><b>Record Factory</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.jboss.jca.adapters.sap.model.cci.RecordFactory#getConnectionFactory <em>Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Record Factory</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Record Factory</em>' containment reference.
	 * @see #setRecordFactory(RecordFactory)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionFactory_RecordFactory()
	 * @see org.jboss.jca.adapters.sap.model.cci.RecordFactory#getConnectionFactory
	 * @model opposite="connectionFactory" containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	RecordFactory getRecordFactory();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionFactory#getRecordFactory <em>Record Factory</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Record Factory</em>' containment reference.
	 * @see #getRecordFactory()
	 * @generated
	 */
	void setRecordFactory(RecordFactory value);

	/**
	 * Returns the value of the '<em><b>Managed Connection Factory</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getConnectionFactories <em>Connection Factories</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Managed Connection Factory</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Managed Connection Factory</em>' container reference.
	 * @see #setManagedConnectionFactory(ManagedConnectionFactory)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionFactory_ManagedConnectionFactory()
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getConnectionFactories
	 * @model opposite="connectionFactories" required="true" transient="false"
	 * @generated
	 */
	ManagedConnectionFactory getManagedConnectionFactory();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionFactory#getManagedConnectionFactory <em>Managed Connection Factory</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Managed Connection Factory</em>' container reference.
	 * @see #getManagedConnectionFactory()
	 * @generated
	 */
	void setManagedConnectionFactory(ManagedConnectionFactory value);

} // ConnectionFactory
