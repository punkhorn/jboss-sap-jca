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
package org.jboss.jca.adapters.sap.cci.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.jboss.jca.adapters.sap.cci.ConnectionSpec;
import org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo;

/**
 * <!-- begin-user-doc -->
 * Implements the {@link ConnectionSpec } interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getUserName <em>User Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getUserId <em>User Id</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getClient <em>Client</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getAliasUser <em>Alias User</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getPasswd <em>Passwd</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getLang <em>Lang</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getMysapsso2 <em>Mysapsso2</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getX509cert <em>X50 9cert</em>}</li>
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
	 * The default value of the '{@link #getUserId() <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserId()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserId() <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserId()
	 * @generated
	 * @ordered
	 */
	protected String userId = USER_ID_EDEFAULT;

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


	protected ConnectionRequestInfo connectionRequestInfo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ConnectionSpecImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CciPackageImpl.Literals.CONNECTION_SPEC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserName(String newUserName) {
		String oldUserName = userName;
		userName = newUserName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackageImpl.CONNECTION_SPEC__USER_NAME, oldUserName, userName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackageImpl.CONNECTION_SPEC__PASSWORD, oldPassword, password));
	}

/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserId(String newUserId) {
		String oldUserId = userId;
		userId = newUserId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackageImpl.CONNECTION_SPEC__USER_ID, oldUserId, userId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClient() {
		return client;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClient(String newClient) {
		String oldClient = client;
		client = newClient;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackageImpl.CONNECTION_SPEC__CLIENT, oldClient, client));
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUser() {
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(String newUser) {
		String oldUser = user;
		user = newUser;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackageImpl.CONNECTION_SPEC__USER, oldUser, user));
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAliasUser() {
		return aliasUser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAliasUser(String newAliasUser) {
		String oldAliasUser = aliasUser;
		aliasUser = newAliasUser;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackageImpl.CONNECTION_SPEC__ALIAS_USER, oldAliasUser, aliasUser));
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPasswd(String newPasswd) {
		String oldPasswd = passwd;
		passwd = newPasswd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackageImpl.CONNECTION_SPEC__PASSWD, oldPasswd, passwd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLang(String newLang) {
		String oldLang = lang;
		lang = newLang;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackageImpl.CONNECTION_SPEC__LANG, oldLang, lang));
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMysapsso2() {
		return mysapsso2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMysapsso2(String newMysapsso2) {
		String oldMysapsso2 = mysapsso2;
		mysapsso2 = newMysapsso2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackageImpl.CONNECTION_SPEC__MYSAPSSO2, oldMysapsso2, mysapsso2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getX509cert() {
		return x509cert;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX509cert(String newX509cert) {
		String oldX509cert = x509cert;
		x509cert = newX509cert;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackageImpl.CONNECTION_SPEC__X509CERT, oldX509cert, x509cert));
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CciPackageImpl.CONNECTION_SPEC__USER_NAME:
				return getUserName();
			case CciPackageImpl.CONNECTION_SPEC__PASSWORD:
				return getPassword();
			case CciPackageImpl.CONNECTION_SPEC__USER_ID:
				return getUserId();
			case CciPackageImpl.CONNECTION_SPEC__CLIENT:
				return getClient();
			case CciPackageImpl.CONNECTION_SPEC__USER:
				return getUser();
			case CciPackageImpl.CONNECTION_SPEC__ALIAS_USER:
				return getAliasUser();
			case CciPackageImpl.CONNECTION_SPEC__PASSWD:
				return getPasswd();
			case CciPackageImpl.CONNECTION_SPEC__LANG:
				return getLang();
			case CciPackageImpl.CONNECTION_SPEC__MYSAPSSO2:
				return getMysapsso2();
			case CciPackageImpl.CONNECTION_SPEC__X509CERT:
				return getX509cert();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CciPackageImpl.CONNECTION_SPEC__USER_NAME:
				setUserName((String)newValue);
				return;
			case CciPackageImpl.CONNECTION_SPEC__PASSWORD:
				setPassword((String)newValue);
				return;
			case CciPackageImpl.CONNECTION_SPEC__USER_ID:
				setUserId((String)newValue);
				return;
			case CciPackageImpl.CONNECTION_SPEC__CLIENT:
				setClient((String)newValue);
				return;
			case CciPackageImpl.CONNECTION_SPEC__USER:
				setUser((String)newValue);
				return;
			case CciPackageImpl.CONNECTION_SPEC__ALIAS_USER:
				setAliasUser((String)newValue);
				return;
			case CciPackageImpl.CONNECTION_SPEC__PASSWD:
				setPasswd((String)newValue);
				return;
			case CciPackageImpl.CONNECTION_SPEC__LANG:
				setLang((String)newValue);
				return;
			case CciPackageImpl.CONNECTION_SPEC__MYSAPSSO2:
				setMysapsso2((String)newValue);
				return;
			case CciPackageImpl.CONNECTION_SPEC__X509CERT:
				setX509cert((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CciPackageImpl.CONNECTION_SPEC__USER_NAME:
				setUserName(USER_NAME_EDEFAULT);
				return;
			case CciPackageImpl.CONNECTION_SPEC__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case CciPackageImpl.CONNECTION_SPEC__USER_ID:
				setUserId(USER_ID_EDEFAULT);
				return;
			case CciPackageImpl.CONNECTION_SPEC__CLIENT:
				setClient(CLIENT_EDEFAULT);
				return;
			case CciPackageImpl.CONNECTION_SPEC__USER:
				setUser(USER_EDEFAULT);
				return;
			case CciPackageImpl.CONNECTION_SPEC__ALIAS_USER:
				setAliasUser(ALIAS_USER_EDEFAULT);
				return;
			case CciPackageImpl.CONNECTION_SPEC__PASSWD:
				setPasswd(PASSWD_EDEFAULT);
				return;
			case CciPackageImpl.CONNECTION_SPEC__LANG:
				setLang(LANG_EDEFAULT);
				return;
			case CciPackageImpl.CONNECTION_SPEC__MYSAPSSO2:
				setMysapsso2(MYSAPSSO2_EDEFAULT);
				return;
			case CciPackageImpl.CONNECTION_SPEC__X509CERT:
				setX509cert(X509CERT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CciPackageImpl.CONNECTION_SPEC__USER_NAME:
				return USER_NAME_EDEFAULT == null ? userName != null : !USER_NAME_EDEFAULT.equals(userName);
			case CciPackageImpl.CONNECTION_SPEC__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case CciPackageImpl.CONNECTION_SPEC__USER_ID:
				return USER_ID_EDEFAULT == null ? userId != null : !USER_ID_EDEFAULT.equals(userId);
			case CciPackageImpl.CONNECTION_SPEC__CLIENT:
				return CLIENT_EDEFAULT == null ? client != null : !CLIENT_EDEFAULT.equals(client);
			case CciPackageImpl.CONNECTION_SPEC__USER:
				return USER_EDEFAULT == null ? user != null : !USER_EDEFAULT.equals(user);
			case CciPackageImpl.CONNECTION_SPEC__ALIAS_USER:
				return ALIAS_USER_EDEFAULT == null ? aliasUser != null : !ALIAS_USER_EDEFAULT.equals(aliasUser);
			case CciPackageImpl.CONNECTION_SPEC__PASSWD:
				return PASSWD_EDEFAULT == null ? passwd != null : !PASSWD_EDEFAULT.equals(passwd);
			case CciPackageImpl.CONNECTION_SPEC__LANG:
				return LANG_EDEFAULT == null ? lang != null : !LANG_EDEFAULT.equals(lang);
			case CciPackageImpl.CONNECTION_SPEC__MYSAPSSO2:
				return MYSAPSSO2_EDEFAULT == null ? mysapsso2 != null : !MYSAPSSO2_EDEFAULT.equals(mysapsso2);
			case CciPackageImpl.CONNECTION_SPEC__X509CERT:
				return X509CERT_EDEFAULT == null ? x509cert != null : !X509CERT_EDEFAULT.equals(x509cert);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
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
		result.append(", userId: ");
		result.append(userId);
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
		result.append(", x509cert: ");
		result.append(x509cert);
		result.append(')');
		return result.toString();
	}

} //ConnectionSpecImpl
