/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain.a.exceptions;

/**
 * Exception personnalisée pour indiquer qu'une fonctionnalité n'est pas encore
 * implémentée dans l'application demo-dsfr-rest.
 * 
 * Cette exception est une extension de {@link RuntimeException} et est utilisée
 * pour signaler des tentatives d'utilisation de fonctionnalités qui n'ont pas
 * encore été développées ou qui ne sont pas supportées.
 * 
 * Cette classe prend un message d'erreur en paramètre lors de la création de
 * l'exception.
 *
 * @author MINARM
 */
public class Demo_dsfr_restNotImplementedException extends RuntimeException {
	/**
	 * identifiant de sérialisation.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur qui initialise l'exception avec un message détaillant l'erreur.
	 * 
	 * @param message Le message décrivant la cause de l'exception.
	 */
	public Demo_dsfr_restNotImplementedException(final String message) {
		super(message);
	}
}
