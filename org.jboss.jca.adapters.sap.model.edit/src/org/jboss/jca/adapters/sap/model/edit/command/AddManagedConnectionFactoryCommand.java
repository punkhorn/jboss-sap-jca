package org.jboss.jca.adapters.sap.model.edit.command;

import java.util.Collection;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.model.spi.ResourceAdapter;

public class AddManagedConnectionFactoryCommand extends ChangeCommand {
	
	protected EditingDomain domain;
	protected ResourceAdapter owner;
	protected EStructuralFeature feature;
	protected Collection<?> collection;
	
	public AddManagedConnectionFactoryCommand(EditingDomain domain, ResourceAdapter owner, EStructuralFeature feature, Collection<?> collection) {
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
			owner.getManagedConnectionFactories().add(mf);
			owner.getConnectionRequestInfoStore().getConnectionRequestInfos().put(mf.getDefaultConnectionName(), mf.getDefaultConnectionRequestInfo());
		}
	}

}
