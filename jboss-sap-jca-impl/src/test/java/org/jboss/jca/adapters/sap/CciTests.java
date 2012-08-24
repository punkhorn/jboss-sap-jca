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
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.resource.cci.IndexedRecord;
import javax.resource.cci.Interaction;
import javax.resource.cci.MappedRecord;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.jca.adapters.sap.cci.JBossSAPConnection;
import org.jboss.jca.adapters.sap.cci.JBossSAPInteractionSpec;
import org.jboss.jca.adapters.sap.impl.RecordFactoryImpl;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.ResourceAdapterArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * CciTests - Tests JBoss SAP CCI API
 * 
 * @author William Collins
 * 
 */
@SuppressWarnings({ "unchecked" })
@RunWith(Arquillian.class)
public class CciTests {

	private static Logger log = Logger.getLogger("CciTests");

	private static String deploymentName = "CciTests";

	//
	// Parameters for Simple Interaction Test
	//

	private static final String REQUTEXT = "Hello SAP!";
	private static final String REQUTEXT_PARAM = "REQUTEXT";
	private static final String ECHOTEXT_PARAM = "ECHOTEXT";

	//
	// Parameters for Parameter Passing Test
	//

	private static final String IMPORT_CHAR_PARAM = "IMPORT_CHAR_PARAM";
	private static final String CHANGING_CHAR_PARAM = "CHANGING_CHAR_PARAM";
	private static final String EXPORT_CHAR_PARAM = "EXPORT_CHAR_PARAM";
	private static final String CHAR_PARAM_VAL = "ABCDEFGHIJ";
	private static final String CHAR_PARAM_RETURN = "ZYXWVUTSRQ";

	private static final String IMPORT_NUM_PARAM = "IMPORT_NUM_PARAM";
	private static final String CHANGING_NUM_PARAM = "CHANGING_NUM_PARAM";
	private static final String EXPORT_NUM_PARAM = "EXPORT_NUM_PARAM";
	private static final String NUM_PARAM_VAL = "0123456789";
	private static final String NUM_PARAM_RETURN = "9876543210";

	private static final String IMPORT_INT_PARAM = "IMPORT_INT_PARAM";
	private static final String CHANGING_INT_PARAM = "CHANGING_INT_PARAM";
	private static final String EXPORT_INT_PARAM = "EXPORT_INT_PARAM";
	private static final int INT_PARAM_VAL = 0x75555555;
	private static final int INT_PARAM_RETURN = 0x7AAAAAAA;

	private static final String IMPORT_FLOAT_PARAM = "IMPORT_FLOAT_PARAM";
	private static final String CHANGING_FLOAT_PARAM = "CHANGING_FLOAT_PARAM";
	private static final String EXPORT_FLOAT_PARAM = "EXPORT_FLOAT_PARAM";
	private static final double FLOAT_PARAM_VAL = Math.pow(10, 38); // This seems to be the biggest double to not come
																	// back as infinity.
	private static final double FLOAT_PARAM_DELTA_VALUE = Math.pow(10, 31); // Looks like the returned double is
																			// accurate to 7 decimal places.
	private static final double FLOAT_PARAM_RETURN = 2 * Math.pow(10, 38);

	private static final String IMPORT_BCD_PARAM = "IMPORT_BCD_PARAM";
	private static final String CHANGING_BCD_PARAM = "CHANGING_BCD_PARAM";
	private static final String EXPORT_BCD_PARAM = "EXPORT_BCD_PARAM";
	private static final BigDecimal BCD_PARAM_VAL = new BigDecimal("100.00000000000001");
	private static final BigDecimal BCD_PARAM_RETURN = new BigDecimal("200.00000000000002");

	private static final String IMPORT_BINARY_PARAM = "IMPORT_BINARY_PARAM";
	private static final String CHANGING_BINARY_PARAM = "CHANGING_BINARY_PARAM";
	private static final String EXPORT_BINARY_PARAM = "EXPORT_BINARY_PARAM";
	private static final byte[] BINARY_PARAM_VAL = new byte[] { (byte) 0x55 };
	private static final byte[] BINARY_PARAM_RETURN = new byte[] { (byte) 0xAA };

