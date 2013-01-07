package org.jboss.jca.adapters.sap.spi.impl;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterInternalException;
import javax.resource.spi.security.PasswordCredential;
import javax.security.auth.Subject;

import org.jboss.jca.adapters.sap.cci.impl.ConnectionFactoryImpl;
import org.jboss.jca.adapters.sap.spi.impl.ConnectionRequestInfoImpl;
import org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionFactoryImpl;
import org.jboss.jca.adapters.sap.spi.impl.ManagedConnectionImpl;
import org.jboss.jca.adapters.sap.spi.impl.ResourceAdapterImpl;
import org.junit.Before;
import org.junit.Test;

import com.sap.conn.jco.ext.DestinationDataProvider;

public class TestManagedConnectionFactoryImpl {
	
	private static final String TEST_AUTH_TYPE = "TEST_AUTH_TYPE";
	private static final String TEST_USER_ID = "TEST_USER_ID";
	private static final String TEST_CLIENT = "TEST_CLIENT";
	private static final String TEST_OTHER_CLIENT = "TEST_OTHER_CLIENT";
	private static final String TEST_USER = "TEST_USER";
	private static final String TEST_OTHER_USER = "TEST_OTHER_USER";
	private static final String TEST_ALIAS_USER = "TEST_ALIAS_USER";
	private static final String TEST_PASSWD = "TEST_PASSWD";
	private static final String TEST_OTHER_PASSWD = "TEST_OTHER_PASSWD";
	private static final String TEST_LANG = "TEST_LANG";
	private static final String TEST_MY_SAP_SSO2 = "TEST_MY_SAP_SSO2";
	private static final String TEST_X509_CERT = "TEST_X509_CERT";
	private static final String TEST_PCS = "TEST_PCS";
	private static final String TEST_TYPE = "TEST_TYPE";
	private static final String TEST_SAP_ROUTER = "TEST_SAP_ROUTER";
	private static final String TEST_SYSNR = "TEST_SYSNR";
	private static final String TEST_ASHOST = "TEST_ASHOST";
	private static final String TEST_MSHOST = "TEST_MSHOST";
	private static final String TEST_MSSERV = "TEST_MSSERV";
	private static final String TEST_GWHOST = "TEST_GWHOST";
	private static final String TEST_GWSEREV = "TEST_GWSEREV";
	private static final String TEST_TPHOST = "TEST_TPHOST";
	private static final String TEST_TPNAME = "TEST_TPNAME";
	private static final String TEST_R3NAME = "TEST_R3NAME";
	private static final String TEST_GROUP = "TEST_GROUP";
	private static final String TEST_TRACE = "TEST_TRACE";
	private static final String TEST_CPIC_TRACE = "TEST_CPIC_TRACE";
	private static final String TEST_LCHECK = "TEST_LCHECK";
	private static final String TEST_USE_SAP_GUI = "TEST_USE_SAP_GUI";
	private static final String TEST_CODE_PAGE = "TEST_CODE_PAGE";
	private static final String TEST_GET_SSO2 = "TEST_GET_SSO2";
	private static final String TEST_DENY_INITIAL_PASSWORD = "TEST_DENY_INITIAL_PASSWORD";
	private static final String TEST_PEAK_LIMIT = "TEST_PEAK_LIMIT";
	private static final String TEST_POOL_CAPACITY = "TEST_POOL_CAPACITY";
	private static final String TEST_EXPIRATION_TIME = "TEST_EXPIRATION_TIME";
	private static final String TEST_EXPIRATION_PERIOD = "TEST_EXPIRATION_PERIOD";
	private static final String TEST_SNC_MODE = "TEST_SNC_MODE";
	private static final String TEST_SNC_PARTNERNAME = "TEST_SNC_PARTNERNAME";
	private static final String TEST_SNC_QOP = "TEST_SNC_QOP";
	private static final String TEST_SNC_MYNAME = "TEST_SNC_MYNAME";
	private static final String TEST_SNC_LIBRARY = "TEST_SNC_LIBRARY";
	private static final String TEST_REPOSITORY_DEST = "TEST_REPOSITORY_DEST";
	private static final String TEST_REPOSITORY_USER = "TEST_REPOSITORY_USER";
	private static final String TEST_REPOSITORY_PASSWD = "TEST_REPOSITORY_PASSWD";
	private static final String TEST_REPOSITORY_SNC = "TEST_REPOSITORY_SNC";
	private static final String TEST_REPOSITORY_ROUNDTRIP_OPTIMAZATION = "TEST_REPOSITORY_ROUNDTRIP_OPTIMAZATION";
	private static final String TEST_MAX_GET_TIME = "TEST_MAX_GET_TIME";
	
	private static ResourceAdapterImpl resourceAdapter;

	static {
		resourceAdapter = new ResourceAdapterImpl();
		try {
			resourceAdapter.start(null);
		} catch (ResourceAdapterInternalException e) {
			throw new ExceptionInInitializerError(e);
		}

	}

	private ManagedConnectionFactoryImpl managedConnectionFactoryImpl;

	@Before
	public void setUp() throws Exception {
		// Given
		managedConnectionFactoryImpl = new ManagedConnectionFactoryImpl();
	}

	@Test
	public void testHashCodeOfDifferentManagedConnectionFactoriesWithSameConfiguration() {
		// Given
		ManagedConnectionFactoryImpl otherManagedConnectionFactory = new ManagedConnectionFactoryImpl();
		otherManagedConnectionFactory.setAshost(TEST_ASHOST);
		otherManagedConnectionFactory.setSysnr(TEST_SYSNR);
		otherManagedConnectionFactory.setClient(TEST_CLIENT);
		otherManagedConnectionFactory.setUser(TEST_USER);
		otherManagedConnectionFactory.setPasswd(TEST_PASSWD);
		otherManagedConnectionFactory.setLang(TEST_LANG);

		managedConnectionFactoryImpl.setAshost(TEST_ASHOST);
		managedConnectionFactoryImpl.setSysnr(TEST_SYSNR);
		managedConnectionFactoryImpl.setClient(TEST_CLIENT);
		managedConnectionFactoryImpl.setUser(TEST_USER);
		managedConnectionFactoryImpl.setPasswd(TEST_PASSWD);
		managedConnectionFactoryImpl.setLang(TEST_LANG);
		
		// When
		int hashcode = managedConnectionFactoryImpl.hashCode();
		int otherHashcode = otherManagedConnectionFactory.hashCode();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.hashCode() differs with hash code of other managed connection factory with same configuration", hashcode, is(otherHashcode));
	}

	@Test
	public void testHashCodeOfDifferentManagedConnectionFactoriesWithDifferentConfiguration() {
		// Given
		ManagedConnectionFactoryImpl otherManagedConnectionFactory = new ManagedConnectionFactoryImpl();
		otherManagedConnectionFactory.setAshost(TEST_ASHOST);
		otherManagedConnectionFactory.setSysnr(TEST_SYSNR);
		otherManagedConnectionFactory.setClient(TEST_CLIENT);
		otherManagedConnectionFactory.setUser(TEST_USER);
		otherManagedConnectionFactory.setPasswd(TEST_PASSWD);
		otherManagedConnectionFactory.setLang(TEST_LANG);
		otherManagedConnectionFactory.setUserId(TEST_USER_ID);

		managedConnectionFactoryImpl.setAshost(TEST_ASHOST);
		managedConnectionFactoryImpl.setSysnr(TEST_SYSNR);
		managedConnectionFactoryImpl.setClient(TEST_CLIENT);
		managedConnectionFactoryImpl.setUser(TEST_USER);
		managedConnectionFactoryImpl.setPasswd(TEST_PASSWD);
		managedConnectionFactoryImpl.setLang(TEST_LANG);
		
		// When
		int hashcode = managedConnectionFactoryImpl.hashCode();
		int otherHashcode = otherManagedConnectionFactory.hashCode();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.hashCode() differs with hash code of other managed connection factory with same configuration", hashcode, not(otherHashcode));
	}

	@Test
	public void testCreateConnectionFactoryWithConnectionManager() throws ResourceException {
		// Given
		ConnectionManager connectionManager = mock(ConnectionManager.class);
		
		// When
		Object connectionFactory = managedConnectionFactoryImpl.createConnectionFactory(connectionManager);
		
		// Then
		assertThat("managedConnectionFactory.createConnectionFactory() returned invalid type of connection factory", connectionFactory, instanceOf(ConnectionFactoryImpl.class));
	}

