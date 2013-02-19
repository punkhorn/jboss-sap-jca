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
package org.jboss.jca.adapters.sap.spi.util;

import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.DissociatableManagedConnection;
import javax.resource.spi.LocalTransaction;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.resource.spi.ManagedConnectionMetaData;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterAssociation;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.jboss.jca.adapters.sap.spi.*;

import org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl
 * @generated
 */
public class SpiAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SpiPackageImpl modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpiAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SpiPackageImpl.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpiSwitch<Adapter> modelSwitch =
		new SpiSwitch<Adapter>() {
			@Override
			public Adapter caseSPIConnectionRequestInfo(ConnectionRequestInfo object) {
				return createSPIConnectionRequestInfoAdapter();
			}
			@Override
			public Adapter caseSPIConnectionManager(ConnectionManager object) {
				return createSPIConnectionManagerAdapter();
			}
			@Override
			public Adapter caseSPILocalTransaction(LocalTransaction object) {
				return createSPILocalTransactionAdapter();
			}
			@Override
			public Adapter caseSPIManagedConnectionFactory(ManagedConnectionFactory object) {
				return createSPIManagedConnectionFactoryAdapter();
			}
			@Override
			public Adapter caseSPIResourceAdapterAssociation(ResourceAdapterAssociation object) {
				return createSPIResourceAdapterAssociationAdapter();
			}
			@Override
			public Adapter caseSPIManagedConnection(ManagedConnection object) {
				return createSPIManagedConnectionAdapter();
			}
			@Override
			public Adapter caseSPIDissociatableManagedConnection(DissociatableManagedConnection object) {
				return createSPIDissociatableManagedConnectionAdapter();
			}
			@Override
			public Adapter caseSPIManagedConnectionMetaData(ManagedConnectionMetaData object) {
				return createSPIManagedConnectionMetaDataAdapter();
			}
			@Override
			public Adapter caseSPIResourceAdapter(ResourceAdapter object) {
				return createSPIResourceAdapterAdapter();
			}
			@Override
			public Adapter caseConnectionRequestInfo(org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo object) {
				return createConnectionRequestInfoAdapter();
			}
			@Override
			public Adapter caseDefaultConnectionManager(DefaultConnectionManager object) {
				return createDefaultConnectionManagerAdapter();
			}
			@Override
			public Adapter caseLocalTransaction(org.jboss.jca.adapters.sap.spi.LocalTransaction object) {
				return createLocalTransactionAdapter();
			}
			@Override
			public Adapter caseManagedConnectionFactory(org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory object) {
				return createManagedConnectionFactoryAdapter();
			}
			@Override
			public Adapter caseManagedConnection(org.jboss.jca.adapters.sap.spi.ManagedConnection object) {
				return createManagedConnectionAdapter();
			}
			@Override
			public Adapter caseManagedConnectionMetaData(org.jboss.jca.adapters.sap.spi.ManagedConnectionMetaData object) {
				return createManagedConnectionMetaDataAdapter();
			}
			@Override
			public Adapter caseNonManagedEnvironmentAdmin(NonManagedEnvironmentAdmin object) {
				return createNonManagedEnvironmentAdminAdapter();
			}
			@Override
			public Adapter caseResourceAdapter(org.jboss.jca.adapters.sap.spi.ResourceAdapter object) {
				return createResourceAdapterAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link javax.resource.spi.ConnectionRequestInfo <em>SPI Connection Request Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.resource.spi.ConnectionRequestInfo
	 * @generated
	 */
	public Adapter createSPIConnectionRequestInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.resource.spi.ConnectionManager <em>SPI Connection Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.resource.spi.ConnectionManager
	 * @generated
	 */
	public Adapter createSPIConnectionManagerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.resource.spi.LocalTransaction <em>SPI Local Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.resource.spi.LocalTransaction
	 * @generated
	 */
	public Adapter createSPILocalTransactionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.resource.spi.ManagedConnectionFactory <em>SPI Managed Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.resource.spi.ManagedConnectionFactory
	 * @generated
	 */
	public Adapter createSPIManagedConnectionFactoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.resource.spi.ResourceAdapterAssociation <em>SPI Resource Adapter Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.resource.spi.ResourceAdapterAssociation
	 * @generated
	 */
	public Adapter createSPIResourceAdapterAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.resource.spi.ManagedConnection <em>SPI Managed Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.resource.spi.ManagedConnection
	 * @generated
	 */
	public Adapter createSPIManagedConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.resource.spi.DissociatableManagedConnection <em>SPI Dissociatable Managed Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.resource.spi.DissociatableManagedConnection
	 * @generated
	 */
	public Adapter createSPIDissociatableManagedConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.resource.spi.ManagedConnectionMetaData <em>SPI Managed Connection Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.resource.spi.ManagedConnectionMetaData
	 * @generated
	 */
	public Adapter createSPIManagedConnectionMetaDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.resource.spi.ResourceAdapter <em>SPI Resource Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.resource.spi.ResourceAdapter
	 * @generated
	 */
	public Adapter createSPIResourceAdapterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo <em>Connection Request Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo
	 * @generated
	 */
	public Adapter createConnectionRequestInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.spi.DefaultConnectionManager <em>Default Connection Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.spi.DefaultConnectionManager
	 * @generated
	 */
	public Adapter createDefaultConnectionManagerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.spi.LocalTransaction <em>Local Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.spi.LocalTransaction
	 * @generated
	 */
	public Adapter createLocalTransactionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory <em>Managed Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory
	 * @generated
	 */
	public Adapter createManagedConnectionFactoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.spi.ManagedConnection <em>Managed Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.spi.ManagedConnection
	 * @generated
	 */
	public Adapter createManagedConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.spi.ManagedConnectionMetaData <em>Managed Connection Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.spi.ManagedConnectionMetaData
	 * @generated
	 */
	public Adapter createManagedConnectionMetaDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.spi.NonManagedEnvironmentAdmin <em>Non Managed Environment Admin</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.spi.NonManagedEnvironmentAdmin
	 * @generated
	 */
	public Adapter createNonManagedEnvironmentAdminAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.spi.ResourceAdapter <em>Resource Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.spi.ResourceAdapter
	 * @generated
	 */
	public Adapter createResourceAdapterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SpiAdapterFactory
