/*
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
import javax.resource.spi.ManagedConnectionFactory;

import org.jboss.jca.adapters.sap.spi.UnmanagedEnvironmentAdmin;

/**
 * Implements the {@link UnmanagedEnvironmentAdmin } interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 * 
 * @version $Id: $
 */
public class UnmanagedEnvironmentAdminImpl implements UnmanagedEnvironmentAdmin {

	/**
	 * States of Administration instance
	 */
	public static enum State {
		DEPLOYED, /* Administration instance has deployed resource adapter */
		UNDEPLOYED; /* Administration instance has undeployed resource adapter */
	}

	/**
	 * The Administration instance
	 */
	public static final UnmanagedEnvironmentAdmin INSTANCE = new UnmanagedEnvironmentAdminImpl();

	/**
	 * State of Administration instance
	 * 
	 * Administration instance starts in <code>UNDEPLOYED</code> state when created and can
	 * transition back and forth to and from <code>DEPLOYED</code> and
	 * <code>UNDEPLOYED</code> states.
	 */
	private State state = State.UNDEPLOYED;

	/**
	 * The resource adapter currently deployed by Administration instance.
	 */
	private ResourceAdapterImpl ra;

	/**
	 * Default constructor of Administration instance; protected to prevent multiple
	 * instances from being constructed.
	 */
	protected UnmanagedEnvironmentAdminImpl() {
	}
	
	@Override
	public boolean isResourceAdapterDeployed() {
		return state == State.DEPLOYED;
	}

	/**
	 * @see org.jboss.jca.adapters.sap.spi.UnmanagedEnvironmentAdmin#createManagedConnectionFactory(java.util.Map)
	 */
	@Override
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
	 * @see org.jboss.jca.adapters.sap.spi.UnmanagedEnvironmentAdmin#deployResourceAdapter(java.util.Map)
	 */
	@Override
	public void deployResourceAdapter(Map<String, String> config) throws ResourceException {
		synchronized (this) {
			if (state == State.DEPLOYED)
				return;
			state = State.DEPLOYED;
		}
		ra = new ResourceAdapterImpl();
		if (config != null && config.size() > 0) {
			setProperties(ra, config);
		}
		ra.start(null);
	}

	/**
	 * @see org.jboss.jca.adapters.sap.spi.UnmanagedEnvironmentAdmin#undeployResourceAdapter()
	 */
	@Override
	public void undeployResourceAdapter() {
		synchronized (this) {
			if (state == State.UNDEPLOYED)
				return;
			state = State.UNDEPLOYED;
		}
		ra.stop();
		ra = null;
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
	 */
	private void checkState() throws ResourceException {
		if (state == State.UNDEPLOYED) {
			throw ExceptionBundle.EXCEPTIONS.resourceAdapterIsUndeployed();
		}
	}

}
