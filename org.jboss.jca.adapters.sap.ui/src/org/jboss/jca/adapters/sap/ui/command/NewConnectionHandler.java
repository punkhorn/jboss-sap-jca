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
import org.jboss.jca.adapters.sap.model.cci.Connection;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnection;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;

public class NewConnectionHandler extends AbstractHandler implements IHandler {

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
			if (obj instanceof ManagedConnection){
				ManagedConnection managedConnection = (ManagedConnection) obj;
				editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(managedConnection);
				if (editingDomain != null) {
					Collection<?> descriptors = editingDomain.getNewChildDescriptors(managedConnection, null);
					for (Object descriptor: descriptors) {
						CommandParameter parameter = (CommandParameter) descriptor;
						if (parameter.getFeature() == SpiPackage.Literals.MANAGED_CONNECTION__CONNECTION_HANDLES) {
							Connection connection = (Connection) parameter.getValue();
							connection.setConnectionName(managedConnection.getConnectionName());
							connection.setConnectionRequestInfo(managedConnection.getConnectionRequestInfo());
							command = CreateChildCommand.create(editingDomain, managedConnection, descriptor, Collections.singletonList(managedConnection));
							setBaseEnabled(true);
							break;
						}
					}
				}
				
			}
		}		
	}
}
