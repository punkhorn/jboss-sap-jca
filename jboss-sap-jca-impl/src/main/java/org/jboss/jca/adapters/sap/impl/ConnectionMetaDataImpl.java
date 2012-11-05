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

import javax.resource.ResourceException;
import javax.resource.cci.ConnectionMetaData;
import javax.resource.spi.ManagedConnectionMetaData;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;

/**
 * Implements the {@link ManagedConnectionMetaData } and {@link ConnectionMetaData } interfaces for the JBoss SAP JCA Connector.
 *
 * @author William Collins
 * 
 * @version $Id: 6a04fa15a6dbe10d1bdda9f0de63408b7f0c0739 $
 */
public class ConnectionMetaDataImpl implements ManagedConnectionMetaData, ConnectionMetaData
{
	/**
	 * Location of property file containing static connection meta data
	 */
	static final String CONNECTION_META_DATA_PROPERITES_FILE = "META-INF/connection-meta-data.properties";
	
	/**
	 * Property Name of EIS Product Name property
	 */
	static final String EIS_PRODUCT_NAME_PROP = "eis-product-name";

	/**
	 * Property Name of EIS Maximum Connections property;
	 */
	static final String EIS_MAX_CONNECTIONS_PROP = "eis-max-connections";

	/**
	 * The Product Name of EIS
	 */
	private static final String EIS_PRODUCT_NAME;
	
	/**
	 * The Maximum Number of Connections supported by EIS
	 */
	private static final int EIS_MAX_CONNECTIONS;

	static {
		Properties metaDataProperties = new Properties();
		try {
			InputStream is = ConnectionMetaDataImpl.class.getClassLoader().getResourceAsStream(CONNECTION_META_DATA_PROPERITES_FILE);
			metaDataProperties.load(is);
			EIS_PRODUCT_NAME = metaDataProperties.getProperty(EIS_PRODUCT_NAME_PROP);
			EIS_MAX_CONNECTIONS = Integer.parseInt(metaDataProperties.getProperty(EIS_MAX_CONNECTIONS_PROP));
			is.close();
		} catch (IOException e) {
			throw new RuntimeException("Could not load connection meta data properties file '" + CONNECTION_META_DATA_PROPERITES_FILE + "'");
		} catch (NumberFormatException e) {
			throw new RuntimeException("'" + EIS_MAX_CONNECTIONS_PROP + "' property has an invalid integer value in property file '" + CONNECTION_META_DATA_PROPERITES_FILE + "'");
		}
	}
	
	private final JCoDestination destination;

   /**
    * Default constructor
    */
   public ConnectionMetaDataImpl(JCoDestination destination)
   {
	   this.destination = destination;
   }

	/**
	 * {@inheritDoc}
	 */
   public String getEISProductName() throws ResourceException
   {
      return EIS_PRODUCT_NAME;
   }

	/**
	 * {@inheritDoc}
	 */
   public String getEISProductVersion() throws ResourceException
   {
		try {
			return destination.getAttributes().getPartnerRelease();
		} catch (JCoException e) {
			throw new ResourceException(e);
		}
   }

	/**
	 * {@inheritDoc}
	 */
   public int getMaxConnections() throws ResourceException
   {
      return EIS_MAX_CONNECTIONS;
   }

	/**
	 * {@inheritDoc}
	 */
   public String getUserName() throws ResourceException
   {
		try {
			return destination.getAttributes().getUser();
		} catch (JCoException e) {
			throw new ResourceException(e);
		}
   }

}
