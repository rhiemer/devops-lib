package br.gov.rj.detran.devops.lib.properties;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Tranformar valores em diversos formatos das propriedades da aplicação
 * @author fabricads
 *
 */
public class PropertieGet {
	private static final Set<String> TRUE_SET = new HashSet<>(Arrays.asList("1", "true", "yes", "s", "y"));

	private final String value;

	public PropertieGet(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public Integer getValueInt() {
		return Integer.valueOf(value);
	}

	public Long getValueLong() {
		return Long.valueOf(value);
	}

	public boolean getValueBoolean() {
		return (value != null && TRUE_SET.contains(value.toLowerCase()));
	}

}
