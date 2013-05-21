package org.jboss.jca.adapters.sap.ui.converter;

import org.eclipse.core.databinding.conversion.Converter;

public class Boolean2StringConverter extends Converter {
	public Boolean2StringConverter() {
		super(Boolean.class, String.class);
	}
	@Override
	public Object convert(Object fromObject) {
		return ((Boolean)fromObject) ? "1" : "0";
	}
}
