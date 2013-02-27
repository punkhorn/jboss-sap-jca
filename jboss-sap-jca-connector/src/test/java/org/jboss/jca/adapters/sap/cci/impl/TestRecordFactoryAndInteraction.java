package org.jboss.jca.adapters.sap.cci.impl;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.NoSuchElementException;

import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.ResourceWarning;

import org.jboss.jca.adapters.sap.cci.Connection;
import org.jboss.jca.adapters.sap.cci.IndexedRecord;
import org.jboss.jca.adapters.sap.cci.InteractionSpec;
import org.jboss.jca.adapters.sap.cci.MappedRecord;
import org.junit.Before;
import org.junit.Test;

import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoField;
import com.sap.conn.jco.JCoFieldIterator;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoListMetaData;
import com.sap.conn.jco.JCoMetaData;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoRecordMetaData;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.JCoRequest;
import com.sap.conn.jco.JCoResponse;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

public class TestRecordFactoryAndInteraction {
	
	/*********************************************************************
	 * Test Function And Record Names
	 *********************************************************************/

	private static final String REPOSITORY_NAME = "TEST_REPOSITORY";
	private static final String FUNCTION_MODULE_NAME = "TEST_FUNCTION_MODULE";
	private static final String INPUT_RECORD_NAME = "TEST_FUNCTION_MODULE.INPUT_RECORD";
	private static final String OUTPUT_RECORD_NAME = "TEST_FUNCTION_MODULE.OUTPUT_RECORD";
	private static final String MAPPED_RECORD_NAME = "TEST_FUNCTION_MODULE.ZSTRUCTURE";
	private static final String INDEXED_RECORD_NAME = "TEST_FUNCTION_MODULE.ZSTRUCTURE_TABLE";
	
	/*********************************************************************
	 * Test Structure Names
	 *********************************************************************/

	private static final String STRUCTURE_TYPE_NAME = "ZSTRUCTURE";
	
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

	/*********************************************************************
	 * Test Parameter Input Values
	 *********************************************************************/
	private static final String CHAR_PARAM_IN_VAL = "ABCDEFGHIJ";
	private static final String NUM_PARAM_IN_VAL = "0123456789";
	private static final int INT_PARAM_IN_VAL = 0x75555555;
	private static final double FLOAT_PARAM_IN_VAL = Math.pow(10, 38); // This seems to be the biggest double to not come
																	// back as infinity.
	private static final BigDecimal BCD_PARAM_IN_VAL = new BigDecimal("100.00000000000001");
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
	 * Classes Under Test
	 ****************************************************************************/

	private RecordFactoryImpl recordFactory;
	private InteractionImpl interaction;
	
	/****************************************************************************
	 * Mocks
	 ****************************************************************************/
	
	private JCoRepository mockRepository;
	private JCoFunctionTemplate mockFunctionTemplate;
	private JCoListMetaData mockImportParameterListMetaData;
	private JCoListMetaData mockChangingParameterListMetaData;
	private JCoListMetaData mockTableParameterListMetaData;
	private JCoListMetaData mockExportParameterListMetaData;
	private JCoRecordMetaData mockStructureMetaData;
	private JCoParameterList mockChangingParameterList;
	private JCoFieldIterator mockParameterListFieldIterator;
	private JCoField mockParameterListCharField;
	private JCoField mockParameterListNumField;
	private JCoField mockParameterListIntField;
	private JCoField mockParameterListFloatField;
	private JCoField mockParameterListBCDField;
	private JCoField mockParameterListBinaryField;
	private JCoField mockParameterListBinaryArrayField;
	private JCoField mockParameterListDateField;
	private JCoField mockParameterListTimeField;
	private JCoField mockParameterListStringField;
	private JCoField mockParameterListStructureField;
	private JCoField mockParameterListTableField;
	private JCoFieldIterator mockStructureFieldIterator;
	private JCoField mockCharField;
	private JCoField mockNumField;
	private JCoField mockIntField;
	private JCoField mockFloatField;
	private JCoField mockBCDField;
	private JCoField mockBinaryField;
	private JCoField mockBinaryArrayField;
	private JCoField mockDateField;
	private JCoField mockTimeField;
	private JCoField mockStringField;
	private JCoStructure mockStructure;
	private JCoFieldIterator mockTableFieldIterator;
	private InteractionSpec mockInteractionSpec;
	private JCoRequest mockRequest;
	private JCoResponse mockResponse;
	private MappedRecordImpl mockInput;
	private MappedRecordImpl mockOutput;
	private AbapException mockAbapException;
	private JCoDestination mockDestination;
	private ConnectionImpl mockConnection;

