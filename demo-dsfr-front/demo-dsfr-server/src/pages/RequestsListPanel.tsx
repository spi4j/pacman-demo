import React from "react";
import { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";
import { Link } from "react-router-dom";
import { Table } from "@codegouvfr/react-dsfr/Table";
import { getFakeTableData_ListRequestTable } from "../mocks/RequestsListPanelMock";
import { apiClient } from "../api/apiClient";
import { requests } from "../api/overrideApiClient";
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
    
    // Start of user code 30f1bf4c7f24fc1157c498bc73b9edce
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
     return result
       // Start of user code 8418c7d927433a3f80bc88ca2bd3797f
       // End of user code
       .map(req => { 
       const row = [
       req.type ?? "",
       req.identifier ?? "",
       req.status ?? "",
       req.reason ?? "",
       ];
       // Start of user code 88028396c07b2e788f2c5e6e616c02d7
       row[0] = REQUEST_TYPE_LABELS[req.type] ?? row[0];
       row[2] = REQUEST_STATUS_LABELS[req.status] ?? row[2];
       row[3] = REQUEST_REASON_LABELS[req.reason] ?? row[3];
       // End of user code
       return row;
     });
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
  
   const REQUEST_TYPE_LABELS: Record<string, string> = {
    PA: "Demande de passeport",
    CN: "Demande de carte d'identité",
    CG: "Demande de carte grise",
    PC: "Demande de permis de conduire",
    CE: "Demande de carte électorale",
    TF: "Demande de timbres fiscaux",
   };
  
   const REQUEST_REASON_LABELS: Record<string, string> = {
    PD: "Première demande",
    RE: "Renouvellement",
    CA: "Changement d'adresse",
    PE: "Perte",
    VO: "Vol",
   };
  
   const REQUEST_STATUS_LABELS: Record<string, string> = {
    DE: "Déposée",
    ET: "En cours",
    AC: "Acceptée",
    TE: "Traitée",
    RE: "Rejetée",
    AN: "Annulée",
   };
  
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
