package org.jboss.jca.adapters.sap.command;

import java.util.Collection;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnection;

public class DissociateConnectionsFromManagedConnectionCommand extends ChangeCommand {
	
	protected EditingDomain domain;
	protected ManagedConnection owner;

	public DissociateConnectionsFromManagedConnectionCommand(EditingDomain domain, ManagedConnection owner, EStructuralFeature feature, Collection<?> collection) {
		super(owner);
		this.domain = domain;
		this.owner = owner;
	}

	@Override
	protected void doExecute() {
		owner.getConnectionHandles().clear();
	}

}
