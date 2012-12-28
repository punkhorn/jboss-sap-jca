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
package org.jboss.jca.adapters.sap.integration;

import org.jboss.jca.adapters.sap.cci.impl.ExceptionBundle;
import org.jboss.jca.adapters.sap.cci.impl.LocalTransactionImpl;
import org.jboss.jca.adapters.sap.spi.impl.ConnectionRequestInfoImpl;
import org.jboss.jca.adapters.sap.spi.impl.DataProviderInternalError;
import org.jboss.jca.adapters.sap.spi.impl.DestinationDataProviderImpl;
import org.jboss.jca.adapters.sap.spi.impl.InvalidConfigurationException;
import org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionFactoryImpl;
import org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionImpl;
import org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionMetaDataImpl;
import org.jboss.jca.adapters.sap.spi.impl.ResourceAdapterImpl;

/**
 * ClassesToTest - Defines the list of Classes deployed and tested by unit tests
 * 
 * @author William Collins
 *
 */
public interface ClassesToTest {

	/**
	 * Specifies the list of classes archived in RARs used by unit tests
	 */
	public static final Class<?>[] CLASSES_TO_TEST = new Class[] { 
			ConnectionRequestInfoImpl.class,
			DataProviderInternalError.class,
			DestinationDataProviderImpl.class,
			ExceptionBundle.class,
			InvalidConfigurationException.class,
			LocalTransactionImpl.class,
			ManagedConnectionFactoryImpl.class,
			ManagedConnectionImpl.class, 
			ManagedConnectionMetaDataImpl.class,
			ResourceAdapterImpl.class,
			};

}
