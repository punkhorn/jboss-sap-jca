package org.jboss.jca.adapters.sap.model.edit.spi;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.jboss.jca.adapters.sap.model.edit.command.AddManagedConnectionCommand;
import org.jboss.jca.adapters.sap.model.edit.command.RemoveManagedConnectionCommand;
import org.jboss.jca.adapters.sap.model.edit.provider.DelegatingItemPropertyDescriptor;
import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;
import org.jboss.jca.adapters.sap.model.spi.provider.ConnectionRequestInfoItemProvider;

public class ManagedConnectionFactoryItemProvider extends
org.jboss.jca.adapters.sap.model.spi.provider.ManagedConnectionFactoryItemProvider {

	public ManagedConnectionFactoryItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * Overridden to simplify label
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			getPropertyDescriptorsGen(object);

			addConnectionRequestInfoPropertyDescriptors(((ManagedConnectionFactory)object).getDefaultConnectionRequestInfo(), getString("_UI_ManagedConnectionFactory_defaultConnectionRequestInfo_feature"));
		}
		return itemPropertyDescriptors;
	}

	/**
	 * Overridden to include properties of contained {@link ConnectionRequestInfo) instance.
	 */
	protected void addConnectionRequestInfoPropertyDescriptors(ConnectionRequestInfo connectionRequestInfo, final String connectionRequestInfoFeature) {
		ConnectionRequestInfoItemProvider connectionRequestInfoItemProvider = (ConnectionRequestInfoItemProvider) getRootAdapterFactory().adapt(connectionRequestInfo, IItemPropertySource.class);
		List<IItemPropertyDescriptor> descriptors = connectionRequestInfoItemProvider.getPropertyDescriptors(connectionRequestInfo);
		for(IItemPropertyDescriptor descriptor: descriptors) {
			itemPropertyDescriptors.add(new DelegatingItemPropertyDescriptor(descriptor, SpiPackage.Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO) {
				@Override
				public String getCategory(Object thisObject) {
					return connectionRequestInfoFeature;
				}
				
				@Override
				public String getId(Object thisObject) {
					return connectionRequestInfoFeature + getDisplayName(thisObject);
				}
			});
		}
	}

	/**
	 * Overridden to provide custom add command.
	 */
	@Override
	protected Command createAddCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Collection<?> collection, int index) {
		if (feature == SpiPackage.Literals.MANAGED_CONNECTION_FACTORY__MANAGED_CONNECTIONS) {
			return new AddManagedConnectionCommand(domain, (ManagedConnectionFactory) owner, feature, collection);
		}
		return super.createAddCommand(domain, owner, feature, collection, index);
	}
	
	/**
	 * Overridden to provide custom remove command.
	 */
	@Override
	protected Command createRemoveCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Collection<?> collection) {
		if (feature == SpiPackage.Literals.MANAGED_CONNECTION_FACTORY__MANAGED_CONNECTIONS) {
			return new RemoveManagedConnectionCommand(domain, (ManagedConnectionFactory) owner, feature, collection);
		}
		return super.createRemoveCommand(domain, owner, feature, collection);
	}
	
	/**
	 * Overridden to provide custom set command.
	 */
	@Override
	protected Command createSetCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Object value) {
		
		// Prevent the default connection request info from being deleted or replaced.
		if (feature == SpiPackage.Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO) {
			return UnexecutableCommand.INSTANCE;
		}

		return super.createSetCommand(domain, owner, feature, value);
	}
}
