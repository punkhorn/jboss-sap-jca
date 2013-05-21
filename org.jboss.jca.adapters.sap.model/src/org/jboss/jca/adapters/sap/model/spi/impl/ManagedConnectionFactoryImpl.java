/**
 */
package org.jboss.jca.adapters.sap.model.spi.impl;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.cci.ConnectionFactory;
import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnection;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactoryState;
import org.jboss.jca.adapters.sap.model.spi.PackageRegistry;
import org.jboss.jca.adapters.sap.model.spi.ResourceAdapter;
import org.jboss.jca.adapters.sap.model.spi.SpiFactory;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Managed Connection Factory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionFactoryImpl#getState <em>State</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionFactoryImpl#getResourceAdapter <em>Resource Adapter</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionFactoryImpl#getDefaultConnectionName <em>Default Connection Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionFactoryImpl#getDefaultConnectionRequestInfo <em>Default Connection Request Info</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionFactoryImpl#getPackageRegistry <em>Package Registry</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionFactoryImpl#getManagedConnections <em>Managed Connections</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionFactoryImpl#getConnectionFactories <em>Connection Factories</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionFactoryImpl#getLogWriter <em>Log Writer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ManagedConnectionFactoryImpl extends EObjectImpl implements ManagedConnectionFactory {
	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final ManagedConnectionFactoryState STATE_EDEFAULT = ManagedConnectionFactoryState.ACTIVE;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected ManagedConnectionFactoryState state = STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultConnectionName() <em>Default Connection Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultConnectionName()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_CONNECTION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultConnectionName() <em>Default Connection Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultConnectionName()
	 * @generated NOT
	 * @ordered
	 */
	protected String defaultConnectionName = UUID.randomUUID().toString();

	/**
	 * The cached value of the '{@link #getDefaultConnectionRequestInfo() <em>Default Connection Request Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultConnectionRequestInfo()
	 * @generated
	 * @ordered
	 */
	protected ConnectionRequestInfo defaultConnectionRequestInfo;

	/**
	 * The cached value of the '{@link #getPackageRegistry() <em>Package Registry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageRegistry()
	 * @generated
	 * @ordered
	 */
	protected PackageRegistry packageRegistry;

	/**
	 * The cached value of the '{@link #getManagedConnections() <em>Managed Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagedConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<ManagedConnection> managedConnections;

	/**
	 * The cached value of the '{@link #getConnectionFactories() <em>Connection Factories</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionFactories()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectionFactory> connectionFactories;

	/**
	 * The default value of the '{@link #getLogWriter() <em>Log Writer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogWriter()
	 * @generated
	 * @ordered
	 */
	protected static final PrintWriter LOG_WRITER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLogWriter() <em>Log Writer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogWriter()
	 * @generated
	 * @ordered
	 */
	protected PrintWriter logWriter = LOG_WRITER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ManagedConnectionFactoryImpl() {
		super();
		setDefaultConnectionRequestInfo(SpiFactory.eINSTANCE.createConnectionRequestInfo());
		setPackageRegistry(SpiFactory.eINSTANCE.createPackageRegistry());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpiPackage.Literals.MANAGED_CONNECTION_FACTORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedConnectionFactoryState getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(ManagedConnectionFactoryState newState) {
		ManagedConnectionFactoryState oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpiPackage.MANAGED_CONNECTION_FACTORY__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceAdapter getResourceAdapter() {
		if (eContainerFeatureID() != SpiPackage.MANAGED_CONNECTION_FACTORY__RESOURCE_ADAPTER) return null;
		return (ResourceAdapter)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceAdapter basicGetResourceAdapter() {
		if (eContainerFeatureID() != SpiPackage.MANAGED_CONNECTION_FACTORY__RESOURCE_ADAPTER) return null;
		return (ResourceAdapter)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceAdapter(ResourceAdapter newResourceAdapter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newResourceAdapter, SpiPackage.MANAGED_CONNECTION_FACTORY__RESOURCE_ADAPTER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceAdapter(ResourceAdapter newResourceAdapter) {
		if (newResourceAdapter != eInternalContainer() || (eContainerFeatureID() != SpiPackage.MANAGED_CONNECTION_FACTORY__RESOURCE_ADAPTER && newResourceAdapter != null)) {
			if (EcoreUtil.isAncestor(this, newResourceAdapter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newResourceAdapter != null)
				msgs = ((InternalEObject)newResourceAdapter).eInverseAdd(this, SpiPackage.RESOURCE_ADAPTER__MANAGED_CONNECTION_FACTORIES, ResourceAdapter.class, msgs);
			msgs = basicSetResourceAdapter(newResourceAdapter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpiPackage.MANAGED_CONNECTION_FACTORY__RESOURCE_ADAPTER, newResourceAdapter, newResourceAdapter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultConnectionName() {
		return defaultConnectionName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultConnectionName(String newDefaultConnectionName) {
		String oldDefaultConnectionName = defaultConnectionName;
		defaultConnectionName = newDefaultConnectionName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpiPackage.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_NAME, oldDefaultConnectionName, defaultConnectionName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionRequestInfo getDefaultConnectionRequestInfo() {
		if (defaultConnectionRequestInfo != null && defaultConnectionRequestInfo.eIsProxy()) {
			InternalEObject oldDefaultConnectionRequestInfo = (InternalEObject)defaultConnectionRequestInfo;
			defaultConnectionRequestInfo = (ConnectionRequestInfo)eResolveProxy(oldDefaultConnectionRequestInfo);
			if (defaultConnectionRequestInfo != oldDefaultConnectionRequestInfo) {
				InternalEObject newDefaultConnectionRequestInfo = (InternalEObject)defaultConnectionRequestInfo;
				NotificationChain msgs = oldDefaultConnectionRequestInfo.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpiPackage.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, null, null);
				if (newDefaultConnectionRequestInfo.eInternalContainer() == null) {
					msgs = newDefaultConnectionRequestInfo.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpiPackage.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpiPackage.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, oldDefaultConnectionRequestInfo, defaultConnectionRequestInfo));
			}
		}
		return defaultConnectionRequestInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionRequestInfo basicGetDefaultConnectionRequestInfo() {
		return defaultConnectionRequestInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ManagedConnection> getManagedConnections() {
		if (managedConnections == null) {
			managedConnections = new EObjectContainmentWithInverseEList.Resolving<ManagedConnection>(ManagedConnection.class, this, SpiPackage.MANAGED_CONNECTION_FACTORY__MANAGED_CONNECTIONS, SpiPackage.MANAGED_CONNECTION__MANAGED_CONNECTION_FACTORY);
		}
		return managedConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConnectionFactory> getConnectionFactories() {
		if (connectionFactories == null) {
			connectionFactories = new EObjectContainmentWithInverseEList.Resolving<ConnectionFactory>(ConnectionFactory.class, this, SpiPackage.MANAGED_CONNECTION_FACTORY__CONNECTION_FACTORIES, CciPackage.CONNECTION_FACTORY__MANAGED_CONNECTION_FACTORY);
		}
		return connectionFactories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrintWriter getLogWriter() {
		return logWriter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogWriter(PrintWriter newLogWriter) {
		PrintWriter oldLogWriter = logWriter;
		logWriter = newLogWriter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpiPackage.MANAGED_CONNECTION_FACTORY__LOG_WRITER, oldLogWriter, logWriter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageRegistry getPackageRegistry() {
		if (packageRegistry != null && packageRegistry.eIsProxy()) {
			InternalEObject oldPackageRegistry = (InternalEObject)packageRegistry;
			packageRegistry = (PackageRegistry)eResolveProxy(oldPackageRegistry);
			if (packageRegistry != oldPackageRegistry) {
				InternalEObject newPackageRegistry = (InternalEObject)packageRegistry;
				NotificationChain msgs =  oldPackageRegistry.eInverseRemove(this, SpiPackage.PACKAGE_REGISTRY__MANAGED_CONNECTION_FACTORY, PackageRegistry.class, null);
				if (newPackageRegistry.eInternalContainer() == null) {
					msgs =  newPackageRegistry.eInverseAdd(this, SpiPackage.PACKAGE_REGISTRY__MANAGED_CONNECTION_FACTORY, PackageRegistry.class, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpiPackage.MANAGED_CONNECTION_FACTORY__PACKAGE_REGISTRY, oldPackageRegistry, packageRegistry));
			}
		}
		return packageRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageRegistry basicGetPackageRegistry() {
		return packageRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPackageRegistry(PackageRegistry newPackageRegistry, NotificationChain msgs) {
		PackageRegistry oldPackageRegistry = packageRegistry;
		packageRegistry = newPackageRegistry;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpiPackage.MANAGED_CONNECTION_FACTORY__PACKAGE_REGISTRY, oldPackageRegistry, newPackageRegistry);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackageRegistry(PackageRegistry newPackageRegistry) {
		if (newPackageRegistry != packageRegistry) {
			NotificationChain msgs = null;
			if (packageRegistry != null)
				msgs = ((InternalEObject)packageRegistry).eInverseRemove(this, SpiPackage.PACKAGE_REGISTRY__MANAGED_CONNECTION_FACTORY, PackageRegistry.class, msgs);
			if (newPackageRegistry != null)
				msgs = ((InternalEObject)newPackageRegistry).eInverseAdd(this, SpiPackage.PACKAGE_REGISTRY__MANAGED_CONNECTION_FACTORY, PackageRegistry.class, msgs);
			msgs = basicSetPackageRegistry(newPackageRegistry, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpiPackage.MANAGED_CONNECTION_FACTORY__PACKAGE_REGISTRY, newPackageRegistry, newPackageRegistry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getAliasUser() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getAliasUser();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setAliasUser(String newAliasUser) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setAliasUser(newAliasUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getAshost() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getAshost();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setAshost(String newAshost) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setAshost(newAshost);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getAuthType() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getAuthType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setAuthType(String newAuthType) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setAuthType(newAuthType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getClient() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo. getClient();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setClient(String newClient) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setClient(newClient);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getCodepage() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getCodepage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setCodepage(String newCodepage) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setCodepage(newCodepage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getCpicTrace() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getCpicTrace();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setCpicTrace(String newCpicTrace) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setCpicTrace(newCpicTrace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getDenyInitialPassword() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getDenyInitialPassword();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setDenyInitialPassword(String newDenyInitialPassword) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setDenyInitialPassword(newDenyInitialPassword);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getExpirationPeriod() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getExpirationPeriod();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setExpirationPeriod(String newExpirationPeriod) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setExpirationPeriod(newExpirationPeriod);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getExpirationTime() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getExpirationTime();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setExpirationTime(String newExpirationTime) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setExpirationTime(newExpirationTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getGetsso2() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getGetsso2();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setGetsso2(String newGetsso2) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setGetsso2(newGetsso2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getGroup() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getGroup();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setGroup(String newGroup) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setGroup(newGroup);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getGwhost() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getGwhost();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setGwhost(String newGwhost) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setGwhost(newGwhost);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getGwserv() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getGwserv();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setGwserv(String newGwserv) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setGwserv(newGwserv);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getLang() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getLang();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setLang(String newLang) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setLang(newLang);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getLcheck() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getLcheck();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setLcheck(String newLcheck) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setLcheck(newLcheck);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getMaxGetTime() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getMaxGetTime();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMaxGetTime(String newMaxGetTime) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setMaxGetTime(newMaxGetTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getMshost() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getMshost();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMshost(String newMshost) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setMshost(newMshost);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getMsserv() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getMsserv();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMsserv(String newMsserv) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setMsserv(newMsserv);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getMysapsso2() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getMysapsso2();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMysapsso2(String newMysapsso2) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setMysapsso2(newMysapsso2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPasswd() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getPasswd();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPasswd(String newPasswd) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setPasswd(newPasswd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPcs() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getPcs();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPcs(String newPcs) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setPcs(newPcs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPeakLimit() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getPeakLimit();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPeakLimit(String newPeakLimit) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setPeakLimit(newPeakLimit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPingOnCreate() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getPingOnCreate();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPingOnCreate(String newPingOnCreate) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setPingOnCreate(newPingOnCreate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPoolCapacity() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getPoolCapacity();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPoolCapacity(String newPoolCapacity) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setPoolCapacity(newPoolCapacity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getR3name() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getR3name();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setR3name(String newR3name) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setR3name(newR3name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getRepositoryDest() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getRepositoryDest();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRepositoryDest(String newRepositoryDest) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setRepositoryDest(newRepositoryDest);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getRepositoryPasswd() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getRepositoryPasswd();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRepositoryPasswd(String newRepositoryPasswd) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setRepositoryPasswd(newRepositoryPasswd);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getRepositoryRoundtripOptimization() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getRepositoryRoundtripOptimization();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRepositoryRoundtripOptimization(String newRepositoryRoundtripOptimization) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setRepositoryRoundtripOptimization(newRepositoryRoundtripOptimization);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getRepositorySnc() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getRepositorySnc();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRepositorySnc(String newRepositorySnc) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setRepositorySnc(newRepositorySnc);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getRepositoryUser() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getRepositoryUser();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setRepositoryUser(String newRepositoryUser) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setRepositoryUser(newRepositoryUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSaprouter() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getSaprouter();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSaprouter(String newSaprouter) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setSaprouter(newSaprouter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSncLibrary() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getSncLibrary();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSncLibrary(String newSncLibrary) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setSncLibrary(newSncLibrary);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSncMode() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getSncMode();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSncMode(String newSncMode) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setSncMode(newSncMode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSncMyname() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getSncMyname();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSncMyname(String newSncMyName) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setSncMyname(newSncMyName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSncPartnername() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getSncPartnername();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSncPartnername(String newSncPartnername) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setSncPartnername(newSncPartnername);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSncQop() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getSncQop();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSncQop(String newSncQop) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setSncQop(newSncQop);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSysnr() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getSysnr();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSysnr(String newSysnr) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setSysnr(newSysnr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getTphost() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getTphost();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setTphost(String newTphost) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setTphost(newTphost);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getTpname() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getTpname();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setTpname(String newTpname) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setTpname(newTpname);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getTrace() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getTrace();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setTrace(String newTrace) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setTrace(newTrace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getType() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setType(String newType) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setType(newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getUser() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getUser();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setUser(String newUser) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setUser(newUser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getUserId() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getUserId();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setUserId(String newUserId) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setUserId(newUserId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getUseSapgui() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getUseSapgui();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setUseSapgui(String newUseSapgui) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setUseSapgui(newUseSapgui);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getX509cert() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getX509cert();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setX509cert(String newX509cert) {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		if (defaultConnectionRequestInfo != null) 
			defaultConnectionRequestInfo.setX509cert(newX509cert);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultConnectionRequestInfo(ConnectionRequestInfo newDefaultConnectionRequestInfo, NotificationChain msgs) {
		ConnectionRequestInfo oldDefaultConnectionRequestInfo = defaultConnectionRequestInfo;
		defaultConnectionRequestInfo = newDefaultConnectionRequestInfo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpiPackage.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, oldDefaultConnectionRequestInfo, newDefaultConnectionRequestInfo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultConnectionRequestInfo(ConnectionRequestInfo newDefaultConnectionRequestInfo) {
		if (newDefaultConnectionRequestInfo != defaultConnectionRequestInfo) {
			NotificationChain msgs = null;
			if (defaultConnectionRequestInfo != null)
				msgs = ((InternalEObject)defaultConnectionRequestInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpiPackage.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, null, msgs);
			if (newDefaultConnectionRequestInfo != null)
				msgs = ((InternalEObject)newDefaultConnectionRequestInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpiPackage.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, null, msgs);
			msgs = basicSetDefaultConnectionRequestInfo(newDefaultConnectionRequestInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpiPackage.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO, newDefaultConnectionRequestInfo, newDefaultConnectionRequestInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpiPackage.MANAGED_CONNECTION_FACTORY__RESOURCE_ADAPTER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetResourceAdapter((ResourceAdapter)otherEnd, msgs);
			case SpiPackage.MANAGED_CONNECTION_FACTORY__PACKAGE_REGISTRY:
				if (packageRegistry != null)
					msgs = ((InternalEObject)packageRegistry).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpiPackage.MANAGED_CONNECTION_FACTORY__PACKAGE_REGISTRY, null, msgs);
				return basicSetPackageRegistry((PackageRegistry)otherEnd, msgs);
			case SpiPackage.MANAGED_CONNECTION_FACTORY__MANAGED_CONNECTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getManagedConnections()).basicAdd(otherEnd, msgs);
			case SpiPackage.MANAGED_CONNECTION_FACTORY__CONNECTION_FACTORIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConnectionFactories()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpiPackage.MANAGED_CONNECTION_FACTORY__RESOURCE_ADAPTER:
				return basicSetResourceAdapter(null, msgs);
			case SpiPackage.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO:
				return basicSetDefaultConnectionRequestInfo(null, msgs);
			case SpiPackage.MANAGED_CONNECTION_FACTORY__PACKAGE_REGISTRY:
				return basicSetPackageRegistry(null, msgs);
			case SpiPackage.MANAGED_CONNECTION_FACTORY__MANAGED_CONNECTIONS:
				return ((InternalEList<?>)getManagedConnections()).basicRemove(otherEnd, msgs);
			case SpiPackage.MANAGED_CONNECTION_FACTORY__CONNECTION_FACTORIES:
				return ((InternalEList<?>)getConnectionFactories()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SpiPackage.MANAGED_CONNECTION_FACTORY__RESOURCE_ADAPTER:
				return eInternalContainer().eInverseRemove(this, SpiPackage.RESOURCE_ADAPTER__MANAGED_CONNECTION_FACTORIES, ResourceAdapter.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SpiPackage.MANAGED_CONNECTION_FACTORY__STATE:
				return getState();
			case SpiPackage.MANAGED_CONNECTION_FACTORY__RESOURCE_ADAPTER:
				if (resolve) return getResourceAdapter();
				return basicGetResourceAdapter();
			case SpiPackage.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_NAME:
				return getDefaultConnectionName();
			case SpiPackage.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO:
				if (resolve) return getDefaultConnectionRequestInfo();
				return basicGetDefaultConnectionRequestInfo();
			case SpiPackage.MANAGED_CONNECTION_FACTORY__PACKAGE_REGISTRY:
				if (resolve) return getPackageRegistry();
				return basicGetPackageRegistry();
			case SpiPackage.MANAGED_CONNECTION_FACTORY__MANAGED_CONNECTIONS:
				return getManagedConnections();
			case SpiPackage.MANAGED_CONNECTION_FACTORY__CONNECTION_FACTORIES:
				return getConnectionFactories();
			case SpiPackage.MANAGED_CONNECTION_FACTORY__LOG_WRITER:
				return getLogWriter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SpiPackage.MANAGED_CONNECTION_FACTORY__STATE:
				setState((ManagedConnectionFactoryState)newValue);
				return;
			case SpiPackage.MANAGED_CONNECTION_FACTORY__RESOURCE_ADAPTER:
				setResourceAdapter((ResourceAdapter)newValue);
				return;
			case SpiPackage.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_NAME:
				setDefaultConnectionName((String)newValue);
				return;
			case SpiPackage.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO:
				setDefaultConnectionRequestInfo((ConnectionRequestInfo)newValue);
				return;
			case SpiPackage.MANAGED_CONNECTION_FACTORY__PACKAGE_REGISTRY:
				setPackageRegistry((PackageRegistry)newValue);
				return;
			case SpiPackage.MANAGED_CONNECTION_FACTORY__MANAGED_CONNECTIONS:
				getManagedConnections().clear();
				getManagedConnections().addAll((Collection<? extends ManagedConnection>)newValue);
				return;
			case SpiPackage.MANAGED_CONNECTION_FACTORY__CONNECTION_FACTORIES:
				getConnectionFactories().clear();
				getConnectionFactories().addAll((Collection<? extends ConnectionFactory>)newValue);
				return;
			case SpiPackage.MANAGED_CONNECTION_FACTORY__LOG_WRITER:
				setLogWriter((PrintWriter)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SpiPackage.MANAGED_CONNECTION_FACTORY__STATE:
				setState(STATE_EDEFAULT);
				return;
			case SpiPackage.MANAGED_CONNECTION_FACTORY__RESOURCE_ADAPTER:
				setResourceAdapter((ResourceAdapter)null);
				return;
			case SpiPackage.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_NAME:
				setDefaultConnectionName(DEFAULT_CONNECTION_NAME_EDEFAULT);
				return;
			case SpiPackage.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO:
				setDefaultConnectionRequestInfo((ConnectionRequestInfo)null);
				return;
			case SpiPackage.MANAGED_CONNECTION_FACTORY__PACKAGE_REGISTRY:
				setPackageRegistry((PackageRegistry)null);
				return;
			case SpiPackage.MANAGED_CONNECTION_FACTORY__MANAGED_CONNECTIONS:
				getManagedConnections().clear();
				return;
			case SpiPackage.MANAGED_CONNECTION_FACTORY__CONNECTION_FACTORIES:
				getConnectionFactories().clear();
				return;
			case SpiPackage.MANAGED_CONNECTION_FACTORY__LOG_WRITER:
				setLogWriter(LOG_WRITER_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SpiPackage.MANAGED_CONNECTION_FACTORY__STATE:
				return state != STATE_EDEFAULT;
			case SpiPackage.MANAGED_CONNECTION_FACTORY__RESOURCE_ADAPTER:
				return basicGetResourceAdapter() != null;
			case SpiPackage.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_NAME:
				return DEFAULT_CONNECTION_NAME_EDEFAULT == null ? defaultConnectionName != null : !DEFAULT_CONNECTION_NAME_EDEFAULT.equals(defaultConnectionName);
			case SpiPackage.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_REQUEST_INFO:
				return defaultConnectionRequestInfo != null;
			case SpiPackage.MANAGED_CONNECTION_FACTORY__PACKAGE_REGISTRY:
				return packageRegistry != null;
			case SpiPackage.MANAGED_CONNECTION_FACTORY__MANAGED_CONNECTIONS:
				return managedConnections != null && !managedConnections.isEmpty();
			case SpiPackage.MANAGED_CONNECTION_FACTORY__CONNECTION_FACTORIES:
				return connectionFactories != null && !connectionFactories.isEmpty();
			case SpiPackage.MANAGED_CONNECTION_FACTORY__LOG_WRITER:
				return LOG_WRITER_EDEFAULT == null ? logWriter != null : !LOG_WRITER_EDEFAULT.equals(logWriter);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (state: ");
		result.append(state);
		result.append(", defaultConnectionName: ");
		result.append(defaultConnectionName);
		result.append(", logWriter: ");
		result.append(logWriter);
		result.append(')');
		return result.toString();
	}

} //ManagedConnectionFactoryImpl
