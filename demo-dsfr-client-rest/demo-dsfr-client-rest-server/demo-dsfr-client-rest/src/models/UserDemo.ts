/**
 * Utilisateur de l'application.
 *
 * @Author MINARM
 */

import { RequestDemo } from "./RequestDemo";

export interface UserDemo {

  /** Id. */
  userDemo_id : string;
  
  /** Le prénom pour l'utilisateur.. */
  firstName: string;
  
  /** Le nom de l'utilisateur.. */
  lastName: string;
  
  /** Le téléphone pour l'utilisateur.. */
  phone?: string;
  
  /** Le mail pour l'utilisateur.. */
  mail?: string;
  
  /** La ville pour l'utilisateur.. */
  city?: string;
  
  /** Le code postal pour l'utilisateur.. */
  zipCode?: string;
  
  /** L'identifiant pour l'utilistateur.. */
  login: string;
  
  /** L'adresse de l'utilistateur.. */
  address?: string;
  
  /** La civilité de l'utilisateur.. */
  civility: string;
  
  /** La date de naissance pour l'utilisateur.. */
  dateOfBirth?: string;
  
  /** Le mot de passe pour l'utilisateur.. */
  password: string;
  
  /** La profession pour l'utilisateur.. */
  businessActivity?: string;
  
  
  /** Demande pour un utilisateur. */
  hasRequests : RequestDemo[] ;
}
