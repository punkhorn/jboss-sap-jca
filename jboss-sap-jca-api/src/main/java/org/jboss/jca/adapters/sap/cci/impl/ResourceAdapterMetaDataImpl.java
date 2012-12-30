/**
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
 * 
 */
package org.jboss.jca.adapters.sap.cci.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.jboss.jca.adapters.sap.cci.ResourceAdapterMetaData;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Adapter Meta Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ResourceAdapterMetaDataImpl extends EObjectImpl implements ResourceAdapterMetaData {
	/**
	 * Location of property file containing static resource adapter meta data
	 * @generated NOT
	 */
	static final String RESOURCE_ADAPTER_META_DATA_PROPERITES_FILE = "META-INF/resource-adapter-meta-data.properties";
	
	/************************************************************************************
	 * Property Names in Resource Adapter Meta Data Property File 
	 ************************************************************************************/
 
	/**
	 * Property Name of Resource Adapter Name property.
	 * @generated NOT
	 */
	static final String RESOURCE_ADAPTER_NAME_PROP = "resource-adapter-name";

	/**
	 * Property Name of Resource Adapter Short Description property.
	 * @generated NOT
	 */
	static final String RESOURCE_ADAPTER_SHORT_DESCRIPTION_PROP = "resource-adapter-short-description";
	
	/**
	 * Property Name of Resource Adapter Vendor Name property.
	 * @generated NOT
	 */
	static final String RESOURCE_ADAPTER_VENDOR_NAME_PROP = "resource-adapter-vendor-name";
	
	/**
	 * Property Name of Resource Adapter Version property.
	 * @generated NOT
	 */
	static final String RESOURCE_ADAPTER_VERSION_PROP = "resource-adapter-version";
	
	/**
	 * Property Name of Resource Adapter Interactions Specs Supported property.
	 * @generated NOT
	 */
	static final String RESOURCE_ADAPTER_INTERACTION_SPECS_SUPPORTED_PROP = "resource-adapter-interaction-specs-supported";
	
	/**
	 * Property Name of Resource Adapter Spec Version property.
	 * @generated NOT
	 */
	static final String RESOURCE_ADAPTER_SPEC_VERSION_PROP = "resource-adapter-spec-version";
	
	/**
	 * Property Name of Resource Adapter Supports Execute with Input and Output Record property.
	 * @generated NOT
	 */
	static final String RESOURCE_ADAPTER_SUPPORTS_EXECUTE_WITH_INPUT_AND_OUTPUT_RECORD_PROP = "resource-adapter-supports-execute-with-input-and-output-record";
	
	/**
	 * Property Name of Resource Adapter Supports Execute with Input Record Only property.
	 * @generated NOT
	 */
	static final String RESOURCE_ADAPTER_SUPPORTS_EXECUTE_WITH_INPUT_RECORD_ONLY_PROP = "resource-adapter-supports-execute-with-input-record-only";
	
	/**
	 * Property Name of Resource Adapter Supports Local Transaction Demarcation property.
	 * @generated NOT
	 */
	static final String RESOURCE_ADAPTER_SUPPORTS_LOCAL_TRANSACTION_DEMARCATION_PROP = "resource-adapter-supports-local-transaction-demarcation";

	/************************************************************************************
	 * Resource Adapter Static Meta Data Properties
	 ************************************************************************************/
 
	/**
	 * Name of Resource Adapter
	 * @generated NOT
	 */
	private static final String RESOURCE_ADAPTER_NAME;

	/**
	 * Short Description of Resource Adapter 
	 * @generated NOT
	 */
	private static final String RESOURCE_ADAPTER_SHORT_DESCRIPTION;
	
	/**
	 * Name of Resource Adapter Vendor
	 * @generated NOT
	 */
	private static final String RESOURCE_ADAPTER_VENDOR_NAME;
	
	/**
	 * Version of Resource Adapter
	 * @generated NOT
	 */
	private static final String RESOURCE_ADAPTER_VERSION;
	
	/**
	 * Comma separated list of fully qualified class names of Interaction Specification classes supported by this Resource Adapter.
	 * @generated NOT
	 */
	private static final String[] RESOURCE_ADAPTER_INTERACTION_SPECS_SUPPORTED;
	
	/**
	 * The Version of the JEE Connector Architecture Specification supported by this Resource Adapter.
	 * @generated NOT
	 */
	private static final String RESOURCE_ADAPTER_SPEC_VERSION;
	
	/**
	 * Indicator specifying whether this Resource Adapter supports Interaction execution with both Input and Output Records. 
	 * @generated NOT
	 */
	private static final boolean RESOURCE_ADAPTER_SUPPORTS_EXECUTE_WITH_INPUT_AND_OUTPUT_RECORD;
	
	/**
	 * Indicator specifying whether this Resource Adapter supports Interaction execution with only an Input Record. 
	 * @generated NOT
	 */
	private static final boolean RESOURCE_ADAPTER_SUPPORTS_EXECUTE_WITH_INPUT_RECORD_ONLY;
	
	/**
	 * Indicator specifying whether this Resource Adapter supports Demarcation of Local Transactions
	 * @generated NOT
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
			throw ExceptionBundle.EXCEPTIONS.failedToLoadResourceAdapterMetaDataPropertiesFile(RESOURCE_ADAPTER_META_DATA_PROPERITES_FILE);
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceAdapterMetaDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	protected EClass eStaticClass() {
		return CciPackageImpl.Literals.RESOURCE_ADAPTER_META_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getAdapterVersion() {
		return RESOURCE_ADAPTER_VERSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getAdapterVendorName() {
		return RESOURCE_ADAPTER_VENDOR_NAME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getAdapterName() {
		return RESOURCE_ADAPTER_NAME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getAdapterShortDescription() {
		return RESOURCE_ADAPTER_SHORT_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSpecVersion() {
		return RESOURCE_ADAPTER_SPEC_VERSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String[] getInteractionSpecsSupported() {
		return RESOURCE_ADAPTER_INTERACTION_SPECS_SUPPORTED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean supportsExecuteWithInputAndOutputRecord() {
		return RESOURCE_ADAPTER_SUPPORTS_EXECUTE_WITH_INPUT_AND_OUTPUT_RECORD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean supportsExecuteWithInputRecordOnly() {
		return RESOURCE_ADAPTER_SUPPORTS_EXECUTE_WITH_INPUT_RECORD_ONLY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean supportsLocalTransactionDemarcation() {
		return RESOURCE_ADAPTER_SUPPORTS_LOCAL_TRANSACTION_DEMARCATION;
	}

} //ResourceAdapterMetaDataImpl
