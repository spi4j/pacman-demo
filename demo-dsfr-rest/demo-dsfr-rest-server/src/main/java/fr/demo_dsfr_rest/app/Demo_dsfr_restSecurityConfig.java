/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.web.BearerTokenResolver;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.source.ImmutableSecret;

import jakarta.servlet.http.HttpServletRequest;

// End of user code

/**
 * Configuration de la sécurité pour l'API avec Spring Security. Cette classe
 * configure la sécurité des requêtes HTTP, la gestion des sessions, et la
 * gestion des JWT (JSON Web Tokens). Elle implémente la sécurité pour les
 * endpoints spécifiques tout en permettant certaines routes non sécurisées.
 * 
 * Elle utilise des clés JWT pour l'authentification, avec une clé secrète
 * définie pour signer et vérifier les JWT. La configuration applique une
 * politique de création de session stateless et désactive la protection CSRF
 * pour les API.
 * 
 * Par défaut, les règles de sécurité suivantes sont appliquées :
 * 
 * Les requêtes vers l'api de santé et swagger sont accessibles sans
 * authentification. Certaines autres routes non sécurisées sont définies
 * explicitement. Toutes les autres requêtes sont sécurisées et nécessitent une
 * authentification.
 *
 * Attention à bien mettre des URLs valides pour la déclaration de la sécurité,
 * si le tokenUrl est invalide ou manquant, Swagger UI ne pourra pas afficher le
 * flow d'authentification le cadenas ne sera pas affiché.
 *
 * @Author MINARM
 */
@Configuration
@EnableWebSecurity
class Demo_dsfr_restSecurityConfig {

	/**
	 * Chemins d'accès aux spécifications OpenAPI, metrics, etc... défini par la
	 * propriété {@code security.whitelist.paths}.
	 */
	@Value("${security.whitelist.paths}")
	private String[] whiteListPaths;

	// Start of user code f1df2d60eb47a96ef4b866b311e17077

	/**
	 * Clé secrète utilisée pour l'encodage et le décodage des jetons JWT. Cette clé
	 * ne doit pas être stockée en dur sur le serveur en production.
	 */
	@Value("${security.jwt.secret}")
	private String jwtKey;

	/**
	 * URI de l'émetteur (issuer) des jetons JWT. Cette propriété correspond à l'URL
	 * du fournisseur d'identité (Identity Provider) utilisée pour valider les
	 * jetons JWT entrants. Elle permet à Spring Security de récupérer
	 * automatiquement les métadonnées de configuration (notamment les clés
	 * publiques de signature) via le endpoint OpenID Connect standard.
	 * </p>
	 * <p>
	 * Typiquement, cette URL pointe vers un serveur d'authentification tel que
	 * Keycloak, incluant le realm concerné.
	 * </p>
	 * <p>
	 * Exemple : {@code http://localhost:8085/realms/pacman-demo-realm}
	 * </p>
	 */
	@Value("${security.jwt.issuer-uri}")
	private String issuerUri;

	// End of user code

	/** Gestion des erreurs sur obtention du jeton. */
	@Autowired
	@Qualifier("Demo_dsfr_restAuthEntryPoint")
	AuthenticationEntryPoint authEntryPoint;

	/**
	 * Définition de la chaîne de filtres de sécurité HTTP pour l'application. Cette
	 * méthode configure les règles de sécurité des différents endpoints et la
	 * gestion des sessions (toujours stateless par défaut pour les API REST).
	 * 
	 * Pour les API REST sans état, en particulier celles utilisant
	 * l'authentification basée sur des jetons, la désactivation du CSRF est une
	 * décision courante et sûre.
	 * <p>
	 * On part sur le postulat suivant : la majorité des requêtes sont (et doivent)
	 * être sécurisées, les requêtes non sécurisées sont donc l'exception. Si Aucune
	 * requête n'est sécurisée au niveau de l'application, supprimer manuellement le
	 * filtre après génération -> aucun contrôle n'est effectué à ce niveau pour la
	 * génération ou la non génération d'un filtre de sécurité.
	 *
	 * Pour l'instant, la gestion des rôles est positionnée au niveau de la
	 * configuration de sécurité. Toutes les règles d'accès sont dans une seule
	 * configuration et cela est plus performant car géré très tôt dans la chaîne de
	 * sécurité. Enfin, il y a une correspondance claire entre URI et rôles. Il est
	 * cependant impossible d'avoir des logiques complexes, pour cela positionner
	 * une annotation {@link PreAuthorize} au niveau de la méthode du contrôleur
	 * pour le service.
	 *
	 * Quelle que soit la stratégie de sécurité, le retour d'authentification se
	 * matérialise par l'obtention d'un jeton (jwt), comme Spring Security ne prend
	 * pas directement en charge JWT, on profite donc de la librairie oauth2 dans
	 * tous les cas pour le codage / décodage du jeton
	 *
	 * @param http l'objet HttpSecurity qui permet de configurer la sécurité des
	 *             requêtes HTTP.
	 * @return un objet SecurityFilterChain configuré avec les règles de sécurité.
	 * @throws Exception si une erreur se produit lors de la configuration.
	 */
	@Bean
	@Order(150)
	public SecurityFilterChain tokenFilterChain(HttpSecurity http) throws Exception {
		return http.cors(Customizer.withDefaults()).csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(request -> {

					/**
					 * Gestion de la sécurité pour les apis de santé, spécifications OpenAPI, etc...
					 */
					request.requestMatchers(whiteListPaths).permitAll()

							/** Liste des uris non sécurisées. */
							.requestMatchers("/v0/users").permitAll()

							/** Liste des uris sécurisées avec un rôle spécifique. */

							// Start of user code f93dcfaeb3f3471dffb8f1981854aebe
							// End of user code

							/** Par défaut, tout le reste est sécurisé. */
							.anyRequest().authenticated();

				})
				.oauth2ResourceServer(
						oauth2 -> oauth2.bearerTokenResolver(jwtTokenResolver()).jwt(Customizer.withDefaults()))
				.exceptionHandling(Customizer.withDefaults()).build();
	}

