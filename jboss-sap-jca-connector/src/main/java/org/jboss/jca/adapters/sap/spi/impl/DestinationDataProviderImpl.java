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
package org.jboss.jca.adapters.sap.spi.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


import com.sap.conn.jco.ext.DestinationDataEventListener;
import com.sap.conn.jco.ext.DestinationDataProvider;

/**
 * Implements the {@link DestinationDataProvider} interface for the JBoss SAP JCA Connector
 * 
 * @author William Collins
 *
 * @version $Id: f013a298cd7272562b09566969b6e8b7ec2d9604 $
 * @generated NOT
 */
public class DestinationDataProviderImpl implements DestinationDataProvider {

	/**
	 * Event Listener to notify JCo runtime of configuration changes
	 */
	private DestinationDataEventListener destinationDataListener;

	/**
	 * Map containing configuration properties for multiple destination FIXME:
	 * Replace with secure storage mechanism.
	 */
	private Map<String, ConnectionRequestInfoImpl> destinationPropertiesMap = new HashMap<String, ConnectionRequestInfoImpl>();

	/**
	 * {@inheritDoc}
	 */
	public Properties getDestinationProperties(String destinationName) {
		return getConnectionRequestInfo(destinationName).getProperties();
	}

	/**
	 * {@inheritDoc}
	 */
	public ConnectionRequestInfoImpl getConnectionRequestInfo(String destinationName) {
		if (destinationName == null) 
			throw ExceptionBundle.EXCEPTIONS.connectionSpecNameIsNull();
		try {
			ConnectionRequestInfoImpl connectionRequestInfo = destinationPropertiesMap.get(destinationName);
			if (connectionRequestInfo == null) {
				throw ExceptionBundle.EXCEPTIONS.connectionSpecDoesNotExist(destinationName);
			}
			return connectionRequestInfo;
		} catch (RuntimeException e) {
			throw ExceptionBundle.EXCEPTIONS.failedToRetrieveConnectionSpec(destinationName, e);
		}
	}

	/**
	 * Adds properties for given destination.
	 * 
	 * @param destinationName - the name of the destination for which the provider should add given properties
	 * @param destinationProperties - the properties added for the destination
	 */
	public void addConnectionRequestInfo(String destinationName, ConnectionRequestInfoImpl destinationProperties) {
		if (destinationName == null) 
			throw ExceptionBundle.EXCEPTIONS.connectionSpecNameIsNull();
		destinationPropertiesMap.put(destinationName, destinationProperties);
		updateProperties(destinationName, destinationProperties);
	}
	
	/**
	 * @param destinationName - the name of the destination for which the provider should remove properties
	 * @return the properties removed for the destination or <code>null</code> if no properties for destination were found
	 */
	public ConnectionRequestInfoImpl removeConnectionRequestInfo(String destinationName) {
		if (destinationName == null) 
			throw ExceptionBundle.EXCEPTIONS.connectionSpecNameIsNull();
		ConnectionRequestInfoImpl destinationProperties = destinationPropertiesMap.get(destinationName);
		updateProperties(destinationName, null);
		return destinationProperties;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setDestinationDataEventListener(DestinationDataEventListener listener) {
		this.destinationDataListener = listener;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean supportsEvents() {
		return true;
	}

	private void updateProperties(String destinationName, ConnectionRequestInfoImpl destinationProperties) {
		synchronized (destinationPropertiesMap) {
			if (destinationProperties == null) {
				if (destinationPropertiesMap.remove(destinationName) != null) {
					if (destinationDataListener != null)
						destinationDataListener.deleted(destinationName);
				}
			} else {
				destinationPropertiesMap.put(destinationName, destinationProperties);
				if (destinationDataListener != null)
					destinationDataListener.updated(destinationName);
			}
		}
	}
}
