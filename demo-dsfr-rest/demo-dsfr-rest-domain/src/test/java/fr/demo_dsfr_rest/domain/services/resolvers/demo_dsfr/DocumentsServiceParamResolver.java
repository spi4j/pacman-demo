
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

import fr.demo_dsfr_rest.domain.port.adapters.demo_dsfr.DocumentsProvider;
import fr.demo_dsfr_rest.domain.port.adapters.stub.demo_dsfr.DocumentsProviderStubImpl;
import fr.demo_dsfr_rest.domain.services.demo_dsfr.DocumentsServiceImpl;

/**
 * Cette classe implémente l'interface {@link ParameterResolver} et sert à
 * résoudre les paramètres dans le contexte d'un test, en fournissant une
 * instance de {@link DocumentsServiceImpl}. Elle est utilisée pour injecter une
 * instance de {@link DocumentsServiceImpl} dans les tests de manière
 * automatique.
 * 
 * La méthode {@link #supportsParameter(ParameterContext, ExtensionContext)}
 * vérifie si le paramètre peut être résolu par ce résolveur, et la méthode
 * {@link #resolveParameter(ParameterContext, ExtensionContext)} résout le
 * paramètre en créant une instance de {@link DocumentsServiceImpl}.
 * <p>
 * Le resolveur permet d'injecter automatiquement le stub (au lieu de la couche
 * de persistance) dans l'instance de {@link DocumentsServiceImpl}.
 * <p>
 * Cette classe est typiquement utilisée dans le cadre des tests unitaires avec
 * JUnit 5 et l'extension de test JUnit Jupiter.
 *
 * @Author MINARM
 * 
 * @see ParameterResolver
 * @see DocumentsServiceImpl
 * @see DocumentsProvider
 * @see DocumentsProviderStubImpl
 */
public class DocumentsServiceParamResolver implements ParameterResolver {

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
		return parameterContext.getParameter().getType() == DocumentsServiceImpl.class;
	}

	/**
	 * Résout le paramètre en créant une instance de {@link DocumentsServiceImpl}
	 * avec un {@link DocumentsProvider}. Dans cet exemple, un stub de
	 * {@link DocumentsProvider} est utilisé pour les tests.
	 * 
	 * @param parameterContext le contexte du paramètre à résoudre
	 * @param extensionContext le contexte de l'extension du test
	 * @return une instance de {@link DocumentsServiceImpl} prête à être utilisée
	 *         dans le test
	 * @throws ParameterResolutionException si une erreur se produit lors de la
	 *                                      résolution du paramètre
	 */
	@Override
	public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		DocumentsProvider provider = new DocumentsProviderStubImpl();
		return new DocumentsServiceImpl(provider);
	}
}
