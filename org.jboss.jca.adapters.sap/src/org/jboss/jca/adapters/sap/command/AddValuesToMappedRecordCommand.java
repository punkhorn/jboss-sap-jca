package org.jboss.jca.adapters.sap.command;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.jca.adapters.sap.model.cci.MappedRecord;

public class AddValuesToMappedRecordCommand extends ChangeCommand {

	protected EditingDomain domain;
	protected MappedRecord owner;
	protected Collection<?> collection;
	
	public AddValuesToMappedRecordCommand(EditingDomain domain, MappedRecord owner, EStructuralFeature feature, Collection<?> collection) {
		super(owner);
		this.domain = domain;
		this.owner = owner;
		this.collection = collection;
	}

	@Override
	protected void doExecute() {
		if (!(collection instanceof Map)) {
			return;
		}
		Map<?,?> map = (Map<?,?>) collection; 
		for (Map.Entry<?,?> entry: map.entrySet()) {

			if (!(entry.getKey() instanceof String))
				continue;

			EStructuralFeature feature = owner.eClass().getEStructuralFeature((String)entry.getKey());
			if (feature == null) 
				continue;

			try {
				owner.eSet(feature, entry.getValue());
			} catch (Exception e) {
				// ignore
			}
		}
	}

}
