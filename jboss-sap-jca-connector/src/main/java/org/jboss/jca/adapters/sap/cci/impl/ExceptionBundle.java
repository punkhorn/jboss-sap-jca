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
package org.jboss.jca.adapters.sap.cci.impl;

import javax.naming.NamingException;
import javax.resource.NotSupportedException;
import javax.resource.ResourceException;
import javax.resource.cci.ResourceWarning;

import org.jboss.logging.Cause;
import org.jboss.logging.Message;
import org.jboss.logging.MessageBundle;
import org.jboss.logging.Messages;

import com.sap.conn.jco.AbapException;

/**
 * Exception Bundle for JBoss SAP JCA Connector
 * 
 * @author William Collins
 *
 */
@MessageBundle(projectCode = "JBossSapJcaCci")
public interface ExceptionBundle {
	ExceptionBundle EXCEPTIONS = Messages.getBundle(ExceptionBundle.class);
	
	@Message(id = 1, value = "The type of record for structure parameter '%s' in the parameter list '%s' is invalid: %s")
	ResourceException invalidRecordTypeForStructureParameterInRecord(String parameterName, String parameterListName, String className);

	@Message(id = 2, value = "The type of record for table parameter '%s' in the parameter list '%s' is invalid: %s")
	ResourceException invalidRecordTypeForTableParameterInRecord(String parameterName, String parameterListName, String className);

	@Message(id = 3, value = "The reference to this object is null")
	NamingException referenceIsNull();

	@Message(id = 4, value = "The connection is closed")
	ResourceException connectionIsClosed();

	@Message(id = 5, value = "The connection is inactive")
	ResourceException connectionIsInactive();

	@Message(id = 6, value = "ResultSetInfo is not supported  by the JBoss SAP JCA Connector")
	NotSupportedException resultSetInfoIsNotSupported();

	@Message(id = 7, value = "The type of connection spec is invalid: %s")
	ResourceException invalidConnectionSpecType(String className);

	@Message(id = 8, value = "The type of input record is invalid: %s")
	ResourceException invalidInputRecordType(String className);

	@Message(id = 9, value = "The type of outpur record is invalid: %s")
	ResourceException invalidOutputRecordType(String className);

	@Message(id = 10, value = "The function name of interaction spec is null")
	ResourceException functionNameOfInteractionSpecIsNull();

	@Message(id = 11, value = "The remote function module threw an AbapException")
	ResourceWarning remoteFunctionModuleThrewABAPException(@Cause AbapException ex);

	@Message(id = 12, value = "The interaction is closed")
	ResourceException interactionIsClosed();

	@Message(id = 13, value = "Failed to load resource adapter meta data properties file '%s'")
	RuntimeException failedToLoadResourceAdapterMetaDataPropertiesFile(String propertiesFile);

	@Message(id = 14, value = "Failed to get record factory")
	ResourceException failedToGetRecordFactory(@Cause Throwable ex);

	@Message(id = 15, value = "Failed to access meta data repository")
	ResourceException failedToAccessMetaDataRepository();

	@Message(id = 16, value = "The indexed record has no record type")
	TypeNotPresentException indexedRecordHasNoRecordType(@Cause Throwable ex);

}


