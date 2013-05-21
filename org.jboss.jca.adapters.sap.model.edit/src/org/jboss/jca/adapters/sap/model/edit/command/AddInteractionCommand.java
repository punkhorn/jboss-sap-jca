package org.jboss.jca.adapters.sap.model.edit.command;

import java.util.Collection;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.jca.adapters.sap.model.cci.Connection;
import org.jboss.jca.adapters.sap.model.cci.Interaction;

public class AddInteractionCommand extends ChangeCommand {
	
	protected EditingDomain domain;
	protected Connection owner;
	protected EStructuralFeature feature;
	protected Collection<?> collection;
	
	public AddInteractionCommand(EditingDomain domain, Connection owner, EStructuralFeature feature, Collection<?> collection) {
		super(owner);
		this.domain = domain;
		this.owner = owner;
		this.feature = feature;
		this.collection = collection;
	}

	@Override
	protected void doExecute() {
		for (Object obj: collection) {
			Interaction interaction = (Interaction) obj;
			owner.getInteractions().remove(interaction);
		}
	}

}
