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

import javax.resource.cci.ResourceAdapterMetaData;

/**
 * Implements the {@link ResourceAdapterMetaData } interface for the JBoss SAP JCA Connector.
 *
 * @author William Collins
 * 
 * @version $Id: $
 */
public enum ResourceAdapterMetaDataImpl implements ResourceAdapterMetaData {
	INSTANCE;

	/**
	 * {@inheritDoc}
	 */
	public String getAdapterVersion() {
		return "1.0.0";
	}

	/**
	 * {@inheritDoc}
	 */
	public String getAdapterVendorName() {
		return "Red Hat";
	}

	/**
	 * {@inheritDoc}
	 */
	public String getAdapterName() {
		return "JBoss SAP JCA Adapter";
	}

	/**
	 * {@inheritDoc}
	 */
	public String getAdapterShortDescription() {
		return "JBoss SAP JCA";
	}

	/**
	 * {@inheritDoc}
	 */
	public String getSpecVersion() {
		return "1.5";
	}

	/**
	 * {@inheritDoc}
	 */
	public String[] getInteractionSpecsSupported() {
		return new String[] { "org.jboss.jca.adapters.sap.JBossSAPInteractionSpec" };
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean supportsExecuteWithInputAndOutputRecord() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean supportsExecuteWithInputRecordOnly() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean supportsLocalTransactionDemarcation() {
		return true; 
	}

}
