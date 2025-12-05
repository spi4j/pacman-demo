/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.infra.entities.mappers.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import java.util.stream.Collectors;

import fr.demo_dsfr_rest.app.exceptions.Demo_dsfr_restMapperException;
import fr.demo_dsfr_rest.domain.entities.demo_dsfr.UserDemoDtoImpl;
import fr.demo_dsfr_rest.infra.entities.demo_dsfr.UserDemoEntityImpl;

// End of user code

/**
 * Classe utilitaire pour la conversion entre les objets {@link UserDemoDtoImpl}
 * et {@link UserDemoEntityImpl}. Cette classe fournit deux méthodes statiques
 * pour convertir un objet DTO en une entité et inversement. Elle permet de
 * mapper un objet {@link UserDemoDtoImpl} vers un {@link UserDemoEntityImpl} et
 * vice-versa.
 */
public class UserDemoMapper {
	/**
	 * Cette méthode permet de convertir un objet {@link UserDemoDtoImpl} en une
	 * entité {@link UserDemoEntityImpl}.
	 * 
	 * @param dto L'objet de type {@link UserDemoDtoImpl} à convertir. Il ne doit
	 *            pas être nul.
	 * @return Un objet de type {@link UserDemoEntityImpl} représentant l'entité
	 *         correspondante.
	 * 
	 * @throws Demo_dsfr_restMapperException Si le paramètre dto est nul, une
	 *                                       exception est lancée pour signaler
	 *                                       l'impossibilité de réaliser la
	 *                                       conversion.
	 */
	public static UserDemoEntityImpl toEntity(final UserDemoDtoImpl dto) {
		if (null == dto) {
			return null;
		}

		UserDemoEntityImpl entity = new UserDemoEntityImpl();

		try {
			entity.setUserDemo_id(dto.getUserDemo_id());
			entity.setFirstName(dto.getFirstName());
			entity.setLastName(dto.getLastName());
			entity.setPhone(dto.getPhone());
			entity.setMail(dto.getMail());
			entity.setCity(dto.getCity());
			entity.setZipCode(dto.getZipCode());
			entity.setLogin(dto.getLogin());
			entity.setAddress(dto.getAddress());
			entity.setCivility(dto.getCivility());
			entity.setDateOfBirth(dto.getDateOfBirth());
			entity.setPassword(dto.getPassword());
			entity.setBusinessActivity(dto.getBusinessActivity());
			entity.setHasRequests(
					dto.getHasRequests().stream().map(o -> RequestDemoMapper.toEntity(o)).collect(Collectors.toList()));

			// Start of user code 3fd9d27cb35db4d9b23df95a62c25559
			// End of user code

		} catch (Exception e) {
			throw new Demo_dsfr_restMapperException("Impossible de mapper la classe : UserDemoEntityImpl");
		}

		return entity;
	}

	/**
	 * Cette méthode permet de convertir un objet {@link UserDemoEntityImpl} en un
	 * {@link UserDemoDtoImpl}.
	 * 
	 * @param entity L'objet de type {@link UserDemoEntityImpl} à convertir. Il ne
	 *               doit pas être nul.
	 * @return Un objet de type {@link UserDemoDtoImpl} représentant le DTO
	 *         correspondant.
	 * 
	 * @throws Demo_dsfr_restMapperException Si le paramètre entity est nul, une
	 *                                       exception est lancée pour signaler
	 *                                       l'impossibilité de réaliser la
	 *                                       conversion.
	 */
	public static UserDemoDtoImpl toDto(final UserDemoEntityImpl entity) {
		if (null == entity) {
			return null;
		}
		UserDemoDtoImpl dto = new UserDemoDtoImpl();

		try {

			dto.setUserDemo_id(entity.getUserDemo_id());
			dto.setFirstName(entity.getFirstName());
			dto.setLastName(entity.getLastName());
			dto.setPhone(entity.getPhone());
			dto.setMail(entity.getMail());
			dto.setCity(entity.getCity());
			dto.setZipCode(entity.getZipCode());
			dto.setLogin(entity.getLogin());
			dto.setAddress(entity.getAddress());
			dto.setCivility(entity.getCivility());
			dto.setDateOfBirth(entity.getDateOfBirth());
			dto.setPassword(entity.getPassword());
			dto.setBusinessActivity(entity.getBusinessActivity());
			dto.setHasRequests(
					entity.getHasRequests().stream().map(o -> RequestDemoMapper.toDto(o)).collect(Collectors.toList()));

			// Start of user code cbdbe849941d16ed04ed6a524ab101b9
			// End of user code

		} catch (Exception e) {
			throw new Demo_dsfr_restMapperException("Impossible de mapper la classe : UserDemoDtoImpl");
		}
		return dto;

	}
}
