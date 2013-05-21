package org.jboss.jca.adapters.sap.model.edit.command;

import org.eclipse.emf.common.command.BasicCommandStack;

public class TransactionalCommandStack extends BasicCommandStack {
	
	// Top of stack when transaction begins
	protected int txnBeginIdx = -1;
	
	public boolean isInTransaction() {
		return txnBeginIdx != -1;
	}

	public void begin() {
		txnBeginIdx = top;
	}
	
	public void commit() {
		
		if (!isInTransaction()) 
			return;

		txnBeginIdx = -1;
	}
	
	public void rollback() {

		if (!isInTransaction()) 
			return;
		
		while (top > txnBeginIdx) {
			undo();
		}
 		
 		txnBeginIdx = -1;
	}
	
	@Override
	protected void handleError(Exception exception) {
		rollback();
		super.handleError(exception);
	}

}
