/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation personnalisée pour marquer les adaptateurs de service dans
 * l'application dans le cadre des tests du domaine et/ou de l'infrastructure'.
 * 
 * Cette annotation est utilisée pour identifier les classes qui servent
 * d'adaptateurs pour les services. Les adaptateurs de service sont généralement
 * utilisés pour intégrer des services externes ou des composants spécifiques à
 * l'architecture de l'application tout en offrant une interface uniforme. Elle
 * est disponible à l'exécution grâce à {@link RetentionPolicy#RUNTIME}.
 * 
 * @author MINARM
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface StubService {
	// RAS.
}