	@Before
	public void setUp() throws Exception {
		/* Create mocks for repository and function template */
		mockConnection = mock(ConnectionImpl.class);
		mockDestination = mock(JCoDestination.class);
		mockRepository = mock(JCoRepository.class);
		mockFunctionTemplate = mock(JCoFunctionTemplate.class);
		mockInteractionSpec = mock(InteractionSpec.class);
		mockRequest = mock(JCoRequest.class);
		mockResponse = mock(JCoResponse.class);
		mockInput = mock(MappedRecordImpl.class);
		mockOutput = mock(MappedRecordImpl.class);
		mockAbapException = mock(AbapException.class);
		
		
		/* Create mocks for parameter list */
		mockChangingParameterList = mock(JCoParameterList.class, "ChangingParameterList");
		
		/* Create mock field iterator for parameter list  */
		mockParameterListFieldIterator = mock(JCoFieldIterator.class, "ChangingParameterListFieldIterator");
		
		/* Create field mocks for field iterator */
		mockParameterListCharField = mock(JCoField.class, "ChangingParameterListCharField");
		mockParameterListNumField = mock(JCoField.class, "ChangingParameterListNumField");
		mockParameterListIntField = mock(JCoField.class, "ChangingParameterListIntField");
		mockParameterListFloatField = mock(JCoField.class, "ChangingParameterListFloatField");
		mockParameterListBCDField = mock(JCoField.class, "ChangingParameterListBCDField");
		mockParameterListBinaryField = mock(JCoField.class, "ChangingParameterListBinaryField");
		mockParameterListBinaryArrayField = mock(JCoField.class, "ChangingParameterListBinaryArrayField");
		mockParameterListDateField = mock(JCoField.class, "ChangingParameterListDateField");
		mockParameterListTimeField = mock(JCoField.class, "ChangingParameterListTimeField");
		mockParameterListStringField = mock(JCoField.class, "ChangingParameterListStringField");
		mockParameterListStructureField = mock(JCoField.class, "ChangingParameterListStructureField");
		mockParameterListTableField = mock(JCoField.class, "ChangingParameterListTableField");
		
		/* Create mock for structure */
		mockStructure = mock(JCoStructure.class, "Structure");
		
		/* Create mock field iterators for structure and table */
		mockStructureFieldIterator = mock(JCoFieldIterator.class, "StructureFieldIterator");
		mockTableFieldIterator = mock(JCoFieldIterator.class, "TableFieldIterator");

		/* Create field mocks for field iterator */
		mockCharField = mock(JCoField.class, "CharField");
		mockNumField = mock(JCoField.class, "NumField");
		mockIntField = mock(JCoField.class, "IntField");
		mockFloatField = mock(JCoField.class, "FloatField");
		mockBCDField = mock(JCoField.class, "BCDField");
		mockBinaryField = mock(JCoField.class, "BinaryField");
		mockBinaryArrayField = mock(JCoField.class, "BinaryArrayField");
		mockDateField = mock(JCoField.class, "DateField");
		mockTimeField = mock(JCoField.class, "TimeField");
		mockStringField = mock(JCoField.class, "StringField");
		
		/* Create mock for table */
		JCoTable mockTable = mock(JCoTable.class, "Table");
		
		/* Create mocks for parameter list meta data */
		mockImportParameterListMetaData = mock(JCoListMetaData.class, "ImportParameterListMetaData");
		mockChangingParameterListMetaData = mock(JCoListMetaData.class, "ChangingParameterListMetaData");
		mockTableParameterListMetaData = mock(JCoListMetaData.class, "TableParameterListMetaData");
		mockExportParameterListMetaData = mock(JCoListMetaData.class, "ExportParameterListMetaData");
		
		/* Create mocks for structure meta data */
		mockStructureMetaData = mock(JCoRecordMetaData.class, "StructureMetaData");
		
		/* Enhance connection mock */
		when(mockConnection.getDestination()).thenReturn(mockDestination);
		
		/* Enhance destination mock */
		when(mockDestination.getRepository()).thenReturn(mockRepository);

		/* Enhance repository mock */
		when(mockRepository.getFunctionTemplate(FUNCTION_MODULE_NAME)).thenReturn(mockFunctionTemplate);
		when(mockRepository.getName()).thenReturn(REPOSITORY_NAME);
		
		/* Enhance function template mock */
		when(mockFunctionTemplate.getImportParameterList()).thenReturn(mockImportParameterListMetaData);
		when(mockFunctionTemplate.getChangingParameterList()).thenReturn(mockChangingParameterListMetaData);
		when(mockFunctionTemplate.getTableParameterList()).thenReturn(mockTableParameterListMetaData);
		when(mockFunctionTemplate.getExportParameterList()).thenReturn(mockExportParameterListMetaData);
		
		/* Enhance request/response mock */
		when(mockRequest.getFieldIterator()).thenReturn(mockParameterListFieldIterator);
		when(mockResponse.getFieldIterator()).thenReturn(mockParameterListFieldIterator);
		
		/* Enhance parameter list mock */
		when(mockChangingParameterList.getFieldIterator()).thenReturn(mockParameterListFieldIterator);
		
		/* Enhance field iterator mocks  */
		when(mockParameterListFieldIterator.hasNextField()).thenReturn(true, true, true, true, true, true, true, true, true, true, true, true, false );
		when(mockParameterListFieldIterator.nextField()).thenReturn(mockParameterListCharField, mockParameterListNumField, mockParameterListIntField, mockParameterListFloatField, mockParameterListBCDField, mockParameterListBinaryField, mockParameterListBinaryArrayField, mockParameterListDateField, mockParameterListTimeField, mockParameterListStringField, mockParameterListStructureField, mockParameterListTableField).thenThrow(new NoSuchElementException());
		
		when(mockStructureFieldIterator.hasNextField()).thenReturn(true, true, true, true, true, true, true, true, true, true, false );
		when(mockStructureFieldIterator.nextField()).thenReturn(mockCharField, mockNumField, mockIntField, mockFloatField, mockBCDField, mockBinaryField, mockBinaryArrayField, mockDateField, mockTimeField, mockStringField).thenThrow(new NoSuchElementException());
		
		when(mockTableFieldIterator.hasNextField()).thenReturn(true, true, true, true, true, true, true, true, true, true, false );
		when(mockTableFieldIterator.nextField()).thenReturn(mockCharField, mockNumField, mockIntField, mockFloatField, mockBCDField, mockBinaryField, mockBinaryArrayField, mockDateField, mockTimeField, mockStringField).thenThrow(new NoSuchElementException());
		
		/* Enhance parameter list field mocks */
		when(mockParameterListCharField.getName()).thenReturn(PARAM_LIST_CHAR_PARAM);
		when(mockParameterListCharField.getValue()).thenReturn(CHAR_PARAM_OUT_VAL);

		when(mockParameterListNumField.getName()).thenReturn(PARAM_LIST_NUM_PARAM);
		when(mockParameterListNumField.getValue()).thenReturn(NUM_PARAM_OUT_VAL);

		when(mockParameterListIntField.getName()).thenReturn(PARAM_LIST_INT_PARAM);
		when(mockParameterListIntField.getValue()).thenReturn(INT_PARAM_OUT_VAL);

		when(mockParameterListFloatField.getName()).thenReturn(PARAM_LIST_FLOAT_PARAM);
		when(mockParameterListFloatField.getValue()).thenReturn(FLOAT_PARAM_OUT_VAL);

		when(mockParameterListBCDField.getName()).thenReturn(PARAM_LIST_BCD_PARAM);
		when(mockParameterListBCDField.getValue()).thenReturn(BCD_PARAM_OUT_VAL);

		when(mockParameterListBinaryField.getName()).thenReturn(PARAM_LIST_BINARY_PARAM);
		when(mockParameterListBinaryField.getValue()).thenReturn(BINARY_PARAM_OUT_VAL);

		when(mockParameterListBinaryArrayField.getName()).thenReturn(PARAM_LIST_BINARY_ARRAY_PARAM);
		when(mockParameterListBinaryArrayField.getValue()).thenReturn(BINARY_ARRAY_PARAM_OUT_VAL);

		when(mockParameterListDateField.getName()).thenReturn(PARAM_LIST_DATE_PARAM);
		when(mockParameterListDateField.getValue()).thenReturn(DATE_PARAM_OUT_VAL);

		when(mockParameterListTimeField.getName()).thenReturn(PARAM_LIST_TIME_PARAM);
		when(mockParameterListTimeField.getValue()).thenReturn(TIME_PARAM_OUT_VAL);

		when(mockParameterListStringField.getName()).thenReturn(PARAM_LIST_STRING_PARAM);
		when(mockParameterListStringField.getValue()).thenReturn(STRING_PARAM_OUT_VAL);

		when(mockParameterListStructureField.getName()).thenReturn(PARAM_LIST_STRUCTURE_PARAM);
		when(mockParameterListStructureField.isStructure()).thenReturn(true);
		when(mockParameterListStructureField.getStructure()).thenReturn(mockStructure);

		when(mockParameterListTableField.getName()).thenReturn(PARAM_LIST_TABLE_PARAM);
		when(mockParameterListTableField.isTable()).thenReturn(true);
		when(mockParameterListTableField.getTable()).thenReturn(mockTable);
		
		/* Enhance structure field mocks */
		when(mockCharField.getName()).thenReturn(CHAR_PARAM);
		when(mockCharField.getValue()).thenReturn(CHAR_PARAM_OUT_VAL);

		when(mockNumField.getName()).thenReturn(NUM_PARAM);
		when(mockNumField.getValue()).thenReturn(NUM_PARAM_OUT_VAL);

		when(mockIntField.getName()).thenReturn(INT_PARAM);
		when(mockIntField.getValue()).thenReturn(INT_PARAM_OUT_VAL);

		when(mockFloatField.getName()).thenReturn(FLOAT_PARAM);
		when(mockFloatField.getValue()).thenReturn(FLOAT_PARAM_OUT_VAL);

		when(mockBCDField.getName()).thenReturn(BCD_PARAM);
		when(mockBCDField.getValue()).thenReturn(BCD_PARAM_OUT_VAL);

		when(mockBinaryField.getName()).thenReturn(BINARY_PARAM);
		when(mockBinaryField.getValue()).thenReturn(BINARY_PARAM_OUT_VAL);

		when(mockBinaryArrayField.getName()).thenReturn(BINARY_ARRAY_PARAM);
		when(mockBinaryArrayField.getValue()).thenReturn(BINARY_ARRAY_PARAM_OUT_VAL);

		when(mockDateField.getName()).thenReturn(DATE_PARAM);
		when(mockDateField.getValue()).thenReturn(DATE_PARAM_OUT_VAL);

		when(mockTimeField.getName()).thenReturn(TIME_PARAM);
		when(mockTimeField.getValue()).thenReturn(TIME_PARAM_OUT_VAL);

		when(mockStringField.getName()).thenReturn(STRING_PARAM);
		when(mockStringField.getValue()).thenReturn(STRING_PARAM_OUT_VAL);
		
		/* Enhance structure mock */
		when(mockStructure.getFieldIterator()).thenReturn(mockStructureFieldIterator);
		
		/* Enhance table mock */
		when(mockTable.getNumRows()).thenReturn(1);
		when(mockTable.getFieldIterator()).thenReturn(mockTableFieldIterator);

		/* Enhance structure meta data mock */
		when(mockStructureMetaData.getName()).thenReturn(STRUCTURE_TYPE_NAME);
		
		/* Create objects to test */
		recordFactory = new RecordFactoryImpl();
		((RecordFactoryImpl)recordFactory).setRepository(mockRepository);
		interaction = new InteractionImpl(mockConnection);
	}
	
