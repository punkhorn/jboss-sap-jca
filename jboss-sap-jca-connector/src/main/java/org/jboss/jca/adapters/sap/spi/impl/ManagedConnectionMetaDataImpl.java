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
package org.jboss.jca.adapters.sap.spi.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.print.attribute.standard.Destination;
import javax.resource.ResourceException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.jboss.jca.adapters.sap.spi.ManagedConnectionMetaData;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;

/**
 * <!-- begin-user-doc -->
 * Implements the {@link ManagedConnectionMetaData } interface for the JBoss SAP
 * JCA Connector.
 * 
 * @author William Collins
 * 
 * @version $Id:  $
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
/**
 * @author bicollin
 *
 */
/**
 * @author bicollin
 *
 */
/**
 * @author bicollin
 *
 */
public class ManagedConnectionMetaDataImpl extends EObjectImpl implements ManagedConnectionMetaData {
	/**
	 * Location of property file containing static connection meta data
	 * @generated NOT
	 */
	static final String CONNECTION_META_DATA_PROPERITES_FILE = "META-INF/connection-meta-data.properties";
	
	/**
	 * Property Name of EIS Product Name property
	 * @generated NOT
	 */
	static final String EIS_PRODUCT_NAME_PROP = "eis-product-name";

	/**
	 * Property Name of EIS Maximum Connections property;
	 * @generated NOT
	 */
	static final String EIS_MAX_CONNECTIONS_PROP = "eis-max-connections";

	/**
	 * The Product Name of EIS
	 * @generated NOT
	 */
	private static final String EIS_PRODUCT_NAME;
	
	/**
	 * The Maximum Number of Connections supported by EIS
	 * @generated NOT
	 */
	private static final int EIS_MAX_CONNECTIONS;

	/**
	 * Initialize static constants from properties file.
	 * 
	 * @generated NOT
	 */
	static {
		Properties metaDataProperties = new Properties();
		try {
			InputStream is = ManagedConnectionMetaDataImpl.class.getClassLoader().getResourceAsStream(CONNECTION_META_DATA_PROPERITES_FILE);
			metaDataProperties.load(is);
			EIS_PRODUCT_NAME = metaDataProperties.getProperty(EIS_PRODUCT_NAME_PROP);
			EIS_MAX_CONNECTIONS = Integer.parseInt(metaDataProperties.getProperty(EIS_MAX_CONNECTIONS_PROP));
			is.close();
		} catch (IOException e) {
			throw ExceptionBundle.EXCEPTIONS.failedToLoadConnectionMetaDataPropertiesFile(CONNECTION_META_DATA_PROPERITES_FILE);
		} catch (NumberFormatException e) {
			throw ExceptionBundle.EXCEPTIONS.propertyHasInvalidIntegerValue(EIS_MAX_CONNECTIONS_PROP, CONNECTION_META_DATA_PROPERITES_FILE);
		}
	}
	
	/**
	 * {@link Destination} instance used to retrieve meta data from SAP instance.
	 * 
	 * @generated NOT
	 */
	private JCoDestination destination;

	/**
	 * <!-- begin-user-doc -->
	 * Create an empty instance of a {@link ManagedConnectionMetaData}.
	 * 
	 * <p> Note this should only be used for serialization
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ManagedConnectionMetaDataImpl() {
		super();
	}

	/**
	 * Create an instance of {@link ManagedConnectionMetaData} connected to SAP instance designated by specified <code>destination</code>
	 * 
	 * @param destination - connection to SAP instance.
	 */
	public ManagedConnectionMetaDataImpl(JCoDestination destination) {
		this.destination = destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpiPackageImpl.Literals.MANAGED_CONNECTION_META_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getEISProductName() throws ResourceException {
		return EIS_PRODUCT_NAME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getEISProductVersion() throws ResourceException {
		try {
			return destination.getAttributes().getPartnerRelease();
		} catch (JCoException e) {
			throw ExceptionBundle.EXCEPTIONS.failedToRetrieveEISProductVersion(e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getMaxConnections() throws ResourceException {
		return EIS_MAX_CONNECTIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getUserName() throws ResourceException {
		try {
			return destination.getAttributes().getUser();
		} catch (JCoException e) {
			throw ExceptionBundle.EXCEPTIONS.failedToRetrieveUserName(e);
		}
	}

} //ManagedConnectionMetaDataImpl