	@Test()
	public void testCreateManagedConnection() throws ResourceException {
		// Given
		managedConnectionFactoryImpl.setResourceAdapter(resourceAdapter);
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.createManagedConnection(null, null);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.createManagedConnection(subjectWithValidCredentials, null) returned null", managedConnection, notNullValue());
	}

	@Test
	public void testCreateConnectionFactoryWithoutConnectionManager() throws ResourceException {
		// When
		Object connectionFactory = managedConnectionFactoryImpl.createConnectionFactory();
		
		// Then
		assertThat("managedConnectionFactory.createConnectionFactory() returned invalid type of connection factory", connectionFactory, instanceOf(ConnectionFactoryImpl.class));
	}

	@Test(expected = ResourceException.class)
	public void testCreateManagedConnectionWithInvalidConnectionSpec() throws ResourceException {
		// Given
		ConnectionRequestInfo mockInvalidConnectionRequestInfo = mock(ConnectionRequestInfo.class);
		
		// When
		managedConnectionFactoryImpl.createManagedConnection(null, mockInvalidConnectionRequestInfo);
		
		// Then
		fail("ManagedConnectionFactoryImpl.createManagedConnection(null, invalidConnectionRequestInfo)() failed to throw ResourceException");
	}

	@Test(expected = SecurityException.class)
	public void testCreateManagedConnectionWithSubjectWithInsufficientCredentials() throws ResourceException {
		// Given
		Set<Principal> principals = new HashSet<Principal>();
		Set<PasswordCredential> publicCredentials = new HashSet<PasswordCredential>();
		Set<PasswordCredential> privateCredentials = new HashSet<PasswordCredential>();
		Subject subject = new Subject(false, principals, publicCredentials, privateCredentials);
		
		// When
		managedConnectionFactoryImpl.createManagedConnection(subject, null);
		
		// Then
		fail("ManagedConnectionFactoryImpl.createManagedConnection(subjectWithOutCredentials, invalid)() failed to throw ResourceException");
	}

	@Test(expected = SecurityException.class)
	public void testCreateManagedConnectionWithSubjectWithCredentialWithWrongConnectionFactory() throws ResourceException {
		// Given
		managedConnectionFactoryImpl.setResourceAdapter(resourceAdapter);
		ManagedConnectionFactoryImpl mockConnectionFactoryImpl = mock(ManagedConnectionFactoryImpl.class);
		Set<Principal> principals = new HashSet<Principal>();
		Set<PasswordCredential> publicCredentials = new HashSet<PasswordCredential>();
		Set<PasswordCredential> privateCredentials = new HashSet<PasswordCredential>();
		PasswordCredential passwordCredential = new PasswordCredential(TEST_USER, TEST_PASSWD.toCharArray());
		passwordCredential.setManagedConnectionFactory(mockConnectionFactoryImpl);
		privateCredentials.add(passwordCredential);
		Subject subjectWithValidCredentials = new Subject(false, principals, publicCredentials, privateCredentials);
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.createManagedConnection(subjectWithValidCredentials, null);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.createManagedConnection(subjectWithValidCredentials, null) returned null", managedConnection, notNullValue());
	}

	@Test(expected = SecurityException.class)
	public void testCreateManagedConnectionWithSubjectWithCredentialWithNullConnectionFactory() throws ResourceException {
		// Given
		managedConnectionFactoryImpl.setResourceAdapter(resourceAdapter);
		Set<Principal> principals = new HashSet<Principal>();
		Set<PasswordCredential> publicCredentials = new HashSet<PasswordCredential>();
		Set<PasswordCredential> privateCredentials = new HashSet<PasswordCredential>();
		PasswordCredential passwordCredential = new PasswordCredential(TEST_USER, TEST_PASSWD.toCharArray());
		passwordCredential.setManagedConnectionFactory(null);
		privateCredentials.add(passwordCredential);
		Subject subjectWithValidCredentials = new Subject(false, principals, publicCredentials, privateCredentials);
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.createManagedConnection(subjectWithValidCredentials, null);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.createManagedConnection(subjectWithValidCredentials, null) returned null", managedConnection, notNullValue());
	}

	@Test()
	public void testCreateManagedConnectionWithSubjectWithValidCredentials() throws ResourceException {
		// Given
		managedConnectionFactoryImpl.setResourceAdapter(resourceAdapter);
		Set<Principal> principals = new HashSet<Principal>();
		Set<PasswordCredential> publicCredentials = new HashSet<PasswordCredential>();
		Set<PasswordCredential> privateCredentials = new HashSet<PasswordCredential>();
		PasswordCredential passwordCredential = new PasswordCredential(TEST_USER, TEST_PASSWD.toCharArray());
		passwordCredential.setManagedConnectionFactory(managedConnectionFactoryImpl);
		privateCredentials.add(passwordCredential);
		Subject subjectWithValidCredentials = new Subject(false, principals, publicCredentials, privateCredentials);
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.createManagedConnection(subjectWithValidCredentials, null);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.createManagedConnection(subjectWithValidCredentials, null) returned null", managedConnection, notNullValue());
	}

	@Test
	public void testCreateManagedConnectionWithValidCredentialsAndConnectionSpec() throws ResourceException {
		managedConnectionFactoryImpl.setResourceAdapter(resourceAdapter);
		Set<Principal> principals = new HashSet<Principal>();
		Set<PasswordCredential> publicCredentials = new HashSet<PasswordCredential>();
		Set<PasswordCredential> privateCredentials = new HashSet<PasswordCredential>();
		PasswordCredential passwordCredential = new PasswordCredential(TEST_USER, TEST_PASSWD.toCharArray());
		passwordCredential.setManagedConnectionFactory(managedConnectionFactoryImpl);
		privateCredentials.add(passwordCredential);
		Subject subjectWithValidCredentials = new Subject(false, principals, publicCredentials, privateCredentials);
		ConnectionRequestInfo connectionRequestInfo = new ConnectionRequestInfoImpl();
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.createManagedConnection(subjectWithValidCredentials, connectionRequestInfo);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.createManagedConnection(subjectWithValidCredentials, null) returned null", managedConnection, notNullValue());
	}

	@Test
	public void testMatchManagedConnectionsWithNullConnectionSet() throws ResourceException {
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.matchManagedConnections(null, null, null);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.matchManagedConnections(null,null,null) did not return null", managedConnection, nullValue());
	}

	@Test
	public void testMatchManagedConnectionsWithInvalidConnectionRequestInfo() throws ResourceException {
		//Given
		ConnectionRequestInfo invalidTypeOfConnectionRequestInfo = mock(ConnectionRequestInfo.class);
		Set<ManagedConnectionImpl> emptyConnectionSet = new HashSet<ManagedConnectionImpl>();
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.matchManagedConnections(emptyConnectionSet, null, invalidTypeOfConnectionRequestInfo);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.matchManagedConnections(emptyConnectionSet, null, invalidTypeOfConnectionRequestInfo) did not return null", managedConnection, nullValue());
	}

	@Test
	public void testMatchManagedConnectionsWithInsufficientCredentials() throws ResourceException {
		//Given
		Set<Principal> principals = new HashSet<Principal>();
		Set<PasswordCredential> publicCredentials = new HashSet<PasswordCredential>();
		Set<PasswordCredential> privateCredentials = new HashSet<PasswordCredential>();
		Subject subjectWithInsufficientCredentials = new Subject(false, principals, publicCredentials, privateCredentials);
		Set<ManagedConnectionImpl> emptyConnectionSet = new HashSet<ManagedConnectionImpl>();
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.matchManagedConnections(emptyConnectionSet, subjectWithInsufficientCredentials, null);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.matchManagedConnections(emptyConnectionSet, subjectWithInsufficientCredentials, null) did not return null", managedConnection, nullValue());
	}

	@Test
	public void testMatchManagedConnectionsWithCredentialWithWrongConnectionFactory() throws ResourceException {
		//Given
		ManagedConnectionFactoryImpl mockConnectionFactoryImpl = mock(ManagedConnectionFactoryImpl.class);
		Set<Principal> principals = new HashSet<Principal>();
		Set<PasswordCredential> publicCredentials = new HashSet<PasswordCredential>();
		Set<PasswordCredential> privateCredentials = new HashSet<PasswordCredential>();
		PasswordCredential passwordCredential = new PasswordCredential(TEST_USER, TEST_PASSWD.toCharArray());
		passwordCredential.setManagedConnectionFactory(mockConnectionFactoryImpl);
		privateCredentials.add(passwordCredential);
		Subject subjectWithCredentialsWithWrongConnectionFactory = new Subject(false, principals, publicCredentials, privateCredentials);
		Set<ManagedConnectionImpl> emptyConnectionSet = new HashSet<ManagedConnectionImpl>();
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.matchManagedConnections(emptyConnectionSet, subjectWithCredentialsWithWrongConnectionFactory, null);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.matchManagedConnections(emptyConnectionSet, subjectWithCredentialsWithWrongConnectionFactory, null) did not return null", managedConnection, nullValue());
	}

