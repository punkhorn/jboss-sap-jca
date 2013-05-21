/**
 */
package org.jboss.jca.adapters.sap.model.spi.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.jboss.jca.adapters.sap.model.spi.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpiFactoryImpl extends EFactoryImpl implements SpiFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SpiFactory init() {
		try {
			SpiFactory theSpiFactory = (SpiFactory)EPackage.Registry.INSTANCE.getEFactory("http://sap.adapters.jca.jboss.org/spi"); 
			if (theSpiFactory != null) {
				return theSpiFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SpiFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpiFactoryImpl() {
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
			case SpiPackage.CONNECTION_REQUEST_INFO: return createConnectionRequestInfo();
			case SpiPackage.CONNECTION_REQUEST_INFO_ENTRY: return (EObject)createConnectionRequestInfoEntry();
			case SpiPackage.CONNECTION_REQUEST_INFO_STORE: return createConnectionRequestInfoStore();
			case SpiPackage.CONNECTION_REQUEST_INFO_STORE_ENTRY: return (EObject)createConnectionRequestInfoStoreEntry();
			case SpiPackage.MANAGED_CONNECTION_FACTORY: return createManagedConnectionFactory();
			case SpiPackage.MANAGED_CONNECTION: return createManagedConnection();
			case SpiPackage.RESOURCE_ADAPTER: return createResourceAdapter();
			case SpiPackage.PACKAGE_REGISTRY: return createPackageRegistry();
			case SpiPackage.PACKAGE_REGISTRY_ENTRY: return (EObject)createPackageRegistryEntry();
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
			case SpiPackage.MANAGED_CONNECTION_FACTORY_STATE:
				return createManagedConnectionFactoryStateFromString(eDataType, initialValue);
			case SpiPackage.MANAGED_CONNECTION_STATE:
				return createManagedConnectionStateFromString(eDataType, initialValue);
			case SpiPackage.RESOURCE_ADAPTER_STATE:
				return createResourceAdapterStateFromString(eDataType, initialValue);
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
			case SpiPackage.MANAGED_CONNECTION_FACTORY_STATE:
				return convertManagedConnectionFactoryStateToString(eDataType, instanceValue);
			case SpiPackage.MANAGED_CONNECTION_STATE:
				return convertManagedConnectionStateToString(eDataType, instanceValue);
			case SpiPackage.RESOURCE_ADAPTER_STATE:
				return convertResourceAdapterStateToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionRequestInfo createConnectionRequestInfo() {
		ConnectionRequestInfoImpl connectionRequestInfo = new ConnectionRequestInfoImpl();
		return connectionRequestInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, String> createConnectionRequestInfoEntry() {
		ConnectionRequestInfoEntryImpl connectionRequestInfoEntry = new ConnectionRequestInfoEntryImpl();
		return connectionRequestInfoEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionRequestInfoStore createConnectionRequestInfoStore() {
		ConnectionRequestInfoStoreImpl connectionRequestInfoStore = new ConnectionRequestInfoStoreImpl();
		return connectionRequestInfoStore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, ConnectionRequestInfo> createConnectionRequestInfoStoreEntry() {
		ConnectionRequestInfoStoreEntryImpl connectionRequestInfoStoreEntry = new ConnectionRequestInfoStoreEntryImpl();
		return connectionRequestInfoStoreEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedConnectionFactory createManagedConnectionFactory() {
		ManagedConnectionFactoryImpl managedConnectionFactory = new ManagedConnectionFactoryImpl();
		return managedConnectionFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedConnection createManagedConnection() {
		ManagedConnectionImpl managedConnection = new ManagedConnectionImpl();
		return managedConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceAdapter createResourceAdapter() {
		ResourceAdapterImpl resourceAdapter = new ResourceAdapterImpl();
		return resourceAdapter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageRegistry createPackageRegistry() {
		PackageRegistryImpl packageRegistry = new PackageRegistryImpl();
		return packageRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, EPackage> createPackageRegistryEntry() {
		PackageRegistryEntryImpl packageRegistryEntry = new PackageRegistryEntryImpl();
		return packageRegistryEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedConnectionFactoryState createManagedConnectionFactoryStateFromString(EDataType eDataType, String initialValue) {
		ManagedConnectionFactoryState result = ManagedConnectionFactoryState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertManagedConnectionFactoryStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedConnectionState createManagedConnectionStateFromString(EDataType eDataType, String initialValue) {
		ManagedConnectionState result = ManagedConnectionState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertManagedConnectionStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceAdapterState createResourceAdapterStateFromString(EDataType eDataType, String initialValue) {
		ResourceAdapterState result = ResourceAdapterState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResourceAdapterStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpiPackage getSpiPackage() {
		return (SpiPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SpiPackage getPackage() {
		return SpiPackage.eINSTANCE;
	}

} //SpiFactoryImpl
