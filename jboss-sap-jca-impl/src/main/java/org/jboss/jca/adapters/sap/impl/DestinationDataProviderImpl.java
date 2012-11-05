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

import java.util.HashMap;
import java.util.Map;

import org.jboss.jca.adapters.sap.cci.JBossSAPConnectionSpec;

import com.sap.conn.jco.ext.DataProviderException;
import com.sap.conn.jco.ext.DestinationDataEventListener;
import com.sap.conn.jco.ext.DestinationDataProvider;

/**
 * Implements the {@link DestinationDataProvider} interface for the JBoss SAP JCA Connector
 * 
 * @author William Collins
 *
 * @version $Id$
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
	private Map<String, JBossSAPConnectionSpec> destinationPropertiesMap = new HashMap<String, JBossSAPConnectionSpec>();

	/**
	 * {@inheritDoc}
	 */
	public JBossSAPConnectionSpec getDestinationProperties(String destinationName) {
		if (destinationName == null) 
			throw new DataProviderException(DataProviderException.Reason.INVALID_CONFIGURATION, "destination-data-provider-impl-no-destination-name", null);
		try {
			JBossSAPConnectionSpec properties = destinationPropertiesMap.get(destinationName);
			if (properties == null) {
				throw new DataProviderException(DataProviderException.Reason.INVALID_CONFIGURATION,
						"destination-data-provider-impl-invalid-destination-configuration", null);
			}
			return properties;
		} catch (RuntimeException e) {
			throw new DataProviderException(DataProviderException.Reason.INTERNAL_ERROR, e);
		}
	}

	/**
	 * Adds properties for given destination.
	 * 
	 * @param destinationName - the name of the destination for which the provider should add given properties
	 * @param destinationProperties - the properties added for the destination
	 */
	public void addDestinationProperties(String destinationName, JBossSAPConnectionSpec destinationProperties) {
		if (destinationName == null) 
			throw new DataProviderException(DataProviderException.Reason.INVALID_CONFIGURATION, "destination-data-provider-impl-null-destination-name", null);
		destinationPropertiesMap.put(destinationName, destinationProperties);
		updateProperties(destinationName, destinationProperties);
	}
	
	/**
	 * @param destinationName - the name of the destination for which the provider should remove properties
	 * @return the properties removed for the destination or <code>null</code> if no properties for destination were found
	 */
	public JBossSAPConnectionSpec removeDestinationProperties(String destinationName) {
		if (destinationName == null) 
			throw new DataProviderException(DataProviderException.Reason.INVALID_CONFIGURATION, "destination-data-provider-impl-null-destination-name", null);
		JBossSAPConnectionSpec destinationProperties = destinationPropertiesMap.get(destinationName);
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

	private void updateProperties(String destinationName, JBossSAPConnectionSpec destinationProperties) {
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
