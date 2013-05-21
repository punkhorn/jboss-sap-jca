package org.jboss.jca.adapters.sap.model.editor.view;

import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.jboss.jca.adapters.sap.model.edit.JBossSapJcaEditPlugin;
import org.jboss.jca.adapters.sap.model.edit.util.JBossSapJcaDestinationDataProvider;
import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfoStore;
import org.jboss.jca.adapters.sap.model.spi.SpiFactory;
import org.jboss.sap.rfc.util.RfcUtil;
import org.jboss.sap.rfc.view.provider.RfcViewItemProviderAdapterFactory;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;

public class SapRfcView extends ViewPart {
	
	/**
	 * This keeps track of the editing domain that is used to track all changes to the model.
	 */
	protected AdapterFactoryEditingDomain editingDomain;

	/**
	 * This is the one adapter factory used for providing views of the model.
	 */
	protected ComposedAdapterFactory adapterFactory;

	protected org.jboss.sap.rfc.Repository repository;

	/**
	 * The viewer for view.
	 */
	private TreeViewer viewer;

	public SapRfcView() {
		initializeEditingDomain();
	}

	@Override
	public void createPartControl(Composite parent) {
		createModel();

		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		viewer.setInput(repository.eResource());
		
		getSite().setSelectionProvider(viewer);
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	protected void createModel() {
		
		ConnectionRequestInfoStore store = SpiFactory.eINSTANCE.createConnectionRequestInfoStore();
		JBossSapJcaDestinationDataProvider.INSTANCE.addConnectionRequestInfoStore(store);
		ConnectionRequestInfo info = SpiFactory.eINSTANCE.createConnectionRequestInfo();
		info.setAshost("nplhost");
		info.setSysnr("42");
		info.setClient("001");
		info.setUser("developer");
		info.setPasswd("ch4ngeme");
		info.setLang("en");
		store.getConnectionRequestInfos().put("SapRfcViewConnection", info);
		
		try {

			JCoDestination destination = JCoDestinationManager.getDestination("SapRfcViewConnection");

			String path = JBossSapJcaEditPlugin.getPlugin().getStateLocation().append(destination.getRepository().getName() + ".rfc").toOSString();
			URI resourceURI = URI.createFileURI(path);
			Resource resource;
			try {
				resource = editingDomain.getResourceSet().getResource(resourceURI, true);
			}
			catch (Exception e) {
				resource = editingDomain.getResourceSet().getResource(resourceURI, false);
			}

			repository = RfcUtil.getRepository("SapRfcViewConnection");
			resource.getContents().clear();
			resource.getContents().add(repository);
			
			List<org.jboss.sap.rfc.Group> groups = RfcUtil.getGroups("SapRfcViewConnection", "*");
			repository.getGroups().addAll(groups);
			
		} catch (JCoException e) {
			e.printStackTrace();
		}
		
	}	
	
	protected void initializeEditingDomain() {
		// Create an adapter factory that yields item providers.
		//
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new RfcViewItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		// Create the command stack that will notify this editor as commands are executed.
		//
		BasicCommandStack commandStack = new BasicCommandStack();

		// Create the editing domain with a special command stack.
		//
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
	}
}
