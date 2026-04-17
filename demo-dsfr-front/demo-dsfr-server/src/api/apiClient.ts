import axios, { AxiosInstance, AxiosRequestConfig } from "axios";
import { apiConfig } from "./apiConfig";
import keycloak from "../contexts/Keycloak";

console.log("API CLIENT INITIALISATION");

// Construction de la configuration finale
const finalConfig: AxiosRequestConfig = {
  ...apiConfig,
  timeout: apiConfig.timeout ?? 15000,
};

// Création de l'instance axios
const apiClient: AxiosInstance = axios.create(finalConfig);

// Intercepteur pour la requête.
apiClient.interceptors.request.use(
  async (config) => {
    try {
      console.log("INTERCEPTEUR ACTIF");
      config.headers = config.headers ?? {};
      
      // priorité SSO
      let token = keycloak.token;
      
      // fallback LOCAL
      if (!token) {
        token = sessionStorage.getItem("token");
      }
       
      config.headers.Authorization = `Bearer ${token}`;
      console.log("jeton ajouté dans l'en-tête");
      return config;   
    } catch (e) {
      console.error("ERREUR INTERCEPTOR:", e);
      throw e;
    }
  },
  (error) => {
    return Promise.reject(error)
  }
);

// Intercepteur pour la réponse. 
apiClient.interceptors.response.use(
  (response) => response,
  (error) => {
    console.error("API Error:", error);
    return Promise.reject(error);
  }
);

export { apiClient };
