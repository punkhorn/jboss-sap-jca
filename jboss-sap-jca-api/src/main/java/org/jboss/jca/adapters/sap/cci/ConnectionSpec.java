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
package org.jboss.jca.adapters.sap.cci;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUserName <em>User Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPassword <em>Password</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getAuthType <em>Auth Type</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUserId <em>User Id</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getClient <em>Client</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUser <em>User</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getAliasUser <em>Alias User</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPasswd <em>Passwd</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getLang <em>Lang</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMysapsso2 <em>Mysapsso2</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getX509cert <em>X50 9cert</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPcs <em>Pcs</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getType <em>Type</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSaprouter <em>Saprouter</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSysnr <em>Sysnr</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getAshost <em>Ashost</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMshost <em>Mshost</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMsserv <em>Msserv</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getGwhost <em>Gwhost</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getGwserv <em>Gwserv</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getTphost <em>Tphost</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getTpname <em>Tpname</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getR3name <em>R3name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getGroup <em>Group</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getTrace <em>Trace</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getCpicTrace <em>Cpic Trace</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getLcheck <em>Lcheck</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUseSapgui <em>Use Sapgui</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getCodepage <em>Codepage</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getGetsso2 <em>Getsso2</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getDenyInitialPassword <em>Deny Initial Password</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPeakLimit <em>Peak Limit</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPoolCapacity <em>Pool Capacity</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getExpirationTime <em>Expiration Time</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getExpirationPeriod <em>Expiration Period</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMaxGetTime <em>Max Get Time</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncMode <em>Snc Mode</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncPartnername <em>Snc Partnername</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncQop <em>Snc Qop</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncMyname <em>Snc Myname</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncLibrary <em>Snc Library</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositoryDest <em>Repository Dest</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositoryUser <em>Repository User</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositoryPasswd <em>Repository Passwd</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositorySnc <em>Repository Snc</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositoryRoundtripOptimization <em>Repository Roundtrip Optimization</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPingOnCreate <em>Ping On Create</em>}</li>
 * </ul>
 * </p>
 *
 * @model superTypes="org.jboss.jca.adapters.sap.cci.CCIConnectionSpec"
 * @generated
 */
