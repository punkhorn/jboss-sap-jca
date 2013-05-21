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
package org.jboss.jca.adapters.sap.spi;

import java.util.Properties;

/**
 * Specializes the {@link javax.resource.spi.ConnectionRequestInfo} interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 *
 */
public interface ConnectionRequestInfo extends javax.resource.spi.ConnectionRequestInfo {
	

	/**
	 * {@inheritDoc}
	 */
	boolean equals(Object other);

	/**
	 * {@inheritDoc}
	 */
	int hashCode();

	/**
	 * Returns a properties object containing the properties of this ConnectionRequestInfo.
	 * @return a properties object containing the properties of this ConnectionRequestInfo.
	 */
	Properties getProperties();

	/**
	 * Logon user alias, can be used instead of logon user.
	 * 
	 * @return Logon user alias.
	 */
	String getAliasUser();

	/**
	 * SAP ABAP application server, mandatory for a direct connection.
	 * 
	 * @return SAP ABAP application server, mandatory for a direct connection.
	 */
	String getAshost();

	/**
	 * Authentication type used by the destination. Known types are
	 * 
	 * <p><b>CONFIGURED_USER</b> - the destination configured for the specified user only. All connections opened via this
	 * destination belongs to the same user. This value is used in default case, if this property is missing.
	 * 
	 * <p><b>CURRENT_USER</b> - the connection created using this destination belongs to the current user. Before the connection
	 * is opened the runtime check the property "jco.client.current_user" in order to get the current user name.
	 * Note:This type is supported in SAP NetWeaver AS only
	 * 
	 * <p>Note:This property is optional, default value is CONFIGURED_USER
	 * 
	 * @return Authentication type used by the destination. Known types are
	 */
	String getAuthType();

	/**
	 * SAP client, mandatory logon parameter.
	 * 
	 * @return SAP client.
	 */
	String getClient();

	/**
	 * Initial codepage in SAP notation.
	 * 
	 * Additional logon parameter to define the codepage that will used to convert the logon parameters.
	 * 
	 * Used in special cases only.
	 * 
	 * @return Initial codepage in SAP notation.
	 */
	String getCodepage();

	/**
	 * Enable/disable CPIC trace [0..3].
	 * 
	 * @return Trace level of CPIC trace [0..3].
	 */
	String getCpicTrace();

	/**
	 * Deny usage of initial passwords (0[default] or 1).
	 * 
	 * <p>If set to 1, using initial passwords will lead to an exception (default=0).
	 * 
	 * @return Deny usage of initial passwords (0[default] or 1)
	 */
	String getDenyInitialPassword();

	/**
	 * Interval in ms with which the timeout checker thread checks the connections in the pool for expiration.
	 * 
	 * @return Interval in ms with which the timeout checker thread checks the connections in the pool for expiration.
	 */
	String getExpirationPeriod();

	/**
	 * Time in ms after that a free connections hold internally by the destination can be closed.
	 * 
	 * @return Time in ms after that a free connections hold internally by the destination can be closed
	 */
	String getExpirationTime();

	/**
	 * Get/Don't get a SSO ticket after logon (1 or 0)
	 * 
	 * <p>Order a SSO ticket after logon, the obtained ticket is available in the destination attributes.
	 * 
	 * @return Get/Don't get a SSO ticket after logon (1 or 0)
	 */
	String getGetsso2();

	/**
	 * Group of SAP application servers, mandatory property for a load balancing connection.
	 * 
	 * @return Group of SAP application servers.
	 */
	String getGroup();

	/**
	 * Allows specifying a concrete gateway, which should be used for establishing the connection to an application
	 * server.
	 * 
	 * <p>If not specified the gateway on the application server is used.
	 * 
	 * @return Gateway used for establishing the connection to an application server.
	 */
	String getGwhost();

	/**
	 * Gateway server port.
	 * 
	 * <p>Should be set, when setting GWhost.
	 * 
	 * <p>Allows specifying the port used on that gateway. If not specified the port of the gateway on the application
	 * server is used.
	 * 
	 * <p>In order to resolve the service names sapgwXXX a lookup in etc/services is performed by the network layer of the
	 * operating system. If using port numbers instead of symbolic service names, no lookups are performed and no
	 * additional entries are needed.
	 * 
	 * @return Gateway server port.
	 */
	String getGwserv();

