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
package org.jboss.jca.adapters.sap;

import java.util.Properties;

import javax.resource.cci.ConnectionSpec;
import javax.resource.spi.ConnectionRequestInfo;

import com.sap.conn.jco.ext.DestinationDataProvider;

/**
 * JBossSAPConnectionSpec - is used by an application component to pass connection request-specific properties to the ConnectionFactory. getConnection method.  *
 * @version $Revision: $
 */
public class JBossSAPConnectionSpec extends Properties implements ConnectionSpec, ConnectionRequestInfo
{

	private static final long serialVersionUID = -2520873677208651216L;
	
	public static final String SAP_DESTINATION_NAME = "org.jboss.jca.adapters.sap.destination_name";
	
	public JBossSAPConnectionSpec() {
	}
	
	
	public JBossSAPConnectionSpec(Properties defaults) {
		super(defaults);
	}
	
	
	public void addProperties(Properties connectionRequestInfo) {
		putAll(connectionRequestInfo);
	}
	
	
	/**
	 * Returns the destination name of the connection to an SAP instance.
	 * @return The destination name of the connection to an SAP instance.
	 */
	public String getDestinationName() {
		return getProperty(SAP_DESTINATION_NAME);
	}

	public void setDestinationName(String destinationName) {
		setProperty(SAP_DESTINATION_NAME, destinationName);
	}

	/**
	 * Returns the name of the user establishing a connection to an SAP instance.
	 * @return The name of the user establishing a connection to an SAP instance.
	 */
	public String getUserName() {
		return getProperty(DestinationDataProvider.JCO_USER);
	}

	/**
	 * Sets the name of the user establishing a connection to an SAP instance.
	 * @param userName - the name of the user establishing a connection to an SAP instance.
	 */
	public void setUserName(String userName) {
		setProperty(DestinationDataProvider.JCO_USER, userName);
	}

	/**
	 * Returns the password for the user establishing a connection
	 * @return The password for the user establishing a connection
	 */
	public String getPassword() {
		return getProperty(DestinationDataProvider.JCO_PASSWD);
	}

	/**
	 * Sets the password for the user establishing a connection
	 * @param password - the password for the user establishing a connection
	 */
	public void setPassword(String password) {
		setProperty(DestinationDataProvider.JCO_PASSWD, password);
	}

}
