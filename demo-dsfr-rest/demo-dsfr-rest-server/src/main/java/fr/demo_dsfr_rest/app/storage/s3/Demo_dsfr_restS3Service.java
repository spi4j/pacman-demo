/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app.storage.s3;

// Start of user code a6878bf5d858367643a1ef2871d36f47

import fr.demo_dsfr_rest.domain.DocumentContent;

// End of user code

/**
 * Interface définissant les opérations de base pour interagir avec un système
 * de stockage compatible S3.
 * <p>
 * Cette interface abstrait les mécanismes d'accès au stockage (MinIO, AWS S3,
 * etc.) afin de fournir un point d'entrée unique pour la gestion des objets.
 * Elle permet de découpler les services applicatifs de l'implémentation
 * technique sous-jacente.
 * </p>
 * <p>
 * Les opérations s'appuient sur l'objet {@link Demo_dsfr_restS3InParams} qui
 * encapsule l'ensemble des paramètres nécessaires (bucket, clé, contenu,
 * métadonnées, etc.).
 * </p>
 * <p>
 * Les implémentations de cette interface sont responsables de :
 * <ul>
 * <li>La gestion de la connexion au système S3</li>
 * <li>L'utilisation de credentials valides (statiques ou temporaires)</li>
 * <li>La gestion des erreurs techniques liées au stockage</li>
 * </ul>
 * </p>
 * 
 * @Author ds
 */
public interface Demo_dsfr_restS3Service {

	/**
	 * Upload un document dans le stockage S3.
	 * <p>
	 * Le document est identifié par la clé fournie dans les paramètres et est
	 * stocké dans le bucket cible. Les métadonnées et le type MIME peuvent être
	 * fournis en option.
	 * </p>
	 *
	 * @param params paramètres de la requête contenant les informations du document
	 * @throws Exception en cas d'erreur lors de l'upload
	 */
	void upload(final Demo_dsfr_restS3InParams params) throws Exception;

	/**
	 * Télécharge un document depuis le stockage S3.
	 * <p>
	 * Retourne le contenu du document sous forme de flux. L'appelant est
	 * responsable de la fermeture du flux après utilisation.
	 * </p>
	 *
	 * @param params paramètres de la requête contenant les informations du document
	 * @return flux du contenu du document (avec les en-têtes pour les métadonnées)
	 * @throws Exception en cas d'erreur lors du téléchargement
	 */
	DocumentContent download(final Demo_dsfr_restS3InParams params) throws Exception;

	/**
	 * Supprime un document du stockage S3.
	 * <p>
	 * Le document est identifié par sa clé et supprimé du bucket cible.
	 * </p>
	 *
	 * @param params paramètres de la requête contenant les informations du document
	 * @throws Exception en cas d'erreur lors de la suppression
	 */
	void delete(final Demo_dsfr_restS3InParams params) throws Exception;

	// Start of user code ddecebdea58b5f264d27f1f7909bab74
	// End of user code
}
