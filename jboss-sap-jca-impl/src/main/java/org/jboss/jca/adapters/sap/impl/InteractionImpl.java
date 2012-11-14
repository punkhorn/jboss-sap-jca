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
package org.jboss.jca.adapters.sap.impl;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.Interaction;
import javax.resource.cci.InteractionSpec;
import javax.resource.cci.Record;
import javax.resource.cci.ResourceWarning;

import org.jboss.jca.adapters.sap.cci.JBossSAPInteractionSpec;

import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.ConversionException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoListMetaData;
import com.sap.conn.jco.JCoMetaData;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoRecord;
import com.sap.conn.jco.JCoTable;

/**
 * Implements the {@link Interaction } interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 * 
 * @version $Id: 08d3ff32c62a603899e35228b921f8bcc4c7005b $
 */
public class InteractionImpl implements Interaction {

	private enum State {
		ACTIVE, CLOSED;
	}

	private State state = State.ACTIVE;

	private ConnectionImpl connection;
	
	private JCoDestination destination;

	private ResourceWarning warnings;

	/**
	 * Create interaction with specified connection.
	 * 
	 * @param connection - the connection
	 */
	InteractionImpl(ConnectionImpl connection) {
		this.connection = connection;
		this.destination = connection.getDestination();
	}

	/**
	 * {@inheritDoc}
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
	 * {@inheritDoc}
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean execute(InteractionSpec ispec, Record input, Record output) throws ResourceException {
		checkState();
		
		if (!(ispec instanceof JBossSAPInteractionSpec))
			throw JBossSapJCAExceptionBundle.EXCEPTIONS.invalidConnectionSpecType(ispec == null? "null" : ispec.getClass().getName());
		JBossSAPInteractionSpec interactionSpec = (JBossSAPInteractionSpec) ispec;

		if (!(input instanceof MappedRecordImpl))
			throw JBossSapJCAExceptionBundle.EXCEPTIONS.invalidInputRecordType(input == null? "null" : input.getClass().getName());
		MappedRecordImpl inputRecord = (MappedRecordImpl) input;

		if (!(output instanceof MappedRecordImpl))
			throw JBossSapJCAExceptionBundle.EXCEPTIONS.invalidOutputRecordType(output == null? "null" : output.getClass().getName());
		MappedRecordImpl outputRecord = (MappedRecordImpl) output;

		String functionName = interactionSpec.getFunctionName();
		if (functionName == null)
			throw JBossSapJCAExceptionBundle.EXCEPTIONS.functionNameOfInteractionSpecIsNull();

		try {
			
			JCoFunction function = destination.getRepository().getFunction(functionName);

			populateInput(function, inputRecord);

			try {
				function.execute(destination);
			} catch (AbapException e) {
				warnings = JBossSapJCAExceptionBundle.EXCEPTIONS.remoteFunctionModuleThrewABAPException(e);
				return false;
			}

			extractOutput(function, outputRecord);

		} catch (JCoException e) {
			throw new ResourceException(e);
		}

		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public Record execute(InteractionSpec ispec, Record input) throws ResourceException {
		checkState();

		MappedRecordImpl output = new MappedRecordImpl("RETURN", "Return value of interaction");

		if (execute(ispec, input, output))
			return output;
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public ResourceWarning getWarnings() throws ResourceException {
		return warnings;
	}

	/**
	 * {@inheritDoc}
	 */
	public void clearWarnings() throws ResourceException {
		warnings = null;
	}

	private void populateInput(JCoFunction function, MappedRecordImpl input) throws ResourceException {

		populateParameterList(function.getImportParameterList(), input);

		populateParameterList(function.getChangingParameterList(), input);

		populateTableParameterList(function.getTableParameterList(), input);
	}

	private void extractOutput(JCoFunction function, MappedRecordImpl output) throws ResourceException {

		extractParameterList(function.getExportParameterList(), output);

		extractParameterList(function.getChangingParameterList(), output);

		extractTableParameterList(function.getTableParameterList(), output);
	}

