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
 * A representation of the model object '<em><b>Mapped Record</b></em>'.
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
	 * @model dataType="org.jboss.jca.adapters.sap.cci.RawSet"
	 * @generated
	 */
	Set entrySet();

} // MappedRecord
