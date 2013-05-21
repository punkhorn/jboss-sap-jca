/**
 */
package org.jboss.jca.adapters.sap.model.cci.impl;

import java.util.Collection;

import javax.resource.spi.ConnectionManager;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.cci.Connection;
import org.jboss.jca.adapters.sap.model.cci.ConnectionState;
import org.jboss.jca.adapters.sap.model.cci.Interaction;
import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnection;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionImpl#getState <em>State</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionImpl#getConnectionName <em>Connection Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionImpl#getConnectionRequestInfo <em>Connection Request Info</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionImpl#getManagedConnection <em>Managed Connection</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionImpl#getConnectionManager <em>Connection Manager</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionImpl#getInteractions <em>Interactions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionImpl extends EObjectImpl implements Connection {
	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final ConnectionState STATE_EDEFAULT = ConnectionState.INACTIVE;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected ConnectionState state = STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getConnectionName() <em>Connection Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionName()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNECTION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConnectionName() <em>Connection Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionName()
	 * @generated
	 * @ordered
	 */
	protected String connectionName = CONNECTION_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConnectionRequestInfo() <em>Connection Request Info</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionRequestInfo()
	 * @generated
	 * @ordered
	 */
	protected ConnectionRequestInfo connectionRequestInfo;

	/**
	 * The default value of the '{@link #getConnectionManager() <em>Connection Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionManager()
	 * @generated
	 * @ordered
	 */
	protected static final ConnectionManager CONNECTION_MANAGER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConnectionManager() <em>Connection Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionManager()
	 * @generated
	 * @ordered
	 */
	protected ConnectionManager connectionManager = CONNECTION_MANAGER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInteractions() <em>Interactions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInteractions()
	 * @generated
	 * @ordered
	 */
	protected EList<Interaction> interactions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CciPackage.Literals.CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionState getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(ConnectionState newState) {
		ConnectionState oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnectionName() {
		return connectionName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionName(String newConnectionName) {
		String oldConnectionName = connectionName;
		connectionName = newConnectionName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION__CONNECTION_NAME, oldConnectionName, connectionName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedConnection getManagedConnection() {
		if (eContainerFeatureID() != CciPackage.CONNECTION__MANAGED_CONNECTION) return null;
		return (ManagedConnection)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedConnection basicGetManagedConnection() {
		if (eContainerFeatureID() != CciPackage.CONNECTION__MANAGED_CONNECTION) return null;
		return (ManagedConnection)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetManagedConnection(ManagedConnection newManagedConnection, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newManagedConnection, CciPackage.CONNECTION__MANAGED_CONNECTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManagedConnection(ManagedConnection newManagedConnection) {
		if (newManagedConnection != eInternalContainer() || (eContainerFeatureID() != CciPackage.CONNECTION__MANAGED_CONNECTION && newManagedConnection != null)) {
			if (EcoreUtil.isAncestor(this, newManagedConnection))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newManagedConnection != null)
				msgs = ((InternalEObject)newManagedConnection).eInverseAdd(this, SpiPackage.MANAGED_CONNECTION__CONNECTION_HANDLES, ManagedConnection.class, msgs);
			msgs = basicSetManagedConnection(newManagedConnection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION__MANAGED_CONNECTION, newManagedConnection, newManagedConnection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionManager(ConnectionManager newConnectionManager) {
		ConnectionManager oldConnectionManager = connectionManager;
		connectionManager = newConnectionManager;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION__CONNECTION_MANAGER, oldConnectionManager, connectionManager));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interaction> getInteractions() {
		if (interactions == null) {
			interactions = new EObjectContainmentWithInverseEList.Resolving<Interaction>(Interaction.class, this, CciPackage.CONNECTION__INTERACTIONS, CciPackage.INTERACTION__CONNECTION);
		}
		return interactions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionRequestInfo getConnectionRequestInfo() {
		if (connectionRequestInfo != null && connectionRequestInfo.eIsProxy()) {
			InternalEObject oldConnectionRequestInfo = (InternalEObject)connectionRequestInfo;
			connectionRequestInfo = (ConnectionRequestInfo)eResolveProxy(oldConnectionRequestInfo);
			if (connectionRequestInfo != oldConnectionRequestInfo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CciPackage.CONNECTION__CONNECTION_REQUEST_INFO, oldConnectionRequestInfo, connectionRequestInfo));
			}
		}
		return connectionRequestInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionRequestInfo basicGetConnectionRequestInfo() {
		return connectionRequestInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionRequestInfo(ConnectionRequestInfo newConnectionRequestInfo) {
		ConnectionRequestInfo oldConnectionRequestInfo = connectionRequestInfo;
		connectionRequestInfo = newConnectionRequestInfo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION__CONNECTION_REQUEST_INFO, oldConnectionRequestInfo, connectionRequestInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CciPackage.CONNECTION__MANAGED_CONNECTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetManagedConnection((ManagedConnection)otherEnd, msgs);
			case CciPackage.CONNECTION__INTERACTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInteractions()).basicAdd(otherEnd, msgs);
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
			case CciPackage.CONNECTION__MANAGED_CONNECTION:
				return basicSetManagedConnection(null, msgs);
			case CciPackage.CONNECTION__INTERACTIONS:
				return ((InternalEList<?>)getInteractions()).basicRemove(otherEnd, msgs);
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
			case CciPackage.CONNECTION__MANAGED_CONNECTION:
				return eInternalContainer().eInverseRemove(this, SpiPackage.MANAGED_CONNECTION__CONNECTION_HANDLES, ManagedConnection.class, msgs);
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
			case CciPackage.CONNECTION__STATE:
				return getState();
			case CciPackage.CONNECTION__CONNECTION_NAME:
				return getConnectionName();
			case CciPackage.CONNECTION__CONNECTION_REQUEST_INFO:
				if (resolve) return getConnectionRequestInfo();
				return basicGetConnectionRequestInfo();
			case CciPackage.CONNECTION__MANAGED_CONNECTION:
				if (resolve) return getManagedConnection();
				return basicGetManagedConnection();
			case CciPackage.CONNECTION__CONNECTION_MANAGER:
				return getConnectionManager();
			case CciPackage.CONNECTION__INTERACTIONS:
				return getInteractions();
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
			case CciPackage.CONNECTION__STATE:
				setState((ConnectionState)newValue);
				return;
			case CciPackage.CONNECTION__CONNECTION_NAME:
				setConnectionName((String)newValue);
				return;
			case CciPackage.CONNECTION__CONNECTION_REQUEST_INFO:
				setConnectionRequestInfo((ConnectionRequestInfo)newValue);
				return;
			case CciPackage.CONNECTION__MANAGED_CONNECTION:
				setManagedConnection((ManagedConnection)newValue);
				return;
			case CciPackage.CONNECTION__CONNECTION_MANAGER:
				setConnectionManager((ConnectionManager)newValue);
				return;
			case CciPackage.CONNECTION__INTERACTIONS:
				getInteractions().clear();
				getInteractions().addAll((Collection<? extends Interaction>)newValue);
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
			case CciPackage.CONNECTION__STATE:
				setState(STATE_EDEFAULT);
				return;
			case CciPackage.CONNECTION__CONNECTION_NAME:
				setConnectionName(CONNECTION_NAME_EDEFAULT);
				return;
			case CciPackage.CONNECTION__CONNECTION_REQUEST_INFO:
				setConnectionRequestInfo((ConnectionRequestInfo)null);
				return;
			case CciPackage.CONNECTION__MANAGED_CONNECTION:
				setManagedConnection((ManagedConnection)null);
				return;
			case CciPackage.CONNECTION__CONNECTION_MANAGER:
				setConnectionManager(CONNECTION_MANAGER_EDEFAULT);
				return;
			case CciPackage.CONNECTION__INTERACTIONS:
				getInteractions().clear();
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
			case CciPackage.CONNECTION__STATE:
				return state != STATE_EDEFAULT;
			case CciPackage.CONNECTION__CONNECTION_NAME:
				return CONNECTION_NAME_EDEFAULT == null ? connectionName != null : !CONNECTION_NAME_EDEFAULT.equals(connectionName);
			case CciPackage.CONNECTION__CONNECTION_REQUEST_INFO:
				return connectionRequestInfo != null;
			case CciPackage.CONNECTION__MANAGED_CONNECTION:
				return basicGetManagedConnection() != null;
			case CciPackage.CONNECTION__CONNECTION_MANAGER:
				return CONNECTION_MANAGER_EDEFAULT == null ? connectionManager != null : !CONNECTION_MANAGER_EDEFAULT.equals(connectionManager);
			case CciPackage.CONNECTION__INTERACTIONS:
				return interactions != null && !interactions.isEmpty();
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
		result.append(", connectionName: ");
		result.append(connectionName);
		result.append(", connectionManager: ");
		result.append(connectionManager);
		result.append(')');
		return result.toString();
	}

} //ConnectionImpl
