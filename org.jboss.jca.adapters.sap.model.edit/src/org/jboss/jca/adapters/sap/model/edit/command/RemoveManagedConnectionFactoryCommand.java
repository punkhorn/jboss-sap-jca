package org.jboss.jca.adapters.sap.model.edit.command;

import java.util.Collection;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.model.spi.ResourceAdapter;

public class RemoveManagedConnectionFactoryCommand extends ChangeCommand {
	
	protected EditingDomain domain;
	protected ResourceAdapter owner;
	protected EStructuralFeature feature;
	protected Collection<?> collection;
	
	public RemoveManagedConnectionFactoryCommand(EditingDomain domain, ResourceAdapter owner, EStructuralFeature feature, Collection<?> collection) {
		super(owner);
		this.domain = domain;
		this.owner = owner;
		this.feature = feature;
		this.collection = collection;
	}

	@Override
	protected void doExecute() {
		for (Object obj: collection) {
			ManagedConnectionFactory mf = (ManagedConnectionFactory) obj;
			if(owner.getManagedConnectionFactories().remove(mf)) {
				owner.getConnectionRequestInfoStore().getConnectionRequestInfos().removeKey(mf.getDefaultConnectionName());
			}
		}
	}

}
