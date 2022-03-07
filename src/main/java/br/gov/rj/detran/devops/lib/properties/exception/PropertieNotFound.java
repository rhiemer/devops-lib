package br.gov.rj.detran.devops.lib.properties.exception;

/**
 * Exceção ao não encontrar a propriedade
 * 
 * @author fabricads
 *
 */
public class PropertieNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2463431001198227498L;

	public PropertieNotFound(String propertie) {
		super(String.format("Propriedade não encontrada:%s", propertie));
	}

}
