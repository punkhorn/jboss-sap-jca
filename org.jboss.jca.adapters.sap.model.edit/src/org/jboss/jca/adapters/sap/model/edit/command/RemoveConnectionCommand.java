package org.jboss.jca.adapters.sap.model.edit.command;

import java.util.Collection;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.jca.adapters.sap.model.cci.Connection;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnection;

public class RemoveConnectionCommand extends ChangeCommand {
	
	protected EditingDomain domain;
	protected ManagedConnection owner;
	protected EStructuralFeature feature;
	protected Collection<?> collection;
	
	public RemoveConnectionCommand(EditingDomain domain, ManagedConnection owner, EStructuralFeature feature, Collection<?> collection) {
		super(owner);
		this.domain = domain;
		this.owner = owner;
		this.feature = feature;
		this.collection = collection;
	}

	@Override
	protected void doExecute() {
		for (Object obj: collection) {
			Connection connection = (Connection) obj;
			owner.getConnectionHandles().remove(connection);
			connection.setConnectionName(null);
		}
	}

}
