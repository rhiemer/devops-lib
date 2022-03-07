package br.gov.rj.detran.devops.lib.properties.app;

import br.gov.rj.detran.devops.lib.properties.Properties;
import br.gov.rj.detran.devops.lib.properties.provider.PropertiesProviderEnvPropertie;
import br.gov.rj.detran.devops.lib.properties.provider.PropertiesProviderSystemPropertie;

/**
 * Busca propriedades da aplicação por system.properties ou por variaveis de
 * ambiente
 * 
 * @author fabricads
 *
 */
public class PropertiesApp extends Properties {

	public PropertiesApp() {
		super(new PropertiesProviderSystemPropertie(), new PropertiesProviderEnvPropertie());
	}

	private static PropertiesApp instance;

	public static PropertiesApp instance() {
		if (instance == null) {
			instance = new PropertiesApp();
		}
		return instance;
	}

}
