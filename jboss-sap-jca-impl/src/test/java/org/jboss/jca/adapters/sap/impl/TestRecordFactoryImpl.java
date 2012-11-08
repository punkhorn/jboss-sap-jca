package org.jboss.jca.adapters.sap.impl;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import javax.resource.ResourceException;
import javax.resource.cci.IndexedRecord;
import javax.resource.cci.MappedRecord;

import org.junit.Test;

public class TestRecordFactoryImpl {
	
	private static final String MAPPED_RECORD_NAME = "MAPPED_RECORD_NAME";
	private static final String INDEXED_RECORD_NAME = "INDEXED_RECORD_NAME";

	@Test
	public void testCreateMappedRecord() throws ResourceException {
		// When
		MappedRecord mappedRecord = RecordFactoryImpl.INSTANCE.createMappedRecord(MAPPED_RECORD_NAME);
		
		// Then
		assertThat("RecordFactoryImpl.INSTANCE.createMappedRecord(MAPPED_RECORD_NAME) returned unexpected value", mappedRecord, notNullValue());
	}

	@Test
	public void testCreateIndexedRecord() throws ResourceException {
		// When
		IndexedRecord mappedRecord = RecordFactoryImpl.INSTANCE.createIndexedRecord(INDEXED_RECORD_NAME);
		
		// Then
		assertThat("RecordFactoryImpl.INSTANCE.createIndexedRecord(INDEXED_RECORD_NAME) returned unexpected value", mappedRecord, notNullValue());
	}

}
