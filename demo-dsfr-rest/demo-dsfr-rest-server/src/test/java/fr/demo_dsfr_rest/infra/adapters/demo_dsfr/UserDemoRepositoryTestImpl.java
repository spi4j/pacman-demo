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

import java.time.LocalDate;
import java.util.ArrayList;
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
import fr.demo_dsfr_rest.infra.entities.repositories.demo_dsfr.UserDemoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

// End of user code

/**
 * Classe de test unitaire pour le repository {@link UserDemoRepository}.
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
public class UserDemoRepositoryTestImpl extends Demo_dsfr_restTestAbs {

	/** Couche de persistance. */
	private final UserDemoRepository userDemoRepository;

	/** Identifiant d'une entité créé par le script d'initialisation des données. */
	private Long crudId = 1000L;

	/** Identifiant de travail pour l'entité. */
	private Long crudIdRun = 1L;

	/**
	 * Constructeur avec injection de la couche de persistance.
	 * 
	 * @param userDemoRepository Le repository pour l'entité.
	 * @param dataSource         La source de données à utiliser pour les tests.
	 * @param entityManager      L'EntityManager utilisé pour manipuler la base de
	 *                           données.
	 */
	@Autowired
	UserDemoRepositoryTestImpl(final UserDemoRepository userDemoRepository, final DataSource dataSource,
			final EntityManager entityManager) {
		this.userDemoRepository = userDemoRepository;
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

		List<UserDemoEntityImpl> userDemo = userDemoRepository.findAll();

		assertNotNull(userDemo, "La liste ne peut pas etre nulle");
		assertTrue(userDemo.size() > 0, "La liste doit comporter au moins une entite");
		int count = userDemo.stream().filter(o -> o.getUserDemo_id().equals(crudId)).collect(Collectors.toList())
				.size();
		assertTrue(count == 1, "L'entite n'a pas ete trouvee dans la liste des entites recuperees");

		// Start of user code facdd89b14fab68782af0cd13c8653ee
		// End of user code
	}

	/**
	 * Vérifie que l'entité UserDemo est correctement récupérée par son identifiant.
	 * 
	 * @throws Exception Si une exception se produit pendant l'exécution du test.
	 */
	@Test
	public void testFindById() throws Exception {

		Optional<UserDemoEntityImpl> userDemo = userDemoRepository.findById(crudId);

		assertTrue(!userDemo.isEmpty(), "Aucune entite n'a ete recuperee");
		assertTrue(userDemo.get().getUserDemo_id() == crudId, "L'entite recuperee n'est pas la bonne entite");

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
		CriteriaQuery<UserDemoEntityImpl> cr = cb.createQuery(UserDemoEntityImpl.class);
		Root<UserDemoEntityImpl> root = cr.from(UserDemoEntityImpl.class);
		cr.select(root).where(cb.equal(root.get("userDemo_id"), crudId));
		Query<UserDemoEntityImpl> query = session.createQuery(cr);
		List<UserDemoEntityImpl> userDemo = query.getResultList();

		assertTrue(!userDemo.isEmpty(), "Aucune entite n'a ete recuperee");
		assertTrue(crudId.equals(userDemo.get(0).getUserDemo_id()), "L'entite recuperee n'est pas la bonne entite");

		// Start of user code ac6d0dccc457924f8c7e8ecb8b86ac83
		// End of user code
	}

	@Test
	public void testValidate() throws Exception {

		// Start of user code c9f326acc4088b79803774041e895edc
		// End of user code
	}

	/**
	 * Test de la création d'une entité UserDemo dans la base de données. Vérifie
	 * que l'entité créée possède bien une clé primaire.
	 * 
	 * @throws Exception Si une exception se produit pendant l'exécution du test.
	 */
	@Test
	public void testCreate() throws Exception {

		UserDemoEntityImpl userDemo = new UserDemoEntityImpl();
		userDemo.setFirstName("S");
		userDemo.setLastName("S");
		userDemo.setPhone("S");
		userDemo.setMail("S");
		userDemo.setCity("S");
		userDemo.setZipCode("S");
		userDemo.setLogin("S");
		userDemo.setAddress("S");
		userDemo.setCivility("S");
		userDemo.setDateOfBirth(LocalDate.now());
		userDemo.setPassword("S");
		userDemo.setBusinessActivity("S");

		RequestDemoEntityImpl hasRequests = new RequestDemoEntityImpl();
		hasRequests.setRequestDemo_id(crudId);
		userDemo.setHasRequests(new ArrayList<RequestDemoEntityImpl>(List.of(hasRequests)));

		userDemoRepository.save(userDemo);
		this.crudIdRun = userDemo.getUserDemo_id();

		assertNotNull(userDemo.getUserDemo_id(), "L'entity creee devrait avoir une cle primaire renseignee");

		// Start of user code 246c678d0d2185ee4a5f4a58b1a3f804
		// End of user code
	}

	/**
	 * Test de la création d'une entité UserDemo avec des valeurs nulles.
	 * 
	 * @throws Exception Si une exception se produit pendant l'exécution du test.
	 */
	@Test
	public void testCreateWithNull() throws Exception {

		UserDemoEntityImpl userDemo = new UserDemoEntityImpl();
		userDemo.setFirstName("S");
		userDemo.setLastName("S");
		userDemo.setPhone(null);
		userDemo.setMail(null);
		userDemo.setCity(null);
		userDemo.setZipCode(null);
		userDemo.setLogin("S");
		userDemo.setAddress(null);
		userDemo.setCivility("S");
		userDemo.setDateOfBirth(null);
		userDemo.setPassword("S");
		userDemo.setBusinessActivity(null);

		RequestDemoEntityImpl hasRequests = new RequestDemoEntityImpl();
		hasRequests.setRequestDemo_id(crudId);
		userDemo.setHasRequests(new ArrayList<RequestDemoEntityImpl>(List.of(hasRequests)));

		userDemoRepository.save(userDemo);

		assertNotNull(userDemo.getUserDemo_id(), "L'entity creee devrait avoir une cle primaire renseignee");

		// Start of user code c549d1f622756a5360ed07b1cd424dac
		// End of user code
	}

	/**
	 * Test de la création d'une entité UserDemo avec un champ obligatoire manquant.
	 * Vérifie qu'une exception est levée en cas de violation d'intégrité des
	 * données.
	 * 
	 * @throws Exception Si une exception se produit pendant l'exécution du test.
	 */
	@Test
	public void testCreateWithNullOnMandatory() throws Exception {
		UserDemoEntityImpl userDemo = new UserDemoEntityImpl();

		try {
			userDemo.setFirstName(null);
			userDemo.setLastName(null);
			userDemo.setPhone("S");
			userDemo.setMail("S");
			userDemo.setCity("S");
			userDemo.setZipCode("S");
			userDemo.setLogin(null);
			userDemo.setAddress("S");
			userDemo.setCivility(null);
			userDemo.setDateOfBirth(LocalDate.now());
			userDemo.setPassword(null);
			userDemo.setBusinessActivity("S");

			RequestDemoEntityImpl hasRequests = new RequestDemoEntityImpl();
			hasRequests.setRequestDemo_id(crudId);
			userDemo.setHasRequests(new ArrayList<RequestDemoEntityImpl>(List.of(hasRequests)));

			userDemoRepository.save(userDemo);
		} catch (DataIntegrityViolationException e) {
			return;
		}

		// Start of user code 3bee2a3cf1479776bccdf476671f0f43
		// End of user code

		fail("L'entity ne devrait pas avoir ete cree");
	}

	/**
	 * Test de la mise à jour d'une entité UserDemo.
	 * 
	 * @throws Exception Si une exception se produit pendant l'exécution du test.
	 */
	@Test
	public void testUpdate() throws Exception {
		testCreate();
		Optional<UserDemoEntityImpl> userDemo = userDemoRepository.findById(this.crudIdRun);

		// Start of user code 55a21c5e67b9311a5d06f9b6c4a7a32b
		// End of user code

		userDemoRepository.save(userDemo.get());

		assertNotNull(userDemo.get().getUserDemo_id(), "L'entity creee devrait avoir une cle primaire renseignee");

		// Start of user code ac82613702aea642a6783fe96033836c
		// End of user code
	}

	/**
	 * Test de la suppression d'une entité UserDemo.
	 * 
	 * @throws Exception Si une exception se produit pendant l'exécution du test.
	 */
	@Test
	public void testDelete() throws Exception {
		testCreate();
		Optional<UserDemoEntityImpl> userDemo = userDemoRepository.findById(this.crudIdRun);

		userDemoRepository.delete(userDemo.get());

		userDemo = userDemoRepository.findById(this.crudIdRun);

		assertTrue(userDemo.isEmpty(), "L'entity devrait avoir ete supprimee");

		// Start of user code 33213e7683c1e6d15b2a658f3c567717
		// End of user code
	}

	/**
	 * Tests de la bonne insertion de l'ensemble des champs. On ne contrôle que les
	 * champs de l'entité UserDemo.
	 * 
	 * @throws Exception Exception Si une exception se produit pendant l'exécution
	 *                   du test.
	 */
	@Test
	public void testAllFieldsInserted() throws Exception {

		UserDemoEntityImpl userDemo = new UserDemoEntityImpl();
		userDemo.setDisableAutoInit(true);

		// Start of user code 0fbb85005efbcba2d1a2536bad04d024
		userDemo.setFirstName("S");
		userDemo.setLastName("S");
		userDemo.setPhone("S");
		userDemo.setMail("S");
		userDemo.setCity("S");
		userDemo.setZipCode("S");
		userDemo.setLogin("S");
		userDemo.setAddress("S");
		userDemo.setCivility("S");
		userDemo.setDateOfBirth(LocalDate.now());
		userDemo.setPassword("S");
		userDemo.setBusinessActivity("S");
		RequestDemoEntityImpl hasRequests = new RequestDemoEntityImpl();
		hasRequests.setRequestDemo_id(crudId);
		userDemo.setHasRequests(new ArrayList<RequestDemoEntityImpl>(List.of(hasRequests)));

		// End of user code

		userDemoRepository.save(userDemo);
		this.crudIdRun = userDemo.getUserDemo_id();

		Optional<UserDemoEntityImpl> userDemo2 = userDemoRepository.findById(this.crudIdRun);

		assertEquals(userDemo.getFirstName(), userDemo2.get().getFirstName(),
				"firstName : Les champs ne correspondent pas");
		assertEquals(userDemo.getLastName(), userDemo2.get().getLastName(),
				"lastName : Les champs ne correspondent pas");
		assertEquals(userDemo.getPhone(), userDemo2.get().getPhone(), "phone : Les champs ne correspondent pas");
		assertEquals(userDemo.getMail(), userDemo2.get().getMail(), "mail : Les champs ne correspondent pas");
		assertEquals(userDemo.getCity(), userDemo2.get().getCity(), "city : Les champs ne correspondent pas");
		assertEquals(userDemo.getZipCode(), userDemo2.get().getZipCode(), "zipCode : Les champs ne correspondent pas");
		assertEquals(userDemo.getLogin(), userDemo2.get().getLogin(), "login : Les champs ne correspondent pas");
		assertEquals(userDemo.getAddress(), userDemo2.get().getAddress(), "address : Les champs ne correspondent pas");
		assertEquals(userDemo.getCivility(), userDemo2.get().getCivility(),
				"civility : Les champs ne correspondent pas");
		assertEquals(userDemo.getDateOfBirth(), userDemo2.get().getDateOfBirth(),
				"dateOfBirth : Les champs ne correspondent pas");
		assertEquals(userDemo.getPassword(), userDemo2.get().getPassword(),
				"password : Les champs ne correspondent pas");
		assertEquals(userDemo.getBusinessActivity(), userDemo2.get().getBusinessActivity(),
				"businessActivity : Les champs ne correspondent pas");

		// Start of user code b02b056bb658395049850159c2a317be
		// End of user code

	}
}
