package org.jboss.jca.adatapter.sap.spi.tests;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.jboss.jca.adapters.sap.cci.impl.CciJcaAdapterFactory;
import org.jboss.jca.adapters.sap.command.TransactionalCommandStack;
import org.jboss.jca.adapters.sap.model.spi.SpiFactory;
import org.jboss.jca.adapters.sap.spi.ConnectionRequestInfoStore;
import org.jboss.jca.adapters.sap.spi.impl.SpiJcaAdapterFactory;
import org.junit.Before;
import org.junit.Test;

public class ConnectionRequestInfoStoreTest {

	private ConnectionRequestInfoStore connectionRequestInfoStore;
	private TransactionalCommandStack commandStack;

	@Before
	public void setUp() throws Exception {
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(CciJcaAdapterFactory.INSTANCE);
		adapterFactory.addAdapterFactory(SpiJcaAdapterFactory.INSTANCE);
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		commandStack = new TransactionalCommandStack();
		
		AdapterFactoryEditingDomain adapterFactoryEditingDomain = new AdapterFactoryEditingDomain(adapterFactory,
				commandStack, new HashMap<Resource, Boolean>());
		adapterFactoryEditingDomain.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMLResourceFactoryImpl());

		EObject model = SpiFactory.eINSTANCE.createConnectionRequestInfoStore();
		Resource resource = adapterFactoryEditingDomain.getResourceSet().createResource(URI.createURI("TestResource.xml"));
		resource.getContents().add(model);

		connectionRequestInfoStore = (ConnectionRequestInfoStore) adapterFactory.adapt(model, ConnectionRequestInfoStore.class);
	}

	@Test
	public void test() {
		assertNotNull(connectionRequestInfoStore);
	}

}
