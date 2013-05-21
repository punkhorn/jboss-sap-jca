package org.jboss.sap.rfc.view.provider;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.jboss.sap.rfc.Function;
import org.jboss.sap.rfc.Repository;
import org.jboss.sap.rfc.Structure;
import org.jboss.sap.rfc.provider.FunctionItemProvider;
import org.jboss.sap.rfc.util.RfcUtil;

public class RfcViewFunctionItemProvider extends FunctionItemProvider {

	public RfcViewFunctionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		String label = ((Function)object).getName();
		return label == null || label.length() == 0 ? getString("_UI_Function_type") : label;
	}

	@Override
	public Collection<?> getChildren(Object object) {
		Function function = (Function) object;
		Repository repository = function.getGroup().getRepository();
		if ((repository != null)) {
			try {
				Structure request = RfcUtil.getRequest(repository.getDestinationName(), function.getName());
				function.setRequest(request);
				Structure response = RfcUtil.getResponse(repository.getDestinationName(), function.getName());
				function.setResponse(response);
			} catch (Exception e) {
			}
		}
		return super.getChildren(object);
	}

	@Override
	public boolean hasChildren(Object object) {
		return true;
	}
}
