/**
 */
package org.jboss.jca.adapters.sap.model.cci.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

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

import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.cci.ConnectionSpec;
import org.jboss.jca.adapters.sap.model.edit.JBossSapJcaEditPlugin;

/**
 * This is the item provider adapter for a {@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ConnectionSpecItemProvider
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
	public ConnectionSpecItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addUserNamePropertyDescriptor(object);
			addPasswordPropertyDescriptor(object);
			addClientPropertyDescriptor(object);
			addUserPropertyDescriptor(object);
			addAliasUserPropertyDescriptor(object);
			addPasswdPropertyDescriptor(object);
			addLangPropertyDescriptor(object);
			addMysapsso2PropertyDescriptor(object);
			addGetsso2PropertyDescriptor(object);
			addX509certPropertyDescriptor(object);
			addLcheckPropertyDescriptor(object);
			addCodepagePropertyDescriptor(object);
			addTracePropertyDescriptor(object);
			addUseSapguiPropertyDescriptor(object);
			addSncLibraryPropertyDescriptor(object);
			addSncModePropertyDescriptor(object);
			addSncMynamePropertyDescriptor(object);
			addSncPartnernamePropertyDescriptor(object);
			addSncQopPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the User Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUserNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionSpec_userName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_userName_feature", "_UI_ConnectionSpec_type"),
				 CciPackage.Literals.CONNECTION_SPEC__USER_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Password feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPasswordPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionSpec_password_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_password_feature", "_UI_ConnectionSpec_type"),
				 CciPackage.Literals.CONNECTION_SPEC__PASSWORD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Client feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClientPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionSpec_client_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_client_feature", "_UI_ConnectionSpec_type"),
				 CciPackage.Literals.CONNECTION_SPEC__CLIENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the User feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUserPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionSpec_user_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_user_feature", "_UI_ConnectionSpec_type"),
				 CciPackage.Literals.CONNECTION_SPEC__USER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Alias User feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAliasUserPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionSpec_aliasUser_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_aliasUser_feature", "_UI_ConnectionSpec_type"),
				 CciPackage.Literals.CONNECTION_SPEC__ALIAS_USER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Passwd feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPasswdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionSpec_passwd_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_passwd_feature", "_UI_ConnectionSpec_type"),
				 CciPackage.Literals.CONNECTION_SPEC__PASSWD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Lang feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLangPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionSpec_lang_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_lang_feature", "_UI_ConnectionSpec_type"),
				 CciPackage.Literals.CONNECTION_SPEC__LANG,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mysapsso2 feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMysapsso2PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionSpec_mysapsso2_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_mysapsso2_feature", "_UI_ConnectionSpec_type"),
				 CciPackage.Literals.CONNECTION_SPEC__MYSAPSSO2,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Getsso2 feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGetsso2PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionSpec_getsso2_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_getsso2_feature", "_UI_ConnectionSpec_type"),
				 CciPackage.Literals.CONNECTION_SPEC__GETSSO2,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the X50 9cert feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addX509certPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionSpec_x509cert_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_x509cert_feature", "_UI_ConnectionSpec_type"),
				 CciPackage.Literals.CONNECTION_SPEC__X509CERT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Lcheck feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLcheckPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionSpec_lcheck_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_lcheck_feature", "_UI_ConnectionSpec_type"),
				 CciPackage.Literals.CONNECTION_SPEC__LCHECK,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Codepage feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCodepagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionSpec_codepage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_codepage_feature", "_UI_ConnectionSpec_type"),
				 CciPackage.Literals.CONNECTION_SPEC__CODEPAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTracePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionSpec_trace_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_trace_feature", "_UI_ConnectionSpec_type"),
				 CciPackage.Literals.CONNECTION_SPEC__TRACE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Use Sapgui feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUseSapguiPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionSpec_useSapgui_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_useSapgui_feature", "_UI_ConnectionSpec_type"),
				 CciPackage.Literals.CONNECTION_SPEC__USE_SAPGUI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Snc Library feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSncLibraryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionSpec_sncLibrary_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_sncLibrary_feature", "_UI_ConnectionSpec_type"),
				 CciPackage.Literals.CONNECTION_SPEC__SNC_LIBRARY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Snc Mode feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSncModePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionSpec_sncMode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_sncMode_feature", "_UI_ConnectionSpec_type"),
				 CciPackage.Literals.CONNECTION_SPEC__SNC_MODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Snc Myname feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSncMynamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionSpec_sncMyname_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_sncMyname_feature", "_UI_ConnectionSpec_type"),
				 CciPackage.Literals.CONNECTION_SPEC__SNC_MYNAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Snc Partnername feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSncPartnernamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionSpec_sncPartnername_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_sncPartnername_feature", "_UI_ConnectionSpec_type"),
				 CciPackage.Literals.CONNECTION_SPEC__SNC_PARTNERNAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Snc Qop feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSncQopPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionSpec_sncQop_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_sncQop_feature", "_UI_ConnectionSpec_type"),
				 CciPackage.Literals.CONNECTION_SPEC__SNC_QOP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns ConnectionSpec.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ConnectionSpec"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ConnectionSpec)object).getUserName();
		return label == null || label.length() == 0 ?
			getString("_UI_ConnectionSpec_type") :
			getString("_UI_ConnectionSpec_type") + " " + label;
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

		switch (notification.getFeatureID(ConnectionSpec.class)) {
			case CciPackage.CONNECTION_SPEC__USER_NAME:
			case CciPackage.CONNECTION_SPEC__PASSWORD:
			case CciPackage.CONNECTION_SPEC__CLIENT:
			case CciPackage.CONNECTION_SPEC__USER:
			case CciPackage.CONNECTION_SPEC__ALIAS_USER:
			case CciPackage.CONNECTION_SPEC__PASSWD:
			case CciPackage.CONNECTION_SPEC__LANG:
			case CciPackage.CONNECTION_SPEC__MYSAPSSO2:
			case CciPackage.CONNECTION_SPEC__GETSSO2:
			case CciPackage.CONNECTION_SPEC__X509CERT:
			case CciPackage.CONNECTION_SPEC__LCHECK:
			case CciPackage.CONNECTION_SPEC__CODEPAGE:
			case CciPackage.CONNECTION_SPEC__TRACE:
			case CciPackage.CONNECTION_SPEC__USE_SAPGUI:
			case CciPackage.CONNECTION_SPEC__SNC_LIBRARY:
			case CciPackage.CONNECTION_SPEC__SNC_MODE:
			case CciPackage.CONNECTION_SPEC__SNC_MYNAME:
			case CciPackage.CONNECTION_SPEC__SNC_PARTNERNAME:
			case CciPackage.CONNECTION_SPEC__SNC_QOP:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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

}
