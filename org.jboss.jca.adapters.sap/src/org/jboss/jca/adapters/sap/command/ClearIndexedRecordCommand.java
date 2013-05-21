package org.jboss.jca.adapters.sap.command;

import java.util.Collection;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.jca.adapters.sap.model.cci.IndexedRecord;

public class ClearIndexedRecordCommand extends ChangeCommand {

	protected EditingDomain domain;
	@SuppressWarnings("rawtypes")
	protected IndexedRecord owner;
	protected Collection<?> collection;
	
	public ClearIndexedRecordCommand(EditingDomain domain, @SuppressWarnings("rawtypes") IndexedRecord owner, EStructuralFeature feature, Collection<?> collection) {
		super(owner);
		this.domain = domain;
		this.owner = owner;
		this.collection = collection;
	}

	@Override
	protected void doExecute() {
		owner.getRecords().clear();
	}

}
