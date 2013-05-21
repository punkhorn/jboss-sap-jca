package org.jboss.jca.adapters.sap.cci.impl;

import javax.resource.ResourceException;
import javax.resource.cci.IndexedRecord;
import javax.resource.cci.MappedRecord;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.jboss.jca.adapters.sap.cci.RecordFactory;
import org.jboss.jca.adapters.sap.model.cci.CciFactory;
import org.jboss.jca.adapters.sap.model.edit.cci.RecordFactoryItemProvider;
import org.jboss.jca.adapters.sap.util.EditingSupport;
import org.jboss.jca.adapters.sap.util.RecordUtil;

public class RecordFactoryImpl extends RecordFactoryItemProvider implements RecordFactory {

	private EditingSupport<org.jboss.jca.adapters.sap.model.cci.RecordFactory> editingSupport = new EditingSupport<org.jboss.jca.adapters.sap.model.cci.RecordFactory>(
			this);

	public RecordFactoryImpl() {
		super(CciJcaAdapterFactory.INSTANCE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IndexedRecord createIndexedRecord(String recordName) throws ResourceException {
		editingSupport.getReadLock().lock();
		try {
			if (editingSupport.getModel().getConnectionFactory() == null
					|| editingSupport.getModel().getConnectionFactory().getManagedConnectionFactory() == null
					|| editingSupport.getModel().getConnectionFactory().getManagedConnectionFactory()
							.getDefaultConnectionName() == null) {
				return null;
			}
			String connectionName = editingSupport.getModel().getConnectionFactory().getManagedConnectionFactory()
					.getDefaultConnectionName();
			Object obj = editingSupport.wrap(RecordUtil.createRecord(connectionName, recordName));
			if (!(obj instanceof IndexedRecord)) {
				return null;
			}
			return (IndexedRecord) obj;
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MappedRecord createMappedRecord(String recordName) throws ResourceException {
		editingSupport.getReadLock().lock();
		try {
			if (editingSupport.getModel().getConnectionFactory() == null
					|| editingSupport.getModel().getConnectionFactory().getManagedConnectionFactory() == null
					|| editingSupport.getModel().getConnectionFactory().getManagedConnectionFactory()
							.getDefaultConnectionName() == null) {
				return null;
			}
			String connectionName = editingSupport.getModel().getConnectionFactory().getManagedConnectionFactory()
					.getDefaultConnectionName();
			Object obj = editingSupport.wrap(RecordUtil.createRecord(connectionName, recordName));
			if (!(obj instanceof MappedRecord)) {
				return null;
			}
			return (MappedRecord) obj;
		} finally {
			editingSupport.getReadLock().unlock();
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
		return CciFactory.eINSTANCE.createRecordFactory();
	}
}
