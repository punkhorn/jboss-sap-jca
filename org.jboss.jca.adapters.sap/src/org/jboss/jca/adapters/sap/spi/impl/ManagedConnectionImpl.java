package org.jboss.jca.adapters.sap.spi.impl;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map.Entry;

import javax.resource.NotSupportedException;
import javax.resource.ResourceException;
import javax.resource.spi.ConnectionEvent;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnectionMetaData;
import javax.resource.spi.security.PasswordCredential;
import javax.security.auth.Subject;
import javax.transaction.xa.XAResource;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.jboss.jca.adapters.sap.cci.Connection;
import org.jboss.jca.adapters.sap.cci.impl.ConnectionImpl;
import org.jboss.jca.adapters.sap.command.DissociateConnectionsFromManagedConnectionCommand;
import org.jboss.jca.adapters.sap.model.cci.CciFactory;
import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.cci.ConnectionState;
import org.jboss.jca.adapters.sap.model.edit.spi.ManagedConnectionItemProvider;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionState;
import org.jboss.jca.adapters.sap.model.spi.SpiFactory;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;
import org.jboss.jca.adapters.sap.spi.ManagedConnection;
import org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.util.EditingSupport;

import com.sap.conn.jco.JCoContext;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.ext.DestinationDataProvider;

public class ManagedConnectionImpl extends ManagedConnectionItemProvider implements ManagedConnection {

	/**
	 * Remote function module called to commit transaction
	 */
	private static final String COMMIT_FUNCTION = "BAPI_TRANSACTION_COMMIT";

	/**
	 * Name of import variable set in remote function call to commit transaction
	 * that causes synchronous commit
	 */
	private static final String SYNC_COMMIT_PARAM = "WAIT";

	/**
	 * Value pass in remote function call to commit transaction that causes
	 * synchronous commit.
	 */
	private static final String SYNC_COMMIT_PARAM_VAL = "X";

	/**
	 * Remote function module called to rollback transaction
	 */
	private static final String ROLLBACK_FUNCTION = "BAPI_TRANSACTION_ROLLBACK";

	/**
	 * Location of plug-in properties.
	 */
	static final String PROPERITES_FILE = "plugin.properties";

	/**
	 * Property Name of EIS Product Name property
	 */
	static final String EIS_PRODUCT_NAME_PROP = "eis-product-name";

	/**
	 * Property Name of EIS Maximum Connections property;
	 */
	static final String EIS_MAX_CONNECTIONS_PROP = "eis-max-connections";

	private class LocalTransaction implements javax.resource.spi.LocalTransaction {

		@Override
		public void begin() throws ResourceException {
			editingSupport.getWriteLock().lock();
			try {
				if (editingSupport.getModel().isInTransaction()) {
					// Nested transactions not supported
					throw new ResourceException("The connection has outstanding transaction");
				}

				// Start stateful session for transaction
				beginStatefulSession();

				// Set this directly since this change should not be on command
				// stack.
				editingSupport.getModel().setInTransaction(true);

				// Notify connection event listeners of local transaction start:
				// JCA 1.5 Specification: 7.7.2.1
				if (!editingSupport.getModel().getConnectionEventListeners().isEmpty()) {
					ConnectionEvent event = new ConnectionEvent(ManagedConnectionImpl.this,
							ConnectionEvent.LOCAL_TRANSACTION_STARTED);
					for (ConnectionEventListener listener : editingSupport.getModel().getConnectionEventListeners()) {
						listener.localTransactionStarted(event);
					}
				}

			} catch (Throwable t) {
				// Set this directly since this change should not be on command
				// stack.
				editingSupport.getModel().setInTransaction(false);
			} finally {
				editingSupport.getWriteLock().unlock();
			}
		}

