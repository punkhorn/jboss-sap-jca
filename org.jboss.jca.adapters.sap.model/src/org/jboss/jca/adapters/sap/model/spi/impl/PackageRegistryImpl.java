/**
 */
package org.jboss.jca.adapters.sap.model.spi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.model.spi.PackageRegistry;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Registry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.PackageRegistryImpl#getPackages <em>Packages</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.PackageRegistryImpl#getManagedConnectionFactory <em>Managed Connection Factory</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageRegistryImpl extends EObjectImpl implements PackageRegistry {
	/**
	 * The cached value of the '{@link #getPackages() <em>Packages</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackages()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, EPackage> packages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageRegistryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpiPackage.Literals.PACKAGE_REGISTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, EPackage> getPackages() {
		if (packages == null) {
			packages = new EcoreEMap<String,EPackage>(SpiPackage.Literals.PACKAGE_REGISTRY_ENTRY, PackageRegistryEntryImpl.class, this, SpiPackage.PACKAGE_REGISTRY__PACKAGES);
		}
		return packages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedConnectionFactory getManagedConnectionFactory() {
		if (eContainerFeatureID() != SpiPackage.PACKAGE_REGISTRY__MANAGED_CONNECTION_FACTORY) return null;
		return (ManagedConnectionFactory)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedConnectionFactory basicGetManagedConnectionFactory() {
		if (eContainerFeatureID() != SpiPackage.PACKAGE_REGISTRY__MANAGED_CONNECTION_FACTORY) return null;
		return (ManagedConnectionFactory)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetManagedConnectionFactory(ManagedConnectionFactory newManagedConnectionFactory, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newManagedConnectionFactory, SpiPackage.PACKAGE_REGISTRY__MANAGED_CONNECTION_FACTORY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManagedConnectionFactory(ManagedConnectionFactory newManagedConnectionFactory) {
		if (newManagedConnectionFactory != eInternalContainer() || (eContainerFeatureID() != SpiPackage.PACKAGE_REGISTRY__MANAGED_CONNECTION_FACTORY && newManagedConnectionFactory != null)) {
			if (EcoreUtil.isAncestor(this, newManagedConnectionFactory))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newManagedConnectionFactory != null)
				msgs = ((InternalEObject)newManagedConnectionFactory).eInverseAdd(this, SpiPackage.MANAGED_CONNECTION_FACTORY__PACKAGE_REGISTRY, ManagedConnectionFactory.class, msgs);
			msgs = basicSetManagedConnectionFactory(newManagedConnectionFactory, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpiPackage.PACKAGE_REGISTRY__MANAGED_CONNECTION_FACTORY, newManagedConnectionFactory, newManagedConnectionFactory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpiPackage.PACKAGE_REGISTRY__MANAGED_CONNECTION_FACTORY:
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
			case SpiPackage.PACKAGE_REGISTRY__PACKAGES:
				return ((InternalEList<?>)getPackages()).basicRemove(otherEnd, msgs);
			case SpiPackage.PACKAGE_REGISTRY__MANAGED_CONNECTION_FACTORY:
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
			case SpiPackage.PACKAGE_REGISTRY__MANAGED_CONNECTION_FACTORY:
				return eInternalContainer().eInverseRemove(this, SpiPackage.MANAGED_CONNECTION_FACTORY__PACKAGE_REGISTRY, ManagedConnectionFactory.class, msgs);
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
			case SpiPackage.PACKAGE_REGISTRY__PACKAGES:
				if (coreType) return getPackages();
				else return getPackages().map();
			case SpiPackage.PACKAGE_REGISTRY__MANAGED_CONNECTION_FACTORY:
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
			case SpiPackage.PACKAGE_REGISTRY__PACKAGES:
				((EStructuralFeature.Setting)getPackages()).set(newValue);
				return;
			case SpiPackage.PACKAGE_REGISTRY__MANAGED_CONNECTION_FACTORY:
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
			case SpiPackage.PACKAGE_REGISTRY__PACKAGES:
				getPackages().clear();
				return;
			case SpiPackage.PACKAGE_REGISTRY__MANAGED_CONNECTION_FACTORY:
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
			case SpiPackage.PACKAGE_REGISTRY__PACKAGES:
				return packages != null && !packages.isEmpty();
			case SpiPackage.PACKAGE_REGISTRY__MANAGED_CONNECTION_FACTORY:
				return basicGetManagedConnectionFactory() != null;
		}
		return super.eIsSet(featureID);
	}

} //PackageRegistryImpl
