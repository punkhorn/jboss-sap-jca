package org.jboss.jca.adapters.sap.impl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.IndexedRecord;
import javax.resource.cci.InteractionSpec;
import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.ResourceWarning;

import org.jboss.jca.adapters.sap.cci.JBossSAPInteractionSpec;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.ConversionException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoListMetaData;
import com.sap.conn.jco.JCoMetaData;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoRecord;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

public class TestInteractionImpl {
	

	/*********************************************************************
	 * Test Function And Record Names
	 *********************************************************************/
	private static final String TEST_FUNCTION_NAME = "testFunctionName";
	private static final String INPUT_RECORD_NAME = "input";
	private static final String OUTPUT_RECORD_NAME = "output";
	
	/*********************************************************************
	 * Test Parameter List Names
	 *********************************************************************/
	private static final String PARAM_LIST_CHAR_PARAM = "PARAM_LIST_CHAR_PARAM";
	private static final String PARAM_LIST_NUM_PARAM = "PARAM_LIST_NUM_PARAM";
	private static final String PARAM_LIST_INT_PARAM = "PARAM_LIST_INT_PARAM";
	private static final String PARAM_LIST_FLOAT_PARAM = "PARAM_LIST_FLOAT_PARAM";
	private static final String PARAM_LIST_BCD_PARAM = "PARAM_LIST_BCD_PARAM";
	private static final String PARAM_LIST_BINARY_PARAM = "PARAM_LIST_BINARY_PARAM";
	private static final String PARAM_LIST_BINARY_ARRAY_PARAM = "PARAM_LIST_BINARY_ARRAY_PARAM";
	private static final String PARAM_LIST_DATE_PARAM = "PARAM_LIST_DATE_PARAM";
	private static final String PARAM_LIST_TIME_PARAM = "PARAM_LIST_TIME_PARAM";
	private static final String PARAM_LIST_STRING_PARAM = "PARAM_LIST_STRING_PARAM";
	private static final String PARAM_LIST_STRUCTURE_PARAM = "PARAM_LIST_STRUCTURE_PARAM";
	private static final String PARAM_LIST_TABLE_PARAM = "CHANGING_TABLE_PARAM";
	private static final String TABLE_PARAM_LIST_TABLE_PARAM = "TABLE_PARAM_LIST_TABLE_PARAM";

	/*********************************************************************
	 * Test Parameter Names
	 *********************************************************************/
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
	private static final String STRUCTURE_PARAM = "STRUCTURE_PARAM";
	private static final String TABLE_PARAM = "TABLE_PARAM";


	/*********************************************************************
	 * Test Parameter Input Values
	 *********************************************************************/
	private static final String CHAR_PARAM_IN_VAL = "ABCDEFGHIJ";
	private static final String NUM_PARAM_IN_VAL = "0123456789";
	private static final int INT_PARAM_IN_VAL = 0x75555555;
	private static final double FLOAT_PARAM_IN_VAL = Math.pow(10, 38); // This seems to be the biggest double to not come
																	// back as infinity.
	private static final BigDecimal BCD_PARAMIN__VAL = new BigDecimal("100.00000000000001");
	private static final byte[] BINARY_PARAM_IN_VAL = new byte[] { (byte) 0x55 };
	private static final byte[] BINARY_ARRAY_PARAM_IN_VAL = new byte[] { (byte) 0xFF, (byte) 0x0F, (byte) 0x1E,
			(byte) 0x2D, (byte) 0x3C, (byte) 0x4B, (byte) 0x5A, (byte) 0x60, (byte) 0x79, (byte) 0x88 };
	private static final Date DATE_PARAM_IN_VAL = new GregorianCalendar(1861, 03, 12).getTime();
	private static final Date TIME_PARAM_IN_VAL = new GregorianCalendar(1970, 0, 1, 12, 15, 30).getTime();
	private static final String STRING_PARAM_IN_VAL = "Four score and seven years ago ...";

	/*********************************************************************
	 * Test Parameter Output Values
	 *********************************************************************/

	private static final String CHAR_PARAM_OUT_VAL = "ZYXWVUTSRQ";
	private static final String NUM_PARAM_OUT_VAL = "9876543210";
	private static final int INT_PARAM_OUT_VAL = 0x7AAAAAAA;
	private static final double FLOAT_PARAM_OUT_VAL = 2 * Math.pow(10, 38);
	private static final BigDecimal BCD_PARAM_OUT_VAL = new BigDecimal("200.00000000000002");
	private static final byte[] BINARY_PARAM_OUT_VAL = new byte[] { (byte) 0xAA };
	private static final byte[] BINARY_ARRAY_PARAM_OUT_VAL = new byte[] { (byte) 0x88, (byte) 0x79, (byte) 0x60,
			(byte) 0x5A, (byte) 0x4B, (byte) 0x3C, (byte) 0x2D, (byte) 0x1E, (byte) 0x0F, (byte) 0xFF };
	private static final Date DATE_PARAM_OUT_VAL = new GregorianCalendar(1865, 03, 9).getTime();
	private static final Date TIME_PARAM_OUT_VAL = new GregorianCalendar(1970, 0, 1, 23, 45, 15).getTime();
	private static final String STRING_PARAM_OUT_VAL = "... shall not perish from this earth.";


	/****************************************************************************
	 * Class Under Test
	 ****************************************************************************/
	private InteractionImpl interaction;
	
	/****************************************************************************
	 * Interaction Dependency Mocks Mocks
	 ****************************************************************************/
	private ConnectionImpl mockConnection;
	private JCoDestination mockDestination;
	
	/****************************************************************************
	 * JCo Meta Data Mocks
	 ****************************************************************************/
	private JCoListMetaData mockParameterListMetaData;
	private JCoMetaData mockStructureMetaData;
	private JCoListMetaData mockTableParameterListMetaData;

	
	/****************************************************************************
	 * JCo Data Structure Mocks
	 ****************************************************************************/
	private InteractionSpec mockInteractionSpec;
	private InteractionSpec mockInvalidInteractionSpec;
	private JCoRepository mockRepository;
	private JCoFunction mockFunction;
	private JCoParameterList mockParameterList;
	private JCoTable mockTableParameterListTable;
	private JCoStructure mockStructure;
	private JCoStructure mockEmbeddedStructure;
	private JCoTable mockTable;
	private JCoStructure mockTableStructure;
	private JCoTable mockEmbeddedTable;
	private JCoTable mockTableTable;
	private JCoStructure mockTableEmbeddedStructure;
	private JCoTable mockTableEmbeddedTable;
	private JCoParameterList mockTableParameterList;
	private ConversionException mockConversionException;

	/****************************************************************************
	 * CCI Data Structures
	 ****************************************************************************/
	private MappedRecord input;
	private MappedRecord output;
	private MappedRecord embeddedStructureRecord;
	private IndexedRecord embeddedTableRecord;
	private IndexedRecord tableRecord;
	private IndexedRecordImpl tableTable;
	private MappedRecordImpl tableEmbeddedStructure;
	private IndexedRecordImpl tableEmbeddedTable;
	private MappedRecordImpl structureRecord;
	private	InteractionSpec mockBogusInteractionSpec;
	private Record mockBogusRecord;
	private Record mockInvalidMappedRecord;
	private Record mockInvalidIndexedRecord;

	@Before
	public void setUp() throws Exception {
		mockConnection = mock(ConnectionImpl.class);
		mockDestination = mock(JCoDestination.class);
		when(mockConnection.getDestination()).thenReturn(mockDestination);
		
		interaction = new InteractionImpl(mockConnection);
	}

	@Test
	public void testClose() throws ResourceException {
		// When
		interaction.close();
		
		// Then
		verify(mockConnection).interactionClosed(interaction);
	}

	@Test
	public void testCloseOnClosedInteraction() throws ResourceException {
		// Given
		interaction.close();
		
		// When
		interaction.close();
		
		// Then
		verify(mockConnection).interactionClosed(interaction); /* verify interactionClose() is called only once */
	}

	@Test
	public void testGetConnection() {
		// When
		Connection connection = interaction.getConnection();
		
		// Then
		assertThat("InteractionImpl.getConnection() returned different instance of ConnectionImpl than used to initialized Interaction", (ConnectionImpl) connection, is(mockConnection));
	}
	
	@Test
	public void testExecuteWithInputAndOutputRecord() throws JCoException, ResourceException {
		// Given
		setupParameterListMetaData();
		setupParameterList();
		setupTableParameterList();
		setupInputAndOutputRecords();
		setupInteractionParametersWithChangingAndTableParameterLists();
		
		// When
		interaction.execute(mockInteractionSpec, input, output);
		
		// Then
		verifyExecuteBehavior();
		verifyPopulateInputBehavior();
	}

	@Test(expected = ResourceException.class)
	public void testExecuteWithInvalidInteractionSpec() throws JCoException, ResourceException {
		// Given
		setupParameterListMetaData();
		setupParameterList();
		setupTableParameterList();
		setupInputAndOutputRecords();
		setupInteractionParametersWithChangingAndTableParameterLists();
		
		// When
		interaction.execute(mockBogusInteractionSpec, input, output);
		
		// Then
		fail("InteractionImpl.execute(interactionSpec,inputRecord,outputRecord) called with invalid InteractionSpec failed to throw ResourceException");
	}

