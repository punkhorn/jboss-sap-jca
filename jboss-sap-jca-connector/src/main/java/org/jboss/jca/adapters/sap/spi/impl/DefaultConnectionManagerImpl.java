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

import javax.resource.ResourceException;

import javax.resource.cci.Connection;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.jboss.jca.adapters.sap.spi.DefaultConnectionManager;

/**
 * <!-- begin-user-doc -->
 * Default {@link ConnectionManager} implementation for non-managed environments.
 * 
 * @author William Collins
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DefaultConnectionManagerImpl extends EObjectImpl implements DefaultConnectionManager {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8972667797879442158L;

	/**
	 * <!-- begin-user-doc -->
	 * Create an instance of a {@link DefaultConnectionManager}.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefaultConnectionManagerImpl() {
		super();
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
		return SpiPackageImpl.Literals.DEFAULT_CONNECTION_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object allocateConnection(ManagedConnectionFactory managedConnectionFactory, ConnectionRequestInfo connectionRequestInfo) throws ResourceException {
		ManagedConnection managecConnection = managedConnectionFactory.createManagedConnection(null, connectionRequestInfo);
		Connection connection = (Connection) managecConnection.getConnection(null, null);
		return connection;
	}

} //DefaultConnectionManagerImpl
