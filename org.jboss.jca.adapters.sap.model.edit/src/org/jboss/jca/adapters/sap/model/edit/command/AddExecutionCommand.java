package org.jboss.jca.adapters.sap.model.edit.command;

import java.util.Collection;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.jca.adapters.sap.model.cci.CciFactory;
import org.jboss.jca.adapters.sap.model.cci.Execution;
import org.jboss.jca.adapters.sap.model.cci.Interaction;
import org.jboss.jca.adapters.sap.model.cci.InteractionSpec;

public class AddExecutionCommand extends ChangeCommand {
	
	protected EditingDomain domain;
	protected Interaction owner;
	protected EStructuralFeature feature;
	protected Collection<?> collection;
	protected String functionModuleName;
	
	public AddExecutionCommand(EditingDomain domain, Interaction owner, EStructuralFeature feature, Collection<?> collection) {
		super(owner);
		this.domain = domain;
		this.owner = owner;
		this.feature = feature;
		this.collection = collection;
	}

	public String getFunctionModuleName() {
		return functionModuleName;
	}

	public void setFunctionModuleName(String functionModuleName) {
		this.functionModuleName = functionModuleName;
	}
	
	@Override
	protected void doExecute() {
		if (functionModuleName == null)
			return;
		for (Object obj: collection) {
			Execution execution = (Execution) obj;
			owner.getExecutions().add(execution);
			InteractionSpec interactionSpec = CciFactory.eINSTANCE.createInteractionSpec();
			interactionSpec.setFunctionName(functionModuleName);
			execution.setInteractionSpec(interactionSpec);
		}
	}

}
