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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.jboss.jca.adapters.sap.spi.LocalTransaction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Transaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class LocalTransactionImpl extends EObjectImpl implements LocalTransaction {

	/**
	 * The managed connection whose transactions are managed by this object.
	 * @generated NOT
	 */
	private ManagedConnectionImpl managedConnection;
	
	/**
	 * <!-- begin-user-doc -->
	 * Create an empty instance of a {@link LocalTransaction}.
	 * 
	 * <p> Note this should only be used for serialization
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalTransactionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * Create an instance of a {@link LocalTransaction}.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected LocalTransactionImpl(ManagedConnectionImpl managedConnection) {
		super();
		this.managedConnection = managedConnection;
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
		return SpiPackageImpl.Literals.LOCAL_TRANSACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void begin() throws ResourceException {
		managedConnection.beginLocalTransaction();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void commit() throws ResourceException {
		managedConnection.commitLocalTransaction();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void rollback() throws ResourceException {
		managedConnection.rollbackLocalTransaction();
	}

} //LocalTransactionImpl
