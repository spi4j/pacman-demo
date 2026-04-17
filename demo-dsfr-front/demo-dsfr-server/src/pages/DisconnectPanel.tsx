import React from "react";
import { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";
import { Link } from "react-router-dom";
import { Alert } from "@codegouvfr/react-dsfr/Alert";

// Start of user code 834c79e2934f27325adefbc92e044920
// End of user code

export default function DisconnectPanel () {
  
  // --------------------------------
  // Gestion générique de la sécurité.
  // --------------------------------
  const { login, user, logout } = useAuth();
  
  
  // Start of user code 23ea2d560429f415db6348c6fca3fe57
  const [globalMessage, setGlobalMessage] = useState(false);

  useEffect(() => {
    logout();
     setGlobalMessage({
      text: "Utilisez de nouveau de menu de connexion pour vous reconnecter à votre compte.",
      severity: "success"
    });
  }, [logout]);
  
  // End of user code
  
  return (
    <>
        
        
      {globalMessage && (
        <Alert
          severity={globalMessage.severity}
          title={
            globalMessage.severity === "error"
              ? "Une erreur s'est produite, il a été impossible de vous déconnecter de l'application."
              : globalMessage.severity === "success"
              ? "Vous avez été déconnecté de l'application."
              : ""
          }
          description={globalMessage.text}
          closable
        />
      )}
      <p/>Votre session a été terminée avec succès.<p/>
      Cette déconnexion peut résulter d’une action volontaire de votre part ou d’une mesure de sécurité automatique liée à une période prolongée d’inactivité.
      La protection de vos données et la confidentialité de vos informations sont au cœur de nos priorités. C’est pourquoi nous appliquons des mécanismes de sécurité renforcés afin de garantir que votre compte et vos informations personnelles demeurent protégés en toutes circonstances.<p/>
      Pour continuer à utiliser l’application et accéder à l’ensemble de vos services, nous vous invitons à vous reconnecter à l’aide de vos identifiants. Si vous rencontrez des difficultés pour vous authentifier, n’hésitez pas à contacter le support technique ou à consulter la rubrique d’aide.
      <p/><a href="/goToReconnect" 
      className="fr-link fr-icon-arrow-right-line fr-link--icon-right"
        >Se reconnecter
      </a>
    </>
  );
}
