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
import javax.resource.cci.IndexedRecord;
import javax.resource.cci.MappedRecord;
import javax.resource.cci.RecordFactory;


/**
 * Implements the {@link RecordFactory } interface for the JBoss SAP JCA Connector.
 *
 * @author William Collins
 * 
 * @version $Id: 402bf810b9a0c28f40a83dc6812fe00bfb29b1c6 $
 */
public enum RecordFactoryImpl implements RecordFactory {
	INSTANCE;

	/**
	 * {@inheritDoc}
	 */
	public MappedRecord createMappedRecord(String recordName) throws ResourceException {
		return new MappedRecordImpl(recordName);
	}

	/**
	 * {@inheritDoc}
	 */
	public IndexedRecord createIndexedRecord(String recordName) throws ResourceException {
		return new IndexedRecordImpl(recordName);
	}

}
