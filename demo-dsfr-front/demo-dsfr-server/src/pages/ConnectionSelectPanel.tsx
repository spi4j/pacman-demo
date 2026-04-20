import React from "react";
import { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";
import { useForm } from "react-hook-form";
import { Alert } from "@codegouvfr/react-dsfr/Alert";
import { Link } from "react-router-dom";
import { Button } from "@codegouvfr/react-dsfr/Button";
import connectionSelectImg from"../assets/imgs/selection-methode-athentification.png";

// Start of user code aa1544a7e4b633b73cb097638fe634a0
// End of user code

export default function ConnectionSelectPanel () {
  
  // --------------------------------
  // Gestion générique de la sécurité.
  // --------------------------------
  const { login, user, logout } = useAuth();
  
  // --------------------------------------------------
  // Définition du type pour les valeurs du formulaire.
  // --------------------------------------------------
  type FormValues = {
    
  };
  
  // -----------------------------------------------
  // Possibilité de navigation si formulaire valide.
  // -----------------------------------------------
  const navigate = useNavigate();
  
  // ------------------------------------------------------------------------------------
  // Initialise useForm avec le type FormValues pour bénéficier de la validation typée.
  // Récupère register, reset pour lier les champs, handleSubmit pour gérer la soumission,
  // et errors pour afficher les messages d'erreur liés à chaque champ.
  // -----------------------------------------------------------------------------------
  const { 
    reset,
    watch,
    register, 
    setValue,
    handleSubmit, 
    formState: { errors, dirtyFields }, 
  } = useForm<FormValues>({
    mode: "onChange"
  });
  
  // -----------------------------------
  // Etat générique pour message global.
  // -----------------------------------  
  const [globalMessage, setGlobalMessage] = React.useState<{
    text: string;
    severity: "success" | "error" | "info" | "warning";
  } | null>(null);
  
  // ----------------------------------------------
  // Traitement métier pour la page.
  // -----------------------------------------------
  async function validateAndExecuteForm(data: FormValues): Promise<boolean> {
    console.log("Validation exécutée :", data);
    // Start of user code c0c3b9169b152f6602b8d199390d4d7d
    return await login({ type: "sso" });
    // End of user code
  }
  
  // -----------------------------------------------------
  // Fonction appelée lors de la soumission du formulaire.
  // -----------------------------------------------------
  const onSubmit = async (data: FormValues) => {
    try {
      console.log("Formulaire soumis :", data);
      const isValid = await validateAndExecuteForm(data);
      
      if (!isValid) {
        setGlobalMessage({ 
           text: "Nous ne trouvons pas de compte associé à ces informations. Assurez-vous que vos identifiants sont exacts.", 
           severity: "error",
        });
        //reset(); 
        return;
       }
       
       
       
       // Start of user code 3ae9c41f85df39a8e0d8403c3ad880ee
          
       // End of user code
          
       setGlobalMessage({ 
          text: "Vous êtes connecté avec votre espace personnel.", 
          severity: "success",
       });
       
    } catch (error) {
        console.error(error);
        setGlobalMessage({
          text: "Une erreur est survenue lors de l’accès au service.",
          severity: "error",
        });
     }
  };
  
  // ----------------------------------------------
  // Permet de sécuriser la génération automatique.
  // ----------------------------------------------
  function getRegisterProps(
    fieldName: keyof FormValues,
    rules?: Parameters<typeof register>[1]) {
    return { ...register(fieldName, rules) };
   }
  
  // ---------------------------------------
  // Centralisation de la gestion des états.
  // ---------------------------------------
  function fieldState(fieldName: keyof FormValues) {
     return errors[fieldName]
       ? "error"
       : dirtyFields[fieldName]
       ? "success"
       : "info";
  }
  
  // ----------------------------------------------
  // Centralisation pour l'affichage des messages.
  // ----------------------------------------------
  function fieldMessage(
     fieldName: keyof FormValues,
     defaultMessage: string,
     successMessage: string
   ) {
      return (
       errors[fieldName]?.message ||
       (dirtyFields[fieldName] ? successMessage : defaultMessage)
     );
  }
  
   
        
  // Start of user code 2db3a48fc78d36b67cb4f1068ffcac92
  
  useEffect(() => {
    // Hack pour rebasculer dans tous les cas en sso
    sessionStorage.setItem("authMode", "sso");
  }, []);

  // End of user code
  
  // Start of user code 1174d2f66dd15c80358cd76a0267120b
  // End of user code
  
  return (
    <>
        
        
      <b>Pour accéder à votre espace, veuillez choisir votre méthode d’authentification.</b><p></p><hr></hr>Vous pouvez vous connecter à l’aide du formulaire interne en utilisant vos identifiants habituels, ou bien passer par l’authentification sécurisée via DemoConnect (SSO), si votre organisation le permet.
       <form onSubmit={handleSubmit(onSubmit)} 
       >
         <fieldset className="fr-fieldset fr-fieldset__legend-adjusted" aria-labelledby="text-legend-connectionSelectForm">
           <legend className="fr-fieldset__legend fr-h4" id="text-legend-connectionSelectForm">
              
              <span className="fr-hint-text"></span>
           </legend>
         <div style={{ width: "100%" }}>
           {globalMessage && (
             <Alert
               severity={globalMessage.severity}
               title=""
               description={globalMessage.text}
               closable
             />
           )}
      <p/>
      <div className="fr-grid-row fr-grid-row--gutters fr-grid-row--top">
      <div className="fr-col">
      <Link to="/goToInternalConnexion"> 
      <p/><Button>Connexion par formulaire</Button>
      </Link> 
      </div>
      <div className="fr-col">
      <p/><Button type="submit">Connexion par DemoConnect</Button>
      </div></div>
          </div> {/* writeCloseForm */}
        </fieldset>
      </form>
      <p></p><p>Afin de garantir une expérience fluide et sécurisée, chaque accès est strictement contrôlé par des mécanismes d’authentification robustes, conçus pour protéger vos données et assurer l’intégrité de vos sessions. Les échanges entre votre navigateur et nos services sont chiffrés de bout en bout, réduisant ainsi tout risque d’interception ou d’usurpation d’identité.</p>
      Nous mettons un point d’honneur à appliquer les meilleures pratiques en matière de sécurité informatique, incluant la gestion sécurisée des identifiants, la limitation des tentatives de connexion et la surveillance des activités suspectes. Vous pouvez ainsi choisir votre mode de connexion en toute confiance, dans un environnement pensé pour la fiabilité, la confidentialité et la protection de vos informations.<p></p>
      <img
        src={connectionSelectImg}
        alt=""
        className="fr-responsive-img"
      /><p/>
         
    </>
  );
}
