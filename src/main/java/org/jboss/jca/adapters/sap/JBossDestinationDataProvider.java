package org.jboss.jca.adapters.sap;

import java.util.HashMap;
import java.util.Map;

import com.sap.conn.jco.ext.DataProviderException;
import com.sap.conn.jco.ext.DestinationDataEventListener;
import com.sap.conn.jco.ext.DestinationDataProvider;

/**
 * Implements the {@link DestinationDataProvider} interface or the JBoss SAP JCA Connector
 * 
 * @author wcollins
 *
 * @version $Revision: $
 */
public class JBossDestinationDataProvider implements DestinationDataProvider {

	/**
	 * Event Listener to notify JCo runtime of configuration changes
	 */
	private DestinationDataEventListener destinationDataListener;

	/**
	 * Map containing configuration properties for multiple destination FIXME:
	 * Replace with secure storage mechanism.
	 */
	private Map<String, JBossSAPConnectionSpec> destinationPropertiesMap = new HashMap<String, JBossSAPConnectionSpec>();

	/**
	 * {@inheritDoc}
	 */
	public JBossSAPConnectionSpec getDestinationProperties(String destinationName) {
		if (destinationName == null) 
			throw new DataProviderException(DataProviderException.Reason.INVALID_CONFIGURATION, "jboss-destination-data-provider-no-destination-name", null);
		try {
			JBossSAPConnectionSpec properties = destinationPropertiesMap.get(destinationName);
			if (properties == null) {
				throw new DataProviderException(DataProviderException.Reason.INVALID_CONFIGURATION,
						"jboss-destination-data-provider-invalid-destination-configuration", null);
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
	public void addDestinationProperties(String destinationName, JBossSAPConnectionSpec destinationProperties) {
		destinationPropertiesMap.put(destinationName, destinationProperties);
		updateProperties(destinationName, destinationProperties);
	}
	
	/**
	 * @param destinationName - the name of the destination for which the provider should remove properties
	 * @return the properties removed for the destination or <code>null</code> if no properties for destination were found
	 */
	public JBossSAPConnectionSpec removeDestinationProperties(String destinationName) {
		JBossSAPConnectionSpec destinationProperties = destinationPropertiesMap.get(destinationName);
		updateProperties(destinationName, null);
		return destinationProperties;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setDestinationDataEventListener(DestinationDataEventListener listener) {
		this.destinationDataListener = listener;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean supportsEvents() {
		return true;
	}

	private void updateProperties(String destinationName, JBossSAPConnectionSpec destinationProperties) {
		synchronized (destinationPropertiesMap) {
			if (destinationProperties == null) {
				if (destinationPropertiesMap.remove(destinationName) != null) {
					if (destinationDataListener != null)
						destinationDataListener.deleted(destinationName);
				}
			} else {
				destinationPropertiesMap.put(destinationName, destinationProperties);
				if (destinationDataListener != null)
					destinationDataListener.updated(destinationName);
			}
		}
	}
}
