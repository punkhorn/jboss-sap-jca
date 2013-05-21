package org.jboss.jca.adatapter.sap.spi.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.resource.ResourceException;

import org.jboss.jca.adapters.sap.cci.InteractionSpec;
import org.jboss.jca.adapters.sap.cci.MappedRecord;
import org.jboss.jca.adapters.sap.cci.RecordFactory;
import org.jboss.jca.adapters.sap.cci.impl.ConnectionFactoryImpl;
import org.jboss.jca.adapters.sap.cci.impl.ConnectionImpl;
import org.jboss.jca.adapters.sap.cci.impl.InteractionImpl;
import org.jboss.jca.adapters.sap.cci.impl.InteractionSpecImpl;
import org.jboss.jca.adapters.sap.model.cci.InteractionState;
import org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionFactoryImpl;
import org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionImpl;
import org.jboss.jca.adapters.sap.spi.impl.ResourceAdapterImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class InteractionTest {

	private static final String ASHOST = "nplhost";
	private static final String SYSNR = "42";
	private static final String CLIENT = "001";
	private static final String USER = "DEVELOPER";
	private static final String PASSWD = "ch4ngeme";
	private static final String LANG = "en";

	private static ResourceAdapterImpl resourceAdapter;
	private static ManagedConnectionFactory managedConnectionFactory;
	private static ManagedConnectionImpl managedConnection;
	private static ConnectionFactoryImpl connectionFactory;
	private static ConnectionImpl connection;

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
		
		connectionFactory = (ConnectionFactoryImpl) managedConnectionFactory.createConnectionFactory();
		
		managedConnection = (ManagedConnectionImpl) managedConnectionFactory.createManagedConnection(null, null);
		
		connection = (ConnectionImpl) managedConnection.getConnection(null, null);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		resourceAdapter.stop();
	}

	@Test
	public void testCreateDestroyInteraction() throws ResourceException {
		InteractionImpl interaction = (InteractionImpl) connection.createInteraction();
		assertEquals("New interaction assigned incorrect state", InteractionState.ACTIVE, interaction.getState());
		assertEquals("New interaction assigned incorrect parent", connection, interaction.getConnection());
		
		interaction.close();
		assertEquals("Closed interaction assigned incorrect state", InteractionState.CLOSED, interaction.getState());
		assertEquals("Closed interaction assigned incorrect parent", null, interaction.getConnection());
	}
	
	@SuppressWarnings({ "unchecked" })
	@Test
	public void testExecuteInteractions() throws ResourceException {
		InteractionImpl interaction = (InteractionImpl) connection.createInteraction();
		
		InteractionSpec interactionSpec = new InteractionSpecImpl();
		interactionSpec.setFunctionName("STFC_CONNECTION");
		
		RecordFactory recordFactory = (RecordFactory) connectionFactory.getRecordFactory();
		
		MappedRecord inputRecord = (MappedRecord) recordFactory.createMappedRecord("STFC_CONNECTION.INPUT_RECORD");
		inputRecord.put("REQUTEXT", "Hello SAP!");
		
		MappedRecord outputRecord = (MappedRecord) interaction.execute(interactionSpec, inputRecord);
		assertEquals("", "Hello SAP!", outputRecord.get("ECHOTEXT"));

		interaction.close();
	}

}
