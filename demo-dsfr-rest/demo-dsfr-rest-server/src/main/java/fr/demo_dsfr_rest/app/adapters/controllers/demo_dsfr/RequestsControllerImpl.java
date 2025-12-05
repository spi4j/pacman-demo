/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app.adapters.controllers.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.demo_dsfr_rest.app.entities.demo_dsfr.RequestDemoXtoImpl;
import fr.demo_dsfr_rest.app.entities.mappers.demo_dsfr.RequestDemoMapper;
import fr.demo_dsfr_rest.app.exceptions.Demo_dsfr_restNotFoundException;
import fr.demo_dsfr_rest.domain.port.features.demo_dsfr.RequestsService;
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
@RequestMapping("/v0/requests")
@Tag(name = "Requests", description = "DESCRIPTION A IMPLEMENTER")
// Start of user code b134a801a1a3888498968fc4ea760cf7
// End of user code
class RequestsControllerImpl {

	/**
	 * Interface service métier.
	 */
	private final RequestsService requests;

	/**
	 * Constructeur.
	 */
	@Autowired
	public RequestsControllerImpl(final RequestsService requests) {
		this.requests = requests;
	}

	/**
	 * Création d'une nouvelle demande.
	 * 
	 * @param requestIn : La requête à créer.
	 *
	 * @return RequestDemoDtoImpl : La requête créée avec son identifiant.
	 */
	// Start of user code 9c1222dee25f7f457e46d87671870afb
	// End of user code
	@PostMapping(produces = "application/json;charset=utf8")
	@Operation(operationId = "setRequest", description = "Création d'une nouvelle demande.", tags = {
			"Requests" }, requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "La requête à créer.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RequestDemoXtoImpl.class))))
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RequestDemoXtoImpl.class))) })
	public ResponseEntity<RequestDemoXtoImpl> setRequest(@RequestBody(required = true) RequestDemoXtoImpl requestIn) {

		ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.status(201);

		// Start of user code aabbc6af6565f068ae807fe17f15c6b4

		// End of user code

		return responseBuilder
				.body(RequestDemoMapper.toXto(this.requests.setRequest(RequestDemoMapper.toDto(requestIn))));
	}

	/**
	 * Retoure une demande en fontion de son identifiant.
	 * 
	 * @param id : L'identifiant unique pour la demande.
	 *
	 * @return Optional<RequestDemoDtoImpl> : La demande retournée en fonction de
	 *         son identifiant.
	 */
	// Start of user code bc2358db358aa53165e8159707d9b2d1
	// End of user code
	@GetMapping(value = "/{id}", produces = "application/json;charset=utf8")
	@Operation(operationId = "getRequest", description = "Retoure une demande en fontion de son identifiant.", tags = {
			"Requests" }, parameters = {
					@Parameter(name = "id", description = "L'identifiant unique pour la demande.", required = true, in = ParameterIn.PATH, example = "") })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RequestDemoXtoImpl.class))),
			@ApiResponse(responseCode = "404", description = "La démarche n'a pas été trouvée dans la base de données") })
	public ResponseEntity<RequestDemoXtoImpl> getRequest(@PathVariable(name = "id", required = true) Long id) {

		ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.status(200);

		// Start of user code 3c8a9c49fb6de085ea17642a062806ad

		// End of user code

		return this.requests.getRequest(id).map(o -> responseBuilder.body(RequestDemoMapper.toXto(o)))
				.orElseThrow(() -> new Demo_dsfr_restNotFoundException(404,
						"La démarche n'a pas été trouvée dans la base de données"));
	}

	/**
	 * Retourne la liste des demandes (tous utilisateurs confondus).
	 * 
	 *
	 * @return List<RequestDemoDtoImpl> : La liste de toutes les demandes pour
	 *         l'ensemble des utilistateurs.
	 */
	// Start of user code b5fd790500d28577a94d0a351c14f88a
	// End of user code
	@GetMapping(produces = "application/json;charset=utf8")
	@Operation(operationId = "getRequests", description = "Retourne la liste des demandes (tous utilisateurs confondus).", tags = {
			"Requests" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RequestDemoXtoImpl.class))),
			@ApiResponse(responseCode = "404", description = "Not Found") })
	public ResponseEntity<List<RequestDemoXtoImpl>> getRequests() {

		ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.status(200);

		// Start of user code b8e42cb8fb7ab242abb556174cbc7311

		// End of user code

		return responseBuilder.body(
				this.requests.getRequests().stream().map(o -> RequestDemoMapper.toXto(o)).collect(Collectors.toList()));
	}

	/**
	 * Retourne l'ensemble des demandes pour un utilisateur.
	 * 
	 * @param userId : L'identifiant de l'utilisateur.
	 *
	 * @return List<RequestDemoDtoImpl> : La liste des demandes pour l'utilisateur.
	 */
	// Start of user code e7fc948d3139ca7583c70c4d9a9ae30a
	// End of user code
	@GetMapping(value = "/user/{id}", produces = "application/json;charset=utf8")
	@Operation(operationId = "getUserRequests", description = "Retourne l'ensemble des demandes pour un utilisateur.", tags = {
			"Requests" }, parameters = {
					@Parameter(name = "id", description = "L'identifiant de l'utilisateur.", required = true, in = ParameterIn.PATH, example = "") })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RequestDemoXtoImpl.class))),
			@ApiResponse(responseCode = "404", description = "Not Found") })
	public ResponseEntity<List<RequestDemoXtoImpl>> getUserRequests(
			@PathVariable(name = "id", required = true) Long userId) {

		ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.status(200);

		// Start of user code e5aef8b6d20ae639ba3ddccb57f65f73

		// End of user code

		return responseBuilder.body(this.requests.getUserRequests(userId).stream().map(o -> RequestDemoMapper.toXto(o))
				.collect(Collectors.toList()));
	}
}
