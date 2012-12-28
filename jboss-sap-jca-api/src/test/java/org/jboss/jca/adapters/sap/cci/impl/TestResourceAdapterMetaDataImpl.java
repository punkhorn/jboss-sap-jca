package org.jboss.jca.adapters.sap.cci.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.jboss.jca.adapters.sap.cci.impl.ResourceAdapterMetaDataImpl.RESOURCE_ADAPTER_INTERACTION_SPECS_SUPPORTED_PROP;
import static org.jboss.jca.adapters.sap.cci.impl.ResourceAdapterMetaDataImpl.RESOURCE_ADAPTER_META_DATA_PROPERITES_FILE;
import static org.jboss.jca.adapters.sap.cci.impl.ResourceAdapterMetaDataImpl.RESOURCE_ADAPTER_NAME_PROP;
import static org.jboss.jca.adapters.sap.cci.impl.ResourceAdapterMetaDataImpl.RESOURCE_ADAPTER_SHORT_DESCRIPTION_PROP;
import static org.jboss.jca.adapters.sap.cci.impl.ResourceAdapterMetaDataImpl.RESOURCE_ADAPTER_SPEC_VERSION_PROP;
import static org.jboss.jca.adapters.sap.cci.impl.ResourceAdapterMetaDataImpl.RESOURCE_ADAPTER_SUPPORTS_EXECUTE_WITH_INPUT_AND_OUTPUT_RECORD_PROP;
import static org.jboss.jca.adapters.sap.cci.impl.ResourceAdapterMetaDataImpl.RESOURCE_ADAPTER_SUPPORTS_EXECUTE_WITH_INPUT_RECORD_ONLY_PROP;
import static org.jboss.jca.adapters.sap.cci.impl.ResourceAdapterMetaDataImpl.RESOURCE_ADAPTER_SUPPORTS_LOCAL_TRANSACTION_DEMARCATION_PROP;
import static org.jboss.jca.adapters.sap.cci.impl.ResourceAdapterMetaDataImpl.RESOURCE_ADAPTER_VENDOR_NAME_PROP;
import static org.jboss.jca.adapters.sap.cci.impl.ResourceAdapterMetaDataImpl.RESOURCE_ADAPTER_VERSION_PROP;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.jboss.jca.adapters.sap.cci.CciFactory;
import org.jboss.jca.adapters.sap.cci.ResourceAdapterMetaData;
import org.junit.Before;
import org.junit.Test;

public class TestResourceAdapterMetaDataImpl {
	
	private static final String RESOURCE_ADAPTER_VERSION;
	private static final String RESOURCE_ADAPTER_VENDOR_NAME;
	private static final String RESOURCE_ADAPTER_NAME;
	private static final String RESOURCE_ADAPTER_SHORT_DESCRIPTION;
	private static final String RESOURCE_ADAPTER_SPEC_VERSION;
	private static final String[] RESOURCE_ADAPTER_INTERACTION_SPECS_SUPPORTED;
	private static final boolean RESOURCE_ADAPTER_SUPPORTS_EXECUTE_WITH_INPUT_AND_OUTPUT_RECORD;
	private static final boolean RESOURCE_ADAPTER_SUPPORTS_EXECUTE_WITH_INPUT_RECORD_ONLY;
	private static final boolean RESOURCE_ADAPTER_SUPPORTS_LOCAL_TRANSACTION_DEMARCATION;

	static {
		Properties metaDataProperties = new Properties();
		try {
			InputStream is = ResourceAdapterMetaDataImpl.class.getClassLoader().getResourceAsStream(RESOURCE_ADAPTER_META_DATA_PROPERITES_FILE);
			metaDataProperties.load(is);
			RESOURCE_ADAPTER_NAME = metaDataProperties.getProperty(RESOURCE_ADAPTER_NAME_PROP);
			RESOURCE_ADAPTER_SHORT_DESCRIPTION = metaDataProperties.getProperty(RESOURCE_ADAPTER_SHORT_DESCRIPTION_PROP);
			RESOURCE_ADAPTER_VENDOR_NAME = metaDataProperties.getProperty(RESOURCE_ADAPTER_VENDOR_NAME_PROP);
			RESOURCE_ADAPTER_VERSION = metaDataProperties.getProperty(RESOURCE_ADAPTER_VERSION_PROP);
			RESOURCE_ADAPTER_INTERACTION_SPECS_SUPPORTED = metaDataProperties.getProperty(RESOURCE_ADAPTER_INTERACTION_SPECS_SUPPORTED_PROP).split(",");
			RESOURCE_ADAPTER_SPEC_VERSION = metaDataProperties.getProperty(RESOURCE_ADAPTER_SPEC_VERSION_PROP);
			RESOURCE_ADAPTER_SUPPORTS_EXECUTE_WITH_INPUT_AND_OUTPUT_RECORD = Boolean.parseBoolean(metaDataProperties.getProperty(RESOURCE_ADAPTER_SUPPORTS_EXECUTE_WITH_INPUT_AND_OUTPUT_RECORD_PROP));
			RESOURCE_ADAPTER_SUPPORTS_EXECUTE_WITH_INPUT_RECORD_ONLY = Boolean.parseBoolean(metaDataProperties.getProperty(RESOURCE_ADAPTER_SUPPORTS_EXECUTE_WITH_INPUT_RECORD_ONLY_PROP));
			RESOURCE_ADAPTER_SUPPORTS_LOCAL_TRANSACTION_DEMARCATION = Boolean.parseBoolean(metaDataProperties.getProperty(RESOURCE_ADAPTER_SUPPORTS_LOCAL_TRANSACTION_DEMARCATION_PROP));
			is.close();
		} catch (IOException e) {
			throw new RuntimeException("Could not load resource adapter meta data properties file '" + RESOURCE_ADAPTER_META_DATA_PROPERITES_FILE + "'");
		}
	}
	private ResourceAdapterMetaData resourceAdapter;
	
