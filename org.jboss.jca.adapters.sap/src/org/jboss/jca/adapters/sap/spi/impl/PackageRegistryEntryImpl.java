package org.jboss.jca.adapters.sap.spi.impl;

import org.jboss.jca.adapters.sap.model.spi.provider.PackageRegistryEntryItemProvider;

public class PackageRegistryEntryImpl extends PackageRegistryEntryItemProvider {
	
	public PackageRegistryEntryImpl() {
		super(SpiJcaAdapterFactory.INSTANCE);
	}

}
