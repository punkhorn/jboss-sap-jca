/**
 */
package org.jboss.jca.adapters.sap.model.cci;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.jboss.jca.adapters.sap.model.cci.CciFactory
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
	CciPackage eINSTANCE = org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionFactoryImpl <em>Connection Factory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.ConnectionFactoryImpl
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getConnectionFactory()
	 * @generated
	 */
	int CONNECTION_FACTORY = 0;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FACTORY__REFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Connection Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FACTORY__CONNECTION_MANAGER = 1;

	/**
	 * The feature id for the '<em><b>Record Factory</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FACTORY__RECORD_FACTORY = 2;

	/**
	 * The feature id for the '<em><b>Managed Connection Factory</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FACTORY__MANAGED_CONNECTION_FACTORY = 3;

	/**
	 * The number of structural features of the '<em>Connection Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FACTORY_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.ConnectionImpl
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 1;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__STATE = 0;

	/**
	 * The feature id for the '<em><b>Connection Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__CONNECTION_NAME = 1;

	/**
	 * The feature id for the '<em><b>Connection Request Info</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__CONNECTION_REQUEST_INFO = 2;

	/**
	 * The feature id for the '<em><b>Managed Connection</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__MANAGED_CONNECTION = 3;

	/**
	 * The feature id for the '<em><b>Connection Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__CONNECTION_MANAGER = 4;

	/**
	 * The feature id for the '<em><b>Interactions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__INTERACTIONS = 5;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl <em>Connection Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getConnectionSpec()
	 * @generated
	 */
	int CONNECTION_SPEC = 2;

	/**
	 * The feature id for the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__USER_NAME = 0;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__PASSWORD = 1;

	/**
	 * The feature id for the '<em><b>Client</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__CLIENT = 2;

	/**
	 * The feature id for the '<em><b>User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__USER = 3;

	/**
	 * The feature id for the '<em><b>Alias User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__ALIAS_USER = 4;

	/**
	 * The feature id for the '<em><b>Passwd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__PASSWD = 5;

	/**
	 * The feature id for the '<em><b>Lang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__LANG = 6;

	/**
	 * The feature id for the '<em><b>Mysapsso2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__MYSAPSSO2 = 7;

	/**
	 * The feature id for the '<em><b>Getsso2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__GETSSO2 = 8;

	/**
	 * The feature id for the '<em><b>X50 9cert</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__X509CERT = 9;

	/**
	 * The feature id for the '<em><b>Lcheck</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__LCHECK = 10;

	/**
	 * The feature id for the '<em><b>Codepage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__CODEPAGE = 11;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__TRACE = 12;

	/**
	 * The feature id for the '<em><b>Use Sapgui</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__USE_SAPGUI = 13;

	/**
	 * The feature id for the '<em><b>Snc Library</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__SNC_LIBRARY = 14;

	/**
	 * The feature id for the '<em><b>Snc Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__SNC_MODE = 15;

	/**
	 * The feature id for the '<em><b>Snc Myname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__SNC_MYNAME = 16;

	/**
	 * The feature id for the '<em><b>Snc Partnername</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__SNC_PARTNERNAME = 17;

	/**
	 * The feature id for the '<em><b>Snc Qop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC__SNC_QOP = 18;

	/**
	 * The number of structural features of the '<em>Connection Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_SPEC_FEATURE_COUNT = 19;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.cci.impl.InteractionImpl <em>Interaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.InteractionImpl
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getInteraction()
	 * @generated
	 */
	int INTERACTION = 3;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__STATE = 0;

	/**
	 * The feature id for the '<em><b>Connection</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__CONNECTION = 1;

	/**
	 * The feature id for the '<em><b>Resource Warning</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__RESOURCE_WARNING = 2;

	/**
	 * The feature id for the '<em><b>Executions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION__EXECUTIONS = 3;

	/**
	 * The number of structural features of the '<em>Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.cci.impl.InteractionSpecImpl <em>Interaction Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.InteractionSpecImpl
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getInteractionSpec()
	 * @generated
	 */
	int INTERACTION_SPEC = 5;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.cci.impl.RecordImpl <em>Record</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.RecordImpl
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getRecord()
	 * @generated
	 */
	int RECORD = 6;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.cci.impl.RecordFactoryImpl <em>Record Factory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.RecordFactoryImpl
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getRecordFactory()
	 * @generated
	 */
	int RECORD_FACTORY = 7;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.cci.impl.MappedRecordImpl <em>Mapped Record</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.MappedRecordImpl
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getMappedRecord()
	 * @generated
	 */
	int MAPPED_RECORD = 8;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.cci.impl.IndexedRecordImpl <em>Indexed Record</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.IndexedRecordImpl
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getIndexedRecord()
	 * @generated
	 */
	int INDEXED_RECORD = 9;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.cci.impl.ExecutionImpl <em>Execution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.ExecutionImpl
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getExecution()
	 * @generated
	 */
	int EXECUTION = 4;

	/**
	 * The feature id for the '<em><b>Interaction Spec</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__INTERACTION_SPEC = 0;

	/**
	 * The feature id for the '<em><b>Input Record</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__INPUT_RECORD = 1;

	/**
	 * The feature id for the '<em><b>Output Record</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__OUTPUT_RECORD = 2;

	/**
	 * The number of structural features of the '<em>Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Function Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_SPEC__FUNCTION_NAME = 0;

	/**
	 * The feature id for the '<em><b>Interaction Verb</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_SPEC__INTERACTION_VERB = 1;

	/**
	 * The feature id for the '<em><b>Execution Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_SPEC__EXECUTION_TIMEOUT = 2;

	/**
	 * The number of structural features of the '<em>Interaction Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_SPEC_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Record Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD__RECORD_NAME = 0;

	/**
	 * The feature id for the '<em><b>Record Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD__RECORD_DESCRIPTION = 1;

	/**
	 * The number of structural features of the '<em>Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Connection Factory</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FACTORY__CONNECTION_FACTORY = 0;

	/**
	 * The feature id for the '<em><b>Indexed Records</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FACTORY__INDEXED_RECORDS = 1;

	/**
	 * The feature id for the '<em><b>Mapped Records</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FACTORY__MAPPED_RECORDS = 2;

	/**
	 * The number of structural features of the '<em>Record Factory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FACTORY_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Record Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_RECORD__RECORD_NAME = RECORD__RECORD_NAME;

	/**
	 * The feature id for the '<em><b>Record Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_RECORD__RECORD_DESCRIPTION = RECORD__RECORD_DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Mapped Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_RECORD_FEATURE_COUNT = RECORD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Record Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEXED_RECORD__RECORD_NAME = RECORD__RECORD_NAME;

	/**
	 * The feature id for the '<em><b>Record Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEXED_RECORD__RECORD_DESCRIPTION = RECORD__RECORD_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Records</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEXED_RECORD__RECORDS = RECORD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Indexed Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEXED_RECORD_FEATURE_COUNT = RECORD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionState <em>Connection State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionState
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getConnectionState()
	 * @generated
	 */
	int CONNECTION_STATE = 10;

	/**
	 * The meta object id for the '{@link org.jboss.jca.adapters.sap.model.cci.InteractionState <em>Interaction State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.cci.InteractionState
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getInteractionState()
	 * @generated
	 */
	int INTERACTION_STATE = 11;

	/**
	 * The meta object id for the '<em>Reference</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.naming.Reference
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 12;

	/**
	 * The meta object id for the '<em>Connection Manager</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.spi.ConnectionManager
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getConnectionManager()
	 * @generated
	 */
	int CONNECTION_MANAGER = 13;

	/**
	 * The meta object id for the '<em>Resource Warning</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.resource.cci.ResourceWarning
	 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getResourceWarning()
	 * @generated
	 */
	int RESOURCE_WARNING = 14;


	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionFactory <em>Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Factory</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionFactory
	 * @generated
	 */
	EClass getConnectionFactory();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionFactory#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionFactory#getReference()
	 * @see #getConnectionFactory()
	 * @generated
	 */
	EAttribute getConnectionFactory_Reference();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionFactory#getConnectionManager <em>Connection Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection Manager</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionFactory#getConnectionManager()
	 * @see #getConnectionFactory()
	 * @generated
	 */
	EAttribute getConnectionFactory_ConnectionManager();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionFactory#getRecordFactory <em>Record Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Record Factory</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionFactory#getRecordFactory()
	 * @see #getConnectionFactory()
	 * @generated
	 */
	EReference getConnectionFactory_RecordFactory();

	/**
	 * Returns the meta object for the container reference '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionFactory#getManagedConnectionFactory <em>Managed Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Managed Connection Factory</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionFactory#getManagedConnectionFactory()
	 * @see #getConnectionFactory()
	 * @generated
	 */
	EReference getConnectionFactory_ManagedConnectionFactory();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.model.cci.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.Connection
	 * @generated
	 */
	EClass getConnection();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.Connection#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.Connection#getState()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_State();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.Connection#getConnectionName <em>Connection Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection Name</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.Connection#getConnectionName()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_ConnectionName();

	/**
	 * Returns the meta object for the container reference '{@link org.jboss.jca.adapters.sap.model.cci.Connection#getManagedConnection <em>Managed Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Managed Connection</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.Connection#getManagedConnection()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_ManagedConnection();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.Connection#getConnectionManager <em>Connection Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection Manager</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.Connection#getConnectionManager()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_ConnectionManager();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.jca.adapters.sap.model.cci.Connection#getInteractions <em>Interactions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Interactions</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.Connection#getInteractions()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_Interactions();

	/**
	 * Returns the meta object for the reference '{@link org.jboss.jca.adapters.sap.model.cci.Connection#getConnectionRequestInfo <em>Connection Request Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connection Request Info</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.Connection#getConnectionRequestInfo()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_ConnectionRequestInfo();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec <em>Connection Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Spec</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionSpec
	 * @generated
	 */
	EClass getConnectionSpec();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getUserName <em>User Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Name</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getUserName()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_UserName();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getPassword()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Password();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getClient <em>Client</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getClient()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Client();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getUser()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_User();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getAliasUser <em>Alias User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias User</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getAliasUser()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_AliasUser();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getPasswd <em>Passwd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Passwd</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getPasswd()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Passwd();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getLang <em>Lang</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lang</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getLang()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Lang();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getMysapsso2 <em>Mysapsso2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mysapsso2</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getMysapsso2()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Mysapsso2();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getGetsso2 <em>Getsso2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Getsso2</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getGetsso2()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Getsso2();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getX509cert <em>X50 9cert</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X50 9cert</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getX509cert()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_X509cert();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getLcheck <em>Lcheck</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lcheck</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getLcheck()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Lcheck();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getCodepage <em>Codepage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Codepage</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getCodepage()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Codepage();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getTrace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trace</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getTrace()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_Trace();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getUseSapgui <em>Use Sapgui</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Sapgui</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getUseSapgui()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_UseSapgui();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getSncLibrary <em>Snc Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snc Library</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getSncLibrary()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_SncLibrary();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getSncMode <em>Snc Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snc Mode</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getSncMode()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_SncMode();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getSncMyname <em>Snc Myname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snc Myname</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getSncMyname()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_SncMyname();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getSncPartnername <em>Snc Partnername</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snc Partnername</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getSncPartnername()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_SncPartnername();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getSncQop <em>Snc Qop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snc Qop</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getSncQop()
	 * @see #getConnectionSpec()
	 * @generated
	 */
	EAttribute getConnectionSpec_SncQop();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.model.cci.Interaction <em>Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interaction</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.Interaction
	 * @generated
	 */
	EClass getInteraction();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.Interaction#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.Interaction#getState()
	 * @see #getInteraction()
	 * @generated
	 */
	EAttribute getInteraction_State();

	/**
	 * Returns the meta object for the container reference '{@link org.jboss.jca.adapters.sap.model.cci.Interaction#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Connection</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.Interaction#getConnection()
	 * @see #getInteraction()
	 * @generated
	 */
	EReference getInteraction_Connection();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.Interaction#getResourceWarning <em>Resource Warning</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Warning</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.Interaction#getResourceWarning()
	 * @see #getInteraction()
	 * @generated
	 */
	EAttribute getInteraction_ResourceWarning();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.jca.adapters.sap.model.cci.Interaction#getExecutions <em>Executions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Executions</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.Interaction#getExecutions()
	 * @see #getInteraction()
	 * @generated
	 */
	EReference getInteraction_Executions();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.model.cci.InteractionSpec <em>Interaction Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interaction Spec</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.InteractionSpec
	 * @generated
	 */
	EClass getInteractionSpec();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.InteractionSpec#getFunctionName <em>Function Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Function Name</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.InteractionSpec#getFunctionName()
	 * @see #getInteractionSpec()
	 * @generated
	 */
	EAttribute getInteractionSpec_FunctionName();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.InteractionSpec#getInteractionVerb <em>Interaction Verb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interaction Verb</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.InteractionSpec#getInteractionVerb()
	 * @see #getInteractionSpec()
	 * @generated
	 */
	EAttribute getInteractionSpec_InteractionVerb();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.InteractionSpec#getExecutionTimeout <em>Execution Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Execution Timeout</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.InteractionSpec#getExecutionTimeout()
	 * @see #getInteractionSpec()
	 * @generated
	 */
	EAttribute getInteractionSpec_ExecutionTimeout();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.model.cci.Record <em>Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Record</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.Record
	 * @generated
	 */
	EClass getRecord();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.Record#getRecordName <em>Record Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Record Name</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.Record#getRecordName()
	 * @see #getRecord()
	 * @generated
	 */
	EAttribute getRecord_RecordName();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.jca.adapters.sap.model.cci.Record#getRecordDescription <em>Record Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Record Description</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.Record#getRecordDescription()
	 * @see #getRecord()
	 * @generated
	 */
	EAttribute getRecord_RecordDescription();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.model.cci.RecordFactory <em>Record Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Record Factory</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.RecordFactory
	 * @generated
	 */
	EClass getRecordFactory();

	/**
	 * Returns the meta object for the container reference '{@link org.jboss.jca.adapters.sap.model.cci.RecordFactory#getConnectionFactory <em>Connection Factory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Connection Factory</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.RecordFactory#getConnectionFactory()
	 * @see #getRecordFactory()
	 * @generated
	 */
	EReference getRecordFactory_ConnectionFactory();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.jca.adapters.sap.model.cci.RecordFactory#getIndexedRecords <em>Indexed Records</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Indexed Records</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.RecordFactory#getIndexedRecords()
	 * @see #getRecordFactory()
	 * @generated
	 */
	EReference getRecordFactory_IndexedRecords();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.jca.adapters.sap.model.cci.RecordFactory#getMappedRecords <em>Mapped Records</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapped Records</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.RecordFactory#getMappedRecords()
	 * @see #getRecordFactory()
	 * @generated
	 */
	EReference getRecordFactory_MappedRecords();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.model.cci.MappedRecord <em>Mapped Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped Record</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.MappedRecord
	 * @generated
	 */
	EClass getMappedRecord();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.model.cci.IndexedRecord <em>Indexed Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Indexed Record</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.IndexedRecord
	 * @generated
	 */
	EClass getIndexedRecord();

	/**
	 * Returns the meta object for the reference list '{@link org.jboss.jca.adapters.sap.model.cci.IndexedRecord#getRecords <em>Records</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Records</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.IndexedRecord#getRecords()
	 * @see #getIndexedRecord()
	 * @generated
	 */
	EReference getIndexedRecord_Records();

	/**
	 * Returns the meta object for class '{@link org.jboss.jca.adapters.sap.model.cci.Execution <em>Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.Execution
	 * @generated
	 */
	EClass getExecution();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.jca.adapters.sap.model.cci.Execution#getInteractionSpec <em>Interaction Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Interaction Spec</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.Execution#getInteractionSpec()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_InteractionSpec();

	/**
	 * Returns the meta object for the reference '{@link org.jboss.jca.adapters.sap.model.cci.Execution#getInputRecord <em>Input Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input Record</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.Execution#getInputRecord()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_InputRecord();

	/**
	 * Returns the meta object for the reference '{@link org.jboss.jca.adapters.sap.model.cci.Execution#getOutputRecord <em>Output Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Output Record</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.Execution#getOutputRecord()
	 * @see #getExecution()
	 * @generated
	 */
	EReference getExecution_OutputRecord();

	/**
	 * Returns the meta object for enum '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionState <em>Connection State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Connection State</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionState
	 * @generated
	 */
	EEnum getConnectionState();

	/**
	 * Returns the meta object for enum '{@link org.jboss.jca.adapters.sap.model.cci.InteractionState <em>Interaction State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Interaction State</em>'.
	 * @see org.jboss.jca.adapters.sap.model.cci.InteractionState
	 * @generated
	 */
	EEnum getInteractionState();

	/**
	 * Returns the meta object for data type '{@link javax.naming.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Reference</em>'.
	 * @see javax.naming.Reference
	 * @model instanceClass="javax.naming.Reference" serializeable="false"
	 * @generated
	 */
	EDataType getReference();

	/**
	 * Returns the meta object for data type '{@link javax.resource.spi.ConnectionManager <em>Connection Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Connection Manager</em>'.
	 * @see javax.resource.spi.ConnectionManager
	 * @model instanceClass="javax.resource.spi.ConnectionManager" serializeable="false"
	 * @generated
	 */
	EDataType getConnectionManager();

	/**
	 * Returns the meta object for data type '{@link javax.resource.cci.ResourceWarning <em>Resource Warning</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Resource Warning</em>'.
	 * @see javax.resource.cci.ResourceWarning
	 * @model instanceClass="javax.resource.cci.ResourceWarning" serializeable="false"
	 * @generated
	 */
	EDataType getResourceWarning();

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
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionFactoryImpl <em>Connection Factory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.ConnectionFactoryImpl
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getConnectionFactory()
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
		 * The meta object literal for the '<em><b>Connection Manager</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_FACTORY__CONNECTION_MANAGER = eINSTANCE.getConnectionFactory_ConnectionManager();

		/**
		 * The meta object literal for the '<em><b>Record Factory</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_FACTORY__RECORD_FACTORY = eINSTANCE.getConnectionFactory_RecordFactory();

		/**
		 * The meta object literal for the '<em><b>Managed Connection Factory</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_FACTORY__MANAGED_CONNECTION_FACTORY = eINSTANCE.getConnectionFactory_ManagedConnectionFactory();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.ConnectionImpl
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getConnection()
		 * @generated
		 */
		EClass CONNECTION = eINSTANCE.getConnection();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__STATE = eINSTANCE.getConnection_State();

		/**
		 * The meta object literal for the '<em><b>Connection Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__CONNECTION_NAME = eINSTANCE.getConnection_ConnectionName();

		/**
		 * The meta object literal for the '<em><b>Managed Connection</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__MANAGED_CONNECTION = eINSTANCE.getConnection_ManagedConnection();

		/**
		 * The meta object literal for the '<em><b>Connection Manager</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__CONNECTION_MANAGER = eINSTANCE.getConnection_ConnectionManager();

		/**
		 * The meta object literal for the '<em><b>Interactions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__INTERACTIONS = eINSTANCE.getConnection_Interactions();

		/**
		 * The meta object literal for the '<em><b>Connection Request Info</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__CONNECTION_REQUEST_INFO = eINSTANCE.getConnection_ConnectionRequestInfo();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl <em>Connection Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.ConnectionSpecImpl
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getConnectionSpec()
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
		 * The meta object literal for the '<em><b>Getsso2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__GETSSO2 = eINSTANCE.getConnectionSpec_Getsso2();

		/**
		 * The meta object literal for the '<em><b>X50 9cert</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__X509CERT = eINSTANCE.getConnectionSpec_X509cert();

		/**
		 * The meta object literal for the '<em><b>Lcheck</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__LCHECK = eINSTANCE.getConnectionSpec_Lcheck();

		/**
		 * The meta object literal for the '<em><b>Codepage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__CODEPAGE = eINSTANCE.getConnectionSpec_Codepage();

		/**
		 * The meta object literal for the '<em><b>Trace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__TRACE = eINSTANCE.getConnectionSpec_Trace();

		/**
		 * The meta object literal for the '<em><b>Use Sapgui</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__USE_SAPGUI = eINSTANCE.getConnectionSpec_UseSapgui();

		/**
		 * The meta object literal for the '<em><b>Snc Library</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__SNC_LIBRARY = eINSTANCE.getConnectionSpec_SncLibrary();

		/**
		 * The meta object literal for the '<em><b>Snc Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__SNC_MODE = eINSTANCE.getConnectionSpec_SncMode();

		/**
		 * The meta object literal for the '<em><b>Snc Myname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_SPEC__SNC_MYNAME = eINSTANCE.getConnectionSpec_SncMyname();

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
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.cci.impl.InteractionImpl <em>Interaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.InteractionImpl
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getInteraction()
		 * @generated
		 */
		EClass INTERACTION = eINSTANCE.getInteraction();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERACTION__STATE = eINSTANCE.getInteraction_State();

		/**
		 * The meta object literal for the '<em><b>Connection</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTION__CONNECTION = eINSTANCE.getInteraction_Connection();

		/**
		 * The meta object literal for the '<em><b>Resource Warning</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERACTION__RESOURCE_WARNING = eINSTANCE.getInteraction_ResourceWarning();

		/**
		 * The meta object literal for the '<em><b>Executions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTION__EXECUTIONS = eINSTANCE.getInteraction_Executions();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.cci.impl.InteractionSpecImpl <em>Interaction Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.InteractionSpecImpl
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getInteractionSpec()
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
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.cci.impl.RecordImpl <em>Record</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.RecordImpl
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getRecord()
		 * @generated
		 */
		EClass RECORD = eINSTANCE.getRecord();

		/**
		 * The meta object literal for the '<em><b>Record Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECORD__RECORD_NAME = eINSTANCE.getRecord_RecordName();

		/**
		 * The meta object literal for the '<em><b>Record Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECORD__RECORD_DESCRIPTION = eINSTANCE.getRecord_RecordDescription();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.cci.impl.RecordFactoryImpl <em>Record Factory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.RecordFactoryImpl
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getRecordFactory()
		 * @generated
		 */
		EClass RECORD_FACTORY = eINSTANCE.getRecordFactory();

		/**
		 * The meta object literal for the '<em><b>Connection Factory</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECORD_FACTORY__CONNECTION_FACTORY = eINSTANCE.getRecordFactory_ConnectionFactory();

		/**
		 * The meta object literal for the '<em><b>Indexed Records</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECORD_FACTORY__INDEXED_RECORDS = eINSTANCE.getRecordFactory_IndexedRecords();

		/**
		 * The meta object literal for the '<em><b>Mapped Records</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECORD_FACTORY__MAPPED_RECORDS = eINSTANCE.getRecordFactory_MappedRecords();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.cci.impl.MappedRecordImpl <em>Mapped Record</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.MappedRecordImpl
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getMappedRecord()
		 * @generated
		 */
		EClass MAPPED_RECORD = eINSTANCE.getMappedRecord();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.cci.impl.IndexedRecordImpl <em>Indexed Record</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.IndexedRecordImpl
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getIndexedRecord()
		 * @generated
		 */
		EClass INDEXED_RECORD = eINSTANCE.getIndexedRecord();

		/**
		 * The meta object literal for the '<em><b>Records</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEXED_RECORD__RECORDS = eINSTANCE.getIndexedRecord_Records();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.cci.impl.ExecutionImpl <em>Execution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.ExecutionImpl
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getExecution()
		 * @generated
		 */
		EClass EXECUTION = eINSTANCE.getExecution();

		/**
		 * The meta object literal for the '<em><b>Interaction Spec</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION__INTERACTION_SPEC = eINSTANCE.getExecution_InteractionSpec();

		/**
		 * The meta object literal for the '<em><b>Input Record</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION__INPUT_RECORD = eINSTANCE.getExecution_InputRecord();

		/**
		 * The meta object literal for the '<em><b>Output Record</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION__OUTPUT_RECORD = eINSTANCE.getExecution_OutputRecord();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionState <em>Connection State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.cci.ConnectionState
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getConnectionState()
		 * @generated
		 */
		EEnum CONNECTION_STATE = eINSTANCE.getConnectionState();

		/**
		 * The meta object literal for the '{@link org.jboss.jca.adapters.sap.model.cci.InteractionState <em>Interaction State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.jca.adapters.sap.model.cci.InteractionState
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getInteractionState()
		 * @generated
		 */
		EEnum INTERACTION_STATE = eINSTANCE.getInteractionState();

		/**
		 * The meta object literal for the '<em>Reference</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.naming.Reference
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getReference()
		 * @generated
		 */
		EDataType REFERENCE = eINSTANCE.getReference();

		/**
		 * The meta object literal for the '<em>Connection Manager</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.spi.ConnectionManager
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getConnectionManager()
		 * @generated
		 */
		EDataType CONNECTION_MANAGER = eINSTANCE.getConnectionManager();

		/**
		 * The meta object literal for the '<em>Resource Warning</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.resource.cci.ResourceWarning
		 * @see org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl#getResourceWarning()
		 * @generated
		 */
		EDataType RESOURCE_WARNING = eINSTANCE.getResourceWarning();

	}

} //CciPackage
