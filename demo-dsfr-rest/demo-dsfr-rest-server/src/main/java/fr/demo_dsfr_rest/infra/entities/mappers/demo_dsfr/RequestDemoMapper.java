/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.infra.entities.mappers.demo_dsfr;
// Start of user code a6878bf5d858367643a1ef2871d36f47

import fr.demo_dsfr_rest.app.exceptions.Demo_dsfr_restMapperException;
import fr.demo_dsfr_rest.domain.entities.demo_dsfr.RequestDemoDtoImpl;
import fr.demo_dsfr_rest.domain.entities.demo_dsfr.UserDemoDtoImpl;
import fr.demo_dsfr_rest.infra.entities.demo_dsfr.RequestDemoEntityImpl;

// End of user code

/**
 * Classe utilitaire pour la conversion entre les objets
 * {@link RequestDemoDtoImpl} et {@link RequestDemoEntityImpl}. Cette classe
 * fournit deux méthodes statiques pour convertir un objet DTO en une entité et
 * inversement. Elle permet de mapper un objet {@link RequestDemoDtoImpl} vers
 * un {@link RequestDemoEntityImpl} et vice-versa.
 */
public class RequestDemoMapper {
	/**
	 * Cette méthode permet de convertir un objet {@link RequestDemoDtoImpl} en une
	 * entité {@link RequestDemoEntityImpl}.
	 * 
	 * @param dto L'objet de type {@link RequestDemoDtoImpl} à convertir. Il ne doit
	 *            pas être nul.
	 * @return Un objet de type {@link RequestDemoEntityImpl} représentant l'entité
	 *         correspondante.
	 * 
	 * @throws Demo_dsfr_restMapperException Si le paramètre dto est nul, une
	 *                                       exception est lancée pour signaler
	 *                                       l'impossibilité de réaliser la
	 *                                       conversion.
	 */
	public static RequestDemoEntityImpl toEntity(final RequestDemoDtoImpl dto) {
		if (null == dto) {
			return null;
		}

		RequestDemoEntityImpl entity = new RequestDemoEntityImpl();

		try {
			entity.setRequestDemo_id(dto.getRequestDemo_id());
			entity.setType(dto.getType());
			entity.setReason(dto.getReason());
			entity.setIdentifier(dto.getIdentifier());
			entity.setStatus(dto.getStatus());

			// Référence inverse jpa.
			UserDemoDtoImpl userDemo = new UserDemoDtoImpl();
			userDemo.setUserDemo_id(dto.getUserDemo_id());
			entity.setUserDemo_hasRequests(UserDemoMapper.toEntity(userDemo));

			// Start of user code e98c2cfbc68f055a1f3d17768cf5dea9
			// End of user code

		} catch (Exception e) {
			throw new Demo_dsfr_restMapperException("Impossible de mapper la classe : RequestDemoEntityImpl");
		}

		return entity;
	}

	/**
	 * Cette méthode permet de convertir un objet {@link RequestDemoEntityImpl} en
	 * un {@link RequestDemoDtoImpl}.
	 * 
	 * @param entity L'objet de type {@link RequestDemoEntityImpl} à convertir. Il
	 *               ne doit pas être nul.
	 * @return Un objet de type {@link RequestDemoDtoImpl} représentant le DTO
	 *         correspondant.
	 * 
	 * @throws Demo_dsfr_restMapperException Si le paramètre entity est nul, une
	 *                                       exception est lancée pour signaler
	 *                                       l'impossibilité de réaliser la
	 *                                       conversion.
	 */
	public static RequestDemoDtoImpl toDto(final RequestDemoEntityImpl entity) {
		if (null == entity) {
			return null;
		}
		RequestDemoDtoImpl dto = new RequestDemoDtoImpl();

		try {

			dto.setRequestDemo_id(entity.getRequestDemo_id());
			dto.setType(entity.getType());
			dto.setReason(entity.getReason());
			dto.setIdentifier(entity.getIdentifier());
			dto.setStatus(entity.getStatus());
			dto.setUserDemo_id(entity.getUserDemo_hasRequests().getUserDemo_id());

			// Start of user code 786e2a9f40e389075fa8c56ce5416e23
			// End of user code

		} catch (Exception e) {
			throw new Demo_dsfr_restMapperException("Impossible de mapper la classe : RequestDemoDtoImpl");
		}
		return dto;

	}
}
