/**
 * JBoss, Home of Professional Open Source.
 * Copyright 2013, Red Hat Middleware LLC, and individual contributors
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

import javax.resource.cci.Record;

import org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl;

/**
 * Package level information
 * 
 * @author William Collins
 * @generated NOT
 */
public interface CciPackage {

	/**
	 * The common prefix of all package namespace URI's of packages derived from this package.
	 */
	public static final String JBOSS_SAP_URI_PREFIX = "http://sap.adapters.jca.jboss.org/";

	/**
	 * The package namespace URI.
	 */
	public static final String CciNS_URI = CciPackageImpl.eNS_URI;

	/**
	 * Details key for a {@link Record} entry annotation providing the description of the underlying JCo data field represented by the annotated record entry. The details value is the description of the record entry and its underlying JCo data field. 
	 */
	public static final String CciNS_DESCRIPTION_KEY = "description";

	/**
	 * Details key for a {@link Record} entry annotation providing the fully-qualified Java classname of the annotated record entry. The details value is the fully-qualified Java classname of the record entry. 
	 */
	public static final String CciNS_CLASS_NAME_OF_FIELD_KEY = "classNameOfField";

	/**
	 * Details key for a {@link Record} entry annotation indicating the table, structure or data element name of the underlying JCo data field represented by the annotated record entry. The details value is the name of the table, structure or data element of the underlying JCo data field. The details values is <code>null</code> if the data element name is unavailable. 
	 */
	public static final String CciNS_RECORD_TYPE_NAME_KEY = "recordTypeName";

	/**
	 * Details key for a {@link Record} entry annotation providing the JCo data type of the underlying data field represented by the annotated record entry. The details value is the JCo data type of the underlying data field represented by the record entry. 
	 */
	public static final String CciNS_TYPE_KEY = "type";

	/**
	 * Details key for a {@link Record} entry annotation providing the String representation of the JCo data type of the underlying data field represented by the annotated record entry. The details value is the String representation of the JCo data type of the underlying data field represented by the record entry. 
	 */
	public static final String CciNS_TYPE_AS_STRING_KEY = "typeAsString";

	/**
	 * Details key for a {@link Record} entry annotation providing the length of the underlying data field for Unicode layout represented by the annotated record entry. The details value is the length of the underlying data field for Unicode layout represented by the record entry. 
	 */
	public static final String CciNS_UNICODE_BYTE_LENGTH_KEY = "unicodeByteLength";

	/**
	 * Details key for a {@link Record} entry annotation providing the byte length of the underlying data field for Non-Unicode layout represented by the annotated record entry. The details value is the byte length of the underlying data field for Non-Unicode layout represented by the record entry. 
	 */
	public static final String CciNS_BYTE_LENGTH_KEY = "byteLength";

	/**
	 * Details key for a {@link Record} entry annotation providing the max length of the underlying data field represented by the annotated record entry. The details value is the max length of the underlying data field represented by the record entry.
	 * 
	 * <ul>
	 * <li><p>For character based data element types the length is the char length.
	 * <li><p>For <em><b>STRING</b></em> and <em><b>XSTRING</b></em> data element types the length is <em><b>0</b></em>.</li> 
	 * <li><p>For <em><b>STRUCTURE</b></em> and <em><b>TABLE</b></em> data element types the length is <em><b>0</b></em>.</li>
	 * <li><p>For numerical based data element types the length is the byte length.
	 * </ul> 
	 */
	public static final String CciNS_LENGTH_KEY = "length";

	/**
	 * Details key for a {@link Record} entry annotation providing the number of decimals in the the underlying data field represented by the annotated record entry. The details value is the number of decimals in the the underlying data field represented by the record entry.
	 * 
	 * <p>The details value is possibly non-zero only for record entries whose underlying data field has the JCo data type <em><b>BCD</b></em> or <em><b>FLOAT</b></em>.
	 */
	public static final String CciNS_DECIMALS_KEY = "decimals";

