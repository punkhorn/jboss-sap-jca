/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.jca.adapters.sap;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterAssociation;
import javax.security.auth.Subject;

import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.ext.DestinationDataProvider;

/**
 * JBossSAPManagedConnectionFactory
 * 
 * @version $Revision: $
 */
public class JBossSAPManagedConnectionFactory implements ManagedConnectionFactory, ResourceAdapterAssociation {

	/** The serial version UID */
	private static final long serialVersionUID = 1L;

	/** The logger */
	private static Logger log = Logger.getLogger("JBossSAPManagedConnectionFactory");

	/** The resource adapter */
	private JBossSAPResourceAdapter ra;

	/** The logwriter */
	private PrintWriter logwriter;
	
	/** The name of destination */
	private String destinationName;

	/** The destination's properties */
	private final JBossSAPConnectionSpec connectionRequestInfo;

	/**
	 * Default constructor
	 */
	public JBossSAPManagedConnectionFactory() {
		connectionRequestInfo = new JBossSAPConnectionSpec();
	}

	/**
	 * Creates a Connection Factory instance.
	 * 
	 * @param cxManager
	 *            ConnectionManager to be associated with created EIS connection
	 *            factory instance
	 * @return EIS-specific Connection Factory instance or
	 *         javax.resource.cci.ConnectionFactory instance
	 * @throws ResourceException
	 *             Generic exception
	 */
	public Object createConnectionFactory(ConnectionManager cxManager) throws ResourceException {
		log.finest("createConnectionFactory()");
		return new JBossSAPCciConnectionFactory(this, cxManager);
	}

	/**
	 * Creates a Connection Factory instance.
	 * 
	 * @return EIS-specific Connection Factory instance or
	 *         javax.resource.cci.ConnectionFactory instance
	 * @throws ResourceException
	 *             Generic exception
	 */
	public Object createConnectionFactory() throws ResourceException {
		throw new ResourceException("This resource adapter doesn't support non-managed environments");
	}

	/**
	 * Creates a new physical connection to the underlying EIS resource manager.
	 * 
	 * @param subject
	 *            Caller's security information
	 * @param cxRequestInfo
	 *            Additional resource adapter specific connection request
	 *            information
	 * @throws ResourceException
	 *             generic exception
	 * @return ManagedConnection instance
	 */
	public ManagedConnection createManagedConnection(Subject subject, ConnectionRequestInfo cxRequestInfo)
			throws ResourceException {
		log.finest("createManagedConnection()");
		
		try {
			// validate connection request info type
			if (cxRequestInfo != null && !(cxRequestInfo instanceof JBossSAPConnectionSpec)) 
				throw new ResourceException("jboss-sap-managed-connection-factory-invalid-connection-request-info-type");
			
			// merge client connection request info with defaults
			JBossSAPConnectionSpec cri = new JBossSAPConnectionSpec(connectionRequestInfo);
			if (cxRequestInfo != null)
				cri.addProperties((JBossSAPConnectionSpec)cxRequestInfo);

			return new JBossSAPManagedConnection(this, cri);
		} catch (JCoException e) {
			throw new ResourceException("jboss-sap-managed-connection-factory-create-managed-connection-failed", e);
		}
	}

	/**
	 * Returns a matched connection from the candidate set of connections.
	 * 
	 * @param connectionSet
	 *            Candidate connection set
	 * @param subject
	 *            Caller's security information
	 * @param cxRequestInfo
	 *            Additional resource adapter specific connection request
	 *            information
	 * @throws ResourceException
	 *             generic exception
	 * @return ManagedConnection if resource adapter finds an acceptable match
	 *         otherwise null
	 */
	public ManagedConnection matchManagedConnections(Set connectionSet, Subject subject,
			ConnectionRequestInfo cxRequestInfo) throws ResourceException {
		log.finest("matchManagedConnections()");
		ManagedConnection result = null;
		Iterator it = connectionSet.iterator();
		while (result == null && it.hasNext()) {
			ManagedConnection mc = (ManagedConnection) it.next();
			if (mc instanceof JBossSAPManagedConnection) {
				result = mc;
			}

		}
		return result;
	}

