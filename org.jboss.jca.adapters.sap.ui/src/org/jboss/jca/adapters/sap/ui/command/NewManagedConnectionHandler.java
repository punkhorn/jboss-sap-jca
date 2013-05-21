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
import org.eclipse.jface.window.Window;
import org.eclipse.ui.ISources;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.jboss.jca.adapters.sap.model.edit.command.TransactionalCommandStack;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnection;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;
import org.jboss.jca.adapters.sap.ui.dialog.ManagedConnectionDialog;

public class NewManagedConnectionHandler extends AbstractHandler implements IHandler {

	private EditingDomain editingDomain;
	private Command command;
	private ManagedConnection managedConnection;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		((TransactionalCommandStack)editingDomain.getCommandStack()).begin();
		editingDomain.getCommandStack().execute(command);
	    ManagedConnectionDialog dialog = new ManagedConnectionDialog(window.getShell(), ManagedConnectionDialog.Type.CREATE, editingDomain, managedConnection);
	    int status = dialog.open();
	    if (status != Window.OK) {
	    	((TransactionalCommandStack)editingDomain.getCommandStack()).rollback();
	    	return null;
	    }
	    ((TransactionalCommandStack)editingDomain.getCommandStack()).commit();
		return null;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		setBaseEnabled(false);
		Object obj = HandlerUtil.getVariable(evaluationContext, ISources.ACTIVE_CURRENT_SELECTION_NAME);
		if (obj instanceof IStructuredSelection) {
			obj = ((IStructuredSelection)obj).getFirstElement();
			if (obj instanceof ManagedConnectionFactory){
				ManagedConnectionFactory managedConnectionFactory = (ManagedConnectionFactory) obj;
				editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(managedConnectionFactory);
				if (editingDomain != null) {
					Collection<?> descriptors = editingDomain.getNewChildDescriptors(managedConnectionFactory, null);
					for (Object descriptor: descriptors) {
						CommandParameter parameter = (CommandParameter) descriptor;
						if (parameter.getFeature() == SpiPackage.Literals.MANAGED_CONNECTION_FACTORY__MANAGED_CONNECTIONS) {
							managedConnection = (ManagedConnection) parameter.getValue();
							managedConnection.getConnectionRequestInfo().getEntries().putAll(managedConnectionFactory.getDefaultConnectionRequestInfo().getEntries());
							command = CreateChildCommand.create(editingDomain, managedConnectionFactory, descriptor, Collections.singletonList(managedConnectionFactory));
							setBaseEnabled(true);
							break;
						}
					}
				}
				
			}
		}		
	}
}
