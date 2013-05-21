/**
 */
package org.jboss.jca.adapters.sap.model.spi.tests;

import java.util.Map;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.model.spi.SpiFactory;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Connection Request Info Store Entry</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConnectionRequestInfoStoreEntryTest extends TestCase {

	/**
	 * The fixture for this Connection Request Info Store Entry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map.Entry<String, ConnectionRequestInfo> fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ConnectionRequestInfoStoreEntryTest.class);
	}

	/**
	 * Constructs a new Connection Request Info Store Entry test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionRequestInfoStoreEntryTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Connection Request Info Store Entry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Map.Entry<String, ConnectionRequestInfo> fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Connection Request Info Store Entry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map.Entry<String, ConnectionRequestInfo> getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected void setUp() throws Exception {
		setFixture((Map.Entry<String, ConnectionRequestInfo>)SpiFactory.eINSTANCE.create(SpiPackage.Literals.CONNECTION_REQUEST_INFO_STORE_ENTRY));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ConnectionRequestInfoStoreEntryTest
