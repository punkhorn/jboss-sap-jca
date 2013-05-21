/**
 */
package org.jboss.jca.adapters.sap.model.spi.util;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.jboss.jca.adapters.sap.model.spi.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage
 * @generated
 */
public class SpiSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SpiPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpiSwitch() {
		if (modelPackage == null) {
			modelPackage = SpiPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SpiPackage.CONNECTION_REQUEST_INFO: {
				ConnectionRequestInfo connectionRequestInfo = (ConnectionRequestInfo)theEObject;
				T result = caseConnectionRequestInfo(connectionRequestInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpiPackage.CONNECTION_REQUEST_INFO_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, String> connectionRequestInfoEntry = (Map.Entry<String, String>)theEObject;
				T result = caseConnectionRequestInfoEntry(connectionRequestInfoEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpiPackage.CONNECTION_REQUEST_INFO_STORE: {
				ConnectionRequestInfoStore connectionRequestInfoStore = (ConnectionRequestInfoStore)theEObject;
				T result = caseConnectionRequestInfoStore(connectionRequestInfoStore);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpiPackage.CONNECTION_REQUEST_INFO_STORE_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, ConnectionRequestInfo> connectionRequestInfoStoreEntry = (Map.Entry<String, ConnectionRequestInfo>)theEObject;
				T result = caseConnectionRequestInfoStoreEntry(connectionRequestInfoStoreEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpiPackage.MANAGED_CONNECTION_FACTORY: {
				ManagedConnectionFactory managedConnectionFactory = (ManagedConnectionFactory)theEObject;
				T result = caseManagedConnectionFactory(managedConnectionFactory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpiPackage.MANAGED_CONNECTION: {
				ManagedConnection managedConnection = (ManagedConnection)theEObject;
				T result = caseManagedConnection(managedConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpiPackage.RESOURCE_ADAPTER: {
				ResourceAdapter resourceAdapter = (ResourceAdapter)theEObject;
				T result = caseResourceAdapter(resourceAdapter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpiPackage.PACKAGE_REGISTRY: {
				PackageRegistry packageRegistry = (PackageRegistry)theEObject;
				T result = casePackageRegistry(packageRegistry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpiPackage.PACKAGE_REGISTRY_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, EPackage> packageRegistryEntry = (Map.Entry<String, EPackage>)theEObject;
				T result = casePackageRegistryEntry(packageRegistryEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection Request Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection Request Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectionRequestInfo(ConnectionRequestInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection Request Info Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection Request Info Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectionRequestInfoEntry(Map.Entry<String, String> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection Request Info Store</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection Request Info Store</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectionRequestInfoStore(ConnectionRequestInfoStore object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection Request Info Store Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection Request Info Store Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectionRequestInfoStoreEntry(Map.Entry<String, ConnectionRequestInfo> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Managed Connection Factory</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Managed Connection Factory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseManagedConnectionFactory(ManagedConnectionFactory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Managed Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Managed Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseManagedConnection(ManagedConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Adapter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Adapter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceAdapter(ResourceAdapter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Registry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Registry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageRegistry(PackageRegistry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Registry Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Registry Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageRegistryEntry(Map.Entry<String, EPackage> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //SpiSwitch
