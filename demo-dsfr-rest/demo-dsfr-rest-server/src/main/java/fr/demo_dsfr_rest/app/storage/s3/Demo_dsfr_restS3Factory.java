/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app.storage.s3;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.io.InputStream;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;

import fr.demo_dsfr_rest.domain.DocumentContent;
import io.minio.BucketExistsArgs;
import io.minio.GetObjectArgs;
import io.minio.GetObjectResponse;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import io.minio.StatObjectArgs;
import io.minio.StatObjectResponse;

// End of user code

/**
 * Configuration Spring responsable de la création et de la gestion des clients
 * S3 pour l'application.
 * <p>
 * Cette classe utilise un **pattern factory** pour créer des instances de
 * {@link MinioClient} à la volée, afin de gérer correctement des **credentials
 * temporaires**. Un client S3 singleton n'étant pas adapté à des credentials
 * qui expirent, la factory permet de reconstruire le client à chaque appel avec
 * des identifiants toujours valides.
 * </p>
 * <p>
 * La méthode {@link #refreshCredentials()} est actuellement une simulation qui
 * renvoie les credentials configurés dans {@link ProjectS3Properties}. En
 * production, cette méthode doit être remplacée par un appel à un service STS
 * ou un fournisseur OIDC (par exemple Keycloak) pour obtenir des credentials
 * temporaires et sécurisés.
 * </p>
 * <p>
 * La classe inclut également un {@link CommandLineRunner} pour initialiser
 * automatiquement le bucket configuré au démarrage de l'application, en
 * vérifiant son existence et en le créant si nécessaire.
 * </p>
 * <p>
 * Cette approche garantit que :
 * <ul>
 * <li>Les credentials sont rafraîchis automatiquement lorsque nécessaire.</li>
 * <li>Le client S3 est toujours créé avec des identifiants valides.</li>
 * <li>La sécurité et la conformité aux bonnes pratiques cloud sont
 * respectées.</li>
 * </ul>
 * </p>
 * 
 * @Author ds
 */
@Configuration
@SuppressWarnings("unused")
public class Demo_dsfr_restS3Factory {

	// Start of user code 736b91750e516139acc13c5eb6564f92
	// End of user code

	/**
	 * Propriétés de configuration pour accéder au stockage S3.
	 * <p>
	 * Cette instance contient l'URL du serveur, le bucket, la clé d'accès et la clé
	 * secrète. Elle est injectée via Spring pour permettre la configuration
	 * dynamique du client S3.
	 * </p>
	 */
	private final Demo_dsfr_restS3Properties props;

	/**
	 * Cache des credentials actuels avec gestion de l'expiration.
	 * <p>
	 * Permet de stocker temporairement les identifiants utilisés pour construire
	 * les clients S3. Les credentials sont rafraîchis automatiquement si expirés.
	 * </p>
	 */
	private volatile CredentialsWrapper currentCredentials;

	/**
	 * Constructeur de la classe.
	 * <p>
	 * Spring injecte les propriétés de configuration S3 afin que la factory puisse
	 * construire des clients S3 configurés correctement.
	 * </p>
	 *
	 * @param props configuration S3 injectée par Spring
	 */
	@Autowired
	public Demo_dsfr_restS3Factory(Demo_dsfr_restS3Properties props) {
		this.props = props;
	}

	/**
	 * Bean exposant la factory de clients S3.
	 * <p>
	 * Permet aux services de récupérer un {@link MinioClient} à la volée via
	 * {@link S3ClientFactory#getClient()}.
	 * </p>
	 *
	 * @return instance de {@link S3ClientFactory} injectable dans Spring
	 */
	@Bean
	@Primary
	public S3ClientFactory s3Client() {
		return new S3ClientFactory();
	}

	/**
	 * Factory interne responsable de la création de clients S3.
	 * <p>
	 * À chaque appel de {@link #getClient()}, un nouveau {@link MinioClient} est
	 * construit avec des credentials valides. Cette approche garantit que les
	 * credentials ne sont jamais expirés lors des opérations.
	 * </p>
	 */
	public class S3ClientFactory implements Demo_dsfr_restS3Service {
		MinioClient getClient() {
			// Start of user code 768b7abee06cfb47784559818f89ac5d

			// CredentialsWrapper creds = getCredentials();

			return MinioClient.builder().endpoint(props.getUrl())
					.credentials(props.getAccessKey(), props.getSecretKey()).build();

			// return MinioClient.builder()
			// .endpoint(props.getUrl())
			// .credentials(creds.accessKey,
			// creds.secretKey).build();

			// End of user code
		}

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
		@Override
		public void upload(final Demo_dsfr_restS3InParams params) throws Exception {

			PutObjectArgs.Builder builder = PutObjectArgs.builder().bucket(params.getBucket()).object(params.getKey())
					.stream(params.getContent(), params.getSize() != null ? params.getSize() : -1, 10 * 1024 * 1024);

			builder.contentType(
					params.getContentType() != null && !params.getContentType().isBlank() ? params.getContentType()
							: "application/octet-stream");

			builder.userMetadata(
					params.getMetadata() != null ? params.getMetadata() : java.util.Collections.emptyMap());

			// Start of user code 76ee3de97a1b8b903319b7c013d8c877
			// End of user code

			getClient().putObject(builder.build());
		}

