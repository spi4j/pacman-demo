/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain.services.requirements;

/**
 * L'interface {@code Requirement} définit les méthodes nécessaires pour gérer
 * les informations relatives à une exigence (requirement). Elle permet de
 * récupérer l'identifiant, le nom, et la version d'implémentation d'une
 * exigence, ainsi que d'en définir la version d'implémentation.
 * 
 * Cette interface définit également des constantes utilisées pour indiquer des
 * statuts d'implémentation.
 * 
 * @author MINARM
 */
public interface Requirement {

	/** Constante indiquant qu'une exigence n'est pas implémentée. */
	String NOTIMPLEMENTED = "notImplemented";

	/** Constante indiquant qu'une exigence n'est pas implémentable. */
	String NOTIMPLEMENTABLE = "notImplementable";

	/** l'identifiant de l'exigence. */
	String getId();

	/** le nom de l'exigence. */
	String getName();

	/** Le No de version implémentée (ex : "0.9"). */
	String getVersionImplem();

	/** Indique qu'une exigence n'est pas implémentée. */
	void setVersionImplem();

	/** Le No de version du modèle (ex : "1.0"). */
	void setVersionImplem(final String versionImplem);

	/** Le No de version du modèle (ex : "1.0"). */
	String getVersionModel();
}
