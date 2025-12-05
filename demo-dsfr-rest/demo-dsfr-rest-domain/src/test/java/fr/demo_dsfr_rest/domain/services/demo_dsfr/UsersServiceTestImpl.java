/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain.services.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import fr.demo_dsfr_rest.domain.a.exceptions.Demo_dsfr_restNotImplementedException;
import fr.demo_dsfr_rest.domain.services.resolvers.demo_dsfr.UsersServiceParamResolver;

// End of user code

/**
 * Classe de test métier pour {@link UsersServiceImpl}.
 * 
 * Cette classe contient des tests unitaires métier pour les méthodes du service
 * {@link UsersServiceImpl}. Les tests sont exécutés avec l'extension
 * {@link UsersServiceParamResolver} pour la gestion des paramètres.
 * 
 * @see UsersServiceImpl
 * @see UsersServiceParamResolver
 */
@ExtendWith(UsersServiceParamResolver.class)
public class UsersServiceTestImpl {

	@Test
	public void setUser(final UsersServiceImpl users) {

		// Start of user code e19cc7eb3cefc3a2666bf1e2ea6cd5a2

		throw new Demo_dsfr_restNotImplementedException(
				"Le test n'a pas été implémenté pour le service : UsersServiceImpl");

		// End of user code
	}

	@Test
	public void getUser(final UsersServiceImpl users) {

		// Start of user code a84285b22ab53ae7963da1b038d06e71

		throw new Demo_dsfr_restNotImplementedException(
				"Le test n'a pas été implémenté pour le service : UsersServiceImpl");

		// End of user code
	}

	// Start of user code a259a71e3ce5ca599cf9b1aa00962b15
	// End of user code
}
