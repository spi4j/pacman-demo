/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.app.entities.mappers.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.util.stream.Collectors;

import fr.demo_dsfr_rest.app.entities.demo_dsfr.UserDemoXtoImpl;
import fr.demo_dsfr_rest.app.exceptions.Demo_dsfr_restMapperException;
import fr.demo_dsfr_rest.domain.entities.demo_dsfr.UserDemoDtoImpl;

// End of user code
/**
 * La classe {@code UserDemoMapper} est responsable de la conversion entre deux
 * types d'objets : {@link UserDemoXtoImpl} et {@link UserDemoDtoImpl}. Elle
 * fournit des méthodes statiques pour effectuer ces transformations. Si une
 * conversion échoue (en raison d'un paramètre {@code null}), une exception
 * {@link Demo_dsfr_restMapperException} est lancée.
 */
public class UserDemoMapper {

	/**
	 * Convertit un objet {@link UserDemoXtoImpl} en un objet
	 * {@link UserDemoDtoImpl}. Si l'objet {@code UserDemoXtoImpl} est {@code null},
	 * une {@link Demo_dsfr_restMapperException} est lancée.
	 *
	 * @param xto L'objet {@code UserDemoXtoImpl} à convertir.
	 * @return Un objet {@code UserDemoDtoImpl} représentant les mêmes informations
	 *         que {@code UserDemoXtoImpl}.
	 * @throws Demo_dsfr_restMapperException Si l'objet {@code UserDemoXtoImpl} est
	 *                                       {@code null}.
	 */
	public static UserDemoDtoImpl toDto(final UserDemoXtoImpl xto) {

		if (null == xto) {
			return null;
		}

		UserDemoDtoImpl dto = new UserDemoDtoImpl();

		try {

			dto.setUserDemo_id(xto.getUserDemo_id());
			dto.setFirstName(xto.getFirstName());
			dto.setLastName(xto.getLastName());
			dto.setPhone(xto.getPhone());
			dto.setMail(xto.getMail());
			dto.setCity(xto.getCity());
			dto.setZipCode(xto.getZipCode());
			dto.setLogin(xto.getLogin());
			dto.setAddress(xto.getAddress());
			dto.setCivility(xto.getCivility());
			dto.setDateOfBirth(xto.getDateOfBirth());
			dto.setPassword(xto.getPassword());
			dto.setBusinessActivity(xto.getBusinessActivity());
			dto.setHasRequests(
					xto.getHasRequests().stream().map(o -> RequestDemoMapper.toDto(o)).collect(Collectors.toList()));

			// Start of user code da41d007102aaa1dfb25d99a1e97ff60
			// End of user code

		} catch (Exception e) {
			throw new Demo_dsfr_restMapperException("Impossible de mapper la classe : UserDemoDtoImpl");
		}
		return dto;

	}

	/**
	 * Convertit un objet {@link UserDemoDtoImpl} en un objet
	 * {@link UserDemoXtoImpl}. Si l'objet {@code UserDemoDtoImpl} est {@code null},
	 * une {@link Demo_dsfr_restMapperException} est lancée.
	 *
	 * @param dto L'objet {@code UserDemoDtoImpl} à convertir.
	 * @return Un objet {@code UserDemoXtoImpl} représentant les mêmes informations
	 *         que {@code UserDemoDtoImpl}.
	 * @throws Demo_dsfr_restMapperException Si l'objet {@code UserDemoDtoImpl} est
	 *                                       {@code null}.
	 */
	public static UserDemoXtoImpl toXto(final UserDemoDtoImpl dto) {

		if (null == dto) {
			return null;
		}

		UserDemoXtoImpl xto = new UserDemoXtoImpl();

		try {

			xto.setUserDemo_id(dto.getUserDemo_id());
			xto.setFirstName(dto.getFirstName());
			xto.setLastName(dto.getLastName());
			xto.setPhone(dto.getPhone());
			xto.setMail(dto.getMail());
			xto.setCity(dto.getCity());
			xto.setZipCode(dto.getZipCode());
			xto.setLogin(dto.getLogin());
			xto.setAddress(dto.getAddress());
			xto.setCivility(dto.getCivility());
			xto.setDateOfBirth(dto.getDateOfBirth());
			xto.setPassword(dto.getPassword());
			xto.setBusinessActivity(dto.getBusinessActivity());
			xto.setHasRequests(
					dto.getHasRequests().stream().map(o -> RequestDemoMapper.toXto(o)).collect(Collectors.toList()));

			// Start of user code 1caebf8be792f037eeb1fd7c5a7fba93
			// End of user code

		} catch (Exception e) {
			throw new Demo_dsfr_restMapperException("Impossible de mapper la classe : UserDemoXtoImpl");
		}
		return xto;
	}

}
