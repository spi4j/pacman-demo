import React from "react";
import { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";
import { useForm } from "react-hook-form";
import { Alert } from "@codegouvfr/react-dsfr/Alert";
import { Button } from "@codegouvfr/react-dsfr/Button";
import { Input } from "@codegouvfr/react-dsfr/Input";
import { RadioButtons } from "@codegouvfr/react-dsfr/RadioButtons";
import { Select } from "@codegouvfr/react-dsfr/Select";
import { Checkbox } from "@codegouvfr/react-dsfr/Checkbox";
import mmRadioIco from "../assets/imgs/";
import mradioIco from "../assets/imgs/";

// Start of user code ae15e10fba58ce46f3eb92ba66fe6899
// End of user code

export default function RegisterPanel () {
  
  // --------------------------------
  // Gestion générique de la sécurité.
  // --------------------------------
  const { login, user, logout } = useAuth();
  
  // --------------------------------------------------
  // Définition du type pour les valeurs du formulaire.
  // --------------------------------------------------
  type FormValues = {
    
    firstNameInput : string;
    lastNameInput : string;
    cityInput : string;
    mmRadio : string;
    mradio : string;
    addressInput : string;
    cpInput : string;
    dateNaissInput : string;
    activitySelect : string;
    infop1CheckBox : string;
    infop2CheckBox : string;
    infop3CheckBox : string;
    idInput : string;
    pwdInput : string;
    mailInput : string;
    telInput : string;
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
    return data.IdentifiantInput === "12345" && data.passwordInput === "azerty";
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
           text: "Les données de sont pas valides, veuillez vérifier.", 
           severity: "error",
        });
        //reset(); 
        return;
       }
       
       
       
       // Start of user code 7fb2063420987239932587e096b544e8
          
       // End of user code
          
       setGlobalMessage({ 
          text: "Les données ont bien été enregistrées, vous pouvez désormais vous connecter à votre espace personnel.", 
          severity: "success",
       });
       
    } catch (error) {
        console.error(error);
        setGlobalMessage({
          text: "Une erreur est survenue lors de l’enregistrement.",
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
  
  // Start of user code 83ebe46f79efd9c33d70f36ef97fe7c4
  // End of user code
  
  return (
    <>
        
        
       <form onSubmit={handleSubmit(onSubmit)} 
       >
         <fieldset className="fr-fieldset fr-fieldset__legend-adjusted" aria-labelledby="text-legend-registerForm">
           <legend className="fr-fieldset__legend fr-h4" id="text-legend-registerForm">
              Formulaire d'inscription
              <span className="fr-hint-text">Bienvenue ! Pour créer votre compte et profiter pleinement de nos services en ligne, veuillez compléter ce formulaire. Tous les champs obligatoires doivent être remplis et vous devrez cocher les trois cases relatives à vos informations personnelles afin de valider vos données de manière sécurisée. Merci de vous assurer que toutes les informations fournies sont exactes.</span>
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
      <RadioButtons 
        hintText=""
        legend="Civilité" 
        options={[
      {
         
         
         hintText: "",
         label: "Madame",
         nativeInputProps: {
           ...register("sexeRadioGroup", { required: "Le champ est en erreur." }),
           value: "",
         },
        },
      {
         
         
         hintText: "",
         label: "Monsieur",
         nativeInputProps: {
           ...register("sexeRadioGroup", { required: "Le champ est en erreur." }),
           value: "",
         },
        },
      ]}
      orientation="horizontal"
      state={fieldState("sexeRadioGroup")}
      stateRelatedMessage={fieldMessage(
          "sexeRadioGroup",
          "Le champ est obligatoire.",
          "Le champ est valide pour soumission."
        )}
      />
      <div className="fr-grid-row fr-grid-row--gutters fr-grid-row--top">
      <div className="fr-col">
      <Input 
        label="Nom"
        
        
        
        
        
        hintText="Nom de famille ou nom de jeune fille si désiré."
        nativeInputProps={{
        ...getRegisterProps("firstNameInput", { 
        required: "Le champ est en erreur.", 
        }),
        type:"text",
        placeholder: "",
        maxLength: 100
        }}
        state={fieldState("firstNameInput")}
        stateRelatedMessage={fieldMessage(
           "firstNameInput",
           "Le champ est obligatoire.",
           "Le champ est valide pour soumission."
        )}
      />
      </div>
      <div className="fr-col">
      <Input 
        label="Prénom"
        
        
        
        
        
        hintText="Prénom courant, possibilité de saisir l'ensemble des prénoms séparés par un espace si désiré."
        nativeInputProps={{
        ...getRegisterProps("lastNameInput", { 
        required: "Le champ est en erreur.", 
        }),
        type:"text",
        placeholder: "",
        maxLength: 100
        }}
        state={fieldState("lastNameInput")}
        stateRelatedMessage={fieldMessage(
           "lastNameInput",
           "Le champ est obligatoire.",
           "Le champ est valide pour soumission."
        )}
      />
      </div></div>
      <Input 
        label="Rue"
        
        
        
        
        
        hintText="Saisir la rue ou le lieu-dit"
        nativeInputProps={{
        ...getRegisterProps("addressInput", { 
        required: "Le champ est en erreur.", 
        }),
        type:"text",
        placeholder: "",
        maxLength: 100
        }}
        state={fieldState("addressInput")}
        stateRelatedMessage={fieldMessage(
           "addressInput",
           "Le champ est obligatoire.",
           "Le champ est valide pour soumission."
        )}
      />
      <div className="fr-grid-row fr-grid-row--gutters fr-grid-row--top">
      <div className="fr-col">
      <Input 
        label="Ville"
        
        
        
        
        
        hintText=""
        nativeInputProps={{
        ...getRegisterProps("cityInput", { 
        }),
        type:"text",
        placeholder: "",
        maxLength: 100
        }}
        state={fieldState("cityInput")}
        stateRelatedMessage={fieldMessage(
           "cityInput",
           "Veuillez saisir le champ.",
           "Le champ est valide pour soumission."
        )}
      />
      </div>
      <div className="fr-col">
      <Input 
        label="Code Postal"
        
        
        
        
        
        hintText=""
        nativeInputProps={{
        ...getRegisterProps("cpInput", { 
        required: "Le code postal n'est pas valide.", 
        validate: (value) => 
            new RegExp("^[0-9]{5}$").test(value) || "Le code postal n'est pas valide.",
        }),
        type:"text",
        placeholder: "",
        maxLength: 5
        }}
        state={fieldState("cpInput")}
        stateRelatedMessage={fieldMessage(
           "cpInput",
           "Le champ est obligatoire.",
           "Le champ est valide pour soumission."
        )}
      />
      </div></div>
      <div className="fr-grid-row fr-grid-row--gutters fr-grid-row--top">
      <div className="fr-col">
       <Select
          label="Secteur d'activité"
          hint="" 
          
          nativeSelectProps={{
            defaultValue: "",
            ...register("activitySelect"),
            // Start of user code 35f9d5704da545bcdef52a6bc511ef99
            // End of user code
          }}
          state={errors.activitySelect ? "error" : dirtyFields.activitySelect ? "success" : "info"}
             stateRelatedMessage={
             errors.activitySelect?.message ||
             (dirtyFields.activitySelect ? "Le champ est valide pour soumission." : "Veuillez saisir le champ.")
          }
       >
       <option value="">Selectionnez une option</option>
       <option value="AD">Administration publique</option>
       <option value="SA">Santé</option>
       <option value="ED">Éducation</option>
       <option value="IN">Industrie</option>
       <option value="AU">Autre</option>
      </Select>
      </div>
      <div className="fr-col">
      <Input 
        label="Date de naissance"
        
        
        
        
        
        hintText=""
        nativeInputProps={{
        ...getRegisterProps("dateNaissInput", { 
        validate: (value) => 
            new RegExp("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/[0-9]{4}$").test(value) || "La date de naissance n'est pas valide.",
        }),
        type:"text",
        placeholder: "dd/mm/aaaa",
        maxLength: 10
        }}
        state={fieldState("dateNaissInput")}
        stateRelatedMessage={fieldMessage(
           "dateNaissInput",
           "Veuillez saisir le champ.",
           "Le champ est valide pour soumission."
        )}
      />
      </div></div>
      <div className="fr-grid-row fr-grid-row--gutters fr-grid-row--top">
      <div className="fr-col">
      <Input 
        label="Adresse mail"
        
        
        
        
        
        hintText=""
        nativeInputProps={{
        ...getRegisterProps("mailInput", { 
        validate: (value) => 
            new RegExp("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$").test(value) || "Le champ est en erreur",
        }),
        type:"text",
        placeholder: "Ex : jean.dupont@gmail.com",
        maxLength: 100
        }}
        state={fieldState("mailInput")}
        stateRelatedMessage={fieldMessage(
           "mailInput",
           "Veuillez saisir le champ",
           "Le champ est valide"
        )}
      />
      </div>
      <div className="fr-col">
      <Input 
        label="Téléphone"
        
        
        
        
        
        hintText=""
        nativeInputProps={{
        ...getRegisterProps("telInput", { 
        validate: (value) => 
            new RegExp("^(?:0|\\+33)[1-9](?:[\\s.-]?\\d{2}){4}$").test(value) || "Le champ est en erreur.",
        }),
        type:"text",
        placeholder: "Ex : 0610547856",
        maxLength: 100
        }}
        state={fieldState("telInput")}
        stateRelatedMessage={fieldMessage(
           "telInput",
           "Veuillez saisir le champ.",
           "Le champ est valide pour soumission."
        )}
      />
      </div></div>
      <div className="fr-grid-row fr-grid-row--gutters fr-grid-row--top">
      <div className="fr-col">
      <Checkbox
        hintText=""
        legend="Informations personnelles"
        options={[
      {
         
         hintText: "",
         label: "Je certifie que les informations saisies sont exactes.",
         nativeInputProps: {
           ...register("viewElement2", {
           validate: (value, allValues) =>
          (allValues.viewElement2?.length ?? 0) >= 3 ||
          "Les trois cases sont obligatoires",
           }),
           value: "ok1",
         },
       },
      {
         
         hintText: "",
         label: "Je déclare être majeur(e).",
         nativeInputProps: {
           ...register("viewElement2"),
           value: "ok2",
         }
       },
      {
         
         hintText: "",
         label: "Je confirme être le titulaire du compte.",
         nativeInputProps: {
           ...register("viewElement2"),
           value: "ok3",
         }
       },
      ]}
            state={errors.viewElement2 ? "error" : dirtyFields.viewElement2 ? "success" : "info"}
              stateRelatedMessage={
                errors.viewElement2?.message ||
                (dirtyFields.viewElement2 ? "La section est valide pour soumission." : "Afin de valider le formulaire les trois cases doivent être cochées.")
              }
      />
      </div>
      <div className="fr-col">
      <Input 
        label="Identifiant"
        
        
        
        
        
        hintText=""
        nativeInputProps={{
        ...getRegisterProps("idInput", { 
        validate: (value) => 
            new RegExp("^[0-9]+$").test(value) || "Le champ est en erreur",
        }),
        type:"text",
        placeholder: "Ex : 0125478854",
        maxLength: 10
        }}
        state={fieldState("idInput")}
        stateRelatedMessage={fieldMessage(
           "idInput",
           "Veuillez saisir le champ",
           "Le champ est valide pour soumission."
        )}
      />
      <Input 
        label="Mot de passe"
        
        
        
        
        
        hintText=""
        nativeInputProps={{
        ...getRegisterProps("pwdInput", { 
        }),
        type:"text",
        placeholder: "",
        maxLength: 100
        }}
        state={fieldState("pwdInput")}
        stateRelatedMessage={fieldMessage(
           "pwdInput",
           "Veuillez saisir le champ",
           "Le champ est valide"
        )}
      />
      </div></div>
      <p/><Button type="submit">Valider</Button>
          </div> {/* writeCloseForm */}
        </fieldset>
      </form>
    </>
  );
}
