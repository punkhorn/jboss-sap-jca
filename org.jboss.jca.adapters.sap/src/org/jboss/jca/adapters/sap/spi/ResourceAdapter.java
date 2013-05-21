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

/**
 * Specializes the {@link avax.resource.spi.ResourceAdapter} interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 */
public interface ResourceAdapter extends javax.resource.spi.ResourceAdapter {
	/**
	 * {@inheritDoc}
	 */
	boolean equals(Object other);

	/**
	 * {@inheritDoc}
	 */
	int hashCode();

	/**
	 * Returns <code>true</code> if resource adapter is started; <code>false</code> otherwise.
	 * 
	 * @return <code>true</code> if resource adapter is started; <code>false</code> otherwise.
	 */
	boolean isStarted();

	/**
	 * Sets the <code>loadAndStoreState</code> flag of this {@link ResourceAdapter} instance.
	 * 
	 * <p>This flag specifies whether this {@link ResourceAdapter} loads and stores its state when started and stopped. Default is <code>false</code>: it does not load and store its state.
	 * 
	 * @param loadAndStoreState - the <code>loadAndStoreState</code> flag of this {@link ResourceAdapter} instance.
	 */
	public abstract void setLoadAndStoreState(boolean loadAndStoreState);

	/**
	 * Gets the <code>loadAndStoreState</code> flag of this {@link ResourceAdapter} instance.
	 * 
	 * <p>This flag specifies whether this {@link ResourceAdapter} loads and stores its state when started and stopped. Default is <code>false</code>: it does not load and store its state.
	 * 
	 * @return The <code>loadAndStoreState</code> flag of this {@link ResourceAdapter} instance.
	 */
	public abstract boolean isLoadAndStoreState();


	/**
	 * Sets the resource URI string of this {@link ResourceAdapter} instance.
	 * 
	 * <p>The <code>resourceURI</code> specifies the location to load the state of the {@link ResourceAdapter} instance from when it is started and where to store its state to when it is stopped.
	 * 
	 * @param resourceUri - the resource URI string of this {@link ResourceAdapter} instance.
	 */
	public abstract void setResourceUri(String resourceUri);

	/**
	 * Gets the resource URI string of this {@link ResourceAdapter} instance.
	 * 
	 * <p>The <code>resourceURI</code> specifies the location to load the state of the {@link ResourceAdapter} instance from when it is started and where to store its state to when it is stopped.
	 * 
	 * @return The resource URI string of this {@link ResourceAdapter} instance.
	 */
	public abstract String getResourceUri();

}