	@Test(expected = ResourceException.class)
	public void testExecuteWithInvalidInputRecord() throws JCoException, ResourceException {
		// Given
		setupParameterListMetaData();
		setupParameterList();
		setupTableParameterList();
		setupInputAndOutputRecords();
		setupInteractionParametersWithChangingAndTableParameterLists();
		
		// When
		interaction.execute(mockInteractionSpec, mockBogusRecord, output);
		
		// Then
		fail("InteractionImpl.execute(interactionSpec,inputRecord,outputRecord) called with invalid input Record failed to throw ResourceException");
	}

	@Test(expected = ResourceException.class)
	public void testExecuteWithInvalidOutputRecord() throws JCoException, ResourceException {
		// Given
		setupParameterListMetaData();
		setupParameterList();
		setupTableParameterList();
		setupInputAndOutputRecords();
		setupInteractionParametersWithChangingAndTableParameterLists();
		
		// When
		interaction.execute(mockInteractionSpec, input, mockBogusRecord);
		
		// Then
		fail("InteractionImpl.execute(interactionSpec,inputRecord,outputRecord) called with invalid output Record failed to throw ResourceException");
	}

	@Test(expected = ResourceException.class)
	public void testExecuteWithInvalidFunctionName() throws JCoException, ResourceException {
		// Given
		setupParameterListMetaData();
		setupParameterList();
		setupTableParameterList();
		setupInputAndOutputRecords();
		setupInteractionParametersWithChangingAndTableParameterLists();
		
		// When
		interaction.execute(mockInvalidInteractionSpec, input, output);
		
		// Then
		fail("InteractionImpl.execute(interactionSpec,inputRecord,outputRecord) called with InteractionSpec with null function name failed to throw ResourceException");
	}

	@Test(expected = ResourceException.class)
	public void testExecuteWithFunctionExecuteThrowingJCoException() throws JCoException, ResourceException {
		// Given
		setupParameterListMetaData();
		setupParameterList();
		setupTableParameterList();
		setupInputAndOutputRecords();
		setupInteractionParametersWithChangingAndTableParameterLists();
		JCoException mockJCoException = mock(JCoException.class);
		doThrow(mockJCoException).when(mockFunction).execute(mockDestination);
		
		// When
		interaction.execute(mockInteractionSpec, input, output);
		
		// Then
		fail("InteractionImpl.execute(interactionSpec,inputRecord,outputRecord) failed to throw ResourceException when underlying JCoFunction threw JCoException");
	}

	@Test
	public void testExecuteWithFunctionExecuteThrowingAbapException() throws JCoException, ResourceException {
		// Given
		setupParameterListMetaData();
		setupParameterList();
		setupTableParameterList();
		setupInputAndOutputRecords();
		setupInteractionParametersWithChangingAndTableParameterLists();
		AbapException mockAbapException = mock(AbapException.class);
		doThrow(mockAbapException).when(mockFunction).execute(mockDestination);
		
		// When
		boolean success = interaction.execute(mockInteractionSpec, input, output);
		
		// Then
		if (success)
			fail("InteractionImpl.execute(interactionSpec,inputRecord,outputRecord) failed to return false when underlying JCoFunction threw AbapException");
	}

	@Test(expected = ResourceException.class)
	public void testExecuteWithMissingRequiredInputParameter() throws JCoException, ResourceException {
		// Given
		setupParmeterListMetaDataForMissingRequiredParameter();
		setupParameterListForMissingRequiredParameter();
		setupInputAndOutputRecordsWithNoRecords();
		setupInteractionParametersWithImportParameterList();
		
		// When
		interaction.execute(mockInteractionSpec, input, output);
		
		// Then
		fail("InteractionImpl.execute(interactionSpec,inputRecord,outputRecord) with missing required input parameter failed to throw ResourceException");
	}

	@Test
	public void testExecuteWithMissingOptionalInputParameter() throws JCoException, ResourceException {
		// Given
		setupParameterListMetaDataForMissingOptionalParameter();
		setupParameterListForMissingOptionalParameter();
		setupInputAndOutputRecordsWithNoRecords();
		setupInteractionParametersWithImportParameterList();
		
		// When
		interaction.execute(mockInteractionSpec, input, output);
		
		// Then
		verify(mockParameterListMetaData).isOptional(0);
	}
	
	@Test(expected = ResourceException.class)
	public void testExecuteWithInvalidMappedRecordInParameterList() throws JCoException, ResourceException {
		// Given
		setupParameterListMetaDataForInvalidMappedRecordInParameterList();
		setupParameterListForInvalidMappedRecordInParameterList();
		setupInputAndOutputRecordsForInvalidMappedRecordInParameterList();
		setupInteractionParametersWithImportParameterList();
		
		// When
		interaction.execute(mockInteractionSpec, input, output);
		
		// Then
		fail("InteractionImpl.execute(interactionSpec,inputRecord,outputRecord) with invalid type of MappedRecord in parameter list failed to throw ResourceException");
	}

	@Test(expected = ResourceException.class)
	public void testExecuteWithInvalidIndexedRecordInParameterList() throws JCoException, ResourceException {
		// Given
		setupParameterListMetaDataForInvalidIndexedRecordInParameterList();
		setupParameterListForInvalidIndexedRecordInParameterList();
		setupInputAndOutputRecordsForInvalidIndexedRecordInParameterList();
		setupInteractionParametersWithImportParameterList();
		
		// When
		interaction.execute(mockInteractionSpec, input, output);
		
		// Then
		fail("InteractionImpl.execute(interactionSpec,inputRecord,outputRecord) with invalid type of IndexedRecord in parameter list failed to throw ResourceException");
	}

	@Test(expected = ResourceException.class)
	public void testExecuteWithInvalidMappedRecordInStructure() throws JCoException, ResourceException {
		// Given
		setupParameterListMetaDataForInvalidMappedRecordInStructure();
		setupParameterListForInvalidMappedRecordInStructure();
		setupInputAndOutputRecordsForInvalidMappedRecordInStructure();
		setupInteractionParametersWithImportParameterList();
		
		// When
		interaction.execute(mockInteractionSpec, input, output);
		
		// Then
		fail("InteractionImpl.execute(interactionSpec,inputRecord,outputRecord) with invalid type of MappedRecord in structure failed to throw ResourceException");
	}

	@Test(expected = ResourceException.class)
	public void testExecuteWithInvalidIndexedRecordInStructure() throws JCoException, ResourceException {
		// Given
		setupParameterListMetaDataForInvalidIndexedRecordInStructure();
		setupParameterListForInvalidIndexedRecordInStructure();
		setupInputAndOutputRecordsForInvalidIndexedRecordInStructure();
		setupInteractionParametersWithImportParameterList();
		
		// When
		interaction.execute(mockInteractionSpec, input, output);
		
		// Then
		fail("InteractionImpl.execute(interactionSpec,inputRecord,outputRecord) with invalid type of IndexedRecord in structure failed to throw ResourceException");
	}
	
	@Test(expected = ResourceException.class)
	public void testExecuteWithInvalidMappedRecordInTable() throws JCoException, ResourceException {
		// Given
		setupTableParameterListMetaDataForInvalidMappedRecordInTable();
		setupTableParameterListForInvalidMappedRecordInTable();
		setupInputAndOutputRecordsForInvalidMappedRecordInTable();
		setupInteractionParametersWithTableParameterList();
		
		// When
		interaction.execute(mockInteractionSpec, input, output);
		
		// Then
		fail("InteractionImpl.execute(interactionSpec,inputRecord,outputRecord) with invalid type of MappedRecord in table failed to throw ResourceException");
		
	}

	@Test
	public void testExecuteWithEmptyTableParameter() throws JCoException, ResourceException {
		// Given
		setupTableParameterListMetaDataForEmptyTableParameter();
		setupTableParameterListForEmptyTableParameter();
		setupInputAndOutputRecordsWithNoRecords();
		setupInteractionParametersWithTableParameterList();
		
		// When
		interaction.execute(mockInteractionSpec, input, output);
		
		// Then
		verify(mockTableParameterListTable, never()).appendRow();
	}

	@Test(expected = ResourceException.class)
	public void testExecuteWithInvalidTableParameter() throws JCoException, ResourceException {
		// Given
		setupTableParameterListMetaDataForInvalidTableParameter();
		setupTableParameterListForInvalidTableParameter();
		setupInputAndOutputRecordsWithInvalidTableParameter();
		setupInteractionParametersWithTableParameterList();
		
		// When
		interaction.execute(mockInteractionSpec, input, output);
		
		// Then	
		fail("InteractionImpl.execute(interactionSpec,inputRecord,outputRecord) with invalid table parameter failed to throw ResourceException");
	}	

	@Ignore
	@Test(expected = ResourceException.class)
	public void testExecuteWithImportParameterCausingConversionException() throws JCoException, ResourceException {
		// Given
		setupParmeterListMetaDataForImportParameterCausingConversionException();
		setupParameterListForImportParameterCausingConversionException();
		setupInputAndOutputRecordsForImportParameterCausingConversionException();
		setupInteractionParametersWithImportParameterList();
		
		// When
		interaction.execute(mockInteractionSpec, input, output);
		
		// Then	
		fail("InteractionImpl.execute(interactionSpec,inputRecord,outputRecord) with import parameter causing conversion exception failed to throw ResourceException");
	}	

