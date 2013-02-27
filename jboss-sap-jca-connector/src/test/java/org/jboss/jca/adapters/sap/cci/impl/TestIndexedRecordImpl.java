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
package org.jboss.jca.adapters.sap.cci.impl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * Units Tests {@link IndexedRecordImpl} class
 * 
 * @author William Collins
 *
 */
public class TestIndexedRecordImpl {
	
	/**
	 * The name of indexed record used in get/set tests
	 */
	private static final String TEST_GET_SET_RECORD_NAME = "getGetSetRecordName";
 
	/**
	 * The Short Description of indexed record used in get/set tests.
	 */
	private static final String TEST_GET_SET_RECORD_DESCRIPTION = "testGetSetRecordDescription";
	
	@SuppressWarnings("rawtypes")
	private IndexedRecordImpl indexedRecord;
	
	@SuppressWarnings("rawtypes")
	@Before
	public void setUp() throws Exception {
		// Given
		indexedRecord = (IndexedRecordImpl) CciFactoryImpl.eINSTANCE.createIndexedRecord();
	}

	@Test
	public void testGetSetRecordName() {
		// When
		indexedRecord.setRecordName(TEST_GET_SET_RECORD_NAME);
		String recordName = indexedRecord.getRecordName();
		
		// Then
		assertThat("IndexedRecordImpl.getRecordName() returned unexpected value:",recordName, is(TEST_GET_SET_RECORD_NAME));
	}

	@Test
	public void testGetSetRecordShortDescription() {
		// When
		indexedRecord.setRecordShortDescription(TEST_GET_SET_RECORD_DESCRIPTION);
		String recordDescription = indexedRecord.getRecordShortDescription();
		
		// Then
		assertThat("IndexedRecordImpl.getRecordShortDescription() returned unexpected value:", recordDescription, is(TEST_GET_SET_RECORD_DESCRIPTION));
	}

}
