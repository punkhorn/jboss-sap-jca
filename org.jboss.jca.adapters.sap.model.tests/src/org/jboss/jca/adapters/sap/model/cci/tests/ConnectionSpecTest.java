/**
 */
package org.jboss.jca.adapters.sap.model.cci.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.jboss.jca.adapters.sap.model.cci.CciFactory;
import org.jboss.jca.adapters.sap.model.cci.ConnectionSpec;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Connection Spec</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConnectionSpecTest extends TestCase {

	/**
	 * The fixture for this Connection Spec test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionSpec fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ConnectionSpecTest.class);
	}

	/**
	 * Constructs a new Connection Spec test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionSpecTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Connection Spec test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ConnectionSpec fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Connection Spec test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionSpec getFixture() {
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
		setFixture(CciFactory.eINSTANCE.createConnectionSpec());
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

} //ConnectionSpecTest
