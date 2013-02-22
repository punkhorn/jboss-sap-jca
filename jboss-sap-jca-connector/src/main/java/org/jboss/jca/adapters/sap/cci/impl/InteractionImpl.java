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

import javax.resource.ResourceException;
import javax.resource.cci.InteractionSpec;
import javax.resource.cci.Record;
import javax.resource.cci.ResourceWarning;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.jboss.jca.adapters.sap.cci.Connection;
import org.jboss.jca.adapters.sap.cci.Interaction;
import org.jboss.jca.adapters.sap.cci.MappedRecord;
import org.jboss.jca.adapters.sap.cci.RecordFactory;

import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoRequest;
import com.sap.conn.jco.JCoResponse;

/**
 * <!-- begin-user-doc -->
 * Implements the {@link Interaction } interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 * 
 * @version $Id: 5c6728062a58f206c69158f22b360bcf454ea921 $
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class InteractionImpl extends EObjectImpl implements Interaction {

	/**
	 * @generated NOT	
	 */
	private enum State {
		ACTIVE, CLOSED;
	}

	/**
	 * @generated NOT	
	 */
	private State state = State.ACTIVE;

	/**
	 * @generated NOT	
	 */
	private ConnectionImpl connection;
	
	/**
	 * @generated NOT	
	 */
	private JCoDestination destination;

	/**
	 * @generated NOT	
	 */
	private ResourceWarning warnings;

	private RecordFactory recordFactory;

	/**
	 * <!-- begin-user-doc -->
	 * Create an {@link Interaction} instance.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InteractionImpl() {
		super();
	}

	/**
	 * Create an {@link Interaction} instance associated with the specified connection.
	 * 
	 * @param connection - the connection
	 * @throws ResourceException 
	 * @generated NOT	
	 */
	protected InteractionImpl(ConnectionImpl connection) throws ResourceException {
		super();
		this.connection = connection;
		this.destination = connection.getDestination();
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CciPackageImpl.Literals.INTERACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized void close() throws ResourceException {
		if (state == State.CLOSED) 
			return;
		state = State.CLOSED;

		this.connection.interactionClosed(this);
		this.destination = null;
		this.connection = null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized boolean execute(InteractionSpec ispec, Record input, Record output) throws ResourceException {
		checkState();
		
		if (!(ispec instanceof org.jboss.jca.adapters.sap.cci.InteractionSpec))
			throw ExceptionBundle.EXCEPTIONS.invalidConnectionSpecType(ispec == null? "null" : ispec.getClass().getName());
		org.jboss.jca.adapters.sap.cci.InteractionSpec interactionSpec = (org.jboss.jca.adapters.sap.cci.InteractionSpec) ispec;

		if (!(input instanceof MappedRecord))
			throw ExceptionBundle.EXCEPTIONS.invalidInputRecordType(input == null? "null" : input.getClass().getName());
		MappedRecord inputRecord = (MappedRecord) input;

		if (!(output instanceof MappedRecord))
			throw ExceptionBundle.EXCEPTIONS.invalidOutputRecordType(output == null? "null" : output.getClass().getName());
		MappedRecord outputRecord = (MappedRecord) output;

		String functionName = interactionSpec.getFunctionName();
		if (functionName == null)
			throw ExceptionBundle.EXCEPTIONS.functionNameOfInteractionSpecIsNull();

		try {
			
			JCoRequest request = destination.getRepository().getRequest(functionName);
			
			((MappedRecordImpl)inputRecord).fill(request);

			try {
				JCoResponse response = request.execute(destination);
				((MappedRecordImpl)outputRecord).put(response);
			} catch (AbapException e) {
				warnings = ExceptionBundle.EXCEPTIONS.remoteFunctionModuleThrewABAPException(e);
				return false;
			}

		} catch (JCoException e) {
			throw new ResourceException(e);
		}

		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public synchronized Record execute(InteractionSpec ispec, Record input) throws ResourceException {
		checkState();

		if (!(ispec instanceof org.jboss.jca.adapters.sap.cci.InteractionSpec))
			throw ExceptionBundle.EXCEPTIONS.invalidConnectionSpecType(ispec == null? "null" : ispec.getClass().getName());
		org.jboss.jca.adapters.sap.cci.InteractionSpec interactionSpec = (org.jboss.jca.adapters.sap.cci.InteractionSpec) ispec;

		String recordName = interactionSpec.getFunctionName() + ".OUTPUT_RECORD";
		MappedRecord output = getRecordFactory().createMappedRecord(recordName);

		if (execute(ispec, input, output))
			return output;
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ResourceWarning getWarnings() throws ResourceException {
		return warnings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * {@inheritDoc}
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void clearWarnings() throws ResourceException {
		warnings = null;
	}

	/**
	 * Internal helper method used by public methods to check the state of this connection before performing an operation on it. This
	 * method prevents operations from being performed on a connection in a <code>CLOSED</code> state.
	 * 
	 * @throws ResourceException if connection is in a <code>CLOSED</code> state.
	 * @generated NOT
	 */
	private void checkState() throws ResourceException {
		if (state == State.CLOSED)
			throw ExceptionBundle.EXCEPTIONS.interactionIsClosed();
	}
	
	/**
	 * Internal assessor method to {@link RecordFactory} which lazy initializes the factory.
	 * 
	 * <p>NB: Must guarantee this method is never called when interaction is closed.
	 * 
	 * @throws ResourceException if SAP repository can not be retrieved from JCo runtime.
	 * @generated NOT
	 */
	private RecordFactory getRecordFactory() throws ResourceException {
		try {
			if(recordFactory == null) {
				recordFactory = CciFactoryImpl.eINSTANCE.createRecordFactory();
				((RecordFactoryImpl)recordFactory).setRepository(destination.getRepository());
			}
			return recordFactory;
		} catch (JCoException e) {
			recordFactory = null;
			throw ExceptionBundle.EXCEPTIONS.failedToGetRecordFactory(e);
		}
	}

} //InteractionImpl
