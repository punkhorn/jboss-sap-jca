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

import java.util.logging.Logger;

import javax.resource.ResourceException;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterInternalException;
import javax.resource.spi.endpoint.MessageEndpointFactory;

import javax.transaction.xa.XAResource;

import com.sap.conn.jco.ext.Environment;

/**
 * Implements the {@link ResourceAdapter } interface for the JBoss SAP JCA Connector.
 *
 * @author William Collins
 * 
 * @version $Id: 25d6694a6bed8a642b3ff41ca346848db6072ba6 $
 */
public class ResourceAdapterImpl implements ResourceAdapter {

	/** The logger */
	private static Logger log = Logger.getLogger("JBossSAPResourceAdapter");

	/** Destination Provider for JCo runtime. */
	private final DestinationDataProviderImpl destinationDataProvider;

	/**
	 * Default constructor
	 */
	public ResourceAdapterImpl() {
		destinationDataProvider = new DestinationDataProviderImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	public void endpointActivation(MessageEndpointFactory endpointFactory, ActivationSpec spec)
			throws ResourceException {
		log.finest("endpointActivation()");
	}

	/**
	 * {@inheritDoc}
	 */
	public void endpointDeactivation(MessageEndpointFactory endpointFactory, ActivationSpec spec) {
		log.finest("endpointDeactivation()");
	}

	/**
	 * {@inheritDoc}
	 */
	public void start(BootstrapContext ctx) throws ResourceAdapterInternalException {
		log.finest("Registering Destination Data Provider: " + destinationDataProvider);
		Environment.registerDestinationDataProvider(destinationDataProvider);
	}

	/**
	 * {@inheritDoc}
	 */
	public void stop() {
		log.finest("Unregistering Destination Data Provider: " + destinationDataProvider);
		Environment.unregisterDestinationDataProvider(destinationDataProvider);
	}

	/**
	 * {@inheritDoc}
	 */
	public XAResource[] getXAResources(ActivationSpec[] specs) throws ResourceException {
		log.finest("getXAResources()");
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		int result = 17;
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof ResourceAdapterImpl))
			return false;

		// Return true to prevent application server from deploying multiple instances of this resource adapter.
		boolean result = true;
		return result;
	}

	DestinationDataProviderImpl getDestinationDataProvider() {
		return destinationDataProvider;
	}

}
