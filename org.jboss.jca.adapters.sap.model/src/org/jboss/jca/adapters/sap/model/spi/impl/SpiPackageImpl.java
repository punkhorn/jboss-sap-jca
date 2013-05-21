/**
 */
package org.jboss.jca.adapters.sap.model.spi.impl;

import java.io.PrintWriter;
import java.util.Map;

import javax.resource.spi.ConnectionEventListener;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl;
import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfoStore;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnection;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactoryState;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionState;
import org.jboss.jca.adapters.sap.model.spi.PackageRegistry;
import org.jboss.jca.adapters.sap.model.spi.ResourceAdapter;
import org.jboss.jca.adapters.sap.model.spi.ResourceAdapterState;
import org.jboss.jca.adapters.sap.model.spi.SpiFactory;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpiPackageImpl extends EPackageImpl implements SpiPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionRequestInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionRequestInfoEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionRequestInfoStoreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionRequestInfoStoreEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass managedConnectionFactoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass managedConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceAdapterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageRegistryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageRegistryEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum managedConnectionFactoryStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum managedConnectionStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum resourceAdapterStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType printWriterEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType connectionEventListenerEDataType = null;

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
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SpiPackageImpl() {
		super(eNS_URI, SpiFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SpiPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SpiPackage init() {
		if (isInited) return (SpiPackage)EPackage.Registry.INSTANCE.getEPackage(SpiPackage.eNS_URI);

		// Obtain or create and register package
		SpiPackageImpl theSpiPackage = (SpiPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SpiPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SpiPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		CciPackageImpl theCciPackage = (CciPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CciPackage.eNS_URI) instanceof CciPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CciPackage.eNS_URI) : CciPackage.eINSTANCE);

		// Create package meta-data objects
		theSpiPackage.createPackageContents();
		theCciPackage.createPackageContents();

		// Initialize created meta-data
		theSpiPackage.initializePackageContents();
		theCciPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSpiPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SpiPackage.eNS_URI, theSpiPackage);
		return theSpiPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectionRequestInfo() {
		return connectionRequestInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionRequestInfo_Entries() {
		return (EReference)connectionRequestInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_AliasUser() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_Ashost() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_AuthType() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_Client() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_Codepage() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_CpicTrace() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_DenyInitialPassword() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_ExpirationPeriod() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_ExpirationTime() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_Getsso2() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_Group() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_Gwhost() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_Gwserv() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_Lang() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_Lcheck() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_MaxGetTime() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_Mshost() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_Msserv() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_Mysapsso2() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_Passwd() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_Password() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_Pcs() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_PeakLimit() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_PingOnCreate() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_PoolCapacity() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_R3name() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_RepositoryDest() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_RepositoryPasswd() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_RepositoryRoundtripOptimization() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_RepositorySnc() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_RepositoryUser() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_Saprouter() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_SncLibrary() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_SncMode() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_SncMyname() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_SncPartnername() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_SncQop() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_Sysnr() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_Tphost() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_Tpname() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_Trace() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_Type() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_UserName() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_User() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_UserId() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_UseSapgui() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfo_X509cert() {
		return (EAttribute)connectionRequestInfoEClass.getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectionRequestInfoEntry() {
		return connectionRequestInfoEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfoEntry_Key() {
		return (EAttribute)connectionRequestInfoEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfoEntry_Value() {
		return (EAttribute)connectionRequestInfoEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectionRequestInfoStore() {
		return connectionRequestInfoStoreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionRequestInfoStore_ConnectionRequestInfos() {
		return (EReference)connectionRequestInfoStoreEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectionRequestInfoStoreEntry() {
		return connectionRequestInfoStoreEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionRequestInfoStoreEntry_Key() {
		return (EAttribute)connectionRequestInfoStoreEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionRequestInfoStoreEntry_Value() {
		return (EReference)connectionRequestInfoStoreEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getManagedConnectionFactory() {
		return managedConnectionFactoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getManagedConnectionFactory_State() {
		return (EAttribute)managedConnectionFactoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getManagedConnectionFactory_ResourceAdapter() {
		return (EReference)managedConnectionFactoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getManagedConnectionFactory_DefaultConnectionName() {
		return (EAttribute)managedConnectionFactoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getManagedConnectionFactory_DefaultConnectionRequestInfo() {
		return (EReference)managedConnectionFactoryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getManagedConnectionFactory_ManagedConnections() {
		return (EReference)managedConnectionFactoryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getManagedConnectionFactory_ConnectionFactories() {
		return (EReference)managedConnectionFactoryEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getManagedConnectionFactory_LogWriter() {
		return (EAttribute)managedConnectionFactoryEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getManagedConnectionFactory_PackageRegistry() {
		return (EReference)managedConnectionFactoryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getManagedConnection() {
		return managedConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getManagedConnection_State() {
		return (EAttribute)managedConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getManagedConnection_ConnectionName() {
		return (EAttribute)managedConnectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getManagedConnection_ConnectionRequestInfo() {
		return (EReference)managedConnectionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getManagedConnection_ConnectionHandles() {
		return (EReference)managedConnectionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getManagedConnection_LogWriter() {
		return (EAttribute)managedConnectionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getManagedConnection_ConnectionEventListeners() {
		return (EAttribute)managedConnectionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getManagedConnection_InTransaction() {
		return (EAttribute)managedConnectionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getManagedConnection_ManagedConnectionFactory() {
		return (EReference)managedConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceAdapter() {
		return resourceAdapterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceAdapter_State() {
		return (EAttribute)resourceAdapterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceAdapter_ConnectionRequestInfoStore() {
		return (EReference)resourceAdapterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceAdapter_ManagedConnectionFactories() {
		return (EReference)resourceAdapterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageRegistry() {
		return packageRegistryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageRegistry_Packages() {
		return (EReference)packageRegistryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageRegistry_ManagedConnectionFactory() {
		return (EReference)packageRegistryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageRegistryEntry() {
		return packageRegistryEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackageRegistryEntry_Key() {
		return (EAttribute)packageRegistryEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageRegistryEntry_Value() {
		return (EReference)packageRegistryEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getManagedConnectionFactoryState() {
		return managedConnectionFactoryStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getManagedConnectionState() {
		return managedConnectionStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getResourceAdapterState() {
		return resourceAdapterStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPrintWriter() {
		return printWriterEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getConnectionEventListener() {
		return connectionEventListenerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpiFactory getSpiFactory() {
		return (SpiFactory)getEFactoryInstance();
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
		connectionRequestInfoEClass = createEClass(CONNECTION_REQUEST_INFO);
		createEReference(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__ENTRIES);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__ALIAS_USER);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__ASHOST);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__AUTH_TYPE);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__CLIENT);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__CODEPAGE);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__CPIC_TRACE);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__DENY_INITIAL_PASSWORD);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__EXPIRATION_PERIOD);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__EXPIRATION_TIME);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__GETSSO2);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__GROUP);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__GWHOST);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__GWSERV);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__LANG);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__LCHECK);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__MAX_GET_TIME);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__MSHOST);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__MSSERV);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__MYSAPSSO2);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__PASSWD);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__PASSWORD);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__PCS);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__PEAK_LIMIT);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__PING_ON_CREATE);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__POOL_CAPACITY);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__R3NAME);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__REPOSITORY_DEST);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__REPOSITORY_PASSWD);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__REPOSITORY_ROUNDTRIP_OPTIMIZATION);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__REPOSITORY_SNC);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__REPOSITORY_USER);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__SAPROUTER);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__SNC_LIBRARY);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__SNC_MODE);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__SNC_MYNAME);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__SNC_PARTNERNAME);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__SNC_QOP);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__SYSNR);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__TPHOST);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__TPNAME);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__TRACE);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__TYPE);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__USER_NAME);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__USER);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__USER_ID);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__USE_SAPGUI);
		createEAttribute(connectionRequestInfoEClass, CONNECTION_REQUEST_INFO__X509CERT);

		connectionRequestInfoEntryEClass = createEClass(CONNECTION_REQUEST_INFO_ENTRY);
		createEAttribute(connectionRequestInfoEntryEClass, CONNECTION_REQUEST_INFO_ENTRY__KEY);
		createEAttribute(connectionRequestInfoEntryEClass, CONNECTION_REQUEST_INFO_ENTRY__VALUE);

		connectionRequestInfoStoreEClass = createEClass(CONNECTION_REQUEST_INFO_STORE);
		createEReference(connectionRequestInfoStoreEClass, CONNECTION_REQUEST_INFO_STORE__CONNECTION_REQUEST_INFOS);

		connectionRequestInfoStoreEntryEClass = createEClass(CONNECTION_REQUEST_INFO_STORE_ENTRY);
		createEAttribute(connectionRequestInfoStoreEntryEClass, CONNECTION_REQUEST_INFO_STORE_ENTRY__KEY);
		createEReference(connectionRequestInfoStoreEntryEClass, CONNECTION_REQUEST_INFO_STORE_ENTRY__VALUE);

		managedConnectionFactoryEClass = createEClass(MANAGED_CONNECTION_FACTORY);
		createEAttribute(managedConnectionFactoryEClass, MANAGED_CONNECTION_FACTORY__STATE);
		createEReference(managedConnectionFactoryEClass, MANAGED_CONNECTION_FACTORY__RESOURCE_ADAPTER);
		createEAttribute(managedConnectionFactoryEClass, MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_NAME);
		createEReference(managedConnectionFactoryEClass, MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO);
		createEReference(managedConnectionFactoryEClass, MANAGED_CONNECTION_FACTORY__PACKAGE_REGISTRY);
		createEReference(managedConnectionFactoryEClass, MANAGED_CONNECTION_FACTORY__MANAGED_CONNECTIONS);
		createEReference(managedConnectionFactoryEClass, MANAGED_CONNECTION_FACTORY__CONNECTION_FACTORIES);
		createEAttribute(managedConnectionFactoryEClass, MANAGED_CONNECTION_FACTORY__LOG_WRITER);

		managedConnectionEClass = createEClass(MANAGED_CONNECTION);
		createEAttribute(managedConnectionEClass, MANAGED_CONNECTION__STATE);
		createEReference(managedConnectionEClass, MANAGED_CONNECTION__MANAGED_CONNECTION_FACTORY);
		createEAttribute(managedConnectionEClass, MANAGED_CONNECTION__CONNECTION_NAME);
		createEReference(managedConnectionEClass, MANAGED_CONNECTION__CONNECTION_REQUEST_INFO);
		createEReference(managedConnectionEClass, MANAGED_CONNECTION__CONNECTION_HANDLES);
		createEAttribute(managedConnectionEClass, MANAGED_CONNECTION__LOG_WRITER);
		createEAttribute(managedConnectionEClass, MANAGED_CONNECTION__CONNECTION_EVENT_LISTENERS);
		createEAttribute(managedConnectionEClass, MANAGED_CONNECTION__IN_TRANSACTION);

		resourceAdapterEClass = createEClass(RESOURCE_ADAPTER);
		createEAttribute(resourceAdapterEClass, RESOURCE_ADAPTER__STATE);
		createEReference(resourceAdapterEClass, RESOURCE_ADAPTER__CONNECTION_REQUEST_INFO_STORE);
		createEReference(resourceAdapterEClass, RESOURCE_ADAPTER__MANAGED_CONNECTION_FACTORIES);

		packageRegistryEClass = createEClass(PACKAGE_REGISTRY);
		createEReference(packageRegistryEClass, PACKAGE_REGISTRY__PACKAGES);
		createEReference(packageRegistryEClass, PACKAGE_REGISTRY__MANAGED_CONNECTION_FACTORY);

		packageRegistryEntryEClass = createEClass(PACKAGE_REGISTRY_ENTRY);
		createEAttribute(packageRegistryEntryEClass, PACKAGE_REGISTRY_ENTRY__KEY);
		createEReference(packageRegistryEntryEClass, PACKAGE_REGISTRY_ENTRY__VALUE);

		// Create enums
		managedConnectionFactoryStateEEnum = createEEnum(MANAGED_CONNECTION_FACTORY_STATE);
		managedConnectionStateEEnum = createEEnum(MANAGED_CONNECTION_STATE);
		resourceAdapterStateEEnum = createEEnum(RESOURCE_ADAPTER_STATE);

		// Create data types
		printWriterEDataType = createEDataType(PRINT_WRITER);
		connectionEventListenerEDataType = createEDataType(CONNECTION_EVENT_LISTENER);
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
		CciPackage theCciPackage = (CciPackage)EPackage.Registry.INSTANCE.getEPackage(CciPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(connectionRequestInfoEClass, ConnectionRequestInfo.class, "ConnectionRequestInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectionRequestInfo_Entries(), this.getConnectionRequestInfoEntry(), null, "entries", null, 0, -1, ConnectionRequestInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_AliasUser(), ecorePackage.getEString(), "aliasUser", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_Ashost(), ecorePackage.getEString(), "ashost", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_AuthType(), ecorePackage.getEString(), "authType", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_Client(), ecorePackage.getEString(), "client", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_Codepage(), ecorePackage.getEString(), "codepage", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_CpicTrace(), ecorePackage.getEString(), "cpicTrace", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_DenyInitialPassword(), ecorePackage.getEString(), "denyInitialPassword", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_ExpirationPeriod(), ecorePackage.getEString(), "expirationPeriod", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_ExpirationTime(), ecorePackage.getEString(), "expirationTime", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_Getsso2(), ecorePackage.getEString(), "getsso2", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_Group(), ecorePackage.getEString(), "group", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_Gwhost(), ecorePackage.getEString(), "gwhost", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_Gwserv(), ecorePackage.getEString(), "gwserv", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_Lang(), ecorePackage.getEString(), "lang", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_Lcheck(), ecorePackage.getEString(), "lcheck", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_MaxGetTime(), ecorePackage.getEString(), "maxGetTime", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_Mshost(), ecorePackage.getEString(), "mshost", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_Msserv(), ecorePackage.getEString(), "msserv", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_Mysapsso2(), ecorePackage.getEString(), "mysapsso2", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_Passwd(), ecorePackage.getEString(), "passwd", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_Password(), ecorePackage.getEString(), "password", null, 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_Pcs(), ecorePackage.getEString(), "pcs", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_PeakLimit(), ecorePackage.getEString(), "peakLimit", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_PingOnCreate(), ecorePackage.getEString(), "pingOnCreate", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_PoolCapacity(), ecorePackage.getEString(), "poolCapacity", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_R3name(), ecorePackage.getEString(), "r3name", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_RepositoryDest(), ecorePackage.getEString(), "repositoryDest", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_RepositoryPasswd(), ecorePackage.getEString(), "repositoryPasswd", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_RepositoryRoundtripOptimization(), ecorePackage.getEString(), "repositoryRoundtripOptimization", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_RepositorySnc(), ecorePackage.getEString(), "repositorySnc", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_RepositoryUser(), ecorePackage.getEString(), "repositoryUser", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_Saprouter(), ecorePackage.getEString(), "saprouter", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_SncLibrary(), ecorePackage.getEString(), "sncLibrary", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_SncMode(), ecorePackage.getEString(), "sncMode", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_SncMyname(), ecorePackage.getEString(), "sncMyname", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_SncPartnername(), ecorePackage.getEString(), "sncPartnername", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_SncQop(), ecorePackage.getEString(), "sncQop", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_Sysnr(), ecorePackage.getEString(), "sysnr", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_Tphost(), ecorePackage.getEString(), "tphost", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_Tpname(), ecorePackage.getEString(), "tpname", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_Trace(), ecorePackage.getEString(), "trace", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_Type(), ecorePackage.getEString(), "type", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_UserName(), ecorePackage.getEString(), "userName", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_User(), ecorePackage.getEString(), "user", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_UserId(), ecorePackage.getEString(), "userId", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_UseSapgui(), ecorePackage.getEString(), "useSapgui", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfo_X509cert(), ecorePackage.getEString(), "x509cert", "", 0, 1, ConnectionRequestInfo.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(connectionRequestInfoEntryEClass, Map.Entry.class, "ConnectionRequestInfoEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnectionRequestInfoEntry_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionRequestInfoEntry_Value(), ecorePackage.getEString(), "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectionRequestInfoStoreEClass, ConnectionRequestInfoStore.class, "ConnectionRequestInfoStore", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectionRequestInfoStore_ConnectionRequestInfos(), this.getConnectionRequestInfoStoreEntry(), null, "connectionRequestInfos", null, 0, -1, ConnectionRequestInfoStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectionRequestInfoStoreEntryEClass, Map.Entry.class, "ConnectionRequestInfoStoreEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnectionRequestInfoStoreEntry_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionRequestInfoStoreEntry_Value(), this.getConnectionRequestInfo(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(managedConnectionFactoryEClass, ManagedConnectionFactory.class, "ManagedConnectionFactory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getManagedConnectionFactory_State(), this.getManagedConnectionFactoryState(), "state", "ACTIVE", 0, 1, ManagedConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getManagedConnectionFactory_ResourceAdapter(), this.getResourceAdapter(), this.getResourceAdapter_ManagedConnectionFactories(), "resourceAdapter", null, 1, 1, ManagedConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getManagedConnectionFactory_DefaultConnectionName(), ecorePackage.getEString(), "defaultConnectionName", null, 1, 1, ManagedConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getManagedConnectionFactory_DefaultConnectionRequestInfo(), this.getConnectionRequestInfo(), null, "defaultConnectionRequestInfo", null, 1, 1, ManagedConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getManagedConnectionFactory_PackageRegistry(), this.getPackageRegistry(), this.getPackageRegistry_ManagedConnectionFactory(), "packageRegistry", null, 0, 1, ManagedConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getManagedConnectionFactory_ManagedConnections(), this.getManagedConnection(), this.getManagedConnection_ManagedConnectionFactory(), "managedConnections", null, 0, -1, ManagedConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getManagedConnectionFactory_ConnectionFactories(), theCciPackage.getConnectionFactory(), theCciPackage.getConnectionFactory_ManagedConnectionFactory(), "connectionFactories", null, 0, -1, ManagedConnectionFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getManagedConnectionFactory_LogWriter(), this.getPrintWriter(), "logWriter", null, 0, 1, ManagedConnectionFactory.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(managedConnectionEClass, ManagedConnection.class, "ManagedConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getManagedConnection_State(), this.getManagedConnectionState(), "state", "ACTIVE", 0, 1, ManagedConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getManagedConnection_ManagedConnectionFactory(), this.getManagedConnectionFactory(), this.getManagedConnectionFactory_ManagedConnections(), "managedConnectionFactory", null, 1, 1, ManagedConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getManagedConnection_ConnectionName(), ecorePackage.getEString(), "connectionName", "", 1, 1, ManagedConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getManagedConnection_ConnectionRequestInfo(), this.getConnectionRequestInfo(), null, "connectionRequestInfo", null, 1, 1, ManagedConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getManagedConnection_ConnectionHandles(), theCciPackage.getConnection(), theCciPackage.getConnection_ManagedConnection(), "connectionHandles", null, 0, -1, ManagedConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getManagedConnection_LogWriter(), this.getPrintWriter(), "logWriter", null, 0, 1, ManagedConnection.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getManagedConnection_ConnectionEventListeners(), this.getConnectionEventListener(), "connectionEventListeners", null, 0, -1, ManagedConnection.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getManagedConnection_InTransaction(), ecorePackage.getEBoolean(), "inTransaction", null, 0, 1, ManagedConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceAdapterEClass, ResourceAdapter.class, "ResourceAdapter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceAdapter_State(), this.getResourceAdapterState(), "state", null, 1, 1, ResourceAdapter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceAdapter_ConnectionRequestInfoStore(), this.getConnectionRequestInfoStore(), null, "connectionRequestInfoStore", null, 1, 1, ResourceAdapter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceAdapter_ManagedConnectionFactories(), this.getManagedConnectionFactory(), this.getManagedConnectionFactory_ResourceAdapter(), "managedConnectionFactories", null, 0, -1, ResourceAdapter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packageRegistryEClass, PackageRegistry.class, "PackageRegistry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPackageRegistry_Packages(), this.getPackageRegistryEntry(), null, "packages", null, 0, -1, PackageRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageRegistry_ManagedConnectionFactory(), this.getManagedConnectionFactory(), this.getManagedConnectionFactory_PackageRegistry(), "managedConnectionFactory", null, 0, 1, PackageRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packageRegistryEntryEClass, Map.Entry.class, "PackageRegistryEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPackageRegistryEntry_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageRegistryEntry_Value(), ecorePackage.getEPackage(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(managedConnectionFactoryStateEEnum, ManagedConnectionFactoryState.class, "ManagedConnectionFactoryState");
		addEEnumLiteral(managedConnectionFactoryStateEEnum, ManagedConnectionFactoryState.ACTIVE);
		addEEnumLiteral(managedConnectionFactoryStateEEnum, ManagedConnectionFactoryState.DESTROYED);

		initEEnum(managedConnectionStateEEnum, ManagedConnectionState.class, "ManagedConnectionState");
		addEEnumLiteral(managedConnectionStateEEnum, ManagedConnectionState.ACTIVE);
		addEEnumLiteral(managedConnectionStateEEnum, ManagedConnectionState.DESTROYED);

		initEEnum(resourceAdapterStateEEnum, ResourceAdapterState.class, "ResourceAdapterState");
		addEEnumLiteral(resourceAdapterStateEEnum, ResourceAdapterState.STARTING);
		addEEnumLiteral(resourceAdapterStateEEnum, ResourceAdapterState.STARTED);
		addEEnumLiteral(resourceAdapterStateEEnum, ResourceAdapterState.STOPPED);

		// Initialize data types
		initEDataType(printWriterEDataType, PrintWriter.class, "PrintWriter", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(connectionEventListenerEDataType, ConnectionEventListener.class, "ConnectionEventListener", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //SpiPackageImpl