	/**
	 * Configure un {@link SecurityFilterChain} spécifique pour sécuriser l'endpoint
	 * "/token".
	 * 
	 * Cette configuration désactive le CSRF, utilise une politique de session
	 * stateless (aucune session ne sera créée), et exige que toutes les requêtes
	 * vers "/token" soient authentifiées via HTTP Basic.
	 *
	 * Le point d'entrée d'authentification personnalisé {@code authEntryPoint} est
	 * utilisé pour gérer les erreurs d'authentification.
	 *
	 * @param http l'objet {@link HttpSecurity} fourni par Spring Security
	 * @return une instance de {@link SecurityFilterChain} configurée pour l'URL
	 *         "/token"
	 * @throws Exception si une erreur survient lors de la configuration
	 */
	@Bean
	@Order(50)
	public SecurityFilterChain authFilterChain(HttpSecurity http) throws Exception {
		return http.cors(Customizer.withDefaults()).csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.securityMatcher("/token").authorizeHttpRequests(auth -> {
					auth.anyRequest().authenticated();
				}).exceptionHandling(Customizer.withDefaults())
				.httpBasic(basic -> basic.authenticationEntryPoint(authEntryPoint)).build();
	}

	/**
	 * Bean responsable du décodage et de la validation des JWT.
	 *
	 * Cette méthode définit la manière dont les jetons JWT sont interprétés et
	 * validés par l'application. Elle constitue le point central de la chaîne de
	 * sécurité OAuth2 Resource Server pour tout ce qui concerne la vérification du
	 * jeton.
	 *
	 * <h3>Fonctionnement</h3>
	 * <ul>
	 * <li>Le JWT est extrait de l'en-tête HTTP {@code Authorization} sous la forme
	 * {@code Bearer <token>}.</li>
	 * <li>Le {@link JwtDecoder} est ensuite responsable de la validation complète
	 * du jeton.</li>
	 * <li>Cette validation peut inclure : signature, expiration, issuer, audience,
	 * claims personnalisés, etc.</li>
	 * </ul>
	 *
	 * <h3>Point d'extension critique</h3>
	 * <p>
	 * Ce bean est <b>le point d'extension principal</b> pour influencer le
	 * comportement de sécurité JWT. Contrairement aux filtres Spring Security ou
	 * aux {@link org.springframework.security.web.SecurityFilterChain}, toute
	 * logique de validation du jeton passe obligatoirement par ce composant.
	 *
	 * Il est donc possible d'y implémenter des comportements avancés tels que :
	 *
	 * <ul>
	 * <li>Accepter des jetons de démonstration (ex: {@code fake.token}) sans
	 * validation externe.</li>
	 * <li>Implémenter des règles conditionnelles de validation selon le contenu du
	 * jeton.</li>
	 * <li>Basculer entre différents modes de validation (démo, test,
	 * production).</li>
	 * <li>Ajouter des vérifications métiers sur les claims (roles, issuer,
	 * audience, etc.).</li>
	 * </ul>
	 *
	 * <h3>Important</h3>
	 * Toute décision d'authentification basée sur JWT dans une application Spring
	 * Security OAuth2 Resource Server doit être réalisée ici ou via un délégué de
	 * {@link JwtDecoder}. Les filtres ou chaînes de sécurité ne permettent pas de
	 * contourner ou d'intercepter proprement la validation du jeton une fois ce
	 * mécanisme activé.
	 *
	 * <h3>Bonnes pratiques</h3>
	 * <ul>
	 * <li>Toujours transmettre le jeton via l'en-tête HTTP
	 * {@code Authorization}.</li>
	 * <li>Utiliser le standard {@code Bearer <token>}.</li>
	 * <li>Centraliser la logique de validation dans ce bean.</li>
	 * <li>Éviter toute logique de contournement dans les filtres ou
	 * SecurityFilterChain.</li>
	 * </ul>
	 *
	 * @return un objet {@link JwtDecoder} utilisé pour décoder et valider les
	 *         jetons JWT entrants.
	 */
	@Bean
	public JwtDecoder jwtDecoder() {

		// Start of user code 7115a832499feae23171aafa8601602f

		return token -> {

			if ("local.fake.token".equals(token)) {
				return Jwt.withTokenValue(token).header("alg", "none").claim("sub", "demo-user")
						.claim("roles", List.of("user")).build();
			}

			return JwtDecoders.fromIssuerLocation(issuerUri).decode(token);
		};

		// End of user code
	}

