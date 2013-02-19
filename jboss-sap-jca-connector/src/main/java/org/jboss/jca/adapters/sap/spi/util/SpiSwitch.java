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
package org.jboss.jca.adapters.sap.spi.util;

import javax.resource.spi.ConnectionManager;
import javax.resource.spi.DissociatableManagedConnection;
import javax.resource.spi.ResourceAdapterAssociation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.jboss.jca.adapters.sap.spi.*;

import org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl;

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
 * @see org.jboss.jca.adapters.sap.spi.impl.SpiPackageImpl
 * @generated
 */
public class SpiSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SpiPackageImpl modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpiSwitch() {
		if (modelPackage == null) {
			modelPackage = SpiPackageImpl.eINSTANCE;
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
			case SpiPackageImpl.CONNECTION_REQUEST_INFO: {
				ConnectionRequestInfo connectionRequestInfo = (ConnectionRequestInfo)theEObject;
				T result = caseConnectionRequestInfo(connectionRequestInfo);
				if (result == null) result = caseSPIConnectionRequestInfo(connectionRequestInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpiPackageImpl.DEFAULT_CONNECTION_MANAGER: {
				DefaultConnectionManager defaultConnectionManager = (DefaultConnectionManager)theEObject;
				T result = caseDefaultConnectionManager(defaultConnectionManager);
				if (result == null) result = caseSPIConnectionManager(defaultConnectionManager);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpiPackageImpl.LOCAL_TRANSACTION: {
				LocalTransaction localTransaction = (LocalTransaction)theEObject;
				T result = caseLocalTransaction(localTransaction);
				if (result == null) result = caseSPILocalTransaction(localTransaction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpiPackageImpl.MANAGED_CONNECTION_FACTORY: {
				ManagedConnectionFactory managedConnectionFactory = (ManagedConnectionFactory)theEObject;
				T result = caseManagedConnectionFactory(managedConnectionFactory);
				if (result == null) result = caseSPIManagedConnectionFactory(managedConnectionFactory);
				if (result == null) result = caseSPIResourceAdapterAssociation(managedConnectionFactory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpiPackageImpl.MANAGED_CONNECTION: {
				ManagedConnection managedConnection = (ManagedConnection)theEObject;
				T result = caseManagedConnection(managedConnection);
				if (result == null) result = caseSPIManagedConnection(managedConnection);
				if (result == null) result = caseSPIDissociatableManagedConnection(managedConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpiPackageImpl.MANAGED_CONNECTION_META_DATA: {
				ManagedConnectionMetaData managedConnectionMetaData = (ManagedConnectionMetaData)theEObject;
				T result = caseManagedConnectionMetaData(managedConnectionMetaData);
				if (result == null) result = caseSPIManagedConnectionMetaData(managedConnectionMetaData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpiPackageImpl.NON_MANAGED_ENVIRONMENT_ADMIN: {
				NonManagedEnvironmentAdmin nonManagedEnvironmentAdmin = (NonManagedEnvironmentAdmin)theEObject;
				T result = caseNonManagedEnvironmentAdmin(nonManagedEnvironmentAdmin);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpiPackageImpl.RESOURCE_ADAPTER: {
				ResourceAdapter resourceAdapter = (ResourceAdapter)theEObject;
				T result = caseResourceAdapter(resourceAdapter);
				if (result == null) result = caseSPIResourceAdapter(resourceAdapter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SPI Connection Request Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SPI Connection Request Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSPIConnectionRequestInfo(javax.resource.spi.ConnectionRequestInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SPI Connection Manager</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SPI Connection Manager</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSPIConnectionManager(ConnectionManager object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SPI Local Transaction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SPI Local Transaction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSPILocalTransaction(javax.resource.spi.LocalTransaction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SPI Managed Connection Factory</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SPI Managed Connection Factory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSPIManagedConnectionFactory(javax.resource.spi.ManagedConnectionFactory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SPI Resource Adapter Association</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SPI Resource Adapter Association</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSPIResourceAdapterAssociation(ResourceAdapterAssociation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SPI Managed Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SPI Managed Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSPIManagedConnection(javax.resource.spi.ManagedConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SPI Dissociatable Managed Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SPI Dissociatable Managed Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSPIDissociatableManagedConnection(DissociatableManagedConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SPI Managed Connection Meta Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SPI Managed Connection Meta Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSPIManagedConnectionMetaData(javax.resource.spi.ManagedConnectionMetaData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SPI Resource Adapter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SPI Resource Adapter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSPIResourceAdapter(javax.resource.spi.ResourceAdapter object) {
		return null;
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
	 * Returns the result of interpreting the object as an instance of '<em>Default Connection Manager</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Connection Manager</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefaultConnectionManager(DefaultConnectionManager object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Transaction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Transaction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalTransaction(LocalTransaction object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Managed Connection Meta Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Managed Connection Meta Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseManagedConnectionMetaData(ManagedConnectionMetaData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Non Managed Environment Admin</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Non Managed Environment Admin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNonManagedEnvironmentAdmin(NonManagedEnvironmentAdmin object) {
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
