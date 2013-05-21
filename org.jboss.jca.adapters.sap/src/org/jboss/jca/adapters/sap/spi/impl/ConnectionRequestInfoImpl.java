/**
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
 * 
 */
package org.jboss.jca.adapters.sap.spi.impl;

import java.util.Properties;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.jca.adapters.sap.model.edit.spi.ConnectionRequestInfoItemProvider;
import org.jboss.jca.adapters.sap.model.spi.SpiFactory;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;
import org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.util.EditingSupport;

/**
 * Implements the {@link ConnectionRequestInfo } interfaces for the JBoss SAP JCA
 * Connector.
 * 
 * @author William Collins
 */
public class ConnectionRequestInfoImpl extends ConnectionRequestInfoItemProvider implements ConnectionRequestInfo {

	protected EditingSupport<org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo> editingSupport = new EditingSupport<org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo>(this);

	/**
	 * Create {@link ConnectionRequestInfo} instance.
	 * 
	 * @param adapterFactory
	 */
	public ConnectionRequestInfoImpl() {
		super(SpiJcaAdapterFactory.INSTANCE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Properties getProperties() {
		editingSupport.getReadLock().lock();
		try {
			Properties properties = new Properties();
			properties.putAll(editingSupport.getModel().getEntries().map());
			return properties;
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAliasUser() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getAliasUser();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAshost() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getAshost();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAuthType() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getAuthType();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getClient() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getClient();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCodepage() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getCodepage();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCpicTrace() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getCpicTrace();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDenyInitialPassword() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getDenyInitialPassword();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getExpirationPeriod() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getExpirationPeriod();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getExpirationTime() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getExpirationTime();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getGetsso2() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getGetsso2();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getGroup() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getGroup();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getGwhost() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getGwhost();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getGwserv() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getGwserv();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLang() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getLang();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLcheck() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getLcheck();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMaxGetTime() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getMaxGetTime();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMshost() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getMshost();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMsserv() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getMsserv();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMysapsso2() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getMysapsso2();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPassword() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getPassword();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPasswd() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getPasswd();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPcs() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getPcs();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPeakLimit() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getPeakLimit();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPingOnCreate() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getPingOnCreate();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPoolCapacity() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getPoolCapacity();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getR3name() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getR3name();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getRepositoryDest() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getRepositoryDest();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getRepositoryPasswd() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getRepositoryPasswd();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getRepositoryRoundtripOptimization() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getRepositoryRoundtripOptimization();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getRepositorySnc() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getRepositorySnc();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getRepositoryUser() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getRepositoryUser();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSaprouter() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getSaprouter();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSncLibrary() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getSncLibrary();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSncMode() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getSncMode();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSncMyname() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getSncMyname();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSncPartnername() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getSncPartnername();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSncQop() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getSncQop();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSysnr() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getSysnr();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTphost() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getTphost();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTpname() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getTpname();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTrace() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getTrace();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getType() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getType();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getUserName() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getUserName();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getUser() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getUser();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getUserId() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getUserId();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getUseSapgui() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getUseSapgui();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getX509cert() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getX509cert();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAliasUser(String user) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__ALIAS_USER, user);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAshost(String ashost) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__ASHOST, ashost);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAuthType(String authType) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__AUTH_TYPE, authType);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setClient(String client) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__CLIENT, client);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setCodepage(String codepage) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__CODEPAGE, codepage);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setCpicTrace(String cpicTrace) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__CPIC_TRACE, cpicTrace);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDenyInitialPassword(String denyInitialPassword) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__DENY_INITIAL_PASSWORD, denyInitialPassword);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setExpirationPeriod(String expirationPeriod) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__EXPIRATION_PERIOD, expirationPeriod);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setExpirationTime(String expirationTime) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__EXPIRATION_TIME, expirationTime);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGetsso2(String getsso2) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__GETSSO2, getsso2);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGroup(String group) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__GROUP, group);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGwhost(String gwhost) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__GWHOST, gwhost);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGwserv(String gwserv) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__GWSERV, gwserv);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLang(String lang) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__LANG, lang);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLcheck(String lcheck) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__LCHECK, lcheck);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMaxGetTime(String maxGetTime) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__MAX_GET_TIME, maxGetTime);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMshost(String mshost) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__MSHOST, mshost);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMsserv(String msserv) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__MSSERV, msserv);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMysapsso2(String mysapsso2) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__MYSAPSSO2, mysapsso2);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPassword(String password) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__PASSWORD, password);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPasswd(String passwd) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__PASSWD, passwd);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPcs(String pcs) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__PCS, pcs);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPeakLimit(String peakLimit) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__PEAK_LIMIT, peakLimit);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPingOnCreate(String pingOnCreate) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__PING_ON_CREATE, pingOnCreate);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPoolCapacity(String poolCapacity) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__POOL_CAPACITY, poolCapacity);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setR3name(String r3name) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__R3NAME, r3name);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepositoryDest(String repositoryDest) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__REPOSITORY_DEST, repositoryDest);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepositoryPasswd(String repositoryPasswd) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__REPOSITORY_PASSWD, repositoryPasswd);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepositoryRoundtripOptimization(String repositoryRoundtripOptimization) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__REPOSITORY_ROUNDTRIP_OPTIMIZATION,
				repositoryRoundtripOptimization);

			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepositorySnc(String repositorySnc) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__REPOSITORY_SNC, repositorySnc);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepositoryUser(String repositoryUser) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__REPOSITORY_USER, repositoryUser);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSaprouter(String saprouter) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__SAPROUTER, saprouter);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSncLibrary(String sncLibrary) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__SNC_LIBRARY, sncLibrary);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSncMode(String sncMode) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__SNC_MODE, sncMode);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSncMyname(String sncMyname) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__SNC_MYNAME, sncMyname);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSncPartnername(String sncPartnername) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__SNC_PARTNERNAME, sncPartnername);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSncQop(String sncQop) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__SNC_QOP, sncQop);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSysnr(String sysnr) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__SYSNR, sysnr);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTphost(String tphost) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__TPHOST, tphost);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTpname(String tpname) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__TPNAME, tpname);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTrace(String trace) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__TRACE, trace);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setType(String type) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__TYPE, type);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setUserName(String userName) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__USER_NAME, userName);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setUser(String user) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__USER, user);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setUserId(String userId) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__USER_ID, userId);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setUseSapgui(String useSapgui) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__USE_SAPGUI, useSapgui);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setX509cert(String x509cert) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			setProperty(SpiPackage.Literals.CONNECTION_REQUEST_INFO__X509CERT, x509cert);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public Notifier getTarget() {
		if (target == null) {
			synchronized (this) {
				if (target == null) {
					target = initializeModel();
					target.eAdapters().add(this);
				}
			}
		}
		return target;
	}

	protected EObject initializeModel() {
		return SpiFactory.eINSTANCE.createConnectionRequestInfo();
	}

	/**
	 * Sets property of the {@link ConnectionRequestInfo} instance using the
	 * {@link EditingDomain}'s {@link CommandStack}.
	 * 
	 * @param feature
	 *            - the {@link EStructuralFeature} of property to set.
	 * @param value
	 *            - the value to set the property to.
	 */
	protected void setProperty(EStructuralFeature feature, Object value) {
		Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), feature, value);
		editingSupport.getCommandStack().execute(command);
	}

}