	private static final String IMPORT_BINARY_ARRAY_PARAM = "IMPORT_BINARY_ARRAY_PARAM";
	private static final String CHANGING_BINARY_ARRAY_PARAM = "CHANGING_BINARY_ARRAY_PARAM";
	private static final String EXPORT_BINARY_ARRAY_PARAM = "EXPORT_BINARY_ARRAY_PARAM";
	private static final byte[] BINARY_ARRAY_PARAM_VAL = new byte[] { (byte) 0xFF, (byte) 0x0F, (byte) 0x1E,
			(byte) 0x2D, (byte) 0x3C, (byte) 0x4B, (byte) 0x5A, (byte) 0x60, (byte) 0x79, (byte) 0x88 };
	private static final byte[] BINARY_ARRAY_PARAM_RETURN = new byte[] { (byte) 0x88, (byte) 0x79, (byte) 0x60,
			(byte) 0x5A, (byte) 0x4B, (byte) 0x3C, (byte) 0x2D, (byte) 0x1E, (byte) 0x0F, (byte) 0xFF };

	private static final String IMPORT_DATE_PARAM = "IMPORT_DATE_PARAM";
	private static final String CHANGING_DATE_PARAM = "CHANGING_DATE_PARAM";
	private static final String EXPORT_DATE_PARAM = "EXPORT_DATE_PARAM";
	private static final Date DATE_PARAM_VAL = new GregorianCalendar(1861, 03, 12).getTime();
	private static final Date DATE_PARAM_RETURN = new GregorianCalendar(1865, 03, 9).getTime();

	private static final String IMPORT_TIME_PARAM = "IMPORT_TIME_PARAM";
	private static final String CHANGING_TIME_PARAM = "CHANGING_TIME_PARAM";
	private static final String EXPORT_TIME_PARAM = "EXPORT_TIME_PARAM";
	private static final Date TIME_PARAM_VAL = new GregorianCalendar(1970, 0, 1, 12, 15, 30).getTime();
	private static final Date TIME_PARAM_RETURN = new GregorianCalendar(1970, 0, 1, 23, 45, 15).getTime();

	private static final String IMPORT_STRING_PARAM = "IMPORT_STRING_PARAM";
	private static final String CHANGING_STRING_PARAM = "CHANGING_STRING_PARAM";
	private static final String EXPORT_STRING_PARAM = "EXPORT_STRING_PARAM";
	private static final String STRING_PARAM_VAL = "Four score and seven years ago ...";
	private static final String STRING_PARAM_RETURN = "... shall not perish from this earth.";

	private static final String IMPORT_STRUCTURE_PARAM = "IMPORT_STRUCTURE_PARAM";
	private static final String CHANGING_STRUCTURE_PARAM = "CHANGING_STRUCTURE_PARAM";
	private static final String EXPORT_STRUCTURE_PARAM = "EXPORT_STRUCTURE_PARAM";
	private static final String CHAR_PARAM = "CHAR_PARAM";
	private static final String NUM_PARAM = "NUM_PARAM";
	private static final String INT_PARAM = "INT_PARAM";
	private static final String FLOAT_PARAM = "FLOAT_PARAM";
	private static final String BCD_PARAM = "BCD_PARAM";
	private static final String BINARY_PARAM = "BINARY_PARAM";
	private static final String BINARY_ARRAY_PARAM = "BINARY_ARRAY_PARAM";
	private static final String DATE_PARAM = "DATE_PARAM";
	private static final String TIME_PARAM = "TIME_PARAM";
	private static final String STRING_PARAM = "STRING_PARAM";

	private static final String TABLE_TABLE_PARAM = "TABLE_TABLE_PARAM";

