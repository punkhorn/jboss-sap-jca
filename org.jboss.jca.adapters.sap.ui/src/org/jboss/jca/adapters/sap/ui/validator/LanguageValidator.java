package org.jboss.jca.adapters.sap.ui.validator;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class LanguageValidator implements IValidator {

	@Override
	public IStatus validate(Object value) {
		if (value instanceof String) {
			String strValue = (String) value;
			if (strValue == null || strValue.length() == 0) 
				return ValidationStatus.ok();
			if (strValue.length() != 2) {
				return ValidationStatus.error("Logon Language must be a two digit SAP language code string");
			}
			return ValidationStatus.ok();
		}
		return ValidationStatus.error("SAP Client must be a two digit SAP language code string");
	}

}
