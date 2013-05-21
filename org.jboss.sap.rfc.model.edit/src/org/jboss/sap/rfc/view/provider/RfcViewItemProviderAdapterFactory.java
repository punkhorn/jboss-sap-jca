package org.jboss.sap.rfc.view.provider;

import org.eclipse.emf.common.notify.Adapter;
import org.jboss.sap.rfc.provider.RfcItemProviderAdapterFactory;

public class RfcViewItemProviderAdapterFactory extends
		RfcItemProviderAdapterFactory {
	
	@Override
	public Adapter createFunctionAdapter() {
		if (functionItemProvider == null) {
			functionItemProvider = new RfcViewFunctionItemProvider(this);
		}

		return functionItemProvider;
	}
	
	@Override
	public Adapter createGroupAdapter() {
		if (groupItemProvider == null) {
			groupItemProvider = new RfcViewGroupItemProvider(this);
		}
		return groupItemProvider;
	}
	
	@Override
	public Adapter createRepositoryAdapter() {
		if (repositoryItemProvider == null) {
			repositoryItemProvider = new RfcViewRepositoryItemProvider(this);
		}
		return repositoryItemProvider;
	}

}
