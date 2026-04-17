/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain.port.adapters.stub.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.io.InputStream;
import java.util.Optional;

import fr.demo_dsfr_rest.domain.DocumentContent;
import fr.demo_dsfr_rest.domain.StubService;
import fr.demo_dsfr_rest.domain.a.exceptions.Demo_dsfr_restNotImplementedException;
import fr.demo_dsfr_rest.domain.port.adapters.demo_dsfr.DocumentsProvider;

// End of user code

/**
 * Implémentation de service stub pour le service Documents. Cette classe
 * implémente l'interface {@link DocumentsProvider} et fournit une version de
 * base des opérations liées à la gestion des personnes. Elle sert de point de
 * départ pour des implémentations réelles ou de tests.
 * <p>
 * Cette classe est un stub, ce qui signifie qu'elle peut contenir des
 * implémentations vides ou des comportements par défaut pour les méthodes de
 * l'interface {@link DocumentsProvider}.
 *
 * Positionner ici l'ensemble du code nécessaire pour remplacer les appels à la
 * couche de persistance. Cette classe peut être utilisée à la fois dans le
 * cadre des tests métier et dans le cadre des tests d'intégration.
 * 
 * @author MINARM
 */
@StubService
public class DocumentsProviderStubImpl implements DocumentsProvider {

	/**
	 * DESCRIPTION A IMPLEMENTER.
	 * 
	 * @param docName      : DESCRIPTION A IMPLEMENTER.
	 * @param docContent   : DESCRIPTION A IMPLEMENTER.
	 * @param docMetadatas : DESCRIPTION A IMPLEMENTER.
	 * @param docType      : DESCRIPTION A IMPLEMENTER.
	 *
	 * @return String : DESCRIPTION A IMPLEMENTER.
	 */
	@Override
	public String setDocument(final String docName, final InputStream docContent, final String docMetadatas,
			final String docType) {

		// Start of user code 4b80c4e4a2379b2007b9d4f5477fae39

		throw new Demo_dsfr_restNotImplementedException(
				"Le test n'a pas été implémenté pour le stub : DocumentsServiceImpl");

		// End of user code
	}

	/**
	 * DESCRIPTION A IMPLEMENTER.
	 * 
	 * @param docName : DESCRIPTION A IMPLEMENTER.
	 *
	 * @return Optional<DocumentContent> : DESCRIPTION A IMPLEMENTER.
	 */
	@Override
	public Optional<DocumentContent> getDocument(final String docName) {

		// Start of user code 9566175f1409ed9933b1315cfaf2152c

		throw new Demo_dsfr_restNotImplementedException(
				"Le test n'a pas été implémenté pour le stub : DocumentsServiceImpl");

		// End of user code
	}

	// Start of user code 1ff03cf55afd4636d997f8ec313a49d4
	// End of user code
}
