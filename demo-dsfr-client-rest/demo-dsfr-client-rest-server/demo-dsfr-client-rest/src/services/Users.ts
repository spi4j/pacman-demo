/**
 * DESCRIPTION A IMPLEMENTER
 *
 * @Author MINARM
 */
import type { AxiosInstance } from "axios";
import type { UserDemo } from "../models/UserDemo";

// fallback global (IMPORTANT)
import { apiClient as defaultApiClient } from "../api/apiClient";

export class Users {
  
  private apiClient: AxiosInstance;
  
  // Permet la surchage du client.
  constructor(apiClient: AxiosInstance = defaultApiClient) {
     this.apiClient = apiClient;
  }
  
   /**
    * Création d'un nouvel utilisateur.
    * 
    * @param userIn : L'utilisateur à créer.
    *
    * @return UserDemo : L'utilisateur avec son identifiant.
    */
   async setUser(userIn: UserDemo) : Promise<UserDemo> {
      
      const response = await this.apiClient.post(`/v0/users`, userIn);
      return response.data;
   }
  
   /**
    * Retourne un utilisateur en fonction de son identifiant.
    * 
    * @param id : L'identifiant unique pour l'utilisateur.
    *
    * @return UserDemo : L'utilisateur retourné en fonction de son identifiant.
    */
   async getUser(id: string) : Promise<UserDemo> {
      
      const response = await this.apiClient.get(`/v0/users/${id}`);
      return response.data;
   }
  
}
