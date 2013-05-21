package org.jboss.jca.adapters.sap.cci.impl;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionSpec;
import javax.resource.cci.RecordFactory;
import javax.resource.cci.ResourceAdapterMetaData;
import javax.resource.spi.ConnectionManager;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.SetCommand;
import org.jboss.jca.adapters.sap.cci.ConnectionFactory;
import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.edit.cci.ConnectionFactoryItemProvider;
import org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.util.EditingSupport;

public class ConnectionFactoryImpl extends ConnectionFactoryItemProvider implements ConnectionFactory {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4451277766276034138L;
	
	private class MetaData implements ResourceAdapterMetaData {

		@Override
		public String getAdapterName() {
			return "JBoss SAP JCA Adapter";
		}

		@Override
		public String getAdapterShortDescription() {
			return "JBoss SAP JCA";
		}

		@Override
		public String getAdapterVendorName() {
			return "Red Hat Middleware LLC";
		}

		@Override
		public String getAdapterVersion() {
			return "1.0.0-SNAPSHOT";
		}

		@Override
		public String[] getInteractionSpecsSupported() {
			return new String[] { "org.jboss.jca.adapters.sap.cci.impl.InteractionSpecImpl" };
		}

		@Override
		public String getSpecVersion() {
			return "1.5";
		}

		@Override
		public boolean supportsExecuteWithInputAndOutputRecord() {
			return true;
		}

		@Override
		public boolean supportsExecuteWithInputRecordOnly() {
			return true;
		}

		@Override
		public boolean supportsLocalTransactionDemarcation() {
			return true;
		}
		
	}

	protected EditingSupport<org.jboss.jca.adapters.sap.model.cci.ConnectionFactory> editingSupport = new EditingSupport<org.jboss.jca.adapters.sap.model.cci.ConnectionFactory>(this);

	public ConnectionFactoryImpl() {
		super(CciJcaAdapterFactory.INSTANCE);
	}

	@Override
	public Connection getConnection() throws ResourceException {
		editingSupport.getWriteLock().lock();
		try {
			ConnectionManager connectionManager = editingSupport.getModel().getConnectionManager();
			ManagedConnectionFactory managedConnectionFactory = (ManagedConnectionFactory) editingSupport.wrap(editingSupport.getModel().getManagedConnectionFactory());
			ConnectionImpl connection = (ConnectionImpl) connectionManager.allocateConnection(managedConnectionFactory, null);
			connection.setConnectionManager(connectionManager);
			return connection;
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public Connection getConnection(ConnectionSpec arg0) throws ResourceException {
		editingSupport.getWriteLock().lock();
		try {
			// copy connection spec properties into new connection request info.
			
			
			ConnectionManager connectionManager = editingSupport.getModel().getConnectionManager();
			ManagedConnectionFactory managedConnectionFactory = (ManagedConnectionFactory) editingSupport.wrap(editingSupport.getModel().getManagedConnectionFactory());
			ConnectionImpl connection = (ConnectionImpl) connectionManager.allocateConnection(managedConnectionFactory, null);
			connection.setConnectionManager(connectionManager);
			return connection;
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public ResourceAdapterMetaData getMetaData() throws ResourceException {
		return new MetaData();
	}

	@Override
	public RecordFactory getRecordFactory() throws ResourceException {
		editingSupport.getReadLock().lock();
		try {
			return (RecordFactory) editingSupport.wrap(editingSupport.getModel().getRecordFactory());
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setReference(Reference reference) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION_FACTORY__REFERENCE, reference);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public Reference getReference() throws NamingException {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getReference();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}
}
