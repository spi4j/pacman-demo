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
import fr.demo_dsfr_rest.app.entities.demo_dsfr.RequestDemoXtoImpl;
import fr.demo_dsfr_rest.domain.port.adapters.demo_dsfr.RequestsProvider;

// End of user code

/**
 * Test d'intégration pour la classe {@link RequestsServiceTestImpl}.
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
// Start of user code 470682ba91effb8a1935cd31658efe70
// End of user code
@ActiveProfiles("test")
@AutoConfigureMockMvc
@Import(Demo_dsfr_restTestConfig.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@TestPropertySource(locations = "classpath:tests.properties")
public class RequestsServiceTestImpl extends Demo_dsfr_restTestAbs {

	/**
	 * Instance de {@link MockMvc} pour effectuer des requêtes HTTP simulées dans
	 * les tests.
	 */
	private MockMvc restHelper;

	/**
	 * Instance de {@link RequestsProvider} qui est utilisée pour gérer les
	 * opérations de persistance au niveau des tests.
	 */
	@SuppressWarnings("unused") // Pour l'instant.
	private RequestsProvider provider;

	/**
	 * Instance de {@link ObjectMapper} utilisée pour gérer les opérations de
	 * conversion entre une entité et json.
	 */
	ObjectMapper objectMapper;

	/**
	 * Constructeur.
	 */
	@Autowired
	RequestsServiceTestImpl(final DataSource dataSource, final RequestsProvider provider, final MockMvc restHelper,
			final ObjectMapper objectMapper) {

		this.provider = provider;
		this.objectMapper = objectMapper;
		this.restHelper = restHelper;
		initSql(dataSource);
	}

	@Test
	// Start of user code fa4ed8ebda85f49bb9532e07c9fc695a
	@Disabled("En attente de l'implémentation de la couche de persistance")
	// End of user code
	public void setRequest() throws Exception {

		// Start of user code be063818e2f722f4eb9fed969a70328d

		/** DESCRIPTION A IMPLEMENTER. */
		RequestDemoXtoImpl requestIn = new RequestDemoXtoImpl();

		// End of user code

		/** Le statut attendu suite au test. */
		int expectedStatus = 201;

		restHelper
				.perform(post("/v0/requests").content(objectMapper.writeValueAsString(requestIn))
						.contentType("application/json"))

				// Start of user code 58fd78f73382119505702ed477147f21
				// End of user code

				.andExpect(status().is(expectedStatus));
	}

	@Test
	// Start of user code 625638097372a36c1818ee07f658d594
	@Disabled("En attente de l'implémentation de la couche de persistance")
	// End of user code
	public void getRequest() throws Exception {

		// Start of user code c9db2270b53bb2abcd57e064884948aa

		/** DESCRIPTION A IMPLEMENTER. */
		Long id = 0L;

		// End of user code

		/** Le statut attendu suite au test. */
		int expectedStatus = 200;

		restHelper.perform(get("/v0/requests/{id}", id).contentType("application/json"))

				// Start of user code 83a5652b73a191feabfb7fe2327bbd16
				// End of user code

				.andExpect(status().is(expectedStatus));
	}

	@Test
	// Start of user code d432199717ad564aa5de4884877456c0
	@Disabled("En attente de l'implémentation de la couche de persistance")
	// End of user code
	public void getRequests() throws Exception {

		// Start of user code 00fb4d67994beec857572331160d8f23

		// End of user code

		/** Le statut attendu suite au test. */
		int expectedStatus = 200;

		restHelper.perform(get("/v0/requests").contentType("application/json"))

				// Start of user code 5f154fd7f2eb9c0edd5ccb2c41be4712
				// End of user code

				.andExpect(status().is(expectedStatus));
	}

	@Test
	// Start of user code 783e73f3d6517dd4d69f925390046d7a
	@Disabled("En attente de l'implémentation de la couche de persistance")
	// End of user code
	public void getUserRequests() throws Exception {

		// Start of user code 337f9c3552203f578326ab6de481279b

		/** DESCRIPTION A IMPLEMENTER. */
		String userId = "S";

		// End of user code

		/** Le statut attendu suite au test. */
		int expectedStatus = 200;

		restHelper.perform(get("/v0/requests/user/{id}", userId).contentType("application/json"))

				// Start of user code eca3f924392ba15891149e2d0dcb9659
				// End of user code

				.andExpect(status().is(expectedStatus));
	}

	// Start of user code 0c776311bf1c964f49976443da22e967

	// End of user code
}
