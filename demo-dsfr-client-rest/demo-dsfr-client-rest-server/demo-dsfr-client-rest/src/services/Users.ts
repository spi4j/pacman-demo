/**
 * DESCRIPTION A IMPLEMENTER
 *
 * @Author MINARM
 */
import type { AxiosInstance } from "axios";
import { apiClient } from "../api/apiClient";
import { UserDemo } from "../models/UserDemo";

export class Users {
  
  // Permet la surchage du client.
  constructor(private apiClient: AxiosInstance = apiClient) {}
  
   /**
    * Création d'un nouvel utilisateur.
    * 
    * @param userIn : L'utilisateur à créer.
    *
    * @return UserDemo : L'utilisateur avec son identifiant.
    */
   async setUser(userIn: UserDemo) : Promise<UserDemo> {
      
      const response = await apiClient.post(`/v0/users`, userIn);
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
      
      const response = await apiClient.get(`/v0/users/${id}`);
      return response.data;
   }
  
}

// On exporte une instance pour simplifier l’usage.
export const users = new Users(apiClient);
