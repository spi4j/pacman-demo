/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app.adaptersdemo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.sql.DataSource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.demo_dsfr_rest.Demo_dsfr_restTestAbs;
import fr.demo_dsfr_rest.Demo_dsfr_restTestConfig;
import fr.demo_dsfr_rest.app.entities.demo_dsfr.UserDemoXtoImpl;
import fr.demo_dsfr_rest.domain.port.adapters.demo_dsfr.UsersProvider;

// End of user code

/**
 * Test d'intégration pour la classe {@link UsersServiceTestImpl}.
 * 
 * Cette classe est utilisée pour tester les fonctionnalités de la gestion des
 * personnes via les tests d'intégration avec un environnement Spring Boot
 * simulé. Elle utilise des annotations Spring comme {@link SpringBootTest},
 * {@link TestPropertySource}, et {@link AutoConfigureMockMvc} pour configurer
 * un environnement de test spécifique.
 * <p>
 * Il est à noter que le fichier de propriétés chargé avec
 * {@link @TestPropertySource} remplacera le fichier application.properties
 * existant, il contient les détails pour configurer le stockage de persistance.
 *
 * @author MINARM
 */
// Start of user code 029042fa93dec72e2777e11651549751
// End of user code
@ActiveProfiles("test")
@AutoConfigureMockMvc
@Import(Demo_dsfr_restTestConfig.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@TestPropertySource(locations = "classpath:tests.properties")
public class UsersServiceTestImpl extends Demo_dsfr_restTestAbs {

	/**
	 * Instance de {@link MockMvc} pour effectuer des requêtes HTTP simulées dans
	 * les tests.
	 */
	private MockMvc restHelper;

	/**
	 * Instance de {@link UsersProvider} qui est utilisée pour gérer les opérations
	 * de persistance au niveau des tests.
	 */
	@SuppressWarnings("unused") // Pour l'instant.
	private UsersProvider provider;

	/**
	 * Instance de {@link ObjectMapper} utilisée pour gérer les opérations de
	 * conversion entre une entité et json.
	 */
	ObjectMapper objectMapper;

	/**
	 * Constructeur.
	 */
	@Autowired
	UsersServiceTestImpl(final DataSource dataSource, final UsersProvider provider, final MockMvc restHelper,
			final ObjectMapper objectMapper) {

		this.provider = provider;
		this.objectMapper = objectMapper;
		this.restHelper = restHelper;
		initSql(dataSource);
	}

	@Test
	// Start of user code a0a75d504951febaed6c05a77746cdd2
	@Disabled("En attente de l'implémentation de la couche de persistance")
	// End of user code
	public void setUser() throws Exception {

		// Start of user code 1541af8d986e8a43e0da1fd128818287

		/** DESCRIPTION A IMPLEMENTER. */
		UserDemoXtoImpl userIn = new UserDemoXtoImpl();

		// End of user code

		/** Le statut attendu suite au test. */
		int expectedStatus = 201;

		restHelper
				.perform(post("/v0/users").content(objectMapper.writeValueAsString(userIn))
						.contentType("application/json"))

				// Start of user code 394ed762ad01e74d45b9403ed25082be
				// End of user code

				.andExpect(status().is(expectedStatus));
	}

	@Test
	// Start of user code 760e07f07f7e4e7e8ece63a5f92f00bd
	@Disabled("En attente de l'implémentation de la couche de persistance")
	// End of user code
	public void getUser() throws Exception {

		// Start of user code a2f0267f75b14d3a22d58acf0612c931

		/** DESCRIPTION A IMPLEMENTER. */
		Long id = 0L;

		// End of user code

		/** Le statut attendu suite au test. */
		int expectedStatus = 200;

		restHelper.perform(get("/v0/users/{id}", id).contentType("application/json"))

				// Start of user code 42ca6cad2b59f0568a907dc14f7850b5
				// End of user code

				.andExpect(status().is(expectedStatus));
	}

	// Start of user code a259a71e3ce5ca599cf9b1aa00962b15

	// End of user code
}
