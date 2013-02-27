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

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.resource.ResourceException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.spi.NonManagedEnvironmentAdmin;
import org.jboss.jca.adapters.sap.spi.ResourceAdapter;

/**
 * <!-- begin-user-doc -->
 * Implements the {@link NonManagedEnvironmentAdmin } interface for the JBoss SAP
 * JCA Connector.
 * 
 * @author William Collins
 * 
 * @version $Id:  $
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.spi.impl.NonManagedEnvironmentAdminImpl#getResourceAdapter <em>Resource Adapter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NonManagedEnvironmentAdminImpl extends EObjectImpl implements NonManagedEnvironmentAdmin {

	/**
	 * The cached value of the '{@link #getResourceAdapter() <em>Resource Adapter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceAdapter()
	 * @generated
	 * @ordered
	 */
	protected ResourceAdapter resourceAdapter;

	/**
	 * States of Administration instance
	 * 
	 * @generated NOT
	 */
	public static enum State {
		DEPLOYED, /* Administration instance has deployed resource adapter */
		UNDEPLOYED; /* Administration instance has undeployed resource adapter */
	}

	/**
	 * The Administration instance
	 * 
	 * @generated NOT
	 */
	public static final NonManagedEnvironmentAdmin INSTANCE = new NonManagedEnvironmentAdminImpl();

	/**
	 * State of Administration instance
	 * 
	 * Administration instance starts in <code>UNDEPLOYED</code> state when created and can
	 * transition back and forth to and from <code>DEPLOYED</code> and
	 * <code>UNDEPLOYED</code> states.
	 * 
	 * @generated NOT
	 */
	private State state = State.UNDEPLOYED;

	/**
	 * The resource adapter currently deployed by Administration instance.
	 * 
	 * @generated NOT
	 */
	private ResourceAdapterImpl ra;

	/**
	 * <!-- begin-user-doc -->
	 * Creates a {@link NonManagedEnvironmentAdmin} instance.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NonManagedEnvironmentAdminImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpiPackageImpl.Literals.NON_MANAGED_ENVIRONMENT_ADMIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceAdapter getResourceAdapter() {
		return resourceAdapter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceAdapter(ResourceAdapter newResourceAdapter, NotificationChain msgs) {
		ResourceAdapter oldResourceAdapter = resourceAdapter;
		resourceAdapter = newResourceAdapter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpiPackageImpl.NON_MANAGED_ENVIRONMENT_ADMIN__RESOURCE_ADAPTER, oldResourceAdapter, newResourceAdapter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ManagedConnectionFactory createManagedConnectionFactory(Map<String, String> config) throws ResourceException {
		checkState();

		ManagedConnectionFactoryImpl managedConnectionFactory = new ManagedConnectionFactoryImpl();
		managedConnectionFactory.setResourceAdapter(ra);
		if (config != null && config.size() > 0) {
			setProperties(managedConnectionFactory, config);
		}

		return managedConnectionFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isResourceAdapterDeployed() {
		return state == State.DEPLOYED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void deployResourceAdapter(Map<String, String> config) throws ResourceException {
		if (state == State.DEPLOYED)
			return;
		state = State.DEPLOYED;

		ra = new ResourceAdapterImpl();
		if (config != null && config.size() > 0) {
			setProperties(ra, config);
		}
		ra.start(null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void undeployResourceAdapter() {
		if (state == State.UNDEPLOYED)
			return;
		state = State.UNDEPLOYED;

		ra.stop();
		ra = null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpiPackageImpl.NON_MANAGED_ENVIRONMENT_ADMIN__RESOURCE_ADAPTER:
				return basicSetResourceAdapter(null, msgs);
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
			case SpiPackageImpl.NON_MANAGED_ENVIRONMENT_ADMIN__RESOURCE_ADAPTER:
				return getResourceAdapter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SpiPackageImpl.NON_MANAGED_ENVIRONMENT_ADMIN__RESOURCE_ADAPTER:
				return resourceAdapter != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * Set the properties of the given Java Bean with the values supplied by
	 * given configuration.
	 * 
	 * @param bean
	 *            - the Java Bean whose properties to set
	 * @param configuration
	 *            - the configuration of property values to use
	 * @throws ResourceException
	 * 
	 * @generated NOT
	 */
	private void setProperties(Object bean, Map<String, String> configuration) throws ResourceException {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
			for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
				String value = configuration.get(propertyDescriptor.getName());
				if (value != null) {
					setProperty(bean, propertyDescriptor, value);
				}
			}
		} catch (IntrospectionException e) {
			throw new ResourceException();
		}
	}

	/**
	 * Set the property of the given Java Bean designate by the given property descriptor with the given value.
	 * 
	 * @param bean - the Java Bean whose property to set
	 * @param propertyDescriptor - the property descriptor of the property to set.
	 * @param value - the value to set on property.
	 * @throws ResourceException
	 * 
	 * @generated NOT
	 */
	private void setProperty(Object bean, PropertyDescriptor propertyDescriptor, String value) throws ResourceException {
		Method setter = propertyDescriptor.getWriteMethod();
		Object[] args = { value };
		try {
			setter.invoke(bean, args);
		} catch (IllegalArgumentException e) {
			throw new ResourceException();
		} catch (IllegalAccessException e) {
			throw new ResourceException();
		} catch (InvocationTargetException e) {
			throw new ResourceException();
		}
	}

	/**
	 * Internal helper method used by public methods to check the state of the Administration instance before performing an operation on it. This
	 * method prevents operations from being performed on Administration instance when it is in an <code>UNDEPLOYED</code> state.
	 * 
	 * @throws ResourceException if Administration instance is in an <code>UNDEPLOYED</code> state.
	 * 
	 * @generated NOT
	 */
	private void checkState() throws ResourceException {
		if (state == State.UNDEPLOYED) {
			throw ExceptionBundle.EXCEPTIONS.resourceAdapterIsUndeployed();
		}
	}

} //NonManagedEnvironmentAdminImpl
