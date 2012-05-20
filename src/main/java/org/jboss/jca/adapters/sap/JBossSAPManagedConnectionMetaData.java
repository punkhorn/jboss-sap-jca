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

import java.util.logging.Logger;

import javax.resource.ResourceException;

import javax.resource.spi.ManagedConnectionMetaData;

/**
 * Implements the {@link ManagedConnectionMetaData } interface for the JBoss SAP JCA Connector.
 *
 * @author William Collins
 * 
 * @version $Revision: $
 */
public class JBossSAPManagedConnectionMetaData implements ManagedConnectionMetaData
{
   /** The logger */
   private static Logger log = Logger.getLogger("JBossSAPManagedConnectionMetaData");

   /**
    * Default constructor
    */
   public JBossSAPManagedConnectionMetaData()
   {

   }

	/**
	 * {@inheritDoc}
	 */
   public String getEISProductName() throws ResourceException
   {
      log.finest("getEISProductName()");
      return null; //TODO
   }

	/**
	 * {@inheritDoc}
	 */
   public String getEISProductVersion() throws ResourceException
   {
      log.finest("getEISProductVersion()");
      return null; //TODO
   }

	/**
	 * {@inheritDoc}
	 */
   public int getMaxConnections() throws ResourceException
   {
      log.finest("getMaxConnections()");
      return 0; //TODO
   }

	/**
	 * {@inheritDoc}
	 */
   public String getUserName() throws ResourceException
   {
      log.finest("getUserName()");
      return null; //TODO
   }


}
