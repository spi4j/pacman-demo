/**
 * DESCRIPTION A IMPLEMENTER
 *
 * @Author MINARM
 */
import type { AxiosInstance } from "axios";
export declare class Documents {
    private apiClient;
    constructor(apiClient?: AxiosInstance);
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
    setDocument(docName: string, docContent: Blob | File, docMetadatas: string, docType: string): Promise<String>;
    /**
     * DESCRIPTION A IMPLEMENTER.
     *
     * @param docName : DESCRIPTION A IMPLEMENTER.
     *
     * @return DocumentContent : DESCRIPTION A IMPLEMENTER.
     */
    getDocument(docName: string): Promise<Blob>;
}
