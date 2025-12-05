/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.infra.adapters.crud.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import fr.demo_dsfr_rest.domain.AdapterService;
import fr.demo_dsfr_rest.domain.entities.demo_dsfr.RequestDemoDtoImpl;
import fr.demo_dsfr_rest.domain.port.adapters.crud.demo_dsfr.RequestDemoCrudProvider;
import fr.demo_dsfr_rest.infra.entities.mappers.demo_dsfr.RequestDemoMapper;
import fr.demo_dsfr_rest.infra.entities.repositories.demo_dsfr.RequestDemoRepository;

// End of user code

@AdapterService
public class RequestDemoCrudJpaProviderImpl implements RequestDemoCrudProvider {

	/** Le gestionnaire de persistance. */
	private RequestDemoRepository requestDemoRepository;

	/**
	 * Constructeur avec injection des parametres.
	 */
	public RequestDemoCrudJpaProviderImpl(final RequestDemoRepository requestDemoRepository) {

		this.requestDemoRepository = requestDemoRepository;
	}

	@Override
	public void save(final RequestDemoDtoImpl requestDemo) {
		this.requestDemoRepository.save(RequestDemoMapper.toEntity(requestDemo));
	}

	@Override
	public void update(final RequestDemoDtoImpl requestDemo) {
		this.requestDemoRepository.save(RequestDemoMapper.toEntity(requestDemo));
	}

	@Override
	public void delete(final RequestDemoDtoImpl requestDemo) {
		this.requestDemoRepository.delete(RequestDemoMapper.toEntity(requestDemo));
	}

	@Override
	public void findById(final RequestDemoDtoImpl requestDemo) {
		this.requestDemoRepository.findById(requestDemo.getRequestDemo_id());
	}
}
