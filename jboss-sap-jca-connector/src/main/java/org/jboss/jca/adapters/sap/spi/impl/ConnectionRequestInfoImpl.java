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

import java.util.Properties;

import java.util.Set;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo;

import com.sap.conn.jco.ext.DestinationDataProvider;

/**
 * <!-- begin-user-doc -->
 * Implements the {@link ConnectionRequestInfo } interfaces for the JBoss SAP JCA Connector.
 * 
 * <p>Extends {@link Properties} to enable a destination configuration to be passed when creating a {@link JBossSAPConnection }.
 * 
 * @author William Collins
 * 
 * @version $Id: d48b3c763bb05448c96d0bc07bd6c895a4d229dc $
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.spi.impl.ConnectionRequestInfoImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionRequestInfoImpl extends EObjectImpl implements ConnectionRequestInfo {

	/**
	 * The default value of the '{@link #getProperties() <em>Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected static final Properties PROPERTIES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * Stores connection request properties
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected Properties properties = PROPERTIES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * Creates an empty connection request info
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ConnectionRequestInfoImpl() {
		super();
		properties = new Properties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * Creates an empty connection request info with the specified defaults
	 * 
	 * @param defaults - the set of default connection properties
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ConnectionRequestInfoImpl(ConnectionRequestInfoImpl defaults) {
		super();
		properties = new Properties(defaults.properties);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpiPackageImpl.Literals.CONNECTION_REQUEST_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Properties getProperties() {
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperties(Properties newProperties) {
		Properties oldProperties = properties;
		properties = newProperties;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpiPackageImpl.CONNECTION_REQUEST_INFO__PROPERTIES, oldProperties, properties));
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
		return properties.getProperty(JSJC_PING_ON_CREATE, "false");
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
		return properties.getProperty(DestinationDataProvider.JCO_POOL_CAPACITY, "1");
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
		return properties.getProperty(DestinationDataProvider.JCO_R3NAME);
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
		return properties.getProperty(DestinationDataProvider.JCO_REPOSITORY_DEST);
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
		return properties.getProperty(DestinationDataProvider.JCO_REPOSITORY_PASSWD);
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
		return properties.getProperty(DestinationDataProvider.JCO_REPOSITORY_ROUNDTRIP_OPTIMIZATION);
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
		return properties.getProperty(DestinationDataProvider.JCO_REPOSITORY_SNC);
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
		return properties.getProperty(DestinationDataProvider.JCO_REPOSITORY_USER);
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
		return properties.getProperty(DestinationDataProvider.JCO_SAPROUTER);
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
		return properties.getProperty(DestinationDataProvider.JCO_SNC_LIBRARY);
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
		return properties.getProperty(DestinationDataProvider.JCO_SNC_MODE);
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
		return properties.getProperty(DestinationDataProvider.JCO_SNC_MYNAME);
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
		return properties.getProperty(DestinationDataProvider.JCO_SNC_PARTNERNAME);
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
		return properties.getProperty(DestinationDataProvider.JCO_SNC_QOP);
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
		return properties.getProperty(DestinationDataProvider.JCO_SYSNR);
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
		return properties.getProperty(DestinationDataProvider.JCO_TPHOST);
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
		return properties.getProperty(DestinationDataProvider.JCO_TPNAME);
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
		return properties.getProperty(DestinationDataProvider.JCO_TRACE);
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
		return properties.getProperty(DestinationDataProvider.JCO_TYPE);
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
		return properties.getProperty(DestinationDataProvider.JCO_USER);
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
		return properties.getProperty(DestinationDataProvider.JCO_USER);
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
		return properties.getProperty(DestinationDataProvider.JCO_USER_ID);
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
		return properties.getProperty(DestinationDataProvider.JCO_USE_SAPGUI);
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
		return properties.getProperty(DestinationDataProvider.JCO_X509CERT);
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
		properties.put(DestinationDataProvider.JCO_ALIAS_USER, user);
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
		properties.put(DestinationDataProvider.JCO_ASHOST, ashost);
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
		properties.put(DestinationDataProvider.JCO_AUTH_TYPE, authType);
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
		properties.put(DestinationDataProvider.JCO_CLIENT, client);
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
		properties.put(DestinationDataProvider.JCO_CODEPAGE, codepage);
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
		properties.put(DestinationDataProvider.JCO_CPIC_TRACE, cpicTrace);
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
		properties.put(DestinationDataProvider.JCO_DENY_INITIAL_PASSWORD, denyInitialPassword);
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
		properties.put(DestinationDataProvider.JCO_EXPIRATION_PERIOD, expirationPeriod);
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
		properties.put(DestinationDataProvider.JCO_EXPIRATION_TIME, expirationTime);
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
		properties.put(DestinationDataProvider.JCO_GETSSO2, getsso2);
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
		properties.put(DestinationDataProvider.JCO_GROUP, group);
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
		properties.put(DestinationDataProvider.JCO_GWHOST, gwhost);
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
		properties.put(DestinationDataProvider.JCO_GWSERV, gwserv);
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
		properties.put(DestinationDataProvider.JCO_LANG, lang);
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
		properties.put(DestinationDataProvider.JCO_LCHECK, lcheck);
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
		properties.put(DestinationDataProvider.JCO_MAX_GET_TIME, maxGetTime);
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
		properties.put(DestinationDataProvider.JCO_MSHOST, mshost);
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
		properties.put(DestinationDataProvider.JCO_MSSERV, msserv);
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
		properties.put(DestinationDataProvider.JCO_MYSAPSSO2, mysapsso2);
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
		properties.put(DestinationDataProvider.JCO_PASSWD, password);
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
		properties.put(DestinationDataProvider.JCO_PASSWD, passwd);
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
		properties.put(DestinationDataProvider.JCO_PCS, pcs);
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
		properties.put(DestinationDataProvider.JCO_PEAK_LIMIT, peakLimit);
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
		properties.put(ConnectionRequestInfoImpl.JSJC_PING_ON_CREATE, pingOnCreate);
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
		properties.put(DestinationDataProvider.JCO_POOL_CAPACITY, poolCapacity);
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
		properties.put(DestinationDataProvider.JCO_R3NAME, r3name);
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
		properties.put(DestinationDataProvider.JCO_REPOSITORY_DEST, repositoryDest);
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
		properties.put(DestinationDataProvider.JCO_REPOSITORY_PASSWD, repositoryPasswd);
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
		properties.put(DestinationDataProvider.JCO_REPOSITORY_ROUNDTRIP_OPTIMIZATION, repositoryRoundtripOptimization);
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
		properties.put(DestinationDataProvider.JCO_REPOSITORY_SNC, repositorySnc);
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
		properties.put(DestinationDataProvider.JCO_REPOSITORY_USER, repositoryUser);
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
		properties.put(DestinationDataProvider.JCO_SAPROUTER, saprouter);
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
		properties.put(DestinationDataProvider.JCO_SNC_LIBRARY, sncLibrary);
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
		properties.put(DestinationDataProvider.JCO_SNC_MODE, sncMode);
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
		properties.put(DestinationDataProvider.JCO_SNC_MYNAME, sncMyname);
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
		properties.put(DestinationDataProvider.JCO_SNC_PARTNERNAME, sncPartnername);
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
		properties.put(DestinationDataProvider.JCO_SNC_QOP, sncQop);
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
		properties.put(DestinationDataProvider.JCO_SYSNR, sysnr);
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
		properties.put(DestinationDataProvider.JCO_TPHOST, tphost);
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
		properties.put(DestinationDataProvider.JCO_TPNAME, tpname);
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
		properties.put(DestinationDataProvider.JCO_TRACE, trace);
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
		properties.put(DestinationDataProvider.JCO_TYPE, type);
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
		properties.put(DestinationDataProvider.JCO_USER, userName);
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
		properties.put(DestinationDataProvider.JCO_USER, user);
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
		properties.put(DestinationDataProvider.JCO_USER_ID, userId);
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
		properties.put(DestinationDataProvider.JCO_USE_SAPGUI, useSapgui);
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
		properties.put(DestinationDataProvider.JCO_X509CERT, x509cert);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean equals(Object other) {
		if (other instanceof ConnectionRequestInfoImpl) {
			return ((ConnectionRequestInfoImpl)other).properties.equals(properties);
		}
		return false; 
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int hashCode() {
		return properties.hashCode();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Set<String> stringPropertyNames() {
		return properties.stringPropertyNames();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object setProperty(String key, String value) {
		return properties.setProperty(key, value);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addProperties(Properties properties) {
		properties.putAll(properties);
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
		return properties.getProperty(DestinationDataProvider.JCO_ALIAS_USER);
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
		return properties.getProperty(DestinationDataProvider.JCO_ASHOST);
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
		return properties.getProperty(DestinationDataProvider.JCO_AUTH_TYPE, DestinationDataProvider.JCO_AUTH_TYPE_CONFIGURED_USER);
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
		return properties.getProperty(DestinationDataProvider.JCO_CLIENT);
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
		return properties.getProperty(DestinationDataProvider.JCO_CODEPAGE);
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
		return properties.getProperty(DestinationDataProvider.JCO_CPIC_TRACE);
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
		return properties.getProperty(DestinationDataProvider.JCO_DENY_INITIAL_PASSWORD, "0");
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
		return properties.getProperty(DestinationDataProvider.JCO_EXPIRATION_PERIOD);
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
		return properties.getProperty(DestinationDataProvider.JCO_EXPIRATION_TIME);
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
		return properties.getProperty(DestinationDataProvider.JCO_GETSSO2);
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
		return properties.getProperty(DestinationDataProvider.JCO_GROUP);
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
		return properties.getProperty(DestinationDataProvider.JCO_GWHOST);
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
		return properties.getProperty(DestinationDataProvider.JCO_GWSERV);
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
		return properties.getProperty(DestinationDataProvider.JCO_LANG);
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
		return properties.getProperty(DestinationDataProvider.JCO_LCHECK);
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
		return properties.getProperty(DestinationDataProvider.JCO_MAX_GET_TIME);
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
		return properties.getProperty(DestinationDataProvider.JCO_MSHOST);
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
		return properties.getProperty(DestinationDataProvider.JCO_MSSERV);
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
		return properties.getProperty(DestinationDataProvider.JCO_MYSAPSSO2);
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
		return properties.getProperty(DestinationDataProvider.JCO_PASSWD);
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
		return properties.getProperty(DestinationDataProvider.JCO_PASSWD);
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
		return properties.getProperty(DestinationDataProvider.JCO_PCS);
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
		return properties.getProperty(DestinationDataProvider.JCO_PEAK_LIMIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SpiPackageImpl.CONNECTION_REQUEST_INFO__PROPERTIES:
				return getProperties();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SpiPackageImpl.CONNECTION_REQUEST_INFO__PROPERTIES:
				setProperties((Properties)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SpiPackageImpl.CONNECTION_REQUEST_INFO__PROPERTIES:
				setProperties(PROPERTIES_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SpiPackageImpl.CONNECTION_REQUEST_INFO__PROPERTIES:
				return PROPERTIES_EDEFAULT == null ? properties != null : !PROPERTIES_EDEFAULT.equals(properties);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (properties: ");
		result.append(properties);
		result.append(')');
		return result.toString();
	}

} //ConnectionRequestInfoImpl
