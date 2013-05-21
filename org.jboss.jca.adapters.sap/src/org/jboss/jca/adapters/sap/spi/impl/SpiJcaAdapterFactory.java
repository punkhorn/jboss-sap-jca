package org.jboss.jca.adapters.sap.spi.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.jboss.jca.adapters.sap.model.edit.spi.SpiItemProviderAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support JCA
 * @author William Collins
 *
 */
public class SpiJcaAdapterFactory extends SpiItemProviderAdapterFactory {
	
	public static final SpiJcaAdapterFactory INSTANCE = new SpiJcaAdapterFactory();
	
	private SpiJcaAdapterFactory() {
		super();
		supportedTypes.add(org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo.class);
		supportedTypes.add(org.jboss.jca.adapters.sap.spi.ConnectionRequestInfoStore.class);
		supportedTypes.add(org.jboss.jca.adapters.sap.spi.ManagedConnection.class);
		supportedTypes.add(org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory.class);
		supportedTypes.add(org.jboss.jca.adapters.sap.spi.NonManagedEnvironmentAdmin.class);
		supportedTypes.add(org.jboss.jca.adapters.sap.spi.ResourceAdapter.class);
	}

	/**
	 * This creates an adapter for a {@link org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo}.
	 */
	@Override
	public Adapter createConnectionRequestInfoAdapter() {
		return new ConnectionRequestInfoImpl();
	}

	/**
	 * This creates an adapter for a {@link org.jboss.jca.adapters.sap.spi.ConnectionRequestInfoStore}.
	 */
	public Adapter createConnectionRequestInfoStoreAdapter() {
		return new ConnectionRequestInfoStoreImpl();
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
		return new ManagedConnectionFactoryImpl();
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
		return new ManagedConnectionImpl();
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
		return new ResourceAdapterImpl();
	}
	
	@Override
	public Adapter createConnectionRequestInfoEntryAdapter() {
		return new ConnectionRequestInfoEntryImpl();
	}
	
	@Override
	public Adapter createConnectionRequestInfoStoreEntryAdapter() {
		return new ConnectionRequestInfoStoreEntryImpl();
	}
	
	@Override
	public Adapter createPackageRegistryAdapter() {
		return new PackageRegistryImpl();
	}
	
	@Override
	public Adapter createPackageRegistryEntryAdapter() {
		return new PackageRegistryEntryImpl();
	}

}
