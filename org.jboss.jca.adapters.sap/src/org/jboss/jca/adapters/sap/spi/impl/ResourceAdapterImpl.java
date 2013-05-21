package org.jboss.jca.adapters.sap.spi.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.resource.ResourceException;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.ResourceAdapterInternalException;
import javax.resource.spi.endpoint.MessageEndpointFactory;
import javax.transaction.xa.XAResource;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.jboss.jca.adapters.sap.cci.impl.CciJcaAdapterFactory;
import org.jboss.jca.adapters.sap.command.TransactionalCommandStack;
import org.jboss.jca.adapters.sap.model.edit.spi.ResourceAdapterItemProvider;
import org.jboss.jca.adapters.sap.model.edit.util.JBossSapJcaDestinationDataProvider;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactoryState;
import org.jboss.jca.adapters.sap.model.spi.ResourceAdapterState;
import org.jboss.jca.adapters.sap.model.spi.SpiFactory;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;
import org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.spi.ResourceAdapter;
import org.jboss.jca.adapters.sap.util.EditingSupport;
import org.jboss.jca.adapters.sap.util.JcaEditingDomainSupport;

/**
 * Implements the {@link ResourceAdapter } interfaces for the JBoss SAP JCA
 * Connector.
 * 
 * @author William Collins
 */
public class ResourceAdapterImpl extends ResourceAdapterItemProvider implements ResourceAdapter {

	public static final String DEFAULT_RESOURCE_URI = "JBossSapJcaResourceAdapter.spi";

	private EditingSupport<org.jboss.jca.adapters.sap.model.spi.ResourceAdapter> editingSupport = new EditingSupport<org.jboss.jca.adapters.sap.model.spi.ResourceAdapter>(this);

	protected EContentAdapter contentAdapter = new EContentAdapter() {
		@Override
		public void notifyChanged(Notification notification) {
			// Monitor the state of any associated managed connection factory
			switch (notification.getFeatureID(ManagedConnectionFactory.class)) {
			case SpiPackage.MANAGED_CONNECTION_FACTORY__STATE:
				if (notification.getNewValue() == ManagedConnectionFactoryState.DESTROYED) {
					managedConnectionFactoryDestroyed(notification);
				}
				break;
			}

			super.notifyChanged(notification);
		}
	};

	/**
	 * The Resource URI.
	 */
	private String resourceUri = DEFAULT_RESOURCE_URI;

	/**
	 * Load and store the state of the {@link ResourceAdapter} when started and
	 * stopped?
	 */
	private boolean loadAndStoreState;

	/**
	 * Create {@link ResourceAdapter} instance.
	 */
	public ResourceAdapterImpl() {
		super(SpiJcaAdapterFactory.INSTANCE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof ResourceAdapterImpl))
			return false;

