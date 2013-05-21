/**
 */
package org.jboss.jca.adapters.sap.model.spi.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfoStore;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.model.spi.ResourceAdapter;
import org.jboss.jca.adapters.sap.model.spi.ResourceAdapterState;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Adapter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ResourceAdapterImpl#getState <em>State</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ResourceAdapterImpl#getConnectionRequestInfoStore <em>Connection Request Info Store</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ResourceAdapterImpl#getManagedConnectionFactories <em>Managed Connection Factories</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceAdapterImpl extends EObjectImpl implements ResourceAdapter {
	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final ResourceAdapterState STATE_EDEFAULT = ResourceAdapterState.STARTING;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected ResourceAdapterState state = STATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConnectionRequestInfoStore() <em>Connection Request Info Store</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionRequestInfoStore()
	 * @generated
	 * @ordered
	 */
	protected ConnectionRequestInfoStore connectionRequestInfoStore;

	/**
	 * The cached value of the '{@link #getManagedConnectionFactories() <em>Managed Connection Factories</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagedConnectionFactories()
	 * @generated
	 * @ordered
	 */
	protected EList<ManagedConnectionFactory> managedConnectionFactories;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ResourceAdapterImpl() {
		super();
		setConnectionRequestInfoStore(new ConnectionRequestInfoStoreImpl());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpiPackage.Literals.RESOURCE_ADAPTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceAdapterState getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(ResourceAdapterState newState) {
		ResourceAdapterState oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpiPackage.RESOURCE_ADAPTER__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionRequestInfoStore getConnectionRequestInfoStore() {
		if (connectionRequestInfoStore != null && connectionRequestInfoStore.eIsProxy()) {
			InternalEObject oldConnectionRequestInfoStore = (InternalEObject)connectionRequestInfoStore;
			connectionRequestInfoStore = (ConnectionRequestInfoStore)eResolveProxy(oldConnectionRequestInfoStore);
			if (connectionRequestInfoStore != oldConnectionRequestInfoStore) {
				InternalEObject newConnectionRequestInfoStore = (InternalEObject)connectionRequestInfoStore;
				NotificationChain msgs = oldConnectionRequestInfoStore.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpiPackage.RESOURCE_ADAPTER__CONNECTION_REQUEST_INFO_STORE, null, null);
				if (newConnectionRequestInfoStore.eInternalContainer() == null) {
					msgs = newConnectionRequestInfoStore.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpiPackage.RESOURCE_ADAPTER__CONNECTION_REQUEST_INFO_STORE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpiPackage.RESOURCE_ADAPTER__CONNECTION_REQUEST_INFO_STORE, oldConnectionRequestInfoStore, connectionRequestInfoStore));
			}
		}
		return connectionRequestInfoStore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionRequestInfoStore basicGetConnectionRequestInfoStore() {
		return connectionRequestInfoStore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConnectionRequestInfoStore(ConnectionRequestInfoStore newConnectionRequestInfoStore, NotificationChain msgs) {
		ConnectionRequestInfoStore oldConnectionRequestInfoStore = connectionRequestInfoStore;
		connectionRequestInfoStore = newConnectionRequestInfoStore;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpiPackage.RESOURCE_ADAPTER__CONNECTION_REQUEST_INFO_STORE, oldConnectionRequestInfoStore, newConnectionRequestInfoStore);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionRequestInfoStore(ConnectionRequestInfoStore newConnectionRequestInfoStore) {
		if (newConnectionRequestInfoStore != connectionRequestInfoStore) {
			NotificationChain msgs = null;
			if (connectionRequestInfoStore != null)
				msgs = ((InternalEObject)connectionRequestInfoStore).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpiPackage.RESOURCE_ADAPTER__CONNECTION_REQUEST_INFO_STORE, null, msgs);
			if (newConnectionRequestInfoStore != null)
				msgs = ((InternalEObject)newConnectionRequestInfoStore).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpiPackage.RESOURCE_ADAPTER__CONNECTION_REQUEST_INFO_STORE, null, msgs);
			msgs = basicSetConnectionRequestInfoStore(newConnectionRequestInfoStore, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpiPackage.RESOURCE_ADAPTER__CONNECTION_REQUEST_INFO_STORE, newConnectionRequestInfoStore, newConnectionRequestInfoStore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ManagedConnectionFactory> getManagedConnectionFactories() {
		if (managedConnectionFactories == null) {
			managedConnectionFactories = new EObjectContainmentWithInverseEList.Resolving<ManagedConnectionFactory>(ManagedConnectionFactory.class, this, SpiPackage.RESOURCE_ADAPTER__MANAGED_CONNECTION_FACTORIES, SpiPackage.MANAGED_CONNECTION_FACTORY__RESOURCE_ADAPTER);
		}
		return managedConnectionFactories;
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
			case SpiPackage.RESOURCE_ADAPTER__MANAGED_CONNECTION_FACTORIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getManagedConnectionFactories()).basicAdd(otherEnd, msgs);
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
			case SpiPackage.RESOURCE_ADAPTER__CONNECTION_REQUEST_INFO_STORE:
				return basicSetConnectionRequestInfoStore(null, msgs);
			case SpiPackage.RESOURCE_ADAPTER__MANAGED_CONNECTION_FACTORIES:
				return ((InternalEList<?>)getManagedConnectionFactories()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SpiPackage.RESOURCE_ADAPTER__STATE:
				return getState();
			case SpiPackage.RESOURCE_ADAPTER__CONNECTION_REQUEST_INFO_STORE:
				if (resolve) return getConnectionRequestInfoStore();
				return basicGetConnectionRequestInfoStore();
			case SpiPackage.RESOURCE_ADAPTER__MANAGED_CONNECTION_FACTORIES:
				return getManagedConnectionFactories();
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
			case SpiPackage.RESOURCE_ADAPTER__STATE:
				setState((ResourceAdapterState)newValue);
				return;
			case SpiPackage.RESOURCE_ADAPTER__CONNECTION_REQUEST_INFO_STORE:
				setConnectionRequestInfoStore((ConnectionRequestInfoStore)newValue);
				return;
			case SpiPackage.RESOURCE_ADAPTER__MANAGED_CONNECTION_FACTORIES:
				getManagedConnectionFactories().clear();
				getManagedConnectionFactories().addAll((Collection<? extends ManagedConnectionFactory>)newValue);
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
			case SpiPackage.RESOURCE_ADAPTER__STATE:
				setState(STATE_EDEFAULT);
				return;
			case SpiPackage.RESOURCE_ADAPTER__CONNECTION_REQUEST_INFO_STORE:
				setConnectionRequestInfoStore((ConnectionRequestInfoStore)null);
				return;
			case SpiPackage.RESOURCE_ADAPTER__MANAGED_CONNECTION_FACTORIES:
				getManagedConnectionFactories().clear();
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
			case SpiPackage.RESOURCE_ADAPTER__STATE:
				return state != STATE_EDEFAULT;
			case SpiPackage.RESOURCE_ADAPTER__CONNECTION_REQUEST_INFO_STORE:
				return connectionRequestInfoStore != null;
			case SpiPackage.RESOURCE_ADAPTER__MANAGED_CONNECTION_FACTORIES:
				return managedConnectionFactories != null && !managedConnectionFactories.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //ResourceAdapterImpl
