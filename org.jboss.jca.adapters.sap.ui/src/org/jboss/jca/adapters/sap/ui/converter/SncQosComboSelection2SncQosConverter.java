package org.jboss.jca.adapters.sap.ui.converter;

import org.eclipse.core.databinding.conversion.Converter;

public class SncQosComboSelection2SncQosConverter extends Converter {

	public SncQosComboSelection2SncQosConverter() {
		super(Integer.class, String.class);
	}

	@Override
	public Object convert(Object fromObject) {
		int selection = (Integer) fromObject;
		switch (selection) {
		case 1:
			return "1";
		case 2:
			return "2";
		case 3:
			return "3";
		case 4:
			return "8";
		case 5:
			return "9";
		}
		return null;
	}

}
