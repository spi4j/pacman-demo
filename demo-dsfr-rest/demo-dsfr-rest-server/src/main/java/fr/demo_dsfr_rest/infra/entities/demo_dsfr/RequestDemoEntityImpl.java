/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.infra.entities.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import fr.demo_dsfr_rest.infra.Demo_dsfr_restEntityAbs;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

// End of user code
/**
 * DESCRIPTION A IMPLEMENTER
 *
 * @Author MINARM
 */
@Entity
@Table(name = "REQUESTDEMO")
@SequenceGenerator(name = "REQUESTDEMO_SEQUENCE", sequenceName = "REQUESTDEMO_SEQ", allocationSize = 1)
public class RequestDemoEntityImpl extends Demo_dsfr_restEntityAbs {

	// CONSTANTES ET ATTRIBUTS
	// Start of user code d7bbcbe6a7acc56177d5556a145d9bb1

	// End of user code

	/** Id. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REQUESTDEMO_SEQUENCE")
	@Column(name = "REQUESTDEMO_ID", nullable = false)
	private Long requestDemo_id;

	/** Le type de démarche. */
	// Start of user code 599dcce2998a6b40b1e38e8c6006cb0a
	// End of user code
	@Column(name = "TYPE", nullable = false)
	private String type;

	/** La raison de la démarche. */
	// Start of user code 40bea8d637cdf2c1b07fcf0630482b73
	// End of user code
	@Column(name = "REASON", nullable = false)
	private String reason;

	/** Le numéro de dossier pour la démarche. */
	// Start of user code f393f3f5e496869a15bc72cbfd56f541
	// End of user code
	@Column(name = "IDENTIFIER", nullable = false)
	private String identifier;

	/** Le statut de la démarche. */
	// Start of user code 9acb44549b41563697bb490144ec6258
	// End of user code
	@Column(name = "STATUS", nullable = false)
	private String status;

	/** DESCRIPTION A IMPLEMENTER. */
	// Start of user code 1b4d3adc60be5b871bdf5cdf093e1491
	// End of user code
	@ManyToOne
	@JoinColumn(name = "USERDEMO_ID", nullable = false)
	private UserDemoEntityImpl userDemo_hasRequests;

	/**
	 * Constructeur sans paramètre pour la classe 'RequestDemoEntityImpl'.
	 */
	public RequestDemoEntityImpl() {
		super();

		// Start of user code 3b7d1f8961bdb6f58435db52ce9a364e
		// End of user code
	}

	/**
	 * Constructeur avec paramètres pour la classe 'RequestDemoEntityImpl'.
	 */
	public RequestDemoEntityImpl(final String type, final String reason, final String identifier, final String status,
			final UserDemoEntityImpl userDemo_hasRequests) {
		super();
		this.type = type;
		this.reason = reason;
		this.identifier = identifier;
		this.status = status;
		this.userDemo_hasRequests = userDemo_hasRequests;

		// Start of user code 695d4e162d26e2f89672f82655c8080a
		// End of user code
	}

	/**
	 * Retourne l'identifiant pour l'entité'.
	 *
	 * @return la valeur de l'identifiant'.
	 */
	public Long getRequestDemo_id() {
		return this.requestDemo_id;
	}

	/**
	 * Affecte l'identifiant pour l'entité'.
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
	 * Retourne l'attribut 'userDemo_hasRequests'.
	 *
	 * @return la valeur de l'attribut 'userDemo_hasRequests'.
	 */
	public UserDemoEntityImpl getUserDemo_hasRequests() {
		return this.userDemo_hasRequests;
	}

	/**
	 * Affectation de l'attribut 'userDemo_hasRequests'.
	 *
	 * @param userDemo_hasRequests la valeur à affecter pour l'attribut
	 *                             'userDemo_hasRequests'.
	 */
	public void setUserDemo_hasRequests(final UserDemoEntityImpl userDemo_hasRequests) {
		this.userDemo_hasRequests = userDemo_hasRequests;
	}

	// METHODES
	// Start of user code a9ac5a6cc3cbe84f9c18323af2b9007f
	// End of user code

}
