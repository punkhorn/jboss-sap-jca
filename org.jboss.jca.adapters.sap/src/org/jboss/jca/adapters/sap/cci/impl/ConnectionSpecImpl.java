package org.jboss.jca.adapters.sap.cci.impl;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.jboss.jca.adapters.sap.cci.ConnectionSpec;
import org.jboss.jca.adapters.sap.model.cci.CciFactory;
import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.edit.cci.ConnectionSpecItemProvider;
import org.jboss.jca.adapters.sap.util.EditingSupport;

public class ConnectionSpecImpl extends ConnectionSpecItemProvider implements ConnectionSpec {

	protected EditingSupport<org.jboss.jca.adapters.sap.model.cci.ConnectionSpec> editingSupport = new EditingSupport<org.jboss.jca.adapters.sap.model.cci.ConnectionSpec>(
			this);

	public ConnectionSpecImpl() {
		super(CciJcaAdapterFactory.INSTANCE);
	}

	@Override
	public String getUserName() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getUserName();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setUserName(String value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION_SPEC__USER_NAME, value);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public String getPassword() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getPassword();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setPassword(String value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION_SPEC__PASSWORD, value);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public String getClient() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getClient();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setClient(String value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION_SPEC__CLIENT, value);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public String getUser() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getUser();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setUser(String value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION_SPEC__USER, value);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public String getAliasUser() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getAliasUser();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setAliasUser(String value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION_SPEC__ALIAS_USER, value);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public String getPasswd() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getPasswd();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setPasswd(String value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION_SPEC__PASSWD, value);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public String getLang() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getLang();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setLang(String value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION_SPEC__LANG, value);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public String getMysapsso2() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getMysapsso2();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setMysapsso2(String value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION_SPEC__MYSAPSSO2, value);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public String getGetsso2() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getGetsso2();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setGetsso2(String value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION_SPEC__GETSSO2, value);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public String getX509cert() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getX509cert();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setX509cert(String value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION_SPEC__X509CERT, value);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public String getLcheck() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getLcheck();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setLcheck(String value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION_SPEC__LCHECK, value);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public String getCodepage() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getCodepage();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setCodepage(String value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION_SPEC__CODEPAGE, value);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public String getTrace() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getTrace();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setTrace(String value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION_SPEC__TRACE, value);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public String getUseSapgui() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getUseSapgui();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setUseSapgui(String value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION_SPEC__USE_SAPGUI, value);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public String getSncLibrary() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getSncLibrary();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setSncLibrary(String value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION_SPEC__SNC_LIBRARY, value);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public String getSncMode() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getSncMode();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setSncMode(String value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION_SPEC__SNC_MODE, value);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public String getSncMyname() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getSncMyname();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setSncMyname(String value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION_SPEC__SNC_MYNAME, value);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public String getSncPartnername() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getSncPartnername();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setSncPartnername(String value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION_SPEC__SNC_PARTNERNAME, value);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
		} finally {
			editingSupport.getWriteLock().unlock();
		}
	}

	@Override
	public String getSncQop() {
		editingSupport.getReadLock().lock();
		try {
			return editingSupport.getModel().getSncQop();
		} finally {
			editingSupport.getReadLock().unlock();
		}
	}

	@Override
	public void setSncQop(String value) {
		editingSupport.getWriteLock().lock();
		editingSupport.beginTransaction();
		try {
			Command command = SetCommand.create(editingSupport.getEditingDomain(), editingSupport.getModel(), CciPackage.Literals.CONNECTION_SPEC__SNC_QOP, value);
			editingSupport.getCommandStack().execute(command);
			editingSupport.commitTransaction();
		} catch (Throwable t) {
			editingSupport.rollbackTransaction();
			throw new RuntimeException(t);
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
		return CciFactory.eINSTANCE.createConnectionSpec();
	}

}
