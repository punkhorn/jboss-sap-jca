package org.jboss.jca.adapters.sap.ui.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.ISources;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.jboss.jca.adapters.sap.model.edit.command.TransactionalCommandStack;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnection;
import org.jboss.jca.adapters.sap.ui.dialog.ManagedConnectionDialog;

public class EditManagedConnectionHandler extends AbstractHandler implements IHandler {

	private ManagedConnection managedConnection;
	private EditingDomain editingDomain;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		((TransactionalCommandStack)editingDomain.getCommandStack()).begin();
	    ManagedConnectionDialog dialog = new ManagedConnectionDialog(window.getShell(), ManagedConnectionDialog.Type.CHANGE, editingDomain, managedConnection);
	    int status = dialog.open();
	    if (status == Window.OK) {
	    	((TransactionalCommandStack)editingDomain.getCommandStack()).commit();
	    } else {
	    	((TransactionalCommandStack)editingDomain.getCommandStack()).rollback();
	    }
		return null;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		setBaseEnabled(false);
		Object obj = HandlerUtil.getVariable(evaluationContext, ISources.ACTIVE_CURRENT_SELECTION_NAME);
		if (obj instanceof IStructuredSelection) {
			obj = ((IStructuredSelection)obj).getFirstElement();
			if (obj instanceof ManagedConnection) {
				managedConnection = (ManagedConnection) obj;
				editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(managedConnection);
				if (editingDomain != null) {
					setBaseEnabled(true);
				}
			}
		}

	}
}
