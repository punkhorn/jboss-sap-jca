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
package org.jboss.jca.adapters.sap.spi.impl;

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
 * @generated NOT
 */
@MessageBundle(projectCode = "JBossSapJcaSpi")
public interface ExceptionBundle {
	ExceptionBundle EXCEPTIONS = Messages.getBundle(ExceptionBundle.class);
	
	@Message(id = 1, value = "The type of connection spec is invalid: %s")
	ResourceException invalidConnectionSpecType(String className);

	@Message(id = 2, value = "The reference to this object is null")
	NamingException referenceIsNull();

	@Message(id = 3, value = "ResultSetInfo is not supported  by the JBoss SAP JCA Connector")
	NotSupportedException resultSetInfoIsNotSupported();

	@Message(id = 4, value = "The connection is closed")
	ResourceException connectionIsClosed();

	@Message(id = 5, value = "The connection is inactive")
	ResourceException connectionIsInactive();

	@Message(id = 6, value = "Failed to load connection meta data properties file '%s'")
	RuntimeException failedToLoadConnectionMetaDataPropertiesFile(String propertiesFile);

	@Message(id = 7, value = "The property '%s' has an invalid integer value in property file '%s'")
	RuntimeException propertyHasInvalidIntegerValue(String property, String propertiesFile);

	@Message(id = 8, value = "Failed to retrieve EIS Product Version")
	ResourceException failedToRetrieveEISProductVersion(@Cause Throwable ex);

	@Message(id = 9, value = "Failed to retrieve User Name")
	ResourceException failedToRetrieveUserName(@Cause Throwable ex);

	@Message(id = 10, value = "The name of requested connection spec is null")
	InvalidConfigurationException connectionSpecNameIsNull();

	@Message(id = 11, value = "The connection spec for '%s' does not exist")
	InvalidConfigurationException connectionSpecDoesNotExist(String connectionSpecName);

	@Message(id = 12, value = "Failed to retreive connection spec for '%s'")
	DataProviderInternalError failedToRetrieveConnectionSpec(String connectionSpecName, @Cause Throwable ex);

	@Message(id = 13, value = "The type of input record is invalid: %s")
	ResourceException invalidInputRecordType(String className);

	@Message(id = 14, value = "The type of outpur record is invalid: %s")
	ResourceException invalidOutputRecordType(String className);

	@Message(id = 15, value = "The function name of interaction spec is null")
	ResourceException functionNameOfInteractionSpecIsNull();

	@Message(id = 16, value = "The remote function module threw an AbapException")
	ResourceWarning remoteFunctionModuleThrewABAPException(@Cause AbapException ex);

	@Message(id = 17, value = "The required parameter '%s' is missing from the parameter list '%s'")
	ResourceException requiredParameterIsMissingInParameterList(String parameterName, String parameterListName);

	@Message(id = 18, value = "The type of record for table parameter '%s' in the table parameter list '%s' is invalid: %s")
	ResourceException invalidRecordTypeForTableParameterInTableParameterList(String parameterName, String parameterListName, String className);

	@Message(id = 19, value = "The type of record for structure parameter '%s' in the parameter list '%s' is invalid: %s")
	ResourceException invalidRecordTypeForStructureParameterInParameterList(String parameterName, String parameterListName, String className);

	@Message(id = 20, value = "The type of record for table parameter '%s' in the parameter list '%s' is invalid: %s")
	ResourceException invalidRecordTypeForTableParameterInParameterList(String parameterName, String parameterListName, String className);

	@Message(id = 21, value = "The type of record for structure parameter '%s' in the structure '%s' is invalid: %s")
	ResourceException invalidRecordTypeForStructureParameterInStructure(String parameterName, String structureName, String className);

	@Message(id = 22, value = "The type of record for table parameter '%s' in the structure '%s' is invalid: %s")
	ResourceException invalidRecordTypeForTableParameterInStructure(String parameterName, String structureName, String className);

	@Message(id = 23, value = "The type of record for table row in the table '%s' is invalid: %s")
	ResourceException invalidRecordTypeForTableRowInTable(String tableName, String className);

	@Message(id = 24, value = "Setting the value '%s' on field '%s' of record '%s' caused ConversionException")
	ResourceException settingValueOnRecordCausedConversionException(String value, String fieldName, String recordName, @Cause Throwable ex);

	@Message(id = 25, value = "The interaction is closed")
	ResourceException interactionIsClosed();

	@Message(id = 26, value = "The JBoss SAP JCA Connector does not support non-managed environments")
	ResourceException nonManagedEnvironmentsNotSupported();

	@Message(id = 27, value = "The type of connection request info is invalid: %s")
	ResourceException invalidConnectionRequestInfoType(String className);

	@Message(id = 28, value = "Did not find sufficient credentials in Subject")
	SecurityException insufficientSecurityCredentialsInSubject();

	@Message(id = 29, value = "The type of resource adapter set on managed connection factory is invalid: %s")
	IllegalArgumentException invalidResourceAdapterTypeSetOnManagedConnectionFactory(String className);

	@Message(id = 30, value = "Failed to create managed connection")
	ResourceException failedToCreateManagedConnection(@Cause Throwable ex);

	@Message(id = 31, value = "Failed to find credentials in Subject matching those of managed connection")
	SecurityException failedToFindMatchingSecurityCredentialsInSubject();

	@Message(id = 32, value = "The value '%s' of connection request info parameter '%s' does not match the value '%s' of managed connection")
	ResourceException connectionRequestInfoParameterDoesNotMatch(String connectionRequestInfoValue, String parameterName, String managedConnectionValue);

	@Message(id = 33, value = "The type of connection to be associated with managed connection is invalid: %s")
	ResourceException invalidConnectionTypeAssociatedWithManagedConnection(String className);

	@Message(id = 34, value = "The connection event listener is null")
	IllegalArgumentException connectionEventListenerIsNull();

	@Message(id = 35, value = "XAResource is not supported  by the JBoss SAP JCA Connector")
	NotSupportedException xaResourceIsNotSupported();

	@Message(id = 36, value = "The connection has outstanding transaction")
	ResourceException connectionHasOutstandingTransaction();

	@Message(id = 37, value = "The connection has no outstanding transaction")
	ResourceException connectionHasNoOutstandingTransaction();

	@Message(id = 38, value = "The transaction commit failed")
	ResourceException commitFailed(@Cause Throwable ex);

	@Message(id = 39, value = "The transaction rollback failed")
	ResourceException rollBackFailed(@Cause Throwable ex);

	@Message(id = 40, value = "The connection ping failed")
	ResourceException pingFailed(@Cause Throwable ex);

	@Message(id = 41, value = "The connection is destroyed")
	ResourceException connectionIsDestroyed();

	@Message(id = 42, value = "Failed to load resource adapter meta data properties file '%s'")
	RuntimeException failedToLoadResourceAdapterMetaDataPropertiesFile(String propertiesFile);

	@Message(id = 43, value = "Failed to get record factory")
	ResourceException failedToGetRecordFactory(@Cause Throwable ex);

	@Message(id = 44, value = "The association of managed connection factory can not be changed during its lifetime")
	IllegalStateException canNotChangeAssociationOfManagedConnectionFactoryDuringItsLifeTime();
	
	@Message(id = 45, value = "The resource adapter is undeployed")
	ResourceException resourceAdapterIsUndeployed();

	@Message(id = 46, value = "The resource adapter is stopped")
	ResourceException resourceAdapterIsStopped();

}