	private void enhanceChangingParameterListMetaData() {
		
		/* Enhance Parameter List Meta Data mock */
		when(mockChangingParameterListMetaData.getName(0)).thenReturn(PARAM_LIST_CHAR_PARAM);
		when(mockChangingParameterListMetaData.getType(0)).thenReturn(JCoMetaData.TYPE_CHAR);
		when(mockChangingParameterListMetaData.getClassNameOfField(0)).thenReturn(String.class.getName());
		when(mockChangingParameterListMetaData.isOptional(0)).thenReturn(false);
		when(mockChangingParameterListMetaData.getTypeAsString(0)).thenReturn("CHAR");
		when(mockChangingParameterListMetaData.getRecordTypeName(0)).thenReturn("ZCHAR");
		when(mockChangingParameterListMetaData.getLength(0)).thenReturn(10);
		when(mockChangingParameterListMetaData.getByteLength(0)).thenReturn(10);
		when(mockChangingParameterListMetaData.getUnicodeByteLength(0)).thenReturn(20);
		when(mockChangingParameterListMetaData.getDecimals(0)).thenReturn(0);
		when(mockChangingParameterListMetaData.isChanging(0)).thenReturn(true);
		when(mockChangingParameterListMetaData.getDescription(0)).thenReturn(PARAM_LIST_CHAR_PARAM);
		
		when(mockChangingParameterListMetaData.getName(1)).thenReturn(PARAM_LIST_NUM_PARAM);
		when(mockChangingParameterListMetaData.getType(1)).thenReturn(JCoMetaData.TYPE_NUM);
		when(mockChangingParameterListMetaData.getClassNameOfField(1)).thenReturn(String.class.getName());
		when(mockChangingParameterListMetaData.isOptional(1)).thenReturn(false);
		when(mockChangingParameterListMetaData.getTypeAsString(1)).thenReturn("NUM");
		when(mockChangingParameterListMetaData.getRecordTypeName(1)).thenReturn("ZNUM");
		when(mockChangingParameterListMetaData.getLength(1)).thenReturn(10);
		when(mockChangingParameterListMetaData.getByteLength(1)).thenReturn(10);
		when(mockChangingParameterListMetaData.getUnicodeByteLength(1)).thenReturn(20);
		when(mockChangingParameterListMetaData.getDecimals(1)).thenReturn(0);
		when(mockChangingParameterListMetaData.isChanging(1)).thenReturn(true);
		when(mockChangingParameterListMetaData.getDescription(1)).thenReturn(PARAM_LIST_NUM_PARAM);
		
		when(mockChangingParameterListMetaData.getName(2)).thenReturn(PARAM_LIST_INT_PARAM);
		when(mockChangingParameterListMetaData.getType(2)).thenReturn(JCoMetaData.TYPE_INT);
		when(mockChangingParameterListMetaData.getClassNameOfField(2)).thenReturn(Integer.class.getName());
		when(mockChangingParameterListMetaData.isOptional(2)).thenReturn(false);
		when(mockChangingParameterListMetaData.getTypeAsString(2)).thenReturn("INT");
		when(mockChangingParameterListMetaData.getRecordTypeName(2)).thenReturn("ZINT");
		when(mockChangingParameterListMetaData.getLength(2)).thenReturn(4);
		when(mockChangingParameterListMetaData.getByteLength(2)).thenReturn(4);
		when(mockChangingParameterListMetaData.getUnicodeByteLength(2)).thenReturn(4);
		when(mockChangingParameterListMetaData.getDecimals(2)).thenReturn(0);
		when(mockChangingParameterListMetaData.isChanging(2)).thenReturn(true);
		when(mockChangingParameterListMetaData.getDescription(2)).thenReturn(PARAM_LIST_INT_PARAM);
		
		when(mockChangingParameterListMetaData.getName(3)).thenReturn(PARAM_LIST_FLOAT_PARAM);
		when(mockChangingParameterListMetaData.getType(3)).thenReturn(JCoMetaData.TYPE_FLOAT);
		when(mockChangingParameterListMetaData.getClassNameOfField(3)).thenReturn(Double.class.getName());
		when(mockChangingParameterListMetaData.isOptional(3)).thenReturn(false);
		when(mockChangingParameterListMetaData.getTypeAsString(3)).thenReturn("FLOAT");
		when(mockChangingParameterListMetaData.getRecordTypeName(3)).thenReturn("F");
		when(mockChangingParameterListMetaData.getLength(3)).thenReturn(8);
		when(mockChangingParameterListMetaData.getByteLength(3)).thenReturn(8);
		when(mockChangingParameterListMetaData.getUnicodeByteLength(3)).thenReturn(8);
		when(mockChangingParameterListMetaData.getDecimals(3)).thenReturn(0);
		when(mockChangingParameterListMetaData.isChanging(3)).thenReturn(true);
		when(mockChangingParameterListMetaData.getDescription(3)).thenReturn(PARAM_LIST_FLOAT_PARAM);
		
		when(mockChangingParameterListMetaData.getName(4)).thenReturn(PARAM_LIST_BCD_PARAM);
		when(mockChangingParameterListMetaData.getType(4)).thenReturn(JCoMetaData.TYPE_BCD);
		when(mockChangingParameterListMetaData.getClassNameOfField(4)).thenReturn(BigDecimal.class.getName());
		when(mockChangingParameterListMetaData.isOptional(4)).thenReturn(false);
		when(mockChangingParameterListMetaData.getTypeAsString(4)).thenReturn("BCD");
		when(mockChangingParameterListMetaData.getRecordTypeName(4)).thenReturn("ZBCD");
		when(mockChangingParameterListMetaData.getLength(4)).thenReturn(9);
		when(mockChangingParameterListMetaData.getByteLength(4)).thenReturn(9);
		when(mockChangingParameterListMetaData.getUnicodeByteLength(4)).thenReturn(9);
		when(mockChangingParameterListMetaData.getDecimals(4)).thenReturn(14);
		when(mockChangingParameterListMetaData.isChanging(4)).thenReturn(true);
		when(mockChangingParameterListMetaData.getDescription(4)).thenReturn(PARAM_LIST_BCD_PARAM);
		
		when(mockChangingParameterListMetaData.getName(5)).thenReturn(PARAM_LIST_BINARY_PARAM);
		when(mockChangingParameterListMetaData.getType(5)).thenReturn(JCoMetaData.TYPE_BYTE);
		when(mockChangingParameterListMetaData.getClassNameOfField(5)).thenReturn(byte[].class.getName());
		when(mockChangingParameterListMetaData.isOptional(5)).thenReturn(false);
		when(mockChangingParameterListMetaData.getTypeAsString(5)).thenReturn("BYTE");
		when(mockChangingParameterListMetaData.getRecordTypeName(5)).thenReturn("ZBYTE");
		when(mockChangingParameterListMetaData.getLength(5)).thenReturn(1);
		when(mockChangingParameterListMetaData.getByteLength(5)).thenReturn(1);
		when(mockChangingParameterListMetaData.getUnicodeByteLength(5)).thenReturn(1);
		when(mockChangingParameterListMetaData.getDecimals(5)).thenReturn(0);
		when(mockChangingParameterListMetaData.isChanging(5)).thenReturn(true);
		when(mockChangingParameterListMetaData.getDescription(5)).thenReturn(PARAM_LIST_BINARY_PARAM);
		
		when(mockChangingParameterListMetaData.getName(6)).thenReturn(PARAM_LIST_BINARY_ARRAY_PARAM);
		when(mockChangingParameterListMetaData.getType(6)).thenReturn(JCoMetaData.TYPE_BYTE);
		when(mockChangingParameterListMetaData.getClassNameOfField(6)).thenReturn(byte[].class.getName());
		when(mockChangingParameterListMetaData.isOptional(6)).thenReturn(false);
		when(mockChangingParameterListMetaData.getTypeAsString(6)).thenReturn("BYTE");
		when(mockChangingParameterListMetaData.getRecordTypeName(6)).thenReturn("ZBYTE");
		when(mockChangingParameterListMetaData.getLength(6)).thenReturn(10);
		when(mockChangingParameterListMetaData.getByteLength(6)).thenReturn(10);
		when(mockChangingParameterListMetaData.getUnicodeByteLength(6)).thenReturn(10);
		when(mockChangingParameterListMetaData.getDecimals(6)).thenReturn(0);
		when(mockChangingParameterListMetaData.isChanging(6)).thenReturn(true);
		when(mockChangingParameterListMetaData.getDescription(6)).thenReturn(PARAM_LIST_BINARY_ARRAY_PARAM);
		
		when(mockChangingParameterListMetaData.getName(7)).thenReturn(PARAM_LIST_DATE_PARAM);
		when(mockChangingParameterListMetaData.getType(7)).thenReturn(JCoMetaData.TYPE_DATE);
		when(mockChangingParameterListMetaData.getClassNameOfField(7)).thenReturn(Date.class.getName());
		when(mockChangingParameterListMetaData.isOptional(7)).thenReturn(false);
		when(mockChangingParameterListMetaData.getTypeAsString(7)).thenReturn("DATE");
		when(mockChangingParameterListMetaData.getRecordTypeName(7)).thenReturn("D");
		when(mockChangingParameterListMetaData.getLength(7)).thenReturn(8);
		when(mockChangingParameterListMetaData.getByteLength(7)).thenReturn(8);
		when(mockChangingParameterListMetaData.getUnicodeByteLength(7)).thenReturn(16);
		when(mockChangingParameterListMetaData.getDecimals(7)).thenReturn(0);
		when(mockChangingParameterListMetaData.isChanging(7)).thenReturn(true);
		when(mockChangingParameterListMetaData.getDescription(7)).thenReturn(PARAM_LIST_DATE_PARAM);
		
		when(mockChangingParameterListMetaData.getName(8)).thenReturn(PARAM_LIST_TIME_PARAM);
		when(mockChangingParameterListMetaData.getType(8)).thenReturn(JCoMetaData.TYPE_TIME);
		when(mockChangingParameterListMetaData.getClassNameOfField(8)).thenReturn(Date.class.getName());
		when(mockChangingParameterListMetaData.isOptional(8)).thenReturn(false);
		when(mockChangingParameterListMetaData.getTypeAsString(8)).thenReturn("TIME");
		when(mockChangingParameterListMetaData.getRecordTypeName(8)).thenReturn("T");
		when(mockChangingParameterListMetaData.getLength(8)).thenReturn(6);
		when(mockChangingParameterListMetaData.getByteLength(8)).thenReturn(6);
		when(mockChangingParameterListMetaData.getUnicodeByteLength(8)).thenReturn(12);
		when(mockChangingParameterListMetaData.getDecimals(8)).thenReturn(0);
		when(mockChangingParameterListMetaData.isChanging(8)).thenReturn(true);
		when(mockChangingParameterListMetaData.getDescription(8)).thenReturn(PARAM_LIST_TIME_PARAM);
		
		when(mockChangingParameterListMetaData.getName(9)).thenReturn(PARAM_LIST_STRING_PARAM);
		when(mockChangingParameterListMetaData.getType(9)).thenReturn(JCoMetaData.TYPE_STRING);
		when(mockChangingParameterListMetaData.getClassNameOfField(9)).thenReturn(String.class.getName());
		when(mockChangingParameterListMetaData.isOptional(9)).thenReturn(false);
		when(mockChangingParameterListMetaData.getTypeAsString(9)).thenReturn("STRING");
		when(mockChangingParameterListMetaData.getRecordTypeName(9)).thenReturn("STRING");
		when(mockChangingParameterListMetaData.getLength(9)).thenReturn(0);
		when(mockChangingParameterListMetaData.getByteLength(9)).thenReturn(8);
		when(mockChangingParameterListMetaData.getUnicodeByteLength(9)).thenReturn(8);
		when(mockChangingParameterListMetaData.getDecimals(9)).thenReturn(0);
		when(mockChangingParameterListMetaData.isChanging(9)).thenReturn(true);
		when(mockChangingParameterListMetaData.getDescription(9)).thenReturn(PARAM_LIST_STRING_PARAM);
		
		when(mockChangingParameterListMetaData.getName(10)).thenReturn(PARAM_LIST_STRUCTURE_PARAM);
		when(mockChangingParameterListMetaData.isStructure(10)).thenReturn(true);
		when(mockChangingParameterListMetaData.getRecordMetaData(10)).thenReturn(mockStructureMetaData);
		when(mockChangingParameterListMetaData.isOptional(10)).thenReturn(false);
		when(mockChangingParameterListMetaData.getTypeAsString(10)).thenReturn("STRUCTURE");
		when(mockChangingParameterListMetaData.getRecordTypeName(10)).thenReturn(STRUCTURE_TYPE_NAME);
		when(mockChangingParameterListMetaData.getLength(10)).thenReturn(0);
		when(mockChangingParameterListMetaData.getByteLength(10)).thenReturn(80);
		when(mockChangingParameterListMetaData.getUnicodeByteLength(10)).thenReturn(112);
		when(mockChangingParameterListMetaData.getDecimals(10)).thenReturn(0);
		when(mockChangingParameterListMetaData.isChanging(10)).thenReturn(true);
		when(mockChangingParameterListMetaData.getDescription(10)).thenReturn(PARAM_LIST_STRUCTURE_PARAM);
		
		when(mockChangingParameterListMetaData.getName(11)).thenReturn(PARAM_LIST_TABLE_PARAM);
		when(mockChangingParameterListMetaData.isTable(11)).thenReturn(true);
		when(mockChangingParameterListMetaData.getRecordMetaData(11)).thenReturn(mockStructureMetaData);
		when(mockChangingParameterListMetaData.isOptional(11)).thenReturn(false);
		when(mockChangingParameterListMetaData.getTypeAsString(11)).thenReturn("TABLE");
		when(mockChangingParameterListMetaData.getRecordTypeName(11)).thenReturn(STRUCTURE_TYPE_NAME);
		when(mockChangingParameterListMetaData.getLength(11)).thenReturn(0);
		when(mockChangingParameterListMetaData.getByteLength(11)).thenReturn(72);
		when(mockChangingParameterListMetaData.getUnicodeByteLength(11)).thenReturn(104);
		when(mockChangingParameterListMetaData.getDecimals(11)).thenReturn(0);
		when(mockChangingParameterListMetaData.isChanging(11)).thenReturn(true);
		when(mockChangingParameterListMetaData.getDescription(11)).thenReturn(PARAM_LIST_TABLE_PARAM);
		
		when(mockChangingParameterListMetaData.getFieldCount()).thenReturn(12);
		
		/* Enhance Structure Meta Data mock*/
		
		when(mockStructureMetaData.getName(0)).thenReturn(CHAR_PARAM);
		when(mockStructureMetaData.getType(0)).thenReturn(JCoMetaData.TYPE_CHAR);
		when(mockStructureMetaData.getClassNameOfField(0)).thenReturn(String.class.getName());
		when(mockStructureMetaData.getTypeAsString(0)).thenReturn("CHAR");
		when(mockStructureMetaData.getRecordTypeName(0)).thenReturn("ZCHAR");
		when(mockStructureMetaData.getLength(0)).thenReturn(10);
		when(mockStructureMetaData.getByteLength(0)).thenReturn(10);
		when(mockStructureMetaData.getUnicodeByteLength(0)).thenReturn(20);
		when(mockStructureMetaData.getDecimals(0)).thenReturn(0);
		when(mockStructureMetaData.getDescription(0)).thenReturn(CHAR_PARAM);

		when(mockStructureMetaData.getName(1)).thenReturn(NUM_PARAM);
		when(mockStructureMetaData.getType(1)).thenReturn(JCoMetaData.TYPE_NUM);
		when(mockStructureMetaData.getClassNameOfField(1)).thenReturn(String.class.getName());
		when(mockStructureMetaData.getTypeAsString(1)).thenReturn("NUM");
		when(mockStructureMetaData.getRecordTypeName(1)).thenReturn("ZNUM");
		when(mockStructureMetaData.getLength(1)).thenReturn(10);
		when(mockStructureMetaData.getByteLength(1)).thenReturn(10);
		when(mockStructureMetaData.getUnicodeByteLength(1)).thenReturn(20);
		when(mockStructureMetaData.getDecimals(1)).thenReturn(0);
		when(mockStructureMetaData.getDescription(1)).thenReturn(NUM_PARAM);
		
		when(mockStructureMetaData.getName(2)).thenReturn(INT_PARAM);
		when(mockStructureMetaData.getType(2)).thenReturn(JCoMetaData.TYPE_INT);
		when(mockStructureMetaData.getClassNameOfField(2)).thenReturn(Integer.class.getName());
		when(mockStructureMetaData.getTypeAsString(2)).thenReturn("INT");
		when(mockStructureMetaData.getRecordTypeName(2)).thenReturn("ZINT");
		when(mockStructureMetaData.getLength(2)).thenReturn(4);
		when(mockStructureMetaData.getByteLength(2)).thenReturn(4);
		when(mockStructureMetaData.getUnicodeByteLength(2)).thenReturn(4);
		when(mockStructureMetaData.getDecimals(2)).thenReturn(0);
		when(mockStructureMetaData.getDescription(2)).thenReturn(INT_PARAM);
		
		when(mockStructureMetaData.getName(3)).thenReturn(FLOAT_PARAM);
		when(mockStructureMetaData.getType(3)).thenReturn(JCoMetaData.TYPE_FLOAT);
		when(mockStructureMetaData.getClassNameOfField(3)).thenReturn(Double.class.getName());
		when(mockStructureMetaData.getTypeAsString(3)).thenReturn("FLOAT");
		when(mockStructureMetaData.getRecordTypeName(3)).thenReturn("F");
		when(mockStructureMetaData.getLength(3)).thenReturn(8);
		when(mockStructureMetaData.getByteLength(3)).thenReturn(8);
		when(mockStructureMetaData.getUnicodeByteLength(3)).thenReturn(8);
		when(mockStructureMetaData.getDecimals(3)).thenReturn(0);
		when(mockStructureMetaData.getDescription(3)).thenReturn(FLOAT_PARAM);
		
		when(mockStructureMetaData.getName(4)).thenReturn(BCD_PARAM);
		when(mockStructureMetaData.getType(4)).thenReturn(JCoMetaData.TYPE_BCD);
		when(mockStructureMetaData.getClassNameOfField(4)).thenReturn(BigDecimal.class.getName());
		when(mockStructureMetaData.getTypeAsString(4)).thenReturn("BCD");
		when(mockStructureMetaData.getRecordTypeName(4)).thenReturn("ZBCD");
		when(mockStructureMetaData.getLength(4)).thenReturn(9);
		when(mockStructureMetaData.getByteLength(4)).thenReturn(9);
		when(mockStructureMetaData.getUnicodeByteLength(4)).thenReturn(9);
		when(mockStructureMetaData.getDecimals(4)).thenReturn(14);
		when(mockStructureMetaData.getDescription(4)).thenReturn(BCD_PARAM);
		
		when(mockStructureMetaData.getName(5)).thenReturn(BINARY_PARAM);
		when(mockStructureMetaData.getType(5)).thenReturn(JCoMetaData.TYPE_BYTE);
		when(mockStructureMetaData.getClassNameOfField(5)).thenReturn(byte[].class.getName());
		when(mockStructureMetaData.getTypeAsString(5)).thenReturn("BYTE");
		when(mockStructureMetaData.getRecordTypeName(5)).thenReturn("ZBYTE");
		when(mockStructureMetaData.getLength(5)).thenReturn(1);
		when(mockStructureMetaData.getByteLength(5)).thenReturn(1);
		when(mockStructureMetaData.getUnicodeByteLength(5)).thenReturn(1);
		when(mockStructureMetaData.getDecimals(5)).thenReturn(0);
		when(mockStructureMetaData.getDescription(5)).thenReturn(BINARY_PARAM);
		
		when(mockStructureMetaData.getName(6)).thenReturn(BINARY_ARRAY_PARAM);
		when(mockStructureMetaData.getType(6)).thenReturn(JCoMetaData.TYPE_BYTE);
		when(mockStructureMetaData.getClassNameOfField(6)).thenReturn(byte[].class.getName());
		when(mockStructureMetaData.getTypeAsString(6)).thenReturn("BYTE");
		when(mockStructureMetaData.getRecordTypeName(6)).thenReturn("ZBYTE");
		when(mockStructureMetaData.getLength(6)).thenReturn(10);
		when(mockStructureMetaData.getByteLength(6)).thenReturn(10);
		when(mockStructureMetaData.getUnicodeByteLength(6)).thenReturn(10);
		when(mockStructureMetaData.getDecimals(6)).thenReturn(0);
		when(mockStructureMetaData.getDescription(6)).thenReturn(BINARY_ARRAY_PARAM);
		
		when(mockStructureMetaData.getName(7)).thenReturn(DATE_PARAM);
		when(mockStructureMetaData.getType(7)).thenReturn(JCoMetaData.TYPE_DATE);
		when(mockStructureMetaData.getClassNameOfField(7)).thenReturn(Date.class.getName());
		when(mockStructureMetaData.getTypeAsString(7)).thenReturn("DATE");
		when(mockStructureMetaData.getRecordTypeName(7)).thenReturn("D");
		when(mockStructureMetaData.getLength(7)).thenReturn(8);
		when(mockStructureMetaData.getByteLength(7)).thenReturn(8);
		when(mockStructureMetaData.getUnicodeByteLength(7)).thenReturn(16);
		when(mockStructureMetaData.getDecimals(7)).thenReturn(0);
		when(mockStructureMetaData.getDescription(7)).thenReturn(DATE_PARAM);
		
		when(mockStructureMetaData.getName(8)).thenReturn(TIME_PARAM);
		when(mockStructureMetaData.getType(8)).thenReturn(JCoMetaData.TYPE_TIME);
		when(mockStructureMetaData.getClassNameOfField(8)).thenReturn(Date.class.getName());
		when(mockStructureMetaData.getTypeAsString(8)).thenReturn("TIME");
		when(mockStructureMetaData.getRecordTypeName(8)).thenReturn("T");
		when(mockStructureMetaData.getLength(8)).thenReturn(6);
		when(mockStructureMetaData.getByteLength(8)).thenReturn(6);
		when(mockStructureMetaData.getUnicodeByteLength(8)).thenReturn(12);
		when(mockStructureMetaData.getDecimals(8)).thenReturn(0);
		when(mockStructureMetaData.getDescription(8)).thenReturn(TIME_PARAM);
		
		when(mockStructureMetaData.getName(9)).thenReturn(STRING_PARAM);
		when(mockStructureMetaData.getType(9)).thenReturn(JCoMetaData.TYPE_STRING);
		when(mockStructureMetaData.getClassNameOfField(9)).thenReturn(String.class.getName());
		when(mockStructureMetaData.getTypeAsString(9)).thenReturn("STRING");
		when(mockStructureMetaData.getRecordTypeName(9)).thenReturn("STRING");
		when(mockStructureMetaData.getLength(9)).thenReturn(0);
		when(mockStructureMetaData.getByteLength(9)).thenReturn(8);
		when(mockStructureMetaData.getUnicodeByteLength(9)).thenReturn(8);
		when(mockStructureMetaData.getDecimals(9)).thenReturn(0);
		when(mockStructureMetaData.getDescription(9)).thenReturn(STRING_PARAM);
		
		when(mockStructureMetaData.getFieldCount()).thenReturn(10);
		
	}
	
