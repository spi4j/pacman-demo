/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app;

/**
 * Définition des vues de sérialisation JSON utilisées avec
 * {@link com.fasterxml.jackson.annotation.JsonView}.
 * 
 * Ces vues permettent de contrôler dynamiquement les champs d'un objet Java qui
 * doivent être sérialisés en fonction du contexte d'utilisation (exposition
 * publique, détails internes, administration, etc.).
 *
 * Les vues peuvent être utilisées dans les XTOs et les contrôleur REST en
 * annotant les champs avec {@code @JsonView(NomDeLaVue.class)}.
 *
 * Exemple :
 * 
 * <pre>
 * {
 * 	&#64;code
 * 	public class Utilisateur {
 * 		&#64;JsonView(Demo_dsfr_restJsonViews.Public.class)
 * 		private String nom;
 *
 * 		@JsonView(Demo_dsfr_restJsonViews.Internal.class)
 * 		private String email;
 * 	}
 * }
 * </pre>
 *
 * Dans un contrôleur, la vue peut être appliquée de cette manière :
 *
 * <pre>
 * {@code
 * &#64;GetMapping("/utilisateur")
 * @JsonView(Demo_dsfr_restJsonViews.Public.class)
 * public Utilisateur getUtilisateur() {
 * 	return utilisateurService.getUtilisateur();
 * }
 * }
 * </pre>
 * 
 * Exemple de définitions de vues :
 * <ul>
 * <li>{@code Public} : Vue minimale, exposée publiquement.</li>
 * <li>{@code Summary} : Vue de synthèse, inclut {@code Public}.</li>
 * <li>{@code Details} : Vue détaillée, inclut {@code Summary}.</li>
 * <li>{@code Internal} : Données internes à l’application, inclut
 * {@code Details}.</li>
 * <li>{@code Admin} : Vue complète, réservée à un usage administratif.</li>
 * </ul>
 *
 * @author MINARM
 */
public class Demo_dsfr_restJsonViews {

	// Start of user code 59a14a5786fe7a105d780bb1e1e2b21b
	// End of user code
}
