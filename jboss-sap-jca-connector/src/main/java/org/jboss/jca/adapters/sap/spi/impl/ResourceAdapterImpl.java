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

import java.util.HashSet;
import java.util.Set;

import javax.resource.ResourceException;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.ResourceAdapterInternalException;
import javax.resource.spi.endpoint.MessageEndpointFactory;
import javax.transaction.xa.XAResource;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
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
 * </p>
 *
 * @generated
 */
public class ResourceAdapterImpl extends EObjectImpl implements ResourceAdapter {

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
	 * The set of active managed connection factories currently managed by this resource adapter.
	 * 
	 * @generated NOT
	 */
	private final Set<ManagedConnectionFactoryImpl> factories = new HashSet<ManagedConnectionFactoryImpl>();
	
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
	public synchronized void stop() {
		if (state == State.STOPPED)
			return;
		state = State.STOPPED;

		// Destroy all outstanding connection factories
		Set<ManagedConnectionFactoryImpl> copy = null;
		synchronized (factories) {
			if (factories.size() > 0) 
				copy = new HashSet<ManagedConnectionFactoryImpl>(factories);
		}
		
		if (copy != null) {
			for (ManagedConnectionFactoryImpl managedConnectionFactory: copy) {
				try {
					managedConnectionFactory.destroy();
				} catch (ResourceException e) {
					//e.printStackTrace();
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
	protected void associateConnectionFactory(ManagedConnectionFactoryImpl factory) throws ResourceException {
		checkState();
		synchronized (factories) {
			factories.add(factory);
		}
	}

	/**
	 * Dissociate the given managed connection factory with this a adapter.
	 * @param factory - The managed connection factory to be dissociated.
	 * @generated NOT
	 */
	protected void dissociateConnection(ManagedConnectionFactoryImpl factory) {
		synchronized (factories) {
			factories.remove(factory);
		}
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
