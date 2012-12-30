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

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.resource.ResourceException;
import javax.resource.cci.Record;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.jboss.jca.adapters.sap.cci.MappedRecord;

import com.sap.conn.jco.JCoField;
import com.sap.conn.jco.JCoFieldIterator;
import com.sap.conn.jco.JCoRecord;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapped Record</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.MappedRecordImpl#getRecordName <em>Record Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.MappedRecordImpl#getRecordShortDescription <em>Record Short Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("rawtypes")
public class MappedRecordImpl extends EObjectImpl implements MappedRecord {
	
	/**
	 * @generated NOT
	 */
	private static final long serialVersionUID = -6456996079915380973L;

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
	public static class Entry implements Map.Entry {
		
		private Object key;
		private Object value;
		
		Entry(Object key, Object value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public Object getKey() {
			return key;
		}

		@Override
		public Object getValue() {
			return value;
		}

		@Override
		public Object setValue(Object newValue) {
            Object oldValue = value;
            value = newValue;
            return oldValue;
		}
		
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry e = (Map.Entry)o;
            Object k1 = getKey();
            Object k2 = e.getKey();
            if (k1 == k2 || (k1 != null && k1.equals(k2))) {
                Object v1 = getValue();
                Object v2 = e.getValue();
                if (v1 == v2 || (v1 != null && v1.equals(v2)))
                    return true;
            }
            return false;
        }
        
        public final int hashCode() {
            return (key==null   ? 0 : key.hashCode()) ^
                   (value==null ? 0 : value.hashCode());
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
	}
	
	/**
	 * @generated NOT
	 */
	private abstract class FeatureIterator implements Iterator {
		
		private final Iterator iterator;
		private EStructuralFeature current;
		
		public FeatureIterator() {
			iterator = eClass().getEStructuralFeatures().iterator();
		}

		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		EStructuralFeature nextEntry() {
			current = (EStructuralFeature) iterator.next(); 
			return current;
		}

		@Override
		public void remove() {
			if (current == null) 
				throw new IllegalStateException();
			String key = current.getName();
			current = null;
			MappedRecordImpl.this.remove(key);
		}
		
	}
	
	/**
	 * @generated NOT
	 */
	private class ValueIterator extends FeatureIterator {
		@Override
		public Object next() {
			EStructuralFeature feature = nextEntry();
			return get(feature.getName());
		}
	}
	
	/**
	 * @generated NOT
	 */
	private class KeyIterator extends FeatureIterator {
		@Override
		public Object next() {
			return nextEntry().getName();
		}
	}
	
	/**
	 * @generated NOT
	 */
	private class EntryIterator extends FeatureIterator {
		@Override
		public Object next() {
			EStructuralFeature feature = nextEntry();
			Object value = get(feature.getName());
			return new Entry(feature.getName(), value);
		}
	}
	
	/**
	 * @generated NOT
	 */
	private class EntrySet extends AbstractSet {

		@Override
		public Iterator iterator() {
			return new EntryIterator();
		}
		
		@Override
		public boolean contains(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry e = (Map.Entry)o;
            return MappedRecordImpl.this.containsKey(e.getKey());
		}
		
		@Override
		public boolean remove(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry e = (Map.Entry)o;
            Object value = MappedRecordImpl.this.remove(e.getKey());
            return value != null; 
		}

		@Override
		public int size() {
			return MappedRecordImpl.this.size();
		}
		
		@Override
		public void clear() {
			MappedRecordImpl.this.clear();
		}
		
	}

	/**
	 * @generated NOT
	 */
	private class KeySet extends AbstractSet {

		@Override
		public Iterator iterator() {
			return new KeyIterator();
		}

		@Override
		public int size() {
			return MappedRecordImpl.this.size();
		}
		
		@Override
		public boolean contains(Object key) {
			return containsKey(key);
		}
		
		@Override
		public boolean remove(Object key) {
			if (containsKey(key)) {
				MappedRecordImpl.this.remove(key);
				return true;
			}
			else
				return false;
		}
		
		@Override
		public void clear() {
			MappedRecordImpl.this.clear();
		}
		
	}

	/**
	 * @generated NOT
	 */
    private class Values extends AbstractCollection {

		@Override
		public Iterator iterator() {
			return new ValueIterator();
		}

