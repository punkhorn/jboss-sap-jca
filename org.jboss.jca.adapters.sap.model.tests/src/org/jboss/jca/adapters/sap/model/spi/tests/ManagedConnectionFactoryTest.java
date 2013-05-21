/**
 */
package org.jboss.jca.adapters.sap.model.spi.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.model.spi.SpiFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Managed Connection Factory</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ManagedConnectionFactoryTest extends TestCase {

	/**
	 * The fixture for this Managed Connection Factory test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ManagedConnectionFactory fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ManagedConnectionFactoryTest.class);
	}

	/**
	 * Constructs a new Managed Connection Factory test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedConnectionFactoryTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Managed Connection Factory test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ManagedConnectionFactory fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Managed Connection Factory test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ManagedConnectionFactory getFixture() {
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
		setFixture(SpiFactory.eINSTANCE.createManagedConnectionFactory());
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

} //ManagedConnectionFactoryTest
