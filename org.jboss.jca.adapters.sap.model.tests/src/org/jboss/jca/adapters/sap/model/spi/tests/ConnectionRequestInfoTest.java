/**
 */
package org.jboss.jca.adapters.sap.model.spi.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.model.spi.SpiFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Connection Request Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getAliasUser() <em>Alias User</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getAshost() <em>Ashost</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getAuthType() <em>Auth Type</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getClient() <em>Client</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getCodepage() <em>Codepage</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getCpicTrace() <em>Cpic Trace</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getDenyInitialPassword() <em>Deny Initial Password</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getExpirationPeriod() <em>Expiration Period</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getExpirationTime() <em>Expiration Time</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getGetsso2() <em>Getsso2</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getGroup() <em>Group</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getGwhost() <em>Gwhost</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getGwserv() <em>Gwserv</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getLang() <em>Lang</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getLcheck() <em>Lcheck</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getMaxGetTime() <em>Max Get Time</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getMshost() <em>Mshost</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getMsserv() <em>Msserv</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getMysapsso2() <em>Mysapsso2</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPasswd() <em>Passwd</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPassword() <em>Password</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPcs() <em>Pcs</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPeakLimit() <em>Peak Limit</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPingOnCreate() <em>Ping On Create</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPoolCapacity() <em>Pool Capacity</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getR3name() <em>R3name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositoryDest() <em>Repository Dest</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositoryPasswd() <em>Repository Passwd</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositoryRoundtripOptimization() <em>Repository Roundtrip Optimization</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositorySnc() <em>Repository Snc</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositoryUser() <em>Repository User</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSaprouter() <em>Saprouter</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncLibrary() <em>Snc Library</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncMode() <em>Snc Mode</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncMyname() <em>Snc Myname</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncPartnername() <em>Snc Partnername</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncQop() <em>Snc Qop</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSysnr() <em>Sysnr</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getTphost() <em>Tphost</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getTpname() <em>Tpname</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getTrace() <em>Trace</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getType() <em>Type</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getUserName() <em>User Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getUser() <em>User</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getUserId() <em>User Id</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getUseSapgui() <em>Use Sapgui</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getX509cert() <em>X50 9cert</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ConnectionRequestInfoTest extends TestCase {

	/**
	 * The fixture for this Connection Request Info test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionRequestInfo fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ConnectionRequestInfoTest.class);
	}

	/**
	 * Constructs a new Connection Request Info test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionRequestInfoTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Connection Request Info test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ConnectionRequestInfo fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Connection Request Info test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionRequestInfo getFixture() {
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
		setFixture(SpiFactory.eINSTANCE.createConnectionRequestInfo());
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

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getAliasUser() <em>Alias User</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getAliasUser()
	 * @generated
	 */
	public void testGetAliasUser() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setAliasUser(java.lang.String) <em>Alias User</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setAliasUser(java.lang.String)
	 * @generated
	 */
	public void testSetAliasUser() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getAshost() <em>Ashost</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getAshost()
	 * @generated
	 */
	public void testGetAshost() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setAshost(java.lang.String) <em>Ashost</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setAshost(java.lang.String)
	 * @generated
	 */
	public void testSetAshost() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getAuthType() <em>Auth Type</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getAuthType()
	 * @generated
	 */
	public void testGetAuthType() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setAuthType(java.lang.String) <em>Auth Type</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setAuthType(java.lang.String)
	 * @generated
	 */
	public void testSetAuthType() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getClient() <em>Client</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getClient()
	 * @generated
	 */
	public void testGetClient() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setClient(java.lang.String) <em>Client</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setClient(java.lang.String)
	 * @generated
	 */
	public void testSetClient() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getCodepage() <em>Codepage</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getCodepage()
	 * @generated
	 */
	public void testGetCodepage() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setCodepage(java.lang.String) <em>Codepage</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setCodepage(java.lang.String)
	 * @generated
	 */
	public void testSetCodepage() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getCpicTrace() <em>Cpic Trace</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getCpicTrace()
	 * @generated
	 */
	public void testGetCpicTrace() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setCpicTrace(java.lang.String) <em>Cpic Trace</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setCpicTrace(java.lang.String)
	 * @generated
	 */
	public void testSetCpicTrace() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getDenyInitialPassword() <em>Deny Initial Password</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getDenyInitialPassword()
	 * @generated
	 */
	public void testGetDenyInitialPassword() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setDenyInitialPassword(java.lang.String) <em>Deny Initial Password</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setDenyInitialPassword(java.lang.String)
	 * @generated
	 */
	public void testSetDenyInitialPassword() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getExpirationPeriod() <em>Expiration Period</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getExpirationPeriod()
	 * @generated
	 */
	public void testGetExpirationPeriod() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setExpirationPeriod(java.lang.String) <em>Expiration Period</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setExpirationPeriod(java.lang.String)
	 * @generated
	 */
	public void testSetExpirationPeriod() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getExpirationTime() <em>Expiration Time</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getExpirationTime()
	 * @generated
	 */
	public void testGetExpirationTime() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setExpirationTime(java.lang.String) <em>Expiration Time</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setExpirationTime(java.lang.String)
	 * @generated
	 */
	public void testSetExpirationTime() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getGetsso2() <em>Getsso2</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getGetsso2()
	 * @generated
	 */
	public void testGetGetsso2() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setGetsso2(java.lang.String) <em>Getsso2</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setGetsso2(java.lang.String)
	 * @generated
	 */
	public void testSetGetsso2() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getGroup() <em>Group</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getGroup()
	 * @generated
	 */
	public void testGetGroup() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setGroup(java.lang.String) <em>Group</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setGroup(java.lang.String)
	 * @generated
	 */
	public void testSetGroup() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getGwhost() <em>Gwhost</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getGwhost()
	 * @generated
	 */
	public void testGetGwhost() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setGwhost(java.lang.String) <em>Gwhost</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setGwhost(java.lang.String)
	 * @generated
	 */
	public void testSetGwhost() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getGwserv() <em>Gwserv</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getGwserv()
	 * @generated
	 */
	public void testGetGwserv() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setGwserv(java.lang.String) <em>Gwserv</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setGwserv(java.lang.String)
	 * @generated
	 */
	public void testSetGwserv() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getLang() <em>Lang</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getLang()
	 * @generated
	 */
	public void testGetLang() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setLang(java.lang.String) <em>Lang</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setLang(java.lang.String)
	 * @generated
	 */
	public void testSetLang() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getLcheck() <em>Lcheck</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getLcheck()
	 * @generated
	 */
	public void testGetLcheck() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setLcheck(java.lang.String) <em>Lcheck</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setLcheck(java.lang.String)
	 * @generated
	 */
	public void testSetLcheck() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getMaxGetTime() <em>Max Get Time</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getMaxGetTime()
	 * @generated
	 */
	public void testGetMaxGetTime() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setMaxGetTime(java.lang.String) <em>Max Get Time</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setMaxGetTime(java.lang.String)
	 * @generated
	 */
	public void testSetMaxGetTime() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getMshost() <em>Mshost</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getMshost()
	 * @generated
	 */
	public void testGetMshost() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setMshost(java.lang.String) <em>Mshost</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setMshost(java.lang.String)
	 * @generated
	 */
	public void testSetMshost() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getMsserv() <em>Msserv</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getMsserv()
	 * @generated
	 */
	public void testGetMsserv() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setMsserv(java.lang.String) <em>Msserv</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setMsserv(java.lang.String)
	 * @generated
	 */
	public void testSetMsserv() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getMysapsso2() <em>Mysapsso2</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getMysapsso2()
	 * @generated
	 */
	public void testGetMysapsso2() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setMysapsso2(java.lang.String) <em>Mysapsso2</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setMysapsso2(java.lang.String)
	 * @generated
	 */
	public void testSetMysapsso2() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPasswd() <em>Passwd</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPasswd()
	 * @generated
	 */
	public void testGetPasswd() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setPasswd(java.lang.String) <em>Passwd</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setPasswd(java.lang.String)
	 * @generated
	 */
	public void testSetPasswd() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPassword() <em>Password</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPassword()
	 * @generated
	 */
	public void testGetPassword() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setPassword(java.lang.String) <em>Password</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setPassword(java.lang.String)
	 * @generated
	 */
	public void testSetPassword() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPcs() <em>Pcs</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPcs()
	 * @generated
	 */
	public void testGetPcs() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setPcs(java.lang.String) <em>Pcs</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setPcs(java.lang.String)
	 * @generated
	 */
	public void testSetPcs() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPeakLimit() <em>Peak Limit</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPeakLimit()
	 * @generated
	 */
	public void testGetPeakLimit() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setPeakLimit(java.lang.String) <em>Peak Limit</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setPeakLimit(java.lang.String)
	 * @generated
	 */
	public void testSetPeakLimit() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPingOnCreate() <em>Ping On Create</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPingOnCreate()
	 * @generated
	 */
	public void testGetPingOnCreate() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setPingOnCreate(java.lang.String) <em>Ping On Create</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setPingOnCreate(java.lang.String)
	 * @generated
	 */
	public void testSetPingOnCreate() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPoolCapacity() <em>Pool Capacity</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getPoolCapacity()
	 * @generated
	 */
	public void testGetPoolCapacity() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setPoolCapacity(java.lang.String) <em>Pool Capacity</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setPoolCapacity(java.lang.String)
	 * @generated
	 */
	public void testSetPoolCapacity() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getR3name() <em>R3name</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getR3name()
	 * @generated
	 */
	public void testGetR3name() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setR3name(java.lang.String) <em>R3name</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setR3name(java.lang.String)
	 * @generated
	 */
	public void testSetR3name() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositoryDest() <em>Repository Dest</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositoryDest()
	 * @generated
	 */
	public void testGetRepositoryDest() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setRepositoryDest(java.lang.String) <em>Repository Dest</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setRepositoryDest(java.lang.String)
	 * @generated
	 */
	public void testSetRepositoryDest() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositoryPasswd() <em>Repository Passwd</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositoryPasswd()
	 * @generated
	 */
	public void testGetRepositoryPasswd() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setRepositoryPasswd(java.lang.String) <em>Repository Passwd</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setRepositoryPasswd(java.lang.String)
	 * @generated
	 */
	public void testSetRepositoryPasswd() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositoryRoundtripOptimization() <em>Repository Roundtrip Optimization</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositoryRoundtripOptimization()
	 * @generated
	 */
	public void testGetRepositoryRoundtripOptimization() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setRepositoryRoundtripOptimization(java.lang.String) <em>Repository Roundtrip Optimization</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setRepositoryRoundtripOptimization(java.lang.String)
	 * @generated
	 */
	public void testSetRepositoryRoundtripOptimization() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositorySnc() <em>Repository Snc</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositorySnc()
	 * @generated
	 */
	public void testGetRepositorySnc() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setRepositorySnc(java.lang.String) <em>Repository Snc</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setRepositorySnc(java.lang.String)
	 * @generated
	 */
	public void testSetRepositorySnc() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositoryUser() <em>Repository User</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getRepositoryUser()
	 * @generated
	 */
	public void testGetRepositoryUser() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setRepositoryUser(java.lang.String) <em>Repository User</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setRepositoryUser(java.lang.String)
	 * @generated
	 */
	public void testSetRepositoryUser() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSaprouter() <em>Saprouter</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSaprouter()
	 * @generated
	 */
	public void testGetSaprouter() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setSaprouter(java.lang.String) <em>Saprouter</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setSaprouter(java.lang.String)
	 * @generated
	 */
	public void testSetSaprouter() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncLibrary() <em>Snc Library</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncLibrary()
	 * @generated
	 */
	public void testGetSncLibrary() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setSncLibrary(java.lang.String) <em>Snc Library</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setSncLibrary(java.lang.String)
	 * @generated
	 */
	public void testSetSncLibrary() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncMode() <em>Snc Mode</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncMode()
	 * @generated
	 */
	public void testGetSncMode() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setSncMode(java.lang.String) <em>Snc Mode</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setSncMode(java.lang.String)
	 * @generated
	 */
	public void testSetSncMode() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncMyname() <em>Snc Myname</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncMyname()
	 * @generated
	 */
	public void testGetSncMyname() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setSncMyname(java.lang.String) <em>Snc Myname</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setSncMyname(java.lang.String)
	 * @generated
	 */
	public void testSetSncMyname() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncPartnername() <em>Snc Partnername</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncPartnername()
	 * @generated
	 */
	public void testGetSncPartnername() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setSncPartnername(java.lang.String) <em>Snc Partnername</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setSncPartnername(java.lang.String)
	 * @generated
	 */
	public void testSetSncPartnername() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncQop() <em>Snc Qop</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSncQop()
	 * @generated
	 */
	public void testGetSncQop() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setSncQop(java.lang.String) <em>Snc Qop</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setSncQop(java.lang.String)
	 * @generated
	 */
	public void testSetSncQop() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSysnr() <em>Sysnr</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getSysnr()
	 * @generated
	 */
	public void testGetSysnr() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setSysnr(java.lang.String) <em>Sysnr</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setSysnr(java.lang.String)
	 * @generated
	 */
	public void testSetSysnr() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getTphost() <em>Tphost</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getTphost()
	 * @generated
	 */
	public void testGetTphost() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setTphost(java.lang.String) <em>Tphost</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setTphost(java.lang.String)
	 * @generated
	 */
	public void testSetTphost() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getTpname() <em>Tpname</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getTpname()
	 * @generated
	 */
	public void testGetTpname() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setTpname(java.lang.String) <em>Tpname</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setTpname(java.lang.String)
	 * @generated
	 */
	public void testSetTpname() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getTrace() <em>Trace</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getTrace()
	 * @generated
	 */
	public void testGetTrace() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setTrace(java.lang.String) <em>Trace</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setTrace(java.lang.String)
	 * @generated
	 */
	public void testSetTrace() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getType() <em>Type</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getType()
	 * @generated
	 */
	public void testGetType() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setType(java.lang.String) <em>Type</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setType(java.lang.String)
	 * @generated
	 */
	public void testSetType() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getUserName() <em>User Name</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getUserName()
	 * @generated
	 */
	public void testGetUserName() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setUserName(java.lang.String) <em>User Name</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setUserName(java.lang.String)
	 * @generated
	 */
	public void testSetUserName() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getUser() <em>User</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getUser()
	 * @generated
	 */
	public void testGetUser() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setUser(java.lang.String) <em>User</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setUser(java.lang.String)
	 * @generated
	 */
	public void testSetUser() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getUserId() <em>User Id</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getUserId()
	 * @generated
	 */
	public void testGetUserId() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setUserId(java.lang.String) <em>User Id</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setUserId(java.lang.String)
	 * @generated
	 */
	public void testSetUserId() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getUseSapgui() <em>Use Sapgui</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getUseSapgui()
	 * @generated
	 */
	public void testGetUseSapgui() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setUseSapgui(java.lang.String) <em>Use Sapgui</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setUseSapgui(java.lang.String)
	 * @generated
	 */
	public void testSetUseSapgui() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getX509cert() <em>X50 9cert</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#getX509cert()
	 * @generated
	 */
	public void testGetX509cert() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setX509cert(java.lang.String) <em>X50 9cert</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo#setX509cert(java.lang.String)
	 * @generated
	 */
	public void testSetX509cert() {
		// TODO: implement this feature setter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //ConnectionRequestInfoTest
