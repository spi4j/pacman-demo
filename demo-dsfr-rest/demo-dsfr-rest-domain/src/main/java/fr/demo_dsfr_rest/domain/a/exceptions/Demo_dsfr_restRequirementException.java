/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain.a.exceptions;

import fr.demo_dsfr_rest.domain.services.requirements.Requirement;

/**
 * Cette exception est lancée lorsque des problèmes sont rencontrés liés à une
 * exigence spécifique. Elle permet de fournir un message d'erreur et un message
 * supplémentaire concernant la possibilité de correction.
 * 
 * Cette exception hérite de {@link RuntimeException} et permet d'ajouter des
 * détails concernant l'exigence (de type {@link Requirement}) associée à
 * l'erreur.
 * 
 * @author MINARM
 */
public class Demo_dsfr_restRequirementException extends RuntimeException {
	/**
	 * identifiant de sérialisation.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Message par défaut suggérant une vérification du service et/ou du test de
	 * l'exigence.
	 */
	private static final String MESSAGECORRECTIONPOSSIBLE = "Vérifier l'implémentation du service ou du test de l'exigence";

	/**
	 * L'exigence liée à cette exception.
	 */
	private final Requirement requirement;

	/**
	 * Constructeur par défaut qui initialise l'exception avec une exigence et un
	 * message spécifique. Le message de correction possible est défini par défaut.
	 * 
	 * @param requirement L'exigence liée à cette exception.
	 * @param message     Le message d'erreur détaillant le problème.
	 */
	public Demo_dsfr_restRequirementException(final Requirement requirement, final String message) {
		this(requirement, message, MESSAGECORRECTIONPOSSIBLE);
	}

	/**
	 * Constructeur qui initialise l'exception avec une exigence, un message
	 * spécifique et un message pour la correction possible.
	 * 
	 * @param requirement               L'exigence liée à cette exception.
	 * @param message                   Le message d'erreur détaillant le problème.
	 * @param messageCorrectionPossible Le message suggérant une correction possible
	 *                                  pour le problème.
	 */
	public Demo_dsfr_restRequirementException(final Requirement requirement, final String message,
			final String messageCorrectionPossible) {
		// super(message, messageCorrectionPossible);
		this.requirement = requirement;
	}

	/**
	 * Constructeur qui initialise l'exception avec une exigence, un message
	 * spécifique et un message pour la correction possible.
	 * 
	 * @param requirement               L'exigence liée à cette exception.
	 * @param message                   Le message d'erreur détaillant le problème.
	 * @param messageCorrectionPossible Le message suggérant une correction possible
	 *                                  pour le problème.
	 */
	public Demo_dsfr_restRequirementException(final Requirement requirement, final String message,
			final Throwable rootCause) {
		// super(rootCause, message
		// , MESSAGECORRECTIONPOSSIBLE);
		this.requirement = requirement;
	}

	/**
	 * Retourne l'exigence liée à cette exception.
	 * 
	 * @return L'exigence associée à cette exception.
	 */
	public Requirement getRequirement() {
		return requirement;
	}
}