		@Override
		public void commit() throws ResourceException {
			editingSupport.getWriteLock().lock();
			try {
				if (!editingSupport.getModel().isInTransaction()) {
					// Error: No outstanding transactions
					throw new ResourceException("The connection has no outstanding transaction");
				}

				// Commit transaction synchronously in SAP system
				try {
					JCoDestination destination = JCoDestinationManager.getDestination(editingSupport.getModel()
							.getConnectionName());
					JCoFunction commit = destination.getRepository().getFunction(COMMIT_FUNCTION);
					commit.getImportParameterList().setValue(SYNC_COMMIT_PARAM, SYNC_COMMIT_PARAM_VAL);
					commit.execute(destination);
				} catch (JCoException e) {
					// Note transaction should be implicitly rolled back in SAP
					// system on error.
					throw new ResourceException("The transaction commit failed", e);
				}

				// Notify connection event listeners of local transaction
				// commit: JCA 1.5 Specification: 7.7.2.1
				if (!editingSupport.getModel().getConnectionEventListeners().isEmpty()) {
					ConnectionEvent event = new ConnectionEvent(ManagedConnectionImpl.this,
							ConnectionEvent.LOCAL_TRANSACTION_COMMITTED);
					for (ConnectionEventListener listener : editingSupport.getModel().getConnectionEventListeners()) {
						listener.localTransactionStarted(event);
					}
				}

			} finally {
				endStatefulSession();

				// Set this directly since this change should not be on command
				// stack.
				editingSupport.getModel().setInTransaction(false);

				editingSupport.getWriteLock().unlock();
			}
		}

		@Override
		public void rollback() throws ResourceException {
			editingSupport.getWriteLock().lock();
			try {
				if (!editingSupport.getModel().isInTransaction()) {
					// Error: No outstanding transactions
					throw new ResourceException("The connection has no outstanding transaction");
				}

				// Commit transaction synchronously in SAP system
				try {
					JCoDestination destination = JCoDestinationManager.getDestination(editingSupport.getModel()
							.getConnectionName());
					JCoFunction rollback = destination.getRepository().getFunction(ROLLBACK_FUNCTION);
					rollback.execute(destination);
				} catch (JCoException e) {
					// Note transaction should be implicitly rolled back in SAP
					// system on error.
					throw new ResourceException("The transaction rollback failed", e);
				}

				// Notify connection event listeners of local transaction
				// commit: JCA 1.5 Specification: 7.7.2.1
				if (!editingSupport.getModel().getConnectionEventListeners().isEmpty()) {
					ConnectionEvent event = new ConnectionEvent(ManagedConnectionImpl.this,
							ConnectionEvent.LOCAL_TRANSACTION_ROLLEDBACK);
					for (ConnectionEventListener listener : editingSupport.getModel().getConnectionEventListeners()) {
						listener.localTransactionStarted(event);
					}
				}

			} finally {
				endStatefulSession();

				// Set this directly since this change should not be on command
				// stack.
				editingSupport.getModel().setInTransaction(false);

				editingSupport.getWriteLock().unlock();
			}
		}

	}

