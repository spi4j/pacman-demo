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
      <p className="fr-text--lg fr-text--bold">Nom : {" "}
      {user?.lastName ?? "-"}</p>
      </div>
      <div className="fr-col">
      <p className="fr-text--lg fr-text--bold">Prénom : {" "}
      {user?.firstName ?? "-"}</p>
      </div></div>
      <div className="fr-grid-row fr-grid-row--gutters fr-grid-row--top">
      <div className="fr-col">
      <p className="fr-text--lg fr-text--bold">Adresse mail : {" "}
      {user?.mail ?? "-"}</p>
      </div>
      <div className="fr-col">
      <p className="fr-text--lg fr-text--bold">Téléphone : {" "}
      {user?.phone ?? "-"}</p>
      </div></div>
      </>)},
      { 
        isDefault: false,
        iconId: "fr-icon-home-4-line",
        label: "Adresse",
        content: (<>
      <p className="fr-text--lg fr-text--bold">Rue  : {" "}
      {user?.address ?? "-"}</p>
      <div className="fr-grid-row fr-grid-row--gutters fr-grid-row--top">
      <div className="fr-col">
      <p className="fr-text--lg fr-text--bold">Ville  : {" "}
      {user?.city ?? "-"}</p>
      </div>
      <div className="fr-col">
      <p className="fr-text--lg fr-text--bold">Code postal : {" "}
      {user?.zipCode ?? "-"}</p>
      </div></div>
      </>)},
      { 
        isDefault: false,
        iconId: "fr-icon-lock-line",
        label: "Information de connexion",
        content: (<>
      <p className="fr-text--lg fr-text--bold">Identifiant  : {" "}
      {user?.login ?? "-"}</p>
      </>)},
      ]}/>
    </>
  );
}