	@Test
	public void testCreateInputRecord() throws ResourceException {
		// Given
		enhanceChangingParameterListMetaData();
		
		// When
		MappedRecord inputRecord = recordFactory.createMappedRecord(INPUT_RECORD_NAME);
		inputRecord.put(PARAM_LIST_CHAR_PARAM, CHAR_PARAM_IN_VAL);
		inputRecord.put(PARAM_LIST_NUM_PARAM, NUM_PARAM_IN_VAL);
		inputRecord.put(PARAM_LIST_INT_PARAM, INT_PARAM_IN_VAL);
		inputRecord.put(PARAM_LIST_FLOAT_PARAM, FLOAT_PARAM_IN_VAL);
		inputRecord.put(PARAM_LIST_BCD_PARAM, BCD_PARAM_IN_VAL);	
		inputRecord.put(PARAM_LIST_BINARY_PARAM, BINARY_PARAM_IN_VAL);
		inputRecord.put(PARAM_LIST_BINARY_ARRAY_PARAM, BINARY_ARRAY_PARAM_IN_VAL);
		inputRecord.put(PARAM_LIST_DATE_PARAM, DATE_PARAM_IN_VAL);
		inputRecord.put(PARAM_LIST_TIME_PARAM, TIME_PARAM_IN_VAL);
		inputRecord.put(PARAM_LIST_STRING_PARAM, STRING_PARAM_IN_VAL);
		
		MappedRecord structure = (MappedRecord) inputRecord.get(PARAM_LIST_STRUCTURE_PARAM);
		structure.put(CHAR_PARAM, CHAR_PARAM_IN_VAL);
		structure.put(NUM_PARAM, NUM_PARAM_IN_VAL);
		structure.put(INT_PARAM, INT_PARAM_IN_VAL);
		structure.put(FLOAT_PARAM, FLOAT_PARAM_IN_VAL);
		structure.put(BCD_PARAM, BCD_PARAM_IN_VAL);
		structure.put(BINARY_PARAM, BINARY_PARAM_IN_VAL);
		structure.put(BINARY_ARRAY_PARAM, BINARY_ARRAY_PARAM_IN_VAL);
		structure.put(DATE_PARAM, DATE_PARAM_IN_VAL);
		structure.put(TIME_PARAM, TIME_PARAM_IN_VAL);
		structure.put(STRING_PARAM, STRING_PARAM_IN_VAL);
		
		@SuppressWarnings("rawtypes")
		IndexedRecord table = (IndexedRecord) inputRecord.get(PARAM_LIST_TABLE_PARAM);
		structure = table.add();
		structure.put(CHAR_PARAM, CHAR_PARAM_IN_VAL);
		structure.put(NUM_PARAM, NUM_PARAM_IN_VAL);
		structure.put(INT_PARAM, INT_PARAM_IN_VAL);
		structure.put(FLOAT_PARAM, FLOAT_PARAM_IN_VAL);
		structure.put(BCD_PARAM, BCD_PARAM_IN_VAL);
		structure.put(BINARY_PARAM, BINARY_PARAM_IN_VAL);
		structure.put(BINARY_ARRAY_PARAM, BINARY_ARRAY_PARAM_IN_VAL);
		structure.put(DATE_PARAM, DATE_PARAM_IN_VAL);
		structure.put(TIME_PARAM, TIME_PARAM_IN_VAL);
		structure.put(STRING_PARAM, STRING_PARAM_IN_VAL);
		
		((MappedRecordImpl)inputRecord).fill(mockChangingParameterList);
		
		// Then
		assertThat("recordFactory.createMappedRecord(INPUT_RECORD_NAME) returned unexpected value", inputRecord, notNullValue());

		verify(mockParameterListCharField, times(1)).setValue((Object)CHAR_PARAM_IN_VAL);
		verify(mockCharField, times(2)).setValue((Object)CHAR_PARAM_IN_VAL);

		verify(mockParameterListNumField, times(1)).setValue((Object)NUM_PARAM_IN_VAL);
		verify(mockNumField, times(2)).setValue((Object)NUM_PARAM_IN_VAL);

		verify(mockParameterListIntField, times(1)).setValue((Object)INT_PARAM_IN_VAL);
		verify(mockIntField, times(2)).setValue((Object)INT_PARAM_IN_VAL);

		verify(mockParameterListFloatField, times(1)).setValue((Object)FLOAT_PARAM_IN_VAL);
		verify(mockFloatField, times(2)).setValue((Object)FLOAT_PARAM_IN_VAL);

		verify(mockParameterListBCDField, times(1)).setValue((Object)BCD_PARAM_IN_VAL);
		verify(mockBCDField, times(2)).setValue((Object)BCD_PARAM_IN_VAL);

		verify(mockParameterListBinaryField, times(1)).setValue((Object)BINARY_PARAM_IN_VAL);
		verify(mockBinaryField, times(2)).setValue((Object)BINARY_PARAM_IN_VAL);

		verify(mockParameterListBinaryArrayField, times(1)).setValue((Object)BINARY_ARRAY_PARAM_IN_VAL);
		verify(mockBinaryArrayField, times(2)).setValue((Object)BINARY_ARRAY_PARAM_IN_VAL);

		verify(mockParameterListDateField, times(1)).setValue((Object)DATE_PARAM_IN_VAL);
		verify(mockDateField, times(2)).setValue((Object)DATE_PARAM_IN_VAL);

		verify(mockParameterListTimeField, times(1)).setValue((Object)TIME_PARAM_IN_VAL);
		verify(mockTimeField, times(2)).setValue((Object)TIME_PARAM_IN_VAL);

		verify(mockParameterListStringField, times(1)).setValue((Object)STRING_PARAM_IN_VAL);
		verify(mockStringField, times(2)).setValue((Object)STRING_PARAM_IN_VAL);
		
		verify(mockParameterListStructureField, times(1)).isStructure();
		verify(mockParameterListStructureField, times(1)).getStructure();

		verify(mockParameterListTableField, times(1)).isTable();
		verify(mockParameterListTableField, times(1)).getTable();

	}

