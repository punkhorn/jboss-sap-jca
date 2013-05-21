package org.jboss.jca.adapters.sap.model.edit.util;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoRequest;

public class SapUtil {
	
	private SapUtil() {}
	
	public static String[] getRfmNames(JCoDestination destination) {
		String[] rfmNames = null;
		try {
			JCoFunction function = destination.getRepository().getFunction("RFC_FUNCTION_SEARCH");
			JCoRequest request = function.getFunctionTemplate().getRequest();
			request.setValue("FUNCNAME", "*");
		} catch (JCoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rfmNames;
	}

}
