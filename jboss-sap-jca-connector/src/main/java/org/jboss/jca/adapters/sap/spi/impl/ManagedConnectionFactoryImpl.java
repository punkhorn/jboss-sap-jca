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

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.DissociatableManagedConnection;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.security.PasswordCredential;
import javax.security.auth.Subject;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.jboss.jca.adapters.sap.cci.ConnectionSpec;
import org.jboss.jca.adapters.sap.cci.impl.ConnectionFactoryImpl;
import org.jboss.jca.adapters.sap.cci.impl.ConnectionSpecImpl;
import org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory;

import com.sap.conn.jco.ext.DestinationDataProvider;

/**
 * <!-- begin-user-doc -->
 * Implements the {@link ManagedConnection } and {@link DissociatableManagedConnection } interfaces for the JBoss SAP
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
public class ManagedConnectionFactoryImpl extends EObjectImpl implements ManagedConnectionFactory {

	/** 
	 * The serial version UID 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * States of a manage connection factory.
	 */
	public static enum State {
		ACTIVE,		/* Active managed connection factory capable of creating managed connection*/ 
		DESTROYED;	/* Destroyed managed connection factory; unusable state */
	}

	/** 
	 * The resource adapter 
	 */
	private ResourceAdapterImpl resourceAdapter;

	/** 
	 * The logwriter set by application server.
	 */
	private PrintWriter logwriter;

	/** 
	 * Default connection configuration properties.
	 * 
	 * This property set is populated by the application server with configuration properties found in the deployment
	 * descriptor of the resource adapter for this manage connection factory class. The application server populates the 
	 * configuration set by calling the property setters of this class. 
	 */
	private final ConnectionRequestInfoImpl defaultConnectionRequestInfo = new ConnectionRequestInfoImpl();

	/**
	 * The set of active managed connection currently managed by this factory.
	 */
	private final Set<ManagedConnectionImpl> connections = new HashSet<ManagedConnectionImpl>();
	
	/** 
	 * State of connection.
	 * 
	 * Managed connection factory starts in <code>ACTIVE</code> state when created and transitions to final <code>DESTROYED</code> state 
	 * when destroyed by application server. 
	 */
	private State state = State.ACTIVE;
	
	/**
	 * <!-- begin-user-doc -->
	 * Create an empty instance of a {@link ManagedConnectionFactory}.
	 * <!-- end-user-doc -->
	 * @generated NOt
	 */
	public ManagedConnectionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpiPackageImpl.Literals.MANAGED_CONNECTION_FACTORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ConnectionSpec convertConnectionRequestInfoToConnectionSpec(ConnectionRequestInfo connectionRequestInfo) {
		ConnectionSpec connectionSpec = new ConnectionSpecImpl();
		
		connectionSpec.setUserId( connectionRequestInfo.getProperty(DestinationDataProvider.JCO_USER_ID));
		connectionSpec.setClient( connectionRequestInfo.getProperty(DestinationDataProvider.JCO_CLIENT));
		connectionSpec.setUser( connectionRequestInfo.getProperty(DestinationDataProvider.JCO_USER));
		connectionSpec.setAliasUser( connectionRequestInfo.getProperty(DestinationDataProvider.JCO_ALIAS_USER));
		connectionSpec.setPasswd( connectionRequestInfo.getProperty(DestinationDataProvider.JCO_PASSWD));
		connectionSpec.setLang( connectionRequestInfo.getProperty(DestinationDataProvider.JCO_LANG));
		connectionSpec.setMysapsso2( connectionRequestInfo.getProperty(DestinationDataProvider.JCO_MYSAPSSO2));
		connectionSpec.setX509cert( connectionRequestInfo.getProperty(DestinationDataProvider.JCO_X509CERT));

		return connectionSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ConnectionRequestInfo convertConnectionSpecToConnectionRequestInfo(ConnectionSpec connectionSpec) {
		ConnectionRequestInfoImpl connectionRequestInfo = new ConnectionRequestInfoImpl();

		connectionRequestInfo.setProperty(DestinationDataProvider.JCO_USER_ID, connectionSpec.getUserId());
		connectionRequestInfo.setProperty(DestinationDataProvider.JCO_CLIENT, connectionSpec.getClient());
		connectionRequestInfo.setProperty(DestinationDataProvider.JCO_USER, connectionSpec.getUser());
		connectionRequestInfo.setProperty(DestinationDataProvider.JCO_ALIAS_USER, connectionSpec.getAliasUser());
		connectionRequestInfo.setProperty(DestinationDataProvider.JCO_PASSWD, connectionSpec.getPasswd());
		connectionRequestInfo.setProperty(DestinationDataProvider.JCO_LANG, connectionSpec.getLang());
		connectionRequestInfo.setProperty(DestinationDataProvider.JCO_MYSAPSSO2, connectionSpec.getMysapsso2());
		connectionRequestInfo.setProperty(DestinationDataProvider.JCO_X509CERT, connectionSpec.getX509cert());

		return connectionRequestInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized Object createConnectionFactory() throws ResourceException {
		checkState();
		return new ConnectionFactoryImpl(this, new DefaultConnectionManagerImpl());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized Object createConnectionFactory(ConnectionManager connectionManager) throws ResourceException {
		checkState();
		return new ConnectionFactoryImpl(this, connectionManager);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized ManagedConnection createManagedConnection(Subject subject, javax.resource.spi.ConnectionRequestInfo connectionRequestInfo) throws ResourceException {
		checkState();
		
		// validate connection request info type
		if (connectionRequestInfo != null && !(connectionRequestInfo instanceof ConnectionRequestInfoImpl))
			throw ExceptionBundle.EXCEPTIONS.invalidConnectionRequestInfoType(connectionRequestInfo.getClass().getName());

		// merge client connection request info with defaults
		ConnectionRequestInfoImpl cri = new ConnectionRequestInfoImpl(defaultConnectionRequestInfo);
		if (connectionRequestInfo != null)
			cri.addProperties(((ConnectionRequestInfoImpl) connectionRequestInfo).getProperties());

		// use credentials in non-null subject.
		if (subject != null) {
			boolean foundCredential = false;
			for (PasswordCredential credential : subject.getPrivateCredentials(PasswordCredential.class)) {
				javax.resource.spi.ManagedConnectionFactory mcf = credential.getManagedConnectionFactory();
				if (mcf != null && mcf.equals(this)) {
					cri.setProperty(DestinationDataProvider.JCO_USER, credential.getUserName());
					cri.setProperty(DestinationDataProvider.JCO_PASSWD, new String(credential.getPassword()));
					foundCredential = true;
					break;
				}
			}
			if (!foundCredential)
				// Did not find sufficient credentials in subject.
				throw ExceptionBundle.EXCEPTIONS.insufficientSecurityCredentialsInSubject();
		}

		return new ManagedConnectionImpl(this, cri);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void destroy() throws ResourceException {
		
		if (state == State.DESTROYED)
			return;
		state = State.DESTROYED;

		Set<ManagedConnectionImpl> copy = null;
		if (connections.size() > 0)
			copy = new HashSet<ManagedConnectionImpl>(connections);
		
		if (copy != null) {
			for (ManagedConnectionImpl managedConnection: copy) {
				managedConnection.destroy();
			}
		}
		
		this.resourceAdapter.dissociateConnection(this);
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
		if (!(other instanceof ManagedConnectionFactoryImpl))
			return false;
		ManagedConnectionFactoryImpl obj = (ManagedConnectionFactoryImpl) other;
		return obj.defaultConnectionRequestInfo.equals(defaultConnectionRequestInfo);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getAliasUser() {
		return defaultConnectionRequestInfo.getAliasUser();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getAshost() {
		return defaultConnectionRequestInfo.getAshost();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getAuthType() {
		return defaultConnectionRequestInfo.getAuthType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getClient() {
		return defaultConnectionRequestInfo.getClient();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getCodepage() {
		return defaultConnectionRequestInfo.getCodepage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getCpicTrace() {
		return defaultConnectionRequestInfo.getCpicTrace();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getDenyInitialPassword() {
		return defaultConnectionRequestInfo.getDenyInitialPassword();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getExpirationPeriod() {
		return defaultConnectionRequestInfo.getExpirationPeriod();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getExpirationTime() {
		return defaultConnectionRequestInfo.getExpirationTime();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getGetsso2() {
		return defaultConnectionRequestInfo.getGetsso2();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getGroup() {
		return defaultConnectionRequestInfo.getGroup();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getGwhost() {
		return defaultConnectionRequestInfo.getGwhost();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getGwserv() {
		return defaultConnectionRequestInfo.getGwserv();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getLang() {
		return  defaultConnectionRequestInfo.getLang();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getLcheck() {
		return defaultConnectionRequestInfo.getLcheck();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PrintWriter getLogWriter() throws ResourceException {
		return logwriter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getMaxGetTime() {
		return defaultConnectionRequestInfo.getMaxGetTime();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getMshost() {
		return defaultConnectionRequestInfo.getMshost();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getMsserv() {
		return defaultConnectionRequestInfo.getMsserv();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getMysapsso2() {
		return defaultConnectionRequestInfo.getMysapsso2();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPasswd() {
		return defaultConnectionRequestInfo.getPasswd();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPcs() {
		return defaultConnectionRequestInfo.getPcs();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPeakLimit() {
		return defaultConnectionRequestInfo.getPeakLimit();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPingOnCreate() {
		return defaultConnectionRequestInfo.getPingOnCreate();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPoolCapacity() {
		return defaultConnectionRequestInfo.getPoolCapacity();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getR3name() {
		return defaultConnectionRequestInfo.getR3name();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getRepositoryDest() {
		return defaultConnectionRequestInfo.getRepositoryDest();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getRepositoryPasswd() {
		return defaultConnectionRequestInfo.getRepositoryPasswd();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getRepositoryRoundtripOptimization() {
		return defaultConnectionRequestInfo.getRepositoryRoundtripOptimization();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getRepositorySnc() {
		return defaultConnectionRequestInfo.getRepositorySnc();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getRepositoryUser() {
		return defaultConnectionRequestInfo.getRepositoryUser();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ResourceAdapterImpl getResourceAdapter() {
		return resourceAdapter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSaprouter() {
		return defaultConnectionRequestInfo.getSaprouter();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSncLibrary() {
		return defaultConnectionRequestInfo.getSncLibrary();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSncMode() {
		return defaultConnectionRequestInfo.getSncMode();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSncMyname() {
		return defaultConnectionRequestInfo.getSncMyname();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSncPartnername() {
		return defaultConnectionRequestInfo.getSncPartnername();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSncQop() {
		return defaultConnectionRequestInfo.getSncQop();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSysnr() {
		return defaultConnectionRequestInfo.getSysnr();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getTphost() {
		return defaultConnectionRequestInfo.getTphost();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getTpname() {
		return defaultConnectionRequestInfo.getTpname();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getTrace() {
		return defaultConnectionRequestInfo.getTrace();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getType() {
		return defaultConnectionRequestInfo.getType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getUser() {
		return defaultConnectionRequestInfo.getUser();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getUserId() {
		return defaultConnectionRequestInfo.getUserId();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getUseSapgui() {
		return defaultConnectionRequestInfo.getUseSapgui();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getX509cert() {
		return defaultConnectionRequestInfo.getX509cert();
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
		return defaultConnectionRequestInfo.hashCode();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized ManagedConnection matchManagedConnections(@SuppressWarnings("rawtypes") Set connectionSet, Subject subject, javax.resource.spi.ConnectionRequestInfo connectionRequestInfo) throws ResourceException {
		checkState();
		
		// Nothing to match
		if (connectionSet == null)
			return null;
		
		// If the application server does not provide connection request properties to match,
		// search the connection set for a managed connection that matches the default connection properties.
		if (connectionRequestInfo == null)
			connectionRequestInfo = defaultConnectionRequestInfo;

		// Can not match against invalid connection request info.
		if (!(connectionRequestInfo instanceof ConnectionRequestInfoImpl))
			return null;
		
		ManagedConnection result = null;

		// Use credentials in non-null subject for matching.
		PasswordCredential subjectCredential = null;
		if (subject != null) {
			for (PasswordCredential credential : subject.getPrivateCredentials(PasswordCredential.class)) {
				javax.resource.spi.ManagedConnectionFactory credentialManagedConnectionFactory = credential.getManagedConnectionFactory();
				if (credentialManagedConnectionFactory !=null && credentialManagedConnectionFactory.equals(this)) {
					subjectCredential =  credential;
					break;
				}
			}
			if (subjectCredential == null)
				// Did not find sufficient credentials in passed subject for this managed connection factory: create new connection.
				return null;
		}
		
		// Search through the connection set for a managed connection that matches the passed credentials and connection request properties. 
		@SuppressWarnings("rawtypes")
		Iterator it = connectionSet.iterator();
		searchConnectionSet: while (result == null && it.hasNext()) {
			ManagedConnection mc = (ManagedConnection) it.next();
			ManagedConnectionImpl candidateConnection = (ManagedConnectionImpl) mc;

			// Validate passed subject credentials match those of the connection.
			if (subjectCredential != null) {
				
				String candidateConnectionUserName = candidateConnection.getConnectionRequestInfo().getUserName();
				String candidateConnectionPassword = candidateConnection.getConnectionRequestInfo().getPassword();
				String subjectCredentialUserName = subjectCredential.getUserName();
				String subjectCredentialPassword = new String(subjectCredential.getPassword());
				
				if (candidateConnectionUserName == null ? subjectCredentialUserName != null : !candidateConnectionUserName.equals(subjectCredentialUserName)) {
					continue searchConnectionSet;
				} else if (candidateConnectionPassword == null ? !subjectCredentialPassword.isEmpty() : !candidateConnectionPassword.equals(subjectCredentialPassword)) {
					continue searchConnectionSet;
				}
				// Subject credentials match.
			}

			// Validate passed connection request info match those of the connection.
			// NB: the set of passed connection request properties need only be a subset of managed connection's set of properties to match.  
			ConnectionRequestInfoImpl jCxRequestInfo = (ConnectionRequestInfoImpl) connectionRequestInfo;
			searchConnectionRequestProperties: for (String propertyName : jCxRequestInfo.stringPropertyNames()) {

				if (subject != null
						&& (propertyName.equals(DestinationDataProvider.JCO_USER) || propertyName.equals(
								DestinationDataProvider.JCO_PASSWD)))
					// Already checked managed connection's credentials against subject credentials which override
					// credentials in connection request info.
					continue searchConnectionRequestProperties;
				
				String candidateConnectionPropertyValue = candidateConnection.getProperties().getProperty(propertyName);
				String cxRequestPropertyValue = jCxRequestInfo.getProperty(propertyName);
				
				if (candidateConnectionPropertyValue == null ? cxRequestPropertyValue != null
						: !candidateConnectionPropertyValue.equals(cxRequestPropertyValue))
					continue searchConnectionSet;
			}
			// All connection request properties match.

			// Found a managed connection that matches.
			result = candidateConnection;
			break;
		}

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
	public void setAliasUser(String user) {
		defaultConnectionRequestInfo.setAliasUser(user);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setAshost(String ashost) {
		defaultConnectionRequestInfo.setAshost(ashost);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setAuthType(String authType) {
		defaultConnectionRequestInfo.setAuthType(authType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setClient(String client) {
		defaultConnectionRequestInfo.setClient(client);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setCodepage(String codepage) {
		defaultConnectionRequestInfo.setCodepage(codepage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setCpicTrace(String cpicTrace) {
		defaultConnectionRequestInfo.setCpicTrace(cpicTrace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setDenyInitialPassword(String denyInitialPassword) {
		defaultConnectionRequestInfo.setDenyInitialPassword(denyInitialPassword);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setExpirationPeriod(String expirationPeriod) {
		defaultConnectionRequestInfo.setExpirationPeriod(expirationPeriod);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setExpirationTime(String expirationTime) {
		defaultConnectionRequestInfo.setExpirationTime(expirationTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setGetsso2(String getsso2) {
		defaultConnectionRequestInfo.setGetsso2(getsso2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setGroup(String group) {
		defaultConnectionRequestInfo.setGroup(group);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setGwhost(String gwhost) {
		defaultConnectionRequestInfo.setGwhost(gwhost);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setGwserv(String gwserv) {
		defaultConnectionRequestInfo.setGwserv(gwserv);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setLang(String lang) {
		defaultConnectionRequestInfo.setLang(lang);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setLcheck(String lcheck) {
		defaultConnectionRequestInfo.setLcheck(lcheck);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setLogWriter(PrintWriter out) throws ResourceException {
		logwriter = out;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMaxGetTime(String maxGetTime) {
		defaultConnectionRequestInfo.setMaxGetTime(maxGetTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMshost(String mshost) {
		defaultConnectionRequestInfo.setMshost(mshost);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMsserv(String msserv) {
		defaultConnectionRequestInfo.setMsserv(msserv);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMysapsso2(String mysapsso2) {
		defaultConnectionRequestInfo.setMysapsso2(mysapsso2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPasswd(String passwd) {
		defaultConnectionRequestInfo.setPasswd(passwd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPcs(String pcs) {
		defaultConnectionRequestInfo.setPcs(pcs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPeakLimit(String peakLimit) {
		defaultConnectionRequestInfo.setPeakLimit(peakLimit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPingOnCreate(String pingOnCreate) {
		defaultConnectionRequestInfo.setPingOnCreate(pingOnCreate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPoolCapacity(String poolCapacity) {
		defaultConnectionRequestInfo.setPoolCapacity(poolCapacity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setR3name(String r3name) {
		defaultConnectionRequestInfo.setR3name(r3name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRepositoryDest(String repositoryDest) {
		defaultConnectionRequestInfo.setRepositoryDest(repositoryDest);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRepositoryPasswd(String repositoryPasswd) {
		defaultConnectionRequestInfo.setRepositoryPasswd(repositoryPasswd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRepositoryRoundtripOptimization(String repositoryRoundtripOptimization) {
		defaultConnectionRequestInfo.setRepositoryRoundtripOptimization(repositoryRoundtripOptimization);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRepositorySnc(String repositorySnc) {
		defaultConnectionRequestInfo.setRepositorySnc(repositorySnc);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRepositoryUser(String repositoryUser) {
		defaultConnectionRequestInfo.setRepositoryUser(repositoryUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void setResourceAdapter(javax.resource.spi.ResourceAdapter resourceAdapter) throws ResourceException {
		checkState();
		if (!(resourceAdapter instanceof ResourceAdapterImpl))
			throw ExceptionBundle.EXCEPTIONS.invalidResourceAdapterTypeSetOnManagedConnectionFactory(resourceAdapter == null ? "null" : resourceAdapter.getClass().getName());
		if (this.resourceAdapter != null)
			throw ExceptionBundle.EXCEPTIONS.canNotChangeAssociationOfManagedConnectionFactoryDuringItsLifeTime();
		
		this.resourceAdapter = (ResourceAdapterImpl) resourceAdapter;
		this.resourceAdapter.associateConnectionFactory(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSaprouter(String saprouter) {
		defaultConnectionRequestInfo.setSaprouter(saprouter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSncLibrary(String sncLibrary) {
		defaultConnectionRequestInfo.setSncLibrary(sncLibrary);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSncMode(String sncMode) {
		defaultConnectionRequestInfo.setSncMode(sncMode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSncMyname(String sncMyname) {
		defaultConnectionRequestInfo.setSncMyname(sncMyname);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSncPartnername(String sncPartnername) {
		defaultConnectionRequestInfo.setSncPartnername(sncPartnername);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSncQop(String sncQop) {
		defaultConnectionRequestInfo.setSncQop(sncQop);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSysnr(String sysnr) {
		defaultConnectionRequestInfo.setSysnr(sysnr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setTphost(String tphost) {
		defaultConnectionRequestInfo.setTphost(tphost);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setTpname(String tpname) {
		defaultConnectionRequestInfo.setTpname(tpname);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setTrace(String trace) {
		defaultConnectionRequestInfo.setTrace(trace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setType(String type) {
		defaultConnectionRequestInfo.setType(type);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setUser(String user) {
		defaultConnectionRequestInfo.setUser(user);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setUserId(String userId) {
		defaultConnectionRequestInfo.setUserId(userId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setUseSapgui(String useSapgui) {
		defaultConnectionRequestInfo.setUseSapgui(useSapgui);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * {@inheritDoc}
	 * </p>
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setX509cert(String x509cert) {
		defaultConnectionRequestInfo.setX509cert(x509cert);
	}

	/**
	 * Associate the given managed connection with this factory.
	 *  
	 * @param connection - The managed connection to be associated.
	 * @throws ResourceException
	 * 
	 * @generated NOT
	 */
	protected synchronized void associateConnection(ManagedConnectionImpl connection) throws ResourceException {
		checkState();
		connections.add(connection);
	}

	/**
	 * Dissociate the given managed connection with this factory 
	 * @param connection - The managed connection to be dissociated.
	 * @throws ResourceException 
	 * 
	 * @generated NOT
	 */
	protected synchronized void dissociateConnection(ManagedConnectionImpl connection) throws ResourceException {
		checkState();
		connections.remove(connection);
	}
	
	/**
	 * Internal helper method used by public methods to check the state of this connection factory before performing an operation on it. This
	 * method prevents operations from being performed on a connection in a <code>DESTROYED</code> state.
	 * 
	 * @throws ResourceException if connection is in a <code>DESTROYED</code> state.
	 * 
	 * @generated NOT
	 */
	private void checkState() throws ResourceException {
		if (state == State.DESTROYED) {
			throw ExceptionBundle.EXCEPTIONS.connectionIsDestroyed();
		}
	}
} //ManagedConnectionFactoryImpl
