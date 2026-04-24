import React from "react";
import { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";
import { Link } from "react-router-dom";

// Start of user code 1fd4d0a24024c2e6364a0fdfad8ca0ca
// End of user code

export default function PassportPanel () {
  
  // --------------------------------
  // Gestion générique de la sécurité.
  // --------------------------------
  const { login, user, logout } = useAuth();
  
  
  
  // Start of user code 073491192c5b0de97af8a36d9ae4d4b9
  // End of user code
  
  return (
    <>
        
        
      <p className="fr-text--lg fr-text--bold">Passeport</p>
      Pour obtenir un passeport, commencez par rassembler les pièces requises : une pièce d’identité ou l’ancien passeport si vous renouvelez, des photos d’identité conformes, un justificatif de domicile récent, et un document prouvant la nationalité si nécessaire. <p/>Prenez ensuite rendez-vous au guichet compétent (mairie, centre des formalités ou consulat à l’étranger) pour déposer votre dossier complet et régler les frais administratifs. Le passeport moderne est biométrique : la prise d’empreintes et la numérisation de la photo peuvent être effectuées lors du rendez-vous, puis la fabrication prend un certain temps selon la période et le lieu. <p/>Vous serez informé lorsque le document sera prêt ; la remise s’effectue obligatoirement en personne sur présentation d’un justificatif ou du récépissé, et pensez à vérifier la date de validité pour anticiper un renouvellement avant vos déplacements. 
      <p/><a href="/gotToAvailableRequests" 
      className="fr-link fr-icon-arrow-left-line fr-link--icon-left"
        >Retour à la liste des démarches
      </a>
    </>
  );
}
