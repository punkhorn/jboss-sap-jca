package org.jboss.jca.adapters.sap.ui.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.PasteFromClipboardCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISources;
import org.eclipse.ui.handlers.HandlerUtil;

public class PasteHandler extends AbstractHandler implements IHandler {

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
			IStructuredSelection selection = (IStructuredSelection) obj;
			if (selection.size() == 1) {
				obj = selection.getFirstElement();
				if (obj instanceof EObject) {
					EObject eObject = (EObject) obj;
					editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
					if (editingDomain != null) {
						command = PasteFromClipboardCommand.create(editingDomain, eObject, null);
						if (command.canExecute()) {
							setBaseEnabled(true);
						}
					}
				}
			}
		}
	}

}
