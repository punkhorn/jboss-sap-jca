package org.jboss.jca.adapters.sap.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.Interaction;
import javax.resource.cci.MappedRecord;
import javax.resource.spi.ManagedConnectionFactory;

import org.jboss.jca.adapters.sap.cci.CciFactory;
import org.jboss.jca.adapters.sap.cci.InteractionSpec;
import org.jboss.jca.adapters.sap.spi.NonManagedEnvironmentAdmin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ITestNonManagedEnvironmentAdmin {

	private NonManagedEnvironmentAdmin spiFactory;

	@Before
	public void setUp() throws Exception {
		// Given
		spiFactory = NonManagedEnvironmentAdmin.INSTANCE;
		spiFactory.deployResourceAdapter(null);
	}

	@After
	public void tearDown() throws Exception {
		spiFactory.undeployResourceAdapter();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testCreateManagedConnectionFactory() throws Exception {
		// Given
		Map<String, String> config = new HashMap<String, String>();
		config.put("ashost", "nplhost");
		config.put("sysnr", "42");
		config.put("client", "001");
		config.put("user", "developer");
		config.put("passwd", "ch4ngeme");
		config.put("lang", "en");

		// When
		ManagedConnectionFactory managedConnectionFactory = spiFactory.createManagedConnectionFactory(config);
		ConnectionFactory connectionFactory = (ConnectionFactory) managedConnectionFactory.createConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		Interaction interaction = connection.createInteraction();
		InteractionSpec interactionSpec = CciFactory.INSTANCE.createInteractionSpec();
		interactionSpec.setFunctionName("STFC_CONNECTION");
		MappedRecord input = (MappedRecord) connectionFactory.getRecordFactory().createMappedRecord(
				"STFC_CONNECTION.INPUT_RECORD");
		input.put("REQUTEXT", "Hello SAP!");
		MappedRecord output = (MappedRecord) connectionFactory.getRecordFactory().createMappedRecord(
				"STFC_CONNECTION.OUTPUT_RECORD");
		assertTrue("Simple Interaction Execution Failed", interaction.execute(interactionSpec, input, output));
		String echoText = (String) output.get("ECHOTEXT");
		assertEquals("Echoed text does not match request text", "Hello SAP!", echoText);

	}

}
