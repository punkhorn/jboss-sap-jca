package org.jboss.jca.adatapter.sap.spi.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionEvent;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.LocalTransaction;
import javax.resource.spi.ManagedConnectionMetaData;

import org.eclipse.emf.ecore.EObject;
import org.jboss.jca.adapters.sap.cci.Connection;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionState;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;
import org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionFactoryImpl;
import org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionImpl;
import org.jboss.jca.adapters.sap.spi.impl.ResourceAdapterImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ManagedConnectionTest {
	
	private static final String ASHOST = "nplhost";
	private static final String SYSNR = "42";
	private static final String CLIENT = "001";
	private static final String USER = "DEVELOPER";
	private static final String PASSWD = "ch4ngeme";
	private static final String LANG = "en";

	private static ResourceAdapterImpl resourceAdapter;
	private static  ManagedConnectionFactory managedConnectionFactory;
	
	private ManagedConnectionImpl managedConnection;

	ConnectionEvent connectionEvent;
	
	@BeforeClass
	public static void setUpBeforeClass() throws ResourceException {
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

	@AfterClass
	public static void shutdown() {
		resourceAdapter.stop();
	}
	
	@Test
	public void testCreateDestroyManagedConnection() throws ResourceException {

		managedConnection = (ManagedConnectionImpl) managedConnectionFactory.createManagedConnection(null, null);
		
		assertNotNull("Failed to create Managed Connection", managedConnection);
		assertEquals("New managed connection configured with incorrect ashost", ASHOST, managedConnection.getConnectionRequestInfo().getAshost());
		assertEquals("New managed connection configured with incorrect ashost", SYSNR, managedConnection.getConnectionRequestInfo().getSysnr());
		assertEquals("New managed connection configured with incorrect ashost", CLIENT, managedConnection.getConnectionRequestInfo().getClient());
		assertEquals("New managed connection configured with incorrect ashost", USER, managedConnection.getConnectionRequestInfo().getUser());
		assertEquals("New managed connection configured with incorrect ashost", PASSWD, managedConnection.getConnectionRequestInfo().getPasswd());
		assertEquals("New managed connection configured with incorrect ashost", LANG, managedConnection.getConnectionRequestInfo().getLang());
		
		managedConnection.destroy();
		EObject managedConnectionModel = (EObject) ((ManagedConnectionImpl)managedConnection).getTarget();
		assertEquals("Destroyed managed connection not dissociated from managed connection factory", ManagedConnectionState.DESTROYED, managedConnectionModel.eGet(SpiPackage.Literals.MANAGED_CONNECTION__STATE));
		
		managedConnection.destroy();
	}
	
	@Test
	public void testConnectionEventListener() throws ResourceException {

		managedConnection = (ManagedConnectionImpl) managedConnectionFactory.createManagedConnection(null, null);

		ConnectionEventListener connectionEventListener = new ConnectionEventListener() {

			@Override
			public void connectionClosed(ConnectionEvent arg0) {
				connectionEvent = arg0;
			}

			@Override
			public void connectionErrorOccurred(ConnectionEvent arg0) {
				connectionEvent = arg0;
			}

			@Override
			public void localTransactionCommitted(ConnectionEvent arg0) {
				connectionEvent = arg0;
			}

			@Override
			public void localTransactionRolledback(ConnectionEvent arg0) {
				connectionEvent = arg0;
			}

			@Override
			public void localTransactionStarted(ConnectionEvent arg0) {
				connectionEvent = arg0;
			}
			
		};
		managedConnection.addConnectionEventListener(connectionEventListener);
		
		Connection connection = (Connection) managedConnection.getConnection(null, null);
		
		connectionEvent = null;
		connection.close();
		assertNotNull("Failed to receive CONNECTION_CLOSE event", connectionEvent);
		assertEquals("Received different type of event than CONNECTION_CLOSE event", ConnectionEvent.CONNECTION_CLOSED,  connectionEvent.getId());
		assertEquals("CONNECTION_CLOSE event for different connection handle received", connection,  connectionEvent.getConnectionHandle());
		assertEquals("Event for different managed connection received", managedConnection,  connectionEvent.getSource());
		
		connectionEvent = null;
		LocalTransaction transaction = managedConnection.getLocalTransaction();
		transaction.begin();
		assertNotNull("Failed to receive LOCAL_TRANSACTION_STARTED event", connectionEvent);
		assertEquals("Received different type of event than LOCAL_TRANSACTION_STARTED event", ConnectionEvent.LOCAL_TRANSACTION_STARTED,  connectionEvent.getId());
		assertEquals("LOCAL_TRANSACTION_STARTED event for different managed connection received", managedConnection,  connectionEvent.getSource());
		
		connectionEvent = null;
		transaction.rollback();
		assertNotNull("Failed to receive LOCAL_TRANSACTION_ROLLEDBACK event", connectionEvent);
		assertEquals("Received different type of event than LOCAL_TRANSACTION_ROLLEDBACK event", ConnectionEvent.LOCAL_TRANSACTION_ROLLEDBACK,  connectionEvent.getId());
		assertEquals("LOCAL_TRANSACTION_ROLLEDBACK event for different managed connection received", managedConnection,  connectionEvent.getSource());
		
		transaction.begin();
		connectionEvent = null;
		transaction.commit();
		assertNotNull("Failed to receive LOCAL_TRANSACTION_COMMITTED event", connectionEvent);
		assertEquals("Received different type of event than LOCAL_TRANSACTION_ROLLEDBACK event", ConnectionEvent.LOCAL_TRANSACTION_COMMITTED,  connectionEvent.getId());
		assertEquals("LOCAL_TRANSACTION_COMMITTED event for different managed connection received", managedConnection,  connectionEvent.getSource());
		
		managedConnection.destroy();
	}
	
	@Test
	public void testManagedConnectionMetadata() throws ResourceException {
		managedConnection = (ManagedConnectionImpl) managedConnectionFactory.createManagedConnection(null, null);

		ManagedConnectionMetaData metaData = managedConnection.getMetaData();
		
		assertNotNull("Failed to retrieve managed connection meta data", metaData);
//		assertEquals("Managed connection meta data returned incorrect EIS Product Name", "SAP\u00AE R/3",  metaData.getEISProductName());
//		assertEquals("Managed connection meta data returned incorrect Max Connections", "0",  metaData.getMaxConnections());
		assertEquals("Managed connection meta data returned incorrect User Name", USER,  metaData.getUserName());
		
		managedConnection.destroy();
	}
	
	@Test
	public void testConnectionAssociation() throws ResourceException {
		// Given
		managedConnection = (ManagedConnectionImpl) managedConnectionFactory.createManagedConnection(null, null);
		ManagedConnectionImpl managedConnection2 = (ManagedConnectionImpl) managedConnectionFactory.createManagedConnection(null, null);
		
		// When 
		Connection connection = (Connection) managedConnection.getConnection(null, null);
		
		// Then
		assertNotNull("Failed to create connection handle", connection);
		assertEquals("Connection handle not added to handle list of managed connection", 1, managedConnection.getConnectionHandles().size());
		
		// When
		managedConnection2.associateConnection(connection);
		
		// Then
		assertEquals("Connection handle not removed from handle list of managed connection", 0, managedConnection.getConnectionHandles().size());
		assertEquals("Connection handle not added to handle list of managed connection", 1, managedConnection2.getConnectionHandles().size());
		
		
		// When
		managedConnection2.dissociateConnections();
		
		// Then
		assertEquals("Connection handle not removed from handle list of managed connection", 0, managedConnection2.getConnectionHandles().size());

		// When
		managedConnection.associateConnection(connection);

		// Then
		assertEquals("Connection handle not added to handle list of managed connection", 1, managedConnection.getConnectionHandles().size());

		// When
		connection.close();

		// Then
		assertEquals("Connection handle not removed from handle list of managed connection", 0, managedConnection.getConnectionHandles().size());

		managedConnection.destroy();
	}
}