	/**
	 * Details key for a {@link Record} entry annotation providing the default value of the annotated record entry. The details value is the default value of the record entry.
	 */
	public static final String CciNS_DEFAULT_KEY = "default";

	/**
	 * Details key for a {@link Record} entry annotation providing the field name in an underlying JCo structure or table represented by the annotated record entry. The details value is the name of the field in the underlying JCo structure or table if the JCo parameter represented by the entry is defined by referencing that field. The details values is <code>null</code> otherwise. 
	 */
	public static final String CciNS_RECORD_FIELD_NAME_KEY = "recordFieldName";

	/**
	 * Details key for a {@link Record} entry annotation indicating whether the annotated record entry represents an underlying JCo <code>ABAP Object</code>. The details value is <code>true</code> if the record entry represents an <code>ABAP Object</code>; <code>false</code> otherwise. 
	 */
	public static final String CciNS_IS_ABAP_OBJECT_KEY = "isAbapObject";

	/**
	 * Details key for a {@link Record} entry annotation indicating whether the annotated record entry represents an underlying <code>TYPE1</code> JCo structure. The details value is <code>true</code> if the record entry represents a <code>TYPE1</code> structure; <code>false</code> otherwise. 
	 */
	public static final String CciNS_IS_NESTED_TYPE1_STRUCTURE_KEY = "isNestedType1Structure";

	/**
	 * Details key for a {@link Record} entry annotation indicating whether the annotated record entry is a <em><b>structure</b></em> type entry; i.e. is a {@link MappedRecord}. The details value is <code>true</code> if the record entry is a {@link MappedRecord}; <code>false</code> otherwise. 
	 */
	public static final String CciNS_IS_STRUCTURE_KEY = "isStructure";

	/**
	 * Details key for a {@link Record} entry annotation indicating whether the annotated record entry is a <em><b>table</b></em> type entry; i.e. is an {@link IndexedRecord}. The details value is <code>true</code> if the record entry is a {@link IndexedRecord}; <code>false</code> otherwise.	 
	 */
	public static final String CciNS_IS_TABLE_KEY = "isTable";

	/**
	 * Details key for a {@link Record} entry annotation indicating whether the underlying data field represented by the annotated record entry is an <em><b>import</b></em> parameter. The details value is <code>true</code> if the underlying data field is an import parameter; <code>false</code> otherwise.	 
	 */
	public static final String CciNS_IS_IMPORT_KEY = "isImport";

	/**
	 * Details key for a {@link Record} entry annotation indicating whether the underlying data field represented by the annotated record entry is an <em><b>export</b></em> parameter. The details value is <code>true</code> if the underlying data field is an export parameter; <code>false</code> otherwise.	 
	 */
	public static final String CciNS_IS_EXPORT_KEY = "isExport";

	/**
	 * Details key for a {@link Record} entry annotation indicating whether the underlying data field represented by the annotated record entry is a <em><b>changing</b></em> parameter. The details value is <code>true</code> if the underlying data field is a changing parameter; <code>false</code> otherwise.	 
	 */
	public static final String CciNS_IS_CHANGING_KEY = "isChanging";

	/**
	 * Details key for a {@link Record} entry annotation indicating whether the underlying data field represented by the annotated record entry is an <em><b>exception</b></em>. The details value is <code>true</code> if the underlying data field is an exception; <code>false</code> otherwise.	 
	 */
	public static final String CciNS_IS_EXCEPTION_KEY = "isException";

	/**
	 * Details key for a {@link Record} entry annotation indicating whether the underlying data field represented by the annotated record entry is an <em><b>optional</b></em> parameter. The details value is <code>true</code> if the underlying data field is an optional parameter; <code>false</code> otherwise.	 
	 */
	public static final String CciNS_IS_OPTIONAL_KEY = "isOptional";
}
