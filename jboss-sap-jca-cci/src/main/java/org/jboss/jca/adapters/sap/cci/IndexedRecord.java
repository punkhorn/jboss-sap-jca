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
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Indexed Record</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.IndexedRecord#getRecordName <em>Record Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.IndexedRecord#getRecordShortDescription <em>Record Short Description</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.IndexedRecord#getRecordType <em>Record Type</em>}</li>
 * </ul>
 * </p>
 *
 * @model superTypes="org.jboss.jca.adapters.sap.cci.CCIIndexedRecord"
 * @generated
 */
@SuppressWarnings("rawtypes")
public interface IndexedRecord extends EObject, javax.resource.cci.IndexedRecord {
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
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.IndexedRecord#getRecordName <em>Record Name</em>}' attribute.
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
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.IndexedRecord#getRecordShortDescription <em>Record Short Description</em>}' attribute.
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
	 * Returns the value of the '<em><b>Record Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Record Type</em>' reference.
	 * @see #isSetRecordType()
	 * @model resolveProxies="false" unsettable="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EClass getRecordType();

	/**
	 * Returns whether the value of the '{@link org.jboss.jca.adapters.sap.cci.IndexedRecord#getRecordType <em>Record Type</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <p>
	 * </p>
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Record Type</em>' reference is set.
	 * @see #getRecordType()
	 * @generated
	 */
	boolean isSetRecordType();

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
	boolean contains(Object o);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model dataType="org.jboss.jca.adapters.sap.cci.MappedRecordIterator"
	 * @generated
	 */
	Iterator<MappedRecord> iterator();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model dataType="org.jboss.jca.adapters.sap.cci.ObjectArray"
	 * @generated
	 */
	Object[] toArray();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model dataType="org.jboss.jca.adapters.sap.cci.ObjectArray" aDataType="org.jboss.jca.adapters.sap.cci.ObjectArray"
	 * @generated
	 */
	Object[] toArray(Object[] a);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean add(Object e);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
     * Appends and returns a new MappedRecord to the end of this list 
     *
     * @return the new MappedRecord
	 * </p>
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	MappedRecord add();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean remove(Object o);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model cDataType="org.jboss.jca.adapters.sap.cci.RawCollection"
	 * @generated
	 */
	boolean containsAll(Collection c);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model cDataType="org.jboss.jca.adapters.sap.cci.RawCollection"
	 * @generated
	 */
	boolean addAll(Collection c);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model cDataType="org.jboss.jca.adapters.sap.cci.RawCollection"
	 * @generated
	 */
	boolean addAll(int index, Collection c);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model cDataType="org.jboss.jca.adapters.sap.cci.RawCollection"
	 * @generated
	 */
	boolean removeAll(Collection c);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model cDataType="org.jboss.jca.adapters.sap.cci.RawCollection"
	 * @generated
	 */
	boolean retainAll(Collection c);

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
	 * @model
	 * @generated
	 */
	MappedRecord get(int index);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	MappedRecord set(int index, Object element);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void add(int index, Object element);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
     * Inserts and returns a new MappedRecord at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right (adds one to their indices).
     *
     * @param index index at which the new MappedRecord is to be inserted
     * @return the new MappedRecord
	 * </p>
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	MappedRecord add(int index);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	MappedRecord remove(int index);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	int indexOf(Object o);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	int lastIndexOf(Object o);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model dataType="org.jboss.jca.adapters.sap.cci.MappedRecordListIterator"
	 * @generated
	 */
	ListIterator<MappedRecord> listIterator();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model dataType="org.jboss.jca.adapters.sap.cci.MappedRecordListIterator"
	 * @generated
	 */
	ListIterator<MappedRecord> listIterator(int index);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model dataType="org.jboss.jca.adapters.sap.cci.MappedRecordList"
	 * @generated
	 */
	List<MappedRecord> subList(int fromIndex, int toIndex);

} // IndexedRecord
