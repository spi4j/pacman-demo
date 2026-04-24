import React from "react";
import { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";
import { Link } from "react-router-dom";
import { Tabs } from "@codegouvfr/react-dsfr/Tabs";

// Start of user code 390f51c79e9352b2247aa06eb0ba83c1
// End of user code

export default function ProfilPanel () {
  
  // --------------------------------
  // Gestion générique de la sécurité.
  // --------------------------------
  const { login, user, logout } = useAuth();
  
  
  // Start of user code 3bc24b8d7f42ddf1b8e1410a27e4cead
  
  const [userDemoData, setUserDemoData] = useState(null);
  
  useEffect(() => {
    setUserDemoData(user);
  }, [user]);
  
  // End of user code
  
  return (
    <>
        
        
      <Tabs
        onTabChange={function noRefCheck(){}}
        tabs={[
      { 
        isDefault: false,
        iconId: "fr-icon-user-line",
        label: "Information personnelles",
        content: (<>
      <div className="fr-grid-row fr-grid-row--gutters fr-grid-row--top">
      <div className="fr-col">
      <p>Nom : {" "}
      {userDemoData?.lastName ?? "-"}
      </p>
      </div>
      <div className="fr-col">
      <p>Prénom : {" "}
      {userDemoData?.firstName ?? "-"}
      </p>
      </div></div>
      <div className="fr-grid-row fr-grid-row--gutters fr-grid-row--top">
      <div className="fr-col">
      <p>Adresse mail : {" "}
      {userDemoData?.mail ?? "-"}
      </p>
      </div>
      <div className="fr-col">
      <p>Téléphone : {" "}
      {userDemoData?.phone ?? "-"}
      </p>
      </div></div>
      </>)},
      { 
        isDefault: false,
        iconId: "fr-icon-home-4-line",
        label: "Adresse",
        content: (<>
      <p>Rue  : {" "}
      {userDemoData?.address ?? "-"}
      </p>
      <div className="fr-grid-row fr-grid-row--gutters fr-grid-row--top">
      <div className="fr-col">
      <p>Ville  : {" "}
      {userDemoData?.city ?? "-"}
      </p>
      </div>
      <div className="fr-col">
      <p>Code postal : {" "}
      {userDemoData?.zipCode ?? "-"}
      </p>
      </div></div>
      </>)},
      { 
        isDefault: false,
        iconId: "fr-icon-lock-line",
        label: "Information de connexion",
        content: (<>
      <p>Identifiant  : {" "}
      {userDemoData?.login ?? "-"}
      </p>
      </>)},
      ]}/>
    </>
  );
}
