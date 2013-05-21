package org.jboss.jca.adapters.sap.command;

import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.jca.adapters.sap.model.cci.Connection;
import org.jboss.jca.adapters.sap.model.cci.ConnectionState;

public class CloseConnectionCommand extends ChangeCommand {

	protected EditingDomain domain;
	protected Connection owner;

	public CloseConnectionCommand(EditingDomain domain, Connection owner) {
		super(owner);
		this.domain = domain;
		this.owner = owner;
	}

	@Override
	protected void doExecute() {
		owner.setState(ConnectionState.CLOSED);
		owner.setConnectionName(null);
		owner.setConnectionRequestInfo(null);
	}

}
