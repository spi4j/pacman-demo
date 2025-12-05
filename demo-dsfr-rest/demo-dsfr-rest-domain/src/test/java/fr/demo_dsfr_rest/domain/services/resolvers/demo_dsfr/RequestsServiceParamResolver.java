
/**
* (C) Copyright Ministère des Armées (France)
*
* Apache License 2.0
*/
package fr.demo_dsfr_rest.domain.services.resolvers.demo_dsfr;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import fr.demo_dsfr_rest.domain.port.adapters.demo_dsfr.RequestsProvider;
import fr.demo_dsfr_rest.domain.port.adapters.stub.demo_dsfr.RequestsProviderStubImpl;
import fr.demo_dsfr_rest.domain.services.demo_dsfr.RequestsServiceImpl;

/**
 * Cette classe implémente l'interface {@link ParameterResolver} et sert à
 * résoudre les paramètres dans le contexte d'un test, en fournissant une
 * instance de {@link RequestsServiceImpl}. Elle est utilisée pour injecter une
 * instance de {@link RequestsServiceImpl} dans les tests de manière
 * automatique.
 * 
 * La méthode {@link #supportsParameter(ParameterContext, ExtensionContext)}
 * vérifie si le paramètre peut être résolu par ce résolveur, et la méthode
 * {@link #resolveParameter(ParameterContext, ExtensionContext)} résout le
 * paramètre en créant une instance de {@link RequestsServiceImpl}.
 * <p>
 * Le resolveur permet d'injecter automatiquement le stub (au lieu de la couche
 * de persistance) dans l'instance de {@link RequestsServiceImpl}.
 * <p>
 * Cette classe est typiquement utilisée dans le cadre des tests unitaires avec
 * JUnit 5 et l'extension de test JUnit Jupiter.
 *
 * @Author MINARM
 * 
 * @see ParameterResolver
 * @see RequestsServiceImpl
 * @see RequestsProvider
 * @see RequestsProviderStubImpl
 */
public class RequestsServiceParamResolver implements ParameterResolver {

	/**
	 * Vérifie si ce résolveur prend en charge le paramètre en question.
	 * 
	 * @param parameterContext le contexte du paramètre à vérifier
	 * @param extensionContext le contexte de l'extension du test
	 * @return true si ce résolveur prend en charge le paramètre, sinon false
	 * @throws ParameterResolutionException si une erreur se produit lors de la
	 *                                      résolution du paramètre
	 */
	@Override
	public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		return parameterContext.getParameter().getType() == RequestsServiceImpl.class;
	}

	/**
	 * Résout le paramètre en créant une instance de {@link RequestsServiceImpl}
	 * avec un {@link RequestsProvider}. Dans cet exemple, un stub de
	 * {@link RequestsProvider} est utilisé pour les tests.
	 * 
	 * @param parameterContext le contexte du paramètre à résoudre
	 * @param extensionContext le contexte de l'extension du test
	 * @return une instance de {@link RequestsServiceImpl} prête à être utilisée
	 *         dans le test
	 * @throws ParameterResolutionException si une erreur se produit lors de la
	 *                                      résolution du paramètre
	 */
	@Override
	public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		RequestsProvider provider = new RequestsProviderStubImpl();
		return new RequestsServiceImpl(provider);
	}
}
