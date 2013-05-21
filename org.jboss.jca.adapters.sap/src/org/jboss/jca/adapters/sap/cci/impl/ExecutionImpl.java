package org.jboss.jca.adapters.sap.cci.impl;

import org.jboss.jca.adapters.sap.cci.Execution;
import org.jboss.jca.adapters.sap.cci.InteractionSpec;
import org.jboss.jca.adapters.sap.cci.MappedRecord;
import org.jboss.jca.adapters.sap.model.edit.cci.ExecutionItemProvider;
import org.jboss.jca.adapters.sap.util.EditingSupport;

public class ExecutionImpl extends ExecutionItemProvider implements Execution {
	
	protected EditingSupport<org.jboss.jca.adapters.sap.model.cci.Execution> editingSupport = new EditingSupport<org.jboss.jca.adapters.sap.model.cci.Execution>(
			this);

	public ExecutionImpl() {
		super(CciJcaAdapterFactory.INSTANCE);
	}

	@Override
	public InteractionSpec getInteractionSpec() {
		editingSupport.getReadLock().lock();
		try {
			return (InteractionSpec) editingSupport.wrap(editingSupport.getModel().getInteractionSpec());
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public MappedRecord getInputRecord() {
		editingSupport.getReadLock().lock();
		try {
			return (MappedRecord) editingSupport.wrap(editingSupport.getModel().getInputRecord());
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public MappedRecord getOutputRecord() {
		editingSupport.getReadLock().lock();
		try {
			return (MappedRecord) editingSupport.wrap(editingSupport.getModel().getOutputRecord());
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

}
