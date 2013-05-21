/**
 */
package org.jboss.jca.adapters.sap.model.cci.impl;

import javax.naming.Reference;
import javax.resource.cci.ResourceWarning;
import javax.resource.spi.ConnectionManager;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.jboss.jca.adapters.sap.model.cci.CciFactory;
import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.cci.Connection;
import org.jboss.jca.adapters.sap.model.cci.ConnectionFactory;
import org.jboss.jca.adapters.sap.model.cci.ConnectionSpec;
import org.jboss.jca.adapters.sap.model.cci.ConnectionState;
import org.jboss.jca.adapters.sap.model.cci.Execution;
import org.jboss.jca.adapters.sap.model.cci.IndexedRecord;
import org.jboss.jca.adapters.sap.model.cci.Interaction;
import org.jboss.jca.adapters.sap.model.cci.InteractionSpec;
import org.jboss.jca.adapters.sap.model.cci.InteractionState;
import org.jboss.jca.adapters.sap.model.cci.MappedRecord;
import org.jboss.jca.adapters.sap.model.cci.Record;
import org.jboss.jca.adapters.sap.model.cci.RecordFactory;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;
import org.jboss.jca.adapters.sap.model.spi.impl.SpiPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CciPackageImpl extends EPackageImpl implements CciPackage {
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
	private EClass interactionEClass = null;

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
	private EClass recordEClass = null;

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
	private EClass executionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum connectionStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum interactionStateEEnum = null;

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
	private EDataType connectionManagerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType resourceWarningEDataType = null;

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
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CciPackageImpl() {
		super(eNS_URI, CciFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CciPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CciPackage init() {
		if (isInited) return (CciPackage)EPackage.Registry.INSTANCE.getEPackage(CciPackage.eNS_URI);

		// Obtain or create and register package
		CciPackageImpl theCciPackage = (CciPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CciPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CciPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		SpiPackageImpl theSpiPackage = (SpiPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SpiPackage.eNS_URI) instanceof SpiPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SpiPackage.eNS_URI) : SpiPackage.eINSTANCE);

		// Create package meta-data objects
		theCciPackage.createPackageContents();
		theSpiPackage.createPackageContents();

		// Initialize created meta-data
		theCciPackage.initializePackageContents();
		theSpiPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCciPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CciPackage.eNS_URI, theCciPackage);
		return theCciPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectionFactory() {
		return connectionFactoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionFactory_Reference() {
		return (EAttribute)connectionFactoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionFactory_ConnectionManager() {
		return (EAttribute)connectionFactoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionFactory_RecordFactory() {
		return (EReference)connectionFactoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionFactory_ManagedConnectionFactory() {
		return (EReference)connectionFactoryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnection() {
		return connectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnection_State() {
		return (EAttribute)connectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnection_ConnectionName() {
		return (EAttribute)connectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnection_ManagedConnection() {
		return (EReference)connectionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnection_ConnectionManager() {
		return (EAttribute)connectionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnection_Interactions() {
		return (EReference)connectionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnection_ConnectionRequestInfo() {
		return (EReference)connectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectionSpec() {
		return connectionSpecEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_UserName() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Password() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Client() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_User() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_AliasUser() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Passwd() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Lang() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Mysapsso2() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Getsso2() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_X509cert() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Lcheck() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Codepage() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Trace() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_UseSapgui() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_SncLibrary() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_SncMode() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_SncMyname() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_SncPartnername() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_SncQop() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInteraction() {
		return interactionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInteraction_State() {
		return (EAttribute)interactionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInteraction_Connection() {
		return (EReference)interactionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInteraction_ResourceWarning() {
		return (EAttribute)interactionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInteraction_Executions() {
		return (EReference)interactionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInteractionSpec() {
		return interactionSpecEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInteractionSpec_FunctionName() {
		return (EAttribute)interactionSpecEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInteractionSpec_InteractionVerb() {
		return (EAttribute)interactionSpecEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInteractionSpec_ExecutionTimeout() {
		return (EAttribute)interactionSpecEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecord() {
		return recordEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecord_RecordName() {
		return (EAttribute)recordEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecord_RecordDescription() {
		return (EAttribute)recordEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecordFactory() {
		return recordFactoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecordFactory_ConnectionFactory() {
		return (EReference)recordFactoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecordFactory_IndexedRecords() {
		return (EReference)recordFactoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecordFactory_MappedRecords() {
		return (EReference)recordFactoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappedRecord() {
		return mappedRecordEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndexedRecord() {
		return indexedRecordEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexedRecord_Records() {
		return (EReference)indexedRecordEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecution() {
		return executionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecution_InteractionSpec() {
		return (EReference)executionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecution_InputRecord() {
		return (EReference)executionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecution_OutputRecord() {
		return (EReference)executionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConnectionState() {
		return connectionStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getInteractionState() {
		return interactionStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getReference() {
		return referenceEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getConnectionManager() {
		return connectionManagerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getResourceWarning() {
		return resourceWarningEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
		connectionFactoryEClass = createEClass(CONNECTION_FACTORY);
		createEAttribute(connectionFactoryEClass, CONNECTION_FACTORY__REFERENCE);
		createEAttribute(connectionFactoryEClass, CONNECTION_FACTORY__CONNECTION_MANAGER);
		createEReference(connectionFactoryEClass, CONNECTION_FACTORY__RECORD_FACTORY);
		createEReference(connectionFactoryEClass, CONNECTION_FACTORY__MANAGED_CONNECTION_FACTORY);

		connectionEClass = createEClass(CONNECTION);
		createEAttribute(connectionEClass, CONNECTION__STATE);
		createEAttribute(connectionEClass, CONNECTION__CONNECTION_NAME);
		createEReference(connectionEClass, CONNECTION__CONNECTION_REQUEST_INFO);
		createEReference(connectionEClass, CONNECTION__MANAGED_CONNECTION);
		createEAttribute(connectionEClass, CONNECTION__CONNECTION_MANAGER);
		createEReference(connectionEClass, CONNECTION__INTERACTIONS);

		connectionSpecEClass = createEClass(CONNECTION_SPEC);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__USER_NAME);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__PASSWORD);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__CLIENT);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__USER);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__ALIAS_USER);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__PASSWD);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__LANG);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__MYSAPSSO2);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__GETSSO2);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__X509CERT);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__LCHECK);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__CODEPAGE);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__TRACE);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__USE_SAPGUI);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__SNC_LIBRARY);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__SNC_MODE);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__SNC_MYNAME);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__SNC_PARTNERNAME);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__SNC_QOP);

		interactionEClass = createEClass(INTERACTION);
		createEAttribute(interactionEClass, INTERACTION__STATE);
		createEReference(interactionEClass, INTERACTION__CONNECTION);
		createEAttribute(interactionEClass, INTERACTION__RESOURCE_WARNING);
		createEReference(interactionEClass, INTERACTION__EXECUTIONS);

		executionEClass = createEClass(EXECUTION);
		createEReference(executionEClass, EXECUTION__INTERACTION_SPEC);
		createEReference(executionEClass, EXECUTION__INPUT_RECORD);
		createEReference(executionEClass, EXECUTION__OUTPUT_RECORD);

		interactionSpecEClass = createEClass(INTERACTION_SPEC);
		createEAttribute(interactionSpecEClass, INTERACTION_SPEC__FUNCTION_NAME);
		createEAttribute(interactionSpecEClass, INTERACTION_SPEC__INTERACTION_VERB);
		createEAttribute(interactionSpecEClass, INTERACTION_SPEC__EXECUTION_TIMEOUT);

		recordEClass = createEClass(RECORD);
		createEAttribute(recordEClass, RECORD__RECORD_NAME);
		createEAttribute(recordEClass, RECORD__RECORD_DESCRIPTION);

		recordFactoryEClass = createEClass(RECORD_FACTORY);
		createEReference(recordFactoryEClass, RECORD_FACTORY__CONNECTION_FACTORY);
		createEReference(recordFactoryEClass, RECORD_FACTORY__INDEXED_RECORDS);
		createEReference(recordFactoryEClass, RECORD_FACTORY__MAPPED_RECORDS);

		mappedRecordEClass = createEClass(MAPPED_RECORD);

		indexedRecordEClass = createEClass(INDEXED_RECORD);
		createEReference(indexedRecordEClass, INDEXED_RECORD__RECORDS);

		// Create enums
		connectionStateEEnum = createEEnum(CONNECTION_STATE);
		interactionStateEEnum = createEEnum(INTERACTION_STATE);

		// Create data types
		referenceEDataType = createEDataType(REFERENCE);
		connectionManagerEDataType = createEDataType(CONNECTION_MANAGER);
		resourceWarningEDataType = createEDataType(RESOURCE_WARNING);
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

		// Obtain other dependent packages
		SpiPackage theSpiPackage = (SpiPackage)EPackage.Registry.INSTANCE.getEPackage(SpiPackage.eNS_URI);

		// Create type parameters
		ETypeParameter indexedRecordEClass_R = addETypeParameter(indexedRecordEClass, "R");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getMappedRecord());
		indexedRecordEClass_R.getEBounds().add(g1);

		// Add supertypes to classes
		mappedRecordEClass.getESuperTypes().add(this.getRecord());
		indexedRecordEClass.getESuperTypes().add(this.getRecord());

		// Initialize classes and features; add operations and parameters
		initEClass(connectionFactoryEClass, ConnectionFactory.class, "ConnectionFactory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnectionFactory_Reference(), this.getReference(), "reference", null, 0, 1, ConnectionFactory.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionFactory_ConnectionManager(), this.getConnectionManager(), "connectionManager", null, 0, 1, ConnectionFactory.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionFactory_RecordFactory(), this.getRecordFactory(), this.getRecordFactory_ConnectionFactory(), "recordFactory", null, 1, 1, ConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionFactory_ManagedConnectionFactory(), theSpiPackage.getManagedConnectionFactory(), theSpiPackage.getManagedConnectionFactory_ConnectionFactories(), "managedConnectionFactory", null, 1, 1, ConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectionEClass, Connection.class, "Connection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnection_State(), this.getConnectionState(), "state", "INACTIVE", 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnection_ConnectionName(), ecorePackage.getEString(), "connectionName", null, 1, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnection_ConnectionRequestInfo(), theSpiPackage.getConnectionRequestInfo(), null, "connectionRequestInfo", null, 1, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnection_ManagedConnection(), theSpiPackage.getManagedConnection(), theSpiPackage.getManagedConnection_ConnectionHandles(), "managedConnection", null, 0, 1, Connection.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnection_ConnectionManager(), this.getConnectionManager(), "connectionManager", null, 0, 1, Connection.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnection_Interactions(), this.getInteraction(), this.getInteraction_Connection(), "interactions", null, 0, -1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectionSpecEClass, ConnectionSpec.class, "ConnectionSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnectionSpec_UserName(), ecorePackage.getEString(), "userName", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Password(), ecorePackage.getEString(), "password", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Client(), ecorePackage.getEString(), "client", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_User(), ecorePackage.getEString(), "user", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_AliasUser(), ecorePackage.getEString(), "aliasUser", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Passwd(), ecorePackage.getEString(), "passwd", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Lang(), ecorePackage.getEString(), "lang", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Mysapsso2(), ecorePackage.getEString(), "mysapsso2", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Getsso2(), ecorePackage.getEString(), "getsso2", "", 0, 1, ConnectionSpec.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_X509cert(), ecorePackage.getEString(), "x509cert", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Lcheck(), ecorePackage.getEString(), "lcheck", "", 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Codepage(), ecorePackage.getEString(), "codepage", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Trace(), ecorePackage.getEString(), "trace", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_UseSapgui(), ecorePackage.getEString(), "useSapgui", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_SncLibrary(), ecorePackage.getEString(), "sncLibrary", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_SncMode(), ecorePackage.getEString(), "sncMode", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_SncMyname(), ecorePackage.getEString(), "sncMyname", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_SncPartnername(), ecorePackage.getEString(), "sncPartnername", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_SncQop(), ecorePackage.getEString(), "sncQop", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interactionEClass, Interaction.class, "Interaction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInteraction_State(), this.getInteractionState(), "state", "ACTIVE", 0, 1, Interaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInteraction_Connection(), this.getConnection(), this.getConnection_Interactions(), "connection", null, 0, 1, Interaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInteraction_ResourceWarning(), this.getResourceWarning(), "resourceWarning", null, 0, 1, Interaction.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInteraction_Executions(), this.getExecution(), null, "executions", null, 0, -1, Interaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(executionEClass, Execution.class, "Execution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecution_InteractionSpec(), this.getInteractionSpec(), null, "interactionSpec", null, 1, 1, Execution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecution_InputRecord(), this.getMappedRecord(), null, "inputRecord", null, 0, 1, Execution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecution_OutputRecord(), this.getMappedRecord(), null, "outputRecord", null, 0, 1, Execution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interactionSpecEClass, InteractionSpec.class, "InteractionSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInteractionSpec_FunctionName(), ecorePackage.getEString(), "functionName", null, 0, 1, InteractionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInteractionSpec_InteractionVerb(), ecorePackage.getEInt(), "interactionVerb", null, 0, 1, InteractionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInteractionSpec_ExecutionTimeout(), ecorePackage.getEInt(), "executionTimeout", null, 0, 1, InteractionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recordEClass, Record.class, "Record", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRecord_RecordName(), ecorePackage.getEString(), "recordName", null, 0, 1, Record.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRecord_RecordDescription(), ecorePackage.getEString(), "recordDescription", null, 0, 1, Record.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recordFactoryEClass, RecordFactory.class, "RecordFactory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRecordFactory_ConnectionFactory(), this.getConnectionFactory(), this.getConnectionFactory_RecordFactory(), "connectionFactory", null, 0, 1, RecordFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getIndexedRecord());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEReference(getRecordFactory_IndexedRecords(), g1, null, "indexedRecords", null, 0, -1, RecordFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecordFactory_MappedRecords(), this.getMappedRecord(), null, "mappedRecords", null, 0, -1, RecordFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappedRecordEClass, MappedRecord.class, "MappedRecord", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(indexedRecordEClass, IndexedRecord.class, "IndexedRecord", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(indexedRecordEClass_R);
		initEReference(getIndexedRecord_Records(), g1, null, "records", null, 0, -1, IndexedRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(connectionStateEEnum, ConnectionState.class, "ConnectionState");
		addEEnumLiteral(connectionStateEEnum, ConnectionState.ACTIVE);
		addEEnumLiteral(connectionStateEEnum, ConnectionState.INACTIVE);
		addEEnumLiteral(connectionStateEEnum, ConnectionState.CLOSED);

		initEEnum(interactionStateEEnum, InteractionState.class, "InteractionState");
		addEEnumLiteral(interactionStateEEnum, InteractionState.ACTIVE);
		addEEnumLiteral(interactionStateEEnum, InteractionState.CLOSED);

		// Initialize data types
		initEDataType(referenceEDataType, Reference.class, "Reference", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(connectionManagerEDataType, ConnectionManager.class, "ConnectionManager", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(resourceWarningEDataType, ResourceWarning.class, "ResourceWarning", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //CciPackageImpl
