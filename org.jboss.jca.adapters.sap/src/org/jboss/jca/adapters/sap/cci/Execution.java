package org.jboss.jca.adapters.sap.cci;

public interface Execution {
	
	public InteractionSpec getInteractionSpec();
	
	public MappedRecord getInputRecord();
	
	public MappedRecord getOutputRecord();

}
