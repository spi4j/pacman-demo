/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration de la sécurité de l'application Spring Boot.
 * 
 * Cette classe configure la chaîne de filtres de sécurité pour l'application.
 * Elle désactive la gestion de session (mode sans état), permet toutes les
 * requêtes HTTP sans authentification, et désactive la protection CSRF.
 * 
 * Elle utilise un `SecurityFilterChain` pour spécifier les règles de sécurité
 * et l'architecture sans état, ce qui est adapté pour des API RESTful ou des
 * applications où l'authentification et la gestion de session sont gérées par
 * d'autres mécanismes (par exemple, un token JWT).
 * 
 * @see org.springframework.security.web.SecurityFilterChain
 * @see org.springframework.security.config.annotation.web.builders.HttpSecurity
 */
@Configuration
@EnableWebSecurity
class Demo_dsfr_restSecurityConfig {

	/**
	 * Définit une chaîne de filtres de sécurité pour l'application.
	 * 
	 * Cette méthode configure la sécurité HTTP de l'application en : - Désactivant
	 * la protection CSRF (en raison de l'architecture sans état) - Spécifiant que
	 * l'application doit utiliser une gestion de session sans état - Permettant
	 * toutes les requêtes HTTP sans aucune authentification
	 * 
	 * @param http L'objet HttpSecurity utilisé pour configurer la sécurité HTTP.
	 * @return Un objet `SecurityFilterChain` configuré.
	 * @throws Exception Si une erreur se produit lors de la configuration de la
	 *                   sécurité HTTP.
	 */
	@Bean
	public SecurityFilterChain tokenFilterChain(HttpSecurity http) throws Exception {
		return http.cors(Customizer.withDefaults()).csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(request -> {
					request.requestMatchers("/**").permitAll().anyRequest().permitAll();
				}).build();
	}
}
