package org.jboss.jca.adapters.sap.command;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.jca.adapters.sap.model.cci.CciFactory;
import org.jboss.jca.adapters.sap.model.cci.Execution;
import org.jboss.jca.adapters.sap.model.cci.Interaction;
import org.jboss.jca.adapters.sap.model.cci.InteractionSpec;
import org.jboss.jca.adapters.sap.model.cci.MappedRecord;

public class AddExecutionCommand extends ChangeCommand {

	protected EditingDomain domain;
	protected Interaction owner;
	protected InteractionSpec interactionSpec;
	protected MappedRecord inputRecord;
	protected MappedRecord outputRecord;

	public AddExecutionCommand(EditingDomain domain, Interaction owner, InteractionSpec interactionSpec,
			MappedRecord inputRecord, MappedRecord outputRecord) {
		super(owner);
		this.domain = domain;
		this.owner = owner;
		this.interactionSpec = interactionSpec;
		this.inputRecord = inputRecord;
		this.outputRecord = outputRecord;
	}

	@Override
	protected void doExecute() {
		Execution execution = CciFactory.eINSTANCE.createExecution();
		execution.setInteractionSpec(EcoreUtil.copy(interactionSpec));
		execution.setInputRecord(EcoreUtil.copy(inputRecord));
		execution.setOutputRecord(EcoreUtil.copy(outputRecord));
		owner.getExecutions().add(execution);
	}

}
