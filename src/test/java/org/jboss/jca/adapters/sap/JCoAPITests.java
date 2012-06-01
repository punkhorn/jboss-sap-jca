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
package org.jboss.jca.adapters.sap;

import static org.jboss.jca.adapters.sap.ClassesToTest.CLASSES_TO_TEST;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.ResourceAdapterArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.sap.conn.jco.JCoFunction;

/**
 * JCoAPITests - Tests JCo API calls through JBoss SAP JCA Connection
 * 
 * @author William Collins
 *
 */
@SuppressWarnings({"restriction"})
@RunWith(Arquillian.class)
public class JCoAPITests {
	
	private static Logger log = Logger.getLogger("JCoAPITests");

	private static String deploymentName = "JCoAPITests";

	//
	// Parameters for JCo Execute Test
	//

	private static final String REQUTEXT = "Hello SAP!";
	private static final String REQUTEXT_PARAM = "REQUTEXT";
	private static final String ECHOTEXT_PARAM = "ECHOTEXT";


	/**
	 * Define the deployment
	 * 
	 * @return The deployment archive
	 */
	@Deployment
	public static ResourceAdapterArchive createDeployment() {
		log.info("Creating deployment for CciTests");

		ResourceAdapterArchive raa = ShrinkWrap.create(ResourceAdapterArchive.class, deploymentName + ".rar");
		JavaArchive ja = ShrinkWrap.create(JavaArchive.class, UUID.randomUUID().toString() + ".jar");
		ja.addClasses(CLASSES_TO_TEST);
		raa.addAsLibrary(ja);

		raa.addAsManifestResource("META-INF/ra.xml", "ra.xml");

		raa.addAsManifestResource("META-INF/JCoAPITests-ironjacamar.xml", "ironjacamar.xml");

		return raa;
	}

	@Resource(mappedName = "java:/eis/JCoAPITestsFactory")
	private javax.resource.cci.ConnectionFactory connectionFactory;

	/**
	 * Tests JCo execute call through JBoss SAP Connector
	 * 
	 * @throws Throwable
	 */
	@Test
	public void testJCoExecute() throws Throwable {
		log.info("Testing JCo Call");
		assertNotNull("Failed to access connection factory 'CciTestsFactory'", connectionFactory);
		JBossSAPCciConnection connection = (JBossSAPCciConnection) connectionFactory.getConnection();
		assertNotNull("Failed to create connection", connection);
		
		JCoFunction function = connection.getRepository().getFunction("STFC_CONNECTION");
		
		function.getImportParameterList().setValue(REQUTEXT_PARAM, REQUTEXT);
		
		function.execute(connection.getDestination());
		
		String echoText = function.getExportParameterList().getString(ECHOTEXT_PARAM);
		
		assertEquals("Echoed text does not match request text", REQUTEXT, echoText);

	}

}
