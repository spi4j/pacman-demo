/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain.port.adapters.crud.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import fr.demo_dsfr_rest.domain.entities.demo_dsfr.UserDemoDtoImpl;

// End of user code

/**
 * Utilisateur de l'application.
 * 
 * @Author MINARM
 */
public interface UserDemoCrudProvider {
	public void save(final UserDemoDtoImpl userDemo);

	public void update(final UserDemoDtoImpl userDemo);

	public void delete(final UserDemoDtoImpl userDemo);

	public void findById(final UserDemoDtoImpl userDemo);
}
