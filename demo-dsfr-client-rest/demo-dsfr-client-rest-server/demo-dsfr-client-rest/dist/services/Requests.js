// fallback global (IMPORTANT)
import { apiClient as defaultApiClient } from "../api/apiClient";
export class Requests {
    // Permet la surchage du client.
    constructor(apiClient = defaultApiClient) {
        this.apiClient = apiClient;
    }
    /**
     * Création d'une nouvelle demande.
     *
     * @param requestIn : La requête à créer.
     *
     * @return RequestDemo : La requête créée avec son identifiant.
     */
    async setRequest(requestIn) {
        const response = await this.apiClient.post(`/v0/requests`, requestIn);
        return response.data;
    }
    /**
     * Retoure une demande en fontion de son identifiant.
     *
     * @param id : L'identifiant unique pour la demande.
     *
     * @return RequestDemo : La demande retournée en fonction de son identifiant.
     */
    async getRequest(id) {
        const response = await this.apiClient.get(`/v0/requests/${id}`);
        return response.data;
    }
    /**
     * Retourne la liste des demandes (tous utilisateurs confondus).
     *
     *
     * @return RequestDemo[] : La liste de toutes les demandes pour l'ensemble des utilistateurs.
     */
    async getRequests() {
        const response = await this.apiClient.get(`/v0/requests`);
        return response.data;
    }
    /**
     * Retourne l'ensemble des demandes pour un utilisateur.
     *
     * @param userId : L'identifiant de l'utilisateur.
     *
     * @return RequestDemo[] : La liste des demandes pour l'utilisateur.
     */
    async getUserRequests(userId) {
        const id = userId;
        const response = await this.apiClient.get(`/v0/requests/user/${id}`);
        return response.data;
    }
}
