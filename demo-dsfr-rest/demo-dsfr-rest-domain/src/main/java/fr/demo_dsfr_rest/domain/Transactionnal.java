/**
 * (C) Copyright Ministère des Armées (France)
 *
 * Apache License 2.0
 */
package fr.demo_dsfr_rest.domain;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation personnalisée marquant les méthodes ou les classes qui doivent
 * être exécutées dans un contexte transactionnel. Cette annotation peut être
 * utilisée pour indiquer qu'une méthode ou une classe doit être traitée dans
 * une transaction.
 * 
 * Elle peut être utilisée en combinaison avec un gestionnaire de transactions,
 * tel qu'un aspect, pour appliquer la logique transactionnelle.
 * 
 * @see org.springframework.transaction.annotation.Transactional
 * @see Demo_dsfr_restTransactionalExecutor
 *
 * @author MINARM
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Transactionnal {
	// RAS
}
