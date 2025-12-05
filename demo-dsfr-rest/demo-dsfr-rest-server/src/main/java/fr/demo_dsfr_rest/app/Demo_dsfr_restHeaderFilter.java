/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.io.IOException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// End of user code

/**
 * {@code any.nameClassRsHeaderFilterImpl()/]} est un filtre HTTP qui s'exécute
 * une seule fois par requête et ajoute des en-têtes personnalisés à toutes les
 * réponses HTTP sortantes.
 *
 * Ce filtre est annoté avec {@link Order} pour s'assurer qu'il est exécuté (par
 * défaut) avec la plus haute priorité dans la chaîne des filtres Spring, ce qui
 * peut être utile pour que les en-têtes soient toujours présents, même en cas
 * d'échec ultérieur.
 * 
 * Placer le filtre avant les filtres de Spring Security s'il y a besoin de
 * modifier la requête avant l’authentification.
 * 
 * Placer le filtre après si on désire accéder aux informations
 * d’authentification (comme SecurityContextHolder) dans le filtre.
 *
 * Utilise {@link OncePerRequestFilter} pour garantir que le filtre ne s'exécute
 * qu'une seule fois par requête HTTP, évitant ainsi les comportements
 * inattendus lors de redirections ou erreurs.
 *
 * @author MINARM
 * @see OncePerRequestFilter
 */
// Start of user code 61979344b10aa88f68bcf83c7e019cb2
@Order(Ordered.HIGHEST_PRECEDENCE)
// End of user code
public class Demo_dsfr_restHeaderFilter extends OncePerRequestFilter {

	/**
	 * Méthode appelée une fois par requête HTTP pour insérer un en-tête
	 * personnalisé dans la réponse.
	 *
	 * @param request     la requête HTTP entrante
	 * @param response    la réponse HTTP sortante
	 * @param filterChain la chaîne de filtres à poursuivre
	 * @throws ServletException en cas d'erreur de traitement
	 * @throws IOException      en cas d'erreur d'entrée/sortie
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		filterChain.doFilter(request, response);
	}
}
