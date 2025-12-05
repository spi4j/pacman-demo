/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.sql.DataSource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import jakarta.persistence.EntityManager;

/**
 * Classe abstraite qui sert de base pour les tests utilisant une source de
 * données SQL. Cette classe contient une méthode d'initialisation qui prépare
 * la base de données avec des scripts SQL au début de l'exécution des tests.
 * 
 * La méthode {@link #initSql(DataSource)} initialise la base de données en
 * exécutant les scripts SQL nécessaires, mais ce processus n'est effectué
 * qu'une seule fois grâce à la variable statique {@code initialized}.
 * 
 * @Author MINARM
 */
public abstract class Demo_dsfr_restTestAbs {

	/**
	 * L'instance de {@link EntityManager} utilisée pour effectuer des opérations de
	 * persistance des entités dans la base de données. Elle est protégée afin
	 * d'être accessible dans les sous-classes de {@code Demo_dsfr_restTestAbs}.
	 */
	protected EntityManager entityManager;

	/**
	 * Variable statique indiquant si l'initialisation de la base de données a déjà
	 * été effectuée. Cette variable est utilisée pour éviter de réinitialiser la
	 * base de données plusieurs fois.
	 */
	protected static boolean initialized;

	/**
	 * Initialise la base de données en exécutant les scripts SQL spécifiés, si cela
	 * n'a pas déjà été fait.
	 * 
	 * Cette méthode vérifie si la base de données a déjà été initialisée en
	 * consultant la variable statique {@code initialized}. Si ce n'est pas le cas,
	 * elle charge et exécute les scripts SQL
	 * {@code create_tables_demo-dsfr-rest_h2.sql} et
	 * {@code init_tables_demo-dsfr-rest_h2.sql} via un
	 * {@link ResourceDatabasePopulator}, puis marque l'initialisation comme
	 * effectuée en définissant {@code initialized} sur {@code true}.
	 * 
	 * @param dataSource La source de données sur laquelle exécuter les scripts
	 *                   d'initialisation. La source de données est utilisée pour se
	 *                   connecter à la base de données.
	 */
	protected void initSql(DataSource dataSource) {

		if (!initialized) {

			ClassPathResource scriptCreate = new ClassPathResource("/create_tables_demo-dsfr-rest_h2.sql");
			assertTrue(scriptCreate.exists(), "Le fichier de création des tables n'a pas été trouvé.");

			ClassPathResource scriptInit = new ClassPathResource("/init_tables_demo-dsfr-rest_h2.sql");
			assertTrue(scriptInit.exists(), "Le fichier d'initialisation des tables n'a pas été trouvé.");

			ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
			populator.addScript(scriptCreate);
			populator.addScript(scriptInit);
			populator.execute(dataSource);
			initialized = true;
		}
	}
}
