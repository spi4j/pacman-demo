import { Requests } from "demo-dsfr-client-rest";
import { Users } from "demo-dsfr-client-rest";
import { Documents } from "demo-dsfr-client-rest";
import { apiClient } from "./apiClient";

// ***************************************
// Ici on injecte axios dans la librairie 
// ***************************************
export const requests = new Requests(apiClient);
export const users = new Users(apiClient);
export const documents = new Documents(apiClient);