	@Test
	public void testExecuteInteractionWithInputRecordOnly() throws JCoException, ResourceException {
		// Given
		setupParameterListMetaData();
		setupInputAndOutputRecords();
		setupParameterList();
		setupTableParameterList();
		setupInteractionParametersWithChangingAndTableParameterLists();
		
		// When
		interaction.execute(mockInteractionSpec, input);
		
		// Then
		verifyExecuteBehavior();
		verifyPopulateInputBehavior();
	}

	@Test
	public void testExecuteInteractionWithInputRecordOnlyAndFunctionExecuteThrowingAbapException() throws JCoException, ResourceException {
		// Given
		setupParameterListMetaData();
		setupInputAndOutputRecords();
		setupParameterList();
		setupTableParameterList();
		setupInteractionParametersWithChangingAndTableParameterLists();
		AbapException mockAbapException = mock(AbapException.class);
		doThrow(mockAbapException).when(mockFunction).execute(mockDestination);
		
		// When
		Record output = interaction.execute(mockInteractionSpec, input);
		
		// Then
		if (output != null)
			fail("InteractionImpl.execute(interactionSpec,inputRecord) failed to return null when underlying JCoFunction threw AbapException");
	}

	@Test
	public void testGetWarnings() throws JCoException, ResourceException {
		// Given
		setupParameterListMetaData();
		setupInputAndOutputRecords();
		setupParameterList();
		setupTableParameterList();
		setupInteractionParametersWithChangingAndTableParameterLists();
		AbapException mockAbapException = mock(AbapException.class);
		doThrow(mockAbapException).when(mockFunction).execute(mockDestination);
		
		// When
		interaction.execute(mockInteractionSpec, input, output);
		ResourceWarning warning = interaction.getWarnings();
		
		// Then
		if (warning == null)
			fail("InteractionImpl.execute(interactionSpec,inputRecord,outputRecord) failed to set ResourceWarning when underlying JCoFunction threw AbapException");
	}

	@Test
	public void testClearWarnings() throws JCoException, ResourceException {
		// Given
		setupParameterListMetaData();
		setupInputAndOutputRecords();
		setupParameterList();
		setupTableParameterList();
		setupInteractionParametersWithChangingAndTableParameterLists();
		AbapException mockAbapException = mock(AbapException.class);
		doThrow(mockAbapException).when(mockFunction).execute(mockDestination);
		
		// When
		interaction.execute(mockInteractionSpec, input, output);
		interaction.clearWarnings();
		ResourceWarning warning = interaction.getWarnings();
		
		// Then
		if (warning != null)
			fail("InteractionImpl.clearWarnings() failed to clear ResourceWarning");
	}
	
	/*********************************************************************************************************
	 * Setups for Tests
	 *********************************************************************************************************/

	/**
	 * Setups for Interaction Parameters 
	 */
	
	private void setupInteractionParametersWithChangingAndTableParameterLists() throws JCoException {
		
		/* Create mocks for interaction execution */
		mockInteractionSpec = mock(JBossSAPInteractionSpec.class);
		mockInvalidInteractionSpec = mock(JBossSAPInteractionSpec.class);
		mockBogusInteractionSpec = mock(InteractionSpec.class);
		mockRepository = mock(JCoRepository.class);
		mockFunction = mock(JCoFunction.class);

		/* Enhance repository and interaction spec for test function */
		when(((JBossSAPInteractionSpec)mockInteractionSpec).getFunctionName()).thenReturn(TEST_FUNCTION_NAME);
		when(mockDestination.getRepository()).thenReturn(mockRepository);
		when(mockRepository.getFunction(TEST_FUNCTION_NAME)).thenReturn(mockFunction);
		
		/* Enhance function mock with parameter lists */
		when(mockFunction.getChangingParameterList()).thenReturn(mockParameterList);
		when(mockFunction.getTableParameterList()).thenReturn(mockTableParameterList);
		
	}
	
	private void setupInteractionParametersWithImportParameterList() throws JCoException {
		
		/* Create mocks for interaction execution */
		mockInteractionSpec = mock(JBossSAPInteractionSpec.class);
		mockBogusInteractionSpec = mock(InteractionSpec.class);
		mockRepository = mock(JCoRepository.class);
		mockFunction = mock(JCoFunction.class);

		/* Enhance repository and interaction spec for test function */
		when(((JBossSAPInteractionSpec)mockInteractionSpec).getFunctionName()).thenReturn(TEST_FUNCTION_NAME);
		when(mockDestination.getRepository()).thenReturn(mockRepository);
		when(mockRepository.getFunction(TEST_FUNCTION_NAME)).thenReturn(mockFunction);
		
		/* Enhance function mock with parameter lists */
		when(mockFunction.getImportParameterList()).thenReturn(mockParameterList);
		
	}

	private void setupInteractionParametersWithTableParameterList() throws JCoException {
		
		/* Create mocks for interaction execution */
		mockInteractionSpec = mock(JBossSAPInteractionSpec.class);
		mockRepository = mock(JCoRepository.class);
		mockFunction = mock(JCoFunction.class);

		/* Enhance repository and interaction spec for test function */
		when(((JBossSAPInteractionSpec)mockInteractionSpec).getFunctionName()).thenReturn(TEST_FUNCTION_NAME);
		when(mockDestination.getRepository()).thenReturn(mockRepository);
		when(mockRepository.getFunction(TEST_FUNCTION_NAME)).thenReturn(mockFunction);
		
		/* Enhance function mock with parameter lists */
		when(mockFunction.getTableParameterList()).thenReturn(mockTableParameterList);
		
	}
	
	/**
	 * Common Setups for Parameter Passing Tests
	 */
	
	private void setupParameterListMetaData() {
		
		/* Create mock for parameter list meta data */
		mockParameterListMetaData = mock(JCoListMetaData.class, "ParameterListMetaData");
		
		/* Create mock for table parameter list meta data */
		mockTableParameterListMetaData = mock(JCoListMetaData.class, "TableParameterListMetaData");
		
		/* Create mock for structure meta data */
		mockStructureMetaData = mock(JCoMetaData.class, "StructureMetaData");

		/* Enhance Parameter List Meta Data mock */
		when(mockParameterListMetaData.getName(0)).thenReturn(PARAM_LIST_CHAR_PARAM);
		when(mockParameterListMetaData.getName(1)).thenReturn(PARAM_LIST_NUM_PARAM);
		when(mockParameterListMetaData.getName(2)).thenReturn(PARAM_LIST_INT_PARAM);
		when(mockParameterListMetaData.getName(3)).thenReturn(PARAM_LIST_FLOAT_PARAM);
		when(mockParameterListMetaData.getName(4)).thenReturn(PARAM_LIST_BCD_PARAM);
		when(mockParameterListMetaData.getName(5)).thenReturn(PARAM_LIST_BINARY_PARAM);
		when(mockParameterListMetaData.getName(6)).thenReturn(PARAM_LIST_BINARY_ARRAY_PARAM);
		when(mockParameterListMetaData.getName(7)).thenReturn(PARAM_LIST_DATE_PARAM);
		when(mockParameterListMetaData.getName(8)).thenReturn(PARAM_LIST_TIME_PARAM);
		when(mockParameterListMetaData.getName(9)).thenReturn(PARAM_LIST_STRING_PARAM);
		when(mockParameterListMetaData.getName(10)).thenReturn(PARAM_LIST_STRUCTURE_PARAM);
		when(mockParameterListMetaData.isStructure(10)).thenReturn(true);
		when(mockParameterListMetaData.getName(11)).thenReturn(PARAM_LIST_TABLE_PARAM);
		when(mockParameterListMetaData.isTable(11)).thenReturn(true);
		when(mockParameterListMetaData.getFieldCount()).thenReturn(12);
		
		/* Enhance Table Parameter List Meta Data mock*/
		when(mockTableParameterListMetaData.getName(0)).thenReturn(TABLE_PARAM_LIST_TABLE_PARAM);
		when(mockTableParameterListMetaData.getFieldCount()).thenReturn(1);

		/* Enhance Structure Meta Data mock*/
		when(mockStructureMetaData.getName(0)).thenReturn(CHAR_PARAM);
		when(mockStructureMetaData.getName(1)).thenReturn(NUM_PARAM);
		when(mockStructureMetaData.getName(2)).thenReturn(INT_PARAM);
		when(mockStructureMetaData.getName(3)).thenReturn(FLOAT_PARAM);
		when(mockStructureMetaData.getName(4)).thenReturn(BCD_PARAM);
		when(mockStructureMetaData.getName(5)).thenReturn(BINARY_PARAM);
		when(mockStructureMetaData.getName(6)).thenReturn(BINARY_ARRAY_PARAM);
		when(mockStructureMetaData.getName(7)).thenReturn(DATE_PARAM);
		when(mockStructureMetaData.getName(8)).thenReturn(TIME_PARAM);
		when(mockStructureMetaData.getName(9)).thenReturn(STRING_PARAM);
		when(mockStructureMetaData.getName(10)).thenReturn(STRUCTURE_PARAM);
		when(mockStructureMetaData.isStructure(10)).thenReturn(true);
		when(mockStructureMetaData.getName(11)).thenReturn(TABLE_PARAM);
		when(mockStructureMetaData.isTable(11)).thenReturn(true);
		when(mockStructureMetaData.getFieldCount()).thenReturn(12);
		
	}
	
