package org.jboss.jca.adatapter.sap.spi.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.resource.ResourceException;

import org.jboss.jca.adapters.sap.cci.Interaction;
import org.jboss.jca.adapters.sap.cci.impl.ConnectionImpl;
import org.jboss.jca.adapters.sap.model.cci.ConnectionState;
import org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionFactoryImpl;
import org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionImpl;
import org.jboss.jca.adapters.sap.spi.impl.ResourceAdapterImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConnectionTest {

	private static final String ASHOST = "nplhost";
	private static final String SYSNR = "42";
	private static final String CLIENT = "001";
	private static final String USER = "DEVELOPER";
	private static final String PASSWD = "ch4ngeme";
	private static final String LANG = "en";

	private static ResourceAdapterImpl resourceAdapter;
	private static ManagedConnectionFactory managedConnectionFactory;
	private static ManagedConnectionImpl managedConnection;

	public static boolean deleteFile(File file) {
		if (file.isDirectory()) {
			for (String child: file.list()) {
				if (!deleteFile(new File(file, child)))
					return false;
			}
		}
		return file.delete();
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		File file = new File("state");
		if (file.exists()) {
			deleteFile(file);
		}
		resourceAdapter = new ResourceAdapterImpl();
		resourceAdapter.setResourceUri("state/ResourceAdapter.spi");
		resourceAdapter.setLoadAndStoreState(true);
		resourceAdapter.start(null);

		managedConnectionFactory = new ManagedConnectionFactoryImpl();
		managedConnectionFactory.setResourceAdapter(resourceAdapter);
		managedConnectionFactory.setAshost(ASHOST);
		managedConnectionFactory.setSysnr(SYSNR);
		managedConnectionFactory.setClient(CLIENT);
		managedConnectionFactory.setUser(USER);
		managedConnectionFactory.setPasswd(PASSWD);
		managedConnectionFactory.setLang(LANG);
		
		managedConnection = (ManagedConnectionImpl) managedConnectionFactory.createManagedConnection(null, null);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		resourceAdapter.stop();
	}

	@Test
	public void testCreateDestroyConnection() throws ResourceException {
		ConnectionImpl connection = (ConnectionImpl) managedConnection.getConnection(null, null);
		assertEquals("New connection handle assinged incorrect parent", managedConnection, connection.getManagedConnection());
		assertEquals("New connection handle assigned incorrect name", managedConnection.getConnectionName(), connection.getConnectionName());
		assertEquals("New connection handle assigned incorrect connection request info reference", managedConnection.getConnectionRequestInfo(), connection.getConnectionRequestInfo());
		
		connection.close();
		assertEquals("Closed connection handle assinged incorrect sate", ConnectionState.CLOSED, connection.getState());
		assertEquals("Closed connection handle assinged incorrect parent", null, connection.getManagedConnection());
		assertEquals("Closed connection handle assigned incorrect name", null, connection.getConnectionName());
		assertEquals("Closed connection handle assigned incorrect connection request info reference", null, connection.getConnectionRequestInfo());
	}
	
	@Test
	public void testCreateDestroyInteractions() throws ResourceException {
		ConnectionImpl connection = (ConnectionImpl) managedConnection.getConnection(null, null);
		assertEquals("New connection handle has incorrect interaction list size", 0, connection.getInteractions().size());
		
		Interaction interaction = (Interaction) connection.createInteraction();
		assertEquals("Connection handle has incorrect interaction list size after interaction create", 1, connection.getInteractions().size());
		
		interaction.close();
		assertEquals("Connection handle has incorrect interaction list size after interaction close", 0, connection.getInteractions().size());
		
		connection.close();
	}

}
