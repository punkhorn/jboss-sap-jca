package org.jboss.jca.adapters.sap.ui.view;

import java.io.IOException;
import java.util.Collection;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.jboss.jca.adapters.sap.model.edit.JBossSapJcaEditPlugin;
import org.jboss.jca.adapters.sap.model.edit.cci.CciItemProviderAdapterFactory;
import org.jboss.jca.adapters.sap.model.edit.command.TransactionalCommandStack;
import org.jboss.jca.adapters.sap.model.edit.spi.SpiItemProviderAdapterFactory;
import org.jboss.jca.adapters.sap.model.edit.util.JBossSapJcaDestinationDataProvider;
import org.jboss.jca.adapters.sap.model.spi.SpiFactory;
import org.jboss.jca.adapters.sap.ui.Log;

/**
 * Sap Connections View
 */

public class SapConnectionsView extends ViewPart implements ISelectionChangedListener {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.jboss.jca.adapters.sap.model.editor.view.SapConnectionsView";

	/**
	 * This keeps track of the editing domain that is used to track all changes
	 * to the model.
	 */
	protected AdapterFactoryEditingDomain editingDomain;

	/**
	 * This is the one adapter factory used for providing views of the model.
	 */
	protected ComposedAdapterFactory adapterFactory;

	/**
	 * The resource adapter containing connections to SAP.
	 */
	protected org.jboss.jca.adapters.sap.model.spi.ResourceAdapter resourceAdapter;

	/**
	 * This listens to to viewer.
	 */
	protected ISelectionChangedListener selectionChangedListener;

	/**
	 * The viewer for view.
	 */
	private TreeViewer viewer;

	/**
	 * This is the property sheet page.
	 * 
	 * @generated
	 */
	protected PropertySheetPage propertySheetPage;

	/**
	 * The constructor.
	 */
	public SapConnectionsView() {
		initializeEditingDomain();
	}

	public AdapterFactoryEditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		createModel();

		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		viewer.setInput(resourceAdapter.eResource());
		viewer.addSelectionChangedListener(this);

		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem()
				.setHelp(viewer.getControl(), "org.jboss.jca.adapters.sap.model.editor.viewer");
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();

		getSite().setSelectionProvider(viewer);
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter.equals(IPropertySheetPage.class)) {
			return getPropertySheetPage();
		} else {
			return super.getAdapter(adapter);
		}
	}

	@Override
	public void dispose() {
		// Save all changes to resource set.
		for (Resource resource : editingDomain.getResourceSet().getResources()) {
			try {
				resource.save(null);
			} catch (IOException e) {
				Log.logWarning("Error when saving view state", e);
			}
		}

		if (propertySheetPage != null) {
			propertySheetPage.dispose();
		}

		JBossSapJcaDestinationDataProvider.INSTANCE.removeConnectionRequestInfoStore(resourceAdapter
				.getConnectionRequestInfoStore());

	}

	public void setSelectionToViewer(Collection<?> collection) {
		final Collection<?> theSelection = collection;

		if (theSelection != null && !theSelection.isEmpty()) {
			Runnable runnable = new Runnable() {
				public void run() {
					viewer.setSelection(new StructuredSelection(theSelection.toArray()), true);
				}
			};
			getSite().getShell().getDisplay().asyncExec(runnable);
		}
	}

	public IPropertySheetPage getPropertySheetPage() {
		if (propertySheetPage == null) {
			propertySheetPage = new ExtendedPropertySheetPage(editingDomain) {
				@Override
				public void setSelectionToViewer(List<?> selection) {
					SapConnectionsView.this.setSelectionToViewer(selection);
					SapConnectionsView.this.setFocus();
				}

				@Override
				public void setActionBars(IActionBars actionBars) {
					super.setActionBars(actionBars);
					// getActionBarContributor().shareGlobalActions(this,
					// actionBars);
				}
			};
			propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(adapterFactory));
		}

		return propertySheetPage;
	}

	private void hookContextMenu() {
		MenuManager menuManager = new MenuManager("#PopupMenu");
		menuManager.setRemoveAllWhenShown(true);

		menuManager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				SapConnectionsView.this.fillContextMenu(manager);
			}
		});

		Menu menu = menuManager.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuManager, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
	}

	private void fillContextMenu(IMenuManager menuManager) {

		menuManager.add(new Separator("edit"));

		menuManager.add(new Separator("additions"));
		menuManager.add(new Separator("additions-end"));

	}

	private void fillLocalToolBar(IToolBarManager manager) {
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {

			}
		});
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {

	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	protected void initializeEditingDomain() {
		// Create an adapter factory that yields item providers.
		//
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new CciItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new SpiItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		// Create the command stack that will notify this editor as commands are
		// executed.
		//
		BasicCommandStack commandStack = new TransactionalCommandStack();
		commandStack.addCommandStackListener(new CommandStackListener() {

			@Override
			public void commandStackChanged(final EventObject event) {
				getViewSite().getShell().getDisplay().asyncExec(new Runnable() {

					@Override
					public void run() {
						update();
						Command mostRecentCommand = ((CommandStack) event.getSource()).getMostRecentCommand();
						if (mostRecentCommand != null) {
							setSelectionToViewer(mostRecentCommand.getAffectedObjects());
						}
						if (propertySheetPage != null && !propertySheetPage.getControl().isDisposed()) {
							propertySheetPage.refresh();
						}
					}
				});

			}
		});

		// Create the editing domain with a special command stack.
		//
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
	}

	protected void createModel() {
		String path = JBossSapJcaEditPlugin.getPlugin().getStateLocation().append("resource.spi").toOSString();
		URI resourceURI = URI.createFileURI(path);
		Resource resource;
		try {
			resource = editingDomain.getResourceSet().getResource(resourceURI, true);
		} catch (Exception e) {
			resource = editingDomain.getResourceSet().getResource(resourceURI, false);
		}

		// Get resource adapter model from resource or create and add to
		// resource.
		if (resource.getContents().isEmpty()) {
			resourceAdapter = SpiFactory.eINSTANCE.createResourceAdapter();
			resource.getContents().add(resourceAdapter);
		} else {
			EObject root = resource.getContents().get(0);

			// Replace root if it is not a resource adapter model element.
			if (!(root instanceof org.jboss.jca.adapters.sap.model.spi.ResourceAdapter)) {
				root = SpiFactory.eINSTANCE.createResourceAdapter();
				resource.getContents().set(0, root);
			}

			// Ensure single root in resource.
			if (resource.getContents().size() > 1) {
				resource.getContents().clear();
				resource.getContents().add(root);
			}
			resourceAdapter = (org.jboss.jca.adapters.sap.model.spi.ResourceAdapter) root;
		}

		try {
			resource.save(null);
		} catch (IOException e) {
			Log.logWarning("Error when saving view state", e);
		}

		JBossSapJcaDestinationDataProvider.INSTANCE.addConnectionRequestInfoStore(resourceAdapter
				.getConnectionRequestInfoStore());

	}
	
	protected void update() {
	}

}