package org.jboss.jca.adatapter.sap.spi.tests;

import javax.resource.spi.ResourceAdapterInternalException;

import org.jboss.jca.adapters.sap.spi.ResourceAdapter;
import org.jboss.jca.adapters.sap.spi.impl.ResourceAdapterImpl;
import org.junit.Before;
import org.junit.Test;

public class ResourceAdapterTest {
	
	private ResourceAdapter resourceAdapter;

	@Before
	public void setup() {
		resourceAdapter = new ResourceAdapterImpl();
	}
	
	@Test
	public void testStartAndStop() throws ResourceAdapterInternalException {
		
		resourceAdapter.start(null);
		resourceAdapter.stop();
	}

}
