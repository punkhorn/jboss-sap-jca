/**
 */
package org.jboss.jca.adapters.sap.model.cci.impl;

import javax.naming.Reference;

import javax.resource.spi.ConnectionManager;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.jboss.jca.adapters.sap.model.cci.CciFactory;
import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.cci.ConnectionFactory;
import org.jboss.jca.adapters.sap.model.cci.RecordFactory;

import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Factory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionFactoryImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionFactoryImpl#getConnectionManager <em>Connection Manager</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionFactoryImpl#getRecordFactory <em>Record Factory</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionFactoryImpl#getManagedConnectionFactory <em>Managed Connection Factory</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionFactoryImpl extends EObjectImpl implements ConnectionFactory {
	/**
	 * The default value of the '{@link #getReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected static final Reference REFERENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected Reference reference = REFERENCE_EDEFAULT;

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
	 * The cached value of the '{@link #getRecordFactory() <em>Record Factory</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecordFactory()
	 * @generated
	 * @ordered
	 */
	protected RecordFactory recordFactory;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ConnectionFactoryImpl() {
		super();
		setRecordFactory(CciFactory.eINSTANCE.createRecordFactory());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CciPackage.Literals.CONNECTION_FACTORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference getReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(Reference newReference) {
		Reference oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_FACTORY__REFERENCE, oldReference, reference));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_FACTORY__CONNECTION_MANAGER, oldConnectionManager, connectionManager));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecordFactory getRecordFactory() {
		if (recordFactory != null && recordFactory.eIsProxy()) {
			InternalEObject oldRecordFactory = (InternalEObject)recordFactory;
			recordFactory = (RecordFactory)eResolveProxy(oldRecordFactory);
			if (recordFactory != oldRecordFactory) {
				InternalEObject newRecordFactory = (InternalEObject)recordFactory;
				NotificationChain msgs =  oldRecordFactory.eInverseRemove(this, CciPackage.RECORD_FACTORY__CONNECTION_FACTORY, RecordFactory.class, null);
				if (newRecordFactory.eInternalContainer() == null) {
					msgs =  newRecordFactory.eInverseAdd(this, CciPackage.RECORD_FACTORY__CONNECTION_FACTORY, RecordFactory.class, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CciPackage.CONNECTION_FACTORY__RECORD_FACTORY, oldRecordFactory, recordFactory));
			}
		}
		return recordFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecordFactory basicGetRecordFactory() {
		return recordFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRecordFactory(RecordFactory newRecordFactory, NotificationChain msgs) {
		RecordFactory oldRecordFactory = recordFactory;
		recordFactory = newRecordFactory;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_FACTORY__RECORD_FACTORY, oldRecordFactory, newRecordFactory);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecordFactory(RecordFactory newRecordFactory) {
		if (newRecordFactory != recordFactory) {
			NotificationChain msgs = null;
			if (recordFactory != null)
				msgs = ((InternalEObject)recordFactory).eInverseRemove(this, CciPackage.RECORD_FACTORY__CONNECTION_FACTORY, RecordFactory.class, msgs);
			if (newRecordFactory != null)
				msgs = ((InternalEObject)newRecordFactory).eInverseAdd(this, CciPackage.RECORD_FACTORY__CONNECTION_FACTORY, RecordFactory.class, msgs);
			msgs = basicSetRecordFactory(newRecordFactory, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_FACTORY__RECORD_FACTORY, newRecordFactory, newRecordFactory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedConnectionFactory getManagedConnectionFactory() {
		if (eContainerFeatureID() != CciPackage.CONNECTION_FACTORY__MANAGED_CONNECTION_FACTORY) return null;
		return (ManagedConnectionFactory)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedConnectionFactory basicGetManagedConnectionFactory() {
		if (eContainerFeatureID() != CciPackage.CONNECTION_FACTORY__MANAGED_CONNECTION_FACTORY) return null;
		return (ManagedConnectionFactory)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetManagedConnectionFactory(ManagedConnectionFactory newManagedConnectionFactory, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newManagedConnectionFactory, CciPackage.CONNECTION_FACTORY__MANAGED_CONNECTION_FACTORY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManagedConnectionFactory(ManagedConnectionFactory newManagedConnectionFactory) {
		if (newManagedConnectionFactory != eInternalContainer() || (eContainerFeatureID() != CciPackage.CONNECTION_FACTORY__MANAGED_CONNECTION_FACTORY && newManagedConnectionFactory != null)) {
			if (EcoreUtil.isAncestor(this, newManagedConnectionFactory))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newManagedConnectionFactory != null)
				msgs = ((InternalEObject)newManagedConnectionFactory).eInverseAdd(this, SpiPackage.MANAGED_CONNECTION_FACTORY__CONNECTION_FACTORIES, ManagedConnectionFactory.class, msgs);
			msgs = basicSetManagedConnectionFactory(newManagedConnectionFactory, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_FACTORY__MANAGED_CONNECTION_FACTORY, newManagedConnectionFactory, newManagedConnectionFactory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CciPackage.CONNECTION_FACTORY__RECORD_FACTORY:
				if (recordFactory != null)
					msgs = ((InternalEObject)recordFactory).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CciPackage.CONNECTION_FACTORY__RECORD_FACTORY, null, msgs);
				return basicSetRecordFactory((RecordFactory)otherEnd, msgs);
			case CciPackage.CONNECTION_FACTORY__MANAGED_CONNECTION_FACTORY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetManagedConnectionFactory((ManagedConnectionFactory)otherEnd, msgs);
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
			case CciPackage.CONNECTION_FACTORY__RECORD_FACTORY:
				return basicSetRecordFactory(null, msgs);
			case CciPackage.CONNECTION_FACTORY__MANAGED_CONNECTION_FACTORY:
				return basicSetManagedConnectionFactory(null, msgs);
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
			case CciPackage.CONNECTION_FACTORY__MANAGED_CONNECTION_FACTORY:
				return eInternalContainer().eInverseRemove(this, SpiPackage.MANAGED_CONNECTION_FACTORY__CONNECTION_FACTORIES, ManagedConnectionFactory.class, msgs);
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
			case CciPackage.CONNECTION_FACTORY__REFERENCE:
				return getReference();
			case CciPackage.CONNECTION_FACTORY__CONNECTION_MANAGER:
				return getConnectionManager();
			case CciPackage.CONNECTION_FACTORY__RECORD_FACTORY:
				if (resolve) return getRecordFactory();
				return basicGetRecordFactory();
			case CciPackage.CONNECTION_FACTORY__MANAGED_CONNECTION_FACTORY:
				if (resolve) return getManagedConnectionFactory();
				return basicGetManagedConnectionFactory();
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
			case CciPackage.CONNECTION_FACTORY__REFERENCE:
				setReference((Reference)newValue);
				return;
			case CciPackage.CONNECTION_FACTORY__CONNECTION_MANAGER:
				setConnectionManager((ConnectionManager)newValue);
				return;
			case CciPackage.CONNECTION_FACTORY__RECORD_FACTORY:
				setRecordFactory((RecordFactory)newValue);
				return;
			case CciPackage.CONNECTION_FACTORY__MANAGED_CONNECTION_FACTORY:
				setManagedConnectionFactory((ManagedConnectionFactory)newValue);
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
			case CciPackage.CONNECTION_FACTORY__REFERENCE:
				setReference(REFERENCE_EDEFAULT);
				return;
			case CciPackage.CONNECTION_FACTORY__CONNECTION_MANAGER:
				setConnectionManager(CONNECTION_MANAGER_EDEFAULT);
				return;
			case CciPackage.CONNECTION_FACTORY__RECORD_FACTORY:
				setRecordFactory((RecordFactory)null);
				return;
			case CciPackage.CONNECTION_FACTORY__MANAGED_CONNECTION_FACTORY:
				setManagedConnectionFactory((ManagedConnectionFactory)null);
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
			case CciPackage.CONNECTION_FACTORY__REFERENCE:
				return REFERENCE_EDEFAULT == null ? reference != null : !REFERENCE_EDEFAULT.equals(reference);
			case CciPackage.CONNECTION_FACTORY__CONNECTION_MANAGER:
				return CONNECTION_MANAGER_EDEFAULT == null ? connectionManager != null : !CONNECTION_MANAGER_EDEFAULT.equals(connectionManager);
			case CciPackage.CONNECTION_FACTORY__RECORD_FACTORY:
				return recordFactory != null;
			case CciPackage.CONNECTION_FACTORY__MANAGED_CONNECTION_FACTORY:
				return basicGetManagedConnectionFactory() != null;
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
		result.append(" (reference: ");
		result.append(reference);
		result.append(", connectionManager: ");
		result.append(connectionManager);
		result.append(')');
		return result.toString();
	}

} //ConnectionFactoryImpl
