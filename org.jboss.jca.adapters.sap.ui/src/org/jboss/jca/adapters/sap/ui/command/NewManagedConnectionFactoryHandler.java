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
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.model.spi.ResourceAdapter;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;
import org.jboss.jca.adapters.sap.ui.dialog.ManagedConnectionFactoryDialog;

public class NewManagedConnectionFactoryHandler extends AbstractHandler implements IHandler {

	private EditingDomain editingDomain;
	private Command command;
	private ManagedConnectionFactory managedConnectionFactory;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		((TransactionalCommandStack)editingDomain.getCommandStack()).begin();
		editingDomain.getCommandStack().execute(command);
	    ManagedConnectionFactoryDialog dialog = new ManagedConnectionFactoryDialog(window.getShell(), ManagedConnectionFactoryDialog.Type.CHANGE, editingDomain, managedConnectionFactory);
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
			if (obj instanceof ResourceAdapter){
				ResourceAdapter resourceAdapter = (ResourceAdapter) obj;
				editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(resourceAdapter);
				if (editingDomain != null) {
					Collection<?> descriptors = editingDomain.getNewChildDescriptors(resourceAdapter, null);
					for (Object descriptor: descriptors) {
						CommandParameter parameter = (CommandParameter) descriptor;
						if (parameter.getFeature() == SpiPackage.Literals.RESOURCE_ADAPTER__MANAGED_CONNECTION_FACTORIES) {
							managedConnectionFactory = (ManagedConnectionFactory) parameter.getValue();
							command = CreateChildCommand.create(editingDomain, resourceAdapter, descriptor, Collections.singletonList(resourceAdapter));
							setBaseEnabled(true);
							break;
						}
					}
				}
				
			}
		}		
	}

}
