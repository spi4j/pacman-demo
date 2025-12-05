/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Demo_dsfr_restAuthEntryPoint est une implémentation personnalisée de
 * l'interface {@link AuthenticationEntryPoint}. Cette classe est utilisée pour
 * gérer les erreurs d'authentification, en envoyant une réponse JSON avec un
 * message d'erreur lorsqu'un utilisateur non authentifié tente d'accéder à une
 * ressource protégée.
 * 
 * Dans ce cas, une réponse HTTP avec un statut 401 (Unauthorized) est renvoyée,
 * et un message JSON est envoyé dans le corps de la réponse.
 * 
 * Cette classe est marquée comme un composant Spring afin qu'elle puisse être
 * injectée dans la configuration de sécurité.
 *
 * Cette classe est générée dès la création du projet et ne peut présumer de la
 * présence ou non d'une sécurité. A supprimer si le projet ne contient aucune
 * règle de sécurité concernant l'accès pour ses apis.
 * 
 * @author MINARM
 */
@Component(value = "Demo_dsfr_restAuthEntryPoint")
public class Demo_dsfr_restAuthEntryPoint implements AuthenticationEntryPoint {

	/**
	 * Méthode appelée lorsqu'une tentative d'accès à une ressource protégée échoue
	 * en raison d'une authentification manquante ou incorrecte. Elle renvoie une
	 * réponse HTTP 401 (Unauthorized) avec un message d'erreur dans le corps de la
	 * réponse en format JSON.
	 * 
	 * @param request       La requête HTTP entrante.
	 * @param response      La réponse HTTP qui sera envoyée au client.
	 * @param authException L'exception d'authentification qui a été levée.
	 * @throws IOException      Si une erreur d'entrée/sortie se produit lors de
	 *                          l'écriture de la réponse.
	 * @throws ServletException Si une erreur liée à la servlet se produit.
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

		// Start of user code 56bcd4f8dd30c88089557e348b4165dc

		response.setContentType("application/json;charset=UTF-8");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.getWriter().write("{\"message\": \"Veuillez vous identifier pour accéder à cette ressource.\"}");

		// End of user code
	}
}