	@Test
	public void testCreateOutputRecord() throws ResourceException {
		// Given
		enhanceChangingParameterListMetaData();
		
		// When
		MappedRecord outputRecord = recordFactory.createMappedRecord(OUTPUT_RECORD_NAME);
		((MappedRecordImpl)outputRecord).put(mockChangingParameterList);
		
		// Then
		assertThat("recordFactory.createMappedRecord(OUTPUT_RECORD_NAME) returned unexpected null value", outputRecord, notNullValue());
		
		assertThat("outputRecord.get(PARAM_LIST_CHAR_PARAM) returned '" +  outputRecord.get(PARAM_LIST_CHAR_PARAM) + "' instead of expected value '" + CHAR_PARAM_OUT_VAL + "'", (String) outputRecord.get(PARAM_LIST_CHAR_PARAM), is(CHAR_PARAM_OUT_VAL));
		assertThat("outputRecord.get(PARAM_LIST_NUM_PARAM) returned '" +  outputRecord.get(PARAM_LIST_NUM_PARAM) + "' instead of expected value '" + NUM_PARAM_OUT_VAL + "'", (String) outputRecord.get(PARAM_LIST_NUM_PARAM), is(NUM_PARAM_OUT_VAL));
		assertThat("outputRecord.get(PARAM_LIST_INT_PARAM) returned '" +  outputRecord.get(PARAM_LIST_INT_PARAM) + "' instead of expected value '" + INT_PARAM_OUT_VAL + "'", (Integer) outputRecord.get(PARAM_LIST_INT_PARAM), is(INT_PARAM_OUT_VAL));
		assertThat("outputRecord.get(PARAM_LIST_FLOAT_PARAM) returned '" +  outputRecord.get(PARAM_LIST_FLOAT_PARAM) + "' instead of expected value '" + FLOAT_PARAM_OUT_VAL + "'", (Double) outputRecord.get(PARAM_LIST_FLOAT_PARAM), is(FLOAT_PARAM_OUT_VAL));
		assertThat("outputRecord.get(PARAM_LIST_BCD_PARAM) returned '" +  outputRecord.get(PARAM_LIST_BCD_PARAM) + "' instead of expected value '" + BCD_PARAM_OUT_VAL + "'", (BigDecimal) outputRecord.get(PARAM_LIST_BCD_PARAM), is(BCD_PARAM_OUT_VAL));
		assertThat("outputRecord.get(PARAM_LIST_BINARY_PARAM) returned '" +  outputRecord.get(PARAM_LIST_BINARY_PARAM) + "' instead of expected value '" + BINARY_PARAM_OUT_VAL + "'", (byte[]) outputRecord.get(PARAM_LIST_BINARY_PARAM), is(BINARY_PARAM_OUT_VAL));
		assertThat("outputRecord.get(PARAM_LIST_BINARY_ARRAY_PARAM) returned '" +  outputRecord.get(PARAM_LIST_BINARY_ARRAY_PARAM) + "' instead of expected value '" + BINARY_ARRAY_PARAM_OUT_VAL + "'", (byte[]) outputRecord.get(PARAM_LIST_BINARY_ARRAY_PARAM), is(BINARY_ARRAY_PARAM_OUT_VAL));
		assertThat("outputRecord.getP(ARAM_LIST_DATE_PARAM) returned '" +  outputRecord.get(PARAM_LIST_DATE_PARAM) + "' instead of expected value '" + DATE_PARAM_OUT_VAL + "'", (Date) outputRecord.get(PARAM_LIST_DATE_PARAM), is(DATE_PARAM_OUT_VAL));
		assertThat("outputRecord.get(PARAM_LIST_TIME_PARAM) returned '" +  outputRecord.get(PARAM_LIST_TIME_PARAM) + "' instead of expected value '" + TIME_PARAM_OUT_VAL + "'", (Date) outputRecord.get(PARAM_LIST_TIME_PARAM), is(TIME_PARAM_OUT_VAL));
		assertThat("outputRecord.get(PARAM_LIST_STRING_PARAM) returned '" +  outputRecord.get(PARAM_LIST_STRING_PARAM) + "' instead of expected value '" + STRING_PARAM_OUT_VAL + "'", (String) outputRecord.get(PARAM_LIST_STRING_PARAM), is(STRING_PARAM_OUT_VAL));
		
		MappedRecord structure = (MappedRecord) outputRecord.get(PARAM_LIST_STRUCTURE_PARAM);
		assertThat("structure.get(PARAM_LIST_STRUCTURE_PARAM) returned unexpected null value", structure, notNullValue());
		assertThat("structure.get(CHAR_PARAM) returned '" +  structure.get(CHAR_PARAM) + "' instead of expected value '" + CHAR_PARAM_OUT_VAL + "'", (String) structure.get(CHAR_PARAM), is(CHAR_PARAM_OUT_VAL));
		assertThat("structure.get(NUM_PARAM) returned '" +  structure.get(NUM_PARAM) + "' instead of expected value '" + NUM_PARAM_OUT_VAL + "'", (String) structure.get(NUM_PARAM), is(NUM_PARAM_OUT_VAL));
		assertThat("structure.get(INT_PARAM) returned '" +  structure.get(INT_PARAM) + "' instead of expected value '" + INT_PARAM_OUT_VAL + "'", (Integer) structure.get(INT_PARAM), is(INT_PARAM_OUT_VAL));
		assertThat("structure.get(FLOAT_PARAM) returned '" +  structure.get(FLOAT_PARAM) + "' instead of expected value '" + FLOAT_PARAM_OUT_VAL + "'", (Double) structure.get(FLOAT_PARAM), is(FLOAT_PARAM_OUT_VAL));
		assertThat("structure.get(BCD_PARAM) returned '" +  structure.get(BCD_PARAM) + "' instead of expected value '" + BCD_PARAM_OUT_VAL + "'", (BigDecimal) structure.get(BCD_PARAM), is(BCD_PARAM_OUT_VAL));
		assertThat("structure.get(BINARY_PARAM) returned '" +  structure.get(BINARY_PARAM) + "' instead of expected value '" + BINARY_PARAM_OUT_VAL + "'", (byte[]) structure.get(BINARY_PARAM), is(BINARY_PARAM_OUT_VAL));
		assertThat("structure.get(BINARY_ARRAY_PARAM) returned '" +  structure.get(BINARY_ARRAY_PARAM) + "' instead of expected value '" + BINARY_ARRAY_PARAM_OUT_VAL + "'", (byte[]) structure.get(BINARY_ARRAY_PARAM), is(BINARY_ARRAY_PARAM_OUT_VAL));
		assertThat("structure.get(DATE_PARAM) returned '" +  structure.get(DATE_PARAM) + "' instead of expected value '" + DATE_PARAM_OUT_VAL + "'", (Date) structure.get(DATE_PARAM), is(DATE_PARAM_OUT_VAL));
		assertThat("structure.get(TIME_PARAM) returned '" +  structure.get(TIME_PARAM) + "' instead of expected value '" + TIME_PARAM_OUT_VAL + "'", (Date) structure.get(TIME_PARAM), is(TIME_PARAM_OUT_VAL));
		assertThat("structure.get(STRING_PARAM) returned '" +  structure.get(STRING_PARAM) + "' instead of expected value '" + STRING_PARAM_OUT_VAL + "'", (String) structure.get(STRING_PARAM), is(STRING_PARAM_OUT_VAL));
		
		@SuppressWarnings("rawtypes")
		IndexedRecord table = (IndexedRecord) outputRecord.get(PARAM_LIST_TABLE_PARAM);
		assertThat("outputRecord.get(PARAM_LIST_TABLE_PARAM) returned unexpected null value", table, notNullValue());
		assertThat("table.size() returned '" + table.size() + "' instead of expected value of '1'", table.size(), is(1));
		MappedRecord tableRow = table.get(0);
		assertThat("tableRow.get(CHAR_PARAM) returned '" +  tableRow.get(CHAR_PARAM) + "' instead of expected value '" + CHAR_PARAM_OUT_VAL + "'", (String) tableRow.get(CHAR_PARAM), is(CHAR_PARAM_OUT_VAL));
		assertThat("tableRow.get(NUM_PARAM) returned '" +  tableRow.get(NUM_PARAM) + "' instead of expected value '" + NUM_PARAM_OUT_VAL + "'", (String) tableRow.get(NUM_PARAM), is(NUM_PARAM_OUT_VAL));
		assertThat("tableRow.get(INT_PARAM) returned '" +  tableRow.get(INT_PARAM) + "' instead of expected value '" + INT_PARAM_OUT_VAL + "'", (Integer) tableRow.get(INT_PARAM), is(INT_PARAM_OUT_VAL));
		assertThat("tableRow.get(FLOAT_PARAM) returned '" +  tableRow.get(FLOAT_PARAM) + "' instead of expected value '" + FLOAT_PARAM_OUT_VAL + "'", (Double) tableRow.get(FLOAT_PARAM), is(FLOAT_PARAM_OUT_VAL));
		assertThat("tableRow.get(BCD_PARAM) returned '" +  tableRow.get(BCD_PARAM) + "' instead of expected value '" + BCD_PARAM_OUT_VAL + "'", (BigDecimal) tableRow.get(BCD_PARAM), is(BCD_PARAM_OUT_VAL));
		assertThat("tableRow.get(BINARY_PARAM) returned '" +  tableRow.get(BINARY_PARAM) + "' instead of expected value '" + BINARY_PARAM_OUT_VAL + "'", (byte[]) tableRow.get(BINARY_PARAM), is(BINARY_PARAM_OUT_VAL));
		assertThat("tableRow.get(BINARY_ARRAY_PARAM) returned '" +  tableRow.get(BINARY_ARRAY_PARAM) + "' instead of expected value '" + BINARY_ARRAY_PARAM_OUT_VAL + "'", (byte[]) tableRow.get(BINARY_ARRAY_PARAM), is(BINARY_ARRAY_PARAM_OUT_VAL));
		assertThat("tableRow.get(DATE_PARAM) returned '" +  tableRow.get(DATE_PARAM) + "' instead of expected value '" + DATE_PARAM_OUT_VAL + "'", (Date) tableRow.get(DATE_PARAM), is(DATE_PARAM_OUT_VAL));
		assertThat("tableRow.get(TIME_PARAM) returned '" +  tableRow.get(TIME_PARAM) + "' instead of expected value '" + TIME_PARAM_OUT_VAL + "'", (Date) tableRow.get(TIME_PARAM), is(TIME_PARAM_OUT_VAL));
		assertThat("tableRow.get(STRING_PARAM) returned '" +  tableRow.get(STRING_PARAM) + "' instead of expected value '" + STRING_PARAM_OUT_VAL + "'", (String) tableRow.get(STRING_PARAM), is(STRING_PARAM_OUT_VAL));
	}

