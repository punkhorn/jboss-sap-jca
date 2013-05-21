package org.jboss.jca.adapters.sap.cci.impl;

import org.jboss.jca.adapters.sap.cci.CciFactory;
import org.jboss.jca.adapters.sap.cci.ConnectionSpec;
import org.jboss.jca.adapters.sap.cci.InteractionSpec;

public enum CciFactoryImpl implements CciFactory {
	INSTANCE;
	
	@Override
	public InteractionSpec createInteractionSpec() {
		return new InteractionSpecImpl();
	}

	@Override
	public ConnectionSpec createConnectionSpec() {
		return new ConnectionSpecImpl();
	}

}
