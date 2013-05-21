package org.jboss.jca.adapters.sap.ui.command;

import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISources;
import org.eclipse.ui.handlers.HandlerUtil;
import org.jboss.jca.adapters.sap.model.edit.command.TransactionalCommandStack;
import org.jboss.sap.rfc.Table;

public class NewTableRowHandler extends AbstractHandler implements IHandler {

	private EditingDomain editingDomain;
	private Command command;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		((TransactionalCommandStack)editingDomain.getCommandStack()).begin();
		editingDomain.getCommandStack().execute(command);
	    ((TransactionalCommandStack)editingDomain.getCommandStack()).commit();
		return null;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		setBaseEnabled(false);
		Object obj = HandlerUtil.getVariable(evaluationContext, ISources.ACTIVE_CURRENT_SELECTION_NAME);
		if (obj instanceof IStructuredSelection) {
			obj = ((IStructuredSelection) obj).getFirstElement();
			if (obj instanceof Table) {
				Table table = (Table) obj;
				editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(table);
				if (editingDomain != null) {
					EStructuralFeature feature = table.eClass().getEStructuralFeature("row");
					EClass rowClass = (EClass) feature.getEType();
					EObject newRow = table.eClass().getEPackage().getEFactoryInstance().create(rowClass);
					command = AddCommand.create(editingDomain, table, feature, Collections.singleton(newRow));
					setBaseEnabled(true);
				}
			}
		}
	}

}