public interface ConnectionSpec extends EObject, javax.resource.cci.ConnectionSpec {
	/**
	 * Returns the value of the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Logon user, logon parameter for password based authentication.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Name</em>' attribute.
	 * @see #setUserName(String)
	 * @model
	 * @generated
	 */
	String getUserName();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUserName <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Logon user, logon parameter for password based authentication.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Name</em>' attribute.
	 * @see #getUserName()
	 * @generated
	 */
	void setUserName(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Logon password, logon parameter for password based authentication.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @model
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Logon password, logon parameter for password based authentication.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Auth Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Authentication type used by the destination. Known types are
	 * 
	 * CONFIGURED_USER - the destination configured for the specified user only. All connections opened via this
	 * destination belongs to the same user. This value is used in default case, if this property is missing.
	 * 
	 * CURRENT_USER - the connection created using this destination belongs to the current user. Before the connection
	 * is opened the runtime check the property "jco.client.current_user" in order to get the current user name.
	 * Note:This type is supported in SAP NetWeaver AS only
	 * 
	 * Note:This property is optional, default value is CONFIGURED_USER
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auth Type</em>' attribute.
	 * @see #setAuthType(String)
	 * @model
	 * @generated
	 */
	String getAuthType();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getAuthType <em>Auth Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Authentication type used by the destination. Known types are
	 * 
	 * CONFIGURED_USER - the destination configured for the specified user only. All connections opened via this
	 * destination belongs to the same user. This value is used in default case, if this property is missing.
	 * 
	 * CURRENT_USER - the connection created using this destination belongs to the current user. Before the connection
	 * is opened the runtime check the property "jco.client.current_user" in order to get the current user name.
	 * Note:This type is supported in SAP NetWeaver AS only
	 * 
	 * Note:This property is optional, default value is CONFIGURED_USER
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auth Type</em>' attribute.
	 * @see #getAuthType()
	 * @generated
	 */
	void setAuthType(String value);

	/**
	 * Returns the value of the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * User identity which is used for logon to the ABAP AS.
	 * 
	 * Used by the JCo runtime, if the destination configuration uses SSO/assertion ticket, certificate, "current" user
	 * or SNC environment for authentication. The user id is mandatory, if neither user not user alias is set. This id
	 * will never be sent to SAP backend, it will be used by the JCo runtime locally.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Id</em>' attribute.
	 * @see #setUserId(String)
	 * @model
	 * @generated
	 */
	String getUserId();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUserId <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * User identity which is used for logon to the ABAP AS.
	 * 
	 * Used by the JCo runtime, if the destination configuration uses SSO/assertion ticket, certificate, "current" user
	 * or SNC environment for authentication. The user id is mandatory, if neither user not user alias is set. This id
	 * will never be sent to SAP backend, it will be used by the JCo runtime locally.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Id</em>' attribute.
	 * @see #getUserId()
	 * @generated
	 */
	void setUserId(String value);

	/**
	 * Returns the value of the '<em><b>Client</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * SAP client, mandatory logon parameter.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Client</em>' attribute.
	 * @see #setClient(String)
	 * @model
	 * @generated
	 */
	String getClient();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getClient <em>Client</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * SAP client, mandatory logon parameter.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client</em>' attribute.
	 * @see #getClient()
	 * @generated
	 */
	void setClient(String value);

	/**
	 * Returns the value of the '<em><b>User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Logon user, logon parameter for password based authentication.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User</em>' attribute.
	 * @see #setUser(String)
	 * @model
	 * @generated
	 */
	String getUser();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUser <em>User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Logon user, logon parameter for password based authentication.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User</em>' attribute.
	 * @see #getUser()
	 * @generated
	 */
	void setUser(String value);

	/**
	 * Returns the value of the '<em><b>Alias User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Logon user alias, can be used instead of logon user.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alias User</em>' attribute.
	 * @see #setAliasUser(String)
	 * @model
	 * @generated
	 */
	String getAliasUser();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getAliasUser <em>Alias User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Logon user alias, can be used instead of logon user.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alias User</em>' attribute.
	 * @see #getAliasUser()
	 * @generated
	 */
	void setAliasUser(String value);

	/**
	 * Returns the value of the '<em><b>Passwd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Logon password, logon parameter for password based authentication.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Passwd</em>' attribute.
	 * @see #setPasswd(String)
	 * @model
	 * @generated
	 */
	String getPasswd();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPasswd <em>Passwd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Logon password, logon parameter for password based authentication.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Passwd</em>' attribute.
	 * @see #getPasswd()
	 * @generated
	 */
	void setPasswd(String value);

	/**
	 * Returns the value of the '<em><b>Lang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Logon language, if not defined the default user language is used.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lang</em>' attribute.
	 * @see #setLang(String)
	 * @model
	 * @generated
	 */
	String getLang();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getLang <em>Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Logon language, if not defined the default user language is used.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lang</em>' attribute.
	 * @see #getLang()
	 * @generated
	 */
	void setLang(String value);

	/**
	 * Returns the value of the '<em><b>Mysapsso2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * The SAP Cookie Version 2 used as logon ticket for SSO based authentication.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mysapsso2</em>' attribute.
	 * @see #setMysapsso2(String)
	 * @model
	 * @generated
	 */
	String getMysapsso2();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMysapsso2 <em>Mysapsso2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * The SAP Cookie Version 2 used as logon ticket for SSO based authentication.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mysapsso2</em>' attribute.
	 * @see #getMysapsso2()
	 * @generated
	 */
	void setMysapsso2(String value);

	/**
	 * Returns the value of the '<em><b>X50 9cert</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * The specified X509 certificate used for certificate based authentication
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X50 9cert</em>' attribute.
	 * @see #setX509cert(String)
	 * @model
	 * @generated
	 */
	String getX509cert();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getX509cert <em>X50 9cert</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * The specified X509 certificate used for certificate based authentication
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X50 9cert</em>' attribute.
	 * @see #getX509cert()
	 * @generated
	 */
	void setX509cert(String value);

	/**
	 * Returns the value of the '<em><b>Pcs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Additional logon parameter to define the codepage type of the SAP System,
	 * 
	 * 1 - non unicode, 2 - unicode enabled.
	 * 
	 * Used in special cases only
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pcs</em>' attribute.
	 * @see #setPcs(String)
	 * @model
	 * @generated
	 */
	String getPcs();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPcs <em>Pcs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Additional logon parameter to define the codepage type of the SAP System,
	 * 
	 * 1 - non unicode, 2 - unicode enabled.
	 * 
	 * Used in special cases only
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pcs</em>' attribute.
	 * @see #getPcs()
	 * @generated
	 */
	void setPcs(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Type of remote host.
	 * 
	 * The type will be recognized automatically and should not be set manually.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Type of remote host.
	 * 
	 * The type will be recognized automatically and should not be set manually.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Saprouter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * SAP Router string for connection to systems behind a SAP Router.
	 * 
	 * SAP Router string contains the chain of SAP Routers and its port numbers and has the form:
	 * 
	 * (/H/<host>[/S/<port>])+
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Saprouter</em>' attribute.
	 * @see #setSaprouter(String)
	 * @model
	 * @generated
	 */
	String getSaprouter();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSaprouter <em>Saprouter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * SAP Router string for connection to systems behind a SAP Router.
	 * 
	 * SAP Router string contains the chain of SAP Routers and its port numbers and has the form:
	 * 
	 * (/H/<host>[/S/<port>])+
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Saprouter</em>' attribute.
	 * @see #getSaprouter()
	 * @generated
	 */
	void setSaprouter(String value);

	/**
	 * Returns the value of the '<em><b>Sysnr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * System number of the SAP ABAP application server, mandatory for a direct connection.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sysnr</em>' attribute.
	 * @see #setSysnr(String)
	 * @model
	 * @generated
	 */
	String getSysnr();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSysnr <em>Sysnr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * System number of the SAP ABAP application server, mandatory for a direct connection.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sysnr</em>' attribute.
	 * @see #getSysnr()
	 * @generated
	 */
	void setSysnr(String value);

	/**
	 * Returns the value of the '<em><b>Ashost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * SAP ABAP application server, mandatory for a direct connection .
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ashost</em>' attribute.
	 * @see #setAshost(String)
	 * @model
	 * @generated
	 */
	String getAshost();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getAshost <em>Ashost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * SAP ABAP application server, mandatory for a direct connection .
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ashost</em>' attribute.
	 * @see #getAshost()
	 * @generated
	 */
	void setAshost(String value);

	/**
	 * Returns the value of the '<em><b>Mshost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * SAP message server port, optional property for a load balancing connection.
	 * 
	 * In order to resolve the service names sapmsXXX a lookup in etc/services is performed by the network layer of the
	 * operating system. If using port numbers instead of symbolic service names, no lookups are performed and no
	 * additional entries are needed.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mshost</em>' attribute.
	 * @see #setMshost(String)
	 * @model
	 * @generated
	 */
	String getMshost();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMshost <em>Mshost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * SAP message server port, optional property for a load balancing connection.
	 * 
	 * In order to resolve the service names sapmsXXX a lookup in etc/services is performed by the network layer of the
	 * operating system. If using port numbers instead of symbolic service names, no lookups are performed and no
	 * additional entries are needed.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mshost</em>' attribute.
	 * @see #getMshost()
	 * @generated
	 */
	void setMshost(String value);

	/**
	 * Returns the value of the '<em><b>Msserv</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * SAP message server port, optional property for a load balancing connection.
	 * 
	 * In order to resolve the service names sapmsXXX a lookup in etc/services is performed by the network layer of the
	 * operating system. If using port numbers instead of symbolic service names, no lookups are performed and no
	 * additional entries are needed.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Msserv</em>' attribute.
	 * @see #setMsserv(String)
	 * @model
	 * @generated
	 */
	String getMsserv();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMsserv <em>Msserv</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * SAP message server port, optional property for a load balancing connection.
	 * 
	 * In order to resolve the service names sapmsXXX a lookup in etc/services is performed by the network layer of the
	 * operating system. If using port numbers instead of symbolic service names, no lookups are performed and no
	 * additional entries are needed.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Msserv</em>' attribute.
	 * @see #getMsserv()
	 * @generated
	 */
	void setMsserv(String value);

	/**
	 * Returns the value of the '<em><b>Gwhost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Allows specifying a concrete gateway, which should be used for establishing the connection to an application
	 * server.
	 * 
	 * If not specified the gateway on the application server is used.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gwhost</em>' attribute.
	 * @see #setGwhost(String)
	 * @model
	 * @generated
	 */
	String getGwhost();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getGwhost <em>Gwhost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Allows specifying a concrete gateway, which should be used for establishing the connection to an application
	 * server.
	 * 
	 * If not specified the gateway on the application server is used.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gwhost</em>' attribute.
	 * @see #getGwhost()
	 * @generated
	 */
	void setGwhost(String value);

	/**
	 * Returns the value of the '<em><b>Gwserv</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Gateway server port.
	 * 
	 * Should be set, when setting GWhost.
	 * 
	 * Allows specifying the port used on that gateway. If not specified the port of the gateway on the application
	 * server is used.
	 * 
	 * In order to resolve the service names sapgwXXX a lookup in etc/services is performed by the network layer of the
	 * operating system. If using port numbers instead of symbolic service names, no lookups are performed and no
	 * additional entries are needed.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gwserv</em>' attribute.
	 * @see #setGwserv(String)
	 * @model
	 * @generated
	 */
	String getGwserv();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getGwserv <em>Gwserv</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Gateway server port.
	 * 
	 * Should be set, when setting GWhost.
	 * 
	 * Allows specifying the port used on that gateway. If not specified the port of the gateway on the application
	 * server is used.
	 * 
	 * In order to resolve the service names sapgwXXX a lookup in etc/services is performed by the network layer of the
	 * operating system. If using port numbers instead of symbolic service names, no lookups are performed and no
	 * additional entries are needed.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gwserv</em>' attribute.
	 * @see #getGwserv()
	 * @generated
	 */
	void setGwserv(String value);

	/**
	 * Returns the value of the '<em><b>Tphost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Host of external server.
	 * 
	 * Not supported in all runtime environments.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tphost</em>' attribute.
	 * @see #setTphost(String)
	 * @model
	 * @generated
	 */
	String getTphost();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getTphost <em>Tphost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Host of external server.
	 * 
	 * Not supported in all runtime environments.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tphost</em>' attribute.
	 * @see #getTphost()
	 * @generated
	 */
	void setTphost(String value);

	/**
	 * Returns the value of the '<em><b>Tpname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Program ID of external server.
	 * 
	 * Not supported in all runtime environments.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tpname</em>' attribute.
	 * @see #setTpname(String)
	 * @model
	 * @generated
	 */
	String getTpname();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getTpname <em>Tpname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Program ID of external server.
	 * 
	 * Not supported in all runtime environments.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tpname</em>' attribute.
	 * @see #getTpname()
	 * @generated
	 */
	void setTpname(String value);

	/**
	 * Returns the value of the '<em><b>R3name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * System ID of the SAP system, mandatory property for a load balancing connection.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>R3name</em>' attribute.
	 * @see #setR3name(String)
	 * @model
	 * @generated
	 */
	String getR3name();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getR3name <em>R3name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * System ID of the SAP system, mandatory property for a load balancing connection.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>R3name</em>' attribute.
	 * @see #getR3name()
	 * @generated
	 */
	void setR3name(String value);

	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Group of SAP application servers, mandatory property for a load balancing connection.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute.
	 * @see #setGroup(String)
	 * @model
	 * @generated
	 */
	String getGroup();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getGroup <em>Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Group of SAP application servers, mandatory property for a load balancing connection.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group</em>' attribute.
	 * @see #getGroup()
	 * @generated
	 */
	void setGroup(String value);

	/**
	 * Returns the value of the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Enable/disable RFC trace (0 or 1).
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace</em>' attribute.
	 * @see #setTrace(String)
	 * @model
	 * @generated
	 */
	String getTrace();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getTrace <em>Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Enable/disable RFC trace (0 or 1).
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace</em>' attribute.
	 * @see #getTrace()
	 * @generated
	 */
	void setTrace(String value);

	/**
	 * Returns the value of the '<em><b>Cpic Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Enable/disable CPIC trace [0..3].
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cpic Trace</em>' attribute.
	 * @see #setCpicTrace(String)
	 * @model
	 * @generated
	 */
	String getCpicTrace();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getCpicTrace <em>Cpic Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Enable/disable CPIC trace [0..3].
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cpic Trace</em>' attribute.
	 * @see #getCpicTrace()
	 * @generated
	 */
	void setCpicTrace(String value);

	/**
	 * Returns the value of the '<em><b>Lcheck</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Enable/Disable logon check at open time, 1 (enable) or 0 (disable).
	 * 
	 * Postpones the authentication until the first call - 1 (enable).
	 * 
	 * Used in special cases only.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lcheck</em>' attribute.
	 * @see #setLcheck(String)
	 * @model
	 * @generated
	 */
	String getLcheck();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getLcheck <em>Lcheck</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Enable/Disable logon check at open time, 1 (enable) or 0 (disable).
	 * 
	 * Postpones the authentication until the first call - 1 (enable).
	 * 
	 * Used in special cases only.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lcheck</em>' attribute.
	 * @see #getLcheck()
	 * @generated
	 */
	void setLcheck(String value);

	/**
	 * Returns the value of the '<em><b>Use Sapgui</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Start an SAP GUI and associate with the connection. (0 - do not start [default], 1 start GUI, 2 start GUI and
	 * hide if not used)
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Sapgui</em>' attribute.
	 * @see #setUseSapgui(String)
	 * @model
	 * @generated
	 */
	String getUseSapgui();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUseSapgui <em>Use Sapgui</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Start an SAP GUI and associate with the connection. (0 - do not start [default], 1 start GUI, 2 start GUI and
	 * hide if not used)
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Sapgui</em>' attribute.
	 * @see #getUseSapgui()
	 * @generated
	 */
	void setUseSapgui(String value);

	/**
	 * Returns the value of the '<em><b>Codepage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Initial codepage in SAP notation.
	 * 
	 * Additional logon parameter to define the codepage that will used to convert the logon parameters.
	 * 
	 * Used in special cases only.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Codepage</em>' attribute.
	 * @see #setCodepage(String)
	 * @model
	 * @generated
	 */
	String getCodepage();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getCodepage <em>Codepage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Initial codepage in SAP notation.
	 * 
	 * Additional logon parameter to define the codepage that will used to convert the logon parameters.
	 * 
	 * Used in special cases only.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Codepage</em>' attribute.
	 * @see #getCodepage()
	 * @generated
	 */
	void setCodepage(String value);

	/**
	 * Returns the value of the '<em><b>Getsso2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Get/Don't get a SSO ticket after logon (1 or 0)
	 * 
	 * Order a SSO ticket after logon, the obtained ticket is available in the destination attributes.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Getsso2</em>' attribute.
	 * @see #setGetsso2(String)
	 * @model
	 * @generated
	 */
	String getGetsso2();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getGetsso2 <em>Getsso2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Get/Don't get a SSO ticket after logon (1 or 0)
	 * 
	 * Order a SSO ticket after logon, the obtained ticket is available in the destination attributes.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Getsso2</em>' attribute.
	 * @see #getGetsso2()
	 * @generated
	 */
	void setGetsso2(String value);

	/**
	 * Returns the value of the '<em><b>Deny Initial Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Deny usage of initial passwords (0[default] or 1).
	 * 
	 * If set to 1, using initial passwords will lead to an exception (default=0).
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deny Initial Password</em>' attribute.
	 * @see #setDenyInitialPassword(String)
	 * @model
	 * @generated
	 */
	String getDenyInitialPassword();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getDenyInitialPassword <em>Deny Initial Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Deny usage of initial passwords (0[default] or 1).
	 * 
	 * If set to 1, using initial passwords will lead to an exception (default=0).
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deny Initial Password</em>' attribute.
	 * @see #getDenyInitialPassword()
	 * @generated
	 */
	void setDenyInitialPassword(String value);

	/**
	 * Returns the value of the '<em><b>Peak Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Maximum number of active connections that can be created for a destination simultaneously.
	 * 
	 * A value of 0 allows an unlimited number of active connections, otherwise if the value is less than the value of
	 * jco.destination.pool_capacity, it will be automatically increased to this value.
	 * 
	 * Default setting is the value of jco.destination.pool_capacity, or in case of jco.destination.pool_capacity not
	 * being specified as well, the default is 0 (unlimited).
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Peak Limit</em>' attribute.
	 * @see #setPeakLimit(String)
	 * @model
	 * @generated
	 */
	String getPeakLimit();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPeakLimit <em>Peak Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Maximum number of active connections that can be created for a destination simultaneously.
	 * 
	 * A value of 0 allows an unlimited number of active connections, otherwise if the value is less than the value of
	 * jco.destination.pool_capacity, it will be automatically increased to this value.
	 * 
	 * Default setting is the value of jco.destination.pool_capacity, or in case of jco.destination.pool_capacity not
	 * being specified as well, the default is 0 (unlimited).
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Peak Limit</em>' attribute.
	 * @see #getPeakLimit()
	 * @generated
	 */
	void setPeakLimit(String value);

	/**
	 * Returns the value of the '<em><b>Pool Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Maximum number of idle connections kept open by the destination. A value of 0 has the effect that there is no
	 * connection pooling, i.e. connections will be closed after each request.
	 * 
	 * A value of 0 has the effect that there is no connection pooling (default=1)
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pool Capacity</em>' attribute.
	 * @see #setPoolCapacity(String)
	 * @model
	 * @generated
	 */
	String getPoolCapacity();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPoolCapacity <em>Pool Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Maximum number of idle connections kept open by the destination. A value of 0 has the effect that there is no
	 * connection pooling, i.e. connections will be closed after each request.
	 * 
	 * A value of 0 has the effect that there is no connection pooling (default=1)
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pool Capacity</em>' attribute.
	 * @see #getPoolCapacity()
	 * @generated
	 */
	void setPoolCapacity(String value);

	/**
	 * Returns the value of the '<em><b>Expiration Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Time in ms after that a free connections hold internally by the destination can be closed.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expiration Time</em>' attribute.
	 * @see #setExpirationTime(String)
	 * @model
	 * @generated
	 */
	String getExpirationTime();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getExpirationTime <em>Expiration Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Time in ms after that a free connections hold internally by the destination can be closed.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expiration Time</em>' attribute.
	 * @see #getExpirationTime()
	 * @generated
	 */
	void setExpirationTime(String value);

	/**
	 * Returns the value of the '<em><b>Expiration Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Interval in ms with which the timeout checker thread checks the connections in the pool for expiration.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expiration Period</em>' attribute.
	 * @see #setExpirationPeriod(String)
	 * @model
	 * @generated
	 */
	String getExpirationPeriod();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getExpirationPeriod <em>Expiration Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Interval in ms with which the timeout checker thread checks the connections in the pool for expiration.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expiration Period</em>' attribute.
	 * @see #getExpirationPeriod()
	 * @generated
	 */
	void setExpirationPeriod(String value);

	/**
	 * Returns the value of the '<em><b>Max Get Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Max time in ms to wait for a connection, if the max allowed number of connections is allocated by the application
	 * SNC configuration
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Get Time</em>' attribute.
	 * @see #setMaxGetTime(String)
	 * @model
	 * @generated
	 */
	String getMaxGetTime();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMaxGetTime <em>Max Get Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Max time in ms to wait for a connection, if the max allowed number of connections is allocated by the application
	 * SNC configuration
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Get Time</em>' attribute.
	 * @see #getMaxGetTime()
	 * @generated
	 */
	void setMaxGetTime(String value);

	/**
	 * Returns the value of the '<em><b>Snc Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Secure network connection (SNC) mode, 0 (off) or 1 (on).
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snc Mode</em>' attribute.
	 * @see #setSncMode(String)
	 * @model
	 * @generated
	 */
	String getSncMode();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncMode <em>Snc Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Secure network connection (SNC) mode, 0 (off) or 1 (on).
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snc Mode</em>' attribute.
	 * @see #getSncMode()
	 * @generated
	 */
	void setSncMode(String value);

	/**
	 * Returns the value of the '<em><b>Snc Partnername</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * SNC partner, e.g. p:CN=R3, O=XYZ-INC, C=EN
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snc Partnername</em>' attribute.
	 * @see #setSncPartnername(String)
	 * @model
	 * @generated
	 */
	String getSncPartnername();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncPartnername <em>Snc Partnername</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * SNC partner, e.g. p:CN=R3, O=XYZ-INC, C=EN
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snc Partnername</em>' attribute.
	 * @see #getSncPartnername()
	 * @generated
	 */
	void setSncPartnername(String value);

	/**
	 * Returns the value of the '<em><b>Snc Qop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * SNC level of security, 1 to 9.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snc Qop</em>' attribute.
	 * @see #setSncQop(String)
	 * @model
	 * @generated
	 */
	String getSncQop();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncQop <em>Snc Qop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * SNC level of security, 1 to 9.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snc Qop</em>' attribute.
	 * @see #getSncQop()
	 * @generated
	 */
	void setSncQop(String value);

	/**
	 * Returns the value of the '<em><b>Snc Myname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Overrides default SNC partner.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snc Myname</em>' attribute.
	 * @see #setSncMyname(String)
	 * @model
	 * @generated
	 */
	String getSncMyname();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncMyname <em>Snc Myname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Overrides default SNC partner.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snc Myname</em>' attribute.
	 * @see #getSncMyname()
	 * @generated
	 */
	void setSncMyname(String value);

	/**
	 * Returns the value of the '<em><b>Snc Library</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Path to library which provides SNC service.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snc Library</em>' attribute.
	 * @see #setSncLibrary(String)
	 * @model
	 * @generated
	 */
	String getSncLibrary();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncLibrary <em>Snc Library</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Path to library which provides SNC service.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snc Library</em>' attribute.
	 * @see #getSncLibrary()
	 * @generated
	 */
	void setSncLibrary(String value);

	/**
	 * Returns the value of the '<em><b>Repository Dest</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Specifies which destination should be used as repository, i.e. use this destination's repository.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Dest</em>' attribute.
	 * @see #setRepositoryDest(String)
	 * @model
	 * @generated
	 */
	String getRepositoryDest();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositoryDest <em>Repository Dest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Specifies which destination should be used as repository, i.e. use this destination's repository.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Dest</em>' attribute.
	 * @see #getRepositoryDest()
	 * @generated
	 */
	void setRepositoryDest(String value);

	/**
	 * Returns the value of the '<em><b>Repository User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * User to use for repository calls.
	 * 
	 * Optional: If repository destination is not set, and this property is set, it will be used as user for repository
	 * queries. This allows using a different user for repository lookups and restrict the permissions accordingly.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository User</em>' attribute.
	 * @see #setRepositoryUser(String)
	 * @model
	 * @generated
	 */
	String getRepositoryUser();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositoryUser <em>Repository User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * User to use for repository calls.
	 * 
	 * Optional: If repository destination is not set, and this property is set, it will be used as user for repository
	 * queries. This allows using a different user for repository lookups and restrict the permissions accordingly.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository User</em>' attribute.
	 * @see #getRepositoryUser()
	 * @generated
	 */
	void setRepositoryUser(String value);

	/**
	 * Returns the value of the '<em><b>Repository Passwd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * The password for a repository user. Mandatory, if a repository user should be used.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Passwd</em>' attribute.
	 * @see #setRepositoryPasswd(String)
	 * @model
	 * @generated
	 */
	String getRepositoryPasswd();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositoryPasswd <em>Repository Passwd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * The password for a repository user. Mandatory, if a repository user should be used.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Passwd</em>' attribute.
	 * @see #getRepositoryPasswd()
	 * @generated
	 */
	void setRepositoryPasswd(String value);

	/**
	 * Returns the value of the '<em><b>Repository Snc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If SNC is used for this destination.
	 * 
	 * Optional: It is possible to turn it off for repository connections, if this property is set to 0.
	 * 
	 * Default setting is the value of jco.client.snc_mode. For special cases only.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Snc</em>' attribute.
	 * @see #setRepositorySnc(String)
	 * @model
	 * @generated
	 */
	String getRepositorySnc();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositorySnc <em>Repository Snc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If SNC is used for this destination.
	 * 
	 * Optional: It is possible to turn it off for repository connections, if this property is set to 0.
	 * 
	 * Default setting is the value of jco.client.snc_mode. For special cases only.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Snc</em>' attribute.
	 * @see #getRepositorySnc()
	 * @generated
	 */
	void setRepositorySnc(String value);

	/**
	 * Returns the value of the '<em><b>Repository Roundtrip Optimization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Is the usage of RFC_METADATA_GET API enabled, which is providing repository data in one single roundtrip.
	 * 
	 * 1 indicates the usage of RFC_METADATA_GET in ABAP System is forced, 0 indicated it is deactivated.
	 * 
	 * If the property is not set, the destination will initially do a remote call to check whether RFC_METADATA_GET is
	 * available. In case it is available, it will use it.
	 * 
	 * Note: If the repository is already initialized, for example because it is used by some other destination, this
	 * property does not have any effect. Generally, this property is related to the ABAP System, and should have the
	 * same value on all destinations pointing to the same ABAP System.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Roundtrip Optimization</em>' attribute.
	 * @see #setRepositoryRoundtripOptimization(String)
	 * @model
	 * @generated
	 */
	String getRepositoryRoundtripOptimization();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositoryRoundtripOptimization <em>Repository Roundtrip Optimization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Is the usage of RFC_METADATA_GET API enabled, which is providing repository data in one single roundtrip.
	 * 
	 * 1 indicates the usage of RFC_METADATA_GET in ABAP System is forced, 0 indicated it is deactivated.
	 * 
	 * If the property is not set, the destination will initially do a remote call to check whether RFC_METADATA_GET is
	 * available. In case it is available, it will use it.
	 * 
	 * Note: If the repository is already initialized, for example because it is used by some other destination, this
	 * property does not have any effect. Generally, this property is related to the ABAP System, and should have the
	 * same value on all destinations pointing to the same ABAP System.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Roundtrip Optimization</em>' attribute.
	 * @see #getRepositoryRoundtripOptimization()
	 * @generated
	 */
	void setRepositoryRoundtripOptimization(String value);

	/**
	 * Returns the value of the '<em><b>Ping On Create</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Indicates whether the Managed Connection will ping the connected SAP instance when created, <code>true</code>, or not, <code>false</code>.
	 * Default is <code>false</code>.
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ping On Create</em>' attribute.
	 * @see #setPingOnCreate(String)
	 * @model
	 * @generated
	 */
	String getPingOnCreate();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPingOnCreate <em>Ping On Create</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * Indicates whether the Managed Connection will ping the connected SAP instance when created, <code>true</code>, or not, <code>false</code>.
	 * Default is <code>false</code>.
	 * </p>
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ping On Create</em>' attribute.
	 * @see #getPingOnCreate()
	 * @generated
	 */
	void setPingOnCreate(String value);

} // ConnectionSpec
