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

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.jboss.jca.adapters.sap.model.edit.spi.ConnectionRequestInfoStoreItemProvider;
import org.jboss.jca.adapters.sap.model.spi.SpiFactory;
import org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.spi.ConnectionRequestInfoStore;
import org.jboss.jca.adapters.sap.util.EditingSupport;

import com.sap.conn.jco.ext.DestinationDataProvider;

/**
 * Implements the {@link ConnectionRequestInfoStore} and {@link DestinationDataProvider} interfaces for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 *
 */
public class ConnectionRequestInfoStoreImpl extends ConnectionRequestInfoStoreItemProvider implements
		ConnectionRequestInfoStore {

	protected EditingSupport<org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfoStore> editingSupport = new EditingSupport<org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfoStore>(this);
	
	
	/**
	 * Create {@link ConnectionRequestInfoStore} instance.
	 * 
	 * @param adapterFactory
	 */
	public ConnectionRequestInfoStoreImpl() {
		super(SpiJcaAdapterFactory.INSTANCE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConnectionRequestInfo getConnectionRequestInfo(String connectionName) {
		editingSupport.getReadLock().lock();
		try {
			EObject model = editingSupport.getModel().getConnectionRequestInfos().get(connectionName);
			return (ConnectionRequestInfo) getRootAdapterFactory().adapt(model, ConnectionRequestInfo.class);
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public Notifier getTarget() {
		if (target == null) {
			synchronized (this) {
				if (target == null) {
					target = initializeModel();
					target.eAdapters().add(this);
				}
			}
		}
		return target;
	}

	protected EObject initializeModel() {
		return SpiFactory.eINSTANCE.createConnectionRequestInfoStore();
	}

}