	private void setupParameterList() {
		
		/* Create mocks for parameters */
		mockParameterList = mock(JCoParameterList.class, "ParameterList");
		mockStructure = mock(JCoStructure.class, "Structure");
		mockEmbeddedStructure = mock(JCoStructure.class, "EmbeddedStructure");
		mockTable = mock(JCoTable.class, "Table");
		mockEmbeddedTable = mock(JCoTable.class, "EmbeddedStructure");
		
		/* Enhance Parameter List mock */
		when(mockParameterList.getListMetaData()).thenReturn(mockParameterListMetaData);
		when(mockParameterList.getValue(PARAM_LIST_CHAR_PARAM)).thenReturn(CHAR_PARAM_OUT_VAL);
		when(mockParameterList.getValue(PARAM_LIST_NUM_PARAM)).thenReturn(NUM_PARAM_OUT_VAL);
		when(mockParameterList.getValue(PARAM_LIST_INT_PARAM)).thenReturn(INT_PARAM_OUT_VAL);
		when(mockParameterList.getValue(PARAM_LIST_FLOAT_PARAM)).thenReturn(FLOAT_PARAM_OUT_VAL);
		when(mockParameterList.getValue(PARAM_LIST_BCD_PARAM)).thenReturn(BCD_PARAM_OUT_VAL);
		when(mockParameterList.getValue(PARAM_LIST_BINARY_PARAM)).thenReturn(BINARY_PARAM_OUT_VAL);
		when(mockParameterList.getValue(PARAM_LIST_BINARY_ARRAY_PARAM)).thenReturn(BINARY_ARRAY_PARAM_OUT_VAL);
		when(mockParameterList.getValue(PARAM_LIST_DATE_PARAM)).thenReturn(DATE_PARAM_OUT_VAL);
		when(mockParameterList.getValue(PARAM_LIST_TIME_PARAM)).thenReturn(TIME_PARAM_OUT_VAL);
		when(mockParameterList.getValue(PARAM_LIST_STRING_PARAM)).thenReturn(STRING_PARAM_OUT_VAL);
		when(mockParameterList.getValue(PARAM_LIST_STRUCTURE_PARAM)).thenReturn(mockStructure);
		when(mockParameterList.getStructure(10)).thenReturn(mockStructure);
		when(mockParameterList.getValue(PARAM_LIST_TABLE_PARAM)).thenReturn(mockTable);
		when(mockParameterList.getTable(11)).thenReturn(mockTable);
		
		/* Enhance Structure mock */
		when(mockStructure.getMetaData()).thenReturn(mockStructureMetaData);
		when(mockStructure.getValue(CHAR_PARAM)).thenReturn(CHAR_PARAM_OUT_VAL);
		when(mockStructure.getValue(NUM_PARAM)).thenReturn(NUM_PARAM_OUT_VAL);
		when(mockStructure.getValue(INT_PARAM)).thenReturn(INT_PARAM_OUT_VAL);
		when(mockStructure.getValue(FLOAT_PARAM)).thenReturn(FLOAT_PARAM_OUT_VAL);
		when(mockStructure.getValue(BCD_PARAM)).thenReturn(BCD_PARAM_OUT_VAL);
		when(mockStructure.getValue(BINARY_PARAM)).thenReturn(BINARY_PARAM_OUT_VAL);
		when(mockStructure.getValue(BINARY_ARRAY_PARAM)).thenReturn(BINARY_ARRAY_PARAM_OUT_VAL);
		when(mockStructure.getValue(DATE_PARAM)).thenReturn(DATE_PARAM_OUT_VAL);
		when(mockStructure.getValue(TIME_PARAM)).thenReturn(TIME_PARAM_OUT_VAL);
		when(mockStructure.getValue(STRING_PARAM)).thenReturn(STRING_PARAM_OUT_VAL);
		when(mockStructure.getValue(STRUCTURE_PARAM)).thenReturn(mockEmbeddedStructure);
		when(mockStructure.getStructure(10)).thenReturn(mockEmbeddedStructure);
		when(mockStructure.getValue(TABLE_PARAM)).thenReturn(mockEmbeddedTable);
		when(mockStructure.getTable(11)).thenReturn(mockEmbeddedTable);
		
		/* Enhance Table mock */
		when(mockTable.getMetaData()).thenReturn(mockStructureMetaData);
		when(mockTable.getNumRows()).thenReturn(1);
		when(mockTable.getValue(CHAR_PARAM)).thenReturn(CHAR_PARAM_OUT_VAL);
		when(mockTable.getValue(NUM_PARAM)).thenReturn(NUM_PARAM_OUT_VAL);
		when(mockTable.getValue(INT_PARAM)).thenReturn(INT_PARAM_OUT_VAL);
		when(mockTable.getValue(FLOAT_PARAM)).thenReturn(FLOAT_PARAM_OUT_VAL);
		when(mockTable.getValue(BCD_PARAM)).thenReturn(BCD_PARAM_OUT_VAL);
		when(mockTable.getValue(BINARY_PARAM)).thenReturn(BINARY_PARAM_OUT_VAL);
		when(mockTable.getValue(BINARY_ARRAY_PARAM)).thenReturn(BINARY_ARRAY_PARAM_OUT_VAL);
		when(mockTable.getValue(DATE_PARAM)).thenReturn(DATE_PARAM_OUT_VAL);
		when(mockTable.getValue(TIME_PARAM)).thenReturn(TIME_PARAM_OUT_VAL);
		when(mockTable.getValue(STRING_PARAM)).thenReturn(STRING_PARAM_OUT_VAL);
		
		/* Enhance Embedded Structure mock */
		when(mockEmbeddedStructure.getMetaData()).thenReturn(mockStructureMetaData);
		
		/* Enhance Embedded Table mock */
		when(mockEmbeddedTable.getMetaData()).thenReturn(mockStructureMetaData);
		when(mockEmbeddedTable.getNumRows()).thenReturn(1);
		when(mockEmbeddedTable.getValue(CHAR_PARAM)).thenReturn(CHAR_PARAM_OUT_VAL);
		when(mockEmbeddedTable.getValue(NUM_PARAM)).thenReturn(NUM_PARAM_OUT_VAL);
		when(mockEmbeddedTable.getValue(INT_PARAM)).thenReturn(INT_PARAM_OUT_VAL);
		when(mockEmbeddedTable.getValue(FLOAT_PARAM)).thenReturn(FLOAT_PARAM_OUT_VAL);
		when(mockEmbeddedTable.getValue(BCD_PARAM)).thenReturn(BCD_PARAM_OUT_VAL);
		when(mockEmbeddedTable.getValue(BINARY_PARAM)).thenReturn(BINARY_PARAM_OUT_VAL);
		when(mockEmbeddedTable.getValue(BINARY_ARRAY_PARAM)).thenReturn(BINARY_ARRAY_PARAM_OUT_VAL);
		when(mockEmbeddedTable.getValue(DATE_PARAM)).thenReturn(DATE_PARAM_OUT_VAL);
		when(mockEmbeddedTable.getValue(TIME_PARAM)).thenReturn(TIME_PARAM_OUT_VAL);
		when(mockEmbeddedTable.getValue(STRING_PARAM)).thenReturn(STRING_PARAM_OUT_VAL);
		
	}
	
	private void setupTableParameterList() {

		/* Create mocks for table parameters */
		mockTableParameterList = mock(JCoParameterList.class, "TableParameterList");
		mockTableParameterListTable = mock(JCoTable.class, "TableParameterListTable");

		mockTableStructure = mock(JCoStructure.class, "TableStructure");
		mockTableEmbeddedStructure = mock(JCoStructure.class, "TableEmbeddedStructure");
		mockTableTable = mock(JCoTable.class, "TableTable");
		mockTableEmbeddedTable = mock(JCoTable.class, "TableEmbeddedStructure");

		/* Enhance Table Parameter List mock */
		when(mockTableParameterList.getTable(TABLE_PARAM_LIST_TABLE_PARAM)).thenReturn(mockTableParameterListTable);
		when(mockTableParameterList.getListMetaData()).thenReturn(mockTableParameterListMetaData);
		
		/* Enhance Table Parameter List Table mock */
		when(mockTableParameterListTable.getMetaData()).thenReturn(mockStructureMetaData);
		when(mockTableParameterListTable.getValue(CHAR_PARAM)).thenReturn(CHAR_PARAM_OUT_VAL);
		when(mockTableParameterListTable.getValue(NUM_PARAM)).thenReturn(NUM_PARAM_OUT_VAL);
		when(mockTableParameterListTable.getValue(INT_PARAM)).thenReturn(INT_PARAM_OUT_VAL);
		when(mockTableParameterListTable.getValue(FLOAT_PARAM)).thenReturn(FLOAT_PARAM_OUT_VAL);
		when(mockTableParameterListTable.getValue(BCD_PARAM)).thenReturn(BCD_PARAM_OUT_VAL);
		when(mockTableParameterListTable.getValue(BINARY_PARAM)).thenReturn(BINARY_PARAM_OUT_VAL);
		when(mockTableParameterListTable.getValue(BINARY_ARRAY_PARAM)).thenReturn(BINARY_ARRAY_PARAM_OUT_VAL);
		when(mockTableParameterListTable.getValue(DATE_PARAM)).thenReturn(DATE_PARAM_OUT_VAL);
		when(mockTableParameterListTable.getValue(TIME_PARAM)).thenReturn(TIME_PARAM_OUT_VAL);
		when(mockTableParameterListTable.getValue(STRING_PARAM)).thenReturn(STRING_PARAM_OUT_VAL);
		when(mockTableParameterListTable.getValue(STRUCTURE_PARAM)).thenReturn(mockTableStructure);
		when(mockTableParameterListTable.getValue(TABLE_PARAM)).thenReturn(mockTableTable);	
		
		/* Enhance Changing Structure mock */
		when(mockTableStructure.getMetaData()).thenReturn(mockStructureMetaData);
		when(mockTableStructure.getValue(CHAR_PARAM)).thenReturn(CHAR_PARAM_OUT_VAL);
		when(mockTableStructure.getValue(NUM_PARAM)).thenReturn(NUM_PARAM_OUT_VAL);
		when(mockTableStructure.getValue(INT_PARAM)).thenReturn(INT_PARAM_OUT_VAL);
		when(mockTableStructure.getValue(FLOAT_PARAM)).thenReturn(FLOAT_PARAM_OUT_VAL);
		when(mockTableStructure.getValue(BCD_PARAM)).thenReturn(BCD_PARAM_OUT_VAL);
		when(mockTableStructure.getValue(BINARY_PARAM)).thenReturn(BINARY_PARAM_OUT_VAL);
		when(mockTableStructure.getValue(BINARY_ARRAY_PARAM)).thenReturn(BINARY_ARRAY_PARAM_OUT_VAL);
		when(mockTableStructure.getValue(DATE_PARAM)).thenReturn(DATE_PARAM_OUT_VAL);
		when(mockTableStructure.getValue(TIME_PARAM)).thenReturn(TIME_PARAM_OUT_VAL);
		when(mockTableStructure.getValue(STRING_PARAM)).thenReturn(STRING_PARAM_OUT_VAL);
		when(mockTableStructure.getValue(STRUCTURE_PARAM)).thenReturn(mockTableEmbeddedStructure);
		when(mockTableStructure.getValue(TABLE_PARAM)).thenReturn(mockTableEmbeddedTable);
		
	}
	
