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
import fr.demo_dsfr_rest.domain.services.resolvers.demo_dsfr.DocumentsServiceParamResolver;

// End of user code

/**
 * Classe de test métier pour {@link DocumentsServiceImpl}.
 * 
 * Cette classe contient des tests unitaires métier pour les méthodes du service
 * {@link DocumentsServiceImpl}. Les tests sont exécutés avec l'extension
 * {@link DocumentsServiceParamResolver} pour la gestion des paramètres.
 * 
 * @see DocumentsServiceImpl
 * @see DocumentsServiceParamResolver
 */
@ExtendWith(DocumentsServiceParamResolver.class)
public class DocumentsServiceTestImpl {

	@Test
	public void setDocument(final DocumentsServiceImpl documents) {

		// Start of user code 4b80c4e4a2379b2007b9d4f5477fae39

		throw new Demo_dsfr_restNotImplementedException(
				"Le test n'a pas été implémenté pour le service : DocumentsServiceImpl");

		// End of user code
	}

	@Test
	public void getDocument(final DocumentsServiceImpl documents) {

		// Start of user code 9566175f1409ed9933b1315cfaf2152c

		throw new Demo_dsfr_restNotImplementedException(
				"Le test n'a pas été implémenté pour le service : DocumentsServiceImpl");

		// End of user code
	}

	// Start of user code 4ce8b2f5b6a54ad44e759d8ff00ee48c
	// End of user code
}
