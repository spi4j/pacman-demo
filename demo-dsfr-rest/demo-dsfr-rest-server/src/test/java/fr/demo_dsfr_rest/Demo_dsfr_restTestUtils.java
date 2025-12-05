/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest;

import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * Classe utilitaire pour les tests unitaires ou d'intégration. Fournit des
 * constantes de format de date/heure et une méthode de génération de données
 * binaires aléatoires.
 *
 * Cette classe n'est pas instanciable.
 *
 * @author MINARM
 */
public final class Demo_dsfr_restTestUtils {

	/**
	 * Formateur de temps au format {@code "HH:mm:ss.SSS"}.
	 * <p>
	 * Exemple : {@code 13:45:30.123}
	 * </p>
	 */
	public static final DateTimeFormatter TIMEFORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

	/**
	 * Formateur de date au format ISO-8601 (exemple : {@code 2025-04-30}).
	 */
	public static final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

	/**
	 * Constructeur privé.
	 */
	private Demo_dsfr_restTestUtils() {
		// RAS.
	}

	/**
	 * Génère un tableau de bytes aléatoires de la taille spécifiée.
	 * 
	 * @param length La taille du tableau de bytes à générer.
	 * @return Le tableau de bytes aléatoires.
	 */
	public static byte[] generateRandomByteArray(int length) {
		byte[] randomBytes = new byte[length];
		Random random = new Random();
		random.nextBytes(randomBytes);
		return randomBytes;
	}
}
