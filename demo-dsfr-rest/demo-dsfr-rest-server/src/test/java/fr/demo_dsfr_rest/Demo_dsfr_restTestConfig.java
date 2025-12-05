/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import fr.demo_dsfr_rest.domain.AdapterService;
import fr.demo_dsfr_rest.domain.DomainService;
import fr.demo_dsfr_rest.domain.StubService;
import fr.demo_dsfr_rest.domain.port.adapters.stub.demo_dsfr.RequestsProviderStubImpl;
import fr.demo_dsfr_rest.domain.port.adapters.stub.demo_dsfr.UsersProviderStubImpl;

/**
 * Configuration des composants spécifiques pour les tests d'intégration.
 * 
 * Cette configuration permet de scanner des classes spécifiques et d'inclure ou
 * exclure certains beans dans le contexte Spring utilisé pour les tests.
 * 
 * Les classes annotées avec {@link TestConfiguration} sont exclues par défaut
 * de l'analyse des composants. Les services annotés avec {@link DomainService}
 * et {@link StubService} sont inclus.
 * 
 * Pour couper l'acces à la couche de persistance sur un service en particulier
 * et passer sur le bouchon, modifier le nom de la (ou des) classe(s) de service
 * au niveau de l'exclusion 'excludeFilters. Par défaut tous les bouchons (Stub)
 * sont exclus.
 * 
 * Remplacer le nom du bouchon par le nom de la classe JPA.
 *
 * @author MINARM
 */
@TestConfiguration
@ComponentScan(basePackages = { "fr.demo_dsfr_rest" }, includeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = { DomainService.class, StubService.class,
				AdapterService.class }) }, excludeFilters = {
						@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
								UsersProviderStubImpl.class, RequestsProviderStubImpl.class }) })
public class Demo_dsfr_restTestConfig {
}
