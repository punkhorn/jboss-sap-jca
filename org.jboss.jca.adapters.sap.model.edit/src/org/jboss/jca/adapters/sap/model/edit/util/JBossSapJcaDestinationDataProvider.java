package org.jboss.jca.adapters.sap.model.edit.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfoStore;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;
import org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoStoreEntryImpl;

import com.sap.conn.jco.ext.DestinationDataEventListener;
import com.sap.conn.jco.ext.DestinationDataProvider;
import com.sap.conn.jco.ext.Environment;

public class JBossSapJcaDestinationDataProvider implements DestinationDataProvider {
	
	public static final JBossSapJcaDestinationDataProvider INSTANCE = new JBossSapJcaDestinationDataProvider();
	
	/**
	 * Forwards change notifications from connection request info store to any destination data listener. 
	 * 
	 * @author William Collins
	 */
	public class ConnectionRequestInfoStoreListener extends EContentAdapter {
		@Override
		public void notifyChanged(Notification msg) {
			if (msg.getFeature() == SpiPackage.Literals.CONNECTION_REQUEST_INFO_STORE__CONNECTION_REQUEST_INFOS) {
				switch (msg.getEventType()) {
				case Notification.ADD: {
					ConnectionRequestInfoStoreEntryImpl entry = (ConnectionRequestInfoStoreEntryImpl) msg
							.getNewValue();
					addConnectionRequestInfoListener(entry.getKey(),
							entry.getValue());
					if (destinationDataEventListener != null)
						destinationDataEventListener.updated(entry.getKey());
					break;
				}
				case Notification.ADD_MANY: {
					@SuppressWarnings("unchecked")
					Collection<ConnectionRequestInfoStoreEntryImpl> entries = (Collection<ConnectionRequestInfoStoreEntryImpl>) msg
							.getNewValue();
					for (ConnectionRequestInfoStoreEntryImpl entry : entries) {
						addConnectionRequestInfoListener(entry.getKey(),
								entry.getValue());
						if (destinationDataEventListener != null)
							destinationDataEventListener.updated(entry.getKey());
					}
					break;
				}
				case Notification.REMOVE: {
					ConnectionRequestInfoStoreEntryImpl entry = (ConnectionRequestInfoStoreEntryImpl) msg
							.getOldValue();
					removeConnectionRequestInfoListener(entry.getValue());
					if (destinationDataEventListener != null)
						destinationDataEventListener.deleted(entry.getKey());
					break;
				}
				case Notification.REMOVE_MANY: {
					@SuppressWarnings("unchecked")
					Collection<ConnectionRequestInfoStoreEntryImpl> entries = (Collection<ConnectionRequestInfoStoreEntryImpl>) msg
							.getOldValue();
					for (ConnectionRequestInfoStoreEntryImpl entry : entries) {
						removeConnectionRequestInfoListener(entry.getValue());
						if (destinationDataEventListener != null)
							destinationDataEventListener.deleted(entry.getKey());
					}
					break;
				}
//				case Notification.SET: {
//					if (msg.getOldValue() != null) {
//						ConnectionRequestInfo connectionRequestInfo = (ConnectionRequestInfo) msg
//								.getOldValue();
//						removeConnectionRequestInfoListener(connectionRequestInfo);
//					}
//					ConnectionRequestInfo connectionRequestInfo = (ConnectionRequestInfo) msg
//							.getNewValue();
//					int index = getConnectionRequestInfos().indexOf(
//							connectionRequestInfo);
//					if (index > -1) {
//						String connectionName = getConnectionRequestInfos()
//								.get(index).getKey();
//						addConnectionRequestInfoListener(connectionName,
//								connectionRequestInfo);
//						if (destinationDataListener != null)
//							destinationDataListener.updated(connectionName);
//					}
//					break;
//				}
				}
			}
			super.notifyChanged(msg);
		}
		
		protected void addConnectionRequestInfoListener(String connectionName, Notifier notifier) {
			notifier.eAdapters().add(new ConnectionRequestInfoListener(connectionName));
		}
		
		protected void removeConnectionRequestInfoListener(Notifier notifier) {
			Set<Adapter> listeners = new HashSet<Adapter>();
			for (Adapter adapter: notifier.eAdapters() ) {
				if (adapter instanceof ConnectionRequestInfoListener) {
					listeners.add(adapter);
				}
			}
			notifier.eAdapters().removeAll(listeners);
		}
	}
	
	private final ConnectionRequestInfoStoreListener connectionRequestInfoStoreListener = new ConnectionRequestInfoStoreListener();

	/**
	 * Forwards change notifications from connection request info to any destination data listener. 
	 * 
	 * @author William Collins
	 */
	public class ConnectionRequestInfoListener extends EContentAdapter {

		private String connectionName;

		public ConnectionRequestInfoListener(String connectionName) {
			this.connectionName = connectionName;
		}

		@Override
		public void notifyChanged(Notification msg) {
			switch (msg.getEventType()) {
			case Notification.SET:
			case Notification.ADD:
			case Notification.ADD_MANY: {
				if (destinationDataEventListener != null)
					destinationDataEventListener.updated(connectionName);
				break;
			}
			case Notification.REMOVE:
			case Notification.REMOVE_MANY: {
				if (destinationDataEventListener != null)
					destinationDataEventListener.deleted(connectionName);
				break;
			}
			}
			super.notifyChanged(msg);
		}
	}
	
	/**
	 * The cached value of the '{@link #getDestinationDataListener() <em>Destination Data Listener</em>}' attribute.
	 */
	protected DestinationDataEventListener destinationDataEventListener;

	Set<ConnectionRequestInfoStore> stores = new HashSet<ConnectionRequestInfoStore>();
	
	private JBossSapJcaDestinationDataProvider() {
		Environment.registerDestinationDataProvider(this);
	}
	
	public void addConnectionRequestInfoStore(ConnectionRequestInfoStore store) {
		
		// Remember store
		stores.add(store);
		
		// listen for any changes in added store.
		store.eAdapters().add(connectionRequestInfoStoreListener);
		
		if (destinationDataEventListener == null) {
			return;
		}
		
		// Update DestinationDataEventListener for added configurations.
		for (String connectionName: store.getConnectionRequestInfos().keySet()) {
			destinationDataEventListener.updated(connectionName);
		}
	}
	
	public void removeConnectionRequestInfoStore(ConnectionRequestInfoStore store) {
		
		// Forget store
		stores.remove(store);
		
		// stop listening for changes in removed store.
		store.eAdapters().remove(connectionRequestInfoStoreListener);
		
		
		// Update DestinationDataEventListener for removed configurations.
		for (String connectionName: store.getConnectionRequestInfos().keySet()) {
			destinationDataEventListener.deleted(connectionName);
		}
	}
	
	@Override
	public Properties getDestinationProperties(String connectionName) {
		for (ConnectionRequestInfoStore store: stores) {
			ConnectionRequestInfo connectionRequestInfo = store.getConnectionRequestInfos().get(connectionName);
			if (connectionRequestInfo != null) {
				Properties properties = new Properties();
				properties.putAll(connectionRequestInfo.getEntries().map());
				return properties;
			}
		}
		return null;
	}

	@Override
	public void setDestinationDataEventListener(
			DestinationDataEventListener destinationDataEventListener) {
		this.destinationDataEventListener = destinationDataEventListener;
	}

	@Override
	public boolean supportsEvents() {
		return true;
	}

}
