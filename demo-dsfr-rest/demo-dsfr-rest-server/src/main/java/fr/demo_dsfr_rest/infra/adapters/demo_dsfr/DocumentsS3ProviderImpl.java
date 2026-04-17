/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.infra.adapters.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.io.InputStream;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.demo_dsfr_rest.app.storage.s3.Demo_dsfr_restS3Factory;
import fr.demo_dsfr_rest.app.storage.s3.Demo_dsfr_restS3InParams;
import fr.demo_dsfr_rest.app.storage.s3.Demo_dsfr_restS3Properties;
import fr.demo_dsfr_rest.domain.AdapterService;
import fr.demo_dsfr_rest.domain.DocumentContent;
import fr.demo_dsfr_rest.domain.port.adapters.demo_dsfr.DocumentsProvider;
import jakarta.persistence.EntityManager;

// End of user code

/**
 * DESCRIPTION A IMPLEMENTER
 * 
 * @Author MINARM
 */
@AdapterService
// Start of user code 2ecde92477a961c7683adcc7b351d5e6
@SuppressWarnings("unused")
// End of user code
public class DocumentsS3ProviderImpl implements DocumentsProvider {

	/**
	 * Client technique utilisé pour interagir avec le mécanisme de stockage s3
	 * externe.
	 */
	private final Demo_dsfr_restS3Factory.S3ClientFactory clientStorage;

	/** Propriétés pour interagir avec le mécanisme de stockage s3 externe. */
	private final Demo_dsfr_restS3Properties propsStorage;

	/** Gestionnaire de persistance jpa. */
	private final EntityManager entityManager;

	/**
	 * Constructeur permettant l'injection du client technique responsable des
	 * opérations de communication avec le système de stockage externe.
	 *
	 * @param clientStorage client utilisé pour accéder au système de stockage.
	 * @param propsStorage  propriétés utilisées pour accéder au système de
	 *                      stockage.
	 * @param entityManager gestionnaire de persistance jpa.
	 */
	@Autowired
	public DocumentsS3ProviderImpl(final Demo_dsfr_restS3Factory.S3ClientFactory clientStorage,
			final Demo_dsfr_restS3Properties propsStorage, final EntityManager entityManager) {
		this.clientStorage = clientStorage;
		this.propsStorage = propsStorage;
		this.entityManager = entityManager;
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
	@Override
	public String setDocument(final String docName, final InputStream docContent, final String docMetadatas,
			final String docType) {

		// Start of user code 4b80c4e4a2379b2007b9d4f5477fae39

		try {

			Demo_dsfr_restS3InParams requestContent = Demo_dsfr_restS3InParams.builder().withKey(docName)
					.withBucket(propsStorage.getBucket()).withMetadata(docMetadatas).withContentType(docType)
					.withContent(docContent).build();
			clientStorage.upload(requestContent);
			return null;

		} catch (Exception exception) {
			throw new RuntimeException(
					"Erreur dans l'execution de l'opération 'setDocument' : " + exception.getMessage());
		}

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

		try {
			Demo_dsfr_restS3InParams requestContent = Demo_dsfr_restS3InParams.builder().withKey(docName)
					.withBucket(propsStorage.getBucket()).build();
			return Optional.of(clientStorage.download(requestContent));

		} catch (Exception exception) {
			throw new RuntimeException(
					"Erreur dans l'execution de l'opération 'getDocument' : " + exception.getMessage());
		}

		// End of user code
	}

	// Start of user code b341c8578507e5e6d94683d397ef826c
	// End of user code
}
