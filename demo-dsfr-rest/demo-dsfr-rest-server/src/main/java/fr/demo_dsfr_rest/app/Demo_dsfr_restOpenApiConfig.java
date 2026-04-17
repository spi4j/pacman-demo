/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

/**
 * Configuration de la documentation OpenAPI pour ce composant.
 * 
 * Cette classe déclare la configuration générale de l'API pour Springdoc. Elle
 * permet de définir les métadonnées principales de la documentation Swagger,
 * telles que le titre, la version, la description, les informations de contact,
 * les termes de licence et d'utilisation.
 *
 * Aucun code métier ou logique n'est présent ici, uniquement des déclarations
 * d'annotations à but documentaire.
 *
 * @see io.swagger.v3.oas.annotations.OpenAPIDefinition
 * @see io.swagger.v3.oas.annotations.info.Info
 * @see org.springframework.context.annotation.Configuration
 */
@Configuration
@OpenAPIDefinition(info = @Info(title = "demo-dsfr", version = "3.0.3", description = "DESCRIPTION A IMPLEMENTER", termsOfService = "", contact = @Contact(name = "", email = "", url = ""), license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0.html")), security = {
		@SecurityRequirement(name = "demo-dsfr-oidc_authorizationcode") })
@SecurityScheme(name = "demo-dsfr-oidc_authorizationcode", type = SecuritySchemeType.OPENIDCONNECT, openIdConnectUrl = "http://localhost:8085/realms/pacman-demo-realm/.well-known/openid-configuration")
class Demo_dsfr_restOpenApiConfig {
}
