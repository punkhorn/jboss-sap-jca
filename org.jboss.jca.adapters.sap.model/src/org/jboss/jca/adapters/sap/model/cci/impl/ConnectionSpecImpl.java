/**
 */
package org.jboss.jca.adapters.sap.model.cci.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.cci.ConnectionSpec;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Spec</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl#getUserName <em>User Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl#getClient <em>Client</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl#getAliasUser <em>Alias User</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl#getPasswd <em>Passwd</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl#getLang <em>Lang</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl#getMysapsso2 <em>Mysapsso2</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl#getGetsso2 <em>Getsso2</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl#getX509cert <em>X50 9cert</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl#getLcheck <em>Lcheck</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl#getCodepage <em>Codepage</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl#getTrace <em>Trace</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl#getUseSapgui <em>Use Sapgui</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl#getSncLibrary <em>Snc Library</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl#getSncMode <em>Snc Mode</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl#getSncMyname <em>Snc Myname</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl#getSncPartnername <em>Snc Partnername</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl#getSncQop <em>Snc Qop</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionSpecImpl extends EObjectImpl implements ConnectionSpec {
	/**
	 * The default value of the '{@link #getUserName() <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserName()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserName() <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserName()
	 * @generated
	 * @ordered
	 */
	protected String userName = USER_NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getClient() <em>Client</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClient()
	 * @generated
	 * @ordered
	 */
	protected static final String CLIENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClient() <em>Client</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClient()
	 * @generated
	 * @ordered
	 */
	protected String client = CLIENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getUser() <em>User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUser()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUser() <em>User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUser()
	 * @generated
	 * @ordered
	 */
	protected String user = USER_EDEFAULT;

	/**
	 * The default value of the '{@link #getAliasUser() <em>Alias User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAliasUser()
	 * @generated
	 * @ordered
	 */
	protected static final String ALIAS_USER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAliasUser() <em>Alias User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAliasUser()
	 * @generated
	 * @ordered
	 */
	protected String aliasUser = ALIAS_USER_EDEFAULT;

	/**
	 * The default value of the '{@link #getPasswd() <em>Passwd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPasswd()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPasswd() <em>Passwd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPasswd()
	 * @generated
	 * @ordered
	 */
	protected String passwd = PASSWD_EDEFAULT;

	/**
	 * The default value of the '{@link #getLang() <em>Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLang()
	 * @generated
	 * @ordered
	 */
	protected static final String LANG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLang() <em>Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLang()
	 * @generated
	 * @ordered
	 */
	protected String lang = LANG_EDEFAULT;

	/**
	 * The default value of the '{@link #getMysapsso2() <em>Mysapsso2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMysapsso2()
	 * @generated
	 * @ordered
	 */
	protected static final String MYSAPSSO2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMysapsso2() <em>Mysapsso2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMysapsso2()
	 * @generated
	 * @ordered
	 */
	protected String mysapsso2 = MYSAPSSO2_EDEFAULT;

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
	 * The cached value of the '{@link #getGetsso2() <em>Getsso2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGetsso2()
	 * @generated
	 * @ordered
	 */
	protected String getsso2 = GETSSO2_EDEFAULT;

	/**
	 * The default value of the '{@link #getX509cert() <em>X50 9cert</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX509cert()
	 * @generated
	 * @ordered
	 */
	protected static final String X509CERT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getX509cert() <em>X50 9cert</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX509cert()
	 * @generated
	 * @ordered
	 */
	protected String x509cert = X509CERT_EDEFAULT;

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
	 * The cached value of the '{@link #getLcheck() <em>Lcheck</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLcheck()
	 * @generated
	 * @ordered
	 */
	protected String lcheck = LCHECK_EDEFAULT;

	/**
	 * The default value of the '{@link #getCodepage() <em>Codepage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodepage()
	 * @generated
	 * @ordered
	 */
	protected static final String CODEPAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCodepage() <em>Codepage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodepage()
	 * @generated
	 * @ordered
	 */
	protected String codepage = CODEPAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTrace() <em>Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrace()
	 * @generated
	 * @ordered
	 */
	protected static final String TRACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTrace() <em>Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrace()
	 * @generated
	 * @ordered
	 */
	protected String trace = TRACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUseSapgui() <em>Use Sapgui</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseSapgui()
	 * @generated
	 * @ordered
	 */
	protected static final String USE_SAPGUI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUseSapgui() <em>Use Sapgui</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseSapgui()
	 * @generated
	 * @ordered
	 */
	protected String useSapgui = USE_SAPGUI_EDEFAULT;

	/**
	 * The default value of the '{@link #getSncLibrary() <em>Snc Library</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSncLibrary()
	 * @generated
	 * @ordered
	 */
	protected static final String SNC_LIBRARY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSncLibrary() <em>Snc Library</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSncLibrary()
	 * @generated
	 * @ordered
	 */
	protected String sncLibrary = SNC_LIBRARY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSncMode() <em>Snc Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSncMode()
	 * @generated
	 * @ordered
	 */
	protected static final String SNC_MODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSncMode() <em>Snc Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSncMode()
	 * @generated
	 * @ordered
	 */
	protected String sncMode = SNC_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSncMyname() <em>Snc Myname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSncMyname()
	 * @generated
	 * @ordered
	 */
	protected static final String SNC_MYNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSncMyname() <em>Snc Myname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSncMyname()
	 * @generated
	 * @ordered
	 */
	protected String sncMyname = SNC_MYNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSncPartnername() <em>Snc Partnername</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSncPartnername()
	 * @generated
	 * @ordered
	 */
	protected static final String SNC_PARTNERNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSncPartnername() <em>Snc Partnername</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSncPartnername()
	 * @generated
	 * @ordered
	 */
	protected String sncPartnername = SNC_PARTNERNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSncQop() <em>Snc Qop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSncQop()
	 * @generated
	 * @ordered
	 */
	protected static final String SNC_QOP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSncQop() <em>Snc Qop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSncQop()
	 * @generated
	 * @ordered
	 */
	protected String sncQop = SNC_QOP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionSpecImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CciPackage.Literals.CONNECTION_SPEC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserName(String newUserName) {
		String oldUserName = userName;
		userName = newUserName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__USER_NAME, oldUserName, userName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClient() {
		return client;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClient(String newClient) {
		String oldClient = client;
		client = newClient;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__CLIENT, oldClient, client));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUser() {
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(String newUser) {
		String oldUser = user;
		user = newUser;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__USER, oldUser, user));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAliasUser() {
		return aliasUser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAliasUser(String newAliasUser) {
		String oldAliasUser = aliasUser;
		aliasUser = newAliasUser;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__ALIAS_USER, oldAliasUser, aliasUser));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPasswd(String newPasswd) {
		String oldPasswd = passwd;
		passwd = newPasswd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__PASSWD, oldPasswd, passwd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLang(String newLang) {
		String oldLang = lang;
		lang = newLang;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__LANG, oldLang, lang));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMysapsso2() {
		return mysapsso2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMysapsso2(String newMysapsso2) {
		String oldMysapsso2 = mysapsso2;
		mysapsso2 = newMysapsso2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__MYSAPSSO2, oldMysapsso2, mysapsso2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGetsso2() {
		return getsso2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGetsso2(String newGetsso2) {
		String oldGetsso2 = getsso2;
		getsso2 = newGetsso2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__GETSSO2, oldGetsso2, getsso2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getX509cert() {
		return x509cert;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX509cert(String newX509cert) {
		String oldX509cert = x509cert;
		x509cert = newX509cert;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__X509CERT, oldX509cert, x509cert));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLcheck() {
		return lcheck;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLcheck(String newLcheck) {
		String oldLcheck = lcheck;
		lcheck = newLcheck;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__LCHECK, oldLcheck, lcheck));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCodepage() {
		return codepage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCodepage(String newCodepage) {
		String oldCodepage = codepage;
		codepage = newCodepage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__CODEPAGE, oldCodepage, codepage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTrace() {
		return trace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrace(String newTrace) {
		String oldTrace = trace;
		trace = newTrace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__TRACE, oldTrace, trace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUseSapgui() {
		return useSapgui;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseSapgui(String newUseSapgui) {
		String oldUseSapgui = useSapgui;
		useSapgui = newUseSapgui;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__USE_SAPGUI, oldUseSapgui, useSapgui));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSncLibrary() {
		return sncLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSncLibrary(String newSncLibrary) {
		String oldSncLibrary = sncLibrary;
		sncLibrary = newSncLibrary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__SNC_LIBRARY, oldSncLibrary, sncLibrary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSncMode() {
		return sncMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSncMode(String newSncMode) {
		String oldSncMode = sncMode;
		sncMode = newSncMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__SNC_MODE, oldSncMode, sncMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSncMyname() {
		return sncMyname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSncMyname(String newSncMyname) {
		String oldSncMyname = sncMyname;
		sncMyname = newSncMyname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__SNC_MYNAME, oldSncMyname, sncMyname));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSncPartnername() {
		return sncPartnername;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSncPartnername(String newSncPartnername) {
		String oldSncPartnername = sncPartnername;
		sncPartnername = newSncPartnername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__SNC_PARTNERNAME, oldSncPartnername, sncPartnername));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSncQop() {
		return sncQop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSncQop(String newSncQop) {
		String oldSncQop = sncQop;
		sncQop = newSncQop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__SNC_QOP, oldSncQop, sncQop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CciPackage.CONNECTION_SPEC__USER_NAME:
				return getUserName();
			case CciPackage.CONNECTION_SPEC__PASSWORD:
				return getPassword();
			case CciPackage.CONNECTION_SPEC__CLIENT:
				return getClient();
			case CciPackage.CONNECTION_SPEC__USER:
				return getUser();
			case CciPackage.CONNECTION_SPEC__ALIAS_USER:
				return getAliasUser();
			case CciPackage.CONNECTION_SPEC__PASSWD:
				return getPasswd();
			case CciPackage.CONNECTION_SPEC__LANG:
				return getLang();
			case CciPackage.CONNECTION_SPEC__MYSAPSSO2:
				return getMysapsso2();
			case CciPackage.CONNECTION_SPEC__GETSSO2:
				return getGetsso2();
			case CciPackage.CONNECTION_SPEC__X509CERT:
				return getX509cert();
			case CciPackage.CONNECTION_SPEC__LCHECK:
				return getLcheck();
			case CciPackage.CONNECTION_SPEC__CODEPAGE:
				return getCodepage();
			case CciPackage.CONNECTION_SPEC__TRACE:
				return getTrace();
			case CciPackage.CONNECTION_SPEC__USE_SAPGUI:
				return getUseSapgui();
			case CciPackage.CONNECTION_SPEC__SNC_LIBRARY:
				return getSncLibrary();
			case CciPackage.CONNECTION_SPEC__SNC_MODE:
				return getSncMode();
			case CciPackage.CONNECTION_SPEC__SNC_MYNAME:
				return getSncMyname();
			case CciPackage.CONNECTION_SPEC__SNC_PARTNERNAME:
				return getSncPartnername();
			case CciPackage.CONNECTION_SPEC__SNC_QOP:
				return getSncQop();
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
			case CciPackage.CONNECTION_SPEC__USER_NAME:
				setUserName((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__PASSWORD:
				setPassword((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__CLIENT:
				setClient((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__USER:
				setUser((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__ALIAS_USER:
				setAliasUser((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__PASSWD:
				setPasswd((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__LANG:
				setLang((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__MYSAPSSO2:
				setMysapsso2((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__GETSSO2:
				setGetsso2((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__X509CERT:
				setX509cert((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__LCHECK:
				setLcheck((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__CODEPAGE:
				setCodepage((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__TRACE:
				setTrace((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__USE_SAPGUI:
				setUseSapgui((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__SNC_LIBRARY:
				setSncLibrary((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__SNC_MODE:
				setSncMode((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__SNC_MYNAME:
				setSncMyname((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__SNC_PARTNERNAME:
				setSncPartnername((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__SNC_QOP:
				setSncQop((String)newValue);
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
			case CciPackage.CONNECTION_SPEC__USER_NAME:
				setUserName(USER_NAME_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__CLIENT:
				setClient(CLIENT_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__USER:
				setUser(USER_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__ALIAS_USER:
				setAliasUser(ALIAS_USER_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__PASSWD:
				setPasswd(PASSWD_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__LANG:
				setLang(LANG_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__MYSAPSSO2:
				setMysapsso2(MYSAPSSO2_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__GETSSO2:
				setGetsso2(GETSSO2_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__X509CERT:
				setX509cert(X509CERT_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__LCHECK:
				setLcheck(LCHECK_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__CODEPAGE:
				setCodepage(CODEPAGE_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__TRACE:
				setTrace(TRACE_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__USE_SAPGUI:
				setUseSapgui(USE_SAPGUI_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__SNC_LIBRARY:
				setSncLibrary(SNC_LIBRARY_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__SNC_MODE:
				setSncMode(SNC_MODE_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__SNC_MYNAME:
				setSncMyname(SNC_MYNAME_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__SNC_PARTNERNAME:
				setSncPartnername(SNC_PARTNERNAME_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__SNC_QOP:
				setSncQop(SNC_QOP_EDEFAULT);
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
			case CciPackage.CONNECTION_SPEC__USER_NAME:
				return USER_NAME_EDEFAULT == null ? userName != null : !USER_NAME_EDEFAULT.equals(userName);
			case CciPackage.CONNECTION_SPEC__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case CciPackage.CONNECTION_SPEC__CLIENT:
				return CLIENT_EDEFAULT == null ? client != null : !CLIENT_EDEFAULT.equals(client);
			case CciPackage.CONNECTION_SPEC__USER:
				return USER_EDEFAULT == null ? user != null : !USER_EDEFAULT.equals(user);
			case CciPackage.CONNECTION_SPEC__ALIAS_USER:
				return ALIAS_USER_EDEFAULT == null ? aliasUser != null : !ALIAS_USER_EDEFAULT.equals(aliasUser);
			case CciPackage.CONNECTION_SPEC__PASSWD:
				return PASSWD_EDEFAULT == null ? passwd != null : !PASSWD_EDEFAULT.equals(passwd);
			case CciPackage.CONNECTION_SPEC__LANG:
				return LANG_EDEFAULT == null ? lang != null : !LANG_EDEFAULT.equals(lang);
			case CciPackage.CONNECTION_SPEC__MYSAPSSO2:
				return MYSAPSSO2_EDEFAULT == null ? mysapsso2 != null : !MYSAPSSO2_EDEFAULT.equals(mysapsso2);
			case CciPackage.CONNECTION_SPEC__GETSSO2:
				return GETSSO2_EDEFAULT == null ? getsso2 != null : !GETSSO2_EDEFAULT.equals(getsso2);
			case CciPackage.CONNECTION_SPEC__X509CERT:
				return X509CERT_EDEFAULT == null ? x509cert != null : !X509CERT_EDEFAULT.equals(x509cert);
			case CciPackage.CONNECTION_SPEC__LCHECK:
				return LCHECK_EDEFAULT == null ? lcheck != null : !LCHECK_EDEFAULT.equals(lcheck);
			case CciPackage.CONNECTION_SPEC__CODEPAGE:
				return CODEPAGE_EDEFAULT == null ? codepage != null : !CODEPAGE_EDEFAULT.equals(codepage);
			case CciPackage.CONNECTION_SPEC__TRACE:
				return TRACE_EDEFAULT == null ? trace != null : !TRACE_EDEFAULT.equals(trace);
			case CciPackage.CONNECTION_SPEC__USE_SAPGUI:
				return USE_SAPGUI_EDEFAULT == null ? useSapgui != null : !USE_SAPGUI_EDEFAULT.equals(useSapgui);
			case CciPackage.CONNECTION_SPEC__SNC_LIBRARY:
				return SNC_LIBRARY_EDEFAULT == null ? sncLibrary != null : !SNC_LIBRARY_EDEFAULT.equals(sncLibrary);
			case CciPackage.CONNECTION_SPEC__SNC_MODE:
				return SNC_MODE_EDEFAULT == null ? sncMode != null : !SNC_MODE_EDEFAULT.equals(sncMode);
			case CciPackage.CONNECTION_SPEC__SNC_MYNAME:
				return SNC_MYNAME_EDEFAULT == null ? sncMyname != null : !SNC_MYNAME_EDEFAULT.equals(sncMyname);
			case CciPackage.CONNECTION_SPEC__SNC_PARTNERNAME:
				return SNC_PARTNERNAME_EDEFAULT == null ? sncPartnername != null : !SNC_PARTNERNAME_EDEFAULT.equals(sncPartnername);
			case CciPackage.CONNECTION_SPEC__SNC_QOP:
				return SNC_QOP_EDEFAULT == null ? sncQop != null : !SNC_QOP_EDEFAULT.equals(sncQop);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (userName: ");
		result.append(userName);
		result.append(", password: ");
		result.append(password);
		result.append(", client: ");
		result.append(client);
		result.append(", user: ");
		result.append(user);
		result.append(", aliasUser: ");
		result.append(aliasUser);
		result.append(", passwd: ");
		result.append(passwd);
		result.append(", lang: ");
		result.append(lang);
		result.append(", mysapsso2: ");
		result.append(mysapsso2);
		result.append(", getsso2: ");
		result.append(getsso2);
		result.append(", x509cert: ");
		result.append(x509cert);
		result.append(", lcheck: ");
		result.append(lcheck);
		result.append(", codepage: ");
		result.append(codepage);
		result.append(", trace: ");
		result.append(trace);
		result.append(", useSapgui: ");
		result.append(useSapgui);
		result.append(", sncLibrary: ");
		result.append(sncLibrary);
		result.append(", sncMode: ");
		result.append(sncMode);
		result.append(", sncMyname: ");
		result.append(sncMyname);
		result.append(", sncPartnername: ");
		result.append(sncPartnername);
		result.append(", sncQop: ");
		result.append(sncQop);
		result.append(')');
		return result.toString();
	}

} //ConnectionSpecImpl
