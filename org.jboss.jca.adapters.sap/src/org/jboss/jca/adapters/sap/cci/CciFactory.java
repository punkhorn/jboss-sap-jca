package org.jboss.jca.adapters.sap.cci;

public interface CciFactory {

	/**
	 * The singleton instance of the factory.
	 * 
	 * @generated
	 */
	CciFactory INSTANCE = org.jboss.jca.adapters.sap.cci.impl.CciFactoryImpl.INSTANCE;

	/**
	 * Returns a new {@link InteractionSpec} instance.
	 * 
	 * @return a new {@link InteractionSpec} instance..
	 */
	InteractionSpec createInteractionSpec();

	/**
	 * Returns a new {@link ConnectionSpec} instance.
	 * 
	 * @return a new {@link ConnectionSpec} instance..
	 */
	ConnectionSpec createConnectionSpec();
}
