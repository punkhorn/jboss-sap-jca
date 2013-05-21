package org.jboss.jca.adapters.sap.command;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.jca.adapters.sap.model.cci.IndexedRecord;

public class RemoveAtIndexFromIndexedRecordCommand extends ChangeCommand {

	protected EditingDomain domain;
	@SuppressWarnings("rawtypes")
	protected IndexedRecord owner;
	protected int index;
	
	public RemoveAtIndexFromIndexedRecordCommand(EditingDomain domain, @SuppressWarnings("rawtypes") IndexedRecord owner, EStructuralFeature feature, int index) {
		super(owner);
		this.domain = domain;
		this.owner = owner;
		this.index = index;
	}

	@Override
	protected void doExecute() {
			owner.getRecords().remove(index);
	}

}
