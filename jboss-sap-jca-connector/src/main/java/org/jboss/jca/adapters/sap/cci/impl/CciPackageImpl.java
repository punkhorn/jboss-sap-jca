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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.naming.Reference;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.ResourceWarning;
import javax.resource.cci.ResultSetInfo;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource.Internal;
import org.jboss.jca.adapters.sap.cci.CciFactory;
import org.jboss.jca.adapters.sap.cci.Connection;
import org.jboss.jca.adapters.sap.cci.ConnectionFactory;
import org.jboss.jca.adapters.sap.cci.ConnectionMetaData;
import org.jboss.jca.adapters.sap.cci.ConnectionSpec;
import org.jboss.jca.adapters.sap.cci.IndexedRecord;
import org.jboss.jca.adapters.sap.cci.Interaction;
import org.jboss.jca.adapters.sap.cci.InteractionSpec;
import org.jboss.jca.adapters.sap.cci.LocalTransaction;
import org.jboss.jca.adapters.sap.cci.MappedRecord;
import org.jboss.jca.adapters.sap.cci.RecordFactory;
import org.jboss.jca.adapters.sap.cci.ResourceAdapterMetaData;
import org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @see org.jboss.jca.adapters.sap.cci.CciFactory
 * @model kind="package"
 * @generated
 */
public class CciPackageImpl extends EPackageImpl {
	
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "cci";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "http://sap.adapters.jca.jboss.org/cci";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "cci";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final CciPackageImpl eINSTANCE = org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl.init();

	/**
	 * The meta object id for the '{@link javax.resource.cci.RecordFactory <em>CCI Record Factory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.RecordFactory
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIRecordFactory()
	 * @generated
	 */
	public static final int CCI_RECORD_FACTORY = 12;

	/**
	 * The number of structural features of the '<em>CCI Record Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CCI_RECORD_FACTORY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.cci.impl.RecordFactoryImpl <em>Record Factory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.RecordFactoryImpl
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getRecordFactory()
	 * @generated
	 */
	public static final int RECORD_FACTORY = 0;

	/**
	 * The number of structural features of the '<em>Record Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RECORD_FACTORY_FEATURE_COUNT = CCI_RECORD_FACTORY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link javax.resource.cci.MappedRecord <em>CCI Mapped Record</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.MappedRecord
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIMappedRecord()
	 * @generated
	 */
	public static final int CCI_MAPPED_RECORD = 13;

	/**
	 * The number of structural features of the '<em>CCI Mapped Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CCI_MAPPED_RECORD_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.cci.impl.MappedRecordImpl <em>Mapped Record</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.MappedRecordImpl
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getMappedRecord()
	 * @generated
	 */
	public static final int MAPPED_RECORD = 1;

	/**
	 * The feature id for the '<em><b>Record Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAPPED_RECORD__RECORD_NAME = CCI_MAPPED_RECORD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Record Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAPPED_RECORD__RECORD_SHORT_DESCRIPTION = CCI_MAPPED_RECORD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapped Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MAPPED_RECORD_FEATURE_COUNT = CCI_MAPPED_RECORD_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link javax.resource.cci.IndexedRecord <em>CCI Indexed Record</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.IndexedRecord
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIIndexedRecord()
	 * @generated
	 */
	public static final int CCI_INDEXED_RECORD = 14;

	/**
	 * The number of structural features of the '<em>CCI Indexed Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CCI_INDEXED_RECORD_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.cci.impl.IndexedRecordImpl <em>Indexed Record</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.IndexedRecordImpl
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getIndexedRecord()
	 * @generated
	 */
	public static final int INDEXED_RECORD = 2;

	/**
	 * The feature id for the '<em><b>Record Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INDEXED_RECORD__RECORD_NAME = CCI_INDEXED_RECORD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Record Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INDEXED_RECORD__RECORD_SHORT_DESCRIPTION = CCI_INDEXED_RECORD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Records</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INDEXED_RECORD__RECORDS = CCI_INDEXED_RECORD_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Indexed Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INDEXED_RECORD_FEATURE_COUNT = CCI_INDEXED_RECORD_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link javax.resource.cci.InteractionSpec <em>CCI Interaction Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.InteractionSpec
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIInteractionSpec()
	 * @generated
	 */
	public static final int CCI_INTERACTION_SPEC = 15;

	/**
	 * The number of structural features of the '<em>CCI Interaction Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CCI_INTERACTION_SPEC_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.cci.impl.InteractionSpecImpl <em>Interaction Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.InteractionSpecImpl
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getInteractionSpec()
	 * @generated
	 */
	public static final int INTERACTION_SPEC = 3;

	/**
	 * The feature id for the '<em><b>Function Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INTERACTION_SPEC__FUNCTION_NAME = CCI_INTERACTION_SPEC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Interaction Verb</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INTERACTION_SPEC__INTERACTION_VERB = CCI_INTERACTION_SPEC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Execution Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INTERACTION_SPEC__EXECUTION_TIMEOUT = CCI_INTERACTION_SPEC_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Interaction Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INTERACTION_SPEC_FEATURE_COUNT = CCI_INTERACTION_SPEC_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link javax.resource.cci.Interaction <em>CCI Interaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.Interaction
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIInteraction()
	 * @generated
	 */
	public static final int CCI_INTERACTION = 16;

	/**
	 * The number of structural features of the '<em>CCI Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CCI_INTERACTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.cci.impl.InteractionImpl <em>Interaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.InteractionImpl
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getInteraction()
	 * @generated
	 */
	public static final int INTERACTION = 4;

	/**
	 * The number of structural features of the '<em>Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INTERACTION_FEATURE_COUNT = CCI_INTERACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link javax.resource.cci.ConnectionFactory <em>CCI Connection Factory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.ConnectionFactory
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIConnectionFactory()
	 * @generated
	 */
	public static final int CCI_CONNECTION_FACTORY = 17;

	/**
	 * The number of structural features of the '<em>CCI Connection Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CCI_CONNECTION_FACTORY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionFactoryImpl <em>Connection Factory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.ConnectionFactoryImpl
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getConnectionFactory()
	 * @generated
	 */
	public static final int CONNECTION_FACTORY = 5;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_FACTORY__REFERENCE = CCI_CONNECTION_FACTORY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Connection Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_FACTORY_FEATURE_COUNT = CCI_CONNECTION_FACTORY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link javax.resource.cci.Connection <em>CCI Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.Connection
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIConnection()
	 * @generated
	 */
	public static final int CCI_CONNECTION = 18;

	/**
	 * The number of structural features of the '<em>CCI Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CCI_CONNECTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.ConnectionImpl
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getConnection()
	 * @generated
	 */
	public static final int CONNECTION = 6;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_FEATURE_COUNT = CCI_CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link javax.resource.cci.ConnectionSpec <em>CCI Connection Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.ConnectionSpec
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIConnectionSpec()
	 * @generated
	 */
	public static final int CCI_CONNECTION_SPEC = 19;

	/**
	 * The number of structural features of the '<em>CCI Connection Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CCI_CONNECTION_SPEC_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl <em>Connection Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getConnectionSpec()
	 * @generated
	 */
	public static final int CONNECTION_SPEC = 7;