	@Before
	public void setUp() throws Exception {
		// Given
		resourceAdapter = CciFactory.eINSTANCE.createResourceAdapterMetaData();
	}

	@Test
	public void testGetAdapterVersion() {
		// When
		String adapterVersion = resourceAdapter.getAdapterVersion();
		
		// Then
		assertThat("ResourceAdapterMetaDataImpl.getAdapterVersion() returned wrong value:", adapterVersion, is(RESOURCE_ADAPTER_VERSION));
	}

	@Test
	public void testGetAdapterVendorName() {
		// When
		String adapterVendorName = resourceAdapter.getAdapterVendorName();
		
		// Then
		assertThat("ResourceAdapterMetaDataImpl.getAdapterVendorName() returned wrong value:", adapterVendorName, is(RESOURCE_ADAPTER_VENDOR_NAME));
	}

	@Test
	public void testGetAdapterName() {
		// When
		String adapterName = resourceAdapter.getAdapterName();
		
		// Then
		assertThat("ResourceAdapterMetaDataImpl.getAdapterName() returned wrong value:", adapterName, is(RESOURCE_ADAPTER_NAME));
	}

	@Test
	public void testGetAdapterShortDescription() {
		// When
		String adapterShortDescription = resourceAdapter.getAdapterShortDescription();
		
		// Then
		assertThat("ResourceAdapterMetaDataImpl.getAdapterShortDescription() returned wrong value:", adapterShortDescription, is(RESOURCE_ADAPTER_SHORT_DESCRIPTION));
	}

	@Test
	public void testGetSpecVersion() {
		// When
		String specVersion = resourceAdapter.getSpecVersion();
		
		// Then
		assertThat("ResourceAdapterMetaDataImpl.getSpecVersion() returned wrong value:", specVersion, is(RESOURCE_ADAPTER_SPEC_VERSION));
	}

	@Test
	public void testGetInteractionSpecsSupported() {
		// When
		String[] interactionSpecsSupported = resourceAdapter.getInteractionSpecsSupported();
		
		// Then
		assertArrayEquals("ResourceAdapterMetaDataImpl.getInteractionSpecsSupported() returned wrong value:", interactionSpecsSupported, RESOURCE_ADAPTER_INTERACTION_SPECS_SUPPORTED);
	}

	@Test
	public void testSupportsExecuteWithInputAndOutputRecord() {
		// When
		boolean supportsExecuteWithInputAndOutputRecord = resourceAdapter.supportsExecuteWithInputAndOutputRecord();
		
		// Then
		assertThat("ResourceAdapterMetaDataImpl.supportsExecuteWithInputAndOutputRecord() returned wrong value:", supportsExecuteWithInputAndOutputRecord, is(RESOURCE_ADAPTER_SUPPORTS_EXECUTE_WITH_INPUT_AND_OUTPUT_RECORD));
	}

	@Test
	public void testSupportsExecuteWithInputRecordOnly() {
		// When
		boolean supportsExecuteWithInputRecordOnly = resourceAdapter.supportsExecuteWithInputRecordOnly();
		
		// Then
		assertThat("ResourceAdapterMetaDataImpl.supportsExecuteWithInputRecordOnly() returned wrong value:", supportsExecuteWithInputRecordOnly, is(RESOURCE_ADAPTER_SUPPORTS_EXECUTE_WITH_INPUT_RECORD_ONLY));
	}

	@Test
	public void testSupportsLocalTransactionDemarcation() {
		// When
		boolean supportsLocalTransactionDemarcation = resourceAdapter.supportsLocalTransactionDemarcation();
		
		// Then
		assertThat("ResourceAdapterMetaDataImpl.supportsLocalTransactionDemarcation() returned wrong value:", supportsLocalTransactionDemarcation, is(RESOURCE_ADAPTER_SUPPORTS_LOCAL_TRANSACTION_DEMARCATION));
	}

}
