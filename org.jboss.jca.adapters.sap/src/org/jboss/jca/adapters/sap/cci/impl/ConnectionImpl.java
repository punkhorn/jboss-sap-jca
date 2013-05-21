package org.jboss.jca.adapters.sap.cci.impl;

import java.util.Collections;
import java.util.List;

import javax.resource.NotSupportedException;
import javax.resource.ResourceException;
import javax.resource.cci.ConnectionMetaData;
import javax.resource.cci.Interaction;
import javax.resource.cci.ResultSetInfo;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.LazyAssociatableConnectionManager;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.jboss.jca.adapters.sap.cci.Connection;
import org.jboss.jca.adapters.sap.command.CloseConnectionCommand;
import org.jboss.jca.adapters.sap.model.cci.CciFactory;
import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.cci.ConnectionState;
import org.jboss.jca.adapters.sap.model.cci.InteractionState;
import org.jboss.jca.adapters.sap.model.edit.cci.ConnectionItemProvider;
import org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.spi.ManagedConnection;
import org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.util.EditingSupport;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;

public class ConnectionImpl extends ConnectionItemProvider implements Connection {

	protected EditingSupport<org.jboss.jca.adapters.sap.model.cci.Connection> editingSupport = new EditingSupport<org.jboss.jca.adapters.sap.model.cci.Connection>(
			this);

	protected class LocalTransaction implements javax.resource.cci.LocalTransaction {

		private javax.resource.spi.LocalTransaction localTransaction;

		public LocalTransaction(ManagedConnection managedConnection) throws ResourceException {
			localTransaction = managedConnection.getLocalTransaction();
		}

		@Override
		public void begin() throws ResourceException {
			localTransaction.begin();
		}

		@Override
		public void commit() throws ResourceException {
			localTransaction.commit();
		}

		@Override
		public void rollback() throws ResourceException {
			localTransaction.rollback();
		}

	}

	protected class MetaData implements ConnectionMetaData {

		@Override
		public String getEISProductName() throws ResourceException {
			return "SAP\u00AE R/3";
		}

		@Override
		public String getEISProductVersion() throws ResourceException {
			editingSupport.getReadLock().lock();
			try {
				JCoDestination destination = JCoDestinationManager.getDestination(editingSupport.getModel()
						.getConnectionName());
				return destination.getAttributes().getPartnerRelease();
			} catch (JCoException e) {
				throw new ResourceException("Failed to retrieve EIS Product Version", e);
			} finally {
				editingSupport.getReadLock().unlock();
			}
		}

		@Override
		public String getUserName() throws ResourceException {
			editingSupport.getReadLock().lock();
			try {
				JCoDestination destination = JCoDestinationManager.getDestination(editingSupport.getModel()
						.getConnectionName());
				return destination.getAttributes().getUser();
			} catch (JCoException e) {
				throw new ResourceException("Failed to retrieve User Name", e);
			} finally {
				editingSupport.getReadLock().unlock();
			}
		}

	}

	protected EContentAdapter contentAdapter = new EContentAdapter() {
		@Override
		public void notifyChanged(Notification notification) {
			// Monitor the state of any associated connection handle
			switch (notification.getFeatureID(Connection.class)) {
			case CciPackage.INTERACTION__STATE:
				if (notification.getNewValue() == InteractionState.CLOSED) {
					interactionClosed(notification);
				}
				break;
			}

			super.notifyChanged(notification);
		}
	};

	public ConnectionImpl() {
		super(CciJcaAdapterFactory.INSTANCE);
	}

