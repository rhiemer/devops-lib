package br.gov.rj.detran.devops.lib.properties;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import br.gov.rj.detran.devops.lib.properties.exception.PropertieNotFound;
import br.gov.rj.detran.devops.lib.properties.provider.PropertiesProvider;

/**
 * Classe abstrata para buscar propriedades da aplicação
 * 
 * @author fabricads
 *
 */
public abstract class Properties {

	private final PropertiesProvider[] propertiesProviders;

	public Properties(PropertiesProvider... propertiesProviders) {
		this.propertiesProviders = propertiesProviders;
	}

	/**
	 * Gerar um erro se não encontrar
	 * 
	 * @param propertie
	 * @return
	 */
	public PropertieGet getPropertie(String propertie) {
		return new PropertieGet(Arrays.stream(propertiesProviders).map(p -> p.getPropertie(propertie))
				.filter(v -> StringUtils.isNotBlank(v)).findFirst()
				.orElseThrow(() -> new PropertieNotFound(propertie)));
	}

	/**
	 * Caso não encontra retorna o valor default informado
	 * 
	 * @param propertie
	 * @param valueDefault
	 * @return
	 */
	public PropertieGet getPropertie(String propertie, String valueDefault) {
		try {
			return this.getPropertie(propertie);
		} catch (PropertieNotFound e) {
			return new PropertieGet(valueDefault);
		}
	}

}
