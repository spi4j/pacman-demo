/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app.adapters.controllers;
// Start of user code 93473a7344419b15c4219cc2b6c64c6f

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.demo_dsfr_rest.app.Demo_dsfr_restJwtTokenService;

// End of user code

/**
 * Contrôleur de l'API pour l'authentification des utilisateurs.
 * 
 * Ce contrôleur gère la demande d'authentification en générant un jeton JWT
 * basé sur l'objet {@link Authentication}. Il expose un point d'accès REST
 * permettant d'obtenir un jeton JWT pour un utilisateur authentifié.
 *
 * @Author MINARM
 */
// Start of user code 61979344b10aa88f68bcf83c7e019cb2
// End of user code
@Controller
@RequestMapping("/token")
public class Demo_dsfr_restJwtTokenControllerImpl {

	/** Décodeur pour le jeton jwt. */
	private final Demo_dsfr_restJwtTokenService jwtService;

	/**
	 * Constructeur du contrôleur d'authentification.
	 * 
	 * @param jwtService Le service qui génère les jetons JWT.
	 */
	public Demo_dsfr_restJwtTokenControllerImpl(Demo_dsfr_restJwtTokenService jwtService) {
		this.jwtService = jwtService;
	}

	/**
	 * Méthode pour effectuer l'authentification et obtenir un jeton JWT. Cette
	 * méthode génère un jeton JWT à partir des informations d'authentification de
	 * l'utilisateur.
	 * 
	 * @param authentication L'objet {@link Authentication} qui contient les
	 *                       informations de l'utilisateur authentifié.
	 * @return Le jeton JWT généré.
	 */
	@PostMapping
	public ResponseEntity<?> authenticate(Authentication authentication) {

		// Start of user code 29748a05013c1ae3bc50822d509ea36e

		String token = this.jwtService.generateToken(authentication);
		return ResponseEntity.status(200).body(token);
		// End of user code
	}
}
