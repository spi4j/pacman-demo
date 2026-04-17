/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain.services.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.io.InputStream;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.demo_dsfr_rest.domain.DocumentContent;
import fr.demo_dsfr_rest.domain.DomainService;
import fr.demo_dsfr_rest.domain.port.adapters.demo_dsfr.DocumentsProvider;
import fr.demo_dsfr_rest.domain.port.features.demo_dsfr.DocumentsService;

// End of user code

/**
 * DESCRIPTION A IMPLEMENTER
 *
 * @Author MINARM
 */
// Start of user code 90a9a313fee40f0a3cd3541cb2d64342
@SuppressWarnings("unused")
// End of user code
@DomainService
public class DocumentsServiceImpl implements DocumentsService {

	/** Règles de gestion associées. */
	private final DocumentsRequirementImpl requirements = new DocumentsRequirementImpl();

	/** Le logger pour la classe. */
	private static final Logger LOG = LoggerFactory.getLogger(DocumentsServiceImpl.class);

	/** Interface de persistance. */
	private final DocumentsProvider documentsProvider;

	// Start of user code 7e5ec1a14d2bd475b35527a46807267d
	// End of user code

	/**
	 * Constructeur avec injection de la persistance.
	 */
	public DocumentsServiceImpl(final DocumentsProvider documentsProvider) {
		this.documentsProvider = documentsProvider;
	}

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
	// Start of user code e3bfb862c4c5bba8ea68da84c8649866
	// End of user code
	@Override
	public String setDocument(final String docName, final InputStream docContent, final String docMetadatas,
			final String docType) {

		// Appel des exigences en provenance de la modélisation

		// Start of user code 3da441d2cc2d2188fa8531ceb7f3bddc

		// End of user code

		String docOut = this.documentsProvider.setDocument(docName, docContent, docMetadatas, docType);

		// Start of user code e1b63fd265ae794b9b64b2c3a10000ff
		// End of user code

		return docOut;
	}

	/**
	 * DESCRIPTION A IMPLEMENTER.
	 * 
	 * @param docName : DESCRIPTION A IMPLEMENTER.
	 *
	 * @return Optional<DocumentContent> : DESCRIPTION A IMPLEMENTER.
	 */
	// Start of user code b9d0639661860751980980971d4b5def
	// End of user code
	@Override
	public Optional<DocumentContent> getDocument(final String docName) {

		// Appel des exigences en provenance de la modélisation

		// Start of user code 1c5c8dd8749b71a28b0863dda9c3a92a

		// End of user code

		Optional<DocumentContent> docContent = this.documentsProvider.getDocument(docName);

		// Start of user code 0314b99ceaaf9bfb971636b84451d1b9
		// End of user code

		return docContent;
	}
}
