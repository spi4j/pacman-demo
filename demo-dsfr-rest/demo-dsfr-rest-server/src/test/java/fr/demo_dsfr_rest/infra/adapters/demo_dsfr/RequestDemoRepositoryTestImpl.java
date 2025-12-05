/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.infra.adapters.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fr.demo_dsfr_rest.Demo_dsfr_restTestAbs;
import fr.demo_dsfr_rest.infra.entities.demo_dsfr.RequestDemoEntityImpl;
import fr.demo_dsfr_rest.infra.entities.demo_dsfr.UserDemoEntityImpl;
import fr.demo_dsfr_rest.infra.entities.repositories.demo_dsfr.RequestDemoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

// End of user code

/**
 * Classe de test unitaire pour le repository {@link RequestDemoRepository}.
 * Utilise {@link SpringBootTest} et les annotations de test JUnit pour tester
 * les opérations CRUD sur la couche de persistance
 * 
 * La classe étend {@link Demo_dsfr_restTestAbs}, ce qui permet d'hériter des
 * configurations de test de base et des fonctionnalités liées à la gestion des
 * données.
 * 
 * Cette classe teste les fonctionnalités suivantes :
 * <ul>
 * <li>findAll : Récupération de toutes les entités.</li>
 * <li>findById : Recherche d'une entité par son identifiant.</li>
 * <li>findByColumn : Recherche d'entités basées sur une colonne
 * spécifique.</li>
 * <li>validate : Validation des entités.</li>
 * <li>create : Création d'une entité.</li>
 * <li>createWithNull : Test de la création d'une entité avec des valeurs
 * nulles.</li>
 * <li>createWithNullOnMandatory : Test de la création d'une entité avec des
 * champs obligatoires manquants.</li>
 * <li>allFieldInserted : Test de la concordance des champs pre et post
 * insertion.</li>
 * <li>update : Mise à jour d'une entité.</li>
 * <li>delete : Suppression d'une entité.</li>
 * </ul>
 *
 * @Author MINARM
 */
@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
@TestPropertySource(locations = "classpath:tests.properties")
public class RequestDemoRepositoryTestImpl extends Demo_dsfr_restTestAbs {

	/** Couche de persistance. */
	private final RequestDemoRepository requestDemoRepository;

	/** Identifiant d'une entité créé par le script d'initialisation des données. */
	private Long crudId = 1000L;

	/** Identifiant de travail pour l'entité. */
	private Long crudIdRun = 1L;

	/**
	 * Constructeur avec injection de la couche de persistance.
	 * 
	 * @param requestDemoRepository Le repository pour l'entité.
	 * @param dataSource            La source de données à utiliser pour les tests.
	 * @param entityManager         L'EntityManager utilisé pour manipuler la base
	 *                              de données.
	 */
	@Autowired
	RequestDemoRepositoryTestImpl(final RequestDemoRepository requestDemoRepository, final DataSource dataSource,
			final EntityManager entityManager) {
		this.requestDemoRepository = requestDemoRepository;
		this.entityManager = entityManager;
		initSql(dataSource);
	}

	/**
	 * Vérifie que la liste des entités récupérées n'est pas nulle et contient au
	 * moins une entité.
	 * 
	 * @throws Exception Si une exception se produit pendant l'exécution du test.
	 */
	@Test
	public void testFindAll() {

		List<RequestDemoEntityImpl> requestDemo = requestDemoRepository.findAll();

		assertNotNull(requestDemo, "La liste ne peut pas etre nulle");
		assertTrue(requestDemo.size() > 0, "La liste doit comporter au moins une entite");
		int count = requestDemo.stream().filter(o -> o.getRequestDemo_id().equals(crudId)).collect(Collectors.toList())
				.size();
		assertTrue(count == 1, "L'entite n'a pas ete trouvee dans la liste des entites recuperees");

		// Start of user code facdd89b14fab68782af0cd13c8653ee
		// End of user code
	}

