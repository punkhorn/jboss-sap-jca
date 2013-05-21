package org.jboss.jca.adapters.sap.ui.converter;

import org.eclipse.core.databinding.conversion.Converter;

public class CpicTraceComboSelection2TraceLevelConverter extends Converter {

	public CpicTraceComboSelection2TraceLevelConverter() {
		super(Integer.class, String.class);
	}

	@Override
	public Object convert(Object fromObject) {
		int selection = (Integer) fromObject;
		switch (selection) {
		case 1:
			return "0";
		case 2:
			return "1";
		case 3:
			return "2";
		case 4:
			return "3";
		}
		return null;
	}

}