	private class MetaData implements ManagedConnectionMetaData {

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
		public int getMaxConnections() throws ResourceException {
			return 0;
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

	protected EditingSupport<org.jboss.jca.adapters.sap.model.spi.ManagedConnection> editingSupport = new EditingSupport<org.jboss.jca.adapters.sap.model.spi.ManagedConnection>(
			this);

	protected EContentAdapter contentAdapter = new EContentAdapter() {
		@Override
		public void notifyChanged(Notification notification) {
			// Monitor the state of any associated connection handle
			switch (notification.getFeatureID(Connection.class)) {
			case CciPackage.CONNECTION__STATE:
				if (notification.getNewValue() == ConnectionState.CLOSED) {
					connectionHandleClosed(notification);
				}
				break;
			}

			super.notifyChanged(notification);
		}
	};

	public ManagedConnectionImpl() {
		super(SpiJcaAdapterFactory.INSTANCE);
	}

	@Override
	public Object getConnection(Subject subject, ConnectionRequestInfo connectionRequestInfo) throws ResourceException {
		checkState();
		if (connectionRequestInfo != null && !(connectionRequestInfo instanceof ConnectionRequestInfoImpl))
			throw new ResourceException("The type of connection request info is invalid: "
					+ connectionRequestInfo.getClass().getName());

		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {

			// Validate subject credentials match those of this connection.
			if (subject != null) {
				boolean foundMatchingCredential = false;
				for (PasswordCredential credential : subject.getPrivateCredentials(PasswordCredential.class)) {
					if (credential.getManagedConnectionFactory().equals(this)) {
						if (!getConnectionRequestInfo().getUserName().equals(credential.getUserName())) {
							continue;
						} else if (!getConnectionRequestInfo().getPassword().equals(
								new String(credential.getPassword()))) {
							continue;
						}
						// Found matching credentials.
						foundMatchingCredential = true;
						break;
					}
				}
				if (!foundMatchingCredential)
					throw new SecurityException(
							"Failed to find credentials in Subject matching those of managed connection");
			}

			// Validate properties of passed connection request info match those
			// of this connection.
			if (connectionRequestInfo != null) {
				ConnectionRequestInfoImpl jCxRequestInfo = (ConnectionRequestInfoImpl) connectionRequestInfo;

				for (Entry<Object, Object> entry : jCxRequestInfo.getProperties().entrySet()) {
					if (subject != null
							&& (entry.getKey().equals(DestinationDataProvider.JCO_USER) || entry.getKey().equals(
									DestinationDataProvider.JCO_PASSWD)))
						// Already checked management credentials against
						// subject credentials which override
						// connection request info credentials.
						continue;

					if (!getConnectionRequestInfo().getProperties().get(entry.getKey()).equals(entry.getValue()))
						throw new ResourceException("The value '" + entry.getValue().toString()
								+ "' of connection request info parameter '" + entry.getKey().toString()
								+ "' does not match the value '"
								+ getConnectionRequestInfo().getProperties().get(entry.getKey()).toString()
								+ "' of managed connection");
				}

			}

			EObject connectionModel = CciFactory.eINSTANCE.createConnection();
			Object newConnection = editingSupport.wrap(connectionModel);

			// Associate connection handle with this managed connection
			Command command = AddCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(),
					SpiPackage.Literals.MANAGED_CONNECTION__CONNECTION_HANDLES, connectionModel);
			editingSupport.getCommandStack().execute(command);

			editingSupport.commitTransaction();
			return newConnection;
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
			throw new ResourceException(e);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public void addConnectionEventListener(ConnectionEventListener listener) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			if (listener == null) {
				throw new IllegalArgumentException("The connection event listener is null");
			}
			Command command = AddCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(),
					SpiPackage.Literals.MANAGED_CONNECTION__CONNECTION_EVENT_LISTENERS, listener);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(e);
		} finally {
			editingSupport.getWriteLock().unlock();
		}

	}