	/**
	 * The feature id for the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_SPEC__USER_NAME = CCI_CONNECTION_SPEC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_SPEC__PASSWORD = CCI_CONNECTION_SPEC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_SPEC__USER_ID = CCI_CONNECTION_SPEC_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Client</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_SPEC__CLIENT = CCI_CONNECTION_SPEC_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_SPEC__USER = CCI_CONNECTION_SPEC_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Alias User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_SPEC__ALIAS_USER = CCI_CONNECTION_SPEC_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Passwd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_SPEC__PASSWD = CCI_CONNECTION_SPEC_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Lang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_SPEC__LANG = CCI_CONNECTION_SPEC_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Mysapsso2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_SPEC__MYSAPSSO2 = CCI_CONNECTION_SPEC_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>X50 9cert</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_SPEC__X509CERT = CCI_CONNECTION_SPEC_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Connection Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_SPEC_FEATURE_COUNT = CCI_CONNECTION_SPEC_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link javax.resource.cci.ConnectionMetaData <em>CCI Connection Meta Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.ConnectionMetaData
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIConnectionMetaData()
	 * @generated
	 */
	public static final int CCI_CONNECTION_META_DATA = 20;

	/**
	 * The number of structural features of the '<em>CCI Connection Meta Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CCI_CONNECTION_META_DATA_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionMetaDataImpl <em>Connection Meta Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.ConnectionMetaDataImpl
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getConnectionMetaData()
	 * @generated
	 */
	public static final int CONNECTION_META_DATA = 8;

	/**
	 * The number of structural features of the '<em>Connection Meta Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTION_META_DATA_FEATURE_COUNT = CCI_CONNECTION_META_DATA_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link javax.resource.cci.LocalTransaction <em>CCI Local Transaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.LocalTransaction
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCILocalTransaction()
	 * @generated
	 */
	public static final int CCI_LOCAL_TRANSACTION = 21;

	/**
	 * The number of structural features of the '<em>CCI Local Transaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CCI_LOCAL_TRANSACTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.cci.impl.LocalTransactionImpl <em>Local Transaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.LocalTransactionImpl
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getLocalTransaction()
	 * @generated
	 */
	public static final int LOCAL_TRANSACTION = 9;

	/**
	 * The number of structural features of the '<em>Local Transaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOCAL_TRANSACTION_FEATURE_COUNT = CCI_LOCAL_TRANSACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link javax.resource.cci.ResourceAdapterMetaData <em>CCI Resource Adapter Meta Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.ResourceAdapterMetaData
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIResourceAdapterMetaData()
	 * @generated
	 */
	public static final int CCI_RESOURCE_ADAPTER_META_DATA = 22;

	/**
	 * The number of structural features of the '<em>CCI Resource Adapter Meta Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CCI_RESOURCE_ADAPTER_META_DATA_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.cci.impl.ResourceAdapterMetaDataImpl <em>Resource Adapter Meta Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.ResourceAdapterMetaDataImpl
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getResourceAdapterMetaData()
	 * @generated
	 */
	public static final int RESOURCE_ADAPTER_META_DATA = 10;

	/**
	 * The number of structural features of the '<em>Resource Adapter Meta Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RESOURCE_ADAPTER_META_DATA_FEATURE_COUNT = CCI_RESOURCE_ADAPTER_META_DATA_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link javax.resource.cci.Record <em>CCI Record</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.Record
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIRecord()
	 * @generated
	 */
	public static final int CCI_RECORD = 11;

	/**
	 * The number of structural features of the '<em>CCI Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CCI_RECORD_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '<em>Object Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getObjectArray()
	 * @generated
	 */
	public static final int OBJECT_ARRAY = 23;

	/**
	 * The meta object id for the '<em>String Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getStringArray()
	 * @generated
	 */
	public static final int STRING_ARRAY = 24;

	/**
	 * The meta object id for the '<em>Mapped Record Collection</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Collection
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getMappedRecordCollection()
	 * @generated
	 */
	public static final int MAPPED_RECORD_COLLECTION = 25;

	/**
	 * The meta object id for the '<em>Mapped Record List Iterator</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.ListIterator
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getMappedRecordListIterator()
	 * @generated
	 */
	public static final int MAPPED_RECORD_LIST_ITERATOR = 26;

	/**
	 * The meta object id for the '<em>Mapped Record Iterator</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Iterator
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getMappedRecordIterator()
	 * @generated
	 */
	public static final int MAPPED_RECORD_ITERATOR = 27;

	/**
	 * The meta object id for the '<em>Mapped Record List</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getMappedRecordList()
	 * @generated
	 */
	public static final int MAPPED_RECORD_LIST = 28;

	/**
	 * The meta object id for the '<em>Raw Collection</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Collection
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getRawCollection()
	 * @generated
	 */
	public static final int RAW_COLLECTION = 29;

	/**
	 * The meta object id for the '<em>Raw Map</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Map
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getRawMap()
	 * @generated
	 */
	public static final int RAW_MAP = 30;

	/**
	 * The meta object id for the '<em>Raw Set</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Set
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getRawSet()
	 * @generated
	 */
	public static final int RAW_SET = 31;

	/**
	 * The meta object id for the '<em>Properties</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Properties
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getProperties()
	 * @generated
	 */
	public static final int PROPERTIES = 32;

	/**
	 * The meta object id for the '<em>Resource Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.ResourceException
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getResourceException()
	 * @generated
	 */
	public static final int RESOURCE_EXCEPTION = 33;

	/**
	 * The meta object id for the '<em>Resource Warning</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.ResourceWarning
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getResourceWarning()
	 * @generated
	 */
	public static final int RESOURCE_WARNING = 34;

	/**
	 * The meta object id for the '<em>Result Set Info</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.ResultSetInfo
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getResultSetInfo()
	 * @generated
	 */
	public static final int RESULT_SET_INFO = 35;

	/**
	 * The meta object id for the '<em>Reference</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.naming.Reference
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getReference()
	 * @generated
	 */
	public static final int REFERENCE = 36;

	/**
	 * The meta object id for the '<em>Registry</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getRegistry()
	 * @generated
	 */
	public static final int REGISTRY = 37;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recordFactoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappedRecordEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexedRecordEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interactionSpecEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interactionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionFactoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionSpecEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionMetaDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localTransactionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceAdapterMetaDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cciRecordEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cciRecordFactoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cciMappedRecordEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cciIndexedRecordEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cciInteractionSpecEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cciInteractionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cciConnectionFactoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cciConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cciConnectionSpecEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cciConnectionMetaDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cciLocalTransactionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cciResourceAdapterMetaDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType mappedRecordIteratorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType objectArrayEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stringArrayEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType rawCollectionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType mappedRecordCollectionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType mappedRecordListIteratorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType mappedRecordListEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType rawMapEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType rawSetEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType propertiesEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType resourceExceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType resourceWarningEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType resultSetInfoEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType referenceEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType registryEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CciPackageImpl() {
		super(eNS_URI, ((EFactory)CciFactory.INSTANCE));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CciPackageImpl#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CciPackageImpl init() {
		if (isInited) return (CciPackageImpl)EPackage.Registry.INSTANCE.getEPackage(CciPackageImpl.eNS_URI);

		// Obtain or create and register package
		CciPackageImpl theCciPackage = (CciPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CciPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CciPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		SpiPackageImpl theSpiPackage = (SpiPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SpiPackageImpl.eNS_URI) instanceof SpiPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SpiPackageImpl.eNS_URI) : SpiPackageImpl.eINSTANCE);

