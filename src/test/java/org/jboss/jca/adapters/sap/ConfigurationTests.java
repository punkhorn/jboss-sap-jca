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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Properties;
import java.util.UUID;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.resource.cci.ConnectionFactory;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.ResourceAdapterArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.sap.conn.jco.ext.DestinationDataProvider;

/**
 * ConfigurationTests - Tests configuration of JBoss SAP JCA Connector
 * 
 * @author William Collins
 *
 */
@SuppressWarnings("restriction")
@RunWith(Arquillian.class)
public class ConfigurationTests {

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
		JavaArchive ja = ShrinkWrap.create(JavaArchive.class, UUID.randomUUID().toString() + ".jar");
		ja.addClasses(JBossSAPResourceAdapter.class, JBossSAPManagedConnectionFactory.class,
				JBossSAPManagedConnection.class, JBossSAPCciConnectionFactory.class,
				JBossSAPCciConnectionFactory.class, JBossSAPConnectionMetaData.class, JBossSAPResourceAdapterMetaData.class,
				JBossSAPConnectionSpec.class);
		raa.addAsLibrary(ja);

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
		JBossSAPCciConnection connection = (JBossSAPCciConnection) connectionFactory.getConnection();
		assertNotNull("Failed to create connection", connection);

		//
		// Test JCoDestination properties
		//

		Properties properties = connection.getProperties();
		assertNotNull("Connection has not properties", properties);
		assertEquals("Authentication Type value does not match", "CONFIGURED_USER",
				properties.getProperty(DestinationDataProvider.JCO_AUTH_TYPE));
		assertEquals("User ID value does not match", "JCO_TESTER_USER_ID",
				properties.getProperty(DestinationDataProvider.JCO_USER_ID));
		assertEquals("Client value does not match", "999", properties.getProperty(DestinationDataProvider.JCO_CLIENT));
		assertEquals("User value does not match", "JCO_TESTER_USER",
				properties.getProperty(DestinationDataProvider.JCO_USER));
		assertEquals("Alias User value does not match", "JCO_TESTER_ALIAS_USER",
				properties.getProperty(DestinationDataProvider.JCO_ALIAS_USER));
		assertEquals("Password value does not match", "JCO_TESTER_PASSWD",
				properties.getProperty(DestinationDataProvider.JCO_PASSWD));
		assertEquals("Language value does not match", "fr", properties.getProperty(DestinationDataProvider.JCO_LANG));
		assertEquals("My SAP SSO 2 value does not match", "JCO_TESTER_SAP_COOKIE",
				properties.getProperty(DestinationDataProvider.JCO_MYSAPSSO2));
		assertEquals("X509 Certificate value does not match", "JCO_TESTER_X509_CERT",
				properties.getProperty(DestinationDataProvider.JCO_X509CERT));
		assertEquals("SAP Router String value does not match", "JCO_TESTER_SAP_ROUTER",
				properties.getProperty(DestinationDataProvider.JCO_SAPROUTER));
		assertEquals("System Number value does not match", "99",
				properties.getProperty(DestinationDataProvider.JCO_SYSNR));
		assertEquals("Application Server Host value does not match", "jcotesterashost.example.com",
				properties.getProperty(DestinationDataProvider.JCO_ASHOST));
		assertEquals("Message Server Host value does not match", "jcotestermshost.example.com",
				properties.getProperty(DestinationDataProvider.JCO_MSHOST));
		assertEquals("Message Server Service value does not match", "1234",
				properties.getProperty(DestinationDataProvider.JCO_MSSERV));
		assertEquals("Gateway Host value does not match", "jcotestergwhost.example.com",
				properties.getProperty(DestinationDataProvider.JCO_GWHOST));
		assertEquals("Gateway Service value does not match", "4321",
				properties.getProperty(DestinationDataProvider.JCO_GWSERV));
		assertEquals("R3 Name value does not match", "T11", properties.getProperty(DestinationDataProvider.JCO_R3NAME));
		assertEquals("Group value does not match", "LOGONGROUP",
				properties.getProperty(DestinationDataProvider.JCO_GROUP));
		assertEquals("Trace value does not match", "1", properties.getProperty(DestinationDataProvider.JCO_TRACE));
		assertEquals("CPIC Trace value does not match", "9",
				properties.getProperty(DestinationDataProvider.JCO_CPIC_TRACE));
		assertEquals("Logon Check value does not match", "1",
				properties.getProperty(DestinationDataProvider.JCO_LCHECK));
		assertEquals("Use SAP GUI value does not match", "2",
				properties.getProperty(DestinationDataProvider.JCO_USE_SAPGUI));
		assertEquals("Code Page value does not match", "ISO-8859-2",
				properties.getProperty(DestinationDataProvider.JCO_CODEPAGE));
		assertEquals("Get SSO 2 value does not match", "1", properties.getProperty(DestinationDataProvider.JCO_GETSSO2));
		assertEquals("Deny Initial Password value does not match", "1",
				properties.getProperty(DestinationDataProvider.JCO_DENY_INITIAL_PASSWORD));
		assertEquals("Peak Limit value does not match", "99",
				properties.getProperty(DestinationDataProvider.JCO_PEAK_LIMIT));
		assertEquals("Pool Capacity value does not match", "199",
				properties.getProperty(DestinationDataProvider.JCO_POOL_CAPACITY));
		assertEquals("Expiration Time value does not match", "20000",
				properties.getProperty(DestinationDataProvider.JCO_EXPIRATION_TIME));
		assertEquals("Expiration Check Period value does not match", "40000",
				properties.getProperty(DestinationDataProvider.JCO_EXPIRATION_PERIOD));
		assertEquals("Max Get Client Time value does not match", "1000",
				properties.getProperty(DestinationDataProvider.JCO_MAX_GET_TIME));
		assertEquals("SNC Mode value does not match", "1", properties.getProperty(DestinationDataProvider.JCO_SNC_MODE));
		assertEquals("SNC Partner Name value does not match", "CN=R3, O=XYZ-INC, C=EN",
				properties.getProperty(DestinationDataProvider.JCO_SNC_PARTNERNAME));
		assertEquals("SNC QOP value does not match", "9", properties.getProperty(DestinationDataProvider.JCO_SNC_QOP));
		assertEquals("SNC My Name value does not match", "CN=R3, O=UVW-INC, C=EN",
				properties.getProperty(DestinationDataProvider.JCO_SNC_MYNAME));
		assertEquals("SNC Library value does not match", "C:\\SECUDE\\LIB\\SECUDE.DLL",
				properties.getProperty(DestinationDataProvider.JCO_SNC_LIBRARY));
		assertEquals("Repository Destination value does not match", "TEST",
				properties.getProperty(DestinationDataProvider.JCO_REPOSITORY_DEST));
		assertEquals("Repository User value does not match", "JCO_REPOSITORY_TESTER",
				properties.getProperty(DestinationDataProvider.JCO_REPOSITORY_USER));
		assertEquals("Repository Password value does not match", "JCO_REPOSITORY_PASSWD",
				properties.getProperty(DestinationDataProvider.JCO_REPOSITORY_PASSWD));
		assertEquals("Repository SNC value does not match", "0",
				properties.getProperty(DestinationDataProvider.JCO_REPOSITORY_SNC));
		assertEquals("Repository Roundtrip Optimization value does not match", "1",
				properties.getProperty(DestinationDataProvider.JCO_REPOSITORY_ROUNDTRIP_OPTIMIZATION));

