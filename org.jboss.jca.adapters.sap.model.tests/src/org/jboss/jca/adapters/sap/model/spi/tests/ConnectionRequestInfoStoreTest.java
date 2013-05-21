/**
 */
package org.jboss.jca.adapters.sap.model.spi.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfoStore;
import org.jboss.jca.adapters.sap.model.spi.SpiFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Connection Request Info Store</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConnectionRequestInfoStoreTest extends TestCase {

	/**
	 * The fixture for this Connection Request Info Store test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionRequestInfoStore fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ConnectionRequestInfoStoreTest.class);
	}

	/**
	 * Constructs a new Connection Request Info Store test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionRequestInfoStoreTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Connection Request Info Store test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ConnectionRequestInfoStore fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Connection Request Info Store test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionRequestInfoStore getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SpiFactory.eINSTANCE.createConnectionRequestInfoStore());
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

} //ConnectionRequestInfoStoreTest
