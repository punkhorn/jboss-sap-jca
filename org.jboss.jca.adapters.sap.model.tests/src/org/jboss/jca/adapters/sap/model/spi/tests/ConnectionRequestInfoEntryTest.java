/**
 */
package org.jboss.jca.adapters.sap.model.spi.tests;

import java.util.Map;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.jboss.jca.adapters.sap.model.spi.SpiFactory;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Connection Request Info Entry</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConnectionRequestInfoEntryTest extends TestCase {

	/**
	 * The fixture for this Connection Request Info Entry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map.Entry<String, String> fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ConnectionRequestInfoEntryTest.class);
	}

	/**
	 * Constructs a new Connection Request Info Entry test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionRequestInfoEntryTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Connection Request Info Entry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Map.Entry<String, String> fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Connection Request Info Entry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map.Entry<String, String> getFixture() {
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
		setFixture((Map.Entry<String, String>)SpiFactory.eINSTANCE.create(SpiPackage.Literals.CONNECTION_REQUEST_INFO_ENTRY));
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

} //ConnectionRequestInfoEntryTest
