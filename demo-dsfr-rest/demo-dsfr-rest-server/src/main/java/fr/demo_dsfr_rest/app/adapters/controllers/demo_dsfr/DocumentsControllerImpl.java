/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app.adapters.controllers.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import fr.demo_dsfr_rest.app.exceptions.Demo_dsfr_restNotFoundException;
import fr.demo_dsfr_rest.app.storage.s3.Demo_dsfr_restS3HttpAdapter;
import fr.demo_dsfr_rest.domain.DocumentContent;
import fr.demo_dsfr_rest.domain.port.features.demo_dsfr.DocumentsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

// End of user code

/**
 * DESCRIPTION A IMPLEMENTER
 *
 * @Author MINARM
 */

@Controller
@RequestMapping("/v0/documents")
@Tag(name = "Documents", description = "DESCRIPTION A IMPLEMENTER")
// Start of user code f28128b38efbc6134dc40751ee21fd29
// End of user code
class DocumentsControllerImpl {

	/**
	 * Interface service métier.
	 */
	private final DocumentsService documents;

	/**
	 * Constructeur.
	 */
	@Autowired
	public DocumentsControllerImpl(final DocumentsService documents) {
		this.documents = documents;
	}

	/**
	 * DESCRIPTION A IMPLEMENTER.
	 * 
	 * @param docName      : DESCRIPTION A IMPLEMENTER.
	 * @param docContent   : DESCRIPTION A IMPLEMENTER.
	 * @param docMetadatas : DESCRIPTION A IMPLEMENTER.
	 * @param docType      : DESCRIPTION A IMPLEMENTER.
	 *
	 * @return String : DESCRIPTION A IMPLEMENTER.
	 */
	// Start of user code e3bfb862c4c5bba8ea68da84c8649866
	// End of user code
	@PostMapping(value = "/{name}", produces = "application/json", consumes = "multipart/form-data")
	@Operation(operationId = "setDocument", description = "DESCRIPTION A IMPLEMENTER", tags = {
			"Documents" }, security = {
					@SecurityRequirement(name = "demo-dsfr-oidc_authorizationcode") }, parameters = {
							@Parameter(name = "name", description = "DESCRIPTION A IMPLEMENTER", required = true, in = ParameterIn.PATH, example = ""),
							@Parameter(name = "type", description = "DESCRIPTION A IMPLEMENTER", required = true, in = ParameterIn.QUERY, example = "") })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))) })
	public ResponseEntity<String> setDocument(@PathVariable(name = "name", required = true) String docName,
			@RequestPart(name = "file", required = true) MultipartFile docContent,
			@RequestPart(name = "metadata", required = true) String docMetadatas,
			@RequestParam(name = "type", required = true) String docType) throws IOException {

		ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.status(201);

		// Start of user code 4b80c4e4a2379b2007b9d4f5477fae39

		// End of user code

		return responseBuilder
				.body(this.documents.setDocument(docName, docContent.getInputStream(), docMetadatas, docType));
	}

	/**
	 * DESCRIPTION A IMPLEMENTER.
	 * 
	 * @param docName : DESCRIPTION A IMPLEMENTER.
	 *
	 * @return Optional<DocumentContent> : DESCRIPTION A IMPLEMENTER.
	 */
	// Start of user code b9d0639661860751980980971d4b5def
	// End of user code
	@GetMapping(value = "/{name}", produces = "application/octet-stream")
	@Operation(operationId = "getDocument", description = "DESCRIPTION A IMPLEMENTER", tags = {
			"Documents" }, security = {
					@SecurityRequirement(name = "demo-dsfr-oidc_authorizationcode") }, parameters = {
							@Parameter(name = "name", description = "DESCRIPTION A IMPLEMENTER", required = true, in = ParameterIn.PATH, example = "") })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/octet-stream", schema = @Schema(implementation = DocumentContent.class))),
			@ApiResponse(responseCode = "404", description = "Not Found") })
	public ResponseEntity<InputStreamResource> getDocument(@PathVariable(name = "name", required = true) String docName)
			throws IOException {

		ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.status(200);

		// Start of user code 9566175f1409ed9933b1315cfaf2152c

		// End of user code

		Optional<DocumentContent> value = this.documents.getDocument(docName);
		if (value.isPresent()) {
			return responseBuilder.body(new Demo_dsfr_restS3HttpAdapter(value.get(), responseBuilder, docName));
		} else
			throw new Demo_dsfr_restNotFoundException(404, "Not Found");
	}
}
