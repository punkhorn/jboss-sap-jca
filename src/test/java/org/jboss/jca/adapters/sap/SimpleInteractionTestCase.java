package org.jboss.jca.adapters.sap;

import static org.jboss.jca.adapters.sap.ClassesToTest.CLASSES_TO_TEST;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.UUID;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.resource.cci.Interaction;
import javax.resource.cci.MappedRecord;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.ResourceAdapterArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings({"restriction","unchecked"})
@RunWith(Arquillian.class)
public class SimpleInteractionTestCase {

	private static Logger log = Logger.getLogger("SimpleInteractionTestCase");

	private static String deploymentName = "SimpleInteractionTestCase";
	
	private static String REQUTEXT = "Hello SAP!";

	@Deployment
	public static ResourceAdapterArchive createDeployment() {
		log.info("Creating deployment for SimpleInteractionTestCase");

		ResourceAdapterArchive raa = ShrinkWrap.create(ResourceAdapterArchive.class, deploymentName + ".rar");
		JavaArchive ja = ShrinkWrap.create(JavaArchive.class, UUID.randomUUID().toString() + ".jar");
		ja.addClasses(CLASSES_TO_TEST);
		raa.addAsLibrary(ja);
		
		raa.addAsManifestResource("META-INF/ra.xml", "ra.xml");
		
		raa.addAsManifestResource("META-INF/ConnectionTestCase-ironjacamar.xml", "ironjacamar.xml");
		
		return raa;
	}

	@Resource(mappedName = "java:/eis/ConnectionTestCaseFactory")
	private javax.resource.cci.ConnectionFactory connectionTestCaseFactory;
	
	@Test
	public void testSimpleInteraction() throws Throwable {
		log.info("Testing Simple Interaction");
		assertNotNull(connectionTestCaseFactory);
		JBossSAPCciConnection connection = (JBossSAPCciConnection) connectionTestCaseFactory.getConnection();
		assertNotNull(connection);
		connection.ping();

		Interaction interaction = connection.createInteraction();
		JBossSAPInteractionSpec interactionSpec = new JBossSAPInteractionSpec();
		interactionSpec.setFunctionName("STFC_CONNECTION");
		MappedRecord input = JBossSAPRecordFactory.INSTANCE.createMappedRecord("input");
		input.put("REQUTEXT", REQUTEXT);
		MappedRecord output = JBossSAPRecordFactory.INSTANCE.createMappedRecord("output");
		assertTrue("Simple Interaction Execution Failed", interaction.execute(interactionSpec, input, output));
		String echoText = (String) output.get("ECHOTEXT");
		assertEquals("Echo text does not match request text", REQUTEXT, echoText);

		connection.close();
	}

	@Test
	public void testInteractionWithReturnStructure() throws Throwable {
		log.info("Testing Simple Interaction");
		assertNotNull(connectionTestCaseFactory);
		JBossSAPCciConnection connection = (JBossSAPCciConnection) connectionTestCaseFactory.getConnection();
		assertNotNull(connection);
		connection.ping();

		Interaction interaction = connection.createInteraction();
		JBossSAPInteractionSpec interactionSpec = new JBossSAPInteractionSpec();
		interactionSpec.setFunctionName("RFC_SYSTEM_INFO");
		MappedRecord input = JBossSAPRecordFactory.INSTANCE.createMappedRecord("input");
		MappedRecord output = JBossSAPRecordFactory.INSTANCE.createMappedRecord("output");
		assertTrue("Interaction with Return Structure Execution Failed", interaction.execute(interactionSpec, input, output));
		MappedRecord rfcsiExport = (MappedRecord) output.get("RFCSI_EXPORT");
		assertNotNull("RFCSI_EXPORT export parameter not returned by interaction", rfcsiExport);
		
		StringBuilder builder = new StringBuilder();
		builder.append(rfcsiExport.getRecordName() + " : " + rfcsiExport.getRecordShortDescription() + " {\n");
		Iterator iterator = rfcsiExport.keySet().iterator();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			builder.append("\t" + key + ": " + rfcsiExport.get(key)+ "\n");
		}
		builder.append("}\n");
		log.info(builder.toString());

		connection.close();
	}

}
