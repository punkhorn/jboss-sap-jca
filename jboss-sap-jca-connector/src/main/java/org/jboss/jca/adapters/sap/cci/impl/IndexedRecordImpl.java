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
package org.jboss.jca.adapters.sap.cci.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.resource.ResourceException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.jboss.jca.adapters.sap.cci.IndexedRecord;
import org.jboss.jca.adapters.sap.cci.MappedRecord;

import com.sap.conn.jco.JCoTable;

/**
 * <!-- begin-user-doc -->
 * Implements the {@link IndexedRecord } interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.IndexedRecordImpl#getRecordName <em>Record Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.IndexedRecordImpl#getRecordShortDescription <em>Record Short Description</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.IndexedRecordImpl#getRecords <em>Records</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("rawtypes")
public class IndexedRecordImpl<R extends MappedRecord> extends EObjectImpl implements IndexedRecord<R> {

	/**
	 * @generated NOT
	 */
	private static final long serialVersionUID = 5538294696847856206L;

	/**
	 * The default value of the '{@link #getRecordName() <em>Record Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecordName()
	 * @generated
	 * @ordered
	 */
	protected static final String RECORD_NAME_EDEFAULT = "0";

	/**
	 * The cached value of the '{@link #getRecordName() <em>Record Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecordName()
	 * @generated
	 * @ordered
	 */
	protected String recordName = RECORD_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRecordShortDescription() <em>Record Short Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecordShortDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String RECORD_SHORT_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRecordShortDescription() <em>Record Short Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecordShortDescription()
	 * @generated
	 * @ordered
	 */
	protected String recordShortDescription = RECORD_SHORT_DESCRIPTION_EDEFAULT;
	
	/**
	 * @generated
	 */
	protected EList<R> records;
	
	/**
	 * <!-- begin-user-doc -->
	 * Create an {@link IndexedRecord} instance.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IndexedRecordImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CciPackageImpl.Literals.INDEXED_RECORD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRecordName() {
		return recordName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecordName(String newRecordName) {
		String oldRecordName = recordName;
		recordName = newRecordName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackageImpl.INDEXED_RECORD__RECORD_NAME, oldRecordName, recordName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRecordShortDescription() {
		return recordShortDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecordShortDescription(String newRecordShortDescription) {
		String oldRecordShortDescription = recordShortDescription;
		recordShortDescription = newRecordShortDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackageImpl.INDEXED_RECORD__RECORD_SHORT_DESCRIPTION, oldRecordShortDescription, recordShortDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<R> getRecords() {
		if (records == null) {
			records = new EObjectContainmentEList<R>(MappedRecord.class, this, CciPackageImpl.INDEXED_RECORD__RECORDS);
		}
		return records;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EClass getRecordType() {
		try {
			return (EClass) eClass().getEGenericSuperTypes().get(0).getETypeArguments().get(0).getEClassifier();
		} catch (Exception e) {
			throw ExceptionBundle.EXCEPTIONS.indexedRecordHasNoRecordType(e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSetRecordType() {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object clone() {
		return EcoreUtil.copy(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean equals(Object other) {
		if (other == this)
			return true;
		if (!(other instanceof List))
			return false;

		ListIterator e1 = listIterator();
		ListIterator e2 = ((List) other).listIterator();
		while (e1.hasNext() && e2.hasNext()) {
			Object o1 = e1.next();
			Object o2 = e2.next();
			if (!(o1 == null ? o2 == null : o1.equals(o2)))
				return false;
	}
	return !(e1.hasNext() || e2.hasNext());
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int hashCode() {
		int hashCode = 1;
		Iterator i = iterator();
		while (i.hasNext()) {
			Object obj = i.next();
			hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
		}
		return hashCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int size() {
		return getRecords().size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isEmpty() {
		return getRecords().isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean contains(Object o) {
		return getRecords().contains(o);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public Iterator<MappedRecord> iterator() {
		return (Iterator<MappedRecord>) getRecords().iterator();
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object[] toArray() {
		return getRecords().toArray();
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object[] toArray(Object[] a) {
		return getRecords().toArray(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public boolean add(Object e) {
		if (!(getRecordType().isInstance(e)))
			throw new IllegalArgumentException();
		return getRecords().add((R) e);
	}
	
	/**
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public MappedRecord add() {
		EClass recordType = getRecordType();
		R mappedRecord = (R) eClass().getEPackage().getEFactoryInstance().create(recordType);
		mappedRecord.setRecordName(getRecordName());
		getRecords().add(mappedRecord);
		return mappedRecord;
	}

	/**
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public MappedRecord add(int index) {
		R mappedRecord = (R) eClass().getEPackage().getEFactoryInstance().create(getRecordType());
		mappedRecord.setRecordName(getRecordName());
		getRecords().add(index, mappedRecord);
		return mappedRecord;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean remove(Object o) {
		return getRecords().remove(o);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean containsAll(Collection c) {
		return getRecords().containsAll(c);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public boolean addAll(Collection c) {
		boolean modified = false;
		Iterator it = c.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			if(!getRecordType().isInstance(obj))
				throw new IllegalArgumentException();
			if(getRecords().add((R)obj))
				modified = true;
		}
		return modified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public boolean addAll(int index, Collection c) {
		boolean modified = false;
		Iterator it = c.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			if(!getRecordType().isInstance(obj))
				throw new IllegalArgumentException();
			getRecords().add(index++, (R)obj);
			modified = true;
		}
		return modified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean removeAll(Collection c) {
		boolean modified = false;
		Iterator it = c.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			if(getRecords().contains(obj))
				it.remove();
				modified = true;
		}
		return modified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean retainAll(Collection c) {
		boolean modified = false;
		Iterator it = c.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			if(!getRecords().contains(obj))
				it.remove();
				modified = true;
		}
		return modified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void clear() {
		getRecords().clear();
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MappedRecord get(int index) {
		return getRecords().get(index);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public MappedRecord set(int index, Object element) {
		if (!getRecordType().isInstance(element))
			throw new IllegalArgumentException();
		return getRecords().set(index, (R) element);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public void add(int index, Object element) {
		if (!(getRecordType().isInstance(element)))
			throw new IllegalArgumentException();
		getRecords().add(index, (R) element);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MappedRecord remove(int index) {
		return getRecords().remove(index);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int indexOf(Object o) {
		return getRecords().indexOf(o);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int lastIndexOf(Object o) {
		return getRecords().lastIndexOf(o);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public ListIterator<MappedRecord> listIterator() {
		return (ListIterator<MappedRecord>) getRecords().listIterator();
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public ListIterator<MappedRecord> listIterator(int index) {
		return (ListIterator<MappedRecord>) getRecords().listIterator(index);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public List<MappedRecord> subList(int fromIndex, int toIndex) {
		return (List<MappedRecord>) getRecords().subList(fromIndex, toIndex);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CciPackageImpl.INDEXED_RECORD__RECORDS:
				return ((InternalEList<?>)getRecords()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CciPackageImpl.INDEXED_RECORD__RECORD_NAME:
				return getRecordName();
			case CciPackageImpl.INDEXED_RECORD__RECORD_SHORT_DESCRIPTION:
				return getRecordShortDescription();
			case CciPackageImpl.INDEXED_RECORD__RECORDS:
				return getRecords();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CciPackageImpl.INDEXED_RECORD__RECORD_NAME:
				setRecordName((String)newValue);
				return;
			case CciPackageImpl.INDEXED_RECORD__RECORD_SHORT_DESCRIPTION:
				setRecordShortDescription((String)newValue);
				return;
			case CciPackageImpl.INDEXED_RECORD__RECORDS:
				getRecords().clear();
				getRecords().addAll((Collection<? extends R>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CciPackageImpl.INDEXED_RECORD__RECORD_NAME:
				setRecordName(RECORD_NAME_EDEFAULT);
				return;
			case CciPackageImpl.INDEXED_RECORD__RECORD_SHORT_DESCRIPTION:
				setRecordShortDescription(RECORD_SHORT_DESCRIPTION_EDEFAULT);
				return;
			case CciPackageImpl.INDEXED_RECORD__RECORDS:
				getRecords().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CciPackageImpl.INDEXED_RECORD__RECORD_NAME:
				return RECORD_NAME_EDEFAULT == null ? recordName != null : !RECORD_NAME_EDEFAULT.equals(recordName);
			case CciPackageImpl.INDEXED_RECORD__RECORD_SHORT_DESCRIPTION:
				return RECORD_SHORT_DESCRIPTION_EDEFAULT == null ? recordShortDescription != null : !RECORD_SHORT_DESCRIPTION_EDEFAULT.equals(recordShortDescription);
			case CciPackageImpl.INDEXED_RECORD__RECORDS:
				return records != null && !records.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (recordName: ");
		result.append(recordName);
		result.append(", recordShortDescription: ");
		result.append(recordShortDescription);
		result.append(')');
		return result.toString();
	}

	/**
	 * Populate this record with the contents of <code>table</code>.
	 * 
	 * @param table - the {@link JCoTable} whose contents are populated into this record.
	 * @throws ResourceException
	 * @generated NOT
	 */
	public void put(JCoTable table) throws ResourceException {
		
		if (table == null)
			return;
		
		table.firstRow();
		for (int i = 0; i < table.getNumRows(); i++, table.nextRow()) {
			MappedRecord nestedRecord = add();
			((MappedRecordImpl)nestedRecord).put(table);
		}
	}

	/**
	 * Populate <code>table</code> with the contents of this record.
	 * 
	 * @param table - the {@link JCoTable} populated with the contents of this record.
	 * @throws ResourceException
	 * @generated NOT
	 */
	public void fill(JCoTable table) throws ResourceException {
		
		if (table == null)
			return;

		Iterator<MappedRecord> iterator = iterator();
		while(iterator.hasNext()) {
			MappedRecord record = iterator.next();
			table.appendRow();
			((MappedRecordImpl)record).fill(table);
		}
	}

} //IndexedRecordImpl
