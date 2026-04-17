import React from "react";
import { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";
import { Link } from "react-router-dom";
import { Table } from "@codegouvfr/react-dsfr/Table";
import { getFakeTableData_searchTable } from "../mocks/SearchResultsPanelMock";

// Start of user code 8353939a891a06097144b42d0efd7e19
// End of user code

export default function SearchResultsPanel () {
  
  // --------------------------------
  // Gestion générique de la sécurité.
  // --------------------------------
  const { login, user, logout } = useAuth();
  
  const [data_searchTable, setData_searchTable] = useState<any[]>([]);
  
  // ----------------------------------------------
  // Chargement des données (appels des services).
  // ----------------------------------------------
  useEffect(() => {
    // Start of user code 437b0889bfbb91081f33fc51e544c470
    setData_searchTable(getFakeTableData_searchTable());
    // End of user code
    
  }, []);
  
  
  // Start of user code 0e2e6027a18616c127deaf3f30495c06
  // End of user code
  
  return (
    <>
        
        
      <Table 
        fixed
        
        caption="Liste des résultats pour la recherche sémentique sur l'ensemble du site."
        data={
            data_searchTable
          }
      headers={[
      "Page",
      "Lien vers la page",
      ]}/>
    </>
  );
}
