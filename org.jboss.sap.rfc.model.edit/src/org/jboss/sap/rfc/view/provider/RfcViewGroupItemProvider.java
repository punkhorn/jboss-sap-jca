package org.jboss.sap.rfc.view.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.jboss.sap.rfc.Function;
import org.jboss.sap.rfc.Group;
import org.jboss.sap.rfc.Repository;
import org.jboss.sap.rfc.provider.GroupItemProvider;
import org.jboss.sap.rfc.util.RfcUtil;

public class RfcViewGroupItemProvider extends GroupItemProvider {

	public RfcViewGroupItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		String label = ((Group)object).getName();
		return label == null || label.length() == 0 ? getString("_UI_Group_type") :	label;
	}

	@Override
	public Collection<?> getChildren(Object object) {
		Group group = (Group) object;
		Repository repository = group.getRepository();
		if ((repository != null) && (group.getFunctions().size() == 0)) {
			try {
				List<Function> functions = RfcUtil.getFunctions(repository.getDestinationName(), "*", group.getName());
				group.getFunctions().addAll(functions);
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
