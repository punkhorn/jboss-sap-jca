package org.jboss.jca.adapters.sap.ui.command;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISources;
import org.eclipse.ui.handlers.HandlerUtil;
import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.cci.Execution;
import org.jboss.jca.adapters.sap.model.cci.Interaction;
import org.jboss.jca.adapters.sap.model.edit.command.TransactionalCommandStack;

public class NewExecutionHandler extends AbstractHandler implements IHandler {

	private EditingDomain editingDomain;
	private Command command;
	private Execution execution;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		((TransactionalCommandStack)editingDomain.getCommandStack()).begin();
		editingDomain.getCommandStack().execute(command);
		return null;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		setBaseEnabled(false);
		Object obj = HandlerUtil.getVariable(evaluationContext, ISources.ACTIVE_CURRENT_SELECTION_NAME);
		if (obj instanceof IStructuredSelection) {
			obj = ((IStructuredSelection)obj).getFirstElement();
			if (obj instanceof Interaction){
				Interaction interaction = (Interaction) obj;
				editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(interaction);
				if (editingDomain != null) {
					Collection<?> descriptors = editingDomain.getNewChildDescriptors(interaction, null);
					for (Object descriptor: descriptors) {
						CommandParameter parameter = (CommandParameter) descriptor;
						if (parameter.getFeature() == CciPackage.Literals.INTERACTION__EXECUTIONS) {
							execution = (Execution) parameter.getValue();
							command = CreateChildCommand.create(editingDomain, interaction, descriptor, Collections.singletonList(execution));
							setBaseEnabled(true);
							break;
						}
					}
				}
				
			}
		}		
	}
}
