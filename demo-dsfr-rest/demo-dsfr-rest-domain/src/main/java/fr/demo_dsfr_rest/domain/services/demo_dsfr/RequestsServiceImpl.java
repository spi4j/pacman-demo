/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain.services.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.demo_dsfr_rest.domain.DomainService;
import fr.demo_dsfr_rest.domain.entities.demo_dsfr.RequestDemoDtoImpl;
import fr.demo_dsfr_rest.domain.port.adapters.demo_dsfr.RequestsProvider;
import fr.demo_dsfr_rest.domain.port.features.demo_dsfr.RequestsService;

// End of user code

/**
 * DESCRIPTION A IMPLEMENTER
 *
 * @Author MINARM
 */
// Start of user code 93c3ffb0c808359e1e3bef9bd5752779
@SuppressWarnings("unused")
// End of user code
@DomainService
public class RequestsServiceImpl implements RequestsService {

	/** Règles de gestion associées. */
	private final RequestsRequirementImpl requirements = new RequestsRequirementImpl();

	/** Le logger pour la classe. */
	private static final Logger LOG = LoggerFactory.getLogger(RequestsServiceImpl.class);

	/** Interface de persistance. */
	private final RequestsProvider requestsProvider;

	// Start of user code 3489b25fcb3064ec4c0f5fe9cec470ff
	// End of user code

	/**
	 * Constructeur avec injection de la persistance.
	 */
	public RequestsServiceImpl(final RequestsProvider requestsProvider) {
		this.requestsProvider = requestsProvider;
	}

	/**
	 * Création d'une nouvelle demande.
	 * 
	 * @param requestIn : La requête à créer.
	 *
	 * @return RequestDemoDtoImpl : La requête créée avec son identifiant.
	 */
	// Start of user code 9c1222dee25f7f457e46d87671870afb
	// End of user code
	@Override
	public RequestDemoDtoImpl setRequest(final RequestDemoDtoImpl requestIn) {

		// Appel des exigences en provenance de la modélisation

		// Start of user code 8e2fa6956c7d8f516e1ef582bde51db9

		// End of user code

		RequestDemoDtoImpl requestOut = this.requestsProvider.setRequest(requestIn.validate());

		// Start of user code 47f3d641e67d862c07e21a399dcb3c68
		// End of user code

		return requestOut;
	}

	/**
	 * Retoure une demande en fontion de son identifiant.
	 * 
	 * @param id : L'identifiant unique pour la demande.
	 *
	 * @return Optional<RequestDemoDtoImpl> : La demande retournée en fonction de
	 *         son identifiant.
	 */
	// Start of user code bc2358db358aa53165e8159707d9b2d1
	// End of user code
	@Override
	public Optional<RequestDemoDtoImpl> getRequest(final Long id) {

		// Appel des exigences en provenance de la modélisation

		// Start of user code b27d6fad94e197fb27aacb256066d575

		// End of user code

		Optional<RequestDemoDtoImpl> requestOut = this.requestsProvider.getRequest(id);

		// Start of user code 1b1e721cdbe39c30467b6ed4195f8823
		// End of user code

		return requestOut;
	}

	/**
	 * Retourne la liste des demandes (tous utilisateurs confondus).
	 * 
	 *
	 * @return List<RequestDemoDtoImpl> : La liste de toutes les demandes pour
	 *         l'ensemble des utilistateurs.
	 */
	// Start of user code b5fd790500d28577a94d0a351c14f88a
	// End of user code
	@Override
	public List<RequestDemoDtoImpl> getRequests() {

		// Appel des exigences en provenance de la modélisation

		// Start of user code 8eca70d244c1b11c1ec03445b3979b74

		// End of user code

		List<RequestDemoDtoImpl> requestsOut = this.requestsProvider.getRequests();

		// Start of user code 8eee830caf5f4d1f577ba6cdb9e2d4b6
		// End of user code

		return requestsOut;
	}

	/**
	 * Retourne l'ensemble des demandes pour un utilisateur.
	 * 
	 * @param userId : L'identifiant de l'utilisateur.
	 *
	 * @return List<RequestDemoDtoImpl> : La liste des demandes pour l'utilisateur.
	 */
	// Start of user code e7fc948d3139ca7583c70c4d9a9ae30a
	// End of user code
	@Override
	public List<RequestDemoDtoImpl> getUserRequests(final Long userId) {

		// Appel des exigences en provenance de la modélisation

		// Start of user code e86d0522abee0749e7fab8de4430f840

		// End of user code

		List<RequestDemoDtoImpl> requestsOut = this.requestsProvider.getUserRequests(userId);

		// Start of user code 7291e13e3eba66279edf267cf57d2b4a
		// End of user code

		return requestsOut;
	}
}
