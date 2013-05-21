/**
 */
package org.jboss.jca.adapters.sap.model.spi.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfoStore;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Request Info Store</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoStoreImpl#getConnectionRequestInfos <em>Connection Request Infos</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionRequestInfoStoreImpl extends EObjectImpl implements ConnectionRequestInfoStore {
	
	/**
	 * The cached value of the '{@link #getConnectionRequestInfos() <em>Connection Request Infos</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionRequestInfos()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, ConnectionRequestInfo> connectionRequestInfos;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionRequestInfoStoreImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpiPackage.Literals.CONNECTION_REQUEST_INFO_STORE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, ConnectionRequestInfo> getConnectionRequestInfos() {
		if (connectionRequestInfos == null) {
			connectionRequestInfos = new EcoreEMap<String,ConnectionRequestInfo>(SpiPackage.Literals.CONNECTION_REQUEST_INFO_STORE_ENTRY, ConnectionRequestInfoStoreEntryImpl.class, this, SpiPackage.CONNECTION_REQUEST_INFO_STORE__CONNECTION_REQUEST_INFOS);
		}
		return connectionRequestInfos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpiPackage.CONNECTION_REQUEST_INFO_STORE__CONNECTION_REQUEST_INFOS:
				return ((InternalEList<?>)getConnectionRequestInfos()).basicRemove(otherEnd, msgs);
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
			case SpiPackage.CONNECTION_REQUEST_INFO_STORE__CONNECTION_REQUEST_INFOS:
				if (coreType) return getConnectionRequestInfos();
				else return getConnectionRequestInfos().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SpiPackage.CONNECTION_REQUEST_INFO_STORE__CONNECTION_REQUEST_INFOS:
				((EStructuralFeature.Setting)getConnectionRequestInfos()).set(newValue);
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
			case SpiPackage.CONNECTION_REQUEST_INFO_STORE__CONNECTION_REQUEST_INFOS:
				getConnectionRequestInfos().clear();
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
			case SpiPackage.CONNECTION_REQUEST_INFO_STORE__CONNECTION_REQUEST_INFOS:
				return connectionRequestInfos != null && !connectionRequestInfos.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConnectionRequestInfoStoreImpl
