/**
 * DESCRIPTION A IMPLEMENTER
 *
 * @Author MINARM
 */
import type { AxiosInstance } from "axios";
// fallback global (IMPORTANT)
import { apiClient as defaultApiClient } from "../api/apiClient";

export class Documents {
  
  private apiClient: AxiosInstance;
  
  // Permet la surchage du client.
  constructor(apiClient: AxiosInstance = defaultApiClient) {
     this.apiClient = apiClient;
  }
  
   /**
    * DESCRIPTION A IMPLEMENTER.
    * 
    * @param docName : DESCRIPTION A IMPLEMENTER.
    * @param docContent : DESCRIPTION A IMPLEMENTER.
    * @param docMetadatas : DESCRIPTION A IMPLEMENTER.
    * @param docType : DESCRIPTION A IMPLEMENTER.
    *
    * @return String : DESCRIPTION A IMPLEMENTER.
    */
   async setDocument(docName: string, docContent: Blob | File, docMetadatas: string, docType: string) : Promise<String> {
      const name = docName;
      const formData = new FormData();
      formData.append("file", docContent);
      formData.append("metadata", docMetadatas);
      const response = await this.apiClient.post(`/v0/documents/${name}`, formData, { params: {type: docType}, headers: { "Content-Type": undefined } });
      return response.data;
   }
  
   /**
    * DESCRIPTION A IMPLEMENTER.
    * 
    * @param docName : DESCRIPTION A IMPLEMENTER.
    *
    * @return DocumentContent : DESCRIPTION A IMPLEMENTER.
    */
   async getDocument(docName: string) : Promise<Blob> {
      const name = docName;
      const response = await this.apiClient.get(`/v0/documents/${name}`, { responseType: 'blob' });
      return response.data;
   }
  
}
