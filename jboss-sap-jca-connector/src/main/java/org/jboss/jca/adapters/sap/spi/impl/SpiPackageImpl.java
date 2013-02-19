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
package org.jboss.jca.adapters.sap.spi.impl;

import com.sap.conn.jco.JCoDestination;

import java.io.PrintWriter;

import java.util.Map;

import java.util.Set;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.DissociatableManagedConnection;
import javax.resource.spi.LocalTransaction;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.resource.spi.ManagedConnectionMetaData;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterAssociation;
import javax.resource.spi.ResourceAdapterInternalException;

import javax.resource.spi.endpoint.MessageEndpointFactory;

import javax.resource.spi.security.PasswordCredential;

import javax.security.auth.Subject;

import javax.transaction.xa.XAResource;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl;

import org.jboss.jca.adapters.sap.spi.DefaultConnectionManager;
import org.jboss.jca.adapters.sap.spi.NonManagedEnvironmentAdmin;
import org.jboss.jca.adapters.sap.spi.SpiFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.jboss.jca.adapters.sap.spi.SpiFactory
 * @model kind="package"
 * @generated
 */
public class SpiPackageImpl extends EPackageImpl {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "spi";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "http://sap.adapters.jca.jboss.org/spi";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "spi";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final SpiPackageImpl eINSTANCE = org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl.init();

	/**
	 * The meta object id for the '{@link javax.resource.spi.ConnectionRequestInfo <em>SPI Connection Request Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.spi.ConnectionRequestInfo
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getSPIConnectionRequestInfo()
	 * @generated
	 */
	public static final int SPI_CONNECTION_REQUEST_INFO = 0;

	/**
	 * The number of structural features of the '<em>SPI Connection Request Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SPI_CONNECTION_REQUEST_INFO_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link javax.resource.spi.ConnectionManager <em>SPI Connection Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.spi.ConnectionManager
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getSPIConnectionManager()
	 * @generated
	 */
	public static final int SPI_CONNECTION_MANAGER = 1;

	/**
	 * The number of structural features of the '<em>SPI Connection Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SPI_CONNECTION_MANAGER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link javax.resource.spi.LocalTransaction <em>SPI Local Transaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.spi.LocalTransaction
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getSPILocalTransaction()
	 * @generated
	 */
	public static final int SPI_LOCAL_TRANSACTION = 2;

	/**
	 * The number of structural features of the '<em>SPI Local Transaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SPI_LOCAL_TRANSACTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link javax.resource.spi.ManagedConnectionFactory <em>SPI Managed Connection Factory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.spi.ManagedConnectionFactory
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getSPIManagedConnectionFactory()
	 * @generated
	 */
	public static final int SPI_MANAGED_CONNECTION_FACTORY = 3;

	/**
	 * The number of structural features of the '<em>SPI Managed Connection Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SPI_MANAGED_CONNECTION_FACTORY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link javax.resource.spi.ResourceAdapterAssociation <em>SPI Resource Adapter Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.spi.ResourceAdapterAssociation
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getSPIResourceAdapterAssociation()
	 * @generated
	 */
	public static final int SPI_RESOURCE_ADAPTER_ASSOCIATION = 4;

	/**
	 * The number of structural features of the '<em>SPI Resource Adapter Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SPI_RESOURCE_ADAPTER_ASSOCIATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link javax.resource.spi.ManagedConnection <em>SPI Managed Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.spi.ManagedConnection
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getSPIManagedConnection()
	 * @generated
	 */
	public static final int SPI_MANAGED_CONNECTION = 5;

	/**
	 * The number of structural features of the '<em>SPI Managed Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SPI_MANAGED_CONNECTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link javax.resource.spi.DissociatableManagedConnection <em>SPI Dissociatable Managed Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.spi.DissociatableManagedConnection
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getSPIDissociatableManagedConnection()
	 * @generated
	 */
	public static final int SPI_DISSOCIATABLE_MANAGED_CONNECTION = 6;

	/**
	 * The number of structural features of the '<em>SPI Dissociatable Managed Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SPI_DISSOCIATABLE_MANAGED_CONNECTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link javax.resource.spi.ManagedConnectionMetaData <em>SPI Managed Connection Meta Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.spi.ManagedConnectionMetaData
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getSPIManagedConnectionMetaData()
	 * @generated
	 */
	public static final int SPI_MANAGED_CONNECTION_META_DATA = 7;

	/**
	 * The number of structural features of the '<em>SPI Managed Connection Meta Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SPI_MANAGED_CONNECTION_META_DATA_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link javax.resource.spi.ResourceAdapter <em>SPI Resource Adapter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.spi.ResourceAdapter
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getSPIResourceAdapter()
	 * @generated
	 */
	public static final int SPI_RESOURCE_ADAPTER = 8;

	/**
	 * The number of structural features of the '<em>SPI Resource Adapter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SPI_RESOURCE_ADAPTER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.spi.impl.ConnectionRequestInfoImpl <em>Connection Request Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.spi.impl.ConnectionRequestInfoImpl
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getConnectionRequestInfo()
	 * @generated
	 */
	public static final int CONNECTION_REQUEST_INFO = 9;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_REQUEST_INFO__PROPERTIES = SPI_CONNECTION_REQUEST_INFO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Connection Request Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_REQUEST_INFO_FEATURE_COUNT = SPI_CONNECTION_REQUEST_INFO_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.spi.impl.DefaultConnectionManagerImpl <em>Default Connection Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.spi.impl.DefaultConnectionManagerImpl
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getDefaultConnectionManager()
	 * @generated
	 */
	public static final int DEFAULT_CONNECTION_MANAGER = 10;

	/**
	 * The number of structural features of the '<em>Default Connection Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DEFAULT_CONNECTION_MANAGER_FEATURE_COUNT = SPI_CONNECTION_MANAGER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.spi.impl.LocalTransactionImpl <em>Local Transaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.spi.impl.LocalTransactionImpl
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getLocalTransaction()
	 * @generated
	 */
	public static final int LOCAL_TRANSACTION = 11;

	/**
	 * The number of structural features of the '<em>Local Transaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOCAL_TRANSACTION_FEATURE_COUNT = SPI_LOCAL_TRANSACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionFactoryImpl <em>Managed Connection Factory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionFactoryImpl
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getManagedConnectionFactory()
	 * @generated
	 */
	public static final int MANAGED_CONNECTION_FACTORY = 12;

