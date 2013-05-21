package org.jboss.jca.adapters.sap.cci;

public interface ConnectionSpec extends javax.resource.cci.ConnectionSpec {

	String getUserName();

	void setUserName(String value);

	String getPassword();

	void setPassword(String value);

	String getClient();

	void setClient(String value);

	String getUser();

	void setUser(String value);

	String getAliasUser();

	void setAliasUser(String value);

	String getPasswd();

	void setPasswd(String value);

	String getLang();

	void setLang(String value);

	String getMysapsso2();

	void setMysapsso2(String value);

	String getGetsso2();

	void setGetsso2(String value);

	String getX509cert();

	void setX509cert(String value);

	String getLcheck();

	void setLcheck(String value);

	String getCodepage();

	void setCodepage(String value);

	String getTrace();

	void setTrace(String value);

	String getUseSapgui();

	void setUseSapgui(String value);

	String getSncLibrary();

	void setSncLibrary(String value);

	String getSncMode();

	void setSncMode(String value);

	String getSncMyname();

	void setSncMyname(String value);

	String getSncPartnername();

	void setSncPartnername(String value);

	String getSncQop();

	void setSncQop(String value);
}
