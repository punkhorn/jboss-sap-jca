package org.jboss.jca.adapters.sap.ui.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.FocusCellOwnerDrawHighlighter;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.TreeViewerEditor;
import org.eclipse.jface.viewers.TreeViewerFocusCellManager;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.jboss.jca.adapters.sap.model.cci.Interaction;
import org.jboss.sap.rfc.Function;
import org.jboss.sap.rfc.RfcFactory;
import org.jboss.sap.rfc.Structure;
import org.jboss.sap.rfc.ui.dialog.SelectFunctionDialog;
import org.jboss.sap.rfc.util.RfcUtil;

public class InteractionEditor extends EditorPart {

	public class AttributeWrapper {
		private EObject parent;
		private EAttribute attribute;

		public AttributeWrapper(EObject parent, EAttribute attribute) {
			this.parent = parent;
			this.attribute = attribute;
		}

		public EObject getParent() {
			return parent;
		}

		public EAttribute getAttribute() {
			return attribute;
		}

		public Object getValue() {
			try {
				return parent.eGet(attribute);
			} catch (Throwable t) {
				return null;
			}
		}

	}

	private class EObjectContentProvider implements ITreeContentProvider {

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		public Object[] getChildren(Object parentElement) {

			if (!(parentElement instanceof EObject)) {
				return new Object[0];
			}

			EObject parentObject = (EObject) parentElement;

			List<Object> children = new ArrayList<Object>();

			for (EAttribute attribute : parentObject.eClass().getEAllAttributes()) {
				children.add(new AttributeWrapper(parentObject, attribute));
			}

			for (EReference reference : parentObject.eClass().getEAllReferences()) {
				Object value = getValue(parentObject, reference);
				if (value == null) {
					EClass eClass = reference.getEReferenceType();
					value = eClass.getEPackage().getEFactoryInstance().create(eClass);
					setValue(parentObject, reference, value);
				}
				
				if (value != null) {
					if (reference.isMany()) {
						@SuppressWarnings("unchecked")
						EList<EObject> values = (EList<EObject>) value;
						for (EObject eObject: values) {
							children.add(eObject);
						}
					} else {
						children.add(value);
					}
				} 
//				if (reference.isMany()) {
//					@SuppressWarnings("unchecked")
//					EList<EObject> values = (EList<EObject>) value;
//					for (EObject eObject: values) {
//						children.add(new AttributeWrapper(parentObject, eObject, reference));
//					}
//				} else {
//					children.add(new AttributeWrapper(parentObject, value, reference));
//				}
			}

			return children.toArray();
		}

		public Object getParent(Object element) {
			if (element instanceof AttributeWrapper) {
				return ((AttributeWrapper) element).getParent();
			} else if (element instanceof EObject) {
				return ((EObject)element).eContainer();
			}

			return null;
		}

		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}

		protected Object getValue(EObject object, EStructuralFeature feature) {
			try {
				return object.eGet(feature);
			} catch (Throwable exception) {
				return null;
			}
		}
		
