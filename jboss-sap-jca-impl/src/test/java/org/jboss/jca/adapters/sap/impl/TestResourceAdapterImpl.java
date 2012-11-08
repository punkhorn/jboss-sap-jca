package org.jboss.jca.adapters.sap.impl;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import javax.resource.ResourceException;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.ResourceAdapterInternalException;
import javax.resource.spi.endpoint.MessageEndpointFactory;
import javax.transaction.xa.XAResource;

import org.junit.Before;
import org.junit.Test;

import com.sap.conn.jco.ext.DestinationDataProvider;
import com.sap.conn.jco.ext.Environment;

public class TestResourceAdapterImpl {

	private ResourceAdapterImpl resourceAdapter;

	@Before
	public void setUp() throws Exception {
		resourceAdapter = new ResourceAdapterImpl();
	}

	@Test
	public void testHashCode() {
		// When
		int value = resourceAdapter.hashCode();
		
		// Then
		assertThat("ResourceAdapterImpl.hashCode() returned unexpected value", value, is(17));
	}

	@Test
	public void testEndpointActivation() throws ResourceException {
		// Given
		MessageEndpointFactory messageEndpointFactory = mock(MessageEndpointFactory.class);
		ActivationSpec activationSpec = mock(ActivationSpec.class);
		
		// When
		resourceAdapter.endpointActivation(messageEndpointFactory, activationSpec);
		
		// Then
		/* Nothing Happens! */
	}

	@Test
	public void testEndpointDeactivation() {
		// Given
		MessageEndpointFactory messageEndpointFactory = mock(MessageEndpointFactory.class);
		ActivationSpec activationSpec = mock(ActivationSpec.class);
		
		// When
		resourceAdapter.endpointDeactivation(messageEndpointFactory, activationSpec);
		
		// Then
		/* Nothing Happens! */
	}

	@Test
	public void testStartStop() throws ResourceAdapterInternalException {
		// Given
		BootstrapContext bootstrapContext = mock(BootstrapContext.class);
		
		// When
		resourceAdapter.start(bootstrapContext);
		
		// Then
		assertThat("ResourceAdapter.start(BoostrapContext) failed to register DestinationDataProvider", Environment.isDestinationDataProviderRegistered(), is(true));

		// When
		resourceAdapter.stop();
		
		// Then
		assertThat("ResourceAdapter.stop() failed to unregister DestinationDataProvider", Environment.isDestinationDataProviderRegistered(), is(false));
	}

	@Test
	public void testGetXAResources() throws ResourceException {
		// When
		XAResource[] xaResources = resourceAdapter.getXAResources(null);
		
		// Then
		assertThat("ResourceAdapterImpl.getXAResources(null) returned unexpected value", xaResources, nullValue());
	}

	@Test
	public void testEqualsToNull() {
		// When
		boolean result = resourceAdapter.equals(null);
		
		// Then
		assertThat("ResourceAdapterImpl.equals(null) returned unexpected value", result, is(false));
	}

	@Test
	public void testEqualsToString() {
		// When
		boolean result = resourceAdapter.equals("");
		
		// Then
		assertThat("ResourceAdapterImpl.equals(string) returned unexpected value", result, is(false));
	}

	@Test
	public void testEqualsToSelf() {
		// When
		boolean result = resourceAdapter.equals(resourceAdapter);
		
		// Then
		assertThat("ResourceAdapterImpl.equals(self) returned unexpected value", result, is(true));
	}

	@Test
	public void testEqualsToAnother() {
		// Given
		ResourceAdapterImpl otherResourceAdapter = new ResourceAdapterImpl();
		
		// When
		boolean result = resourceAdapter.equals(otherResourceAdapter);
		
		// Then
		assertThat("ResourceAdapterImpl.equals(otherResourceAdapter) returned unexpected value", result, is(true));
	}

	@Test
	public void testGetDestinationDataProvider() {
		// When
		DestinationDataProvider destinationDataProvider = resourceAdapter.getDestinationDataProvider();
		
		// Then
		assertThat("ResourceAdapterImpl.getDestinationDataProvider() returned unexpected value", destinationDataProvider, notNullValue());
	}

}