	/**
	 * The number of structural features of the '<em>Managed Connection Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MANAGED_CONNECTION_FACTORY_FEATURE_COUNT = SPI_MANAGED_CONNECTION_FACTORY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionImpl <em>Managed Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionImpl
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getManagedConnection()
	 * @generated
	 */
	public static final int MANAGED_CONNECTION = 13;

	/**
	 * The number of structural features of the '<em>Managed Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MANAGED_CONNECTION_FEATURE_COUNT = SPI_MANAGED_CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionMetaDataImpl <em>Managed Connection Meta Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionMetaDataImpl
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getManagedConnectionMetaData()
	 * @generated
	 */
	public static final int MANAGED_CONNECTION_META_DATA = 14;

	/**
	 * The number of structural features of the '<em>Managed Connection Meta Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MANAGED_CONNECTION_META_DATA_FEATURE_COUNT = SPI_MANAGED_CONNECTION_META_DATA_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.spi.impl.NonManagedEnvironmentAdminImpl <em>Non Managed Environment Admin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.spi.impl.NonManagedEnvironmentAdminImpl
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getNonManagedEnvironmentAdmin()
	 * @generated
	 */
	public static final int NON_MANAGED_ENVIRONMENT_ADMIN = 15;

	/**
	 * The number of structural features of the '<em>Non Managed Environment Admin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NON_MANAGED_ENVIRONMENT_ADMIN_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.spi.impl.ResourceAdapterImpl <em>Resource Adapter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.spi.impl.ResourceAdapterImpl
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getResourceAdapter()
	 * @generated
	 */
	public static final int RESOURCE_ADAPTER = 16;

	/**
	 * The number of structural features of the '<em>Resource Adapter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RESOURCE_ADAPTER_FEATURE_COUNT = SPI_RESOURCE_ADAPTER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '<em>Password Credential</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.spi.security.PasswordCredential
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getPasswordCredential()
	 * @generated
	 */
	public static final int PASSWORD_CREDENTIAL = 17;

	/**
	 * The meta object id for the '<em>Subject</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.security.auth.Subject
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getSubject()
	 * @generated
	 */
	public static final int SUBJECT = 18;

	/**
	 * The meta object id for the '<em>Connection Event Listener</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.spi.ConnectionEventListener
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getConnectionEventListener()
	 * @generated
	 */
	public static final int CONNECTION_EVENT_LISTENER = 19;

	/**
	 * The meta object id for the '<em>XA Resource</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.transaction.xa.XAResource
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getXAResource()
	 * @generated
	 */
	public static final int XA_RESOURCE = 20;

	/**
	 * The meta object id for the '<em>XA Resource Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getXAResourceArray()
	 * @generated
	 */
	public static final int XA_RESOURCE_ARRAY = 21;

	/**
	 * The meta object id for the '<em>JCo Destination</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.sap.conn.jco.JCoDestination
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getJCoDestination()
	 * @generated
	 */
	public static final int JCO_DESTINATION = 22;

	/**
	 * The meta object id for the '<em>Activation Spec Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getActivationSpecArray()
	 * @generated
	 */
	public static final int ACTIVATION_SPEC_ARRAY = 23;

	/**
	 * The meta object id for the '<em>Activation Spec</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.spi.ActivationSpec
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getActivationSpec()
	 * @generated
	 */
	public static final int ACTIVATION_SPEC = 24;

	/**
	 * The meta object id for the '<em>Bootstrap Context</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.spi.BootstrapContext
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getBootstrapContext()
	 * @generated
	 */
	public static final int BOOTSTRAP_CONTEXT = 25;

	/**
	 * The meta object id for the '<em>Resource Adapter Internal Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.spi.ResourceAdapterInternalException
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getResourceAdapterInternalException()
	 * @generated
	 */
	public static final int RESOURCE_ADAPTER_INTERNAL_EXCEPTION = 26;

	/**
	 * The meta object id for the '<em>Message Endpoint Factory</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.spi.endpoint.MessageEndpointFactory
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getMessageEndpointFactory()
	 * @generated
	 */
	public static final int MESSAGE_ENDPOINT_FACTORY = 27;

	/**
	 * The meta object id for the '<em>Print Writer</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.PrintWriter
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getPrintWriter()
	 * @generated
	 */
	public static final int PRINT_WRITER = 28;

	/**
	 * The meta object id for the '<em>String Map</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Map
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getStringMap()
	 * @generated
	 */
	public static final int STRING_MAP = 29;

	/**
	 * The meta object id for the '<em>String Set</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Set
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getStringSet()
	 * @generated
	 */
	public static final int STRING_SET = 30;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spiConnectionRequestInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spiConnectionManagerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spiLocalTransactionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spiManagedConnectionFactoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spiResourceAdapterAssociationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spiManagedConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spiDissociatableManagedConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spiManagedConnectionMetaDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spiResourceAdapterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionRequestInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultConnectionManagerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localTransactionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass managedConnectionFactoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass managedConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass managedConnectionMetaDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nonManagedEnvironmentAdminEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceAdapterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType passwordCredentialEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType subjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType connectionEventListenerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType xaResourceEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType xaResourceArrayEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType jCoDestinationEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType activationSpecArrayEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType activationSpecEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType bootstrapContextEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType resourceAdapterInternalExceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType messageEndpointFactoryEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType printWriterEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stringMapEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stringSetEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SpiPackageImpl() {
		super(eNS_URI, ((EFactory)SpiFactory.INSTANCE));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SpiPackageImpl#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SpiPackageImpl init() {
		if (isInited) return (SpiPackageImpl)EPackage.Registry.INSTANCE.getEPackage(SpiPackageImpl.eNS_URI);

		// Obtain or create and register package
		SpiPackageImpl theSpiPackage = (SpiPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SpiPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SpiPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		CciPackageImpl theCciPackage = (CciPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CciPackageImpl.eNS_URI) instanceof CciPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CciPackageImpl.eNS_URI) : CciPackageImpl.eINSTANCE);

		// Create package meta-data objects
		theSpiPackage.createPackageContents();
		theCciPackage.createPackageContents();