	/**
	 * Define the deployment
	 * 
	 * @return The deployment archive
	 */
	@Deployment
	public static ResourceAdapterArchive createDeployment() {
		log.info("Creating deployment for Cci Tests");

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

	/**
	 * Test connectivity to SAP instance.
	 * 
	 * @exception Throwable
	 *                Thrown in case of a test error
	 */
	@Test
	public void testConnection() throws Throwable {
		JBossSAPConnection connection = null;
		try {
			log.info("Testing Connection");
			assertNotNull("Failed to access connection factory 'DefaultTestsFactory'", connectionFactory);
			connection = (JBossSAPConnection) connectionFactory.getConnection();
			assertNotNull("Failed to create connection", connection);
			log.info("Connection test succeeded!");
		} finally {
			if (connection != null)
				connection.close();
		}
	}

	/**
	 * Tests interaction with SAP instance by sending string to STFC_CONNECTION function module and checking that it
	 * receives back the same string.
	 * 
	 * @throws Throwable
	 *             Thrown if case of an test error
	 */
	@Test
	public void testSimpleInteraction() throws Throwable {
		JBossSAPConnection connection = null;
		try {
			log.info("Testing Simple Interaction");
			assertNotNull("Failed to access connection factory 'DefaultTestsFactory'", connectionFactory);
			connection = (JBossSAPConnection) connectionFactory.getConnection();
			assertNotNull("Failed to create connection", connection);

			Interaction interaction = connection.createInteraction();
			JBossSAPInteractionSpec interactionSpec = new JBossSAPInteractionSpec();
			interactionSpec.setFunctionName("STFC_CONNECTION");
			MappedRecord input = RecordFactoryImpl.INSTANCE.createMappedRecord("input");
			input.put(REQUTEXT_PARAM, REQUTEXT);
			MappedRecord output = RecordFactoryImpl.INSTANCE.createMappedRecord("output");
			assertTrue("Simple Interaction Execution Failed", interaction.execute(interactionSpec, input, output));
			String echoText = (String) output.get(ECHOTEXT_PARAM);
			assertEquals("Echoed text does not match request text", REQUTEXT, echoText);

		} finally {
			if (connection != null)
				connection.close();
		}
	}

	/**
	 * Tests sending and receiving parameters of variety of types to and from ABAP function module through Import,
	 * Export, Changing and Table parameter lists.
	 * 
	 * <p>
	 * NB: This unit test requires ZJBOSS_PARAM_TEST function module be installed and activated in targeted SAP
	 * instance.
	 * 
	 * @throws Throwable
	 *             Thrown if case of an test error
	 */
	@Test
	public void testParameterPassing() throws Throwable {
		JBossSAPConnection connection = null;
		try {
			log.info("Testing Parameter Passing");
			assertNotNull("Failed to access connection factory 'DefaultTestsFactory'", connectionFactory);
			connection = (JBossSAPConnection) connectionFactory.getConnection();
			assertNotNull("Failed to create connection", connection);

			//
			// Create interaction to invoke ZJBOSS_PARAM_TEST function module.
			//

			Interaction interaction = connection.createInteraction();
			JBossSAPInteractionSpec interactionSpec = new JBossSAPInteractionSpec();
			interactionSpec.setFunctionName("ZJBOSS_PARAM_TEST");

			//
			// Create input record to pass parameters to function module.
			//

			MappedRecord input = connectionFactory.getRecordFactory().createMappedRecord("input");

			//
			// Populate input record with import and changing parameters.
			//

			input.put(IMPORT_CHAR_PARAM, CHAR_PARAM_VAL);
			input.put(IMPORT_NUM_PARAM, NUM_PARAM_VAL);
			input.put(IMPORT_INT_PARAM, INT_PARAM_VAL);
			input.put(IMPORT_FLOAT_PARAM, FLOAT_PARAM_VAL);
			input.put(IMPORT_BCD_PARAM, BCD_PARAM_VAL);
			input.put(IMPORT_BINARY_PARAM, BINARY_PARAM_VAL);
			input.put(IMPORT_BINARY_ARRAY_PARAM, BINARY_ARRAY_PARAM_VAL);
			input.put(IMPORT_DATE_PARAM, DATE_PARAM_VAL);
			input.put(IMPORT_TIME_PARAM, TIME_PARAM_VAL);
			input.put(IMPORT_STRING_PARAM, STRING_PARAM_VAL);
			input.put(CHANGING_CHAR_PARAM, CHAR_PARAM_VAL);
			input.put(CHANGING_NUM_PARAM, NUM_PARAM_VAL);
			input.put(CHANGING_INT_PARAM, INT_PARAM_VAL);
			input.put(CHANGING_FLOAT_PARAM, FLOAT_PARAM_VAL);
			input.put(CHANGING_BCD_PARAM, BCD_PARAM_VAL);
			input.put(CHANGING_BINARY_PARAM, BINARY_PARAM_VAL);
			input.put(CHANGING_BINARY_ARRAY_PARAM, BINARY_ARRAY_PARAM_VAL);
			input.put(CHANGING_DATE_PARAM, DATE_PARAM_VAL);
			input.put(CHANGING_TIME_PARAM, TIME_PARAM_VAL);
			input.put(CHANGING_STRING_PARAM, STRING_PARAM_VAL);

			// Create embedded import structure, populate and add to input record.
			MappedRecord importStructureParam = RecordFactoryImpl.INSTANCE.createMappedRecord(IMPORT_STRUCTURE_PARAM);
			importStructureParam.put(CHAR_PARAM, CHAR_PARAM_VAL);
			importStructureParam.put(NUM_PARAM, NUM_PARAM_VAL);
			importStructureParam.put(INT_PARAM, INT_PARAM_VAL);
			importStructureParam.put(FLOAT_PARAM, FLOAT_PARAM_VAL);
			importStructureParam.put(BCD_PARAM, BCD_PARAM_VAL);
			importStructureParam.put(BINARY_PARAM, BINARY_PARAM_VAL);
			importStructureParam.put(BINARY_ARRAY_PARAM, BINARY_ARRAY_PARAM_VAL);
			importStructureParam.put(DATE_PARAM, DATE_PARAM_VAL);
			importStructureParam.put(TIME_PARAM, TIME_PARAM_VAL);
			importStructureParam.put(STRING_PARAM, STRING_PARAM_VAL);
			input.put(IMPORT_STRUCTURE_PARAM, importStructureParam);

			// Create embedded changing structure, populate and add to input record.
			MappedRecord changingStructureParam = RecordFactoryImpl.INSTANCE
					.createMappedRecord(CHANGING_STRUCTURE_PARAM);
			changingStructureParam.put(CHAR_PARAM, CHAR_PARAM_VAL);
			changingStructureParam.put(NUM_PARAM, NUM_PARAM_VAL);
			changingStructureParam.put(INT_PARAM, INT_PARAM_VAL);
			changingStructureParam.put(FLOAT_PARAM, FLOAT_PARAM_VAL);
			changingStructureParam.put(BCD_PARAM, BCD_PARAM_VAL);
			changingStructureParam.put(BINARY_PARAM, BINARY_PARAM_VAL);
			changingStructureParam.put(BINARY_ARRAY_PARAM, BINARY_ARRAY_PARAM_VAL);
			changingStructureParam.put(DATE_PARAM, DATE_PARAM_VAL);
			changingStructureParam.put(TIME_PARAM, TIME_PARAM_VAL);
			changingStructureParam.put(STRING_PARAM, STRING_PARAM_VAL);
			input.put(CHANGING_STRUCTURE_PARAM, importStructureParam);

			//
			// Populate input record with table parameters
			//

			IndexedRecord tableTableParam = RecordFactoryImpl.INSTANCE.createIndexedRecord(TABLE_TABLE_PARAM);
			MappedRecord tableTableRowParam = RecordFactoryImpl.INSTANCE.createMappedRecord(TABLE_TABLE_PARAM);
			tableTableRowParam.put(CHAR_PARAM, CHAR_PARAM_VAL);
			tableTableRowParam.put(NUM_PARAM, NUM_PARAM_VAL);
			tableTableRowParam.put(INT_PARAM, INT_PARAM_VAL);
			tableTableRowParam.put(FLOAT_PARAM, FLOAT_PARAM_VAL);
			tableTableRowParam.put(BCD_PARAM, BCD_PARAM_VAL);
			tableTableRowParam.put(BINARY_PARAM, BINARY_PARAM_VAL);
			tableTableRowParam.put(BINARY_ARRAY_PARAM, BINARY_ARRAY_PARAM_VAL);
			tableTableRowParam.put(DATE_PARAM, DATE_PARAM_VAL);
			tableTableRowParam.put(TIME_PARAM, TIME_PARAM_VAL);
			tableTableParam.add(tableTableRowParam);
			input.put(TABLE_TABLE_PARAM, tableTableParam);

			//
			// Create output record and execute interaction.
			//

			MappedRecord output = connectionFactory.getRecordFactory().createMappedRecord("output");
			assertTrue("ZJBOSS_PARAM_TEST failed", interaction.execute(interactionSpec, input, output));

			//
			// Extract export parameters and test return values
			//

			String exportCharParam = (String) output.get(EXPORT_CHAR_PARAM);
			assertEquals("Exported CHAR parameter does not match import", CHAR_PARAM_VAL, exportCharParam);
			String exportNumParam = (String) output.get(EXPORT_NUM_PARAM);
			assertEquals("Exported NUM parameter does not match import", NUM_PARAM_VAL, exportNumParam);
			int exportIntParam = (Integer) output.get(EXPORT_INT_PARAM);
			assertEquals("Exported INT parameter does not match import", INT_PARAM_VAL, exportIntParam);
			double exportFloatParam = (Double) output.get(EXPORT_FLOAT_PARAM);
			assertEquals("Exported FLOAT parameter does not match import", FLOAT_PARAM_VAL, exportFloatParam,
					FLOAT_PARAM_DELTA_VALUE);
			BigDecimal exportBcdParam = (BigDecimal) output.get(EXPORT_BCD_PARAM);
			assertEquals("Exported BCD parameter does not match import", BCD_PARAM_VAL, exportBcdParam);
			byte[] exportBinaryParam = (byte[]) output.get(EXPORT_BINARY_PARAM);
			assertArrayEquals("Exported BINARY parameter does not match import", BINARY_PARAM_VAL, exportBinaryParam);
			byte[] exportBinaryArrayParam = (byte[]) output.get(EXPORT_BINARY_ARRAY_PARAM);
			assertArrayEquals("Exported BINARY ARRAY parameter does not match import", BINARY_ARRAY_PARAM_VAL,
					exportBinaryArrayParam);
			Date exportDateParam = (Date) output.get(EXPORT_DATE_PARAM);
			assertEquals("Exported DATE parameter does not match import", DATE_PARAM_VAL, exportDateParam);
			Date exportTimeParam = (Date) output.get(EXPORT_TIME_PARAM);
			assertEquals("Exported TIME parameter does not match import", TIME_PARAM_VAL, exportTimeParam);
			String exportStringParam = (String) output.get(EXPORT_STRING_PARAM);
			assertEquals("Exported STRING parameter does not match import", STRING_PARAM_VAL, exportStringParam);

			MappedRecord exportStructureParam = (MappedRecord) output.get(EXPORT_STRUCTURE_PARAM);
			String charParam = (String) exportStructureParam.get(CHAR_PARAM);
			assertEquals("Exported Structure CHAR parameter does not match import", CHAR_PARAM_VAL, charParam);
			String numParam = (String) exportStructureParam.get(NUM_PARAM);
			assertEquals("Exported Structure NUM parameter does not match import", NUM_PARAM_VAL, numParam);
			int intParam = (Integer) exportStructureParam.get(INT_PARAM);
			assertEquals("Exported Structure INT parameter does not match import", INT_PARAM_VAL, intParam);
			double floatParam = (Double) exportStructureParam.get(FLOAT_PARAM);
			assertEquals("Exported Structure FLOAT parameter does not match import", FLOAT_PARAM_VAL, floatParam,
					FLOAT_PARAM_DELTA_VALUE);
			BigDecimal bcdParam = (BigDecimal) exportStructureParam.get(BCD_PARAM);
			assertEquals("Exported Structure BCD parameter does not match import", BCD_PARAM_VAL, bcdParam);
			byte[] binaryParam = (byte[]) exportStructureParam.get(BINARY_PARAM);
			assertArrayEquals("Exported Structure BINARY parameter does not match import", BINARY_PARAM_VAL,
					binaryParam);
			byte[] binaryArrayParam = (byte[]) exportStructureParam.get(BINARY_ARRAY_PARAM);
			assertArrayEquals("Exported Structure BINARY ARRAY parameter does not match import",
					BINARY_ARRAY_PARAM_VAL, binaryArrayParam);
			Date dateParam = (Date) exportStructureParam.get(DATE_PARAM);
			assertEquals("Exported Structure DATE parameter does not match import", DATE_PARAM_VAL, dateParam);
			Date timeParam = (Date) exportStructureParam.get(TIME_PARAM);
			assertEquals("Exported Structure TIME parameter does not match import", TIME_PARAM_VAL, timeParam);
			String stringParam = (String) exportStructureParam.get(STRING_PARAM);
			assertEquals("Exported Structure STRING parameter does not match import", STRING_PARAM_VAL, stringParam);

			//
			// Extract changing parameters and test return values
			//

			String changingCharParam = (String) output.get(CHANGING_CHAR_PARAM);
			assertEquals("Changing CHAR parameter does not match expected return value", CHAR_PARAM_RETURN,
					changingCharParam);
			String changingNumParam = (String) output.get(CHANGING_NUM_PARAM);
			assertEquals("Changing NUM parameter does not match expected return value", NUM_PARAM_RETURN,
					changingNumParam);
			int changingIntParam = (Integer) output.get(CHANGING_INT_PARAM);
			assertEquals("Changing INT parameter does not match expected", INT_PARAM_RETURN, changingIntParam);
			double changingFloatParam = (Double) output.get(CHANGING_FLOAT_PARAM);
			assertEquals("Changing FLOAT parameter does not match expected return value", FLOAT_PARAM_RETURN,
					changingFloatParam, FLOAT_PARAM_DELTA_VALUE);
			BigDecimal changingBcdParam = (BigDecimal) output.get(CHANGING_BCD_PARAM);
			assertEquals("Changing BCD parameter does not match expected return value", BCD_PARAM_RETURN,
					changingBcdParam);
			byte[] changingBinaryParam = (byte[]) output.get(CHANGING_BINARY_PARAM);
			assertArrayEquals("Changing BINARY parameter does not match expected return value", BINARY_PARAM_RETURN,
					changingBinaryParam);
			byte[] changingBinaryArrayParam = (byte[]) output.get(CHANGING_BINARY_ARRAY_PARAM);
			assertArrayEquals("Changing BINARY ARRAY parameter does not match expected return value",
					BINARY_ARRAY_PARAM_RETURN, changingBinaryArrayParam);
			Date changingDateParam = (Date) output.get(CHANGING_DATE_PARAM);
			assertEquals("Changing DATE parameter does not match expected return value", DATE_PARAM_RETURN,
					changingDateParam);
			Date changingTimeParam = (Date) output.get(CHANGING_TIME_PARAM);
			assertEquals("Changing TIME parameter does not match expected return value", TIME_PARAM_RETURN,
					changingTimeParam);
			String changingStringParam = (String) output.get(CHANGING_STRING_PARAM);
			assertEquals("Changing STRING parameter does not match expected return value", STRING_PARAM_RETURN,
					changingStringParam);

			changingStructureParam = (MappedRecord) output.get(CHANGING_STRUCTURE_PARAM);
			charParam = (String) changingStructureParam.get(CHAR_PARAM);
			assertEquals("Changing Structure CHAR parameter does not match expected return value", CHAR_PARAM_RETURN,
					charParam);
			numParam = (String) changingStructureParam.get(NUM_PARAM);
			assertEquals("Changing Structure NUM parameter does not match expected return value", NUM_PARAM_RETURN,
					numParam);
			intParam = (Integer) changingStructureParam.get(INT_PARAM);
			assertEquals("Changing Structure INT parameter does not match expected return value", INT_PARAM_RETURN,
					intParam);
			floatParam = (Double) changingStructureParam.get(FLOAT_PARAM);
			assertEquals("Changing Structure FLOAT parameter does not match expected return value", FLOAT_PARAM_RETURN,
					floatParam, FLOAT_PARAM_DELTA_VALUE);
			bcdParam = (BigDecimal) changingStructureParam.get(BCD_PARAM);
			assertEquals("Changing Structure BCD parameter does not match expected return value", BCD_PARAM_RETURN,
					bcdParam);
			binaryParam = (byte[]) changingStructureParam.get(BINARY_PARAM);
			assertArrayEquals("Changing Structure BINARY parameter does not match expected return value",
					BINARY_PARAM_RETURN, binaryParam);
			binaryArrayParam = (byte[]) changingStructureParam.get(BINARY_ARRAY_PARAM);
			assertArrayEquals("Changing Structure BINARY ARRAY parameter does not match expected return value",
					BINARY_ARRAY_PARAM_RETURN, binaryArrayParam);
			dateParam = (Date) changingStructureParam.get(DATE_PARAM);
			assertEquals("Changing Structure DATE parameter does not match expected return value", DATE_PARAM_RETURN,
					dateParam);
			timeParam = (Date) changingStructureParam.get(TIME_PARAM);
			assertEquals("Changing Structure TIME parameter does not match expected return value", TIME_PARAM_RETURN,
					timeParam);

			//
			// Extract table parameters and test return values
			//

			tableTableParam = (IndexedRecord) output.get(TABLE_TABLE_PARAM);
			assertNotNull("Table missing in output", tableTableParam);
			assertTrue("Table missing isEmpty", tableTableParam.size() > 0);
			tableTableRowParam = (MappedRecord) tableTableParam.get(0);
			charParam = (String) tableTableRowParam.get(CHAR_PARAM);
			assertEquals("Table CHAR parameter does not match expected return", CHAR_PARAM_RETURN, charParam);
			numParam = (String) tableTableRowParam.get(NUM_PARAM);
			assertEquals("Table NUM parameter does not match expected return", NUM_PARAM_RETURN, numParam);
			intParam = (Integer) tableTableRowParam.get(INT_PARAM);
			assertEquals("Table INT parameter does not match expected return", INT_PARAM_RETURN, intParam);
			floatParam = (Double) tableTableRowParam.get(FLOAT_PARAM);
			assertEquals("Table FLOAT parameter does not match expected return", FLOAT_PARAM_RETURN, floatParam,
					FLOAT_PARAM_DELTA_VALUE);
			bcdParam = (BigDecimal) tableTableRowParam.get(BCD_PARAM);
			assertEquals("Table BCD parameter does not match expected return", BCD_PARAM_RETURN, bcdParam);
			binaryParam = (byte[]) tableTableRowParam.get(BINARY_PARAM);
			assertArrayEquals("Table BINARY parameter does not match expected return", BINARY_PARAM_RETURN, binaryParam);
			binaryArrayParam = (byte[]) tableTableRowParam.get(BINARY_ARRAY_PARAM);
			assertArrayEquals("Table BINARY ARRAY parameter does not match expected return", BINARY_ARRAY_PARAM_RETURN,
					binaryArrayParam);
			dateParam = (Date) tableTableRowParam.get(DATE_PARAM);
			assertEquals("Table DATE parameter does not match expected return", DATE_PARAM_RETURN, dateParam);
			timeParam = (Date) tableTableRowParam.get(TIME_PARAM);
			assertEquals("Table TIME parameter does not match expected return", TIME_PARAM_RETURN, timeParam);
		} finally {
			if (connection != null)
				connection.close();
		}

	}

}
