/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain.port.features.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.io.InputStream;
import java.util.Optional;

import fr.demo_dsfr_rest.domain.DocumentContent;

// End of user code

/**
 * DESCRIPTION A IMPLEMENTER
 * 
 * @Author MINARM
 */
public interface DocumentsService {
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
	public String setDocument(final String docName, final InputStream docContent, final String docMetadatas,
			final String docType);

	/**
	 * DESCRIPTION A IMPLEMENTER.
	 * 
	 * @param docName : DESCRIPTION A IMPLEMENTER.
	 *
	 * @return Optional<DocumentContent> : DESCRIPTION A IMPLEMENTER.
	 */
	public Optional<DocumentContent> getDocument(final String docName);

}
