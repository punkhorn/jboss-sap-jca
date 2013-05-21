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
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage.Literals;
import org.jboss.jca.adapters.sap.ui.Activator;
import org.jboss.jca.adapters.sap.ui.converter.Boolean2StringConverter;
import org.jboss.jca.adapters.sap.ui.converter.CpicTraceComboSelection2TraceLevelConverter;
import org.jboss.jca.adapters.sap.ui.converter.SncQosComboSelection2SncQosConverter;
import org.jboss.jca.adapters.sap.ui.validator.ClientNumberValidator;
import org.jboss.jca.adapters.sap.ui.validator.LanguageValidator;
import org.jboss.jca.adapters.sap.ui.validator.NonNegativeIntegerValidator;
import org.jboss.jca.adapters.sap.ui.validator.SapRouterStringValidator;
import org.jboss.jca.adapters.sap.ui.validator.SystemNumberValidator;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;

public class ManagedConnectionFactoryDialog extends TitleAreaDialog {
	private Binding maxGetTimeBinding;
	private Binding expirationPeriodBinding;
	private Binding expirationTimeBinding;
	private Binding poolCapacityBinding;
	private Binding peakLimitBinding;
	private Binding langBinding2;
	private Binding clientBinding2;
	private Binding saprouterBinding;
	private Binding sysnrBinding2;
	private Binding clientBinding;
	private Binding sysnrBinding;
	
	public enum Type {
		CREATE, CHANGE, COPY
	}

    private Type type;
	private Text ashostText;
	private Text clientText;
	private Text userText;
	private Text passwordText;
	private Text languageText;
	private Text sysnrText;
	
	private ManagedConnectionFactory managedConnectionFactory;
	private EditingDomain editingDomain;
	
