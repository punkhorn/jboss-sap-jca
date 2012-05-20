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

import java.util.HashMap;

import javax.resource.cci.MappedRecord;

/**
 * Implements the {@link MappedRecord } interface for the JBoss SAP JCA Connector.
 *
 * @author William Collins
 * 
 * @version $Revision: $
 */
@SuppressWarnings("rawtypes")
public class JBossSAPMappedRecord extends HashMap implements MappedRecord {

	private static final long serialVersionUID = 7043798736836203848L;
	
	private String recordName;
	
	private String recordShortDescription;
	
	/**
	 * Create mapped record with specified record name
	 * 
	 * @param recordName - the record name
	 */
	public JBossSAPMappedRecord(String recordName) {
		this(recordName, null);
	}
	
	/**
	 * Create mapped record with specified record name and short description
	 * @param recordName - the record name
	 * @param recordShortDescription - the record short description
	 */
	public JBossSAPMappedRecord(String recordName, String recordShortDescription) {
		this.recordName = recordName;
		this.recordShortDescription = recordShortDescription;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getRecordName() {
		return recordName;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setRecordName(String name) {
		this.recordName = name;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setRecordShortDescription(String description) {
		this.recordShortDescription = description;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getRecordShortDescription() {
		return recordShortDescription;
	}
	

}
