/**
 * DESCRIPTION A IMPLEMENTER
 *
 * @Author MINARM
 */
import type { AxiosInstance } from "axios";
import type { RequestDemo } from "../models/RequestDemo";
export declare class Requests {
    private apiClient;
    constructor(apiClient?: AxiosInstance);
    /**
     * Création d'une nouvelle demande.
     *
     * @param requestIn : La requête à créer.
     *
     * @return RequestDemo : La requête créée avec son identifiant.
     */
    setRequest(requestIn: RequestDemo): Promise<RequestDemo>;
    /**
     * Retoure une demande en fontion de son identifiant.
     *
     * @param id : L'identifiant unique pour la demande.
     *
     * @return RequestDemo : La demande retournée en fonction de son identifiant.
     */
    getRequest(id: string): Promise<RequestDemo>;
    /**
     * Retourne la liste des demandes (tous utilisateurs confondus).
     *
     *
     * @return RequestDemo[] : La liste de toutes les demandes pour l'ensemble des utilistateurs.
     */
    getRequests(): Promise<RequestDemo[]>;
    /**
     * Retourne l'ensemble des demandes pour un utilisateur.
     *
     * @param userId : L'identifiant de l'utilisateur.
     *
     * @return RequestDemo[] : La liste des demandes pour l'utilisateur.
     */
    getUserRequests(userId: string): Promise<RequestDemo[]>;
}
