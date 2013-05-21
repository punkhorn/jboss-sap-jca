/**
 */
package org.jboss.jca.adapters.sap.model.cci.impl;

import java.util.Collection;
import javax.resource.cci.ResourceWarning;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.ecore.util.InternalEList;
import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.cci.Connection;
import org.jboss.jca.adapters.sap.model.cci.Execution;
import org.jboss.jca.adapters.sap.model.cci.Interaction;
import org.jboss.jca.adapters.sap.model.cci.InteractionState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.InteractionImpl#getState <em>State</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.InteractionImpl#getConnection <em>Connection</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.InteractionImpl#getResourceWarning <em>Resource Warning</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.InteractionImpl#getExecutions <em>Executions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InteractionImpl extends EObjectImpl implements Interaction {
	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final InteractionState STATE_EDEFAULT = InteractionState.ACTIVE;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected InteractionState state = STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourceWarning() <em>Resource Warning</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceWarning()
	 * @generated
	 * @ordered
	 */
	protected static final ResourceWarning RESOURCE_WARNING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceWarning() <em>Resource Warning</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceWarning()
	 * @generated
	 * @ordered
	 */
	protected ResourceWarning resourceWarning = RESOURCE_WARNING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExecutions() <em>Executions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutions()
	 * @generated
	 * @ordered
	 */
	protected EList<Execution> executions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InteractionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CciPackage.Literals.INTERACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionState getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(InteractionState newState) {
		InteractionState oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.INTERACTION__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection getConnection() {
		if (eContainerFeatureID() != CciPackage.INTERACTION__CONNECTION) return null;
		return (Connection)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection basicGetConnection() {
		if (eContainerFeatureID() != CciPackage.INTERACTION__CONNECTION) return null;
		return (Connection)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConnection(Connection newConnection, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConnection, CciPackage.INTERACTION__CONNECTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnection(Connection newConnection) {
		if (newConnection != eInternalContainer() || (eContainerFeatureID() != CciPackage.INTERACTION__CONNECTION && newConnection != null)) {
			if (EcoreUtil.isAncestor(this, newConnection))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConnection != null)
				msgs = ((InternalEObject)newConnection).eInverseAdd(this, CciPackage.CONNECTION__INTERACTIONS, Connection.class, msgs);
			msgs = basicSetConnection(newConnection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.INTERACTION__CONNECTION, newConnection, newConnection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceWarning getResourceWarning() {
		return resourceWarning;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceWarning(ResourceWarning newResourceWarning) {
		ResourceWarning oldResourceWarning = resourceWarning;
		resourceWarning = newResourceWarning;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.INTERACTION__RESOURCE_WARNING, oldResourceWarning, resourceWarning));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Execution> getExecutions() {
		if (executions == null) {
			executions = new EObjectContainmentEList.Resolving<Execution>(Execution.class, this, CciPackage.INTERACTION__EXECUTIONS);
		}
		return executions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CciPackage.INTERACTION__CONNECTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConnection((Connection)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CciPackage.INTERACTION__CONNECTION:
				return basicSetConnection(null, msgs);
			case CciPackage.INTERACTION__EXECUTIONS:
				return ((InternalEList<?>)getExecutions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case CciPackage.INTERACTION__CONNECTION:
				return eInternalContainer().eInverseRemove(this, CciPackage.CONNECTION__INTERACTIONS, Connection.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CciPackage.INTERACTION__STATE:
				return getState();
			case CciPackage.INTERACTION__CONNECTION:
				if (resolve) return getConnection();
				return basicGetConnection();
			case CciPackage.INTERACTION__RESOURCE_WARNING:
				return getResourceWarning();
			case CciPackage.INTERACTION__EXECUTIONS:
				return getExecutions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CciPackage.INTERACTION__STATE:
				setState((InteractionState)newValue);
				return;
			case CciPackage.INTERACTION__CONNECTION:
				setConnection((Connection)newValue);
				return;
			case CciPackage.INTERACTION__RESOURCE_WARNING:
				setResourceWarning((ResourceWarning)newValue);
				return;
			case CciPackage.INTERACTION__EXECUTIONS:
				getExecutions().clear();
				getExecutions().addAll((Collection<? extends Execution>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CciPackage.INTERACTION__STATE:
				setState(STATE_EDEFAULT);
				return;
			case CciPackage.INTERACTION__CONNECTION:
				setConnection((Connection)null);
				return;
			case CciPackage.INTERACTION__RESOURCE_WARNING:
				setResourceWarning(RESOURCE_WARNING_EDEFAULT);
				return;
			case CciPackage.INTERACTION__EXECUTIONS:
				getExecutions().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CciPackage.INTERACTION__STATE:
				return state != STATE_EDEFAULT;
			case CciPackage.INTERACTION__CONNECTION:
				return basicGetConnection() != null;
			case CciPackage.INTERACTION__RESOURCE_WARNING:
				return RESOURCE_WARNING_EDEFAULT == null ? resourceWarning != null : !RESOURCE_WARNING_EDEFAULT.equals(resourceWarning);
			case CciPackage.INTERACTION__EXECUTIONS:
				return executions != null && !executions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (state: ");
		result.append(state);
		result.append(", resourceWarning: ");
		result.append(resourceWarning);
		result.append(')');
		return result.toString();
	}

} //InteractionImpl