	@Override
	public void close() throws ResourceException {
		checkState();
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			ConnectionState state = editingSupport.getModel().getState();
			if (state == ConnectionState.CLOSED)
				return;

			if (state == ConnectionState.INACTIVE
					&& editingSupport.getModel().getConnectionManager() instanceof LazyAssociatableConnectionManager) {
				LazyAssociatableConnectionManager lazyAssociatableConnectionManager = (LazyAssociatableConnectionManager) editingSupport
						.getModel().getConnectionManager();
				ManagedConnectionFactory managedConnectionFactory = (ManagedConnectionFactory) editingSupport
						.wrap(editingSupport.getModel().getManagedConnection().getManagedConnectionFactory());
				lazyAssociatableConnectionManager.inactiveConnectionClosed(this, managedConnectionFactory);
			}

			Command command = new CloseConnectionCommand(editingSupport.getEditingDomain(), editingSupport.getModel());
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
			throw new ResourceException(e);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public Interaction createInteraction() throws ResourceException {
		checkState();
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			
			// Create and add interaction to connection.
			EObject interactionModel = CciFactory.eINSTANCE.createInteraction();
			Command command = AddCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION__INTERACTIONS, Collections.singleton(interactionModel));
			editingSupport.getCommandStack().execute(command);
			Interaction interaction = (Interaction) editingSupport.wrap(interactionModel);

			editingSupport.commitTransaction();
			return interaction;
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
			throw new ResourceException(e);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public javax.resource.cci.LocalTransaction getLocalTransaction() throws ResourceException {
		checkState();
		return new LocalTransaction(getManagedConnection());
	}

	@Override
	public ConnectionMetaData getMetaData() throws ResourceException {
		checkState();
		return new MetaData();
	}

	@Override
	public ResultSetInfo getResultSetInfo() throws ResourceException {
		throw new NotSupportedException("ResultSetInfo is not supported  by the JBoss SAP JCA Connector");
	}
	
	public ConnectionState getState() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getState();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public String getConnectionName() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getConnectionName();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public ConnectionRequestInfo getConnectionRequestInfo() {
		editingSupport.getReadLock().lock();
		try {
			return (ConnectionRequestInfo) editingSupport.wrap(editingSupport.getModel().getConnectionRequestInfo());
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public ConnectionManager getConnectionManager() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getConnectionManager();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}
	
	public void setConnectionManager(ConnectionManager connectionManager) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION__CONNECTION_MANAGER, connectionManager);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public ManagedConnection getManagedConnection() {
		editingSupport.getReadLock().lock();
		try {
			return (ManagedConnection) editingSupport.wrap(editingSupport.getModel().getManagedConnection());
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Interaction> getInteractions() {
		editingSupport.getReadLock().lock();
		try {
			return (List<Interaction>) editingSupport.wrap(editingSupport.getModel().getInteractions());
		} finally {
			editingSupport.getReadLock().unlock();
		}
		
	}
	
	@Override
	public void setTarget(Notifier target) {
		super.setTarget(target);
		target.eAdapters().add(contentAdapter);
	}
	
	@Override
	public void notifyChanged(Notification notification) {
		switch (notification.getFeatureID(Connection.class)) {
		case CciPackage.CONNECTION__MANAGED_CONNECTION:
			managedConnectionChanged(notification);
			break;
		}
		super.notifyChanged(notification);
	}

	protected void interactionClosed(Notification notification) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {

			// Dissociate interaction
			Command command = RemoveCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION__INTERACTIONS, notification.getNotifier());
			editingSupport.getCommandStack().execute(command);
			
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	protected void managedConnectionChanged(Notification notification) {
		editingSupport.getWriteLock().lock();
		try {

			if (editingSupport.getModel().getState() == ConnectionState.CLOSED)
				return;

			editingSupport.beginTransaction();

			// Activate Handle if a managed connection has been set. Deactivate
			// otherwise.
			ConnectionState state;
			if (notification.getNewValue() == null) {
				state = ConnectionState.INACTIVE;
			} else {
				state = ConnectionState.ACTIVE;
			}

			// Activate/Deactivate Connection Handle
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(),
					CciPackage.Literals.CONNECTION__STATE, state);
			editingSupport.getCommandStack().execute(command);

			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * Internal helper method used by public methods to check the state of this
	 * connection before performing an operation on it. This method prevents
	 * operations from being performed on a connection in a <code>CLOSED</code>
	 * state. It also ensures that a connection in an <code>INACTIVE</code>
	 * state is re-associated with a <code>ManagedConnection</code> before
	 * performing any operation on it; i.e. the connection is placed in an
	 * <code>ACTIVE</code> state first.
	 * 
	 * @throws ResourceException
	 *             if connection is closed or can not be placed in an
	 *             <code>ACTIVE</code> state.
	 */
	private void checkState() throws ResourceException {
		editingSupport.getReadLock().lock();
		try {
			if (editingSupport.getModel().getState() == ConnectionState.CLOSED) {
				throw new ResourceException("The connection is closed");
			}
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}
}
