package org.jboss.jca.adapters.sap.command;

import java.util.Stack;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.eclipse.emf.common.command.BasicCommandStack;

public class TransactionalCommandStack extends BasicCommandStack {
	
	protected final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
	protected final Lock readLock = readWriteLock.readLock();
	protected final Lock writeLock = readWriteLock.writeLock();
	
	/**
	 * Stack of top indexes for each nested transaction.
	 */ 
	protected final Stack<Integer> txnStack = new Stack<Integer>();
	
	// Top of stack when transaction begins
	protected int txnBeginIdx = -1;
	
	protected boolean inTrasaction;
	
	public Lock getReadLock() {
		return readLock;
	}

	public Lock getWriteLock() {
		return writeLock;
	}

	public boolean isInTransaction() {
		return !txnStack.isEmpty();
	}

	public void begin() {
		txnStack.push(top);
	}
	
	public void commit() {
		
		if (!isInTransaction()) 
			return;
		
		txnStack.pop();
	}
	
	public void rollback() {

		if (!isInTransaction()) 
			return;
		
		int txnBeginIdx = txnStack.pop();
		while (top > txnBeginIdx) {
			undo();
		}
	}
	
	@Override
	protected void handleError(Exception exception) {
		rollback();
		super.handleError(exception);
	}

}
