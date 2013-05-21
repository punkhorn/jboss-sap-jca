/**
 */
package org.jboss.jca.adapters.sap.model.cci;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getUserName <em>User Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getPassword <em>Password</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getClient <em>Client</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getUser <em>User</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getAliasUser <em>Alias User</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getPasswd <em>Passwd</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getLang <em>Lang</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getMysapsso2 <em>Mysapsso2</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getGetsso2 <em>Getsso2</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getX509cert <em>X50 9cert</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getLcheck <em>Lcheck</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getCodepage <em>Codepage</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getTrace <em>Trace</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getUseSapgui <em>Use Sapgui</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getSncLibrary <em>Snc Library</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getSncMode <em>Snc Mode</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getSncMyname <em>Snc Myname</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getSncPartnername <em>Snc Partnername</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getSncQop <em>Snc Qop</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionSpec()
 * @model
 * @generated
 */
public interface ConnectionSpec extends EObject {
	/**
	 * Returns the value of the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Name</em>' attribute.
	 * @see #setUserName(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionSpec_UserName()
	 * @model
	 * @generated
	 */
	String getUserName();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getUserName <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Name</em>' attribute.
	 * @see #getUserName()
	 * @generated
	 */
	void setUserName(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionSpec_Password()
	 * @model
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Client</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Client</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Client</em>' attribute.
	 * @see #setClient(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionSpec_Client()
	 * @model
	 * @generated
	 */
	String getClient();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getClient <em>Client</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client</em>' attribute.
	 * @see #getClient()
	 * @generated
	 */
	void setClient(String value);

	/**
	 * Returns the value of the '<em><b>User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User</em>' attribute.
	 * @see #setUser(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionSpec_User()
	 * @model
	 * @generated
	 */
	String getUser();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getUser <em>User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User</em>' attribute.
	 * @see #getUser()
	 * @generated
	 */
	void setUser(String value);

	/**
	 * Returns the value of the '<em><b>Alias User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alias User</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alias User</em>' attribute.
	 * @see #setAliasUser(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionSpec_AliasUser()
	 * @model
	 * @generated
	 */
	String getAliasUser();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getAliasUser <em>Alias User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alias User</em>' attribute.
	 * @see #getAliasUser()
	 * @generated
	 */
	void setAliasUser(String value);

	/**
	 * Returns the value of the '<em><b>Passwd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Passwd</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Passwd</em>' attribute.
	 * @see #setPasswd(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionSpec_Passwd()
	 * @model
	 * @generated
	 */
	String getPasswd();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getPasswd <em>Passwd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Passwd</em>' attribute.
	 * @see #getPasswd()
	 * @generated
	 */
	void setPasswd(String value);

	/**
	 * Returns the value of the '<em><b>Lang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lang</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lang</em>' attribute.
	 * @see #setLang(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionSpec_Lang()
	 * @model
	 * @generated
	 */
	String getLang();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getLang <em>Lang</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lang</em>' attribute.
	 * @see #getLang()
	 * @generated
	 */
	void setLang(String value);

	/**
	 * Returns the value of the '<em><b>Mysapsso2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mysapsso2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mysapsso2</em>' attribute.
	 * @see #setMysapsso2(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionSpec_Mysapsso2()
	 * @model
	 * @generated
	 */
	String getMysapsso2();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getMysapsso2 <em>Mysapsso2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mysapsso2</em>' attribute.
	 * @see #getMysapsso2()
	 * @generated
	 */
	void setMysapsso2(String value);

	/**
	 * Returns the value of the '<em><b>Getsso2</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Getsso2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Getsso2</em>' attribute.
	 * @see #setGetsso2(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionSpec_Getsso2()
	 * @model default="" transient="true"
	 * @generated
	 */
	String getGetsso2();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getGetsso2 <em>Getsso2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Getsso2</em>' attribute.
	 * @see #getGetsso2()
	 * @generated
	 */
	void setGetsso2(String value);

	/**
	 * Returns the value of the '<em><b>X50 9cert</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X50 9cert</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X50 9cert</em>' attribute.
	 * @see #setX509cert(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionSpec_X509cert()
	 * @model
	 * @generated
	 */
	String getX509cert();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getX509cert <em>X50 9cert</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X50 9cert</em>' attribute.
	 * @see #getX509cert()
	 * @generated
	 */
	void setX509cert(String value);

	/**
	 * Returns the value of the '<em><b>Lcheck</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lcheck</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lcheck</em>' attribute.
	 * @see #setLcheck(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionSpec_Lcheck()
	 * @model default=""
	 * @generated
	 */
	String getLcheck();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getLcheck <em>Lcheck</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lcheck</em>' attribute.
	 * @see #getLcheck()
	 * @generated
	 */
	void setLcheck(String value);

	/**
	 * Returns the value of the '<em><b>Codepage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Codepage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Codepage</em>' attribute.
	 * @see #setCodepage(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionSpec_Codepage()
	 * @model
	 * @generated
	 */
	String getCodepage();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getCodepage <em>Codepage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Codepage</em>' attribute.
	 * @see #getCodepage()
	 * @generated
	 */
	void setCodepage(String value);

	/**
	 * Returns the value of the '<em><b>Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace</em>' attribute.
	 * @see #setTrace(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionSpec_Trace()
	 * @model
	 * @generated
	 */
	String getTrace();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getTrace <em>Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace</em>' attribute.
	 * @see #getTrace()
	 * @generated
	 */
	void setTrace(String value);

	/**
	 * Returns the value of the '<em><b>Use Sapgui</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Sapgui</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Sapgui</em>' attribute.
	 * @see #setUseSapgui(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionSpec_UseSapgui()
	 * @model
	 * @generated
	 */
	String getUseSapgui();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getUseSapgui <em>Use Sapgui</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Sapgui</em>' attribute.
	 * @see #getUseSapgui()
	 * @generated
	 */
	void setUseSapgui(String value);

	/**
	 * Returns the value of the '<em><b>Snc Library</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snc Library</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snc Library</em>' attribute.
	 * @see #setSncLibrary(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionSpec_SncLibrary()
	 * @model
	 * @generated
	 */
	String getSncLibrary();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getSncLibrary <em>Snc Library</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snc Library</em>' attribute.
	 * @see #getSncLibrary()
	 * @generated
	 */
	void setSncLibrary(String value);

	/**
	 * Returns the value of the '<em><b>Snc Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snc Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snc Mode</em>' attribute.
	 * @see #setSncMode(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionSpec_SncMode()
	 * @model
	 * @generated
	 */
	String getSncMode();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getSncMode <em>Snc Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snc Mode</em>' attribute.
	 * @see #getSncMode()
	 * @generated
	 */
	void setSncMode(String value);

	/**
	 * Returns the value of the '<em><b>Snc Myname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snc Myname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snc Myname</em>' attribute.
	 * @see #setSncMyname(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionSpec_SncMyname()
	 * @model
	 * @generated
	 */
	String getSncMyname();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getSncMyname <em>Snc Myname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snc Myname</em>' attribute.
	 * @see #getSncMyname()
	 * @generated
	 */
	void setSncMyname(String value);

	/**
	 * Returns the value of the '<em><b>Snc Partnername</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snc Partnername</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snc Partnername</em>' attribute.
	 * @see #setSncPartnername(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionSpec_SncPartnername()
	 * @model
	 * @generated
	 */
	String getSncPartnername();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getSncPartnername <em>Snc Partnername</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snc Partnername</em>' attribute.
	 * @see #getSncPartnername()
	 * @generated
	 */
	void setSncPartnername(String value);

	/**
	 * Returns the value of the '<em><b>Snc Qop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snc Qop</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snc Qop</em>' attribute.
	 * @see #setSncQop(String)
	 * @see org.jboss.jca.adapters.sap.model.cci.CciPackage#getConnectionSpec_SncQop()
	 * @model
	 * @generated
	 */
	String getSncQop();

	/**
	 * Sets the value of the '{@link org.jboss.jca.adapters.sap.model.cci.ConnectionSpec#getSncQop <em>Snc Qop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snc Qop</em>' attribute.
	 * @see #getSncQop()
	 * @generated
	 */
	void setSncQop(String value);

} // ConnectionSpec
