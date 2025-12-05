/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.util.Arrays;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;

import fr.demo_dsfr_rest.domain.AdapterService;
import fr.demo_dsfr_rest.domain.DomainService;
import fr.demo_dsfr_rest.domain.StubService;

// End of user code

/**
 * Classe de démarrage de l'application Spring Boot. Cette classe est annotée
 * avec {@link SpringBootApplication}, ce qui permet de configurer
 * automatiquement les composants nécessaires à l'exécution de l'application.
 * 
 * Toutes les classes annotées {@link StubService} ne sont pas prises en compte
 * par Spring ce qui désactive par défaut l'injection des différentes bouchons
 * pour les tests d'intégration.
 * 
 * Elle active par ailleurs la gestion des aspects avec
 * {@link EnableAspectJAutoProxy} et configure un scan de composants
 * personnalisé pour inclure les services annotés avec {@link AdapterService} et
 * {@link DomainService}.
 * 
 * La méthode {@link #main(String...)} est le point d'entrée principal de
 * l'application, qui démarre l'application Spring Boot.
 *
 * @author MINARM
 *
 * @see SpringBootApplication
 * @see EnableAspectJAutoProxy
 * @see ComponentScan
 * @see DomainService
 * @see AdapterService
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "fr.demo_dsfr_rest" }, includeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = { DomainService.class, AdapterService.class }) })
public class Demo_dsfr_restBootstrap {

	/**
	 * Le logger pour la classe.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(Demo_dsfr_restBootstrap.class);

	/**
	 * Point d'entrée de l'application Spring Boot. Il démarre l'application en
	 * appelant {@link SpringApplication#run(Class, String...)} avec la classe
	 * {@code  Demo_dsfr_restBootstrap}.
	 *
	 * @param args Les arguments de la ligne de commande.
	 */
	public static void main(String... args) {

		// Start of user code fad58de7366495db4650cfefac2fcd61

		// End of user code

		TimeZone.setDefault(TimeZone.getTimeZone("GMT+08:00"));
		SpringApplication.run(Demo_dsfr_restBootstrap.class, args);
	}

	/**
	 * Un {@link CommandLineRunner} qui est exécuté au démarrage de l'application.
	 * Il affiche la liste de tous les beans définis dans le contexte de
	 * l'application Spring.
	 *
	 * @param ctx Le contexte de l'application Spring contenant les beans.
	 * @return Un {@link CommandLineRunner} qui est exécuté au démarrage de
	 *         l'application.
	 */
	// @Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			LOG.debug("Liste des beans disponibles pour Spring Boot:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				LOG.debug(beanName);
			}
		};
	}

	// Start of user code cc7cc330467ff509028f0297a4c8e288
	// End of user code
}
