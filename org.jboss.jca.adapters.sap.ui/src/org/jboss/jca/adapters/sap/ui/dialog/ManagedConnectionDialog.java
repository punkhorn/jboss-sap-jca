package org.jboss.jca.adapters.sap.ui.dialog;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnection;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage.Literals;
import org.jboss.jca.adapters.sap.ui.Activator;
import org.jboss.jca.adapters.sap.ui.converter.Boolean2StringConverter;
import org.jboss.jca.adapters.sap.ui.converter.CpicTraceComboSelection2TraceLevelConverter;
import org.jboss.jca.adapters.sap.ui.converter.SncQosComboSelection2SncQosConverter;
import org.jboss.jca.adapters.sap.ui.validator.ClientNumberValidator;
import org.jboss.jca.adapters.sap.ui.validator.LanguageValidator;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;

public class ManagedConnectionDialog extends TitleAreaDialog {
	
	public enum Type {
		CREATE, CHANGE, COPY
	}

    private Type type;
	
	private ManagedConnection managedConnection;
	private Combo authTypeCombo;
	private Control clientText2;
	private Control userText2;
	private Control userAlias;
	private Control passwordText2;
	private Control mysapsso2Text;
	private Control x509certText;
	private Control languageText2;
	private Button traceBtn;
	private Combo cpicTraceCombo;
	private Button lcheckBtn;
	private Control codepageText;
	private Button getsso2Btn;
	private Button denyInitialPasswordBtn;
	private Button sncModeBtn;
	private Text sncPartnernameText;
	private Combo sncQopCombo;
	private Control sncMynameText;
	private Control sncLibraryText;
	private EditingDomain editingDomain;
	private Binding clientBinding2;
	private Binding langBinding2;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public ManagedConnectionDialog(Shell parentShell, Type type, EditingDomain editingDomain, ManagedConnection managedConnection) {
		super(parentShell);
		setShellStyle(SWT.APPLICATION_MODAL);
		this.type = type;
		this.editingDomain = editingDomain;
		this.managedConnection = managedConnection;
	}
	
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		if (type == Type.CREATE) {
			newShell.setText(Activator.getDefault().getString("ManagedConnectionDialog.Create.Title"));
		} else if (type == Type.CHANGE) {
			newShell.setText(Activator.getDefault().getString("ManagedConnectionDialog.Change.Title"));
		} else if (type == Type.COPY) {
			newShell.setText(Activator.getDefault().getString("ManagedConnectionDialog.Copy.Title"));
		}
	}
	
	public boolean testConnection() {
		try {
			JCoDestination destination = JCoDestinationManager.getDestination(managedConnection.getConnectionName());
			destination.ping();
			return true;
		} catch (JCoException e) {
			return false;
		}
	}
	
	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);

		if (type == Type.CREATE) {
			setTitle(Activator.getDefault().getString("ManagedConnectionDialog.Create.Title"));
		} else if (type == Type.CHANGE) {
			setTitle(Activator.getDefault().getString("ManagedConnectionDialog.Change.Title"));
			setMessage(Activator.getDefault().getString("ManagedConnectionDialog.Change.Title"));
		} else if (type == Type.COPY) {
			setTitle(Activator.getDefault().getString("ManagedConnectionDialog.Copy.Title"));
			setMessage(Activator.getDefault().getString("ManagedConnectionDialog.Copy.Title"));
		}
		
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
		
		final TabFolder tabFolder = new TabFolder(container, SWT.BORDER);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tabFolder.setLayout(new FillLayout());
		
		//
		// Authorization Tab
		//

		TabItem authTabItem = new TabItem(tabFolder, SWT.NONE);
		authTabItem.setText("Authentication");
		
		// Create scrolled composite to make tab contents to scroll.
		final ScrolledComposite authScrolledComposite = new ScrolledComposite(
				tabFolder, SWT.V_SCROLL);
		
		// Create container for actual connection pane content.
		final Composite authContainer = new Composite(authScrolledComposite, SWT.NONE);
		authContainer.setLayout(new GridLayout(2, false));
		authScrolledComposite.setContent(authContainer);

		// Set container as content of scrolled composite.
		authTabItem.setControl(authScrolledComposite);
		
		Label authTypeLbl = new Label(authContainer, SWT.NONE);
		authTypeLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		authTypeLbl.setText("SAP Authentication Type : ");
		
		authTypeCombo = new Combo(authContainer, SWT.READ_ONLY);
		authTypeCombo.setToolTipText("Authentication type used by the destination. Known types are\n \nCONFIGURED_USER - the destination configured for the specified user only. All connections opened via this destination belongs to the same user. This value is used in default case, if this property is missing.\n \nCURRENT_USER - the connection created using this destination belongs to the current user. Before the connection is opened the runtime check the property \"jco.client.current_user\" in order to get the current user name.\nNote:This type is supported in SAP NetWeaver AS only\n \nNote:This property is optional, default value is CONFIGURED_USER\n");
		authTypeCombo.setItems(new String[] {"CONFIGURED_USER", "CURRENT_USER"});
		authTypeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		authTypeCombo.select(0);
		
		Label clientLbl2 = new Label(authContainer, SWT.NONE);
		clientLbl2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		clientLbl2.setText("SAP Client : ");
		
		clientText2 = new Text(authContainer, SWT.BORDER);
		clientText2.setToolTipText("SAP client, mandatory logon parameter.");
		clientText2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label userLbl2 = new Label(authContainer, SWT.NONE);
		userLbl2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		userLbl2.setText("Logon User : ");
		
		userText2 = new Text(authContainer, SWT.BORDER);
		userText2.setToolTipText("Logon user, logon parameter for password based authentication.");
		userText2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label userAliasLbl = new Label(authContainer, SWT.NONE);
		userAliasLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		userAliasLbl.setText("Logon User Alias : ");
		
		userAlias = new Text(authContainer, SWT.BORDER);
		userAlias.setToolTipText("Logon user alias, can be used instead of logon user.");
		userAlias.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label passwordLbl2 = new Label(authContainer, SWT.NONE);
		passwordLbl2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		passwordLbl2.setAlignment(SWT.RIGHT);
		passwordLbl2.setText("Logon Password : ");
		
		passwordText2 = new Text(authContainer, SWT.BORDER | SWT.PASSWORD);
		passwordText2.setToolTipText("Logon password, logon parameter for password based authentication.");
		passwordText2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label mysapsso2Lbl = new Label(authContainer, SWT.NONE);
		mysapsso2Lbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		mysapsso2Lbl.setAlignment(SWT.RIGHT);
		mysapsso2Lbl.setText("SAP SSO Logon Ticket : ");
		
		mysapsso2Text = new Text(authContainer, SWT.BORDER);
		mysapsso2Text.setToolTipText("The SAP Cookie Version 2 used as logon ticket for SSO based authentication.");
		mysapsso2Text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label x509certLbl = new Label(authContainer, SWT.NONE);
		x509certLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		x509certLbl.setAlignment(SWT.RIGHT);
		x509certLbl.setText("SAP X509 Login Ticket : ");
		
		x509certText = new Text(authContainer, SWT.BORDER);
		x509certText.setToolTipText("The X509 certificate used for certificate based authentication");
		x509certText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label languageLbl2 = new Label(authContainer, SWT.NONE);
		languageLbl2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		languageLbl2.setAlignment(SWT.RIGHT);
		languageLbl2.setText("Logon Language : ");
		
		languageText2 = new Text(authContainer, SWT.BORDER);
		languageText2.setToolTipText("Logon language, if not defined the default user language is used.");
		languageText2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		// Set size
		authScrolledComposite.setExpandHorizontal(true);
		Point point = authContainer.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		authContainer.setSize(point);
		authScrolledComposite.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				authContainer.setSize(authContainer.computeSize(SWT.DEFAULT, SWT.DEFAULT));
				authContainer.layout();
			}
		});
		
		//
		// Special Tab
		//
		
		TabItem specialTabItem = new TabItem(tabFolder, SWT.NONE);
		specialTabItem.setText("Special");
		
		// Create scrolled composite to make tab contents to scroll.
		final ScrolledComposite specialScrolledComposite = new ScrolledComposite(
				tabFolder, SWT.V_SCROLL);
		
		// Create container for actual connection pane content.
		final Composite specialContainer = new Composite(specialScrolledComposite, SWT.NONE);
		specialContainer.setLayout(new GridLayout(2, false));
		specialScrolledComposite.setContent(specialContainer);

		// Set container as content of scrolled composite.
		specialTabItem.setControl(specialScrolledComposite);
		
		traceBtn = new Button(specialContainer, SWT.CHECK);
		traceBtn.setToolTipText("Enable/disable RFC trace");
		traceBtn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		traceBtn.setText("Enable RFC Trace?");
		
		Label cpicTraceLbl = new Label(specialContainer, SWT.NONE);
		cpicTraceLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		cpicTraceLbl.setAlignment(SWT.RIGHT);
		cpicTraceLbl.setText("Select CPIC Trace : ");
		
		cpicTraceCombo = new Combo(specialContainer, SWT.READ_ONLY);
		cpicTraceCombo.setToolTipText("Enable/disable CPIC trace");
		cpicTraceCombo.setItems(new String[] {"", "Trace Level 0: No Trace", "Trace Level 1: Only Errors are Logged", "Trace Level 2: Flow and Basic Data Trace", "Trace Level 3: Flow and Complete Data Trace"});
		cpicTraceCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		cpicTraceCombo.select(0);
		
		lcheckBtn = new Button(specialContainer, SWT.CHECK);
		lcheckBtn.setToolTipText("Enable/Disable logon check at open time.\n \nWhen enabled, postpones the authentication until the first call.\n \nUsed in special cases only.\n");
		lcheckBtn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		lcheckBtn.setText("Enable Logon Check?");
		
		Label codepageLbl = new Label(specialContainer, SWT.NONE);
		codepageLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		codepageLbl.setAlignment(SWT.RIGHT);
		codepageLbl.setText("Initial Codepage : ");
		
		codepageText = new Text(specialContainer, SWT.BORDER);
		codepageText.setToolTipText("Initial codepage in SAP notation.\n \nAdditional logon parameter to define the codepage that will used to convert the logon parameters.\n \nUsed in special cases only.\n");
		codepageText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		getsso2Btn = new Button(specialContainer, SWT.CHECK);
		getsso2Btn.setToolTipText("Get/Don't get a SSO ticket after logon.\n \nWhen enabled, order an SSO ticket after logon. The obtained ticket is then available in the connection attributes.\n");
		getsso2Btn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		getsso2Btn.setText("Reqeust SSO Ticket?");
		
		denyInitialPasswordBtn = new Button(specialContainer, SWT.CHECK);
		denyInitialPasswordBtn.setToolTipText("Deny usage of initial passwords (disabled by default).\n \nIf enabled, using initial passwords will lead to an exception.\n");
		denyInitialPasswordBtn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		denyInitialPasswordBtn.setText("Deny Use of Initial Passwords?");
		
		// Set size
		specialScrolledComposite.setExpandHorizontal(true);
		point = specialContainer.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		specialContainer.setSize(point);
		specialScrolledComposite.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				specialContainer.setSize(specialContainer.computeSize(SWT.DEFAULT, SWT.DEFAULT));
				specialContainer.layout();
			}
		});
		
		//
		// SNC Tab
		//
		
		TabItem sncTabItem = new TabItem(tabFolder, SWT.NONE);
		sncTabItem.setText("SNC");
		
		// Create scrolled composite to make tab contents to scroll.
		final ScrolledComposite sncScrolledComposite = new ScrolledComposite(
				tabFolder, SWT.V_SCROLL);
		
		// Create container for actual connection pane content.
		final Composite sncContainer = new Composite(sncScrolledComposite, SWT.NONE);
		sncContainer.setLayout(new GridLayout(2, false));
		sncScrolledComposite.setContent(sncContainer);

		// Set container as content of scrolled composite.
		sncTabItem.setControl(sncScrolledComposite);
		
		sncModeBtn = new Button(sncContainer, SWT.CHECK);
		sncModeBtn.setToolTipText("Enables secure network connection (SNC) mode.");
		sncModeBtn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		sncModeBtn.setText("Turn On SNC Mode?");
		
		Label sncPartnernameLbl = new Label(sncContainer, SWT.NONE);
		sncPartnernameLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		sncPartnernameLbl.setAlignment(SWT.RIGHT);
		sncPartnernameLbl.setText("SNC Partner Name : ");
		
		sncPartnernameText = new Text(sncContainer, SWT.BORDER);
		sncPartnernameText.setToolTipText("SNC partner, e.g. p:CN=R3, O=XYZ-INC, C=EN");
		sncPartnernameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label sncQopLbl = new Label(sncContainer, SWT.NONE);
		sncQopLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		sncQopLbl.setAlignment(SWT.RIGHT);
		sncQopLbl.setText("SNC Level of Security : ");
		
		sncQopCombo = new Combo(sncContainer, SWT.READ_ONLY);
		sncQopCombo.setToolTipText("SNC level of security,");
		sncQopCombo.setItems(new String[] {"", "Security Level 1: Secure Authentication Only", "Security Level 2: Data Integrity Protection", "Security Level 3: Data Privacy Protection", "Security Level 8: Default Protection", "Security Level 9: Maximum Protection"});
		sncQopCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		sncQopCombo.select(0);

		Label sncMynameLbl = new Label(sncContainer, SWT.NONE);
		sncMynameLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		sncMynameLbl.setAlignment(SWT.RIGHT);
		sncMynameLbl.setText("SNC Name : ");
		
		sncMynameText = new Text(sncContainer, SWT.BORDER);
		sncMynameText.setToolTipText("SNC name.\n\nOverrides default SNC partner.");
		sncMynameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label sncLibLbl = new Label(sncContainer, SWT.NONE);
		sncLibLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		sncLibLbl.setAlignment(SWT.RIGHT);
		sncLibLbl.setText("SNC Library Path : ");
		
		sncLibraryText = new Text(sncContainer, SWT.BORDER);
		sncLibraryText.setToolTipText("Path to library which provides SNC service.");
		sncLibraryText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		// Set size
		sncScrolledComposite.setExpandHorizontal(true);
		point = sncContainer.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		sncContainer.setSize(point);
		sncScrolledComposite.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				sncContainer.setSize(sncContainer.computeSize(SWT.DEFAULT, SWT.DEFAULT));
				sncContainer.layout();
			}
		});
		
		Button testConnectionBtn = new Button(container, SWT.NONE);
		testConnectionBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (testConnection()) {
					setMessage("Connection Test Succeeded");
				} else {
					setMessage("Connection Test Failed");
				}
			}
		});
		testConnectionBtn.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		testConnectionBtn.setAlignment(SWT.RIGHT);
		testConnectionBtn.setText("Test Connection");

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
		initDataBindings();

		ControlDecorationSupport.create(clientBinding2, SWT.TOP | SWT.LEFT);
		ControlDecorationSupport.create(langBinding2, SWT.TOP | SWT.LEFT);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 409);
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextAuthTypeComboObserveWidget = WidgetProperties.text().observe(authTypeCombo);
		IObservableValue managedConnectionFactoryAuthTypeObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__AUTH_TYPE)).observe(managedConnection);
		bindingContext.bindValue(observeTextAuthTypeComboObserveWidget, managedConnectionFactoryAuthTypeObserveValue, null, null);
		//
		IObservableValue observeTextClientText2ObserveWidget = WidgetProperties.text(SWT.Modify).observe(clientText2);
		IObservableValue managedConnectionFactoryClientObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__CLIENT)).observe(managedConnection);
		UpdateValueStrategy clientStrategy2 = new UpdateValueStrategy();
		clientStrategy2.setBeforeSetValidator(new ClientNumberValidator());
		clientBinding2 = bindingContext.bindValue(observeTextClientText2ObserveWidget, managedConnectionFactoryClientObserveValue, clientStrategy2, null);
		//
		IObservableValue observeTextUserText2ObserveWidget = WidgetProperties.text(SWT.Modify).observe(userText2);
		IObservableValue managedConnectionFactoryUserObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__USER)).observe(managedConnection);
		bindingContext.bindValue(observeTextUserText2ObserveWidget, managedConnectionFactoryUserObserveValue, null, null);
		//
		IObservableValue observeTextUserAliasObserveWidget = WidgetProperties.text(SWT.Modify).observe(userAlias);
		IObservableValue managedConnectionFactoryAliasUserObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__ALIAS_USER)).observe(managedConnection);
		bindingContext.bindValue(observeTextUserAliasObserveWidget, managedConnectionFactoryAliasUserObserveValue, null, null);
		//
		IObservableValue observeTextPasswordText2ObserveWidget = WidgetProperties.text(SWT.Modify).observe(passwordText2);
		IObservableValue managedConnectionFactoryPasswordObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__PASSWORD)).observe(managedConnection);
		bindingContext.bindValue(observeTextPasswordText2ObserveWidget, managedConnectionFactoryPasswordObserveValue, null, null);
		//
		IObservableValue observeTextMysapsso2TextObserveWidget = WidgetProperties.text(SWT.Modify).observe(mysapsso2Text);
		IObservableValue managedConnectionFactoryMysapsso2ObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__MYSAPSSO2)).observe(managedConnection);
		bindingContext.bindValue(observeTextMysapsso2TextObserveWidget, managedConnectionFactoryMysapsso2ObserveValue, null, null);
		//
		IObservableValue observeTextX509certTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(x509certText);
		IObservableValue managedConnectionFactoryX509certObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__X509CERT)).observe(managedConnection);
		bindingContext.bindValue(observeTextX509certTextObserveWidget, managedConnectionFactoryX509certObserveValue, null, null);
		//
		IObservableValue observeTextLanguageText2ObserveWidget = WidgetProperties.text(SWT.Modify).observe(languageText2);
		IObservableValue managedConnectionFactoryLangObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__LANG)).observe(managedConnection);
		UpdateValueStrategy strategy_3 = new UpdateValueStrategy();
		strategy_3.setBeforeSetValidator(new LanguageValidator());
		langBinding2 = bindingContext.bindValue(observeTextLanguageText2ObserveWidget, managedConnectionFactoryLangObserveValue, strategy_3, null);
		//
		IObservableValue observeSelectionTraceBtnObserveWidget = WidgetProperties.selection().observe(traceBtn);
		IObservableValue managedConnectionFactoryTraceObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__TRACE)).observe(managedConnection);
		UpdateValueStrategy traceStrategy = new UpdateValueStrategy();
		traceStrategy.setConverter(new Boolean2StringConverter());
		bindingContext.bindValue(observeSelectionTraceBtnObserveWidget, managedConnectionFactoryTraceObserveValue, traceStrategy, null);
		//
		IObservableValue observeSelectionCpicTraceComboObserveWidget = WidgetProperties.singleSelectionIndex().observe(cpicTraceCombo);
		IObservableValue managedConnectionFactoryCpicTraceObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__CPIC_TRACE)).observe(managedConnection);
		UpdateValueStrategy strategy_4 = new UpdateValueStrategy();
		strategy_4.setConverter(new CpicTraceComboSelection2TraceLevelConverter());
		bindingContext.bindValue(observeSelectionCpicTraceComboObserveWidget, managedConnectionFactoryCpicTraceObserveValue, strategy_4, null);
		//
		IObservableValue observeSelectionLcheckBtnObserveWidget = WidgetProperties.selection().observe(lcheckBtn);
		IObservableValue managedConnectionFactoryLcheckObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__LCHECK)).observe(managedConnection);
		UpdateValueStrategy strategy_5 = new UpdateValueStrategy();
		strategy_5.setConverter(new Boolean2StringConverter());
		bindingContext.bindValue(observeSelectionLcheckBtnObserveWidget, managedConnectionFactoryLcheckObserveValue, strategy_5, null);
		//
		IObservableValue observeTextCodepageTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(codepageText);
		IObservableValue managedConnectionFactoryCodepageObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__CODEPAGE)).observe(managedConnection);
		bindingContext.bindValue(observeTextCodepageTextObserveWidget, managedConnectionFactoryCodepageObserveValue, null, null);
		//
		IObservableValue observeSelectionGetsso2BtnObserveWidget = WidgetProperties.selection().observe(getsso2Btn);
		IObservableValue managedConnectionFactoryGetsso2ObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__GETSSO2)).observe(managedConnection);
		UpdateValueStrategy strategy_6 = new UpdateValueStrategy();
		strategy_6.setConverter(new Boolean2StringConverter());
		bindingContext.bindValue(observeSelectionGetsso2BtnObserveWidget, managedConnectionFactoryGetsso2ObserveValue, strategy_6, null);
		//
		IObservableValue observeSelectionDenyInitialPasswordBtnObserveWidget = WidgetProperties.selection().observe(denyInitialPasswordBtn);
		IObservableValue managedConnectionFactoryDenyInitialPasswordObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__DENY_INITIAL_PASSWORD)).observe(managedConnection);
		UpdateValueStrategy strategy_7 = new UpdateValueStrategy();
		strategy_7.setConverter(new Boolean2StringConverter());
		bindingContext.bindValue(observeSelectionDenyInitialPasswordBtnObserveWidget, managedConnectionFactoryDenyInitialPasswordObserveValue, strategy_7, null);
		//
		IObservableValue observeSelectionSncModeBtnObserveWidget = WidgetProperties.selection().observe(sncModeBtn);
		IObservableValue managedConnectionFactorySncModeObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__SNC_MODE)).observe(managedConnection);
		UpdateValueStrategy strategy_13 = new UpdateValueStrategy();
		strategy_13.setConverter(new Boolean2StringConverter());
		bindingContext.bindValue(observeSelectionSncModeBtnObserveWidget, managedConnectionFactorySncModeObserveValue, strategy_13, null);
		//
		IObservableValue observeTextSncPartnernameTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(sncPartnernameText);
		IObservableValue managedConnectionFactorySncPartnernameObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__SNC_PARTNERNAME)).observe(managedConnection);
		bindingContext.bindValue(observeTextSncPartnernameTextObserveWidget, managedConnectionFactorySncPartnernameObserveValue, null, null);
		//
		IObservableValue observeSingleSelectionIndexSncQopComboObserveWidget = WidgetProperties.singleSelectionIndex().observe(sncQopCombo);
		IObservableValue managedConnectionFactorySncQopObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__SNC_QOP)).observe(managedConnection);
		UpdateValueStrategy strategy_14 = new UpdateValueStrategy();
		strategy_14.setConverter(new SncQosComboSelection2SncQosConverter());
		bindingContext.bindValue(observeSingleSelectionIndexSncQopComboObserveWidget, managedConnectionFactorySncQopObserveValue, strategy_14, null);
		//
		IObservableValue observeTextSncMynameTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(sncMynameText);
		IObservableValue managedConnectionFactorySncMynameObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__SNC_MYNAME)).observe(managedConnection);
		bindingContext.bindValue(observeTextSncMynameTextObserveWidget, managedConnectionFactorySncMynameObserveValue, null, null);
		//
		IObservableValue observeTextSncLibraryTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(sncLibraryText);
		IObservableValue managedConnectionFactorySncLibraryObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__SNC_LIBRARY)).observe(managedConnection);
		bindingContext.bindValue(observeTextSncLibraryTextObserveWidget, managedConnectionFactorySncLibraryObserveValue, null, null);
		
		return bindingContext;
	}
}
