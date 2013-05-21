package org.jboss.jca.adapters.sap.ui.editor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.jboss.jca.adapters.sap.model.cci.Interaction;

public class InteractionEditorInput implements IEditorInput {
	
	private Interaction interaction;
	
	public InteractionEditorInput(Interaction interaction) {
		this.interaction = interaction;
	}

	public Interaction getInteraction() {
		return interaction;
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		return null;
	}

	@Override
	public boolean exists() {
		return true;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return ImageDescriptor.getMissingImageDescriptor();
	}

	@Override
	public String getName() {
		return "Interaction " + interaction.getConnection().getConnectionName();
	}

	@Override
	public IPersistableElement getPersistable() {
		return null;
	}

	@Override
	public String getToolTipText() {
		return "Edit an Interaction";
	}

}