	@Test
	public void testMatchManagedConnectionsWithCredentialWithNullConnectionFactory() throws ResourceException {
		//Given
		Set<Principal> principals = new HashSet<Principal>();
		Set<PasswordCredential> publicCredentials = new HashSet<PasswordCredential>();
		Set<PasswordCredential> privateCredentials = new HashSet<PasswordCredential>();
		PasswordCredential passwordCredential = new PasswordCredential(TEST_USER, TEST_PASSWD.toCharArray());
		passwordCredential.setManagedConnectionFactory(null);
		privateCredentials.add(passwordCredential);
		Subject subjectWithCredentialsWithNullConnectionFactory = new Subject(false, principals, publicCredentials, privateCredentials);
		Set<ManagedConnectionImpl> emptyConnectionSet = new HashSet<ManagedConnectionImpl>();
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.matchManagedConnections(emptyConnectionSet, subjectWithCredentialsWithNullConnectionFactory, null);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.matchManagedConnections(emptyConnectionSet, subjectWithCredentialsWithNullConnectionFactory, null) did not return null", managedConnection, nullValue());
	}

	@Test
	public void testMatchManagedConnectionsWithValidCredentialsAndEmptyConnectionSet() throws ResourceException {
		//Given
		Set<Principal> principals = new HashSet<Principal>();
		Set<PasswordCredential> publicCredentials = new HashSet<PasswordCredential>();
		Set<PasswordCredential> privateCredentials = new HashSet<PasswordCredential>();
		PasswordCredential passwordCredential = new PasswordCredential(TEST_USER, TEST_PASSWD.toCharArray());
		passwordCredential.setManagedConnectionFactory(managedConnectionFactoryImpl);
		privateCredentials.add(passwordCredential);
		Subject subjectWithValidCredentials = new Subject(false, principals, publicCredentials, privateCredentials);
		Set<ManagedConnectionImpl> emptyConnectionSet = new HashSet<ManagedConnectionImpl>();
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.matchManagedConnections(emptyConnectionSet, subjectWithValidCredentials, null);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.matchManagedConnections(emptyConnectionSet, subjectWithValidCredentials, null) did not return null", managedConnection, nullValue());
	}

	@Test
	public void testMatchManagedConnectionsWithValidCredentialsAndNonMatchingConnectionSet() throws ResourceException {
		//Given
		Set<Principal> principals = new HashSet<Principal>();
		Set<PasswordCredential> publicCredentials = new HashSet<PasswordCredential>();
		Set<PasswordCredential> privateCredentials = new HashSet<PasswordCredential>();
		PasswordCredential passwordCredential = new PasswordCredential(TEST_USER, TEST_PASSWD.toCharArray());
		passwordCredential.setManagedConnectionFactory(managedConnectionFactoryImpl);
		privateCredentials.add(passwordCredential);
		Subject subjectWithValidCredentials = new Subject(false, principals, publicCredentials, privateCredentials);
		Set<ManagedConnectionImpl> connectionSetWithNoCredentialsMatch = new HashSet<ManagedConnectionImpl>();
		
		ConnectionRequestInfoImpl connectionSpecWithNonMatchingUsername = new ConnectionRequestInfoImpl();
		connectionSpecWithNonMatchingUsername.setUserName(TEST_OTHER_USER);
		ManagedConnectionImpl mockManagedConnectionWithNonMatchingUserName = mock(ManagedConnectionImpl.class);
		when(mockManagedConnectionWithNonMatchingUserName.getProperties()).thenReturn(connectionSpecWithNonMatchingUsername);
		ManagedConnectionImpl mockManagedConnectionWithNonMatchingPassword = mock(ManagedConnectionImpl.class);
		ConnectionRequestInfoImpl connectionSpecWithNonMatchingPassword = new ConnectionRequestInfoImpl();
		connectionSpecWithNonMatchingPassword.setUserName(TEST_USER);
		connectionSpecWithNonMatchingPassword.setPassword(TEST_OTHER_PASSWD);
		when(mockManagedConnectionWithNonMatchingPassword.getProperties()).thenReturn(connectionSpecWithNonMatchingPassword);
		connectionSetWithNoCredentialsMatch.add(mockManagedConnectionWithNonMatchingPassword);
		connectionSetWithNoCredentialsMatch.add(mockManagedConnectionWithNonMatchingUserName);
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.matchManagedConnections(connectionSetWithNoCredentialsMatch, subjectWithValidCredentials, null);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.matchManagedConnections(connectionSpecWithNonMatchingUsername, subjectWithValidCredentials, null) did not return null", managedConnection, nullValue());
	}

	@Test
	public void testMatchManagedConnectionsWithConnectionSetWithNullUserName() throws ResourceException {
		//Given
		Set<Principal> principals = new HashSet<Principal>();
		Set<PasswordCredential> publicCredentials = new HashSet<PasswordCredential>();
		Set<PasswordCredential> privateCredentials = new HashSet<PasswordCredential>();
		PasswordCredential passwordCredential = new PasswordCredential(TEST_USER, TEST_PASSWD.toCharArray());
		passwordCredential.setManagedConnectionFactory(managedConnectionFactoryImpl);
		privateCredentials.add(passwordCredential);
		Subject subjectWithValidCredentials = new Subject(false, principals, publicCredentials, privateCredentials);
		Set<ManagedConnectionImpl> connectionSetWithConnectionWithNullUserName = new HashSet<ManagedConnectionImpl>();
		
		ManagedConnectionImpl mockManagedConnectionWithNullUsername = mock(ManagedConnectionImpl.class);
		ConnectionRequestInfoImpl connectionSpecWithMatchingUsernameAndPassword = new ConnectionRequestInfoImpl();
		connectionSpecWithMatchingUsernameAndPassword.setPassword(TEST_PASSWD);
		when(mockManagedConnectionWithNullUsername.getProperties()).thenReturn(connectionSpecWithMatchingUsernameAndPassword);
		connectionSetWithConnectionWithNullUserName.add(mockManagedConnectionWithNullUsername);
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.matchManagedConnections(connectionSetWithConnectionWithNullUserName, subjectWithValidCredentials, null);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.matchManagedConnections(connectionSetWithConnectionWithNullUserName, subjectWithValidCredentials, null) did not return null", managedConnection, nullValue());
	}

	@Test
	public void testMatchManagedConnectionsWithConnectionSetWithDifferentUserName() throws ResourceException {
		//Given
		Set<Principal> principals = new HashSet<Principal>();
		Set<PasswordCredential> publicCredentials = new HashSet<PasswordCredential>();
		Set<PasswordCredential> privateCredentials = new HashSet<PasswordCredential>();
		PasswordCredential passwordCredential = new PasswordCredential(TEST_USER, TEST_PASSWD.toCharArray());
		passwordCredential.setManagedConnectionFactory(managedConnectionFactoryImpl);
		privateCredentials.add(passwordCredential);
		Subject subjectWithValidCredentials = new Subject(false, principals, publicCredentials, privateCredentials);
		Set<ManagedConnectionImpl> connectionSetWithConnectionWithOtherUserName = new HashSet<ManagedConnectionImpl>();
		
		ManagedConnectionImpl mockManagedConnectionWithOtherUsername = mock(ManagedConnectionImpl.class);
		ConnectionRequestInfoImpl connectionSpecWithMatchingUsernameAndPassword = new ConnectionRequestInfoImpl();
		connectionSpecWithMatchingUsernameAndPassword.setUserName(TEST_OTHER_USER);
		connectionSpecWithMatchingUsernameAndPassword.setPassword(TEST_PASSWD);
		when(mockManagedConnectionWithOtherUsername.getProperties()).thenReturn(connectionSpecWithMatchingUsernameAndPassword);
		connectionSetWithConnectionWithOtherUserName.add(mockManagedConnectionWithOtherUsername);
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.matchManagedConnections(connectionSetWithConnectionWithOtherUserName, subjectWithValidCredentials, null);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.matchManagedConnections(connectionSetWithConnectionWithOtherUserName, subjectWithValidCredentials, null) did not return null", managedConnection, nullValue());
	}