	private Text sysnrText2;
	private Text saprouterText;
	private Text ashostText2;
	private Text mshostText;
	private Text msservText;
	private Text gwhostText;
	private Text gwservText;
	private Text r3nameText;
	private Text groupText;
	private Text clientText2;
	private Text userAlias;
	private Text userText2;
	private Text passwordText2;
	private Text languageText2;
	private Control mysapsso2Text;
	private Control x509certText;
	private Combo authTypeCombo;
	private Combo cpicTraceCombo;
	private Text codepageText;
	private Text peakLimitText;
	private Text poolCapacityText;
	private Control expirationTimeText;
	private Text expirationCheckPeriodText;
	private Text maxGetClientTimeText;
	private Button traceBtn;
	private Button lcheckBtn;
	private Button getsso2Btn;
	private Button denyInitialPasswordBtn;
	private Button sncModeBtn;
	private Text sncPartnernameText;
	private Combo sncQopCombo;
	private Control sncMynameText;
	private Text sncLibraryText;
	private Control repositoryDestinationText;
	private Text repositoryUserText;
	private Control repositoryPasswordText;
	private Button respositorySncBtn;
	private Button repositoryRoundtripOptimizationBtn;
	private Binding langBinding;
	private Label saprouterLbl;
	private Label ashostLbl2;
	private Label clientLbl2;
	private Label repositoryDestinationLbl;
	private Label repositoryUserLbl;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public ManagedConnectionFactoryDialog(Shell parentShell, Type type, EditingDomain editingDomain, ManagedConnectionFactory managedConnectionFactory) {
		super(parentShell);
		setShellStyle(SWT.APPLICATION_MODAL);
		this.type = type;
		this.editingDomain = editingDomain;
		this.managedConnectionFactory = managedConnectionFactory;
	}
	
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		if (type == Type.CREATE) {
			newShell.setText(Activator.getDefault().getString("ManagedConnectionFactoryDialog.Create.Title"));
		} else if (type == Type.CHANGE) {
			newShell.setText(Activator.getDefault().getString("ManagedConnectionFactoryDialog.Change.Title"));
		} else if (type == Type.COPY) {
			newShell.setText(Activator.getDefault().getString("ManagedConnectionFactoryDialog.Copy.Title"));
		}
	}
	
	public boolean testConnection() {
		try {
			JCoDestination destination = JCoDestinationManager.getDestination(managedConnectionFactory.getDefaultConnectionName());
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
			setTitle(Activator.getDefault().getString("ManagedConnectionFactoryDialog.Create.Title"));
		} else if (type == Type.CHANGE) {
			setTitle(Activator.getDefault().getString("ManagedConnectionFactoryDialog.Change.Title"));
			setMessage(Activator.getDefault().getString("ManagedConnectionFactoryDialog.Change.Title"));
		} else if (type == Type.COPY) {
			setTitle(Activator.getDefault().getString("ManagedConnectionFactoryDialog.Copy.Title"));
			setMessage(Activator.getDefault().getString("ManagedConnectionFactoryDialog.Copy.Title"));
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
		// Basic Tab
		//
		
		TabItem basicTabItem = new TabItem(tabFolder, SWT.NONE);
		basicTabItem.setText("Basic");
		
		Composite basicContainer = new Composite(tabFolder, SWT.NONE);
		basicTabItem.setControl(basicContainer);
		basicContainer.setLayout(new GridLayout(2, false));
		
		Label ashostLbl = new Label(basicContainer, SWT.NONE);
		ashostLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		ashostLbl.setAlignment(SWT.RIGHT);
		ashostLbl.setText("SAP Application Server : ");
		
		ashostText = new Text(basicContainer, SWT.BORDER);
		ashostText.setToolTipText("SAP ABAP application server, mandatory for a direct connection.");
		ashostText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label systemNumberLbl = new Label(basicContainer, SWT.NONE);
		systemNumberLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		systemNumberLbl.setText("SAP System Number : ");
		
		sysnrText = new Text(basicContainer, SWT.BORDER);
		sysnrText.setToolTipText("System number of the SAP ABAP application server, mandatory for a direct connection.");
		sysnrText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label clientLbl = new Label(basicContainer, SWT.NONE);
		clientLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		clientLbl.setAlignment(SWT.RIGHT);
		clientLbl.setText("SAP Client : ");
		
		clientText = new Text(basicContainer, SWT.BORDER);
		clientText.setToolTipText("SAP client, mandatory logon parameter.");
		clientText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label userLbl = new Label(basicContainer, SWT.NONE);
		userLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		userLbl.setAlignment(SWT.RIGHT);
		userLbl.setText("Logon User : ");
		
		userText = new Text(basicContainer, SWT.BORDER);
		userText.setToolTipText("Logon user, logon parameter for password based authentication.");
		userText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label passwordLbl = new Label(basicContainer, SWT.NONE);
		passwordLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		passwordLbl.setAlignment(SWT.RIGHT);
		passwordLbl.setText("Logon Password : ");
		
		passwordText = new Text(basicContainer, SWT.BORDER | SWT.PASSWORD);
		passwordText.setToolTipText("Logon password, logon parameter for password based authentication.");
		passwordText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label languageLbl = new Label(basicContainer, SWT.NONE);
		languageLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		languageLbl.setAlignment(SWT.RIGHT);
		languageLbl.setText("Logon Language : ");
		
		languageText = new Text(basicContainer, SWT.BORDER);
		languageText.setToolTipText("Logon language, if not defined the default user language is used.");
		languageText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(basicContainer, SWT.NONE);
		new Label(basicContainer, SWT.NONE);
		
		//
		// Connect Tab
		//

		// Create tab item for connection pane.
		TabItem connectTabItem = new TabItem(tabFolder, SWT.NONE);
		connectTabItem.setText("Connection");
		
		// Create scrolled composite to make tab contents to scroll.
		final ScrolledComposite connectScrolledComposite = new ScrolledComposite(
				tabFolder, SWT.V_SCROLL);
		
		// Create container for actual connection pane content.
		final Composite connectContainer = new Composite(connectScrolledComposite, SWT.NONE);
		connectContainer.setLayout(new GridLayout(2, false));
		connectScrolledComposite.setContent(connectContainer);

		// Set container as content of scrolled composite.
		connectTabItem.setControl(connectScrolledComposite);
		
		Label sysnrLbl2 = new Label(connectContainer, SWT.NONE);
		sysnrLbl2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		sysnrLbl2.setAlignment(SWT.RIGHT);
		sysnrLbl2.setText("SAP System Number : ");
		
		sysnrText2 = new Text(connectContainer, SWT.BORDER);
		sysnrText2.setToolTipText("System number of the SAP ABAP application server, mandatory for a direct connection.");
		sysnrText2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		saprouterLbl = new Label(connectContainer, SWT.NONE);
		saprouterLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		saprouterLbl.setText("SAP Router String : ");
		
		saprouterText = new Text(connectContainer, SWT.BORDER);
		saprouterText.setToolTipText("SAP Router string for connection to systems behind a SAP Router.\n\nSAP Router string contains the chain of SAP Routers and its port numbers and has the form:\n\n(/H/<host>[/S/<port>])+\n");
		saprouterText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		ashostLbl2 = new Label(connectContainer, SWT.NONE);
		ashostLbl2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		ashostLbl2.setText("SAP Application Server : ");
		
		ashostText2 = new Text(connectContainer, SWT.BORDER);
		ashostText2.setToolTipText("SAP ABAP application server, mandatory for a direct connection.");
		ashostText2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label mshostLbl = new Label(connectContainer, SWT.NONE);
		mshostLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		mshostLbl.setText("SAP Message Server : ");
		
		mshostText = new Text(connectContainer, SWT.BORDER);
		mshostText.setToolTipText("SAP message server port, optional property for a load balancing connection.\n\nIn order to resolve the service names sapmsXXX a lookup in etc/services is performed by the network layer of the operating system. If using port numbers instead of symbolic service names, no lookups are performed and no additional entries are needed.\n");
		mshostText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label msservLbl = new Label(connectContainer, SWT.NONE);
		msservLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		msservLbl.setText("SAP Message Server Port : ");
		
		msservText = new Text(connectContainer, SWT.BORDER);
		msservText.setToolTipText("SAP message server port, optional property for a load balancing connection.\n \nIn order to resolve the service names sapmsXXX a lookup in etc/services is performed by the network layer of the operating system. If using port numbers instead of symbolic service names, no lookups are performed and no additional entries are needed.\n");
		msservText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label gwhostLbl = new Label(connectContainer, SWT.NONE);
		gwhostLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		gwhostLbl.setText("Gateway Host : ");
		
		gwhostText = new Text(connectContainer, SWT.BORDER);
		gwhostText.setToolTipText("Allows specifying a concrete gateway, which should be used for establishing the connection to an application server.\n\nIf not specified the gateway on the application server is used.\n");
		gwhostText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label gwservLbl = new Label(connectContainer, SWT.NONE);
		gwservLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		gwservLbl.setText("Gateway Port : ");
		
		gwservText = new Text(connectContainer, SWT.BORDER);
		gwservText.setToolTipText("Gateway server port.\n \nShould be set, when setting Gateway Host.\n\nAllows specifying the port used on that gateway. If not specified the port of the gateway on the application server is used.\n\nIn order to resolve the service names sapgwXXX a lookup in etc/services is performed by the network layer of the operating system. If using port numbers instead of symbolic service names, no lookups are performed and no additional entries are needed.\n");
		gwservText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label r3nameLbl = new Label(connectContainer, SWT.NONE);
		r3nameLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		r3nameLbl.setText("SAP System ID : ");
		
		r3nameText = new Text(connectContainer, SWT.BORDER);
		r3nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label groupLbl = new Label(connectContainer, SWT.NONE);
		groupLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		groupLbl.setText("SAP Application Server Group : ");
		
		groupText = new Text(connectContainer, SWT.BORDER);
		groupText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		// Set size
		connectScrolledComposite.setExpandHorizontal(true);
		Point point = connectContainer.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		connectContainer.setSize(point);
		connectScrolledComposite.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				connectContainer.setSize(connectContainer.computeSize(SWT.DEFAULT, SWT.DEFAULT));
				connectContainer.layout();
			}
		});


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
		
		clientLbl2 = new Label(authContainer, SWT.NONE);
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
		point = authContainer.computeSize(SWT.DEFAULT, SWT.DEFAULT);
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
		// Pool Tab
		//
		
		TabItem poolTabItem = new TabItem(tabFolder, SWT.NONE);
		poolTabItem.setText("Pool");
		
		// Create scrolled composite to make tab contents to scroll.
		final ScrolledComposite poolScrolledComposite = new ScrolledComposite(
				tabFolder, SWT.V_SCROLL);
		
		// Create container for actual connection pane content.
		final Composite poolContainer = new Composite(poolScrolledComposite, SWT.NONE);
		poolContainer.setLayout(new GridLayout(2, false));
		poolScrolledComposite.setContent(poolContainer);

		// Set container as content of scrolled composite.
		poolTabItem.setControl(poolScrolledComposite);
		
		Label peakLimitLbl = new Label(poolContainer, SWT.NONE);
		peakLimitLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		peakLimitLbl.setAlignment(SWT.RIGHT);
		peakLimitLbl.setText("Connection Pool Peak Limit : ");
		
		peakLimitText = new Text(poolContainer, SWT.BORDER);
		peakLimitText.setToolTipText("Maximum number of active connections that can be created for a destination simultaneously.\n \nA value of 0 allows an unlimited number of active connections, otherwise if the value is less than the value of the Connection Pool Capacity, it will be automatically increased to this value.\n \nDefault setting is the value of the Connection Pool Capacity, or in case of the Connection Pool Capacity not being specified as well, the default is 0 (unlimited).\n");
		peakLimitText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label poolCapacityLbl = new Label(poolContainer, SWT.NONE);
		poolCapacityLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		poolCapacityLbl.setAlignment(SWT.RIGHT);
		poolCapacityLbl.setText("Connection Pool Capacity : ");
		
		poolCapacityText = new Text(poolContainer, SWT.BORDER);
		poolCapacityText.setToolTipText("Maximum number of idle connections kept open by the destination. A value of 0 has the effect that there is no connection pooling, i.e. connections will be closed after each request.\n \nA value of 0 has the effect that there is no connection pooling (default=1)\n");
		poolCapacityText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label expirationTimeLbl = new Label(poolContainer, SWT.NONE);
		expirationTimeLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		expirationTimeLbl.setAlignment(SWT.RIGHT);
		expirationTimeLbl.setText("Connection Pool Expiration Time : ");
		
		expirationTimeText = new Text(poolContainer, SWT.BORDER);
		expirationTimeText.setToolTipText("Time in ms after that a free connections hold internally by the destination can be closed.");
		expirationTimeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label expirationCheckPeriodLbl = new Label(poolContainer, SWT.NONE);
		expirationCheckPeriodLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		expirationCheckPeriodLbl.setAlignment(SWT.RIGHT);
		expirationCheckPeriodLbl.setText("Connection Pool Expiration Check Period : ");
		
		expirationCheckPeriodText = new Text(poolContainer, SWT.BORDER);
		expirationCheckPeriodText.setToolTipText("Interval in ms after which the connections in the pool will be checked for expiration.");
		expirationCheckPeriodText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label maxGetClientTimeLbl = new Label(poolContainer, SWT.NONE);
		maxGetClientTimeLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		maxGetClientTimeLbl.setAlignment(SWT.RIGHT);
		maxGetClientTimeLbl.setText("Connection Pool Max Get Client Time : ");
		
		maxGetClientTimeText = new Text(poolContainer, SWT.BORDER);
		maxGetClientTimeText.setToolTipText("Max time in ms to wait for a connection, if the max allowed number of connections is allocated by the destination's configuration");
		maxGetClientTimeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		// Set size
		poolScrolledComposite.setExpandHorizontal(true);
		point = poolContainer.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		poolContainer.setSize(point);
		poolScrolledComposite.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				poolContainer.setSize(poolContainer.computeSize(SWT.DEFAULT, SWT.DEFAULT));
				poolContainer.layout();
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
		
		//
		// Repository Tab
		//
		
		TabItem repositoryTabItem = new TabItem(tabFolder, SWT.NONE);
		repositoryTabItem.setText("Repository");
		
		// Create scrolled composite to make tab contents to scroll.
		final ScrolledComposite repositoryScrolledComposite = new ScrolledComposite(
				tabFolder, SWT.V_SCROLL);
		
		// Create container for actual connection pane content.
		final Composite repositoryContainer = new Composite(repositoryScrolledComposite, SWT.NONE);
		repositoryContainer.setLayout(new GridLayout(2, false));
		repositoryScrolledComposite.setContent(repositoryContainer);

		// Set container as content of scrolled composite.
		repositoryTabItem.setControl(repositoryScrolledComposite);
		
		repositoryDestinationLbl = new Label(repositoryContainer, SWT.NONE);
		repositoryDestinationLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		repositoryDestinationLbl.setAlignment(SWT.RIGHT);
		repositoryDestinationLbl.setText("Repository Destination : ");
		
		repositoryDestinationText = new Text(repositoryContainer, SWT.BORDER);
		repositoryDestinationText.setToolTipText("Specifies which destination should be used as the repository, i.e. use this destination's repository.");
		repositoryDestinationText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		repositoryUserLbl = new Label(repositoryContainer, SWT.NONE);
		repositoryUserLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		repositoryUserLbl.setAlignment(SWT.RIGHT);
		repositoryUserLbl.setText("Repository Logon User : ");
		
		repositoryUserText = new Text(repositoryContainer, SWT.BORDER);
		repositoryUserText.setToolTipText("User to use for repository calls.\n \nOptional: If repository destination is not set, and this property is set, it will be used as user for repository queries. This allows using a different user for repository lookups and restrict the permissions accordingly.\n");
		repositoryUserText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label repositoryPasswordLbl = new Label(repositoryContainer, SWT.NONE);
		repositoryPasswordLbl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		repositoryPasswordLbl.setAlignment(SWT.RIGHT);
		repositoryPasswordLbl.setText("Repository Logon Password : ");
		
		repositoryPasswordText = new Text(repositoryContainer, SWT.BORDER | SWT.PASSWORD);
		repositoryPasswordText.setToolTipText("The password for a repository user. Mandatory, if a repository user should be used.");
		repositoryPasswordText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		respositorySncBtn = new Button(repositoryContainer, SWT.CHECK);
		respositorySncBtn.setToolTipText("Enable SNC for the repository destination.\n \nOptional: It is possible to turn it off for repository connections, if this property is disabled.\n \nDefault setting is the value of SNC Mode. For special cases only.\n");
		respositorySncBtn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		respositorySncBtn.setText("Turn On SNC Mode for Repository Destination?");
		
		repositoryRoundtripOptimizationBtn = new Button(repositoryContainer, SWT.CHECK);
		repositoryRoundtripOptimizationBtn.setToolTipText("Enables the use of the RFC_METADATA_GET API, which provides repository data in one single roundtrip.\n \nEnabling this property forces the use of the RFC_METADATA_GET API in the connected ABAP System. Disabling this property deactivates the use of the RFC_METADATA_GET API.\n \nIf the property is disabled, the destination will initially do a remote call to check whether RFC_METADATA_GET is available. In case it is available, it will use it.\n \nNote: If the repository is already initialized, for example because it is used by some other destination, this property does not have any effect. Generally, this property is related to the ABAP System, and should have the same value on all destinations pointing to the same ABAP System.\n");
		repositoryRoundtripOptimizationBtn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		repositoryRoundtripOptimizationBtn.setText("Use RFC_METADATA_GET?");
		
		// Set size
		repositoryScrolledComposite.setExpandHorizontal(true);
		point = repositoryContainer.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		repositoryContainer.setSize(point);
		repositoryScrolledComposite.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				repositoryContainer.setSize(repositoryContainer.computeSize(SWT.DEFAULT, SWT.DEFAULT));
				repositoryContainer.layout();
			}
		});

		//
		// Connection Test Button
		//
		
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
		ControlDecorationSupport.create(sysnrBinding, SWT.TOP | SWT.LEFT);
		ControlDecorationSupport.create(clientBinding, SWT.TOP | SWT.LEFT);
		ControlDecorationSupport.create(langBinding, SWT.TOP | SWT.LEFT);
		ControlDecorationSupport.create(sysnrBinding2, SWT.TOP | SWT.LEFT);
		ControlDecorationSupport.create(saprouterBinding, SWT.TOP | SWT.LEFT);
		ControlDecorationSupport.create(clientBinding2, SWT.TOP | SWT.LEFT);
		ControlDecorationSupport.create(langBinding2, SWT.TOP | SWT.LEFT);
		ControlDecorationSupport.create(peakLimitBinding, SWT.TOP | SWT.LEFT);
		ControlDecorationSupport.create(poolCapacityBinding, SWT.TOP | SWT.LEFT);
		ControlDecorationSupport.create(expirationTimeBinding, SWT.TOP | SWT.LEFT);
		ControlDecorationSupport.create(expirationPeriodBinding, SWT.TOP | SWT.LEFT);
		ControlDecorationSupport.create(maxGetTimeBinding, SWT.TOP | SWT.LEFT);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 439);
	}
	
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextAshostTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(ashostText);
		IObservableValue managedConnectionFactoryAshostObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__ASHOST)).observe(managedConnectionFactory);
		bindingContext.bindValue(observeTextAshostTextObserveWidget, managedConnectionFactoryAshostObserveValue, null, null);
		//
		IObservableValue observeTextSysnrTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(sysnrText);
		IObservableValue managedConnectionFactorySysnrObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__SYSNR)).observe(managedConnectionFactory);
		UpdateValueStrategy strategy_1 = new UpdateValueStrategy();
		strategy_1.setBeforeSetValidator(new SystemNumberValidator());
		sysnrBinding = bindingContext.bindValue(observeTextSysnrTextObserveWidget, managedConnectionFactorySysnrObserveValue, strategy_1, null);
		//
		IObservableValue observeTextClientTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(clientText);
		IObservableValue managedConnectionFactoryClientObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__CLIENT)).observe(managedConnectionFactory);
		UpdateValueStrategy strategy = new UpdateValueStrategy();
		strategy.setBeforeSetValidator(new ClientNumberValidator());
		clientBinding = bindingContext.bindValue(observeTextClientTextObserveWidget, managedConnectionFactoryClientObserveValue, strategy, null);
		//
		IObservableValue observeTextUserTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(userText);
		IObservableValue managedConnectionFactoryUserNameObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__USER_NAME)).observe(managedConnectionFactory);
		bindingContext.bindValue(observeTextUserTextObserveWidget, managedConnectionFactoryUserNameObserveValue, null, null);
		//
		IObservableValue observeTextPasswordTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(passwordText);
		IObservableValue managedConnectionFactoryPasswordObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__PASSWORD)).observe(managedConnectionFactory);
		bindingContext.bindValue(observeTextPasswordTextObserveWidget, managedConnectionFactoryPasswordObserveValue, null, null);
		//
		IObservableValue observeTextLanguageTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(languageText);
		IObservableValue managedConnectionFactoryLangObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__LANG)).observe(managedConnectionFactory);
		UpdateValueStrategy langStrategy = new UpdateValueStrategy();
		langStrategy.setBeforeSetValidator(new LanguageValidator());
		langBinding = bindingContext.bindValue(observeTextLanguageTextObserveWidget, managedConnectionFactoryLangObserveValue, langStrategy, null);
		//
		IObservableValue observeTextSysnrText2ObserveWidget = WidgetProperties.text(SWT.Modify).observe(sysnrText2);
		UpdateValueStrategy strategy_2 = new UpdateValueStrategy();
		strategy_2.setBeforeSetValidator(new SystemNumberValidator());
		sysnrBinding2 = bindingContext.bindValue(observeTextSysnrText2ObserveWidget, managedConnectionFactorySysnrObserveValue, strategy_2, null);
		//
		IObservableValue observeTextSaprouterTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(saprouterText);
		IObservableValue managedConnectionFactorySaprouterObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__SAPROUTER)).observe(managedConnectionFactory);
		UpdateValueStrategy saprouterStrategy = new UpdateValueStrategy();
		saprouterStrategy.setBeforeSetValidator(new SapRouterStringValidator());
		saprouterBinding = bindingContext.bindValue(observeTextSaprouterTextObserveWidget, managedConnectionFactorySaprouterObserveValue, saprouterStrategy, null);
		//
		IObservableValue observeTextAshostText2ObserveWidget = WidgetProperties.text(SWT.Modify).observe(ashostText2);
		bindingContext.bindValue(observeTextAshostText2ObserveWidget, managedConnectionFactoryAshostObserveValue, null, null);
		//
		IObservableValue observeTextMshostTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(mshostText);
		IObservableValue managedConnectionFactoryMshostObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__MSHOST)).observe(managedConnectionFactory);
		bindingContext.bindValue(observeTextMshostTextObserveWidget, managedConnectionFactoryMshostObserveValue, null, null);
		//
		IObservableValue observeTextMsservTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(msservText);
		IObservableValue managedConnectionFactoryMsservObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__MSSERV)).observe(managedConnectionFactory);
		bindingContext.bindValue(observeTextMsservTextObserveWidget, managedConnectionFactoryMsservObserveValue, null, null);
		//
		IObservableValue observeTextGwhostTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(gwhostText);
		IObservableValue managedConnectionFactoryGwhostObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__GWHOST)).observe(managedConnectionFactory);
		bindingContext.bindValue(observeTextGwhostTextObserveWidget, managedConnectionFactoryGwhostObserveValue, null, null);
		//
		IObservableValue observeTextGwservTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(gwservText);
		IObservableValue managedConnectionFactoryGwservObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__GWSERV)).observe(managedConnectionFactory);
		bindingContext.bindValue(observeTextGwservTextObserveWidget, managedConnectionFactoryGwservObserveValue, null, null);
		//
		IObservableValue observeTextR3nameTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(r3nameText);
		IObservableValue managedConnectionFactoryR3nameObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__R3NAME)).observe(managedConnectionFactory);
		bindingContext.bindValue(observeTextR3nameTextObserveWidget, managedConnectionFactoryR3nameObserveValue, null, null);
		//
		IObservableValue observeTextGroupTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(groupText);
		IObservableValue managedConnectionFactoryGroupObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__GROUP)).observe(managedConnectionFactory);
		bindingContext.bindValue(observeTextGroupTextObserveWidget, managedConnectionFactoryGroupObserveValue, null, null);
		//
		IObservableValue observeTextAuthTypeComboObserveWidget = WidgetProperties.text().observe(authTypeCombo);
		IObservableValue managedConnectionFactoryAuthTypeObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__AUTH_TYPE)).observe(managedConnectionFactory);
		bindingContext.bindValue(observeTextAuthTypeComboObserveWidget, managedConnectionFactoryAuthTypeObserveValue, null, null);
		//
		IObservableValue observeTextClientText2ObserveWidget = WidgetProperties.text(SWT.Modify).observe(clientText2);
		UpdateValueStrategy clientStrategy2 = new UpdateValueStrategy();
		clientStrategy2.setBeforeSetValidator(new ClientNumberValidator());
		clientBinding2 = bindingContext.bindValue(observeTextClientText2ObserveWidget, managedConnectionFactoryClientObserveValue, clientStrategy2, null);
		//
		IObservableValue observeTextUserText2ObserveWidget = WidgetProperties.text(SWT.Modify).observe(userText2);
		IObservableValue managedConnectionFactoryUserObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__USER)).observe(managedConnectionFactory);
		bindingContext.bindValue(observeTextUserText2ObserveWidget, managedConnectionFactoryUserObserveValue, null, null);
		//
		IObservableValue observeTextUserAliasObserveWidget = WidgetProperties.text(SWT.Modify).observe(userAlias);
		IObservableValue managedConnectionFactoryAliasUserObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__ALIAS_USER)).observe(managedConnectionFactory);
		bindingContext.bindValue(observeTextUserAliasObserveWidget, managedConnectionFactoryAliasUserObserveValue, null, null);
		//
		IObservableValue observeTextPasswordText2ObserveWidget = WidgetProperties.text(SWT.Modify).observe(passwordText2);
		bindingContext.bindValue(observeTextPasswordText2ObserveWidget, managedConnectionFactoryPasswordObserveValue, null, null);
		//
		IObservableValue observeTextMysapsso2TextObserveWidget = WidgetProperties.text(SWT.Modify).observe(mysapsso2Text);
		IObservableValue managedConnectionFactoryMysapsso2ObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__MYSAPSSO2)).observe(managedConnectionFactory);
		bindingContext.bindValue(observeTextMysapsso2TextObserveWidget, managedConnectionFactoryMysapsso2ObserveValue, null, null);
		//
		IObservableValue observeTextX509certTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(x509certText);
		IObservableValue managedConnectionFactoryX509certObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__X509CERT)).observe(managedConnectionFactory);
		bindingContext.bindValue(observeTextX509certTextObserveWidget, managedConnectionFactoryX509certObserveValue, null, null);
		//
		IObservableValue observeTextLanguageText2ObserveWidget = WidgetProperties.text(SWT.Modify).observe(languageText2);
		UpdateValueStrategy strategy_3 = new UpdateValueStrategy();
		strategy_3.setBeforeSetValidator(new LanguageValidator());
		langBinding2 = bindingContext.bindValue(observeTextLanguageText2ObserveWidget, managedConnectionFactoryLangObserveValue, strategy_3, null);
		//
		IObservableValue observeSelectionTraceBtnObserveWidget = WidgetProperties.selection().observe(traceBtn);
		IObservableValue managedConnectionFactoryTraceObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__TRACE)).observe(managedConnectionFactory);
		UpdateValueStrategy traceStrategy = new UpdateValueStrategy();
		traceStrategy.setConverter(new Boolean2StringConverter());
		bindingContext.bindValue(observeSelectionTraceBtnObserveWidget, managedConnectionFactoryTraceObserveValue, traceStrategy, null);
		//
		IObservableValue observeSelectionCpicTraceComboObserveWidget = WidgetProperties.singleSelectionIndex().observe(cpicTraceCombo);
		IObservableValue managedConnectionFactoryCpicTraceObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__CPIC_TRACE)).observe(managedConnectionFactory);
		UpdateValueStrategy strategy_4 = new UpdateValueStrategy();
		strategy_4.setConverter(new CpicTraceComboSelection2TraceLevelConverter());
		bindingContext.bindValue(observeSelectionCpicTraceComboObserveWidget, managedConnectionFactoryCpicTraceObserveValue, strategy_4, null);
		//
		IObservableValue observeSelectionLcheckBtnObserveWidget = WidgetProperties.selection().observe(lcheckBtn);
		IObservableValue managedConnectionFactoryLcheckObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__LCHECK)).observe(managedConnectionFactory);
		UpdateValueStrategy strategy_5 = new UpdateValueStrategy();
		strategy_5.setConverter(new Boolean2StringConverter());
		bindingContext.bindValue(observeSelectionLcheckBtnObserveWidget, managedConnectionFactoryLcheckObserveValue, strategy_5, null);
		//
		IObservableValue observeTextCodepageTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(codepageText);
		IObservableValue managedConnectionFactoryCodepageObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__CODEPAGE)).observe(managedConnectionFactory);
		bindingContext.bindValue(observeTextCodepageTextObserveWidget, managedConnectionFactoryCodepageObserveValue, null, null);
		//
		IObservableValue observeSelectionGetsso2BtnObserveWidget = WidgetProperties.selection().observe(getsso2Btn);
		IObservableValue managedConnectionFactoryGetsso2ObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__GETSSO2)).observe(managedConnectionFactory);
		UpdateValueStrategy strategy_6 = new UpdateValueStrategy();
		strategy_6.setConverter(new Boolean2StringConverter());
		bindingContext.bindValue(observeSelectionGetsso2BtnObserveWidget, managedConnectionFactoryGetsso2ObserveValue, strategy_6, null);
		//
		IObservableValue observeSelectionDenyInitialPasswordBtnObserveWidget = WidgetProperties.selection().observe(denyInitialPasswordBtn);
		IObservableValue managedConnectionFactoryDenyInitialPasswordObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__DENY_INITIAL_PASSWORD)).observe(managedConnectionFactory);
		UpdateValueStrategy strategy_7 = new UpdateValueStrategy();
		strategy_7.setConverter(new Boolean2StringConverter());
		bindingContext.bindValue(observeSelectionDenyInitialPasswordBtnObserveWidget, managedConnectionFactoryDenyInitialPasswordObserveValue, strategy_7, null);
		//
		IObservableValue observeTextPeakLimitTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(peakLimitText);
		IObservableValue managedConnectionFactoryPeakLimitObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__PEAK_LIMIT)).observe(managedConnectionFactory);
		UpdateValueStrategy strategy_8 = new UpdateValueStrategy();
		strategy_8.setBeforeSetValidator(new NonNegativeIntegerValidator("Connection Pool Peak Limit"));
		peakLimitBinding = bindingContext.bindValue(observeTextPeakLimitTextObserveWidget, managedConnectionFactoryPeakLimitObserveValue, strategy_8, null);
		//
		IObservableValue observeTextPoolCapacityTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(poolCapacityText);
		IObservableValue managedConnectionFactoryPoolCapacityObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__POOL_CAPACITY)).observe(managedConnectionFactory);
		UpdateValueStrategy strategy_9 = new UpdateValueStrategy();
		strategy_9.setBeforeSetValidator(new NonNegativeIntegerValidator("Connection Pool Capacity"));
		poolCapacityBinding = bindingContext.bindValue(observeTextPoolCapacityTextObserveWidget, managedConnectionFactoryPoolCapacityObserveValue, strategy_9, null);
		//
		IObservableValue observeTextExpirationTimeTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(expirationTimeText);
		IObservableValue managedConnectionFactoryExpirationTimeObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__EXPIRATION_TIME)).observe(managedConnectionFactory);
		UpdateValueStrategy strategy_10 = new UpdateValueStrategy();
		strategy_10.setBeforeSetValidator(new NonNegativeIntegerValidator("Connection Pool Expiration Time"));
		expirationTimeBinding = bindingContext.bindValue(observeTextExpirationTimeTextObserveWidget, managedConnectionFactoryExpirationTimeObserveValue, strategy_10, null);
		//
		IObservableValue observeTextExpirationCheckPeriodTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(expirationCheckPeriodText);
		IObservableValue managedConnectionFactoryExpirationPeriodObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__EXPIRATION_PERIOD)).observe(managedConnectionFactory);
		UpdateValueStrategy strategy_11 = new UpdateValueStrategy();
		strategy_11.setBeforeSetValidator(new NonNegativeIntegerValidator("Connection Pool Expiration Check Period"));
		expirationPeriodBinding = bindingContext.bindValue(observeTextExpirationCheckPeriodTextObserveWidget, managedConnectionFactoryExpirationPeriodObserveValue, strategy_11, null);
		//
		IObservableValue observeTextMaxGetClientTimeTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(maxGetClientTimeText);
		IObservableValue managedConnectionFactoryMaxGetTimeObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__MAX_GET_TIME)).observe(managedConnectionFactory);
		UpdateValueStrategy strategy_12 = new UpdateValueStrategy();
		strategy_12.setBeforeSetValidator(new NonNegativeIntegerValidator("Connection Pool Max Get Client Time"));
		maxGetTimeBinding = bindingContext.bindValue(observeTextMaxGetClientTimeTextObserveWidget, managedConnectionFactoryMaxGetTimeObserveValue, strategy_12, null);
		//
		IObservableValue observeSelectionSncModeBtnObserveWidget = WidgetProperties.selection().observe(sncModeBtn);
		IObservableValue managedConnectionFactorySncModeObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__SNC_MODE)).observe(managedConnectionFactory);
		UpdateValueStrategy strategy_13 = new UpdateValueStrategy();
		strategy_13.setConverter(new Boolean2StringConverter());
		bindingContext.bindValue(observeSelectionSncModeBtnObserveWidget, managedConnectionFactorySncModeObserveValue, strategy_13, null);
		//
		IObservableValue observeTextSncPartnernameTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(sncPartnernameText);
		IObservableValue managedConnectionFactorySncPartnernameObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__SNC_PARTNERNAME)).observe(managedConnectionFactory);
		bindingContext.bindValue(observeTextSncPartnernameTextObserveWidget, managedConnectionFactorySncPartnernameObserveValue, null, null);
		//
		IObservableValue observeSingleSelectionIndexSncQopComboObserveWidget = WidgetProperties.singleSelectionIndex().observe(sncQopCombo);
		IObservableValue managedConnectionFactorySncQopObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__SNC_QOP)).observe(managedConnectionFactory);
		UpdateValueStrategy strategy_14 = new UpdateValueStrategy();
		strategy_14.setConverter(new SncQosComboSelection2SncQosConverter());
		bindingContext.bindValue(observeSingleSelectionIndexSncQopComboObserveWidget, managedConnectionFactorySncQopObserveValue, strategy_14, null);
		//
		IObservableValue observeTextSncMynameTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(sncMynameText);
		IObservableValue managedConnectionFactorySncMynameObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__SNC_MYNAME)).observe(managedConnectionFactory);
		bindingContext.bindValue(observeTextSncMynameTextObserveWidget, managedConnectionFactorySncMynameObserveValue, null, null);
		//
		IObservableValue observeTextSncLibraryTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(sncLibraryText);
		IObservableValue managedConnectionFactorySncLibraryObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__SNC_LIBRARY)).observe(managedConnectionFactory);
		bindingContext.bindValue(observeTextSncLibraryTextObserveWidget, managedConnectionFactorySncLibraryObserveValue, null, null);
		//
		IObservableValue observeTextRepositoryDestinationTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(repositoryDestinationText);
		IObservableValue managedConnectionFactoryRepositoryDestObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__REPOSITORY_DEST)).observe(managedConnectionFactory);
		bindingContext.bindValue(observeTextRepositoryDestinationTextObserveWidget, managedConnectionFactoryRepositoryDestObserveValue, null, null);
		//
		IObservableValue observeTextRepositoryUserTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(repositoryUserText);
		IObservableValue managedConnectionFactoryRepositoryUserObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__REPOSITORY_USER)).observe(managedConnectionFactory);
		bindingContext.bindValue(observeTextRepositoryUserTextObserveWidget, managedConnectionFactoryRepositoryUserObserveValue, null, null);
		//
		IObservableValue observeTextRepositoryPasswordTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(repositoryPasswordText);
		IObservableValue managedConnectionFactoryRepositoryPasswdObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__REPOSITORY_PASSWD)).observe(managedConnectionFactory);
		bindingContext.bindValue(observeTextRepositoryPasswordTextObserveWidget, managedConnectionFactoryRepositoryPasswdObserveValue, null, null);
		//
		IObservableValue observeSelectionRespositorySncBtnObserveWidget = WidgetProperties.selection().observe(respositorySncBtn);
		IObservableValue managedConnectionFactoryRepositorySncObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__REPOSITORY_SNC)).observe(managedConnectionFactory);
		UpdateValueStrategy strategy_15 = new UpdateValueStrategy();
		strategy_15.setConverter(new Boolean2StringConverter());
		bindingContext.bindValue(observeSelectionRespositorySncBtnObserveWidget, managedConnectionFactoryRepositorySncObserveValue, strategy_15, null);
		//
		IObservableValue observeSelectionRepositoryRoundtripOptimizationBtnObserveWidget = WidgetProperties.selection().observe(repositoryRoundtripOptimizationBtn);
		IObservableValue managedConnectionFactoryRepositoryRoundtripOptimizationObserveValue = EMFEditProperties.value(editingDomain, FeaturePath.fromList(Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, Literals.CONNECTION_REQUEST_INFO__REPOSITORY_ROUNDTRIP_OPTIMIZATION)).observe(managedConnectionFactory);
		UpdateValueStrategy strategy_16 = new UpdateValueStrategy();
		strategy_16.setConverter(new Boolean2StringConverter());
		bindingContext.bindValue(observeSelectionRepositoryRoundtripOptimizationBtnObserveWidget, managedConnectionFactoryRepositoryRoundtripOptimizationObserveValue, strategy_16, null);
		//
		return bindingContext;
	}
}
