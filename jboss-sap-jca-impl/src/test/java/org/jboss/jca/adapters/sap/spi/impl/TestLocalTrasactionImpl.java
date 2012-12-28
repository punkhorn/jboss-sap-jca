package org.jboss.jca.adapters.sap.spi.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import javax.resource.ResourceException;

import org.jboss.jca.adapters.sap.spi.impl.LocalTransactionImpl;
import org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionImpl;
import org.junit.Before;
import org.junit.Test;

public class TestLocalTrasactionImpl {

	private ManagedConnectionImpl managedConnection;
	private LocalTransactionImpl localTransaction;

	@Before
	public void setUp() throws Exception {
		// Given
		managedConnection = mock(ManagedConnectionImpl.class);
		localTransaction = new LocalTransactionImpl(managedConnection);
	}

	@Test
	public void testBegin() throws ResourceException {
		// When
		localTransaction.begin();
		
		// Then
		verify(managedConnection).beginLocalTransaction();
	}

	@Test
	public void testCommit() throws ResourceException {
		// When
		localTransaction.commit();
		
		// Then
		verify(managedConnection).commitLocalTransaction();
	}

	@Test
	public void testRollback() throws ResourceException {
		// When
		localTransaction.rollback();
		
		// Then
		verify(managedConnection).rollbackLocalTransaction();
	}

}
