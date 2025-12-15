import axios from "axios";
/**
 * Client HTTP centralisé utilisé par tous les services.
 * La baseURL devra être fournie par l'application consommatrice
 * via une variable d'environnement ou une configuration runtime.
 */
export const apiClient = axios.create({
    baseURL: "http://localhost:8081", // pourra être surchargé
    headers: {
        "Content-Type": "application/json",
    },
});
