/**
 */
package org.jboss.jca.adapters.sap.model.cci.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.jboss.jca.adapters.sap.model.cci.CciFactory;
import org.jboss.jca.adapters.sap.model.cci.InteractionSpec;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Interaction Spec</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class InteractionSpecTest extends TestCase {

	/**
	 * The fixture for this Interaction Spec test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InteractionSpec fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(InteractionSpecTest.class);
	}

	/**
	 * Constructs a new Interaction Spec test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionSpecTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Interaction Spec test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(InteractionSpec fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Interaction Spec test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InteractionSpec getFixture() {
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
		setFixture(CciFactory.eINSTANCE.createInteractionSpec());
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

} //InteractionSpecTest