		/**
		 * Télécharge un objet depuis un stockage compatible S3 et retourne son contenu
		 * ainsi que ses métadonnées.
		 * <p>
		 * Cette méthode utilise le client MinIO pour :
		 * <ul>
		 * <li>récupérer le contenu binaire de l'objet via {@code getObject}</li>
		 * <li>récupérer les métadonnées associées via {@code statObject}</li>
		 * </ul>
		 * </p>
		 * <p>
		 * Les métadonnées sont ensuite converties en {@link HttpHeaders} afin de
		 * faciliter leur propagation dans une réponse HTTP (ex : contrôleur REST). Cela
		 * inclut :
		 * <ul>
		 * <li>les en-têtes standards (Content-Type, Content-Length)</li>
		 * <li>les métadonnées personnalisées (préfixées en {@code x-amz-meta-*})</li>
		 * <li>l'ETag de l'objet si disponible</li>
		 * </ul>
		 * </p>
		 * <p>
		 * Le contenu etant retourné sous forme de {@link InputStream}, il est de la
		 * responsabilité de l'appelant de fermer ce flux après utilisation afin
		 * d'éviter toute fuite de ressources.
		 * </p>
		 *
		 * @param params paramètres d'entrée contenant le nom du bucket et la clé de
		 *               l'objet
		 * @return un {@link DocumentContent} contenant le flux du fichier et les
		 *         en-têtes associés
		 * @throws Exception en cas d'erreur lors de l'accès au stockage S3
		 */
		@Override
		public DocumentContent download(final Demo_dsfr_restS3InParams params) throws Exception {

			GetObjectResponse object = getClient()
					.getObject(GetObjectArgs.builder().bucket(params.getBucket()).object(params.getKey()).build());

			StatObjectResponse stat = getClient()
					.statObject(StatObjectArgs.builder().bucket(params.getBucket()).object(params.getKey()).build());

			Map<String, List<String>> headers = new HashMap<>();
			if (stat.contentType() != null) {
				headers.put("Content-Type", List.of(stat.contentType()));
			}

			headers.put("Content-Length", List.of(String.valueOf(stat.size())));

			// Start of user code 4340fd73e75df7a9d9e45902a59ba3a4
			stat.userMetadata().forEach((key, value) -> headers.put("x-amz-meta-" + key, List.of(value)));
			// End of user code

			if (stat.etag() != null) {
				headers.put("ETag", List.of(stat.etag()));
			}

			// Start of user code fd456406745d816a45cae554c788e754
			// End of user code

			return new DocumentContent(object, headers);
		}

		/**
		 * Supprime un document du stockage S3.
		 * <p>
		 * Le document est identifié par sa clé et supprimé du bucket cible.
		 * </p>
		 *
		 * @param params paramètres de la requête contenant le bucket et la clé
		 * @throws Exception en cas d'erreur lors de la suppression
		 */
		@Override
		public void delete(final Demo_dsfr_restS3InParams params) throws Exception {
			getClient().removeObject(
					RemoveObjectArgs.builder().bucket(params.getBucket()).object(params.getKey()).build());
		}

		// Start of user code cea07ae1e52297e7166b9f364bc454e9
		// End of user code
	}

	/**
	 * Rafraîchit les credentials S3.
	 * <p>
	 * Actuellement, cette méthode renvoie les credentials configurés dans
	 * {@link Demo_dsfr_restS3Properties}. En production, elle doit être remplacée
	 * par un appel à un STS ou un fournisseur OIDC pour obtenir des credentials
	 * temporaires.
	 * </p>
	 *
	 * @return {@link CredentialsWrapper} contenant les nouveaux credentials et leur
	 *         expiration
	 */
	private CredentialsWrapper refreshCredentials() {

		// Remplacer par appel réel (Keycloak / STS / MinIO)
		// Start of user code b5164fbdf0a4526876438e688f5e4130
		String accessKey = this.props.getAccessKey();
		String secretKey = this.props.getSecretKey();
		Instant expiration = Instant.now().plusSeconds(3600);
		// End of user code

		return new CredentialsWrapper(accessKey, secretKey, expiration);
	}

	/**
	 * Retourne les credentials actuels en s'assurant qu'ils ne sont pas expirés.
	 * <p>
	 * Si les credentials sont absents ou expirés, {@link #refreshCredentials()} est
	 * appelé.
	 * </p>
	 *
	 * @return credentials valides encapsulées dans {@link CredentialsWrapper}
	 */
	private synchronized CredentialsWrapper getCredentials() {
		if (this.currentCredentials == null || this.currentCredentials.isExpired()) {
			this.currentCredentials = refreshCredentials();
		}
		return this.currentCredentials;
	}

	/**
	 * Wrapper interne pour gérer les credentials et leur expiration.
	 */
	private static class CredentialsWrapper {
		String accessKey;
		String secretKey;
		Instant expiration;

		CredentialsWrapper(String accessKey, String secretKey, Instant expiration) {
			this.accessKey = accessKey;
			this.secretKey = secretKey;
			this.expiration = expiration;
		}

		boolean isExpired() {
			// Start of user code 0795139a3f084ac64605f8a81bdab571

			return Instant.now().isAfter(expiration.minusSeconds(60));

			// End of user code
		}
	}

	/**
	 * Initialise le bucket S3 au démarrage de l'application.
	 * <p>
	 * Vérifie si le bucket configuré existe, et le crée si nécessaire. Utilise la
	 * factory pour obtenir un client avec des credentials valides.
	 * </p>
	 *
	 * @param factory factory utilisée pour créer le client MinIO
	 * @return {@link CommandLineRunner} exécuté au démarrage de Spring
	 */
	@Bean
	public CommandLineRunner initBucket(S3ClientFactory factory) {
		return args -> {
			MinioClient client = factory.getClient();
			boolean exists = client.bucketExists(BucketExistsArgs.builder().bucket(this.props.getBucket()).build());
			if (!exists) {
				client.makeBucket(MakeBucketArgs.builder().bucket(this.props.getBucket()).build());
			}
		};
	}
}
