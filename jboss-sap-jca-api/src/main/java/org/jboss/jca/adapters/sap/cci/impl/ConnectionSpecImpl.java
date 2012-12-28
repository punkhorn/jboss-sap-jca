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
import org.jboss.jca.adapters.sap.cci.CciPackage;
import org.jboss.jca.adapters.sap.cci.ConnectionSpec;
import org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Spec</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getUserName <em>User Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getAuthType <em>Auth Type</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getUserId <em>User Id</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getClient <em>Client</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getAliasUser <em>Alias User</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getPasswd <em>Passwd</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getLang <em>Lang</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getMysapsso2 <em>Mysapsso2</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getX509cert <em>X50 9cert</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getPcs <em>Pcs</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getSaprouter <em>Saprouter</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getSysnr <em>Sysnr</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getAshost <em>Ashost</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getMshost <em>Mshost</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getMsserv <em>Msserv</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getGwhost <em>Gwhost</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getGwserv <em>Gwserv</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getTphost <em>Tphost</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getTpname <em>Tpname</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getR3name <em>R3name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getTrace <em>Trace</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getCpicTrace <em>Cpic Trace</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getLcheck <em>Lcheck</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getUseSapgui <em>Use Sapgui</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getCodepage <em>Codepage</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getGetsso2 <em>Getsso2</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getDenyInitialPassword <em>Deny Initial Password</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getPeakLimit <em>Peak Limit</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getPoolCapacity <em>Pool Capacity</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getExpirationTime <em>Expiration Time</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getExpirationPeriod <em>Expiration Period</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getMaxGetTime <em>Max Get Time</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getSncMode <em>Snc Mode</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getSncPartnername <em>Snc Partnername</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getSncQop <em>Snc Qop</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getSncMyname <em>Snc Myname</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getSncLibrary <em>Snc Library</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getRepositoryDest <em>Repository Dest</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getRepositoryUser <em>Repository User</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getRepositoryPasswd <em>Repository Passwd</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getRepositorySnc <em>Repository Snc</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getRepositoryRoundtripOptimization <em>Repository Roundtrip Optimization</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl#getPingOnCreate <em>Ping On Create</em>}</li>
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
	 * The default value of the '{@link #getAuthType() <em>Auth Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthType()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTH_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthType() <em>Auth Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthType()
	 * @generated
	 * @ordered
	 */
	protected String authType = AUTH_TYPE_EDEFAULT;

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

	/**
	 * The default value of the '{@link #getPcs() <em>Pcs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPcs()
	 * @generated
	 * @ordered
	 */
	protected static final String PCS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPcs() <em>Pcs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPcs()
	 * @generated
	 * @ordered
	 */
	protected String pcs = PCS_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSaprouter() <em>Saprouter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSaprouter()
	 * @generated
	 * @ordered
	 */
	protected static final String SAPROUTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSaprouter() <em>Saprouter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSaprouter()
	 * @generated
	 * @ordered
	 */
	protected String saprouter = SAPROUTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getSysnr() <em>Sysnr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSysnr()
	 * @generated
	 * @ordered
	 */
	protected static final String SYSNR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSysnr() <em>Sysnr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSysnr()
	 * @generated
	 * @ordered
	 */
	protected String sysnr = SYSNR_EDEFAULT;

	/**
	 * The default value of the '{@link #getAshost() <em>Ashost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAshost()
	 * @generated
	 * @ordered
	 */
	protected static final String ASHOST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAshost() <em>Ashost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAshost()
	 * @generated
	 * @ordered
	 */
	protected String ashost = ASHOST_EDEFAULT;

	/**
	 * The default value of the '{@link #getMshost() <em>Mshost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMshost()
	 * @generated
	 * @ordered
	 */
	protected static final String MSHOST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMshost() <em>Mshost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMshost()
	 * @generated
	 * @ordered
	 */
	protected String mshost = MSHOST_EDEFAULT;

	/**
	 * The default value of the '{@link #getMsserv() <em>Msserv</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMsserv()
	 * @generated
	 * @ordered
	 */
	protected static final String MSSERV_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMsserv() <em>Msserv</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMsserv()
	 * @generated
	 * @ordered
	 */
	protected String msserv = MSSERV_EDEFAULT;

	/**
	 * The default value of the '{@link #getGwhost() <em>Gwhost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGwhost()
	 * @generated
	 * @ordered
	 */
	protected static final String GWHOST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGwhost() <em>Gwhost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGwhost()
	 * @generated
	 * @ordered
	 */
	protected String gwhost = GWHOST_EDEFAULT;

	/**
	 * The default value of the '{@link #getGwserv() <em>Gwserv</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGwserv()
	 * @generated
	 * @ordered
	 */
	protected static final String GWSERV_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGwserv() <em>Gwserv</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGwserv()
	 * @generated
	 * @ordered
	 */
	protected String gwserv = GWSERV_EDEFAULT;

	/**
	 * The default value of the '{@link #getTphost() <em>Tphost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTphost()
	 * @generated
	 * @ordered
	 */
	protected static final String TPHOST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTphost() <em>Tphost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTphost()
	 * @generated
	 * @ordered
	 */
	protected String tphost = TPHOST_EDEFAULT;

	/**
	 * The default value of the '{@link #getTpname() <em>Tpname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTpname()
	 * @generated
	 * @ordered
	 */
	protected static final String TPNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTpname() <em>Tpname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTpname()
	 * @generated
	 * @ordered
	 */
	protected String tpname = TPNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getR3name() <em>R3name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR3name()
	 * @generated
	 * @ordered
	 */
	protected static final String R3NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getR3name() <em>R3name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR3name()
	 * @generated
	 * @ordered
	 */
	protected String r3name = R3NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getGroup() <em>Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected static final String GROUP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected String group = GROUP_EDEFAULT;

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
	 * The default value of the '{@link #getCpicTrace() <em>Cpic Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpicTrace()
	 * @generated
	 * @ordered
	 */
	protected static final String CPIC_TRACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCpicTrace() <em>Cpic Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpicTrace()
	 * @generated
	 * @ordered
	 */
	protected String cpicTrace = CPIC_TRACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLcheck() <em>Lcheck</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLcheck()
	 * @generated
	 * @ordered
	 */
	protected static final String LCHECK_EDEFAULT = null;

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
	 * The default value of the '{@link #getGetsso2() <em>Getsso2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGetsso2()
	 * @generated
	 * @ordered
	 */
	protected static final String GETSSO2_EDEFAULT = null;

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
	 * The default value of the '{@link #getDenyInitialPassword() <em>Deny Initial Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDenyInitialPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String DENY_INITIAL_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDenyInitialPassword() <em>Deny Initial Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDenyInitialPassword()
	 * @generated
	 * @ordered
	 */
	protected String denyInitialPassword = DENY_INITIAL_PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getPeakLimit() <em>Peak Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeakLimit()
	 * @generated
	 * @ordered
	 */
	protected static final String PEAK_LIMIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPeakLimit() <em>Peak Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeakLimit()
	 * @generated
	 * @ordered
	 */
	protected String peakLimit = PEAK_LIMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPoolCapacity() <em>Pool Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPoolCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final String POOL_CAPACITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPoolCapacity() <em>Pool Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPoolCapacity()
	 * @generated
	 * @ordered
	 */
	protected String poolCapacity = POOL_CAPACITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getExpirationTime() <em>Expiration Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpirationTime()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPIRATION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpirationTime() <em>Expiration Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpirationTime()
	 * @generated
	 * @ordered
	 */
	protected String expirationTime = EXPIRATION_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getExpirationPeriod() <em>Expiration Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpirationPeriod()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPIRATION_PERIOD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpirationPeriod() <em>Expiration Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpirationPeriod()
	 * @generated
	 * @ordered
	 */
	protected String expirationPeriod = EXPIRATION_PERIOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxGetTime() <em>Max Get Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxGetTime()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_GET_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxGetTime() <em>Max Get Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxGetTime()
	 * @generated
	 * @ordered
	 */
	protected String maxGetTime = MAX_GET_TIME_EDEFAULT;

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
	 * The default value of the '{@link #getRepositoryDest() <em>Repository Dest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryDest()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_DEST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepositoryDest() <em>Repository Dest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryDest()
	 * @generated
	 * @ordered
	 */
	protected String repositoryDest = REPOSITORY_DEST_EDEFAULT;

	/**
	 * The default value of the '{@link #getRepositoryUser() <em>Repository User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryUser()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_USER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepositoryUser() <em>Repository User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryUser()
	 * @generated
	 * @ordered
	 */
	protected String repositoryUser = REPOSITORY_USER_EDEFAULT;

	/**
	 * The default value of the '{@link #getRepositoryPasswd() <em>Repository Passwd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryPasswd()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_PASSWD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepositoryPasswd() <em>Repository Passwd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryPasswd()
	 * @generated
	 * @ordered
	 */
	protected String repositoryPasswd = REPOSITORY_PASSWD_EDEFAULT;

	/**
	 * The default value of the '{@link #getRepositorySnc() <em>Repository Snc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositorySnc()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_SNC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepositorySnc() <em>Repository Snc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositorySnc()
	 * @generated
	 * @ordered
	 */
	protected String repositorySnc = REPOSITORY_SNC_EDEFAULT;

	/**
	 * The default value of the '{@link #getRepositoryRoundtripOptimization() <em>Repository Roundtrip Optimization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryRoundtripOptimization()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_ROUNDTRIP_OPTIMIZATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepositoryRoundtripOptimization() <em>Repository Roundtrip Optimization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryRoundtripOptimization()
	 * @generated
	 * @ordered
	 */
	protected String repositoryRoundtripOptimization = REPOSITORY_ROUNDTRIP_OPTIMIZATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPingOnCreate() <em>Ping On Create</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPingOnCreate()
	 * @generated
	 * @ordered
	 */
	protected static final String PING_ON_CREATE_EDEFAULT = null;
	
	/**
	 * The cached value of the '{@link #getPingOnCreate() <em>Ping On Create</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPingOnCreate()
	 * @generated
	 * @ordered
	 */
	protected String pingOnCreate = PING_ON_CREATE_EDEFAULT;

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
	public String getAuthType() {
		return authType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthType(String newAuthType) {
		String oldAuthType = authType;
		authType = newAuthType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__AUTH_TYPE, oldAuthType, authType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserId(String newUserId) {
		String oldUserId = userId;
		userId = newUserId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__USER_ID, oldUserId, userId));
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
	public String getPcs() {
		return pcs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPcs(String newPcs) {
		String oldPcs = pcs;
		pcs = newPcs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__PCS, oldPcs, pcs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSaprouter() {
		return saprouter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSaprouter(String newSaprouter) {
		String oldSaprouter = saprouter;
		saprouter = newSaprouter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__SAPROUTER, oldSaprouter, saprouter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSysnr() {
		return sysnr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSysnr(String newSysnr) {
		String oldSysnr = sysnr;
		sysnr = newSysnr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__SYSNR, oldSysnr, sysnr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAshost() {
		return ashost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAshost(String newAshost) {
		String oldAshost = ashost;
		ashost = newAshost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__ASHOST, oldAshost, ashost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMshost() {
		return mshost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMshost(String newMshost) {
		String oldMshost = mshost;
		mshost = newMshost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__MSHOST, oldMshost, mshost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMsserv() {
		return msserv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMsserv(String newMsserv) {
		String oldMsserv = msserv;
		msserv = newMsserv;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__MSSERV, oldMsserv, msserv));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGwhost() {
		return gwhost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGwhost(String newGwhost) {
		String oldGwhost = gwhost;
		gwhost = newGwhost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__GWHOST, oldGwhost, gwhost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGwserv() {
		return gwserv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGwserv(String newGwserv) {
		String oldGwserv = gwserv;
		gwserv = newGwserv;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__GWSERV, oldGwserv, gwserv));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTphost() {
		return tphost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTphost(String newTphost) {
		String oldTphost = tphost;
		tphost = newTphost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__TPHOST, oldTphost, tphost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTpname() {
		return tpname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTpname(String newTpname) {
		String oldTpname = tpname;
		tpname = newTpname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__TPNAME, oldTpname, tpname));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getR3name() {
		return r3name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setR3name(String newR3name) {
		String oldR3name = r3name;
		r3name = newR3name;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__R3NAME, oldR3name, r3name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroup(String newGroup) {
		String oldGroup = group;
		group = newGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__GROUP, oldGroup, group));
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
	public String getCpicTrace() {
		return cpicTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpicTrace(String newCpicTrace) {
		String oldCpicTrace = cpicTrace;
		cpicTrace = newCpicTrace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__CPIC_TRACE, oldCpicTrace, cpicTrace));
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
	public String getDenyInitialPassword() {
		return denyInitialPassword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDenyInitialPassword(String newDenyInitialPassword) {
		String oldDenyInitialPassword = denyInitialPassword;
		denyInitialPassword = newDenyInitialPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__DENY_INITIAL_PASSWORD, oldDenyInitialPassword, denyInitialPassword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPeakLimit() {
		return peakLimit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeakLimit(String newPeakLimit) {
		String oldPeakLimit = peakLimit;
		peakLimit = newPeakLimit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__PEAK_LIMIT, oldPeakLimit, peakLimit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPoolCapacity() {
		return poolCapacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPoolCapacity(String newPoolCapacity) {
		String oldPoolCapacity = poolCapacity;
		poolCapacity = newPoolCapacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__POOL_CAPACITY, oldPoolCapacity, poolCapacity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpirationTime() {
		return expirationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpirationTime(String newExpirationTime) {
		String oldExpirationTime = expirationTime;
		expirationTime = newExpirationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__EXPIRATION_TIME, oldExpirationTime, expirationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpirationPeriod() {
		return expirationPeriod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpirationPeriod(String newExpirationPeriod) {
		String oldExpirationPeriod = expirationPeriod;
		expirationPeriod = newExpirationPeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__EXPIRATION_PERIOD, oldExpirationPeriod, expirationPeriod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxGetTime() {
		return maxGetTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxGetTime(String newMaxGetTime) {
		String oldMaxGetTime = maxGetTime;
		maxGetTime = newMaxGetTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__MAX_GET_TIME, oldMaxGetTime, maxGetTime));
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
	public String getRepositoryDest() {
		return repositoryDest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositoryDest(String newRepositoryDest) {
		String oldRepositoryDest = repositoryDest;
		repositoryDest = newRepositoryDest;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__REPOSITORY_DEST, oldRepositoryDest, repositoryDest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepositoryUser() {
		return repositoryUser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositoryUser(String newRepositoryUser) {
		String oldRepositoryUser = repositoryUser;
		repositoryUser = newRepositoryUser;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__REPOSITORY_USER, oldRepositoryUser, repositoryUser));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepositoryPasswd() {
		return repositoryPasswd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositoryPasswd(String newRepositoryPasswd) {
		String oldRepositoryPasswd = repositoryPasswd;
		repositoryPasswd = newRepositoryPasswd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__REPOSITORY_PASSWD, oldRepositoryPasswd, repositoryPasswd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepositorySnc() {
		return repositorySnc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositorySnc(String newRepositorySnc) {
		String oldRepositorySnc = repositorySnc;
		repositorySnc = newRepositorySnc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__REPOSITORY_SNC, oldRepositorySnc, repositorySnc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepositoryRoundtripOptimization() {
		return repositoryRoundtripOptimization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositoryRoundtripOptimization(String newRepositoryRoundtripOptimization) {
		String oldRepositoryRoundtripOptimization = repositoryRoundtripOptimization;
		repositoryRoundtripOptimization = newRepositoryRoundtripOptimization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__REPOSITORY_ROUNDTRIP_OPTIMIZATION, oldRepositoryRoundtripOptimization, repositoryRoundtripOptimization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPingOnCreate() {
		return pingOnCreate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPingOnCreate(String newPingOnCreate) {
		String oldPingOnCreate = pingOnCreate;
		pingOnCreate = newPingOnCreate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.CONNECTION_SPEC__PING_ON_CREATE, oldPingOnCreate, pingOnCreate));
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
			case CciPackage.CONNECTION_SPEC__AUTH_TYPE:
				return getAuthType();
			case CciPackage.CONNECTION_SPEC__USER_ID:
				return getUserId();
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
			case CciPackage.CONNECTION_SPEC__X509CERT:
				return getX509cert();
			case CciPackage.CONNECTION_SPEC__PCS:
				return getPcs();
			case CciPackage.CONNECTION_SPEC__TYPE:
				return getType();
			case CciPackage.CONNECTION_SPEC__SAPROUTER:
				return getSaprouter();
			case CciPackage.CONNECTION_SPEC__SYSNR:
				return getSysnr();
			case CciPackage.CONNECTION_SPEC__ASHOST:
				return getAshost();
			case CciPackage.CONNECTION_SPEC__MSHOST:
				return getMshost();
			case CciPackage.CONNECTION_SPEC__MSSERV:
				return getMsserv();
			case CciPackage.CONNECTION_SPEC__GWHOST:
				return getGwhost();
			case CciPackage.CONNECTION_SPEC__GWSERV:
				return getGwserv();
			case CciPackage.CONNECTION_SPEC__TPHOST:
				return getTphost();
			case CciPackage.CONNECTION_SPEC__TPNAME:
				return getTpname();
			case CciPackage.CONNECTION_SPEC__R3NAME:
				return getR3name();
			case CciPackage.CONNECTION_SPEC__GROUP:
				return getGroup();
			case CciPackage.CONNECTION_SPEC__TRACE:
				return getTrace();
			case CciPackage.CONNECTION_SPEC__CPIC_TRACE:
				return getCpicTrace();
			case CciPackage.CONNECTION_SPEC__LCHECK:
				return getLcheck();
			case CciPackage.CONNECTION_SPEC__USE_SAPGUI:
				return getUseSapgui();
			case CciPackage.CONNECTION_SPEC__CODEPAGE:
				return getCodepage();
			case CciPackage.CONNECTION_SPEC__GETSSO2:
				return getGetsso2();
			case CciPackage.CONNECTION_SPEC__DENY_INITIAL_PASSWORD:
				return getDenyInitialPassword();
			case CciPackage.CONNECTION_SPEC__PEAK_LIMIT:
				return getPeakLimit();
			case CciPackage.CONNECTION_SPEC__POOL_CAPACITY:
				return getPoolCapacity();
			case CciPackage.CONNECTION_SPEC__EXPIRATION_TIME:
				return getExpirationTime();
			case CciPackage.CONNECTION_SPEC__EXPIRATION_PERIOD:
				return getExpirationPeriod();
			case CciPackage.CONNECTION_SPEC__MAX_GET_TIME:
				return getMaxGetTime();
			case CciPackage.CONNECTION_SPEC__SNC_MODE:
				return getSncMode();
			case CciPackage.CONNECTION_SPEC__SNC_PARTNERNAME:
				return getSncPartnername();
			case CciPackage.CONNECTION_SPEC__SNC_QOP:
				return getSncQop();
			case CciPackage.CONNECTION_SPEC__SNC_MYNAME:
				return getSncMyname();
			case CciPackage.CONNECTION_SPEC__SNC_LIBRARY:
				return getSncLibrary();
			case CciPackage.CONNECTION_SPEC__REPOSITORY_DEST:
				return getRepositoryDest();
			case CciPackage.CONNECTION_SPEC__REPOSITORY_USER:
				return getRepositoryUser();
			case CciPackage.CONNECTION_SPEC__REPOSITORY_PASSWD:
				return getRepositoryPasswd();
			case CciPackage.CONNECTION_SPEC__REPOSITORY_SNC:
				return getRepositorySnc();
			case CciPackage.CONNECTION_SPEC__REPOSITORY_ROUNDTRIP_OPTIMIZATION:
				return getRepositoryRoundtripOptimization();
			case CciPackage.CONNECTION_SPEC__PING_ON_CREATE:
				return getPingOnCreate();
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
			case CciPackage.CONNECTION_SPEC__AUTH_TYPE:
				setAuthType((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__USER_ID:
				setUserId((String)newValue);
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
			case CciPackage.CONNECTION_SPEC__X509CERT:
				setX509cert((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__PCS:
				setPcs((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__TYPE:
				setType((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__SAPROUTER:
				setSaprouter((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__SYSNR:
				setSysnr((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__ASHOST:
				setAshost((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__MSHOST:
				setMshost((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__MSSERV:
				setMsserv((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__GWHOST:
				setGwhost((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__GWSERV:
				setGwserv((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__TPHOST:
				setTphost((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__TPNAME:
				setTpname((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__R3NAME:
				setR3name((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__GROUP:
				setGroup((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__TRACE:
				setTrace((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__CPIC_TRACE:
				setCpicTrace((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__LCHECK:
				setLcheck((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__USE_SAPGUI:
				setUseSapgui((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__CODEPAGE:
				setCodepage((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__GETSSO2:
				setGetsso2((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__DENY_INITIAL_PASSWORD:
				setDenyInitialPassword((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__PEAK_LIMIT:
				setPeakLimit((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__POOL_CAPACITY:
				setPoolCapacity((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__EXPIRATION_TIME:
				setExpirationTime((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__EXPIRATION_PERIOD:
				setExpirationPeriod((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__MAX_GET_TIME:
				setMaxGetTime((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__SNC_MODE:
				setSncMode((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__SNC_PARTNERNAME:
				setSncPartnername((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__SNC_QOP:
				setSncQop((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__SNC_MYNAME:
				setSncMyname((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__SNC_LIBRARY:
				setSncLibrary((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__REPOSITORY_DEST:
				setRepositoryDest((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__REPOSITORY_USER:
				setRepositoryUser((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__REPOSITORY_PASSWD:
				setRepositoryPasswd((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__REPOSITORY_SNC:
				setRepositorySnc((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__REPOSITORY_ROUNDTRIP_OPTIMIZATION:
				setRepositoryRoundtripOptimization((String)newValue);
				return;
			case CciPackage.CONNECTION_SPEC__PING_ON_CREATE:
				setPingOnCreate((String)newValue);
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
			case CciPackage.CONNECTION_SPEC__AUTH_TYPE:
				setAuthType(AUTH_TYPE_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__USER_ID:
				setUserId(USER_ID_EDEFAULT);
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
			case CciPackage.CONNECTION_SPEC__X509CERT:
				setX509cert(X509CERT_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__PCS:
				setPcs(PCS_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__SAPROUTER:
				setSaprouter(SAPROUTER_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__SYSNR:
				setSysnr(SYSNR_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__ASHOST:
				setAshost(ASHOST_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__MSHOST:
				setMshost(MSHOST_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__MSSERV:
				setMsserv(MSSERV_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__GWHOST:
				setGwhost(GWHOST_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__GWSERV:
				setGwserv(GWSERV_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__TPHOST:
				setTphost(TPHOST_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__TPNAME:
				setTpname(TPNAME_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__R3NAME:
				setR3name(R3NAME_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__GROUP:
				setGroup(GROUP_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__TRACE:
				setTrace(TRACE_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__CPIC_TRACE:
				setCpicTrace(CPIC_TRACE_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__LCHECK:
				setLcheck(LCHECK_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__USE_SAPGUI:
				setUseSapgui(USE_SAPGUI_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__CODEPAGE:
				setCodepage(CODEPAGE_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__GETSSO2:
				setGetsso2(GETSSO2_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__DENY_INITIAL_PASSWORD:
				setDenyInitialPassword(DENY_INITIAL_PASSWORD_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__PEAK_LIMIT:
				setPeakLimit(PEAK_LIMIT_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__POOL_CAPACITY:
				setPoolCapacity(POOL_CAPACITY_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__EXPIRATION_TIME:
				setExpirationTime(EXPIRATION_TIME_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__EXPIRATION_PERIOD:
				setExpirationPeriod(EXPIRATION_PERIOD_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__MAX_GET_TIME:
				setMaxGetTime(MAX_GET_TIME_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__SNC_MODE:
				setSncMode(SNC_MODE_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__SNC_PARTNERNAME:
				setSncPartnername(SNC_PARTNERNAME_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__SNC_QOP:
				setSncQop(SNC_QOP_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__SNC_MYNAME:
				setSncMyname(SNC_MYNAME_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__SNC_LIBRARY:
				setSncLibrary(SNC_LIBRARY_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__REPOSITORY_DEST:
				setRepositoryDest(REPOSITORY_DEST_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__REPOSITORY_USER:
				setRepositoryUser(REPOSITORY_USER_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__REPOSITORY_PASSWD:
				setRepositoryPasswd(REPOSITORY_PASSWD_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__REPOSITORY_SNC:
				setRepositorySnc(REPOSITORY_SNC_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__REPOSITORY_ROUNDTRIP_OPTIMIZATION:
				setRepositoryRoundtripOptimization(REPOSITORY_ROUNDTRIP_OPTIMIZATION_EDEFAULT);
				return;
			case CciPackage.CONNECTION_SPEC__PING_ON_CREATE:
				setPingOnCreate(PING_ON_CREATE_EDEFAULT);
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
			case CciPackage.CONNECTION_SPEC__AUTH_TYPE:
				return AUTH_TYPE_EDEFAULT == null ? authType != null : !AUTH_TYPE_EDEFAULT.equals(authType);
			case CciPackage.CONNECTION_SPEC__USER_ID:
				return USER_ID_EDEFAULT == null ? userId != null : !USER_ID_EDEFAULT.equals(userId);
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
			case CciPackage.CONNECTION_SPEC__X509CERT:
				return X509CERT_EDEFAULT == null ? x509cert != null : !X509CERT_EDEFAULT.equals(x509cert);
			case CciPackage.CONNECTION_SPEC__PCS:
				return PCS_EDEFAULT == null ? pcs != null : !PCS_EDEFAULT.equals(pcs);
			case CciPackage.CONNECTION_SPEC__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case CciPackage.CONNECTION_SPEC__SAPROUTER:
				return SAPROUTER_EDEFAULT == null ? saprouter != null : !SAPROUTER_EDEFAULT.equals(saprouter);
			case CciPackage.CONNECTION_SPEC__SYSNR:
				return SYSNR_EDEFAULT == null ? sysnr != null : !SYSNR_EDEFAULT.equals(sysnr);
			case CciPackage.CONNECTION_SPEC__ASHOST:
				return ASHOST_EDEFAULT == null ? ashost != null : !ASHOST_EDEFAULT.equals(ashost);
			case CciPackage.CONNECTION_SPEC__MSHOST:
				return MSHOST_EDEFAULT == null ? mshost != null : !MSHOST_EDEFAULT.equals(mshost);
			case CciPackage.CONNECTION_SPEC__MSSERV:
				return MSSERV_EDEFAULT == null ? msserv != null : !MSSERV_EDEFAULT.equals(msserv);
			case CciPackage.CONNECTION_SPEC__GWHOST:
				return GWHOST_EDEFAULT == null ? gwhost != null : !GWHOST_EDEFAULT.equals(gwhost);
			case CciPackage.CONNECTION_SPEC__GWSERV:
				return GWSERV_EDEFAULT == null ? gwserv != null : !GWSERV_EDEFAULT.equals(gwserv);
			case CciPackage.CONNECTION_SPEC__TPHOST:
				return TPHOST_EDEFAULT == null ? tphost != null : !TPHOST_EDEFAULT.equals(tphost);
			case CciPackage.CONNECTION_SPEC__TPNAME:
				return TPNAME_EDEFAULT == null ? tpname != null : !TPNAME_EDEFAULT.equals(tpname);
			case CciPackage.CONNECTION_SPEC__R3NAME:
				return R3NAME_EDEFAULT == null ? r3name != null : !R3NAME_EDEFAULT.equals(r3name);
			case CciPackage.CONNECTION_SPEC__GROUP:
				return GROUP_EDEFAULT == null ? group != null : !GROUP_EDEFAULT.equals(group);
			case CciPackage.CONNECTION_SPEC__TRACE:
				return TRACE_EDEFAULT == null ? trace != null : !TRACE_EDEFAULT.equals(trace);
			case CciPackage.CONNECTION_SPEC__CPIC_TRACE:
				return CPIC_TRACE_EDEFAULT == null ? cpicTrace != null : !CPIC_TRACE_EDEFAULT.equals(cpicTrace);
			case CciPackage.CONNECTION_SPEC__LCHECK:
				return LCHECK_EDEFAULT == null ? lcheck != null : !LCHECK_EDEFAULT.equals(lcheck);
			case CciPackage.CONNECTION_SPEC__USE_SAPGUI:
				return USE_SAPGUI_EDEFAULT == null ? useSapgui != null : !USE_SAPGUI_EDEFAULT.equals(useSapgui);
			case CciPackage.CONNECTION_SPEC__CODEPAGE:
				return CODEPAGE_EDEFAULT == null ? codepage != null : !CODEPAGE_EDEFAULT.equals(codepage);
			case CciPackage.CONNECTION_SPEC__GETSSO2:
				return GETSSO2_EDEFAULT == null ? getsso2 != null : !GETSSO2_EDEFAULT.equals(getsso2);
			case CciPackage.CONNECTION_SPEC__DENY_INITIAL_PASSWORD:
				return DENY_INITIAL_PASSWORD_EDEFAULT == null ? denyInitialPassword != null : !DENY_INITIAL_PASSWORD_EDEFAULT.equals(denyInitialPassword);
			case CciPackage.CONNECTION_SPEC__PEAK_LIMIT:
				return PEAK_LIMIT_EDEFAULT == null ? peakLimit != null : !PEAK_LIMIT_EDEFAULT.equals(peakLimit);
			case CciPackage.CONNECTION_SPEC__POOL_CAPACITY:
				return POOL_CAPACITY_EDEFAULT == null ? poolCapacity != null : !POOL_CAPACITY_EDEFAULT.equals(poolCapacity);
			case CciPackage.CONNECTION_SPEC__EXPIRATION_TIME:
				return EXPIRATION_TIME_EDEFAULT == null ? expirationTime != null : !EXPIRATION_TIME_EDEFAULT.equals(expirationTime);
			case CciPackage.CONNECTION_SPEC__EXPIRATION_PERIOD:
				return EXPIRATION_PERIOD_EDEFAULT == null ? expirationPeriod != null : !EXPIRATION_PERIOD_EDEFAULT.equals(expirationPeriod);
			case CciPackage.CONNECTION_SPEC__MAX_GET_TIME:
				return MAX_GET_TIME_EDEFAULT == null ? maxGetTime != null : !MAX_GET_TIME_EDEFAULT.equals(maxGetTime);
			case CciPackage.CONNECTION_SPEC__SNC_MODE:
				return SNC_MODE_EDEFAULT == null ? sncMode != null : !SNC_MODE_EDEFAULT.equals(sncMode);
			case CciPackage.CONNECTION_SPEC__SNC_PARTNERNAME:
				return SNC_PARTNERNAME_EDEFAULT == null ? sncPartnername != null : !SNC_PARTNERNAME_EDEFAULT.equals(sncPartnername);
			case CciPackage.CONNECTION_SPEC__SNC_QOP:
				return SNC_QOP_EDEFAULT == null ? sncQop != null : !SNC_QOP_EDEFAULT.equals(sncQop);
			case CciPackage.CONNECTION_SPEC__SNC_MYNAME:
				return SNC_MYNAME_EDEFAULT == null ? sncMyname != null : !SNC_MYNAME_EDEFAULT.equals(sncMyname);
			case CciPackage.CONNECTION_SPEC__SNC_LIBRARY:
				return SNC_LIBRARY_EDEFAULT == null ? sncLibrary != null : !SNC_LIBRARY_EDEFAULT.equals(sncLibrary);
			case CciPackage.CONNECTION_SPEC__REPOSITORY_DEST:
				return REPOSITORY_DEST_EDEFAULT == null ? repositoryDest != null : !REPOSITORY_DEST_EDEFAULT.equals(repositoryDest);
			case CciPackage.CONNECTION_SPEC__REPOSITORY_USER:
				return REPOSITORY_USER_EDEFAULT == null ? repositoryUser != null : !REPOSITORY_USER_EDEFAULT.equals(repositoryUser);
			case CciPackage.CONNECTION_SPEC__REPOSITORY_PASSWD:
				return REPOSITORY_PASSWD_EDEFAULT == null ? repositoryPasswd != null : !REPOSITORY_PASSWD_EDEFAULT.equals(repositoryPasswd);
			case CciPackage.CONNECTION_SPEC__REPOSITORY_SNC:
				return REPOSITORY_SNC_EDEFAULT == null ? repositorySnc != null : !REPOSITORY_SNC_EDEFAULT.equals(repositorySnc);
			case CciPackage.CONNECTION_SPEC__REPOSITORY_ROUNDTRIP_OPTIMIZATION:
				return REPOSITORY_ROUNDTRIP_OPTIMIZATION_EDEFAULT == null ? repositoryRoundtripOptimization != null : !REPOSITORY_ROUNDTRIP_OPTIMIZATION_EDEFAULT.equals(repositoryRoundtripOptimization);
			case CciPackage.CONNECTION_SPEC__PING_ON_CREATE:
				return PING_ON_CREATE_EDEFAULT == null ? pingOnCreate != null : !PING_ON_CREATE_EDEFAULT.equals(pingOnCreate);
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
		result.append(", authType: ");
		result.append(authType);
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
		result.append(", pcs: ");
		result.append(pcs);
		result.append(", type: ");
		result.append(type);
		result.append(", saprouter: ");
		result.append(saprouter);
		result.append(", sysnr: ");
		result.append(sysnr);
		result.append(", ashost: ");
		result.append(ashost);
		result.append(", mshost: ");
		result.append(mshost);
		result.append(", msserv: ");
		result.append(msserv);
		result.append(", gwhost: ");
		result.append(gwhost);
		result.append(", gwserv: ");
		result.append(gwserv);
		result.append(", tphost: ");
		result.append(tphost);
		result.append(", tpname: ");
		result.append(tpname);
		result.append(", r3name: ");
		result.append(r3name);
		result.append(", group: ");
		result.append(group);
		result.append(", trace: ");
		result.append(trace);
		result.append(", cpicTrace: ");
		result.append(cpicTrace);
		result.append(", lcheck: ");
		result.append(lcheck);
		result.append(", useSapgui: ");
		result.append(useSapgui);
		result.append(", codepage: ");
		result.append(codepage);
		result.append(", getsso2: ");
		result.append(getsso2);
		result.append(", denyInitialPassword: ");
		result.append(denyInitialPassword);
		result.append(", peakLimit: ");
		result.append(peakLimit);
		result.append(", poolCapacity: ");
		result.append(poolCapacity);
		result.append(", expirationTime: ");
		result.append(expirationTime);
		result.append(", expirationPeriod: ");
		result.append(expirationPeriod);
		result.append(", maxGetTime: ");
		result.append(maxGetTime);
		result.append(", sncMode: ");
		result.append(sncMode);
		result.append(", sncPartnername: ");
		result.append(sncPartnername);
		result.append(", sncQop: ");
		result.append(sncQop);
		result.append(", sncMyname: ");
		result.append(sncMyname);
		result.append(", sncLibrary: ");
		result.append(sncLibrary);
		result.append(", repositoryDest: ");
		result.append(repositoryDest);
		result.append(", repositoryUser: ");
		result.append(repositoryUser);
		result.append(", repositoryPasswd: ");
		result.append(repositoryPasswd);
		result.append(", repositorySnc: ");
		result.append(repositorySnc);
		result.append(", repositoryRoundtripOptimization: ");
		result.append(repositoryRoundtripOptimization);
		result.append(", pingOnCreate: ");
		result.append(pingOnCreate);
		result.append(')');
		return result.toString();
	}

} //ConnectionSpecImpl
