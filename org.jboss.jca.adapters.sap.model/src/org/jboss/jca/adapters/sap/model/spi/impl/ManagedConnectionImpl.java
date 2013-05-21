/**
 */
package org.jboss.jca.adapters.sap.model.spi.impl;

import java.io.PrintWriter;
import java.util.Collection;
import javax.resource.spi.ConnectionEventListener;
import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.cci.Connection;
import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnection;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionState;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Managed Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionImpl#getState <em>State</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionImpl#getManagedConnectionFactory <em>Managed Connection Factory</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionImpl#getConnectionName <em>Connection Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionImpl#getConnectionRequestInfo <em>Connection Request Info</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionImpl#getConnectionHandles <em>Connection Handles</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionImpl#getLogWriter <em>Log Writer</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionImpl#getConnectionEventListeners <em>Connection Event Listeners</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.impl.ManagedConnectionImpl#isInTransaction <em>In Transaction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ManagedConnectionImpl extends EObjectImpl implements ManagedConnection {
	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final ManagedConnectionState STATE_EDEFAULT = ManagedConnectionState.ACTIVE;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected ManagedConnectionState state = STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getConnectionName() <em>Connection Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionName()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNECTION_NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getConnectionName() <em>Connection Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionName()
	 * @generated NOT
	 * @ordered
	 */
	protected String connectionName = UUID.randomUUID().toString();

	/**
	 * The cached value of the '{@link #getConnectionRequestInfo() <em>Connection Request Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionRequestInfo()
	 * @generated NOT
	 * @ordered
	 */
	protected ConnectionRequestInfo connectionRequestInfo;

	/**
	 * The cached value of the '{@link #getConnectionHandles() <em>Connection Handles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionHandles()
	 * @generated
	 * @ordered
	 */
	protected EList<Connection> connectionHandles;

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
	 * The cached value of the '{@link #getConnectionEventListeners() <em>Connection Event Listeners</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionEventListeners()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectionEventListener> connectionEventListeners;

	/**
	 * The default value of the '{@link #isInTransaction() <em>In Transaction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInTransaction()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IN_TRANSACTION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInTransaction() <em>In Transaction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInTransaction()
	 * @generated
	 * @ordered
	 */
	protected boolean inTransaction = IN_TRANSACTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ManagedConnectionImpl() {
		super();
		setConnectionRequestInfo(new ConnectionRequestInfoImpl());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpiPackage.Literals.MANAGED_CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedConnectionState getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(ManagedConnectionState newState) {
		ManagedConnectionState oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpiPackage.MANAGED_CONNECTION__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnectionName() {
		return connectionName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionName(String newConnectionName) {
		String oldConnectionName = connectionName;
		connectionName = newConnectionName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpiPackage.MANAGED_CONNECTION__CONNECTION_NAME, oldConnectionName, connectionName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionRequestInfo getConnectionRequestInfo() {
		if (connectionRequestInfo != null && connectionRequestInfo.eIsProxy()) {
			InternalEObject oldConnectionRequestInfo = (InternalEObject)connectionRequestInfo;
			connectionRequestInfo = (ConnectionRequestInfo)eResolveProxy(oldConnectionRequestInfo);
			if (connectionRequestInfo != oldConnectionRequestInfo) {
				InternalEObject newConnectionRequestInfo = (InternalEObject)connectionRequestInfo;
				NotificationChain msgs = oldConnectionRequestInfo.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpiPackage.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, null, null);
				if (newConnectionRequestInfo.eInternalContainer() == null) {
					msgs = newConnectionRequestInfo.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpiPackage.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpiPackage.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, oldConnectionRequestInfo, connectionRequestInfo));
			}
		}
		return connectionRequestInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionRequestInfo basicGetConnectionRequestInfo() {
		return connectionRequestInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConnectionRequestInfo(ConnectionRequestInfo newConnectionRequestInfo, NotificationChain msgs) {
		ConnectionRequestInfo oldConnectionRequestInfo = connectionRequestInfo;
		connectionRequestInfo = newConnectionRequestInfo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SpiPackage.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, oldConnectionRequestInfo, newConnectionRequestInfo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionRequestInfo(ConnectionRequestInfo newConnectionRequestInfo) {
		if (newConnectionRequestInfo != connectionRequestInfo) {
			NotificationChain msgs = null;
			if (connectionRequestInfo != null)
				msgs = ((InternalEObject)connectionRequestInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SpiPackage.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, null, msgs);
			if (newConnectionRequestInfo != null)
				msgs = ((InternalEObject)newConnectionRequestInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SpiPackage.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, null, msgs);
			msgs = basicSetConnectionRequestInfo(newConnectionRequestInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpiPackage.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO, newConnectionRequestInfo, newConnectionRequestInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Connection> getConnectionHandles() {
		if (connectionHandles == null) {
			connectionHandles = new EObjectContainmentWithInverseEList.Resolving<Connection>(Connection.class, this, SpiPackage.MANAGED_CONNECTION__CONNECTION_HANDLES, CciPackage.CONNECTION__MANAGED_CONNECTION);
		}
		return connectionHandles;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SpiPackage.MANAGED_CONNECTION__LOG_WRITER, oldLogWriter, logWriter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConnectionEventListener> getConnectionEventListeners() {
		if (connectionEventListeners == null) {
			connectionEventListeners = new EDataTypeUniqueEList<ConnectionEventListener>(ConnectionEventListener.class, this, SpiPackage.MANAGED_CONNECTION__CONNECTION_EVENT_LISTENERS);
		}
		return connectionEventListeners;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInTransaction() {
		return inTransaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInTransaction(boolean newInTransaction) {
		boolean oldInTransaction = inTransaction;
		inTransaction = newInTransaction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpiPackage.MANAGED_CONNECTION__IN_TRANSACTION, oldInTransaction, inTransaction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedConnectionFactory getManagedConnectionFactory() {
		if (eContainerFeatureID() != SpiPackage.MANAGED_CONNECTION__MANAGED_CONNECTION_FACTORY) return null;
		return (ManagedConnectionFactory)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedConnectionFactory basicGetManagedConnectionFactory() {
		if (eContainerFeatureID() != SpiPackage.MANAGED_CONNECTION__MANAGED_CONNECTION_FACTORY) return null;
		return (ManagedConnectionFactory)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetManagedConnectionFactory(ManagedConnectionFactory newManagedConnectionFactory, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newManagedConnectionFactory, SpiPackage.MANAGED_CONNECTION__MANAGED_CONNECTION_FACTORY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManagedConnectionFactory(ManagedConnectionFactory newManagedConnectionFactory) {
		if (newManagedConnectionFactory != eInternalContainer() || (eContainerFeatureID() != SpiPackage.MANAGED_CONNECTION__MANAGED_CONNECTION_FACTORY && newManagedConnectionFactory != null)) {
			if (EcoreUtil.isAncestor(this, newManagedConnectionFactory))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newManagedConnectionFactory != null)
				msgs = ((InternalEObject)newManagedConnectionFactory).eInverseAdd(this, SpiPackage.MANAGED_CONNECTION_FACTORY__MANAGED_CONNECTIONS, ManagedConnectionFactory.class, msgs);
			msgs = basicSetManagedConnectionFactory(newManagedConnectionFactory, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpiPackage.MANAGED_CONNECTION__MANAGED_CONNECTION_FACTORY, newManagedConnectionFactory, newManagedConnectionFactory));
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
			case SpiPackage.MANAGED_CONNECTION__MANAGED_CONNECTION_FACTORY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetManagedConnectionFactory((ManagedConnectionFactory)otherEnd, msgs);
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_HANDLES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConnectionHandles()).basicAdd(otherEnd, msgs);
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
			case SpiPackage.MANAGED_CONNECTION__MANAGED_CONNECTION_FACTORY:
				return basicSetManagedConnectionFactory(null, msgs);
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO:
				return basicSetConnectionRequestInfo(null, msgs);
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_HANDLES:
				return ((InternalEList<?>)getConnectionHandles()).basicRemove(otherEnd, msgs);
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
			case SpiPackage.MANAGED_CONNECTION__MANAGED_CONNECTION_FACTORY:
				return eInternalContainer().eInverseRemove(this, SpiPackage.MANAGED_CONNECTION_FACTORY__MANAGED_CONNECTIONS, ManagedConnectionFactory.class, msgs);
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
			case SpiPackage.MANAGED_CONNECTION__STATE:
				return getState();
			case SpiPackage.MANAGED_CONNECTION__MANAGED_CONNECTION_FACTORY:
				if (resolve) return getManagedConnectionFactory();
				return basicGetManagedConnectionFactory();
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_NAME:
				return getConnectionName();
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO:
				if (resolve) return getConnectionRequestInfo();
				return basicGetConnectionRequestInfo();
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_HANDLES:
				return getConnectionHandles();
			case SpiPackage.MANAGED_CONNECTION__LOG_WRITER:
				return getLogWriter();
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_EVENT_LISTENERS:
				return getConnectionEventListeners();
			case SpiPackage.MANAGED_CONNECTION__IN_TRANSACTION:
				return isInTransaction();
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
			case SpiPackage.MANAGED_CONNECTION__STATE:
				setState((ManagedConnectionState)newValue);
				return;
			case SpiPackage.MANAGED_CONNECTION__MANAGED_CONNECTION_FACTORY:
				setManagedConnectionFactory((ManagedConnectionFactory)newValue);
				return;
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_NAME:
				setConnectionName((String)newValue);
				return;
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO:
				setConnectionRequestInfo((ConnectionRequestInfo)newValue);
				return;
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_HANDLES:
				getConnectionHandles().clear();
				getConnectionHandles().addAll((Collection<? extends Connection>)newValue);
				return;
			case SpiPackage.MANAGED_CONNECTION__LOG_WRITER:
				setLogWriter((PrintWriter)newValue);
				return;
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_EVENT_LISTENERS:
				getConnectionEventListeners().clear();
				getConnectionEventListeners().addAll((Collection<? extends ConnectionEventListener>)newValue);
				return;
			case SpiPackage.MANAGED_CONNECTION__IN_TRANSACTION:
				setInTransaction((Boolean)newValue);
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
			case SpiPackage.MANAGED_CONNECTION__STATE:
				setState(STATE_EDEFAULT);
				return;
			case SpiPackage.MANAGED_CONNECTION__MANAGED_CONNECTION_FACTORY:
				setManagedConnectionFactory((ManagedConnectionFactory)null);
				return;
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_NAME:
				setConnectionName(CONNECTION_NAME_EDEFAULT);
				return;
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO:
				setConnectionRequestInfo((ConnectionRequestInfo)null);
				return;
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_HANDLES:
				getConnectionHandles().clear();
				return;
			case SpiPackage.MANAGED_CONNECTION__LOG_WRITER:
				setLogWriter(LOG_WRITER_EDEFAULT);
				return;
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_EVENT_LISTENERS:
				getConnectionEventListeners().clear();
				return;
			case SpiPackage.MANAGED_CONNECTION__IN_TRANSACTION:
				setInTransaction(IN_TRANSACTION_EDEFAULT);
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
			case SpiPackage.MANAGED_CONNECTION__STATE:
				return state != STATE_EDEFAULT;
			case SpiPackage.MANAGED_CONNECTION__MANAGED_CONNECTION_FACTORY:
				return basicGetManagedConnectionFactory() != null;
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_NAME:
				return CONNECTION_NAME_EDEFAULT == null ? connectionName != null : !CONNECTION_NAME_EDEFAULT.equals(connectionName);
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO:
				return connectionRequestInfo != null;
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_HANDLES:
				return connectionHandles != null && !connectionHandles.isEmpty();
			case SpiPackage.MANAGED_CONNECTION__LOG_WRITER:
				return LOG_WRITER_EDEFAULT == null ? logWriter != null : !LOG_WRITER_EDEFAULT.equals(logWriter);
			case SpiPackage.MANAGED_CONNECTION__CONNECTION_EVENT_LISTENERS:
				return connectionEventListeners != null && !connectionEventListeners.isEmpty();
			case SpiPackage.MANAGED_CONNECTION__IN_TRANSACTION:
				return inTransaction != IN_TRANSACTION_EDEFAULT;
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
		result.append(", connectionName: ");
		result.append(connectionName);
		result.append(", logWriter: ");
		result.append(logWriter);
		result.append(", connectionEventListeners: ");
		result.append(connectionEventListeners);
		result.append(", inTransaction: ");
		result.append(inTransaction);
		result.append(')');
		return result.toString();
	}

} //ManagedConnectionImpl
