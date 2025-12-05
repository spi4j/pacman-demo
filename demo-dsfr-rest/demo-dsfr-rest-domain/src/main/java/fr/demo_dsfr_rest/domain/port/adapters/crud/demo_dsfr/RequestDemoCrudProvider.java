/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain.port.adapters.crud.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import fr.demo_dsfr_rest.domain.entities.demo_dsfr.RequestDemoDtoImpl;

// End of user code

/**
 * Demande pour un utilisateur.
 * 
 * @Author MINARM
 */
public interface RequestDemoCrudProvider {
	public void save(final RequestDemoDtoImpl requestDemo);

	public void update(final RequestDemoDtoImpl requestDemo);

	public void delete(final RequestDemoDtoImpl requestDemo);

	public void findById(final RequestDemoDtoImpl requestDemo);
}
