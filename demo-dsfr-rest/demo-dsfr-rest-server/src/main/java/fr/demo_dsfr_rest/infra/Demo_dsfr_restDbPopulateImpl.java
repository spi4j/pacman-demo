/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.infra;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import fr.demo_dsfr_rest.infra.entities.demo_dsfr.RequestDemoEntityImpl;
import fr.demo_dsfr_rest.infra.entities.demo_dsfr.UserDemoEntityImpl;
import fr.demo_dsfr_rest.infra.entities.repositories.demo_dsfr.RequestDemoRepository;
import fr.demo_dsfr_rest.infra.entities.repositories.demo_dsfr.UserDemoRepository;
import jakarta.annotation.PostConstruct;
import net.datafaker.Faker;

// End of user code

/**
 * Composant chargé d'initialiser la base de données de l'application avec des
 * données de démonstration.
 * <p>
 * Cette implémentation utilise <strong>DataFaker</strong> pour générer des
 * données textuelles aléatoires, et les API <strong>java.time</strong> pour
 * produire des dates, heures et timestamps modernes et non dépréciés.
 * </p>
 *
 * Au démarrage de l'application, la méthode {@link #populate()} est
 * automatiquement exécutée grâce à l'annotation {@code @PostConstruct}, ce qui
 * entraîne la création des entités persistées en base via leurs repositories
 * Spring Data.
 * </p>
 *
 * Les méthodes utilitaires {@code randomLocalDate()}, {@code randomTimeStamp()}
 * et {@code randomTime()} permettent de générer des valeurs temporelles
 * cohérentes et compatibles avec Java 17+ et DataFaker 2.5+.
 * </p>
 *
 * @author MINARM
 */
@Component
@SuppressWarnings("unused")
public class Demo_dsfr_restDbPopulateImpl {

	/** Gestionnaires de persistance disponibles. */
	final UserDemoRepository userDemoRepository;
	final RequestDemoRepository requestDemoRepository;

	/** Gestionnaires de données aléatoires. */
	private Faker faker = new Faker(Locale.FRANCE);

	/** Valeurs par défaut pour les dates et heures. */
	private LocalDate randomLocalDate(int daysAhead) {
		return LocalDate.now().plusDays(faker.number().numberBetween(0, daysAhead));
	}

	/** Valeurs par défaut pour les dates et heures. */
	private Timestamp randomTimeStamp(int daysAhead) {
		return Timestamp.from(Instant.now().plus(faker.number().numberBetween(0, daysAhead), ChronoUnit.DAYS));
	}

	/** Valeurs par défaut pour les dates et heures. */
	private Time randomTime() {
		return Time.valueOf(LocalTime.of(faker.number().numberBetween(0, 23), faker.number().numberBetween(0, 59),
				faker.number().numberBetween(0, 59)));
	}

	// Start of user code ccd1066343c95877b75b79d47c36bebe
	/** Nombre de lignes à créer dans la base de données. */
	private final int nbEntities = 10;
	private final int nbRelations = 5;
	// End of user code

	@Value("${spring.populate.faker.enabled:true}")
	private boolean populateEnabled;

	@Autowired
	/** Constructeur avec injection des persistance disponibles. */
	public Demo_dsfr_restDbPopulateImpl(final UserDemoRepository userDemoRepository,
			final RequestDemoRepository requestDemoRepository) {
		this.userDemoRepository = userDemoRepository;
		this.requestDemoRepository = requestDemoRepository;
	}

	/**
	 * DESCRIPTION A IMPLEMENTER.
	 */
	UserDemoEntityImpl userDemoPopulateWithFakeData(final RequestDemoEntityImpl requestDemo) {
		UserDemoEntityImpl userDemo = new UserDemoEntityImpl();

		// Start of user code cf79eb27d3d3d239876f4f42e3789192

		String fn = faker.name().firstName();
		String ln = faker.name().lastName();
		userDemo.setFirstName(fn);
		userDemo.setLastName(ln);
		userDemo.setPhone(faker.phoneNumber().phoneNumber());
		userDemo.setMail(faker.internet().emailAddress(fn + "." + ln).toLowerCase());
		userDemo.setCity(faker.address().city());
		userDemo.setZipCode(faker.address().zipCode());
		userDemo.setLogin((fn + "." + ln).toLowerCase());
		userDemo.setAddress(faker.address().streetAddress());
		userDemo.setCivility(faker.name().prefix());
		userDemo.setDateOfBirth(randomLocalDate(80));
		userDemo.setPassword(faker.credentials().password());
		userDemo.setBusinessActivity(faker.company().industry());

		// End of user code

		return userDemo;
	}

	/**
	 * DESCRIPTION A IMPLEMENTER.
	 */
	RequestDemoEntityImpl requestDemoPopulateWithFakeData(final UserDemoEntityImpl userDemo) {
		RequestDemoEntityImpl requestDemo = new RequestDemoEntityImpl();

		// Start of user code 2b3517d11bcb1172ba92edf896aa109a

		requestDemo.setType(faker.options().option("PA", "CN", "CG", "PC", "CE", "TF"));
		requestDemo.setReason(faker.options().option("RE", "PD", "PE", "VO", "CA"));
		requestDemo.setIdentifier(faker.code().asin());
		requestDemo.setStatus(faker.options().option("DE", "ET", "AC", "TE", "RE", "AN"));
		requestDemo.setUserDemo_hasRequests(userDemo);

		// End of user code

		return requestDemo;
	}

	/**
	 * Initialise automatiquement la base de données avec un ensemble de données de
	 * démonstration à chaque démarrage de l'application.
	 * <p>
	 * Cette méthode est exécutée automatiquement grâce à l'annotation
	 * {@link PostConstruct}. Elle crée {@code nbEntities} entités dans la base.
	 */
	@PostConstruct
	public void populate() {
		if (!populateEnabled)
			return;

		IntStream.range(0, nbEntities).forEach(i -> {
			// Start of user code f1399e649e5189a1b6ddbc2110423d17
			UserDemoEntityImpl userDemo = userDemoRepository.save(userDemoPopulateWithFakeData(null));
			// End of user code

			// Start of user code eff84bdefaf9cdc14ddeb8376157f2a4
			IntStream.range(0, nbRelations).forEach(i2 -> {
				RequestDemoEntityImpl requestDemo = requestDemoRepository
						.save(requestDemoPopulateWithFakeData(userDemo));
			});
			// End of user code

			// Start of user code e679aa86ca55b033b965ba72500dbe92
			// End of user code
		});
	}
}
