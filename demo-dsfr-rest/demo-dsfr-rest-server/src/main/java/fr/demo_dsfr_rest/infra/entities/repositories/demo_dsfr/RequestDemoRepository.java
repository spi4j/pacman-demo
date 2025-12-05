/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.infra.entities.repositories.demo_dsfr;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.demo_dsfr_rest.infra.entities.demo_dsfr.RequestDemoEntityImpl;

/**
 * Interface de dépôt pour accéder aux entités {@link RequestDemoEntityImpl}.
 * Cette interface hérite de {@link JpaRepository}, fournissant ainsi un
 * ensemble complet de méthodes CRUD, de pagination et de tri pour l'entité
 * {@code RequestDemoEntityImpl}.
 *
 * Elle permet de manipuler des objets {@code RequestDemoEntityImpl} en
 * interaction avec la base de données, via Spring Data JPA.
 *
 * @author MINARM
 * @see RequestDemoEntityImpl
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
public interface RequestDemoRepository extends JpaRepository<RequestDemoEntityImpl, Long> {

	// Start of user code a5d6870780cb60344e25986d6f86d013

	@Query("""
			    SELECT r
			    FROM RequestDemoEntityImpl r
			    WHERE r.userDemo_hasRequests.userDemo_id = :userId
			""")
	List<RequestDemoEntityImpl> findByUserId(final @Param("userId") Long userId);

	// End of user code

}