		// Initialize created meta-data
		theSpiPackage.initializePackageContents();
		theCciPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSpiPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SpiPackageImpl.eNS_URI, theSpiPackage);
		return theSpiPackage;
	}


	/**
	 * Returns the meta object for class '{@link javax.resource.spi.ConnectionRequestInfo <em>SPI Connection Request Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SPI Connection Request Info</em>'.
	 * @see javax.resource.spi.ConnectionRequestInfo
	 * @model instanceClass="javax.resource.spi.ConnectionRequestInfo"
	 * @generated
	 */
	public EClass getSPIConnectionRequestInfo() {
		return spiConnectionRequestInfoEClass;
	}

	/**
	 * Returns the meta object for class '{@link javax.resource.spi.ConnectionManager <em>SPI Connection Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SPI Connection Manager</em>'.
	 * @see javax.resource.spi.ConnectionManager
	 * @model instanceClass="javax.resource.spi.ConnectionManager"
	 * @generated
	 */
	public EClass getSPIConnectionManager() {
		return spiConnectionManagerEClass;
	}

	/**
	 * Returns the meta object for class '{@link javax.resource.spi.LocalTransaction <em>SPI Local Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SPI Local Transaction</em>'.
	 * @see javax.resource.spi.LocalTransaction
	 * @model instanceClass="javax.resource.spi.LocalTransaction"
	 * @generated
	 */
	public EClass getSPILocalTransaction() {
		return spiLocalTransactionEClass;
	}

	/**
	 * Returns the meta object for class '{@link javax.resource.spi.ManagedConnectionFactory <em>SPI Managed Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SPI Managed Connection Factory</em>'.
	 * @see javax.resource.spi.ManagedConnectionFactory
	 * @model instanceClass="javax.resource.spi.ManagedConnectionFactory"
	 * @generated
	 */
	public EClass getSPIManagedConnectionFactory() {
		return spiManagedConnectionFactoryEClass;
	}

	/**
	 * Returns the meta object for class '{@link javax.resource.spi.ResourceAdapterAssociation <em>SPI Resource Adapter Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SPI Resource Adapter Association</em>'.
	 * @see javax.resource.spi.ResourceAdapterAssociation
	 * @model instanceClass="javax.resource.spi.ResourceAdapterAssociation"
	 * @generated
	 */
	public EClass getSPIResourceAdapterAssociation() {
		return spiResourceAdapterAssociationEClass;
	}

	/**
	 * Returns the meta object for class '{@link javax.resource.spi.ManagedConnection <em>SPI Managed Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SPI Managed Connection</em>'.
	 * @see javax.resource.spi.ManagedConnection
	 * @model instanceClass="javax.resource.spi.ManagedConnection"
	 * @generated
	 */
	public EClass getSPIManagedConnection() {
		return spiManagedConnectionEClass;
	}

	/**
	 * Returns the meta object for class '{@link javax.resource.spi.DissociatableManagedConnection <em>SPI Dissociatable Managed Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SPI Dissociatable Managed Connection</em>'.
	 * @see javax.resource.spi.DissociatableManagedConnection
	 * @model instanceClass="javax.resource.spi.DissociatableManagedConnection"
	 * @generated
	 */
	public EClass getSPIDissociatableManagedConnection() {
		return spiDissociatableManagedConnectionEClass;
	}

	/**
	 * Returns the meta object for class '{@link javax.resource.spi.ManagedConnectionMetaData <em>SPI Managed Connection Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SPI Managed Connection Meta Data</em>'.
	 * @see javax.resource.spi.ManagedConnectionMetaData
	 * @model instanceClass="javax.resource.spi.ManagedConnectionMetaData"
	 * @generated
	 */
	public EClass getSPIManagedConnectionMetaData() {
		return spiManagedConnectionMetaDataEClass;
	}

	/**
	 * Returns the meta object for class '{@link javax.resource.spi.ResourceAdapter <em>SPI Resource Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SPI Resource Adapter</em>'.
	 * @see javax.resource.spi.ResourceAdapter
	 * @model instanceClass="javax.resource.spi.ResourceAdapter"
	 * @generated
	 */
	public EClass getSPIResourceAdapter() {
		return spiResourceAdapterEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo <em>Connection Request Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Request Info</em>'.
	 * @see org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo
	 * @generated
	 */
	public EClass getConnectionRequestInfo() {
		return connectionRequestInfoEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Properties</em>'.
	 * @see org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo#getProperties()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_Properties() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(0);
	}


	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.spi.DefaultConnectionManager <em>Default Connection Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Connection Manager</em>'.
	 * @see org.jboss.jca.adapters.sap.spi.DefaultConnectionManager
	 * @generated
	 */
	public EClass getDefaultConnectionManager() {
		return defaultConnectionManagerEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.spi.LocalTransaction <em>Local Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Transaction</em>'.
	 * @see org.jboss.jca.adapters.sap.spi.LocalTransaction
	 * @generated
	 */
	public EClass getLocalTransaction() {
		return localTransactionEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory <em>Managed Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Managed Connection Factory</em>'.
	 * @see org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory
	 * @generated
	 */
	public EClass getManagedConnectionFactory() {
		return managedConnectionFactoryEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.spi.ManagedConnection <em>Managed Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Managed Connection</em>'.
	 * @see org.jboss.jca.adapters.sap.spi.ManagedConnection
	 * @generated
	 */
	public EClass getManagedConnection() {
		return managedConnectionEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.spi.ManagedConnectionMetaData <em>Managed Connection Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Managed Connection Meta Data</em>'.
	 * @see org.jboss.jca.adapters.sap.spi.ManagedConnectionMetaData
	 * @generated
	 */
	public EClass getManagedConnectionMetaData() {
		return managedConnectionMetaDataEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.spi.NonManagedEnvironmentAdmin <em>Non Managed Environment Admin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Managed Environment Admin</em>'.
	 * @see org.jboss.jca.adapters.sap.spi.NonManagedEnvironmentAdmin
	 * @generated
	 */
	public EClass getNonManagedEnvironmentAdmin() {
		return nonManagedEnvironmentAdminEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.spi.ResourceAdapter <em>Resource Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Adapter</em>'.
	 * @see org.jboss.jca.adapters.sap.spi.ResourceAdapter
	 * @generated
	 */
	public EClass getResourceAdapter() {
		return resourceAdapterEClass;
	}

	/**
	 * Returns the meta object for data type '{@link javax.resource.spi.security.PasswordCredential <em>Password Credential</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Password Credential</em>'.
	 * @see javax.resource.spi.security.PasswordCredential
	 * @model instanceClass="javax.resource.spi.security.PasswordCredential"
	 * @generated
	 */
	public EDataType getPasswordCredential() {
		return passwordCredentialEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link javax.security.auth.Subject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Subject</em>'.
	 * @see javax.security.auth.Subject
	 * @model instanceClass="javax.security.auth.Subject"
	 * @generated
	 */
	public EDataType getSubject() {
		return subjectEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link javax.resource.spi.ConnectionEventListener <em>Connection Event Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Connection Event Listener</em>'.
	 * @see javax.resource.spi.ConnectionEventListener
	 * @model instanceClass="javax.resource.spi.ConnectionEventListener"
	 * @generated
	 */
	public EDataType getConnectionEventListener() {
		return connectionEventListenerEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link javax.transaction.xa.XAResource <em>XA Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>XA Resource</em>'.
	 * @see javax.transaction.xa.XAResource
	 * @model instanceClass="javax.transaction.xa.XAResource"
	 * @generated
	 */
	public EDataType getXAResource() {
		return xaResourceEDataType;
	}

	/**
	 * Returns the meta object for data type '<em>XA Resource Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>XA Resource Array</em>'.
	 * @model instanceClass="javax.transaction.xa.XAResource[]"
	 * @generated
	 */
	public EDataType getXAResourceArray() {
		return xaResourceArrayEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link com.sap.conn.jco.JCoDestination <em>JCo Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>JCo Destination</em>'.
	 * @see com.sap.conn.jco.JCoDestination
	 * @model instanceClass="com.sap.conn.jco.JCoDestination"
	 * @generated
	 */
	public EDataType getJCoDestination() {
		return jCoDestinationEDataType;
	}

	/**
	 * Returns the meta object for data type '<em>Activation Spec Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Activation Spec Array</em>'.
	 * @model instanceClass="javax.resource.spi.ActivationSpec[]"
	 * @generated
	 */
	public EDataType getActivationSpecArray() {
		return activationSpecArrayEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link javax.resource.spi.ActivationSpec <em>Activation Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Activation Spec</em>'.
	 * @see javax.resource.spi.ActivationSpec
	 * @model instanceClass="javax.resource.spi.ActivationSpec"
	 * @generated
	 */
	public EDataType getActivationSpec() {
		return activationSpecEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link javax.resource.spi.BootstrapContext <em>Bootstrap Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Bootstrap Context</em>'.
	 * @see javax.resource.spi.BootstrapContext
	 * @model instanceClass="javax.resource.spi.BootstrapContext"
	 * @generated
	 */
	public EDataType getBootstrapContext() {
		return bootstrapContextEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link javax.resource.spi.ResourceAdapterInternalException <em>Resource Adapter Internal Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Resource Adapter Internal Exception</em>'.
	 * @see javax.resource.spi.ResourceAdapterInternalException
	 * @model instanceClass="javax.resource.spi.ResourceAdapterInternalException"
	 * @generated
	 */
	public EDataType getResourceAdapterInternalException() {
		return resourceAdapterInternalExceptionEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link javax.resource.spi.endpoint.MessageEndpointFactory <em>Message Endpoint Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Message Endpoint Factory</em>'.
	 * @see javax.resource.spi.endpoint.MessageEndpointFactory
	 * @model instanceClass="javax.resource.spi.endpoint.MessageEndpointFactory"
	 * @generated
	 */
	public EDataType getMessageEndpointFactory() {
		return messageEndpointFactoryEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link java.io.PrintWriter <em>Print Writer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Print Writer</em>'.
	 * @see java.io.PrintWriter
	 * @model instanceClass="java.io.PrintWriter"
	 * @generated
	 */
	public EDataType getPrintWriter() {
		return printWriterEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link java.util.Map <em>String Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String Map</em>'.
	 * @see java.util.Map
	 * @model instanceClass="java.util.Map<java.lang.String, java.lang.String>"
	 * @generated
	 */
	public EDataType getStringMap() {
		return stringMapEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link java.util.Set <em>String Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String Set</em>'.
	 * @see java.util.Set
	 * @model instanceClass="java.util.Set<java.lang.String>"
	 * @generated
	 */
	public EDataType getStringSet() {
		return stringSetEDataType;
	}


	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public SpiFactory getSpiFactory() {
		return (SpiFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		spiConnectionRequestInfoEClass = createEClass(SPI_CONNECTION_REQUEST_INFO);

		spiConnectionManagerEClass = createEClass(SPI_CONNECTION_MANAGER);

		spiLocalTransactionEClass = createEClass(SPI_LOCAL_TRANSACTION);

		spiManagedConnectionFactoryEClass = createEClass(SPI_MANAGED_CONNECTION_FACTORY);

		spiResourceAdapterAssociationEClass = createEClass(SPI_RESOURCE_ADAPTER_ASSOCIATION);

		spiManagedConnectionEClass = createEClass(SPI_MANAGED_CONNECTION);

		spiDissociatableManagedConnectionEClass = createEClass(SPI_DISSOCIATABLE_MANAGED_CONNECTION);

		spiManagedConnectionMetaDataEClass = createEClass(SPI_MANAGED_CONNECTION_META_DATA);

		spiResourceAdapterEClass = createEClass(SPI_RESOURCE_ADAPTER);

		connectionRequestInfoEClass = createEClass(CONNECTION_REQUEST_INFO);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__PROPERTIES);

		defaultConnectionManagerEClass = createEClass(DEFAULT_CONNECTION_MANAGER);

		localTransactionEClass = createEClass(LOCAL_TRANSACTION);

		managedConnectionFactoryEClass = createEClass(MANAGED_CONNECTION_FACTORY);

		managedConnectionEClass = createEClass(MANAGED_CONNECTION);

		managedConnectionMetaDataEClass = createEClass(MANAGED_CONNECTION_META_DATA);

		nonManagedEnvironmentAdminEClass = createEClass(NON_MANAGED_ENVIRONMENT_ADMIN);

		resourceAdapterEClass = createEClass(RESOURCE_ADAPTER);

		// Create data types
		passwordCredentialEDataType = createEDataType(PASSWORD_CREDENTIAL);
		subjectEDataType = createEDataType(SUBJECT);
		connectionEventListenerEDataType = createEDataType(CONNECTION_EVENT_LISTENER);
		xaResourceEDataType = createEDataType(XA_RESOURCE);
		xaResourceArrayEDataType = createEDataType(XA_RESOURCE_ARRAY);
		jCoDestinationEDataType = createEDataType(JCO_DESTINATION);
		activationSpecArrayEDataType = createEDataType(ACTIVATION_SPEC_ARRAY);
		activationSpecEDataType = createEDataType(ACTIVATION_SPEC);
		bootstrapContextEDataType = createEDataType(BOOTSTRAP_CONTEXT);
		resourceAdapterInternalExceptionEDataType = createEDataType(RESOURCE_ADAPTER_INTERNAL_EXCEPTION);
		messageEndpointFactoryEDataType = createEDataType(MESSAGE_ENDPOINT_FACTORY);
		printWriterEDataType = createEDataType(PRINT_WRITER);
		stringMapEDataType = createEDataType(STRING_MAP);
		stringSetEDataType = createEDataType(STRING_SET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CciPackageImpl theCciPackage = (CciPackageImpl)EPackage.Registry.INSTANCE.getEPackage(CciPackageImpl.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		connectionRequestInfoEClass.getESuperTypes().add(this.getSPIConnectionRequestInfo());
		defaultConnectionManagerEClass.getESuperTypes().add(this.getSPIConnectionManager());
		localTransactionEClass.getESuperTypes().add(this.getSPILocalTransaction());
		managedConnectionFactoryEClass.getESuperTypes().add(this.getSPIManagedConnectionFactory());
		managedConnectionFactoryEClass.getESuperTypes().add(this.getSPIResourceAdapterAssociation());
		managedConnectionEClass.getESuperTypes().add(this.getSPIManagedConnection());
		managedConnectionEClass.getESuperTypes().add(this.getSPIDissociatableManagedConnection());
		managedConnectionMetaDataEClass.getESuperTypes().add(this.getSPIManagedConnectionMetaData());
		resourceAdapterEClass.getESuperTypes().add(this.getSPIResourceAdapter());

		// Initialize classes and features; add operations and parameters
		initEClass(spiConnectionRequestInfoEClass, ConnectionRequestInfo.class, "SPIConnectionRequestInfo", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(spiConnectionManagerEClass, ConnectionManager.class, "SPIConnectionManager", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(spiLocalTransactionEClass, LocalTransaction.class, "SPILocalTransaction", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(spiManagedConnectionFactoryEClass, ManagedConnectionFactory.class, "SPIManagedConnectionFactory", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(spiResourceAdapterAssociationEClass, ResourceAdapterAssociation.class, "SPIResourceAdapterAssociation", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(spiManagedConnectionEClass, ManagedConnection.class, "SPIManagedConnection", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(spiDissociatableManagedConnectionEClass, DissociatableManagedConnection.class, "SPIDissociatableManagedConnection", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(spiManagedConnectionMetaDataEClass, ManagedConnectionMetaData.class, "SPIManagedConnectionMetaData", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(spiResourceAdapterEClass, ResourceAdapter.class, "SPIResourceAdapter", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(connectionRequestInfoEClass, org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo.class, "ConnectionRequestInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnectionRequestInfo_Properties(), theCciPackage.getProperties(), "properties", null, 0, 1, org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(connectionRequestInfoEClass, ecorePackage.getEBoolean(), "equals", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "other", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEInt(), "hashCode", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, this.getStringSet(), "stringPropertyNames", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getProperty", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "key", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, ecorePackage.getEJavaObject(), "setProperty", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "key", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "addProperties", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCciPackage.getProperties(), "properties", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getAliasUser", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getAshost", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getAuthType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getClient", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getCodepage", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getCpicTrace", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getDenyInitialPassword", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getExpirationPeriod", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getExpirationTime", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getGetsso2", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getGroup", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getGwhost", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getGwserv", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getLang", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getLcheck", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getMaxGetTime", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getMshost", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getMsserv", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getMysapsso2", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getPassword", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getPasswd", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getPcs", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getPeakLimit", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getPingOnCreate", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getPoolCapacity", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getR3name", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getRepositoryDest", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getRepositoryPasswd", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getRepositoryRoundtripOptimization", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getRepositorySnc", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getRepositoryUser", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getSaprouter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getSncLibrary", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getSncMode", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getSncMyname", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getSncPartnername", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getSncQop", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getSysnr", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getTphost", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getTpname", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getTrace", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getUserName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getUser", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getUserId", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getUseSapgui", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionRequestInfoEClass, ecorePackage.getEString(), "getX509cert", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setAliasUser", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "user", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setAshost", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "ashost", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setAuthType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "authType", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setClient", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "client", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setCodepage", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "codepage", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setCpicTrace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "cpicTrace", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setDenyInitialPassword", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "denyInitialPassword", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setExpirationPeriod", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "expirationPeriod", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setExpirationTime", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "expirationTime", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setGetsso2", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "getsso2", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "group", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setGwhost", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "gwhost", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setGwserv", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "gwserv", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setLang", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "lang", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setLcheck", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "lcheck", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setMaxGetTime", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "maxGetTime", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setMshost", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "mshost", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setMsserv", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "msserv", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setMysapsso2", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "mysapsso2", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setPassword", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "password", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setPasswd", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "passwd", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setPcs", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "pcs", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setPeakLimit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "peakLimit", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setPingOnCreate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "pingOnCreate", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setPoolCapacity", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "poolCapacity", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setR3name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "r3name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setRepositoryDest", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "repositoryDest", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setRepositoryPasswd", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "repositoryPasswd", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setRepositoryRoundtripOptimization", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "repositoryRoundtripOptimization", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setRepositorySnc", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "repositorySnc", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setRepositoryUser", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "repositoryUser", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setSaprouter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "saprouter", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setSncLibrary", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sncLibrary", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setSncMode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sncMode", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setSncMyname", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sncMyname", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setSncPartnername", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sncPartnername", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setSncQop", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sncQop", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setSysnr", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sysnr", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setTphost", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "tphost", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setTpname", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "tpname", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setTrace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "trace", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setUserName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "userName", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setUser", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "user", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setUserId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "userId", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setUseSapgui", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "useSapgui", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionRequestInfoEClass, null, "setX509cert", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "x509cert", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(defaultConnectionManagerEClass, DefaultConnectionManager.class, "DefaultConnectionManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(defaultConnectionManagerEClass, ecorePackage.getEJavaObject(), "allocateConnection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSPIManagedConnectionFactory(), "managedConnectionFactory", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSPIConnectionRequestInfo(), "connectionRequestInfo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		initEClass(localTransactionEClass, org.jboss.jca.adapters.sap.spi.LocalTransaction.class, "LocalTransaction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(localTransactionEClass, null, "begin", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(localTransactionEClass, null, "commit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(localTransactionEClass, null, "rollback", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		initEClass(managedConnectionFactoryEClass, org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory.class, "ManagedConnectionFactory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(managedConnectionFactoryEClass, theCciPackage.getConnectionSpec(), "convertConnectionRequestInfoToConnectionSpec", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getConnectionRequestInfo(), "connectionRequestInfo", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, this.getConnectionRequestInfo(), "convertConnectionSpecToConnectionRequestInfo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCciPackage.getConnectionSpec(), "connectionSpec", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, ecorePackage.getEJavaObject(), "createConnectionFactory", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionFactoryEClass, ecorePackage.getEJavaObject(), "createConnectionFactory", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSPIConnectionManager(), "connectionManager", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionFactoryEClass, this.getSPIManagedConnection(), "createManagedConnection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSubject(), "subject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSPIConnectionRequestInfo(), "connectionRequestInfo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionFactoryEClass, null, "destroy", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionFactoryEClass, ecorePackage.getEBoolean(), "equals", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "other", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getAliasUser", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getAshost", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getAuthType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getClient", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getCodepage", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getCpicTrace", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getDenyInitialPassword", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getExpirationPeriod", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getExpirationTime", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getGetsso2", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getGroup", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getGwhost", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getGwserv", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getLang", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getLcheck", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, this.getPrintWriter(), "getLogWriter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getMaxGetTime", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getMshost", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getMsserv", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getMysapsso2", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getPasswd", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getPcs", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getPeakLimit", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getPingOnCreate", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getPoolCapacity", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getR3name", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getRepositoryDest", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getRepositoryPasswd", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getRepositoryRoundtripOptimization", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getRepositorySnc", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getRepositoryUser", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, this.getResourceAdapter(), "getResourceAdapter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getSaprouter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getSncLibrary", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getSncMode", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getSncMyname", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getSncPartnername", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getSncQop", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getSysnr", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getTphost", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getTpname", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getTrace", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getUser", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getUserId", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getUseSapgui", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEString(), "getX509cert", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionFactoryEClass, ecorePackage.getEInt(), "hashCode", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, this.getSPIManagedConnection(), "matchManagedConnections", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCciPackage.getRawSet(), "connectionSet", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSubject(), "subject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSPIConnectionRequestInfo(), "connectionRequestInfo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionFactoryEClass, null, "setAliasUser", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "user", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setAshost", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "ashost", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setAuthType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "authType", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setClient", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "client", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setCodepage", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "codepage", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setCpicTrace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "cpicTrace", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setDenyInitialPassword", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "denyInitialPassword", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setExpirationPeriod", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "expirationPeriod", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setExpirationTime", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "expirationTime", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setGetsso2", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "getsso2", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "group", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setGwhost", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "gwhost", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setGwserv", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "gwserv", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setLang", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "lang", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setLcheck", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "lcheck", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setLogWriter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPrintWriter(), "out", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionFactoryEClass, null, "setMaxGetTime", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "maxGetTime", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setMshost", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "mshost", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setMsserv", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "msserv", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setMysapsso2", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "mysapsso2", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setPasswd", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "passwd", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setPcs", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "pcs", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setPeakLimit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "peakLimit", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setPingOnCreate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "pingOnCreate", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setPoolCapacity", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "poolCapacity", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setR3name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "r3name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setRepositoryDest", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "repositoryDest", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setRepositoryPasswd", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "repositoryPasswd", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setRepositoryRoundtripOptimization", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "repositoryRoundtripOptimization", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setRepositorySnc", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "repositorySnc", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setRepositoryUser", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "repositoryUser", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setResourceAdapter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSPIResourceAdapter(), "resourceAdapter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionFactoryEClass, null, "setSaprouter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "saprouter", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setSncLibrary", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sncLibrary", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setSncMode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sncMode", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setSncMyname", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sncMyname", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setSncPartnername", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sncPartnername", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setSncQop", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sncQop", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setSysnr", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sysnr", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setTphost", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "tphost", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setTpname", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "tpname", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setTrace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "trace", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setUser", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "user", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setUserId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "userId", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setUseSapgui", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "useSapgui", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionFactoryEClass, null, "setX509cert", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "x509cert", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(managedConnectionEClass, org.jboss.jca.adapters.sap.spi.ManagedConnection.class, "ManagedConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(managedConnectionEClass, ecorePackage.getEBoolean(), "equals", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "other", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(managedConnectionEClass, ecorePackage.getEInt(), "hashCode", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionEClass, ecorePackage.getEJavaObject(), "getConnection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSubject(), "subject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSPIConnectionRequestInfo(), "connectionRequestInfo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionEClass, null, "addConnectionEventListener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getConnectionEventListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionEClass, null, "removeConnectionEventListener", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getConnectionEventListener(), "listener", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionEClass, this.getSPILocalTransaction(), "getLocalTransaction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionEClass, this.getXAResource(), "getXAResource", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionEClass, this.getSPIManagedConnectionMetaData(), "getMetaData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionEClass, this.getPrintWriter(), "getLogWriter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionEClass, null, "setLogWriter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPrintWriter(), "out", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionEClass, null, "associateConnection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "connection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionEClass, null, "dissociateConnections", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionEClass, null, "cleanup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionEClass, null, "destroy", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionEClass, theCciPackage.getProperties(), "getProperties", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionEClass, this.getConnectionRequestInfo(), "getConnectionRequestInfo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		addEOperation(managedConnectionEClass, this.getJCoDestination(), "getDestination", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionEClass, this.getManagedConnectionFactory(), "getManagedConnectionFactory", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		addEOperation(managedConnectionEClass, ecorePackage.getEBoolean(), "isStateful", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(managedConnectionEClass, null, "beginStatefulSession", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionEClass, null, "endStatefulSession", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionEClass, null, "ping", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionEClass, null, "associateHandle", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCciPackage.getConnection(), "handle", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionEClass, null, "dissociateHandle", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCciPackage.getConnection(), "handle", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionEClass, null, "closeHandle", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCciPackage.getConnection(), "handle", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		initEClass(managedConnectionMetaDataEClass, org.jboss.jca.adapters.sap.spi.ManagedConnectionMetaData.class, "ManagedConnectionMetaData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(managedConnectionMetaDataEClass, ecorePackage.getEString(), "getEISProductName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionMetaDataEClass, ecorePackage.getEString(), "getEISProductVersion", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionMetaDataEClass, ecorePackage.getEInt(), "getMaxConnections", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(managedConnectionMetaDataEClass, ecorePackage.getEString(), "getUserName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		initEClass(nonManagedEnvironmentAdminEClass, NonManagedEnvironmentAdmin.class, "NonManagedEnvironmentAdmin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(nonManagedEnvironmentAdminEClass, this.getManagedConnectionFactory(), "createManagedConnectionFactory", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStringMap(), "config", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		addEOperation(nonManagedEnvironmentAdminEClass, ecorePackage.getEBoolean(), "isResourceAdapterDeployed", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(nonManagedEnvironmentAdminEClass, null, "deployResourceAdapter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStringMap(), "config", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		addEOperation(nonManagedEnvironmentAdminEClass, null, "undeployResourceAdapter", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(resourceAdapterEClass, org.jboss.jca.adapters.sap.spi.ResourceAdapter.class, "ResourceAdapter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(resourceAdapterEClass, ecorePackage.getEBoolean(), "equals", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "other", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(resourceAdapterEClass, ecorePackage.getEInt(), "hashCode", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(resourceAdapterEClass, ecorePackage.getEBoolean(), "isStarted", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(resourceAdapterEClass, null, "start", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBootstrapContext(), "bootstrapContext", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceAdapterInternalException());

		addEOperation(resourceAdapterEClass, null, "stop", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(resourceAdapterEClass, this.getXAResourceArray(), "getXAResources", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getActivationSpecArray(), "activationSpecs", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(resourceAdapterEClass, null, "endpointActivation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMessageEndpointFactory(), "endpointFactory", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getActivationSpec(), "activationSpec", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theCciPackage.getResourceException());

		op = addEOperation(resourceAdapterEClass, null, "endpointDeactivation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMessageEndpointFactory(), "endpointFactory", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getActivationSpec(), "activationSpec", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize data types
		initEDataType(passwordCredentialEDataType, PasswordCredential.class, "PasswordCredential", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(subjectEDataType, Subject.class, "Subject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(connectionEventListenerEDataType, ConnectionEventListener.class, "ConnectionEventListener", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(xaResourceEDataType, XAResource.class, "XAResource", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(xaResourceArrayEDataType, XAResource[].class, "XAResourceArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(jCoDestinationEDataType, JCoDestination.class, "JCoDestination", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(activationSpecArrayEDataType, ActivationSpec[].class, "ActivationSpecArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(activationSpecEDataType, ActivationSpec.class, "ActivationSpec", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(bootstrapContextEDataType, BootstrapContext.class, "BootstrapContext", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(resourceAdapterInternalExceptionEDataType, ResourceAdapterInternalException.class, "ResourceAdapterInternalException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(messageEndpointFactoryEDataType, MessageEndpointFactory.class, "MessageEndpointFactory", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(printWriterEDataType, PrintWriter.class, "PrintWriter", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(stringMapEDataType, Map.class, "StringMap", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.Map<java.lang.String, java.lang.String>");
		initEDataType(stringSetEDataType, Set.class, "StringSet", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.Set<java.lang.String>");

		// Create resource
		createResource(eNS_URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public interface Literals {
		/**
		 * The meta object literal for the '{@link javax.resource.spi.ConnectionRequestInfo <em>SPI Connection Request Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.spi.ConnectionRequestInfo
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getSPIConnectionRequestInfo()
		 * @generated
		 */
		public static final EClass SPI_CONNECTION_REQUEST_INFO = eINSTANCE.getSPIConnectionRequestInfo();

		/**
		 * The meta object literal for the '{@link javax.resource.spi.ConnectionManager <em>SPI Connection Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.spi.ConnectionManager
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getSPIConnectionManager()
		 * @generated
		 */
		public static final EClass SPI_CONNECTION_MANAGER = eINSTANCE.getSPIConnectionManager();

		/**
		 * The meta object literal for the '{@link javax.resource.spi.LocalTransaction <em>SPI Local Transaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.spi.LocalTransaction
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getSPILocalTransaction()
		 * @generated
		 */
		public static final EClass SPI_LOCAL_TRANSACTION = eINSTANCE.getSPILocalTransaction();

		/**
		 * The meta object literal for the '{@link javax.resource.spi.ManagedConnectionFactory <em>SPI Managed Connection Factory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.spi.ManagedConnectionFactory
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getSPIManagedConnectionFactory()
		 * @generated
		 */
		public static final EClass SPI_MANAGED_CONNECTION_FACTORY = eINSTANCE.getSPIManagedConnectionFactory();

		/**
		 * The meta object literal for the '{@link javax.resource.spi.ResourceAdapterAssociation <em>SPI Resource Adapter Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.spi.ResourceAdapterAssociation
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getSPIResourceAdapterAssociation()
		 * @generated
		 */
		public static final EClass SPI_RESOURCE_ADAPTER_ASSOCIATION = eINSTANCE.getSPIResourceAdapterAssociation();

		/**
		 * The meta object literal for the '{@link javax.resource.spi.ManagedConnection <em>SPI Managed Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.spi.ManagedConnection
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getSPIManagedConnection()
		 * @generated
		 */
		public static final EClass SPI_MANAGED_CONNECTION = eINSTANCE.getSPIManagedConnection();

		/**
		 * The meta object literal for the '{@link javax.resource.spi.DissociatableManagedConnection <em>SPI Dissociatable Managed Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.spi.DissociatableManagedConnection
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getSPIDissociatableManagedConnection()
		 * @generated
		 */
		public static final EClass SPI_DISSOCIATABLE_MANAGED_CONNECTION = eINSTANCE.getSPIDissociatableManagedConnection();

		/**
		 * The meta object literal for the '{@link javax.resource.spi.ManagedConnectionMetaData <em>SPI Managed Connection Meta Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.spi.ManagedConnectionMetaData
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getSPIManagedConnectionMetaData()
		 * @generated
		 */
		public static final EClass SPI_MANAGED_CONNECTION_META_DATA = eINSTANCE.getSPIManagedConnectionMetaData();

		/**
		 * The meta object literal for the '{@link javax.resource.spi.ResourceAdapter <em>SPI Resource Adapter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.spi.ResourceAdapter
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getSPIResourceAdapter()
		 * @generated
		 */
		public static final EClass SPI_RESOURCE_ADAPTER = eINSTANCE.getSPIResourceAdapter();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.spi.impl.ConnectionRequestInfoImpl <em>Connection Request Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.spi.impl.ConnectionRequestInfoImpl
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getConnectionRequestInfo()
		 * @generated
		 */
		public static final EClass CONNECTION_REQUEST_INFO = eINSTANCE.getConnectionRequestInfo();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute CONNECTION_REQUEST_INFO__PROPERTIES = eINSTANCE.getConnectionRequestInfo_Properties();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.spi.impl.DefaultConnectionManagerImpl <em>Default Connection Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.spi.impl.DefaultConnectionManagerImpl
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getDefaultConnectionManager()
		 * @generated
		 */
		public static final EClass DEFAULT_CONNECTION_MANAGER = eINSTANCE.getDefaultConnectionManager();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.spi.impl.LocalTransactionImpl <em>Local Transaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.spi.impl.LocalTransactionImpl
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getLocalTransaction()
		 * @generated
		 */
		public static final EClass LOCAL_TRANSACTION = eINSTANCE.getLocalTransaction();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionFactoryImpl <em>Managed Connection Factory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionFactoryImpl
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getManagedConnectionFactory()
		 * @generated
		 */
		public static final EClass MANAGED_CONNECTION_FACTORY = eINSTANCE.getManagedConnectionFactory();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionImpl <em>Managed Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionImpl
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getManagedConnection()
		 * @generated
		 */
		public static final EClass MANAGED_CONNECTION = eINSTANCE.getManagedConnection();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionMetaDataImpl <em>Managed Connection Meta Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionMetaDataImpl
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getManagedConnectionMetaData()
		 * @generated
		 */
		public static final EClass MANAGED_CONNECTION_META_DATA = eINSTANCE.getManagedConnectionMetaData();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.spi.impl.NonManagedEnvironmentAdminImpl <em>Non Managed Environment Admin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.spi.impl.NonManagedEnvironmentAdminImpl
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getNonManagedEnvironmentAdmin()
		 * @generated
		 */
		public static final EClass NON_MANAGED_ENVIRONMENT_ADMIN = eINSTANCE.getNonManagedEnvironmentAdmin();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.spi.impl.ResourceAdapterImpl <em>Resource Adapter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.spi.impl.ResourceAdapterImpl
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getResourceAdapter()
		 * @generated
		 */
		public static final EClass RESOURCE_ADAPTER = eINSTANCE.getResourceAdapter();

		/**
		 * The meta object literal for the '<em>Password Credential</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.spi.security.PasswordCredential
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getPasswordCredential()
		 * @generated
		 */
		public static final EDataType PASSWORD_CREDENTIAL = eINSTANCE.getPasswordCredential();

		/**
		 * The meta object literal for the '<em>Subject</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.security.auth.Subject
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getSubject()
		 * @generated
		 */
		public static final EDataType SUBJECT = eINSTANCE.getSubject();

		/**
		 * The meta object literal for the '<em>Connection Event Listener</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.spi.ConnectionEventListener
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getConnectionEventListener()
		 * @generated
		 */
		public static final EDataType CONNECTION_EVENT_LISTENER = eINSTANCE.getConnectionEventListener();

		/**
		 * The meta object literal for the '<em>XA Resource</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.transaction.xa.XAResource
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getXAResource()
		 * @generated
		 */
		public static final EDataType XA_RESOURCE = eINSTANCE.getXAResource();

		/**
		 * The meta object literal for the '<em>XA Resource Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getXAResourceArray()
		 * @generated
		 */
		public static final EDataType XA_RESOURCE_ARRAY = eINSTANCE.getXAResourceArray();

		/**
		 * The meta object literal for the '<em>JCo Destination</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.sap.conn.jco.JCoDestination
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getJCoDestination()
		 * @generated
		 */
		public static final EDataType JCO_DESTINATION = eINSTANCE.getJCoDestination();

		/**
		 * The meta object literal for the '<em>Activation Spec Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getActivationSpecArray()
		 * @generated
		 */
		public static final EDataType ACTIVATION_SPEC_ARRAY = eINSTANCE.getActivationSpecArray();

		/**
		 * The meta object literal for the '<em>Activation Spec</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.spi.ActivationSpec
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getActivationSpec()
		 * @generated
		 */
		public static final EDataType ACTIVATION_SPEC = eINSTANCE.getActivationSpec();

		/**
		 * The meta object literal for the '<em>Bootstrap Context</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.spi.BootstrapContext
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getBootstrapContext()
		 * @generated
		 */
		public static final EDataType BOOTSTRAP_CONTEXT = eINSTANCE.getBootstrapContext();

		/**
		 * The meta object literal for the '<em>Resource Adapter Internal Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.spi.ResourceAdapterInternalException
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getResourceAdapterInternalException()
		 * @generated
		 */
		public static final EDataType RESOURCE_ADAPTER_INTERNAL_EXCEPTION = eINSTANCE.getResourceAdapterInternalException();

		/**
		 * The meta object literal for the '<em>Message Endpoint Factory</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.spi.endpoint.MessageEndpointFactory
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getMessageEndpointFactory()
		 * @generated
		 */
		public static final EDataType MESSAGE_ENDPOINT_FACTORY = eINSTANCE.getMessageEndpointFactory();

		/**
		 * The meta object literal for the '<em>Print Writer</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.PrintWriter
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getPrintWriter()
		 * @generated
		 */
		public static final EDataType PRINT_WRITER = eINSTANCE.getPrintWriter();

		/**
		 * The meta object literal for the '<em>String Map</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Map
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getStringMap()
		 * @generated
		 */
		public static final EDataType STRING_MAP = eINSTANCE.getStringMap();

		/**
		 * The meta object literal for the '<em>String Set</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Set
		 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl#getStringSet()
		 * @generated
		 */
		public static final EDataType STRING_SET = eINSTANCE.getStringSet();

	}

} //SpiPackageImpl
