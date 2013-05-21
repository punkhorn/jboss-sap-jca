package org.jboss.sap.rfc.view.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.jboss.sap.rfc.Repository;
import org.jboss.sap.rfc.provider.RepositoryItemProvider;

public class RfcViewRepositoryItemProvider extends RepositoryItemProvider {

	public RfcViewRepositoryItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		String label = ((Repository)object).getName();
		return label == null || label.length() == 0 ? getString("_UI_Repository_type") : label;
	}
}
