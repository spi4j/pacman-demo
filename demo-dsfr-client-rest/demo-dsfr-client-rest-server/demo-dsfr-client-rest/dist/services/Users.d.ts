/**
 * DESCRIPTION A IMPLEMENTER
 *
 * @Author MINARM
 */
import type { AxiosInstance } from "axios";
import type { UserDemo } from "../models/UserDemo";
export declare class Users {
    private apiClient;
    constructor(apiClient?: AxiosInstance);
    /**
     * Création d'un nouvel utilisateur.
     *
     * @param userIn : L'utilisateur à créer.
     *
     * @return UserDemo : L'utilisateur avec son identifiant.
     */
    setUser(userIn: UserDemo): Promise<UserDemo>;
    /**
     * Retourne un utilisateur en fonction de son identifiant.
     *
     * @param id : L'identifiant unique pour l'utilisateur.
     *
     * @return UserDemo : L'utilisateur retourné en fonction de son identifiant.
     */
    getUser(id: string): Promise<UserDemo>;
}
