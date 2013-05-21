package org.jboss.jca.adapters.sap.command;

import org.eclipse.emf.edit.command.ChangeCommand;
import org.jboss.jca.adapters.sap.model.cci.MappedRecord;
import org.jboss.jca.adapters.sap.util.RecordUtil;

import com.sap.conn.jco.JCoRecord;

public class ExtractJCoRecordIntoMappedRecordCommand extends ChangeCommand {

	protected MappedRecord mappedRecord;
	protected JCoRecord jcoRecord;

	public ExtractJCoRecordIntoMappedRecordCommand(MappedRecord mappedRecord, JCoRecord jcoRecord) {
		super(mappedRecord);
		this.mappedRecord = mappedRecord;
		this.jcoRecord = jcoRecord;
	}

	@Override
	protected void doExecute() {
		RecordUtil.extractJCoRecordIntoMappedRecord(jcoRecord, mappedRecord);
	}

}
