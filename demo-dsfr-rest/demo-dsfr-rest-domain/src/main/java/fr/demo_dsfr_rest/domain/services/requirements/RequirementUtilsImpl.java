/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain.services.requirements;

import fr.demo_dsfr_rest.domain.a.exceptions.Demo_dsfr_restRequirementException;

/**
 * Classe utilitaire contenant des méthodes de validation pour les exigences.
 * Cette classe est conçue pour valider la version d'implémentation d'une
 * exigence, et lance des exceptions spécifiques si des erreurs sont détectées,
 * telles que des versions déjà définies ou des incohérences entre la version du
 * modèle et la version implémentée.
 * 
 * Cette classe est une classe utilitaire qui ne peut pas être instanciée.
 * 
 * @author MINARM
 */
public final class RequirementUtilsImpl {

	/**
	 * Constructeur privé pour empêcher l'instanciation de cette classe utilitaire.
	 */
	private RequirementUtilsImpl() {
		// RAS
	}

	/**
	 * Vérifie la version d'implémentation d'une exigence donnée et lance des
	 * exceptions en cas de problèmes de version.
	 * 
	 * <ul>
	 * <li>Si une version d'implémentation est déjà affectée à l'exigence, une
	 * exception est lancée.</li>
	 * <li>Si la version spécifiée est {@code Requirement.NOTIMPLEMENTED}, une
	 * exception est lancée pour indiquer que l'exigence n'est pas encore
	 * implémentée.</li>
	 * <li>Si la version spécifiée est {@code Requirement.NOTIMPLEMENTABLE}, aucune
	 * action n'est effectuée, mais la situation est enregistrée dans le log.</li>
	 * <li>Si la version spécifiée ne correspond pas à la version du modèle, une
	 * exception est lancée pour indiquer une incohérence de version.</li>
	 * </ul>
	 * 
	 * @param requirement   L'exigence à vérifier, qui contient les informations sur
	 *                      la version du modèle et de l'implémentation.
	 * @param versionImplem La version d'implémentation à vérifier.
	 * @throws Demo_dsfr_restRequirementException Si une erreur est détectée lors de
	 *                                            la vérification des versions.
	 */
	public static void checkRequirementVersion(final Requirement requirement, final String versionImplem) {
		if (requirement.getVersionImplem() != null) {
			throw new Demo_dsfr_restRequirementException(requirement, "La version a déjà été affectée",
					"Vérifier que le setVersionImplem() n'a été appelé qu'une seule fois pour l'exigence : "
							+ requirement.getName());
		} else if (Requirement.NOTIMPLEMENTED.equals(versionImplem)) {
			throw new Demo_dsfr_restRequirementException(requirement, "Exigence pas encore implémentée",
					"Pour l'exigence " + requirement.getName() + ", il faut :\n" + "   - soit faire un appel à : "
							+ requirement + ".setVersionImplem(Requirement.NOTIMPLEMENTABLE)\n"
							+ "   - soit spécifier la version comme suit : " + requirement + ".setVersionImplem(\""
							+ requirement.getVersionModel() + "\")");
		} else if (Requirement.NOTIMPLEMENTABLE.equals(versionImplem)) {
			// LoggerFactory.getLogger(RequirementUtilsImpl.class).debug("Exigence non
			// implémentable : " + requirement);
		} else if (requirement.getVersionModel().equals(versionImplem) == false) {
			throw new Demo_dsfr_restRequirementException(requirement,
					"La version du modèle (=" + requirement.getVersionModel()
							+ ") ne correspond pas à la version implémentée (= " + versionImplem + ")",
					"Vérifier l'implémentation de l'exigence : " + requirement.getName());
		}
	}
}