	/**
	 * Logon language, if not defined the default user language is used.
	 * 
	 * @return Logon language, if not defined the default user language is used.
	 */
	String getLang();

	/**
	 * Enable/Disable logon check at open time, 1 (enable) or 0 (disable).
	 * 
	 * <p>Postpones the authentication until the first call - 1 (enable).
	 * 
	 * <p>Used in special cases only.
	 * 
	 * @return 1 (enabled) or 0 (disabled).
	 */
	String getLcheck();

	/**
	 * Max time in ms to wait for a connection, if the max allowed number of connections is allocated by the application
	 * SNC configuration
	 * 
	 * @return Max time in ms to wait for a connection.
	 */
	String getMaxGetTime();

	/**
	 * SAP message server port, optional property for a load balancing connection.
	 * 
	 * <p>In order to resolve the service names sapmsXXX a lookup in etc/services is performed by the network layer of the
	 * operating system. If using port numbers instead of symbolic service names, no lookups are performed and no
	 * additional entries are needed.
	 * 
	 * @return SAP message server port.
	 */
	String getMshost();

	/**
	 * SAP message server port, optional property for a load balancing connection.
	 * 
	 * <p>In order to resolve the service names sapmsXXX a lookup in etc/services is performed by the network layer of the
	 * operating system. If using port numbers instead of symbolic service names, no lookups are performed and no
	 * additional entries are needed.
	 * 
	 * @return SAP message server port.
	 */
	String getMsserv();

	/**
	 * The SAP Cookie Version 2 used as logon ticket for SSO based authentication.
	 * 
	 * @return The SAP Cookie Version 2 used as logon ticket for SSO based authentication.
	 */
	String getMysapsso2();

	/**
	 * Returns the password for the user establishing a connection
	 * 
	 * <p>
	 * <b>NB:</b> The <em>password</em> and <em>passwd<em> properties are the same property
	 * </p>
	 * 
	 * @return The password for the user establishing a connection
	 */
	String getPassword();

	/**
	 * Logon password, logon parameter for password based authentication.
	 * 
	 * <p>
	 * <b>NB:</b> The <em>password</em> and <em>passwd<em> properties are the same property
	 * </p>
	 * 
	 * @return Logon password, logon parameter for password based authentication.
	 */
	String getPasswd();

	/**
	 * Additional logon parameter to define the codepage type of the SAP System,
	 * 
	 * <p>1 - non unicode, 2 - unicode enabled.
	 * 
	 * <p>Used in special cases only
	 * 
	 * @return Additional logon parameter to define the codepage type of the SAP System.
	 */
	String getPcs();

	/**
	 * Maximum number of active connections that can be created for a destination simultaneously.
	 * 
	 * <p>A value of 0 allows an unlimited number of active connections, otherwise if the value is less than the value of
	 * jco.destination.pool_capacity, it will be automatically increased to this value.
	 * 
	 * <p>Default setting is the value of jco.destination.pool_capacity, or in case of jco.destination.pool_capacity not
	 * being specified as well, the default is 0 (unlimited).
	 * 
	 * @return Maximum number of active connections that can be created for a destination simultaneously
	 */
	String getPeakLimit();

	/**
	 * Indicates whether the Managed Connection will ping the connected SAP instance when created, <code>true</code>, or not, <code>false</code>.
	 * Default is <code>false</code>.
	 * 
	 * @return Whether the Managed Connection will ping the connected SAP instance when created, <code>true</code>, or not, <code>false</code>.
	 */
	String getPingOnCreate();

	/**
	 * Maximum number of idle connections kept open by the destination. A value of 0 has the effect that there is no
	 * connection pooling, i.e. connections will be closed after each request.
	 * 
	 *<p> A value of 0 has the effect that there is no connection pooling (default=1)
	 * 
	 * @return Maximum number of idle connections kept open by the destination.
	 */
	String getPoolCapacity();

