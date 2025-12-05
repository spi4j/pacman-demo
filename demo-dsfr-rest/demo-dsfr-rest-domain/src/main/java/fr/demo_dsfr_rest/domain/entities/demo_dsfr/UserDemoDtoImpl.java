/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain.entities.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fr.demo_dsfr_rest.domain.ValidatorUtils;
import fr.demo_dsfr_rest.domain.a.exceptions.Demo_dsfr_restValidationException;
import fr.demo_dsfr_rest.domain.entities.Demo_dsfr_restEntityAbs;

// End of user code
/**
 * Utilisateur de l'application.
 *
 * @Author MINARM
 */
public class UserDemoDtoImpl extends Demo_dsfr_restEntityAbs {
	// CONSTANTES

	// Start of user code d7bbcbe6a7acc56177d5556a145d9bb1
	// End of user code

	// ATTRIBUTS

	/** Id. */
	private Long userDemo_id;

	/** Le prénom pour l'utilisateur. */
	private String firstName;

	/** Le nom de l'utilisateur. */
	private String lastName;

	/** Le téléphone pour l'utilisateur. */
	private String phone;

	/** Le mail pour l'utilisateur. */
	private String mail;

	/** La ville pour l'utilisateur. */
	private String city;

	/** Le code postal pour l'utilisateur. */
	private String zipCode;

	/** L'identifiant pour l'utilistateur. */
	private String login;

	/** L'adresse de l'utilistateur. */
	private String address;

	/** La civilité de l'utilisateur. */
	private String civility;

	/** La date de naissance pour l'utilisateur. */
	private LocalDate dateOfBirth;

	/** Le mot de passe pour l'utilisateur. */
	private String password;

	/** La profession pour l'utilisateur. */
	private String businessActivity;

	/** Demande pour un utilisateur. */
	private List<RequestDemoDtoImpl> hasRequests;

	/**
	 * Retourne l'identifiant pour le dto.
	 *
	 * @return la valeur de l'identifiant.
	 */
	public Long getUserDemo_id() {
		return this.userDemo_id;
	}

	/**
	 * Affecte l'identifiant pour le dto.
	 *
	 * @param la valeur de l'identifiant.
	 */
	public void setUserDemo_id(final Long userDemo_id) {
		this.userDemo_id = userDemo_id;
	}

	/**
	 * Retourne l'attribut 'firstName'.
	 *
	 * @return la valeur de l'attribut 'firstName'.
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Affectation de l'attribut 'firstName'.
	 *
	 * @param firstName la valeur à affecter pour l'attribut 'firstName'.
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Retourne l'attribut 'lastName'.
	 *
	 * @return la valeur de l'attribut 'lastName'.
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Affectation de l'attribut 'lastName'.
	 *
	 * @param lastName la valeur à affecter pour l'attribut 'lastName'.
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Retourne l'attribut 'phone'.
	 *
	 * @return la valeur de l'attribut 'phone'.
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * Affectation de l'attribut 'phone'.
	 *
	 * @param phone la valeur à affecter pour l'attribut 'phone'.
	 */
	public void setPhone(final String phone) {
		this.phone = phone;
	}

	/**
	 * Retourne l'attribut 'mail'.
	 *
	 * @return la valeur de l'attribut 'mail'.
	 */
	public String getMail() {
		return this.mail;
	}

	/**
	 * Affectation de l'attribut 'mail'.
	 *
	 * @param mail la valeur à affecter pour l'attribut 'mail'.
	 */
	public void setMail(final String mail) {
		this.mail = mail;
	}

	/**
	 * Retourne l'attribut 'city'.
	 *
	 * @return la valeur de l'attribut 'city'.
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * Affectation de l'attribut 'city'.
	 *
	 * @param city la valeur à affecter pour l'attribut 'city'.
	 */
	public void setCity(final String city) {
		this.city = city;
	}

	/**
	 * Retourne l'attribut 'zipCode'.
	 *
	 * @return la valeur de l'attribut 'zipCode'.
	 */
	public String getZipCode() {
		return this.zipCode;
	}

