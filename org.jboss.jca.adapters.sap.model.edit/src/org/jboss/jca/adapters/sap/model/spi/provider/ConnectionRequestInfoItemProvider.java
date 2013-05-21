/**
 */
package org.jboss.jca.adapters.sap.model.spi.provider;


import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
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
import org.jboss.jca.adapters.sap.model.edit.JBossSapJcaEditPlugin;
import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;

/**
 * This is the item provider adapter for a {@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ConnectionRequestInfoItemProvider
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
	public ConnectionRequestInfoItemProvider(AdapterFactory adapterFactory) {
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

			addAliasUserPropertyDescriptor(object);
			addAshostPropertyDescriptor(object);
			addAuthTypePropertyDescriptor(object);
			addClientPropertyDescriptor(object);
			addCodepagePropertyDescriptor(object);
			addCpicTracePropertyDescriptor(object);
			addDenyInitialPasswordPropertyDescriptor(object);
			addExpirationPeriodPropertyDescriptor(object);
			addExpirationTimePropertyDescriptor(object);
			addGetsso2PropertyDescriptor(object);
			addGroupPropertyDescriptor(object);
			addGwhostPropertyDescriptor(object);
			addGwservPropertyDescriptor(object);
			addLangPropertyDescriptor(object);
			addLcheckPropertyDescriptor(object);
			addMaxGetTimePropertyDescriptor(object);
			addMshostPropertyDescriptor(object);
			addMsservPropertyDescriptor(object);
			addMysapsso2PropertyDescriptor(object);
			addPasswdPropertyDescriptor(object);
			addPasswordPropertyDescriptor(object);
			addPcsPropertyDescriptor(object);
			addPeakLimitPropertyDescriptor(object);
			addPingOnCreatePropertyDescriptor(object);
			addPoolCapacityPropertyDescriptor(object);
			addR3namePropertyDescriptor(object);
			addRepositoryDestPropertyDescriptor(object);
			addRepositoryPasswdPropertyDescriptor(object);
			addRepositoryRoundtripOptimizationPropertyDescriptor(object);
			addRepositorySncPropertyDescriptor(object);
			addRepositoryUserPropertyDescriptor(object);
			addSaprouterPropertyDescriptor(object);
			addSncLibraryPropertyDescriptor(object);
			addSncModePropertyDescriptor(object);
			addSncMynamePropertyDescriptor(object);
			addSncPartnernamePropertyDescriptor(object);
			addSncQopPropertyDescriptor(object);
			addSysnrPropertyDescriptor(object);
			addTphostPropertyDescriptor(object);
			addTpnamePropertyDescriptor(object);
			addTracePropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addUserNamePropertyDescriptor(object);
			addUserPropertyDescriptor(object);
			addUserIdPropertyDescriptor(object);
			addUseSapguiPropertyDescriptor(object);
			addX509certPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_ConnectionRequestInfo_aliasUser_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_aliasUser_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__ALIAS_USER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Ashost feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAshostPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_ashost_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_ashost_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__ASHOST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Auth Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAuthTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_authType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_authType_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__AUTH_TYPE,
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
				 getString("_UI_ConnectionRequestInfo_client_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_client_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__CLIENT,
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
				 getString("_UI_ConnectionRequestInfo_codepage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_codepage_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__CODEPAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Cpic Trace feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCpicTracePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_cpicTrace_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_cpicTrace_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__CPIC_TRACE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Deny Initial Password feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDenyInitialPasswordPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_denyInitialPassword_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_denyInitialPassword_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__DENY_INITIAL_PASSWORD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Expiration Period feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExpirationPeriodPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_expirationPeriod_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_expirationPeriod_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__EXPIRATION_PERIOD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Expiration Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExpirationTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_expirationTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_expirationTime_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__EXPIRATION_TIME,
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
				 getString("_UI_ConnectionRequestInfo_getsso2_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_getsso2_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__GETSSO2,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Group feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGroupPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_group_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_group_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__GROUP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Gwhost feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGwhostPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_gwhost_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_gwhost_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__GWHOST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Gwserv feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGwservPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_gwserv_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_gwserv_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__GWSERV,
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
				 getString("_UI_ConnectionRequestInfo_lang_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_lang_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__LANG,
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
				 getString("_UI_ConnectionRequestInfo_lcheck_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_lcheck_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__LCHECK,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Get Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxGetTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_maxGetTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_maxGetTime_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__MAX_GET_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mshost feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMshostPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_mshost_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_mshost_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__MSHOST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Msserv feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMsservPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_msserv_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_msserv_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__MSSERV,
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
				 getString("_UI_ConnectionRequestInfo_mysapsso2_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_mysapsso2_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__MYSAPSSO2,
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
				 getString("_UI_ConnectionRequestInfo_passwd_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_passwd_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__PASSWD,
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
				 getString("_UI_ConnectionRequestInfo_password_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_password_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__PASSWORD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Pcs feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPcsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_pcs_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_pcs_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__PCS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Peak Limit feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPeakLimitPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_peakLimit_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_peakLimit_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__PEAK_LIMIT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Ping On Create feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPingOnCreatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_pingOnCreate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_pingOnCreate_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__PING_ON_CREATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Pool Capacity feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPoolCapacityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_poolCapacity_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_poolCapacity_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__POOL_CAPACITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the R3name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addR3namePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_r3name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_r3name_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__R3NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Repository Dest feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRepositoryDestPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_repositoryDest_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_repositoryDest_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__REPOSITORY_DEST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Repository Passwd feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRepositoryPasswdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_repositoryPasswd_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_repositoryPasswd_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__REPOSITORY_PASSWD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Repository Roundtrip Optimization feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRepositoryRoundtripOptimizationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_repositoryRoundtripOptimization_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_repositoryRoundtripOptimization_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__REPOSITORY_ROUNDTRIP_OPTIMIZATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Repository Snc feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRepositorySncPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_repositorySnc_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_repositorySnc_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__REPOSITORY_SNC,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Repository User feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRepositoryUserPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_repositoryUser_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_repositoryUser_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__REPOSITORY_USER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Saprouter feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSaprouterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_saprouter_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_saprouter_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__SAPROUTER,
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
				 getString("_UI_ConnectionRequestInfo_sncLibrary_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_sncLibrary_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__SNC_LIBRARY,
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
				 getString("_UI_ConnectionRequestInfo_sncMode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_sncMode_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__SNC_MODE,
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
				 getString("_UI_ConnectionRequestInfo_sncMyname_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_sncMyname_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__SNC_MYNAME,
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
				 getString("_UI_ConnectionRequestInfo_sncPartnername_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_sncPartnername_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__SNC_PARTNERNAME,
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
				 getString("_UI_ConnectionRequestInfo_sncQop_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_sncQop_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__SNC_QOP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sysnr feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSysnrPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_sysnr_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_sysnr_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__SYSNR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Tphost feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTphostPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_tphost_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_tphost_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__TPHOST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Tpname feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTpnamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_tpname_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_tpname_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__TPNAME,
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
				 getString("_UI_ConnectionRequestInfo_trace_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_trace_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__TRACE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_type_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
				 getString("_UI_ConnectionRequestInfo_userName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_userName_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__USER_NAME,
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
				 getString("_UI_ConnectionRequestInfo_user_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_user_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__USER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the User Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUserIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConnectionRequestInfo_userId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_userId_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__USER_ID,
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
				 getString("_UI_ConnectionRequestInfo_useSapgui_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_useSapgui_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__USE_SAPGUI,
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
				 getString("_UI_ConnectionRequestInfo_x509cert_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionRequestInfo_x509cert_feature", "_UI_ConnectionRequestInfo_type"),
				 SpiPackage.Literals.CONNECTION_REQUEST_INFO__X509CERT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns ConnectionRequestInfo.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ConnectionRequestInfo"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ConnectionRequestInfo)object).getR3name();
		return label == null || label.length() == 0 ?
			getString("_UI_ConnectionRequestInfo_type") :
			getString("_UI_ConnectionRequestInfo_type") + " " + label;
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

		switch (notification.getFeatureID(ConnectionRequestInfo.class)) {
			case SpiPackage.CONNECTION_REQUEST_INFO__ENTRIES:
			case SpiPackage.CONNECTION_REQUEST_INFO__ALIAS_USER:
			case SpiPackage.CONNECTION_REQUEST_INFO__ASHOST:
			case SpiPackage.CONNECTION_REQUEST_INFO__AUTH_TYPE:
			case SpiPackage.CONNECTION_REQUEST_INFO__CLIENT:
			case SpiPackage.CONNECTION_REQUEST_INFO__CODEPAGE:
			case SpiPackage.CONNECTION_REQUEST_INFO__CPIC_TRACE:
			case SpiPackage.CONNECTION_REQUEST_INFO__DENY_INITIAL_PASSWORD:
			case SpiPackage.CONNECTION_REQUEST_INFO__EXPIRATION_PERIOD:
			case SpiPackage.CONNECTION_REQUEST_INFO__EXPIRATION_TIME:
			case SpiPackage.CONNECTION_REQUEST_INFO__GETSSO2:
			case SpiPackage.CONNECTION_REQUEST_INFO__GROUP:
			case SpiPackage.CONNECTION_REQUEST_INFO__GWHOST:
			case SpiPackage.CONNECTION_REQUEST_INFO__GWSERV:
			case SpiPackage.CONNECTION_REQUEST_INFO__LANG:
			case SpiPackage.CONNECTION_REQUEST_INFO__LCHECK:
			case SpiPackage.CONNECTION_REQUEST_INFO__MAX_GET_TIME:
			case SpiPackage.CONNECTION_REQUEST_INFO__MSHOST:
			case SpiPackage.CONNECTION_REQUEST_INFO__MSSERV:
			case SpiPackage.CONNECTION_REQUEST_INFO__MYSAPSSO2:
			case SpiPackage.CONNECTION_REQUEST_INFO__PASSWD:
			case SpiPackage.CONNECTION_REQUEST_INFO__PASSWORD:
			case SpiPackage.CONNECTION_REQUEST_INFO__PCS:
			case SpiPackage.CONNECTION_REQUEST_INFO__PEAK_LIMIT:
			case SpiPackage.CONNECTION_REQUEST_INFO__PING_ON_CREATE:
			case SpiPackage.CONNECTION_REQUEST_INFO__POOL_CAPACITY:
			case SpiPackage.CONNECTION_REQUEST_INFO__R3NAME:
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_DEST:
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_PASSWD:
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_ROUNDTRIP_OPTIMIZATION:
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_SNC:
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_USER:
			case SpiPackage.CONNECTION_REQUEST_INFO__SAPROUTER:
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_LIBRARY:
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_MODE:
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_MYNAME:
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_PARTNERNAME:
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_QOP:
			case SpiPackage.CONNECTION_REQUEST_INFO__SYSNR:
			case SpiPackage.CONNECTION_REQUEST_INFO__TPHOST:
			case SpiPackage.CONNECTION_REQUEST_INFO__TPNAME:
			case SpiPackage.CONNECTION_REQUEST_INFO__TRACE:
			case SpiPackage.CONNECTION_REQUEST_INFO__TYPE:
			case SpiPackage.CONNECTION_REQUEST_INFO__USER_NAME:
			case SpiPackage.CONNECTION_REQUEST_INFO__USER:
			case SpiPackage.CONNECTION_REQUEST_INFO__USER_ID:
			case SpiPackage.CONNECTION_REQUEST_INFO__USE_SAPGUI:
			case SpiPackage.CONNECTION_REQUEST_INFO__X509CERT:
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
	
	@Override
	protected Command createSetCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Object value) {
		return new SetCommand(domain, owner, feature, value) {
			@Override
			public Collection<?> doGetAffectedObjects() {
				return Collections.singleton(owner.eContainer());
			}
		};
	}
	
}
