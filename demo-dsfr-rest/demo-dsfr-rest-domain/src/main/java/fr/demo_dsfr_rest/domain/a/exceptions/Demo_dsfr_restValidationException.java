/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain.a.exceptions;

import java.util.Arrays;

/**
 * Exception personnalisée pour gérer les erreurs de validation dans
 * l'application demo-dsfr-rest. Cette exception étend {@link RuntimeException}
 * et permet de signaler des erreurs liées à des champs invalides dans un objet
 * spécifique.
 * 
 * La classe fournit plusieurs constructeurs permettant de spécifier des
 * messages d'erreur personnalisés et d'indiquer les champs invalides pour un
 * objet.
 * 
 * @author MINARM
 */
public class Demo_dsfr_restValidationException extends RuntimeException {
	/**
	 * identifiant de sérialisation.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur qui initialise l'exception avec un message détaillant l'erreur.
	 * 
	 * @param message Le message décrivant la cause de l'exception.
	 */
	public Demo_dsfr_restValidationException(final String message) {
		super(message);
	}

	/**
	 * Constructeur qui permet de spécifier une instance d'objet et des champs
	 * invalides. Ce constructeur génère un message d'erreur décrivant les champs
	 * invalides pour un objet donné.
	 *
	 * @param instance L'objet pour lequel la validation a échoué.
	 * @param fields   Les noms des champs invalides de l'objet.
	 */
	public Demo_dsfr_restValidationException(final Object instance, final String... fields) {
		this(instance, null, fields);
	}

	/**
	 * Constructeur qui permet de spécifier une instance d'objet, des champs
	 * invalides et une cause d'erreur. Ce constructeur génère un message d'erreur
	 * décrivant les champs invalides pour un objet donné et permet de spécifier une
	 * exception précédente (cause).
	 *
	 * @param instance L'objet pour lequel la validation a échoué.
	 * @param cause    La cause de l'exception précédente (peut être null).
	 * @param fields   Les noms des champs invalides de l'objet.
	 */
	public Demo_dsfr_restValidationException(final Object instance, final Throwable cause, final String... fields) {
		super("Champ(s) " + Arrays.toString(fields) + " invalide(s) pour l'objet " + instance, cause);
	}
}
