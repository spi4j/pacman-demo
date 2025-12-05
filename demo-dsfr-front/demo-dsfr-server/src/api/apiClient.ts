import axios, { AxiosInstance, AxiosRequestConfig } from "axios";
import { apiConfig } from "./apiConfig";

// Construction de la configuration finale
const finalConfig: AxiosRequestConfig = {
  ...apiConfig,
  timeout: apiConfig.timeout ?? 15000,
};

// Création de l’instance axios
const apiClient: AxiosInstance = axios.create(finalConfig);

// Intercepteur pour la requête.
apiClient.interceptors.request.use(
  (config) => {
    return config;
  },
  (error) => {
    return Promise.reject(error);
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
