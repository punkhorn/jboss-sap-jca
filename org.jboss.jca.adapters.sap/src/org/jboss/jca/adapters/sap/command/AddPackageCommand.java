package org.jboss.jca.adapters.sap.command;

import java.util.Collection;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.jca.adapters.sap.model.spi.PackageRegistry;

public class AddPackageCommand extends ChangeCommand {
	
	protected EditingDomain domain;
	protected PackageRegistry owner;
	protected EStructuralFeature feature;
	protected Collection<?> collection;

	public AddPackageCommand(EditingDomain domain, PackageRegistry owner, EStructuralFeature feature, Collection<?> collection) {
		super(owner);
		this.domain = domain;
		this.owner = owner;
		this.feature = feature;
		this.collection = collection;
}

	@Override
	protected void doExecute() {
		owner.getPackages().removeAll(collection);
	}

}
