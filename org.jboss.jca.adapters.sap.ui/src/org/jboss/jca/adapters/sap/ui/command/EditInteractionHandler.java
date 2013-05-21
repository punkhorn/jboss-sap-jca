package org.jboss.jca.adapters.sap.ui.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISources;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.jboss.jca.adapters.sap.model.cci.Interaction;
import org.jboss.jca.adapters.sap.ui.editor.InteractionEditor;
import org.jboss.jca.adapters.sap.ui.editor.InteractionEditorInput;

public class EditInteractionHandler extends AbstractHandler implements IHandler {

	private Interaction interaction;
	private EditingDomain editingDomain;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		InteractionEditorInput input = new InteractionEditorInput(interaction);
		IWorkbenchPage page = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();
		try {
			page.openEditor(input, InteractionEditor.ID);
		} catch (PartInitException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		setBaseEnabled(false);
		Object obj = HandlerUtil.getVariable(evaluationContext, ISources.ACTIVE_CURRENT_SELECTION_NAME);
		if (obj instanceof IStructuredSelection) {
			obj = ((IStructuredSelection)obj).getFirstElement();
			if (obj instanceof Interaction) {
				interaction = (Interaction) obj;
				editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(interaction);
				if (editingDomain != null) {
					setBaseEnabled(true);
				}
			}
		}

	}
}
