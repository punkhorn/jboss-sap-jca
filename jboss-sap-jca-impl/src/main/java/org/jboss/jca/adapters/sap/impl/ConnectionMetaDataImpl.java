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
 * @version $Id$
 */
public class ConnectionMetaDataImpl implements ManagedConnectionMetaData, ConnectionMetaData
{
	
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
      return "SAP® R/3";
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
      return 0;
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
