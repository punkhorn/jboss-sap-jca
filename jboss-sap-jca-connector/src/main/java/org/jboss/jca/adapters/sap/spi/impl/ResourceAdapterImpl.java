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

import java.util.Collection;

import javax.resource.ResourceException;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.ResourceAdapterInternalException;
import javax.resource.spi.endpoint.MessageEndpointFactory;
import javax.transaction.xa.XAResource;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.spi.ResourceAdapter;

import com.sap.conn.jco.ext.Environment;

/**
 * <!-- begin-user-doc -->
 * Implements the {@link ResourceAdapter }interface for the JBoss SAP
 * JCA Connector.
 * 
 * @author William Collins
 * 
 * @version $Id:  $
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.spi.impl.ResourceAdapterImpl#getManagedConnectionFactories <em>Managed Connection Factories</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceAdapterImpl extends EObjectImpl implements ResourceAdapter {

	/**
	 * The cached value of the '{@link #getManagedConnectionFactories() <em>Managed Connection Factories</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * The set of active managed connection factories currently managed by this resource adapter.
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #getManagedConnectionFactories()
	 * @generated
	 * @ordered
	 */
	protected EList<ManagedConnectionFactory> managedConnectionFactories;

	/**
	 * States of a Resource Adapter
	 * 
	 * @generated NOT
	 */
	public static enum State {
		STARTED,
		STARTING,
		STOPPED;
	}

	/** 
	 * Destination Provider for JCo runtime. 
	 * 
	 * @generated NOT
	 */
	private final DestinationDataProviderImpl destinationDataProvider;

	/** 
	 * State of resource adapter
	 * 
	 * Resource adapter starts in <code>STOPPED</code> state when created and can
	 * transition back and forth to and from <code>STARTED</code> and
	 * <code>STOPPED</code> states.
	 * 
	 * @generated NOT
	 */
	private State state = State.STARTING;

	/**
	 * <!-- begin-user-doc -->
	 * Creates an {@link ResourceAdapter} instance.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ResourceAdapterImpl() {
		super();
		destinationDataProvider = new DestinationDataProviderImpl();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpiPackageImpl.Literals.RESOURCE_ADAPTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EList<ManagedConnectionFactory> getManagedConnectionFactoriesGen() {
		if (managedConnectionFactories == null) {
			managedConnectionFactories = new EObjectContainmentEList<ManagedConnectionFactory>(ManagedConnectionFactory.class, this, SpiPackageImpl.RESOURCE_ADAPTER__MANAGED_CONNECTION_FACTORIES);
		}
		return managedConnectionFactories;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<ManagedConnectionFactory> getManagedConnectionFactories() {
		return ECollections.unmodifiableEList(getManagedConnectionFactoriesGen());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof ResourceAdapterImpl))
			return false;

		// Return true to prevent application server from deploying multiple instances of this resource adapter.
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int hashCode() {
		int result = 17;
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isStarted() {
		return state == State.STARTED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void start(BootstrapContext bootstrapContext) throws ResourceAdapterInternalException {
		if (state == State.STARTED)
			return;
		state = State.STARTED;
		Environment.registerDestinationDataProvider(destinationDataProvider);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public synchronized void stop() {
		if (state == State.STOPPED)
			return;
		state = State.STOPPED;

		// Destroy all outstanding connection factories
		EList<ManagedConnectionFactory> copy = null;
		if (getManagedConnectionFactoriesGen().size() > 0) 
			copy = (EList<ManagedConnectionFactory>)  ((BasicEList<ManagedConnectionFactory>)getManagedConnectionFactoriesGen()).clone();
		
		if (copy != null) {
			for (ManagedConnectionFactory managedConnectionFactory: copy) {
				try {
					managedConnectionFactory.destroy();
				} catch (ResourceException e) {
				}
			}
		}

		Environment.unregisterDestinationDataProvider(destinationDataProvider);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public XAResource[] getXAResources(ActivationSpec[] activationSpecs) throws ResourceException {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void endpointActivation(MessageEndpointFactory endpointFactory, ActivationSpec activationSpec) throws ResourceException {
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void endpointDeactivation(MessageEndpointFactory endpointFactory, ActivationSpec activationSpec) {
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpiPackageImpl.RESOURCE_ADAPTER__MANAGED_CONNECTION_FACTORIES:
				return ((InternalEList<?>)getManagedConnectionFactories()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SpiPackageImpl.RESOURCE_ADAPTER__MANAGED_CONNECTION_FACTORIES:
				return getManagedConnectionFactories();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SpiPackageImpl.RESOURCE_ADAPTER__MANAGED_CONNECTION_FACTORIES:
				getManagedConnectionFactories().clear();
				getManagedConnectionFactories().addAll((Collection<? extends ManagedConnectionFactory>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SpiPackageImpl.RESOURCE_ADAPTER__MANAGED_CONNECTION_FACTORIES:
				getManagedConnectionFactories().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SpiPackageImpl.RESOURCE_ADAPTER__MANAGED_CONNECTION_FACTORIES:
				return managedConnectionFactories != null && !managedConnectionFactories.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * Return the {@link DesitnationDataProviderImpl} instance managing connection configurations for adapter.
	 * @return the {@link DesitnationDataProviderImpl} instance managing connection configurations for adapter.
	 * @generated NOT
	 */
	protected DestinationDataProviderImpl getDestinationDataProvider() {
		return destinationDataProvider;
	}

	/**
	 * Associate the given managed connection factory with this adapter.
	 *  
	 * @param factory - The managed connection factory to be associated.
	 * @generated NOT
	 */
	protected synchronized void associateConnectionFactory(ManagedConnectionFactoryImpl factory) throws ResourceException {
		checkState();
		getManagedConnectionFactoriesGen().add(factory);
	}

	/**
	 * Dissociate the given managed connection factory with this a adapter.
	 * @param factory - The managed connection factory to be dissociated.
	 * @generated NOT
	 */
	protected synchronized void dissociateConnection(ManagedConnectionFactoryImpl factory) {
		getManagedConnectionFactoriesGen().remove(factory);
	}
	
	/**
	 * Internal helper method used by public methods to check the state of the Resource Adapter instance before performing an operation on it. This
	 * method prevents operations from being performed on Resource Adapter instance when it is in a <code>STOPPED</code> state.
	 * 
	 * @throws ResourceException if Resource Adapter instance is in an <code>STOPPED</code> state.
	 * @generated NOT
	 */
	private void checkState() throws ResourceException {
		if (state == State.STOPPED) {
			throw ExceptionBundle.EXCEPTIONS.resourceAdapterIsStopped();
		}
	}
} //ResourceAdapterImpl
