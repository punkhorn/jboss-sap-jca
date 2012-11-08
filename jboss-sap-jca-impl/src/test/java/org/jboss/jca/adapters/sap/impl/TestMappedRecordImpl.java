package org.jboss.jca.adapters.sap.impl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TestMappedRecordImpl {
	
	private static final String TEST_RECORD_NAME = "TEST_RECORD_NAME";
	private static final String NEW_TEST_RECORD_NAME = "NEW_TEST_RECORD_NAME";
	private static final String TEST_RECORD_DESCRIPTION = "TEST_RECORD_DESCRIPTION";
	private static final String NEW_TEST_RECORD_DESCRIPTION = "NEW_TEST_RECORD_DESCRIPTION";
	
	private MappedRecordImpl mappedRecordWithName;
	private MappedRecordImpl mappedRecordWithNameAndDescription;

	@Before
	public void setUp() throws Exception {
		// Given
		mappedRecordWithName = new MappedRecordImpl(TEST_RECORD_NAME);
		mappedRecordWithNameAndDescription = new MappedRecordImpl(TEST_RECORD_NAME, TEST_RECORD_DESCRIPTION);
	}

	@Test
	public void testMappedRecordImplWithName() {
		// When
		String recordName = mappedRecordWithName.getRecordName();
		
		// Then
		assertThat("MappedRecordImpl.getRecordName() returned unexpected value", recordName, is(TEST_RECORD_NAME));
	}

	@Test
	public void testMappedRecordImplWithNameAndDescription() {
		// When
		String recordName = mappedRecordWithName.getRecordName();
		String recordDescription = mappedRecordWithNameAndDescription.getRecordShortDescription();
		
		// Then
		assertThat("MappedRecordImpl.getRecordName() returned unexpected value", recordName, is(TEST_RECORD_NAME));
		assertThat("MappedRecordImpl.getRecordShortDescription() returned unexpected value", recordDescription, is(TEST_RECORD_DESCRIPTION));
	}

	@Test
	public void testGetRecordName() {
		// When
		String recordName = mappedRecordWithName.getRecordName();
		
		// Then
		assertThat("MappedRecordImpl.getRecordName() returned unexpected value", recordName, is(TEST_RECORD_NAME));
	}

	@Test
	public void testSetRecordName() {
		// When
		mappedRecordWithName.setRecordName(NEW_TEST_RECORD_NAME);
		String recordName = mappedRecordWithName.getRecordName();
		
		// Then
		assertThat("MappedRecordImpl.getRecordName() returned name different than set by MappedRecordImpl.setRecordName(name)", recordName, is(NEW_TEST_RECORD_NAME));
	}

	@Test
	public void testSetRecordShortDescription() {
		// When
		mappedRecordWithNameAndDescription.setRecordShortDescription(NEW_TEST_RECORD_DESCRIPTION);
		String recordDescrption = mappedRecordWithNameAndDescription.getRecordShortDescription();
		
		// Then
		assertThat("MappedRecordImpl.getRecordShortDescription() returned name different than set by MappedRecordImpl.setRecordShortDescription(description)", recordDescrption, is(NEW_TEST_RECORD_DESCRIPTION));
	}

}
