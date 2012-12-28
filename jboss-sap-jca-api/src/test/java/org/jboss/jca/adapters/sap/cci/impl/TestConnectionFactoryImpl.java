package org.jboss.jca.adapters.sap.cci.impl;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.resource.ResourceException;
import javax.resource.cci.RecordFactory;
import javax.resource.cci.ResourceAdapterMetaData;
import javax.resource.spi.ConnectionManager;

import org.jboss.jca.adapters.sap.cci.Connection;
import org.jboss.jca.adapters.sap.cci.ConnectionSpec;
import org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory;
import org.junit.Before;
import org.junit.Test;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoRepository;

public class TestConnectionFactoryImpl {
	
	private ManagedConnectionFactory mockManagedConnectionFactory;
	private ConnectionManager mockConnectionManager;
	private ConnectionFactoryImpl defaultConnectionFactory;
	private ConnectionFactoryImpl connectionFactory;
	
	@Before
	public void setUp() throws Exception {
		// Given
		mockManagedConnectionFactory = mock(ManagedConnectionFactory.class);
		mockConnectionManager = mock(ConnectionManager.class);
		
		defaultConnectionFactory = new ConnectionFactoryImpl();
		connectionFactory = new ConnectionFactoryImpl(mockManagedConnectionFactory, mockConnectionManager);
	}

	@Test
	public void testGetConnection() throws ResourceException {
		// Given
		Connection mockConnection = mock(ConnectionImpl.class);
		when(mockConnectionManager.allocateConnection(mockManagedConnectionFactory, null)).thenReturn(mockConnection);
		
		// When
		Connection returnedConnection = connectionFactory.getConnection();
		
		// Then
		assertThat("ConnectionFactoryImpl.getConnection() returned null value:", returnedConnection, notNullValue());
		assertThat("ConnectionFactoryImpl.getConnection() returned different ConnectionImpl instance than returned by ConnectionManager.allocateConnection(): ", returnedConnection, sameInstance(mockConnection));
		verify(mockConnectionManager).allocateConnection(mockManagedConnectionFactory, null);
	}

	@Test
	public void testGetConnectionWithConnectionSpec() throws ResourceException {
		// Given
		Connection mockConnection = mock(ConnectionImpl.class);
		ConnectionSpec mockConnectionSpec = mock(ConnectionSpec.class);
		when(mockConnectionManager.allocateConnection(eq(mockManagedConnectionFactory), any(ConnectionRequestInfo.class))).thenReturn(mockConnection);
		
		// When
		Connection returnedConnection = connectionFactory.getConnection(mockConnectionSpec);
		
		// Then
		assertThat("ConnectionFactoryImpl.getConnection(ConnectionSpec) returned null value", returnedConnection, notNullValue());
		assertThat("ConnectionFactoryImpl.getConnection(ConnectionSpec) returned different ConnectionImpl instance than returned by ConnectionManager.allocateConnection()", returnedConnection, sameInstance(mockConnection));
	}

	@Test ( expected = ResourceException.class)
	public void testGetConnectionWithInvalidConnectionSpec() throws ResourceException {
		// Given
		Connection mockConnection = mock(ConnectionImpl.class);
		javax.resource.cci.ConnectionSpec mockConnectionSpec = mock(javax.resource.cci.ConnectionSpec.class);
		when(mockConnectionManager.allocateConnection(eq(mockManagedConnectionFactory), any(ConnectionRequestInfo.class))).thenReturn(mockConnection);
		
		// When
		connectionFactory.getConnection(mockConnectionSpec);
		
		// Then
		fail("ConnectionFactoryImpl.getConnection(ConnectionSpec) fails to throw ResourceException when passed invalid type of ConnectionSpec");
	}

	@Test
	public void testGetMetaData() throws ResourceException {
		// When
		ResourceAdapterMetaData returnedResourceAdapterMetaData = defaultConnectionFactory.getMetaData(); 
		
		// Then
		assertNotNull("ConnectionFactoryImpl.getMetaData() returned null ResourceAdapterMetaData", returnedResourceAdapterMetaData);
	}

	@Test
	public void testGetRecordFactory() throws ResourceException, JCoException {
		// Given
		ConnectionImpl mockConnection = mock(ConnectionImpl.class);
		JCoDestination mockDestination = mock(JCoDestination.class);
		JCoRepository mockRepository = mock(JCoRepository.class);
		when(mockConnectionManager.allocateConnection(mockManagedConnectionFactory, null)).thenReturn(mockConnection);
		when(mockConnection.getDestination()).thenReturn(mockDestination);
		when(mockDestination.getRepository()).thenReturn(mockRepository);
		
		// When
		RecordFactory returnedRecordFactory = connectionFactory.getRecordFactory(); 
		
		// Then
		assertThat("ConnectionFactoryImpl.getRecordFactory() returned null RecordFactory", returnedRecordFactory, notNullValue());
	}

	@Test
	public void testGetReference() throws NamingException {
		// Given
		Reference mockReference = mock(Reference.class);
		defaultConnectionFactory.setReference(mockReference);
		
		// When
		Reference returnedReference = defaultConnectionFactory.getReference();
		
		// Then
		assertThat("ConnectionFactoryImpl.getReference() returned different Reference instance than was set", returnedReference, sameInstance(mockReference));
	}

	@Test(expected = NamingException.class)
	public void testGetReferenceThrowsNamingException() throws NamingException {
		// When
		defaultConnectionFactory.getReference();
		
		// Then
		fail("ConnectionFactoryImpl.getReference() fails to throw NamingException when attempting to return null reference");
	}

}
