/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.infra.adapters.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.demo_dsfr_rest.domain.AdapterService;
import fr.demo_dsfr_rest.domain.entities.demo_dsfr.UserDemoDtoImpl;
import fr.demo_dsfr_rest.domain.port.adapters.demo_dsfr.UsersProvider;
import fr.demo_dsfr_rest.infra.entities.demo_dsfr.UserDemoEntityImpl;
import fr.demo_dsfr_rest.infra.entities.mappers.demo_dsfr.UserDemoMapper;
import fr.demo_dsfr_rest.infra.entities.repositories.demo_dsfr.UserDemoRepository;

// End of user code

/**
 * DESCRIPTION A IMPLEMENTER
 * 
 * @Author MINARM
 */
@AdapterService
public class UsersJpaProviderImpl implements UsersProvider {

	// Start of user code 2129864a49adcaa3a812f92be467bf4e
	// End of user code

	/** Gestionnaires de persistance disponibles. */
	final UserDemoRepository userDemoRepository;

	/**
	 * Constructeur.
	 */
	@Autowired
	public UsersJpaProviderImpl(final UserDemoRepository userDemoRepository) {

		this.userDemoRepository = userDemoRepository;

		// Start of user code 2e3e969fd52202f4f94ef7456a361c15
		// End of user code
	}

	/**
	 * Création d'un nouvel utilisateur.
	 * 
	 * @param userIn : L'utilisateur à créer.
	 *
	 * @return UserDemoDtoImpl : L'utilisateur avec son identifiant.
	 */
	@Override
	public UserDemoDtoImpl setUser(final UserDemoDtoImpl userIn) {

		// Start of user code e19cc7eb3cefc3a2666bf1e2ea6cd5a2
		// End of user code

		return UserDemoMapper.toDto(setUser_invoke(userIn));
	}

	/**
	 * Création d'un nouvel utilisateur.
	 * 
	 * @param userIn : L'utilisateur à créer.
	 *
	 * @return UserDemoDtoImpl : L'utilisateur avec son identifiant.
	 */
	// Start of user code ef3d53afcb20b5c00b4e0dcae908f1b2
	// End of user code
	private UserDemoEntityImpl setUser_invoke(final UserDemoDtoImpl userIn) {

		// Start of user code bbbc4f55376e7360e625b71743dd03f1

		UserDemoEntityImpl userEntity = UserDemoMapper.toEntity(userIn);
		return userDemoRepository.save(userEntity);

		// End of user code
	}

	/**
	 * Retourne un utilisateur en fonction de son identifiant.
	 * 
	 * @param id : L'identifiant unique pour l'utilisateur.
	 *
	 * @return Optional<UserDemoDtoImpl> : L'utilisateur retourné en fonction de son
	 *         identifiant.
	 */
	@Override
	public Optional<UserDemoDtoImpl> getUser(final Long id) {

		// Start of user code a84285b22ab53ae7963da1b038d06e71
		// End of user code

		Optional<UserDemoEntityImpl> entity = getUser_invoke(id);
		if (entity.isPresent()) {
			return Optional.of(UserDemoMapper.toDto(entity.get()));
		}
		return Optional.empty();
	}

	/**
	 * Retourne un utilisateur en fonction de son identifiant.
	 * 
	 * @param id : L'identifiant unique pour l'utilisateur.
	 *
	 * @return Optional<UserDemoDtoImpl> : L'utilisateur retourné en fonction de son
	 *         identifiant.
	 */
	// Start of user code 54567b82ffbc7a6388c0952ddd3db577
	// End of user code
	private Optional<UserDemoEntityImpl> getUser_invoke(final Long id) {

		// Start of user code 8dabbdd9bb7e05b909a22338d9c9435c

		return userDemoRepository.findById(id);

		// End of user code
	}
}
