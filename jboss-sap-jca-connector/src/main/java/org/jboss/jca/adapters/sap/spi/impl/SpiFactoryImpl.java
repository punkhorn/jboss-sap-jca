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
package org.jboss.jca.adapters.sap.spi.impl;

import com.sap.conn.jco.JCoDestination;

import java.io.PrintWriter;

import java.util.Map;

import java.util.Set;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ResourceAdapterInternalException;

import javax.resource.spi.endpoint.MessageEndpointFactory;

import javax.resource.spi.security.PasswordCredential;

import javax.security.auth.Subject;

import javax.transaction.xa.XAResource;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.jboss.jca.adapters.sap.spi.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpiFactoryImpl extends EFactoryImpl implements SpiFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final SpiFactoryImpl eINSTANCE = init();

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SpiFactoryImpl init() {
		try {
			SpiFactoryImpl theSpiFactory = (SpiFactoryImpl)EPackage.Registry.INSTANCE.getEFactory("http://sap.adapters.jca.jboss.org/spi"); 
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
			case SpiPackageImpl.CONNECTION_REQUEST_INFO: return createConnectionRequestInfo();
			case SpiPackageImpl.DEFAULT_CONNECTION_MANAGER: return createDefaultConnectionManager();
			case SpiPackageImpl.LOCAL_TRANSACTION: return createLocalTransaction();
			case SpiPackageImpl.MANAGED_CONNECTION_FACTORY: return createManagedConnectionFactory();
			case SpiPackageImpl.MANAGED_CONNECTION: return createManagedConnection();
			case SpiPackageImpl.MANAGED_CONNECTION_META_DATA: return createManagedConnectionMetaData();
			case SpiPackageImpl.NON_MANAGED_ENVIRONMENT_ADMIN: return createNonManagedEnvironmentAdmin();
			case SpiPackageImpl.RESOURCE_ADAPTER: return createResourceAdapter();
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
			case SpiPackageImpl.PASSWORD_CREDENTIAL:
				return createPasswordCredentialFromString(eDataType, initialValue);
			case SpiPackageImpl.SUBJECT:
				return createSubjectFromString(eDataType, initialValue);
			case SpiPackageImpl.CONNECTION_EVENT_LISTENER:
				return createConnectionEventListenerFromString(eDataType, initialValue);
			case SpiPackageImpl.XA_RESOURCE:
				return createXAResourceFromString(eDataType, initialValue);
			case SpiPackageImpl.XA_RESOURCE_ARRAY:
				return createXAResourceArrayFromString(eDataType, initialValue);
			case SpiPackageImpl.JCO_DESTINATION:
				return createJCoDestinationFromString(eDataType, initialValue);
			case SpiPackageImpl.ACTIVATION_SPEC_ARRAY:
				return createActivationSpecArrayFromString(eDataType, initialValue);
			case SpiPackageImpl.ACTIVATION_SPEC:
				return createActivationSpecFromString(eDataType, initialValue);
			case SpiPackageImpl.BOOTSTRAP_CONTEXT:
				return createBootstrapContextFromString(eDataType, initialValue);
			case SpiPackageImpl.RESOURCE_ADAPTER_INTERNAL_EXCEPTION:
				return createResourceAdapterInternalExceptionFromString(eDataType, initialValue);
			case SpiPackageImpl.MESSAGE_ENDPOINT_FACTORY:
				return createMessageEndpointFactoryFromString(eDataType, initialValue);
			case SpiPackageImpl.PRINT_WRITER:
				return createPrintWriterFromString(eDataType, initialValue);
			case SpiPackageImpl.STRING_MAP:
				return createStringMapFromString(eDataType, initialValue);
			case SpiPackageImpl.STRING_SET:
				return createStringSetFromString(eDataType, initialValue);
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
			case SpiPackageImpl.PASSWORD_CREDENTIAL:
				return convertPasswordCredentialToString(eDataType, instanceValue);
			case SpiPackageImpl.SUBJECT:
				return convertSubjectToString(eDataType, instanceValue);
			case SpiPackageImpl.CONNECTION_EVENT_LISTENER:
				return convertConnectionEventListenerToString(eDataType, instanceValue);
			case SpiPackageImpl.XA_RESOURCE:
				return convertXAResourceToString(eDataType, instanceValue);
			case SpiPackageImpl.XA_RESOURCE_ARRAY:
				return convertXAResourceArrayToString(eDataType, instanceValue);
			case SpiPackageImpl.JCO_DESTINATION:
				return convertJCoDestinationToString(eDataType, instanceValue);
			case SpiPackageImpl.ACTIVATION_SPEC_ARRAY:
				return convertActivationSpecArrayToString(eDataType, instanceValue);
			case SpiPackageImpl.ACTIVATION_SPEC:
				return convertActivationSpecToString(eDataType, instanceValue);
			case SpiPackageImpl.BOOTSTRAP_CONTEXT:
				return convertBootstrapContextToString(eDataType, instanceValue);
			case SpiPackageImpl.RESOURCE_ADAPTER_INTERNAL_EXCEPTION:
				return convertResourceAdapterInternalExceptionToString(eDataType, instanceValue);
			case SpiPackageImpl.MESSAGE_ENDPOINT_FACTORY:
				return convertMessageEndpointFactoryToString(eDataType, instanceValue);
			case SpiPackageImpl.PRINT_WRITER:
				return convertPrintWriterToString(eDataType, instanceValue);
			case SpiPackageImpl.STRING_MAP:
				return convertStringMapToString(eDataType, instanceValue);
			case SpiPackageImpl.STRING_SET:
				return convertStringSetToString(eDataType, instanceValue);
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
	public DefaultConnectionManager createDefaultConnectionManager() {
		DefaultConnectionManagerImpl defaultConnectionManager = new DefaultConnectionManagerImpl();
		return defaultConnectionManager;
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
	public ManagedConnectionMetaData createManagedConnectionMetaData() {
		ManagedConnectionMetaDataImpl managedConnectionMetaData = new ManagedConnectionMetaDataImpl();
		return managedConnectionMetaData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonManagedEnvironmentAdmin createNonManagedEnvironmentAdmin() {
		NonManagedEnvironmentAdminImpl nonManagedEnvironmentAdmin = new NonManagedEnvironmentAdminImpl();
		return nonManagedEnvironmentAdmin;
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
	public PasswordCredential createPasswordCredentialFromString(EDataType eDataType, String initialValue) {
		return (PasswordCredential)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPasswordCredentialToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subject createSubjectFromString(EDataType eDataType, String initialValue) {
		return (Subject)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSubjectToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionEventListener createConnectionEventListenerFromString(EDataType eDataType, String initialValue) {
		return (ConnectionEventListener)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConnectionEventListenerToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XAResource createXAResourceFromString(EDataType eDataType, String initialValue) {
		return (XAResource)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertXAResourceToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XAResource[] createXAResourceArrayFromString(EDataType eDataType, String initialValue) {
		return (XAResource[])super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertXAResourceArrayToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JCoDestination createJCoDestinationFromString(EDataType eDataType, String initialValue) {
		return (JCoDestination)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJCoDestinationToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivationSpec[] createActivationSpecArrayFromString(EDataType eDataType, String initialValue) {
		return (ActivationSpec[])super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActivationSpecArrayToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivationSpec createActivationSpecFromString(EDataType eDataType, String initialValue) {
		return (ActivationSpec)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActivationSpecToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BootstrapContext createBootstrapContextFromString(EDataType eDataType, String initialValue) {
		return (BootstrapContext)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBootstrapContextToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceAdapterInternalException createResourceAdapterInternalExceptionFromString(EDataType eDataType, String initialValue) {
		return (ResourceAdapterInternalException)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResourceAdapterInternalExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageEndpointFactory createMessageEndpointFactoryFromString(EDataType eDataType, String initialValue) {
		return (MessageEndpointFactory)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMessageEndpointFactoryToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrintWriter createPrintWriterFromString(EDataType eDataType, String initialValue) {
		return (PrintWriter)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPrintWriterToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String> createStringMapFromString(EDataType eDataType, String initialValue) {
		return (Map<String, String>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStringMapToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Set<String> createStringSetFromString(EDataType eDataType, String initialValue) {
		return (Set<String>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStringSetToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpiPackageImpl getSpiPackage() {
		return (SpiPackageImpl)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SpiPackageImpl getPackage() {
		return SpiPackageImpl.eINSTANCE;
	}

} //SpiFactoryImpl
