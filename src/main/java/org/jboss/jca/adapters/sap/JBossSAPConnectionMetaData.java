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
package org.jboss.jca.adapters.sap;

import javax.resource.ResourceException;

import javax.resource.cci.ConnectionMetaData;

import com.sap.conn.jco.JCoException;

/**
 * Implements the {@link ConnectionMetaData } interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 *
 * @version $Revision: $
 */
public class JBossSAPConnectionMetaData implements ConnectionMetaData
{
	private final JBossSAPCciConnection connection;
	
   /**
    * Default constructor
    */
   JBossSAPConnectionMetaData(JBossSAPCciConnection connection)
   {
	   this.connection = connection;
   }

	/**
	 * {@inheritDoc}
	 */
   public String getEISProductName() throws ResourceException
   {
      return "SAP"; 
   }

	/**
	 * {@inheritDoc}
	 */
   public String getEISProductVersion() throws ResourceException
   {
		try {
			return connection.getDestination().getAttributes().getPartnerRelease();
		} catch (JCoException e) {
			throw new ResourceException(e);
		}
   }

	/**
	 * {@inheritDoc}
	 */
   public String getUserName() throws ResourceException
   {
		try {
			return connection.getDestination().getAttributes().getUser();
		} catch (JCoException e) {
			throw new ResourceException(e);
		}
   }


}
