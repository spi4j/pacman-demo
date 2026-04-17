/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app.entities.mappers.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import fr.demo_dsfr_rest.app.entities.demo_dsfr.RequestDemoXtoImpl;
import fr.demo_dsfr_rest.app.exceptions.Demo_dsfr_restMapperException;
import fr.demo_dsfr_rest.domain.entities.demo_dsfr.RequestDemoDtoImpl;

// End of user code

/**
 * La classe {@code RequestDemoMapper} est responsable de la conversion entre
 * deux types d'objets : {@link RequestDemoXtoImpl} et
 * {@link RequestDemoDtoImpl}. Elle fournit des méthodes statiques pour
 * effectuer ces transformations. Si une conversion échoue (en raison d'un
 * paramètre {@code null}), une exception {@link Demo_dsfr_restMapperException}
 * est lancée.
 */
public class RequestDemoMapper {

	/**
	 * Convertit un objet {@link RequestDemoXtoImpl} en un objet
	 * {@link RequestDemoDtoImpl}. Si l'objet {@code RequestDemoXtoImpl} est
	 * {@code null}, une {@link Demo_dsfr_restMapperException} est lancée.
	 *
	 * @param xto L'objet {@code RequestDemoXtoImpl} à convertir.
	 * @return Un objet {@code RequestDemoDtoImpl} représentant les mêmes
	 *         informations que {@code RequestDemoXtoImpl}.
	 * @throws Demo_dsfr_restMapperException Si l'objet {@code RequestDemoXtoImpl}
	 *                                       est {@code null}.
	 */
	public static RequestDemoDtoImpl toDto(final RequestDemoXtoImpl xto) {

		if (null == xto) {
			return null;
		}

		RequestDemoDtoImpl dto = new RequestDemoDtoImpl();

		try {

			dto.setRequestDemo_id(xto.getRequestDemo_id());
			dto.setType(xto.getType());
			dto.setReason(xto.getReason());
			dto.setIdentifier(xto.getIdentifier());
			dto.setStatus(xto.getStatus());
			dto.setUserDemo_id(xto.getUserDemo_id());

			// Start of user code feeccc940a7cc1562cafe146803022d4
			// End of user code

		} catch (Exception e) {
			throw new Demo_dsfr_restMapperException("Impossible de mapper la classe : RequestDemoDtoImpl");
		}
		return dto;

	}

	/**
	 * Convertit un objet {@link RequestDemoDtoImpl} en un objet
	 * {@link RequestDemoXtoImpl}. Si l'objet {@code RequestDemoDtoImpl} est
	 * {@code null}, une {@link Demo_dsfr_restMapperException} est lancée.
	 *
	 * @param dto L'objet {@code RequestDemoDtoImpl} à convertir.
	 * @return Un objet {@code RequestDemoXtoImpl} représentant les mêmes
	 *         informations que {@code RequestDemoDtoImpl}.
	 * @throws Demo_dsfr_restMapperException Si l'objet {@code RequestDemoDtoImpl}
	 *                                       est {@code null}.
	 */
	public static RequestDemoXtoImpl toXto(final RequestDemoDtoImpl dto) {

		if (null == dto) {
			return null;
		}

		RequestDemoXtoImpl xto = new RequestDemoXtoImpl();

		try {

			xto.setRequestDemo_id(dto.getRequestDemo_id());
			xto.setType(dto.getType());
			xto.setReason(dto.getReason());
			xto.setIdentifier(dto.getIdentifier());
			xto.setStatus(dto.getStatus());
			xto.setUserDemo_id(dto.getUserDemo_id());

			// Start of user code ee9705d36a9e897a0b47ed5304a294b7
			// End of user code

		} catch (Exception e) {
			throw new Demo_dsfr_restMapperException("Impossible de mapper la classe : RequestDemoXtoImpl");
		}
		return xto;
	}

}
