package org.jboss.jca.adapters.sap.model.editor;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class Log {
	
	public static void logInfo(String message) {
		log(IStatus.INFO, IStatus.OK, message, null);
	}
	
	public static void logWarning(Throwable exception) {
		log(IStatus.WARNING, IStatus.OK, "Unexpected Exception", exception);
	}
	
	public static void logWarning(String message, Throwable exception) {
		log(IStatus.WARNING, IStatus.OK, message, exception);
	}
	
	public static void logError(Throwable exception) {
		log(IStatus.ERROR, IStatus.OK, "Unexpected Exception", exception);
	}
	
	public static void logError(String message, Throwable exception) {
		log(IStatus.ERROR, IStatus.OK, message, exception);
	}
	
	public static void log(int severity, int code, String message, Throwable exception) {
		log(createStatus(severity, code, message, exception));
	}
	
	public static IStatus createStatus(int severity, int code, String message, Throwable exception) {
		return new Status(severity, "org.jboss.jca.adapters.sap.model.editor", code, message, exception);
	}

	public static void log(IStatus status) {
		JBossSapJcaEditorPlugin.getPlugin().getLog().log(status);
	}

}
