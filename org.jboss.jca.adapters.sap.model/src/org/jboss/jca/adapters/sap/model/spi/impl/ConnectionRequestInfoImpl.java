/**
 */
package org.jboss.jca.adapters.sap.model.spi.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;

import com.sap.conn.jco.ext.DestinationDataProvider;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Request Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getEntries <em>Entries</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getAliasUser <em>Alias User</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getAshost <em>Ashost</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getAuthType <em>Auth Type</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getClient <em>Client</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getCodepage <em>Codepage</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getCpicTrace <em>Cpic Trace</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getDenyInitialPassword <em>Deny Initial Password</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getExpirationPeriod <em>Expiration Period</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getExpirationTime <em>Expiration Time</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getGetsso2 <em>Getsso2</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getGwhost <em>Gwhost</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getGwserv <em>Gwserv</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getLang <em>Lang</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getLcheck <em>Lcheck</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getMaxGetTime <em>Max Get Time</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getMshost <em>Mshost</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getMsserv <em>Msserv</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getMysapsso2 <em>Mysapsso2</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getPasswd <em>Passwd</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getPcs <em>Pcs</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getPeakLimit <em>Peak Limit</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getPingOnCreate <em>Ping On Create</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getPoolCapacity <em>Pool Capacity</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getR3name <em>R3name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getRepositoryDest <em>Repository Dest</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getRepositoryPasswd <em>Repository Passwd</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getRepositoryRoundtripOptimization <em>Repository Roundtrip Optimization</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getRepositorySnc <em>Repository Snc</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getRepositoryUser <em>Repository User</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getSaprouter <em>Saprouter</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getSncLibrary <em>Snc Library</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getSncMode <em>Snc Mode</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getSncMyname <em>Snc Myname</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getSncPartnername <em>Snc Partnername</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getSncQop <em>Snc Qop</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getSysnr <em>Sysnr</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getTphost <em>Tphost</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getTpname <em>Tpname</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getTrace <em>Trace</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getUserName <em>User Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getUserId <em>User Id</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getUseSapgui <em>Use Sapgui</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ConnectionRequestInfoImpl#getX509cert <em>X50 9cert</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionRequestInfoImpl extends EObjectImpl implements ConnectionRequestInfo {
	/**
	 * Name of Connection Spec/Connection Request Info parameter specifying whether Managed Connection will ping the connected SAP instance when created. Default is <code>false</code>.
	 * @generated NOT 
	 */
	public static final String JSJC_PING_ON_CREATE = "jsjc.mc.poc";

	/**
	 * The cached value of the '{@link #getEntries() <em>Entries</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntries()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> entries;

	/**
	 * The default value of the '{@link #getAliasUser() <em>Alias User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAliasUser()
	 * @generated
	 * @ordered
	 */
	protected static final String ALIAS_USER_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getAshost() <em>Ashost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAshost()
	 * @generated
	 * @ordered
	 */
	protected static final String ASHOST_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getAuthType() <em>Auth Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthType()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTH_TYPE_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getClient() <em>Client</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClient()
	 * @generated
	 * @ordered
	 */
	protected static final String CLIENT_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getCodepage() <em>Codepage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodepage()
	 * @generated
	 * @ordered
	 */
	protected static final String CODEPAGE_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getCpicTrace() <em>Cpic Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpicTrace()
	 * @generated
	 * @ordered
	 */
	protected static final String CPIC_TRACE_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getDenyInitialPassword() <em>Deny Initial Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDenyInitialPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String DENY_INITIAL_PASSWORD_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getExpirationPeriod() <em>Expiration Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpirationPeriod()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPIRATION_PERIOD_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getExpirationTime() <em>Expiration Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpirationTime()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPIRATION_TIME_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getGetsso2() <em>Getsso2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGetsso2()
	 * @generated
	 * @ordered
	 */
	protected static final String GETSSO2_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getGroup() <em>Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected static final String GROUP_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getGwhost() <em>Gwhost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGwhost()
	 * @generated
	 * @ordered
	 */
	protected static final String GWHOST_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getGwserv() <em>Gwserv</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGwserv()
	 * @generated
	 * @ordered
	 */
	protected static final String GWSERV_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getLang() <em>Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLang()
	 * @generated
	 * @ordered
	 */
	protected static final String LANG_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getLcheck() <em>Lcheck</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLcheck()
	 * @generated
	 * @ordered
	 */
	protected static final String LCHECK_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getMaxGetTime() <em>Max Get Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxGetTime()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_GET_TIME_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getMshost() <em>Mshost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMshost()
	 * @generated
	 * @ordered
	 */
	protected static final String MSHOST_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getMsserv() <em>Msserv</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMsserv()
	 * @generated
	 * @ordered
	 */
	protected static final String MSSERV_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getMysapsso2() <em>Mysapsso2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMysapsso2()
	 * @generated
	 * @ordered
	 */
	protected static final String MYSAPSSO2_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getPasswd() <em>Passwd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPasswd()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWD_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getPcs() <em>Pcs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPcs()
	 * @generated
	 * @ordered
	 */
	protected static final String PCS_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getPeakLimit() <em>Peak Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeakLimit()
	 * @generated
	 * @ordered
	 */
	protected static final String PEAK_LIMIT_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getPingOnCreate() <em>Ping On Create</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPingOnCreate()
	 * @generated
	 * @ordered
	 */
	protected static final String PING_ON_CREATE_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getPoolCapacity() <em>Pool Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPoolCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final String POOL_CAPACITY_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getR3name() <em>R3name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR3name()
	 * @generated
	 * @ordered
	 */
	protected static final String R3NAME_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getRepositoryDest() <em>Repository Dest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryDest()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_DEST_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getRepositoryPasswd() <em>Repository Passwd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryPasswd()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_PASSWD_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getRepositoryRoundtripOptimization() <em>Repository Roundtrip Optimization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryRoundtripOptimization()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_ROUNDTRIP_OPTIMIZATION_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getRepositorySnc() <em>Repository Snc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositorySnc()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_SNC_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getRepositoryUser() <em>Repository User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryUser()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_USER_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getSaprouter() <em>Saprouter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSaprouter()
	 * @generated
	 * @ordered
	 */
	protected static final String SAPROUTER_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getSncLibrary() <em>Snc Library</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSncLibrary()
	 * @generated
	 * @ordered
	 */
	protected static final String SNC_LIBRARY_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getSncMode() <em>Snc Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSncMode()
	 * @generated
	 * @ordered
	 */
	protected static final String SNC_MODE_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getSncMyname() <em>Snc Myname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSncMyname()
	 * @generated
	 * @ordered
	 */
	protected static final String SNC_MYNAME_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getSncPartnername() <em>Snc Partnername</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSncPartnername()
	 * @generated
	 * @ordered
	 */
	protected static final String SNC_PARTNERNAME_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getSncQop() <em>Snc Qop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSncQop()
	 * @generated
	 * @ordered
	 */
	protected static final String SNC_QOP_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getSysnr() <em>Sysnr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSysnr()
	 * @generated
	 * @ordered
	 */
	protected static final String SYSNR_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getTphost() <em>Tphost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTphost()
	 * @generated
	 * @ordered
	 */
	protected static final String TPHOST_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getTpname() <em>Tpname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTpname()
	 * @generated
	 * @ordered
	 */
	protected static final String TPNAME_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getTrace() <em>Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrace()
	 * @generated
	 * @ordered
	 */
	protected static final String TRACE_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getUserName() <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserName()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_NAME_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getUser() <em>User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUser()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getUserId() <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserId()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_ID_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getUseSapgui() <em>Use Sapgui</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseSapgui()
	 * @generated
	 * @ordered
	 */
	protected static final String USE_SAPGUI_EDEFAULT = "";

	/**
	 * The default value of the '{@link #getX509cert() <em>X50 9cert</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX509cert()
	 * @generated
	 * @ordered
	 */
	protected static final String X509CERT_EDEFAULT = "";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionRequestInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpiPackage.Literals.CONNECTION_REQUEST_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getEntries() {
		if (entries == null) {
			entries = new EcoreEMap<String,String>(SpiPackage.Literals.CONNECTION_REQUEST_INFO_ENTRY, ConnectionRequestInfoEntryImpl.class, this, SpiPackage.CONNECTION_REQUEST_INFO__ENTRIES);
		}
		return entries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getAliasUser() {
		return getEntries().get(DestinationDataProvider.JCO_ALIAS_USER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getAshost() {
		return getEntries().get(DestinationDataProvider.JCO_ASHOST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getAuthType() {
		String value = getEntries().get(DestinationDataProvider.JCO_AUTH_TYPE);
		return (value == null) ? DestinationDataProvider.JCO_AUTH_TYPE_CONFIGURED_USER : value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getClient() {
		return getEntries().get(DestinationDataProvider.JCO_CLIENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getCodepage() {
		return getEntries().get(DestinationDataProvider.JCO_CODEPAGE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getCpicTrace() {
		return getEntries().get(DestinationDataProvider.JCO_CPIC_TRACE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getDenyInitialPassword() {
		String value = getEntries().get(DestinationDataProvider.JCO_DENY_INITIAL_PASSWORD);
		return (value == null) ? "0" : value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getExpirationPeriod() {
		return getEntries().get(DestinationDataProvider.JCO_EXPIRATION_PERIOD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getExpirationTime() {
		return getEntries().get(DestinationDataProvider.JCO_EXPIRATION_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getGetsso2() {
		return getEntries().get(DestinationDataProvider.JCO_GETSSO2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getGroup() {
		return getEntries().get(DestinationDataProvider.JCO_GROUP);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getGwhost() {
		return getEntries().get(DestinationDataProvider.JCO_GWHOST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getGwserv() {
		return getEntries().get(DestinationDataProvider.JCO_GWSERV);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getLang() {
		return getEntries().get(DestinationDataProvider.JCO_LANG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getLcheck() {
		return getEntries().get(DestinationDataProvider.JCO_LCHECK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getMaxGetTime() {
		return getEntries().get(DestinationDataProvider.JCO_MAX_GET_TIME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getMshost() {
		return getEntries().get(DestinationDataProvider.JCO_MSHOST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getMsserv() {
		return getEntries().get(DestinationDataProvider.JCO_MSSERV);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getMysapsso2() {
		return getEntries().get(DestinationDataProvider.JCO_MYSAPSSO2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPassword() {
		return getEntries().get(DestinationDataProvider.JCO_PASSWD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPasswd() {
		return getEntries().get(DestinationDataProvider.JCO_PASSWD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPcs() {
		return getEntries().get(DestinationDataProvider.JCO_PCS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPeakLimit() {
		return getEntries().get(DestinationDataProvider.JCO_PEAK_LIMIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPingOnCreate() {
		String value = getEntries().get(JSJC_PING_ON_CREATE);
		return (value == null) ? "false" : value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPoolCapacity() {
		String value = getEntries().get(DestinationDataProvider.JCO_POOL_CAPACITY);
		return (value == null) ? "1" : value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getR3name() {
		return getEntries().get(DestinationDataProvider.JCO_R3NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getRepositoryDest() {
		return getEntries().get(DestinationDataProvider.JCO_REPOSITORY_DEST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getRepositoryPasswd() {
		return getEntries().get(DestinationDataProvider.JCO_REPOSITORY_PASSWD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getRepositoryRoundtripOptimization() {
		return getEntries().get(DestinationDataProvider.JCO_REPOSITORY_ROUNDTRIP_OPTIMIZATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getRepositorySnc() {
		return getEntries().get(DestinationDataProvider.JCO_REPOSITORY_SNC);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getRepositoryUser() {
		return getEntries().get(DestinationDataProvider.JCO_REPOSITORY_USER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSaprouter() {
		return getEntries().get(DestinationDataProvider.JCO_SAPROUTER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSncLibrary() {
		return getEntries().get(DestinationDataProvider.JCO_SNC_LIBRARY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSncMode() {
		return getEntries().get(DestinationDataProvider.JCO_SNC_MODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSncMyname() {
		return getEntries().get(DestinationDataProvider.JCO_SNC_MYNAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSncPartnername() {
		return getEntries().get(DestinationDataProvider.JCO_SNC_PARTNERNAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSncQop() {
		return getEntries().get(DestinationDataProvider.JCO_SNC_QOP);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSysnr() {
		return getEntries().get(DestinationDataProvider.JCO_SYSNR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getTphost() {
		return getEntries().get(DestinationDataProvider.JCO_TPHOST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getTpname() {
		return getEntries().get(DestinationDataProvider.JCO_TPNAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getTrace() {
		return getEntries().get(DestinationDataProvider.JCO_TRACE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getType() {
		return getEntries().get(DestinationDataProvider.JCO_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getUserName() {
		return getEntries().get(DestinationDataProvider.JCO_USER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getUser() {
		return getEntries().get(DestinationDataProvider.JCO_USER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getUserId() {
		return getEntries().get(DestinationDataProvider.JCO_USER_ID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getUseSapgui() {
		return getEntries().get(DestinationDataProvider.JCO_USE_SAPGUI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getX509cert() {
		return getEntries().get(DestinationDataProvider.JCO_X509CERT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setAliasUser(String user) {
		getEntries().put(DestinationDataProvider.JCO_ALIAS_USER, user);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setAshost(String ashost) {
		getEntries().put(DestinationDataProvider.JCO_ASHOST, ashost);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setAuthType(String authType) {
		getEntries().put(DestinationDataProvider.JCO_AUTH_TYPE, authType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setClient(String client) {
		getEntries().put(DestinationDataProvider.JCO_CLIENT, client);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setCodepage(String codepage) {
		getEntries().put(DestinationDataProvider.JCO_CODEPAGE, codepage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setCpicTrace(String cpicTrace) {
		getEntries().put(DestinationDataProvider.JCO_CPIC_TRACE, cpicTrace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setDenyInitialPassword(String denyInitialPassword) {
		getEntries().put(DestinationDataProvider.JCO_DENY_INITIAL_PASSWORD, denyInitialPassword);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setExpirationPeriod(String expirationPeriod) {
		getEntries().put(DestinationDataProvider.JCO_EXPIRATION_PERIOD, expirationPeriod);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setExpirationTime(String expirationTime) {
		getEntries().put(DestinationDataProvider.JCO_EXPIRATION_TIME, expirationTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setGetsso2(String getsso2) {
		getEntries().put(DestinationDataProvider.JCO_GETSSO2, getsso2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setGroup(String group) {
		getEntries().put(DestinationDataProvider.JCO_GROUP, group);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setGwhost(String gwhost) {
		getEntries().put(DestinationDataProvider.JCO_GWHOST, gwhost);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setGwserv(String gwserv) {
		getEntries().put(DestinationDataProvider.JCO_GWSERV, gwserv);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setLang(String lang) {
		getEntries().put(DestinationDataProvider.JCO_LANG, lang);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setLcheck(String lcheck) {
		getEntries().put(DestinationDataProvider.JCO_LCHECK, lcheck);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMaxGetTime(String maxGetTime) {
		getEntries().put(DestinationDataProvider.JCO_MAX_GET_TIME, maxGetTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMshost(String mshost) {
		getEntries().put(DestinationDataProvider.JCO_MSHOST, mshost);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMsserv(String msserv) {
		getEntries().put(DestinationDataProvider.JCO_MSSERV, msserv);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMysapsso2(String mysapsso2) {
		getEntries().put(DestinationDataProvider.JCO_MYSAPSSO2, mysapsso2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPassword(String password) {
		getEntries().put(DestinationDataProvider.JCO_PASSWD, password);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPasswd(String passwd) {
		getEntries().put(DestinationDataProvider.JCO_PASSWD, passwd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPcs(String pcs) {
		getEntries().put(DestinationDataProvider.JCO_PCS, pcs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPeakLimit(String peakLimit) {
		getEntries().put(DestinationDataProvider.JCO_PEAK_LIMIT, peakLimit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPingOnCreate(String pingOnCreate) {
		getEntries().put(ConnectionRequestInfoImpl.JSJC_PING_ON_CREATE, pingOnCreate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPoolCapacity(String poolCapacity) {
		getEntries().put(DestinationDataProvider.JCO_POOL_CAPACITY, poolCapacity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setR3name(String r3name) {
		getEntries().put(DestinationDataProvider.JCO_R3NAME, r3name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRepositoryDest(String repositoryDest) {
		getEntries().put(DestinationDataProvider.JCO_REPOSITORY_DEST, repositoryDest);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRepositoryPasswd(String repositoryPasswd) {
		getEntries().put(DestinationDataProvider.JCO_REPOSITORY_PASSWD, repositoryPasswd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRepositoryRoundtripOptimization(String repositoryRoundtripOptimization) {
		getEntries().put(DestinationDataProvider.JCO_REPOSITORY_ROUNDTRIP_OPTIMIZATION, repositoryRoundtripOptimization);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRepositorySnc(String repositorySnc) {
		getEntries().put(DestinationDataProvider.JCO_REPOSITORY_SNC, repositorySnc);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRepositoryUser(String repositoryUser) {
		getEntries().put(DestinationDataProvider.JCO_REPOSITORY_USER, repositoryUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSaprouter(String saprouter) {
		getEntries().put(DestinationDataProvider.JCO_SAPROUTER, saprouter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSncLibrary(String sncLibrary) {
		getEntries().put(DestinationDataProvider.JCO_SNC_LIBRARY, sncLibrary);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSncMode(String sncMode) {
		getEntries().put(DestinationDataProvider.JCO_SNC_MODE, sncMode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSncMyname(String sncMyname) {
		getEntries().put(DestinationDataProvider.JCO_SNC_MYNAME, sncMyname);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSncPartnername(String sncPartnername) {
		getEntries().put(DestinationDataProvider.JCO_SNC_PARTNERNAME, sncPartnername);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSncQop(String sncQop) {
		getEntries().put(DestinationDataProvider.JCO_SNC_QOP, sncQop);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSysnr(String sysnr) {
		getEntries().put(DestinationDataProvider.JCO_SYSNR, sysnr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setTphost(String tphost) {
		getEntries().put(DestinationDataProvider.JCO_TPHOST, tphost);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setTpname(String tpname) {
		getEntries().put(DestinationDataProvider.JCO_TPNAME, tpname);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setTrace(String trace) {
		getEntries().put(DestinationDataProvider.JCO_TRACE, trace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setType(String type) {
		getEntries().put(DestinationDataProvider.JCO_TYPE, type);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setUserName(String userName) {
		getEntries().put(DestinationDataProvider.JCO_USER, userName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setUser(String user) {
		getEntries().put(DestinationDataProvider.JCO_USER, user);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setUserId(String userId) {
		getEntries().put(DestinationDataProvider.JCO_USER_ID, userId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setUseSapgui(String useSapgui) {
		getEntries().put(DestinationDataProvider.JCO_USE_SAPGUI, useSapgui);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setX509cert(String x509cert) {
		getEntries().put(DestinationDataProvider.JCO_X509CERT, x509cert);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpiPackage.CONNECTION_REQUEST_INFO__ENTRIES:
				return ((InternalEList<?>)getEntries()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SpiPackage.CONNECTION_REQUEST_INFO__ENTRIES:
				if (coreType) return getEntries();
				else return getEntries().map();
			case SpiPackage.CONNECTION_REQUEST_INFO__ALIAS_USER:
				return getAliasUser();
			case SpiPackage.CONNECTION_REQUEST_INFO__ASHOST:
				return getAshost();
			case SpiPackage.CONNECTION_REQUEST_INFO__AUTH_TYPE:
				return getAuthType();
			case SpiPackage.CONNECTION_REQUEST_INFO__CLIENT:
				return getClient();
			case SpiPackage.CONNECTION_REQUEST_INFO__CODEPAGE:
				return getCodepage();
			case SpiPackage.CONNECTION_REQUEST_INFO__CPIC_TRACE:
				return getCpicTrace();
			case SpiPackage.CONNECTION_REQUEST_INFO__DENY_INITIAL_PASSWORD:
				return getDenyInitialPassword();
			case SpiPackage.CONNECTION_REQUEST_INFO__EXPIRATION_PERIOD:
				return getExpirationPeriod();
			case SpiPackage.CONNECTION_REQUEST_INFO__EXPIRATION_TIME:
				return getExpirationTime();
			case SpiPackage.CONNECTION_REQUEST_INFO__GETSSO2:
				return getGetsso2();
			case SpiPackage.CONNECTION_REQUEST_INFO__GROUP:
				return getGroup();
			case SpiPackage.CONNECTION_REQUEST_INFO__GWHOST:
				return getGwhost();
			case SpiPackage.CONNECTION_REQUEST_INFO__GWSERV:
				return getGwserv();
			case SpiPackage.CONNECTION_REQUEST_INFO__LANG:
				return getLang();
			case SpiPackage.CONNECTION_REQUEST_INFO__LCHECK:
				return getLcheck();
			case SpiPackage.CONNECTION_REQUEST_INFO__MAX_GET_TIME:
				return getMaxGetTime();
			case SpiPackage.CONNECTION_REQUEST_INFO__MSHOST:
				return getMshost();
			case SpiPackage.CONNECTION_REQUEST_INFO__MSSERV:
				return getMsserv();
			case SpiPackage.CONNECTION_REQUEST_INFO__MYSAPSSO2:
				return getMysapsso2();
			case SpiPackage.CONNECTION_REQUEST_INFO__PASSWD:
				return getPasswd();
			case SpiPackage.CONNECTION_REQUEST_INFO__PASSWORD:
				return getPassword();
			case SpiPackage.CONNECTION_REQUEST_INFO__PCS:
				return getPcs();
			case SpiPackage.CONNECTION_REQUEST_INFO__PEAK_LIMIT:
				return getPeakLimit();
			case SpiPackage.CONNECTION_REQUEST_INFO__PING_ON_CREATE:
				return getPingOnCreate();
			case SpiPackage.CONNECTION_REQUEST_INFO__POOL_CAPACITY:
				return getPoolCapacity();
			case SpiPackage.CONNECTION_REQUEST_INFO__R3NAME:
				return getR3name();
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_DEST:
				return getRepositoryDest();
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_PASSWD:
				return getRepositoryPasswd();
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_ROUNDTRIP_OPTIMIZATION:
				return getRepositoryRoundtripOptimization();
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_SNC:
				return getRepositorySnc();
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_USER:
				return getRepositoryUser();
			case SpiPackage.CONNECTION_REQUEST_INFO__SAPROUTER:
				return getSaprouter();
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_LIBRARY:
				return getSncLibrary();
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_MODE:
				return getSncMode();
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_MYNAME:
				return getSncMyname();
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_PARTNERNAME:
				return getSncPartnername();
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_QOP:
				return getSncQop();
			case SpiPackage.CONNECTION_REQUEST_INFO__SYSNR:
				return getSysnr();
			case SpiPackage.CONNECTION_REQUEST_INFO__TPHOST:
				return getTphost();
			case SpiPackage.CONNECTION_REQUEST_INFO__TPNAME:
				return getTpname();
			case SpiPackage.CONNECTION_REQUEST_INFO__TRACE:
				return getTrace();
			case SpiPackage.CONNECTION_REQUEST_INFO__TYPE:
				return getType();
			case SpiPackage.CONNECTION_REQUEST_INFO__USER_NAME:
				return getUserName();
			case SpiPackage.CONNECTION_REQUEST_INFO__USER:
				return getUser();
			case SpiPackage.CONNECTION_REQUEST_INFO__USER_ID:
				return getUserId();
			case SpiPackage.CONNECTION_REQUEST_INFO__USE_SAPGUI:
				return getUseSapgui();
			case SpiPackage.CONNECTION_REQUEST_INFO__X509CERT:
				return getX509cert();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SpiPackage.CONNECTION_REQUEST_INFO__ENTRIES:
				((EStructuralFeature.Setting)getEntries()).set(newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__ALIAS_USER:
				setAliasUser((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__ASHOST:
				setAshost((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__AUTH_TYPE:
				setAuthType((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__CLIENT:
				setClient((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__CODEPAGE:
				setCodepage((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__CPIC_TRACE:
				setCpicTrace((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__DENY_INITIAL_PASSWORD:
				setDenyInitialPassword((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__EXPIRATION_PERIOD:
				setExpirationPeriod((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__EXPIRATION_TIME:
				setExpirationTime((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__GETSSO2:
				setGetsso2((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__GROUP:
				setGroup((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__GWHOST:
				setGwhost((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__GWSERV:
				setGwserv((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__LANG:
				setLang((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__LCHECK:
				setLcheck((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__MAX_GET_TIME:
				setMaxGetTime((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__MSHOST:
				setMshost((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__MSSERV:
				setMsserv((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__MYSAPSSO2:
				setMysapsso2((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__PASSWD:
				setPasswd((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__PASSWORD:
				setPassword((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__PCS:
				setPcs((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__PEAK_LIMIT:
				setPeakLimit((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__PING_ON_CREATE:
				setPingOnCreate((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__POOL_CAPACITY:
				setPoolCapacity((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__R3NAME:
				setR3name((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_DEST:
				setRepositoryDest((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_PASSWD:
				setRepositoryPasswd((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_ROUNDTRIP_OPTIMIZATION:
				setRepositoryRoundtripOptimization((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_SNC:
				setRepositorySnc((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_USER:
				setRepositoryUser((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__SAPROUTER:
				setSaprouter((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_LIBRARY:
				setSncLibrary((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_MODE:
				setSncMode((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_MYNAME:
				setSncMyname((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_PARTNERNAME:
				setSncPartnername((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_QOP:
				setSncQop((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__SYSNR:
				setSysnr((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__TPHOST:
				setTphost((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__TPNAME:
				setTpname((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__TRACE:
				setTrace((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__TYPE:
				setType((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__USER_NAME:
				setUserName((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__USER:
				setUser((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__USER_ID:
				setUserId((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__USE_SAPGUI:
				setUseSapgui((String)newValue);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__X509CERT:
				setX509cert((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SpiPackage.CONNECTION_REQUEST_INFO__ENTRIES:
				getEntries().clear();
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__ALIAS_USER:
				setAliasUser(ALIAS_USER_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__ASHOST:
				setAshost(ASHOST_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__AUTH_TYPE:
				setAuthType(AUTH_TYPE_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__CLIENT:
				setClient(CLIENT_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__CODEPAGE:
				setCodepage(CODEPAGE_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__CPIC_TRACE:
				setCpicTrace(CPIC_TRACE_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__DENY_INITIAL_PASSWORD:
				setDenyInitialPassword(DENY_INITIAL_PASSWORD_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__EXPIRATION_PERIOD:
				setExpirationPeriod(EXPIRATION_PERIOD_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__EXPIRATION_TIME:
				setExpirationTime(EXPIRATION_TIME_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__GETSSO2:
				setGetsso2(GETSSO2_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__GROUP:
				setGroup(GROUP_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__GWHOST:
				setGwhost(GWHOST_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__GWSERV:
				setGwserv(GWSERV_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__LANG:
				setLang(LANG_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__LCHECK:
				setLcheck(LCHECK_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__MAX_GET_TIME:
				setMaxGetTime(MAX_GET_TIME_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__MSHOST:
				setMshost(MSHOST_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__MSSERV:
				setMsserv(MSSERV_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__MYSAPSSO2:
				setMysapsso2(MYSAPSSO2_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__PASSWD:
				setPasswd(PASSWD_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__PCS:
				setPcs(PCS_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__PEAK_LIMIT:
				setPeakLimit(PEAK_LIMIT_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__PING_ON_CREATE:
				setPingOnCreate(PING_ON_CREATE_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__POOL_CAPACITY:
				setPoolCapacity(POOL_CAPACITY_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__R3NAME:
				setR3name(R3NAME_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_DEST:
				setRepositoryDest(REPOSITORY_DEST_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_PASSWD:
				setRepositoryPasswd(REPOSITORY_PASSWD_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_ROUNDTRIP_OPTIMIZATION:
				setRepositoryRoundtripOptimization(REPOSITORY_ROUNDTRIP_OPTIMIZATION_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_SNC:
				setRepositorySnc(REPOSITORY_SNC_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_USER:
				setRepositoryUser(REPOSITORY_USER_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__SAPROUTER:
				setSaprouter(SAPROUTER_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_LIBRARY:
				setSncLibrary(SNC_LIBRARY_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_MODE:
				setSncMode(SNC_MODE_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_MYNAME:
				setSncMyname(SNC_MYNAME_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_PARTNERNAME:
				setSncPartnername(SNC_PARTNERNAME_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_QOP:
				setSncQop(SNC_QOP_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__SYSNR:
				setSysnr(SYSNR_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__TPHOST:
				setTphost(TPHOST_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__TPNAME:
				setTpname(TPNAME_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__TRACE:
				setTrace(TRACE_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__USER_NAME:
				setUserName(USER_NAME_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__USER:
				setUser(USER_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__USER_ID:
				setUserId(USER_ID_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__USE_SAPGUI:
				setUseSapgui(USE_SAPGUI_EDEFAULT);
				return;
			case SpiPackage.CONNECTION_REQUEST_INFO__X509CERT:
				setX509cert(X509CERT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SpiPackage.CONNECTION_REQUEST_INFO__ENTRIES:
				return entries != null && !entries.isEmpty();
			case SpiPackage.CONNECTION_REQUEST_INFO__ALIAS_USER:
				return ALIAS_USER_EDEFAULT == null ? getAliasUser() != null : !ALIAS_USER_EDEFAULT.equals(getAliasUser());
			case SpiPackage.CONNECTION_REQUEST_INFO__ASHOST:
				return ASHOST_EDEFAULT == null ? getAshost() != null : !ASHOST_EDEFAULT.equals(getAshost());
			case SpiPackage.CONNECTION_REQUEST_INFO__AUTH_TYPE:
				return AUTH_TYPE_EDEFAULT == null ? getAuthType() != null : !AUTH_TYPE_EDEFAULT.equals(getAuthType());
			case SpiPackage.CONNECTION_REQUEST_INFO__CLIENT:
				return CLIENT_EDEFAULT == null ? getClient() != null : !CLIENT_EDEFAULT.equals(getClient());
			case SpiPackage.CONNECTION_REQUEST_INFO__CODEPAGE:
				return CODEPAGE_EDEFAULT == null ? getCodepage() != null : !CODEPAGE_EDEFAULT.equals(getCodepage());
			case SpiPackage.CONNECTION_REQUEST_INFO__CPIC_TRACE:
				return CPIC_TRACE_EDEFAULT == null ? getCpicTrace() != null : !CPIC_TRACE_EDEFAULT.equals(getCpicTrace());
			case SpiPackage.CONNECTION_REQUEST_INFO__DENY_INITIAL_PASSWORD:
				return DENY_INITIAL_PASSWORD_EDEFAULT == null ? getDenyInitialPassword() != null : !DENY_INITIAL_PASSWORD_EDEFAULT.equals(getDenyInitialPassword());
			case SpiPackage.CONNECTION_REQUEST_INFO__EXPIRATION_PERIOD:
				return EXPIRATION_PERIOD_EDEFAULT == null ? getExpirationPeriod() != null : !EXPIRATION_PERIOD_EDEFAULT.equals(getExpirationPeriod());
			case SpiPackage.CONNECTION_REQUEST_INFO__EXPIRATION_TIME:
				return EXPIRATION_TIME_EDEFAULT == null ? getExpirationTime() != null : !EXPIRATION_TIME_EDEFAULT.equals(getExpirationTime());
			case SpiPackage.CONNECTION_REQUEST_INFO__GETSSO2:
				return GETSSO2_EDEFAULT == null ? getGetsso2() != null : !GETSSO2_EDEFAULT.equals(getGetsso2());
			case SpiPackage.CONNECTION_REQUEST_INFO__GROUP:
				return GROUP_EDEFAULT == null ? getGroup() != null : !GROUP_EDEFAULT.equals(getGroup());
			case SpiPackage.CONNECTION_REQUEST_INFO__GWHOST:
				return GWHOST_EDEFAULT == null ? getGwhost() != null : !GWHOST_EDEFAULT.equals(getGwhost());
			case SpiPackage.CONNECTION_REQUEST_INFO__GWSERV:
				return GWSERV_EDEFAULT == null ? getGwserv() != null : !GWSERV_EDEFAULT.equals(getGwserv());
			case SpiPackage.CONNECTION_REQUEST_INFO__LANG:
				return LANG_EDEFAULT == null ? getLang() != null : !LANG_EDEFAULT.equals(getLang());
			case SpiPackage.CONNECTION_REQUEST_INFO__LCHECK:
				return LCHECK_EDEFAULT == null ? getLcheck() != null : !LCHECK_EDEFAULT.equals(getLcheck());
			case SpiPackage.CONNECTION_REQUEST_INFO__MAX_GET_TIME:
				return MAX_GET_TIME_EDEFAULT == null ? getMaxGetTime() != null : !MAX_GET_TIME_EDEFAULT.equals(getMaxGetTime());
			case SpiPackage.CONNECTION_REQUEST_INFO__MSHOST:
				return MSHOST_EDEFAULT == null ? getMshost() != null : !MSHOST_EDEFAULT.equals(getMshost());
			case SpiPackage.CONNECTION_REQUEST_INFO__MSSERV:
				return MSSERV_EDEFAULT == null ? getMsserv() != null : !MSSERV_EDEFAULT.equals(getMsserv());
			case SpiPackage.CONNECTION_REQUEST_INFO__MYSAPSSO2:
				return MYSAPSSO2_EDEFAULT == null ? getMysapsso2() != null : !MYSAPSSO2_EDEFAULT.equals(getMysapsso2());
			case SpiPackage.CONNECTION_REQUEST_INFO__PASSWD:
				return PASSWD_EDEFAULT == null ? getPasswd() != null : !PASSWD_EDEFAULT.equals(getPasswd());
			case SpiPackage.CONNECTION_REQUEST_INFO__PASSWORD:
				return PASSWORD_EDEFAULT == null ? getPassword() != null : !PASSWORD_EDEFAULT.equals(getPassword());
			case SpiPackage.CONNECTION_REQUEST_INFO__PCS:
				return PCS_EDEFAULT == null ? getPcs() != null : !PCS_EDEFAULT.equals(getPcs());
			case SpiPackage.CONNECTION_REQUEST_INFO__PEAK_LIMIT:
				return PEAK_LIMIT_EDEFAULT == null ? getPeakLimit() != null : !PEAK_LIMIT_EDEFAULT.equals(getPeakLimit());
			case SpiPackage.CONNECTION_REQUEST_INFO__PING_ON_CREATE:
				return PING_ON_CREATE_EDEFAULT == null ? getPingOnCreate() != null : !PING_ON_CREATE_EDEFAULT.equals(getPingOnCreate());
			case SpiPackage.CONNECTION_REQUEST_INFO__POOL_CAPACITY:
				return POOL_CAPACITY_EDEFAULT == null ? getPoolCapacity() != null : !POOL_CAPACITY_EDEFAULT.equals(getPoolCapacity());
			case SpiPackage.CONNECTION_REQUEST_INFO__R3NAME:
				return R3NAME_EDEFAULT == null ? getR3name() != null : !R3NAME_EDEFAULT.equals(getR3name());
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_DEST:
				return REPOSITORY_DEST_EDEFAULT == null ? getRepositoryDest() != null : !REPOSITORY_DEST_EDEFAULT.equals(getRepositoryDest());
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_PASSWD:
				return REPOSITORY_PASSWD_EDEFAULT == null ? getRepositoryPasswd() != null : !REPOSITORY_PASSWD_EDEFAULT.equals(getRepositoryPasswd());
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_ROUNDTRIP_OPTIMIZATION:
				return REPOSITORY_ROUNDTRIP_OPTIMIZATION_EDEFAULT == null ? getRepositoryRoundtripOptimization() != null : !REPOSITORY_ROUNDTRIP_OPTIMIZATION_EDEFAULT.equals(getRepositoryRoundtripOptimization());
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_SNC:
				return REPOSITORY_SNC_EDEFAULT == null ? getRepositorySnc() != null : !REPOSITORY_SNC_EDEFAULT.equals(getRepositorySnc());
			case SpiPackage.CONNECTION_REQUEST_INFO__REPOSITORY_USER:
				return REPOSITORY_USER_EDEFAULT == null ? getRepositoryUser() != null : !REPOSITORY_USER_EDEFAULT.equals(getRepositoryUser());
			case SpiPackage.CONNECTION_REQUEST_INFO__SAPROUTER:
				return SAPROUTER_EDEFAULT == null ? getSaprouter() != null : !SAPROUTER_EDEFAULT.equals(getSaprouter());
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_LIBRARY:
				return SNC_LIBRARY_EDEFAULT == null ? getSncLibrary() != null : !SNC_LIBRARY_EDEFAULT.equals(getSncLibrary());
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_MODE:
				return SNC_MODE_EDEFAULT == null ? getSncMode() != null : !SNC_MODE_EDEFAULT.equals(getSncMode());
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_MYNAME:
				return SNC_MYNAME_EDEFAULT == null ? getSncMyname() != null : !SNC_MYNAME_EDEFAULT.equals(getSncMyname());
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_PARTNERNAME:
				return SNC_PARTNERNAME_EDEFAULT == null ? getSncPartnername() != null : !SNC_PARTNERNAME_EDEFAULT.equals(getSncPartnername());
			case SpiPackage.CONNECTION_REQUEST_INFO__SNC_QOP:
				return SNC_QOP_EDEFAULT == null ? getSncQop() != null : !SNC_QOP_EDEFAULT.equals(getSncQop());
			case SpiPackage.CONNECTION_REQUEST_INFO__SYSNR:
				return SYSNR_EDEFAULT == null ? getSysnr() != null : !SYSNR_EDEFAULT.equals(getSysnr());
			case SpiPackage.CONNECTION_REQUEST_INFO__TPHOST:
				return TPHOST_EDEFAULT == null ? getTphost() != null : !TPHOST_EDEFAULT.equals(getTphost());
			case SpiPackage.CONNECTION_REQUEST_INFO__TPNAME:
				return TPNAME_EDEFAULT == null ? getTpname() != null : !TPNAME_EDEFAULT.equals(getTpname());
			case SpiPackage.CONNECTION_REQUEST_INFO__TRACE:
				return TRACE_EDEFAULT == null ? getTrace() != null : !TRACE_EDEFAULT.equals(getTrace());
			case SpiPackage.CONNECTION_REQUEST_INFO__TYPE:
				return TYPE_EDEFAULT == null ? getType() != null : !TYPE_EDEFAULT.equals(getType());
			case SpiPackage.CONNECTION_REQUEST_INFO__USER_NAME:
				return USER_NAME_EDEFAULT == null ? getUserName() != null : !USER_NAME_EDEFAULT.equals(getUserName());
			case SpiPackage.CONNECTION_REQUEST_INFO__USER:
				return USER_EDEFAULT == null ? getUser() != null : !USER_EDEFAULT.equals(getUser());
			case SpiPackage.CONNECTION_REQUEST_INFO__USER_ID:
				return USER_ID_EDEFAULT == null ? getUserId() != null : !USER_ID_EDEFAULT.equals(getUserId());
			case SpiPackage.CONNECTION_REQUEST_INFO__USE_SAPGUI:
				return USE_SAPGUI_EDEFAULT == null ? getUseSapgui() != null : !USE_SAPGUI_EDEFAULT.equals(getUseSapgui());
			case SpiPackage.CONNECTION_REQUEST_INFO__X509CERT:
				return X509CERT_EDEFAULT == null ? getX509cert() != null : !X509CERT_EDEFAULT.equals(getX509cert());
		}
		return super.eIsSet(featureID);
	}

} //ConnectionRequestInfoImpl
