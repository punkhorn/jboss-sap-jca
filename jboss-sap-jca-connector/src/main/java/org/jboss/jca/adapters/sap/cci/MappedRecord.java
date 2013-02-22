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

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * Specializes the {@link javax.resource.cci.MappedRecord} interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.MappedRecord#getRecordName <em>Record Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.MappedRecord#getRecordShortDescription <em>Record Short Description</em>}</li>
 * </ul>
 * </p>
 *
 * @model superTypes="org.jboss.jca.adapters.sap.cci.CCIMappedRecord"
 * @generated
 */
	@SuppressWarnings("rawtypes")
public interface MappedRecord extends EObject, javax.resource.cci.MappedRecord {
	/**
	 * Returns the value of the '<em><b>Record Name</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of this Record
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Record Name</em>' attribute.
	 * @see #setRecordName(String)
	 * @model default="0"
	 * @generated
	 */
	String getRecordName();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.MappedRecord#getRecordName <em>Record Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Record Name</em>' attribute.
	 * @see #getRecordName()
	 * @generated
	 */
	void setRecordName(String value);

	/**
	 * Returns the value of the '<em><b>Record Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The short description of this Record
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Record Short Description</em>' attribute.
	 * @see #setRecordShortDescription(String)
	 * @model
	 * @generated
	 */
	String getRecordShortDescription();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.MappedRecord#getRecordShortDescription <em>Record Short Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Record Short Description</em>' attribute.
	 * @see #getRecordShortDescription()
	 * @generated
	 */
	void setRecordShortDescription(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Create a copy of this Record
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	Object clone();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Compare two Records for equality
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean equals(Object other);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return a hashcode for this Record
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	int hashCode();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the number of attributes defined for this Record.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	int size();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns <code>true</code> if this Record has no defined attributes.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isEmpty();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns <code>true</code> if this Record has attribute with name equal to specified key.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean containsKey(Object key);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns <code>true</code> if this Record contains one or more attributes with specified value.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean containsValue(Object value);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <p>
	 * <b>NB:</b> {@link MappedRecord} and {@link IndexRecord} values of record are automatically created when first retrieved.
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the value of attribute with name equal to specified key. Returns <code>null</code> if there is no attribute with name equal to specified key in this Record. 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	Object get(Object key);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sets the value of attribute with name equal to specified key to the specified value. No value is set if there is no attribute with name equal to specified key in this Record.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	Object put(Object key, Object value);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Unsets the value of the attribute with name equal to the specified key. No value is unset if there is no attribute with name equal to specified key in this Record.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	Object remove(Object key);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * For each mapping in the specified map, sets the value of attribute with name equal to the mappings key to the mappings value. Mappings in specified map with key values that do not correspond to an attribute name in record are ignored.
	 * <!-- end-model-doc -->
	 * @model mDataType="org.jboss.jca.adapters.sap.cci.RawMap"
	 * @generated
	 */
	void putAll(Map m);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  Unsets the value of all attributes in this Record.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void clear();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns a {@link Set} view of attribute names in this Record.
	 * <!-- end-model-doc -->
	 * @model dataType="org.jboss.jca.adapters.sap.cci.RawSet"
	 * @generated
	 */
	Set keySet();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns a {@link Set} view of attribute values in this Record.
	 * <!-- end-model-doc -->
	 * @model dataType="org.jboss.jca.adapters.sap.cci.RawCollection"
	 * @generated
	 */
	Collection values();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns a {@link Set} view of entries in this Record.
	 * <!-- end-model-doc -->
	 * @model dataType="org.jboss.jca.adapters.sap.cci.RawSet"
	 * @generated
	 */
	Set entrySet();

} // MappedRecord
