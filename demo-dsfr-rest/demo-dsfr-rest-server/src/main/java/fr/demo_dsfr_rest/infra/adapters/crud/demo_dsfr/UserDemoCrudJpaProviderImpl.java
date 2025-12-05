/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.infra.adapters.crud.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import fr.demo_dsfr_rest.domain.AdapterService;
import fr.demo_dsfr_rest.domain.entities.demo_dsfr.UserDemoDtoImpl;
import fr.demo_dsfr_rest.domain.port.adapters.crud.demo_dsfr.UserDemoCrudProvider;
import fr.demo_dsfr_rest.infra.entities.mappers.demo_dsfr.UserDemoMapper;
import fr.demo_dsfr_rest.infra.entities.repositories.demo_dsfr.UserDemoRepository;

// End of user code

@AdapterService
public class UserDemoCrudJpaProviderImpl implements UserDemoCrudProvider {

	/** Le gestionnaire de persistance. */
	private UserDemoRepository userDemoRepository;

	/**
	 * Constructeur avec injection des parametres.
	 */
	public UserDemoCrudJpaProviderImpl(final UserDemoRepository userDemoRepository) {

		this.userDemoRepository = userDemoRepository;
	}

	@Override
	public void save(final UserDemoDtoImpl userDemo) {
		this.userDemoRepository.save(UserDemoMapper.toEntity(userDemo));
	}

	@Override
	public void update(final UserDemoDtoImpl userDemo) {
		this.userDemoRepository.save(UserDemoMapper.toEntity(userDemo));
	}

	@Override
	public void delete(final UserDemoDtoImpl userDemo) {
		this.userDemoRepository.delete(UserDemoMapper.toEntity(userDemo));
	}

	@Override
	public void findById(final UserDemoDtoImpl userDemo) {
		this.userDemoRepository.findById(userDemo.getUserDemo_id());
	}
}
