package org.jboss.jca.adapters.sap.impl;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import java.util.Properties;

import javax.resource.NotSupportedException;
import javax.resource.ResourceException;
import javax.resource.cci.ConnectionMetaData;
import javax.resource.cci.Interaction;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.LazyAssociatableConnectionManager;
import javax.resource.spi.LocalTransaction;
import javax.resource.spi.ManagedConnectionMetaData;

import org.jboss.jca.adapters.sap.cci.JBossSAPConnectionSpec;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestConnectionImpl {
	
	private ConnectionImpl connection;
	private ManagedConnectionImpl mockManagedConnection;
	private ManagedConnectionFactoryImpl mockManagedConnectionFactory;
	private JBossSAPConnectionSpec connectionSpec;
	private ConnectionManager mockConnectionManager;

	@Before
	public void setUp() throws Exception {
		// Given
		mockManagedConnectionFactory = mock(ManagedConnectionFactoryImpl.class);
		connectionSpec = new JBossSAPConnectionSpec();
		mockManagedConnection = mock(ManagedConnectionImpl.class);
		when(mockManagedConnection.getProperties()).thenReturn(connectionSpec);
		when(mockManagedConnection.getManagedConnectionFactory()).thenReturn(mockManagedConnectionFactory);
		mockConnectionManager = mock(ConnectionManager.class, withSettings().extraInterfaces(LazyAssociatableConnectionManager.class));
		
		connection = new ConnectionImpl(mockManagedConnection); /* Active connection */
		connection.setConnectionManager(mockConnectionManager);
	}

	@Test
	public void testClose() throws ResourceException {
		// When
		connection.close();
		
		// Then
		verify(mockManagedConnection).closeHandle(connection); /* Ensure handle is closed with managed connection only once. */
		verify(((LazyAssociatableConnectionManager)mockConnectionManager), never()).inactiveConnectionClosed(	connection, mockManagedConnectionFactory); /* Ensure this method is never called with an active or closed connection */
	}

	@Test
	public void testCloseOnClosedConnection() throws ResourceException {
		// Given
		connection.close(); /* Close connection */
		
		// When
		connection.close();
		
		// Then
		verify(mockManagedConnection).closeHandle(connection); /* Ensure handle is closed with managed connection only once. */
		verify(((LazyAssociatableConnectionManager)mockConnectionManager), never()).inactiveConnectionClosed(	connection, mockManagedConnectionFactory); /* Ensure this method is never called with an active or closed connection */
	}

	@Test
	public void testCloseOnInactiveConnection() throws ResourceException {
		// Given
		connection.dissociateManagedConnection(); /* In-activate connection */
		
		// When
		connection.close();
		
		// Then
		verify(((LazyAssociatableConnectionManager)mockConnectionManager)).inactiveConnectionClosed(connection, mockManagedConnectionFactory); /* Ensure this method is called with an inactive connection */
	}

	@Test
	public void testCreateInteraction() throws ResourceException {
		// When
		Interaction interaction = connection.createInteraction();
		
		// Then
		assertThat("ConnectionImpl.createInteraction() returned null Interaction", interaction, notNullValue());
	}

	@Test( expected = ResourceException.class )
	public void testCreateInteractionOnClosedConnection() throws ResourceException {
		// Given
		connection.close();
		
		// When
		connection.createInteraction();
		
		// Then
		fail("ConnectionImpl.createInteraction() on closed connection failed to throw ResourceException");
	}

	@Test
	public void testGetLocalTransaction() throws ResourceException {
		// Given
		LocalTransaction mockLocalTransaction = mock(LocalTransaction.class, withSettings().extraInterfaces(javax.resource.cci.LocalTransaction.class));
		when(mockManagedConnection.getLocalTransaction()).thenReturn(mockLocalTransaction);
		
		// When
		javax.resource.cci.LocalTransaction localTransaction = connection.getLocalTransaction();
		
		// Then
		assertThat("ConnectionImpl.getLocalTransaction() returned null LocalTransaction", localTransaction, notNullValue());
		assertThat("ConnectionImpl.getLocalTransaction() returned different LocalTransaction instance from that returned by ManagedConnection.getLocalTransaction()", (LocalTransaction) localTransaction, sameInstance(mockLocalTransaction));
	}

	@Test( expected = ResourceException.class )
	public void testGetLocalTransactionOnClosedConnection() throws ResourceException {
		// Given
		connection.close();
		
		// When
		connection.getLocalTransaction();
		
		// Then
		fail("ConnectionImpl.getLocalTransaction() on closed connection failed to throw ResourceException");
	}

	@Test
	public void testGetMetaData() throws ResourceException {
		// Given
		ManagedConnectionMetaData mockConnectionMetaData = mock(ManagedConnectionMetaData.class, withSettings().extraInterfaces(ConnectionMetaData.class));
		when(mockManagedConnection.getMetaData()).thenReturn(mockConnectionMetaData);
		
		// When
		ConnectionMetaData connectionMetaData = connection.getMetaData();
		
		// Then
		assertThat("ConnectionImpl.getMetaData() returned null ConnectionMetaData", connectionMetaData, notNullValue()) ;
		assertThat("ConnectionImpl.getMetaData() returned different ConnectionMetaData instance from that returned by ManagedConnection.getMetaData()", (ManagedConnectionMetaData) connectionMetaData, is(mockConnectionMetaData));
	}

	@Test( expected = ResourceException.class )
	public void testGetMetaDataOnClosedConnection() throws ResourceException {
		// Given
		connection.close();
		
		// When
		connection.getMetaData();
		
		// Then
		fail("ConnectionImpl.getMetaData() on closed connection failed to throw ResourceException");
	}

	@Test ( expected = NotSupportedException.class )
	public void testGetResultSetInfo() throws ResourceException {
		// When
		connection.getResultSetInfo();
		
		// Then
		fail("ConnectionImpl.getResultSetInfo() failed to throw NotSupportedException");
	}

	@Test ( expected = ResourceException.class )
	public void testGetResultSetInfoOnClosedConnection() throws ResourceException {
		// Given
		connection.close();
		
		// When
		connection.getResultSetInfo();
		
		// Then
		fail("ConnectionImpl.getResultSetInfo() on closed connection failed to throw ResourceException");
	}

	@Test
	public void testBegin() throws ResourceException {
		// When
		connection.begin();
		
		// Then
		verify(mockManagedConnection).beginStatefulSession();
	}

	@Test ( expected = ResourceException.class )
	public void testBeginOnClosedConnection() throws ResourceException {
		// Given
		connection.close();
		
		// When
		connection.begin();
		
		// Then
		fail("ConnectionImpl.begin on closed connection failed to throw ResourceException");
	}

	@Test
	public void testEnd() throws ResourceException {
		// When
		connection.end();
		
		// Then
		verify(mockManagedConnection).endStatefulSession();
	}

	@Test ( expected = ResourceException.class )
	public void testEndOnClosedConnection() throws ResourceException {
		// Given
		connection.close();
		
		// When
		connection.end();
		
		// Then
		fail("ConnectionImpl.end() on closed connection failed to throw ResourceException");
	}

	@Test
	public void testIsClosed() throws ResourceException {
		// When
		boolean isClosed = connection.isClosed();
		
		// Then
		assertFalse("ConnectionImpl.isClosed() on active connection returned true", isClosed);
	}

	@Test
	public void testIsClosedOnClosedConnection() throws ResourceException {
		// Given
		connection.close();
		
		// When
		boolean isClosed = connection.isClosed();
		
		// Then
		assertThat("ConnectionImpl.isClosed() on closed connection returned false", isClosed, is(true));
	}

	@Test
	public void testIsStatefulOnNonStatefulConnection() {
		// Given
		when(mockManagedConnection.isStateful()).thenReturn(false);
		
		// When
		boolean isStateful = connection.isStateful();
		
		// Then
		assertThat("ConnectionImpl.isStateful() on non-stateful connection returned true", isStateful, is(false));
	}

	@Test
	public void testIsStatefulOnStatefulConnection() throws ResourceException {
		// Given
		connection.begin();
		when(mockManagedConnection.isStateful()).thenReturn(true);
		
		// When
		boolean isStateful = connection.isStateful();
		
		// Then
		assertThat("ConnectionImpl.isStateful() on stateful connection returned false", isStateful, is(true));
	}

	@Test
	public void testPing() throws ResourceException {
		// Given
		
		// When
		connection.ping();
		
		// Then
		verify(mockManagedConnection).ping();
	}

	@Test( expected = ResourceException.class )
	public void testPingOnClosedConnection() throws ResourceException {
		// Given
		connection.close();
		
		// When
		connection.ping();
		
		// Then
		fail("ConnectionImpl.ping on closed connection failed to throw ResourceException");
	}

	@Test
	public void testGetProperties() {
		// When
		Properties properties = connection.getProperties();
		
		// Then
		assertThat("ConnectionImpl.getProperties() returned connection spec different from one used to initialize connection", connectionSpec, is(properties));
	}

}
