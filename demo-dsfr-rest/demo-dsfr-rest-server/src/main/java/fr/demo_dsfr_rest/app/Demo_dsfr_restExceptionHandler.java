/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import fr.demo_dsfr_rest.app.exceptions.Demo_dsfr_restNotFoundException;
import fr.demo_dsfr_rest.domain.a.exceptions.Demo_dsfr_restNotImplementedException;

/**
 * Gère les exceptions dans l'application en fournissant des réponses d'erreur
 * personnalisées. Cette classe utilise l'annotation {@link ControllerAdvice}
 * pour intercepter les exceptions globalement et les convertir en réponses HTTP
 * structurées.
 * 
 * Compléter la classe si besoin avec autant de méthodes de gestion des
 * exceptions que nécessaires;
 * 
 * @author MINARM
 */
@ControllerAdvice
public class Demo_dsfr_restExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Gère les exceptions {@link Demo_dsfr_restNotFoundException} et renvoie une
	 * réponse d'erreur avec le code de statut approprié.
	 * 
	 * @param ex      L'exception {@link Demo_dsfr_restNotFoundException} capturée.
	 * @param request La requête HTTP associée à l'exception.
	 * @return Une réponse HTTP avec un corps contenant le message d'erreur et le
	 *         code de statut approprié.
	 */
	@ExceptionHandler(value = { Demo_dsfr_restNotFoundException.class })
	protected ResponseEntity<Object> handleDataNotFound(Demo_dsfr_restNotFoundException ex, WebRequest request) {
		Demo_dsfr_restErrorBodyResponse bodyResponse = new Demo_dsfr_restErrorBodyResponse(ex.getStatusCode(),
				ex.getMessage());

		// Start of user code 15e77aaa7162c500ac0b8d3f5cec5484
		// End of user code

		return handleExceptionInternal(ex, bodyResponse, new HttpHeaders(),
				Demo_dsfr_restHttpStatusResolver.resolve(bodyResponse.getStatusCode()), request);
	}

	/**
	 * Gère les exceptions {@link Demo_dsfr_restNotImplementedException} et renvoie
	 * une réponse d'erreur avec un code de statut 501.
	 * 
	 * @param ex      L'exception {@link Demo_dsfr_restNotImplementedException}
	 *                capturée.
	 * @param request La requête HTTP associée à l'exception.
	 * @return Une réponse HTTP avec un corps contenant le message d'erreur et le
	 *         code de statut 501.
	 */
	@ExceptionHandler(value = { Demo_dsfr_restNotImplementedException.class })
	protected ResponseEntity<Object> handleNotImplemented(Demo_dsfr_restNotImplementedException ex,
			WebRequest request) {
		Demo_dsfr_restErrorBodyResponse bodyResponse = new Demo_dsfr_restErrorBodyResponse(
				HttpStatus.NOT_IMPLEMENTED.value(), ex.getMessage());

		// Start of user code 57631699b32d606f8e39b099884ff187
		// End of user code

		return handleExceptionInternal(ex, bodyResponse, new HttpHeaders(), HttpStatus.NOT_IMPLEMENTED, request);
	}

	/**
	 * Gère les exceptions génériques {@link Exception} et renvoie une réponse
	 * d'erreur avec un code de statut 500.
	 * 
	 * @param ex      L'exception générique capturée.
	 * @param request La requête HTTP associée à l'exception.
	 * @return Une réponse HTTP avec un corps contenant un message générique
	 *         d'erreur et un code de statut 500.
	 */
	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleServerError(Exception ex, WebRequest request) {
		Demo_dsfr_restErrorBodyResponse bodyResponse = new Demo_dsfr_restErrorBodyResponse(
				HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());

		// Start of user code d7b194e2e3f6018a116de0d2363e8153
		// End of user code

		return handleExceptionInternal(ex, bodyResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	// Start of user code dadf5413c9696ff2509d90c2b7356ffd
	// End of user code
}
