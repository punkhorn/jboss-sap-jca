package org.jboss.jca.adapters.sap.model.edit.command;

import java.util.Collection;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.jca.adapters.sap.model.cci.Execution;
import org.jboss.jca.adapters.sap.model.cci.Interaction;

public class RemoveExecutionCommand extends ChangeCommand {
	
	protected EditingDomain domain;
	protected Interaction owner;
	protected EStructuralFeature feature;
	protected Collection<?> collection;
	protected String functionModuleName;
	
	public RemoveExecutionCommand(EditingDomain domain, Interaction owner, EStructuralFeature feature, Collection<?> collection) {
		super(owner);
		this.domain = domain;
		this.owner = owner;
		this.feature = feature;
		this.collection = collection;
	}

	@Override
	protected void doExecute() {
		for (Object obj: collection) {
			Execution execution = (Execution) obj;
			owner.getExecutions().remove(execution);
		}
	}

}
