/**
 */
package org.jboss.jca.adapters.sap.model.cci.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.jboss.jca.adapters.sap.model.cci.CciFactory;
import org.jboss.jca.adapters.sap.model.cci.ConnectionFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Connection Factory</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConnectionFactoryTest extends TestCase {

	/**
	 * The fixture for this Connection Factory test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionFactory fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ConnectionFactoryTest.class);
	}

	/**
	 * Constructs a new Connection Factory test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionFactoryTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Connection Factory test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ConnectionFactory fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Connection Factory test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionFactory getFixture() {
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
		setFixture(CciFactory.eINSTANCE.createConnectionFactory());
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

} //ConnectionFactoryTest
