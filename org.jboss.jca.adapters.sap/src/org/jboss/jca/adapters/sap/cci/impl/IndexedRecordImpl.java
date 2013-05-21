package org.jboss.jca.adapters.sap.cci.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.jboss.jca.adapters.sap.cci.IndexedRecord;
import org.jboss.jca.adapters.sap.cci.MappedRecord;
import org.jboss.jca.adapters.sap.command.ClearIndexedRecordCommand;
import org.jboss.jca.adapters.sap.command.RemoveAtIndexFromIndexedRecordCommand;
import org.jboss.jca.adapters.sap.command.RetainValuesInIndexedRecordCommand;
import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.edit.cci.IndexedRecordItemProvider;
import org.jboss.jca.adapters.sap.util.EditingSupport;

public class IndexedRecordImpl extends IndexedRecordItemProvider implements IndexedRecord {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2296683342307564094L;
	
	public class RecordIterator implements Iterator<MappedRecord> {
		
		Iterator<? extends org.jboss.jca.adapters.sap.model.cci.MappedRecord> iterator;
		org.jboss.jca.adapters.sap.model.cci.MappedRecord current;
		
		public RecordIterator() {
			iterator = editingSupport.getModel().getRecords().iterator();
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
		
		@Override
		public MappedRecord next() {
			editingSupport.getReadLock().lock();
			try {
				current = iterator.next();
				return (MappedRecord) editingSupport.wrap(current); 
			} finally {
				editingSupport.getReadLock().unlock();
			}
		}

		@Override
		public void remove() {
			editingSupport.getWriteLock().lock();
			editingSupport.beginTransaction();
			try {
				Command command = RemoveCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.INDEXED_RECORD__RECORDS, current);
				editingSupport.getCommandStack().execute(command);
				editingSupport.commitTransaction();
			} catch (Throwable t) {
				editingSupport.rollbackTransaction();
				throw new RuntimeException(t);
			} finally {
				editingSupport.getWriteLock().unlock();
			}
		}
		
	}
	
	public class RecordListIterator implements ListIterator<MappedRecord> {
		
		ListIterator<? extends org.jboss.jca.adapters.sap.model.cci.MappedRecord> iterator;
		org.jboss.jca.adapters.sap.model.cci.MappedRecord current;
		
		public RecordListIterator() {
			iterator = editingSupport.getModel().getRecords().listIterator();
		}

		public RecordListIterator(int index) {
			iterator = editingSupport.getModel().getRecords().listIterator(index);
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

		@Override
		public MappedRecord next() {
			editingSupport.getReadLock().lock();
			try {
				current = iterator.next();
				return (MappedRecord) editingSupport.wrap(current);
			} finally {
				editingSupport.getReadLock().unlock();
			}
		}

		@Override
		public boolean hasPrevious() {
			editingSupport.getReadLock().lock();
			try {
				return iterator.hasPrevious();
			} finally {
				editingSupport.getReadLock().unlock();
			}
		}

		@Override
		public MappedRecord previous() {
			editingSupport.getReadLock().lock();
			try {
				current = iterator.previous();
				return (MappedRecord) editingSupport.wrap(current);
			} finally {
				editingSupport.getReadLock().unlock();
			}
		}

		@Override
		public int nextIndex() {
			editingSupport.getReadLock().lock();
			try {
				return iterator.nextIndex();
			} finally {
				editingSupport.getReadLock().unlock();
			}
		}

		@Override
		public int previousIndex() {
			editingSupport.getReadLock().lock();
			try {
				return iterator.previousIndex();
			} finally {
				editingSupport.getReadLock().unlock();
			}
		}

		@Override
		public void remove() {
			editingSupport.getWriteLock().lock();
			try {
				IndexedRecordImpl.this.remove(current);
			} finally {
				editingSupport.getWriteLock().unlock();
			}
		}

		@Override
		public void set(MappedRecord e) {
			editingSupport.getWriteLock().lock();
			try {
				int index = iterator.previousIndex() + 1;
				IndexedRecordImpl.this.set(index, e);
			} finally {
				editingSupport.getWriteLock().unlock();
			}
		}

		@Override
		public void add(MappedRecord e) {
			editingSupport.getWriteLock().lock();
			try {
				int index = iterator.previousIndex() + 1;
				IndexedRecordImpl.this.add(index, e);
			} finally {
				editingSupport.getWriteLock().unlock();
			}
		}
		
	}

