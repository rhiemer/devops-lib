package br.gov.rj.detran.devops.lib.properties.provider;

public class PropertiesProviderEnvPropertie implements PropertiesProvider {

	@Override
	public String getPropertie(String propertie) {
		return System.getenv(propertie);
	}

}