	@SuppressWarnings("unchecked")
	private void setupInputAndOutputRecords() {
		
		/* Create Input Records */
		input = new MappedRecordImpl(INPUT_RECORD_NAME);
		
		/* Create Parameter List Records */
		structureRecord = new MappedRecordImpl(PARAM_LIST_STRUCTURE_PARAM);
		embeddedStructureRecord = new MappedRecordImpl(STRUCTURE_PARAM);
		tableRecord = new IndexedRecordImpl(PARAM_LIST_TABLE_PARAM);
		embeddedTableRecord = new IndexedRecordImpl(TABLE_PARAM);
		
		/* Create Table Parameter List Records */
		tableTable = new IndexedRecordImpl(TABLE_PARAM_LIST_TABLE_PARAM);
		tableEmbeddedStructure = new MappedRecordImpl(STRUCTURE_PARAM);
		tableEmbeddedTable = new IndexedRecordImpl(TABLE_PARAM);
		
		/* Create Output Record */
		output = new MappedRecordImpl(OUTPUT_RECORD_NAME);
		
		/* Populate Parameter List Parameters */
		input.put(PARAM_LIST_CHAR_PARAM, CHAR_PARAM_IN_VAL);
		input.put(PARAM_LIST_NUM_PARAM, NUM_PARAM_IN_VAL);
		input.put(PARAM_LIST_INT_PARAM, INT_PARAM_IN_VAL);
		input.put(PARAM_LIST_FLOAT_PARAM, FLOAT_PARAM_IN_VAL);
		input.put(PARAM_LIST_BCD_PARAM, BCD_PARAMIN__VAL);
		input.put(PARAM_LIST_BINARY_PARAM, BINARY_PARAM_IN_VAL);
		input.put(PARAM_LIST_BINARY_ARRAY_PARAM, BINARY_ARRAY_PARAM_IN_VAL);
		input.put(PARAM_LIST_DATE_PARAM, DATE_PARAM_IN_VAL);
		input.put(PARAM_LIST_TIME_PARAM, TIME_PARAM_IN_VAL);
		input.put(PARAM_LIST_STRING_PARAM, STRING_PARAM_IN_VAL);
		input.put(PARAM_LIST_STRUCTURE_PARAM, structureRecord);
		input.put(PARAM_LIST_TABLE_PARAM, tableRecord);
		
		/* Populate Structure Record */
		structureRecord.put(CHAR_PARAM, CHAR_PARAM_IN_VAL);
		structureRecord.put(NUM_PARAM, NUM_PARAM_IN_VAL);
		structureRecord.put(INT_PARAM, INT_PARAM_IN_VAL);
		structureRecord.put(FLOAT_PARAM, FLOAT_PARAM_IN_VAL);
		structureRecord.put(BCD_PARAM, BCD_PARAMIN__VAL);
		structureRecord.put(BINARY_PARAM, BINARY_PARAM_IN_VAL);
		structureRecord.put(BINARY_ARRAY_PARAM, BINARY_ARRAY_PARAM_IN_VAL);
		structureRecord.put(DATE_PARAM, DATE_PARAM_IN_VAL);
		structureRecord.put(TIME_PARAM, TIME_PARAM_IN_VAL);
		structureRecord.put(STRING_PARAM, STRING_PARAM_IN_VAL);
		structureRecord.put(STRUCTURE_PARAM, embeddedStructureRecord);
		structureRecord.put(TABLE_PARAM, embeddedTableRecord);

		/* Populate Embedded Structure Record */
		embeddedStructureRecord.put(CHAR_PARAM, CHAR_PARAM_IN_VAL);
		embeddedStructureRecord.put(NUM_PARAM, NUM_PARAM_IN_VAL);
		embeddedStructureRecord.put(INT_PARAM, INT_PARAM_IN_VAL);
		embeddedStructureRecord.put(FLOAT_PARAM, FLOAT_PARAM_IN_VAL);
		embeddedStructureRecord.put(BCD_PARAM, BCD_PARAMIN__VAL);
		embeddedStructureRecord.put(BINARY_PARAM, BINARY_PARAM_IN_VAL);
		embeddedStructureRecord.put(BINARY_ARRAY_PARAM, BINARY_ARRAY_PARAM_IN_VAL);
		embeddedStructureRecord.put(DATE_PARAM, DATE_PARAM_IN_VAL);
		embeddedStructureRecord.put(TIME_PARAM, TIME_PARAM_IN_VAL);
		embeddedStructureRecord.put(STRING_PARAM, STRING_PARAM_IN_VAL);
		
		/* Populate Table Record */
		{
			MappedRecord lineRecord = new MappedRecordImpl(TABLE_PARAM);
			lineRecord.put(CHAR_PARAM, CHAR_PARAM_IN_VAL);
			lineRecord.put(NUM_PARAM, NUM_PARAM_IN_VAL);
			lineRecord.put(INT_PARAM, INT_PARAM_IN_VAL);
			lineRecord.put(FLOAT_PARAM, FLOAT_PARAM_IN_VAL);
			lineRecord.put(BCD_PARAM, BCD_PARAMIN__VAL);
			lineRecord.put(BINARY_PARAM, BINARY_PARAM_IN_VAL);
			lineRecord.put(BINARY_ARRAY_PARAM, BINARY_ARRAY_PARAM_IN_VAL);
			lineRecord.put(DATE_PARAM, DATE_PARAM_IN_VAL);
			lineRecord.put(TIME_PARAM, TIME_PARAM_IN_VAL);
			lineRecord.put(STRING_PARAM, STRING_PARAM_IN_VAL);
			tableRecord.add(lineRecord);
		}
		
		/* Populate Embedded Table Record */
		{
			MappedRecord lineRecord = new MappedRecordImpl(TABLE_PARAM);
			lineRecord.put(CHAR_PARAM, CHAR_PARAM_IN_VAL);
			lineRecord.put(NUM_PARAM, NUM_PARAM_IN_VAL);
			lineRecord.put(INT_PARAM, INT_PARAM_IN_VAL);
			lineRecord.put(FLOAT_PARAM, FLOAT_PARAM_IN_VAL);
			lineRecord.put(BCD_PARAM, BCD_PARAMIN__VAL);
			lineRecord.put(BINARY_PARAM, BINARY_PARAM_IN_VAL);
			lineRecord.put(BINARY_ARRAY_PARAM, BINARY_ARRAY_PARAM_IN_VAL);
			lineRecord.put(DATE_PARAM, DATE_PARAM_IN_VAL);
			lineRecord.put(TIME_PARAM, TIME_PARAM_IN_VAL);
			lineRecord.put(STRING_PARAM, STRING_PARAM_IN_VAL);
			embeddedTableRecord.add(lineRecord);
		}
		
		/* Populate Table Parameter List Parameters */
		input.put(TABLE_PARAM_LIST_TABLE_PARAM, tableTable);
		
		/* Populate Table Parameter List Table Record */
		{
			MappedRecord lineRecord = new MappedRecordImpl(TABLE_PARAM_LIST_TABLE_PARAM);
			lineRecord.put(CHAR_PARAM, CHAR_PARAM_IN_VAL);
			lineRecord.put(NUM_PARAM, NUM_PARAM_IN_VAL);
			lineRecord.put(INT_PARAM, INT_PARAM_IN_VAL);
			lineRecord.put(FLOAT_PARAM, FLOAT_PARAM_IN_VAL);
			lineRecord.put(BCD_PARAM, BCD_PARAMIN__VAL);
			lineRecord.put(BINARY_PARAM, BINARY_PARAM_IN_VAL);
			lineRecord.put(BINARY_ARRAY_PARAM, BINARY_ARRAY_PARAM_IN_VAL);
			lineRecord.put(DATE_PARAM, DATE_PARAM_IN_VAL);
			lineRecord.put(TIME_PARAM, TIME_PARAM_IN_VAL);
			lineRecord.put(STRING_PARAM, STRING_PARAM_IN_VAL);
			lineRecord.put(STRUCTURE_PARAM, tableEmbeddedStructure);
			lineRecord.put(TABLE_PARAM, tableEmbeddedTable);
			tableTable.add(lineRecord);
		}
		
		/* Populate Table Parameter List Embedded Structure Record */
		tableEmbeddedStructure.put(CHAR_PARAM, CHAR_PARAM_IN_VAL);
		tableEmbeddedStructure.put(NUM_PARAM, NUM_PARAM_IN_VAL);
		tableEmbeddedStructure.put(INT_PARAM, INT_PARAM_IN_VAL);
		tableEmbeddedStructure.put(FLOAT_PARAM, FLOAT_PARAM_IN_VAL);
		tableEmbeddedStructure.put(BCD_PARAM, BCD_PARAMIN__VAL);
		tableEmbeddedStructure.put(BINARY_PARAM, BINARY_PARAM_IN_VAL);
		tableEmbeddedStructure.put(BINARY_ARRAY_PARAM, BINARY_ARRAY_PARAM_IN_VAL);
		tableEmbeddedStructure.put(DATE_PARAM, DATE_PARAM_IN_VAL);
		tableEmbeddedStructure.put(TIME_PARAM, TIME_PARAM_IN_VAL);
		tableEmbeddedStructure.put(STRING_PARAM, STRING_PARAM_IN_VAL);
		
		/* Populate Table Parameter List Embedded Table Record */
		{
			MappedRecord lineRecord = new MappedRecordImpl(TABLE_PARAM_LIST_TABLE_PARAM);
			lineRecord.put(CHAR_PARAM, CHAR_PARAM_IN_VAL);
			lineRecord.put(NUM_PARAM, NUM_PARAM_IN_VAL);
			lineRecord.put(INT_PARAM, INT_PARAM_IN_VAL);
			lineRecord.put(FLOAT_PARAM, FLOAT_PARAM_IN_VAL);
			lineRecord.put(BCD_PARAM, BCD_PARAMIN__VAL);
			lineRecord.put(BINARY_PARAM, BINARY_PARAM_IN_VAL);
			lineRecord.put(BINARY_ARRAY_PARAM, BINARY_ARRAY_PARAM_IN_VAL);
			lineRecord.put(DATE_PARAM, DATE_PARAM_IN_VAL);
			lineRecord.put(TIME_PARAM, TIME_PARAM_IN_VAL);
			lineRecord.put(STRING_PARAM, STRING_PARAM_IN_VAL);
			tableEmbeddedTable.add(lineRecord);
		}
		
	}
	
