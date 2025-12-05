/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain.services.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.demo_dsfr_rest.domain.DomainService;
import fr.demo_dsfr_rest.domain.entities.demo_dsfr.UserDemoDtoImpl;
import fr.demo_dsfr_rest.domain.port.adapters.demo_dsfr.UsersProvider;
import fr.demo_dsfr_rest.domain.port.features.demo_dsfr.UsersService;

// End of user code

/**
 * DESCRIPTION A IMPLEMENTER
 *
 * @Author MINARM
 */
// Start of user code 1a332a6854354e5d588b42a771a99752
@SuppressWarnings("unused")
// End of user code
@DomainService
public class UsersServiceImpl implements UsersService {

	/** Règles de gestion associées. */
	private final UsersRequirementImpl requirements = new UsersRequirementImpl();

	/** Le logger pour la classe. */
	private static final Logger LOG = LoggerFactory.getLogger(UsersServiceImpl.class);

	/** Interface de persistance. */
	private final UsersProvider usersProvider;

	// Start of user code 402b7c3016f1f7335e4758db75983e12
	// End of user code

	/**
	 * Constructeur avec injection de la persistance.
	 */
	public UsersServiceImpl(final UsersProvider usersProvider) {
		this.usersProvider = usersProvider;
	}

	/**
	 * Création d'un nouvel utilisateur.
	 * 
	 * @param userIn : L'utilisateur à créer.
	 *
	 * @return UserDemoDtoImpl : L'utilisateur avec son identifiant.
	 */
	// Start of user code 525e4ae1466a9b953190d0cf023144e3
	// End of user code
	@Override
	public UserDemoDtoImpl setUser(final UserDemoDtoImpl userIn) {

		// Appel des exigences en provenance de la modélisation

		// Start of user code 4d9cea5946d9b767f109c2fb2cd4a53d

		// End of user code

		UserDemoDtoImpl userOut = this.usersProvider.setUser(userIn.validate());

		// Start of user code 594d374dc2f914d3c45c73adbe097393
		// End of user code

		return userOut;
	}

	/**
	 * Retourne un utilisateur en fonction de son identifiant.
	 * 
	 * @param id : L'identifiant unique pour l'utilisateur.
	 *
	 * @return Optional<UserDemoDtoImpl> : L'utilisateur retourné en fonction de son
	 *         identifiant.
	 */
	// Start of user code 00c43ead3f53bff1b82d7bb87647edb8
	// End of user code
	@Override
	public Optional<UserDemoDtoImpl> getUser(final Long id) {

		// Appel des exigences en provenance de la modélisation

		// Start of user code b3367303c34457ed59dda258954d0bb7

		// End of user code

		Optional<UserDemoDtoImpl> userOut = this.usersProvider.getUser(id);

		// Start of user code 16b23f8cc0dace67fddc9f352e7101eb
		// End of user code

		return userOut;
	}
}
