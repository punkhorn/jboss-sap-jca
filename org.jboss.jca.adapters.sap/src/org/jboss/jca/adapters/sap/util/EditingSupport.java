package org.jboss.jca.adapters.sap.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.jboss.jca.adapters.sap.cci.impl.CciJcaAdapterFactory;
import org.jboss.jca.adapters.sap.command.TransactionalCommandStack;
import org.jboss.jca.adapters.sap.model.cci.Connection;
import org.jboss.jca.adapters.sap.model.cci.ConnectionFactory;
import org.jboss.jca.adapters.sap.model.cci.ConnectionSpec;
import org.jboss.jca.adapters.sap.model.cci.Execution;
import org.jboss.jca.adapters.sap.model.cci.IndexedRecord;
import org.jboss.jca.adapters.sap.model.cci.Interaction;
import org.jboss.jca.adapters.sap.model.cci.InteractionSpec;
import org.jboss.jca.adapters.sap.model.cci.MappedRecord;
import org.jboss.jca.adapters.sap.model.cci.RecordFactory;
import org.jboss.jca.adapters.sap.model.cci.util.CciSwitch;
import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfoStore;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnection;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.model.spi.util.SpiSwitch;
import org.jboss.jca.adapters.sap.spi.ResourceAdapter;
import org.jboss.jca.adapters.sap.spi.impl.SpiJcaAdapterFactory;

public class EditingSupport<T extends EObject> {
	
	private Adapter adapter;

	public EditingSupport(Adapter adapter) {
		this.adapter = adapter;
	}

	@SuppressWarnings("unchecked")
	public T getModel() {
		return (T) adapter.getTarget();
	}

	public Lock getReadLock() {
		return getCommandStack().getReadLock();
	}

	public Lock getWriteLock() {
		return getCommandStack().getWriteLock();
	}

	public void beginTransaction() {
		getCommandStack().begin();
	}

	public void commitTransaction() {
		getCommandStack().commit();
	}

	public void rollbackTransaction() {
		getCommandStack().rollback();
	}

	/**
	 * Returns the {@link TransactionalCommandStack} used by this
	 * {@link ResourceAdapter}.
	 * 
	 * @return the {@link TransactionalCommandStack} used by this
	 *         {@link ResourceAdapter}.
	 */
	public TransactionalCommandStack getCommandStack() {
		return JcaEditingDomainSupport.INSTANCE.getCommandStack();
	}

	/**
	 * Returns the {@link AdapterFactoryEditingDomain} used by this
	 * {@link ResourceAdapter}.
	 * 
	 * @return the {@link AdapterFactoryEditingDomain} used by this
	 *         {@link ResourceAdapter}.
	 */
	public AdapterFactoryEditingDomain getEditingDomain() {
		return JcaEditingDomainSupport.INSTANCE.getEditingDomain();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map wrap(Map map) {
		Map wrappedMap = new HashMap();
		for (Object obj : map.entrySet()) {
			Map.Entry entry = (Map.Entry) obj;
			wrappedMap.put(entry.getKey(), wrap(entry.getValue()));
		}
		return wrappedMap;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Collection wrap(Collection collection) {
		Collection wrappedCollection = new HashSet();
		for (Object object : collection) {
			wrappedCollection.add(wrap(object));
		}
		return wrappedCollection;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List wrap(List list) {
		List wrappedList = new ArrayList();
		for (Object object : list) {
			wrappedList.add(wrap(object));
		}
		return wrappedList;
	}
	
	public Object wrap(Object object) {
		if (object instanceof Notifier) {
			if (SpiJcaAdapterFactory.INSTANCE.isFactoryForType(object)) {
				Class<?> clazz = spiModelSwitch.doSwitch((EObject) object);
				if (clazz != null) {
					return getEditingDomain().getAdapterFactory().adapt(object, clazz);
				}
			}
			if (CciJcaAdapterFactory.INSTANCE.isFactoryForType(object)) {
				Class<?> clazz = cciModelSwitch.doSwitch((EObject) object);
				if (clazz != null) {
					return getEditingDomain().getAdapterFactory().adapt(object, clazz);
				}
			}
		}
		return object;
	}

	public Object adapt(Object object) {
		Object wrappedObject = wrap(object);
		if (wrappedObject == object) {
			return null;
		} 
		return wrappedObject;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Collection unwrap(Collection collection) {
		Collection unwrappedCollection = new HashSet();
		for (Object object : collection) {
			unwrappedCollection.add(unwrap(object));
		}
		return unwrappedCollection;
	}

	public Object unwrap(Object object) {
		if (object instanceof Adapter) {
			return ((Adapter) object).getTarget();
		}
		return object;
	}

	public Object unadapt(Object object) {
		if (object instanceof Adapter) {
			return ((Adapter) object).getTarget();
		}
		return null;
	}

	protected CciSwitch<Class<?>> cciModelSwitch = new CciSwitch<Class<?>>() {
		@Override
		public Class<?> caseConnectionFactory(ConnectionFactory object) {
			return org.jboss.jca.adapters.sap.cci.ConnectionFactory.class;
		}

		@Override
		public Class<?> caseConnection(Connection object) {
			return org.jboss.jca.adapters.sap.cci.Connection.class;
		}

		@Override
		public Class<?> caseConnectionSpec(ConnectionSpec object) {
			return org.jboss.jca.adapters.sap.cci.ConnectionSpec.class;
		}

		@Override
		public Class<?> caseInteraction(Interaction object) {
			return org.jboss.jca.adapters.sap.cci.Interaction.class;
		}

		@Override
		public Class<?> caseExecution(Execution object) {
			return org.jboss.jca.adapters.sap.cci.Execution.class;
		}

		@Override
		public Class<?> caseInteractionSpec(InteractionSpec object) {
			return org.jboss.jca.adapters.sap.cci.InteractionSpec.class;
		}

		@Override
		public Class<?> caseRecordFactory(RecordFactory object) {
			return org.jboss.jca.adapters.sap.cci.RecordFactory.class;
		}

		@Override
		public Class<?> caseMappedRecord(MappedRecord object) {
			return org.jboss.jca.adapters.sap.cci.MappedRecord.class;
		}

		@Override
		public <R extends MappedRecord> Class<?> caseIndexedRecord(IndexedRecord<R> object) {
			return org.jboss.jca.adapters.sap.cci.IndexedRecord.class;
		}
	};

	protected SpiSwitch<Class<?>> spiModelSwitch = new SpiSwitch<Class<?>>() {
		@Override
		public Class<?> caseConnectionRequestInfo(ConnectionRequestInfo object) {
			return org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo.class;
		}

		@Override
		public Class<?> caseConnectionRequestInfoStore(ConnectionRequestInfoStore object) {
			return org.jboss.jca.adapters.sap.spi.ConnectionRequestInfoStore.class;
		}

		@Override
		public Class<?> caseConnectionRequestInfoStoreEntry(Map.Entry<String, ConnectionRequestInfo> object) {
			return org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo.class;
		}

		@Override
		public Class<?> caseManagedConnectionFactory(ManagedConnectionFactory object) {
			return org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory.class;
		}

		@Override
		public Class<?> caseManagedConnection(ManagedConnection object) {
			return org.jboss.jca.adapters.sap.spi.ManagedConnection.class;
		}

		@Override
		public Class<?> caseResourceAdapter(org.jboss.jca.adapters.sap.model.spi.ResourceAdapter object) {
			return org.jboss.jca.adapters.sap.spi.ResourceAdapter.class;
		}
	};
}
