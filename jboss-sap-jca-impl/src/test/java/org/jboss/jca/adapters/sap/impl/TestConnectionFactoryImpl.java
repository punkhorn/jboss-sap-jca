package org.jboss.jca.adapters.sap.impl;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.resource.ResourceException;
import javax.resource.cci.ConnectionSpec;
import javax.resource.cci.RecordFactory;
import javax.resource.cci.ResourceAdapterMetaData;
import javax.resource.spi.ConnectionManager;

import org.jboss.jca.adapters.sap.cci.JBossSAPConnectionSpec;
import org.junit.Before;
import org.junit.Test;

public class TestConnectionFactoryImpl {
	
	private ManagedConnectionFactoryImpl mockManagedConnectionFactory;
	private ConnectionManager mockConnectionManager;
	private ConnectionFactoryImpl defaultConnectionFactory;
	private ConnectionFactoryImpl connectionFactory;
	
	@Before
	public void setUp() throws Exception {
		// Given
		mockManagedConnectionFactory = mock(ManagedConnectionFactoryImpl.class);
		mockConnectionManager = mock(ConnectionManager.class);
		
		defaultConnectionFactory = new ConnectionFactoryImpl();
		connectionFactory = new ConnectionFactoryImpl(mockManagedConnectionFactory, mockConnectionManager);
	}

	@Test
	public void testGetConnection() throws ResourceException {
		// Given
		ConnectionImpl mockConnection = mock(ConnectionImpl.class);
		when(mockConnectionManager.allocateConnection(mockManagedConnectionFactory, null)).thenReturn(mockConnection);
		
		// When
		ConnectionImpl returnedConnection = connectionFactory.getConnection();
		
		// Then
		assertThat("ConnectionFactoryImpl.getConnection() returned null value:", returnedConnection, notNullValue());
		assertThat("ConnectionFactoryImpl.getConnection() returned different ConnectionImpl instance than returned by ConnectionManager.allocateConnection(): ", returnedConnection, sameInstance(mockConnection));
		verify(mockConnectionManager).allocateConnection(mockManagedConnectionFactory, null);
	}

	@Test
	public void testGetConnectionWithConnectionSpec() throws ResourceException {
		// Given
		ConnectionImpl mockConnection = mock(ConnectionImpl.class);
		JBossSAPConnectionSpec mockConnectionSpec = mock(JBossSAPConnectionSpec.class);
		when(mockConnectionManager.allocateConnection(mockManagedConnectionFactory, mockConnectionSpec)).thenReturn(mockConnection);
		
		// When
		ConnectionImpl returnedConnection = connectionFactory.getConnection(mockConnectionSpec);
		
		// Then
		assertThat("ConnectionFactoryImpl.getConnection(ConnectionSpec) returned null value", returnedConnection, notNullValue());
		assertThat("ConnectionFactoryImpl.getConnection(ConnectionSpec) returned different ConnectionImpl instance than returned by ConnectionManager.allocateConnection()", returnedConnection, sameInstance(mockConnection));
		verify(mockConnectionManager).allocateConnection(mockManagedConnectionFactory, mockConnectionSpec);
	}

	@Test ( expected = ResourceException.class)
	public void testGetConnectionWithInvalidConnectionSpec() throws ResourceException {
		// Given
		ConnectionSpec mockConnectionSpec = mock(ConnectionSpec.class);
		
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
	public void testGetRecordFactory() throws ResourceException {
		// When
		RecordFactory returnedRecordFactory = defaultConnectionFactory.getRecordFactory(); 
		
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