		// Return true to prevent application server from deploying multiple
		// instances of this resource adapter.
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		int result = 17;
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isLoadAndStoreState() {
		return loadAndStoreState;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLoadAndStoreState(boolean loadAndStoreState) {
		this.loadAndStoreState = loadAndStoreState;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getResourceUri() {
		return resourceUri;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setResourceUri(String resourceUri) {
		this.resourceUri = resourceUri;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isStarted() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getState().equals(ResourceAdapterState.STARTED);
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void endpointActivation(MessageEndpointFactory endpointFactory, ActivationSpec activationSpec)
			throws ResourceException {
		// Not Supported: Do Nothing.
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void endpointDeactivation(MessageEndpointFactory endpointFactory, ActivationSpec activationSpec) {
		// Not Supported: Do Nothing.
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public XAResource[] getXAResources(ActivationSpec[] activationSpecs) throws ResourceException {
		// Not Supported: Return null.
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void start(BootstrapContext arg0) throws ResourceAdapterInternalException {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			if (editingSupport.getModel().getState().equals(ResourceAdapterState.STARTED))
				return;

			setProperty(SpiPackage.Literals.RESOURCE_ADAPTER__STATE, ResourceAdapterState.STARTED);

			JBossSapJcaDestinationDataProvider.INSTANCE.addConnectionRequestInfoStore(editingSupport.getModel()
					.getConnectionRequestInfoStore());

			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stop() {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			if (editingSupport.getModel().getState() == ResourceAdapterState.STOPPED)
				return;
			setProperty(SpiPackage.Literals.RESOURCE_ADAPTER__STATE, ResourceAdapterState.STOPPED);

			JBossSapJcaDestinationDataProvider.INSTANCE.removeConnectionRequestInfoStore(editingSupport.getModel()
					.getConnectionRequestInfoStore());

			storeModel(editingSupport.getModel());

			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<ManagedConnectionFactory> getManagedConnectionFactories() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.wrap(editingSupport.getModel().getManagedConnectionFactories());
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * <p>
	 * Overridden to initialize
	 * {@link org.jboss.jca.adapters.sap.model.spi.ResourceAdapter} model on
	 * demand.
	 */
	@Override
	public Notifier getTarget() {
		if (target == null) {
			synchronized (this) {
				if (target == null) {
					target = initializeModel();
					target.eAdapters().add(this);
				}
			}
		}
		return target;
	}

	@Override
	public void setTarget(Notifier target) {
		super.setTarget(target);
		target.eAdapters().add(contentAdapter);
	}

	/**
	 * Sets property of the {@link ResourceAdapter} instance using the
	 * {@link EditingDomain}'s {@link CommandStack}.
	 * 
	 * @param feature
	 *            - the {@link EStructuralFeature} of property to set.
	 * @param value
	 *            - the value to set the property to.
	 */
	protected void setProperty(EStructuralFeature feature, Object value) {
		Command command = createSetCommand(editingSupport.getEditingDomain(), editingSupport.getModel(), feature, value);
		editingSupport.getCommandStack().execute(command);
	}

	/**
	 * Initializes an {@link AdapterFactoryEditingDomain } instance.
	 * 
	 * @return an {@link AdapterFactoryEditingDomain } instance.
	 */
	protected AdapterFactoryEditingDomain initializeEditingDomain() {

		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(CciJcaAdapterFactory.INSTANCE);
		adapterFactory.addAdapterFactory(SpiJcaAdapterFactory.INSTANCE);
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		TransactionalCommandStack commandStack = new TransactionalCommandStack();

		AdapterFactoryEditingDomain adapterFactoryEditingDomain = new AdapterFactoryEditingDomain(adapterFactory,
				commandStack, new HashMap<Resource, Boolean>());
		adapterFactoryEditingDomain.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMLResourceFactoryImpl());
		return adapterFactoryEditingDomain;
	}

	/**
	 * Load and return a
	 * {@link org.jboss.jca.adapters.sap.model.spi.ResourceAdapter } model
	 * instance.
	 * 
	 * @param resourceURI
	 *            - the location of the resource containing the model to load.
	 * @param editingDomain
	 *            - the {@link AdapterFactoryEditingDomain } into which the model
	 *            is loaded.
	 * @return a {@link org.jboss.jca.adapters.sap.model.spi.ResourceAdapter }
	 *         model instance.
	 */
	protected EObject initializeModel() {

		// Get reference to editing domain
		AdapterFactoryEditingDomain editingDomain = JcaEditingDomainSupport.INSTANCE.getEditingDomain();

		// Load or create resource for resource adapter model.
		File tempFile = new File(resourceUri);
		URI resourceURI = URI.createURI(tempFile.getAbsolutePath());
		Resource resource;
		if (loadAndStoreState) {
			try {
				resource = editingDomain.getResourceSet().getResource(resourceURI, true);
			} catch (Exception e) {
				resource = editingDomain.getResourceSet().getResource(resourceURI, false);
			}
		} else {
			resource = editingDomain.getResourceSet().createResource(resourceURI);
		}

		// Get resource adapter model from resource or create and add to
		// resource.
		org.jboss.jca.adapters.sap.model.spi.ResourceAdapter resourceAdapter;
		if (resource.getContents().isEmpty()) {
			resourceAdapter = SpiFactory.eINSTANCE.createResourceAdapter();
			resource.getContents().add(resourceAdapter);
		} else {
			EObject root = resource.getContents().get(0);

			if (!(root instanceof org.jboss.jca.adapters.sap.model.spi.ResourceAdapter)) {
				root = SpiFactory.eINSTANCE.createResourceAdapter();
			}

			if (resource.getContents().size() > 1) {
				resource.getContents().clear();
				resource.getContents().add(root);
			}
			resourceAdapter = (org.jboss.jca.adapters.sap.model.spi.ResourceAdapter) root;
		}
		return resourceAdapter;
	}

	/**
	 * Store a {@link org.jboss.jca.adapters.sap.model.spi.ResourceAdapter }
	 * model instance.
	 * 
	 * @param resourceAdapter
	 *            - the
	 *            {@link org.jboss.jca.adapters.sap.model.spi.ResourceAdapter }
	 *            model instance to store.
	 */
	protected void storeModel(org.jboss.jca.adapters.sap.model.spi.ResourceAdapter resourceAdapter) {
		try {
			if (loadAndStoreState) {
				for (Resource resource: editingSupport.getEditingDomain().getResourceSet().getResources()) {
					final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
					saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
							Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
					resource.save(saveOptions);
				}
			}
		} catch (IOException e) {
			// TODO log.
			e.printStackTrace();
		}
	}

	protected void managedConnectionFactoryDestroyed(Notification notification) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {

			// Dissociate managed connection factory
			Command command = RemoveCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(),
					SpiPackage.Literals.RESOURCE_ADAPTER__MANAGED_CONNECTION_FACTORIES, notification.getNotifier());
			editingSupport.getCommandStack().execute(command);

			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

}
