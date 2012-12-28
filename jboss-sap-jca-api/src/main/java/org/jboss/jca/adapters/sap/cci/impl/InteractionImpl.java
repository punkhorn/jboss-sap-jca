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
import javax.resource.cci.Record;
import javax.resource.cci.ResourceWarning;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.jboss.jca.adapters.sap.cci.CciPackage;
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
 * @version $Id: 08d3ff32c62a603899e35228b921f8bcc4c7005b $
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
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InteractionImpl() {
		super();
	}

	/**
	 * Create interaction with specified connection.
	 * 
	 * @param connection - the connection
	 * @generated NOT	
	 */
	protected InteractionImpl(ConnectionImpl connection) {
		super();
		this.connection = connection;
		this.destination = connection.getDestination();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CciPackage.Literals.INTERACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void close() throws ResourceException {
		synchronized (state) {
			if (state == State.CLOSED) 
				return;
			state = State.CLOSED;
		}
		this.connection.interactionClosed(this);
		this.destination = null;
		this.connection = null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean execute(javax.resource.cci.InteractionSpec ispec, Record input, Record output) throws ResourceException {
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
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Record execute(javax.resource.cci.InteractionSpec ispec, Record input) throws ResourceException {
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
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ResourceWarning getWarnings() throws ResourceException {
		return warnings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void clearWarnings() throws ResourceException {
		warnings = null;
	}

	protected void checkState() throws ResourceException {
		if (state == State.CLOSED)
			throw ExceptionBundle.EXCEPTIONS.interactionIsClosed();
	}
	
	protected RecordFactory getRecordFactory() throws ResourceException {
		try {
			if(recordFactory == null) {
				recordFactory = CciPackage.eINSTANCE.getCciFactory().createRecordFactory();
				((RecordFactoryImpl)recordFactory).setRepository(destination.getRepository());
			}
			return recordFactory;
		} catch (JCoException e) {
			recordFactory = null;
			throw ExceptionBundle.EXCEPTIONS.failedToGetRecordFactory(e);
		}
	}

} //InteractionImpl