	/**
	 * System ID of the SAP system, mandatory property for a load balancing connection.
	 * 
	 * @return System ID of the SAP system.
	 */
	String getR3name();

	/**
	 * Specifies which destination should be used as repository, i.e. use this destination's repository.
	 * 
	 * @return Destination that should be used as repository
	 */
	String getRepositoryDest();

	/**
	 * The password for a repository user. Mandatory, if a repository user should be used.
	 * 
	 * @return The password for a repository user.
	 */
	String getRepositoryPasswd();

	/**
	 * <p>Is the usage of RFC_METADATA_GET API enabled, which is providing repository data in one single roundtrip.
	 * 
	 * <p>1 indicates the usage of RFC_METADATA_GET in ABAP System is forced, 0 indicated it is deactivated.
	 * 
	 * <p>If the property is not set, the destination will initially do a remote call to check whether RFC_METADATA_GET is
	 * available. In case it is available, it will use it.
	 * 
	 * <p>Note: If the repository is already initialized, for example because it is used by some other destination, this
	 * property does not have any effect. Generally, this property is related to the ABAP System, and should have the
	 * same value on all destinations pointing to the same ABAP System.
	 * 
	 * @return Is the usage of RFC_METADATA_GET API forced (1) or deactivated (0).
	 */
	String getRepositoryRoundtripOptimization();

	/**
	 * <p>If SNC is used for this destination.
	 * 
	 * <p>Optional: It is possible to turn it off for repository connections, if this property is set to 0.
	 * 
	 * <p>Default setting is the value of jco.client.snc_mode. For special cases only.
	 * 
	 * @return If SNC is used for this destination.
	 */
	String getRepositorySnc();

	/**
	 * <p>User to use for repository calls.
	 * 
	 * <p>Optional: If repository destination is not set, and this property is set, it will be used as user for repository
	 * queries. This allows using a different user for repository lookups and restrict the permissions accordingly.
	 * 
	 * @return User used for repository calls.
	 */
	String getRepositoryUser();

	/**
	 * <p>SAP Router string for connection to systems behind a SAP Router.
	 * 
	 * <p>SAP Router string contains the chain of SAP Routers and its port numbers and has the form:
	 * 
	 * <pre>(/H/<host>[/S/<port>])+</pre>
	 * 
	 * @return SAP Router string for connection to systems behind a SAP Router.
	 */
	String getSaprouter();

	/**
	 * Path to library which provides SNC service.
	 * 
	 * @return Path to library which provides SNC service
	 */
	String getSncLibrary();

	/**
	 * Secure network connection (SNC) mode, 0 (off) or 1 (on).
	 * 
	 * @return Secure network connection (SNC) mode, 0 (off) or 1 (on).
	 */
	String getSncMode();

	/**
	 * SNC name.
	 * 
	 * <p>Overrides default SNC partner.
	 * 
	 * @return SNC name.
	 */
	String getSncMyname();

	/**
	 * SNC partner, e.g. p:CN=R3, O=XYZ-INC, C=EN
	 * 
	 * @return SNC partner.
	 */
	String getSncPartnername();

	/**
	 * SNC partner, e.g. p:CN=R3, O=XYZ-INC, C=EN
	 * 
	 * @return SNC partner.
	 */
	String getSncQop();

	/**
	 * System number of the SAP ABAP application server, mandatory for a direct connection.
	 * 
	 * @return - System number of the SAP ABAP application server, mandatory for a direct connection.
	 */
	String getSysnr();

	/**
	 * Host of external server.
	 * 
	 * <p>Not supported in all runtime environments.
	 * 
	 * @return Host of external server.
	 */
	String getTphost();

	/**
	 * Program ID of external server.
	 * 
	 * <p>Not supported in all runtime environments.
	 * 
	 * @return Program ID of external server.
	 */
	String getTpname();

	/**
	 * Enable/disable RFC trace (0 or 1).
	 * 
	 * @return trace level of RFC trace (0 or 1).
	 */
	String getTrace();

	/**
	 * Type of remote host.
	 * 
	 * <p>The type will be recognized automatically and should not be set manually.
	 * 
	 * @return Type of remote host.
	 */
	String getType();

