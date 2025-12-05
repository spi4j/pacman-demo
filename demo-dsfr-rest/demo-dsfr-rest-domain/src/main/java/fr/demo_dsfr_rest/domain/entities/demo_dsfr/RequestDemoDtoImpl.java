/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain.entities.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fr.demo_dsfr_rest.domain.ValidatorUtils;
import fr.demo_dsfr_rest.domain.a.exceptions.Demo_dsfr_restValidationException;
import fr.demo_dsfr_rest.domain.entities.Demo_dsfr_restEntityAbs;

// End of user code
/**
 * Demande pour un utilisateur.
 *
 * @Author MINARM
 */
public class RequestDemoDtoImpl extends Demo_dsfr_restEntityAbs {
	// CONSTANTES

	// Start of user code d7bbcbe6a7acc56177d5556a145d9bb1
	// End of user code

	// ATTRIBUTS

	/** Id. */
	private Long requestDemo_id;

	/** Le type de démarche. */
	private String type;

	/** La raison de la démarche. */
	private String reason;

	/** Le numéro de dossier pour la démarche. */
	private String identifier;

	/** Le statut de la démarche. */
	private String status;

	/** L'identifiant pour UserDemo. */
	private Long userDemo_id;

	/**
	 * Retourne l'identifiant pour le dto.
	 *
	 * @return la valeur de l'identifiant.
	 */
	public Long getRequestDemo_id() {
		return this.requestDemo_id;
	}

	/**
	 * Affecte l'identifiant pour le dto.
	 *
	 * @param la valeur de l'identifiant.
	 */
	public void setRequestDemo_id(final Long requestDemo_id) {
		this.requestDemo_id = requestDemo_id;
	}

	/**
	 * Retourne l'attribut 'type'.
	 *
	 * @return la valeur de l'attribut 'type'.
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Affectation de l'attribut 'type'.
	 *
	 * @param type la valeur à affecter pour l'attribut 'type'.
	 */
	public void setType(final String type) {
		this.type = type;
	}

	/**
	 * Retourne l'attribut 'reason'.
	 *
	 * @return la valeur de l'attribut 'reason'.
	 */
	public String getReason() {
		return this.reason;
	}

	/**
	 * Affectation de l'attribut 'reason'.
	 *
	 * @param reason la valeur à affecter pour l'attribut 'reason'.
	 */
	public void setReason(final String reason) {
		this.reason = reason;
	}

	/**
	 * Retourne l'attribut 'identifier'.
	 *
	 * @return la valeur de l'attribut 'identifier'.
	 */
	public String getIdentifier() {
		return this.identifier;
	}

	/**
	 * Affectation de l'attribut 'identifier'.
	 *
	 * @param identifier la valeur à affecter pour l'attribut 'identifier'.
	 */
	public void setIdentifier(final String identifier) {
		this.identifier = identifier;
	}

	/**
	 * Retourne l'attribut 'status'.
	 *
	 * @return la valeur de l'attribut 'status'.
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * Affectation de l'attribut 'status'.
	 *
	 * @param status la valeur à affecter pour l'attribut 'status'.
	 */
	public void setStatus(final String status) {
		this.status = status;
	}

	/**
	 * Retourne l'identifiant pour UserDemo.
	 *
	 * @return la valeur de l'identifiant.
	 */
	public Long getUserDemo_id() {
		return this.userDemo_id;
	}

	/**
	 * Affecte l'identifiant pour UserDemo.
	 *
	 * @param la valeur de l'identifiant.
	 */
	public void setUserDemo_id(Long userDemo_id) {
		this.userDemo_id = userDemo_id;
	}

	// METHODES
	// Start of user code a9ac5a6cc3cbe84f9c18323af2b9007f
	// End of user code

	/**
	 * Valide les informations de l'objet en vérifiant la présence des valeurs
	 * obligatoires, les contraintes de taille et un pattern spécifique pour
	 * certains champs.
	 * 
	 * Cette méthode utilise des utilitaires de validation pour vérifier que
	 * certains des champs modélisés ne sont pas vides, respectent une taille
	 * minimale et/ou maximale, ainsi qu'un format spécifique grâce à une expression
	 * régulière qui est fournie (toujours par le biais de la modélisation).
	 * 
	 * Si des erreurs de validation sont trouvées, une exception
	 * {@link Demo_dsfr_restValidationException} est lancée avec les messages
	 * d'erreur correspondants.
	 * 
	 * @throws Demo_dsfr_restValidationException si des erreurs de validation sont
	 *                                           trouvées. L'exception contient une
	 *                                           liste des erreurs sous forme de
	 *                                           tableau de chaînes.
	 */
	public RequestDemoDtoImpl validate() throws Demo_dsfr_restValidationException {

		List<String> errors = new ArrayList<>();
		ValidatorUtils.checkMandatory("type", type, errors);
		ValidatorUtils.checkMandatory("reason", reason, errors);
		ValidatorUtils.checkMandatory("identifier", identifier, errors);
		ValidatorUtils.checkMandatory("status", status, errors);

		if (!errors.isEmpty()) {
			throw new Demo_dsfr_restValidationException(this, errors.toArray(new String[errors.size()]));
		}
		return this;
	}

	/**
	 * Compare cet objet avec l'objet spécifié pour déterminer s'ils sont égaux.
	 *
	 * Cette méthode vérifie si l'instance actuelle et l'objet fourni sont la même
	 * instance, puis compare les attributs des deux objets pour en vérifier
	 * l'égalité. La comparaison est effectuée à l'aide de la méthode
	 * {@link Objects#equals(Object, Object)} afin de gérer correctement les valeurs
	 * de type 'null'.
	 *
	 * @param obj L'objet à comparer avec l'instance actuelle. Celui-ci doit être
	 *            une instance de {@link RequestDemoDtoImpl} pour une comparaison
	 *            valide.
	 *
	 * @return {@code true} si l'objet spécifié est égal à l'instance actuelle,
	 *         {@code false} sinon.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RequestDemoDtoImpl)) {
			return false;
		}

		RequestDemoDtoImpl requestDemo = (RequestDemoDtoImpl) obj;
		return Objects.equals(this.requestDemo_id, requestDemo_id)

				&& Objects.equals(this.type, requestDemo.type) && Objects.equals(this.reason, requestDemo.reason)
				&& Objects.equals(this.identifier, requestDemo.identifier)
				&& Objects.equals(this.status, requestDemo.status)

		;
	}

	/**
	 * Retourne un code de hachage pour l'objet actuel. On ne prend pas en compte
	 * les objets référencés.
	 *
	 * Elle utilise la méthode {@link Objects#hash(Object...)} pour générer un code
	 * de hachage combiné basé sur ces attributs. Ce code de hachage est utilisé
	 * dans des structures de données telles que les tables de hachage.
	 *
	 * @return Le code de hachage pour l'objet actuel.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.requestDemo_id, this.type, this.reason, this.identifier, this.status);
	}

	/**
	 * Retourne une représentation sous forme de chaîne de caractères de l'objet
	 * actuel. On ne prend pas en compte les objets référencés.
	 *
	 * Cette méthode est utile pour obtenir une représentation lisible de l'objet,
	 * notamment pour les opérations de débogage ou de journalisation.
	 */
	@Override
	public String toString() {
		return "RequestDemoDtoImpl { requestDemo_id = " + this.requestDemo_id

				+ "type = " + this.type + "reason = " + this.reason + "identifier = " + this.identifier + "status = "
				+ this.status + "}";
	}

}
