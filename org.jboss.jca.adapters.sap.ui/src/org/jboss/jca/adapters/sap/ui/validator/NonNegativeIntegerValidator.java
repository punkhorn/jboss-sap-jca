package org.jboss.jca.adapters.sap.ui.validator;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class NonNegativeIntegerValidator implements IValidator {
	
	static final String ERROR_MSG = "Value must me a non-negative integer string";
	
	static final String ERROR_MSG2 = " must me a non-negative integer string";
	
	private String parameterName;
	
	public NonNegativeIntegerValidator() {
	}

	public NonNegativeIntegerValidator(String parameterName) {
		this.parameterName = parameterName;
	}
	
	public String getMessage() {
		return parameterName == null ? ERROR_MSG : parameterName + ERROR_MSG2; 
	}

	@Override
	public IStatus validate(Object value) {
		if (value instanceof String) {
			String strValue = (String) value;
			if (strValue == null || strValue.length() == 0) 
				return ValidationStatus.ok();
			try {
				int intValue = Integer.parseInt(strValue);
				if (intValue < 0 )
					return ValidationStatus.error(getMessage());
				return ValidationStatus.ok();
			} catch (NumberFormatException e) {
				return ValidationStatus.error(getMessage());
			}
		}
		return ValidationStatus.error(getMessage());
	}

}
