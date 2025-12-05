/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

/**
 * Classe utilitaire permettant d'accéder aux informations du token JWT courant
 * à partir du contexte de sécurité Spring Security. Fournit des méthodes
 * pratiques pour récupérer le JWT, l'ID utilisateur, les rôles, et tous les
 * claims.
 *
 * Cette classe est générée dès la création du projet et ne peut présumer de la
 * présence ou non d'une sécurité. A supprimer si le projet ne contient aucune
 * règle de sécurité concernant l'accès pour ses apis.
 * 
 * @author MINARM
 */
public class Demo_dsfr_restCurrentJwtTokenHelper {

	/**
	 * Récupère le token JWT courant à partir du {@link SecurityContextHolder}.
	 *
	 * @return un {@link Optional} contenant le {@link Jwt} si disponible, sinon
	 *         vide
	 */
	public static Optional<Jwt> getJwt() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth instanceof JwtAuthenticationToken jwtAuth) {
			return Optional.of(jwtAuth.getToken());
		}
		return Optional.empty();
	}

	/**
	 * Récupère l'identifiant de l'utilisateur (claim {@code sub}) depuis le token
	 * JWT.
	 *
	 * @return un {@link Optional} contenant l'identifiant de l'utilisateur, sinon
	 *         vide
	 */
	public static Optional<String> getUserId() {
		return getJwt().map(Jwt::getSubject);
	}

	/**
	 * Récupère la liste des rôles définis dans le claim {@code roles} du JWT.
	 *
	 * @return la liste des rôles, ou une liste vide si non définis
	 */
	public static List<String> getRoles() {
		return getJwt().map(jwt -> jwt.getClaimAsStringList("roles")).orElse(List.of());
	}

	/**
	 * Récupère tous les claims du token JWT courant.
	 *
	 * @return une {@link Map} contenant les noms et valeurs des claims, ou une map
	 *         vide si aucun token n'est présent
	 */
	public static Map<String, Object> getClaims() {
		return getJwt().map(Jwt::getClaims).orElse(Map.of());
	}
}
