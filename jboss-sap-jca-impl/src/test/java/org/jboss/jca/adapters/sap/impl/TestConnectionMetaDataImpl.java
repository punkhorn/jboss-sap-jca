package org.jboss.jca.adapters.sap.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.jboss.jca.adapters.sap.impl.ConnectionMetaDataImpl.*;

import java.io.IOException;
import java.util.Properties;

import javax.resource.ResourceException;

import org.junit.Before;
import org.junit.Test;

import com.sap.conn.jco.JCoAttributes;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;

public class TestConnectionMetaDataImpl {
	
	private static final String TEST_CONNECTION_META_DATA_PROPERITES_FILE = "test-connection-meta-data.properties";

	static final String EIS_PRODUCT_VERSION_PROP = "eis-product-version";
	static final String EIS_USER_NAME_PROP = "eis-user-name";

	private static final String EIS_PRODUCT_NAME;
	private static final String EIS_PRODUCT_VERSION;
	private static final int EIS_MAX_CONNECTIONS;
	private static final String EIS_USER_NAME;

	static {
		Properties testProperties = new Properties();
		
		try {
			testProperties.load(ConnectionMetaDataImpl.class.getClassLoader().getResourceAsStream(CONNECTION_META_DATA_PROPERITES_FILE));
			EIS_PRODUCT_NAME = testProperties.getProperty(EIS_PRODUCT_NAME_PROP);
			EIS_MAX_CONNECTIONS = Integer.parseInt(testProperties.getProperty(EIS_MAX_CONNECTIONS_PROP));
		} catch (IOException e1) {
			throw new RuntimeException("Could not load connection meta data properties file '" + CONNECTION_META_DATA_PROPERITES_FILE + "'");
		} catch (NumberFormatException e) {
			throw new RuntimeException("'" + EIS_MAX_CONNECTIONS_PROP + "' property has an invalid integer value in onnection meta data properties file '" + CONNECTION_META_DATA_PROPERITES_FILE + "'");
		}

		try {
			testProperties.load(TestConnectionMetaDataImpl.class.getClassLoader().getResourceAsStream(TEST_CONNECTION_META_DATA_PROPERITES_FILE));
			EIS_PRODUCT_VERSION = testProperties.getProperty(EIS_PRODUCT_VERSION_PROP);
			EIS_USER_NAME = testProperties.getProperty(EIS_USER_NAME_PROP);
		} catch (IOException e) {
			throw new RuntimeException("Could not load test connection meta data properties file '" + TEST_CONNECTION_META_DATA_PROPERITES_FILE + "'");
		}
		
	}
	
	private JCoDestination mockDestination;
	private ConnectionMetaDataImpl connectionMetaDataImpl;
	private JCoAttributes mockAttributes;
	
	@Before
	public void setUp() throws JCoException, ResourceException {
		// Given
		mockDestination = mock(JCoDestination.class);
		mockAttributes = mock(JCoAttributes.class);
		when(mockAttributes.getPartnerRelease()).thenReturn(EIS_PRODUCT_VERSION);
		when(mockAttributes.getUser()).thenReturn(EIS_USER_NAME);
		when(mockDestination.getAttributes()).thenReturn(mockAttributes);

		connectionMetaDataImpl = new ConnectionMetaDataImpl(mockDestination);
	}

	@Test
	public void testGetEISProductName() throws ResourceException {
		// When
		String eisProductName = connectionMetaDataImpl.getEISProductName();
			
		// Then
		assertThat("ConnectionMetaDataImpl.getEISProductName() returned wrong EIS Product Name: ", eisProductName, is(EIS_PRODUCT_NAME));
	}

	@Test
	public void testGetEISProductVersion() throws JCoException, ResourceException {
		// When
		String eisProductVersion = connectionMetaDataImpl.getEISProductVersion();
		
		// Then
		assertThat("ConnectionMetaDataImpl.getEISProductVersion() returned wrong EIS Product Version:", eisProductVersion, is(EIS_PRODUCT_VERSION));
		verify(mockAttributes).getPartnerRelease();
	}

	@Test( expected = ResourceException.class )
	public void testGetEISProductVersionWithJCoException() throws JCoException, ResourceException {
		// Given
		when(mockDestination.getAttributes()).thenThrow(new JCoException(JCoException.JCO_ERROR_PROGRAM, "Test Exception"));
		
		// When
		connectionMetaDataImpl.getEISProductVersion();
		
		// Then
		fail("ConnectionMetaDataImpl.getEISProductVersion() failed to throw ResourceException when underlying JCoException is thrown");
	}

	@Test
	public void testGetMaxConnections() throws ResourceException {
		// When
		int maxConnections = connectionMetaDataImpl.getMaxConnections();
		
		// Then
		assertThat("ConnectionMetaDataImpl.getMaxConnections() returned wrong value:", maxConnections, is(EIS_MAX_CONNECTIONS));
	}

	@Test
	public void testGetUserName() throws ResourceException {
		// When
		String userName = connectionMetaDataImpl.getUserName();
		
		// Then
		assertThat("ConnectionMetaDataImpl.getUserName() returned wrong value:", userName, is(EIS_USER_NAME));
		verify(mockAttributes).getUser();
	}

	@Test( expected = ResourceException.class )
	public void testGetUserNameWithJCoException() throws ResourceException, JCoException {
		// Given
		when(mockDestination.getAttributes()).thenThrow(new JCoException(JCoException.JCO_ERROR_PROGRAM, "Test Exception"));
		
		// When
		connectionMetaDataImpl.getUserName();
		
		// Then
		fail("ConnectionMetaDataImpl.getUserName() failed to throw ResourceException when underlying JCoException is thrown");
	}

}