	/**
	 * Returns the name of the user establishing a connection to an SAP instance.
	 * 
	 * <p>
	 * <b>NB:</b> The <em>user</em> and <em>userName<em> properties are the same property
	 * </p>
	 * 
	 * @return The name of the user establishing a connection to an SAP instance.
	 */
	String getUserName();

	/**
	 * Logon user, logon parameter for password based authentication.
	 * 
	 * <p>
	 * <b>NB:</b> The <em>user</em> and <em>userName<em> properties are the same property
	 * </p>
	 * 
	 * @return Logon user, logon parameter for password based authentication.
	 */
	String getUser();

	/**
	 * User identity which is used for logon to the ABAP AS.
	 * 
	 * <p>Used by the JCo runtime, if the destination configuration uses SSO/assertion ticket, certificate, "current" user
	 * or SNC environment for authentication. The user id is mandatory, if neither user not user alias is set. This id
	 * will never be sent to SAP backend, it will be used by the JCo runtime locally.
	 * 
	 * @return User identity which is used for logon to the ABAP AS.
	 */
	String getUserId();

	/**
	 * Start an SAP GUI and associate with the connection. (0 - do not start [default], 1 start GUI, 2 start GUI and
	 * hide if not used)
	 * 
	 * @return 0 - do not start [default], 1 start GUI, 2 start GUI and hide if not used
	 */
	String getUseSapgui();

	/**
	 * The specified X509 certificate used for certificate based authentication
	 * 
	 * @return The specified X509 certificate used for certificate based authentication
	 */
	String getX509cert();

