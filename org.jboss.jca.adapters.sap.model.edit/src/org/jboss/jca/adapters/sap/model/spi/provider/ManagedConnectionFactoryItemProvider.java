/**
 */
package org.jboss.jca.adapters.sap.model.spi.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.model.spi.SpiFactory;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;

/**
 * This is the item provider adapter for a {@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ManagedConnectionFactoryItemProvider
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
	public ManagedConnectionFactoryItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

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
			addDefaultConnectionNamePropertyDescriptor(object);
			addLogWriterPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}
	
	/**
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addStatePropertyDescriptor(object);
			addDefaultConnectionNamePropertyDescriptor(object);
			addLogWriterPropertyDescriptor(object);
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
				 getString("_UI_ManagedConnectionFactory_state_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManagedConnectionFactory_state_feature", "_UI_ManagedConnectionFactory_type"),
				 SpiPackage.Literals.MANAGED_CONNECTION_FACTORY__STATE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Default Connection Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultConnectionNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ManagedConnectionFactory_defaultConnectionName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManagedConnectionFactory_defaultConnectionName_feature", "_UI_ManagedConnectionFactory_type"),
				 SpiPackage.Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_NAME,
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
				 getString("_UI_ManagedConnectionFactory_logWriter_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManagedConnectionFactory_logWriter_feature", "_UI_ManagedConnectionFactory_type"),
				 SpiPackage.Literals.MANAGED_CONNECTION_FACTORY__LOG_WRITER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
			childrenFeatures.add(SpiPackage.Literals.MANAGED_CONNECTION_FACTORY__MANAGED_CONNECTIONS);
			childrenFeatures.add(SpiPackage.Literals.MANAGED_CONNECTION_FACTORY__CONNECTION_FACTORIES);
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
	 * This returns ManagedConnectionFactory.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ManagedConnectionFactory"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ManagedConnectionFactory)object).getDefaultConnectionName();
		return label == null || label.length() == 0 ?
			getString("_UI_ManagedConnectionFactory_type") :
			getString("_UI_ManagedConnectionFactory_type") + " " + label;
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

		switch (notification.getFeatureID(ManagedConnectionFactory.class)) {
			case SpiPackage.MANAGED_CONNECTION_FACTORY__STATE:
			case SpiPackage.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_NAME:
			case SpiPackage.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO:
			case SpiPackage.MANAGED_CONNECTION_FACTORY__PACKAGE_REGISTRY:
			case SpiPackage.MANAGED_CONNECTION_FACTORY__LOG_WRITER:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case SpiPackage.MANAGED_CONNECTION_FACTORY__MANAGED_CONNECTIONS:
			case SpiPackage.MANAGED_CONNECTION_FACTORY__CONNECTION_FACTORIES:
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
				(SpiPackage.Literals.MANAGED_CONNECTION_FACTORY__MANAGED_CONNECTIONS,
				 SpiFactory.eINSTANCE.createManagedConnection()));

		newChildDescriptors.add
			(createChildParameter
				(SpiPackage.Literals.MANAGED_CONNECTION_FACTORY__CONNECTION_FACTORIES,
				 CciFactory.eINSTANCE.createConnectionFactory()));
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
	
//	/*
//	 * @generated
//	 */
//	@Override
//	protected Command createAddCommand(EditingDomain domain, EObject owner,
//			EStructuralFeature feature, Collection<?> collection, int index) {
//		if (feature == SpiPackage.Literals.MANAGED_CONNECTION_FACTORY__MANAGED_CONNECTIONS) {
//			return new AddManagedConnectionCommand(domain, (ManagedConnectionFactory) owner, feature, collection);
//		}
//		return super.createAddCommand(domain, owner, feature, collection, index);
//	}
//	
//	/*
//	 * @generated
//	 */
//	@Override
//	protected Command createRemoveCommand(EditingDomain domain, EObject owner,
//			EStructuralFeature feature, Collection<?> collection) {
//		if (feature == SpiPackage.Literals.MANAGED_CONNECTION_FACTORY__MANAGED_CONNECTIONS) {
//			return new RemoveManagedConnectionCommand(domain, (ManagedConnectionFactory) owner, feature, collection);
//		}
//		return super.createRemoveCommand(domain, owner, feature, collection);
//	}
//	
//	/*
//	 * @generated
//	 */
//	@Override
//	protected Command createSetCommand(EditingDomain domain, EObject owner,
//			EStructuralFeature feature, Object value) {
//		
//		// Prevent the default connection request info from being deleted or modified.
//		if (feature == SpiPackage.Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO) {
//			return UnexecutableCommand.INSTANCE;
//		}
//
//		return super.createSetCommand(domain, owner, feature, value);
//	}
	
}
