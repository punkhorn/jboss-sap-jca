package org.jboss.jca.adapters.sap.model.edit.command;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

public class CreateExecutionCommand extends CreateChildCommand {
	
	protected String functionModuleName;
	
	public CreateExecutionCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Object child, Collection<?> selection,
			Helper helper) {
		super(domain, owner, feature, child, selection, helper);
	}

	public CreateExecutionCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Object child, Collection<?> selection) {
		super(domain, owner, feature, child, selection);
	}

	public CreateExecutionCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Object child, int index,
			Collection<?> selection, Helper helper) {
		super(domain, owner, feature, child, index, selection, helper);
	}

	public CreateExecutionCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Object child, int index,
			Collection<?> selection) {
		super(domain, owner, feature, child, index, selection);
	}

	public String getFunctionModuleName() {
		return functionModuleName;
	}

	public void setFunctionModuleName(String functionModuleName) {
		this.functionModuleName = functionModuleName;
	}
	
}
