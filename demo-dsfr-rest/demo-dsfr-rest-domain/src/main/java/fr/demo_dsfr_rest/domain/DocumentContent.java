/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Représente la réponse d'une opération de lecture pour un document (format
 * binaire).
 * <p>
 * Cette classe encapsule les données retournées lors de la récupération d'un
 * document depuis un espace de stockage. Elle contient à la fois le contenu
 * binaire de l'objet sous forme de flux ({@link InputStream}) ainsi que les
 * métadonnées associées sous forme de tableau associatif ({@link Map<String,
 * List<String>>}).
 * </p>
 * <p>
 * Les en-têtes peuvent inclure :
 * <ul>
 * <li>des métadonnées standard (ex : Content-Type, Content-Length)</li>
 * <li>des métadonnées personnalisées (ex : x-amz-meta-*)</li>
 * </ul>
 * </p>
 * <p>
 * Cette classe est indépendante de toute implémentation spécifique et peut être
 * utilisée comme modèle générique de réponse dans les services de stockage.
 * </p>
 *
 * @author MINARM
 */
public class DocumentContent {

	/** Contenu binaire de l'objet sous forme de flux. */
	private final InputStream body;

	/** Métadonnées / en-têtes de l'objet, sous forme clé -> liste de valeurs.. */
	private final Map<String, List<String>> headers;

	/**
	 * Construit une instance de {@link DocumentContent}.
	 *
	 * @param body    flux du contenu de l'objet
	 * @param headers map des métadonnées / en-têtes
	 */
	public DocumentContent(final InputStream body, final Map<String, List<String>> headers) {
		this.body = body;
		this.headers = headers != null ? Map.copyOf(headers) : Collections.emptyMap();
	}

	/**
	 * Retourne le contenu binaire de l'objet.
	 *
	 * @return le flux du contenu
	 */
	public InputStream getBody() {
		return this.body;
	}

	/**
	 * Retourne les en-têtes / métadonnées associées.
	 *
	 * @return map clé -> liste de valeurs
	 */
	public Map<String, List<String>> getHeaders() {
		return this.headers;
	}
}