	@Test
	public void testMatchManagedConnectionsWithConnectionSetWithNullPassword() throws ResourceException {
		//Given
		Set<Principal> principals = new HashSet<Principal>();
		Set<PasswordCredential> publicCredentials = new HashSet<PasswordCredential>();
		Set<PasswordCredential> privateCredentials = new HashSet<PasswordCredential>();
		PasswordCredential passwordCredential = new PasswordCredential(TEST_USER, TEST_PASSWD.toCharArray());
		passwordCredential.setManagedConnectionFactory(managedConnectionFactoryImpl);
		privateCredentials.add(passwordCredential);
		Subject subjectWithValidCredentials = new Subject(false, principals, publicCredentials, privateCredentials);
		Set<ManagedConnectionImpl> connectionSetWithConnectionWithNullPassword = new HashSet<ManagedConnectionImpl>();
		
		ManagedConnectionImpl mockManagedConnectionWithNullPassword = mock(ManagedConnectionImpl.class);
		ConnectionRequestInfoImpl connectionSpecWithMatchingUsernameAndPassword = new ConnectionRequestInfoImpl();
		connectionSpecWithMatchingUsernameAndPassword.setUserName(TEST_USER);
		when(mockManagedConnectionWithNullPassword.getProperties()).thenReturn(connectionSpecWithMatchingUsernameAndPassword);
		connectionSetWithConnectionWithNullPassword.add(mockManagedConnectionWithNullPassword);
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.matchManagedConnections(connectionSetWithConnectionWithNullPassword, subjectWithValidCredentials, null);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.matchManagedConnections(connectionSetWithConnectionWithNullPassword, subjectWithValidCredentials, null) did not return null", managedConnection, nullValue());
	}

	@Test
	public void testMatchManagedConnectionsWithConnectionSetWithOtherPassword() throws ResourceException {
		//Given
		Set<Principal> principals = new HashSet<Principal>();
		Set<PasswordCredential> publicCredentials = new HashSet<PasswordCredential>();
		Set<PasswordCredential> privateCredentials = new HashSet<PasswordCredential>();
		PasswordCredential passwordCredential = new PasswordCredential(TEST_USER, TEST_PASSWD.toCharArray());
		passwordCredential.setManagedConnectionFactory(managedConnectionFactoryImpl);
		privateCredentials.add(passwordCredential);
		Subject subjectWithValidCredentials = new Subject(false, principals, publicCredentials, privateCredentials);
		Set<ManagedConnectionImpl> connectionSetWithConnectionWithOtherPassword = new HashSet<ManagedConnectionImpl>();
		
		ManagedConnectionImpl mockManagedConnectionWithOtherPassword = mock(ManagedConnectionImpl.class);
		ConnectionRequestInfoImpl connectionSpecWithMatchingUsernameAndPassword = new ConnectionRequestInfoImpl();
		connectionSpecWithMatchingUsernameAndPassword.setUserName(TEST_USER);
		connectionSpecWithMatchingUsernameAndPassword.setPassword(TEST_OTHER_PASSWD);
		when(mockManagedConnectionWithOtherPassword.getProperties()).thenReturn(connectionSpecWithMatchingUsernameAndPassword);
		connectionSetWithConnectionWithOtherPassword.add(mockManagedConnectionWithOtherPassword);
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.matchManagedConnections(connectionSetWithConnectionWithOtherPassword, subjectWithValidCredentials, null);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.matchManagedConnections(connectionSetWithConnectionWithOtherPassword, subjectWithValidCredentials, null) did not return null", managedConnection, nullValue());
	}

	@Test
	public void testMatchManagedConnectionsWithValidCredentialsAndMatchingConnectionSet() throws ResourceException {
		//Given
		Set<Principal> principals = new HashSet<Principal>();
		Set<PasswordCredential> publicCredentials = new HashSet<PasswordCredential>();
		Set<PasswordCredential> privateCredentials = new HashSet<PasswordCredential>();
		PasswordCredential passwordCredential = new PasswordCredential(TEST_USER, TEST_PASSWD.toCharArray());
		passwordCredential.setManagedConnectionFactory(managedConnectionFactoryImpl);
		privateCredentials.add(passwordCredential);
		Subject subjectWithValidCredentials = new Subject(false, principals, publicCredentials, privateCredentials);
		Set<ManagedConnectionImpl> connectionSetWithCredentialsMatch = new HashSet<ManagedConnectionImpl>();
		
		ManagedConnectionImpl mockManagedConnectionWithMatchingUsernameAndPassword = mock(ManagedConnectionImpl.class);
		ConnectionRequestInfoImpl connectionSpecWithMatchingUsernameAndPassword = new ConnectionRequestInfoImpl();
		connectionSpecWithMatchingUsernameAndPassword.setUserName(TEST_USER);
		connectionSpecWithMatchingUsernameAndPassword.setPassword(TEST_PASSWD);
		when(mockManagedConnectionWithMatchingUsernameAndPassword.getProperties()).thenReturn(connectionSpecWithMatchingUsernameAndPassword);
		connectionSetWithCredentialsMatch.add(mockManagedConnectionWithMatchingUsernameAndPassword);
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.matchManagedConnections(connectionSetWithCredentialsMatch, subjectWithValidCredentials, null);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.matchManagedConnections(connectionSetWithCredentialsMatch, subjectWithValidCredentials, null) did not return matching connection", managedConnection, is((ManagedConnection)mockManagedConnectionWithMatchingUsernameAndPassword));
	}

	@Test
	public void testMatchManagedConnectionsWithMatchingNullUserNames() throws ResourceException {
		//Given
		Set<Principal> principals = new HashSet<Principal>();
		Set<PasswordCredential> publicCredentials = new HashSet<PasswordCredential>();
		Set<PasswordCredential> privateCredentials = new HashSet<PasswordCredential>();
		PasswordCredential passwordCredential = new PasswordCredential(null, TEST_PASSWD.toCharArray());
		passwordCredential.setManagedConnectionFactory(managedConnectionFactoryImpl);
		privateCredentials.add(passwordCredential);
		Subject subjectWithValidCredentials = new Subject(false, principals, publicCredentials, privateCredentials);
		Set<ManagedConnectionImpl> connectionSetWithaMatchingNullUsername = new HashSet<ManagedConnectionImpl>();
		
		ManagedConnectionImpl mockManagedConnectionWithMatchingNullUsername = mock(ManagedConnectionImpl.class);
		ConnectionRequestInfoImpl connectionSpecWithMatchingUsernameAndPassword = new ConnectionRequestInfoImpl();
		connectionSpecWithMatchingUsernameAndPassword.setPassword(TEST_PASSWD);
		when(mockManagedConnectionWithMatchingNullUsername.getProperties()).thenReturn(connectionSpecWithMatchingUsernameAndPassword);
		connectionSetWithaMatchingNullUsername.add(mockManagedConnectionWithMatchingNullUsername);
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.matchManagedConnections(connectionSetWithaMatchingNullUsername, subjectWithValidCredentials, null);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.matchManagedConnections(connectionSetWithaMatchingNullUsername, subjectWithValidCredentials, null) did not return matching connection", managedConnection, is((ManagedConnection)mockManagedConnectionWithMatchingNullUsername));
	}

	@Test
	public void testMatchManagedConnectionsWithMatchingEmptyPassword() throws ResourceException {
		//Given
		Set<Principal> principals = new HashSet<Principal>();
		Set<PasswordCredential> publicCredentials = new HashSet<PasswordCredential>();
		Set<PasswordCredential> privateCredentials = new HashSet<PasswordCredential>();
		PasswordCredential passwordCredential = new PasswordCredential(TEST_USER, new char[0]);
		passwordCredential.setManagedConnectionFactory(managedConnectionFactoryImpl);
		privateCredentials.add(passwordCredential);
		Subject subjectWithValidCredentials = new Subject(false, principals, publicCredentials, privateCredentials);
		Set<ManagedConnectionImpl> connectionSetWithaMatchingEmptyPassword = new HashSet<ManagedConnectionImpl>();
		
		ManagedConnectionImpl mockManagedConnectionWithMatchingEmptyPassword = mock(ManagedConnectionImpl.class);
		ConnectionRequestInfoImpl connectionSpecWithMatchingUsernameAndPassword = new ConnectionRequestInfoImpl();
		connectionSpecWithMatchingUsernameAndPassword.setUserName(TEST_USER);
		when(mockManagedConnectionWithMatchingEmptyPassword.getProperties()).thenReturn(connectionSpecWithMatchingUsernameAndPassword);
		connectionSetWithaMatchingEmptyPassword.add(mockManagedConnectionWithMatchingEmptyPassword);
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.matchManagedConnections(connectionSetWithaMatchingEmptyPassword, subjectWithValidCredentials, null);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.matchManagedConnections(connectionSetWithaMatchingEmptyPassword, subjectWithValidCredentials, null) did not return matching connection", managedConnection, is((ManagedConnection)mockManagedConnectionWithMatchingEmptyPassword));
	}