	/**
	 * Affectation de l'attribut 'zipCode'.
	 *
	 * @param zipCode la valeur à affecter pour l'attribut 'zipCode'.
	 */
	public void setZipCode(final String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Retourne l'attribut 'login'.
	 *
	 * @return la valeur de l'attribut 'login'.
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * Affectation de l'attribut 'login'.
	 *
	 * @param login la valeur à affecter pour l'attribut 'login'.
	 */
	public void setLogin(final String login) {
		this.login = login;
	}

	/**
	 * Retourne l'attribut 'address'.
	 *
	 * @return la valeur de l'attribut 'address'.
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * Affectation de l'attribut 'address'.
	 *
	 * @param address la valeur à affecter pour l'attribut 'address'.
	 */
	public void setAddress(final String address) {
		this.address = address;
	}

	/**
	 * Retourne l'attribut 'civility'.
	 *
	 * @return la valeur de l'attribut 'civility'.
	 */
	public String getCivility() {
		return this.civility;
	}

	/**
	 * Affectation de l'attribut 'civility'.
	 *
	 * @param civility la valeur à affecter pour l'attribut 'civility'.
	 */
	public void setCivility(final String civility) {
		this.civility = civility;
	}

	/**
	 * Retourne l'attribut 'dateOfBirth'.
	 *
	 * @return la valeur de l'attribut 'dateOfBirth'.
	 */
	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}

