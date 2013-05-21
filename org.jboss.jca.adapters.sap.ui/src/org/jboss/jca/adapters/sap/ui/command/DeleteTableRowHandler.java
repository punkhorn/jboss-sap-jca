package org.jboss.jca.adapters.sap.ui.command;

import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISources;
import org.eclipse.ui.handlers.HandlerUtil;
import org.jboss.jca.adapters.sap.model.edit.command.TransactionalCommandStack;
import org.jboss.sap.rfc.Structure;
import org.jboss.sap.rfc.Table;

public class DeleteTableRowHandler extends AbstractHandler implements IHandler {

	private EditingDomain editingDomain;
	private Command command;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		((TransactionalCommandStack) editingDomain.getCommandStack()).begin();
		editingDomain.getCommandStack().execute(command);
		((TransactionalCommandStack) editingDomain.getCommandStack()).commit();
		return null;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		setBaseEnabled(false);
		Object obj = HandlerUtil.getVariable(evaluationContext, ISources.ACTIVE_CURRENT_SELECTION_NAME);
		if (obj instanceof IStructuredSelection) {
			obj = ((IStructuredSelection) obj).getFirstElement();
			if (obj instanceof Structure) {
				Structure rowToDelete = (Structure) obj;
				if (rowToDelete.eContainer() instanceof Table) {
					Table table = (Table) rowToDelete.eContainer();
					editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(rowToDelete);
					if (editingDomain != null) {
						EStructuralFeature feature = table.eClass().getEStructuralFeature("row");
						command = RemoveCommand.create(editingDomain, table, feature, Collections.singleton(rowToDelete));
						setBaseEnabled(true);
					}
				}
			}
		}
	}

}
