/**
 */
package org.jboss.jca.adapters.sap.model.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

import org.jboss.jca.adapters.sap.model.spi.tests.SpiTests;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>Jboss-sap-jca</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class JbossSapJcaAllTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new JbossSapJcaAllTests("Jboss-sap-jca Tests");
		suite.addTest(SpiTests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JbossSapJcaAllTests(String name) {
		super(name);
	}

} //JbossSapJcaAllTests
