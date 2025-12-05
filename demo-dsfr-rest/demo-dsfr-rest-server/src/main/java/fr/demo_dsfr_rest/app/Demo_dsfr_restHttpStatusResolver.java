/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app;

import org.springframework.http.HttpStatus;

/**
 * La classe {@code Demo_dsfr_restHttpStatusResolver} fournit une méthode
 * statique permettant de résoudre un code de statut HTTP en utilisant la classe
 * {@link HttpStatus}. Cette méthode permet de retourner un objet
 * {@link HttpStatus} correspondant au code de statut HTTP fourni.
 * 
 * @author MINARM
 */
class Demo_dsfr_restHttpStatusResolver {
	/**
	 * Résout un code de statut HTTP en un objet {@link HttpStatus}.
	 *
	 * @param statusCode Le code de statut HTTP à résoudre.
	 * @return Un objet {@link HttpStatus} représentant le code de statut HTTP, ou
	 *         {@code null} si le code n'est pas valide.
	 * @throws IllegalArgumentException Si le code de statut est invalide et ne peut
	 *                                  être résolu.
	 * 
	 * @param statusCode le code de statut HTTP sous forme d'entier.
	 * @return le statut sous forme d'énumération.
	 */
	static HttpStatus resolve(final int statusCode) {
		return HttpStatus.resolve(statusCode);
	}
}
