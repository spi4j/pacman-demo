/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app.entities.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

// End of user code

/**
 * Utilisateur de l'application.
 *
 * @Author MINARM
 */
// Start of user code 4ab6864fc58ecd8b598ee10dfe2ac311
// End of user code
@Schema(description = "Utilisateur de l'application.")
public class UserDemoXtoImpl implements Serializable {

	// CONSTANTES

	/**
	 * SerialUid.
	 */
	private static final long serialVersionUID = -1;

	// Start of user code d7bbcbe6a7acc56177d5556a145d9bb1
	// End of user code

	/** Id. */
	@JsonProperty("id")
	@Schema(description = "Identifiant unique de l'entité", accessMode = Schema.AccessMode.READ_ONLY)
	private Long userDemo_id;

	// ATTRIBUTS

	/** Le prénom pour l'utilisateur. */
	// Start of user code ed89387bcd11937a7a92a99a2cbfb5d7
	@JsonProperty("firstName")
	// End of user code
	@Schema(description = "Le prénom pour l'utilisateur.")
	private String firstName;

	/** Le nom de l'utilisateur. */
	// Start of user code ef21925fada6dfb684b5d8ec72114bb1
	@JsonProperty("lastName")
	// End of user code
	@Schema(description = "Le nom de l'utilisateur.")
	private String lastName;

	/** Le téléphone pour l'utilisateur. */
	// Start of user code f7a42fe7211f98ac7a60a285ac3a9e87
	@JsonProperty("phone")
	// End of user code
	@Schema(description = "Le téléphone pour l'utilisateur.")
	private String phone;

	/** Le mail pour l'utilisateur. */
	// Start of user code b83a886a5c437ccd9ac15473fd6f1788
	@JsonProperty("mail")
	// End of user code
	@Schema(description = "Le mail pour l'utilisateur.")
	private String mail;

	/** La ville pour l'utilisateur. */
	// Start of user code 4ed5d2eaed1a1fadcc41ad1d58ed603e
	@JsonProperty("city")
	// End of user code
	@Schema(description = "La ville pour l'utilisateur.")
	private String city;

	/** Le code postal pour l'utilisateur. */
	// Start of user code f5518b3aaaa2622484b3bcf594525d63
	@JsonProperty("zipCode")
	// End of user code
	@Schema(description = "Le code postal pour l'utilisateur.")
	private String zipCode;

	/** L'identifiant pour l'utilistateur. */
	// Start of user code d56b699830e77ba53855679cb1d252da
	@JsonProperty("login")
	// End of user code
	@Schema(description = "L'identifiant pour l'utilistateur.")
	private String login;

	/** L'adresse de l'utilistateur. */
	// Start of user code 884d9804999fc47a3c2694e49ad2536a
	@JsonProperty("address")
	// End of user code
	@Schema(description = "L'adresse de l'utilistateur.")
	private String address;

	/** La civilité de l'utilisateur. */
	// Start of user code f5ec804ca4a783ea231b40cc2931d5b7
	@JsonProperty("civility")
	// End of user code
	@Schema(description = "La civilité de l'utilisateur.")
	private String civility;

	/** La date de naissance pour l'utilisateur. */
	// Start of user code a4c1a22b58f3056c2963045cca4d13b9
	@JsonProperty("dateOfBirth")
	// End of user code
	@Schema(description = "La date de naissance pour l'utilisateur.")
	private LocalDate dateOfBirth;

	/** Le mot de passe pour l'utilisateur. */
	// Start of user code 5f4dcc3b5aa765d61d8327deb882cf99
	@JsonProperty("password")
	// End of user code
	@Schema(description = "Le mot de passe pour l'utilisateur.")
	private String password;

	/** La profession pour l'utilisateur. */
	// Start of user code a2bccc6382f2ee36c038b276087ed6a3
	@JsonProperty("businessActivity")
	// End of user code
	@Schema(description = "La profession pour l'utilisateur.")
	private String businessActivity;

	/** Demande pour un utilisateur. */
	// Start of user code 1b4d3adc60be5b871bdf5cdf093e1491
	@JsonProperty("hasRequests")
	// End of user code
	@Schema(hidden = true) // Non utile pour swagger-ui.
	private List<RequestDemoXtoImpl> hasRequests;

	/**
	 * Constructeur sans paramètre pour la classe : UserDemoXtoImpl.
	 */
	public UserDemoXtoImpl() {
		super();
	}

	/**
	 * Retourne l'identifiant pour le dto.
	 *
	 * @return la valeur de l'identifiant.
	 */
	public Long getUserDemo_id() {
		return this.userDemo_id;
	}

	/**
	 * Affecte l'identifiant pour le dto'.
	 *
	 * @param la valeur de l'identifiant'.
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
	public List<RequestDemoXtoImpl> getHasRequests() {
		// Permet de gérer open api.
		if (null == this.hasRequests) {
			this.hasRequests = new ArrayList<RequestDemoXtoImpl>();
		}
		return this.hasRequests;
	}

	/**
	 * Affectation de l'attribut 'requestDemo'.
	 *
	 * @param requestDemo la valeur à affecter pour l'attribut 'requestDemo'.
	 */
	public void setHasRequests(final List<RequestDemoXtoImpl> hasRequests) {
		this.hasRequests = hasRequests;
	}

	// METHODES
	// Start of user code a9ac5a6cc3cbe84f9c18323af2b9007f
	// End of user code

}
