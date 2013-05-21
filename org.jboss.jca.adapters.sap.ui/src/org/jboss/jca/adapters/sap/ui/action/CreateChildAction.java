package org.jboss.jca.adapters.sap.ui.action;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnection;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.model.spi.ResourceAdapter;
import org.jboss.jca.adapters.sap.ui.dialog.ManagedConnectionDialog;
import org.jboss.jca.adapters.sap.ui.dialog.ManagedConnectionFactoryDialog;

public class CreateChildAction extends org.eclipse.emf.edit.ui.action.CreateChildAction {
	
	ResourceAdapter resourceAdapter;
	Object owner;

	public CreateChildAction(EditingDomain editingDomain, ISelection selection,
			Object descriptor) {
		super(editingDomain, selection, descriptor);
	}

	public CreateChildAction(IEditorPart editorPart, ISelection selection,
			Object descriptor) {
		super(editorPart, selection, descriptor);
	}

	public CreateChildAction(IWorkbenchPart workbenchPart,
			ISelection selection, Object descriptor) {
		super(workbenchPart, selection, descriptor);
	}
	
	public ResourceAdapter getResourceAdapter() {
		return resourceAdapter;
	}

	public void setResourceAdapter(ResourceAdapter resourceAdapter) {
		this.resourceAdapter = resourceAdapter;
	}
	
	@Override
	protected Command createActionCommand(EditingDomain editingDomain,
			Collection<?> collection) {
		if (collection.size() == 1) {
			owner = collection.iterator().next();
		}
		return super.createActionCommand(editingDomain, collection);
	}

	@Override
	public void run() {
		if (descriptor instanceof CommandParameter) {
			CommandParameter commandParameter = (CommandParameter) descriptor;
			if (commandParameter.getValue() instanceof ManagedConnection) {
				ManagedConnection managedConnection = (ManagedConnection) commandParameter.getValue();
				ManagedConnectionFactory managedConnectionFactory = (ManagedConnectionFactory) owner;
				managedConnection.getConnectionRequestInfo().getEntries().clear();
				managedConnection.getConnectionRequestInfo().getEntries().putAll(managedConnectionFactory.getDefaultConnectionRequestInfo().getEntries());
			    resourceAdapter.getConnectionRequestInfoStore().getConnectionRequestInfos().put(managedConnection.getConnectionName(), managedConnection.getConnectionRequestInfo());
			    Shell parentShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			    ManagedConnectionDialog dialog = new ManagedConnectionDialog(parentShell, ManagedConnectionDialog.Type.CREATE, editingDomain, managedConnection);
			    int status = dialog.open();
			    resourceAdapter.getConnectionRequestInfoStore().getConnectionRequestInfos().removeKey(managedConnection.getConnectionName());
			    if (status != Window.OK)
			    	return;
			} else if (commandParameter.getValue() instanceof ManagedConnectionFactory) {
				ManagedConnectionFactory managedConnection = (ManagedConnectionFactory) commandParameter.getValue();
			    resourceAdapter.getConnectionRequestInfoStore().getConnectionRequestInfos().put(managedConnection.getDefaultConnectionName(), managedConnection.getDefaultConnectionRequestInfo());
			    Shell parentShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			    ManagedConnectionFactoryDialog dialog = new ManagedConnectionFactoryDialog(parentShell, ManagedConnectionFactoryDialog.Type.CREATE, editingDomain, managedConnection);
			    int status = dialog.open();
			    resourceAdapter.getConnectionRequestInfoStore().getConnectionRequestInfos().removeKey(managedConnection.getDefaultConnectionName());
			    if (status != Window.OK)
			    	return;
			}
		}
		super.run();
	}

}
