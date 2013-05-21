package org.jboss.jca.adapters.sap.ui;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.jboss.jca.adapters.sap.ui"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	private ResourceBundle resourceBundle;

	private ResourceBundle untranslatedResourceBundle;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
	
	public String getString(String key) {
		return getString(key, false);
	}

	public String getString(String key, boolean translate) {
		ResourceBundle bundle = translate ? resourceBundle : untranslatedResourceBundle;
		if (bundle == null) {
			if (translate) {
				bundle = resourceBundle = Platform.getResourceBundle(getBundle());
			} else {
				String resourceName = getBundle().getEntry("/").toString() + "plugin.properties";
				
				try {
					InputStream inputStream = new URL(resourceName).openStream();
					bundle = untranslatedResourceBundle = new PropertyResourceBundle(inputStream);
					inputStream.close();
				} catch (IOException e) {
					throw new MissingResourceException("Missing properties: " + resourceName, getClass().getName(), "plugin.properties");
				}
			}
		}

		try {
			return bundle.getString(key);
		} catch (Exception e) {
			return key;
		}
	}

    public String getString(String key, Object [] substitutions, boolean translate)
    {
      return MessageFormat.format(getString(key, translate), substitutions);
    }
}
