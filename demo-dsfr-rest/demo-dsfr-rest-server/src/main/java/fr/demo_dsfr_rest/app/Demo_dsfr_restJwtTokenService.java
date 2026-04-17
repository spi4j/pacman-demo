/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

/**
 * Service de génération de jetons JWT pour l'API.
 *
 * Cette classe fournit une méthode pour générer des jetons JWT basés sur un
 * utilisateur authentifié. Le jeton généré est signé avec l'algorithme HS256 et
 * doit avoir une durée de validité limitée.
 *
 * @Author MINARM
 */
@Service
public class Demo_dsfr_restJwtTokenService {

	/**
	 * L'encodeur JWT utilisé pour générer le jeton (fourni par la classe de gestion
	 * de la sécurité {@link Demo_dsfr_restSecurityConfig}).
	 */
	private final JwtEncoder jwtEncoder;

	/**
	 * Constructeur du service de génération de jetons JWT.
	 * 
	 * @param jwtEncoder L'encodeur JWT à utiliser pour signer et générer les
	 *                   jetons.
	 */
	@Autowired
	public Demo_dsfr_restJwtTokenService(JwtEncoder jwtEncoder) {
		this.jwtEncoder = jwtEncoder;
	}

	/**
	 * Génère un jeton JWT pour un utilisateur authentifié.
	 * 
	 * Par défaut, Le jeton généré a un sujet correspondant au nom de l'utilisateur
	 * authentifié, une date de création (émise) égale à l'instant actuel, et une
	 * date d'expiration à définir par le développeur après l'émission. Modifier et
	 * ajouter l'ensemble des informations nécessaires pour l'emission et (par la
	 * suite) la validation du jeton.
	 * 
	 * @param authentication L'objet d'authentification contenant les informations
	 *                       de l'utilisateur.
	 * @return Le jeton JWT encodé sous forme de chaîne de caractères.
	 * @throws RuntimeException Si l'objet d'authentification est null.
	 */
	public String generateToken(Authentication authentication) {

		// Start of user code 9035e409627cb1f549f8f9f418544ee4

		if (null == authentication)
			throw new RuntimeException("Les paramètres d'authentication n'ont pas été trouvés !");

		Instant now = Instant.now();

		/** Création du set de revendications JWT. */
		JwtClaimsSet claims = JwtClaimsSet.builder().id("123").issuer("http://votre-application").issuedAt(now)
				.audience(List.of("votre-audience")).expiresAt(now.plus(30, ChronoUnit.MINUTES))
				.subject(authentication.getName()).build();

		// End of user code

		/** Création des paramètres JWT (incluant les en-têtes). */
		JwtEncoderParameters jwtEncoderParameters = JwtEncoderParameters
				.from(JwsHeader.with(MacAlgorithm.HS256).build(), claims);

		/** Génération et retour du jeton JWT encodé. */
		return this.jwtEncoder.encode(jwtEncoderParameters).getTokenValue();
	}
}