	/**
	 * Bean pour l'encodage des JWT avec la clé secrète définie. Cette méthode crée
	 * un JwtEncoder qui utilise la clé secrète pour signer les JWT.
	 * 
	 * @return un objet JwtEncoder utilisé pour encoder les JWT sortants.
	 */
	@Bean
	public JwtEncoder jwtEncoder() {
		return new NimbusJwtEncoder(new ImmutableSecret<>(this.jwtKey.getBytes()));
	}

	/**
	 * Bean avec implémentation personnalisée de {@link BearerTokenResolver}
	 * permettant de résoudre un token d'accès Bearer à partir de différentes
	 * sources dans une requête HTTP. Pour l'instant la recherche dans les cookies
	 * n'est pas activée. Par contre cette classe prépare déjà la possibilité
	 * d'avoir de multiples schémas de sécurité pour un service, d'ou le format de
	 * ce code.
	 *
	 * On tente de récupérer le token dans l'ordre suivant (selon la nature de la
	 * sécurité, tous les étapes ne sont pas présentes):
	 * 
	 * <ol>
	 * <li>L'en-tête HTTP {@code Authorization} avec le préfixe {@code Bearer } (le
	 * plus fréquent)</li>
	 * <li>Le paramètre de requête {@code token}</li>
	 * </ol>
	 * 
	 * Si aucun token n'est trouvé, la méthode {@code resolve} retourne
	 * {@code null}.
	 */
	@Bean
	public BearerTokenResolver jwtTokenResolver() {
		return new BearerTokenResolver() {
			@Override
			public String resolve(HttpServletRequest request) {
				/** Recherche dans l'en-tête, le plus courant (toujours présent). */
				String authHeader = request.getHeader("Authorization");
				if (authHeader != null && authHeader.startsWith("Bearer ")) {
					return authHeader.substring(7);
				}
				return null; // Aucun jeton trouvé.
			}
		};
	}

	/**
	 * Configure un convertisseur chargé de transformer un {@link Jwt} en
	 * {@link org.springframework.security.authentication.AbstractAuthenticationToken}.
	 *
	 * <p>
	 * Ce convertisseur est utilisé par Spring Security pour extraire les rôles
	 * (authorities) contenus dans le JWT et les convertir en objets
	 * {@link org.springframework.security.core.GrantedAuthority} exploitables par
	 * le système de sécurité.
	 * </p>
	 * <p>
	 * La configuration appliquée est la suivante :
	 * </p>
	 * <ul>
	 * <li>Les rôles sont extraits depuis la claim JWT <b>"roles"</b>.</li>
	 * <li>Chaque rôle est préfixé automatiquement par <b>"ROLE_"</b>.</li>
	 * <li>Les autorités sont ensuite injectées dans un
	 * {@link org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken}.</li>
	 * </ul>
	 * <p>
	 * Ce bean est utilisé dans la configuration OAuth2 Resource Server afin de
	 * personnaliser la manière dont les claims JWT sont traduits en autorités
	 * Spring Security.
	 * </p>
	 *
	 * @return un {@link JwtAuthenticationConverter} configuré pour transformer un
	 *         JWT en authentification Spring Security
	 */
	@Bean
	public JwtAuthenticationConverter jwtAuthenticationConverter() {
		JwtGrantedAuthoritiesConverter delegate = new JwtGrantedAuthoritiesConverter();
		delegate.setAuthoritiesClaimName("roles");
		delegate.setAuthorityPrefix("ROLE_");
		JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
		converter.setJwtGrantedAuthoritiesConverter(delegate);
		return converter;
	}

	/**
	 * Crée un bean {@link UserDetailsService} en mémoire avec un utilisateur de
	 * base.
	 * 
	 * Cet utilisateur possède le nom d'utilisateur "user", un mot de passe encodé
	 * avec {@link BCryptPasswordEncoder} et le rôle "USER" par défaut.
	 * 
	 * @return Un {@link UserDetailsService} qui gère l'utilisateur en mémoire.
	 */
	@Bean
	public UserDetailsService users() {

		// Start of user code 9bc65c2abec141778ffaa729489f3e87

		UserDetails user = User.builder().username("user").password(passwordEncoder().encode("password")).roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
		// End of user code
	}

	/**
	 * Crée un bean pour l'encodeur de mot de passe {@link BCryptPasswordEncoder}.
	 * 
	 * Ce bean est utilisé pour encoder les mots de passe des utilisateurs dans
	 * l'application.
	 * 
	 * @return Un {@link BCryptPasswordEncoder} qui permet de hacher les mots de
	 *         passe.
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Start of user code 401a85bd411e63b5ca25428ede6359ad
	// End of user code
}
