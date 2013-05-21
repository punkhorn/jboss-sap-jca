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
import javax.resource.spi.ManagedConnectionFactory;

import org.jboss.jca.adapters.sap.spi.NonManagedEnvironmentAdmin;
import org.jboss.jca.adapters.sap.spi.ResourceAdapter;

/**
 * Implements the {@link NonManagedEnvironmentAdmin } interface for the JBoss SAP
 * JCA Connector.
 * 
 * @author William Collins
 * 
 */
public class NonManagedEnvironmentAdminImpl implements
		NonManagedEnvironmentAdmin {

	/**
	 * Enumeration defining the states of a {@link NonManagedEnvironmentAdmin} instance.
	 * <p>{@link State#DEPLOYED} - In this state a {@link NonManagedEnvironmentAdmin} has deployed a {@link ResourceAdapter} instance.
	 * <p>{@link State#UNDEPLOYED} - In this state a {@link NonManagedEnvironmentAdmin} has not deployed a {@link ResourceAdapter} instance.
	 */
	public static enum State {
		
		/**
		 * The {@link State} of a {@link NonManagedEnvironmentAdmin} where it has deployed a {@link ResourceAdapter} instance.
		 */
		DEPLOYED,
		/**
		 * The {@link State} of a {@link NonManagedEnvironmentAdmin} where it has NOT deployed a {@link ResourceAdapter} instance.
		 */
		UNDEPLOYED; 
	}

	/**
	 * The Administration instance
	 */
	public static final NonManagedEnvironmentAdmin INSTANCE = new NonManagedEnvironmentAdminImpl();

	/**
	 * State of Administration instance
	 * 
	 * Administration instance starts in <code>UNDEPLOYED</code> state when created and can
	 * transition back and forth to and from <code>DEPLOYED</code> and
	 * <code>UNDEPLOYED</code> states.
	 * 
	 */
	private State state = State.UNDEPLOYED;

	/**
	 * The deployed {@link ResourceAdapter} instance.
	 */
	protected ResourceAdapter resourceAdapter;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResourceAdapter getResourceAdapter() {
		return resourceAdapter;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ManagedConnectionFactory createManagedConnectionFactory(
			Map<String, String> config) throws ResourceException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isResourceAdapterDeployed() {
		return state.equals(State.DEPLOYED);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deployResourceAdapter(Map<String, String> config)
			throws ResourceException {
		if (state == State.DEPLOYED)
			return;
		state = State.DEPLOYED;

		resourceAdapter = new ResourceAdapterImpl();
		if (config != null && config.size() > 0) {
			setProperties(resourceAdapter, config);
		}
		resourceAdapter.start(null);
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undeployResourceAdapter() {
		// TODO Auto-generated method stub

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
			throw new ResourceException("The resource adapter is undeployed");
		}
	}

}
