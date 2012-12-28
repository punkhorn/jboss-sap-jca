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
package org.jboss.jca.adapters.sap.cci.util;

import javax.resource.cci.Record;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.jboss.jca.adapters.sap.cci.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.jboss.jca.adapters.sap.cci.CciPackage
 * @generated
 */
public class CciAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CciPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CciAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CciPackage.eINSTANCE;
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
	protected CciSwitch<Adapter> modelSwitch =
		new CciSwitch<Adapter>() {
			@Override
			public Adapter caseRecordFactory(RecordFactory object) {
				return createRecordFactoryAdapter();
			}
			@Override
			public Adapter caseMappedRecord(MappedRecord object) {
				return createMappedRecordAdapter();
			}
			@Override
			public Adapter caseIndexedRecord(IndexedRecord object) {
				return createIndexedRecordAdapter();
			}
			@Override
			public Adapter caseInteractionSpec(InteractionSpec object) {
				return createInteractionSpecAdapter();
			}
			@Override
			public Adapter caseInteraction(Interaction object) {
				return createInteractionAdapter();
			}
			@Override
			public Adapter caseConnectionFactory(ConnectionFactory object) {
				return createConnectionFactoryAdapter();
			}
			@Override
			public Adapter caseConnection(Connection object) {
				return createConnectionAdapter();
			}
			@Override
			public Adapter caseConnectionSpec(ConnectionSpec object) {
				return createConnectionSpecAdapter();
			}
			@Override
			public Adapter caseConnectionMetaData(ConnectionMetaData object) {
				return createConnectionMetaDataAdapter();
			}
			@Override
			public Adapter caseLocalTransaction(LocalTransaction object) {
				return createLocalTransactionAdapter();
			}
			@Override
			public Adapter caseResourceAdapterMetaData(ResourceAdapterMetaData object) {
				return createResourceAdapterMetaDataAdapter();
			}
			@Override
			public Adapter caseCCIRecord(Record object) {
				return createCCIRecordAdapter();
			}
			@Override
			public Adapter caseCCIRecordFactory(javax.resource.cci.RecordFactory object) {
				return createCCIRecordFactoryAdapter();
			}
			@Override
			public Adapter caseCCIMappedRecord(javax.resource.cci.MappedRecord object) {
				return createCCIMappedRecordAdapter();
			}
			@Override
			public Adapter caseCCIIndexedRecord(javax.resource.cci.IndexedRecord object) {
				return createCCIIndexedRecordAdapter();
			}
			@Override
			public Adapter caseCCIInteractionSpec(javax.resource.cci.InteractionSpec object) {
				return createCCIInteractionSpecAdapter();
			}
			@Override
			public Adapter caseCCIInteraction(javax.resource.cci.Interaction object) {
				return createCCIInteractionAdapter();
			}
			@Override
			public Adapter caseCCIConnectionFactory(javax.resource.cci.ConnectionFactory object) {
				return createCCIConnectionFactoryAdapter();
			}
			@Override
			public Adapter caseCCIConnection(javax.resource.cci.Connection object) {
				return createCCIConnectionAdapter();
			}
			@Override
			public Adapter caseCCIConnectionSpec(javax.resource.cci.ConnectionSpec object) {
				return createCCIConnectionSpecAdapter();
			}
			@Override
			public Adapter caseCCIConnectionMetaData(javax.resource.cci.ConnectionMetaData object) {
				return createCCIConnectionMetaDataAdapter();
			}
			@Override
			public Adapter caseCCILocalTransaction(javax.resource.cci.LocalTransaction object) {
				return createCCILocalTransactionAdapter();
			}
			@Override
			public Adapter caseCCIResourceAdapterMetaData(javax.resource.cci.ResourceAdapterMetaData object) {
				return createCCIResourceAdapterMetaDataAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.cci.RecordFactory <em>Record Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.cci.RecordFactory
	 * @generated
	 */
	public Adapter createRecordFactoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.cci.MappedRecord <em>Mapped Record</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.cci.MappedRecord
	 * @generated
	 */
	public Adapter createMappedRecordAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.cci.IndexedRecord <em>Indexed Record</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.cci.IndexedRecord
	 * @generated
	 */
	public Adapter createIndexedRecordAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.cci.InteractionSpec <em>Interaction Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.cci.InteractionSpec
	 * @generated
	 */
	public Adapter createInteractionSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.cci.Interaction <em>Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.cci.Interaction
	 * @generated
	 */
	public Adapter createInteractionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.cci.ConnectionFactory <em>Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionFactory
	 * @generated
	 */
	public Adapter createConnectionFactoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.cci.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.cci.Connection
	 * @generated
	 */
	public Adapter createConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec <em>Connection Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec
	 * @generated
	 */
	public Adapter createConnectionSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.cci.ConnectionMetaData <em>Connection Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionMetaData
	 * @generated
	 */
	public Adapter createConnectionMetaDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.cci.LocalTransaction <em>Local Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.cci.LocalTransaction
	 * @generated
	 */
	public Adapter createLocalTransactionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.jboss.jca.adapters.sap.cci.ResourceAdapterMetaData <em>Resource Adapter Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.jboss.jca.adapters.sap.cci.ResourceAdapterMetaData
	 * @generated
	 */
	public Adapter createResourceAdapterMetaDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.resource.cci.Record <em>CCI Record</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.resource.cci.Record
	 * @generated
	 */
	public Adapter createCCIRecordAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.resource.cci.RecordFactory <em>CCI Record Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.resource.cci.RecordFactory
	 * @generated
	 */
	public Adapter createCCIRecordFactoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.resource.cci.MappedRecord <em>CCI Mapped Record</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.resource.cci.MappedRecord
	 * @generated
	 */
	public Adapter createCCIMappedRecordAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.resource.cci.IndexedRecord <em>CCI Indexed Record</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.resource.cci.IndexedRecord
	 * @generated
	 */
	public Adapter createCCIIndexedRecordAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.resource.cci.InteractionSpec <em>CCI Interaction Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.resource.cci.InteractionSpec
	 * @generated
	 */
	public Adapter createCCIInteractionSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.resource.cci.Interaction <em>CCI Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.resource.cci.Interaction
	 * @generated
	 */
	public Adapter createCCIInteractionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.resource.cci.ConnectionFactory <em>CCI Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.resource.cci.ConnectionFactory
	 * @generated
	 */
	public Adapter createCCIConnectionFactoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.resource.cci.Connection <em>CCI Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.resource.cci.Connection
	 * @generated
	 */
	public Adapter createCCIConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.resource.cci.ConnectionSpec <em>CCI Connection Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.resource.cci.ConnectionSpec
	 * @generated
	 */
	public Adapter createCCIConnectionSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.resource.cci.ConnectionMetaData <em>CCI Connection Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.resource.cci.ConnectionMetaData
	 * @generated
	 */
	public Adapter createCCIConnectionMetaDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.resource.cci.LocalTransaction <em>CCI Local Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.resource.cci.LocalTransaction
	 * @generated
	 */
	public Adapter createCCILocalTransactionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link javax.resource.cci.ResourceAdapterMetaData <em>CCI Resource Adapter Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see javax.resource.cci.ResourceAdapterMetaData
	 * @generated
	 */
	public Adapter createCCIResourceAdapterMetaDataAdapter() {
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

} //CciAdapterFactory