		protected void setValue(EObject object, EStructuralFeature feature, Object value) {
			try {
				object.eSet(feature, value);
			} catch (Throwable t) {
			}
		}
	}

	private class FeatureNameColumnLabelProvider extends ColumnLabelProvider {
		public String getText(Object element) {
			if (element instanceof AttributeWrapper) {
				EStructuralFeature feature = ((AttributeWrapper) element).getAttribute();
				return feature.getName();
			} else if (element instanceof EObject) {
				EReference reference = ((EObject)element).eContainmentFeature();
				if (reference != null) {
					return reference.getName();
				}
			}
			return null;
		}
		
		@Override
		public String getToolTipText(Object element) {
			if (element instanceof AttributeWrapper) {
				EStructuralFeature feature = ((AttributeWrapper) element).getAttribute();
				EAnnotation annotation = feature.getEAnnotation(RfcUtil.GenNS_URI);
				return annotation.getDetails().get(RfcUtil.GenNS_DOCUMENTATION_KEY);
			} else if (element instanceof EObject) {
				EReference reference = ((EObject)element).eContainmentFeature();
				if (reference != null) {
					EAnnotation annotation = reference.getEAnnotation(RfcUtil.GenNS_URI);
					return annotation.getDetails().get(RfcUtil.GenNS_DOCUMENTATION_KEY);
				}
			}
			return null;
		}
		
		@Override
		public Point getToolTipShift(Object object) {
			return new Point(5,5);
		}
		
		@Override
		public int getToolTipDisplayDelayTime(Object object) {
			return 100; 
		}
		
		@Override
		public int getToolTipTimeDisplayed(Object object) {
			return 5000;
		}
	}

	private class FeatureValueColumnLabelProvider extends ColumnLabelProvider {

		public String getText(Object element) {
			if (element instanceof AttributeWrapper) {
				Object value = ((AttributeWrapper) element).getValue();
				return value == null ? null : value.toString();
			}
			return null;
		}

	}

	public InteractionEditor() {
	}

	public static final String ID = "org.jboss.jca.adapters.sap.ui.editor.InteractionEditor";

	protected AdapterFactoryEditingDomain editingDomain;

	protected ComposedAdapterFactory adapterFactory;

	private Interaction interaction;

	private InteractionEditorInput input;

	protected Label lblFunctionName;

	protected TreeViewer inputTreeViewer;

	protected TreeViewer outputTreeViewer;

	protected Function function = RfcFactory.eINSTANCE.createFunction();

	protected List<IItemPropertyDescriptor> inputDescriptors;

	protected List<IItemPropertyDescriptor> outputDescriptors;

	protected AdapterFactoryItemDelegator adapterFactoryItemDelegator;

	protected Structure request;

	protected Structure response;

	protected Button btnExecuteFunction;

	protected Resource resource;
	
	protected EContentAdapter contentAdapter = new EContentAdapter() {
		@Override
		public void notifyChanged(Notification notification) {
			inputTreeViewer.refresh();
			super.notifyChanged(notification);
		}
	};

	@Override
	public void doSave(IProgressMonitor monitor) {
	}

	@Override
	public void doSaveAs() {
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		if (!(input instanceof InteractionEditorInput)) {
			throw new RuntimeException("Invalid input");
		}

		this.input = (InteractionEditorInput) input;
		setSite(site);
		setInput(input);
		interaction = this.input.getInteraction();
		setPartName(this.input.getName());

		initializeEditingDomain();

	}

	protected void initializeEditingDomain() {
		editingDomain = (AdapterFactoryEditingDomain) AdapterFactoryEditingDomain.getEditingDomainFor(interaction);
		adapterFactory = (ComposedAdapterFactory) editingDomain.getAdapterFactory();
		adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(adapterFactory);
		resource = editingDomain.getResourceSet().createResource(URI.createURI("http://interaction.cci"));
		resource.eAdapters().add(contentAdapter);
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		Composite functionComposite = new Composite(parent, SWT.NONE);
		functionComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		functionComposite.setLayout(new GridLayout(3, false));

		Button btnSelectFunction = new Button(functionComposite, SWT.NONE);
		btnSelectFunction.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectFunction();
			}
		});
		btnSelectFunction.setText("Select Function");

		lblFunctionName = new Label(functionComposite, SWT.NONE);
		lblFunctionName.setText("Please Select a Function");
		lblFunctionName.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));

		btnExecuteFunction = new Button(functionComposite, SWT.NONE);
		btnExecuteFunction.setEnabled(false);
		btnExecuteFunction.setAlignment(SWT.LEFT);
		btnExecuteFunction.setText("Execute Function");
		btnExecuteFunction.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				executeFunction();
			}
		});

		Composite ioComposite = new Composite(parent, SWT.NONE);
		ioComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		ioComposite.setLayout(new FillLayout(SWT.HORIZONTAL));

		SashForm sashForm = new SashForm(ioComposite, SWT.NONE);

		//
		// Request Panel
		//
		
		Composite inputComposite = new Composite(sashForm, SWT.NONE);
		inputComposite.setLayout(new GridLayout(1, false));

		Label lblNewLabel_1 = new Label(inputComposite, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		lblNewLabel_1.setText("Input Record");

		inputTreeViewer = new TreeViewer(inputComposite, SWT.BORDER);
		final Tree inputTree = inputTreeViewer.getTree();
		inputTree.setLinesVisible(true);
		inputTree.setHeaderVisible(true);
		inputTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		TreeViewerFocusCellManager focusCellManager = new TreeViewerFocusCellManager(inputTreeViewer,
				new FocusCellOwnerDrawHighlighter(inputTreeViewer));
		ColumnViewerToolTipSupport.enableFor(inputTreeViewer, ToolTip.NO_RECREATE);
		ColumnViewerEditorActivationStrategy actSupport = new ColumnViewerEditorActivationStrategy(inputTreeViewer) {
			@Override
			protected boolean isEditorActivationEvent(ColumnViewerEditorActivationEvent event) {
				return event.eventType == ColumnViewerEditorActivationEvent.TRAVERSAL
						|| event.eventType == ColumnViewerEditorActivationEvent.MOUSE_DOUBLE_CLICK_SELECTION
						|| (event.eventType == ColumnViewerEditorActivationEvent.KEY_PRESSED && event.keyCode == SWT.CR)
						|| event.eventType == ColumnViewerEditorActivationEvent.PROGRAMMATIC;
			}
		};

		TreeViewerEditor.create(inputTreeViewer, focusCellManager, actSupport, ColumnViewerEditor.TABBING_HORIZONTAL
				| ColumnViewerEditor.TABBING_MOVE_TO_ROW_NEIGHBOR | ColumnViewerEditor.TABBING_VERTICAL
				| ColumnViewerEditor.KEYBOARD_ACTIVATION);
		
		final TextCellEditor textCellEditor = new TextCellEditor(inputTree);

		TreeViewerColumn featureNameColumn = new TreeViewerColumn(inputTreeViewer, SWT.NONE);
		featureNameColumn.getColumn().setWidth(200);
		featureNameColumn.getColumn().setMoveable(true);
		featureNameColumn.getColumn().setText("Parameter Name");
		featureNameColumn.setLabelProvider(new FeatureNameColumnLabelProvider());
		featureNameColumn.setEditingSupport(new EditingSupport(inputTreeViewer) {

			@Override
			protected CellEditor getCellEditor(Object element) {
				return textCellEditor;
			}

			@Override
			protected boolean canEdit(Object element) {
				return false;
			}

			@Override
			protected Object getValue(Object element) {
				return ((AttributeWrapper)element).getAttribute().getName() + "";
			}

			@Override
			protected void setValue(Object element, Object value) {
				
			}
			
		});

		TreeViewerColumn featureValueColumn = new TreeViewerColumn(inputTreeViewer, SWT.NONE);
		featureValueColumn.getColumn().setWidth(200);
		featureValueColumn.getColumn().setMoveable(true);
		featureValueColumn.getColumn().setText("Parameter Value");
		featureValueColumn.setLabelProvider(new FeatureValueColumnLabelProvider());
		featureValueColumn.setEditingSupport(new EditingSupport(inputTreeViewer) {

			@Override
			protected CellEditor getCellEditor(Object element) {
				EStructuralFeature feature = ((AttributeWrapper)element).getAttribute();
				if (feature instanceof EAttribute) {
					EAttribute attribute = (EAttribute) feature;
					return new PropertyDescriptor.EDataTypeCellEditor(attribute.getEAttributeType(), inputTree);
				}
				return textCellEditor;
			}

			@Override
			protected boolean canEdit(Object element) {
				return (element instanceof AttributeWrapper) ? true : false;
			}

			@Override
			protected Object getValue(Object element) {
				return ((AttributeWrapper)element).getValue();
			}

			@Override
			protected void setValue(Object element, Object value) {
				EObject eObject = ((AttributeWrapper)element).getParent();
				EStructuralFeature feature = ((AttributeWrapper)element).getAttribute();
				Command cmd = SetCommand.create(editingDomain, eObject, feature, value);
				editingDomain.getCommandStack().execute(cmd);
				inputTreeViewer.update(element, null);
			}
			
		});

		inputTreeViewer.setContentProvider(new EObjectContentProvider());
		
		// Add menu manager for context menu
		MenuManager menuManager = new MenuManager();
		Menu menu = menuManager.createContextMenu(inputTree);
		inputTree.setMenu(menu);
		getSite().registerContextMenu(menuManager, inputTreeViewer);
		getSite().setSelectionProvider(inputTreeViewer);

		//
		// Response Panel
		//
		
		Composite outputComposite = new Composite(sashForm, SWT.NONE);
		outputComposite.setLayout(new GridLayout(1, false));

		Label lblNewLabel_2 = new Label(outputComposite, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		lblNewLabel_2.setText("Output Record");

		outputTreeViewer = new TreeViewer(outputComposite, SWT.BORDER);
		Tree outputTree = outputTreeViewer.getTree();
		outputTree.setLinesVisible(true);
		outputTree.setHeaderVisible(true);
		outputTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		featureNameColumn = new TreeViewerColumn(outputTreeViewer, SWT.NONE);
		featureNameColumn.getColumn().setWidth(200);
		featureNameColumn.getColumn().setMoveable(true);
		featureNameColumn.getColumn().setText("Parameter Name");
		featureNameColumn.setLabelProvider(new FeatureNameColumnLabelProvider());

		featureValueColumn = new TreeViewerColumn(outputTreeViewer, SWT.NONE);
		featureValueColumn.getColumn().setWidth(200);
		featureValueColumn.getColumn().setMoveable(true);
		featureValueColumn.getColumn().setText("Parameter Value");
		featureValueColumn.setLabelProvider(new FeatureValueColumnLabelProvider());

		outputTreeViewer.setContentProvider(new EObjectContentProvider());

		initDataBindings();

	}

	@Override
	public void setFocus() {
	}

	protected void selectFunction() {
		
		String destinationName = interaction.getConnection().getConnectionName();
		SelectFunctionDialog dialog = new SelectFunctionDialog(getSite().getShell(), destinationName);
		int status = dialog.open();
		if (status != Window.OK) {
			return;
		}

		function = dialog.getFunction();
		if (function == null) {
			btnExecuteFunction.setEnabled(false);
			return;
		} else {
			lblFunctionName.setText(function.getName());
			
			request = RfcUtil.getRequest(destinationName, function.getName());
			resource.getContents().add(request);

			response = RfcUtil.getResponse(destinationName, function.getName());
			resource.getContents().add(response);
			
			inputTreeViewer.setInput(request);
			outputTreeViewer.setInput(response);
			btnExecuteFunction.setEnabled(true);
		}

	}
	
	protected void executeFunction() {
		String destinationName = interaction.getConnection().getConnectionName();
		Structure response = RfcUtil.executeFunction(destinationName, function.getName(), request);
		if (response != null) {
			this.response = response;
			outputTreeViewer.setInput(response);
		}
	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		return bindingContext;
	}
}