		// Create package meta-data objects
		theCciPackage.createPackageContents();
		theSpiPackage.createPackageContents();

		// Initialize created meta-data
		theCciPackage.initializePackageContents();
		theSpiPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCciPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CciPackageImpl.eNS_URI, theCciPackage);
		return theCciPackage;
	}
	
	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.cci.RecordFactory <em>Record Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Record Factory</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.RecordFactory
	 * @generated
	 */
	public EClass getRecordFactory() {
		return recordFactoryEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.cci.MappedRecord <em>Mapped Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped Record</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.MappedRecord
	 * @generated
	 */
	public EClass getMappedRecord() {
		return mappedRecordEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.MappedRecord#getRecordName <em>Record Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Record Name</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.MappedRecord#getRecordName()
	 * @see #getMappedRecord()
	 * @generated
	 */
	public EAttribute getMappedRecord_RecordName() {
		return (EAttribute)mappedRecordEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.MappedRecord#getRecordShortDescription <em>Record Short Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Record Short Description</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.MappedRecord#getRecordShortDescription()
	 * @see #getMappedRecord()
	 * @generated
	 */
	public EAttribute getMappedRecord_RecordShortDescription() {
		return (EAttribute)mappedRecordEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.cci.IndexedRecord <em>Indexed Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Indexed Record</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.IndexedRecord
	 * @generated
	 */
	public EClass getIndexedRecord() {
		return indexedRecordEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.IndexedRecord#getRecordName <em>Record Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Record Name</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.IndexedRecord#getRecordName()
	 * @see #getIndexedRecord()
	 * @generated
	 */
	public EAttribute getIndexedRecord_RecordName() {
		return (EAttribute)indexedRecordEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.IndexedRecord#getRecordShortDescription <em>Record Short Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Record Short Description</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.IndexedRecord#getRecordShortDescription()
	 * @see #getIndexedRecord()
	 * @generated
	 */
	public EAttribute getIndexedRecord_RecordShortDescription() {
		return (EAttribute)indexedRecordEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.jca.adapters.sap.cci.IndexedRecord#getRecords <em>Records</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Records</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.IndexedRecord#getRecords()
	 * @see #getIndexedRecord()
	 * @generated
	 */
	public EReference getIndexedRecord_Records() {
		return (EReference)indexedRecordEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.cci.InteractionSpec <em>Interaction Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interaction Spec</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.InteractionSpec
	 * @generated
	 */
	public EClass getInteractionSpec() {
		return interactionSpecEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.InteractionSpec#getFunctionName <em>Function Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Function Name</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.InteractionSpec#getFunctionName()
	 * @see #getInteractionSpec()
	 * @generated
	 */
	public EAttribute getInteractionSpec_FunctionName() {
		return (EAttribute)interactionSpecEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.InteractionSpec#getInteractionVerb <em>Interaction Verb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interaction Verb</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.InteractionSpec#getInteractionVerb()
	 * @see #getInteractionSpec()
	 * @generated
	 */
	public EAttribute getInteractionSpec_InteractionVerb() {
		return (EAttribute)interactionSpecEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.InteractionSpec#getExecutionTimeout <em>Execution Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Execution Timeout</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.InteractionSpec#getExecutionTimeout()
	 * @see #getInteractionSpec()
	 * @generated
	 */
	public EAttribute getInteractionSpec_ExecutionTimeout() {
		return (EAttribute)interactionSpecEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.cci.Interaction <em>Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interaction</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.Interaction
	 * @generated
	 */
	public EClass getInteraction() {
		return interactionEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.cci.ConnectionFactory <em>Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Factory</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionFactory
	 * @generated
	 */
	public EClass getConnectionFactory() {
		return connectionFactoryEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionFactory#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionFactory#getReference()
	 * @see #getConnectionFactory()
	 * @generated
	 */
	public EAttribute getConnectionFactory_Reference() {
		return (EAttribute)connectionFactoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.cci.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.Connection
	 * @generated
	 */
	public EClass getConnection() {
		return connectionEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec <em>Connection Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Spec</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec
	 * @generated
	 */
	public EClass getConnectionSpec() {
		return connectionSpecEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUserName <em>User Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Name</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUserName()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	public EAttribute getConnectionSpec_UserName() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPassword()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	public EAttribute getConnectionSpec_Password() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUserId <em>User Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Id</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUserId()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	public EAttribute getConnectionSpec_UserId() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getClient <em>Client</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getClient()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	public EAttribute getConnectionSpec_Client() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUser()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	public EAttribute getConnectionSpec_User() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getAliasUser <em>Alias User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias User</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getAliasUser()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	public EAttribute getConnectionSpec_AliasUser() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPasswd <em>Passwd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Passwd</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPasswd()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	public EAttribute getConnectionSpec_Passwd() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getLang <em>Lang</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lang</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getLang()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	public EAttribute getConnectionSpec_Lang() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMysapsso2 <em>Mysapsso2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mysapsso2</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMysapsso2()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	public EAttribute getConnectionSpec_Mysapsso2() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getX509cert <em>X50 9cert</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X50 9cert</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getX509cert()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	public EAttribute getConnectionSpec_X509cert() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.cci.ConnectionMetaData <em>Connection Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Meta Data</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionMetaData
	 * @generated
	 */
	public EClass getConnectionMetaData() {
		return connectionMetaDataEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.cci.LocalTransaction <em>Local Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Transaction</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.LocalTransaction
	 * @generated
	 */
	public EClass getLocalTransaction() {
		return localTransactionEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.cci.ResourceAdapterMetaData <em>Resource Adapter Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Adapter Meta Data</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ResourceAdapterMetaData
	 * @generated
	 */
	public EClass getResourceAdapterMetaData() {
		return resourceAdapterMetaDataEClass;
	}

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.Record <em>CCI Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Record</em>'.
	 * @see javax.resource.cci.Record
	 * @model instanceClass="javax.resource.cci.Record"
	 * @generated
	 */
	public EClass getCCIRecord() {
		return cciRecordEClass;
	}

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.RecordFactory <em>CCI Record Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Record Factory</em>'.
	 * @see javax.resource.cci.RecordFactory
	 * @model instanceClass="javax.resource.cci.RecordFactory"
	 * @generated
	 */
	public EClass getCCIRecordFactory() {
		return cciRecordFactoryEClass;
	}

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.MappedRecord <em>CCI Mapped Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Mapped Record</em>'.
	 * @see javax.resource.cci.MappedRecord
	 * @model instanceClass="javax.resource.cci.MappedRecord"
	 * @generated
	 */
	public EClass getCCIMappedRecord() {
		return cciMappedRecordEClass;
	}

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.IndexedRecord <em>CCI Indexed Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Indexed Record</em>'.
	 * @see javax.resource.cci.IndexedRecord
	 * @model instanceClass="javax.resource.cci.IndexedRecord"
	 * @generated
	 */
	public EClass getCCIIndexedRecord() {
		return cciIndexedRecordEClass;
	}

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.InteractionSpec <em>CCI Interaction Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Interaction Spec</em>'.
	 * @see javax.resource.cci.InteractionSpec
	 * @model instanceClass="javax.resource.cci.InteractionSpec"
	 * @generated
	 */
	public EClass getCCIInteractionSpec() {
		return cciInteractionSpecEClass;
	}

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.Interaction <em>CCI Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Interaction</em>'.
	 * @see javax.resource.cci.Interaction
	 * @model instanceClass="javax.resource.cci.Interaction"
	 * @generated
	 */
	public EClass getCCIInteraction() {
		return cciInteractionEClass;
	}

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.ConnectionFactory <em>CCI Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Connection Factory</em>'.
	 * @see javax.resource.cci.ConnectionFactory
	 * @model instanceClass="javax.resource.cci.ConnectionFactory"
	 * @generated
	 */
	public EClass getCCIConnectionFactory() {
		return cciConnectionFactoryEClass;
	}

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.Connection <em>CCI Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Connection</em>'.
	 * @see javax.resource.cci.Connection
	 * @model instanceClass="javax.resource.cci.Connection"
	 * @generated
	 */
	public EClass getCCIConnection() {
		return cciConnectionEClass;
	}

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.ConnectionSpec <em>CCI Connection Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Connection Spec</em>'.
	 * @see javax.resource.cci.ConnectionSpec
	 * @model instanceClass="javax.resource.cci.ConnectionSpec"
	 * @generated
	 */
	public EClass getCCIConnectionSpec() {
		return cciConnectionSpecEClass;
	}

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.ConnectionMetaData <em>CCI Connection Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Connection Meta Data</em>'.
	 * @see javax.resource.cci.ConnectionMetaData
	 * @model instanceClass="javax.resource.cci.ConnectionMetaData"
	 * @generated
	 */
	public EClass getCCIConnectionMetaData() {
		return cciConnectionMetaDataEClass;
	}

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.LocalTransaction <em>CCI Local Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Local Transaction</em>'.
	 * @see javax.resource.cci.LocalTransaction
	 * @model instanceClass="javax.resource.cci.LocalTransaction"
	 * @generated
	 */
	public EClass getCCILocalTransaction() {
		return cciLocalTransactionEClass;
	}

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.ResourceAdapterMetaData <em>CCI Resource Adapter Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Resource Adapter Meta Data</em>'.
	 * @see javax.resource.cci.ResourceAdapterMetaData
	 * @model instanceClass="javax.resource.cci.ResourceAdapterMetaData"
	 * @generated
	 */
	public EClass getCCIResourceAdapterMetaData() {
		return cciResourceAdapterMetaDataEClass;
	}

	/**
	 * Returns the meta object for data type '{@link java.util.Iterator <em>Mapped Record Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Mapped Record Iterator</em>'.
	 * @see java.util.Iterator
	 * @model instanceClass="java.util.Iterator<org.jboss.jca.adapters.sap.cci.MappedRecord>"
	 * @generated
	 */
	public EDataType getMappedRecordIterator() {
		return mappedRecordIteratorEDataType;
	}

	/**
	 * Returns the meta object for data type '<em>Object Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Object Array</em>'.
	 * @model instanceClass="java.lang.Object[]"
	 * @generated
	 */
	public EDataType getObjectArray() {
		return objectArrayEDataType;
	}

	/**
	 * Returns the meta object for data type '<em>String Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String Array</em>'.
	 * @model instanceClass="java.lang.String[]"
	 * @generated
	 */
	public EDataType getStringArray() {
		return stringArrayEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link java.util.Collection <em>Raw Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Raw Collection</em>'.
	 * @see java.util.Collection
	 * @model instanceClass="java.util.Collection"
	 * @generated
	 */
	public EDataType getRawCollection() {
		return rawCollectionEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link java.util.Collection <em>Mapped Record Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Mapped Record Collection</em>'.
	 * @see java.util.Collection
	 * @model instanceClass="java.util.Collection<org.jboss.jca.adapters.sap.cci.MappedRecord>"
	 * @generated
	 */
	public EDataType getMappedRecordCollection() {
		return mappedRecordCollectionEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link java.util.ListIterator <em>Mapped Record List Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Mapped Record List Iterator</em>'.
	 * @see java.util.ListIterator
	 * @model instanceClass="java.util.ListIterator<org.jboss.jca.adapters.sap.cci.MappedRecord>"
	 * @generated
	 */
	public EDataType getMappedRecordListIterator() {
		return mappedRecordListIteratorEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link java.util.List <em>Mapped Record List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Mapped Record List</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List<org.jboss.jca.adapters.sap.cci.MappedRecord>"
	 * @generated
	 */
	public EDataType getMappedRecordList() {
		return mappedRecordListEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link java.util.Map <em>Raw Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Raw Map</em>'.
	 * @see java.util.Map
	 * @model instanceClass="java.util.Map"
	 * @generated
	 */
	public EDataType getRawMap() {
		return rawMapEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link java.util.Set <em>Raw Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Raw Set</em>'.
	 * @see java.util.Set
	 * @model instanceClass="java.util.Set"
	 * @generated
	 */
	public EDataType getRawSet() {
		return rawSetEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link java.util.Properties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Properties</em>'.
	 * @see java.util.Properties
	 * @model instanceClass="java.util.Properties"
	 * @generated
	 */
	public EDataType getProperties() {
		return propertiesEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link javax.resource.ResourceException <em>Resource Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Resource Exception</em>'.
	 * @see javax.resource.ResourceException
	 * @model instanceClass="javax.resource.ResourceException"
	 * @generated
	 */
	public EDataType getResourceException() {
		return resourceExceptionEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link javax.resource.cci.ResourceWarning <em>Resource Warning</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Resource Warning</em>'.
	 * @see javax.resource.cci.ResourceWarning
	 * @model instanceClass="javax.resource.cci.ResourceWarning"
	 * @generated
	 */
	public EDataType getResourceWarning() {
		return resourceWarningEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link javax.resource.cci.ResultSetInfo <em>Result Set Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Result Set Info</em>'.
	 * @see javax.resource.cci.ResultSetInfo
	 * @model instanceClass="javax.resource.cci.ResultSetInfo"
	 * @generated
	 */
	public EDataType getResultSetInfo() {
		return resultSetInfoEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link javax.naming.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Reference</em>'.
	 * @see javax.naming.Reference
	 * @model instanceClass="javax.naming.Reference"
	 * @generated
	 */
	public EDataType getReference() {
		return referenceEDataType;
	}

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.ecore.EPackage.Registry <em>Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Registry</em>'.
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @model instanceClass="org.eclipse.emf.ecore.EPackage.Registry"
	 * @generated
	 */
	public EDataType getRegistry() {
		return registryEDataType;
	}

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public CciFactory getCciFactory() {
		return (CciFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		recordFactoryEClass = createEClass(RECORD_FACTORY);

		mappedRecordEClass = createEClass(MAPPED_RECORD);
		createEAttribute(mappedRecordEClass, MAPPED_RECORD__RECORD_NAME);
		createEAttribute(mappedRecordEClass, MAPPED_RECORD__RECORD_SHORT_DESCRIPTION);

		indexedRecordEClass = createEClass(INDEXED_RECORD);
		createEAttribute(indexedRecordEClass, INDEXED_RECORD__RECORD_NAME);
		createEAttribute(indexedRecordEClass, INDEXED_RECORD__RECORD_SHORT_DESCRIPTION);
		createEReference(indexedRecordEClass, INDEXED_RECORD__RECORDS);

		interactionSpecEClass = createEClass(INTERACTION_SPEC);
		createEAttribute(interactionSpecEClass, INTERACTION_SPEC__FUNCTION_NAME);
		createEAttribute(interactionSpecEClass, INTERACTION_SPEC__INTERACTION_VERB);
		createEAttribute(interactionSpecEClass, INTERACTION_SPEC__EXECUTION_TIMEOUT);

		interactionEClass = createEClass(INTERACTION);

		connectionFactoryEClass = createEClass(CONNECTION_FACTORY);
		createEAttribute(connectionFactoryEClass, CONNECTION_FACTORY__REFERENCE);

		connectionEClass = createEClass(CONNECTION);

		connectionSpecEClass = createEClass(CONNECTION_SPEC);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__USER_NAME);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__PASSWORD);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__USER_ID);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__CLIENT);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__USER);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__ALIAS_USER);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__PASSWD);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__LANG);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__MYSAPSSO2);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__X509CERT);

		connectionMetaDataEClass = createEClass(CONNECTION_META_DATA);

		localTransactionEClass = createEClass(LOCAL_TRANSACTION);

		resourceAdapterMetaDataEClass = createEClass(RESOURCE_ADAPTER_META_DATA);

		cciRecordEClass = createEClass(CCI_RECORD);

		cciRecordFactoryEClass = createEClass(CCI_RECORD_FACTORY);

		cciMappedRecordEClass = createEClass(CCI_MAPPED_RECORD);

		cciIndexedRecordEClass = createEClass(CCI_INDEXED_RECORD);

		cciInteractionSpecEClass = createEClass(CCI_INTERACTION_SPEC);

		cciInteractionEClass = createEClass(CCI_INTERACTION);

		cciConnectionFactoryEClass = createEClass(CCI_CONNECTION_FACTORY);

		cciConnectionEClass = createEClass(CCI_CONNECTION);

		cciConnectionSpecEClass = createEClass(CCI_CONNECTION_SPEC);

		cciConnectionMetaDataEClass = createEClass(CCI_CONNECTION_META_DATA);

		cciLocalTransactionEClass = createEClass(CCI_LOCAL_TRANSACTION);

		cciResourceAdapterMetaDataEClass = createEClass(CCI_RESOURCE_ADAPTER_META_DATA);

		// Create data types
		objectArrayEDataType = createEDataType(OBJECT_ARRAY);
		stringArrayEDataType = createEDataType(STRING_ARRAY);
		mappedRecordCollectionEDataType = createEDataType(MAPPED_RECORD_COLLECTION);
		mappedRecordListIteratorEDataType = createEDataType(MAPPED_RECORD_LIST_ITERATOR);
		mappedRecordIteratorEDataType = createEDataType(MAPPED_RECORD_ITERATOR);
		mappedRecordListEDataType = createEDataType(MAPPED_RECORD_LIST);
		rawCollectionEDataType = createEDataType(RAW_COLLECTION);
		rawMapEDataType = createEDataType(RAW_MAP);
		rawSetEDataType = createEDataType(RAW_SET);
		propertiesEDataType = createEDataType(PROPERTIES);
		resourceExceptionEDataType = createEDataType(RESOURCE_EXCEPTION);
		resourceWarningEDataType = createEDataType(RESOURCE_WARNING);
		resultSetInfoEDataType = createEDataType(RESULT_SET_INFO);
		referenceEDataType = createEDataType(REFERENCE);
		registryEDataType = createEDataType(REGISTRY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters
		ETypeParameter indexedRecordEClass_R = addETypeParameter(indexedRecordEClass, "R");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getMappedRecord());
		indexedRecordEClass_R.getEBounds().add(g1);

		// Add supertypes to classes
		recordFactoryEClass.getESuperTypes().add(this.getCCIRecordFactory());
		mappedRecordEClass.getESuperTypes().add(this.getCCIMappedRecord());
		indexedRecordEClass.getESuperTypes().add(this.getCCIIndexedRecord());
		interactionSpecEClass.getESuperTypes().add(this.getCCIInteractionSpec());
		interactionEClass.getESuperTypes().add(this.getCCIInteraction());
		connectionFactoryEClass.getESuperTypes().add(this.getCCIConnectionFactory());
		connectionEClass.getESuperTypes().add(this.getCCIConnection());
		connectionSpecEClass.getESuperTypes().add(this.getCCIConnectionSpec());
		connectionMetaDataEClass.getESuperTypes().add(this.getCCIConnectionMetaData());
		localTransactionEClass.getESuperTypes().add(this.getCCILocalTransaction());
		resourceAdapterMetaDataEClass.getESuperTypes().add(this.getCCIResourceAdapterMetaData());

		// Initialize classes and features; add operations and parameters
		initEClass(recordFactoryEClass, RecordFactory.class, "RecordFactory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(recordFactoryEClass, this.getMappedRecord(), "createMappedRecord", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "recordName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		op = addEOperation(recordFactoryEClass, this.getIndexedRecord(), "createIndexedRecord", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "recordName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		op = addEOperation(recordFactoryEClass, this.getRegistry(), "getPackageRegistry", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		initEClass(mappedRecordEClass, MappedRecord.class, "MappedRecord", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappedRecord_RecordName(), ecorePackage.getEString(), "recordName", "0", 0, 1, MappedRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappedRecord_RecordShortDescription(), ecorePackage.getEString(), "recordShortDescription", null, 0, 1, MappedRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(mappedRecordEClass, ecorePackage.getEJavaObject(), "clone", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(mappedRecordEClass, ecorePackage.getEBoolean(), "equals", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "other", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(mappedRecordEClass, ecorePackage.getEInt(), "hashCode", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(mappedRecordEClass, ecorePackage.getEInt(), "size", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(mappedRecordEClass, ecorePackage.getEBoolean(), "isEmpty", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(mappedRecordEClass, ecorePackage.getEBoolean(), "containsKey", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "key", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(mappedRecordEClass, ecorePackage.getEBoolean(), "containsValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(mappedRecordEClass, ecorePackage.getEJavaObject(), "get", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "key", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(mappedRecordEClass, ecorePackage.getEJavaObject(), "put", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "key", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(mappedRecordEClass, ecorePackage.getEJavaObject(), "remove", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "key", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(mappedRecordEClass, null, "putAll", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRawMap(), "m", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(mappedRecordEClass, null, "clear", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(mappedRecordEClass, this.getRawSet(), "keySet", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(mappedRecordEClass, this.getRawCollection(), "values", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(mappedRecordEClass, this.getRawSet(), "entrySet", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(indexedRecordEClass, IndexedRecord.class, "IndexedRecord", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIndexedRecord_RecordName(), ecorePackage.getEString(), "recordName", "0", 0, 1, IndexedRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIndexedRecord_RecordShortDescription(), ecorePackage.getEString(), "recordShortDescription", null, 0, 1, IndexedRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(indexedRecordEClass_R);
		initEReference(getIndexedRecord_Records(), g1, null, "records", null, 0, -1, IndexedRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(indexedRecordEClass, ecorePackage.getEJavaObject(), "clone", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexedRecordEClass, ecorePackage.getEBoolean(), "equals", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "other", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(indexedRecordEClass, ecorePackage.getEInt(), "hashCode", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(indexedRecordEClass, ecorePackage.getEInt(), "size", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(indexedRecordEClass, ecorePackage.getEBoolean(), "isEmpty", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexedRecordEClass, ecorePackage.getEBoolean(), "contains", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "o", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(indexedRecordEClass, this.getMappedRecordIterator(), "iterator", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(indexedRecordEClass, this.getObjectArray(), "toArray", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexedRecordEClass, this.getObjectArray(), "toArray", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getObjectArray(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexedRecordEClass, ecorePackage.getEBoolean(), "add", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(indexedRecordEClass, this.getMappedRecord(), "add", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexedRecordEClass, ecorePackage.getEBoolean(), "remove", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "o", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexedRecordEClass, ecorePackage.getEBoolean(), "containsAll", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRawCollection(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexedRecordEClass, ecorePackage.getEBoolean(), "addAll", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRawCollection(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexedRecordEClass, ecorePackage.getEBoolean(), "addAll", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRawCollection(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexedRecordEClass, ecorePackage.getEBoolean(), "removeAll", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRawCollection(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexedRecordEClass, ecorePackage.getEBoolean(), "retainAll", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRawCollection(), "c", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(indexedRecordEClass, null, "clear", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexedRecordEClass, this.getMappedRecord(), "get", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexedRecordEClass, this.getMappedRecord(), "set", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "element", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexedRecordEClass, null, "add", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "element", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexedRecordEClass, this.getMappedRecord(), "add", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexedRecordEClass, this.getMappedRecord(), "remove", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexedRecordEClass, ecorePackage.getEInt(), "indexOf", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "o", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexedRecordEClass, ecorePackage.getEInt(), "lastIndexOf", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "o", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(indexedRecordEClass, this.getMappedRecordListIterator(), "listIterator", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexedRecordEClass, this.getMappedRecordListIterator(), "listIterator", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexedRecordEClass, this.getMappedRecordList(), "subList", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "fromIndex", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "toIndex", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(indexedRecordEClass, ecorePackage.getEClass(), "getRecordType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(interactionSpecEClass, InteractionSpec.class, "InteractionSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInteractionSpec_FunctionName(), ecorePackage.getEString(), "functionName", null, 0, 1, InteractionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInteractionSpec_InteractionVerb(), ecorePackage.getEInt(), "interactionVerb", null, 0, 1, InteractionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInteractionSpec_ExecutionTimeout(), ecorePackage.getEInt(), "executionTimeout", null, 0, 1, InteractionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interactionEClass, Interaction.class, "Interaction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(interactionEClass, null, "close", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		addEOperation(interactionEClass, this.getConnection(), "getConnection", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(interactionEClass, ecorePackage.getEBoolean(), "execute", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getCCIInteractionSpec(), "ispec", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getCCIRecord(), "input", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getCCIRecord(), "output", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		op = addEOperation(interactionEClass, this.getCCIRecord(), "execute", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getCCIInteractionSpec(), "ispec", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getCCIRecord(), "input", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		op = addEOperation(interactionEClass, this.getResourceWarning(), "getWarnings", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		op = addEOperation(interactionEClass, null, "clearWarnings", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		initEClass(connectionFactoryEClass, ConnectionFactory.class, "ConnectionFactory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnectionFactory_Reference(), this.getReference(), "reference", null, 0, 1, ConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(connectionFactoryEClass, this.getConnection(), "getConnection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		op = addEOperation(connectionFactoryEClass, this.getConnection(), "getConnection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getCCIConnectionSpec(), "properties", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		op = addEOperation(connectionFactoryEClass, this.getRecordFactory(), "getRecordFactory", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		op = addEOperation(connectionFactoryEClass, this.getResourceAdapterMetaData(), "getMetaData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		initEClass(connectionEClass, Connection.class, "Connection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(connectionEClass, null, "begin", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		op = addEOperation(connectionEClass, null, "end", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		addEOperation(connectionEClass, ecorePackage.getEBoolean(), "isClosed", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionEClass, ecorePackage.getEBoolean(), "isStateful", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(connectionEClass, this.getConnectionSpec(), "getConnectionSpec", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(connectionEClass, this.getInteraction(), "createInteraction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		op = addEOperation(connectionEClass, this.getLocalTransaction(), "getLocalTransaction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		op = addEOperation(connectionEClass, this.getConnectionMetaData(), "getMetaData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		op = addEOperation(connectionEClass, this.getResultSetInfo(), "getResultSetInfo", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		op = addEOperation(connectionEClass, null, "ping", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		op = addEOperation(connectionEClass, null, "close", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		initEClass(connectionSpecEClass, ConnectionSpec.class, "ConnectionSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnectionSpec_UserName(), ecorePackage.getEString(), "userName", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Password(), ecorePackage.getEString(), "password", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_UserId(), ecorePackage.getEString(), "userId", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Client(), ecorePackage.getEString(), "client", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_User(), ecorePackage.getEString(), "user", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_AliasUser(), ecorePackage.getEString(), "aliasUser", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Passwd(), ecorePackage.getEString(), "passwd", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Lang(), ecorePackage.getEString(), "lang", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Mysapsso2(), ecorePackage.getEString(), "mysapsso2", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_X509cert(), ecorePackage.getEString(), "x509cert", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectionMetaDataEClass, ConnectionMetaData.class, "ConnectionMetaData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(connectionMetaDataEClass, ecorePackage.getEString(), "getEISProductName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		op = addEOperation(connectionMetaDataEClass, ecorePackage.getEString(), "getEISProductVersion", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		op = addEOperation(connectionMetaDataEClass, ecorePackage.getEString(), "getUserName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		initEClass(localTransactionEClass, LocalTransaction.class, "LocalTransaction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(localTransactionEClass, null, "begin", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		op = addEOperation(localTransactionEClass, null, "commit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		op = addEOperation(localTransactionEClass, null, "rollback", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getResourceException());

		initEClass(resourceAdapterMetaDataEClass, ResourceAdapterMetaData.class, "ResourceAdapterMetaData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(resourceAdapterMetaDataEClass, ecorePackage.getEString(), "getAdapterVersion", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(resourceAdapterMetaDataEClass, ecorePackage.getEString(), "getAdapterVendorName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(resourceAdapterMetaDataEClass, ecorePackage.getEString(), "getAdapterName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(resourceAdapterMetaDataEClass, ecorePackage.getEString(), "getAdapterShortDescription", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(resourceAdapterMetaDataEClass, ecorePackage.getEString(), "getSpecVersion", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(resourceAdapterMetaDataEClass, this.getStringArray(), "getInteractionSpecsSupported", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(resourceAdapterMetaDataEClass, ecorePackage.getEBoolean(), "supportsExecuteWithInputAndOutputRecord", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(resourceAdapterMetaDataEClass, ecorePackage.getEBoolean(), "supportsExecuteWithInputRecordOnly", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(resourceAdapterMetaDataEClass, ecorePackage.getEBoolean(), "supportsLocalTransactionDemarcation", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(cciRecordEClass, Record.class, "CCIRecord", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(cciRecordFactoryEClass, javax.resource.cci.RecordFactory.class, "CCIRecordFactory", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(cciMappedRecordEClass, javax.resource.cci.MappedRecord.class, "CCIMappedRecord", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(cciIndexedRecordEClass, javax.resource.cci.IndexedRecord.class, "CCIIndexedRecord", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(cciInteractionSpecEClass, javax.resource.cci.InteractionSpec.class, "CCIInteractionSpec", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(cciInteractionEClass, javax.resource.cci.Interaction.class, "CCIInteraction", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(cciConnectionFactoryEClass, javax.resource.cci.ConnectionFactory.class, "CCIConnectionFactory", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(cciConnectionEClass, javax.resource.cci.Connection.class, "CCIConnection", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(cciConnectionSpecEClass, javax.resource.cci.ConnectionSpec.class, "CCIConnectionSpec", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(cciConnectionMetaDataEClass, javax.resource.cci.ConnectionMetaData.class, "CCIConnectionMetaData", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(cciLocalTransactionEClass, javax.resource.cci.LocalTransaction.class, "CCILocalTransaction", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(cciResourceAdapterMetaDataEClass, javax.resource.cci.ResourceAdapterMetaData.class, "CCIResourceAdapterMetaData", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		// Initialize data types
		initEDataType(objectArrayEDataType, Object[].class, "ObjectArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(stringArrayEDataType, String[].class, "StringArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(mappedRecordCollectionEDataType, Collection.class, "MappedRecordCollection", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.Collection<org.jboss.jca.adapters.sap.cci.MappedRecord>");
		initEDataType(mappedRecordListIteratorEDataType, ListIterator.class, "MappedRecordListIterator", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.ListIterator<org.jboss.jca.adapters.sap.cci.MappedRecord>");
		initEDataType(mappedRecordIteratorEDataType, Iterator.class, "MappedRecordIterator", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.Iterator<org.jboss.jca.adapters.sap.cci.MappedRecord>");
		initEDataType(mappedRecordListEDataType, List.class, "MappedRecordList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.List<org.jboss.jca.adapters.sap.cci.MappedRecord>");
		initEDataType(rawCollectionEDataType, Collection.class, "RawCollection", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(rawMapEDataType, Map.class, "RawMap", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(rawSetEDataType, Set.class, "RawSet", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(propertiesEDataType, Properties.class, "Properties", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(resourceExceptionEDataType, ResourceException.class, "ResourceException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(resourceWarningEDataType, ResourceWarning.class, "ResourceWarning", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(resultSetInfoEDataType, ResultSetInfo.class, "ResultSetInfo", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(referenceEDataType, Reference.class, "Reference", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(registryEDataType, Registry.class, "Registry", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public interface Literals {
		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.cci.impl.RecordFactoryImpl <em>Record Factory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.RecordFactoryImpl
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getRecordFactory()
		 * @generated
		 */
		public static final EClass RECORD_FACTORY = eINSTANCE.getRecordFactory();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.cci.impl.MappedRecordImpl <em>Mapped Record</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.MappedRecordImpl
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getMappedRecord()
		 * @generated
		 */
		public static final EClass MAPPED_RECORD = eINSTANCE.getMappedRecord();

		/**
		 * The meta object literal for the '<em><b>Record Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute MAPPED_RECORD__RECORD_NAME = eINSTANCE.getMappedRecord_RecordName();

		/**
		 * The meta object literal for the '<em><b>Record Short Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute MAPPED_RECORD__RECORD_SHORT_DESCRIPTION = eINSTANCE.getMappedRecord_RecordShortDescription();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.cci.impl.IndexedRecordImpl <em>Indexed Record</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.IndexedRecordImpl
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getIndexedRecord()
		 * @generated
		 */
		public static final EClass INDEXED_RECORD = eINSTANCE.getIndexedRecord();

		/**
		 * The meta object literal for the '<em><b>Record Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute INDEXED_RECORD__RECORD_NAME = eINSTANCE.getIndexedRecord_RecordName();

		/**
		 * The meta object literal for the '<em><b>Record Short Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute INDEXED_RECORD__RECORD_SHORT_DESCRIPTION = eINSTANCE.getIndexedRecord_RecordShortDescription();

		/**
		 * The meta object literal for the '<em><b>Records</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference INDEXED_RECORD__RECORDS = eINSTANCE.getIndexedRecord_Records();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.cci.impl.InteractionSpecImpl <em>Interaction Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.InteractionSpecImpl
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getInteractionSpec()
		 * @generated
		 */
		public static final EClass INTERACTION_SPEC = eINSTANCE.getInteractionSpec();

		/**
		 * The meta object literal for the '<em><b>Function Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute INTERACTION_SPEC__FUNCTION_NAME = eINSTANCE.getInteractionSpec_FunctionName();

		/**
		 * The meta object literal for the '<em><b>Interaction Verb</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute INTERACTION_SPEC__INTERACTION_VERB = eINSTANCE.getInteractionSpec_InteractionVerb();

		/**
		 * The meta object literal for the '<em><b>Execution Timeout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute INTERACTION_SPEC__EXECUTION_TIMEOUT = eINSTANCE.getInteractionSpec_ExecutionTimeout();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.cci.impl.InteractionImpl <em>Interaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.InteractionImpl
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getInteraction()
		 * @generated
		 */
		public static final EClass INTERACTION = eINSTANCE.getInteraction();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionFactoryImpl <em>Connection Factory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.ConnectionFactoryImpl
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getConnectionFactory()
		 * @generated
		 */
		public static final EClass CONNECTION_FACTORY = eINSTANCE.getConnectionFactory();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute CONNECTION_FACTORY__REFERENCE = eINSTANCE.getConnectionFactory_Reference();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.ConnectionImpl
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getConnection()
		 * @generated
		 */
		public static final EClass CONNECTION = eINSTANCE.getConnection();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl <em>Connection Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getConnectionSpec()
		 * @generated
		 */
		public static final EClass CONNECTION_SPEC = eINSTANCE.getConnectionSpec();

		/**
		 * The meta object literal for the '<em><b>User Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute CONNECTION_SPEC__USER_NAME = eINSTANCE.getConnectionSpec_UserName();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute CONNECTION_SPEC__PASSWORD = eINSTANCE.getConnectionSpec_Password();

		/**
		 * The meta object literal for the '<em><b>User Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute CONNECTION_SPEC__USER_ID = eINSTANCE.getConnectionSpec_UserId();

		/**
		 * The meta object literal for the '<em><b>Client</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute CONNECTION_SPEC__CLIENT = eINSTANCE.getConnectionSpec_Client();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute CONNECTION_SPEC__USER = eINSTANCE.getConnectionSpec_User();

		/**
		 * The meta object literal for the '<em><b>Alias User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute CONNECTION_SPEC__ALIAS_USER = eINSTANCE.getConnectionSpec_AliasUser();

		/**
		 * The meta object literal for the '<em><b>Passwd</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute CONNECTION_SPEC__PASSWD = eINSTANCE.getConnectionSpec_Passwd();

		/**
		 * The meta object literal for the '<em><b>Lang</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute CONNECTION_SPEC__LANG = eINSTANCE.getConnectionSpec_Lang();

		/**
		 * The meta object literal for the '<em><b>Mysapsso2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute CONNECTION_SPEC__MYSAPSSO2 = eINSTANCE.getConnectionSpec_Mysapsso2();

		/**
		 * The meta object literal for the '<em><b>X50 9cert</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute CONNECTION_SPEC__X509CERT = eINSTANCE.getConnectionSpec_X509cert();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionMetaDataImpl <em>Connection Meta Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.ConnectionMetaDataImpl
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getConnectionMetaData()
		 * @generated
		 */
		public static final EClass CONNECTION_META_DATA = eINSTANCE.getConnectionMetaData();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.cci.impl.LocalTransactionImpl <em>Local Transaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.LocalTransactionImpl
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getLocalTransaction()
		 * @generated
		 */
		public static final EClass LOCAL_TRANSACTION = eINSTANCE.getLocalTransaction();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.cci.impl.ResourceAdapterMetaDataImpl <em>Resource Adapter Meta Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.ResourceAdapterMetaDataImpl
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getResourceAdapterMetaData()
		 * @generated
		 */
		public static final EClass RESOURCE_ADAPTER_META_DATA = eINSTANCE.getResourceAdapterMetaData();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.Record <em>CCI Record</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.Record
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIRecord()
		 * @generated
		 */
		public static final EClass CCI_RECORD = eINSTANCE.getCCIRecord();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.RecordFactory <em>CCI Record Factory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.RecordFactory
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIRecordFactory()
		 * @generated
		 */
		public static final EClass CCI_RECORD_FACTORY = eINSTANCE.getCCIRecordFactory();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.MappedRecord <em>CCI Mapped Record</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.MappedRecord
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIMappedRecord()
		 * @generated
		 */
		public static final EClass CCI_MAPPED_RECORD = eINSTANCE.getCCIMappedRecord();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.IndexedRecord <em>CCI Indexed Record</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.IndexedRecord
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIIndexedRecord()
		 * @generated
		 */
		public static final EClass CCI_INDEXED_RECORD = eINSTANCE.getCCIIndexedRecord();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.InteractionSpec <em>CCI Interaction Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.InteractionSpec
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIInteractionSpec()
		 * @generated
		 */
		public static final EClass CCI_INTERACTION_SPEC = eINSTANCE.getCCIInteractionSpec();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.Interaction <em>CCI Interaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.Interaction
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIInteraction()
		 * @generated
		 */
		public static final EClass CCI_INTERACTION = eINSTANCE.getCCIInteraction();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.ConnectionFactory <em>CCI Connection Factory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.ConnectionFactory
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIConnectionFactory()
		 * @generated
		 */
		public static final EClass CCI_CONNECTION_FACTORY = eINSTANCE.getCCIConnectionFactory();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.Connection <em>CCI Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.Connection
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIConnection()
		 * @generated
		 */
		public static final EClass CCI_CONNECTION = eINSTANCE.getCCIConnection();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.ConnectionSpec <em>CCI Connection Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.ConnectionSpec
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIConnectionSpec()
		 * @generated
		 */
		public static final EClass CCI_CONNECTION_SPEC = eINSTANCE.getCCIConnectionSpec();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.ConnectionMetaData <em>CCI Connection Meta Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.ConnectionMetaData
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIConnectionMetaData()
		 * @generated
		 */
		public static final EClass CCI_CONNECTION_META_DATA = eINSTANCE.getCCIConnectionMetaData();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.LocalTransaction <em>CCI Local Transaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.LocalTransaction
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCILocalTransaction()
		 * @generated
		 */
		public static final EClass CCI_LOCAL_TRANSACTION = eINSTANCE.getCCILocalTransaction();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.ResourceAdapterMetaData <em>CCI Resource Adapter Meta Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.ResourceAdapterMetaData
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIResourceAdapterMetaData()
		 * @generated
		 */
		public static final EClass CCI_RESOURCE_ADAPTER_META_DATA = eINSTANCE.getCCIResourceAdapterMetaData();

		/**
		 * The meta object literal for the '<em>Object Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getObjectArray()
		 * @generated
		 */
		public static final EDataType OBJECT_ARRAY = eINSTANCE.getObjectArray();

		/**
		 * The meta object literal for the '<em>String Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getStringArray()
		 * @generated
		 */
		public static final EDataType STRING_ARRAY = eINSTANCE.getStringArray();

		/**
		 * The meta object literal for the '<em>Mapped Record Collection</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Collection
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getMappedRecordCollection()
		 * @generated
		 */
		public static final EDataType MAPPED_RECORD_COLLECTION = eINSTANCE.getMappedRecordCollection();

		/**
		 * The meta object literal for the '<em>Mapped Record List Iterator</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.ListIterator
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getMappedRecordListIterator()
		 * @generated
		 */
		public static final EDataType MAPPED_RECORD_LIST_ITERATOR = eINSTANCE.getMappedRecordListIterator();

		/**
		 * The meta object literal for the '<em>Mapped Record Iterator</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Iterator
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getMappedRecordIterator()
		 * @generated
		 */
		public static final EDataType MAPPED_RECORD_ITERATOR = eINSTANCE.getMappedRecordIterator();

		/**
		 * The meta object literal for the '<em>Mapped Record List</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.List
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getMappedRecordList()
		 * @generated
		 */
		public static final EDataType MAPPED_RECORD_LIST = eINSTANCE.getMappedRecordList();

		/**
		 * The meta object literal for the '<em>Raw Collection</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Collection
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getRawCollection()
		 * @generated
		 */
		public static final EDataType RAW_COLLECTION = eINSTANCE.getRawCollection();

		/**
		 * The meta object literal for the '<em>Raw Map</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Map
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getRawMap()
		 * @generated
		 */
		public static final EDataType RAW_MAP = eINSTANCE.getRawMap();

		/**
		 * The meta object literal for the '<em>Raw Set</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Set
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getRawSet()
		 * @generated
		 */
		public static final EDataType RAW_SET = eINSTANCE.getRawSet();

		/**
		 * The meta object literal for the '<em>Properties</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Properties
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getProperties()
		 * @generated
		 */
		public static final EDataType PROPERTIES = eINSTANCE.getProperties();

		/**
		 * The meta object literal for the '<em>Resource Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.ResourceException
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getResourceException()
		 * @generated
		 */
		public static final EDataType RESOURCE_EXCEPTION = eINSTANCE.getResourceException();

		/**
		 * The meta object literal for the '<em>Resource Warning</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.ResourceWarning
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getResourceWarning()
		 * @generated
		 */
		public static final EDataType RESOURCE_WARNING = eINSTANCE.getResourceWarning();

		/**
		 * The meta object literal for the '<em>Result Set Info</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.ResultSetInfo
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getResultSetInfo()
		 * @generated
		 */
		public static final EDataType RESULT_SET_INFO = eINSTANCE.getResultSetInfo();

		/**
		 * The meta object literal for the '<em>Reference</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.naming.Reference
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getReference()
		 * @generated
		 */
		public static final EDataType REFERENCE = eINSTANCE.getReference();

		/**
		 * The meta object literal for the '<em>Registry</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecore.EPackage.Registry
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getRegistry()
		 * @generated
		 */
		public static final EDataType REGISTRY = eINSTANCE.getRegistry();

	}

	/**
	 * @generated NOT
	 */
	@Override
	protected void eSetDirectResource(Internal resource)
	{
		int savedFlags = eFlags;
		eFlags &= ~EFROZEN;
	    super.eSetDirectResource(resource);
	    eFlags = savedFlags;
	}

} //CciPackageImpl
