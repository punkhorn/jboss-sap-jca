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
package org.jboss.jca.adapters.sap.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.resource.cci.ConnectionFactory;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.jca.adapters.sap.cci.Connection;
import org.jboss.jca.adapters.sap.cci.ConnectionSpec;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.ResourceAdapterArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * ConfigurationTests - Tests configuration of JBoss SAP JCA Connector
 * 
 * @author William Collins
 *
 */
@RunWith(Arquillian.class)
public class ITestConfiguration {

	private static Logger log = Logger.getLogger("ConfigurationTests");

	private static String deploymentName = "ConfigurationTests";

	/**
	 * Define the deployment
	 * 
	 * @return The deployment archive
	 */
	@Deployment
	public static ResourceAdapterArchive createDeployment() {
		log.info("Creating deployment for Configuration Tests");
		
		ResourceAdapterArchive raa = ShrinkWrap.create(ResourceAdapterArchive.class, deploymentName + ".rar");

		raa.addAsManifestResource("META-INF/ra.xml", "ra.xml");

		raa.addAsManifestResource("META-INF/ConfigurationTests-ironjacamar.xml", "ironjacamar.xml");

		return raa;
	}

	/** Resource */
	@Resource(mappedName = "java:/eis/ConfigurationTestsFactory")
	private ConnectionFactory connectionFactory;

	/**
	 * Tests injection of connection configuration parameters by JCA container.
	 * 
	 * @throws Throwable
	 */
	@Test
	public void testConnectionFactoryConfiguration() throws Throwable {
		log.info("Testing Connection Factory Configuration");
		
		assertNotNull("Failed to access 'ConfigurationTestsFactory'", connectionFactory);
		Connection connection = (Connection) connectionFactory.getConnection();
		assertNotNull("Failed to create connection", connection);

		//
		// Test JCoDestination properties
		//

		ConnectionSpec connectionSpec = connection.getConnectionSpec();
		assertNotNull("Connection has not properties", connectionSpec);
		assertEquals("Client value does not match", "001", 
				connectionSpec.getClient());
		assertEquals("User value does not match", "developer",
				connectionSpec.getUser());
		assertEquals("Password value does not match", "ch4ngeme",
				connectionSpec.getPasswd());
		assertEquals("Language value does not match", "en", 
				connectionSpec.getLang());

	}

}
