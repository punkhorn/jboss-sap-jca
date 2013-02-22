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
import javax.resource.spi.ManagedConnectionMetaData;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.jboss.jca.adapters.sap.cci.ConnectionMetaData;

/**
 * <!-- begin-user-doc -->
 * Implements the {@link ConnectionMetaData } interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ConnectionMetaDataImpl extends EObjectImpl implements ConnectionMetaData {
	
	/**
	 * The {@link ManagedConnectionMetaData} instance associated with this object.
	 * 
	 * @generated NOT
	 */
	private ManagedConnectionMetaData managedConnectionMetaData;
	
	/**
	 * <!-- begin-user-doc -->
	 * Creates a {@link ConnectionMetaData} instance.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionMetaDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * Creates a {@link ConnectionMetaData} instance associated with the given {@link ManagedConnectionMetaData} instance.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ConnectionMetaDataImpl(ManagedConnectionMetaData managedConnectionMetaData) {
		super();
		this.managedConnectionMetaData = managedConnectionMetaData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CciPackageImpl.Literals.CONNECTION_META_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getEISProductName() throws ResourceException {
		return managedConnectionMetaData.getEISProductName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getEISProductVersion() throws ResourceException {
		return managedConnectionMetaData.getEISProductVersion();
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getUserName() throws ResourceException {
		return managedConnectionMetaData.getUserName();
	}

} //ConnectionMetaDataImpl
