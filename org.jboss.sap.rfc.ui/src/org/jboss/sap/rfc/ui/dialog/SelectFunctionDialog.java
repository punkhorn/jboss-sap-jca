package org.jboss.sap.rfc.ui.dialog;

import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.TableViewerColumnSorter;
import org.jboss.sap.rfc.Function;
import org.jboss.sap.rfc.Group;
import org.jboss.sap.rfc.RfcFactory;
import org.jboss.sap.rfc.RfcPackage.Literals;
import org.jboss.sap.rfc.util.RfcUtil;

public class SelectFunctionDialog extends TitleAreaDialog {

	private String destinationName;
	
	private Function function;
	
	private Group group = RfcFactory.eINSTANCE.createGroup();
	
	private Text functionNameText;
	private Table functionTable;
	private TableViewer functionTableViewer;

	public SelectFunctionDialog(Shell parentShell, String destinationName) {
		super(parentShell);
		setShellStyle(SWT.RESIZE);
		this.destinationName = destinationName;
	}

	public Function getFunction() {
		return function;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		
		newShell.setText("Select Function");
	}
	
	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		
		setTitle("Select Function");
		setMessage("Select a Function");
		
		return contents;
	}
	
	
	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(1, false));
		
		Composite searchComposite = new Composite(container, SWT.NONE);
		searchComposite.setLayout(new GridLayout(3, false));
		GridData gd_searchComposite = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_searchComposite.widthHint = 439;
		searchComposite.setLayoutData(gd_searchComposite);
		
		Label lblFunctionName = new Label(searchComposite, SWT.NONE);
		lblFunctionName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFunctionName.setBounds(0, 0, 68, 17);
		lblFunctionName.setText("Function Name: ");
		
		functionNameText = new Text(searchComposite, SWT.BORDER);
		functionNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		
		Button btnSearch = new Button(searchComposite, SWT.NONE);
		btnSearch.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnSearch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				List<Function> functions = searchFunctions(functionNameText.getText());
				group.getFunctions().clear();
				group.getFunctions().addAll(functions);
			}
		});
		btnSearch.setText("Search");
		
		functionTableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		functionTableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection)event.getSelection();
				function = (Function) selection.getFirstElement();
			}
		});
		functionTable = functionTableViewer.getTable();
		functionTable.setHeaderVisible(true);
		functionTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TableViewerColumn functionNameViewerColumn = new TableViewerColumn(functionTableViewer, SWT.NONE);
		new TableViewerColumnSorter(functionNameViewerColumn) {
			@Override
			protected int doCompare(Viewer viewer, Object e1, Object e2) {
				Function f1 = (Function) e1;
				Function f2 = (Function) e2;
				return f1.getName().compareTo(f2.getName());
			}
			@Override
			protected Object getValue(Object o) {
				return ((Function)o).getName();
			}
		};
		TableColumn functionNameColumn = functionNameViewerColumn.getColumn();
		functionNameColumn.setWidth(200);
		functionNameColumn.setText("Function Name");
		
		TableViewerColumn functionDescriptionViewerColumn = new TableViewerColumn(functionTableViewer, SWT.NONE);
		TableColumn functionDescriptionColumn = functionDescriptionViewerColumn.getColumn();
		functionDescriptionColumn.setWidth(100);
		functionDescriptionColumn.setText("Function Description");
		initDataBindings();
		
		return container;
	}
	
	protected List<Function> searchFunctions(String functionNameFilter) {
		return RfcUtil.getFunctions(destinationName, functionNameFilter, "*");
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap[] observeMaps = EMFObservables.observeMaps(listContentProvider.getKnownElements(), new EStructuralFeature[]{Literals.FUNCTION__NAME, Literals.FUNCTION__DESCRIPTION});
		functionTableViewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		functionTableViewer.setContentProvider(listContentProvider);
		//
		IObservableList groupFunctionsObserveList = EMFObservables.observeList(Realm.getDefault(), group, Literals.GROUP__FUNCTIONS);
		functionTableViewer.setInput(groupFunctionsObserveList);
		//
		return bindingContext;
	}
}
