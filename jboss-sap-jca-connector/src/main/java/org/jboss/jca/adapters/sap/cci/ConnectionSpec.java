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
 * Specializes the {@link javax.resource.cci.ConnectionSpec} interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUserName <em>User Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPassword <em>Password</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUserId <em>User Id</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getClient <em>Client</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUser <em>User</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getAliasUser <em>Alias User</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPasswd <em>Passwd</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getLang <em>Lang</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMysapsso2 <em>Mysapsso2</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getX509cert <em>X50 9cert</em>}</li>
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

} // ConnectionSpec
