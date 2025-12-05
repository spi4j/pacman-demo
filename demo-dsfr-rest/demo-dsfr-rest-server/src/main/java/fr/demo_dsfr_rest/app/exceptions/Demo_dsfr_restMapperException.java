/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app.exceptions;

/**
 * Exception personnalisée pour le mappage dans l'application demo-dsfr-rest.
 * 
 * Cette exception est une extension de {@link RuntimeException} et est utilisée
 * pour signaler des erreurs spécifiques liées au processus de mappage des
 * données dans l'application demo-dsfr-rest.
 * 
 * Cette classe prend un message d'erreur en paramètre lors de la création de
 * l'exception.
 * 
 * @author MINARM
 */
public class Demo_dsfr_restMapperException extends RuntimeException {
	/**
	 * identifiant de sérialisation.
	 */
	private static final long serialVersionUID = 7461624407885629938L;

	/**
	 * Constructeur qui initialise l'exception avec un message détaillant l'erreur.
	 * 
	 * @param message Le message décrivant la cause de l'exception.
	 */
	public Demo_dsfr_restMapperException(final String message) {
		super(message);
	}

	/**
	 * Constructeur qui initialise l'exception avec un message détaillant l'erreur
	 * et le contenu de l'exception initiale.
	 * 
	 * @param message Le message décrivant la cause de l'exception.
	 * @param ex      L'exception initiale qui a levé l'exception.
	 */
	public Demo_dsfr_restMapperException(final String message, final Exception ex) {
		super(message, ex);
	}
}
