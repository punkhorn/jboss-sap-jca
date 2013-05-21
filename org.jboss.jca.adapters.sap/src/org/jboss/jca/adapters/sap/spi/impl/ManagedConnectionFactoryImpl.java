package org.jboss.jca.adapters.sap.spi.impl;

import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.security.PasswordCredential;
import javax.security.auth.Subject;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.jboss.jca.adapters.sap.model.cci.CciFactory;
import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.edit.spi.ManagedConnectionFactoryItemProvider;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactoryState;
import org.jboss.jca.adapters.sap.model.spi.ManagedConnectionState;
import org.jboss.jca.adapters.sap.model.spi.ResourceAdapterState;
import org.jboss.jca.adapters.sap.model.spi.SpiFactory;
import org.jboss.jca.adapters.sap.model.spi.SpiPackage;
import org.jboss.jca.adapters.sap.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.spi.ManagedConnection;
import org.jboss.jca.adapters.sap.spi.ManagedConnectionFactory;
import org.jboss.jca.adapters.sap.spi.ResourceAdapter;
import org.jboss.jca.adapters.sap.util.EditingSupport;
import org.jboss.jca.adapters.sap.util.JcaEditingDomainSupport;

import com.sap.conn.jco.ext.DestinationDataProvider;

public class ManagedConnectionFactoryImpl extends ManagedConnectionFactoryItemProvider implements
		ManagedConnectionFactory {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4766960653504208905L;
	
	public static final String RESOURCE_URI_PREFIX = "ManagedConnectionFactory-";
	
	public static final String RESOURCE_URI_SUFFIX = ".spi";
	

	protected EditingSupport<org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory> editingSupport = new EditingSupport<org.jboss.jca.adapters.sap.model.spi.ManagedConnectionFactory>(this);

	protected EContentAdapter contentAdapter = new EContentAdapter() {
		@Override
		public void notifyChanged(Notification notification) {
			// Monitor the state of any associated connection handle
			switch (notification.getFeatureID(ManagedConnection.class)) {
			case SpiPackage.MANAGED_CONNECTION__STATE:
				if (notification.getNewValue() == ManagedConnectionState.DESTROYED) {
					managedConnectionDestroyed(notification);
				}
				break;
			}

			super.notifyChanged(notification);
		}
	};

	public ManagedConnectionFactoryImpl() {
		super(SpiJcaAdapterFactory.INSTANCE);
	}

	public String getAliasUser() {
		ConnectionRequestInfo defaultConnectionRequestInfo = getDefaultConnectionRequestInfo();
		return (defaultConnectionRequestInfo == null) ? null : defaultConnectionRequestInfo.getAliasUser();
	}

	public void setAliasUser(String newAliasUser) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setAliasUser(newAliasUser);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getAshost() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getAliasUser();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setAshost(String newAshost) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setAshost(newAshost);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getAuthType() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getAuthType();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setAuthType(String newAuthType) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setAuthType(newAuthType);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getClient() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getClient();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setClient(String newClient) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setClient(newClient);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getCodepage() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getCodepage();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setCodepage(String newCodepage) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setCodepage(newCodepage);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getCpicTrace() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getCpicTrace();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setCpicTrace(String newCpicTrace) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setCpicTrace(newCpicTrace);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getDenyInitialPassword() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getDenyInitialPassword();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setDenyInitialPassword(String newDenyInitialPassword) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setDenyInitialPassword(newDenyInitialPassword);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getExpirationPeriod() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getExpirationPeriod();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setExpirationPeriod(String newExpirationPeriod) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setExpirationPeriod(newExpirationPeriod);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getExpirationTime() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getExpirationTime();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setExpirationTime(String newExpirationTime) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setExpirationTime(newExpirationTime);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getGetsso2() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getGetsso2();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setGetsso2(String newGetsso2) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setGetsso2(newGetsso2);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getGroup() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getGroup();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setGroup(String newGroup) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setGroup(newGroup);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getGwhost() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getGwhost();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setGwhost(String newGwhost) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setGwhost(newGwhost);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getGwserv() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getGwserv();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setGwserv(String newGwserv) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setGwserv(newGwserv);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getLang() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getLang();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setLang(String newLang) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setLang(newLang);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getLcheck() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getLcheck();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setLcheck(String newLcheck) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setLcheck(newLcheck);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getMaxGetTime() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getMaxGetTime();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setMaxGetTime(String newMaxGetTime) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setMaxGetTime(newMaxGetTime);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getMshost() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getMshost();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setMshost(String newMshost) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setMshost(newMshost);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getMsserv() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getMsserv();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setMsserv(String newMsserv) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setMsserv(newMsserv);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getMysapsso2() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getMysapsso2();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setMysapsso2(String newMysapsso2) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setMysapsso2(newMysapsso2);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getPasswd() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getPasswd();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setPasswd(String newPasswd) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setPasswd(newPasswd);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getPcs() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getPcs();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setPcs(String newPcs) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setPcs(newPcs);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getPeakLimit() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getPeakLimit();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setPeakLimit(String newPeakLimit) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setPeakLimit(newPeakLimit);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getPingOnCreate() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getPingOnCreate();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setPingOnCreate(String newPingOnCreate) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setPingOnCreate(newPingOnCreate);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getPoolCapacity() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getPoolCapacity();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setPoolCapacity(String newPoolCapacity) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setPoolCapacity(newPoolCapacity);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getR3name() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getR3name();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setR3name(String newR3name) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setR3name(newR3name);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getRepositoryDest() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getRepositoryDest();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setRepositoryDest(String newRepositoryDest) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setRepositoryDest(newRepositoryDest);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getRepositoryPasswd() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getRepositoryPasswd();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setRepositoryPasswd(String newRepositoryPasswd) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setRepositoryPasswd(newRepositoryPasswd);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getRepositoryRoundtripOptimization() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getRepositoryRoundtripOptimization();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setRepositoryRoundtripOptimization(String newRepositoryRoundtripOptimization) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setRepositoryRoundtripOptimization(newRepositoryRoundtripOptimization);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getRepositorySnc() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getRepositorySnc();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setRepositorySnc(String newRepositorySnc) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setRepositorySnc(newRepositorySnc);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getRepositoryUser() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getRepositoryUser();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setRepositoryUser(String newRepositoryUser) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setRepositoryUser(newRepositoryUser);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getSaprouter() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getSaprouter();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setSaprouter(String newSaprouter) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setSaprouter(newSaprouter);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getSncLibrary() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getSncLibrary();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setSncLibrary(String newSncLibrary) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setSncLibrary(newSncLibrary);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getSncMode() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getSncMode();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setSncMode(String newSncMode) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setSncMode(newSncMode);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getSncMyname() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getSncMyname();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setSncMyname(String newSncMyName) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setSncMyname(newSncMyName);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getSncPartnername() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getSncPartnername();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setSncPartnername(String newSncPartnername) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setSncPartnername(newSncPartnername);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getSncQop() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getSncQop();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setSncQop(String newSncQop) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setSncQop(newSncQop);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getSysnr() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getSysnr();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setSysnr(String newSysnr) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setSysnr(newSysnr);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getTphost() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getTphost();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setTphost(String newTphost) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setTphost(newTphost);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getTpname() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getTpname();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setTpname(String newTpname) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setTpname(newTpname);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getTrace() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getTrace();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setTrace(String newTrace) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setTrace(newTrace);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getType() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getType();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setType(String newType) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setType(newType);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getUser() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getUser();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setUser(String newUser) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setUser(newUser);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getUserId() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getUserId();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setUserId(String newUserId) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setUserId(newUserId);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getUseSapgui() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getUseSapgui();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setUseSapgui(String newUseSapgui) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setUseSapgui(newUseSapgui);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	public String getX509cert() {
		editingSupport.getReadLock().lock();
		try {
			return getDefaultConnectionRequestInfo().getX509cert();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	public void setX509cert(String newX509cert) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			getDefaultConnectionRequestInfo().setX509cert(newX509cert);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public Object createConnectionFactory() throws ResourceException {
		checkState();
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			EObject eObject = CciFactory.eINSTANCE.createConnectionFactory();
			ConnectionManager connectionManager = new DefaultConnectionManagerImpl();
			Command command = SetCommand.create(editingSupport.getEditingDomain(), eObject,
					CciPackage.Literals.CONNECTION_FACTORY__CONNECTION_MANAGER, connectionManager);
			editingSupport.getCommandStack().execute(command);
			command = AddCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(),
					SpiPackage.Literals.MANAGED_CONNECTION_FACTORY__CONNECTION_FACTORIES, eObject);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
			return editingSupport.wrap(eObject);
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
			throw new ResourceException(e);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public Object createConnectionFactory(ConnectionManager connectionManager) throws ResourceException {
		checkState();
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			EObject eObject = CciFactory.eINSTANCE.createConnectionFactory();
			Command command = SetCommand.create(editingSupport.getEditingDomain(), eObject,
					CciPackage.Literals.CONNECTION_FACTORY__CONNECTION_MANAGER, connectionManager);
			editingSupport.getCommandStack().execute(command);
			command = AddCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(),
					SpiPackage.Literals.MANAGED_CONNECTION_FACTORY__CONNECTION_FACTORIES, eObject);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
			return editingSupport.wrap(eObject);
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
			throw new ResourceException(e);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public javax.resource.spi.ManagedConnection createManagedConnection(Subject subject,
			javax.resource.spi.ConnectionRequestInfo connectionRequestInfo) throws ResourceException {
		checkState();

		// validate connection request info type
		if (connectionRequestInfo != null && !(connectionRequestInfo instanceof ConnectionRequestInfoImpl))
			throw new ResourceException("The type of connection request info is invalid: " + connectionRequestInfo.getClass().getName());
		ConnectionRequestInfoImpl connectionRequestInfoImpl = (ConnectionRequestInfoImpl) connectionRequestInfo;

		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			EObject managedConnectionModel = SpiFactory.eINSTANCE.createManagedConnection();

			// merge default and passed connection request info properties into
			// connection connection request info of new connection.
			EObject connectionRequestInfoModel = (EObject) managedConnectionModel
					.eGet(SpiPackage.Literals.MANAGED_CONNECTION__CONNECTION_REQUEST_INFO);
			
			EObject defaultConnectionRequestInfoModel = editingSupport.getModel().getDefaultConnectionRequestInfo();
			
			
			EObject passedConnectionRequestInfoModel = connectionRequestInfoImpl == null ? null : (EObject) connectionRequestInfoImpl.getTarget();
			for (EAttribute attribute : connectionRequestInfoModel.eClass().getEAllAttributes()) {
				// First copy any default value.
				Object value = defaultConnectionRequestInfoModel.eGet(attribute);
				if (value != null) {
					connectionRequestInfoModel.eSet(attribute, value);
				}
				// Then copy any passed value which will override any default.
				value = passedConnectionRequestInfoModel == null ? null :  passedConnectionRequestInfoModel.eGet(attribute);
				if (value != null) {
					connectionRequestInfoModel.eSet(attribute, value);
				}
			}

			// use credentials in non-null subject.
			if (subject != null) {
				boolean foundCredential = false;
				for (PasswordCredential credential : subject.getPrivateCredentials(PasswordCredential.class)) {
					javax.resource.spi.ManagedConnectionFactory mcf = credential.getManagedConnectionFactory();
					if (mcf != null && mcf.equals(this)) {
						connectionRequestInfoModel.eSet(SpiPackage.Literals.CONNECTION_REQUEST_INFO__USER,
								credential.getUserName());
						connectionRequestInfoModel.eSet(SpiPackage.Literals.CONNECTION_REQUEST_INFO__PASSWD,
								credential.getPassword());
						foundCredential = true;
						break;
					}
				}
				if (!foundCredential)
					// Did not find sufficient credentials in subject: this is
					// an error.
					throw new SecurityException("Did not find sufficient credentials in Subject");
			}

			Command command = AddCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(),
					SpiPackage.Literals.MANAGED_CONNECTION_FACTORY__MANAGED_CONNECTIONS, managedConnectionModel);
			editingSupport.getCommandStack().execute(command);

			editingSupport.commitTransaction();
			return (ManagedConnection) editingSupport.wrap(managedConnectionModel);
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
			throw new ResourceException(e);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public void destroy() throws ResourceException {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			if (editingSupport.getModel().getState() == ManagedConnectionFactoryState.DESTROYED) {
				return;
			}

			// Destroy all outstanding managed connections.
			for (EObject managedConnectionModel : editingSupport.getModel().getManagedConnections()) {
				ManagedConnection managedConnection = (ManagedConnection) getRootAdapterFactory().adapt(
						managedConnectionModel, ManagedConnection.class);
				managedConnection.destroy();
			}

			// Set managed connection factory to DESTROYED state.
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(),
					SpiPackage.Literals.MANAGED_CONNECTION_FACTORY__STATE, ManagedConnectionFactoryState.DESTROYED);
			editingSupport.getCommandStack().execute(command);

			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
			throw new ResourceException(e);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public PrintWriter getLogWriter() throws ResourceException {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getLogWriter();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public ResourceAdapter getResourceAdapter() {
		editingSupport.getReadLock().lock();
		try {
			return (ResourceAdapter) editingSupport.wrap(editingSupport.getModel().getResourceAdapter());
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public javax.resource.spi.ManagedConnection matchManagedConnections(Set connectionSet, Subject subject,
			javax.resource.spi.ConnectionRequestInfo connectionRequestInfo) throws ResourceException {
		editingSupport.getReadLock().lock();
		try {

			// Nothing to match
			if (connectionSet == null)
				return null;

			// If the application server does not provide connection request
			// properties to match,
			// search the connection set for a managed connection that matches
			// the default connection properties.
			if (connectionRequestInfo == null)
				connectionRequestInfo = getDefaultConnectionRequestInfo();

			// Can not match against invalid connection request info.
			if (!(connectionRequestInfo instanceof ConnectionRequestInfoImpl))
				return null;

			ManagedConnection result = null;

			// Use credentials in non-null subject for matching.
			PasswordCredential subjectCredential = null;
			if (subject != null) {
				for (PasswordCredential credential : subject.getPrivateCredentials(PasswordCredential.class)) {
					javax.resource.spi.ManagedConnectionFactory credentialManagedConnectionFactory = credential
							.getManagedConnectionFactory();
					if (credentialManagedConnectionFactory != null && credentialManagedConnectionFactory.equals(this)) {
						subjectCredential = credential;
						break;
					}
				}
				if (subjectCredential == null)
					// Did not find sufficient credentials in passed subject for
					// this managed connection factory: create new connection.
					return null;
			}

			// Search through the connection set for a managed connection that
			// matches the passed credentials and connection request properties.
			Iterator it = connectionSet.iterator();
			searchConnectionSet: while (result == null && it.hasNext()) {
				ManagedConnectionImpl candidateConnection = (ManagedConnectionImpl) it.next();

				// Validate passed subject credentials match those of the
				// connection.
				if (subjectCredential != null) {

					String candidateConnectionUserName = candidateConnection.getConnectionRequestInfo().getUserName();
					String candidateConnectionPassword = candidateConnection.getConnectionRequestInfo().getPassword();
					String subjectCredentialUserName = subjectCredential.getUserName();
					String subjectCredentialPassword = new String(subjectCredential.getPassword());

					if (candidateConnectionUserName == null ? subjectCredentialUserName != null
							: !candidateConnectionUserName.equals(subjectCredentialUserName)) {
						continue searchConnectionSet;
					} else if (candidateConnectionPassword == null ? !subjectCredentialPassword.isEmpty()
							: !candidateConnectionPassword.equals(subjectCredentialPassword)) {
						continue searchConnectionSet;
					}
					// Subject credentials match.
				}

				// Validate passed connection request info match those of the
				// connection.
				// NB: the set of passed connection request properties need only
				// be a subset of managed connection's set of properties to
				// match.
				ConnectionRequestInfoImpl jCxRequestInfo = (ConnectionRequestInfoImpl) connectionRequestInfo;
				searchConnectionRequestProperties: for (String propertyName : jCxRequestInfo.getProperties()
						.stringPropertyNames()) {

					if (subject != null
							&& (propertyName.equals(DestinationDataProvider.JCO_USER) || propertyName
									.equals(DestinationDataProvider.JCO_PASSWD)))
						// Already checked managed connection's credentials
						// against subject credentials which override
						// credentials in connection request info.
						continue searchConnectionRequestProperties;

					String candidateConnectionPropertyValue = candidateConnection.getConnectionRequestInfo()
							.getProperties().getProperty(propertyName);
					String cxRequestPropertyValue = jCxRequestInfo.getProperties().getProperty(propertyName);

					if (candidateConnectionPropertyValue == null ? cxRequestPropertyValue != null
							: !candidateConnectionPropertyValue.equals(cxRequestPropertyValue))
						continue searchConnectionSet;
				}
				// All connection request properties match.

				// Found a managed connection that matches.
				result = candidateConnection;
				break;
			}

			return result;
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setLogWriter(PrintWriter out) throws ResourceException {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			editingSupport.getModel().setLogWriter(out);
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
			throw new ResourceException(e);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public void setResourceAdapter(javax.resource.spi.ResourceAdapter resourceAdapter) throws ResourceException {
		checkState();

		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			// Check that the correct type of resource adapter is being set.
			if (!(resourceAdapter instanceof ResourceAdapterImpl))
				throw new IllegalArgumentException("The type of resource adapter set on managed connection factory is invalid: " + (resourceAdapter == null ? "null" : resourceAdapter.getClass().getName()));

			// Check that an adapter has not already been set.
			if (editingSupport.getModel().getResourceAdapter() != null)
				throw new IllegalStateException("The association of managed connection factory can not be changed during its lifetime");

			// Check that the resource adapter has not already been stopped.
			EObject resourceAdapterModel = (EObject) ((ResourceAdapterImpl) resourceAdapter).getTarget();
			ResourceAdapterState resourceAdapterState = (ResourceAdapterState) resourceAdapterModel
					.eGet(SpiPackage.Literals.RESOURCE_ADAPTER__STATE);
			if (resourceAdapterState == ResourceAdapterState.STOPPED) {
				throw new ResourceException("The resource adapter is stopped");
			}
			
			// Associate resource adapter with this managed connection.
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(),
					SpiPackage.Literals.MANAGED_CONNECTION_FACTORY__RESOURCE_ADAPTER, resourceAdapterModel);
			editingSupport.getCommandStack().execute(command);
			
			// Relocate resource
			URI relocatedResourceURI = resourceAdapterModel.eResource().getURI().trimSegments(1).appendSegment(getResourceName());
			editingSupport.getModel().eResource().setURI(relocatedResourceURI);
			
			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
			throw new ResourceException(e);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<ManagedConnection> getManagedConnections() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.wrap(editingSupport.getModel().getManagedConnections());
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}
	
	/**
	 * {@inheritDoc}
	 * <p>
	 * Overridden to initialize model if necessary.
	 */
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

	/**
	 * {@inheritDoc}
	 * <p>
	 * Overridden to set content adapter on model.
	 */
	@Override
	public void setTarget(Notifier target) {
		super.setTarget(target);
		target.eAdapters().add(contentAdapter);
	}
	
	protected String getResourceName() {
		editingSupport.getReadLock().lock();
		try {
			return  RESOURCE_URI_PREFIX + editingSupport.getModel().getDefaultConnectionName() + RESOURCE_URI_SUFFIX;
		} finally {
			editingSupport.getReadLock().unlock();
		}
		
	}
	
	protected EObject initializeModel() {
		
		// Get reference to editing domain
		AdapterFactoryEditingDomain editingDomain = JcaEditingDomainSupport.INSTANCE.getEditingDomain();

		// Create model
		EObject managedConnectionFactoryModel = SpiFactory.eINSTANCE.createManagedConnectionFactory();
		
		// Create resource for managed connection factory
		String defaultConnectionName = (String) managedConnectionFactoryModel.eGet(SpiPackage.Literals.MANAGED_CONNECTION_FACTORY__DEFAULT_CONNECTION_NAME);
		String resourceFilename = RESOURCE_URI_PREFIX + defaultConnectionName + RESOURCE_URI_SUFFIX;
		File tempFile = new File(resourceFilename);
		URI resourceURI = URI.createURI(tempFile.getAbsolutePath());
		Resource resource = editingDomain.getResourceSet().createResource(resourceURI);
		
		// Add model to resource
		resource.getContents().add(managedConnectionFactoryModel);
		
		return managedConnectionFactoryModel;
	}

	protected ConnectionRequestInfo getDefaultConnectionRequestInfo() {
		editingSupport.getReadLock().lock();
		try {
			return (ConnectionRequestInfo) editingSupport.wrap(editingSupport.getModel().getDefaultConnectionRequestInfo());
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	protected void managedConnectionDestroyed(Notification notification) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			
			// Dissociate connection handle
			Command command = RemoveCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), SpiPackage.Literals.MANAGED_CONNECTION_FACTORY__MANAGED_CONNECTIONS, notification.getNotifier());
			editingSupport.getCommandStack().execute(command);

			editingSupport.commitTransaction();
		} catch (Exception e) {
			editingSupport.rollbackTransaction();
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	/**
	 * Internal helper method used by public methods to check the state of this
	 * connection factory before performing an operation on it. This method
	 * prevents operations from being performed on a connection in a
	 * <code>DESTROYED</code> state.
	 * 
	 * @throws ResourceException
	 *             if connection is in a <code>DESTROYED</code> state.
	 * 
	 * @generated NOT
	 */
	private void checkState() throws ResourceException {
		editingSupport.getReadLock().lock();
		try {
			if (editingSupport.getModel().getState() == ManagedConnectionFactoryState.DESTROYED) {
				throw new ResourceException("The connection is destroyed");
			}
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}
}
