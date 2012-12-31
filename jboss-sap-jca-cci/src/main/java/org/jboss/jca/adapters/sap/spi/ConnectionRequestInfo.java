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
	 * Name of Connection Spec/Connection Request Info parameter specifying whether Managed Connection will ping the connected SAP instance when created. Default is <code>false</code>.
	 */
	public static final String JSJC_PING_ON_CREATE = "jsjc.mc.poc";

	/**
	 * Sets the value of the property identified by <code>key</code>  to <code>value</code> in this connection request info.
	 *  
	 * @param key the key to be placed into this connection request info.
	 * @param value the value corresponding to <tt>key</tt>.
	 * @return the previous value of the specified key in this connection request info, or <code>null</code> if it did not have one.
	 */
	public Object setProperty(String key, String value);
	
	/**
	 * Gets the value of the property identified by <code>key</code> in this connection request info.
	 *  
	 * @param key the property key.
	 * @return the value in this connection request info with the specified key value.
	 */
	public String getProperty(String key);
	
	/**
	 * Copies all properties from specified property set into this connection request info.
	 * 
	 * @param properties - the property set.
	 */
	public void addProperties(Properties properties);
	
	/**
	 * Returns the name of the user establishing a connection to an SAP instance.
	 * 
	 * @return The name of the user establishing a connection to an SAP instance.
	 */
	public String getUserName();
	
	/**
	 * Sets the name of the user establishing a connection to an SAP instance.
	 * 
	 * @param userName
	 *            - the name of the user establishing a connection to an SAP instance.
	 */
	public void setUserName(String userName);
	
	/**
	 * Returns the password for the user establishing a connection
	 * 
	 * @return The password for the user establishing a connection
	 */
	public String getPassword();
	
	/**
	 * Sets the password for the user establishing a connection
	 * 
	 * @param password
	 *            - the password for the user establishing a connection
	 */
	public void setPassword(String password);
	
	/**
	 * Indicates whether the Managed Connection will ping the connected SAP instance when created, <code>true</code>, or not, <code>false</code>.
	 * Default is <code>false</code>.
	 * 
	 * @return Whether the Managed Connection will ping the connected SAP instance when created.
	 */
	public String getPingOnCreate();
	
	/**
	 * Sets whether the Managed Connection will ping the connected SAP instance when created, <code>true</code>, or not, <code>false</code>.
	 * 
	 * @param pingOnCreate - whether the Managed Connection will ping the connected SAP instance when created, <code>true</code>, or not, <code>false</code>.
	 */
	public void setPingOnCreate(String pingOnCreate);

}
