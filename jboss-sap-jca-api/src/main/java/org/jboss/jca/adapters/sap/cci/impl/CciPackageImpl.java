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
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource.Internal;
import org.jboss.jca.adapters.sap.cci.CciFactory;
import org.jboss.jca.adapters.sap.cci.CciPackage;
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
	 * @see org.jboss.jca.adapters.sap.cci.CciPackage#eNS_URI
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

		// Create package meta-data objects
		theCciPackage.createPackageContents();

		// Initialize created meta-data
		theCciPackage.initializePackageContents();

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
	public EClass getRecordFactory() {
		return recordFactoryEClass;
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
	public EAttribute getMappedRecord_RecordName() {
		return (EAttribute)mappedRecordEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappedRecord_RecordShortDescription() {
		return (EAttribute)mappedRecordEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getIndexedRecord_RecordName() {
		return (EAttribute)indexedRecordEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndexedRecord_RecordShortDescription() {
		return (EAttribute)indexedRecordEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexedRecord_RecordType() {
		return (EReference)indexedRecordEClass.getEStructuralFeatures().get(2);
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
	public EClass getInteraction() {
		return interactionEClass;
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
	public EClass getConnection() {
		return connectionEClass;
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
	public EAttribute getConnectionSpec_AuthType() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_UserId() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Client() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_User() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_AliasUser() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Passwd() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Lang() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Mysapsso2() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_X509cert() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Pcs() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Type() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Saprouter() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Sysnr() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Ashost() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Mshost() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Msserv() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Gwhost() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Gwserv() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Tphost() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Tpname() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_R3name() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Group() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Trace() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_CpicTrace() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Lcheck() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_UseSapgui() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Codepage() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_Getsso2() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_DenyInitialPassword() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_PeakLimit() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_PoolCapacity() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_ExpirationTime() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_ExpirationPeriod() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_MaxGetTime() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_SncMode() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_SncPartnername() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_SncQop() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_SncMyname() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_SncLibrary() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_RepositoryDest() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_RepositoryUser() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_RepositoryPasswd() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_RepositorySnc() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_RepositoryRoundtripOptimization() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionSpec_PingOnCreate() {
		return (EAttribute)connectionSpecEClass.getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectionMetaData() {
		return connectionMetaDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalTransaction() {
		return localTransactionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceAdapterMetaData() {
		return resourceAdapterMetaDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCIRecord() {
		return cciRecordEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCIRecordFactory() {
		return cciRecordFactoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCIMappedRecord() {
		return cciMappedRecordEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCIIndexedRecord() {
		return cciIndexedRecordEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCIInteractionSpec() {
		return cciInteractionSpecEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCIInteraction() {
		return cciInteractionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCIConnectionFactory() {
		return cciConnectionFactoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCIConnection() {
		return cciConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCIConnectionSpec() {
		return cciConnectionSpecEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCIConnectionMetaData() {
		return cciConnectionMetaDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCILocalTransaction() {
		return cciLocalTransactionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCIResourceAdapterMetaData() {
		return cciResourceAdapterMetaDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMappedRecordIterator() {
		return mappedRecordIteratorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getObjectArray() {
		return objectArrayEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getStringArray() {
		return stringArrayEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRawCollection() {
		return rawCollectionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMappedRecordCollection() {
		return mappedRecordCollectionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMappedRecordListIterator() {
		return mappedRecordListIteratorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMappedRecordList() {
		return mappedRecordListEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRawMap() {
		return rawMapEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRawSet() {
		return rawSetEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getProperties() {
		return propertiesEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getResourceException() {
		return resourceExceptionEDataType;
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
	public EDataType getResultSetInfo() {
		return resultSetInfoEDataType;
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
		createEReference(indexedRecordEClass, INDEXED_RECORD__RECORD_TYPE);

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
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__AUTH_TYPE);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__USER_ID);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__CLIENT);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__USER);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__ALIAS_USER);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__PASSWD);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__LANG);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__MYSAPSSO2);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__X509CERT);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__PCS);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__TYPE);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__SAPROUTER);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__SYSNR);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__ASHOST);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__MSHOST);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__MSSERV);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__GWHOST);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__GWSERV);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__TPHOST);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__TPNAME);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__R3NAME);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__GROUP);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__TRACE);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__CPIC_TRACE);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__LCHECK);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__USE_SAPGUI);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__CODEPAGE);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__GETSSO2);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__DENY_INITIAL_PASSWORD);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__PEAK_LIMIT);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__POOL_CAPACITY);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__EXPIRATION_TIME);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__EXPIRATION_PERIOD);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__MAX_GET_TIME);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__SNC_MODE);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__SNC_PARTNERNAME);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__SNC_QOP);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__SNC_MYNAME);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__SNC_LIBRARY);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__REPOSITORY_DEST);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__REPOSITORY_USER);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__REPOSITORY_PASSWD);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__REPOSITORY_SNC);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__REPOSITORY_ROUNDTRIP_OPTIMIZATION);
		createEAttribute(connectionSpecEClass, CONNECTION_SPEC__PING_ON_CREATE);

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

		// Set bounds for type parameters

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

		op = addEOperation(recordFactoryEClass, ecorePackage.getEPackage(), "getPackage", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "functionModuleName", 0, 1, IS_UNIQUE, IS_ORDERED);
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
		initEReference(getIndexedRecord_RecordType(), ecorePackage.getEClass(), null, "recordType", null, 0, 1, IndexedRecord.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

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
		initEAttribute(getConnectionSpec_AuthType(), ecorePackage.getEString(), "authType", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_UserId(), ecorePackage.getEString(), "userId", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Client(), ecorePackage.getEString(), "client", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_User(), ecorePackage.getEString(), "user", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_AliasUser(), ecorePackage.getEString(), "aliasUser", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Passwd(), ecorePackage.getEString(), "passwd", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Lang(), ecorePackage.getEString(), "lang", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Mysapsso2(), ecorePackage.getEString(), "mysapsso2", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_X509cert(), ecorePackage.getEString(), "x509cert", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Pcs(), ecorePackage.getEString(), "pcs", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Type(), ecorePackage.getEString(), "type", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Saprouter(), ecorePackage.getEString(), "saprouter", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Sysnr(), ecorePackage.getEString(), "sysnr", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Ashost(), ecorePackage.getEString(), "ashost", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Mshost(), ecorePackage.getEString(), "mshost", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Msserv(), ecorePackage.getEString(), "msserv", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Gwhost(), ecorePackage.getEString(), "gwhost", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Gwserv(), ecorePackage.getEString(), "gwserv", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Tphost(), ecorePackage.getEString(), "tphost", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Tpname(), ecorePackage.getEString(), "tpname", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_R3name(), ecorePackage.getEString(), "r3name", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Group(), ecorePackage.getEString(), "group", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Trace(), ecorePackage.getEString(), "trace", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_CpicTrace(), ecorePackage.getEString(), "cpicTrace", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Lcheck(), ecorePackage.getEString(), "lcheck", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_UseSapgui(), ecorePackage.getEString(), "useSapgui", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Codepage(), ecorePackage.getEString(), "codepage", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_Getsso2(), ecorePackage.getEString(), "getsso2", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_DenyInitialPassword(), ecorePackage.getEString(), "denyInitialPassword", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_PeakLimit(), ecorePackage.getEString(), "peakLimit", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_PoolCapacity(), ecorePackage.getEString(), "poolCapacity", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_ExpirationTime(), ecorePackage.getEString(), "expirationTime", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_ExpirationPeriod(), ecorePackage.getEString(), "expirationPeriod", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_MaxGetTime(), ecorePackage.getEString(), "maxGetTime", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_SncMode(), ecorePackage.getEString(), "sncMode", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_SncPartnername(), ecorePackage.getEString(), "sncPartnername", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_SncQop(), ecorePackage.getEString(), "sncQop", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_SncMyname(), ecorePackage.getEString(), "sncMyname", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_SncLibrary(), ecorePackage.getEString(), "sncLibrary", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_RepositoryDest(), ecorePackage.getEString(), "repositoryDest", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_RepositoryUser(), ecorePackage.getEString(), "repositoryUser", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_RepositoryPasswd(), ecorePackage.getEString(), "repositoryPasswd", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_RepositorySnc(), ecorePackage.getEString(), "repositorySnc", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_RepositoryRoundtripOptimization(), ecorePackage.getEString(), "repositoryRoundtripOptimization", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionSpec_PingOnCreate(), ecorePackage.getEString(), "pingOnCreate", null, 0, 1, ConnectionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		// Create resource
		createResource(eNS_URI);
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