	private void setupInputAndOutputRecordsWithNoRecords() {
		
		/* Create Input Records */
		input = new MappedRecordImpl(INPUT_RECORD_NAME);
		
		/* Create Output Record */
		output = new MappedRecordImpl(OUTPUT_RECORD_NAME);
	}	
	
	/**
	 * Setups for ExecuteWithEmptyTableParameter Test
	 */
	
	private void setupTableParameterListMetaDataForEmptyTableParameter(){
		/* Create mock for table parameter list meta data */
		mockTableParameterListMetaData = mock(JCoListMetaData.class, "EmptyTableParameterParameterListMetaData");
		
		/* Enhance Table Parameter List Meta Data mock*/
		when(mockTableParameterListMetaData.getName(0)).thenReturn(TABLE_PARAM_LIST_TABLE_PARAM);
		when(mockTableParameterListMetaData.getFieldCount()).thenReturn(1);

	}
	
	private void setupTableParameterListForEmptyTableParameter() {

		/* Create mocks for table parameters */
		mockTableParameterList = mock(JCoParameterList.class, "EmptyTableParameterParameterList");
		mockTableParameterListTable = mock(JCoTable.class, "EmptyTableParameterListTable");

		/* Enhance Table Parameter List mock */
		when(mockTableParameterList.getTable(TABLE_PARAM_LIST_TABLE_PARAM)).thenReturn(mockTableParameterListTable);
		when(mockTableParameterList.getListMetaData()).thenReturn(mockTableParameterListMetaData);
	}
	
	/**
	 * Setups for ExecuteWithInvalidTableParameter Test
	 */
	
	private void setupTableParameterListMetaDataForInvalidTableParameter(){
		/* Create mock for table parameter list meta data */
		mockTableParameterListMetaData = mock(JCoListMetaData.class, "InvalidTableParameterParameterListMetaData");
		
		/* Enhance Table Parameter List Meta Data mock*/
		when(mockTableParameterListMetaData.getName(0)).thenReturn(TABLE_PARAM_LIST_TABLE_PARAM);
		when(mockTableParameterListMetaData.getFieldCount()).thenReturn(1);

	}
	
	private void setupTableParameterListForInvalidTableParameter() {

		/* Create mocks for table parameters */
		mockTableParameterList = mock(JCoParameterList.class, "InvalidTableParameterParameterList");
		mockTableParameterListTable = mock(JCoTable.class, "InvalidTableParameterListTable");

		/* Enhance Table Parameter List mock */
		when(mockTableParameterList.getTable(TABLE_PARAM_LIST_TABLE_PARAM)).thenReturn(mockTableParameterListTable);
		when(mockTableParameterList.getListMetaData()).thenReturn(mockTableParameterListMetaData);
	}
	
	@SuppressWarnings("unchecked")
	private void setupInputAndOutputRecordsWithInvalidTableParameter() {
		
		/* Create Input Records */
		input = new MappedRecordImpl(INPUT_RECORD_NAME);
		mockInvalidIndexedRecord = mock(IndexedRecord.class); 
		input.put(TABLE_PARAM_LIST_TABLE_PARAM, mockInvalidIndexedRecord);
		
		/* Create Output Record */
		output = new MappedRecordImpl(OUTPUT_RECORD_NAME);
		
	}
	
	/**
	 * Setups for ExecuteWithMissingRequiredImportParameter Test
	 */
	
	private void setupParmeterListMetaDataForMissingRequiredParameter(){
		/* Create mock for parameter list meta data */
		mockParameterListMetaData = mock(JCoListMetaData.class, "MissingRequiredParameterParameterListMetaData");
		
		/* Enhance Parameter List Meta Data mock */
		when(mockParameterListMetaData.getName(0)).thenReturn(PARAM_LIST_CHAR_PARAM);
		when(mockParameterListMetaData.isOptional(0)).thenReturn(false);
		when(mockParameterListMetaData.getFieldCount()).thenReturn(1);
		
	}
	
	private void setupParameterListForMissingRequiredParameter() {

		/* Create mocks for parameters */
		mockParameterList = mock(JCoParameterList.class, "MissingRequiredParameterParameterList");

		/* Enhance Parameter List mock */
		when(mockParameterList.getListMetaData()).thenReturn(mockParameterListMetaData);
	}
	
	/**
	 * Setups for ExecuteWithMissingOptionalInputParameter Test
	 */
	
	private void setupParameterListMetaDataForMissingOptionalParameter(){
		/* Create mock for parameter list meta data */
		mockParameterListMetaData = mock(JCoListMetaData.class, "MissingOptionalParameterParameterListMetaData");
		
		/* Enhance Parameter List Meta Data mock */
		when(mockParameterListMetaData.getName(0)).thenReturn(PARAM_LIST_CHAR_PARAM);
		when(mockParameterListMetaData.isOptional(0)).thenReturn(true);
		when(mockParameterListMetaData.getFieldCount()).thenReturn(1);
		
	}
	
	private void setupParameterListForMissingOptionalParameter() {

		/* Create mocks for parameters */
		mockParameterList = mock(JCoParameterList.class, "MissingOptionalParameterParameterList");

		/* Enhance Parameter List mock */
		when(mockParameterList.getListMetaData()).thenReturn(mockParameterListMetaData);
	}
	
	/**
	 * Setups for ExecuteWithInvalidMappedRecordParameterInParameterList Test
	 */

	private void setupParameterListMetaDataForInvalidMappedRecordInParameterList() {
		/* Create mocks for Parameter List Meta Data */
		mockParameterListMetaData = mock(JCoListMetaData.class, "InvalidMappedRecordParameterListMetaData");
		
		/* Enhance Parameter List Meta Data mock*/
		when(mockParameterListMetaData.getName(0)).thenReturn(PARAM_LIST_STRUCTURE_PARAM);
		when(mockParameterListMetaData.isStructure(0)).thenReturn(true);
		when(mockParameterListMetaData.getFieldCount()).thenReturn(1);
	}

	private void setupParameterListForInvalidMappedRecordInParameterList() {
		/* Create mocks for parameters */
		mockParameterList = mock(JCoParameterList.class, "InvalidMappedRecordParameterList");
		
		/* Enhance */
		when(mockParameterList.getListMetaData()).thenReturn(mockParameterListMetaData);
	}
	
