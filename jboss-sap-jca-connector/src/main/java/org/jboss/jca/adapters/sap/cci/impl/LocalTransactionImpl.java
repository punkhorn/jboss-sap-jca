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
package org.jboss.jca.adapters.sap.cci.impl;

import javax.resource.ResourceException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.jboss.jca.adapters.sap.cci.LocalTransaction;

/**
 * <!-- begin-user-doc -->
 * Implements the {@link LocalTransaction } interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class LocalTransactionImpl extends EObjectImpl implements LocalTransaction {
	
	/**
	 * The {@link javax.resource.spi.LocalTransaction} associated with this transaction.
	 * 
	 * @generated NOT
	 */
	private javax.resource.spi.LocalTransaction localTransaction;
	
	/**
	 * <!-- begin-user-doc -->
	 * Create a {@link LocalTransaction} instance.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalTransactionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * Create a {@link LocalTransaction} instance associated with the given local transaction.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LocalTransactionImpl( javax.resource.spi.LocalTransaction localTransaction) {
		super();
		this.localTransaction = localTransaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CciPackageImpl.Literals.LOCAL_TRANSACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void begin() throws ResourceException {
		localTransaction.begin();
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void commit() throws ResourceException {
		localTransaction.commit();
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void rollback() throws ResourceException {
		localTransaction.rollback();
	}

} //LocalTransactionImpl
