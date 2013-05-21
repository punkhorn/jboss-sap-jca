package org.jboss.jca.adapters.sap.ui.validator;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class SapRouterStringValidator implements IValidator {

	@Override
	public IStatus validate(Object value) {
		if (value instanceof String) {
			String strValue = (String) value;
			if (strValue == null || strValue.length() == 0) 
				return ValidationStatus.ok();
			if(strValue.matches("(/H/[^/]+(/S/[^/]+)?)+")) {
				return ValidationStatus.ok();
			}
			return ValidationStatus.error("SAP Router String must be a string of the form (/H/<host>[/S/<port>])+");
		}
		return ValidationStatus.error("SAP Router String must be a string of the form (/H/<host>[/S/<port>])+");
	}

}