		//
		// Test JCoDestination convenience methods
		//

		assertEquals("Client value does not match", "999", connection.getClient());
		assertEquals("User value does not match", "JCO_TESTER_USER", connection.getUser());
		assertEquals("Alias User value does not match", "JCO_TESTER_ALIAS_USER", connection.getAliasUser());
		assertEquals("Language value does not match", "fr", connection.getLanguage());
		assertEquals("SAP Router String value does not match", "JCO_TESTER_SAP_ROUTER", connection.getSAPRouterString());
		assertEquals("System Number value does not match", "99", connection.getSystemNumber());
		assertEquals("Application Server Host value does not match", "jcotesterashost.example.com",
				connection.getApplicationServerHost());
		assertEquals("Message Server Host value does not match", "jcotestermshost.example.com",
				connection.getMessageServerHost());
		assertEquals("Message Server Service value does not match", "1234", connection.getMessageServerService());
		assertEquals("Gateway Host value does not match", "jcotestergwhost.example.com", connection.getGatewayHost());
		assertEquals("Gateway Service value does not match", "4321", connection.getGatewayService());
		assertEquals("R3 Name value does not match", "T11", connection.getR3Name());
		assertEquals("Logon Check value does not match", "1", connection.getLogonCheck());
		// assertEquals("Peak Limit value does not match", "99", connection.getPeakLimit());
		// assertEquals("Pool Capacity value does not match", "199", connection.getPoolCapacity());
		// assertEquals("Expiration Time value does not match", "20000", connection.getExpirationTime());
		// assertEquals("Expiration Check Period value does not match", "40000", connection.getExpirationCheckPeriod());
		// assertEquals("Max Get Client Time value does not match", "1000", connection.getMaxGetClientTime());
		assertEquals("SNC Mode value does not match", "1", connection.getSncMode());
		assertEquals("SNC Partner Name value does not match", "CN=R3, O=XYZ-INC, C=EN", connection.getSncPartnerName());
		assertEquals("SNC QOP value does not match", "9", connection.getSncQOP());
		assertEquals("SNC My Name value does not match", "CN=R3, O=UVW-INC, C=EN", connection.getSncMyName());
		assertEquals("SNC Library value does not match", "C:\\SECUDE\\LIB\\SECUDE.DLL", connection.getSncLibrary());
		assertEquals("Repository User value does not match", "JCO_REPOSITORY_TESTER", connection.getRepositoryUser());

	}

}
