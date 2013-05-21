/**
 */
package org.jboss.jca.adapters.sap.model.cci.impl;

import java.util.Collection;
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
import org.jboss.jca.adapters.sap.model.cci.ConnectionFactory;
import org.jboss.jca.adapters.sap.model.cci.IndexedRecord;
import org.jboss.jca.adapters.sap.model.cci.MappedRecord;
import org.jboss.jca.adapters.sap.model.cci.RecordFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Record Factory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.RecordFactoryImpl#getConnectionFactory <em>Connection Factory</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.RecordFactoryImpl#getIndexedRecords <em>Indexed Records</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.RecordFactoryImpl#getMappedRecords <em>Mapped Records</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RecordFactoryImpl extends EObjectImpl implements RecordFactory {
	/**
	 * The cached value of the '{@link #getIndexedRecords() <em>Indexed Records</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexedRecords()
	 * @generated
	 * @ordered
	 */
	protected EList<IndexedRecord<?>> indexedRecords;
	/**
	 * The cached value of the '{@link #getMappedRecords() <em>Mapped Records</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappedRecords()
	 * @generated
	 * @ordered
	 */
	protected EList<MappedRecord> mappedRecords;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecordFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CciPackage.Literals.RECORD_FACTORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionFactory getConnectionFactory() {
		if (eContainerFeatureID() != CciPackage.RECORD_FACTORY__CONNECTION_FACTORY) return null;
		return (ConnectionFactory)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionFactory basicGetConnectionFactory() {
		if (eContainerFeatureID() != CciPackage.RECORD_FACTORY__CONNECTION_FACTORY) return null;
		return (ConnectionFactory)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConnectionFactory(ConnectionFactory newConnectionFactory, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConnectionFactory, CciPackage.RECORD_FACTORY__CONNECTION_FACTORY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionFactory(ConnectionFactory newConnectionFactory) {
		if (newConnectionFactory != eInternalContainer() || (eContainerFeatureID() != CciPackage.RECORD_FACTORY__CONNECTION_FACTORY && newConnectionFactory != null)) {
			if (EcoreUtil.isAncestor(this, newConnectionFactory))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConnectionFactory != null)
				msgs = ((InternalEObject)newConnectionFactory).eInverseAdd(this, CciPackage.CONNECTION_FACTORY__RECORD_FACTORY, ConnectionFactory.class, msgs);
			msgs = basicSetConnectionFactory(newConnectionFactory, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.RECORD_FACTORY__CONNECTION_FACTORY, newConnectionFactory, newConnectionFactory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IndexedRecord<?>> getIndexedRecords() {
		if (indexedRecords == null) {
			indexedRecords = new EObjectContainmentEList.Resolving<IndexedRecord<?>>(IndexedRecord.class, this, CciPackage.RECORD_FACTORY__INDEXED_RECORDS);
		}
		return indexedRecords;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappedRecord> getMappedRecords() {
		if (mappedRecords == null) {
			mappedRecords = new EObjectContainmentEList.Resolving<MappedRecord>(MappedRecord.class, this, CciPackage.RECORD_FACTORY__MAPPED_RECORDS);
		}
		return mappedRecords;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CciPackage.RECORD_FACTORY__CONNECTION_FACTORY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConnectionFactory((ConnectionFactory)otherEnd, msgs);
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
			case CciPackage.RECORD_FACTORY__CONNECTION_FACTORY:
				return basicSetConnectionFactory(null, msgs);
			case CciPackage.RECORD_FACTORY__INDEXED_RECORDS:
				return ((InternalEList<?>)getIndexedRecords()).basicRemove(otherEnd, msgs);
			case CciPackage.RECORD_FACTORY__MAPPED_RECORDS:
				return ((InternalEList<?>)getMappedRecords()).basicRemove(otherEnd, msgs);
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
			case CciPackage.RECORD_FACTORY__CONNECTION_FACTORY:
				return eInternalContainer().eInverseRemove(this, CciPackage.CONNECTION_FACTORY__RECORD_FACTORY, ConnectionFactory.class, msgs);
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
			case CciPackage.RECORD_FACTORY__CONNECTION_FACTORY:
				if (resolve) return getConnectionFactory();
				return basicGetConnectionFactory();
			case CciPackage.RECORD_FACTORY__INDEXED_RECORDS:
				return getIndexedRecords();
			case CciPackage.RECORD_FACTORY__MAPPED_RECORDS:
				return getMappedRecords();
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
			case CciPackage.RECORD_FACTORY__CONNECTION_FACTORY:
				setConnectionFactory((ConnectionFactory)newValue);
				return;
			case CciPackage.RECORD_FACTORY__INDEXED_RECORDS:
				getIndexedRecords().clear();
				getIndexedRecords().addAll((Collection<? extends IndexedRecord<?>>)newValue);
				return;
			case CciPackage.RECORD_FACTORY__MAPPED_RECORDS:
				getMappedRecords().clear();
				getMappedRecords().addAll((Collection<? extends MappedRecord>)newValue);
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
			case CciPackage.RECORD_FACTORY__CONNECTION_FACTORY:
				setConnectionFactory((ConnectionFactory)null);
				return;
			case CciPackage.RECORD_FACTORY__INDEXED_RECORDS:
				getIndexedRecords().clear();
				return;
			case CciPackage.RECORD_FACTORY__MAPPED_RECORDS:
				getMappedRecords().clear();
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
			case CciPackage.RECORD_FACTORY__CONNECTION_FACTORY:
				return basicGetConnectionFactory() != null;
			case CciPackage.RECORD_FACTORY__INDEXED_RECORDS:
				return indexedRecords != null && !indexedRecords.isEmpty();
			case CciPackage.RECORD_FACTORY__MAPPED_RECORDS:
				return mappedRecords != null && !mappedRecords.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RecordFactoryImpl
