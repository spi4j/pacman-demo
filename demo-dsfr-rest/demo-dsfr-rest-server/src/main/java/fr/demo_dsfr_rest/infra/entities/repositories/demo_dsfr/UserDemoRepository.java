/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.infra.entities.repositories.demo_dsfr;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.demo_dsfr_rest.infra.entities.demo_dsfr.UserDemoEntityImpl;

/**
 * Interface de dépôt pour accéder aux entités {@link UserDemoEntityImpl}. Cette
 * interface hérite de {@link JpaRepository}, fournissant ainsi un ensemble
 * complet de méthodes CRUD, de pagination et de tri pour l'entité
 * {@code UserDemoEntityImpl}.
 *
 * Elle permet de manipuler des objets {@code UserDemoEntityImpl} en interaction
 * avec la base de données, via Spring Data JPA.
 *
 * @author MINARM
 * @see UserDemoEntityImpl
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
public interface UserDemoRepository extends JpaRepository<UserDemoEntityImpl, Long> {

	// Start of user code 7325d66f8e6f78ff40ecb7898bd53e32
	// End of user code

}
