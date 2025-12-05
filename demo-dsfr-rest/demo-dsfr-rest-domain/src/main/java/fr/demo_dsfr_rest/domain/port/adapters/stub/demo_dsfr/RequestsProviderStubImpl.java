/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain.port.adapters.stub.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.util.List;
import java.util.Optional;

import fr.demo_dsfr_rest.domain.StubService;
import fr.demo_dsfr_rest.domain.a.exceptions.Demo_dsfr_restNotImplementedException;
import fr.demo_dsfr_rest.domain.entities.demo_dsfr.RequestDemoDtoImpl;
import fr.demo_dsfr_rest.domain.port.adapters.demo_dsfr.RequestsProvider;

// End of user code

/**
 * Implémentation de service stub pour le service Requests. Cette classe
 * implémente l'interface {@link RequestsProvider} et fournit une version de
 * base des opérations liées à la gestion des personnes. Elle sert de point de
 * départ pour des implémentations réelles ou de tests.
 * <p>
 * Cette classe est un stub, ce qui signifie qu'elle peut contenir des
 * implémentations vides ou des comportements par défaut pour les méthodes de
 * l'interface {@link RequestsProvider}.
 *
 * Positionner ici l'ensemble du code nécessaire pour remplacer les appels à la
 * couche de persistance. Cette classe peut être utilisée à la fois dans le
 * cadre des tests métier et dans le cadre des tests d'intégration.
 * 
 * @author MINARM
 */
@StubService
public class RequestsProviderStubImpl implements RequestsProvider {

	/**
	 * Création d'une nouvelle demande.
	 * 
	 * @param requestIn : La requête à créer.
	 *
	 * @return RequestDemoDtoImpl : La requête créée avec son identifiant.
	 */
	@Override
	public RequestDemoDtoImpl setRequest(final RequestDemoDtoImpl requestIn) {

		// Start of user code aabbc6af6565f068ae807fe17f15c6b4

		throw new Demo_dsfr_restNotImplementedException(
				"Le test n'a pas été implémenté pour le stub : RequestsServiceImpl");

		// End of user code
	}

	/**
	 * Retoure une demande en fontion de son identifiant.
	 * 
	 * @param id : L'identifiant unique pour la demande.
	 *
	 * @return Optional<RequestDemoDtoImpl> : La demande retournée en fonction de
	 *         son identifiant.
	 */
	@Override
	public Optional<RequestDemoDtoImpl> getRequest(final Long id) {

		// Start of user code 3c8a9c49fb6de085ea17642a062806ad

		throw new Demo_dsfr_restNotImplementedException(
				"Le test n'a pas été implémenté pour le stub : RequestsServiceImpl");

		// End of user code
	}

	/**
	 * Retourne la liste des demandes (tous utilisateurs confondus).
	 * 
	 *
	 * @return List<RequestDemoDtoImpl> : La liste de toutes les demandes pour
	 *         l'ensemble des utilistateurs.
	 */
	@Override
	public List<RequestDemoDtoImpl> getRequests() {

		// Start of user code b8e42cb8fb7ab242abb556174cbc7311

		throw new Demo_dsfr_restNotImplementedException(
				"Le test n'a pas été implémenté pour le stub : RequestsServiceImpl");

		// End of user code
	}

	/**
	 * Retourne l'ensemble des demandes pour un utilisateur.
	 * 
	 * @param userId : L'identifiant de l'utilisateur.
	 *
	 * @return List<RequestDemoDtoImpl> : La liste des demandes pour l'utilisateur.
	 */
	@Override
	public List<RequestDemoDtoImpl> getUserRequests(final Long userId) {

		// Start of user code e5aef8b6d20ae639ba3ddccb57f65f73

		throw new Demo_dsfr_restNotImplementedException(
				"Le test n'a pas été implémenté pour le stub : RequestsServiceImpl");

		// End of user code
	}

}
