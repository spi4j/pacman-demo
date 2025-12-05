/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain.port.features.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.util.Optional;

import fr.demo_dsfr_rest.domain.entities.demo_dsfr.UserDemoDtoImpl;

// End of user code

/**
 * DESCRIPTION A IMPLEMENTER
 * 
 * @Author MINARM
 */
public interface UsersService {
	/**
	 * Création d'un nouvel utilisateur.
	 * 
	 * @param userIn : L'utilisateur à créer.
	 *
	 * @return UserDemoDtoImpl : L'utilisateur avec son identifiant.
	 */
	public UserDemoDtoImpl setUser(final UserDemoDtoImpl userIn);

	/**
	 * Retourne un utilisateur en fonction de son identifiant.
	 * 
	 * @param id : L'identifiant unique pour l'utilisateur.
	 *
	 * @return Optional<UserDemoDtoImpl> : L'utilisateur retourné en fonction de son
	 *         identifiant.
	 */
	public Optional<UserDemoDtoImpl> getUser(final Long id);

}