	/**
	 * Set logon user alias, can be used instead of logon user.
	 * 
	 * @param user
	 *            - logon user alias.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setAliasUser(String user);

	/**
	 * Set ABAP application server.
	 * 
	 * @param ashost
	 *            - SAP ABAP application server.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setAshost(String ashost);

	/**
	 * Sets authentication type used by the destination.
	 * 
	 * @param authType
	 *            - authentication type used by the destination.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setAuthType(String authType);

	/**
	 * Set SAP client.
	 * 
	 * @param client
	 *            - SAP client.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setClient(String client);

	/**
	 * Set initial codepage in SAP notation.
	 * 
	 * @param codepage
	 *            - Initial codepage in SAP notation.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setCodepage(String codepage);

	/**
	 * Set trace level of CPIC trace [0..3].
	 * 
	 * @param cpicTrace
	 *            - Trace level of CPIC trace: [0..3].
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setCpicTrace(String cpicTrace);

	/**
	 * Set whether to deny usage of initial passwords (0[default] or 1).
	 * 
	 * @param denyInitialPassword
	 *            - whether to deny usage of initial passwords (0[default] or 1).
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setDenyInitialPassword(String denyInitialPassword);

	/**
	 * Set interval in ms with which the timeout checker thread checks the connections in the pool for expiration.
	 * 
	 * @param expirationPeriod
	 *            - Interval in ms with which the timeout checker thread checks the connections in the pool for
	 *            expiration.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setExpirationPeriod(String expirationPeriod);

	/**
	 * Set the time in ms after that a free connections hold internally by the destination can be closed
	 * 
	 * @param expirationTime
	 *            - Time in ms after that a free connections hold internally by the destination can be closed
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setExpirationTime(String expirationTime);

	/**
	 * Set whether to Get/Don't get a SSO ticket after logon (1 or 0).
	 * 
	 * @param getsso2
	 *            - Get/Don't get a SSO ticket after logon (1 or 0).
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setGetsso2(String getsso2);

	/**
	 * Set group of SAP application servers.
	 * 
	 * @param group
	 *            - Group of SAP application servers.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setGroup(String group);

	/**
	 * Set Gateway used for establishing the connection to an application server.
	 * 
	 * @param gwhost
	 *            - Gateway used for establishing the connection to an application server.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setGwhost(String gwhost);

	/**
	 * Set Gateway server port.
	 * 
	 * @param gwserv
	 *            - Gateway server port. -
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setGwserv(String gwserv);

	/**
	 * Sets logon language.
	 * 
	 * @param lang
	 *            - Logon language.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setLang(String lang);

	/**
	 * Set whether to Enable/Disable logon check at open time, 1 (enable) or 0 (disable).
	 * 
	 * @param lcheck
	 *            - 1 (enabled) or 0 (disabled).
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setLcheck(String lcheck);

	/**
	 * Set the max time in ms to wait for a connection
	 * 
	 * @param maxGetTime
	 *            - Max time in ms to wait for a connection
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setMaxGetTime(String maxGetTime);

	/**
	 * Set SAP message server port, optional property for a load balancing connection.
	 * 
	 * @param mshost
	 *            - SAP message server port.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setMshost(String mshost);

	/**
	 * Set SAP message server port
	 * 
	 * @param msserv
	 *            - SAP message server port -
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setMsserv(String msserv);

	/**
	 * Set the SAP Cookie Version 2 used as logon ticket for SSO based authentication.
	 * 
	 * @param mysapsso2
	 *            - The SAP Cookie Version 2 used as logon ticket for SSO based authentication.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setMysapsso2(String mysapsso2);

	/**
	 * Sets the password for the user establishing a connection
	 * 
	 * <p>
	 * <b>NB:</b> The <em>password</em> and <em>passwd<em> properties are the same property
	 * </p>
	 * 
	 * @param password
	 *            - the password for the user establishing a connection
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setPassword(String password);

	/**
	 * Set logon password, logon parameter for password based authentication.
	 * 
	 * <p>
	 * <b>NB:</b> The <em>password</em> and <em>passwd<em> properties are the same property
	 * </p>
	 * 
	 * @param passwd
	 *            - Logon password, logon parameter for password based authentication.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setPasswd(String passwd);

	/**
	 * Set additional logon parameter to define the codepage type of the SAP System
	 * 
	 * @param pcs
	 *            - Additional logon parameter to define the codepage type of the SAP System
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setPcs(String pcs);

	/**
	 * Set maximum number of active connections that can be created for a destination simultaneously
	 * 
	 * <p>A value of 0 allows an unlimited number of active connections, otherwise if the value is less than the value of
	 * jco.destination.pool_capacity, it will be automatically increased to this value.
	 * 
	 * @param peakLimit
	 *            - Maximum number of active connections that can be created for a destination simultaneously
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setPeakLimit(String peakLimit);

	/**
	 * Sets whether the Managed Connection will ping the connected SAP instance when created, <code>true</code>, or not, <code>false</code>.
	 * 
	 * @param pingOnCreate - whether the Managed Connection will ping the connected SAP instance when created, <code>true</code>, or not, <code>false</code>.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setPingOnCreate(String pingOnCreate);

	/**
	 * Set maximum number of idle connections kept open by the destination.
	 * 
	 * <p>A value of 0 has the effect that there is no connection pooling (default=1)
	 * 
	 * @param poolCapacity
	 *            - Maximum number of idle connections kept open by the destination.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setPoolCapacity(String poolCapacity);

	/**
	 * Set System ID of the SAP system.
	 * 
	 * @param r3name
	 *            - System ID of the SAP system.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setR3name(String r3name);

	/**
	 * Set destination that should be used as repository.
	 * 
	 * @param repositoryDest
	 *            - Destination that should be used as repository
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setRepositoryDest(String repositoryDest);

	/**
	 * Set the password for a repository user.
	 * 
	 * @param repositoryPasswd
	 *            - The password for a repository user.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setRepositoryPasswd(String repositoryPasswd);

	/**
	 * Enable the usage of RFC_METADATA_GET API, which is providing repository data in one single roundtrip.
	 * 
	 * <p>1 forces the usage of RFC_METADATA_GET in ABAP System, 0 deactivates it.
	 * 
	 * <p>If the property is not set, the destination will initially do a remote call to check whether RFC_METADATA_GET is
	 * available. In case it is available, it will use it.
	 * 
	 * <p>Note: If the repository is already initializated, for example because it is used by some other destination, this
	 * property does not have any effect. Generally, this property is related to the ABAP System, and should have the
	 * same value on all destinations pointing to the same ABAP System.
	 * 
	 * @param repositoryRoundtripOptimization
	 *            - Force(1)/Deactivate(0) the usage of RFC_METADATA_GET API.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setRepositoryRoundtripOptimization(String repositoryRoundtripOptimization);

	/**
	 * Set if SNC is used for this destination.
	 * 
	 * <p>Optional: It is possible to turn it off for repository connections, if this property is set to 0.
	 * 
	 * @param repositorySnc
	 *            - if SNC is used for this destination.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setRepositorySnc(String repositorySnc);

	/**
	 * Set user to use for repository calls.
	 * 
	 * <p>Optional: If repository destination is not set, and this property is set, it will be used as user for repository
	 * queries. This allows using a different user for repository lookups and restrict the permissions accordingly.
	 * 
	 * @param repositoryUser
	 *            - User used for repository calls.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setRepositoryUser(String repositoryUser);

	/**
	 * Set SAP Router string for connection to systems behind a SAP Router.
	 * 
	 * @param saprouter
	 *            - SAP Router string for connection to systems behind a SAP Router.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setSaprouter(String saprouter);

	/**
	 * Set path to library which provides SNC service
	 * 
	 * @param sncLibrary
	 *            - Path to library which provides SNC service
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setSncLibrary(String sncLibrary);

	/**
	 * Set the secure network connection (SNC) mode, 0 (off) or 1 (on).
	 * 
	 * @param sncMode
	 *            - Secure network connection (SNC) mode, 0 (off) or 1 (on).
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setSncMode(String sncMode);

	/**
	 * Set SNC name.
	 * 
	 * @param sncMyname
	 *            - SNC name.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setSncMyname(String sncMyname);

	/**
	 * Set SNC partner.
	 * 
	 * <p>e.g. p:CN=R3, O=XYZ-INC, C=EN
	 * 
	 * @param sncPartnername
	 *            - SNC partner.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setSncPartnername(String sncPartnername);

	/**
	 * Set SNC level of security, 1 to 9.
	 * 
	 * @param sncQop
	 *            - SNC level of security, 1 to 9.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setSncQop(String sncQop);

	/**
	 * Set system number of the SAP ABAP application server.
	 * 
	 * @param sysnr
	 *            - System number of the SAP ABAP application server.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setSysnr(String sysnr);

	/**
	 * Set host of external server.
	 * 
	 * @param tphost
	 *            - Host of external server.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setTphost(String tphost);

	/**
	 * Set program ID of external server.
	 * 
	 * @param tpname
	 *            - Program ID of external server.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setTpname(String tpname);

	/**
	 * Trace level of RFC trace
	 * 
	 * @param trace
	 *            - Trace level of RFC trace: Enable/disable RFC trace (0 or 1).
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setTrace(String trace);

	/**
	 * Set type of remote host.
	 * 
	 * @param type
	 *            - Type of remote host.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setType(String type);

	/**
	 * Sets the name of the user establishing a connection to an SAP instance.
	 * 
	 * <p>
	 * <b>NB:</b> The <em>user</em> and <em>userName<em> properties are the same property
	 * </p>
	 * 
	 * @param userName
	 *            - the name of the user establishing a connection to an SAP instance.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setUserName(String userName);

	/**
	 * Set logon user, logon parameter for password based authentication.
	 * 
	 * <p>
	 * <b>NB:</b> The <em>user</em> and <em>userName<em> properties are the same property
	 * </p>
	 * 
	 * @param user
	 * 			- the logon user
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setUser(String user);

	/**
	 * Set user identity which is used for logon to the ABAP AS.
	 * 
	 * @param userId
	 *            - User identity which is used for logon to the ABAP AS.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setUserId(String userId);

	/**
	 * Set whether to start an SAP GUI and associate with the connection. (0 - do not start [default], 1 start GUI, 2
	 * start GUI and hide if not used)
	 * 
	 * @param useSapgui
	 *            - do not start [default], 1 start GUI, 2 start GUI and hide if not used.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setUseSapgui(String useSapgui);

	/**
	 * Set the specified X509 certificate used for certificate based authentication
	 * 
	 * @param x509cert
	 *            - The specified X509 certificate used for certificate based authentication
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setX509cert(String x509cert);

} // ConnectionRequestInfo
