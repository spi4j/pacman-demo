/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app.storage.s3;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity.BodyBuilder;

import fr.demo_dsfr_rest.domain.DocumentContent;

/**
 * Adapter HTTP permettant de transformer un objet domaine
 * {@link DocumentContent} en ressource exploitable par Spring pour une réponse
 * REST.
 * <p>
 * Cette classe étend {@link InputStreamResource} afin de fournir le flux
 * binaire du document au client HTTP tout en injectant les métadonnées
 * associées dans les en-têtes de la réponse via le {@link BodyBuilder}.
 * </p>
 * <p>
 * Les métadonnées issues du domaine sont converties en en-têtes HTTP standards
 * ou personnalisés (ex : Content-Type, Content-Length, x-amz-meta-*),
 * permettant ainsi de préserver les informations du stockage lors de
 * l'exposition REST.
 * </p>
 * <p>
 * Si l'en-tête "Content-Disposition" n'est pas déjà présent dans le document,
 * il est automatiquement généré pour forcer le téléchargement du fichier, avec
 * gestion des caractères spéciaux et espaces via encodage UTF-8 :
 * </p>
 * <p>
 * Cette classe joue le rôle d'adapter dans une architecture hexagonale :
 * <ul>
 * <li>le domaine reste indépendant de toute notion HTTP</li>
 * <li>cet adapter est responsable de la transformation vers le modèle HTTP
 * Spring</li>
 * </ul>
 * </p>
 *
 * @author ds
 */
public class Demo_dsfr_restS3HttpAdapter extends InputStreamResource {

	/**
	 * Construit une ressource HTTP à partir d'un document domaine, injecte les
	 * métadonnées dans les en-têtes de la réponse et gère automatiquement le
	 * Content-Disposition si nécessaire.
	 *
	 * @param document     objet domaine contenant le flux et les métadonnées
	 * @param response     builder de réponse HTTP Spring utilisé pour définir les
	 *                     headers
	 * @param documentName nom du document utilisé pour le Content-Disposition
	 */
	public Demo_dsfr_restS3HttpAdapter(DocumentContent document, BodyBuilder response, String documentName) {
		super(document.getBody());
		document.getHeaders().forEach((key, values) -> {
			if (values != null) {
				values.forEach(value -> response.header(key, value));
			}
		});

		if (document.getHeaders().get("Content-Disposition") == null) {
			String encodedFileName = URLEncoder.encode(documentName, StandardCharsets.UTF_8).replaceAll("\\+", "%20");
			String contentDisposition = "attachment; filename=\"" + documentName + "\"; filename*=UTF-8''"
					+ encodedFileName;
			response.header("Content-Disposition", contentDisposition);
		}
	}
}
