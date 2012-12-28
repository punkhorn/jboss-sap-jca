package org.jboss.jca.adapters.sap.cci;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.sap.conn.jco.ext.DataProviderException;
import com.sap.conn.jco.ext.DestinationDataEventListener;
import com.sap.conn.jco.ext.DestinationDataProvider;

/**
 * DestinationDataProvider for JBoss SOA Platform
 * 
 * @author wcollins@redhat.com
 *
 */
public class JBossDestinationDataProvider implements DestinationDataProvider {

	/**
	 * Event Listener to notify JCo runtime of configuration changes
	 */
	private DestinationDataEventListener destinationDataListener;
	
	/**
	 * Map containing configuration properties for multiple destination
	 * FIXME: Replace with secure storage mechanism.
	 */
	private Map<String, Properties> destinationPropertiesMap = new HashMap<String, Properties>();
	
	/**
	 * Convenience method to populate properties with standard configuration.
	 * 
	 * @param asHost - the SAP ABAP application server
	 * @param systemNumber - the system number of the SAP ABAP application serve
	 * @param client - the SAP client
	 * @param user - the logon user
	 * @param password - the logon password
	 * @param language - the logon language
	 * @return
	 */
	public static Properties createDestinationProperties(String asHost, String systemNumber, String client, String user, String password, String language) {
		Properties destinationProperties = new Properties();
		destinationProperties.setProperty(DestinationDataProvider.JCO_ASHOST, asHost);
		destinationProperties.setProperty(DestinationDataProvider.JCO_SYSNR, systemNumber);
		destinationProperties.setProperty(DestinationDataProvider.JCO_CLIENT, client);
		destinationProperties.setProperty(DestinationDataProvider.JCO_USER, user );
		destinationProperties.setProperty(DestinationDataProvider.JCO_PASSWD, password);
		destinationProperties.setProperty(DestinationDataProvider.JCO_LANG, language);
		return destinationProperties;
	}

	/* (non-Javadoc)
	 * @see com.sap.conn.jco.ext.DestinationDataProvider#getDestinationProperties(java.lang.String)
	 */
	public Properties getDestinationProperties(String destinationName) {
		try {
			Properties properties =  destinationPropertiesMap.get(destinationName);
			if (properties != null && properties.isEmpty()) {
				throw new DataProviderException(DataProviderException.Reason.INVALID_CONFIGURATION,"org.jboss.sap.JBossDestinationDataProvider.invalid-destination-configuration",null);
			}
			return properties;
		} catch (RuntimeException e) {
			throw new DataProviderException(DataProviderException.Reason.INTERNAL_ERROR, e);
		}
	}
	
	/**
	 * Adds properties for given destination.
	 * 
	 * @param destinationName - the name of the destination for which the provider should add given properties
	 * @param destinationProperties - the properties added for the destination
	 */
	public void addDestinationProperties(String destinationName, Properties destinationProperties) {
		destinationPropertiesMap.put(destinationName, destinationProperties);
		updateProperties(destinationName, destinationProperties);
	}
	
	/**
	 * @param destinationName - the name of the destination for which the provider should remove properties
	 * @return the properties removed for the destination or <code>null</code> if no properties for destination were found
	 */
	public Properties removeDestinationProperties(String destinationName) {
		Properties destinationProperties = destinationPropertiesMap.get(destinationName);
		updateProperties(destinationName, null);
		return destinationProperties;
	}

	/* (non-Javadoc)
	 * @see com.sap.conn.jco.ext.DestinationDataProvider#setDestinationDataEventListener(com.sap.conn.jco.ext.DestinationDataEventListener)
	 */
	public void setDestinationDataEventListener(
			DestinationDataEventListener listener) {
		this.destinationDataListener = listener;

	}

	/* (non-Javadoc)
	 * @see com.sap.conn.jco.ext.DestinationDataProvider#supportsEvents()
	 */
	public boolean supportsEvents() {
		return true;
	}

	private void updateProperties(String destinationName,
			Properties destinationProperties) {
		synchronized (destinationPropertiesMap) {
			if (destinationProperties == null) {
				if (destinationPropertiesMap.remove(destinationName) != null) {
					destinationDataListener.deleted(destinationName);
				}
			} else {
				destinationPropertiesMap.put(destinationName, destinationProperties);
				destinationDataListener.updated(destinationName);
			}
		}
	}

}