	/**
	 * Affectation de l'attribut 'dateOfBirth'.
	 *
	 * @param dateOfBirth la valeur à affecter pour l'attribut 'dateOfBirth'.
	 */
	public void setDateOfBirth(final LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Retourne l'attribut 'password'.
	 *
	 * @return la valeur de l'attribut 'password'.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Affectation de l'attribut 'password'.
	 *
	 * @param password la valeur à affecter pour l'attribut 'password'.
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * Retourne l'attribut 'businessActivity'.
	 *
	 * @return la valeur de l'attribut 'businessActivity'.
	 */
	public String getBusinessActivity() {
		return this.businessActivity;
	}

	/**
	 * Affectation de l'attribut 'businessActivity'.
	 *
	 * @param businessActivity la valeur à affecter pour l'attribut
	 *                         'businessActivity'.
	 */
	public void setBusinessActivity(final String businessActivity) {
		this.businessActivity = businessActivity;
	}

	/**
	 * Retourne l'attribut 'requestDemo'.
	 *
	 * @return la valeur de l'attribut 'requestDemo'.
	 */
	public List<RequestDemoDtoImpl> getHasRequests() {
		// Permet de gérer open api.
		if (null == this.hasRequests) {
			this.hasRequests = new ArrayList<RequestDemoDtoImpl>();
		}
		return this.hasRequests;
	}

	/**
	 * Affectation de l'attribut 'requestDemo'.
	 *
	 * @param requestDemo la valeur à affecter pour l'attribut 'requestDemo'.
	 */
	public void setHasRequests(final List<RequestDemoDtoImpl> hasRequests) {
		this.hasRequests = hasRequests;
	}

	// METHODES
	// Start of user code a9ac5a6cc3cbe84f9c18323af2b9007f
	// End of user code

	/**
	 * Valide les informations de l'objet en vérifiant la présence des valeurs
	 * obligatoires, les contraintes de taille et un pattern spécifique pour
	 * certains champs.
	 * 
	 * Cette méthode utilise des utilitaires de validation pour vérifier que
	 * certains des champs modélisés ne sont pas vides, respectent une taille
	 * minimale et/ou maximale, ainsi qu'un format spécifique grâce à une expression
	 * régulière qui est fournie (toujours par le biais de la modélisation).
	 * 
	 * Si des erreurs de validation sont trouvées, une exception
	 * {@link Demo_dsfr_restValidationException} est lancée avec les messages
	 * d'erreur correspondants.
	 * 
	 * @throws Demo_dsfr_restValidationException si des erreurs de validation sont
	 *                                           trouvées. L'exception contient une
	 *                                           liste des erreurs sous forme de
	 *                                           tableau de chaînes.
	 */
	public UserDemoDtoImpl validate() throws Demo_dsfr_restValidationException {

		List<String> errors = new ArrayList<>();
		ValidatorUtils.checkMandatory("firstName", firstName, errors);
		ValidatorUtils.checkMandatory("lastName", lastName, errors);
		ValidatorUtils.checkMandatory("login", login, errors);
		ValidatorUtils.checkMandatory("civility", civility, errors);
		ValidatorUtils.checkMandatory("password", password, errors);

		if (!errors.isEmpty()) {
			throw new Demo_dsfr_restValidationException(this, errors.toArray(new String[errors.size()]));
		}
		return this;
	}

	/**
	 * Compare cet objet avec l'objet spécifié pour déterminer s'ils sont égaux.
	 *
	 * Cette méthode vérifie si l'instance actuelle et l'objet fourni sont la même
	 * instance, puis compare les attributs des deux objets pour en vérifier
	 * l'égalité. La comparaison est effectuée à l'aide de la méthode
	 * {@link Objects#equals(Object, Object)} afin de gérer correctement les valeurs
	 * de type 'null'.
	 *
	 * @param obj L'objet à comparer avec l'instance actuelle. Celui-ci doit être
	 *            une instance de {@link UserDemoDtoImpl} pour une comparaison
	 *            valide.
	 *
	 * @return {@code true} si l'objet spécifié est égal à l'instance actuelle,
	 *         {@code false} sinon.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserDemoDtoImpl)) {
			return false;
		}

		UserDemoDtoImpl UserDemo = (UserDemoDtoImpl) obj;
		return Objects.equals(this.userDemo_id, userDemo_id)

				&& Objects.equals(this.firstName, UserDemo.firstName)
				&& Objects.equals(this.lastName, UserDemo.lastName) && Objects.equals(this.phone, UserDemo.phone)
				&& Objects.equals(this.mail, UserDemo.mail) && Objects.equals(this.city, UserDemo.city)
				&& Objects.equals(this.zipCode, UserDemo.zipCode) && Objects.equals(this.login, UserDemo.login)
				&& Objects.equals(this.address, UserDemo.address) && Objects.equals(this.civility, UserDemo.civility)
				&& Objects.equals(this.dateOfBirth, UserDemo.dateOfBirth)
				&& Objects.equals(this.password, UserDemo.password)
				&& Objects.equals(this.businessActivity, UserDemo.businessActivity)

		;
	}

	/**
	 * Retourne un code de hachage pour l'objet actuel. On ne prend pas en compte
	 * les objets référencés.
	 *
	 * Elle utilise la méthode {@link Objects#hash(Object...)} pour générer un code
	 * de hachage combiné basé sur ces attributs. Ce code de hachage est utilisé
	 * dans des structures de données telles que les tables de hachage.
	 *
	 * @return Le code de hachage pour l'objet actuel.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.userDemo_id, this.firstName, this.lastName, this.phone, this.mail, this.city,
				this.zipCode, this.login, this.address, this.civility, this.dateOfBirth, this.password,
				this.businessActivity);
	}

	/**
	 * Retourne une représentation sous forme de chaîne de caractères de l'objet
	 * actuel. On ne prend pas en compte les objets référencés.
	 *
	 * Cette méthode est utile pour obtenir une représentation lisible de l'objet,
	 * notamment pour les opérations de débogage ou de journalisation.
	 */
	@Override
	public String toString() {
		return "UserDemoDtoImpl { userDemo_id = " + this.userDemo_id

				+ "firstName = " + this.firstName + "lastName = " + this.lastName + "phone = " + this.phone + "mail = "
				+ this.mail + "city = " + this.city + "zipCode = " + this.zipCode + "login = " + this.login
				+ "address = " + this.address + "civility = " + this.civility + "dateOfBirth = " + this.dateOfBirth
				+ "password = " + this.password + "businessActivity = " + this.businessActivity + "}";
	}

}
