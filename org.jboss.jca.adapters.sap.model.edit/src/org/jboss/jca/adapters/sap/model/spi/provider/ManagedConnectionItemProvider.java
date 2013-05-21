/**
 */
package org.jboss.jca.adapters.sap.model.spi.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.jboss.jca.adapters.sap.model.cci.CciFactory;
import org.jboss.jca.adapters.sap.model.edit.JBossSapJcaEditPlugin;
import org.jboss.jca.adapters.sap.model.edit.command.AddConnectionCommand;
import org.jboss.jca.adapters.sap.model.edit.command.RemoveConnectionCommand;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnection;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;

/**
 * This is the item provider adapter for a {@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ManagedConnectionItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedConnectionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

//	/**
//	 * This returns the property descriptors for the adapted class.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	@Override
//	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
//		if (itemPropertyDescriptors == null) {
//			getPropertyDescriptorsGen(object);
//
//			addConnectionRequestInfoPropertyDescriptors(((ManagedConnection)object).getConnectionRequestInfo(), getString("_UI_ManagedConnection_connectionRequestInfo_feature"));
//		}
//		return itemPropertyDescriptors;
//	}
//	
//	/**
//	 * 
//	 * @param connectionRequestInfo
//	 * @param connectionRequestInfoFeature
//	 * 
//	 * @generated NOT
//	 */
//	protected void addConnectionRequestInfoPropertyDescriptors(ConnectionRequestInfo connectionRequestInfo, final String connectionRequestInfoFeature) {
//		ConnectionRequestInfoItemProvider connectionRequestInfoItemProvider = (ConnectionRequestInfoItemProvider) getRootAdapterFactory().adapt(connectionRequestInfo, IItemPropertySource.class);
//		List<IItemPropertyDescriptor> descriptors = connectionRequestInfoItemProvider.getPropertyDescriptors(connectionRequestInfo);
//		for(IItemPropertyDescriptor descriptor: descriptors) {
//			itemPropertyDescriptors.add(new DelegatingItemPropertyDescriptor(descriptor, SpiPackage.Literals.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO) {
//				@Override
//				public String getCategory(Object thisObject) {
//					return connectionRequestInfoFeature;
//				}
//				
//				@Override
//				public String getId(Object thisObject) {
//					return connectionRequestInfoFeature + getDisplayName(thisObject);
//				}
//			});
//		}
//	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<IItemPropertyDescriptor> getPropertyDescriptorsGen(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addStatePropertyDescriptor(object);
			addConnectionNamePropertyDescriptor(object);
			addLogWriterPropertyDescriptor(object);
			addConnectionEventListenersPropertyDescriptor(object);
			addInTransactionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the State feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ManagedConnection_state_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManagedConnection_state_feature", "_UI_ManagedConnection_type"),
				 SpiPackage.Literals.MANAGED_CONNECTION__STATE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Connection Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConnectionNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ManagedConnection_connectionName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManagedConnection_connectionName_feature", "_UI_ManagedConnection_type"),
				 SpiPackage.Literals.MANAGED_CONNECTION__CONNECTION_NAME,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Log Writer feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLogWriterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ManagedConnection_logWriter_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManagedConnection_logWriter_feature", "_UI_ManagedConnection_type"),
				 SpiPackage.Literals.MANAGED_CONNECTION__LOG_WRITER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Connection Event Listeners feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConnectionEventListenersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ManagedConnection_connectionEventListeners_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManagedConnection_connectionEventListeners_feature", "_UI_ManagedConnection_type"),
				 SpiPackage.Literals.MANAGED_CONNECTION__CONNECTION_EVENT_LISTENERS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the In Transaction feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInTransactionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ManagedConnection_inTransaction_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManagedConnection_inTransaction_feature", "_UI_ManagedConnection_type"),
				 SpiPackage.Literals.MANAGED_CONNECTION__IN_TRANSACTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(SpiPackage.Literals.MANAGED_CONNECTION__CONNECTION_HANDLES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ManagedConnection.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ManagedConnection"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ManagedConnection)object).getConnectionName();
		return label == null || label.length() == 0 ?
			getString("_UI_ManagedConnection_type") :
			getString("_UI_ManagedConnection_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ManagedConnection.class)) {
			case SpiPackage.MANAGED_CONNECTION__STATE:
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_NAME:
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO:
			case SpiPackage.MANAGED_CONNECTION__LOG_WRITER:
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_EVENT_LISTENERS:
			case SpiPackage.MANAGED_CONNECTION__IN_TRANSACTION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_HANDLES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(SpiPackage.Literals.MANAGED_CONNECTION__CONNECTION_HANDLES,
				 CciFactory.eINSTANCE.createConnection()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return JBossSapJcaEditPlugin.INSTANCE;
	}

	@Override
	protected Command createAddCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Collection<?> collection, int index) {
		if (feature == SpiPackage.Literals.MANAGED_CONNECTION__CONNECTION_HANDLES) {
			return new AddConnectionCommand(domain, (ManagedConnection) owner, feature, collection);
		}
		return super.createAddCommand(domain, owner, feature, collection, index);
	}
	
	@Override
	protected Command createRemoveCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Collection<?> collection) {
		if (feature == SpiPackage.Literals.MANAGED_CONNECTION__CONNECTION_HANDLES) {
			return new RemoveConnectionCommand(domain, (ManagedConnection) owner, feature, collection);
		}
		return super.createRemoveCommand(domain, owner, feature, collection);
	}
}