	protected EditingSupport<org.jboss.jca.adapters.sap.model.cci.IndexedRecord<? extends org.jboss.jca.adapters.sap.model.cci.MappedRecord>> editingSupport = new EditingSupport<org.jboss.jca.adapters.sap.model.cci.IndexedRecord<? extends org.jboss.jca.adapters.sap.model.cci.MappedRecord>>(this);

	public IndexedRecordImpl() {
		super(CciJcaAdapterFactory.INSTANCE);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			EObject indexedRecordModel = EcoreUtil.copy(editingSupport.getModel());
			Object clone = editingSupport.wrap(indexedRecordModel);
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
			if (!(other instanceof IndexedRecordImpl))
				return false;
			EObject otherModel = ((IndexedRecordImpl)other).editingSupport.getModel();
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
			return editingSupport.getModel().getRecords().size();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public boolean isEmpty() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getRecords().size() == 0;
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public boolean contains(Object o) {
		editingSupport.getReadLock().lock();
		try {
			o = unwrap(o);
			return editingSupport.getModel().getRecords().contains(o);
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Iterator iterator() {
		editingSupport.getReadLock().lock();
		try {
			return new RecordIterator();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public Object[] toArray() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.wrap(editingSupport.getModel().getRecords()).toArray();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] toArray(Object[] a) {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.wrap(editingSupport.getModel().getRecords()).toArray(a);
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public boolean add(Object e) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = AddCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.INDEXED_RECORD__RECORDS, unwrap(e));
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
			return true;
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			return false;
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public boolean remove(Object o) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = RemoveCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.INDEXED_RECORD__RECORDS, unwrap(o));
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
			return true;
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			return false;
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public boolean containsAll(@SuppressWarnings("rawtypes") Collection c) {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getRecords().containsAll(editingSupport.unwrap(c));
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public boolean addAll(@SuppressWarnings("rawtypes") Collection c) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = AddCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.INDEXED_RECORD__RECORDS, unwrap(c));
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
			return true;
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			return false;
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public boolean addAll(int index, @SuppressWarnings("rawtypes") Collection c) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = AddCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.INDEXED_RECORD__RECORDS, unwrap(c), index);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
			return true;
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			return false;
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public boolean removeAll(@SuppressWarnings("rawtypes") Collection c) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = RemoveCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.INDEXED_RECORD__RECORDS, unwrap(c));
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
			return true;
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			return false;
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public boolean retainAll(@SuppressWarnings("rawtypes") Collection c) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = new RetainValuesInIndexedRecordCommand(editingSupport.getEditingDomain(), editingSupport.getModel(), null, editingSupport.unwrap(c));
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
			return true;
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			return false;
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public void clear() {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = new ClearIndexedRecordCommand(editingSupport.getEditingDomain(), editingSupport.getModel(), null, null);
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
	public Object get(int index) {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.wrap(editingSupport.getModel().getRecords().get(index));
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public Object set(int index, Object element) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Object returnValue = editingSupport.wrap(editingSupport.getModel().getRecords().get(index));
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.INDEXED_RECORD__RECORDS, unwrap(element), index);
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
	public void add(int index, Object element) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = AddCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.INDEXED_RECORD__RECORDS, unwrap(element), index);
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
	public Object remove(int index) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Object returnValue = editingSupport.wrap(editingSupport.getModel().getRecords().get(index));
			Command command = new RemoveAtIndexFromIndexedRecordCommand(editingSupport.getEditingDomain(), editingSupport.getModel(), null, index);
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
	public int indexOf(Object o) {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getRecords().indexOf(unwrap(0));
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public int lastIndexOf(Object o) {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getRecords().lastIndexOf(unwrap(0));
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ListIterator listIterator() {
		return new RecordListIterator();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ListIterator listIterator(int index) {
		return new RecordListIterator(index);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List subList(int fromIndex, int toIndex) {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.wrap(editingSupport.getModel().getRecords().subList(fromIndex, toIndex));
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}
}
