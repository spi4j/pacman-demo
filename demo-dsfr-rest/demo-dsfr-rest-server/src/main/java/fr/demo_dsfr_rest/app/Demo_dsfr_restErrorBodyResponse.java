/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app;

/**
 * Représente une réponse d'erreur avec un code de statut HTTP et un message
 * d'erreur. Cette classe est utilisée pour encapsuler les informations d'une
 * erreur retournée par un service, incluant un code de statut HTTP et un
 * message d'erreur associé.
 * 
 * Cette classe est utilisée par le gestionnaire global des exceptions de
 * l'application demo-dsfr-rest, la classe
 * {@link Demo_dsfr_restExceptionHandler}. Par défaut, la structure est minimale
 * avec un statut HTTP (bien qu'il soit aussi présent au niveau de l'en-tête) et
 * un message d'erreur.
 * 
 * Compléter la classe selon le besoin et modifier la classe
 * {@link Demo_dsfr_restExceptionHandler} afin de prendre en compte l'ensemble
 * des modifications apportées.
 * 
 * @author MINARM
 */
class Demo_dsfr_restErrorBodyResponse {

	/**
	 * Le code de statut HTTP associé à l'erreur.
	 */
	private final int statusCode;

	/**
	 * Le message d'erreur ou d'avertissement associé à l'erreur..
	 */
	private final String errMessage;

	/**
	 * Constructeur.
	 */
	Demo_dsfr_restErrorBodyResponse(final int statusCode, final String errMessage) {
		this.statusCode = statusCode;
		this.errMessage = errMessage;
	}

	/**
	 * Retourne le statut HTTP pour l'exception.
	 * 
	 * @return le statut HTTP.
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * Retourne le message d'erreur ou d'avertissement pour l'exception.
	 * 
	 * @return le message d'erreur ou d'avertissment?
	 */
	public String getErrMessage() {
		return errMessage;
	}
}
