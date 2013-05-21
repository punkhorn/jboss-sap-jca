package org.jboss.jca.adapters.sap.spi.impl;

import org.jboss.jca.adapters.sap.model.edit.spi.ConnectionRequestInfoStoreEntryItemProvider;

public class ConnectionRequestInfoStoreEntryImpl extends
		ConnectionRequestInfoStoreEntryItemProvider {
	
	public ConnectionRequestInfoStoreEntryImpl() {
		super(SpiJcaAdapterFactory.INSTANCE);
	}

}
