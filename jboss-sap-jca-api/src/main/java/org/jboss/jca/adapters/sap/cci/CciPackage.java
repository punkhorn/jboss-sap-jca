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
package org.jboss.jca.adapters.sap.cci;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.jboss.jca.adapters.sap.cci.CciFactory
 * @model kind="package"
 * @generated
 */
public interface CciPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cci";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.adapters.jca.jboss.org/cci";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cci";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CciPackage eINSTANCE = org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl.init();

	/**
	 * The meta object id for the '{@link javax.resource.cci.RecordFactory <em>CCI Record Factory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.RecordFactory
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIRecordFactory()
	 * @generated
	 */
	int CCI_RECORD_FACTORY = 12;

	/**
	 * The number of structural features of the '<em>CCI Record Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCI_RECORD_FACTORY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.cci.impl.RecordFactoryImpl <em>Record Factory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.RecordFactoryImpl
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getRecordFactory()
	 * @generated
	 */
	int RECORD_FACTORY = 0;

	/**
	 * The number of structural features of the '<em>Record Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FACTORY_FEATURE_COUNT = CCI_RECORD_FACTORY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link javax.resource.cci.MappedRecord <em>CCI Mapped Record</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.MappedRecord
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIMappedRecord()
	 * @generated
	 */
	int CCI_MAPPED_RECORD = 13;

	/**
	 * The number of structural features of the '<em>CCI Mapped Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCI_MAPPED_RECORD_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.cci.impl.MappedRecordImpl <em>Mapped Record</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.MappedRecordImpl
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getMappedRecord()
	 * @generated
	 */
	int MAPPED_RECORD = 1;

	/**
	 * The feature id for the '<em><b>Record Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_RECORD__RECORD_NAME = CCI_MAPPED_RECORD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Record Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_RECORD__RECORD_SHORT_DESCRIPTION = CCI_MAPPED_RECORD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapped Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_RECORD_FEATURE_COUNT = CCI_MAPPED_RECORD_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link javax.resource.cci.IndexedRecord <em>CCI Indexed Record</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.IndexedRecord
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIIndexedRecord()
	 * @generated
	 */
	int CCI_INDEXED_RECORD = 14;

	/**
	 * The number of structural features of the '<em>CCI Indexed Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCI_INDEXED_RECORD_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.cci.impl.IndexedRecordImpl <em>Indexed Record</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.IndexedRecordImpl
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getIndexedRecord()
	 * @generated
	 */
	int INDEXED_RECORD = 2;

	/**
	 * The feature id for the '<em><b>Record Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEXED_RECORD__RECORD_NAME = CCI_INDEXED_RECORD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Record Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEXED_RECORD__RECORD_SHORT_DESCRIPTION = CCI_INDEXED_RECORD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Record Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEXED_RECORD__RECORD_TYPE = CCI_INDEXED_RECORD_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Indexed Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEXED_RECORD_FEATURE_COUNT = CCI_INDEXED_RECORD_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link javax.resource.cci.InteractionSpec <em>CCI Interaction Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.InteractionSpec
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIInteractionSpec()
	 * @generated
	 */
	int CCI_INTERACTION_SPEC = 15;

	/**
	 * The number of structural features of the '<em>CCI Interaction Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCI_INTERACTION_SPEC_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.cci.impl.InteractionSpecImpl <em>Interaction Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.InteractionSpecImpl
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getInteractionSpec()
	 * @generated
	 */
	int INTERACTION_SPEC = 3;

	/**
	 * The feature id for the '<em><b>Function Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_SPEC__FUNCTION_NAME = CCI_INTERACTION_SPEC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Interaction Verb</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_SPEC__INTERACTION_VERB = CCI_INTERACTION_SPEC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Execution Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_SPEC__EXECUTION_TIMEOUT = CCI_INTERACTION_SPEC_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Interaction Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_SPEC_FEATURE_COUNT = CCI_INTERACTION_SPEC_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link javax.resource.cci.Interaction <em>CCI Interaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.Interaction
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIInteraction()
	 * @generated
	 */
	int CCI_INTERACTION = 16;

	/**
	 * The number of structural features of the '<em>CCI Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCI_INTERACTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.cci.impl.InteractionImpl <em>Interaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.InteractionImpl
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getInteraction()
	 * @generated
	 */
	int INTERACTION = 4;

	/**
	 * The number of structural features of the '<em>Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_FEATURE_COUNT = CCI_INTERACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link javax.resource.cci.ConnectionFactory <em>CCI Connection Factory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.ConnectionFactory
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIConnectionFactory()
	 * @generated
	 */
	int CCI_CONNECTION_FACTORY = 17;

	/**
	 * The number of structural features of the '<em>CCI Connection Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCI_CONNECTION_FACTORY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionFactoryImpl <em>Connection Factory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.ConnectionFactoryImpl
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getConnectionFactory()
	 * @generated
	 */
	int CONNECTION_FACTORY = 5;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FACTORY__REFERENCE = CCI_CONNECTION_FACTORY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Connection Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FACTORY_FEATURE_COUNT = CCI_CONNECTION_FACTORY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link javax.resource.cci.Connection <em>CCI Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.Connection
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIConnection()
	 * @generated
	 */
	int CCI_CONNECTION = 18;

	/**
	 * The number of structural features of the '<em>CCI Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCI_CONNECTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.ConnectionImpl
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 6;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FEATURE_COUNT = CCI_CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link javax.resource.cci.ConnectionSpec <em>CCI Connection Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.ConnectionSpec
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIConnectionSpec()
	 * @generated
	 */
	int CCI_CONNECTION_SPEC = 19;

	/**
	 * The number of structural features of the '<em>CCI Connection Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCI_CONNECTION_SPEC_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl <em>Connection Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getConnectionSpec()
	 * @generated
	 */
	int CONNECTION_SPEC = 7;

	/**
	 * The feature id for the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__USER_NAME = CCI_CONNECTION_SPEC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__PASSWORD = CCI_CONNECTION_SPEC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Auth Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__AUTH_TYPE = CCI_CONNECTION_SPEC_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__USER_ID = CCI_CONNECTION_SPEC_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Client</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__CLIENT = CCI_CONNECTION_SPEC_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__USER = CCI_CONNECTION_SPEC_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Alias User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__ALIAS_USER = CCI_CONNECTION_SPEC_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Passwd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__PASSWD = CCI_CONNECTION_SPEC_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Lang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__LANG = CCI_CONNECTION_SPEC_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Mysapsso2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__MYSAPSSO2 = CCI_CONNECTION_SPEC_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>X50 9cert</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__X509CERT = CCI_CONNECTION_SPEC_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Pcs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__PCS = CCI_CONNECTION_SPEC_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__TYPE = CCI_CONNECTION_SPEC_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Saprouter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__SAPROUTER = CCI_CONNECTION_SPEC_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Sysnr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__SYSNR = CCI_CONNECTION_SPEC_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Ashost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__ASHOST = CCI_CONNECTION_SPEC_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Mshost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__MSHOST = CCI_CONNECTION_SPEC_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Msserv</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__MSSERV = CCI_CONNECTION_SPEC_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Gwhost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__GWHOST = CCI_CONNECTION_SPEC_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Gwserv</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__GWSERV = CCI_CONNECTION_SPEC_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Tphost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__TPHOST = CCI_CONNECTION_SPEC_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Tpname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__TPNAME = CCI_CONNECTION_SPEC_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>R3name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__R3NAME = CCI_CONNECTION_SPEC_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__GROUP = CCI_CONNECTION_SPEC_FEATURE_COUNT + 23;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__TRACE = CCI_CONNECTION_SPEC_FEATURE_COUNT + 24;

	/**
	 * The feature id for the '<em><b>Cpic Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__CPIC_TRACE = CCI_CONNECTION_SPEC_FEATURE_COUNT + 25;

	/**
	 * The feature id for the '<em><b>Lcheck</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__LCHECK = CCI_CONNECTION_SPEC_FEATURE_COUNT + 26;

	/**
	 * The feature id for the '<em><b>Use Sapgui</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__USE_SAPGUI = CCI_CONNECTION_SPEC_FEATURE_COUNT + 27;

	/**
	 * The feature id for the '<em><b>Codepage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__CODEPAGE = CCI_CONNECTION_SPEC_FEATURE_COUNT + 28;

	/**
	 * The feature id for the '<em><b>Getsso2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__GETSSO2 = CCI_CONNECTION_SPEC_FEATURE_COUNT + 29;

	/**
	 * The feature id for the '<em><b>Deny Initial Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__DENY_INITIAL_PASSWORD = CCI_CONNECTION_SPEC_FEATURE_COUNT + 30;

	/**
	 * The feature id for the '<em><b>Peak Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__PEAK_LIMIT = CCI_CONNECTION_SPEC_FEATURE_COUNT + 31;

	/**
	 * The feature id for the '<em><b>Pool Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__POOL_CAPACITY = CCI_CONNECTION_SPEC_FEATURE_COUNT + 32;

	/**
	 * The feature id for the '<em><b>Expiration Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__EXPIRATION_TIME = CCI_CONNECTION_SPEC_FEATURE_COUNT + 33;

	/**
	 * The feature id for the '<em><b>Expiration Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__EXPIRATION_PERIOD = CCI_CONNECTION_SPEC_FEATURE_COUNT + 34;

	/**
	 * The feature id for the '<em><b>Max Get Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__MAX_GET_TIME = CCI_CONNECTION_SPEC_FEATURE_COUNT + 35;

	/**
	 * The feature id for the '<em><b>Snc Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__SNC_MODE = CCI_CONNECTION_SPEC_FEATURE_COUNT + 36;

	/**
	 * The feature id for the '<em><b>Snc Partnername</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__SNC_PARTNERNAME = CCI_CONNECTION_SPEC_FEATURE_COUNT + 37;

	/**
	 * The feature id for the '<em><b>Snc Qop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__SNC_QOP = CCI_CONNECTION_SPEC_FEATURE_COUNT + 38;

	/**
	 * The feature id for the '<em><b>Snc Myname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__SNC_MYNAME = CCI_CONNECTION_SPEC_FEATURE_COUNT + 39;

	/**
	 * The feature id for the '<em><b>Snc Library</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__SNC_LIBRARY = CCI_CONNECTION_SPEC_FEATURE_COUNT + 40;

	/**
	 * The feature id for the '<em><b>Repository Dest</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__REPOSITORY_DEST = CCI_CONNECTION_SPEC_FEATURE_COUNT + 41;

	/**
	 * The feature id for the '<em><b>Repository User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__REPOSITORY_USER = CCI_CONNECTION_SPEC_FEATURE_COUNT + 42;

	/**
	 * The feature id for the '<em><b>Repository Passwd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__REPOSITORY_PASSWD = CCI_CONNECTION_SPEC_FEATURE_COUNT + 43;

	/**
	 * The feature id for the '<em><b>Repository Snc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__REPOSITORY_SNC = CCI_CONNECTION_SPEC_FEATURE_COUNT + 44;

	/**
	 * The feature id for the '<em><b>Repository Roundtrip Optimization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__REPOSITORY_ROUNDTRIP_OPTIMIZATION = CCI_CONNECTION_SPEC_FEATURE_COUNT + 45;

	/**
	 * The feature id for the '<em><b>Ping On Create</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__PING_ON_CREATE = CCI_CONNECTION_SPEC_FEATURE_COUNT + 46;

	/**
	 * The number of structural features of the '<em>Connection Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC_FEATURE_COUNT = CCI_CONNECTION_SPEC_FEATURE_COUNT + 47;

	/**
	 * The meta object id for the '{@link javax.resource.cci.ConnectionMetaData <em>CCI Connection Meta Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.ConnectionMetaData
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIConnectionMetaData()
	 * @generated
	 */
	int CCI_CONNECTION_META_DATA = 20;

	/**
	 * The number of structural features of the '<em>CCI Connection Meta Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCI_CONNECTION_META_DATA_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionMetaDataImpl <em>Connection Meta Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.ConnectionMetaDataImpl
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getConnectionMetaData()
	 * @generated
	 */
	int CONNECTION_META_DATA = 8;

	/**
	 * The number of structural features of the '<em>Connection Meta Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_META_DATA_FEATURE_COUNT = CCI_CONNECTION_META_DATA_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link javax.resource.cci.LocalTransaction <em>CCI Local Transaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.LocalTransaction
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCILocalTransaction()
	 * @generated
	 */
	int CCI_LOCAL_TRANSACTION = 21;

	/**
	 * The number of structural features of the '<em>CCI Local Transaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCI_LOCAL_TRANSACTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.cci.impl.LocalTransactionImpl <em>Local Transaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.LocalTransactionImpl
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getLocalTransaction()
	 * @generated
	 */
	int LOCAL_TRANSACTION = 9;

	/**
	 * The number of structural features of the '<em>Local Transaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_TRANSACTION_FEATURE_COUNT = CCI_LOCAL_TRANSACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link javax.resource.cci.ResourceAdapterMetaData <em>CCI Resource Adapter Meta Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.ResourceAdapterMetaData
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIResourceAdapterMetaData()
	 * @generated
	 */
	int CCI_RESOURCE_ADAPTER_META_DATA = 22;

	/**
	 * The number of structural features of the '<em>CCI Resource Adapter Meta Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCI_RESOURCE_ADAPTER_META_DATA_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.cci.impl.ResourceAdapterMetaDataImpl <em>Resource Adapter Meta Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.ResourceAdapterMetaDataImpl
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getResourceAdapterMetaData()
	 * @generated
	 */
	int RESOURCE_ADAPTER_META_DATA = 10;

	/**
	 * The number of structural features of the '<em>Resource Adapter Meta Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ADAPTER_META_DATA_FEATURE_COUNT = CCI_RESOURCE_ADAPTER_META_DATA_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link javax.resource.cci.Record <em>CCI Record</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.Record
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIRecord()
	 * @generated
	 */
	int CCI_RECORD = 11;

	/**
	 * The number of structural features of the '<em>CCI Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCI_RECORD_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '<em>Mapped Record Iterator</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Iterator
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getMappedRecordIterator()
	 * @generated
	 */
	int MAPPED_RECORD_ITERATOR = 27;

	/**
	 * The meta object id for the '<em>Object Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getObjectArray()
	 * @generated
	 */
	int OBJECT_ARRAY = 23;

	/**
	 * The meta object id for the '<em>String Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getStringArray()
	 * @generated
	 */
	int STRING_ARRAY = 24;

	/**
	 * The meta object id for the '<em>Raw Collection</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Collection
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getRawCollection()
	 * @generated
	 */
	int RAW_COLLECTION = 29;

	/**
	 * The meta object id for the '<em>Mapped Record Collection</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Collection
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getMappedRecordCollection()
	 * @generated
	 */
	int MAPPED_RECORD_COLLECTION = 25;

	/**
	 * The meta object id for the '<em>Mapped Record List Iterator</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.ListIterator
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getMappedRecordListIterator()
	 * @generated
	 */
	int MAPPED_RECORD_LIST_ITERATOR = 26;

	/**
	 * The meta object id for the '<em>Mapped Record List</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getMappedRecordList()
	 * @generated
	 */
	int MAPPED_RECORD_LIST = 28;

	/**
	 * The meta object id for the '<em>Raw Map</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Map
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getRawMap()
	 * @generated
	 */
	int RAW_MAP = 30;

	/**
	 * The meta object id for the '<em>Raw Set</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Set
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getRawSet()
	 * @generated
	 */
	int RAW_SET = 31;

	/**
	 * The meta object id for the '<em>Properties</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Properties
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getProperties()
	 * @generated
	 */
	int PROPERTIES = 32;

	/**
	 * The meta object id for the '<em>Resource Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.ResourceException
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getResourceException()
	 * @generated
	 */
	int RESOURCE_EXCEPTION = 33;

	/**
	 * The meta object id for the '<em>Resource Warning</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.ResourceWarning
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getResourceWarning()
	 * @generated
	 */
	int RESOURCE_WARNING = 34;

	/**
	 * The meta object id for the '<em>Result Set Info</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.ResultSetInfo
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getResultSetInfo()
	 * @generated
	 */
	int RESULT_SET_INFO = 35;

	/**
	 * The meta object id for the '<em>Reference</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.naming.Reference
	 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 36;

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.cci.RecordFactory <em>Record Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Record Factory</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.RecordFactory
	 * @generated
	 */
	EClass getRecordFactory();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.cci.MappedRecord <em>Mapped Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped Record</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.MappedRecord
	 * @generated
	 */
	EClass getMappedRecord();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.MappedRecord#getRecordName <em>Record Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Record Name</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.MappedRecord#getRecordName()
	 * @see #getMappedRecord()
	 * @generated
	 */
	EAttribute getMappedRecord_RecordName();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.MappedRecord#getRecordShortDescription <em>Record Short Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Record Short Description</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.MappedRecord#getRecordShortDescription()
	 * @see #getMappedRecord()
	 * @generated
	 */
	EAttribute getMappedRecord_RecordShortDescription();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.cci.IndexedRecord <em>Indexed Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Indexed Record</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.IndexedRecord
	 * @generated
	 */
	EClass getIndexedRecord();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.IndexedRecord#getRecordName <em>Record Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Record Name</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.IndexedRecord#getRecordName()
	 * @see #getIndexedRecord()
	 * @generated
	 */
	EAttribute getIndexedRecord_RecordName();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.IndexedRecord#getRecordShortDescription <em>Record Short Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Record Short Description</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.IndexedRecord#getRecordShortDescription()
	 * @see #getIndexedRecord()
	 * @generated
	 */
	EAttribute getIndexedRecord_RecordShortDescription();

	/**
	 * Returns the meta object for the reference '{@link org.jboss.jca.adapters.sap.cci.IndexedRecord#getRecordType <em>Record Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Record Type</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.IndexedRecord#getRecordType()
	 * @see #getIndexedRecord()
	 * @generated
	 */
	EReference getIndexedRecord_RecordType();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.cci.InteractionSpec <em>Interaction Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interaction Spec</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.InteractionSpec
	 * @generated
	 */
	EClass getInteractionSpec();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.InteractionSpec#getFunctionName <em>Function Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Function Name</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.InteractionSpec#getFunctionName()
	 * @see #getInteractionSpec()
	 * @generated
	 */
	EAttribute getInteractionSpec_FunctionName();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.InteractionSpec#getInteractionVerb <em>Interaction Verb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interaction Verb</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.InteractionSpec#getInteractionVerb()
	 * @see #getInteractionSpec()
	 * @generated
	 */
	EAttribute getInteractionSpec_InteractionVerb();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.InteractionSpec#getExecutionTimeout <em>Execution Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Execution Timeout</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.InteractionSpec#getExecutionTimeout()
	 * @see #getInteractionSpec()
	 * @generated
	 */
	EAttribute getInteractionSpec_ExecutionTimeout();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.cci.Interaction <em>Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interaction</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.Interaction
	 * @generated
	 */
	EClass getInteraction();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.cci.ConnectionFactory <em>Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Factory</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionFactory
	 * @generated
	 */
	EClass getConnectionFactory();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionFactory#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionFactory#getReference()
	 * @see #getConnectionFactory()
	 * @generated
	 */
	EAttribute getConnectionFactory_Reference();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.cci.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.Connection
	 * @generated
	 */
	EClass getConnection();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec <em>Connection Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Spec</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec
	 * @generated
	 */
	EClass getConnectionSpec();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUserName <em>User Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Name</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUserName()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_UserName();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPassword()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Password();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getAuthType <em>Auth Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auth Type</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getAuthType()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_AuthType();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUserId <em>User Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Id</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUserId()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_UserId();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getClient <em>Client</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getClient()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Client();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUser()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_User();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getAliasUser <em>Alias User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias User</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getAliasUser()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_AliasUser();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPasswd <em>Passwd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Passwd</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPasswd()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Passwd();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getLang <em>Lang</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lang</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getLang()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Lang();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMysapsso2 <em>Mysapsso2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mysapsso2</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMysapsso2()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Mysapsso2();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getX509cert <em>X50 9cert</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X50 9cert</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getX509cert()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_X509cert();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPcs <em>Pcs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pcs</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPcs()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Pcs();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getType()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSaprouter <em>Saprouter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Saprouter</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSaprouter()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Saprouter();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSysnr <em>Sysnr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sysnr</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSysnr()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Sysnr();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getAshost <em>Ashost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ashost</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getAshost()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Ashost();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMshost <em>Mshost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mshost</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMshost()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Mshost();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMsserv <em>Msserv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Msserv</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMsserv()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Msserv();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getGwhost <em>Gwhost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gwhost</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getGwhost()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Gwhost();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getGwserv <em>Gwserv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gwserv</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getGwserv()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Gwserv();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getTphost <em>Tphost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tphost</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getTphost()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Tphost();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getTpname <em>Tpname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tpname</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getTpname()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Tpname();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getR3name <em>R3name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>R3name</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getR3name()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_R3name();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getGroup()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Group();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getTrace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trace</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getTrace()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Trace();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getCpicTrace <em>Cpic Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cpic Trace</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getCpicTrace()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_CpicTrace();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getLcheck <em>Lcheck</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lcheck</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getLcheck()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Lcheck();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUseSapgui <em>Use Sapgui</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Sapgui</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getUseSapgui()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_UseSapgui();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getCodepage <em>Codepage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Codepage</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getCodepage()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Codepage();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getGetsso2 <em>Getsso2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Getsso2</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getGetsso2()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Getsso2();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getDenyInitialPassword <em>Deny Initial Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deny Initial Password</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getDenyInitialPassword()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_DenyInitialPassword();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPeakLimit <em>Peak Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Peak Limit</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPeakLimit()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_PeakLimit();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPoolCapacity <em>Pool Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pool Capacity</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPoolCapacity()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_PoolCapacity();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getExpirationTime <em>Expiration Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expiration Time</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getExpirationTime()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_ExpirationTime();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getExpirationPeriod <em>Expiration Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expiration Period</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getExpirationPeriod()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_ExpirationPeriod();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMaxGetTime <em>Max Get Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Get Time</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getMaxGetTime()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_MaxGetTime();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncMode <em>Snc Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snc Mode</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncMode()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_SncMode();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncPartnername <em>Snc Partnername</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snc Partnername</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncPartnername()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_SncPartnername();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncQop <em>Snc Qop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snc Qop</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncQop()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_SncQop();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncMyname <em>Snc Myname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snc Myname</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncMyname()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_SncMyname();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncLibrary <em>Snc Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snc Library</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getSncLibrary()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_SncLibrary();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositoryDest <em>Repository Dest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository Dest</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositoryDest()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_RepositoryDest();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositoryUser <em>Repository User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository User</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositoryUser()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_RepositoryUser();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositoryPasswd <em>Repository Passwd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository Passwd</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositoryPasswd()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_RepositoryPasswd();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositorySnc <em>Repository Snc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository Snc</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositorySnc()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_RepositorySnc();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositoryRoundtripOptimization <em>Repository Roundtrip Optimization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository Roundtrip Optimization</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getRepositoryRoundtripOptimization()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_RepositoryRoundtripOptimization();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPingOnCreate <em>Ping On Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ping On Create</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionSpec#getPingOnCreate()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_PingOnCreate();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.cci.ConnectionMetaData <em>Connection Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Meta Data</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ConnectionMetaData
	 * @generated
	 */
	EClass getConnectionMetaData();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.cci.LocalTransaction <em>Local Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Transaction</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.LocalTransaction
	 * @generated
	 */
	EClass getLocalTransaction();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.cci.ResourceAdapterMetaData <em>Resource Adapter Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Adapter Meta Data</em>'.
	 * @see org.jboss.jca.adapters.sap.cci.ResourceAdapterMetaData
	 * @generated
	 */
	EClass getResourceAdapterMetaData();

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.Record <em>CCI Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Record</em>'.
	 * @see javax.resource.cci.Record
	 * @model instanceClass="javax.resource.cci.Record"
	 * @generated
	 */
	EClass getCCIRecord();

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.RecordFactory <em>CCI Record Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Record Factory</em>'.
	 * @see javax.resource.cci.RecordFactory
	 * @model instanceClass="javax.resource.cci.RecordFactory"
	 * @generated
	 */
	EClass getCCIRecordFactory();

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.MappedRecord <em>CCI Mapped Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Mapped Record</em>'.
	 * @see javax.resource.cci.MappedRecord
	 * @model instanceClass="javax.resource.cci.MappedRecord"
	 * @generated
	 */
	EClass getCCIMappedRecord();

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.IndexedRecord <em>CCI Indexed Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Indexed Record</em>'.
	 * @see javax.resource.cci.IndexedRecord
	 * @model instanceClass="javax.resource.cci.IndexedRecord"
	 * @generated
	 */
	EClass getCCIIndexedRecord();

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.InteractionSpec <em>CCI Interaction Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Interaction Spec</em>'.
	 * @see javax.resource.cci.InteractionSpec
	 * @model instanceClass="javax.resource.cci.InteractionSpec"
	 * @generated
	 */
	EClass getCCIInteractionSpec();

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.Interaction <em>CCI Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Interaction</em>'.
	 * @see javax.resource.cci.Interaction
	 * @model instanceClass="javax.resource.cci.Interaction"
	 * @generated
	 */
	EClass getCCIInteraction();

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.ConnectionFactory <em>CCI Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Connection Factory</em>'.
	 * @see javax.resource.cci.ConnectionFactory
	 * @model instanceClass="javax.resource.cci.ConnectionFactory"
	 * @generated
	 */
	EClass getCCIConnectionFactory();

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.Connection <em>CCI Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Connection</em>'.
	 * @see javax.resource.cci.Connection
	 * @model instanceClass="javax.resource.cci.Connection"
	 * @generated
	 */
	EClass getCCIConnection();

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.ConnectionSpec <em>CCI Connection Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Connection Spec</em>'.
	 * @see javax.resource.cci.ConnectionSpec
	 * @model instanceClass="javax.resource.cci.ConnectionSpec"
	 * @generated
	 */
	EClass getCCIConnectionSpec();

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.ConnectionMetaData <em>CCI Connection Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Connection Meta Data</em>'.
	 * @see javax.resource.cci.ConnectionMetaData
	 * @model instanceClass="javax.resource.cci.ConnectionMetaData"
	 * @generated
	 */
	EClass getCCIConnectionMetaData();

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.LocalTransaction <em>CCI Local Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Local Transaction</em>'.
	 * @see javax.resource.cci.LocalTransaction
	 * @model instanceClass="javax.resource.cci.LocalTransaction"
	 * @generated
	 */
	EClass getCCILocalTransaction();

	/**
	 * Returns the meta object for class '{@link javax.resource.cci.ResourceAdapterMetaData <em>CCI Resource Adapter Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCI Resource Adapter Meta Data</em>'.
	 * @see javax.resource.cci.ResourceAdapterMetaData
	 * @model instanceClass="javax.resource.cci.ResourceAdapterMetaData"
	 * @generated
	 */
	EClass getCCIResourceAdapterMetaData();

	/**
	 * Returns the meta object for data type '{@link java.util.Iterator <em>Mapped Record Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Mapped Record Iterator</em>'.
	 * @see java.util.Iterator
	 * @model instanceClass="java.util.Iterator<org.jboss.jca.adapters.sap.cci.MappedRecord>"
	 * @generated
	 */
	EDataType getMappedRecordIterator();

	/**
	 * Returns the meta object for data type '<em>Object Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Object Array</em>'.
	 * @model instanceClass="java.lang.Object[]"
	 * @generated
	 */
	EDataType getObjectArray();

	/**
	 * Returns the meta object for data type '<em>String Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String Array</em>'.
	 * @model instanceClass="java.lang.String[]"
	 * @generated
	 */
	EDataType getStringArray();

	/**
	 * Returns the meta object for data type '{@link java.util.Collection <em>Raw Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Raw Collection</em>'.
	 * @see java.util.Collection
	 * @model instanceClass="java.util.Collection"
	 * @generated
	 */
	EDataType getRawCollection();

	/**
	 * Returns the meta object for data type '{@link java.util.Collection <em>Mapped Record Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Mapped Record Collection</em>'.
	 * @see java.util.Collection
	 * @model instanceClass="java.util.Collection<org.jboss.jca.adapters.sap.cci.MappedRecord>"
	 * @generated
	 */
	EDataType getMappedRecordCollection();

	/**
	 * Returns the meta object for data type '{@link java.util.ListIterator <em>Mapped Record List Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Mapped Record List Iterator</em>'.
	 * @see java.util.ListIterator
	 * @model instanceClass="java.util.ListIterator<org.jboss.jca.adapters.sap.cci.MappedRecord>"
	 * @generated
	 */
	EDataType getMappedRecordListIterator();

	/**
	 * Returns the meta object for data type '{@link java.util.List <em>Mapped Record List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Mapped Record List</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List<org.jboss.jca.adapters.sap.cci.MappedRecord>"
	 * @generated
	 */
	EDataType getMappedRecordList();

	/**
	 * Returns the meta object for data type '{@link java.util.Map <em>Raw Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Raw Map</em>'.
	 * @see java.util.Map
	 * @model instanceClass="java.util.Map"
	 * @generated
	 */
	EDataType getRawMap();

	/**
	 * Returns the meta object for data type '{@link java.util.Set <em>Raw Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Raw Set</em>'.
	 * @see java.util.Set
	 * @model instanceClass="java.util.Set"
	 * @generated
	 */
	EDataType getRawSet();

	/**
	 * Returns the meta object for data type '{@link java.util.Properties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Properties</em>'.
	 * @see java.util.Properties
	 * @model instanceClass="java.util.Properties"
	 * @generated
	 */
	EDataType getProperties();

	/**
	 * Returns the meta object for data type '{@link javax.resource.ResourceException <em>Resource Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Resource Exception</em>'.
	 * @see javax.resource.ResourceException
	 * @model instanceClass="javax.resource.ResourceException"
	 * @generated
	 */
	EDataType getResourceException();

	/**
	 * Returns the meta object for data type '{@link javax.resource.cci.ResourceWarning <em>Resource Warning</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Resource Warning</em>'.
	 * @see javax.resource.cci.ResourceWarning
	 * @model instanceClass="javax.resource.cci.ResourceWarning"
	 * @generated
	 */
	EDataType getResourceWarning();

	/**
	 * Returns the meta object for data type '{@link javax.resource.cci.ResultSetInfo <em>Result Set Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Result Set Info</em>'.
	 * @see javax.resource.cci.ResultSetInfo
	 * @model instanceClass="javax.resource.cci.ResultSetInfo"
	 * @generated
	 */
	EDataType getResultSetInfo();

	/**
	 * Returns the meta object for data type '{@link javax.naming.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Reference</em>'.
	 * @see javax.naming.Reference
	 * @model instanceClass="javax.naming.Reference"
	 * @generated
	 */
	EDataType getReference();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CciFactory getCciFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.cci.impl.RecordFactoryImpl <em>Record Factory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.RecordFactoryImpl
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getRecordFactory()
		 * @generated
		 */
		EClass RECORD_FACTORY = eINSTANCE.getRecordFactory();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.cci.impl.MappedRecordImpl <em>Mapped Record</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.MappedRecordImpl
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getMappedRecord()
		 * @generated
		 */
		EClass MAPPED_RECORD = eINSTANCE.getMappedRecord();

		/**
		 * The meta object literal for the '<em><b>Record Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPED_RECORD__RECORD_NAME = eINSTANCE.getMappedRecord_RecordName();

		/**
		 * The meta object literal for the '<em><b>Record Short Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPED_RECORD__RECORD_SHORT_DESCRIPTION = eINSTANCE.getMappedRecord_RecordShortDescription();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.cci.impl.IndexedRecordImpl <em>Indexed Record</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.IndexedRecordImpl
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getIndexedRecord()
		 * @generated
		 */
		EClass INDEXED_RECORD = eINSTANCE.getIndexedRecord();

		/**
		 * The meta object literal for the '<em><b>Record Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEXED_RECORD__RECORD_NAME = eINSTANCE.getIndexedRecord_RecordName();

		/**
		 * The meta object literal for the '<em><b>Record Short Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEXED_RECORD__RECORD_SHORT_DESCRIPTION = eINSTANCE.getIndexedRecord_RecordShortDescription();

		/**
		 * The meta object literal for the '<em><b>Record Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEXED_RECORD__RECORD_TYPE = eINSTANCE.getIndexedRecord_RecordType();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.cci.impl.InteractionSpecImpl <em>Interaction Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.InteractionSpecImpl
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getInteractionSpec()
		 * @generated
		 */
		EClass INTERACTION_SPEC = eINSTANCE.getInteractionSpec();

		/**
		 * The meta object literal for the '<em><b>Function Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERACTION_SPEC__FUNCTION_NAME = eINSTANCE.getInteractionSpec_FunctionName();

		/**
		 * The meta object literal for the '<em><b>Interaction Verb</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERACTION_SPEC__INTERACTION_VERB = eINSTANCE.getInteractionSpec_InteractionVerb();

		/**
		 * The meta object literal for the '<em><b>Execution Timeout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERACTION_SPEC__EXECUTION_TIMEOUT = eINSTANCE.getInteractionSpec_ExecutionTimeout();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.cci.impl.InteractionImpl <em>Interaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.InteractionImpl
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getInteraction()
		 * @generated
		 */
		EClass INTERACTION = eINSTANCE.getInteraction();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionFactoryImpl <em>Connection Factory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.ConnectionFactoryImpl
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getConnectionFactory()
		 * @generated
		 */
		EClass CONNECTION_FACTORY = eINSTANCE.getConnectionFactory();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_FACTORY__REFERENCE = eINSTANCE.getConnectionFactory_Reference();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.ConnectionImpl
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getConnection()
		 * @generated
		 */
		EClass CONNECTION = eINSTANCE.getConnection();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl <em>Connection Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getConnectionSpec()
		 * @generated
		 */
		EClass CONNECTION_SPEC = eINSTANCE.getConnectionSpec();

		/**
		 * The meta object literal for the '<em><b>User Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__USER_NAME = eINSTANCE.getConnectionSpec_UserName();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__PASSWORD = eINSTANCE.getConnectionSpec_Password();

		/**
		 * The meta object literal for the '<em><b>Auth Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__AUTH_TYPE = eINSTANCE.getConnectionSpec_AuthType();

		/**
		 * The meta object literal for the '<em><b>User Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__USER_ID = eINSTANCE.getConnectionSpec_UserId();

		/**
		 * The meta object literal for the '<em><b>Client</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__CLIENT = eINSTANCE.getConnectionSpec_Client();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__USER = eINSTANCE.getConnectionSpec_User();

		/**
		 * The meta object literal for the '<em><b>Alias User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__ALIAS_USER = eINSTANCE.getConnectionSpec_AliasUser();

		/**
		 * The meta object literal for the '<em><b>Passwd</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__PASSWD = eINSTANCE.getConnectionSpec_Passwd();

		/**
		 * The meta object literal for the '<em><b>Lang</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__LANG = eINSTANCE.getConnectionSpec_Lang();

		/**
		 * The meta object literal for the '<em><b>Mysapsso2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__MYSAPSSO2 = eINSTANCE.getConnectionSpec_Mysapsso2();

		/**
		 * The meta object literal for the '<em><b>X50 9cert</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__X509CERT = eINSTANCE.getConnectionSpec_X509cert();

		/**
		 * The meta object literal for the '<em><b>Pcs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__PCS = eINSTANCE.getConnectionSpec_Pcs();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__TYPE = eINSTANCE.getConnectionSpec_Type();

		/**
		 * The meta object literal for the '<em><b>Saprouter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__SAPROUTER = eINSTANCE.getConnectionSpec_Saprouter();

		/**
		 * The meta object literal for the '<em><b>Sysnr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__SYSNR = eINSTANCE.getConnectionSpec_Sysnr();

		/**
		 * The meta object literal for the '<em><b>Ashost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__ASHOST = eINSTANCE.getConnectionSpec_Ashost();

		/**
		 * The meta object literal for the '<em><b>Mshost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__MSHOST = eINSTANCE.getConnectionSpec_Mshost();

		/**
		 * The meta object literal for the '<em><b>Msserv</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__MSSERV = eINSTANCE.getConnectionSpec_Msserv();

		/**
		 * The meta object literal for the '<em><b>Gwhost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__GWHOST = eINSTANCE.getConnectionSpec_Gwhost();

		/**
		 * The meta object literal for the '<em><b>Gwserv</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__GWSERV = eINSTANCE.getConnectionSpec_Gwserv();

		/**
		 * The meta object literal for the '<em><b>Tphost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__TPHOST = eINSTANCE.getConnectionSpec_Tphost();

		/**
		 * The meta object literal for the '<em><b>Tpname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__TPNAME = eINSTANCE.getConnectionSpec_Tpname();

		/**
		 * The meta object literal for the '<em><b>R3name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__R3NAME = eINSTANCE.getConnectionSpec_R3name();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__GROUP = eINSTANCE.getConnectionSpec_Group();

		/**
		 * The meta object literal for the '<em><b>Trace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__TRACE = eINSTANCE.getConnectionSpec_Trace();

		/**
		 * The meta object literal for the '<em><b>Cpic Trace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__CPIC_TRACE = eINSTANCE.getConnectionSpec_CpicTrace();

		/**
		 * The meta object literal for the '<em><b>Lcheck</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__LCHECK = eINSTANCE.getConnectionSpec_Lcheck();

		/**
		 * The meta object literal for the '<em><b>Use Sapgui</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__USE_SAPGUI = eINSTANCE.getConnectionSpec_UseSapgui();

		/**
		 * The meta object literal for the '<em><b>Codepage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__CODEPAGE = eINSTANCE.getConnectionSpec_Codepage();

		/**
		 * The meta object literal for the '<em><b>Getsso2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__GETSSO2 = eINSTANCE.getConnectionSpec_Getsso2();

		/**
		 * The meta object literal for the '<em><b>Deny Initial Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__DENY_INITIAL_PASSWORD = eINSTANCE.getConnectionSpec_DenyInitialPassword();

		/**
		 * The meta object literal for the '<em><b>Peak Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__PEAK_LIMIT = eINSTANCE.getConnectionSpec_PeakLimit();

		/**
		 * The meta object literal for the '<em><b>Pool Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__POOL_CAPACITY = eINSTANCE.getConnectionSpec_PoolCapacity();

		/**
		 * The meta object literal for the '<em><b>Expiration Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__EXPIRATION_TIME = eINSTANCE.getConnectionSpec_ExpirationTime();

		/**
		 * The meta object literal for the '<em><b>Expiration Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__EXPIRATION_PERIOD = eINSTANCE.getConnectionSpec_ExpirationPeriod();

		/**
		 * The meta object literal for the '<em><b>Max Get Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__MAX_GET_TIME = eINSTANCE.getConnectionSpec_MaxGetTime();

		/**
		 * The meta object literal for the '<em><b>Snc Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__SNC_MODE = eINSTANCE.getConnectionSpec_SncMode();

		/**
		 * The meta object literal for the '<em><b>Snc Partnername</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__SNC_PARTNERNAME = eINSTANCE.getConnectionSpec_SncPartnername();

		/**
		 * The meta object literal for the '<em><b>Snc Qop</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__SNC_QOP = eINSTANCE.getConnectionSpec_SncQop();

		/**
		 * The meta object literal for the '<em><b>Snc Myname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__SNC_MYNAME = eINSTANCE.getConnectionSpec_SncMyname();

		/**
		 * The meta object literal for the '<em><b>Snc Library</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__SNC_LIBRARY = eINSTANCE.getConnectionSpec_SncLibrary();

		/**
		 * The meta object literal for the '<em><b>Repository Dest</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__REPOSITORY_DEST = eINSTANCE.getConnectionSpec_RepositoryDest();

		/**
		 * The meta object literal for the '<em><b>Repository User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__REPOSITORY_USER = eINSTANCE.getConnectionSpec_RepositoryUser();

		/**
		 * The meta object literal for the '<em><b>Repository Passwd</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__REPOSITORY_PASSWD = eINSTANCE.getConnectionSpec_RepositoryPasswd();

		/**
		 * The meta object literal for the '<em><b>Repository Snc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__REPOSITORY_SNC = eINSTANCE.getConnectionSpec_RepositorySnc();

		/**
		 * The meta object literal for the '<em><b>Repository Roundtrip Optimization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__REPOSITORY_ROUNDTRIP_OPTIMIZATION = eINSTANCE.getConnectionSpec_RepositoryRoundtripOptimization();

		/**
		 * The meta object literal for the '<em><b>Ping On Create</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__PING_ON_CREATE = eINSTANCE.getConnectionSpec_PingOnCreate();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionMetaDataImpl <em>Connection Meta Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.ConnectionMetaDataImpl
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getConnectionMetaData()
		 * @generated
		 */
		EClass CONNECTION_META_DATA = eINSTANCE.getConnectionMetaData();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.cci.impl.LocalTransactionImpl <em>Local Transaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.LocalTransactionImpl
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getLocalTransaction()
		 * @generated
		 */
		EClass LOCAL_TRANSACTION = eINSTANCE.getLocalTransaction();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.cci.impl.ResourceAdapterMetaDataImpl <em>Resource Adapter Meta Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.ResourceAdapterMetaDataImpl
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getResourceAdapterMetaData()
		 * @generated
		 */
		EClass RESOURCE_ADAPTER_META_DATA = eINSTANCE.getResourceAdapterMetaData();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.Record <em>CCI Record</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.Record
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIRecord()
		 * @generated
		 */
		EClass CCI_RECORD = eINSTANCE.getCCIRecord();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.RecordFactory <em>CCI Record Factory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.RecordFactory
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIRecordFactory()
		 * @generated
		 */
		EClass CCI_RECORD_FACTORY = eINSTANCE.getCCIRecordFactory();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.MappedRecord <em>CCI Mapped Record</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.MappedRecord
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIMappedRecord()
		 * @generated
		 */
		EClass CCI_MAPPED_RECORD = eINSTANCE.getCCIMappedRecord();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.IndexedRecord <em>CCI Indexed Record</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.IndexedRecord
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIIndexedRecord()
		 * @generated
		 */
		EClass CCI_INDEXED_RECORD = eINSTANCE.getCCIIndexedRecord();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.InteractionSpec <em>CCI Interaction Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.InteractionSpec
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIInteractionSpec()
		 * @generated
		 */
		EClass CCI_INTERACTION_SPEC = eINSTANCE.getCCIInteractionSpec();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.Interaction <em>CCI Interaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.Interaction
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIInteraction()
		 * @generated
		 */
		EClass CCI_INTERACTION = eINSTANCE.getCCIInteraction();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.ConnectionFactory <em>CCI Connection Factory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.ConnectionFactory
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIConnectionFactory()
		 * @generated
		 */
		EClass CCI_CONNECTION_FACTORY = eINSTANCE.getCCIConnectionFactory();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.Connection <em>CCI Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.Connection
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIConnection()
		 * @generated
		 */
		EClass CCI_CONNECTION = eINSTANCE.getCCIConnection();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.ConnectionSpec <em>CCI Connection Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.ConnectionSpec
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIConnectionSpec()
		 * @generated
		 */
		EClass CCI_CONNECTION_SPEC = eINSTANCE.getCCIConnectionSpec();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.ConnectionMetaData <em>CCI Connection Meta Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.ConnectionMetaData
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIConnectionMetaData()
		 * @generated
		 */
		EClass CCI_CONNECTION_META_DATA = eINSTANCE.getCCIConnectionMetaData();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.LocalTransaction <em>CCI Local Transaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.LocalTransaction
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCILocalTransaction()
		 * @generated
		 */
		EClass CCI_LOCAL_TRANSACTION = eINSTANCE.getCCILocalTransaction();

		/**
		 * The meta object literal for the '{@link javax.resource.cci.ResourceAdapterMetaData <em>CCI Resource Adapter Meta Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.ResourceAdapterMetaData
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getCCIResourceAdapterMetaData()
		 * @generated
		 */
		EClass CCI_RESOURCE_ADAPTER_META_DATA = eINSTANCE.getCCIResourceAdapterMetaData();

		/**
		 * The meta object literal for the '<em>Mapped Record Iterator</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Iterator
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getMappedRecordIterator()
		 * @generated
		 */
		EDataType MAPPED_RECORD_ITERATOR = eINSTANCE.getMappedRecordIterator();

		/**
		 * The meta object literal for the '<em>Object Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getObjectArray()
		 * @generated
		 */
		EDataType OBJECT_ARRAY = eINSTANCE.getObjectArray();

		/**
		 * The meta object literal for the '<em>String Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getStringArray()
		 * @generated
		 */
		EDataType STRING_ARRAY = eINSTANCE.getStringArray();

		/**
		 * The meta object literal for the '<em>Raw Collection</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Collection
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getRawCollection()
		 * @generated
		 */
		EDataType RAW_COLLECTION = eINSTANCE.getRawCollection();

		/**
		 * The meta object literal for the '<em>Mapped Record Collection</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Collection
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getMappedRecordCollection()
		 * @generated
		 */
		EDataType MAPPED_RECORD_COLLECTION = eINSTANCE.getMappedRecordCollection();

		/**
		 * The meta object literal for the '<em>Mapped Record List Iterator</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.ListIterator
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getMappedRecordListIterator()
		 * @generated
		 */
		EDataType MAPPED_RECORD_LIST_ITERATOR = eINSTANCE.getMappedRecordListIterator();

		/**
		 * The meta object literal for the '<em>Mapped Record List</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.List
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getMappedRecordList()
		 * @generated
		 */
		EDataType MAPPED_RECORD_LIST = eINSTANCE.getMappedRecordList();

		/**
		 * The meta object literal for the '<em>Raw Map</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Map
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getRawMap()
		 * @generated
		 */
		EDataType RAW_MAP = eINSTANCE.getRawMap();

		/**
		 * The meta object literal for the '<em>Raw Set</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Set
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getRawSet()
		 * @generated
		 */
		EDataType RAW_SET = eINSTANCE.getRawSet();

		/**
		 * The meta object literal for the '<em>Properties</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Properties
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getProperties()
		 * @generated
		 */
		EDataType PROPERTIES = eINSTANCE.getProperties();

		/**
		 * The meta object literal for the '<em>Resource Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.ResourceException
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getResourceException()
		 * @generated
		 */
		EDataType RESOURCE_EXCEPTION = eINSTANCE.getResourceException();

		/**
		 * The meta object literal for the '<em>Resource Warning</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.ResourceWarning
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getResourceWarning()
		 * @generated
		 */
		EDataType RESOURCE_WARNING = eINSTANCE.getResourceWarning();

		/**
		 * The meta object literal for the '<em>Result Set Info</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.ResultSetInfo
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getResultSetInfo()
		 * @generated
		 */
		EDataType RESULT_SET_INFO = eINSTANCE.getResultSetInfo();

		/**
		 * The meta object literal for the '<em>Reference</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.naming.Reference
		 * @see org.jboss.jca.adapters.sap.cci.impl.CciPackageImpl#getReference()
		 * @generated
		 */
		EDataType REFERENCE = eINSTANCE.getReference();

	}

} //CciPackage
