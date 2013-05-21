package org.jboss.jca.adapters.sap.model.edit.command;

import java.util.Collection;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnection;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.model.spi.ResourceAdapter;

public class AddManagedConnectionCommand extends ChangeCommand {
	
	protected EditingDomain domain;
	protected ManagedConnectionFactory owner;
	protected EStructuralFeature feature;
	protected Collection<?> collection;
	
	public AddManagedConnectionCommand(EditingDomain domain, ManagedConnectionFactory owner, EStructuralFeature feature, Collection<?> collection) {
		super(owner);
		this.domain = domain;
		this.owner = owner;
		this.feature = feature;
		this.collection = collection;
	}

	@Override
	protected void doExecute() {
		for (Object obj: collection) {
			ManagedConnection managedConnection = (ManagedConnection) obj;
			owner.getManagedConnections().add(managedConnection);
			ResourceAdapter resourceAdapter = owner.getResourceAdapter();
			resourceAdapter.getConnectionRequestInfoStore().getConnectionRequestInfos().put(managedConnection.getConnectionName(), managedConnection.getConnectionRequestInfo());
		}
	}

}
