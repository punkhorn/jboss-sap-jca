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
 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec()
 * @model superTypes="org.jboss.jca.adapters.sap.cci.CCIConnectionSpec"
 * @generated
 */
public interface ConnectionSpec extends EObject, javax.resource.cci.ConnectionSpec {
	/**
	 * Returns the value of the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Name</em>' attribute.
	 * @see #setUserName(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_UserName()
	 * @model
	 * @generated
	 */
	String getUserName();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUserName <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_Password()
	 * @model
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Auth Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auth Type</em>' attribute.
	 * @see #setAuthType(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_AuthType()
	 * @model
	 * @generated
	 */
	String getAuthType();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getAuthType <em>Auth Type</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>User Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Id</em>' attribute.
	 * @see #setUserId(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_UserId()
	 * @model
	 * @generated
	 */
	String getUserId();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUserId <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Client</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Client</em>' attribute.
	 * @see #setClient(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_Client()
	 * @model
	 * @generated
	 */
	String getClient();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getClient <em>Client</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>User</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User</em>' attribute.
	 * @see #setUser(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_User()
	 * @model
	 * @generated
	 */
	String getUser();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUser <em>User</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Alias User</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alias User</em>' attribute.
	 * @see #setAliasUser(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_AliasUser()
	 * @model
	 * @generated
	 */
	String getAliasUser();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getAliasUser <em>Alias User</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Passwd</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Passwd</em>' attribute.
	 * @see #setPasswd(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_Passwd()
	 * @model
	 * @generated
	 */
	String getPasswd();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPasswd <em>Passwd</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Lang</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lang</em>' attribute.
	 * @see #setLang(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_Lang()
	 * @model
	 * @generated
	 */
	String getLang();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getLang <em>Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Mysapsso2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mysapsso2</em>' attribute.
	 * @see #setMysapsso2(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_Mysapsso2()
	 * @model
	 * @generated
	 */
	String getMysapsso2();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMysapsso2 <em>Mysapsso2</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>X50 9cert</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X50 9cert</em>' attribute.
	 * @see #setX509cert(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_X509cert()
	 * @model
	 * @generated
	 */
	String getX509cert();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getX509cert <em>X50 9cert</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Pcs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pcs</em>' attribute.
	 * @see #setPcs(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_Pcs()
	 * @model
	 * @generated
	 */
	String getPcs();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPcs <em>Pcs</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Saprouter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Saprouter</em>' attribute.
	 * @see #setSaprouter(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_Saprouter()
	 * @model
	 * @generated
	 */
	String getSaprouter();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSaprouter <em>Saprouter</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Sysnr</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sysnr</em>' attribute.
	 * @see #setSysnr(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_Sysnr()
	 * @model
	 * @generated
	 */
	String getSysnr();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSysnr <em>Sysnr</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Ashost</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ashost</em>' attribute.
	 * @see #setAshost(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_Ashost()
	 * @model
	 * @generated
	 */
	String getAshost();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getAshost <em>Ashost</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Mshost</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mshost</em>' attribute.
	 * @see #setMshost(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_Mshost()
	 * @model
	 * @generated
	 */
	String getMshost();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMshost <em>Mshost</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Msserv</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Msserv</em>' attribute.
	 * @see #setMsserv(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_Msserv()
	 * @model
	 * @generated
	 */
	String getMsserv();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMsserv <em>Msserv</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Gwhost</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gwhost</em>' attribute.
	 * @see #setGwhost(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_Gwhost()
	 * @model
	 * @generated
	 */
	String getGwhost();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getGwhost <em>Gwhost</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Gwserv</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gwserv</em>' attribute.
	 * @see #setGwserv(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_Gwserv()
	 * @model
	 * @generated
	 */
	String getGwserv();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getGwserv <em>Gwserv</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Tphost</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tphost</em>' attribute.
	 * @see #setTphost(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_Tphost()
	 * @model
	 * @generated
	 */
	String getTphost();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getTphost <em>Tphost</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Tpname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tpname</em>' attribute.
	 * @see #setTpname(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_Tpname()
	 * @model
	 * @generated
	 */
	String getTpname();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getTpname <em>Tpname</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>R3name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>R3name</em>' attribute.
	 * @see #setR3name(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_R3name()
	 * @model
	 * @generated
	 */
	String getR3name();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getR3name <em>R3name</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Group</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute.
	 * @see #setGroup(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_Group()
	 * @model
	 * @generated
	 */
	String getGroup();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getGroup <em>Group</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Trace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace</em>' attribute.
	 * @see #setTrace(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_Trace()
	 * @model
	 * @generated
	 */
	String getTrace();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getTrace <em>Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Cpic Trace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cpic Trace</em>' attribute.
	 * @see #setCpicTrace(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_CpicTrace()
	 * @model
	 * @generated
	 */
	String getCpicTrace();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getCpicTrace <em>Cpic Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Lcheck</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lcheck</em>' attribute.
	 * @see #setLcheck(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_Lcheck()
	 * @model
	 * @generated
	 */
	String getLcheck();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getLcheck <em>Lcheck</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Use Sapgui</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Sapgui</em>' attribute.
	 * @see #setUseSapgui(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_UseSapgui()
	 * @model
	 * @generated
	 */
	String getUseSapgui();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUseSapgui <em>Use Sapgui</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Codepage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Codepage</em>' attribute.
	 * @see #setCodepage(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_Codepage()
	 * @model
	 * @generated
	 */
	String getCodepage();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getCodepage <em>Codepage</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Getsso2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Getsso2</em>' attribute.
	 * @see #setGetsso2(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_Getsso2()
	 * @model
	 * @generated
	 */
	String getGetsso2();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getGetsso2 <em>Getsso2</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Deny Initial Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deny Initial Password</em>' attribute.
	 * @see #setDenyInitialPassword(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_DenyInitialPassword()
	 * @model
	 * @generated
	 */
	String getDenyInitialPassword();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getDenyInitialPassword <em>Deny Initial Password</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Peak Limit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Peak Limit</em>' attribute.
	 * @see #setPeakLimit(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_PeakLimit()
	 * @model
	 * @generated
	 */
	String getPeakLimit();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPeakLimit <em>Peak Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Pool Capacity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pool Capacity</em>' attribute.
	 * @see #setPoolCapacity(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_PoolCapacity()
	 * @model
	 * @generated
	 */
	String getPoolCapacity();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPoolCapacity <em>Pool Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Expiration Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expiration Time</em>' attribute.
	 * @see #setExpirationTime(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_ExpirationTime()
	 * @model
	 * @generated
	 */
	String getExpirationTime();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getExpirationTime <em>Expiration Time</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Expiration Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expiration Period</em>' attribute.
	 * @see #setExpirationPeriod(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_ExpirationPeriod()
	 * @model
	 * @generated
	 */
	String getExpirationPeriod();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getExpirationPeriod <em>Expiration Period</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Max Get Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Get Time</em>' attribute.
	 * @see #setMaxGetTime(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_MaxGetTime()
	 * @model
	 * @generated
	 */
	String getMaxGetTime();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMaxGetTime <em>Max Get Time</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Snc Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snc Mode</em>' attribute.
	 * @see #setSncMode(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_SncMode()
	 * @model
	 * @generated
	 */
	String getSncMode();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncMode <em>Snc Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Snc Partnername</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snc Partnername</em>' attribute.
	 * @see #setSncPartnername(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_SncPartnername()
	 * @model
	 * @generated
	 */
	String getSncPartnername();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncPartnername <em>Snc Partnername</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Snc Qop</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snc Qop</em>' attribute.
	 * @see #setSncQop(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_SncQop()
	 * @model
	 * @generated
	 */
	String getSncQop();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncQop <em>Snc Qop</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Snc Myname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snc Myname</em>' attribute.
	 * @see #setSncMyname(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_SncMyname()
	 * @model
	 * @generated
	 */
	String getSncMyname();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncMyname <em>Snc Myname</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Snc Library</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snc Library</em>' attribute.
	 * @see #setSncLibrary(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_SncLibrary()
	 * @model
	 * @generated
	 */
	String getSncLibrary();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncLibrary <em>Snc Library</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Repository Dest</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Dest</em>' attribute.
	 * @see #setRepositoryDest(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_RepositoryDest()
	 * @model
	 * @generated
	 */
	String getRepositoryDest();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositoryDest <em>Repository Dest</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Repository User</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository User</em>' attribute.
	 * @see #setRepositoryUser(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_RepositoryUser()
	 * @model
	 * @generated
	 */
	String getRepositoryUser();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositoryUser <em>Repository User</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Repository Passwd</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Passwd</em>' attribute.
	 * @see #setRepositoryPasswd(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_RepositoryPasswd()
	 * @model
	 * @generated
	 */
	String getRepositoryPasswd();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositoryPasswd <em>Repository Passwd</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Repository Snc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Snc</em>' attribute.
	 * @see #setRepositorySnc(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_RepositorySnc()
	 * @model
	 * @generated
	 */
	String getRepositorySnc();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositorySnc <em>Repository Snc</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Repository Roundtrip Optimization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Roundtrip Optimization</em>' attribute.
	 * @see #setRepositoryRoundtripOptimization(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_RepositoryRoundtripOptimization()
	 * @model
	 * @generated
	 */
	String getRepositoryRoundtripOptimization();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositoryRoundtripOptimization <em>Repository Roundtrip Optimization</em>}' attribute.
	 * <!-- begin-user-doc -->
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
	 * If the meaning of the '<em>Ping On Create</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ping On Create</em>' attribute.
	 * @see #setPingOnCreate(String)
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#getConnectionSpec_PingOnCreate()
	 * @model
	 * @generated
	 */
	String getPingOnCreate();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPingOnCreate <em>Ping On Create</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ping On Create</em>' attribute.
	 * @see #getPingOnCreate()
	 * @generated
	 */
	void setPingOnCreate(String value);

} // ConnectionSpec