	/**
	 * Vérifie que l'entité requestDemo est correctement récupérée par son
	 * identifiant.
	 * 
	 * @throws Exception Si une exception se produit pendant l'exécution du test.
	 */
	@Test
	public void testFindById() throws Exception {

		Optional<RequestDemoEntityImpl> requestDemo = requestDemoRepository.findById(crudId);

		assertTrue(!requestDemo.isEmpty(), "Aucune entite n'a ete recuperee");
		assertTrue(requestDemo.get().getRequestDemo_id() == crudId, "L'entite recuperee n'est pas la bonne entite");

		// Start of user code 6ace50c02167250b08e7a5ea0d5e8720
		// End of user code
	}

	/**
	 * Test de la méthode de recherche personnalisée avec critères. Exemple de
	 * recherche sur une colonne spécifique de l'entité.
	 * 
	 * @throws Exception Si une exception se produit pendant l'exécution du test.
	 */
	@Test
	public void testFindByColumn() throws Exception {

		Session session = entityManager.unwrap(org.hibernate.Session.class);
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<RequestDemoEntityImpl> cr = cb.createQuery(RequestDemoEntityImpl.class);
		Root<RequestDemoEntityImpl> root = cr.from(RequestDemoEntityImpl.class);
		cr.select(root).where(cb.equal(root.get("requestDemo_id"), crudId));
		Query<RequestDemoEntityImpl> query = session.createQuery(cr);
		List<RequestDemoEntityImpl> requestDemo = query.getResultList();

		assertTrue(!requestDemo.isEmpty(), "Aucune entite n'a ete recuperee");
		assertTrue(crudId.equals(requestDemo.get(0).getRequestDemo_id()),
				"L'entite recuperee n'est pas la bonne entite");

		// Start of user code ac6d0dccc457924f8c7e8ecb8b86ac83
		// End of user code
	}

	@Test
	public void testValidate() throws Exception {

		// Start of user code c9f326acc4088b79803774041e895edc
		// End of user code
	}

	/**
	 * Test de la création d'une entité requestDemo dans la base de données. Vérifie
	 * que l'entité créée possède bien une clé primaire.
	 * 
	 * @throws Exception Si une exception se produit pendant l'exécution du test.
	 */
	@Test
	public void testCreate() throws Exception {

		RequestDemoEntityImpl requestDemo = new RequestDemoEntityImpl();
		requestDemo.setType("S");
		requestDemo.setReason("S");
		requestDemo.setIdentifier("S");
		requestDemo.setStatus("S");

		UserDemoEntityImpl userDemo_hasRequests = new UserDemoEntityImpl();
		userDemo_hasRequests.setUserDemo_id(crudId);
		requestDemo.setUserDemo_hasRequests(userDemo_hasRequests);

		requestDemoRepository.save(requestDemo);
		this.crudIdRun = requestDemo.getRequestDemo_id();

		assertNotNull(requestDemo.getRequestDemo_id(), "L'entity creee devrait avoir une cle primaire renseignee");

		// Start of user code 246c678d0d2185ee4a5f4a58b1a3f804
		// End of user code
	}

	/**
	 * Test de la création d'une entité requestDemo avec des valeurs nulles.
	 * 
	 * @throws Exception Si une exception se produit pendant l'exécution du test.
	 */
	@Test
	public void testCreateWithNull() throws Exception {

		RequestDemoEntityImpl requestDemo = new RequestDemoEntityImpl();
		requestDemo.setType("S");
		requestDemo.setReason("S");
		requestDemo.setIdentifier("S");
		requestDemo.setStatus("S");

		UserDemoEntityImpl userDemo_hasRequests = new UserDemoEntityImpl();
		userDemo_hasRequests.setUserDemo_id(crudId);
		requestDemo.setUserDemo_hasRequests(userDemo_hasRequests);

		requestDemoRepository.save(requestDemo);

		assertNotNull(requestDemo.getRequestDemo_id(), "L'entity creee devrait avoir une cle primaire renseignee");

		// Start of user code c549d1f622756a5360ed07b1cd424dac
		// End of user code
	}