	/**
	 * Get the log writer for this ManagedConnectionFactory instance.
	 * 
	 * @return PrintWriter
	 * @throws ResourceException
	 *             generic exception
	 */
	public PrintWriter getLogWriter() throws ResourceException {
		log.finest("getLogWriter()");
		return logwriter;
	}

	/**
	 * Set the log writer for this ManagedConnectionFactory instance.
	 * 
	 * @param out
	 *            PrintWriter - an out stream for error logging and tracing
	 * @throws ResourceException
	 *             generic exception
	 */
	public void setLogWriter(PrintWriter out) throws ResourceException {
		log.finest("setLogWriter()");
		logwriter = out;
	}

	/**
	 * Get the resource adapter
	 * 
	 * @return The handle
	 */
	public JBossSAPResourceAdapter getResourceAdapter() {
		log.finest("getResourceAdapter()");
		return ra;
	}

	/**
	 * Set the resource adapter
	 * 
	 * @param ra
	 *            The handle
	 */
	public void setResourceAdapter(ResourceAdapter ra) {
		log.finest("setResourceAdapter(): " + ra);
		if (!(ra instanceof JBossSAPResourceAdapter))
			throw new IllegalArgumentException(
					"jboss-sap-managed-connection-set-resouce-adapter-invalid-resource-adapter");
		this.ra = (JBossSAPResourceAdapter) ra;
	}

	/**
	 * Returns a hash code value for the object.
	 * 
	 * @return A hash code value for this object.
	 */
	@Override
	public int hashCode() {
		int result = 17;
		return result;
	}

	/**
	 * Indicates whether some other object is equal to this one.
	 * 
	 * @param other
	 *            The reference object with which to compare.
	 * @return true if this object is the same as the obj argument, false
	 *         otherwise.
	 */
	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof JBossSAPManagedConnectionFactory))
			return false;
		JBossSAPManagedConnectionFactory obj = (JBossSAPManagedConnectionFactory) other;
		boolean result = true;
		return result;
	}

	public String getDestinationName() {
		return connectionRequestInfo.getProperty(JBossSAPConnectionSpec.SAP_DESTINATION_NAME);
	}

	public void setDestinationName(String destinationName) {
		log.info("DestinationName set: " + destinationName);
		connectionRequestInfo.setProperty(JBossSAPConnectionSpec.SAP_DESTINATION_NAME, destinationName);
	}

	public String getAshost() {
		return connectionRequestInfo.getProperty(DestinationDataProvider.JCO_ASHOST);
	}

	public void setAshost(String ashost) {
		log.info("Ashost set: " + ashost);
		connectionRequestInfo.setProperty(DestinationDataProvider.JCO_ASHOST, ashost);
	}

	public String getSysnr() {
		return connectionRequestInfo.getProperty(DestinationDataProvider.JCO_SYSNR);
	}

	public void setSysnr(String sysnr) {
		log.info("Sysnr set: " + sysnr);
		connectionRequestInfo.setProperty(DestinationDataProvider.JCO_SYSNR, sysnr);
	}

	public String getClient() {
		return connectionRequestInfo.getProperty(DestinationDataProvider.JCO_CLIENT);
	}

	public void setClient(String client) {
		log.info("Client set: " + client);
		connectionRequestInfo.setProperty(DestinationDataProvider.JCO_CLIENT, client);
	}

	public String getUser() {
		return connectionRequestInfo.getProperty(DestinationDataProvider.JCO_USER);
	}

	public void setUser(String user) {
		log.info("User set: " + user);
		connectionRequestInfo.setProperty(DestinationDataProvider.JCO_USER, user);
	}

	public String getPasswd() {
		return connectionRequestInfo.getProperty(DestinationDataProvider.JCO_PASSWD);
	}

	public void setPasswd(String passwd) {
		log.info("Password set: " + passwd);
		connectionRequestInfo.setProperty(DestinationDataProvider.JCO_PASSWD, passwd);
	}

	public String getLang() {
		return connectionRequestInfo.getProperty(DestinationDataProvider.JCO_LANG);
	}

	public void setLang(String lang) {
		log.info("Lang set: " + lang);
		connectionRequestInfo.setProperty(DestinationDataProvider.JCO_LANG, lang);
	}

}
