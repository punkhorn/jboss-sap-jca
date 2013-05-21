/**
 */
package org.jboss.jca.adapters.sap.model.spi.tests;

import java.util.Map;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.emf.ecore.EPackage;

import org.jboss.jca.adapters.sap.model.spi.SpiFactory;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Package Registry Entry</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PackageRegistryEntryTest extends TestCase {

	/**
	 * The fixture for this Package Registry Entry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map.Entry<String, EPackage> fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PackageRegistryEntryTest.class);
	}

	/**
	 * Constructs a new Package Registry Entry test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageRegistryEntryTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Package Registry Entry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Map.Entry<String, EPackage> fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Package Registry Entry test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map.Entry<String, EPackage> getFixture() {
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
		setFixture((Map.Entry<String, EPackage>)SpiFactory.eINSTANCE.create(SpiPackage.Literals.PACKAGE_REGISTRY_ENTRY));
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

} //PackageRegistryEntryTest
