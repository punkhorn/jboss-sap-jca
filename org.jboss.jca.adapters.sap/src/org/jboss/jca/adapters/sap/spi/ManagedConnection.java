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

import java.io.PrintWriter;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.DissociatableManagedConnection;
import javax.resource.spi.LocalTransaction;
import javax.resource.spi.ManagedConnectionMetaData;
import javax.security.auth.Subject;
import javax.transaction.xa.XAResource;

/**
 * Specializes the {@link javax.resource.spi.ManagedConnection} interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 *
 *
 */
public interface ManagedConnection extends javax.resource.spi.ManagedConnection, DissociatableManagedConnection {
	/**
	 * {@inheritDoc}
	 */
	boolean equals(Object other);

	/**
	 * {@inheritDoc}
	 */
	int hashCode();

	/**
	 * {@inheritDoc}
	 */
	Object getConnection(Subject subject, ConnectionRequestInfo connectionRequestInfo) throws ResourceException;

	/**
	 * {@inheritDoc}
	 */
	void addConnectionEventListener(ConnectionEventListener listener);

	/**
	 * {@inheritDoc}
	 */
	void removeConnectionEventListener(ConnectionEventListener listener);

	/**
	 * {@inheritDoc}
	 */
	LocalTransaction getLocalTransaction() throws ResourceException;

	/**
	 * {@inheritDoc}
	 */
	XAResource getXAResource() throws ResourceException;

	/**
	 * {@inheritDoc}
	 */
	ManagedConnectionMetaData getMetaData() throws ResourceException;

	/**
	 * {@inheritDoc}
	 */
	PrintWriter getLogWriter() throws ResourceException;

	/**
	 * {@inheritDoc}
	 */
	void setLogWriter(PrintWriter out) throws ResourceException;

	/**
	 * {@inheritDoc}
	 */
	void associateConnection(Object connection) throws ResourceException;

	/**
	 * {@inheritDoc}
	 */
	void dissociateConnections() throws ResourceException;

	/**
	 * {@inheritDoc}
	 */
	void cleanup() throws ResourceException;

	/**
	 * {@inheritDoc}
	 */
	void destroy() throws ResourceException;

	/**
	 * <p><b>NB:</b> For internal use only.
	 * 
	 * @throws ResourceException If connection is destroyed.
	 */
	void beginStatefulSession() throws ResourceException;

	/**
	 * <p><b>NB:</b> For internal use only.
	 * 
	 * @throws ResourceException If connection is destroyed or has outstanding transaction or if error occurs in underlying JCo 
	 * runtime. 
	 */
	void endStatefulSession() throws ResourceException;

	/**
	 * <p><b>NB:</b> For internal use only.
	 * 
	 * @throws ResourceException if underlying JCo runtime throws exception when pinging.
	 */
	void ping() throws ResourceException;

}
