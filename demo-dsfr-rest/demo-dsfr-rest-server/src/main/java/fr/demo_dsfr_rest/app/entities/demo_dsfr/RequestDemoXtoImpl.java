/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app.entities.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// End of user code

/**
 * Demande pour un utilisateur.
 *
 * @Author MINARM
 */
// Start of user code 4ab6864fc58ecd8b598ee10dfe2ac311
// End of user code
@Schema(description = "Demande pour un utilisateur.")
public class RequestDemoXtoImpl implements Serializable {

	// CONSTANTES

	/**
	 * SerialUid.
	 */
	private static final long serialVersionUID = -1;

	// Start of user code d7bbcbe6a7acc56177d5556a145d9bb1
	// End of user code

	/** Id. */
	@JsonProperty("id")
	@Schema(description = "Identifiant unique de l'entité", accessMode = Schema.AccessMode.READ_ONLY)
	private Long requestDemo_id;

	// ATTRIBUTS

	/** Le type de démarche. */
	// Start of user code 599dcce2998a6b40b1e38e8c6006cb0a
	@JsonProperty("type")
	// End of user code
	@Schema(description = "Le type de démarche.")
	private String type;

	/** La raison de la démarche. */
	// Start of user code 40bea8d637cdf2c1b07fcf0630482b73
	@JsonProperty("reason")
	// End of user code
	@Schema(description = "La raison de la démarche.")
	private String reason;

	/** Le numéro de dossier pour la démarche. */
	// Start of user code f393f3f5e496869a15bc72cbfd56f541
	@JsonProperty("identifier")
	// End of user code
	@Schema(description = "Le numéro de dossier pour la démarche.")
	private String identifier;

	/** Le statut de la démarche. */
	// Start of user code 9acb44549b41563697bb490144ec6258
	@JsonProperty("status")
	// End of user code
	@Schema(description = "Le statut de la démarche.")
	private String status;

	/** L'identifiant pour UserDemo. */
	// Start of user code 9462d0e72e019e6a225e82aeda8600de
	@JsonProperty("userDemo_id")
	// End of user code
	@Schema(description = "Utilisateur de l'application.")
	private Long userDemo_id;

	/**
	 * Constructeur sans paramètre pour la classe : RequestDemoXtoImpl.
	 */
	public RequestDemoXtoImpl() {
		super();
	}

	/**
	 * Retourne l'identifiant pour le dto.
	 *
	 * @return la valeur de l'identifiant.
	 */
	public Long getRequestDemo_id() {
		return this.requestDemo_id;
	}

	/**
	 * Affecte l'identifiant pour le dto'.
	 *
	 * @param la valeur de l'identifiant'.
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

}
