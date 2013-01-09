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
package org.jboss.jca.adapters.sap.cci.impl;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.resource.ResourceException;
import javax.resource.cci.ConnectionSpec;
import javax.resource.spi.ConnectionManager;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.jboss.jca.adapters.sap.cci.Connection;
import org.jboss.jca.adapters.sap.cci.ConnectionFactory;
import org.jboss.jca.adapters.sap.cci.RecordFactory;
import org.jboss.jca.adapters.sap.cci.ResourceAdapterMetaData;
import org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory;

import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoRepository;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Factory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.cci.impl.ConnectionFactoryImpl#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionFactoryImpl extends EObjectImpl implements ConnectionFactory {
	/**
	 * @generated NOT
	 */
	private static final long serialVersionUID = -6650542883206047114L;
	
	/**
	 * The default value of the '{@link #getReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected static final Reference REFERENCE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected Reference reference = REFERENCE_EDEFAULT;
	
	/**
	 * @generated NOT
	 */
	private ManagedConnectionFactory managedConnectionFactory;

	/**
	 * @generated NOT
	 */
	private ConnectionManager connectionManager;
	
	/**
	 * @generated NOT
	 */
	private RecordFactory recordFactory;
	
	/**
	 * @generated NOT
	 */
	private ResourceAdapterMetaData resourceAdapterMetaData;


	/**
	 * <!-- begin-user-doc -->
	 * Default Constructor
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ConnectionFactoryImpl() {
		super();
	}

	/**
	 * 
	 * 
	 * @param connectionManager
	 *            ConnectionManager
	 * @generated NOT
	 */
	public ConnectionFactoryImpl(ManagedConnectionFactory managedConnectionFactory,	ConnectionManager connectionManager) {
		super();
		this.managedConnectionFactory = managedConnectionFactory;
		this.connectionManager = connectionManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CciPackageImpl.Literals.CONNECTION_FACTORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Reference getReference() throws NamingException {
		if(reference == null)
			throw ExceptionBundle.EXCEPTIONS.referenceIsNull();
		return getReferenceGen();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference getReferenceGen() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(Reference newReference) {
		Reference oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackageImpl.CONNECTION_FACTORY__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Connection getConnection() throws ResourceException {
		ConnectionImpl newConnection = (ConnectionImpl) connectionManager.allocateConnection(
				managedConnectionFactory, null);
		newConnection.setConnectionManager(connectionManager);

		return newConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Connection getConnection(ConnectionSpec connectionSpec) throws ResourceException {
		if (!(connectionSpec instanceof org.jboss.jca.adapters.sap.cci.ConnectionSpec))
			throw ExceptionBundle.EXCEPTIONS.invalidConnectionSpecType(connectionSpec.getClass().getName());

		ConnectionRequestInfo connectionRequestInfo = managedConnectionFactory.convertConnectionSpecToConnectionRequestInfo((org.jboss.jca.adapters.sap.cci.ConnectionSpec)connectionSpec);

		ConnectionImpl newConnection = (ConnectionImpl) connectionManager.allocateConnection(
				managedConnectionFactory, connectionRequestInfo);
		newConnection.setConnectionManager(connectionManager);

		return newConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RecordFactory getRecordFactory() throws ResourceException {
		try {
			if (recordFactory == null) {
				JCoRepository repository = ((ConnectionImpl)getConnection()).getDestination().getRepository();
				recordFactory = CciFactoryImpl.eINSTANCE.createRecordFactory();
				((org.jboss.jca.adapters.sap.cci.impl.RecordFactoryImpl)recordFactory).setRepository(repository);
			}
			return recordFactory;
		} catch (JCoException e) {
			throw ExceptionBundle.EXCEPTIONS.failedToGetRecordFactory(e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ResourceAdapterMetaData getMetaData() throws ResourceException {
		if (resourceAdapterMetaData == null) {
			resourceAdapterMetaData = new ResourceAdapterMetaDataImpl();
		}
		return resourceAdapterMetaData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CciPackageImpl.CONNECTION_FACTORY__REFERENCE:
				return getReferenceGen();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CciPackageImpl.CONNECTION_FACTORY__REFERENCE:
				setReference((Reference)newValue);
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
			case CciPackageImpl.CONNECTION_FACTORY__REFERENCE:
				setReference(REFERENCE_EDEFAULT);
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
			case CciPackageImpl.CONNECTION_FACTORY__REFERENCE:
				return REFERENCE_EDEFAULT == null ? reference != null : !REFERENCE_EDEFAULT.equals(reference);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (reference: ");
		result.append(reference);
		result.append(')');
		return result.toString();
	}

} //ConnectionFactoryImpl
