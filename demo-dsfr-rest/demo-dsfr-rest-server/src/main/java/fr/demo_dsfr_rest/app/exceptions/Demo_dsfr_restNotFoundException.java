/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app.exceptions;

import fr.demo_dsfr_rest.app.Demo_dsfr_restExceptionHandler;

/**
 * Services REST: Classe minimaliste (à titre d'exemple) pour une exception de
 * type fonctionnelle. Elle est automatiquement renvoyée par les générateurs si
 * dans le cadre des services rest sécurisés l'appelant n'a pas passé la phase
 * d'authentification.
 * 
 * Cette classe fonctionne en relation avec les classes
 * {@link Demo_dsfr_restErrorBodyResponse} et
 * {@link Demo_dsfr_restExceptionHandler}
 * 
 * Si besoin, créer des exceptions supplémentaires et les positionner au niveau
 * de ce package.
 * 
 * @author MINARM
 */
public class Demo_dsfr_restNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3708878571796774828L;

	/**
	 * Code pour le statut HTTP.
	 */
	private int statusCode;

	/**
	 * Constructeur.
	 */
	public Demo_dsfr_restNotFoundException(final int statusCode, final String msg) {
		super(msg);
		this.statusCode = statusCode;
	}

	/**
	 * Retourne le code de statut HTTP.
	 * 
	 * @return le code de statut HTTP.
	 */
	public int getStatusCode() {
		return statusCode;
	}
}
