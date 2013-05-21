/**
 */
package org.jboss.jca.adapters.sap.model.spi;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.jboss.jca.adapters.sap.model.spi.SpiFactory
 * @model kind="package"
 * @generated
 */
public interface SpiPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "spi";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.adapters.jca.jboss.org/spi";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "spi";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SpiPackage eINSTANCE = org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl <em>Connection Request Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getConnectionRequestInfo()
	 * @generated
	 */
	int CONNECTION_REQUEST_INFO = 0;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__ENTRIES = 0;

	/**
	 * The feature id for the '<em><b>Alias User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__ALIAS_USER = 1;

	/**
	 * The feature id for the '<em><b>Ashost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__ASHOST = 2;

	/**
	 * The feature id for the '<em><b>Auth Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__AUTH_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Client</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__CLIENT = 4;

	/**
	 * The feature id for the '<em><b>Codepage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__CODEPAGE = 5;

	/**
	 * The feature id for the '<em><b>Cpic Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__CPIC_TRACE = 6;

	/**
	 * The feature id for the '<em><b>Deny Initial Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__DENY_INITIAL_PASSWORD = 7;

	/**
	 * The feature id for the '<em><b>Expiration Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__EXPIRATION_PERIOD = 8;

	/**
	 * The feature id for the '<em><b>Expiration Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__EXPIRATION_TIME = 9;

	/**
	 * The feature id for the '<em><b>Getsso2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__GETSSO2 = 10;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__GROUP = 11;

	/**
	 * The feature id for the '<em><b>Gwhost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__GWHOST = 12;

	/**
	 * The feature id for the '<em><b>Gwserv</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__GWSERV = 13;

	/**
	 * The feature id for the '<em><b>Lang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__LANG = 14;

	/**
	 * The feature id for the '<em><b>Lcheck</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__LCHECK = 15;

	/**
	 * The feature id for the '<em><b>Max Get Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__MAX_GET_TIME = 16;

	/**
	 * The feature id for the '<em><b>Mshost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__MSHOST = 17;

	/**
	 * The feature id for the '<em><b>Msserv</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__MSSERV = 18;

	/**
	 * The feature id for the '<em><b>Mysapsso2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__MYSAPSSO2 = 19;

	/**
	 * The feature id for the '<em><b>Passwd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__PASSWD = 20;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__PASSWORD = 21;

	/**
	 * The feature id for the '<em><b>Pcs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__PCS = 22;

	/**
	 * The feature id for the '<em><b>Peak Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__PEAK_LIMIT = 23;

	/**
	 * The feature id for the '<em><b>Ping On Create</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__PING_ON_CREATE = 24;

	/**
	 * The feature id for the '<em><b>Pool Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__POOL_CAPACITY = 25;

	/**
	 * The feature id for the '<em><b>R3name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__R3NAME = 26;

	/**
	 * The feature id for the '<em><b>Repository Dest</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__REPOSITORY_DEST = 27;

	/**
	 * The feature id for the '<em><b>Repository Passwd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__REPOSITORY_PASSWD = 28;

	/**
	 * The feature id for the '<em><b>Repository Roundtrip Optimization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__REPOSITORY_ROUNDTRIP_OPTIMIZATION = 29;

	/**
	 * The feature id for the '<em><b>Repository Snc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__REPOSITORY_SNC = 30;

	/**
	 * The feature id for the '<em><b>Repository User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__REPOSITORY_USER = 31;

	/**
	 * The feature id for the '<em><b>Saprouter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__SAPROUTER = 32;

	/**
	 * The feature id for the '<em><b>Snc Library</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__SNC_LIBRARY = 33;

	/**
	 * The feature id for the '<em><b>Snc Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__SNC_MODE = 34;

	/**
	 * The feature id for the '<em><b>Snc Myname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__SNC_MYNAME = 35;

	/**
	 * The feature id for the '<em><b>Snc Partnername</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__SNC_PARTNERNAME = 36;

	/**
	 * The feature id for the '<em><b>Snc Qop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__SNC_QOP = 37;

	/**
	 * The feature id for the '<em><b>Sysnr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__SYSNR = 38;

	/**
	 * The feature id for the '<em><b>Tphost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__TPHOST = 39;

	/**
	 * The feature id for the '<em><b>Tpname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__TPNAME = 40;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__TRACE = 41;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__TYPE = 42;

	/**
	 * The feature id for the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__USER_NAME = 43;

	/**
	 * The feature id for the '<em><b>User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__USER = 44;

	/**
	 * The feature id for the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__USER_ID = 45;

	/**
	 * The feature id for the '<em><b>Use Sapgui</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__USE_SAPGUI = 46;

	/**
	 * The feature id for the '<em><b>X50 9cert</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO__X509CERT = 47;

	/**
	 * The number of structural features of the '<em>Connection Request Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO_FEATURE_COUNT = 48;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoEntryImpl <em>Connection Request Info Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoEntryImpl
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getConnectionRequestInfoEntry()
	 * @generated
	 */
	int CONNECTION_REQUEST_INFO_ENTRY = 1;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Connection Request Info Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoStoreImpl <em>Connection Request Info Store</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoStoreImpl
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getConnectionRequestInfoStore()
	 * @generated
	 */
	int CONNECTION_REQUEST_INFO_STORE = 2;

	/**
	 * The feature id for the '<em><b>Connection Request Infos</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO_STORE__CONNECTION_REQUEST_INFOS = 0;

	/**
	 * The number of structural features of the '<em>Connection Request Info Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO_STORE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoStoreEntryImpl <em>Connection Request Info Store Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoStoreEntryImpl
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getConnectionRequestInfoStoreEntry()
	 * @generated
	 */
	int CONNECTION_REQUEST_INFO_STORE_ENTRY = 3;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO_STORE_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO_STORE_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Connection Request Info Store Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_REQUEST_INFO_STORE_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionFactoryImpl <em>Managed Connection Factory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionFactoryImpl
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getManagedConnectionFactory()
	 * @generated
	 */
	int MANAGED_CONNECTION_FACTORY = 4;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGED_CONNECTION_FACTORY__STATE = 0;

	/**
	 * The feature id for the '<em><b>Resource Adapter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGED_CONNECTION_FACTORY__RESOURCE_ADAPTER = 1;

	/**
	 * The feature id for the '<em><b>Default Connection Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_NAME = 2;

	/**
	 * The feature id for the '<em><b>Default Connection Request Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO = 3;

	/**
	 * The feature id for the '<em><b>Package Registry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGED_CONNECTION_FACTORY__PACKAGE_REGISTRY = 4;

	/**
	 * The feature id for the '<em><b>Managed Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGED_CONNECTION_FACTORY__MANAGED_CONNECTIONS = 5;

	/**
	 * The feature id for the '<em><b>Connection Factories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGED_CONNECTION_FACTORY__CONNECTION_FACTORIES = 6;

	/**
	 * The feature id for the '<em><b>Log Writer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGED_CONNECTION_FACTORY__LOG_WRITER = 7;

	/**
	 * The number of structural features of the '<em>Managed Connection Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGED_CONNECTION_FACTORY_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionImpl <em>Managed Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionImpl
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getManagedConnection()
	 * @generated
	 */
	int MANAGED_CONNECTION = 5;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGED_CONNECTION__STATE = 0;

	/**
	 * The feature id for the '<em><b>Managed Connection Factory</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGED_CONNECTION__MANAGED_CONNECTION_FACTORY = 1;

	/**
	 * The feature id for the '<em><b>Connection Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGED_CONNECTION__CONNECTION_NAME = 2;

	/**
	 * The feature id for the '<em><b>Connection Request Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGED_CONNECTION__CONNECTION_REQUEST_INFO = 3;

	/**
	 * The feature id for the '<em><b>Connection Handles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGED_CONNECTION__CONNECTION_HANDLES = 4;

	/**
	 * The feature id for the '<em><b>Log Writer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGED_CONNECTION__LOG_WRITER = 5;

	/**
	 * The feature id for the '<em><b>Connection Event Listeners</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGED_CONNECTION__CONNECTION_EVENT_LISTENERS = 6;

	/**
	 * The feature id for the '<em><b>In Transaction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGED_CONNECTION__IN_TRANSACTION = 7;

	/**
	 * The number of structural features of the '<em>Managed Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANAGED_CONNECTION_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.spi.impl.ResourceAdapterImpl <em>Resource Adapter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.ResourceAdapterImpl
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getResourceAdapter()
	 * @generated
	 */
	int RESOURCE_ADAPTER = 6;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ADAPTER__STATE = 0;

	/**
	 * The feature id for the '<em><b>Connection Request Info Store</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ADAPTER__CONNECTION_REQUEST_INFO_STORE = 1;

	/**
	 * The feature id for the '<em><b>Managed Connection Factories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ADAPTER__MANAGED_CONNECTION_FACTORIES = 2;

	/**
	 * The number of structural features of the '<em>Resource Adapter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ADAPTER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.spi.impl.PackageRegistryImpl <em>Package Registry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.PackageRegistryImpl
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getPackageRegistry()
	 * @generated
	 */
	int PACKAGE_REGISTRY = 7;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REGISTRY__PACKAGES = 0;

	/**
	 * The feature id for the '<em><b>Managed Connection Factory</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REGISTRY__MANAGED_CONNECTION_FACTORY = 1;

	/**
	 * The number of structural features of the '<em>Package Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REGISTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.spi.impl.PackageRegistryEntryImpl <em>Package Registry Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.PackageRegistryEntryImpl
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getPackageRegistryEntry()
	 * @generated
	 */
	int PACKAGE_REGISTRY_ENTRY = 8;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REGISTRY_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REGISTRY_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Package Registry Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_REGISTRY_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactoryState <em>Managed Connection Factory State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactoryState
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getManagedConnectionFactoryState()
	 * @generated
	 */
	int MANAGED_CONNECTION_FACTORY_STATE = 9;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionState <em>Managed Connection State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionState
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getManagedConnectionState()
	 * @generated
	 */
	int MANAGED_CONNECTION_STATE = 10;


	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.spi.ResourceAdapterState <em>Resource Adapter State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ResourceAdapterState
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getResourceAdapterState()
	 * @generated
	 */
	int RESOURCE_ADAPTER_STATE = 11;


	/**
	 * The meta object id for the '<em>Print Writer</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.PrintWriter
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getPrintWriter()
	 * @generated
	 */
	int PRINT_WRITER = 12;


	/**
	 * The meta object id for the '<em>Connection Event Listener</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.spi.ConnectionEventListener
	 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getConnectionEventListener()
	 * @generated
	 */
	int CONNECTION_EVENT_LISTENER = 13;


	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo <em>Connection Request Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Request Info</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo
	 * @generated
	 */
	EClass getConnectionRequestInfo();

	/**
	 * Returns the meta object for the map '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Entries</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getEntries()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EReference getConnectionRequestInfo_Entries();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getAliasUser <em>Alias User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias User</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getAliasUser()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_AliasUser();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getAshost <em>Ashost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ashost</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getAshost()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_Ashost();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getAuthType <em>Auth Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auth Type</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getAuthType()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_AuthType();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getClient <em>Client</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getClient()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_Client();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getCodepage <em>Codepage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Codepage</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getCodepage()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_Codepage();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getCpicTrace <em>Cpic Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cpic Trace</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getCpicTrace()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_CpicTrace();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getDenyInitialPassword <em>Deny Initial Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deny Initial Password</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getDenyInitialPassword()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_DenyInitialPassword();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getExpirationPeriod <em>Expiration Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expiration Period</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getExpirationPeriod()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_ExpirationPeriod();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getExpirationTime <em>Expiration Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expiration Time</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getExpirationTime()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_ExpirationTime();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getGetsso2 <em>Getsso2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Getsso2</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getGetsso2()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_Getsso2();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getGroup()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_Group();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getGwhost <em>Gwhost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gwhost</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getGwhost()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_Gwhost();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getGwserv <em>Gwserv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gwserv</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getGwserv()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_Gwserv();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getLang <em>Lang</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lang</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getLang()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_Lang();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getLcheck <em>Lcheck</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lcheck</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getLcheck()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_Lcheck();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getMaxGetTime <em>Max Get Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Get Time</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getMaxGetTime()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_MaxGetTime();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getMshost <em>Mshost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mshost</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getMshost()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_Mshost();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getMsserv <em>Msserv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Msserv</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getMsserv()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_Msserv();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getMysapsso2 <em>Mysapsso2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mysapsso2</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getMysapsso2()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_Mysapsso2();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPasswd <em>Passwd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Passwd</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPasswd()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_Passwd();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPassword()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_Password();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPcs <em>Pcs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pcs</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPcs()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_Pcs();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPeakLimit <em>Peak Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Peak Limit</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPeakLimit()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_PeakLimit();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPingOnCreate <em>Ping On Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ping On Create</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPingOnCreate()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_PingOnCreate();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPoolCapacity <em>Pool Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pool Capacity</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPoolCapacity()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_PoolCapacity();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getR3name <em>R3name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>R3name</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getR3name()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_R3name();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositoryDest <em>Repository Dest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository Dest</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositoryDest()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_RepositoryDest();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositoryPasswd <em>Repository Passwd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository Passwd</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositoryPasswd()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_RepositoryPasswd();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositoryRoundtripOptimization <em>Repository Roundtrip Optimization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository Roundtrip Optimization</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositoryRoundtripOptimization()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_RepositoryRoundtripOptimization();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositorySnc <em>Repository Snc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository Snc</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositorySnc()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_RepositorySnc();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositoryUser <em>Repository User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository User</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositoryUser()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_RepositoryUser();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSaprouter <em>Saprouter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Saprouter</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSaprouter()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_Saprouter();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncLibrary <em>Snc Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snc Library</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncLibrary()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_SncLibrary();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncMode <em>Snc Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snc Mode</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncMode()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_SncMode();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncMyname <em>Snc Myname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snc Myname</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncMyname()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_SncMyname();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncPartnername <em>Snc Partnername</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snc Partnername</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncPartnername()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_SncPartnername();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncQop <em>Snc Qop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snc Qop</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncQop()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_SncQop();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSysnr <em>Sysnr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sysnr</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSysnr()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_Sysnr();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getTphost <em>Tphost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tphost</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getTphost()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_Tphost();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getTpname <em>Tpname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tpname</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getTpname()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_Tpname();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getTrace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trace</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getTrace()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_Trace();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getType()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getUserName <em>User Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Name</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getUserName()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_UserName();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getUser()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_User();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getUserId <em>User Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Id</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getUserId()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_UserId();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getUseSapgui <em>Use Sapgui</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Sapgui</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getUseSapgui()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_UseSapgui();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getX509cert <em>X50 9cert</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X50 9cert</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getX509cert()
	 * @see #getConnectionRequestInfo()
	 * @generated
	 */
	EAttribute getConnectionRequestInfo_X509cert();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Connection Request Info Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Request Info Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueDataType="org.eclipse.emf.ecore.EString" valueRequired="true"
	 * @generated
	 */
	EClass getConnectionRequestInfoEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getConnectionRequestInfoEntry()
	 * @generated
	 */
	EAttribute getConnectionRequestInfoEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getConnectionRequestInfoEntry()
	 * @generated
	 */
	EAttribute getConnectionRequestInfoEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfoStore <em>Connection Request Info Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Request Info Store</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfoStore
	 * @generated
	 */
	EClass getConnectionRequestInfoStore();

	/**
	 * Returns the meta object for the map '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfoStore#getConnectionRequestInfos <em>Connection Request Infos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Connection Request Infos</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfoStore#getConnectionRequestInfos()
	 * @see #getConnectionRequestInfoStore()
	 * @generated
	 */
	EReference getConnectionRequestInfoStore_ConnectionRequestInfos();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Connection Request Info Store Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Request Info Store Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueType="org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo" valueRequired="true"
	 * @generated
	 */
	EClass getConnectionRequestInfoStoreEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getConnectionRequestInfoStoreEntry()
	 * @generated
	 */
	EAttribute getConnectionRequestInfoStoreEntry_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getConnectionRequestInfoStoreEntry()
	 * @generated
	 */
	EReference getConnectionRequestInfoStoreEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory <em>Managed Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Managed Connection Factory</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory
	 * @generated
	 */
	EClass getManagedConnectionFactory();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getState()
	 * @see #getManagedConnectionFactory()
	 * @generated
	 */
	EAttribute getManagedConnectionFactory_State();

	/**
	 * Returns the meta object for the container reference '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getResourceAdapter <em>Resource Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Resource Adapter</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getResourceAdapter()
	 * @see #getManagedConnectionFactory()
	 * @generated
	 */
	EReference getManagedConnectionFactory_ResourceAdapter();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getDefaultConnectionName <em>Default Connection Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Connection Name</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getDefaultConnectionName()
	 * @see #getManagedConnectionFactory()
	 * @generated
	 */
	EAttribute getManagedConnectionFactory_DefaultConnectionName();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getDefaultConnectionRequestInfo <em>Default Connection Request Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Connection Request Info</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getDefaultConnectionRequestInfo()
	 * @see #getManagedConnectionFactory()
	 * @generated
	 */
	EReference getManagedConnectionFactory_DefaultConnectionRequestInfo();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getManagedConnections <em>Managed Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Managed Connections</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getManagedConnections()
	 * @see #getManagedConnectionFactory()
	 * @generated
	 */
	EReference getManagedConnectionFactory_ManagedConnections();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getConnectionFactories <em>Connection Factories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connection Factories</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getConnectionFactories()
	 * @see #getManagedConnectionFactory()
	 * @generated
	 */
	EReference getManagedConnectionFactory_ConnectionFactories();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getLogWriter <em>Log Writer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Log Writer</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getLogWriter()
	 * @see #getManagedConnectionFactory()
	 * @generated
	 */
	EAttribute getManagedConnectionFactory_LogWriter();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getPackageRegistry <em>Package Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Package Registry</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory#getPackageRegistry()
	 * @see #getManagedConnectionFactory()
	 * @generated
	 */
	EReference getManagedConnectionFactory_PackageRegistry();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection <em>Managed Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Managed Connection</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnection
	 * @generated
	 */
	EClass getManagedConnection();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getState()
	 * @see #getManagedConnection()
	 * @generated
	 */
	EAttribute getManagedConnection_State();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getConnectionName <em>Connection Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection Name</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getConnectionName()
	 * @see #getManagedConnection()
	 * @generated
	 */
	EAttribute getManagedConnection_ConnectionName();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getConnectionRequestInfo <em>Connection Request Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Connection Request Info</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getConnectionRequestInfo()
	 * @see #getManagedConnection()
	 * @generated
	 */
	EReference getManagedConnection_ConnectionRequestInfo();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getConnectionHandles <em>Connection Handles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connection Handles</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getConnectionHandles()
	 * @see #getManagedConnection()
	 * @generated
	 */
	EReference getManagedConnection_ConnectionHandles();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getLogWriter <em>Log Writer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Log Writer</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getLogWriter()
	 * @see #getManagedConnection()
	 * @generated
	 */
	EAttribute getManagedConnection_LogWriter();

	/**
	 * Returns the meta object for the attribute list '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getConnectionEventListeners <em>Connection Event Listeners</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Connection Event Listeners</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getConnectionEventListeners()
	 * @see #getManagedConnection()
	 * @generated
	 */
	EAttribute getManagedConnection_ConnectionEventListeners();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#isInTransaction <em>In Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>In Transaction</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnection#isInTransaction()
	 * @see #getManagedConnection()
	 * @generated
	 */
	EAttribute getManagedConnection_InTransaction();

	/**
	 * Returns the meta object for the container reference '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getManagedConnectionFactory <em>Managed Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Managed Connection Factory</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnection#getManagedConnectionFactory()
	 * @see #getManagedConnection()
	 * @generated
	 */
	EReference getManagedConnection_ManagedConnectionFactory();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.model.spi.ResourceAdapter <em>Resource Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Adapter</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ResourceAdapter
	 * @generated
	 */
	EClass getResourceAdapter();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.spi.ResourceAdapter#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ResourceAdapter#getState()
	 * @see #getResourceAdapter()
	 * @generated
	 */
	EAttribute getResourceAdapter_State();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.jca.adapters.sap.model.spi.ResourceAdapter#getConnectionRequestInfoStore <em>Connection Request Info Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Connection Request Info Store</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ResourceAdapter#getConnectionRequestInfoStore()
	 * @see #getResourceAdapter()
	 * @generated
	 */
	EReference getResourceAdapter_ConnectionRequestInfoStore();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.jca.adapters.sap.model.spi.ResourceAdapter#getManagedConnectionFactories <em>Managed Connection Factories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Managed Connection Factories</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ResourceAdapter#getManagedConnectionFactories()
	 * @see #getResourceAdapter()
	 * @generated
	 */
	EReference getResourceAdapter_ManagedConnectionFactories();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.model.spi.PackageRegistry <em>Package Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Registry</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.PackageRegistry
	 * @generated
	 */
	EClass getPackageRegistry();

	/**
	 * Returns the meta object for the map '{@link org.jboss.jca.adapters.sap.model.spi.PackageRegistry#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Packages</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.PackageRegistry#getPackages()
	 * @see #getPackageRegistry()
	 * @generated
	 */
	EReference getPackageRegistry_Packages();

	/**
	 * Returns the meta object for the container reference '{@link org.jboss.jca.adapters.sap.model.spi.PackageRegistry#getManagedConnectionFactory <em>Managed Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Managed Connection Factory</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.PackageRegistry#getManagedConnectionFactory()
	 * @see #getPackageRegistry()
	 * @generated
	 */
	EReference getPackageRegistry_ManagedConnectionFactory();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Package Registry Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Registry Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueType="org.eclipse.emf.ecore.EPackage" valueContainment="true" valueResolveProxies="true" valueRequired="true"
	 * @generated
	 */
	EClass getPackageRegistryEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPackageRegistryEntry()
	 * @generated
	 */
	EAttribute getPackageRegistryEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPackageRegistryEntry()
	 * @generated
	 */
	EReference getPackageRegistryEntry_Value();

	/**
	 * Returns the meta object for enum '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactoryState <em>Managed Connection Factory State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Managed Connection Factory State</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactoryState
	 * @generated
	 */
	EEnum getManagedConnectionFactoryState();

	/**
	 * Returns the meta object for enum '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionState <em>Managed Connection State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Managed Connection State</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionState
	 * @generated
	 */
	EEnum getManagedConnectionState();

	/**
	 * Returns the meta object for enum '{@link org.jboss.jca.adapters.sap.model.spi.ResourceAdapterState <em>Resource Adapter State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Resource Adapter State</em>'.
	 * @see org.jboss.jca.adapters.sap.model.spi.ResourceAdapterState
	 * @generated
	 */
	EEnum getResourceAdapterState();

	/**
	 * Returns the meta object for data type '{@link java.io.PrintWriter <em>Print Writer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Print Writer</em>'.
	 * @see java.io.PrintWriter
	 * @model instanceClass="java.io.PrintWriter" serializeable="false"
	 * @generated
	 */
	EDataType getPrintWriter();

	/**
	 * Returns the meta object for data type '{@link javax.resource.spi.ConnectionEventListener <em>Connection Event Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Connection Event Listener</em>'.
	 * @see javax.resource.spi.ConnectionEventListener
	 * @model instanceClass="javax.resource.spi.ConnectionEventListener" serializeable="false"
	 * @generated
	 */
	EDataType getConnectionEventListener();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SpiFactory getSpiFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl <em>Connection Request Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getConnectionRequestInfo()
		 * @generated
		 */
		EClass CONNECTION_REQUEST_INFO = eINSTANCE.getConnectionRequestInfo();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_REQUEST_INFO__ENTRIES = eINSTANCE.getConnectionRequestInfo_Entries();

		/**
		 * The meta object literal for the '<em><b>Alias User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__ALIAS_USER = eINSTANCE.getConnectionRequestInfo_AliasUser();

		/**
		 * The meta object literal for the '<em><b>Ashost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__ASHOST = eINSTANCE.getConnectionRequestInfo_Ashost();

		/**
		 * The meta object literal for the '<em><b>Auth Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__AUTH_TYPE = eINSTANCE.getConnectionRequestInfo_AuthType();

		/**
		 * The meta object literal for the '<em><b>Client</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__CLIENT = eINSTANCE.getConnectionRequestInfo_Client();

		/**
		 * The meta object literal for the '<em><b>Codepage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__CODEPAGE = eINSTANCE.getConnectionRequestInfo_Codepage();

		/**
		 * The meta object literal for the '<em><b>Cpic Trace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__CPIC_TRACE = eINSTANCE.getConnectionRequestInfo_CpicTrace();

		/**
		 * The meta object literal for the '<em><b>Deny Initial Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__DENY_INITIAL_PASSWORD = eINSTANCE.getConnectionRequestInfo_DenyInitialPassword();

		/**
		 * The meta object literal for the '<em><b>Expiration Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__EXPIRATION_PERIOD = eINSTANCE.getConnectionRequestInfo_ExpirationPeriod();

		/**
		 * The meta object literal for the '<em><b>Expiration Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__EXPIRATION_TIME = eINSTANCE.getConnectionRequestInfo_ExpirationTime();

		/**
		 * The meta object literal for the '<em><b>Getsso2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__GETSSO2 = eINSTANCE.getConnectionRequestInfo_Getsso2();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__GROUP = eINSTANCE.getConnectionRequestInfo_Group();

		/**
		 * The meta object literal for the '<em><b>Gwhost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__GWHOST = eINSTANCE.getConnectionRequestInfo_Gwhost();

		/**
		 * The meta object literal for the '<em><b>Gwserv</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__GWSERV = eINSTANCE.getConnectionRequestInfo_Gwserv();

		/**
		 * The meta object literal for the '<em><b>Lang</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__LANG = eINSTANCE.getConnectionRequestInfo_Lang();

		/**
		 * The meta object literal for the '<em><b>Lcheck</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__LCHECK = eINSTANCE.getConnectionRequestInfo_Lcheck();

		/**
		 * The meta object literal for the '<em><b>Max Get Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__MAX_GET_TIME = eINSTANCE.getConnectionRequestInfo_MaxGetTime();

		/**
		 * The meta object literal for the '<em><b>Mshost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__MSHOST = eINSTANCE.getConnectionRequestInfo_Mshost();

		/**
		 * The meta object literal for the '<em><b>Msserv</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__MSSERV = eINSTANCE.getConnectionRequestInfo_Msserv();

		/**
		 * The meta object literal for the '<em><b>Mysapsso2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__MYSAPSSO2 = eINSTANCE.getConnectionRequestInfo_Mysapsso2();

		/**
		 * The meta object literal for the '<em><b>Passwd</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__PASSWD = eINSTANCE.getConnectionRequestInfo_Passwd();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__PASSWORD = eINSTANCE.getConnectionRequestInfo_Password();

		/**
		 * The meta object literal for the '<em><b>Pcs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__PCS = eINSTANCE.getConnectionRequestInfo_Pcs();

		/**
		 * The meta object literal for the '<em><b>Peak Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__PEAK_LIMIT = eINSTANCE.getConnectionRequestInfo_PeakLimit();

		/**
		 * The meta object literal for the '<em><b>Ping On Create</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__PING_ON_CREATE = eINSTANCE.getConnectionRequestInfo_PingOnCreate();

		/**
		 * The meta object literal for the '<em><b>Pool Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__POOL_CAPACITY = eINSTANCE.getConnectionRequestInfo_PoolCapacity();

		/**
		 * The meta object literal for the '<em><b>R3name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__R3NAME = eINSTANCE.getConnectionRequestInfo_R3name();

		/**
		 * The meta object literal for the '<em><b>Repository Dest</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__REPOSITORY_DEST = eINSTANCE.getConnectionRequestInfo_RepositoryDest();

		/**
		 * The meta object literal for the '<em><b>Repository Passwd</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__REPOSITORY_PASSWD = eINSTANCE.getConnectionRequestInfo_RepositoryPasswd();

		/**
		 * The meta object literal for the '<em><b>Repository Roundtrip Optimization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__REPOSITORY_ROUNDTRIP_OPTIMIZATION = eINSTANCE.getConnectionRequestInfo_RepositoryRoundtripOptimization();

		/**
		 * The meta object literal for the '<em><b>Repository Snc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__REPOSITORY_SNC = eINSTANCE.getConnectionRequestInfo_RepositorySnc();

		/**
		 * The meta object literal for the '<em><b>Repository User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__REPOSITORY_USER = eINSTANCE.getConnectionRequestInfo_RepositoryUser();

		/**
		 * The meta object literal for the '<em><b>Saprouter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__SAPROUTER = eINSTANCE.getConnectionRequestInfo_Saprouter();

		/**
		 * The meta object literal for the '<em><b>Snc Library</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__SNC_LIBRARY = eINSTANCE.getConnectionRequestInfo_SncLibrary();

		/**
		 * The meta object literal for the '<em><b>Snc Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__SNC_MODE = eINSTANCE.getConnectionRequestInfo_SncMode();

		/**
		 * The meta object literal for the '<em><b>Snc Myname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__SNC_MYNAME = eINSTANCE.getConnectionRequestInfo_SncMyname();

		/**
		 * The meta object literal for the '<em><b>Snc Partnername</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__SNC_PARTNERNAME = eINSTANCE.getConnectionRequestInfo_SncPartnername();

		/**
		 * The meta object literal for the '<em><b>Snc Qop</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__SNC_QOP = eINSTANCE.getConnectionRequestInfo_SncQop();

		/**
		 * The meta object literal for the '<em><b>Sysnr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__SYSNR = eINSTANCE.getConnectionRequestInfo_Sysnr();

		/**
		 * The meta object literal for the '<em><b>Tphost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__TPHOST = eINSTANCE.getConnectionRequestInfo_Tphost();

		/**
		 * The meta object literal for the '<em><b>Tpname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__TPNAME = eINSTANCE.getConnectionRequestInfo_Tpname();

		/**
		 * The meta object literal for the '<em><b>Trace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__TRACE = eINSTANCE.getConnectionRequestInfo_Trace();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__TYPE = eINSTANCE.getConnectionRequestInfo_Type();

		/**
		 * The meta object literal for the '<em><b>User Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__USER_NAME = eINSTANCE.getConnectionRequestInfo_UserName();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__USER = eINSTANCE.getConnectionRequestInfo_User();

		/**
		 * The meta object literal for the '<em><b>User Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__USER_ID = eINSTANCE.getConnectionRequestInfo_UserId();

		/**
		 * The meta object literal for the '<em><b>Use Sapgui</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__USE_SAPGUI = eINSTANCE.getConnectionRequestInfo_UseSapgui();

		/**
		 * The meta object literal for the '<em><b>X50 9cert</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO__X509CERT = eINSTANCE.getConnectionRequestInfo_X509cert();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoEntryImpl <em>Connection Request Info Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoEntryImpl
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getConnectionRequestInfoEntry()
		 * @generated
		 */
		EClass CONNECTION_REQUEST_INFO_ENTRY = eINSTANCE.getConnectionRequestInfoEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO_ENTRY__KEY = eINSTANCE.getConnectionRequestInfoEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO_ENTRY__VALUE = eINSTANCE.getConnectionRequestInfoEntry_Value();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoStoreImpl <em>Connection Request Info Store</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoStoreImpl
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getConnectionRequestInfoStore()
		 * @generated
		 */
		EClass CONNECTION_REQUEST_INFO_STORE = eINSTANCE.getConnectionRequestInfoStore();

		/**
		 * The meta object literal for the '<em><b>Connection Request Infos</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_REQUEST_INFO_STORE__CONNECTION_REQUEST_INFOS = eINSTANCE.getConnectionRequestInfoStore_ConnectionRequestInfos();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoStoreEntryImpl <em>Connection Request Info Store Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoStoreEntryImpl
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getConnectionRequestInfoStoreEntry()
		 * @generated
		 */
		EClass CONNECTION_REQUEST_INFO_STORE_ENTRY = eINSTANCE.getConnectionRequestInfoStoreEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_REQUEST_INFO_STORE_ENTRY__KEY = eINSTANCE.getConnectionRequestInfoStoreEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_REQUEST_INFO_STORE_ENTRY__VALUE = eINSTANCE.getConnectionRequestInfoStoreEntry_Value();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionFactoryImpl <em>Managed Connection Factory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionFactoryImpl
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getManagedConnectionFactory()
		 * @generated
		 */
		EClass MANAGED_CONNECTION_FACTORY = eINSTANCE.getManagedConnectionFactory();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MANAGED_CONNECTION_FACTORY__STATE = eINSTANCE.getManagedConnectionFactory_State();

		/**
		 * The meta object literal for the '<em><b>Resource Adapter</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MANAGED_CONNECTION_FACTORY__RESOURCE_ADAPTER = eINSTANCE.getManagedConnectionFactory_ResourceAdapter();

		/**
		 * The meta object literal for the '<em><b>Default Connection Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_NAME = eINSTANCE.getManagedConnectionFactory_DefaultConnectionName();

		/**
		 * The meta object literal for the '<em><b>Default Connection Request Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO = eINSTANCE.getManagedConnectionFactory_DefaultConnectionRequestInfo();

		/**
		 * The meta object literal for the '<em><b>Managed Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MANAGED_CONNECTION_FACTORY__MANAGED_CONNECTIONS = eINSTANCE.getManagedConnectionFactory_ManagedConnections();

		/**
		 * The meta object literal for the '<em><b>Connection Factories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MANAGED_CONNECTION_FACTORY__CONNECTION_FACTORIES = eINSTANCE.getManagedConnectionFactory_ConnectionFactories();

		/**
		 * The meta object literal for the '<em><b>Log Writer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MANAGED_CONNECTION_FACTORY__LOG_WRITER = eINSTANCE.getManagedConnectionFactory_LogWriter();

		/**
		 * The meta object literal for the '<em><b>Package Registry</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MANAGED_CONNECTION_FACTORY__PACKAGE_REGISTRY = eINSTANCE.getManagedConnectionFactory_PackageRegistry();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionImpl <em>Managed Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionImpl
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getManagedConnection()
		 * @generated
		 */
		EClass MANAGED_CONNECTION = eINSTANCE.getManagedConnection();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MANAGED_CONNECTION__STATE = eINSTANCE.getManagedConnection_State();

		/**
		 * The meta object literal for the '<em><b>Connection Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MANAGED_CONNECTION__CONNECTION_NAME = eINSTANCE.getManagedConnection_ConnectionName();

		/**
		 * The meta object literal for the '<em><b>Connection Request Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MANAGED_CONNECTION__CONNECTION_REQUEST_INFO = eINSTANCE.getManagedConnection_ConnectionRequestInfo();

		/**
		 * The meta object literal for the '<em><b>Connection Handles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MANAGED_CONNECTION__CONNECTION_HANDLES = eINSTANCE.getManagedConnection_ConnectionHandles();

		/**
		 * The meta object literal for the '<em><b>Log Writer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MANAGED_CONNECTION__LOG_WRITER = eINSTANCE.getManagedConnection_LogWriter();

		/**
		 * The meta object literal for the '<em><b>Connection Event Listeners</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MANAGED_CONNECTION__CONNECTION_EVENT_LISTENERS = eINSTANCE.getManagedConnection_ConnectionEventListeners();

		/**
		 * The meta object literal for the '<em><b>In Transaction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MANAGED_CONNECTION__IN_TRANSACTION = eINSTANCE.getManagedConnection_InTransaction();

		/**
		 * The meta object literal for the '<em><b>Managed Connection Factory</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MANAGED_CONNECTION__MANAGED_CONNECTION_FACTORY = eINSTANCE.getManagedConnection_ManagedConnectionFactory();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.spi.impl.ResourceAdapterImpl <em>Resource Adapter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.ResourceAdapterImpl
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getResourceAdapter()
		 * @generated
		 */
		EClass RESOURCE_ADAPTER = eINSTANCE.getResourceAdapter();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_ADAPTER__STATE = eINSTANCE.getResourceAdapter_State();

		/**
		 * The meta object literal for the '<em><b>Connection Request Info Store</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_ADAPTER__CONNECTION_REQUEST_INFO_STORE = eINSTANCE.getResourceAdapter_ConnectionRequestInfoStore();

		/**
		 * The meta object literal for the '<em><b>Managed Connection Factories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_ADAPTER__MANAGED_CONNECTION_FACTORIES = eINSTANCE.getResourceAdapter_ManagedConnectionFactories();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.spi.impl.PackageRegistryImpl <em>Package Registry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.PackageRegistryImpl
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getPackageRegistry()
		 * @generated
		 */
		EClass PACKAGE_REGISTRY = eINSTANCE.getPackageRegistry();

		/**
		 * The meta object literal for the '<em><b>Packages</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_REGISTRY__PACKAGES = eINSTANCE.getPackageRegistry_Packages();

		/**
		 * The meta object literal for the '<em><b>Managed Connection Factory</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_REGISTRY__MANAGED_CONNECTION_FACTORY = eINSTANCE.getPackageRegistry_ManagedConnectionFactory();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.spi.impl.PackageRegistryEntryImpl <em>Package Registry Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.PackageRegistryEntryImpl
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getPackageRegistryEntry()
		 * @generated
		 */
		EClass PACKAGE_REGISTRY_ENTRY = eINSTANCE.getPackageRegistryEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_REGISTRY_ENTRY__KEY = eINSTANCE.getPackageRegistryEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_REGISTRY_ENTRY__VALUE = eINSTANCE.getPackageRegistryEntry_Value();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactoryState <em>Managed Connection Factory State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactoryState
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getManagedConnectionFactoryState()
		 * @generated
		 */
		EEnum MANAGED_CONNECTION_FACTORY_STATE = eINSTANCE.getManagedConnectionFactoryState();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.spi.ManagedConnectionState <em>Managed Connection State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.spi.ManagedConnectionState
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getManagedConnectionState()
		 * @generated
		 */
		EEnum MANAGED_CONNECTION_STATE = eINSTANCE.getManagedConnectionState();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.spi.ResourceAdapterState <em>Resource Adapter State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.spi.ResourceAdapterState
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getResourceAdapterState()
		 * @generated
		 */
		EEnum RESOURCE_ADAPTER_STATE = eINSTANCE.getResourceAdapterState();

		/**
		 * The meta object literal for the '<em>Print Writer</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.PrintWriter
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getPrintWriter()
		 * @generated
		 */
		EDataType PRINT_WRITER = eINSTANCE.getPrintWriter();

		/**
		 * The meta object literal for the '<em>Connection Event Listener</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.spi.ConnectionEventListener
		 * @see org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl#getConnectionEventListener()
		 * @generated
		 */
		EDataType CONNECTION_EVENT_LISTENER = eINSTANCE.getConnectionEventListener();

	}

} //SpiPackage
