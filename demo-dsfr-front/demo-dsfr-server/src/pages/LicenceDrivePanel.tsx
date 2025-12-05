import React from "react";
import { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";

// Start of user code b17d151793af5ee1a310b63720f0cfd0
// End of user code

export default function LicenceDrivePanel () {
  
  // --------------------------------
  // Gestion générique de la sécurité.
  // --------------------------------
  const { login, user, logout } = useAuth();
  
  
  // Start of user code bba8d3bd6a094ff897a9e78908f21cfc
  // End of user code
  
  return (
    <>
        
        
      <p className="fr-text--lg fr-text--bold">Permis de conduire</p>
      <p>Pour obtenir un permis de conduire, vous devez effectuer la démarche en ligne sur le site officiel de l’ANTS (Agence Nationale des Titres Sécurisés) ou via une préfecture/mairie habilitée. Avant de commencer, préparez les documents nécessaires : justificatif d’identité, justificatif de domicile, certificat de réussite à l’examen théorique (le code de la route), et, selon le cas, le certificat de formation pratique ou l’attestation d’auto-école.</p>
      <p>Après avoir rempli le formulaire de demande et transmis les pièces justificatives numérisées, vous devrez régler les frais administratifs correspondants. </p>
      <p>Une fois la demande validée, un permis provisoire peut être délivré immédiatement pour circuler en attendant la réception du permis définitif, qui sera envoyé à votre domicile par courrier sécurisé.</p>
      <p/><a href="/gotToAvailableRequests" 
      className="fr-link fr-icon-arrow-left-line fr-link--icon-left"
        >Retour à la liste des démarches
      </a>
    </>
  );
}
