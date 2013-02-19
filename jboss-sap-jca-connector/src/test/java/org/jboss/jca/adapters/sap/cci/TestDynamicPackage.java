package org.jboss.jca.adapters.sap.cci;

import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.jboss.jca.adapters.sap.cci.impl.CciFactoryImpl;
import org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl;
import org.jboss.jca.adapters.sap.cci.impl.CciPackageRegistryImpl;
import org.jboss.jca.adapters.sap.cci.impl.RecordFactoryImpl;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoRepository;

public class TestDynamicPackage {

	//@Test
	public void test() throws Exception {
		Properties destinationProperties = JBossDestinationDataProvider.createDestinationProperties("nplhost", "42",
				"001", "developer", "ch4ngeme", "en");

		JBossDestinationDataProvider provider = new JBossDestinationDataProvider();

		com.sap.conn.jco.ext.Environment.registerDestinationDataProvider(provider);
		provider.addDestinationProperties("ABAP_AS", destinationProperties);

		JCoDestination destination = JCoDestinationManager.getDestination("ABAP_AS");
		destination.ping();

		JCoRepository aRepository = destination.getRepository();
		
		RecordFactory recordFactory = CciFactoryImpl.eINSTANCE.createRecordFactory();
		((RecordFactoryImpl)recordFactory).setRepository(aRepository);
		String nsURI = CciPackage.JBOSS_SAP_URI_PREFIX  + aRepository.getName() + "/" + "BAPI_FLCUST_GETLIST";
		EPackage dPackage = recordFactory.getPackageRegistry().getEPackage(nsURI);

		// Save Model
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		URI uri = URI.createURI("file:///tmp/BAPI_FLCUST_GETLIST.ecore");
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(CciPackageImpl.eINSTANCE);
		resource.getContents().add(dPackage);
		resource.save(null);
		
		// Create input record
		MappedRecord mappedRecord = recordFactory.createMappedRecord("BAPI_FLCUST_GETLIST.INPUT_RECORD");
		uri = URI.createURI("file:///tmp/BAPI_FLCUST_GETLIST.INPUT_RECORD.ecore");
		resource = resourceSet.createResource(uri);
		resource.getContents().add(mappedRecord);
		resource.save(null);

	}
	
	//@Test
	public void testPackageRegistry() throws Exception {
		Properties destinationProperties = JBossDestinationDataProvider.createDestinationProperties("nplhost", "42",
				"001", "developer", "ch4ngeme", "en");

		JBossDestinationDataProvider provider = new JBossDestinationDataProvider();

		com.sap.conn.jco.ext.Environment.registerDestinationDataProvider(provider);
		provider.addDestinationProperties("ABAP_AS", destinationProperties);

		JCoDestination destination = JCoDestinationManager.getDestination("ABAP_AS");
		destination.ping();

		JCoRepository aRepository = destination.getRepository();
		
		CciPackageRegistryImpl registry = new CciPackageRegistryImpl(aRepository);
		
		//
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new EcoreResourceFactoryImpl());
		resourceSet.setPackageRegistry(registry);
		URI uri = URI.createURI("file:///tmp/input.xml");
		Resource resource = resourceSet.createResource(uri);
		resource.load(null);
		MappedRecord inputRecord = (MappedRecord) resource.getContents().get(0);
		EPackage ePackage = inputRecord.eClass().getEPackage();
		ePackage.getEClassifier("OUTPUT_RECORD");
	}

}
