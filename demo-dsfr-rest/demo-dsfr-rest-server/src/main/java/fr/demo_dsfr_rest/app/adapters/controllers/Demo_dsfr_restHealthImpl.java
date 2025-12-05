/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app.adapters.controllers;

import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Implémentation de l'interface {@link HealthIndicator} pour vérifier l'état de
 * santé d'un service. Cette classe est conditionnellement activée en fonction
 * de la présence d'un indicateur de santé nommé {@code demo-dsfr-rest_health}
 * dans le contexte de l'application.
 * 
 * La méthode {@link #health()} crée un état de santé "healthy" par défaut, mais
 * peut être étendue pour fournir une vérification de santé plus complexe si
 * nécessaire.
 * 
 * @see HealthIndicator
 * @see Health
 *
 * @Author MINARM
 */
@Component
@ConditionalOnEnabledHealthIndicator("demo-dsfr-rest_health")
class Demo_dsfr_restHealthImpl implements HealthIndicator {

	/**
	 * Vérifie l'état de santé d'un service et retourne un objet {@link Health}
	 * indiquant l'état.
	 * 
	 * Dans cette implémentation, la méthode retourne simplement un état de santé
	 * "healthy" par défaut, mais peut être enrichie pour effectuer des
	 * vérifications supplémentaires.
	 * </p>
	 *
	 * @return l'état de santé du service, sous la forme d'un objet {@link Health}.
	 */
	@Override
	public Health health() {
		Health.Builder healthBuilder = new Health.Builder();

		// Start of user code 555bf8344ca0caf09b42f55e185526d8

		healthBuilder.withDetail("version", "0.0.0").withDetail("latency", "0ms");

		// End of user code

		return healthBuilder.build();
	}
}
