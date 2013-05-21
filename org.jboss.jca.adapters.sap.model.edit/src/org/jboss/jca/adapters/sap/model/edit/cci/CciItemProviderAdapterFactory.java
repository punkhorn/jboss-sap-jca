package org.jboss.jca.adapters.sap.model.edit.cci;

import org.eclipse.emf.common.notify.Adapter;

public class CciItemProviderAdapterFactory extends
org.jboss.jca.adapters.sap.model.cci.provider.CciItemProviderAdapterFactory {

	public CciItemProviderAdapterFactory() {
		super();
	}

	@Override
	public Adapter createConnectionFactoryAdapter() {
		if (connectionFactoryItemProvider == null) {
			connectionFactoryItemProvider = new ConnectionFactoryItemProvider(this);
		}

		return connectionFactoryItemProvider;
	}

	@Override
	public Adapter createConnectionAdapter() {
		if (connectionItemProvider == null) {
			connectionItemProvider = new ConnectionItemProvider(this);
		}

		return connectionItemProvider;
	}

	@Override
	public Adapter createConnectionSpecAdapter() {
		if (connectionSpecItemProvider == null) {
			connectionSpecItemProvider = new ConnectionSpecItemProvider(this);
		}

		return connectionSpecItemProvider;
	}

	@Override
	public Adapter createInteractionAdapter() {
		if (interactionItemProvider == null) {
			interactionItemProvider = new InteractionItemProvider(this);
		}

		return interactionItemProvider;
	}

	@Override
	public Adapter createInteractionSpecAdapter() {
		if (interactionSpecItemProvider == null) {
			interactionSpecItemProvider = new InteractionSpecItemProvider(this);
		}

		return interactionSpecItemProvider;
	}

	@Override
	public Adapter createRecordFactoryAdapter() {
		if (recordFactoryItemProvider == null) {
			recordFactoryItemProvider = new RecordFactoryItemProvider(this);
		}

		return recordFactoryItemProvider;
	}

	@Override
	public Adapter createExecutionAdapter() {
		if (executionItemProvider == null) {
			executionItemProvider = new ExecutionItemProvider(this);
		}

		return executionItemProvider;
	}

}