	@SuppressWarnings("unchecked")
	private void setupInputAndOutputRecordsForInvalidMappedRecordInParameterList() {
		/* Create Input Records */
		input = new MappedRecordImpl(INPUT_RECORD_NAME);
		mockInvalidMappedRecord = mock(MappedRecord.class); 
		input.put(PARAM_LIST_STRUCTURE_PARAM, mockInvalidMappedRecord);
		
		/* Create Output Record */
		output = new MappedRecordImpl(OUTPUT_RECORD_NAME);
	}
	
	/**
	 * Setups for ExecuteWithInvalidIndexedRecordParameterInParameterList Test
	 */

	private void setupParameterListMetaDataForInvalidIndexedRecordInParameterList() {
		/* Create mocks for Parameter List Meta Data */
		mockParameterListMetaData = mock(JCoListMetaData.class, "InvalidIndexedParameterListMetaData");
		
		/* Enhance Parameter List Meta Data mock*/
		when(mockParameterListMetaData.getName(0)).thenReturn(PARAM_LIST_TABLE_PARAM);
		when(mockParameterListMetaData.isTable(0)).thenReturn(true);
		when(mockParameterListMetaData.getFieldCount()).thenReturn(1);
	}
	
	private void setupParameterListForInvalidIndexedRecordInParameterList() {
		/* Create mocks for parameters */
		mockParameterList = mock(JCoParameterList.class, "InvalidIndexedRecordParameterList");
		
		/* Enhance */
		when(mockParameterList.getListMetaData()).thenReturn(mockParameterListMetaData);
	}
	
	@SuppressWarnings("unchecked")
	private void setupInputAndOutputRecordsForInvalidIndexedRecordInParameterList() {
		/* Create Input Records */
		input = new MappedRecordImpl(INPUT_RECORD_NAME);
		mockInvalidIndexedRecord = mock(IndexedRecord.class); 
		input.put(PARAM_LIST_TABLE_PARAM, mockInvalidIndexedRecord);
		
		/* Create Output Record */
		output = new MappedRecordImpl(OUTPUT_RECORD_NAME);
	}
	
	/**
	 * Setups for ExecuteWithInvalidMappedRecordParameterInStructure Test
	 */

	private void setupParameterListMetaDataForInvalidMappedRecordInStructure() {
		/* Create mocks for Parameter List Meta Data */
		mockParameterListMetaData = mock(JCoListMetaData.class, "InvalidMappedRecordInStructureParameterListMetaData");
		
		/* Create mock for structure meta data */
		mockStructureMetaData = mock(JCoMetaData.class, "InvalidMappedRecordInStructureStructureMetaData");

		/* Enhance Parameter List Meta Data mock*/
		when(mockParameterListMetaData.getName(0)).thenReturn(PARAM_LIST_STRUCTURE_PARAM);
		when(mockParameterListMetaData.isStructure(0)).thenReturn(true);
		when(mockParameterListMetaData.getFieldCount()).thenReturn(1);

		/* Enhance Structure Meta Data mock*/
		when(mockStructureMetaData.getName(0)).thenReturn(STRUCTURE_PARAM);
		when(mockStructureMetaData.isStructure(0)).thenReturn(true);
		when(mockStructureMetaData.getFieldCount()).thenReturn(1);
		
	}

	private void setupParameterListForInvalidMappedRecordInStructure() {
		/* Create mocks for parameters */
		mockParameterList = mock(JCoParameterList.class, "InvalidMappedRecordInStructureParameterList");
		mockStructure = mock(JCoStructure.class, "InvalidMappedRecordInStructureStructure");
		mockEmbeddedStructure = mock(JCoStructure.class, "InvalidMappedRecordInStructureEmbeddedStructure");
		
		/* Enhance Parameter List mock*/
		when(mockParameterList.getListMetaData()).thenReturn(mockParameterListMetaData);
		when(mockParameterList.getValue(PARAM_LIST_STRUCTURE_PARAM)).thenReturn(mockStructure);
		when(mockParameterList.getStructure(0)).thenReturn(mockStructure);
		
		/* Enhance Structure mock */
		when(mockStructure.getMetaData()).thenReturn(mockStructureMetaData);
		when(mockStructure.getValue(STRUCTURE_PARAM)).thenReturn(mockEmbeddedStructure);
		when(mockStructure.getStructure(0)).thenReturn(mockEmbeddedStructure);
	}
	
	@SuppressWarnings("unchecked")
	private void setupInputAndOutputRecordsForInvalidMappedRecordInStructure() {
		/* Create Input Record */
		input = new MappedRecordImpl(INPUT_RECORD_NAME);
		
		/* Create Parameter List Record */
		structureRecord = new MappedRecordImpl(PARAM_LIST_STRUCTURE_PARAM);
		
		/* Create mock for invalid MappedRecord */
		mockInvalidMappedRecord = mock(MappedRecord.class); 
		
		/* Populate Parameter List Parameters */
		input.put(PARAM_LIST_STRUCTURE_PARAM, structureRecord);
		
		/* Populate Structure Record */
		structureRecord.put(STRUCTURE_PARAM, mockInvalidMappedRecord);

		/* Create Output Record */
		output = new MappedRecordImpl(OUTPUT_RECORD_NAME);
	}
	
	/**
	 * Setups for ExecuteWithInvalidIndexedRecordParameterInStructure Test
	 */

	private void setupParameterListMetaDataForInvalidIndexedRecordInStructure() {
		/* Create mocks for Parameter List Meta Data */
		mockParameterListMetaData = mock(JCoListMetaData.class, "InvalidMappedRecordInStructureParameterListMetaData");
		
		/* Create mock for structure meta data */
		mockStructureMetaData = mock(JCoMetaData.class, "InvalidMappedRecordInStructureStructureMetaData");

		/* Enhance Parameter List Meta Data mock*/
		when(mockParameterListMetaData.getName(0)).thenReturn(PARAM_LIST_STRUCTURE_PARAM);
		when(mockParameterListMetaData.isStructure(0)).thenReturn(true);
		when(mockParameterListMetaData.getFieldCount()).thenReturn(1);

		/* Enhance Structure Meta Data mock*/
		when(mockStructureMetaData.getName(0)).thenReturn(TABLE_PARAM);
		when(mockStructureMetaData.isTable(0)).thenReturn(true);
		when(mockStructureMetaData.getFieldCount()).thenReturn(1);
		
	}

	private void setupParameterListForInvalidIndexedRecordInStructure() {
		/* Create mocks for parameters */
		mockParameterList = mock(JCoParameterList.class, "InvalidMappedRecordInStructureParameterList");
		mockStructure = mock(JCoStructure.class, "InvalidMappedRecordInStructureStructure");
		mockEmbeddedTable = mock(JCoTable.class, "InvalidIndexedRecordInStructureEmbeddedStructure");
		
		/* Enhance Parameter List mock*/
		when(mockParameterList.getListMetaData()).thenReturn(mockParameterListMetaData);
		when(mockParameterList.getValue(PARAM_LIST_STRUCTURE_PARAM)).thenReturn(mockStructure);
		when(mockParameterList.getStructure(0)).thenReturn(mockStructure);
		
		/* Enhance Structure mock */
		when(mockStructure.getMetaData()).thenReturn(mockStructureMetaData);
		when(mockStructure.getValue(TABLE_PARAM)).thenReturn(mockEmbeddedStructure);
		when(mockStructure.getTable(0)).thenReturn(mockEmbeddedTable);
	}
	
	@SuppressWarnings("unchecked")
	private void setupInputAndOutputRecordsForInvalidIndexedRecordInStructure() {
		/* Create Input Record */
		input = new MappedRecordImpl(INPUT_RECORD_NAME);
		
		/* Create Parameter List Record */
		structureRecord = new MappedRecordImpl(PARAM_LIST_STRUCTURE_PARAM);
		
		/* Create mock for invalid IndexedRecord */
		mockInvalidIndexedRecord = mock(IndexedRecord.class); 
		
		/* Populate Parameter List Parameters */
		input.put(PARAM_LIST_STRUCTURE_PARAM, structureRecord);
		
		/* Populate Structure Record */
		structureRecord.put(TABLE_PARAM, mockInvalidIndexedRecord);

		/* Create Output Record */
		output = new MappedRecordImpl(OUTPUT_RECORD_NAME);
	}
	
	/**
	 * Setups for ExecuteWithInvalidIndexedRecordParameterInStructure Test
	 */
	private void setupTableParameterListMetaDataForInvalidMappedRecordInTable() {
		/* Create mocks for Parameter List Meta Data */
		mockTableParameterListMetaData = mock(JCoListMetaData.class, "InvalidMappedRecordInTableParameterListMetaData");
		
		/* Create mock for structure meta data */
		mockStructureMetaData = mock(JCoMetaData.class, "InvalidMappedRecordInTableStructureMetaData");

		/* Enhance Table Parameter List Meta Data mock*/
		when(mockTableParameterListMetaData.getName(0)).thenReturn(TABLE_PARAM_LIST_TABLE_PARAM);
		when(mockTableParameterListMetaData.isTable(0)).thenReturn(true);
		when(mockTableParameterListMetaData.getFieldCount()).thenReturn(1);
		
	}

