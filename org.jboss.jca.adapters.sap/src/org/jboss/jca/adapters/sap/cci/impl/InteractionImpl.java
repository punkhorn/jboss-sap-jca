package org.jboss.jca.adapters.sap.cci.impl;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.InteractionSpec;
import javax.resource.cci.Record;
import javax.resource.cci.ResourceWarning;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.SetCommand;
import org.jboss.jca.adapters.sap.cci.Interaction;
import org.jboss.jca.adapters.sap.cci.MappedRecord;
import org.jboss.jca.adapters.sap.command.AddExecutionCommand;
import org.jboss.jca.adapters.sap.command.ExtractJCoRecordIntoMappedRecordCommand;
import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.cci.InteractionState;
import org.jboss.jca.adapters.sap.model.edit.cci.InteractionItemProvider;
import org.jboss.jca.adapters.sap.util.EditingSupport;
import org.jboss.jca.adapters.sap.util.RecordUtil;

import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoRequest;
import com.sap.conn.jco.JCoResponse;

public class InteractionImpl extends InteractionItemProvider implements Interaction {

	protected EditingSupport<org.jboss.jca.adapters.sap.model.cci.Interaction> editingSupport = new EditingSupport<org.jboss.jca.adapters.sap.model.cci.Interaction>(
			this);

	public InteractionImpl() {
		super(CciJcaAdapterFactory.INSTANCE);
	}

	@Override
	public void clearWarnings() throws ResourceException {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {

			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(),
					CciPackage.Literals.INTERACTION__RESOURCE_WARNING, null);
			editingSupport.getCommandStack().execute(command);

			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new ResourceException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public void close() throws ResourceException {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			InteractionState state = editingSupport.getModel().getState();
			if (state == InteractionState.CLOSED)
				return;

			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(),
					CciPackage.Literals.INTERACTION__STATE, InteractionState.CLOSED);
			editingSupport.getCommandStack().execute(command);

			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new ResourceException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public Record execute(InteractionSpec ispec, Record input) throws ResourceException {
		checkState();
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			if (!(ispec instanceof org.jboss.jca.adapters.sap.cci.InteractionSpec))
				throw new ResourceException("The type of connection spec is invalid: "
						+ (ispec == null ? "null" : ispec.getClass().getName()));
			org.jboss.jca.adapters.sap.cci.InteractionSpec interactionSpec = (org.jboss.jca.adapters.sap.cci.InteractionSpec) ispec;

			String connectionName = editingSupport.getModel().getConnection().getConnectionName();

			String outputRecordName = interactionSpec.getFunctionName() + ".OUTPUT_RECORD";

			Object obj = editingSupport.wrap(RecordUtil.createRecord(connectionName, outputRecordName));
			if (!(obj instanceof MappedRecord)) {
				// TODO revisit this; throwing an exception is probably more
				// appropriate.
				return null;
			}
			MappedRecord output = (MappedRecord) obj;

			Record returnValue = null;
			if (execute(ispec, input, output)) {
				returnValue = output;
			}

			editingSupport.commitTransaction();
			return returnValue;
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new ResourceException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public boolean execute(InteractionSpec ispec, Record input, Record output) throws ResourceException {
		checkState();
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {

			// Validate passed interaction spec.
			if (!(ispec instanceof org.jboss.jca.adapters.sap.cci.impl.InteractionSpecImpl))
				throw new ResourceException("The type of connection spec is invalid: "
						+ (ispec == null ? "null" : ispec.getClass().getName()));
			org.jboss.jca.adapters.sap.cci.impl.InteractionSpecImpl interactionSpec = (org.jboss.jca.adapters.sap.cci.impl.InteractionSpecImpl) ispec;
			String functionName = interactionSpec.getFunctionName();
			if (functionName == null)
				throw new ResourceException("The function name of interaction spec is null");

			// Validate passed input record.
			if (!(input instanceof MappedRecordImpl))
				throw new ResourceException("The type of input record is invalid: "
						+ (input == null ? "null" : input.getClass().getName()));
			MappedRecordImpl inputRecord = (MappedRecordImpl) input;

			// Validate passed output record.
			if (!(output instanceof MappedRecordImpl))
				throw new ResourceException("The type of outpur record is invalid: "
						+ (output == null ? "null" : output.getClass().getName()));
			MappedRecordImpl outputRecord = (MappedRecordImpl) output;

			// Create JCo request
			String connectionName = editingSupport.getModel().getConnection().getConnectionName();
			JCoDestination destination = JCoDestinationManager.getDestination(connectionName);
			JCoRequest request = destination.getRepository().getRequest(functionName);

			// Invoke RFC
			RecordUtil.fillJCoRecordFromMappedRecord(inputRecord.editingSupport.getModel(), request);
			JCoResponse response = request.execute(destination);
			Command command = new ExtractJCoRecordIntoMappedRecordCommand(outputRecord.editingSupport.getModel(),
					response);
			editingSupport.getCommandStack().execute(command);

			// Create and add an execution to interaction.
			command = new AddExecutionCommand(editingSupport.getEditingDomain(), editingSupport.getModel(),
					interactionSpec.editingSupport.getModel(), inputRecord.editingSupport.getModel(),
					outputRecord.editingSupport.getModel());
			editingSupport.getCommandStack().execute(command);

			editingSupport.commitTransaction();
			return true;
		} catch (AbapException e) {
			// Set resourceWarning directly: do not want this change on command
			// stack.
			editingSupport.getModel().setResourceWarning(
					new ResourceWarning("The remote function module threw an AbapException", e));
			editingSupport.rollbackTransaction();
			return false;
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new ResourceException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public Connection getConnection() {
		editingSupport.getReadLock().lock();
		try {
			return (Connection) editingSupport.wrap(editingSupport.getModel().getConnection());
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public ResourceWarning getWarnings() throws ResourceException {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getResourceWarning();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public InteractionState getState() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getState();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * Internal helper method used by public methods to check the state of this
	 * interaction before performing an operation on it. This method prevents
	 * operations from being performed on an interaction in a
	 * <code>CLOSED</code> state.
	 * 
	 * @throws ResourceException
	 *             if interaction is in a <code>CLOSED</code> state.
	 */
	private void checkState() throws ResourceException {
		editingSupport.getReadLock().lock();
		try {
			if (editingSupport.getModel().getState() == InteractionState.CLOSED) {
				throw new ResourceException("The interaction is closed");
			}
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}
}
