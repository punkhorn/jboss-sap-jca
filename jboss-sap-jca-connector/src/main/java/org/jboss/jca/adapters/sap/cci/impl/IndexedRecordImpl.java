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
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.jboss.jca.adapters.sap.cci.IndexedRecord;
import org.jboss.jca.adapters.sap.cci.MappedRecord;

import com.sap.conn.jco.JCoTable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Indexed Record</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.IndexedRecordImpl#getRecordName <em>Record Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.IndexedRecordImpl#getRecordShortDescription <em>Record Short Description</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.IndexedRecordImpl#getRecordType <em>Record Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
/**
 * @author bicollin
 *
 */
@SuppressWarnings("rawtypes")
public class IndexedRecordImpl extends EObjectImpl implements IndexedRecord {

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
	 * @generated NOT
	 */
	protected EList<MappedRecord> records = new BasicInternalEList<MappedRecord>(MappedRecord.class);
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IndexedRecordImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CciPackageImpl.Literals.INDEXED_RECORD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRecordName() {
		return recordName;
	}

	/**
	 * <!-- begin-user-doc -->
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
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRecordShortDescription() {
		return recordShortDescription;
	}

	/**
	 * <!-- begin-user-doc -->
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
	 * @generated NOT
	 */
	public EClass getRecordType() {
		return (EClass) eClass().getEStructuralFeature("recordType").getEType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSetRecordType() {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<MappedRecord> getRecord() {
		return records;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void unsetRecord() {
		// NOOP
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSetRecord() {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object clone() {
		return EcoreUtil.copy(this);
	}

	/**
	 * <!-- begin-user-doc -->
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
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int size() {
		return records.size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isEmpty() {
		return records.isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean contains(Object o) {
		return records.contains(o);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Iterator<MappedRecord> iterator() {
		return records.iterator();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object[] toArray() {
		return records.toArray();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object[] toArray(Object[] a) {
		return records.toArray(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean add(Object e) {
		if (!(getRecordType().isInstance(e)))
			throw new IllegalArgumentException();
		return records.add((MappedRecord) e);
	}
	
	/**
	 * @generated NOT
	 */
	public MappedRecord add() {
		EClass recordType = getRecordType();
		MappedRecord mappedRecord = (MappedRecord) eClass().getEPackage().getEFactoryInstance().create(recordType);
		mappedRecord.setRecordName(getRecordName());
		records.add(mappedRecord);
		return mappedRecord;
	}

	/**
	 * @generated NOT
	 */
	public MappedRecord add(int index) {
		MappedRecord mappedRecord = (MappedRecord) eClass().getEPackage().getEFactoryInstance().create(getRecordType());
		mappedRecord.setRecordName(getRecordName());
		records.add(index, mappedRecord);
		return mappedRecord;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean remove(Object o) {
		return records.remove(o);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean containsAll(Collection c) {
		return records.containsAll(c);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean addAll(Collection c) {
		boolean modified = false;
		Iterator it = c.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			if(!getRecordType().isInstance(obj))
				throw new IllegalArgumentException();
			if(records.add((MappedRecord)obj))
				modified = true;
		}
		return modified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean addAll(int index, Collection c) {
		boolean modified = false;
		Iterator it = c.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			if(!getRecordType().isInstance(obj))
				throw new IllegalArgumentException();
			records.add(index++, (MappedRecord)obj);
			modified = true;
		}
		return modified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean removeAll(Collection c) {
		boolean modified = false;
		Iterator it = c.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			if(records.contains(obj))
				it.remove();
				modified = true;
		}
		return modified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean retainAll(Collection c) {
		boolean modified = false;
		Iterator it = c.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			if(!records.contains(obj))
				it.remove();
				modified = true;
		}
		return modified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void clear() {
		records.clear();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MappedRecord get(int index) {
		return records.get(index);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MappedRecord set(int index, Object element) {
		if (!getRecordType().isInstance(element))
			throw new IllegalArgumentException();
		return records.set(index, (MappedRecord) element);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void add(int index, Object element) {
		if (!(getRecordType().isInstance(element)))
			throw new IllegalArgumentException();
		records.add(index, (MappedRecord) element);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MappedRecord remove(int index) {
		return records.remove(index);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int indexOf(Object o) {
		return records.indexOf(o);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int lastIndexOf(Object o) {
		return records.lastIndexOf(o);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ListIterator<MappedRecord> listIterator() {
		return records.listIterator();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ListIterator<MappedRecord> listIterator(int index) {
		return records.listIterator(index);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List<MappedRecord> subList(int fromIndex, int toIndex) {
		return records.subList(fromIndex, toIndex);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CciPackageImpl.INDEXED_RECORD__RECORD:
				return ((InternalEList<?>)getRecord()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
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
			case CciPackageImpl.INDEXED_RECORD__RECORD_TYPE:
				return getRecordType();
			case CciPackageImpl.INDEXED_RECORD__RECORD:
				return getRecord();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
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
			case CciPackageImpl.INDEXED_RECORD__RECORD:
				getRecord().clear();
				getRecord().addAll((Collection<? extends MappedRecord>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
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
			case CciPackageImpl.INDEXED_RECORD__RECORD:
				unsetRecord();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
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
			case CciPackageImpl.INDEXED_RECORD__RECORD_TYPE:
				return isSetRecordType();
			case CciPackageImpl.INDEXED_RECORD__RECORD:
				return isSetRecord();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
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
