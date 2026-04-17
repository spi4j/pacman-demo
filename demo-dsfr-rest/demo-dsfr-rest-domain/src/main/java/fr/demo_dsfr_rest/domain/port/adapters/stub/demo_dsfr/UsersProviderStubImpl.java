/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain.port.adapters.stub.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.util.Optional;

import fr.demo_dsfr_rest.domain.StubService;
import fr.demo_dsfr_rest.domain.a.exceptions.Demo_dsfr_restNotImplementedException;
import fr.demo_dsfr_rest.domain.entities.demo_dsfr.UserDemoDtoImpl;
import fr.demo_dsfr_rest.domain.port.adapters.demo_dsfr.UsersProvider;

// End of user code

/**
 * Implémentation de service stub pour le service Users. Cette classe implémente
 * l'interface {@link UsersProvider} et fournit une version de base des
 * opérations liées à la gestion des personnes. Elle sert de point de départ
 * pour des implémentations réelles ou de tests.
 * <p>
 * Cette classe est un stub, ce qui signifie qu'elle peut contenir des
 * implémentations vides ou des comportements par défaut pour les méthodes de
 * l'interface {@link UsersProvider}.
 *
 * Positionner ici l'ensemble du code nécessaire pour remplacer les appels à la
 * couche de persistance. Cette classe peut être utilisée à la fois dans le
 * cadre des tests métier et dans le cadre des tests d'intégration.
 * 
 * @author MINARM
 */
@StubService
public class UsersProviderStubImpl implements UsersProvider {

	/**
	 * Création d'un nouvel utilisateur.
	 * 
	 * @param userIn : L'utilisateur à créer.
	 *
	 * @return UserDemoDtoImpl : L'utilisateur avec son identifiant.
	 */
	@Override
	public UserDemoDtoImpl setUser(final UserDemoDtoImpl userIn) {

		// Start of user code e19cc7eb3cefc3a2666bf1e2ea6cd5a2

		throw new Demo_dsfr_restNotImplementedException(
				"Le test n'a pas été implémenté pour le stub : UsersServiceImpl");

		// End of user code
	}

	/**
	 * Retourne un utilisateur en fonction de son identifiant.
	 * 
	 * @param id : L'identifiant unique pour l'utilisateur.
	 *
	 * @return Optional<UserDemoDtoImpl> : L'utilisateur retourné en fonction de son
	 *         identifiant.
	 */
	@Override
	public Optional<UserDemoDtoImpl> getUser(final Long id) {

		// Start of user code a84285b22ab53ae7963da1b038d06e71

		throw new Demo_dsfr_restNotImplementedException(
				"Le test n'a pas été implémenté pour le stub : UsersServiceImpl");

		// End of user code
	}

	// Start of user code 1ff03cf55afd4636d997f8ec313a49d4
	// End of user code
}
