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
import javax.resource.cci.ResourceWarning;
import javax.resource.cci.ResultSetInfo;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.jboss.jca.adapters.sap.cci.*;
import org.jboss.jca.adapters.sap.cci.CciFactory;
import org.jboss.jca.adapters.sap.cci.IndexedRecord;
import org.jboss.jca.adapters.sap.cci.MappedRecord;

import com.sap.conn.jco.JCoMetaData;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("rawtypes")
public class CciFactoryImpl extends EFactoryImpl implements CciFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final CciFactoryImpl eINSTANCE = init();

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CciFactoryImpl init() {
		try {
			CciFactoryImpl theCciFactory = (CciFactoryImpl)EPackage.Registry.INSTANCE.getEFactory("http://sap.adapters.jca.jboss.org/cci"); 
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
	 * @param jcoMetaData
	 * @return
	 * @generated NOT
	 */
	EClass create(JCoMetaData jcoMetaData) {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CciPackageImpl.RECORD_FACTORY: return createRecordFactory();
			case CciPackageImpl.MAPPED_RECORD: return createMappedRecord();
			case CciPackageImpl.INDEXED_RECORD: return createIndexedRecord();
			case CciPackageImpl.INTERACTION_SPEC: return createInteractionSpec();
			case CciPackageImpl.INTERACTION: return createInteraction();
			case CciPackageImpl.CONNECTION_FACTORY: return createConnectionFactory();
			case CciPackageImpl.CONNECTION: return createConnection();
			case CciPackageImpl.CONNECTION_SPEC: return createConnectionSpec();
			case CciPackageImpl.CONNECTION_META_DATA: return createConnectionMetaData();
			case CciPackageImpl.LOCAL_TRANSACTION: return createLocalTransaction();
			case CciPackageImpl.RESOURCE_ADAPTER_META_DATA: return createResourceAdapterMetaData();
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
			case CciPackageImpl.OBJECT_ARRAY:
				return createObjectArrayFromString(eDataType, initialValue);
			case CciPackageImpl.STRING_ARRAY:
				return createStringArrayFromString(eDataType, initialValue);
			case CciPackageImpl.MAPPED_RECORD_COLLECTION:
				return createMappedRecordCollectionFromString(eDataType, initialValue);
			case CciPackageImpl.MAPPED_RECORD_LIST_ITERATOR:
				return createMappedRecordListIteratorFromString(eDataType, initialValue);
			case CciPackageImpl.MAPPED_RECORD_ITERATOR:
				return createMappedRecordIteratorFromString(eDataType, initialValue);
			case CciPackageImpl.MAPPED_RECORD_LIST:
				return createMappedRecordListFromString(eDataType, initialValue);
			case CciPackageImpl.RAW_COLLECTION:
				return createRawCollectionFromString(eDataType, initialValue);
			case CciPackageImpl.RAW_MAP:
				return createRawMapFromString(eDataType, initialValue);
			case CciPackageImpl.RAW_SET:
				return createRawSetFromString(eDataType, initialValue);
			case CciPackageImpl.PROPERTIES:
				return createPropertiesFromString(eDataType, initialValue);
			case CciPackageImpl.RESOURCE_EXCEPTION:
				return createResourceExceptionFromString(eDataType, initialValue);
			case CciPackageImpl.RESOURCE_WARNING:
				return createResourceWarningFromString(eDataType, initialValue);
			case CciPackageImpl.RESULT_SET_INFO:
				return createResultSetInfoFromString(eDataType, initialValue);
			case CciPackageImpl.REFERENCE:
				return createReferenceFromString(eDataType, initialValue);
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
			case CciPackageImpl.OBJECT_ARRAY:
				return convertObjectArrayToString(eDataType, instanceValue);
			case CciPackageImpl.STRING_ARRAY:
				return convertStringArrayToString(eDataType, instanceValue);
			case CciPackageImpl.MAPPED_RECORD_COLLECTION:
				return convertMappedRecordCollectionToString(eDataType, instanceValue);
			case CciPackageImpl.MAPPED_RECORD_LIST_ITERATOR:
				return convertMappedRecordListIteratorToString(eDataType, instanceValue);
			case CciPackageImpl.MAPPED_RECORD_ITERATOR:
				return convertMappedRecordIteratorToString(eDataType, instanceValue);
			case CciPackageImpl.MAPPED_RECORD_LIST:
				return convertMappedRecordListToString(eDataType, instanceValue);
			case CciPackageImpl.RAW_COLLECTION:
				return convertRawCollectionToString(eDataType, instanceValue);
			case CciPackageImpl.RAW_MAP:
				return convertRawMapToString(eDataType, instanceValue);
			case CciPackageImpl.RAW_SET:
				return convertRawSetToString(eDataType, instanceValue);
			case CciPackageImpl.PROPERTIES:
				return convertPropertiesToString(eDataType, instanceValue);
			case CciPackageImpl.RESOURCE_EXCEPTION:
				return convertResourceExceptionToString(eDataType, instanceValue);
			case CciPackageImpl.RESOURCE_WARNING:
				return convertResourceWarningToString(eDataType, instanceValue);
			case CciPackageImpl.RESULT_SET_INFO:
				return convertResultSetInfoToString(eDataType, instanceValue);
			case CciPackageImpl.REFERENCE:
				return convertReferenceToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
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
	public IndexedRecord createIndexedRecord() {
		IndexedRecordImpl indexedRecord = new IndexedRecordImpl();
		return indexedRecord;
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
	public Interaction createInteraction() {
		InteractionImpl interaction = new InteractionImpl();
		return interaction;
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
	public ConnectionMetaData createConnectionMetaData() {
		ConnectionMetaDataImpl connectionMetaData = new ConnectionMetaDataImpl();
		return connectionMetaData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalTransaction createLocalTransaction() {
		LocalTransactionImpl localTransaction = new LocalTransactionImpl();
		return localTransaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceAdapterMetaData createResourceAdapterMetaData() {
		ResourceAdapterMetaDataImpl resourceAdapterMetaData = new ResourceAdapterMetaDataImpl();
		return resourceAdapterMetaData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iterator createMappedRecordIteratorFromString(EDataType eDataType, String initialValue) {
		return (Iterator)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMappedRecordIteratorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object[] createObjectArrayFromString(EDataType eDataType, String initialValue) {
		return (Object[])super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertObjectArrayToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String[] createStringArrayFromString(EDataType eDataType, String initialValue) {
		return (String[])super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStringArrayToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection createRawCollectionFromString(EDataType eDataType, String initialValue) {
		return (Collection)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRawCollectionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection createMappedRecordCollectionFromString(EDataType eDataType, String initialValue) {
		return (Collection)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMappedRecordCollectionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListIterator createMappedRecordListIteratorFromString(EDataType eDataType, String initialValue) {
		return (ListIterator)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMappedRecordListIteratorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List createMappedRecordListFromString(EDataType eDataType, String initialValue) {
		return (List)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMappedRecordListToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map createRawMapFromString(EDataType eDataType, String initialValue) {
		return (Map)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRawMapToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Set createRawSetFromString(EDataType eDataType, String initialValue) {
		return (Set)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRawSetToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Properties createPropertiesFromString(EDataType eDataType, String initialValue) {
		return (Properties)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPropertiesToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceException createResourceExceptionFromString(EDataType eDataType, String initialValue) {
		return (ResourceException)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResourceExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceWarning createResourceWarningFromString(EDataType eDataType, String initialValue) {
		return (ResourceWarning)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResourceWarningToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultSetInfo createResultSetInfoFromString(EDataType eDataType, String initialValue) {
		return (ResultSetInfo)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResultSetInfoToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference createReferenceFromString(EDataType eDataType, String initialValue) {
		return (Reference)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReferenceToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CciPackageImpl getCciPackage() {
		return (CciPackageImpl)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CciPackageImpl getPackage() {
		return CciPackageImpl.eINSTANCE;
	}

} //CciFactoryImpl
