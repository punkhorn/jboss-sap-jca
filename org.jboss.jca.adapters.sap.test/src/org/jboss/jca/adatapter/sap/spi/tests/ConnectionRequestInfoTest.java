package org.jboss.jca.adatapter.sap.spi.tests;

import static junit.framework.Assert.assertEquals;

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
import org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.spi.impl.SpiJcaAdapterFactory;
import org.junit.Before;
import org.junit.Test;

public class ConnectionRequestInfoTest {
	
	private ConnectionRequestInfo connectionRequestInfo;
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
		
		EObject model = SpiFactory.eINSTANCE.createConnectionRequestInfo();
		Resource resource = adapterFactoryEditingDomain.getResourceSet().createResource(URI.createURI("TestResource.xml"));
		resource.getContents().add(model);

		connectionRequestInfo = (ConnectionRequestInfo) adapterFactory.adapt(model, ConnectionRequestInfo.class);
	}

	@Test
	public void testBasicSetAndGet() {
		connectionRequestInfo.setAshost("nplhost");
		connectionRequestInfo.setSysnr("42");
		connectionRequestInfo.setClient("001");
		connectionRequestInfo.setUser("developer");
		connectionRequestInfo.setPasswd("ch4ngeme");
		connectionRequestInfo.setLang("en");
		
		assertEquals("ConnectionRequestInfo.getAshost() returned different value than was set.", "nplhost", connectionRequestInfo.getAshost());
		assertEquals("ConnectionRequestInfo.getSysnr() returned different value than was set.", "42", connectionRequestInfo.getSysnr());
		assertEquals("ConnectionRequestInfo.getClient() returned different value than was set.", "001", connectionRequestInfo.getClient());
		assertEquals("ConnectionRequestInfo.getUser() returned different value than was set.", "developer", connectionRequestInfo.getUser());
		assertEquals("ConnectionRequestInfo.getPasswd() returned different value than was set.", "ch4ngeme", connectionRequestInfo.getPasswd());
		assertEquals("ConnectionRequestInfo.getLang() returned different value than was set.", "en", connectionRequestInfo.getLang());
	}
	
	@Test
	public void testMultiThread() throws InterruptedException {
		Client client1 = new Client("Client_One");
		Client client2 = new Client("Client_Two");
		Thread client1Thread = new Thread(client1);
		Thread client2Thread = new Thread(client2);
		client2Thread.start();
		client1Thread.start();
		client1Thread.join();
		client2Thread.join();
		System.out.println(connectionRequestInfo.getAshost());
		System.out.println(connectionRequestInfo.getSysnr());
		System.out.println(connectionRequestInfo.getClient());
		System.out.println(connectionRequestInfo.getUser());
		System.out.println(connectionRequestInfo.getPasswd());
		System.out.println(connectionRequestInfo.getLang());
	}
	
	public class Client implements Runnable {

		String clientName;
		
		public Client(String clientName) {
			this.clientName = clientName;
		}
		
		@Override
		public void run() {
			commandStack.getWriteLock().lock();
			System.out.println(clientName + " Starting Transaction");
			commandStack.begin();
			try {
				
				connectionRequestInfo.setAshost(clientName + "_host");
				connectionRequestInfo.setSysnr(clientName + "_sysnr");
				connectionRequestInfo.setClient(clientName + "_client");
				connectionRequestInfo.setUser(clientName + "_user");
				connectionRequestInfo.setPasswd(clientName + "_passwd");
				connectionRequestInfo.setLang(clientName + "_lang");
				
				commandStack.commit();
				System.out.println(clientName + " Committing Transaction");
			} catch (Throwable t) {
				commandStack.rollback();
				System.out.println(clientName + " Rollingback Transaction");
			} finally {
				commandStack.getWriteLock().unlock();
			}
			
		}
		
	}

}
