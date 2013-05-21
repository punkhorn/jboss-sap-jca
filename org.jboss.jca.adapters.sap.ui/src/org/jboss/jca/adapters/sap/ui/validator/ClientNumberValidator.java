package org.jboss.jca.adapters.sap.ui.validator;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class ClientNumberValidator implements IValidator {

	@Override
	public IStatus validate(Object value) {
		if (value instanceof String) {
			String strValue = (String) value;
			if (strValue == null || strValue.length() == 0) 
				return ValidationStatus.ok();
			if (strValue.length() != 3) {
				return ValidationStatus.error("SAP Client must be a three digit numeric string");
			}
			try {
				Integer.parseInt(strValue);
				return ValidationStatus.ok();
			} catch (NumberFormatException e) {
				return ValidationStatus.error("SAP Client must be a three digit numeric string");
			}
		}
		return ValidationStatus.error("SAP Client must be a three digit numeric string");
	}

}