	/**
	 * Test de la création d'une entité requestDemo avec un champ obligatoire
	 * manquant. Vérifie qu'une exception est levée en cas de violation d'intégrité
	 * des données.
	 * 
	 * @throws Exception Si une exception se produit pendant l'exécution du test.
	 */
	@Test
	public void testCreateWithNullOnMandatory() throws Exception {
		RequestDemoEntityImpl requestDemo = new RequestDemoEntityImpl();

		try {
			requestDemo.setType(null);
			requestDemo.setReason(null);
			requestDemo.setIdentifier(null);
			requestDemo.setStatus(null);

			UserDemoEntityImpl userDemo_hasRequests = new UserDemoEntityImpl();
			userDemo_hasRequests.setUserDemo_id(crudId);
			requestDemo.setUserDemo_hasRequests(userDemo_hasRequests);

			requestDemoRepository.save(requestDemo);
		} catch (DataIntegrityViolationException e) {
			return;
		}

		// Start of user code 3bee2a3cf1479776bccdf476671f0f43
		// End of user code

		fail("L'entity ne devrait pas avoir ete cree");
	}

	/**
	 * Test de la mise à jour d'une entité requestDemo.
	 * 
	 * @throws Exception Si une exception se produit pendant l'exécution du test.
	 */
	@Test
	public void testUpdate() throws Exception {
		testCreate();
		Optional<RequestDemoEntityImpl> requestDemo = requestDemoRepository.findById(this.crudIdRun);

		// Start of user code 55a21c5e67b9311a5d06f9b6c4a7a32b
		// End of user code

		requestDemoRepository.save(requestDemo.get());

		assertNotNull(requestDemo.get().getRequestDemo_id(),
				"L'entity creee devrait avoir une cle primaire renseignee");

		// Start of user code ac82613702aea642a6783fe96033836c
		// End of user code
	}

	/**
	 * Test de la suppression d'une entité requestDemo.
	 * 
	 * @throws Exception Si une exception se produit pendant l'exécution du test.
	 */
	@Test
	public void testDelete() throws Exception {
		testCreate();
		Optional<RequestDemoEntityImpl> requestDemo = requestDemoRepository.findById(this.crudIdRun);

		requestDemoRepository.delete(requestDemo.get());

		requestDemo = requestDemoRepository.findById(this.crudIdRun);

		assertTrue(requestDemo.isEmpty(), "L'entity devrait avoir ete supprimee");

		// Start of user code 33213e7683c1e6d15b2a658f3c567717
		// End of user code
	}

	/**
	 * Tests de la bonne insertion de l'ensemble des champs. On ne contrôle que les
	 * champs de l'entité requestDemo.
	 * 
	 * @throws Exception Exception Si une exception se produit pendant l'exécution
	 *                   du test.
	 */
	@Test
	public void testAllFieldsInserted() throws Exception {

		RequestDemoEntityImpl requestDemo = new RequestDemoEntityImpl();
		requestDemo.setDisableAutoInit(true);

		// Start of user code 0fbb85005efbcba2d1a2536bad04d024
		requestDemo.setType("S");
		requestDemo.setReason("S");
		requestDemo.setIdentifier("S");
		requestDemo.setStatus("S");
		UserDemoEntityImpl userDemo_hasRequests = new UserDemoEntityImpl();
		userDemo_hasRequests.setUserDemo_id(crudId);
		requestDemo.setUserDemo_hasRequests(userDemo_hasRequests);

		// End of user code

		requestDemoRepository.save(requestDemo);
		this.crudIdRun = requestDemo.getRequestDemo_id();

		Optional<RequestDemoEntityImpl> requestDemo2 = requestDemoRepository.findById(this.crudIdRun);

		assertEquals(requestDemo.getType(), requestDemo2.get().getType(), "type : Les champs ne correspondent pas");
		assertEquals(requestDemo.getReason(), requestDemo2.get().getReason(),
				"reason : Les champs ne correspondent pas");
		assertEquals(requestDemo.getIdentifier(), requestDemo2.get().getIdentifier(),
				"identifier : Les champs ne correspondent pas");
		assertEquals(requestDemo.getStatus(), requestDemo2.get().getStatus(),
				"status : Les champs ne correspondent pas");

		// Start of user code b02b056bb658395049850159c2a317be
		// End of user code

	}
}
