/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain.port.adapters.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.util.List;
import java.util.Optional;

import fr.demo_dsfr_rest.domain.entities.demo_dsfr.RequestDemoDtoImpl;

// End of user code

/**
 * DESCRIPTION A IMPLEMENTER
 * 
 * @Author MINARM
 */
public interface RequestsProvider {
	/**
	 * Création d'une nouvelle demande.
	 * 
	 * @param requestIn : La requête à créer.
	 *
	 * @return RequestDemoDtoImpl : La requête créée avec son identifiant.
	 */
	public RequestDemoDtoImpl setRequest(final RequestDemoDtoImpl requestIn);

	/**
	 * Retoure une demande en fontion de son identifiant.
	 * 
	 * @param id : L'identifiant unique pour la demande.
	 *
	 * @return Optional<RequestDemoDtoImpl> : La demande retournée en fonction de
	 *         son identifiant.
	 */
	public Optional<RequestDemoDtoImpl> getRequest(final Long id);

	/**
	 * Retourne la liste des demandes (tous utilisateurs confondus).
	 * 
	 *
	 * @return List<RequestDemoDtoImpl> : La liste de toutes les demandes pour
	 *         l'ensemble des utilistateurs.
	 */
	public List<RequestDemoDtoImpl> getRequests();

	/**
	 * Retourne l'ensemble des demandes pour un utilisateur.
	 * 
	 * @param userId : L'identifiant de l'utilisateur.
	 *
	 * @return List<RequestDemoDtoImpl> : La liste des demandes pour l'utilisateur.
	 */
	public List<RequestDemoDtoImpl> getUserRequests(final Long userId);

}
