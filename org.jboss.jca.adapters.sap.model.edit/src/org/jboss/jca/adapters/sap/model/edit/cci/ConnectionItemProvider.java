package org.jboss.jca.adapters.sap.model.edit.cci;

import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.cci.Connection;
import org.jboss.jca.adapters.sap.model.edit.provider.DelegatingItemPropertyDescriptor;
import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.model.spi.provider.ConnectionRequestInfoItemProvider;

public class ConnectionItemProvider extends org.jboss.jca.adapters.sap.model.cci.provider.ConnectionItemProvider {

	public ConnectionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * Adds property descriptors of contained {@link ConnectionRequestInfo) instance to this {@link Connection} instance.
	 */
	protected void addConnectionRequestInfoPropertyDescriptors(ConnectionRequestInfo connectionRequestInfo, final String connectionRequestInfoFeature) {
		ConnectionRequestInfoItemProvider connectionRequestInfoItemProvider = (ConnectionRequestInfoItemProvider) getRootAdapterFactory().adapt(connectionRequestInfo, IItemPropertySource.class);
		List<IItemPropertyDescriptor> descriptors = connectionRequestInfoItemProvider.getPropertyDescriptors(connectionRequestInfo);
		for(IItemPropertyDescriptor descriptor: descriptors) {
			itemPropertyDescriptors.add(new DelegatingItemPropertyDescriptor(descriptor, CciPackage.Literals.CONNECTION__CONNECTION_REQUEST_INFO) {
				@Override
				public String getCategory(Object thisObject) {
					return connectionRequestInfoFeature;
				}
				
				@Override
				public String getId(Object thisObject) {
					return connectionRequestInfoFeature + getDisplayName(thisObject);
				}
				
				@Override
				public boolean canSetProperty(Object object) {
					return false;
				}
			});
		}
	}

	/**
	 * Overridden to simplify label.
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			getPropertyDescriptorsGen(object);

			addConnectionRequestInfoPropertyDescriptors(((Connection)object).getConnectionRequestInfo(), getString("_UI_Connection_connectionRequestInfo_feature"));
		}
		return itemPropertyDescriptors;
	}

}
