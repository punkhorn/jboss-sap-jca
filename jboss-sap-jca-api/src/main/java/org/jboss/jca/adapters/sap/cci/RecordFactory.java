/**
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
 * 
 */
package org.jboss.jca.adapters.sap.cci;

import javax.resource.ResourceException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record Factory</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getRecordFactory()
 * @model superTypes="org.jboss.jca.adapters.sap.cci.CCIRecordFactory"
 * @generated
 */
public interface RecordFactory extends EObject, javax.resource.cci.RecordFactory {
	/**
	 * @generated NOT
	 */
	public static final String CciNS_DESCRIPTION_KEY = "description";
	
	/**
	 * @generated NOT
	 */
	public static final String CciNS_CLASS_NAME_OF_FIELD_KEY = "classNameOfField";
	
	/**
	 * @generated NOT
	 */
	public static final String CciNS_RECORD_TYPE_NAME_KEY = "recordTypeName";
	
	/**
	 * @generated NOT
	 */
	public static final String CciNS_TYPE_KEY = "type";
	
	/**
	 * @generated NOT
	 */
	public static final String CciNS_TYPE_AS_STRING_KEY = "typeAsString";
	
	/**
	 * @generated NOT
	 */
	public static final String CciNS_UNICODE_BYTE_LENGTH_KEY = "unicodeByteLength";
	
	/**
	 * @generated NOT
	 */
	public static final String CciNS_BYTE_LENGTH_KEY = "byteLength";
	
	/**
	 * @generated NOT
	 */
	public static final String CciNS_LENGTH_KEY = "length";
	
	/**
	 * @generated NOT
	 */
	public static final String CciNS_DECIMALS_KEY = "decimals";
	
	/**
	 * @generated NOT
	 */
	public static final String CciNS_DEFAULT_KEY = "default";
	
	/**
	 * @generated NOT
	 */
	public static final String CciNS_RECORD_FIELD_NAME_KEY = "recordFieldName";
	
	/**
	 * @generated NOT
	 */
	public static final String CciNS_IS_ABAP_OBJECT_KEY = "isAbapObject";
	
	/**
	 * @generated NOT
	 */
	public static final String CciNS_IS_NESTED_TYPE1_STRUCTURE_KEY = "isNestedType1Structure";
	
	/**
	 * @generated NOT
	 */
	public static final String CciNS_IS_STRUCTURE_KEY = "isStructure";
	
	/**
	 * @generated NOT
	 */
	public static final String CciNS_IS_TABLE_KEY = "isTable";
	
	/**
	 * @generated NOT
	 */
	public static final String CciNS_IS_IMPORT_KEY = "isImport";
	
	/**
	 * @generated NOT
	 */
	public static final String CciNS_IS_EXPORT_KEY = "isExport";
	
	/**
	 * @generated NOT
	 */
	public static final String CciNS_IS_CHANGING_KEY = "isChanging";
	
	/**
	 * @generated NOT
	 */
	public static final String CciNS_IS_EXCEPTION_KEY = "isException";
	
	/**
	 * @generated NOT
	 */
	public static final String CciNS_IS_OPTIONAL_KEY = "isOptional";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	MappedRecord createMappedRecord(String recordName) throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	IndexedRecord createIndexedRecord(String recordName) throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException"
	 * @generated
	 */
	EPackage getPackage(String functionModuleName) throws ResourceException;

} // RecordFactory