	@Override
	public void removeConnectionEventListener(ConnectionEventListener listener) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			if (listener == null) {
				throw new IllegalArgumentException("The connection event listener is null");
			}
			Command command = RemoveCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(),
					SpiPackage.Literals.MANAGED_CONNECTION__CONNECTION_EVENT_LISTENERS, listener);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(e);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public LocalTransaction getLocalTransaction() throws ResourceException {
		checkState();
		return new LocalTransaction();
	}

	@Override
	public XAResource getXAResource() throws ResourceException {
		throw new NotSupportedException("XAResource is not supported  by the JBoss SAP JCA Connector");
	}

	@Override
	public ManagedConnectionMetaData getMetaData() throws ResourceException {
		checkState();
		return new MetaData();
	}

	@Override
	public PrintWriter getLogWriter() throws ResourceException {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getLogWriter();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setLogWriter(PrintWriter out) throws ResourceException {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(),
					SpiPackage.Literals.MANAGED_CONNECTION__LOG_WRITER, out);
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
	public void associateConnection(Object connection) throws ResourceException {
		checkState();
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			if (!(connection instanceof ConnectionImpl))
				throw new ResourceException(
						"The type of connection to be associated with managed connection is invalid: "
								+ (connection == null ? "null" : connection.getClass().getName()));

			// Associate connection to this managed connection
			org.jboss.jca.adapters.sap.model.cci.Connection connectionModel = (org.jboss.jca.adapters.sap.model.cci.Connection) ((ConnectionImpl) connection)
					.getTarget();
			Command command = AddCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(),
					SpiPackage.Literals.MANAGED_CONNECTION__CONNECTION_HANDLES, connectionModel);
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
	public void dissociateConnections() throws ResourceException {
		checkState();
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			if (editingSupport.getModel().getConnectionHandles().size() > 0) {
				Command command = new DissociateConnectionsFromManagedConnectionCommand(
						editingSupport.getEditingDomain(), editingSupport.getModel(), null, null);
				editingSupport.getCommandStack().execute(command);
			}
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
			throw new ResourceException(e);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public void cleanup() throws ResourceException {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {

			if (editingSupport.getModel().getConnectionHandles().size() > 0) {
				@SuppressWarnings("unchecked")
				List<Connection> handles = editingSupport.wrap(editingSupport.getModel().getConnectionHandles());
				for (Connection handle : handles) {
					handle.close();
				}
			}

			// End any stateful session.
			JCoDestination destination = JCoDestinationManager.getDestination(editingSupport.getModel()
					.getConnectionName());
			if (JCoContext.isStateful(destination)) {
				JCoContext.end(destination);
			}

			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
			throw new ResourceException(e);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public void destroy() throws ResourceException {
		editingSupport.getWriteLock().lock();
		try {
			if (editingSupport.getModel().getState() == ManagedConnectionState.DESTROYED)
				return;

			editingSupport.beginTransaction();

			cleanup();

			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(),
					SpiPackage.Literals.MANAGED_CONNECTION__STATE, ManagedConnectionState.DESTROYED);
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
	public void beginStatefulSession() throws ResourceException {
		checkState();
		editingSupport.getWriteLock().lock();
		try {
			JCoDestination destination = JCoDestinationManager.getDestination(editingSupport.getModel()
					.getConnectionName());
			JCoContext.begin(destination);
		} catch (Exception e) {
			throw new ResourceException(e);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public void endStatefulSession() throws ResourceException {
		checkState();
		editingSupport.getWriteLock().lock();
		try {
			JCoDestination destination = JCoDestinationManager.getDestination(editingSupport.getModel()
					.getConnectionName());

			if (!JCoContext.isStateful(destination))
				return;

			JCoContext.end(destination);
		} catch (Exception e) {
			throw new ResourceException(e);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public void ping() throws ResourceException {
		checkState();
		editingSupport.getReadLock().lock();
		try {
			String connectionName = editingSupport.getModel().getConnectionName();
			JCoDestination destination = JCoDestinationManager.getDestination(connectionName);
			destination.ping();
		} catch (Exception e) {
			throw new ResourceException("The connection ping failed", e);
		} finally {
			editingSupport.getReadLock().unlock();
		}

	}

	public ManagedConnectionState getState() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getState();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public ManagedConnectionFactory getManagedConnectionFactory() {
		editingSupport.getReadLock().lock();
		try {
			return (ManagedConnectionFactory) editingSupport.wrap(editingSupport.getModel()
					.getManagedConnectionFactory());
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

	public org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo getConnectionRequestInfo() {
		editingSupport.getReadLock().lock();
		try {
			return (org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo) getRootAdapterFactory().adapt(
					editingSupport.getModel().getConnectionRequestInfo(),
					org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo.class);
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Connection> getConnectionHandles() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.wrap(editingSupport.getModel().getConnectionHandles());
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public List<ConnectionEventListener> getConnectionEventListeners() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getConnectionEventListeners();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public boolean isInTransaction() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().isInTransaction();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Overridden to set content adapter on model.
	 */
	@Override
	public void setTarget(Notifier target) {
		super.setTarget(target);
		target.eAdapters().add(contentAdapter);
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
		return SpiFactory.eINSTANCE.createManagedConnection();
	}

	protected void connectionHandleClosed(Notification notification) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {

			// Dissociate connection handle
			Command command = RemoveCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(),
					SpiPackage.Literals.MANAGED_CONNECTION__CONNECTION_HANDLES, notification.getNotifier());
			editingSupport.getCommandStack().execute(command);

			// Notify connection event listeners of connection handle close
			if (!editingSupport.getModel().getConnectionEventListeners().isEmpty()) {
				ConnectionEvent event = new ConnectionEvent(this, ConnectionEvent.CONNECTION_CLOSED);
				event.setConnectionHandle(editingSupport.wrap(notification.getNotifier()));
				for (ConnectionEventListener listener : editingSupport.getModel().getConnectionEventListeners()) {
					listener.localTransactionStarted(event);
				}
			}

			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * Internal helper method used by public methods to check the state of this
	 * connection factory before performing an operation on it. This method
	 * prevents operations from being performed on a connection in a
	 * <code>DESTROYED</code> state.
	 * 
	 * @throws ResourceException
	 *             if connection is in a <code>DESTROYED</code> state.
	 * 
	 * @generated NOT
	 */
	private void checkState() throws ResourceException {
		editingSupport.getReadLock().lock();
		try {
			if (editingSupport.getModel().getState() == ManagedConnectionState.DESTROYED) {
				throw new ResourceException("The connection is destroyed");
			}
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

}