	@Test
	public void testCreateMappedRecord() throws ResourceException {
		// Given
		enhanceChangingParameterListMetaData();

		// When
		MappedRecord mappedRecord = recordFactory.createMappedRecord(MAPPED_RECORD_NAME);
		
		// Then
		assertThat("recordFactory.createMappedRecord(MAPPED_RECORD_NAME) returned unexpected null value", mappedRecord, notNullValue());
	}

	@Test
	public void testCreateIndexedRecord() throws ResourceException {
		// Given
		enhanceChangingParameterListMetaData();

		// When
		@SuppressWarnings("rawtypes")
		IndexedRecord mappedRecord = recordFactory.createIndexedRecord(INDEXED_RECORD_NAME);
		
		// Then
		assertThat("recordFactory.createIndexedRecord(INDEXED_RECORD_NAME) returned unexpected null value", mappedRecord, notNullValue());
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
		enhanceChangingParameterListMetaData();
		when(mockInteractionSpec.getFunctionName()).thenReturn(FUNCTION_MODULE_NAME);
		when(mockDestination.getRepository()).thenReturn(mockRepository);
		when(mockRepository.getRequest(FUNCTION_MODULE_NAME)).thenReturn(mockRequest);
		when(mockRequest.execute(mockDestination)).thenReturn(mockResponse);

		
		// When
		interaction.execute(mockInteractionSpec, mockInput, mockOutput);
		
		// Then
		verify(mockInteractionSpec, times(1)).getFunctionName();
		verify(mockInput, times(1)).fill(mockRequest);
		verify(mockRequest, times(1)).execute(mockDestination);
		verify(mockOutput, times(1)).put(mockResponse);
	}

