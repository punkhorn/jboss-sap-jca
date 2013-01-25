/**
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 * 
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 * 
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 * 
 */
package org.jboss.jca.adapters.sap.cci.provider;


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

import org.jboss.jca.adapters.sap.cci.ConnectionSpec;

import org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl;

/**
 * This is the item provider adapter for a {@link org.jboss.jca.adapters.sap.cci.ConnectionSpec} object.
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
			addAuthTypePropertyDescriptor(object);
			addUserIdPropertyDescriptor(object);
			addClientPropertyDescriptor(object);
			addUserPropertyDescriptor(object);
			addAliasUserPropertyDescriptor(object);
			addPasswdPropertyDescriptor(object);
			addLangPropertyDescriptor(object);
			addMysapsso2PropertyDescriptor(object);
			addX509certPropertyDescriptor(object);
			addPcsPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addSaprouterPropertyDescriptor(object);
			addSysnrPropertyDescriptor(object);
			addAshostPropertyDescriptor(object);
			addMshostPropertyDescriptor(object);
			addMsservPropertyDescriptor(object);
			addGwhostPropertyDescriptor(object);
			addGwservPropertyDescriptor(object);
			addTphostPropertyDescriptor(object);
			addTpnamePropertyDescriptor(object);
			addR3namePropertyDescriptor(object);
			addGroupPropertyDescriptor(object);
			addTracePropertyDescriptor(object);
			addCpicTracePropertyDescriptor(object);
			addLcheckPropertyDescriptor(object);
			addUseSapguiPropertyDescriptor(object);
			addCodepagePropertyDescriptor(object);
			addGetsso2PropertyDescriptor(object);
			addDenyInitialPasswordPropertyDescriptor(object);
			addPeakLimitPropertyDescriptor(object);
			addPoolCapacityPropertyDescriptor(object);
			addExpirationTimePropertyDescriptor(object);
			addExpirationPeriodPropertyDescriptor(object);
			addMaxGetTimePropertyDescriptor(object);
			addSncModePropertyDescriptor(object);
			addSncPartnernamePropertyDescriptor(object);
			addSncQopPropertyDescriptor(object);
			addSncMynamePropertyDescriptor(object);
			addSncLibraryPropertyDescriptor(object);
			addRepositoryDestPropertyDescriptor(object);
			addRepositoryUserPropertyDescriptor(object);
			addRepositoryPasswdPropertyDescriptor(object);
			addRepositorySncPropertyDescriptor(object);
			addRepositoryRoundtripOptimizationPropertyDescriptor(object);
			addPingOnCreatePropertyDescriptor(object);
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
				 CciPackageImpl.Literals.CONNECTION_SPEC__USER_NAME,
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
				 CciPackageImpl.Literals.CONNECTION_SPEC__PASSWORD,
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
				 getString("_UI_ConnectionSpec_authType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_authType_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__AUTH_TYPE,
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
				 getString("_UI_ConnectionSpec_userId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_userId_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__USER_ID,
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
				 CciPackageImpl.Literals.CONNECTION_SPEC__CLIENT,
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
				 CciPackageImpl.Literals.CONNECTION_SPEC__USER,
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
				 CciPackageImpl.Literals.CONNECTION_SPEC__ALIAS_USER,
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
				 CciPackageImpl.Literals.CONNECTION_SPEC__PASSWD,
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
				 CciPackageImpl.Literals.CONNECTION_SPEC__LANG,
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
				 CciPackageImpl.Literals.CONNECTION_SPEC__MYSAPSSO2,
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
				 CciPackageImpl.Literals.CONNECTION_SPEC__X509CERT,
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
				 getString("_UI_ConnectionSpec_pcs_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_pcs_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__PCS,
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
				 getString("_UI_ConnectionSpec_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_type_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__TYPE,
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
				 getString("_UI_ConnectionSpec_saprouter_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_saprouter_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__SAPROUTER,
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
				 getString("_UI_ConnectionSpec_sysnr_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_sysnr_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__SYSNR,
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
				 getString("_UI_ConnectionSpec_ashost_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_ashost_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__ASHOST,
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
				 getString("_UI_ConnectionSpec_mshost_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_mshost_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__MSHOST,
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
				 getString("_UI_ConnectionSpec_msserv_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_msserv_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__MSSERV,
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
				 getString("_UI_ConnectionSpec_gwhost_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_gwhost_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__GWHOST,
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
				 getString("_UI_ConnectionSpec_gwserv_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_gwserv_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__GWSERV,
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
				 getString("_UI_ConnectionSpec_tphost_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_tphost_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__TPHOST,
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
				 getString("_UI_ConnectionSpec_tpname_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_tpname_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__TPNAME,
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
				 getString("_UI_ConnectionSpec_r3name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_r3name_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__R3NAME,
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
				 getString("_UI_ConnectionSpec_group_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_group_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__GROUP,
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
				 CciPackageImpl.Literals.CONNECTION_SPEC__TRACE,
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
				 getString("_UI_ConnectionSpec_cpicTrace_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_cpicTrace_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__CPIC_TRACE,
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
				 CciPackageImpl.Literals.CONNECTION_SPEC__LCHECK,
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
				 CciPackageImpl.Literals.CONNECTION_SPEC__USE_SAPGUI,
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
				 CciPackageImpl.Literals.CONNECTION_SPEC__CODEPAGE,
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
				 CciPackageImpl.Literals.CONNECTION_SPEC__GETSSO2,
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
				 getString("_UI_ConnectionSpec_denyInitialPassword_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_denyInitialPassword_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__DENY_INITIAL_PASSWORD,
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
				 getString("_UI_ConnectionSpec_peakLimit_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_peakLimit_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__PEAK_LIMIT,
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
				 getString("_UI_ConnectionSpec_poolCapacity_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_poolCapacity_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__POOL_CAPACITY,
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
				 getString("_UI_ConnectionSpec_expirationTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_expirationTime_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__EXPIRATION_TIME,
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
				 getString("_UI_ConnectionSpec_expirationPeriod_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_expirationPeriod_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__EXPIRATION_PERIOD,
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
				 getString("_UI_ConnectionSpec_maxGetTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_maxGetTime_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__MAX_GET_TIME,
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
				 CciPackageImpl.Literals.CONNECTION_SPEC__SNC_MODE,
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
				 CciPackageImpl.Literals.CONNECTION_SPEC__SNC_PARTNERNAME,
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
				 CciPackageImpl.Literals.CONNECTION_SPEC__SNC_QOP,
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
				 CciPackageImpl.Literals.CONNECTION_SPEC__SNC_MYNAME,
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
				 CciPackageImpl.Literals.CONNECTION_SPEC__SNC_LIBRARY,
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
				 getString("_UI_ConnectionSpec_repositoryDest_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_repositoryDest_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__REPOSITORY_DEST,
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
				 getString("_UI_ConnectionSpec_repositoryUser_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_repositoryUser_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__REPOSITORY_USER,
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
				 getString("_UI_ConnectionSpec_repositoryPasswd_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_repositoryPasswd_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__REPOSITORY_PASSWD,
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
				 getString("_UI_ConnectionSpec_repositorySnc_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_repositorySnc_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__REPOSITORY_SNC,
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
				 getString("_UI_ConnectionSpec_repositoryRoundtripOptimization_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_repositoryRoundtripOptimization_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__REPOSITORY_ROUNDTRIP_OPTIMIZATION,
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
				 getString("_UI_ConnectionSpec_pingOnCreate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConnectionSpec_pingOnCreate_feature", "_UI_ConnectionSpec_type"),
				 CciPackageImpl.Literals.CONNECTION_SPEC__PING_ON_CREATE,
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
			case CciPackageImpl.CONNECTION_SPEC__USER_NAME:
			case CciPackageImpl.CONNECTION_SPEC__PASSWORD:
			case CciPackageImpl.CONNECTION_SPEC__AUTH_TYPE:
			case CciPackageImpl.CONNECTION_SPEC__USER_ID:
			case CciPackageImpl.CONNECTION_SPEC__CLIENT:
			case CciPackageImpl.CONNECTION_SPEC__USER:
			case CciPackageImpl.CONNECTION_SPEC__ALIAS_USER:
			case CciPackageImpl.CONNECTION_SPEC__PASSWD:
			case CciPackageImpl.CONNECTION_SPEC__LANG:
			case CciPackageImpl.CONNECTION_SPEC__MYSAPSSO2:
			case CciPackageImpl.CONNECTION_SPEC__X509CERT:
			case CciPackageImpl.CONNECTION_SPEC__PCS:
			case CciPackageImpl.CONNECTION_SPEC__TYPE:
			case CciPackageImpl.CONNECTION_SPEC__SAPROUTER:
			case CciPackageImpl.CONNECTION_SPEC__SYSNR:
			case CciPackageImpl.CONNECTION_SPEC__ASHOST:
			case CciPackageImpl.CONNECTION_SPEC__MSHOST:
			case CciPackageImpl.CONNECTION_SPEC__MSSERV:
			case CciPackageImpl.CONNECTION_SPEC__GWHOST:
			case CciPackageImpl.CONNECTION_SPEC__GWSERV:
			case CciPackageImpl.CONNECTION_SPEC__TPHOST:
			case CciPackageImpl.CONNECTION_SPEC__TPNAME:
			case CciPackageImpl.CONNECTION_SPEC__R3NAME:
			case CciPackageImpl.CONNECTION_SPEC__GROUP:
			case CciPackageImpl.CONNECTION_SPEC__TRACE:
			case CciPackageImpl.CONNECTION_SPEC__CPIC_TRACE:
			case CciPackageImpl.CONNECTION_SPEC__LCHECK:
			case CciPackageImpl.CONNECTION_SPEC__USE_SAPGUI:
			case CciPackageImpl.CONNECTION_SPEC__CODEPAGE:
			case CciPackageImpl.CONNECTION_SPEC__GETSSO2:
			case CciPackageImpl.CONNECTION_SPEC__DENY_INITIAL_PASSWORD:
			case CciPackageImpl.CONNECTION_SPEC__PEAK_LIMIT:
			case CciPackageImpl.CONNECTION_SPEC__POOL_CAPACITY:
			case CciPackageImpl.CONNECTION_SPEC__EXPIRATION_TIME:
			case CciPackageImpl.CONNECTION_SPEC__EXPIRATION_PERIOD:
			case CciPackageImpl.CONNECTION_SPEC__MAX_GET_TIME:
			case CciPackageImpl.CONNECTION_SPEC__SNC_MODE:
			case CciPackageImpl.CONNECTION_SPEC__SNC_PARTNERNAME:
			case CciPackageImpl.CONNECTION_SPEC__SNC_QOP:
			case CciPackageImpl.CONNECTION_SPEC__SNC_MYNAME:
			case CciPackageImpl.CONNECTION_SPEC__SNC_LIBRARY:
			case CciPackageImpl.CONNECTION_SPEC__REPOSITORY_DEST:
			case CciPackageImpl.CONNECTION_SPEC__REPOSITORY_USER:
			case CciPackageImpl.CONNECTION_SPEC__REPOSITORY_PASSWD:
			case CciPackageImpl.CONNECTION_SPEC__REPOSITORY_SNC:
			case CciPackageImpl.CONNECTION_SPEC__REPOSITORY_ROUNDTRIP_OPTIMIZATION:
			case CciPackageImpl.CONNECTION_SPEC__PING_ON_CREATE:
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
