/**
 * Demande pour un utilisateur.
 *
 * @Author MINARM
 */
export interface RequestDemo {
    /** Id. */
    requestDemo_id: string;
    /** Le type de démarche.. */
    type: string;
    /** La raison de la démarche.. */
    reason: string;
    /** Le numéro de dossier pour la démarche.. */
    identifier: string;
    /** Le statut de la démarche.. */
    status: string;
    /** L'identifiant pour UserDemo. */
    userDemo_id: string;
}