	@Test(expected = ResourceException.class)
	public void testExecuteWithInvalidInteractionSpec() throws JCoException, ResourceException {
		// Given
		javax.resource.cci.InteractionSpec mockBogusInteractionSpec = mock(javax.resource.cci.InteractionSpec.class);
		enhanceChangingParameterListMetaData();
		when(mockInteractionSpec.getFunctionName()).thenReturn(null);
		when(mockDestination.getRepository()).thenReturn(mockRepository);
		when(mockRepository.getRequest(FUNCTION_MODULE_NAME)).thenReturn(mockRequest);
		
		// When
		interaction.execute(mockBogusInteractionSpec, mockInput, mockOutput);
		
		// Then
		fail("InteractionImpl.execute(interactionSpec,inputRecord,outputRecord) called with invalid output Record failed to throw ResourceException");
	}

	@Test(expected = ResourceException.class)
	public void testExecuteWithInvalidInputRecord() throws JCoException, ResourceException {
		// Given
		Record mockBogusRecord = mock(Record.class);
		enhanceChangingParameterListMetaData();
		when(mockInteractionSpec.getFunctionName()).thenReturn(null);
		when(mockDestination.getRepository()).thenReturn(mockRepository);
		when(mockRepository.getRequest(FUNCTION_MODULE_NAME)).thenReturn(mockRequest);
		
		// When
		interaction.execute(mockInteractionSpec, mockBogusRecord, mockOutput);
		
		// Then
		fail("InteractionImpl.execute(interactionSpec,inputRecord,outputRecord) called with invalid output Record failed to throw ResourceException");
	}

