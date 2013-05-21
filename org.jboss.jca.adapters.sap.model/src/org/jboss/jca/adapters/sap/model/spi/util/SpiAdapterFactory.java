/**
 */
package org.jboss.jca.adapters.sap.model.spi.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.EPackage;
import org.jboss.jca.adapters.sap.model.spi.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage
 * @generated
 */
public class SpiAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SpiPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpiAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SpiPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpiSwitch<Adapter> modelSwitch =
		new SpiSwitch<Adapter>() {
			@Override
			public Adapter caseConnectionRequestInfo(ConnectionRequestInfo object) {
				return createConnectionRequestInfoAdapter();
			}
			@Override
			public Adapter caseConnectionRequestInfoEntry(Map.Entry<String, String> object) {
				return createConnectionRequestInfoEntryAdapter();
			}
			@Override
			public Adapter caseConnectionRequestInfoStore(ConnectionRequestInfoStore object) {
				return createConnectionRequestInfoStoreAdapter();
			}
			@Override
			public Adapter caseConnectionRequestInfoStoreEntry(Map.Entry<String, ConnectionRequestInfo> object) {
				return createConnectionRequestInfoStoreEntryAdapter();
			}
			@Override
			public Adapter caseManagedConnectionFactory(ManagedConnectionFactory object) {
				return createManagedConnectionFactoryAdapter();
			}
			@Override
			public Adapter caseManagedConnection(ManagedConnection object) {
				return createManagedConnectionAdapter();
			}
			@Override
			public Adapter caseResourceAdapter(ResourceAdapter object) {
				return createResourceAdapterAdapter();
			}
			@Override
			public Adapter casePackageRegistry(PackageRegistry object) {
				return createPackageRegistryAdapter();
			}
			@Override
			public Adapter casePackageRegistryEntry(Map.Entry<String, EPackage> object) {
				return createPackageRegistryEntryAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo <em>Connection Request Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo
	 * @generated
	 */
	public Adapter createConnectionRequestInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Connection Request Info Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createConnectionRequestInfoEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfoStore <em>Connection Request Info Store</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfoStore
	 * @generated
	 */
	public Adapter createConnectionRequestInfoStoreAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Connection Request Info Store Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createConnectionRequestInfoStoreEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory <em>Managed Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory
	 * @generated
	 */
	public Adapter createManagedConnectionFactoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection <em>Managed Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnection
	 * @generated
	 */
	public Adapter createManagedConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.model.spi.ResourceAdapter <em>Resource Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.model.spi.ResourceAdapter
	 * @generated
	 */
	public Adapter createResourceAdapterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.model.spi.PackageRegistry <em>Package Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.model.spi.PackageRegistry
	 * @generated
	 */
	public Adapter createPackageRegistryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Package Registry Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createPackageRegistryEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SpiAdapterFactory
