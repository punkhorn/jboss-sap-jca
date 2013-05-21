/**
 */
package org.jboss.jca.adapters.sap.model.spi.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.jboss.jca.adapters.sap.model.spi.ResourceAdapter;
import org.jboss.jca.adapters.sap.model.spi.SpiFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Resource Adapter</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResourceAdapterTest extends TestCase {

	/**
	 * The fixture for this Resource Adapter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceAdapter fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ResourceAdapterTest.class);
	}

	/**
	 * Constructs a new Resource Adapter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceAdapterTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Resource Adapter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ResourceAdapter fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Resource Adapter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceAdapter getFixture() {
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
		setFixture(SpiFactory.eINSTANCE.createResourceAdapter());
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

} //ResourceAdapterTest
