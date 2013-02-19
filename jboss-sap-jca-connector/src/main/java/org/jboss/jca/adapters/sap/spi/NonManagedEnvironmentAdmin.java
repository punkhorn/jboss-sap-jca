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

import java.util.Map;

import javax.resource.ResourceException;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * Connector specific interface to manage the JBoss SAP JCA Connector in a stand alone environment (i.e. outside an application server environment).
 * 
 * @author William Collins
 * 
 * @version $Id: $
 * <!-- end-user-doc -->
 *
 *
 * @model
 * @generated
 */
public interface NonManagedEnvironmentAdmin extends EObject {

	/**
	 * The singleton instance of the Administration interface.
	 * 
	 * @generated NOT
	 */
	public static NonManagedEnvironmentAdmin INSTANCE = org.jboss.jca.adapters.sap.spi.impl.NonManagedEnvironmentAdminImpl.INSTANCE;

	/**
	 * <!-- begin-user-doc -->
	 * Create and configure a new {@link ManagedConnectionFactory} managed by
	 * the resource adapter.
	 * 
	 * @param config
	 *            - the configuration properties used to configure the managed
	 *            connection factory or <code>null</code> if the managed
	 *            connection factory will use its default configuration.
	 *            <p>
	 *            NB: A minimal set of configuration properties must be passed
	 *            in order for the managed connection factory to create usable
	 *            managed connections by default.
	 * @return new {@link ManagedConnectionFactory} managed by the resource
	 *         adapter.
	 * @throws ResourceException
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException" configDataType="org.jboss.jca.adapters.sap.spi.StringMap"
	 * @generated
	 */
	ManagedConnectionFactory createManagedConnectionFactory(Map<String, String> config) throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * Returns <code>true</code> if resource adapter is deployed;
	 * <code>false</code> otherwise.
	 * 
	 * @return <code>true</code> if resource adapter is deployed;
	 *         <code>false</code> otherwise.
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isResourceAdapterDeployed();

	/**
	 * <!-- begin-user-doc -->
	 * Creates, configures and starts the resource adapter of the JBoss SAP JCA
	 * Connector
	 * 
	 * <p>
	 * NB: The resource adapter must be deployed before any resources of the
	 * adapter such as managed connection factories can be successfully created.
	 * 
	 * @param config
	 *            - the configuration properties to use when configuring the
	 *            resource adapter or <code>null</code> if the resource adapter
	 *            will use its default configuration.
	 *            <p>
	 *            NB: The <code>config</code> parameter is currently ignored.
	 * @throws ResourceException
	 * <!-- end-user-doc -->
	 * @model exceptions="org.jboss.jca.adapters.sap.cci.ResourceException" configDataType="org.jboss.jca.adapters.sap.spi.StringMap"
	 * @generated
	 */
	void deployResourceAdapter(Map<String, String> config) throws ResourceException;

	/**
	 * <!-- begin-user-doc -->
	 * Stops the resource adapter of the JBoss SAP JCA Connector.
	 * 
	 * <p>
	 * NB: Destroys all resources managed by the resource adapter including
	 * managed connections and managed connection factories. While in an
	 * <code>undeployed<CODE> state, all methods of the SPI factory except {@link NonManagedEnvironmentAdmin#deployResourceAdapter(Map)} will fail by throwing an {@link ResourceException}.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void undeployResourceAdapter();

} // NonManagedEnvironmentAdmin
