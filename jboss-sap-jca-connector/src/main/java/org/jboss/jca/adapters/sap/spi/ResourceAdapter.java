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
package org.jboss.jca.adapters.sap.spi;

import javax.resource.ResourceException;

import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.ResourceAdapterInternalException;

import javax.resource.spi.endpoint.MessageEndpointFactory;

import javax.transaction.xa.XAResource;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * Specializes the {@link javax.resource.spi.ManagedConnectionFactory} interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 * <!-- end-user-doc -->
 *
 *
 * @model superTypes="org.jboss.jca.adapters.sap.spi.SPIResourceAdapter"
 * @generated
 */
public interface ResourceAdapter extends EObject, javax.resource.spi.ResourceAdapter {
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean equals(Object other);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	int hashCode();

	/**
	 * <!-- begin-user-doc -->
	 * Returns <code>true</code> if resource adapter is started; <code>false</code> otherwise.
	 * 
	 * @return <code>true</code> if resource adapter is started; <code>false</code> otherwise.
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isStarted();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.spi.ResourceAdapterInternalException" bootstrapContextDataType="org.jboss.jca.adapters.sap.spi.BootstrapContext"
	 * @generated
	 */
	void start(BootstrapContext bootstrapContext) throws ResourceAdapterInternalException;

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void stop();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model dataType="org.jboss.jca.adapters.sap.spi.XAResourceArray" exceptions="org.jboss.jca.adapters.sap.cci.ResourceException" activationSpecsDataType="org.jboss.jca.adapters.sap.spi.ActivationSpecArray"
	 * @generated
	 */
	XAResource[] getXAResources(ActivationSpec[] activationSpecs) throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException" endpointFactoryDataType="org.jboss.jca.adapters.sap.spi.MessageEndpointFactory" activationSpecDataType="org.jboss.jca.adapters.sap.spi.ActivationSpec"
	 * @generated
	 */
	void endpointActivation(MessageEndpointFactory endpointFactory, ActivationSpec activationSpec) throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @model endpointFactoryDataType="org.jboss.jca.adapters.sap.spi.MessageEndpointFactory" activationSpecDataType="org.jboss.jca.adapters.sap.spi.ActivationSpec"
	 * @generated
	 */
	void endpointDeactivation(MessageEndpointFactory endpointFactory, ActivationSpec activationSpec);

} // ResourceAdapter
