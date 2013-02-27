package org.jboss.jca.adapters.sap.integration;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import javax.resource.cci.ConnectionFactory;
import javax.resource.spi.ManagedConnectionFactory;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.jboss.jca.adapters.sap.cci.CciPackage;
import org.jboss.jca.adapters.sap.cci.MappedRecord;
import org.jboss.jca.adapters.sap.cci.RecordFactory;
import org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl;
import org.jboss.jca.adapters.sap.spi.NonManagedEnvironmentAdmin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ITestDynamicPackage {
		
	private static final String PACKAGE_URL = CciPackage.JBOSS_SAP_URI_PREFIX  + "NPL/BAPI_FLCUST_GETLIST";
	
	private static final String PACKAGE_MODEL_FILE_URL = "file:///tmp/BAPI_FLCUST_GETLIST.ecore";
	
	private static final String INPUT_RECORD_NAME = "INPUT_RECORD";
	
	private static final String INPUT_RECORD_SHORT_DESCRIPTION = "Test Record Description";

	private static final String INPUT_RECORD_FILE_URL = "file:///tmp/BAPI_FLCUST_GETLIST.INPUT_RECORD.ecore";

	private NonManagedEnvironmentAdmin admin;

	@Before
	public void setUp() throws Exception {
		// Given
		admin = NonManagedEnvironmentAdmin.INSTANCE;
		admin.deployResourceAdapter(null);
	}

	@After
	public void tearDown() throws Exception {
		admin.undeployResourceAdapter();
	}

	@Test
	public void testCreateStoreAndLoadOfDynamicResources() throws Exception {

		//
		// Given
		//
		
		// Create connection and get record factory.
		Map<String, String> config = new HashMap<String, String>();
		config.put("ashost", "nplhost");
		config.put("sysnr", "42");
		config.put("client", "001");
		config.put("user", "developer");
		config.put("passwd", "ch4ngeme");
		config.put("lang", "en");
		ManagedConnectionFactory managedConnectionFactory = admin.createManagedConnectionFactory(config);
		ConnectionFactory connectionFactory = (ConnectionFactory) managedConnectionFactory.createConnectionFactory();
		RecordFactory recordFactory = (RecordFactory) connectionFactory.getRecordFactory();


		//
		// When
		//
		
		// Get the package model for flight customer get list call
		String nsURI = PACKAGE_URL;
		EPackage dPackage = recordFactory.getPackageRegistry().getEPackage(nsURI);

		// Save the package model
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		URI packageModelResourceURI = URI.createURI(PACKAGE_MODEL_FILE_URL);
		Resource resource = resourceSet.createResource(packageModelResourceURI);
		resource.getContents().add(CciPackageImpl.eINSTANCE);
		resource.getContents().add(dPackage);
		resource.save(null);
		
		// Create and save input record
		MappedRecord mappedRecord = recordFactory.createMappedRecord("BAPI_FLCUST_GETLIST.INPUT_RECORD");
		mappedRecord.setRecordShortDescription(INPUT_RECORD_SHORT_DESCRIPTION);
		URI inputRecordResourceURI = URI.createURI(INPUT_RECORD_FILE_URL);
		resource = resourceSet.createResource(inputRecordResourceURI);
		resource.getContents().add(mappedRecord);
		resource.save(null);

		// Load saved input record
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		resourceSet.setPackageRegistry(recordFactory.getPackageRegistry());
		resource = resourceSet.getResource(inputRecordResourceURI, true);
		resource.load(null);
		MappedRecord inputRecord = (MappedRecord) resource.getContents().get(0);
		
		//
		// THEN
		//
		
		assertEquals("Deserialized record name does not match original", INPUT_RECORD_NAME, inputRecord.getRecordName());
		assertEquals("Deserialized record short description does not match original", INPUT_RECORD_SHORT_DESCRIPTION, inputRecord.getRecordShortDescription());
	}
	
}
