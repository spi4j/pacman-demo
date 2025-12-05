/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.infra;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Transient;

// End of user code

/**
 * Classe abstraite représentant un modèle avec des champs additionnels dans le
 * cadre de la gestion de la couche de persistance. Cette classe est utilisée
 * pour gérer l'auto-attribution des valeurs sur les différents champs.
 */
@MappedSuperclass
public abstract class Demo_dsfr_restEntityAbs {

	/**
	 * Indicateur permettant de désactiver l'initialisation automatique lors des
	 * événements de cycle de vie {@code @PrePersist} et {@code @PreUpdate}.
	 * 
	 * Cet indicateur est plus précis que {@link @ActiveProfiles} car il est
	 * positionnable au niveau de la méthode, il peut (et doit) fonctionner en
	 * combinaison avec {@link @ActiveProfiles}.
	 *
	 * Ce champ n'est pas persistant en base de données ({@code @Transient}). Il est
	 * utilisé pour empêcher l'exécution de logique d'initialisation automatique,
	 * par exemple dans certaines situations de traitement ou de tests.
	 */
	@Transient
	private boolean disableAutoInit;

	// CONSTANTES ET ATTRIBUTS
	// Start of user code d7bbcbe6a7acc56177d5556a145d9bb1
	// End of user code

	/**
	 * Constructeur.
	 */
	protected Demo_dsfr_restEntityAbs() {
		// Start of user code 2e3e969fd52202f4f94ef7456a361c15
		// End of user code
	}

	/**
	 * Méthode de rappel appelée automatiquement avant l'insertion en base de
	 * données (persist).
	 *
	 * Cette méthode est exécutée une seule fois lors de la création de l'entité.
	 * Elle peut être utilisée pour initialiser certains champs par défaut, comme
	 * une date de création ou un booléen, sans avoir à les définir manuellement
	 * dans le code métier.
	 *
	 * <strong>Note :</strong> Le bloc utilisateur permet d'ajouter une logique
	 * personnalisée qui ne sera pas écrasée lors des régénérations de code.
	 */
	@PrePersist
	public void prePersist() {
		if (!this.disableAutoInit) {
			// Start of user code c68eaf37cb78a1bd3a58dc7e563107ed
			// End of user code
		}
	}

	/**
	 * Méthode de rappel appelée automatiquement avant la mise à jour de l'entité en
	 * base de données.
	 * 
	 * Elle est utile pour mettre à jour des métadonnées, comme une date de
	 * modification ou un champ d'audit, à chaque modification de l'entité.
	 *
	 * <strong>Note :</strong> Le bloc utilisateur permet d'ajouter une logique
	 * personnalisée qui ne sera pas écrasée lors des régénérations de code.
	 */
	@PreUpdate
	public void preUpdate() {
		if (!this.disableAutoInit) {
			// Start of user code 482712014ff54b834aa9f7c7be44181c
			// End of user code
		}
	}

	/**
	 * Indique si l'initialisation automatique doit être désactivée lors des
	 * événements {@code @PrePersist} et {@code @PreUpdate}.
	 *
	 * @return {@code true} si l'initialisation automatique est désactivée,
	 *         {@code false} sinon
	 */
	public boolean getDisableAutoInit() {
		return this.disableAutoInit;
	}

	/**
	 * Active ou désactive l'initialisation automatique lors des événements
	 * {@code @PrePersist} et {@code @PreUpdate}.
	 *
	 * @param disableAutoInit {@code true} pour désactiver l'initialisation
	 *                        automatique, {@code false} pour l'activer
	 */
	public void setDisableAutoInit(final boolean disableAutoInit) {
		this.disableAutoInit = disableAutoInit;
	}

	// METHODES
	// Start of user code a9ac5a6cc3cbe84f9c18323af2b9007f
	// End of user code
}
