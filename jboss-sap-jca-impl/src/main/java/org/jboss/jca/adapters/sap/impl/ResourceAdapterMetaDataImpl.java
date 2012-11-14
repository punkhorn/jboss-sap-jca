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
package org.jboss.jca.adapters.sap.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.resource.cci.ResourceAdapterMetaData;

/**
 * Implements the {@link ResourceAdapterMetaData } interface for the JBoss SAP JCA Connector.
 *
 * @author William Collins
 * 
 * @version $Id: d4e3db14627f48851b1308d78c6d481f511362f2 $
 */
public enum ResourceAdapterMetaDataImpl implements ResourceAdapterMetaData {
	INSTANCE;

	/**
	 * Location of property file containing static resource adapter meta data
	 */
	static final String RESOURCE_ADAPTER_META_DATA_PROPERITES_FILE = "META-INF/resource-adapter-meta-data.properties";
	
	/************************************************************************************
	 * Property Names in Resource Adapter Meta Data Property File 
	 ************************************************************************************/
 
	/**
	 * Property Name of Resource Adapter Name property.
	 */
	static final String RESOURCE_ADAPTER_NAME_PROP = "resource-adapter-name";

	/**
	 * Property Name of Resource Adapter Short Description property.
	 */
	static final String RESOURCE_ADAPTER_SHORT_DESCRIPTION_PROP = "resource-adapter-short-description";
	
	/**
	 * Property Name of Resource Adapter Vendor Name property.
	 */
	static final String RESOURCE_ADAPTER_VENDOR_NAME_PROP = "resource-adapter-vendor-name";
	
	/**
	 * Property Name of Resource Adapter Version property.
	 */
	static final String RESOURCE_ADAPTER_VERSION_PROP = "resource-adapter-version";
	
	/**
	 * Property Name of Resource Adapter Interactions Specs Supported property.
	 */
	static final String RESOURCE_ADAPTER_INTERACTION_SPECS_SUPPORTED_PROP = "resource-adapter-interaction-specs-supported";
	
	/**
	 * Property Name of Resource Adapter Spec Version property.
	 */
	static final String RESOURCE_ADAPTER_SPEC_VERSION_PROP = "resource-adapter-spec-version";
	
	/**
	 * Property Name of Resource Adapter Supports Execute with Input and Output Record property.
	 */
	static final String RESOURCE_ADAPTER_SUPPORTS_EXECUTE_WITH_INPUT_AND_OUTPUT_RECORD_PROP = "resource-adapter-supports-execute-with-input-and-output-record";
	
	/**
	 * Property Name of Resource Adapter Supports Execute with Input Record Only property.
	 */
	static final String RESOURCE_ADAPTER_SUPPORTS_EXECUTE_WITH_INPUT_RECORD_ONLY_PROP = "resource-adapter-supports-execute-with-input-record-only";
	
	/**
	 * Property Name of Resource Adapter Supports Local Transaction Demarcation property.
	 */
	static final String RESOURCE_ADAPTER_SUPPORTS_LOCAL_TRANSACTION_DEMARCATION_PROP = "resource-adapter-supports-local-transaction-demarcation";

	/************************************************************************************
	 * Resource Adapter Static Meta Data Properties
	 ************************************************************************************/
 
	/**
	 * Name of Resource Adapter
	 */
	private static final String RESOURCE_ADAPTER_NAME;

	/**
	 * Short Description of Resource Adapter 
	 */
	private static final String RESOURCE_ADAPTER_SHORT_DESCRIPTION;
	
	/**
	 * Name of Resource Adapter Vendor
	 */
	private static final String RESOURCE_ADAPTER_VENDOR_NAME;
	
	/**
	 * Version of Resource Adapter
	 */
	private static final String RESOURCE_ADAPTER_VERSION;
	
	/**
	 * Comma separated list of fully qualified class names of Interaction Specification classes supported by this Resource Adapter.
	 */
	private static final String[] RESOURCE_ADAPTER_INTERACTION_SPECS_SUPPORTED;
	
	/**
	 * The Version of the JEE Connector Architecture Specification supported by this Resource Adapter.
	 */
	private static final String RESOURCE_ADAPTER_SPEC_VERSION;
	
	/**
	 * Indicator specifying whether this Resource Adapter supports Interaction execution with both Input and Output Records. 
	 */
	private static final boolean RESOURCE_ADAPTER_SUPPORTS_EXECUTE_WITH_INPUT_AND_OUTPUT_RECORD;
	
	/**
	 * Indicator specifying whether this Resource Adapter supports Interaction execution with only an Input Record. 
	 */
	private static final boolean RESOURCE_ADAPTER_SUPPORTS_EXECUTE_WITH_INPUT_RECORD_ONLY;
	
	/**
	 * Indicator specifying whether this Resource Adapter supports Demarcation of Local Transactions
	 */
	private static final boolean RESOURCE_ADAPTER_SUPPORTS_LOCAL_TRANSACTION_DEMARCATION;
	
	static {
		Properties metaDataProperties = new Properties();
		try {
			InputStream is = ConnectionMetaDataImpl.class.getClassLoader().getResourceAsStream(RESOURCE_ADAPTER_META_DATA_PROPERITES_FILE);
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
			throw JBossSapJCAExceptionBundle.EXCEPTIONS.failedToLoadResourceAdapterMetaDataPropertiesFile(RESOURCE_ADAPTER_META_DATA_PROPERITES_FILE);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getAdapterVersion() {
		return RESOURCE_ADAPTER_VERSION;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getAdapterVendorName() {
		return RESOURCE_ADAPTER_VENDOR_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getAdapterName() {
		return RESOURCE_ADAPTER_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getAdapterShortDescription() {
		return RESOURCE_ADAPTER_SHORT_DESCRIPTION;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getSpecVersion() {
		return RESOURCE_ADAPTER_SPEC_VERSION;
	}

	/**
	 * {@inheritDoc}
	 */
	public String[] getInteractionSpecsSupported() {
		return RESOURCE_ADAPTER_INTERACTION_SPECS_SUPPORTED;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean supportsExecuteWithInputAndOutputRecord() {
		return RESOURCE_ADAPTER_SUPPORTS_EXECUTE_WITH_INPUT_AND_OUTPUT_RECORD;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean supportsExecuteWithInputRecordOnly() {
		return RESOURCE_ADAPTER_SUPPORTS_EXECUTE_WITH_INPUT_RECORD_ONLY;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean supportsLocalTransactionDemarcation() {
		return RESOURCE_ADAPTER_SUPPORTS_LOCAL_TRANSACTION_DEMARCATION;
	}

}
