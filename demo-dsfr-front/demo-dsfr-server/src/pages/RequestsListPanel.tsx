import React from "react";
import { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";
import { Table } from "@codegouvfr/react-dsfr/Table";
import { getFakeTableData_ListRequestTable } from "../mocks/RequestsListPanelMock";
import { apiClient } from "../api/apiClient";
import { requests } from "demo-dsfr-client-rest";
import { RequestDemo } from "demo-dsfr-client-rest";

// Start of user code d1177b453a3736dc602f6dc49b423f6b

// ------------------------------------------------------
// On écrit la liste de correspondance dans tous les cas.
// ------------------------------------------------------
const selectColumns: Record<number, Record<string, string>> = {
};
// End of user code

export default function RequestsListPanel () {
  
  // --------------------------------
  // Gestion générique de la sécurité.
  // --------------------------------
  const { login, user, logout } = useAuth();
  
  const [data_ListRequestTable, setData_ListRequestTable] = useState<any[]>([]);
  
  // ----------------------------------------------
  // Chargement des données (appels des services).
  // ----------------------------------------------
  useEffect(() => {
    // Start of user code 437b0889bfbb91081f33fc51e544c470
    setData_ListRequestTable(getFakeTableData_ListRequestTable());
    // End of user code
    
    // Start of user code e5aef8b6d20ae639ba3ddccb57f65f73
    // Placer ici le code pour l'initialisation des paramètres en entrée.
    const userId = user?.id;
    // End of user code
    
    getUserRequests(userId)
      .then(rows => {
        setData_ListRequestTable(
        listRequestTableDataMap(rows));}); 
  }, []);
  
  // ----------------------------------------------
  // Mapping des données pour ListRequestTable
  // ----------------------------------------------
  function listRequestTableDataMap (result) {
     return result.map(req => [
      req.type ?? "",
      req.identifier ?? "",
      req.status ?? "",
      req.reason ?? "",
     ]);
   }
  
  /**
   * Retourne l'ensemble des demandes pour un utilisateur..
   */
  async function getUserRequests(userId) {
    const result = await requests
      .getUserRequests(userId);
    return result;
  }
  
  
  // Start of user code 8f15ff7826ad45e166f2985365071af5
  // End of user code
  
  return (
    <>
        
        
      <Table 
        fixed
        
        caption="Liste de vos démarches administratives en cours et/ou finalisées"
        data={
            data_ListRequestTable
          }
      headers={[
      "Type de démarche",
      "Identifiant de la démarche",
      "Statut de la démarche",
      "Raison de la démarche",
      ]}/>
    </>
  );
}
