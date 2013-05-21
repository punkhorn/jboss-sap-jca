package org.jboss.jca.adapters.sap.spi.impl;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.jca.adapters.sap.command.RemovePackageCommand;
import org.jboss.jca.adapters.sap.model.edit.spi.PackageRegistryItemProvider;
import org.jboss.jca.adapters.sap.model.spi.PackageRegistry;
import org.jboss.jca.adapters.sap.model.spi.SpiFactory;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;
import org.jboss.jca.adapters.sap.util.EditingSupport;
import org.jboss.jca.adapters.sap.util.RecordUtil;

public class PackageRegistryImpl extends PackageRegistryItemProvider implements EPackage.Registry {

	private abstract class BaseIterator<E> implements Iterator<E> {

		Iterator<Entry<String, EPackage>> iterator;
		Entry<String, Object> current;

		public BaseIterator() {
			this.iterator = editingSupport.getModel().getPackages().iterator();
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

		@SuppressWarnings({ "unchecked", "rawtypes" })
		final Entry<String, Object> nextEntry() {
			editingSupport.getReadLock().lock();
			try {
				current = (Entry) iterator.next();
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
				String key = current.getKey();
				current = null;
				PackageRegistryImpl.this.remove(key);
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
				return nextEntry().getKey();
			} finally {
				editingSupport.getReadLock().unlock();
			}
		}
		
	}
	
	private final class ValueIterator extends BaseIterator<Object> {

		@Override
		public EPackage next() {
			editingSupport.getReadLock().lock();
			try {
				return (EPackage) nextEntry().getValue();
			} finally {
				editingSupport.getReadLock().unlock();
			}
		}
		
	}
	
	private final class EntryIterator extends BaseIterator<Entry<String,Object>> {

		@Override
		public java.util.Map.Entry<String, Object> next() {
			editingSupport.getReadLock().lock();
			try {
				return nextEntry();
			} finally {
				editingSupport.getReadLock().unlock();
			}
		}
		
	}
	
	private final class EntrySet extends AbstractSet<Entry<String,Object>> {

		@Override
		public Iterator<java.util.Map.Entry<String, Object>> iterator() {
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
				Map.Entry<String, EPackage> entry = (Map.Entry<String, EPackage>) o;
				EPackage ePackage = editingSupport.getModel().getPackages().get(entry.getKey());
				return ePackage != null && entry.getValue().equals(ePackage);
			} finally {
				editingSupport.getReadLock().unlock();
			}
		}
		
		@Override
		public boolean remove(Object o) {
			editingSupport.getWriteLock().lock();
			try {
				if (contains(o)) {
					PackageRegistryImpl.this.remove(o);
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
			return PackageRegistryImpl.this.size();
		}
		
		@Override
		public void clear() {
			PackageRegistryImpl.this.clear();
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
			return PackageRegistryImpl.this.size();
		}
		
		@Override
		public boolean contains(Object o) {
			return PackageRegistryImpl.this.containsKey(o);
		}
		
		@Override
		public void clear() {
			PackageRegistryImpl.this.clear();
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
			return PackageRegistryImpl.this.size();
		}

		@Override
		public boolean contains(Object o) {
			return PackageRegistryImpl.this.containsKey(o);
		}

		@Override
		public boolean remove(Object o) {
			editingSupport.getWriteLock().lock();
			try {
				if (contains(o)) {
					PackageRegistryImpl.this.remove(o);
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
			PackageRegistryImpl.this.clear();
		}

	}

	private EditingSupport<org.jboss.jca.adapters.sap.model.spi.PackageRegistry> editingSupport = new EditingSupport<org.jboss.jca.adapters.sap.model.spi.PackageRegistry>(this);

	public PackageRegistryImpl() {
		super(SpiJcaAdapterFactory.INSTANCE);
	}

	@Override
	public int size() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getPackages().size();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public boolean isEmpty() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getPackages().size() == 0;
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public boolean containsKey(Object key) {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getPackages().containsKey(key);
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public boolean containsValue(Object value) {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getPackages().containsValue(value);
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public Object get(Object key) {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getPackages().get(key);
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public Object put(String key, Object value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Object rtn = editingSupport.getModel().getPackages().get(key);
			@SuppressWarnings("unchecked")
			BasicEMap.Entry<String, EPackage> entry = (BasicEMap.Entry<String, EPackage>) EcoreUtil
					.create(SpiPackage.Literals.PACKAGE_REGISTRY_ENTRY);
			entry.setKey(key);
			entry.setValue((EPackage) value);
			Command command = AddCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(),
					SpiPackage.Literals.PACKAGE_REGISTRY__PACKAGES, entry);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
			return rtn;
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
			Object rtn = editingSupport.getModel().getPackages().get(key);
			Command command = RemoveCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(),
					SpiPackage.Literals.PACKAGE_REGISTRY__PACKAGES, key);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
			return rtn;
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = AddCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(),
					SpiPackage.Literals.PACKAGE_REGISTRY__PACKAGES, m);
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
			EMap<String, EPackage> packages = editingSupport.getModel().getPackages();
			Command command = RemoveCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(),
					SpiPackage.Literals.PACKAGE_REGISTRY__PACKAGES, packages);
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
	public Set<String> keySet() {
		editingSupport.getReadLock().lock();
		try {
			return new KeySet();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public Collection<Object> values() {
		editingSupport.getReadLock().lock();
		try {
			return new ValueSet();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		editingSupport.getReadLock().lock();
		try {
			return new EntrySet();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public EPackage getEPackage(String nsURI) {
		editingSupport.getWriteLock().lock();
		try {
			String connectionName = editingSupport.getModel().getManagedConnectionFactory().getDefaultConnectionName();
			return RecordUtil.getEPackage(connectionName, nsURI);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public EFactory getEFactory(String nsURI) {
		editingSupport.getWriteLock().lock();
		try {
			String connectionName = editingSupport.getModel().getManagedConnectionFactory().getDefaultConnectionName();
			return RecordUtil.getEFactory(connectionName, nsURI);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public Notifier getTarget() {
		if (target == null) {
			synchronized (this) {
				if (target == null) {
					target = initializeModel();
					target.eAdapters().add(this);
				}
			}
		}
		return target;
	}

	protected EObject initializeModel() {
		return SpiFactory.eINSTANCE.createPackageRegistry();
	}

	@Override
	protected Command createRemoveCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection<?> collection) {
		if (feature == SpiPackage.Literals.PACKAGE_REGISTRY__PACKAGES) {
			return new RemovePackageCommand(domain, (PackageRegistry) owner, feature, collection);
		}
		return super.createRemoveCommand(domain, owner, feature, collection);
	}
}
