package org.jboss.jca.adapters.sap.cci.impl;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.jboss.jca.adapters.sap.cci.InteractionSpec;
import org.jboss.jca.adapters.sap.model.cci.CciFactory;
import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.edit.cci.InteractionSpecItemProvider;
import org.jboss.jca.adapters.sap.util.EditingSupport;

public class InteractionSpecImpl extends InteractionSpecItemProvider implements InteractionSpec {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2384945565087934072L;
	
	protected EditingSupport<org.jboss.jca.adapters.sap.model.cci.InteractionSpec> editingSupport = new EditingSupport<org.jboss.jca.adapters.sap.model.cci.InteractionSpec>(
			this);

	public InteractionSpecImpl() {
		super(CciJcaAdapterFactory.INSTANCE);
	}

	@Override
	public String getFunctionName() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getFunctionName();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setFunctionName(String value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.INTERACTION_SPEC__FUNCTION_NAME, value);
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
	public int getInteractionVerb() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getInteractionVerb();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setInteractionVerb(int value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.INTERACTION_SPEC__INTERACTION_VERB, value);
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
	public int getExecutionTimeout() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getExecutionTimeout();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setExecutionTimeout(int value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.INTERACTION_SPEC__EXECUTION_TIMEOUT, value);
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
		return CciFactory.eINSTANCE.createInteractionSpec();
	}
}
