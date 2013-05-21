package org.jboss.jca.adapters.sap.model.edit.spi;

import org.eclipse.emf.common.notify.Adapter;

public class SpiItemProviderAdapterFactory extends
org.jboss.jca.adapters.sap.model.spi.provider.SpiItemProviderAdapterFactory {

	public SpiItemProviderAdapterFactory() {
		super();
	}
	
	@Override
	public Adapter createConnectionRequestInfoEntryAdapter() {
		if (connectionRequestInfoEntryItemProvider == null) {
			connectionRequestInfoEntryItemProvider = new ConnectionRequestInfoEntryItemProvider(this);
		}

		return connectionRequestInfoEntryItemProvider;
	}
	
	@Override
	public Adapter createConnectionRequestInfoAdapter() {
		if (connectionRequestInfoItemProvider == null) {
			connectionRequestInfoItemProvider = new ConnectionRequestInfoItemProvider(this);
		}

		return connectionRequestInfoItemProvider;
	}

	@Override
	public Adapter createConnectionRequestInfoStoreEntryAdapter() {
		if (connectionRequestInfoStoreEntryItemProvider == null) {
			connectionRequestInfoStoreEntryItemProvider = new ConnectionRequestInfoStoreEntryItemProvider(this);
		}

		return connectionRequestInfoStoreEntryItemProvider;
	}
	
	@Override
	public Adapter createConnectionRequestInfoStoreAdapter() {
		return new ConnectionRequestInfoStoreItemProvider(this);
	}
	
	@Override
	public Adapter createManagedConnectionFactoryAdapter() {
		if (managedConnectionFactoryItemProvider == null) {
			managedConnectionFactoryItemProvider = new ManagedConnectionFactoryItemProvider(this);
		}

		return managedConnectionFactoryItemProvider;
	}

	@Override
	public Adapter createManagedConnectionAdapter() {
		if (managedConnectionItemProvider == null) {
			managedConnectionItemProvider = new ManagedConnectionItemProvider(this);
		}

		return managedConnectionItemProvider;
	}

	@Override
	public Adapter createPackageRegistryEntryAdapter() {
		if (packageRegistryEntryItemProvider == null) {
			packageRegistryEntryItemProvider = new PackageRegistryEntryItemProvider(this);
		}

		return packageRegistryEntryItemProvider;
	}

	@Override
	public Adapter createPackageRegistryAdapter() {
		if (packageRegistryItemProvider == null) {
			packageRegistryItemProvider = new PackageRegistryItemProvider(this);
		}

		return packageRegistryItemProvider;
	}

	@Override
	public Adapter createResourceAdapterAdapter() {
		if (resourceAdapterItemProvider == null) {
			resourceAdapterItemProvider = new ResourceAdapterItemProvider(this);
		}

		return resourceAdapterItemProvider;
	}

}