	@Test
	public void testMatchManagedConnectionsWithValidCredentialsAndMatchingConnectionSetAndOverriddenConnectionRequestInfo() throws ResourceException {
		//Given
		Set<Principal> principals = new HashSet<Principal>();
		Set<PasswordCredential> publicCredentials = new HashSet<PasswordCredential>();
		Set<PasswordCredential> privateCredentials = new HashSet<PasswordCredential>();
		PasswordCredential passwordCredential = new PasswordCredential(TEST_USER, TEST_PASSWD.toCharArray());
		passwordCredential.setManagedConnectionFactory(managedConnectionFactoryImpl);
		privateCredentials.add(passwordCredential);
		Subject subjectWithValidCredentials = new Subject(false, principals, publicCredentials, privateCredentials);
		Set<ManagedConnectionImpl> connectionSetWithCredentialsMatch = new HashSet<ManagedConnectionImpl>();
		
		ManagedConnectionImpl mockManagedConnectionWithMatchingUsernameAndPassword = mock(ManagedConnectionImpl.class);
		ConnectionRequestInfoImpl connectionSpecWithMatchingUsernameAndPassword = new ConnectionRequestInfoImpl();
		connectionSpecWithMatchingUsernameAndPassword.setUserName(TEST_USER);
		connectionSpecWithMatchingUsernameAndPassword.setPassword(TEST_PASSWD);
		when(mockManagedConnectionWithMatchingUsernameAndPassword.getProperties()).thenReturn(connectionSpecWithMatchingUsernameAndPassword);
		connectionSetWithCredentialsMatch.add(mockManagedConnectionWithMatchingUsernameAndPassword);
		
		ConnectionRequestInfoImpl overriddedConnectionRequestInfo = new ConnectionRequestInfoImpl();
		overriddedConnectionRequestInfo.setUserName(TEST_OTHER_USER);
		overriddedConnectionRequestInfo.setPassword(TEST_OTHER_PASSWD);
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.matchManagedConnections(connectionSetWithCredentialsMatch, subjectWithValidCredentials, overriddedConnectionRequestInfo);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.matchManagedConnections(connectionSetWithCredentialsMatch, subjectWithValidCredentials, overriddedConnectionRequestInfo) did not return matching connection", managedConnection, is((ManagedConnection)mockManagedConnectionWithMatchingUsernameAndPassword));
	}

	@Test
	public void testMatchManagedConnectionsWithConnectionRequestInfoWithExtraProperty() throws ResourceException {
		//Given
		Set<ManagedConnectionImpl> connectionSetWithMatchingUsernameAndPassword = new HashSet<ManagedConnectionImpl>();
		
		ManagedConnectionImpl mockManagedConnectionWithMatchingUsernameAndPassword = mock(ManagedConnectionImpl.class);
		ConnectionRequestInfoImpl connectionSpecWithMatchingUsernameAndPassword = new ConnectionRequestInfoImpl();
		connectionSpecWithMatchingUsernameAndPassword.setUserName(TEST_USER);
		connectionSpecWithMatchingUsernameAndPassword.setPassword(TEST_PASSWD);
		when(mockManagedConnectionWithMatchingUsernameAndPassword.getProperties()).thenReturn(connectionSpecWithMatchingUsernameAndPassword);
		connectionSetWithMatchingUsernameAndPassword.add(mockManagedConnectionWithMatchingUsernameAndPassword);
		
		/* Create Connection Request that is a superset of candidate connection's properties. */
		ConnectionRequestInfoImpl connectionRequestInfoWithExtraProperty = new ConnectionRequestInfoImpl();
		connectionRequestInfoWithExtraProperty.setUserName(TEST_USER);
		connectionRequestInfoWithExtraProperty.setPassword(TEST_PASSWD);
		connectionRequestInfoWithExtraProperty.setProperty(DestinationDataProvider.JCO_CLIENT, TEST_CLIENT);
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.matchManagedConnections(connectionSetWithMatchingUsernameAndPassword, null, connectionRequestInfoWithExtraProperty);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.matchManagedConnections(connectionSetWithMatchingUsernameAndPassword, null, connectionRequestInfoWithExtraProperty) did not return null", managedConnection, nullValue());
	}

	@Test
	public void testMatchManagedConnectionsWithConnectionRequestInfoWithNonMatchingProperty() throws ResourceException {
		//Given
		Set<ManagedConnectionImpl> connectionSetWithMatchingUsernameAndPassword = new HashSet<ManagedConnectionImpl>();
		
		ManagedConnectionImpl mockManagedConnectionWithMatchingUsernameAndPassword = mock(ManagedConnectionImpl.class);
		ConnectionRequestInfoImpl connectionSpecWithMatchingUsernameAndPassword = new ConnectionRequestInfoImpl();
		connectionSpecWithMatchingUsernameAndPassword.setUserName(TEST_USER);
		connectionSpecWithMatchingUsernameAndPassword.setPassword(TEST_PASSWD);
		connectionSpecWithMatchingUsernameAndPassword.setProperty(DestinationDataProvider.JCO_CLIENT, TEST_CLIENT);
		when(mockManagedConnectionWithMatchingUsernameAndPassword.getProperties()).thenReturn(connectionSpecWithMatchingUsernameAndPassword);
		connectionSetWithMatchingUsernameAndPassword.add(mockManagedConnectionWithMatchingUsernameAndPassword);
		
		/* Create Connection Request that is a superset of candidate connection's properties. */
		ConnectionRequestInfoImpl connectionRequestInfoWithNonMatchingProperty = new ConnectionRequestInfoImpl();
		connectionRequestInfoWithNonMatchingProperty.setUserName(TEST_USER);
		connectionRequestInfoWithNonMatchingProperty.setPassword(TEST_PASSWD);
		connectionRequestInfoWithNonMatchingProperty.setProperty(DestinationDataProvider.JCO_CLIENT, TEST_OTHER_CLIENT);
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.matchManagedConnections(connectionSetWithMatchingUsernameAndPassword, null, connectionRequestInfoWithNonMatchingProperty);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.matchManagedConnections(connectionSetWithMatchingUsernameAndPassword, null, connectionRequestInfoWithNonMatchingProperty) did not return null", managedConnection, nullValue());
	}

	@Test
	public void testMatchManagedConnectionsWithSubsetConnectionRequestInfo() throws ResourceException {
		//Given
		Set<ManagedConnectionImpl> connectionSetWithMatchingProperties = new HashSet<ManagedConnectionImpl>();
		
		ManagedConnectionImpl mockManagedConnectionWithSupersetOfProperties = mock(ManagedConnectionImpl.class);
		ConnectionRequestInfoImpl connectionSpecWithSupersetOfProperties = new ConnectionRequestInfoImpl();
		connectionSpecWithSupersetOfProperties.setUserName(TEST_USER);
		connectionSpecWithSupersetOfProperties.setPassword(TEST_PASSWD);
		connectionSpecWithSupersetOfProperties.setProperty(DestinationDataProvider.JCO_CLIENT, TEST_CLIENT);
		connectionSpecWithSupersetOfProperties.setProperty(DestinationDataProvider.JCO_SYSNR, TEST_SYSNR);
		when(mockManagedConnectionWithSupersetOfProperties.getProperties()).thenReturn(connectionSpecWithSupersetOfProperties);
		connectionSetWithMatchingProperties.add(mockManagedConnectionWithSupersetOfProperties);
		
		/* Create Connection Request that is a superset of candidate connection's properties. */
		ConnectionRequestInfoImpl connectionRequestInfoWithSubsetOfMatchingProperties = new ConnectionRequestInfoImpl();
		connectionRequestInfoWithSubsetOfMatchingProperties.setUserName(TEST_USER);
		connectionRequestInfoWithSubsetOfMatchingProperties.setPassword(TEST_PASSWD);
		connectionRequestInfoWithSubsetOfMatchingProperties.setProperty(DestinationDataProvider.JCO_CLIENT, TEST_CLIENT);
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.matchManagedConnections(connectionSetWithMatchingProperties, null, connectionRequestInfoWithSubsetOfMatchingProperties);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.matchManagedConnections(connectionSetWithMatchingProperties, null, connectionRequestInfoWithSubsetOfMatchingProperties) did not return null", managedConnection, is((ManagedConnection)mockManagedConnectionWithSupersetOfProperties));
	}

