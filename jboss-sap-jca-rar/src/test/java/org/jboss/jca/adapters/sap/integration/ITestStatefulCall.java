package org.jboss.jca.adapters.sap.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.resource.cci.Interaction;
import javax.resource.cci.MappedRecord;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.jca.adapters.sap.cci.CciFactory;
import org.jboss.jca.adapters.sap.cci.Connection;
import org.jboss.jca.adapters.sap.cci.InteractionSpec;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.ResourceAdapterArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * StatefulCallTests - Tests stateful calls of RFC Function Modules through JBoss SAP JCA Connector
 * 
 * @author William Collins
 * 
 */
@RunWith(Arquillian.class)
public class ITestStatefulCall {

	private static Logger log = Logger.getLogger("StatefulCollTests");

	private static String deploymentName = "StatfullCallTests";

	private static int threadCount = 5;

	private static int incrementNum = 3;

	/**
	 * Define the deployment
	 * 
	 * @return The deployment archive
	 */
	@Deployment
	public static ResourceAdapterArchive createDeployment() {
		log.info("Creating deployment for StatefulCallTests");

		ResourceAdapterArchive raa = ShrinkWrap.create(ResourceAdapterArchive.class, deploymentName + ".rar");
//		JavaArchive ja = ShrinkWrap.create(JavaArchive.class, UUID.randomUUID().toString() + ".jar");
//		ja.addClasses(CLASSES_TO_TEST);
//		raa.addAsLibrary(ja);

		raa.addAsManifestResource("META-INF/ra.xml", "ra.xml");

		raa.addAsManifestResource("META-INF/DefaultTests-ironjacamar.xml", "ironjacamar.xml");

		return raa;
	}

	@Resource(mappedName = "java:/eis/DefaultTestsFactory")
	private javax.resource.cci.ConnectionFactory connectionFactory;

	/**
	 * A Callable Task that makes stateful calls to SAP to increment the global variable of a function module.
	 */
	private Callable<Integer> incrementTestTask = new Callable<Integer>() {

		/**
		 * Makes sequence of stateful calls to <code>ZJBOSS_INCREMENT_COUNTER</code> and returns the value returned by
		 * <code>ZJBOSS_GET_COUNTER</code> at end of call sequence.
		 */
		@Override
		public Integer call() throws Exception {
			Connection connection = null;
			try {
				log.info("Testing Stateful Call Sequence");
				assertNotNull("Failed to access connection factory 'CciTestsFactory'", connectionFactory);
				connection = (Connection) connectionFactory.getConnection();
				assertNotNull("Failed to create connection", connection);
				connection.ping();

				//
				// Create interaction to invoke ZJBOSS_INCREMENT_COUNTER function module.
				//

				Interaction interaction = connection.createInteraction();
				InteractionSpec incrementCounter = CciFactory.INSTANCE.createInteractionSpec();
				incrementCounter.setFunctionName("ZJBOSS_INCREMENT_COUNTER");
				InteractionSpec getCounter = CciFactory.INSTANCE.createInteractionSpec();
				getCounter.setFunctionName("ZJBOSS_GET_COUNTER");

				//
				// Create input record to pass parameters to function module.
				//

				MappedRecord input = connectionFactory.getRecordFactory().createMappedRecord("ZJBOSS_INCREMENT_COUNTER.INPUT_RECORD");
				MappedRecord output = connectionFactory.getRecordFactory().createMappedRecord("ZJBOSS_INCREMENT_COUNTER.OUTPUT_RECORD");

				// Start stateful sequence and execute interaction multiple times.
				connection.begin();
				for (int i = 0; i < incrementNum; i++) {
					assertTrue("ZJBOSS_INCREMENT_COUNTER failed", interaction.execute(incrementCounter, input, output));
				}

				input = connectionFactory.getRecordFactory().createMappedRecord("ZJBOSS_GET_COUNTER.INPUT_RECORD");
				output = connectionFactory.getRecordFactory().createMappedRecord("ZJBOSS_GET_COUNTER.OUTPUT_RECORD");
				assertTrue("ZJBOSS_GET_COUNTER failed", interaction.execute(getCounter, input, output));

				return (Integer) output.get("GET_VALUE");

			} finally {
				if (connection != null) {
					connection.end();
					connection.close();
				}
			}
		}

	};

	/**
	 * Tests Stateful Call sequence in concurrent threads.
	 * 
	 * @throws Throwable
	 *             Thrown in case of a test error.
	 */
	@Test
	public void testStatefulCallSequences() throws Throwable {
		List<Callable<Integer>> tasks = Collections.nCopies(threadCount, incrementTestTask);
		ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
		List<Future<Integer>> futures = executorService.invokeAll(tasks);

		for (Future<Integer> future : futures) {
			int incrementedValue = future.get().intValue();
			assertEquals("Incremented value '" + incrementedValue + "' does not match expected value '" + incrementNum
					+ "'", incrementedValue, incrementNum);
		}
	}

}
