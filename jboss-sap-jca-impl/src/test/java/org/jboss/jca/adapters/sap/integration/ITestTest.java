package org.jboss.jca.adapters.sap.integration;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ITestTest {

	   private static Logger log = Logger.getLogger(ITestTest.class);

	@Test
	public void test() {
		log.debugf("Deploying: %s", "Hello, World!");
	}

}
