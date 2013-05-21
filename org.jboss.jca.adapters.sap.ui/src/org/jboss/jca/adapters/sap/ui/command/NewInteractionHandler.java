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
import org.jboss.jca.adapters.sap.model.cci.Connection;

public class NewInteractionHandler extends AbstractHandler implements IHandler {

	private EditingDomain editingDomain;
	private Command command;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		editingDomain.getCommandStack().execute(command);
		return null;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		setBaseEnabled(false);
		Object obj = HandlerUtil.getVariable(evaluationContext, ISources.ACTIVE_CURRENT_SELECTION_NAME);
		if (obj instanceof IStructuredSelection) {
			obj = ((IStructuredSelection)obj).getFirstElement();
			if (obj instanceof Connection){
				Connection connection = (Connection) obj;
				editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(connection);
				if (editingDomain != null) {
					Collection<?> descriptors = editingDomain.getNewChildDescriptors(connection, null);
					for (Object descriptor: descriptors) {
						CommandParameter parameter = (CommandParameter) descriptor;
						if (parameter.getFeature() == CciPackage.Literals.CONNECTION__INTERACTIONS) {
							command = CreateChildCommand.create(editingDomain, connection, descriptor, Collections.singletonList(connection));
							setBaseEnabled(true);
							break;
						}
					}
				}
				
			}
		}		
	}
}
