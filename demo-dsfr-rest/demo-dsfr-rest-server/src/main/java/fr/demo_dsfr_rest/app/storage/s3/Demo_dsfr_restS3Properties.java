/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app.storage.s3;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Propriétés de configuration pour la connexion à S3.
 * <p>
 * Cette classe centralise toutes les propriétés nécessaires pour se connecter à
 * un serveur S3 et gérer les buckets. Les valeurs sont injectées depuis le
 * fichier {@code application.properties} via le préfixe {@code S3}.
 * <p>
 * Note : on n'utilise pas @Value sur la classe de configuration au niveau de
 * chaque champ afin d'éviter les problèmes liés aux profils Spring actifs.
 * L'utilisation de @ConfigurationProperties permet de garantir que toutes les
 * propriétés sont correctement résolues quel que soit le profil.
 * </p>
 * <p>
 * Propriétés attendues :
 * </p>
 * <ul>
 * <li>{@code s3.url} : URL du serveur S3 (ex: http://localhost:9000)</li>
 * <li>{@code s3.access-key} : clé d'accès pour l'authentification</li>
 * <li>{@code s3.secret-key} : clé secrète associée</li>
 * <li>{@code s3.bucket} : nom du bucket par défaut</li>
 * </ul>
 *
 * @author ds
 */
@Component
@ConfigurationProperties(prefix = "s3")
public class Demo_dsfr_restS3Properties {

	/** URL du serveur S3 (ex: http://localhost:9000). */
	private String url;

	/** Clé d'accès utilisée pour l'authentification auprès du serveur S3. */
	private String accessKey;

	/** Clé secrète associée à la clé d'accès. */
	private String secretKey;

	/** Nom du bucket utilisé par l'application. */
	private String bucket;

	/**
	 * Retourne l'URL du serveur S3.
	 * 
	 * @return l'URL du serveur S3 (ex: http://localhost:9000)
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * Définit l'URL du serveur S3.
	 * 
	 * @param url l'URL du serveur S3 (ex: http://localhost:9000)
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Retourne la clé d'accès utilisée pour l'authentification auprès du serveur
	 * S3.
	 * 
	 * @return la clé d'accès
	 */
	public String getAccessKey() {
		return this.accessKey;
	}

	/**
	 * Définit la clé d'accès utilisée pour l'authentification auprès du serveur S3.
	 * 
	 * @param accessKey la clé d'accès
	 */
	public void setAccessKey(final String accessKey) {
		this.accessKey = accessKey;
	}

	/**
	 * Retourne la clé secrète associée à la clé d'accès pour S3.
	 * 
	 * @return la clé secrète
	 */
	public String getSecretKey() {
		return this.secretKey;
	}

	/**
	 * Définit la clé secrète associée à la clé d'accès pour S3.
	 * 
	 * @param secretKey la clé secrète
	 */
	public void setSecretKey(final String secretKey) {
		this.secretKey = secretKey;
	}

	/**
	 * Retourne le nom du bucket par défaut utilisé pour stocker les objets.
	 * 
	 * @return le nom du bucket
	 */
	public String getBucket() {
		return this.bucket;
	}

	/**
	 * Définit le nom du bucket par défaut utilisé pour stocker les objets.
	 * 
	 * @param bucket le nom du bucket
	 */
	public void setBucket(String bucket) {
		this.bucket = bucket;
	}
}