	private void setupTableParameterListForInvalidMappedRecordInTable() {
		/* Create mocks for parameters */
		mockTableParameterList = mock(JCoParameterList.class, "InvalidMappedRecordInTableTableParameterList");
		mockTableParameterListTable = mock(JCoTable.class, "InvalidMappedRecordInTableTable");
		
		/* Enhance Table Parameter List mock */
		when(mockTableParameterList.getListMetaData()).thenReturn(mockTableParameterListMetaData);
		when(mockTableParameterList.getTable(0)).thenReturn(mockTableParameterListTable);
		when(mockTableParameterList.getTable(TABLE_PARAM_LIST_TABLE_PARAM)).thenReturn(mockTableParameterListTable);
		
		/* Enhance Table Parameter List Table mock */
		when(mockTableParameterListTable.getMetaData()).thenReturn(mockStructureMetaData);
	}
	
	@SuppressWarnings("unchecked")
	private void setupInputAndOutputRecordsForInvalidMappedRecordInTable() {
		/* Create Input Record */
		input = new MappedRecordImpl(INPUT_RECORD_NAME);
		
		/* Create Table Parameter List Record */
		tableTable = new IndexedRecordImpl(TABLE_PARAM_LIST_TABLE_PARAM);
		
		/* Create mock for invalid MappedRecord */
		mockInvalidMappedRecord = mock(MappedRecord.class);
		
		/* Populate Table Parameter List Parameters */
		input.put(TABLE_PARAM_LIST_TABLE_PARAM, tableTable);
		
		/* Populate Table Record */
		tableTable.add(mockInvalidMappedRecord);

		/* Create Output Record */
		output = new MappedRecordImpl(OUTPUT_RECORD_NAME);
	}
	
	/**
	 * Setups for ExecuteWithImportParameterCausingConversionException Test
	 */
	
	private void setupParmeterListMetaDataForImportParameterCausingConversionException(){
		/* Create mock for parameter list meta data */
		mockParameterListMetaData = mock(JCoListMetaData.class, "ImportParameterCausingConversionExceptionParameterListMetaData");
		
		/* Enhance Parameter List Meta Data mock */
		when(mockParameterListMetaData.getName(0)).thenReturn(PARAM_LIST_CHAR_PARAM);
		when(mockParameterListMetaData.isOptional(0)).thenReturn(false);
		when(mockParameterListMetaData.getFieldCount()).thenReturn(1);
		
	}
	
	private void setupParameterListForImportParameterCausingConversionException() {
		/* Create mocks for parameters */
		mockParameterList = mock(JCoParameterList.class, "ImportParameterCausingConversionExceptionParameterList");
		mockConversionException = mock(ConversionException.class);

		/* Enhance Parameter List mock */
		when(mockParameterList.getListMetaData()).thenReturn(mockParameterListMetaData);
		doThrow(mockConversionException).when(((JCoRecord)mockParameterList)).setValue(anyInt(), anyString());
	}
	
	@SuppressWarnings("unchecked")
	private void setupInputAndOutputRecordsForImportParameterCausingConversionException() {
		/* Create Input Record */
		input = new MappedRecordImpl(INPUT_RECORD_NAME);
		
		/* Populate Parameter List Parameter */
		input.put(PARAM_LIST_CHAR_PARAM, CHAR_PARAM_IN_VAL);
		
		/* Create Output Record */
		output = new MappedRecordImpl(OUTPUT_RECORD_NAME);
	}
	
	/**
	 * Verify Behavior 
	 */

	private void verifyExecuteBehavior() throws JCoException {
		verify(((JBossSAPInteractionSpec)mockInteractionSpec)).getFunctionName();
		verify(mockConnection).getDestination();
		verify(mockDestination).getRepository();
		verify(mockRepository).getFunction(TEST_FUNCTION_NAME);
		
	}
	
	private void verifyPopulateInputBehavior() {
		
		/* Verify calls on Changing Parameter List */
		verify(mockParameterList).setValue(0, (Object) CHAR_PARAM_IN_VAL);
		verify(mockParameterList).setValue(1, (Object) NUM_PARAM_IN_VAL);
		verify(mockParameterList).setValue(2, (Object) INT_PARAM_IN_VAL);
		verify(mockParameterList).setValue(3, (Object) FLOAT_PARAM_IN_VAL);
		verify(mockParameterList).setValue(4, (Object) BCD_PARAMIN__VAL);
		verify(mockParameterList).setValue(5, (Object) BINARY_PARAM_IN_VAL);
		verify(mockParameterList).setValue(6, (Object) BINARY_ARRAY_PARAM_IN_VAL);
		verify(mockParameterList).setValue(7, (Object) DATE_PARAM_IN_VAL);
		verify(mockParameterList).setValue(8, (Object) TIME_PARAM_IN_VAL);
		verify(mockParameterList).setValue(9, (Object) STRING_PARAM_IN_VAL);
		verify(mockParameterList, times(2)).getStructure(10);
		verify(mockParameterList, times(2)).getTable(11);
		
		/* Verify calls on Changing Structure */
		verify(mockStructure).setValue(0, (Object) CHAR_PARAM_IN_VAL);
		verify(mockStructure).setValue(1, (Object) NUM_PARAM_IN_VAL);
		verify(mockStructure).setValue(2, (Object) INT_PARAM_IN_VAL);
		verify(mockStructure).setValue(3, (Object) FLOAT_PARAM_IN_VAL);
		verify(mockStructure).setValue(4, (Object) BCD_PARAMIN__VAL);
		verify(mockStructure).setValue(5, (Object) BINARY_PARAM_IN_VAL);
		verify(mockStructure).setValue(6, (Object) BINARY_ARRAY_PARAM_IN_VAL);
		verify(mockStructure).setValue(7, (Object) DATE_PARAM_IN_VAL);
		verify(mockStructure).setValue(8, (Object) TIME_PARAM_IN_VAL);
		verify(mockStructure).setValue(9, (Object) STRING_PARAM_IN_VAL);
		verify(mockStructure, times(2)).getStructure(10);
		verify(mockStructure, times(2)).getTable(11);
		
		/* Verify calls on Changing Embedded Structure */
		verify(mockEmbeddedStructure).setValue(0, (Object) CHAR_PARAM_IN_VAL);
		verify(mockEmbeddedStructure).setValue(1, (Object) NUM_PARAM_IN_VAL);
		verify(mockEmbeddedStructure).setValue(2, (Object) INT_PARAM_IN_VAL);
		verify(mockEmbeddedStructure).setValue(3, (Object) FLOAT_PARAM_IN_VAL);
		verify(mockEmbeddedStructure).setValue(4, (Object) BCD_PARAMIN__VAL);
		verify(mockEmbeddedStructure).setValue(5, (Object) BINARY_PARAM_IN_VAL);
		verify(mockEmbeddedStructure).setValue(6, (Object) BINARY_ARRAY_PARAM_IN_VAL);
		verify(mockEmbeddedStructure).setValue(7, (Object) DATE_PARAM_IN_VAL);
		verify(mockEmbeddedStructure).setValue(8, (Object) TIME_PARAM_IN_VAL);
		verify(mockEmbeddedStructure).setValue(9, (Object) STRING_PARAM_IN_VAL);
		verify(mockEmbeddedStructure).getStructure(10);
		verify(mockEmbeddedStructure).getTable(11);
		
		/* Verify calls on Changing Table */
		verify(mockTable).setValue(0, (Object) CHAR_PARAM_IN_VAL);
		verify(mockTable).setValue(1, (Object) NUM_PARAM_IN_VAL);
		verify(mockTable).setValue(2, (Object) INT_PARAM_IN_VAL);
		verify(mockTable).setValue(3, (Object) FLOAT_PARAM_IN_VAL);
		verify(mockTable).setValue(4, (Object) BCD_PARAMIN__VAL);
		verify(mockTable).setValue(5, (Object) BINARY_PARAM_IN_VAL);
		verify(mockTable).setValue(6, (Object) BINARY_ARRAY_PARAM_IN_VAL);
		verify(mockTable).setValue(7, (Object) DATE_PARAM_IN_VAL);
		verify(mockTable).setValue(8, (Object) TIME_PARAM_IN_VAL);
		verify(mockTable).setValue(9, (Object) STRING_PARAM_IN_VAL);
		verify(mockTable).getStructure(10);
		verify(mockTable).getTable(11);

		/* Verify calls on Changing Embedded Table */
		verify(mockEmbeddedTable).setValue(0, (Object) CHAR_PARAM_IN_VAL);
		verify(mockEmbeddedTable).setValue(1, (Object) NUM_PARAM_IN_VAL);
		verify(mockEmbeddedTable).setValue(2, (Object) INT_PARAM_IN_VAL);
		verify(mockEmbeddedTable).setValue(3, (Object) FLOAT_PARAM_IN_VAL);
		verify(mockEmbeddedTable).setValue(4, (Object) BCD_PARAMIN__VAL);
		verify(mockEmbeddedTable).setValue(5, (Object) BINARY_PARAM_IN_VAL);
		verify(mockEmbeddedTable).setValue(6, (Object) BINARY_ARRAY_PARAM_IN_VAL);
		verify(mockEmbeddedTable).setValue(7, (Object) DATE_PARAM_IN_VAL);
		verify(mockEmbeddedTable).setValue(8, (Object) TIME_PARAM_IN_VAL);
		verify(mockEmbeddedTable).setValue(9, (Object) STRING_PARAM_IN_VAL);
		verify(mockEmbeddedTable).getStructure(10);
		verify(mockEmbeddedTable).getTable(11);

	}

}
