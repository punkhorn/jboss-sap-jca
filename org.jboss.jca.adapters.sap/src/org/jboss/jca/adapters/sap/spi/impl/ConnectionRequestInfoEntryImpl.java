package org.jboss.jca.adapters.sap.spi.impl;

import org.jboss.jca.adapters.sap.model.edit.spi.ConnectionRequestInfoEntryItemProvider;

public class ConnectionRequestInfoEntryImpl extends
		ConnectionRequestInfoEntryItemProvider {
	
	public ConnectionRequestInfoEntryImpl() {
		super(SpiJcaAdapterFactory.INSTANCE);
	}

}
