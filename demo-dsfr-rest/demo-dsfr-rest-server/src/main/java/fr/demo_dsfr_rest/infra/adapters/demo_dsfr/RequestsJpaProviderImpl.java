/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.infra.adapters.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import fr.demo_dsfr_rest.domain.AdapterService;
import fr.demo_dsfr_rest.domain.entities.demo_dsfr.RequestDemoDtoImpl;
import fr.demo_dsfr_rest.domain.port.adapters.demo_dsfr.RequestsProvider;
import fr.demo_dsfr_rest.infra.entities.demo_dsfr.RequestDemoEntityImpl;
import fr.demo_dsfr_rest.infra.entities.mappers.demo_dsfr.RequestDemoMapper;
import fr.demo_dsfr_rest.infra.entities.repositories.demo_dsfr.RequestDemoRepository;

// End of user code

/**
 * DESCRIPTION A IMPLEMENTER
 * 
 * @Author MINARM
 */
@AdapterService
public class RequestsJpaProviderImpl implements RequestsProvider {

	// Start of user code 2129864a49adcaa3a812f92be467bf4e
	// End of user code

	/** Gestionnaires de persistance disponibles. */
	final RequestDemoRepository requestDemoRepository;

	/**
	 * Constructeur.
	 */
	@Autowired
	public RequestsJpaProviderImpl(final RequestDemoRepository requestDemoRepository) {

		this.requestDemoRepository = requestDemoRepository;

		// Start of user code 2e3e969fd52202f4f94ef7456a361c15
		// End of user code
	}

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
		// End of user code

		return RequestDemoMapper.toDto(setRequest_invoke(requestIn));
	}

	/**
	 * Création d'une nouvelle demande.
	 * 
	 * @param requestIn : La requête à créer.
	 *
	 * @return RequestDemoDtoImpl : La requête créée avec son identifiant.
	 */
	// Start of user code 7a85869ca4a29a11f035827c1d35ac9f
	// End of user code
	private RequestDemoEntityImpl setRequest_invoke(final RequestDemoDtoImpl requestIn) {

		// Start of user code abb2ee80b2d3b79f43a9f87a832e05ba

		RequestDemoEntityImpl requestEntity = RequestDemoMapper.toEntity(requestIn);
		return requestDemoRepository.save(requestEntity);

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
		// End of user code

		Optional<RequestDemoEntityImpl> entity = getRequest_invoke(id);
		if (entity.isPresent()) {
			return Optional.of(RequestDemoMapper.toDto(entity.get()));
		}
		return Optional.empty();
	}

	/**
	 * Retoure une demande en fontion de son identifiant.
	 * 
	 * @param id : L'identifiant unique pour la demande.
	 *
	 * @return Optional<RequestDemoDtoImpl> : La demande retournée en fonction de
	 *         son identifiant.
	 */
	// Start of user code 0ef999988feada9904c983b5d18b8a5a
	// End of user code
	private Optional<RequestDemoEntityImpl> getRequest_invoke(final Long id) {

		// Start of user code 44f9af59e0028891dd03b0c86fdd771a

		return requestDemoRepository.findById(id);

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
		// End of user code

		return getRequests_invoke().stream().map(o -> RequestDemoMapper.toDto(o)).collect(Collectors.toList());
	}

	/**
	 * Retourne la liste des demandes (tous utilisateurs confondus).
	 * 
	 *
	 * @return List<RequestDemoDtoImpl> : La liste de toutes les demandes pour
	 *         l'ensemble des utilistateurs.
	 */
	// Start of user code 6135da4fe608f497781e602346fdc640
	// End of user code
	private List<RequestDemoEntityImpl> getRequests_invoke() {

		// Start of user code 7565b815428d7b3e93246f5698f86082

		return requestDemoRepository.findAll();

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
		// End of user code

		return getUserRequests_invoke(userId).stream().map(o -> RequestDemoMapper.toDto(o))
				.collect(Collectors.toList());
	}

	/**
	 * Retourne l'ensemble des demandes pour un utilisateur.
	 * 
	 * @param userId : L'identifiant de l'utilisateur.
	 *
	 * @return List<RequestDemoDtoImpl> : La liste des demandes pour l'utilisateur.
	 */
	// Start of user code 2850b2221ecbbeea5318514ca59969aa
	// End of user code
	private List<RequestDemoEntityImpl> getUserRequests_invoke(final Long userId) {

		// Start of user code 26558b58f69b68d8479a5a9de31cd1b9

		return requestDemoRepository.findByUserId(userId);

		// return requestDemoRepository.findByUserId(userId);

		// End of user code
	}
}
