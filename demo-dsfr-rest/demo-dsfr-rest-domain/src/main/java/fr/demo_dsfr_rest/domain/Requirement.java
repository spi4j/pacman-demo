/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import fr.demo_dsfr_rest.domain.services.requirements.RequirementsEnum;

/**
 * Annotation marquant une méthode comme nécessitant des conditions ou des
 * prérequis spécifiques.
 * 
 * Cette annotation peut être utilisée pour indiquer qu'une méthode doit
 * respecter certains critères ou conditions spéciales, mais la logique exacte
 * des prérequis doit être définie ailleurs dans le code.
 * 
 * L'annotation est héritée (via {@link Inherited}), ce qui signifie qu'elle
 * sera également présente sur les sous-classes d'une classe qui contient cette
 * annotation.
 * 
 * @author MINARM
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Requirement {

	/**
	 * La liste des exigences.
	 */
	RequirementsEnum[] value();
}
