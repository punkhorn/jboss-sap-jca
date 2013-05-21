package org.jboss.jca.adapters.sap.model.edit.spi;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.jca.adapters.sap.model.edit.command.AddManagedConnectionFactoryCommand;
import org.jboss.jca.adapters.sap.model.edit.command.RemoveManagedConnectionFactoryCommand;
import org.jboss.jca.adapters.sap.model.spi.ResourceAdapter;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;

public class ResourceAdapterItemProvider
		extends
		org.jboss.jca.adapters.sap.model.spi.provider.ResourceAdapterItemProvider {

	public ResourceAdapterItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * Overridden to provide custom add command.
	 */
	@Override
	protected Command createAddCommand(EditingDomain domain, final EObject owner,
			EStructuralFeature feature, final Collection<?> collection, int index) {
	if (feature == SpiPackage.Literals.RESOURCE_ADAPTER__MANAGED_CONNECTION_FACTORIES) {
			return new AddManagedConnectionFactoryCommand(domain, (ResourceAdapter) owner, feature, collection);
		}
		return super.createAddCommand(domain, owner, feature, collection, index);
	}
	
	/**
	 * Overridden to provide custom remove command.
	 */
	@Override
	protected Command createRemoveCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Collection<?> collection) {
		if (feature == SpiPackage.Literals.RESOURCE_ADAPTER__MANAGED_CONNECTION_FACTORIES) {
			return new RemoveManagedConnectionFactoryCommand(domain, (ResourceAdapter) owner, feature, collection);
		}
		return super.createRemoveCommand(domain, owner, feature, collection);
	}

	/**
	 * Overridden to provide custom set command.
	 */
	@Override
	protected Command createSetCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Object value) {
		
		// Prevent the connection request info store from being deleted or replaced.
		if (feature == SpiPackage.Literals.RESOURCE_ADAPTER__CONNECTION_REQUEST_INFO_STORE) {
			return UnexecutableCommand.INSTANCE;
		}
		return super.createSetCommand(domain, owner, feature, value);
	}
}