	@Test(expected = ResourceException.class)
	public void testExecuteWithInvalidOutputRecord() throws JCoException, ResourceException {
		// Given
		Record mockBogusRecord = mock(Record.class);
		enhanceChangingParameterListMetaData();
		when(mockInteractionSpec.getFunctionName()).thenReturn(null);
		when(mockDestination.getRepository()).thenReturn(mockRepository);
		when(mockRepository.getRequest(FUNCTION_MODULE_NAME)).thenReturn(mockRequest);
		
		// When
		interaction.execute(mockInteractionSpec, mockInput, mockBogusRecord);
		
		// Then
		fail("InteractionImpl.execute(interactionSpec,inputRecord,outputRecord) called with invalid output Record failed to throw ResourceException");
	}

	@Test(expected = ResourceException.class)
	public void testExecuteWithInvalidFunctionName() throws JCoException, ResourceException {
		// Given
		when(mockInteractionSpec.getFunctionName()).thenReturn(null);
		when(mockDestination.getRepository()).thenReturn(mockRepository);
		when(mockRepository.getRequest(FUNCTION_MODULE_NAME)).thenReturn(mockRequest);
		
		// When
		interaction.execute(mockInteractionSpec, mockInput, mockOutput);
		
		// Then
		fail("InteractionImpl.execute(interactionSpec,inputRecord,outputRecord) called with InteractionSpec with null function name failed to throw ResourceException");
	}

	@Test(expected = ResourceException.class)
	public void testExecuteWithFunctionExecuteThrowingJCoException() throws JCoException, ResourceException {
		// Given
		when(mockInteractionSpec.getFunctionName()).thenReturn(FUNCTION_MODULE_NAME);
		when(mockDestination.getRepository()).thenReturn(mockRepository);
		when(mockRepository.getRequest(FUNCTION_MODULE_NAME)).thenReturn(mockRequest);
		JCoException mockJCoException = mock(JCoException.class);
		doThrow(mockJCoException).when(mockRequest).execute(mockDestination);
		
		// When
		interaction.execute(mockInteractionSpec, mockInput, mockOutput);
		
		// Then
		fail("interaction.execute(interactionSpec,inputRecord,outputRecord) failed to throw ResourceException when underlying JCoFunction threw JCoException");
	}

	@Test
	public void testExecuteWithFunctionExecuteThrowingAbapException() throws JCoException, ResourceException {
		// Given
		when(mockInteractionSpec.getFunctionName()).thenReturn(FUNCTION_MODULE_NAME);
		when(mockDestination.getRepository()).thenReturn(mockRepository);
		when(mockRepository.getRequest(FUNCTION_MODULE_NAME)).thenReturn(mockRequest);
		AbapException mockAbapException = mock(AbapException.class);
		doThrow(mockAbapException).when(mockRequest).execute(mockDestination);
		
		// When
		boolean success = interaction.execute(mockInteractionSpec, mockInput, mockOutput);
		
		// Then
		if (success)
			fail("interaction.execute(interactionSpec,inputRecord,outputRecord) failed to return false when underlying JCoFunction threw AbapException");
	}
	@Test
	public void testExecuteInteractionWithInputRecordOnly() throws JCoException, ResourceException {
		// Given
		enhanceChangingParameterListMetaData();
		when(mockInteractionSpec.getFunctionName()).thenReturn(FUNCTION_MODULE_NAME);
		when(mockDestination.getRepository()).thenReturn(mockRepository);
		when(mockRepository.getRequest(FUNCTION_MODULE_NAME)).thenReturn(mockRequest);
		when(mockRequest.execute(mockDestination)).thenReturn(mockResponse);
		
		// When
		Record output = interaction.execute(mockInteractionSpec, mockInput);
		
		// Then
		assertThat("interaction.execute(interactionSpec,inputRecord) returned  unexpected null value", output, notNullValue());
	}	
	
	@Test
	public void testExecuteInteractionWithInputRecordOnlyAndFunctionExecuteThrowingAbapException() throws JCoException, ResourceException {
		// Given
		when(mockInteractionSpec.getFunctionName()).thenReturn(FUNCTION_MODULE_NAME);
		when(mockDestination.getRepository()).thenReturn(mockRepository);
		when(mockRepository.getRequest(FUNCTION_MODULE_NAME)).thenReturn(mockRequest);
		
		AbapException mockAbapException = mock(AbapException.class);
		doThrow(mockAbapException).when(mockRequest).execute(mockDestination);
		
		// When
		Record output = interaction.execute(mockInteractionSpec, mockInput);
		
		// Then
		if (output != null)
			fail("interaction.execute(interactionSpec,inputRecord) failed to return null when underlying JCoFunction threw AbapException");
	}
	
	@Test
	public void testGetWarnings() throws JCoException, ResourceException {
		// Given
		when(mockInteractionSpec.getFunctionName()).thenReturn(FUNCTION_MODULE_NAME);
		when(mockDestination.getRepository()).thenReturn(mockRepository);
		when(mockRepository.getRequest(FUNCTION_MODULE_NAME)).thenReturn(mockRequest);
		
		doThrow(mockAbapException).when(mockRequest).execute(mockDestination);
		
		// When
		interaction.execute(mockInteractionSpec, mockInput, mockOutput);
		ResourceWarning warning = interaction.getWarnings();
		
		// Then
		if (warning == null)
			fail("interation.execute(interactionSpec,inputRecord,outputRecord) failed to set ResourceWarning when underlying JCoFunction threw AbapException");
	}

	@Test
	public void testClearWarnings() throws JCoException, ResourceException {
		// Given
		when(mockInteractionSpec.getFunctionName()).thenReturn(FUNCTION_MODULE_NAME);
		when(mockDestination.getRepository()).thenReturn(mockRepository);
		when(mockRepository.getRequest(FUNCTION_MODULE_NAME)).thenReturn(mockRequest);
		
		doThrow(mockAbapException).when(mockRequest).execute(mockDestination);
		
		// When
		interaction.execute(mockInteractionSpec, mockInput, mockOutput);
		interaction.clearWarnings();
		ResourceWarning warning = interaction.getWarnings();
		
		// Then
		if (warning != null)
			fail("interaction.clearWarnings() failed to clear ResourceWarning");

	}	
}