		@Override
		public int size() {
			return MappedRecordImpl.this.size();
		}
		
		@Override
		public boolean contains(Object o) {
            return containsValue(o);
		}
		
		@Override
		public void clear() {
			MappedRecordImpl.this.clear();
		}
    }	
    
	/**
	 * @generated NOT
	 */
	private transient volatile Set entrySet = null;
	
	/**
	 * @generated NOT
	 */
	private transient volatile Set keySet = null;
	
	/**
	 * @generated NOT
	 */
	private transient volatile Collection values = null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected MappedRecordImpl() {
		super();
		recordName = eClass().getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CciPackageImpl.Literals.MAPPED_RECORD;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackageImpl.MAPPED_RECORD__RECORD_NAME, oldRecordName, recordName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackageImpl.MAPPED_RECORD__RECORD_SHORT_DESCRIPTION, oldRecordShortDescription, recordShortDescription));
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
		
		if (!(other instanceof Map))
			return false;
		Map m = (Map) other;
		if (m.size() != size())
			return false;
		
		try {
			Iterator i = entrySet().iterator();
			while (i.hasNext()) {
				Entry e = (Entry) i.next();
				Object key = e.getKey();
				Object value = e.getValue();
				if (value == null) {
					if (!(m.get(key) == null && m.containsKey(key)))
						return false;
				} else {
					if (!value.equals(m.get(key)))
						return false;
				}
			}
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int hashCode() {
		int h = 0;
		Iterator i = entrySet().iterator();
		while(i.hasNext()) 
			h += i.next().hashCode();
		return h;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int size() {
		return eClass().getFeatureCount();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isEmpty() {
		return eClass().getFeatureCount() == 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean containsKey(Object key) {
		if (!(key instanceof String)) 
			return false;
		String featureName = (String) key;
		return eClass().getEStructuralFeature(featureName) == null ? false : true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean containsValue(Object value) {
		for(EStructuralFeature eFeature: eClass().getEStructuralFeatures()) {
			if (eGet(eFeature).equals(value))
				return true;
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object get(Object key) {
		if (!(key instanceof String)) 
			return null;
		String featureName = (String) key;
		EStructuralFeature eFeature = eClass().getEStructuralFeature(featureName);
		if (eFeature == null)
			return null;
		Object retValue = eGet(eFeature);
		if(retValue == null && eFeature.getEType() instanceof EClass) {
			EClass recordClass = (EClass) eFeature.getEType();
			if(CciPackageImpl.eINSTANCE.getMappedRecord().isSuperTypeOf(recordClass) || CciPackageImpl.eINSTANCE.getIndexedRecord().isSuperTypeOf(recordClass)) {
				Record record = (Record) eClass().getEPackage().getEFactoryInstance().create(recordClass);
				record.setRecordName(featureName);
				put(key, record);
				retValue = record;
			}
		}
		return retValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object put(Object key, Object value) {
		if (key == null) 
			throw new NullPointerException("Key can not be null");
		if (!(key instanceof String)) 
			throw new ClassCastException("Key '" + key + "' must be a string");
		String featureName = (String) key;
		EStructuralFeature eFeature = eClass().getEStructuralFeature(featureName);
		if (eFeature == null)
			throw new IllegalArgumentException("Key '" + key + "' is not a valid attribute name for this record");
		Object returnValue = eGet(eFeature);
		try {
			eSet(eFeature, value);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Key '" + key + "' is not a valid attribute name for this record", e);
		} catch (ClassCastException e) {
			ClassCastException ex = new ClassCastException("The value '" + value + "' of type '" + value.getClass() +"' is invalid for attribute '" + key + "'");
			ex.initCause(e);
			throw ex;
		} catch (ArrayStoreException e) {
			ArrayStoreException ex = new ArrayStoreException("The value '" + value + "' of type '" + value.getClass() +"' is invalid for attribute '" + key + "'");
			ex.initCause(e);
			throw ex; 
		}
		return returnValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object remove(Object key) {
		if (!(key instanceof String)) 
			return null;
		String featureName = (String) key;
		EStructuralFeature eFeature = eClass().getEStructuralFeature(featureName);
		if (eFeature == null)
			return null;
		Object returnValue = eGet(eFeature);
		eUnset(eFeature);
		return returnValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void putAll(Map m) {
		for(Object key: m.keySet()) {
			Object value = m.get(key);
			put(key, value);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void clear() {
		for(EStructuralFeature eFeature: eClass().getEStructuralFeatures()) {
			eUnset(eFeature);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Set keySet() {
		Set ks = keySet;
		return (ks != null ? ks : (keySet = new KeySet()));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Collection values() {
		Collection vs = values;
		return (vs != null ? vs : (values = new Values()));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Set entrySet() {
		Set es = entrySet;
		return (es != null ? es : (entrySet = new EntrySet()));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CciPackageImpl.MAPPED_RECORD__RECORD_NAME:
				return getRecordName();
			case CciPackageImpl.MAPPED_RECORD__RECORD_SHORT_DESCRIPTION:
				return getRecordShortDescription();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CciPackageImpl.MAPPED_RECORD__RECORD_NAME:
				setRecordName((String)newValue);
				return;
			case CciPackageImpl.MAPPED_RECORD__RECORD_SHORT_DESCRIPTION:
				setRecordShortDescription((String)newValue);
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
			case CciPackageImpl.MAPPED_RECORD__RECORD_NAME:
				setRecordName(RECORD_NAME_EDEFAULT);
				return;
			case CciPackageImpl.MAPPED_RECORD__RECORD_SHORT_DESCRIPTION:
				setRecordShortDescription(RECORD_SHORT_DESCRIPTION_EDEFAULT);
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
			case CciPackageImpl.MAPPED_RECORD__RECORD_NAME:
				return RECORD_NAME_EDEFAULT == null ? recordName != null : !RECORD_NAME_EDEFAULT.equals(recordName);
			case CciPackageImpl.MAPPED_RECORD__RECORD_SHORT_DESCRIPTION:
				return RECORD_SHORT_DESCRIPTION_EDEFAULT == null ? recordShortDescription != null : !RECORD_SHORT_DESCRIPTION_EDEFAULT.equals(recordShortDescription);
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
	 * @param record
	 * @throws ResourceException
	 * @generated NOT
	 */
	public void put(JCoRecord record) throws ResourceException {

		if (record == null)
			return;
		
		JCoFieldIterator iterator = record.getFieldIterator();
		while(iterator.hasNextField()) {
			JCoField field = iterator.nextField();
			Object obj = get(field.getName());
			if (field.isStructure()) {
				if (obj == null || !(obj instanceof MappedRecordImpl))
					throw ExceptionBundle.EXCEPTIONS.invalidRecordTypeForStructureParameterInRecord(field.getName(), record.getMetaData().getName(), obj.getClass().getName());
				((MappedRecordImpl)obj).put(field.getStructure());
			} else if (field.isTable()) {
				if (obj == null || !(obj instanceof IndexedRecordImpl))
					throw ExceptionBundle.EXCEPTIONS.invalidRecordTypeForTableParameterInRecord(field.getName(), record.getMetaData().getName(), obj.getClass().getName());
				((IndexedRecordImpl)obj).put(field.getTable());
			} else {
				put(field.getName(), field.getValue());
			}
		}
	}
	
	/**
	 * @param record
	 * @throws ResourceException
	 * @generated NOT
	 */
	public void fill(JCoRecord record) throws ResourceException {
		
		if (record == null)
			return;
		
		JCoFieldIterator iterator = record.getFieldIterator();
		while(iterator.hasNextField()) {
			JCoField field = iterator.nextField();
			Object obj = get(field.getName());
			if (field.isStructure()) {
				if (obj == null || !(obj instanceof MappedRecordImpl))
					throw ExceptionBundle.EXCEPTIONS.invalidRecordTypeForStructureParameterInRecord(field.getName(), record.getMetaData().getName(), obj.getClass().getName());
				((MappedRecordImpl)obj).fill(field.getStructure());
			} else if (field.isTable()) {
				if (obj == null || !(obj instanceof IndexedRecordImpl))
					throw ExceptionBundle.EXCEPTIONS.invalidRecordTypeForTableParameterInRecord(field.getName(), record.getMetaData().getName(), obj.getClass().getName());
				((IndexedRecordImpl)obj).fill(field.getTable());
			} else {
				field.setValue(obj);
			}
		}
	}

} //MappedRecordImpl
