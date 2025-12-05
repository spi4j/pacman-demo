/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilitaire contenant des méthodes de validation pour vérifier
 * certaines contraintes sur des champs de données. Ces méthodes vérifient des
 * conditions telles que la présence d'une valeur obligatoire ou la taille d'une
 * chaîne de caractères.
 * 
 * Cette classe n'a pas besoin d'être instanciée, car elle contient uniquement
 * des méthodes statiques.
 * 
 * @author MINARM
 */
public class ValidatorUtils {
	/**
	 * Vérifie si une valeur obligatoire (non nulle) est fournie pour un champ. Si
	 * la valeur est nulle, le nom du champ est ajouté à la liste des champs
	 * invalides.
	 *
	 * @param fieldName     Le nom du champ à valider.
	 * @param value         La valeur du champ à vérifier.
	 * @param invalidFields La liste des champs invalides à laquelle ajouter le nom
	 *                      du champ en cas de validation échouée.
	 */
	public static void checkMandatory(final String fieldName, final Object value, List<String> invalidFields) {
		if (value == null) {
			if (invalidFields == null) {
				invalidFields = new ArrayList<>();
			}
			invalidFields.add(fieldName);
		}
	}

	/**
	 * Vérifie si la taille d'une chaîne de caractères est comprise dans une plage
	 * spécifiée. Si la taille dépasse la taille maximale autorisée, une entrée est
	 * ajoutée à la liste des champs invalides indiquant la taille actuelle de la
	 * chaîne et la taille maximale autorisée. Idem pour la taille minimale.
	 * 
	 * Si la chaîne est nulle, cette méthode ne fait aucune vérification.
	 * </p>
	 *
	 * @param fieldName     Le nom du champ à valider.
	 * @param value         La valeur du champ (une chaîne de caractères) à
	 *                      vérifier.
	 * @param minSize       La taille minimale autorisée pour la chaîne.
	 * @param maxSize       La taille maximale autorisée pour la chaîne.
	 * @param invalidFields La liste des champs invalides à laquelle ajouter une
	 *                      entrée en cas de validation échouée.
	 */
	public static void checkSize(final String fieldName, final String value, final Integer minSize,
			final Integer maxSize, List<String> invalidFields) {

		if (value == null)
			return;

		if (maxSize != null && value.length() > maxSize) {
			if (invalidFields == null)
				invalidFields = new ArrayList<>();
			invalidFields.add(fieldName + " (" + value.length() + " > " + maxSize + ")");
		}

		if (minSize != null && value.length() < minSize) {
			if (invalidFields == null)
				invalidFields = new ArrayList<>();
			invalidFields.add(fieldName + " (" + value.length() + " < " + minSize + ")");
		}
	}
}
