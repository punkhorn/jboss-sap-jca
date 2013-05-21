/**
 */
package org.jboss.jca.adapters.sap.model.spi.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.jboss.jca.adapters.sap.model.spi.ManagedConnection;
import org.jboss.jca.adapters.sap.model.spi.SpiFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Managed Connection</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ManagedConnectionTest extends TestCase {

	/**
	 * The fixture for this Managed Connection test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ManagedConnection fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ManagedConnectionTest.class);
	}

	/**
	 * Constructs a new Managed Connection test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedConnectionTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Managed Connection test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ManagedConnection fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Managed Connection test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ManagedConnection getFixture() {
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
		setFixture(SpiFactory.eINSTANCE.createManagedConnection());
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

} //ManagedConnectionTest
