import React from "react";
import { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";
import { Link } from "react-router-dom";

// Start of user code d7af38382711d6d7dff6e9494f8d27c9
// End of user code

export default function CniPanel () {
  
  // --------------------------------
  // Gestion générique de la sécurité.
  // --------------------------------
  const { login, user, logout } = useAuth();
  
  
  
  // Start of user code a1927f907f88895fc705b93955b6c3bb
  // End of user code
  
  return (
    <>
        
        
      <p className="fr-text--lg fr-text--bold">Carte d'identité</p>
      <p>Pour obtenir une carte d'identité, commencez par rassembler les pièces justificatives demandées (acte de naissance ou copie intégrale, justificatif de domicile récent, une photo d'identité conforme et, si besoin, un justificatif de nationalité). </p><p>Ensuite, prenez rendez-vous ou rendez-vous directement à la mairie, au consulat ou au guichet compétent selon votre lieu de résidence, et déposez votre dossier complet. Le traitement comprend la vérification des documents, la prise d'empreintes si nécessaire, puis la fabrication de la carte — les délais peuvent varier selon les périodes et les communes. </p>Enfin, une fois la carte prête, vous serez informé pour la retirer en personne contre remise d'une pièce d'identité ou d'un récépissé. Pensez à vérifier la date d'expiration et à anticiper le renouvellement pour éviter toute situation problématique lors de vos déplacements. 
      <p/><a href="/gotToAvailableRequests" 
      className="fr-link fr-icon-arrow-left-line fr-link--icon-left"
        >Retour à la liste des démarches
      </a>
    </>
  );
}
