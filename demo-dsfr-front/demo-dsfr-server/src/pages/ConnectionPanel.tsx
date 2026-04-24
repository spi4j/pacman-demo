import React from "react";
import { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";
import { useForm } from "react-hook-form";
import { Alert } from "@codegouvfr/react-dsfr/Alert";
import { Link } from "react-router-dom";
import { Button } from "@codegouvfr/react-dsfr/Button";
import { Input } from "@codegouvfr/react-dsfr/Input";
import { PasswordInput } from "@codegouvfr/react-dsfr/blocks/PasswordInput";

// Start of user code 9d693f75830fa331a99602728df556a1
// End of user code

export default function ConnectionPanel () {
  
  // --------------------------------
  // Gestion générique de la sécurité.
  // --------------------------------
  const { login, user, logout } = useAuth();
  
  
  // --------------------------------------------------
  // Définition du type pour les valeurs du formulaire.
  // --------------------------------------------------
  type FormValues = {
    
    idInput : string;
    pwdInput : string;
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
    return await login({
      type: "local",
      username: data.idInput,
      password: data.pwdInput
    });
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
       
       // Start of user code 9503976855b3b2cb91bd5050c3b913ac
       // End of user code
       
       
       
       // Start of user code 898b7ec196b52eca0fecaa7867e09ea5
          
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
  // End of user code
  
  // Start of user code e6b86bc9067baf9364289ae35dd4e8f2
  // End of user code
  
  return (
    <>
        
        
       <form onSubmit={handleSubmit(onSubmit)} 
       style={{
         maxWidth: "600px"
         
       }}>
         <fieldset className="fr-fieldset fr-fieldset__legend-adjusted" aria-labelledby="text-legend-connexionForm">
           <legend className="fr-fieldset__legend fr-h4" id="text-legend-connexionForm">
              Formulaire de connexion
              <span className="fr-hint-text">Connectez-vous pour suivre l'ensemble de vos démarches et gérer vos informations en ligne.</span>
           </legend>
         <div style={{ width: "100%" }}>
           {globalMessage && globalMessage.text.trim() !== "" && (
             <Alert
               severity={globalMessage.severity}
               title=""
               description={globalMessage.text}
               closable
             />
           )}
      <p/>
      <Input 
        label="Votre identifiant"
        
        
        
        
        
        hintText="Indiquez votre identifiant pour accéder à vos démarches en ligne."
        nativeInputProps={{
        ...getRegisterProps("idInput", { 
        required: "L'identifiant n'a pas été saisi ou n'est pas valide.", 
        validate: (value) => 
            new RegExp("^[0-9-a-z]+$").test(value) || "L'identifiant n'a pas été saisi ou n'est pas valide.",
        }),
        type:"text",
        placeholder: "Ex : 0214587311",
        maxLength: 20
        }}
        state={fieldState("idInput")}
        stateRelatedMessage={fieldMessage(
           "idInput",
           "Votre identifiant est obligatoire et doit être composé uniquement de chiffres.",
           "Le champ est valide pour soumission."
        )}
      />
      <Input 
        label="Votre mot de passe" 
        hintText="Renseigner votre mot de passe afin de valider votre connexion."
        nativeInputProps={{
        ...getRegisterProps("pwdInput", { 
        required: "Le mot de passe n'a pas été saisi ou n'est pas valide.", 
        }),
        type:"password",
        placeholder: "",
        maxLength: 20
        }}
        state={fieldState("pwdInput")}
        stateRelatedMessage={fieldMessage(
           "pwdInput",
           "Votre mot de passe est obligatoire.",
           "Le champ est valide pour soumission."
        )}
      />
      <p/><a href="/goToRegister" 
      className="fr-link fr-icon-arrow-right-line fr-link--icon-right"
        >Pas encore de compte ?
      </a>
      <p/><Button type="submit">Valider</Button>
          </div> {/* writeCloseForm */}
        </fieldset>
      </form>
    </>
  );
}
