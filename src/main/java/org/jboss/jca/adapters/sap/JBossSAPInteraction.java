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
package org.jboss.jca.adapters.sap;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.Interaction;
import javax.resource.cci.InteractionSpec;
import javax.resource.cci.Record;
import javax.resource.cci.ResourceWarning;

import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.ConversionException;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoListMetaData;
import com.sap.conn.jco.JCoMetaData;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoRecord;
import com.sap.conn.jco.JCoTable;

/**
 * JBossSAPInteraction implements the Interaction interface
 * 
 * @author William Collins
 * 
 * @version $Revision: $
 */
public class JBossSAPInteraction implements Interaction {

	private enum State {
		ACTIVE, CLOSED;
	}

	private State state = State.ACTIVE;

	private final JBossSAPCciConnection connection;

	private ResourceWarning warnings;

	/**
	 * Create interaction with specified connection.
	 * 
	 * @param connection - the connection
	 */
	JBossSAPInteraction(JBossSAPCciConnection connection) {
		this.connection = connection;
	}

	/**
	 * {@inheritDoc}
	 */
	public void close() throws ResourceException {
		state = State.CLOSED;
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
			throw new ResourceException("jboss-sap-interaction-invalid-specification");
		JBossSAPInteractionSpec interactionSpec = (JBossSAPInteractionSpec) ispec;

		if (!(input instanceof JBossSAPMappedRecord))
			throw new ResourceException("jboss-sap-interaction-invalid-input-record");
		JBossSAPMappedRecord inputRecord = (JBossSAPMappedRecord) input;

		if (!(output instanceof JBossSAPMappedRecord))
			throw new ResourceException("jboss-sap-interaction-invalid-output-record");
		JBossSAPMappedRecord outputRecord = (JBossSAPMappedRecord) output;

		String functionName = interactionSpec.getFunctionName();
		if (functionName == null)
			throw new ResourceException("jboss-sap-interaction-invalid-function-name");

		try {

			JCoFunction function = connection.getDestination().getRepository().getFunction(functionName);

			populateInput(function, inputRecord);

			try {
				function.execute(connection.getDestination());
			} catch (AbapException e) {
				warnings = new ResourceWarning(e);
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

		JBossSAPMappedRecord output = new JBossSAPMappedRecord("RETURN", "Return value of interaction");

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

	private void populateInput(JCoFunction function, JBossSAPMappedRecord input) throws ResourceException {

		populateParameterList(function.getImportParameterList(), input);

		populateParameterList(function.getChangingParameterList(), input);

		populateTableParameterList(function.getTableParameterList(), input);
	}

	private void extractOutput(JCoFunction function, JBossSAPMappedRecord output) throws ResourceException {

		extractParameterList(function.getExportParameterList(), output);

		extractParameterList(function.getChangingParameterList(), output);

		extractTableParameterList(function.getTableParameterList(), output);
	}

	@SuppressWarnings("unchecked")
	private void extractParameterList(JCoParameterList parameterList, JBossSAPMappedRecord mappedRecord)
			throws ResourceException {

		if (parameterList == null)
			return;

		JCoListMetaData listMetaData = parameterList.getListMetaData();

		for (int i = 0; i < listMetaData.getFieldCount(); i++) {

			// Changing parameter lists have combination of import and export parameters: only extract export
			// parameters
			if (!listMetaData.isExport(i))
				continue;

			String name = listMetaData.getName(i);
			Object value = parameterList.getValue(name);

			// If no export value, check that it is optional
			if (value == null) {
				if (listMetaData.isOptional(i))
					continue;
				else
					throw new ResourceException("jboss-sap-interaction-required-field-missing");
			}

			if (listMetaData.isStructure(i)) {
				JBossSAPMappedRecord nestedRecord = new JBossSAPMappedRecord(listMetaData.getName(i),
						listMetaData.getDescription(i));
				extractStructure(parameterList.getStructure(i), nestedRecord);
				mappedRecord.put(listMetaData.getName(i), nestedRecord);
			} else if (listMetaData.isTable(i)) {
				JBossSAPIndexedRecord nestedRecord = new JBossSAPIndexedRecord(listMetaData.getName(i),
						listMetaData.getDescription(i));
				extractTable(parameterList.getTable(i), nestedRecord);
				mappedRecord.put(listMetaData.getName(i), nestedRecord);
			} else {
				mappedRecord.put(listMetaData.getName(i), parameterList.getValue(i));
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void extractTableParameterList(JCoParameterList tableList, JBossSAPMappedRecord mappedRecord)
			throws ResourceException {

		if (tableList == null)
			return;

		JCoListMetaData listMetaData = tableList.getListMetaData();

		for (int i = 0; i < listMetaData.getFieldCount(); i++) {
			JCoTable table = tableList.getTable(listMetaData.getName(i));
			if (table.isEmpty())
				continue;
			JBossSAPIndexedRecord indexedRecord = new JBossSAPIndexedRecord(listMetaData.getName(i),
					listMetaData.getDescription(i));
			extractTable(table, indexedRecord);
			mappedRecord.put(listMetaData.getName(i), indexedRecord);
		}

	}

	@SuppressWarnings("unchecked")
	private void extractTable(JCoTable table, JBossSAPIndexedRecord indexedRecord) throws ResourceException {
		table.firstRow();
		for (int i = 0; i < table.getNumRows(); table.nextRow()) {
			JBossSAPMappedRecord nestedRecord = new JBossSAPMappedRecord(indexedRecord.getRecordName() + "[" + i + "]",
					indexedRecord.getRecordShortDescription());
			extractStructure(table, nestedRecord);
			indexedRecord.add(nestedRecord);
		}
	}

	@SuppressWarnings("unchecked")
	private void extractStructure(JCoRecord record, JBossSAPMappedRecord mappedRecord) throws ResourceException {

		JCoMetaData listMetaData = record.getMetaData();

		for (int i = 0; i < listMetaData.getFieldCount(); i++) {

			if (listMetaData.isStructure(i)) {
				JBossSAPMappedRecord nestedRecord = new JBossSAPMappedRecord(listMetaData.getName(i),
						listMetaData.getDescription(i));
				extractStructure(record.getStructure(i), nestedRecord);
				mappedRecord.put(listMetaData.getName(i), nestedRecord);
			} else if (listMetaData.isTable(i)) {
				JBossSAPIndexedRecord nestedRecord = new JBossSAPIndexedRecord(listMetaData.getName(i),
						listMetaData.getDescription(i));
				extractTable(record.getTable(i), nestedRecord);
				mappedRecord.put(listMetaData.getName(i), nestedRecord);
			} else {
				mappedRecord.put(listMetaData.getName(i), record.getValue(i));
			}
		}
	}

	private void populateTableParameterList(JCoParameterList tableList, JBossSAPMappedRecord mappedRecord)
			throws ResourceException {

		if (tableList == null)
			return;

		JCoListMetaData listMetaData = tableList.getListMetaData();

		for (int i = 0; i < listMetaData.getFieldCount(); i++) {
			JCoTable table = tableList.getTable(listMetaData.getName(i));
			Object tableData = mappedRecord.get(listMetaData.getName());
			if (tableData == null)
				// NB: Interaction depends on caller to know what tables in table parameter list need to be populated
				// before execution.
				continue;

			if (!(tableData instanceof JBossSAPIndexedRecord))
				throw new ResourceException("jboss-sap-interaction-invalid-table-value");

			populateTable(table, (JBossSAPIndexedRecord) tableData);
		}
	}

	private void populateParameterList(JCoParameterList parameterList, JBossSAPMappedRecord mappedRecord)
			throws ResourceException {

		if (parameterList == null)
			return;

		JCoListMetaData listMetaData = parameterList.getListMetaData();

		for (int i = 0; i < listMetaData.getFieldCount(); i++) {

			// Changing parameter lists have combination of import and export parameters: only populate import
			// parameters
			if (!listMetaData.isImport(i))
				continue;

			Object value = parameterList.getValue(listMetaData.getName(i));

			// If no input value, check that it is optional
			if (value == null) {
				if (listMetaData.isOptional(i))
					continue;
				else
					throw new ResourceException("jboss-sap-interaction-required-field-missing");
			}

			if (listMetaData.isStructure(i)) {
				if (!(value instanceof JBossSAPMappedRecord))
					throw new ResourceException("jboss-sap-interaction-invalid-structure-value");
				populateStructure(parameterList.getStructure(i), (JBossSAPMappedRecord) value);
			} else if (listMetaData.isTable(i)) {
				if (!(value instanceof JBossSAPIndexedRecord))
					throw new ResourceException("jboss-sap-interaction-invalid-table-value");
				populateTable(parameterList.getTable(i), (JBossSAPIndexedRecord) value);
			} else {
				populateField(parameterList, i, value);
			}
		}
	}

	private void populateStructure(JCoRecord record, JBossSAPMappedRecord mappedRecord) throws ResourceException {
		JCoMetaData metaData = record.getMetaData();
		for (int i = 0; i < metaData.getFieldCount(); i++) {
			Object field = mappedRecord.get(metaData.getName(i));
			// Throw exception if no corresponding input field
			if (field == null)
				throw new ResourceException("jboss-sap-interaction-required-field-missing");

			if (metaData.isStructure(i)) {
				if (!(field instanceof JBossSAPMappedRecord))
					throw new ResourceException("jboss-sap-interaction-invalid-structure-value");
				populateStructure(record.getStructure(i), (JBossSAPMappedRecord) field);
			} else if (metaData.isTable(i)) {
				if (!(field instanceof JBossSAPIndexedRecord))
					throw new ResourceException("jboss-sap-interaction-invalid-table-value");
				populateTable(record.getTable(i), (JBossSAPIndexedRecord) field);
			} else {
				populateField(record, i, field);
			}
		}
	}

	private void populateTable(JCoTable table, JBossSAPIndexedRecord indexedRecord) throws ResourceException {
		for (Object item : indexedRecord) {
			if (item instanceof JBossSAPMappedRecord) {
				populateTableRow(table, (JBossSAPMappedRecord) item);
			} else {
				throw new ResourceException("jboss-sap-interaction-invalid-table-row-value");
			}
		}
	}

	private void populateTableRow(JCoTable table, JBossSAPMappedRecord mappedRecord) throws ResourceException {
		table.appendRow();
		populateStructure(table, mappedRecord);
	}

	private void populateField(JCoRecord record, int index, Object value) throws ResourceException {
		try {
			record.setValue(index, value);
		} catch (ConversionException e) {
			throw new ResourceException(e);
		}
	}

	private void checkState() throws ResourceException {
		if (state == State.CLOSED)
			throw new ResourceException("jboss-sap-interaction-is-closed");
	}

}
