/**
 */
package org.jboss.jca.adapters.sap.model.cci.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.jboss.jca.adapters.sap.model.cci.*;
import org.jboss.jca.adapters.sap.model.cci.CciFactory;
import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.cci.Connection;
import org.jboss.jca.adapters.sap.model.cci.ConnectionFactory;
import org.jboss.jca.adapters.sap.model.cci.ConnectionSpec;
import org.jboss.jca.adapters.sap.model.cci.ConnectionState;
import org.jboss.jca.adapters.sap.model.cci.Execution;
import org.jboss.jca.adapters.sap.model.cci.Interaction;
import org.jboss.jca.adapters.sap.model.cci.InteractionSpec;
import org.jboss.jca.adapters.sap.model.cci.InteractionState;
import org.jboss.jca.adapters.sap.model.cci.RecordFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CciFactoryImpl extends EFactoryImpl implements CciFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CciFactory init() {
		try {
			CciFactory theCciFactory = (CciFactory)EPackage.Registry.INSTANCE.getEFactory("http://sap.adapters.jca.jboss.org/cci"); 
			if (theCciFactory != null) {
				return theCciFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CciFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CciFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CciPackage.CONNECTION_FACTORY: return createConnectionFactory();
			case CciPackage.CONNECTION: return createConnection();
			case CciPackage.CONNECTION_SPEC: return createConnectionSpec();
			case CciPackage.INTERACTION: return createInteraction();
			case CciPackage.EXECUTION: return createExecution();
			case CciPackage.INTERACTION_SPEC: return createInteractionSpec();
			case CciPackage.RECORD_FACTORY: return createRecordFactory();
			case CciPackage.MAPPED_RECORD: return createMappedRecord();
			case CciPackage.INDEXED_RECORD: return createIndexedRecord();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CciPackage.CONNECTION_STATE:
				return createConnectionStateFromString(eDataType, initialValue);
			case CciPackage.INTERACTION_STATE:
				return createInteractionStateFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CciPackage.CONNECTION_STATE:
				return convertConnectionStateToString(eDataType, instanceValue);
			case CciPackage.INTERACTION_STATE:
				return convertInteractionStateToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionFactory createConnectionFactory() {
		ConnectionFactoryImpl connectionFactory = new ConnectionFactoryImpl();
		return connectionFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection createConnection() {
		ConnectionImpl connection = new ConnectionImpl();
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionSpec createConnectionSpec() {
		ConnectionSpecImpl connectionSpec = new ConnectionSpecImpl();
		return connectionSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interaction createInteraction() {
		InteractionImpl interaction = new InteractionImpl();
		return interaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionSpec createInteractionSpec() {
		InteractionSpecImpl interactionSpec = new InteractionSpecImpl();
		return interactionSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecordFactory createRecordFactory() {
		RecordFactoryImpl recordFactory = new RecordFactoryImpl();
		return recordFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappedRecord createMappedRecord() {
		MappedRecordImpl mappedRecord = new MappedRecordImpl();
		return mappedRecord;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R extends MappedRecord> IndexedRecord<R> createIndexedRecord() {
		IndexedRecordImpl<R> indexedRecord = new IndexedRecordImpl<R>();
		return indexedRecord;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Execution createExecution() {
		ExecutionImpl execution = new ExecutionImpl();
		return execution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionState createConnectionStateFromString(EDataType eDataType, String initialValue) {
		ConnectionState result = ConnectionState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConnectionStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionState createInteractionStateFromString(EDataType eDataType, String initialValue) {
		InteractionState result = InteractionState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInteractionStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CciPackage getCciPackage() {
		return (CciPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CciPackage getPackage() {
		return CciPackage.eINSTANCE;
	}

} //CciFactoryImpl
