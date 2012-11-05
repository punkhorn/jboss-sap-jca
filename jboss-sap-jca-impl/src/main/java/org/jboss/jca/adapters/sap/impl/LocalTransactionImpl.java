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
package org.jboss.jca.adapters.sap.impl;

import javax.resource.ResourceException;

/**
 * Implements the {@link javax.resource.cci.LocalTransaction} and {@link javax.resource.spi.LocalTransaction} interfaces 
 * for the JBoss SAP JCA connector.
 * 
 * @author William Collins
 *
 * @version $Id: dc2bc9e0ae954cc169d2491f4c6000ec0db62d6e $
 */
public class LocalTransactionImpl implements javax.resource.cci.LocalTransaction, javax.resource.spi.LocalTransaction {
	
	/**
	 * The managed connection whose transactions are managed by this object.
	 */
	private final ManagedConnectionImpl managedConnection;
	
	/**
	 * Create a {@link LocalTransactionImpl} object managing the transactions of the given {@link ManagedConnectionImpl}.
	 * 
	 * @param managedConnection - the manage connection whose local transactions this object will manage.
	 */
	LocalTransactionImpl(ManagedConnectionImpl managedConnection) {
		this.managedConnection = managedConnection;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.LocalTransaction#begin()
	 */
	@Override
	public void begin() throws ResourceException {
		managedConnection.beginLocalTransaction();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.LocalTransaction#commit()
	 */
	@Override
	public void commit() throws ResourceException {
		managedConnection.commitLocalTransaction();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.LocalTransaction#rollback()
	 */
	@Override
	public void rollback() throws ResourceException {
		managedConnection.rollbackLocalTransaction();
	}

}
