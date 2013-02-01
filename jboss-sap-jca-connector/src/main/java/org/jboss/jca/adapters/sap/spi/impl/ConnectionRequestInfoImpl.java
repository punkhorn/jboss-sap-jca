/*
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
 */
package org.jboss.jca.adapters.sap.spi.impl;

import java.util.Properties;

import org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo;

/**
 * Implements the {@link ConnectionRequestInfo } interfaces for the JBoss SAP JCA Connector.
 * 
 * <p>Extends {@link Properties} to enable a destination configuration to be passed when creating a {@link JBossSAPConnection }.
 * 
 * @author William Collins
 * 
 * @version $Id: d48b3c763bb05448c96d0bc07bd6c895a4d229dc $
 */
public class ConnectionRequestInfoImpl extends Properties implements ConnectionRequestInfo {

	private static final long serialVersionUID = -2520873677208651216L;
	
	/**
	 * Creates an empty connection spec.
	 */
	public ConnectionRequestInfoImpl() {
	}

	/**
	 * Creates an empty connection spec with the specified defaults.
	 * 
	 * @param defaults - the defaults
	 */
	public ConnectionRequestInfoImpl(Properties defaults) {
		super(defaults);
	}
	
	/**
	 * Copies all properties from specified property set
	 * 
	 * @param properties - the property set.
	 */
	public void addProperties(Properties properties) {
		putAll(properties);
	}

	/**
	 * Returns the name of the user establishing a connection to an SAP instance.
	 * 
	 * @return The name of the user establishing a connection to an SAP instance.
	 */
	public String getUserName() {
		return getProperty(DestinationDataProviderImpl.JCO_USER);
	}

	/**
	 * Sets the name of the user establishing a connection to an SAP instance.
	 * 
	 * @param userName
	 *            - the name of the user establishing a connection to an SAP instance.
	 */
	public void setUserName(String userName) {
		setProperty(DestinationDataProviderImpl.JCO_USER, userName);
	}

	/**
	 * Returns the password for the user establishing a connection
	 * 
	 * @return The password for the user establishing a connection
	 */
	public String getPassword() {
		return getProperty(DestinationDataProviderImpl.JCO_PASSWD);
	}

	/**
	 * Sets the password for the user establishing a connection
	 * 
	 * @param password
	 *            - the password for the user establishing a connection
	 */
	public void setPassword(String password) {
		setProperty(DestinationDataProviderImpl.JCO_PASSWD, password);
	}

	/**
	 * Indicates whether the Managed Connection will ping the connected SAP instance when created, <code>true</code>, or not, <code>false</code>.
	 * Default is <code>false</code>.
	 * 
	 * @return Whether the Managed Connection will ping the connected SAP instance when created.
	 */
	public String getPingOnCreate() {
		return getProperty(ConnectionRequestInfoImpl.JSJC_PING_ON_CREATE, "false");
	}

	/**
	 * Sets whether the Managed Connection will ping the connected SAP instance when created, <code>true</code>, or not, <code>false</code>.
	 * 
	 * @param pingOnCreate - whether the Managed Connection will ping the connected SAP instance when created, <code>true</code>, or not, <code>false</code>.
	 */
	public void setPingOnCreate(String pingOnCreate) {
		setProperty(ConnectionRequestInfoImpl.JSJC_PING_ON_CREATE, pingOnCreate);
	}

}
