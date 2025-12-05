/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.infra.entities.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.time.LocalDate;
import java.util.List;

import fr.demo_dsfr_rest.infra.Demo_dsfr_restEntityAbs;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

// End of user code
/**
 * DESCRIPTION A IMPLEMENTER
 *
 * @Author MINARM
 */
@Entity
@Table(name = "USERDEMO")
@SequenceGenerator(name = "USERDEMO_SEQUENCE", sequenceName = "USERDEMO_SEQ", allocationSize = 1)
public class UserDemoEntityImpl extends Demo_dsfr_restEntityAbs {

	// CONSTANTES ET ATTRIBUTS
	// Start of user code d7bbcbe6a7acc56177d5556a145d9bb1

	// End of user code

	/** Id. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERDEMO_SEQUENCE")
	@Column(name = "USERDEMO_ID", nullable = false)
	private Long userDemo_id;

	/** Le prénom pour l'utilisateur. */
	// Start of user code ed89387bcd11937a7a92a99a2cbfb5d7
	// End of user code
	@Column(name = "FIRSTNAME", nullable = false)
	private String firstName;

	/** Le nom de l'utilisateur. */
	// Start of user code ef21925fada6dfb684b5d8ec72114bb1
	// End of user code
	@Column(name = "LASTNAME", nullable = false)
	private String lastName;

	/** Le téléphone pour l'utilisateur. */
	// Start of user code f7a42fe7211f98ac7a60a285ac3a9e87
	// End of user code
	@Column(name = "PHONE", nullable = true)
	private String phone;

	/** Le mail pour l'utilisateur. */
	// Start of user code b83a886a5c437ccd9ac15473fd6f1788
	// End of user code
	@Column(name = "MAIL", nullable = true)
	private String mail;

	/** La ville pour l'utilisateur. */
	// Start of user code 4ed5d2eaed1a1fadcc41ad1d58ed603e
	// End of user code
	@Column(name = "CITY", nullable = true)
	private String city;

	/** Le code postal pour l'utilisateur. */
	// Start of user code f5518b3aaaa2622484b3bcf594525d63
	// End of user code
	@Column(name = "ZIPCODE", nullable = true)
	private String zipCode;

	/** L'identifiant pour l'utilistateur. */
	// Start of user code d56b699830e77ba53855679cb1d252da
	// End of user code
	@Column(name = "LOGIN", nullable = false)
	private String login;

	/** L'adresse de l'utilistateur. */
	// Start of user code 884d9804999fc47a3c2694e49ad2536a
	// End of user code
	@Column(name = "ADDRESS", nullable = true)
	private String address;

	/** La civilité de l'utilisateur. */
	// Start of user code f5ec804ca4a783ea231b40cc2931d5b7
	// End of user code
	@Column(name = "CIVILITY", nullable = false)
	private String civility;

	/** La date de naissance pour l'utilisateur. */
	// Start of user code a4c1a22b58f3056c2963045cca4d13b9
	// End of user code
	@Column(name = "DATEOFBIRTH", nullable = true, columnDefinition = "DATE")
	private LocalDate dateOfBirth;

	/** Le mot de passe pour l'utilisateur. */
	// Start of user code 5f4dcc3b5aa765d61d8327deb882cf99
	// End of user code
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	/** La profession pour l'utilisateur. */
	// Start of user code a2bccc6382f2ee36c038b276087ed6a3
	// End of user code
	@Column(name = "BUSINESSACTIVITY", nullable = true)
	private String businessActivity;

	/** DESCRIPTION A IMPLEMENTER. */
	// Start of user code 977bf967e883705fa1152b1ff0cd8491
	// End of user code
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "userDemo_hasRequests")
	private List<RequestDemoEntityImpl> hasRequests;

	/**
	 * Constructeur sans paramètre pour la classe 'UserDemoEntityImpl'.
	 */
	public UserDemoEntityImpl() {
		super();

		// Start of user code 3b7d1f8961bdb6f58435db52ce9a364e
		// End of user code
	}

	/**
	 * Constructeur avec paramètres pour la classe 'UserDemoEntityImpl'.
	 */
	public UserDemoEntityImpl(final String firstName, final String lastName, final String phone, final String mail,
			final String city, final String zipCode, final String login, final String address, final String civility,
			final LocalDate dateOfBirth, final String password, final String businessActivity,
			final List<RequestDemoEntityImpl> hasRequests) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.mail = mail;
		this.city = city;
		this.zipCode = zipCode;
		this.login = login;
		this.address = address;
		this.civility = civility;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
		this.businessActivity = businessActivity;
		this.hasRequests = hasRequests;

		// Start of user code 695d4e162d26e2f89672f82655c8080a
		// End of user code
	}

	/**
	 * Retourne l'identifiant pour l'entité'.
	 *
	 * @return la valeur de l'identifiant'.
	 */
	public Long getUserDemo_id() {
		return this.userDemo_id;
	}

	/**
	 * Affecte l'identifiant pour l'entité'.
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
	 * Retourne l'attribut 'hasRequests'.
	 *
	 * @return la valeur de l'attribut 'hasRequests'.
	 */
	public List<RequestDemoEntityImpl> getHasRequests() {
		return this.hasRequests;
	}

	/**
	 * Affectation de l'attribut 'hasRequests'.
	 *
	 * @param hasRequests la valeur à affecter pour l'attribut 'hasRequests'.
	 */
	public void setHasRequests(final List<RequestDemoEntityImpl> hasRequests) {
		this.hasRequests = hasRequests;
	}

	// METHODES
	// Start of user code a9ac5a6cc3cbe84f9c18323af2b9007f
	// End of user code

}
