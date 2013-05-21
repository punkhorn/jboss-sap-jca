package org.jboss.jca.adapters.sap.cci.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.jboss.jca.adapters.sap.model.edit.cci.CciItemProviderAdapterFactory;

public class CciJcaAdapterFactory extends CciItemProviderAdapterFactory {

	public static final CciJcaAdapterFactory INSTANCE = new CciJcaAdapterFactory();

	private CciJcaAdapterFactory() {
		super();
		supportedTypes.add(org.jboss.jca.adapters.sap.cci.Connection.class);
		supportedTypes.add(org.jboss.jca.adapters.sap.cci.ConnectionFactory.class);
		supportedTypes.add(org.jboss.jca.adapters.sap.cci.ConnectionSpec.class);
		supportedTypes.add(org.jboss.jca.adapters.sap.cci.Execution.class);
		supportedTypes.add(org.jboss.jca.adapters.sap.cci.IndexedRecord.class);
		supportedTypes.add(org.jboss.jca.adapters.sap.cci.Interaction.class);
		supportedTypes.add(org.jboss.jca.adapters.sap.cci.InteractionSpec.class);
		supportedTypes.add(org.jboss.jca.adapters.sap.cci.MappedRecord.class);
		supportedTypes.add(org.jboss.jca.adapters.sap.cci.Record.class);
		supportedTypes.add(org.jboss.jca.adapters.sap.cci.RecordFactory.class);
	}

	/**
	 * Overridden to support dynamic MappedRecord and IndexedRecord types.
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		if ((type instanceof org.jboss.jca.adapters.sap.model.cci.MappedRecord)
				|| (type instanceof org.jboss.jca.adapters.sap.model.cci.IndexedRecord<?>))
			return true;
		return super.isFactoryForType(type);
	}

	@Override
	public Adapter createConnectionAdapter() {
		return new ConnectionImpl();
	}

	@Override
	public Adapter createConnectionFactoryAdapter() {
		return new ConnectionFactoryImpl();
	}

	@Override
	public Adapter createConnectionSpecAdapter() {
		return new ConnectionSpecImpl();
	}

	@Override
	public Adapter createExecutionAdapter() {
		return new ExecutionImpl();
	}

	@Override
	public Adapter createIndexedRecordAdapter() {
		return new IndexedRecordImpl();
	}

	@Override
	public Adapter createInteractionAdapter() {
		return new InteractionImpl();
	}

	@Override
	public Adapter createInteractionSpecAdapter() {
		return new InteractionSpecImpl();
	}

	@Override
	public Adapter createMappedRecordAdapter() {
		return new MappedRecordImpl();
	}

	@Override
	public Adapter createRecordFactoryAdapter() {
		return new RecordFactoryImpl();
	}

}
