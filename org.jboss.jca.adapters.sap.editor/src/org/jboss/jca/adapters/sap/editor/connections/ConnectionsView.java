package org.jboss.jca.adapters.sap.editor.connections;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.jboss.jca.adapters.sap.editor.JBossSapJcaEditorPlugin;

public class ConnectionsView extends ViewPart {

	public ConnectionsView() {
		super();
		JBossSapJcaEditorPlugin.getPlugin();
	}

	@Override
	public void createPartControl(Composite parent) {
		
	}

	@Override
	public void setFocus() {
		// NOOP
	}

}
