package org.jboss.jca.adapters.sap.cci.impl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.jboss.jca.adapters.sap.cci.CciFactory;
import org.junit.Before;
import org.junit.Test;

public class TestMappedRecordImpl {
	
	/**
	 * The name of mapped record used in get/set tests
	 */
	private static final String TEST_GET_SET_RECORD_NAME = "TEST_GET_SET_RECORD_NAME";
	
	/**
	 * The Short Description of mapped record used in get/set tests.
	 */
	private static final String TEST_GET_SET_RECORD_DESCRIPTION = "TEST_GET_SET_RECORD_DESCRIPTION";
	
	private MappedRecordImpl mappedRecord;

	@Before
	public void setUp() throws Exception {
		// Given
		mappedRecord = (MappedRecordImpl) CciFactory.eINSTANCE.createMappedRecord();
	}

	@Test
	public void testSetGetRecordName() {
		// When
		mappedRecord.setRecordName(TEST_GET_SET_RECORD_NAME);
		String recordName = mappedRecord.getRecordName();
		
		// Then
		assertThat("MappedRecordImpl.getRecordName() returned name different than set by MappedRecordImpl.setRecordName(name)", recordName, is(TEST_GET_SET_RECORD_NAME));
	}

	@Test
	public void testSetGetRecordShortDescription() {
		// When
		mappedRecord.setRecordShortDescription(TEST_GET_SET_RECORD_DESCRIPTION);
		String recordDescrption = mappedRecord.getRecordShortDescription();
		
		// Then
		assertThat("MappedRecordImpl.getRecordShortDescription() returned name different than set by MappedRecordImpl.setRecordShortDescription(description)", recordDescrption, is(TEST_GET_SET_RECORD_DESCRIPTION));
	}

}