	@Test
	public void testMatchManagedConnectionsWithConnectionRequestInfoWithDefaultProperties() throws ResourceException {
		//Given
		Set<ManagedConnectionImpl> connectionSetWithMatchingProperties = new HashSet<ManagedConnectionImpl>();
		
		ManagedConnectionImpl mockManagedConnectionWithSupersetOfProperties = mock(ManagedConnectionImpl.class);
		ConnectionRequestInfoImpl connectionSpecWithDefaultProperties = new ConnectionRequestInfoImpl();
		connectionSpecWithDefaultProperties.setUserName(TEST_USER);
		connectionSpecWithDefaultProperties.setPassword(TEST_PASSWD);
		connectionSpecWithDefaultProperties.setProperty(DestinationDataProvider.JCO_CLIENT, TEST_CLIENT);
		connectionSpecWithDefaultProperties.setProperty(DestinationDataProvider.JCO_SYSNR, TEST_SYSNR);
		connectionSpecWithDefaultProperties = new ConnectionRequestInfoImpl(connectionSpecWithDefaultProperties);
		when(mockManagedConnectionWithSupersetOfProperties.getProperties()).thenReturn(connectionSpecWithDefaultProperties);
		connectionSetWithMatchingProperties.add(mockManagedConnectionWithSupersetOfProperties);
		
		/* Create Connection Request that is a superset of candidate connection's properties. */
		ConnectionRequestInfoImpl connectionRequestInfoWithDefaultProperties = new ConnectionRequestInfoImpl();
		connectionRequestInfoWithDefaultProperties.setUserName(TEST_USER);
		connectionRequestInfoWithDefaultProperties.setPassword(TEST_PASSWD);
		connectionRequestInfoWithDefaultProperties.setProperty(DestinationDataProvider.JCO_CLIENT, TEST_CLIENT);
		connectionRequestInfoWithDefaultProperties.setProperty(DestinationDataProvider.JCO_SYSNR, TEST_SYSNR);
		connectionRequestInfoWithDefaultProperties = new ConnectionRequestInfoImpl(connectionRequestInfoWithDefaultProperties);
		
		// When
		ManagedConnection managedConnection = managedConnectionFactoryImpl.matchManagedConnections(connectionSetWithMatchingProperties, null, connectionRequestInfoWithDefaultProperties);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.matchManagedConnections(connectionSetWithMatchingProperties, null, connectionRequestInfoWithDefaultProperties) did not return null", managedConnection, is((ManagedConnection)mockManagedConnectionWithSupersetOfProperties));
	}

	@Test
	public void testGetSetLogWriter() throws ResourceException {
		// Given
		PrintWriter setValue = mock(PrintWriter.class);
		
		// When
		managedConnectionFactoryImpl.setLogWriter(setValue);
		PrintWriter getValue = managedConnectionFactoryImpl.getLogWriter();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getLogWriter() returned different value than set by ManagedConnectionFactoryImpl.setLogWriter(logWrither)", getValue, is(setValue));
	}

	@Test
	public void testGetSetResourceAdapter() {
		// Given
		ResourceAdapterImpl setValue = mock(ResourceAdapterImpl.class);
		
		// When
		managedConnectionFactoryImpl.setResourceAdapter(setValue);
		ResourceAdapterImpl getValue = managedConnectionFactoryImpl.getResourceAdapter();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getResourceAdapter() returned different value than set by ManagedConnectionFactoryImpl.setResourceAdapter(resourceAdapter)", getValue, is(setValue));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetInvalidResourceAdapter() {
		// Given
		ResourceAdapter setValue = mock(ResourceAdapter.class);
		
		// When
		managedConnectionFactoryImpl.setResourceAdapter(setValue);
		
		// Then
		fail("ManagedConnectionFactoryImpl.setResourceAdapter(invalidTypeOfResourceAdapter) did not throw InvalidArgumentException");
	}

	@Test
	public void testEquals() {
		
	}

	@Test
	public void testEqualsToNull() {
		// When
		boolean result = managedConnectionFactoryImpl.equals(null);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.equals(null) returned unexpected result", result, is(false));
	}

	@Test
	public void testEqualsToSelf() {
		// When
		boolean result = managedConnectionFactoryImpl.equals(managedConnectionFactoryImpl);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.equals(self) returned unexpected result", result, is(true));
	}

	@Test
	public void testEqualsToDifferentType() {
		// Given
		ManagedConnectionFactory otherManagedConnectionFactory = mock(ManagedConnectionFactory.class);
		
		// When
		boolean result = managedConnectionFactoryImpl.equals(otherManagedConnectionFactory);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.equals(differentTypeOfManagedConnectionFactory) returned unexpected result", result, is(false));
	}

	@Test
	public void testEqualsToOtherManagedConnectionFactoryWithSameConfiguration() {
		// Given
		ManagedConnectionFactoryImpl otherManagedConnectionFactory = new ManagedConnectionFactoryImpl();
		otherManagedConnectionFactory.setAshost(TEST_ASHOST);
		otherManagedConnectionFactory.setSysnr(TEST_SYSNR);
		otherManagedConnectionFactory.setClient(TEST_CLIENT);
		otherManagedConnectionFactory.setUser(TEST_USER);
		otherManagedConnectionFactory.setPasswd(TEST_PASSWD);
		otherManagedConnectionFactory.setLang(TEST_LANG);

		managedConnectionFactoryImpl.setAshost(TEST_ASHOST);
		managedConnectionFactoryImpl.setSysnr(TEST_SYSNR);
		managedConnectionFactoryImpl.setClient(TEST_CLIENT);
		managedConnectionFactoryImpl.setUser(TEST_USER);
		managedConnectionFactoryImpl.setPasswd(TEST_PASSWD);
		managedConnectionFactoryImpl.setLang(TEST_LANG);
		
		// When
		boolean result = managedConnectionFactoryImpl.equals(otherManagedConnectionFactory);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.equals(differentTypeOfManagedConnectionFactory) returned unexpected result", result, is(true));
	}

	@Test
	public void testEqualsToOtherManagedConnectionFactoryWithDifferentConfiguration() {
		// Given
		ManagedConnectionFactoryImpl otherManagedConnectionFactory = new ManagedConnectionFactoryImpl();
		otherManagedConnectionFactory.setAshost(TEST_ASHOST);
		otherManagedConnectionFactory.setSysnr(TEST_SYSNR);
		otherManagedConnectionFactory.setClient(TEST_CLIENT);
		otherManagedConnectionFactory.setUser(TEST_USER);
		otherManagedConnectionFactory.setPasswd(TEST_PASSWD);
		otherManagedConnectionFactory.setLang(TEST_LANG);
		otherManagedConnectionFactory.setUserId(TEST_USER_ID);

		managedConnectionFactoryImpl.setAshost(TEST_ASHOST);
		managedConnectionFactoryImpl.setSysnr(TEST_SYSNR);
		managedConnectionFactoryImpl.setClient(TEST_CLIENT);
		managedConnectionFactoryImpl.setUser(TEST_USER);
		managedConnectionFactoryImpl.setPasswd(TEST_PASSWD);
		managedConnectionFactoryImpl.setLang(TEST_LANG);
		
		
		// When
		boolean result = managedConnectionFactoryImpl.equals(otherManagedConnectionFactory);
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.equals(differentTypeOfManagedConnectionFactory) returned unexpected result", result, is(false));
	}

	@Test
	public void testGetSetAuthType() {
		// Given
		String setValue = TEST_AUTH_TYPE;
		
		// When
		managedConnectionFactoryImpl.setAuthType(setValue);
		String getValue = managedConnectionFactoryImpl.getAuthType();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getAuthType() returned different value than set by ManagedConnectionFactoryImpl.getAuthType(authType)", getValue, is(setValue));
	}

	@Test
	public void testGetSetUserId() {
		// Given
		String setValue = TEST_USER_ID;
		
		// When
		managedConnectionFactoryImpl.setUserId(setValue);
		String getValue = managedConnectionFactoryImpl.getUserId();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getUserId() returned different value than set by ManagedConnectionFactoryImpl.getUserId(userId)", getValue, is(setValue));
	}

	@Test
	public void testGetSetClient() {
		// Given
		String setValue = TEST_CLIENT;
		
		// When
		managedConnectionFactoryImpl.setClient(setValue);
		String getValue = managedConnectionFactoryImpl.getClient();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getClient() returned different value than set by ManagedConnectionFactoryImpl.setClient(client)", getValue, is(setValue));
	}

