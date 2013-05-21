package org.jboss.jca.adapters.sap.ui.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.jboss.jca.adapters.sap.model.edit.util.JBossSapJcaDestinationDataProvider;
import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo;
import org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfoStore;
import org.jboss.jca.adapters.sap.model.spi.SpiFactory;
import org.jboss.sap.rfc.ui.dialog.SelectFunctionDialog;

public class SelectFunction extends AbstractHandler implements IHandler {

	public SelectFunction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ConnectionRequestInfoStore store = SpiFactory.eINSTANCE.createConnectionRequestInfoStore();
		JBossSapJcaDestinationDataProvider.INSTANCE.addConnectionRequestInfoStore(store);
		ConnectionRequestInfo info = SpiFactory.eINSTANCE.createConnectionRequestInfo();
		info.setAshost("nplhost");
		info.setSysnr("42");
		info.setClient("001");
		info.setUser("developer");
		info.setPasswd("ch4ngeme");
		info.setLang("en");
		store.getConnectionRequestInfos().put("SapRfcViewConnection", info);
		
		
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		SelectFunctionDialog dialog = new SelectFunctionDialog(window.getShell(), "SapRfcViewConnection");
		dialog.open();
		return null;
	}

}
