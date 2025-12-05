/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app.adapters.controllers.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.demo_dsfr_rest.app.entities.demo_dsfr.UserDemoXtoImpl;
import fr.demo_dsfr_rest.app.entities.mappers.demo_dsfr.UserDemoMapper;
import fr.demo_dsfr_rest.app.exceptions.Demo_dsfr_restNotFoundException;
import fr.demo_dsfr_rest.domain.port.features.demo_dsfr.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

// End of user code

/**
 * DESCRIPTION A IMPLEMENTER
 *
 * @Author MINARM
 */

@Controller
@RequestMapping("/v0/users")
@Tag(name = "Users", description = "DESCRIPTION A IMPLEMENTER")
// Start of user code f9aae5fda8d810a29f12d1e61b4ab25f
// End of user code
class UsersControllerImpl {

	/**
	 * Interface service métier.
	 */
	private final UsersService users;

	/**
	 * Constructeur.
	 */
	@Autowired
	public UsersControllerImpl(final UsersService users) {
		this.users = users;
	}

	/**
	 * Création d'un nouvel utilisateur.
	 * 
	 * @param userIn : L'utilisateur à créer.
	 *
	 * @return UserDemoDtoImpl : L'utilisateur avec son identifiant.
	 */
	// Start of user code 525e4ae1466a9b953190d0cf023144e3
	// End of user code
	@PostMapping(produces = "application/json;charset=utf8")
	@Operation(operationId = "setUser", description = "Création d'un nouvel utilisateur.", tags = {
			"Users" }, requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "L'utilisateur à créer.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDemoXtoImpl.class))))
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDemoXtoImpl.class))) })
	public ResponseEntity<UserDemoXtoImpl> setUser(@RequestBody(required = true) UserDemoXtoImpl userIn) {

		ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.status(201);

		// Start of user code e19cc7eb3cefc3a2666bf1e2ea6cd5a2

		// End of user code

		return responseBuilder.body(UserDemoMapper.toXto(this.users.setUser(UserDemoMapper.toDto(userIn))));
	}

	/**
	 * Retourne un utilisateur en fonction de son identifiant.
	 * 
	 * @param id : L'identifiant unique pour l'utilisateur.
	 *
	 * @return Optional<UserDemoDtoImpl> : L'utilisateur retourné en fonction de son
	 *         identifiant.
	 */
	// Start of user code 00c43ead3f53bff1b82d7bb87647edb8
	// End of user code
	@GetMapping(value = "/{id}", produces = "application/json;charset=utf8")
	@Operation(operationId = "getUser", description = "Retourne un utilisateur en fonction de son identifiant.", tags = {
			"Users" }, parameters = {
					@Parameter(name = "id", description = "L'identifiant unique pour l'utilisateur.", required = true, in = ParameterIn.PATH, example = "") })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDemoXtoImpl.class))),
			@ApiResponse(responseCode = "404", description = "Utilisateur non trouvé dans la base de données") })
	public ResponseEntity<UserDemoXtoImpl> getUser(@PathVariable(name = "id", required = true) Long id) {

		ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.status(200);

		// Start of user code a84285b22ab53ae7963da1b038d06e71

		// End of user code

		return this.users.getUser(id).map(o -> responseBuilder.body(UserDemoMapper.toXto(o))).orElseThrow(
				() -> new Demo_dsfr_restNotFoundException(404, "Utilisateur non trouvé dans la base de données"));
	}
}