	@Test
	public void testGetSetUser() {
		// Given
		String setValue = TEST_USER;
		
		// When
		managedConnectionFactoryImpl.setUser(setValue);
		String getValue = managedConnectionFactoryImpl.getUser();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getUser() returned different value than set by ManagedConnectionFactoryImpl.setUser(user)", getValue, is(setValue));
	}

	@Test
	public void testGetSetAliasUser() {
		// Given
		String setValue = TEST_ALIAS_USER;
		
		// When
		managedConnectionFactoryImpl.setAliasUser(setValue);
		String getValue = managedConnectionFactoryImpl.getAliasUser();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getAliasUser() returned different value than set by ManagedConnectionFactoryImpl.setAliasUser(user)", getValue, is(setValue));
	}

	@Test
	public void testGetSetPasswd() {
		// Given
		String setValue = TEST_PASSWD;
		
		// When
		managedConnectionFactoryImpl.setPasswd(setValue);
		String getValue = managedConnectionFactoryImpl.getPasswd();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getPasswd() returned different value than set by ManagedConnectionFactoryImpl.setPasswd(passwd)", getValue, is(setValue));
	}

	@Test
	public void testGetSetLang() {
		// Given
		String setValue = TEST_LANG;
		
		// When
		managedConnectionFactoryImpl.setLang(setValue);
		String getValue = managedConnectionFactoryImpl.getLang();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getLang() returned different value than set by ManagedConnectionFactoryImpl.setLang(lang)", getValue, is(setValue));
	}

	@Test
	public void testGetSetMysapsso2() {
		// Given
		String setValue = TEST_MY_SAP_SSO2;
		
		// When
		managedConnectionFactoryImpl.setMysapsso2(setValue);
		String getValue = managedConnectionFactoryImpl.getMysapsso2();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getMysapsso2() returned different value than set by ManagedConnectionFactoryImpl.setMysapsso2(sapss02)", getValue, is(setValue));
	}

	@Test
	public void testGetSetX509cert() {
		// Given
		String setValue = TEST_X509_CERT;
		
		// When
		managedConnectionFactoryImpl.setX509cert(setValue);
		String getValue = managedConnectionFactoryImpl.getX509cert();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getX509cert() returned different value than set by ManagedConnectionFactoryImpl.setX509cert(x509Cert)", getValue, is(setValue));
	}

	@Test
	public void testGetSetPcs() {
		// Given
		String setValue = TEST_PCS;
		
		// When
		managedConnectionFactoryImpl.setPcs(setValue);
		String getValue = managedConnectionFactoryImpl.getPcs();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getPcs() returned different value than set by ManagedConnectionFactoryImpl.setPcs(pcs)", getValue, is(setValue));
	}

	@Test
	public void testGetSetType() {
		// Given
		String setValue = TEST_TYPE;
		
		// When
		managedConnectionFactoryImpl.setType(setValue);
		String getValue = managedConnectionFactoryImpl.getType();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getType() returned different value than set by ManagedConnectionFactoryImpl.setType(type)", getValue, is(setValue));
	}

	@Test
	public void testGetSetSaprouter() {
		// Given
		String setValue = TEST_SAP_ROUTER;
		
		// When
		managedConnectionFactoryImpl.setSaprouter(setValue);
		String getValue = managedConnectionFactoryImpl.getSaprouter();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getSaprouter() returned different value than set by ManagedConnectionFactoryImpl.setSaprouter(sapRouter)", getValue, is(setValue));
	}

	@Test
	public void testGetSetSysnr() {
		// Given
		String setValue = TEST_SYSNR;
		
		// When
		managedConnectionFactoryImpl.setSysnr(setValue);
		String getValue = managedConnectionFactoryImpl.getSysnr();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getSysnr() returned different value than set by ManagedConnectionFactoryImpl.setSysnr(sysnr)", getValue, is(setValue));
	}

	@Test
	public void testGetSetAshost() {
		// Given
		String setValue = TEST_ASHOST;
		
		// When
		managedConnectionFactoryImpl.setAshost(setValue);
		String getValue = managedConnectionFactoryImpl.getAshost();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getAshost() returned different value than set by ManagedConnectionFactoryImpl.setAshost(ashost)", getValue, is(setValue));
	}

	@Test
	public void testGetSetMshost() {
		// Given
		String setValue = TEST_MSHOST;
		
		// When
		managedConnectionFactoryImpl.setMshost(setValue);
		String getValue = managedConnectionFactoryImpl.getMshost();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getMshost() returned different value than set by ManagedConnectionFactoryImpl.setMshost(mshost)", getValue, is(setValue));
	}

	@Test
	public void testGetSetMsserv() {
		// Given
		String setValue = TEST_MSSERV;
		
		// When
		managedConnectionFactoryImpl.setMsserv(setValue);
		String getValue = managedConnectionFactoryImpl.getMsserv();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getMsserv() returned different value than set by ManagedConnectionFactoryImpl.setMsserv(msserv)", getValue, is(setValue));
	}

	@Test
	public void testGetSetGwhost() {
		// Given
		String setValue = TEST_GWHOST;
		
		// When
		managedConnectionFactoryImpl.setGwhost(setValue);
		String getValue = managedConnectionFactoryImpl.getGwhost();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getGwhost() returned different value than set by ManagedConnectionFactoryImpl.setGwhost(gwhost)", getValue, is(setValue));
	}

	@Test
	public void testGetSetGwserv() {
		// Given
		String setValue = TEST_GWSEREV;
		
		// When
		managedConnectionFactoryImpl.setGwserv(setValue);
		String getValue = managedConnectionFactoryImpl.getGwserv();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getGwserv() returned different value than set by ManagedConnectionFactoryImpl.setGwserv(gwserv)", getValue, is(setValue));
	}

	@Test
	public void testGetSetTphost() {
		// Given
		String setValue = TEST_TPHOST;
		
		// When
		managedConnectionFactoryImpl.setTphost(setValue);
		String getValue = managedConnectionFactoryImpl.getTphost();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getTphost() returned different value than set by ManagedConnectionFactoryImpl.setTphost(tpserv)", getValue, is(setValue));
	}

	@Test
	public void testGetSetTpname() {
		// Given
		String setValue = TEST_TPNAME;
		
		// When
		managedConnectionFactoryImpl.setTpname(setValue);
		String getValue = managedConnectionFactoryImpl.getTpname();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getTpname() returned different value than set by ManagedConnectionFactoryImpl.setTpname(tpname)", getValue, is(setValue));
	}

	@Test
	public void testGetSetR3name() {
		// Given
		String setValue = TEST_R3NAME;
		
		// When
		managedConnectionFactoryImpl.setR3name(setValue);
		String getValue = managedConnectionFactoryImpl.getR3name();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getR3name() returned different value than set by ManagedConnectionFactoryImpl.setR3name(r3Name)", getValue, is(setValue));
	}

	@Test
	public void testGetSetGroup() {
		// Given
		String setValue = TEST_GROUP;
		
		// When
		managedConnectionFactoryImpl.setGroup(setValue);
		String getValue = managedConnectionFactoryImpl.getGroup();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getGroup() returned different value than set by ManagedConnectionFactoryImpl.setGroup(group)", getValue, is(setValue));
	}

	@Test
	public void testGetSetTrace() {
		// Given
		String setValue = TEST_TRACE;
		
		// When
		managedConnectionFactoryImpl.setTrace(setValue);
		String getValue = managedConnectionFactoryImpl.getTrace();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getTrace() returned different value than set by ManagedConnectionFactoryImpl.setTrace(trace)", getValue, is(setValue));
	}

	@Test
	public void testGetSetCpicTrace() {
		// Given
		String setValue = TEST_CPIC_TRACE;
		
		// When
		managedConnectionFactoryImpl.setCpicTrace(setValue);
		String getValue = managedConnectionFactoryImpl.getCpicTrace();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getCpicTrace() returned different value than set by ManagedConnectionFactoryImpl.setCpicTrace(cpicTrace)", getValue, is(setValue));
	}

	@Test
	public void testGetSetLcheck() {
		// Given
		String setValue = TEST_LCHECK;
		
		// When
		managedConnectionFactoryImpl.setLcheck(setValue);
		String getValue = managedConnectionFactoryImpl.getLcheck();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getLcheck() returned different value than set by ManagedConnectionFactoryImpl.setLcheck(lcheck)", getValue, is(setValue));
	}

	@Test
	public void testGetSetUseSapgui() {
		// Given
		String setValue = TEST_USE_SAP_GUI;
		
		// When
		managedConnectionFactoryImpl.setUseSapgui(setValue);
		String getValue = managedConnectionFactoryImpl.getUseSapgui();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getUseSapgui() returned different value than set by ManagedConnectionFactoryImpl.setUseSapgui(useSapGui)", getValue, is(setValue));
	}

