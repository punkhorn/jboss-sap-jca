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
package org.jboss.jca.adapters.sap.cci;

import java.util.Properties;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;

/**
 * Implements the {@link Connection } interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 * 
 */
public interface JBossSAPConnection extends Connection {

	/**
	 * Begins stateful call sequence for interactions made through this connection.
	 * 
	 * @throws ResourceException
	 */
	public abstract void begin() throws ResourceException;

	/**
	 * Ends stateful call sequence for interactions through this connection
	 * 
	 * @throws ResourceException
	 */
	public abstract void end() throws ResourceException;

	/**
	 * Returns <code>true</code> if connection is closed; <code>false</code> otherwise
	 * 
	 * @return <code>true</code> if connection is closed; <code>false</code> otherwise
	 */
	public abstract boolean isClosed();

	/**
	 * Returns <code>true</code> if stateful call sequence was started and is not finished; <code>false</code> otherwise
	 * 
	 * @return <code>true</code> if stateful call sequence was started and is not finished; <code>false</code> otherwise
	 */
	public abstract boolean isStateful();

	/**
	 * Return the configuration properties of connection
	 * 
	 * @return the configuration properties of connection
	 */
	public abstract Properties getProperties();

	/**
	 * Executes a connection test for this connection
	 * 
	 * @throws ResourceException
	 */
	public void ping() throws ResourceException;
}