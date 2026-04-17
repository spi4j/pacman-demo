/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app.storage.s3;

import java.io.InputStream;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Représente une requête de manipulation d'un document dans un stockage S3.
 * <p>
 * Cette classe encapsule l'ensemble des paramètres nécessaires pour effectuer
 * une opération sur un objet S3 (upload, stockage, etc.), tels que le bucket
 * cible, la clé de l'objet, le contenu binaire, le type MIME et les métadonnées
 * associées.
 * </p>
 * <p>
 * Elle utilise le pattern {@link Builder} afin de faciliter la construction
 * d'instances de manière fluide et sécurisée, tout en permettant de gérer des
 * paramètres optionnels.
 * </p>
 * <p>
 * Le champ {@code key} est obligatoire pour garantir l'identification unique de
 * l'objet dans le stockage S3.
 * </p>
 * <p>
 * Cette classe est indépendante de toute implémentation S3 (MinIO, AWS, etc.)
 * et peut être utilisée comme modèle générique dans les services de stockage.
 * </p>
 * 
 * @Author ds
 */
public class Demo_dsfr_restS3InParams {

	// Start of user code 736b91750e516139acc13c5eb6564f92
	// End of user code

	/**
	 * Nom du bucket cible dans lequel l'objet sera stocké.
	 */
	private String bucket;

	/**
	 * Clé de l'objet (identifiant unique dans le bucket).
	 */
	private String key;

	/**
	 * Contenu binaire du document sous forme de flux.
	 */
	private InputStream content;

	/**
	 * Type MIME du document (ex : application/pdf, image/png).
	 */
	private String contentType;

	/**
	 * Métadonnées associées à l'objet S3.
	 */
	private Map<String, String> metadata;

	/**
	 * Taille du contenu en octets (optionnelle).
	 */
	private Long size;

	/**
	 * Constructeur privé pour forcer l'utilisation du {@link Builder}.
	 */
	private Demo_dsfr_restS3InParams() {
		// RAS.
	}

	// Start of user code a9ac5a6cc3cbe84f9c18323af2b9007f
	// End of user code

	/**
	 * Retourne le nom du bucket cible.
	 *
	 * @return le bucket
	 */
	public String getBucket() {
		return this.bucket;
	}

	/**
	 * Retourne la clé de l'objet.
	 *
	 * @return la clé
	 */
	public String getKey() {
		return this.key;
	}

	/**
	 * Retourne le contenu du document.
	 *
	 * @return le flux du contenu
	 */
	public InputStream getContent() {
		return this.content;
	}

	/**
	 * Retourne le type MIME du document.
	 *
	 * @return le content type
	 */
	public String getContentType() {
		return this.contentType;
	}

	/**
	 * Retourne les métadonnées associées.
	 *
	 * @return la map de métadonnées
	 */
	public Map<String, String> getMetadata() {
		return this.metadata;
	}

	/**
	 * Retourne la taille du document.
	 *
	 * @return la taille en octets
	 */
	public Long getSize() {
		return this.size;
	}

	/**
	 * Crée un builder permettant de construire une instance de
	 * {@link Demo_dsfr_restS3InParams}.
	 *
	 * @return une instance de {@link Builder}
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder permettant de construire une instance de
	 * {@link Demo_dsfr_restS3InParams}.
	 * <p>
	 * Permet une initialisation fluide et lisible des paramètres, tout en validant
	 * les champs obligatoires lors de l'appel à {@link #build()}.
	 * </p>
	 */
	public static class Builder {

		/**
		 * Instance en cours de construction.
		 */
		private final Demo_dsfr_restS3InParams request;

		/**
		 * Constructeur privé du builder.
		 */
		private Builder() {
			this.request = new Demo_dsfr_restS3InParams();
		}

		/**
		 * Définit le bucket cible.
		 *
		 * @param bucket nom du bucket
		 * @return le builder courant
		 */
		public Builder withBucket(final String request) {
			this.request.bucket = request;
			return this;
		}

		/**
		 * Définit la clé de l'objet.
		 *
		 * @param key clé unique de l'objet
		 * @return le builder courant
		 */
		public Builder withKey(final String key) {
			this.request.key = key;
			return this;
		}

		/**
		 * Définit le contenu du document.
		 *
		 * @param content flux du contenu
		 * @return le builder courant
		 */
		public Builder withContent(final InputStream content) {
			this.request.content = content;
			return this;
		}

		/**
		 * Définit le type MIME du document.
		 *
		 * @param contentType type MIME
		 * @return le builder courant
		 */
		public Builder withContentType(final String contentType) {
			this.request.contentType = contentType;
			return this;
		}

		/**
		 * Définit les métadonnées associées à l'objet.
		 *
		 * @param metadata map de métadonnées
		 * @return le builder courant
		 * @throws JsonProcessingException
		 * @throws JsonMappingException
		 */
		public Builder withMetadata(final String metadata) throws JsonMappingException, JsonProcessingException {
			Map<String, String> metaDataMap = new ObjectMapper().readValue(
					(metadata == null || metadata.isBlank()) ? "{}" : metadata,
					new TypeReference<Map<String, String>>() {
					});
			this.request.metadata = metaDataMap;
			return this;
		}

		/**
		 * Définit la taille du document.
		 *
		 * @param size taille en octets
		 * @return le builder courant
		 */
		public Builder withSize(final Long size) {
			this.request.size = size;
			return this;
		}

		// Start of user code 5be07f6ee612e2d5227c83cb93a1dd01
		// End of user code

		/**
		 * Construit une instance de {@link Demo_dsfr_restS3InParams}.
		 * <p>
		 * Vérifie la présence du champ obligatoire {@code key} avant de retourner
		 * l'objet.
		 * </p>
		 *
		 * @return une instance valide de {@link Demo_dsfr_restS3InParams}
		 * @throws IllegalStateException si un champ obligatoire est manquant
		 */
		public Demo_dsfr_restS3InParams build() {
			if (this.request.key == null || this.request.key.isEmpty()) {
				throw new IllegalStateException("La clé est obligatoire pour manipuler un document S3");
			}

			// Start of user code 4db18e60fe1869fc283cdb1b5f57427a
			// End of user code

			return this.request;
		}
	}
}