	@Test
	public void testGetSetCodepage() {
		// Given
		String setValue = TEST_CODE_PAGE;
		
		// When
		managedConnectionFactoryImpl.setCodepage(setValue);
		String getValue = managedConnectionFactoryImpl.getCodepage();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getCodepage() returned different value than set by ManagedConnectionFactoryImpl.setCodepage(codePage)", getValue, is(setValue));
	}

	@Test
	public void testGetSetGetsso2() {
		// Given
		String setValue = TEST_GET_SSO2;
		
		// When
		managedConnectionFactoryImpl.setGetsso2(setValue);
		String getValue = managedConnectionFactoryImpl.getGetsso2();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getGetsso2() returned different value than set by ManagedConnectionFactoryImpl.setGetsso2(getsso2)", getValue, is(setValue));
	}

	@Test
	public void testGetSetDenyInitialPassword() {
		// Given
		String setValue = TEST_DENY_INITIAL_PASSWORD;
		
		// When
		managedConnectionFactoryImpl.setDenyInitialPassword(setValue);
		String getValue = managedConnectionFactoryImpl.getDenyInitialPassword();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getDenyInitialPassword() returned different value than set by ManagedConnectionFactoryImpl.setDenyInitialPassword(denyInitialPassword)", getValue, is(setValue));
	}

	@Test
	public void testGetSetPeakLimit() {
		// Given
		String setValue = TEST_PEAK_LIMIT;
		
		// When
		managedConnectionFactoryImpl.setPeakLimit(setValue);
		String getValue = managedConnectionFactoryImpl.getPeakLimit();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getPeakLimit() returned different value than set by ManagedConnectionFactoryImpl.setPeakLimit(peakLimit)", getValue, is(setValue));
	}

	@Test
	public void testGetSetPoolCapacity() {
		// Given
		String setValue = TEST_POOL_CAPACITY;
		
		// When
		managedConnectionFactoryImpl.setPoolCapacity(setValue);
		String getValue = managedConnectionFactoryImpl.getPoolCapacity();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getPoolCapacity() returned different value than set by ManagedConnectionFactoryImpl.setPoolCapacity(poolCapacity)", getValue, is(setValue));
	}

	@Test
	public void testGetSetExpirationTime() {
		// Given
		String setValue = TEST_EXPIRATION_TIME;
		
		// When
		managedConnectionFactoryImpl.setExpirationTime(setValue);
		String getValue = managedConnectionFactoryImpl.getExpirationTime();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getExpirationTime() returned different value than set by ManagedConnectionFactoryImpl.setExpirationTime(expirationTime)", getValue, is(setValue));
	}

	@Test
	public void testGetSetExpirationPeriod() {
		// Given
		String setValue = TEST_EXPIRATION_PERIOD;
		
		// When
		managedConnectionFactoryImpl.setExpirationPeriod(setValue);
		String getValue = managedConnectionFactoryImpl.getExpirationPeriod();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getExpirationPeriod() returned different value than set by ManagedConnectionFactoryImpl.setExpirationPeriod(expirationPeriod)", getValue, is(setValue));
	}

	@Test
	public void testGetSetMaxGetTime() {
		// Given
		String setValue = TEST_MAX_GET_TIME;
		
		// When
		managedConnectionFactoryImpl.setMaxGetTime(setValue);
		String getValue = managedConnectionFactoryImpl.getMaxGetTime();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getMaxGetTime() returned different value than set by ManagedConnectionFactoryImpl.setMaxGetTime(maxGetTime)", getValue, is(setValue));
	}

	@Test
	public void testGetSetSncMode() {
		// Given
		String setValue = TEST_SNC_MODE;
		
		// When
		managedConnectionFactoryImpl.setSncMode(setValue);
		String getValue = managedConnectionFactoryImpl.getSncMode();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getSncMode() returned different value than set by ManagedConnectionFactoryImpl.setSncMode(sncMode)", getValue, is(setValue));
	}

	@Test
	public void testGetSetSncPartnername() {
		// Given
		String setValue = TEST_SNC_PARTNERNAME;
		
		// When
		managedConnectionFactoryImpl.setSncPartnername(setValue);
		String getValue = managedConnectionFactoryImpl.getSncPartnername();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getSncPartnername() returned different value than set by ManagedConnectionFactoryImpl.setSncPartnername(sncPartnerName)", getValue, is(setValue));
	}

	@Test
	public void testGetSetSncQop() {
		// Given
		String setValue = TEST_SNC_QOP;
		
		// When
		managedConnectionFactoryImpl.setSncQop(setValue);
		String getValue = managedConnectionFactoryImpl.getSncQop();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getSncQop() returned different value than set by ManagedConnectionFactoryImpl.setSncQop(sncQop)", getValue, is(setValue));
	}

	@Test
	public void testGetSetSncMyname() {
		// Given
		String setValue = TEST_SNC_MYNAME;
		
		// When
		managedConnectionFactoryImpl.setSncMyname(setValue);
		String getValue = managedConnectionFactoryImpl.getSncMyname();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getSncMyname() returned different value than set by ManagedConnectionFactoryImpl.setSncMyname(sncMyname)", getValue, is(setValue));
	}

	@Test
	public void testGetSetSncLibrary() {
		// Given
		String setValue = TEST_SNC_LIBRARY;
		
		// When
		managedConnectionFactoryImpl.setSncLibrary(setValue);
		String getValue = managedConnectionFactoryImpl.getSncLibrary();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getSncLibrary() returned different value than set by ManagedConnectionFactoryImpl.setSncLibrary(sncLibrary)", getValue, is(setValue));
	}

	@Test
	public void testGetSetRepositoryDest() {
		// Given
		String setValue = TEST_REPOSITORY_DEST;
		
		// When
		managedConnectionFactoryImpl.setRepositoryDest(setValue);
		String getValue = managedConnectionFactoryImpl.getRepositoryDest();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getRepositoryDest() returned different value than set by ManagedConnectionFactoryImpl.setRepositoryDest(repositoryDest)", getValue, is(setValue));
	}

	@Test
	public void testGetSetRepositoryUser() {
		// Given
		String setValue = TEST_REPOSITORY_USER;
		
		// When
		managedConnectionFactoryImpl.setRepositoryUser(setValue);
		String getValue = managedConnectionFactoryImpl.getRepositoryUser();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getRepositoryUser() returned different value than set by ManagedConnectionFactoryImpl.setRepositoryUser(repositoryUser)", getValue, is(setValue));
	}

	@Test
	public void testGetSetRepositoryPasswd() {
		// Given
		String setValue = TEST_REPOSITORY_PASSWD;
		
		// When
		managedConnectionFactoryImpl.setRepositoryPasswd(setValue);
		String getValue = managedConnectionFactoryImpl.getRepositoryPasswd();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getRepositoryPasswd() returned different value than set by ManagedConnectionFactoryImpl.setRepositoryPasswd(repositoryPasswd)", getValue, is(setValue));
	}

	@Test
	public void testGetSetRepositorySnc() {
		// Given
		String setValue = TEST_REPOSITORY_SNC;
		
		// When
		managedConnectionFactoryImpl.setRepositorySnc(setValue);
		String getValue = managedConnectionFactoryImpl.getRepositorySnc();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getRepositorySnc() returned different value than set by ManagedConnectionFactoryImpl.setRepositorySnc(repositorySnc)", getValue, is(setValue));
	}

	@Test
	public void testGetSetRepositoryRoundtripOptimization() {
		// Given
		String setValue = TEST_REPOSITORY_ROUNDTRIP_OPTIMAZATION;
		
		// When
		managedConnectionFactoryImpl.setRepositoryRoundtripOptimization(setValue);
		String getValue = managedConnectionFactoryImpl.getRepositoryRoundtripOptimization();
		
		// Then
		assertThat("ManagedConnectionFactoryImpl.getRepositoryRoundtripOptimization() returned different value than set by ManagedConnectionFactoryImpl.setRepositoryRoundtripOptimization(repositoryRoundtripOptimization)", getValue, is(setValue));
	}

	@Test
	public void testAssociateDissociateConnection() {
		// Given
		ManagedConnectionImpl managedConnection = mock(ManagedConnectionImpl.class);
		
		// When
		managedConnectionFactoryImpl.associateConnection(managedConnection);
		managedConnectionFactoryImpl.dissociateConnection(managedConnection);
		
		// Then
		/* No exceptions happened; life is good! */
	}

}