	@SuppressWarnings("unchecked")
	private void extractParameterList(JCoParameterList parameterList, MappedRecordImpl mappedRecord)
			throws ResourceException {

		if (parameterList == null)
			return;

		JCoListMetaData listMetaData = parameterList.getListMetaData();

		for (int i = 0; i < listMetaData.getFieldCount(); i++) {

			String name = listMetaData.getName(i);
			Object value = parameterList.getValue(name);

			// If no export value, check that it is optional
			if (value == null) {
				if (listMetaData.isOptional(i))
					continue;
				else
					throw JBossSapJCAExceptionBundle.EXCEPTIONS.requiredParameterIsMissingInParameterList(name, listMetaData.getName());
			}

			if (listMetaData.isStructure(i)) {
				MappedRecordImpl nestedRecord = new MappedRecordImpl(listMetaData.getName(i),
						listMetaData.getDescription(i));
				extractStructure(parameterList.getStructure(i), nestedRecord);
				mappedRecord.put(listMetaData.getName(i), nestedRecord);
			} else if (listMetaData.isTable(i)) {
				IndexedRecordImpl nestedRecord = new IndexedRecordImpl(listMetaData.getName(i),
						listMetaData.getDescription(i));
				extractTable(parameterList.getTable(i), nestedRecord);
				mappedRecord.put(listMetaData.getName(i), nestedRecord);
			} else {
				mappedRecord.put(listMetaData.getName(i), parameterList.getValue(i));
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void extractTableParameterList(JCoParameterList tableList, MappedRecordImpl mappedRecord)
			throws ResourceException {

		if (tableList == null)
			return;

		JCoListMetaData listMetaData = tableList.getListMetaData();

		for (int i = 0; i < listMetaData.getFieldCount(); i++) {
			JCoTable table = tableList.getTable(listMetaData.getName(i));
			if (table.isEmpty())
				continue;
			IndexedRecordImpl indexedRecord = new IndexedRecordImpl(listMetaData.getName(i),
					listMetaData.getDescription(i));
			extractTable(table, indexedRecord);
			mappedRecord.put(listMetaData.getName(i), indexedRecord);
		}

	}

	@SuppressWarnings("unchecked")
	private void extractTable(JCoTable table, IndexedRecordImpl indexedRecord) throws ResourceException {
		
		if (table == null) 
			return;
		
		table.firstRow();
		for (int i = 0; i < table.getNumRows(); i++, table.nextRow()) {
			MappedRecordImpl nestedRecord = new MappedRecordImpl(indexedRecord.getRecordName() + "[" + i + "]",
					indexedRecord.getRecordShortDescription());
			extractStructure(table, nestedRecord);
			indexedRecord.add(nestedRecord);
		}
	}

	@SuppressWarnings("unchecked")
	private void extractStructure(JCoRecord record, MappedRecordImpl mappedRecord) throws ResourceException {
		
		if (record == null)
			return;

		JCoMetaData listMetaData = record.getMetaData();

		for (int i = 0; i < listMetaData.getFieldCount(); i++) {

			if (listMetaData.isStructure(i)) {
				MappedRecordImpl nestedRecord = new MappedRecordImpl(listMetaData.getName(i),
						listMetaData.getDescription(i));
				extractStructure(record.getStructure(i), nestedRecord);
				mappedRecord.put(listMetaData.getName(i), nestedRecord);
			} else if (listMetaData.isTable(i)) {
				IndexedRecordImpl nestedRecord = new IndexedRecordImpl(listMetaData.getName(i),
						listMetaData.getDescription(i));
				extractTable(record.getTable(i), nestedRecord);
				mappedRecord.put(listMetaData.getName(i), nestedRecord);
			} else {
				mappedRecord.put(listMetaData.getName(i), record.getValue(i));
			}
		}
	}

	private void populateTableParameterList(JCoParameterList tableList, MappedRecordImpl mappedRecord)
			throws ResourceException {

		if (tableList == null)
			return;

		JCoListMetaData listMetaData = tableList.getListMetaData();

		for (int i = 0; i < listMetaData.getFieldCount(); i++) {
			JCoTable table = tableList.getTable(listMetaData.getName(i));
			Object tableData = mappedRecord.get(listMetaData.getName(i));
			if (tableData == null)
				// NB: Interaction depends on caller to know what tables in table parameter list need to be populated
				// before execution.
				continue;

			if (!(tableData instanceof IndexedRecordImpl))
				throw JBossSapJCAExceptionBundle.EXCEPTIONS.invalidRecordTypeForTableParameterInTableParameterList(listMetaData.getName(i), listMetaData.getName(), tableData.getClass().getName());

			populateTable(table, (IndexedRecordImpl) tableData);
		}
	}

	private void populateParameterList(JCoParameterList parameterList, MappedRecordImpl mappedRecord)
			throws ResourceException {

		if (parameterList == null)
			return;

		JCoListMetaData listMetaData = parameterList.getListMetaData();

		for (int i = 0; i < listMetaData.getFieldCount(); i++) {

			Object value = mappedRecord.get(listMetaData.getName(i));

			// If no input value, check that it is optional
			if (value == null) {
				if (listMetaData.isOptional(i))
					continue;
				else
					throw JBossSapJCAExceptionBundle.EXCEPTIONS.requiredParameterIsMissingInParameterList(listMetaData.getName(i), listMetaData.getName());
			}

			if (listMetaData.isStructure(i)) {
				if (!(value instanceof MappedRecordImpl))
					throw JBossSapJCAExceptionBundle.EXCEPTIONS.invalidRecordTypeForStructureParameterInParameterList(listMetaData.getName(i), listMetaData.getName(), value.getClass().getName());
				populateStructure(parameterList.getStructure(i), (MappedRecordImpl) value);
			} else if (listMetaData.isTable(i)) {
				if (!(value instanceof IndexedRecordImpl))
					throw JBossSapJCAExceptionBundle.EXCEPTIONS.invalidRecordTypeForTableParameterInParameterList(listMetaData.getName(i), listMetaData.getName(), value.getClass().getName());
				populateTable(parameterList.getTable(i), (IndexedRecordImpl) value);
			} else {
				populateField(parameterList, i, value);
			}
		}
	}

	private void populateStructure(JCoRecord record, MappedRecordImpl mappedRecord) throws ResourceException {
		
		if (record == null)
			return;
		
		JCoMetaData metaData = record.getMetaData();
		
		for (int i = 0; i < metaData.getFieldCount(); i++) {
			Object field = mappedRecord.get(metaData.getName(i));
			if (field == null) {
				// NB: Interaction depends on caller to know what items in structure needs to be populated
				// before execution.
				continue;
			}

			if (metaData.isStructure(i)) {
				if (!(field instanceof MappedRecordImpl))
					throw JBossSapJCAExceptionBundle.EXCEPTIONS.invalidRecordTypeForStructureParameterInStructure(metaData.getName(i), metaData.getName(), field.getClass().getName());
				populateStructure(record.getStructure(i), (MappedRecordImpl) field);
			} else if (metaData.isTable(i)) {
				if (!(field instanceof IndexedRecordImpl))
					throw JBossSapJCAExceptionBundle.EXCEPTIONS.invalidRecordTypeForTableParameterInStructure(metaData.getName(i), metaData.getName(), field.getClass().getName());
				populateTable(record.getTable(i), (IndexedRecordImpl) field);
			} else {
				populateField(record, i, field);
			}
		}
	}

	private void populateTable(JCoTable table, IndexedRecordImpl indexedRecord) throws ResourceException {
		
		if (table == null)
			return;
		
		for (Object item : indexedRecord) {
			if (item instanceof MappedRecordImpl) {
				populateTableRow(table, (MappedRecordImpl) item);
			} else {
				throw JBossSapJCAExceptionBundle.EXCEPTIONS.invalidRecordTypeForTableRowInTable(table.getMetaData().getName(), item.getClass().getName());
			}
		}
	}

	private void populateTableRow(JCoTable table, MappedRecordImpl mappedRecord) throws ResourceException {
		table.appendRow();
		populateStructure(table, mappedRecord);
	}

	private void populateField(JCoRecord record, int index, Object value) throws ResourceException {
		try {
			record.setValue(index, value);
		} catch (ConversionException e) {
			throw JBossSapJCAExceptionBundle.EXCEPTIONS.settingValueOnRecordCausedConversionException(value.toString(), record.getMetaData().getName(index), record.getMetaData().getName(), e);
		}
	}

	private void checkState() throws ResourceException {
		if (state == State.CLOSED)
			throw JBossSapJCAExceptionBundle.EXCEPTIONS.interactionIsClosed();
	}

}
