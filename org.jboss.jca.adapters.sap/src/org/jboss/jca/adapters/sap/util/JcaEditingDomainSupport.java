package org.jboss.jca.adapters.sap.util;

import java.util.HashMap;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.jboss.jca.adapters.sap.cci.impl.CciJcaAdapterFactory;
import org.jboss.jca.adapters.sap.command.TransactionalCommandStack;
import org.jboss.jca.adapters.sap.spi.impl.SpiJcaAdapterFactory;

public enum JcaEditingDomainSupport {
	INSTANCE;
	
	private AdapterFactoryEditingDomain editingDomain;
	
	JcaEditingDomainSupport() {
		editingDomain = initializeEditingDomain();
	}
	
	public AdapterFactoryEditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * Returns the {@link TransactionalCommandStack} used by the
	 * {@link AdapterFactoryEditingDomain}.
	 * 
	 * @return the {@link TransactionalCommandStack} used by the
	 *         {@link AdapterFactoryEditingDomain}.
	 */
	public TransactionalCommandStack getCommandStack() {
		return (TransactionalCommandStack) getEditingDomain().getCommandStack();
	}

	/**
	 * Initializes an {@link AdapterFactoryEditingDomain } instance.
	 * 
	 * @return an {@link AdapterFactoryEditingDomain } instance.
	 */
	protected AdapterFactoryEditingDomain initializeEditingDomain() {

		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(CciJcaAdapterFactory.INSTANCE);
		adapterFactory.addAdapterFactory(SpiJcaAdapterFactory.INSTANCE);
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		TransactionalCommandStack commandStack = new TransactionalCommandStack();

		AdapterFactoryEditingDomain adapterFactoryEditingDomain = new AdapterFactoryEditingDomain(adapterFactory,
				commandStack, new HashMap<Resource, Boolean>());
		adapterFactoryEditingDomain.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMLResourceFactoryImpl());
		return adapterFactoryEditingDomain;
	}

	
}
