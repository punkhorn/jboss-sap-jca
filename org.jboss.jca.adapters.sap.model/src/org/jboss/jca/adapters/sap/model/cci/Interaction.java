/**
 */
package org.jboss.jca.adapters.sap.model.cci;

import javax.resource.cci.ResourceWarning;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.Interaction#getState <em>State</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.Interaction#getConnection <em>Connection</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.Interaction#getResourceWarning <em>Resource Warning</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.Interaction#getExecutions <em>Executions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getInteraction()
 * @model
 * @generated
 */
public interface Interaction extends EObject {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The default value is <code>"ACTIVE"</code>.
	 * The literals are from the enumeration {@link org.jboss.jca.adapters.sap.model.cci.InteractionState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.jboss.jca.adapters.sap.model.cci.InteractionState
	 * @see #setState(InteractionState)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getInteraction_State()
	 * @model default="ACTIVE"
	 * @generated
	 */
	InteractionState getState();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.Interaction#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.jboss.jca.adapters.sap.model.cci.InteractionState
	 * @see #getState()
	 * @generated
	 */
	void setState(InteractionState value);

	/**
	 * Returns the value of the '<em><b>Connection</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.jboss.jca.adapters.sap.model.cci.Connection#getInteractions <em>Interactions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection</em>' container reference.
	 * @see #setConnection(Connection)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getInteraction_Connection()
	 * @see org.jboss.jca.adapters.sap.model.cci.Connection#getInteractions
	 * @model opposite="interactions" transient="false"
	 * @generated
	 */
	Connection getConnection();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.Interaction#getConnection <em>Connection</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection</em>' container reference.
	 * @see #getConnection()
	 * @generated
	 */
	void setConnection(Connection value);

	/**
	 * Returns the value of the '<em><b>Resource Warning</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Warning</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Warning</em>' attribute.
	 * @see #setResourceWarning(ResourceWarning)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getInteraction_ResourceWarning()
	 * @model dataType="org.jboss.jca.adapters.sap.model.cci.ResourceWarning" transient="true"
	 * @generated
	 */
	ResourceWarning getResourceWarning();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.Interaction#getResourceWarning <em>Resource Warning</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Warning</em>' attribute.
	 * @see #getResourceWarning()
	 * @generated
	 */
	void setResourceWarning(ResourceWarning value);

	/**
	 * Returns the value of the '<em><b>Executions</b></em>' containment reference list.
	 * The list contents are of type {@link org.jboss.jca.adapters.sap.model.cci.Execution}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Executions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executions</em>' containment reference list.
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getInteraction_Executions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Execution> getExecutions();

} // Interaction
