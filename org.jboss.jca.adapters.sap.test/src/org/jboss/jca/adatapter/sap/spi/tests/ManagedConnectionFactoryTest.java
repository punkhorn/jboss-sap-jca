package org.jboss.jca.adatapter.sap.spi.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.PrintWriter;
import java.util.Collections;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionEvent;
import javax.resource.spi.ConnectionEventListener;

import org.jboss.jca.adapters.sap.cci.ConnectionFactory;
import org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.spi.ManagedConnection;
import org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.spi.impl.DefaultConnectionManagerImpl;
import org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionFactoryImpl;
import org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionImpl;
import org.jboss.jca.adapters.sap.spi.impl.ResourceAdapterImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ManagedConnectionFactoryTest {
	
	private ResourceAdapterImpl resourceAdapter;
	private ManagedConnectionFactory managedConnectionFactory;
	private ManagedConnectionFactory managedConnectionFactory2;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		File file = new File("state");
		if (file.exists()) {
			deleteFile(file);
		}
	}
	
	public static boolean deleteFile(File file) {
		if (file.isDirectory()) {
			for (String child: file.list()) {
				if (!deleteFile(new File(file, child)))
					return false;
			}
		}
		return file.delete();
	}

	@Before
	public void setUp() throws Exception {
		resourceAdapter = new ResourceAdapterImpl();
		resourceAdapter.setResourceUri("state/ResourceAdapter.spi");
		resourceAdapter.setLoadAndStoreState(true);
		resourceAdapter.start(null);
		
	}
	
	@After
	public void shutdown() {
		resourceAdapter.stop();
	}
	
	@Test
	public void testCreateDestroyManagedConnectionFactory() throws ResourceException {
		managedConnectionFactory = new ManagedConnectionFactoryImpl();
		
		managedConnectionFactory2 = new ManagedConnectionFactoryImpl();
		
		managedConnectionFactory.setResourceAdapter(resourceAdapter);

		managedConnectionFactory.setAshost("nplhost");
		managedConnectionFactory.setSysnr("42");
		managedConnectionFactory.setClient("001");
		managedConnectionFactory.setUser("developer");
		managedConnectionFactory.setPasswd("ch4ngeme");
		managedConnectionFactory.setLang("en");

		managedConnectionFactory.setLogWriter(new PrintWriter(System.out));

		managedConnectionFactory2.setResourceAdapter(resourceAdapter);
		managedConnectionFactory2.setAshost("nplhost");
		managedConnectionFactory2.setSysnr("00");
		managedConnectionFactory2.setClient("000");
		managedConnectionFactory2.setUser("DDIC");
		managedConnectionFactory2.setPasswd("ch4ngeme");
		managedConnectionFactory2.setLang("de");
		
		managedConnectionFactory2.destroy();
		
		resourceAdapter.stop();
		
		resourceAdapter.start(null);
		
		assertEquals("Managed Connection Factory missing", resourceAdapter.getManagedConnectionFactories().size(), 1);
		assertEquals("Managed Connection Factory missing", resourceAdapter.getManagedConnectionFactories().get(0), managedConnectionFactory);
	}
	
	@Test
	public void testCreateDestroyManagedConnection() throws ResourceException {
		assertEquals("Managed Connection Factory missing", resourceAdapter.getManagedConnectionFactories().size(), 1);
		managedConnectionFactory = resourceAdapter.getManagedConnectionFactories().get(0);
		
		ManagedConnection managedConnection = (ManagedConnection) managedConnectionFactory.createManagedConnection(null, null);
		
		assertNotNull("Failed to create Managed Connection", managedConnection);
		
		managedConnection.destroy();
		
		assertEquals("Destroyed managed connection not dissociated from managed connection factory", ((ManagedConnectionFactoryImpl)managedConnectionFactory).getManagedConnections().size(), 0);
		
	}
	
	@Test
	public void testConnectionEventNotification() throws ResourceException {
		assertEquals("Managed Connection Factory missing", resourceAdapter.getManagedConnectionFactories().size(), 1);
		managedConnectionFactory = resourceAdapter.getManagedConnectionFactories().get(0);

		
	}
	
	@Test
	public void testManagedConnectionMatch() throws ResourceException {
		assertEquals("Managed Connection Factory missing", resourceAdapter.getManagedConnectionFactories().size(), 1);
		managedConnectionFactory = resourceAdapter.getManagedConnectionFactories().get(0);
		
		ManagedConnection managedConnection = (ManagedConnection) managedConnectionFactory.createManagedConnection(null, null);
		
		ConnectionRequestInfo connectionRequestInfo = ((ManagedConnectionImpl)managedConnection).getConnectionRequestInfo();
		
		ManagedConnection matchedManagedConnection = (ManagedConnection) managedConnectionFactory.matchManagedConnections(Collections.singleton(managedConnection), null, connectionRequestInfo);
		assertEquals("Managed Connection does not match expected", managedConnection, matchedManagedConnection);
	}
	
	@Test
	public void testConnectionFactoryCreate() throws ResourceException {
		assertEquals("Managed Connection Factory missing", resourceAdapter.getManagedConnectionFactories().size(), 1);
		managedConnectionFactory = resourceAdapter.getManagedConnectionFactories().get(0);
		
		managedConnectionFactory.setLogWriter(new PrintWriter(System.out));
		
		ConnectionFactory connectionFactory = (ConnectionFactory) managedConnectionFactory.createConnectionFactory();
		ConnectionFactory connectionFactory2 = (ConnectionFactory) managedConnectionFactory.createConnectionFactory(new DefaultConnectionManagerImpl());
		
		assertNotNull("Creation of Connection Factory for managed environment failed", connectionFactory);
		assertNotNull("Creation of Connection Factory for unmanaged environment failed", connectionFactory2);
		
	}

	@Test
	public void testManagedConnectionAssociation() throws ResourceException {
		assertEquals("Managed Connection Factory missing", resourceAdapter.getManagedConnectionFactories().size(), 1);
		managedConnectionFactory = resourceAdapter.getManagedConnectionFactories().get(0);
		
		managedConnectionFactory.setLogWriter(new PrintWriter(System.out));
		
		ManagedConnection managedConnection = (ManagedConnection) managedConnectionFactory.createManagedConnection(null, null);
		
		ConnectionEventListener connectionEventListener = new ConnectionEventListener() {

			@Override
			public void connectionClosed(ConnectionEvent arg0) {
				System.out.println(arg0);
			}

			@Override
			public void connectionErrorOccurred(ConnectionEvent arg0) {
				System.out.println(arg0);
			}

			@Override
			public void localTransactionCommitted(ConnectionEvent arg0) {
				System.out.println(arg0);
			}

			@Override
			public void localTransactionRolledback(ConnectionEvent arg0) {
				System.out.println(arg0);
			}

			@Override
			public void localTransactionStarted(ConnectionEvent arg0) {
				System.out.println(arg0);
			}
			
		};
		managedConnection.addConnectionEventListener(connectionEventListener);
		
		managedConnection.ping();
		
		managedConnection.getConnection(null, null);

	}
	
	@Test
	public void testConnectionHandleCreate() throws ResourceException {
		assertEquals("Managed Connection Factory missing", resourceAdapter.getManagedConnectionFactories().size(), 1);
		managedConnectionFactory = resourceAdapter.getManagedConnectionFactories().get(0);
	}	
}
