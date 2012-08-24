/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.jca.adapters.sap;

import static org.jboss.jca.adapters.sap.ClassesToTest.CLASSES_TO_TEST;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.UUID;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.resource.cci.Interaction;
import javax.resource.cci.MappedRecord;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.jca.adapters.sap.cci.JBossSAPConnection;
import org.jboss.jca.adapters.sap.cci.JBossSAPInteractionSpec;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.ResourceAdapterArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * BPMTransactionTests - Test JBoss SAP JCA connector bean managed transactions
 * 
 * @author William Collins
 *
 */
@SuppressWarnings({ "unchecked" })
@RunWith(Arquillian.class)
public class BMPTransactionTests {

	private static Logger log = Logger.getLogger("BMPTransactionTests");

	private static String deploymentName = "BMPTransactionTests";
	
	//
	// Remote Function Modules called in tests
	//
	
	/**
	 * Creates a new persistent counters structure in SAP.
	 */
	private static final String CREATE_COUNTERS_FUNC = "ZJBOSS_COUNTERS_CREATE";
	
	/**
	 * Reads the value of a counters structure in SAP.
	 */
	private static final String READ_COUNTERS_FUNC = "ZJBOSS_COUNTERS_READ";
	
	/**
	 * Updates the value of counters structure in SAP.
	 */
	private static final String UPDATE_COUNTERS_FUNC = "ZJBOSS_COUNTERS_UPDATE";
	
	/**
	 * Deletes a counters structure in SAP. 
	 */
	private static final String DELETE_COUNTERS_FUNC = "ZJBOSS_COUNTERS_DELETE";
	
	// 
	// Names of parameters used in tests.
	//
	
	/**
	 * An initial value import parameter; used set the initial value of a counters structure when creating a structure.
	 */
	private static final String IV_INIT_VAL_PARAM = "IV_INIT_VAL";
	
	/**
	 * A counters id import parameter; used to identify a counters structure when reading, updating or deleting a structure.
	 */
	private static final String IV_COUNTERID_PARAM = "IV_COUNTERID";
	
	/**
	 * A counters structure import parameter; used when updating a counters structure.
	 */
	private static final String IV_COUNTERS_PARAM = "IV_COUNTERS";
	
	/**
	 * A counters id export parameter; used when creating a new counters structure.
	 */
	private static final String OV_COUNTERID_PARAM = "OV_COUNTERID";
	
	/**
	 * A counters structure parameter; used when updating a counters structure.
	 */
	private static final String OV_COUNTERS_PARAM = "OV_COUNTERS";
	
	/**
	 * A counters value parameter; used to set a new value when updating  a counters structure.
	 */
	private static final String VALUE_PARAM = "VALUE";
	
	/**
	 * The initial value set on counters value. 
	 */
	private static final int INIT_VALUE = 7;
	


	/**
	 * Define the deployment
	 * 
	 * @return The deployment archive
	 */
	@Deployment
	public static ResourceAdapterArchive createDeployment() {
		log.info("Creating deployment for BMP Transaction Tests");

		ResourceAdapterArchive raa = ShrinkWrap.create(ResourceAdapterArchive.class, deploymentName + ".rar");
		JavaArchive ja = ShrinkWrap.create(JavaArchive.class, UUID.randomUUID().toString() + ".jar");
		ja.addClasses(CLASSES_TO_TEST);
		raa.addAsLibrary(ja);

		raa.addAsManifestResource("META-INF/ra.xml", "ra.xml");

		raa.addAsManifestResource("META-INF/DefaultTests-ironjacamar.xml", "ironjacamar.xml");

		return raa;
	}

	@Resource(mappedName = "java:/eis/DefaultTestsFactory")
	private javax.resource.cci.ConnectionFactory connectionFactory;

	@SuppressWarnings("unchecked")
	@Test
	public void testTransactionSequence() throws Throwable {
		JBossSAPConnection connection = null;
		MappedRecord counters = null;
		String countersId = null;
		int countersValue;
		
		try {
			log.info("Testing Transaction Sequence");
			assertNotNull("Failed to access connection factory 'DefaultTestsFactory'", connectionFactory);
			connection = (JBossSAPConnection) connectionFactory.getConnection();
			assertNotNull("Failed to create connection", connection);
			
			// Start transaction
			connection.getLocalTransaction().begin();
			
			// Create a counters structure.
			Interaction interaction = connection.createInteraction();
			JBossSAPInteractionSpec interactionSpec = new JBossSAPInteractionSpec();
			interactionSpec.setFunctionName(CREATE_COUNTERS_FUNC);
			MappedRecord input = connectionFactory.getRecordFactory().createMappedRecord("input");
			input.put(IV_INIT_VAL_PARAM, 7);
			MappedRecord output = (MappedRecord) interaction.execute(interactionSpec, input);
			assertNotNull("Failed to create counters structure", output);
			countersId = (String) output.get(OV_COUNTERID_PARAM);
			assertNotNull("Counters ID not returned in create", countersId);
			
			// Read counters structure.
			interactionSpec.setFunctionName(READ_COUNTERS_FUNC);
			input.clear();
			input.put(IV_COUNTERID_PARAM, countersId);
			output.clear();
			assertTrue("Failed to read counters structure", interaction.execute(interactionSpec, input, output));
			counters = (MappedRecord) output.get(OV_COUNTERS_PARAM);
			assertNotNull("Counters  structure not returned in read", counters);
			countersValue = (Integer) counters.get(VALUE_PARAM);
			assertEquals("Counters value not initialized correctly", INIT_VALUE, countersValue);
			
			// Double counters value.
			countersValue *= 2;
			counters.put(VALUE_PARAM, countersValue);
			
			// Update counters structure
			interactionSpec.setFunctionName(UPDATE_COUNTERS_FUNC);
			input.clear();
			input.put(IV_COUNTERS_PARAM, counters);
			output.clear();
			assertTrue("Failed to update counters structure", interaction.execute(interactionSpec, input, output));
			
			// Commit transaction
			connection.getLocalTransaction().commit();
			
			// Read counters structure.
			interactionSpec.setFunctionName(READ_COUNTERS_FUNC);
			input.clear();
			input.put(IV_COUNTERID_PARAM, countersId);
			output.clear();
			assertTrue("Failed to read counters structure", interaction.execute(interactionSpec, input, output));
			counters = (MappedRecord) output.get(OV_COUNTERS_PARAM);
			assertNotNull("Counters  structure not returned in read", counters);
			countersValue = (Integer) counters.get(VALUE_PARAM);
			assertEquals("Counters value not updated correctly", 2 * INIT_VALUE, countersValue);
			
			// Start transaction
			connection.getLocalTransaction().begin();
			
			// Delete counters structure
			interactionSpec.setFunctionName(DELETE_COUNTERS_FUNC);
			input.clear();
			input.put(IV_COUNTERID_PARAM, countersId);
			output.clear();
			assertTrue("Failed to delete counters structure", interaction.execute(interactionSpec, input, output));
			
			// Commit transaction
			connection.getLocalTransaction().commit();
			
			// Verify counters structure deleted.
			interactionSpec.setFunctionName(READ_COUNTERS_FUNC);
			input.clear();
			input.put(IV_COUNTERID_PARAM, countersId);
			output.clear();
			assertFalse("Failed to delete counters structure", interaction.execute(interactionSpec, input, output));
			
			
		} finally {
			if (connection != null)
				connection.close();
		}
	}

}
