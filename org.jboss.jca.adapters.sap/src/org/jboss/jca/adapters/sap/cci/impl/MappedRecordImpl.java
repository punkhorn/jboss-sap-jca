package org.jboss.jca.adapters.sap.cci.impl;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.jca.adapters.sap.cci.MappedRecord;
import org.jboss.jca.adapters.sap.command.RemoveValuesFromRecordCommand;
import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.edit.cci.MappedRecordItemProvider;
import org.jboss.jca.adapters.sap.util.EditingSupport;

public class MappedRecordImpl extends MappedRecordItemProvider implements MappedRecord {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7362742212685087334L;

	public static class Entry implements Map.Entry<String,Object> {
		
		private String key;
		private Object value;
		
		Entry(String key, Object value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String getKey() {
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
            @SuppressWarnings("unchecked")
			Map.Entry<String,Object> e = (Map.Entry<String,Object>)o;
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

	private abstract class BaseIterator<E> implements Iterator<E> {

		Iterator<EStructuralFeature> iterator;
		EStructuralFeature current;

		public BaseIterator() {
			this.iterator = editingSupport.getModel().eClass().getEAllStructuralFeatures().iterator();
		}

		@Override
		public boolean hasNext() {
			editingSupport.getReadLock().lock();
			try {
				return iterator.hasNext();
			} finally {
				editingSupport.getReadLock().unlock();
			}
		}

		final EStructuralFeature nextEntry() {
			editingSupport.getReadLock().lock();
			try {
				current = (EStructuralFeature) iterator.next();
				return current;
			} finally {
				editingSupport.getReadLock().unlock();
			}
		}

		@Override
		public void remove() {
			editingSupport.getWriteLock().lock();
			try {
				if (current == null)
					throw new IllegalStateException();
				MappedRecordImpl.this.remove(current.getName());
				current = null;
			} finally {
				editingSupport.getWriteLock().unlock();
			}
		}

	}
	
	private final class KeyIterator extends BaseIterator<String> {

		@Override
		public String next() {
			editingSupport.getReadLock().lock();
			try {
				return nextEntry().getName();
			} finally {
				editingSupport.getReadLock().unlock();
			}
		}
		
	}
	
	private final class ValueIterator extends BaseIterator<Object> {

		@Override
		public Object next() {
			editingSupport.getReadLock().lock();
			try {
				return MappedRecordImpl.this.get(nextEntry().getName());
			} finally {
				editingSupport.getReadLock().unlock();
			}
		}
		
	}
	
	private final class EntryIterator extends BaseIterator<Entry> {

		@Override
		public Entry next() {
			editingSupport.getReadLock().lock();
			try {
				EStructuralFeature feature = nextEntry();
				Object value = MappedRecordImpl.this.get(feature.getName());
				return new Entry(feature.getName(), value);
			} finally {
				editingSupport.getReadLock().unlock();
			}
		}
		
	}
	
	private final class EntrySet extends AbstractSet<Entry> {

		@Override
		public Iterator<Entry> iterator() {
			return new EntryIterator();
		}
		
		@Override
		public boolean contains(Object o) {
			editingSupport.getReadLock().lock();
			try {
				if (!(o instanceof Map.Entry)) {
					return false;
				}
				@SuppressWarnings("unchecked")
				Map.Entry<String, Object> entry = (Map.Entry<String, Object>) o;
				Object value = MappedRecordImpl.this.get(entry.getKey());
				return value != null;
			} finally {
				editingSupport.getReadLock().unlock();
			}
		}
		
		@Override
		public boolean remove(Object o) {
			editingSupport.getWriteLock().lock();
			try {
				if (contains(o)) {
					MappedRecordImpl.this.remove(o);
					return true;
				} else {
					return false;
				}
			} finally {
				editingSupport.getWriteLock().unlock();
			}
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
	
	private final class ValueSet extends AbstractCollection<Object> {

		@Override
		public Iterator<Object> iterator() {
			editingSupport.getReadLock().lock();
			try {
				return new ValueIterator();
			} finally {
				editingSupport.getReadLock().unlock();
			}
		}

		@Override
		public int size() {
			return MappedRecordImpl.this.size();
		}
		
		@Override
		public boolean contains(Object o) {
			return MappedRecordImpl.this.containsKey(o);
		}
		
		@Override
		public void clear() {
			MappedRecordImpl.this.clear();
		}
	}

	private final class KeySet extends AbstractSet<String> {

		@Override
		public Iterator<String> iterator() {
			editingSupport.getReadLock().lock();
			try {
				return new KeyIterator();
			} finally {
				editingSupport.getReadLock().unlock();
			}
		}

		@Override
		public int size() {
			return MappedRecordImpl.this.size();
		}

		@Override
		public boolean contains(Object o) {
			return MappedRecordImpl.this.containsKey(o);
		}

		@Override
		public boolean remove(Object o) {
			editingSupport.getWriteLock().lock();
			try {
				if (contains(o)) {
					MappedRecordImpl.this.remove(o);
					return true;
				} else {
					return false;
				}
			} finally {
				editingSupport.getWriteLock().unlock();
			}
		}

		@Override
		public void clear() {
			MappedRecordImpl.this.clear();
		}

	}

	protected EditingSupport<org.jboss.jca.adapters.sap.model.cci.MappedRecord> editingSupport = new EditingSupport<org.jboss.jca.adapters.sap.model.cci.MappedRecord>(this);

	public MappedRecordImpl() {
		super(CciJcaAdapterFactory.INSTANCE);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			EObject mappedRecordModel = EcoreUtil.copy(editingSupport.getModel());
			Object clone = editingSupport.wrap(mappedRecordModel);
			editingSupport.commitTransaction();
			return clone;
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			CloneNotSupportedException e = new CloneNotSupportedException();
			e.initCause(t);
			throw e;
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public int hashCode() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().hashCode();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public boolean equals(Object other) {
		editingSupport.getReadLock().lock();
		try {
			if (other == this) 
				return true;
			if (!(other instanceof MappedRecordImpl))
				return false;
			EObject otherModel = (EObject) editingSupport.unwrap(other);
			EObject myModel = editingSupport.getModel();
			return EcoreUtil.equals(myModel, otherModel);
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public String getRecordName() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getRecordName();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public String getRecordShortDescription() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getRecordDescription();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setRecordName(String name) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.RECORD__RECORD_NAME, name);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public void setRecordShortDescription(String description) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.RECORD__RECORD_DESCRIPTION, description);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public int size() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().eClass().getFeatureCount();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public boolean isEmpty() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().eClass().getFeatureCount() == 0;
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public boolean containsKey(Object key) {
		editingSupport.getReadLock().lock();
		try {
			if (!(key instanceof String)) 
				return false;
			String featureName = (String) key;
			return editingSupport.getModel().eClass().getEStructuralFeature(featureName) == null ? false : true;
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public boolean containsValue(Object value) {
		editingSupport.getReadLock().lock();
		try {
			EObject model = editingSupport.getModel();
			for(EStructuralFeature eFeature: model.eClass().getEStructuralFeatures()) {
				if (model.eGet(eFeature).equals(editingSupport.unwrap(value)))
					return true;
			}
			return false;
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public Object get(Object key) {
		editingSupport.getReadLock().lock();
		try {
			if (!(key instanceof String)) 
				return null;
			String featureName = (String) key;
			EObject model = editingSupport.getModel();
			EStructuralFeature eFeature = model.eClass().getEStructuralFeature(featureName);
			if (eFeature == null)
				return null;
			Object retValue = model.eGet(eFeature);
			if(retValue == null && eFeature.getEType() instanceof EClass) {
				EClass recordClass = (EClass) eFeature.getEType();
				if(CciPackage.eINSTANCE.getMappedRecord().isSuperTypeOf(recordClass) || CciPackage.eINSTANCE.getIndexedRecord().isSuperTypeOf(recordClass)) {
					EObject record = model.eClass().getEPackage().getEFactoryInstance().create(recordClass);
					record.eSet(CciPackage.Literals.RECORD__RECORD_NAME, featureName);
					editingSupport.getReadLock().unlock();
					put(key, record);
					editingSupport.getReadLock().lock();
					retValue = record;
				}
			}
			return editingSupport.wrap(retValue);
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public Object put(Object key, Object value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			if (key == null) 
				throw new NullPointerException("Key can not be null");
			if (!(key instanceof String)) 
				throw new ClassCastException("Key '" + key + "' must be a string");
			String featureName = (String) key;
			EObject model = editingSupport.getModel();
			EStructuralFeature eFeature = model.eClass().getEStructuralFeature(featureName);
			if (eFeature == null)
				throw new IllegalArgumentException("Key '" + key + "' is not a valid attribute name for this record");
			Object returnValue = editingSupport.wrap(model.eGet(eFeature));
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), eFeature, editingSupport.unwrap(value));
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
			return returnValue;
		} catch (IllegalArgumentException e) {
			editingSupport.rollbackTransaction();
			throw new IllegalArgumentException("Key '" + key + "' is not a valid attribute name for this record", e);
		} catch (ClassCastException e) {
			editingSupport.rollbackTransaction();
			ClassCastException ex = new ClassCastException("The value '" + value + "' of type '" + value.getClass() +"' is invalid for attribute '" + key + "'");
			ex.initCause(e);
			throw ex;
		} catch (ArrayStoreException e) {
			editingSupport.rollbackTransaction();
			ArrayStoreException ex = new ArrayStoreException("The value '" + value + "' of type '" + value.getClass() +"' is invalid for attribute '" + key + "'");
			ex.initCause(e);
			throw ex; 
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public Object remove(Object key) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			if (!(key instanceof String)) 
				return null;
			String featureName = (String) key;
			EObject model = editingSupport.getModel();
			EStructuralFeature eFeature = model.eClass().getEStructuralFeature(featureName);
			if (eFeature == null)
				return null;
			Object returnValue = editingSupport.wrap(model.eGet(eFeature));
			Command command = RemoveCommand.create(editingSupport.getEditingDomain(), model, null, Collections.singleton(eFeature));
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
			return returnValue;
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public void putAll(@SuppressWarnings("rawtypes") Map m) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = AddCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), null, editingSupport.wrap(m));
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public void clear() {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			EObject model = editingSupport.getModel();
			Command command = RemoveCommand.create(editingSupport.getEditingDomain(), model, null, model.eClass().getEAllStructuralFeatures());
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Set keySet() {
		return new KeySet();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Collection values() {
		return new ValueSet();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Set entrySet() {
		return new EntrySet();
	}

	@Override
	protected Command createAddCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection<?> collection, int index) {
		return new RemoveValuesFromRecordCommand(domain, (org.jboss.jca.adapters.sap.model.cci.MappedRecord) owner, feature, collection);
	}

	@Override
	protected Command createRemoveCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection<?> collection) {
		return new RemoveValuesFromRecordCommand(domain, (org.jboss.jca.adapters.sap.model.cci.MappedRecord) owner, feature, collection);
	}
}
