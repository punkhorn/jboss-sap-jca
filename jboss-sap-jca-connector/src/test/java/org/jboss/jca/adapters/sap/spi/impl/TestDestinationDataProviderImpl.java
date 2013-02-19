package org.jboss.jca.adapters.sap.spi.impl;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.sap.conn.jco.ext.DataProviderException;
import com.sap.conn.jco.ext.DestinationDataEventListener;

public class TestDestinationDataProviderImpl {

	private static final String BOGUS_DESTINATION_NAME = "BogusDestinationName";

	private static final String TEST_CONNECTION_REQUEST_INFO = "TestConnectionRequestInfo";
	
	private DestinationDataEventListener mockDestinationDataEventListener;
	private DestinationDataProviderImpl destinationDataProvider;
	private ConnectionRequestInfoImpl mockDestinationConnectionRequestInfo;
	
	@Before
	public void setUp() throws Exception {
		mockDestinationDataEventListener = mock(DestinationDataEventListener.class);
		mockDestinationConnectionRequestInfo = mock(ConnectionRequestInfoImpl.class);
		
		destinationDataProvider = new DestinationDataProviderImpl();
		destinationDataProvider.setDestinationDataEventListener(mockDestinationDataEventListener);
	}

	@Test ( expected = DataProviderException.class )
	public void testGetDestinationPropertiesWithNullDestinationName() {
		// When
		destinationDataProvider.getDestinationProperties(null);
		
		// Then
		fail("DestinationDataProviderImpl.getDestinationProperties(null) failed to throw DataProviderException");
	}

	@Test ( expected = DataProviderException.class )
	public void testGetDestinationPropertiesWithBogusDestinationName() {
		// When
		destinationDataProvider.getDestinationProperties(BOGUS_DESTINATION_NAME);
		
		// Then
		fail("DestinationDataProviderImpl.getDestinationProperties(bogusDestinationName) failed to throw DataProviderException");
	}

	@Test
	public void testGetDestinationProperties() {
		// Given
		destinationDataProvider.addConnectionRequestInfo(TEST_CONNECTION_REQUEST_INFO, mockDestinationConnectionRequestInfo);
		
		// When
		ConnectionRequestInfoImpl destinationProperties = destinationDataProvider.getConnectionRequestInfo(TEST_CONNECTION_REQUEST_INFO);
		
		// Then
		assertThat("DestinationDataProviderImpl.getDestinationProperties(TEST_DESTINATION_PROPERTIES) returned null JBossSAPConnectionSpec", destinationProperties, notNullValue());
		assertThat("DestinationDataProviderImpl.getDestinationProperties(TEST_DESTINATION_PROPERTIES) returned JBossSAPConnectionSpec instance different than what was set originally", destinationProperties, is(mockDestinationConnectionRequestInfo));
	}

	@Test
	public void testAddDestinationProperties() {
		// When
		destinationDataProvider.addConnectionRequestInfo(TEST_CONNECTION_REQUEST_INFO, mockDestinationConnectionRequestInfo);
		
		// Then
		verify(mockDestinationDataEventListener).updated(TEST_CONNECTION_REQUEST_INFO);
	}

	@Test ( expected = DataProviderException.class )
	public void testAddDestinationPropertiesWithNullDestinationName() {
		// When
		destinationDataProvider.addConnectionRequestInfo(null, mockDestinationConnectionRequestInfo);
		
		// Then
		fail("DestinationDataProviderImpl.addDestinationProperties(null, destinationProperties) failed to throw DataProviderException");
	}

	@Test( expected = DataProviderException.class )
	public void testRemoveDestinationPropertiesWithNullDestinationName() {
		// When
		destinationDataProvider.removeConnectionRequestInfo(null);

		// Then
		fail("DestinationDataProviderImpl.removeDestinationProperties(null) failed to throw DataProviderException");
	}

	@Test
	public void testRemoveDestinationPropertiesWithBogusDestinationName() {
		// When
		destinationDataProvider.removeConnectionRequestInfo(BOGUS_DESTINATION_NAME);
		
		// Then
		verify(mockDestinationDataEventListener, never()).deleted(BOGUS_DESTINATION_NAME);
	}

	@Test
	public void testRemoveDestinationProperties() {
		// Given
		destinationDataProvider.addConnectionRequestInfo(TEST_CONNECTION_REQUEST_INFO, mockDestinationConnectionRequestInfo);
		
		// When
		ConnectionRequestInfoImpl destinationProperties = destinationDataProvider.removeConnectionRequestInfo(TEST_CONNECTION_REQUEST_INFO);
		
		// Then
		assertThat("DestinationDataProviderImpl.removeDestinationProperties(TEST_DESTINATION_PROPERTIES) returned null JBossSAPConnectionSpec", destinationProperties, notNullValue());
		assertThat("", destinationProperties,is(mockDestinationConnectionRequestInfo));
		verify(mockDestinationDataEventListener).deleted(TEST_CONNECTION_REQUEST_INFO);
	}

	@Test
	public void testSupportsEvents() {
		// When
		boolean supportsEvents = destinationDataProvider.supportsEvents();
		
		// Then
		assertThat("DestinationDataProviderImpl.supportsEvents() returned false", supportsEvents, is(true));
	}

}
