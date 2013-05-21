package org.jboss.jca.adapters.sap.command;

import java.util.Collection;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.jca.adapters.sap.model.cci.MappedRecord;

public class RemoveValuesFromRecordCommand extends ChangeCommand {

	protected EditingDomain domain;
	protected MappedRecord owner;
	protected Collection<?> collection;
	
	public RemoveValuesFromRecordCommand(EditingDomain domain, MappedRecord owner, EStructuralFeature feature, Collection<?> collection) {
		super(owner);
		this.domain = domain;
		this.owner = owner;
		this.collection = collection;
	}

	@Override
	protected void doExecute() {
		for (Object obj: collection) {
			if (!(obj instanceof EStructuralFeature))
				continue;
			EStructuralFeature feature = (EStructuralFeature)obj;
			owner.eUnset(feature);
		}
	}

}
