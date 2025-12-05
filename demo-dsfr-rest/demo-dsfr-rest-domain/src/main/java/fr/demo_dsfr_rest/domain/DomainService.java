/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation personnalisée pour marquer les services du domaine dans
 * l'application demo-dsfr-rest.
 * 
 * Cette annotation est utilisée pour indiquer qu'une classe fait partie du
 * domaine métier de l'application, généralement utilisée pour désigner les
 * services ou les composants qui gèrent la logique métier. Elle est disponible
 * à l'exécution grâce à {@link RetentionPolicy#RUNTIME}.
 * 
 * Cette annotation ne comporte actuellement aucun élément spécifique, mais peut
 * être étendue à l'avenir pour ajouter des métadonnées supplémentaires si
 * nécessaire.
 *
 * @author MINARM
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DomainService {
	// RAS.
}
