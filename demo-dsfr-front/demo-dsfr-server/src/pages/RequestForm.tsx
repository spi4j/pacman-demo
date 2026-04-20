import React from "react";
import { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";
import { useForm } from "react-hook-form";
import { Alert } from "@codegouvfr/react-dsfr/Alert";
import { Link } from "react-router-dom";
import { Select } from "@codegouvfr/react-dsfr/Select";
import { Button } from "@codegouvfr/react-dsfr/Button";
import { Upload } from "@codegouvfr/react-dsfr/Upload";
import { ToggleSwitch } from "@codegouvfr/react-dsfr/ToggleSwitch";
import { Input } from "@codegouvfr/react-dsfr/Input";
import { apiClient } from "../api/apiClient";
import { requests } from "../api/overrideApiClient";
import { RequestDemo } from "demo-dsfr-client-rest";

// Start of user code 995723c4afdf2e019a92beded2745f35

import { documents } from "../api/overrideApiClient";

// End of user code

export default function RequestForm () {
  
  // --------------------------------
  // Gestion générique de la sécurité.
  // --------------------------------
  const { login, user, logout } = useAuth();
  
  // --------------------------------------------------
  // Définition du type pour les valeurs du formulaire.
  // --------------------------------------------------
  type FormValues = {
    
    requestSelect : string;
    docUpload : FileList;
    purposePassRequestSelect : string;
    oldPasswordInput : string;
    firstName : string;
    lastNamesForCni : string;
    usageFirstName : string;
    viewElement12 : string;
    purposeCniRequestSelect : string;
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
    return true;
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
           text: "Le formulaire n'est pas valide, veuillez vérifier l'ensemble de la saisie.", 
           severity: "error",
        });
        //reset(); 
        return;
       }
       
       
       const payload = buildRequestFormPayload(data);
       await setRequest(payload);
       
       // Start of user code e44bd242ede4029a648d53ff249e5a9a
       
       console.log("docUpload:", data.docUpload);
       if (data.docUpload && data.docUpload.length > 0) {
          console.log("Upload de fichier détecté, on appelle le second service...");
          // premier fichier uniquement (même si multiple)
          const file = data.docUpload[0];
          
          try {
             await documents.setDocument(
               "mondocumentfromreact.pdf",
               file,
               JSON.stringify({                   
                 requestType: data.requestSelect,
                 userId: user?.id,
               }),
               "application/pdf");
          } catch (err) {
             console.error("Erreur upload fichier :", err);
             setGlobalMessage({
                text: "La demande est créée mais le fichier n'a pas pu être envoyé.",
                severity: "warning",
             });
          }
       }
       
       // End of user code
          
       setGlobalMessage({ 
          text: "La demande a bien été envoyé.", 
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
  
  // ---------------------------------------------
  // Peuplement des données pour le(s) service(s).
  // ---------------------------------------------
  function buildRequestFormPayload(data : FormValues) 
  {
    return {
      reason: data.purposePassRequestSelect,
      reason: data.purposeCniRequestSelect,
      // Start of user code 10b7ef2154c9c5efc789dd8d75b7df7e
      
      reason:
      data.requestSelect === "PA"
        ? data.purposePassRequestSelect
        : data.requestSelect === "CN"
        ? data.purposeCniRequestSelect
        : null,
      type: data.requestSelect,
      identifier: "B4508QFJAA",
      status: "DE",
      userDemo_id: user?.id,
      
      // End of user code
    };
  }
   
        
  // Start of user code 2db3a48fc78d36b67cb4f1068ffcac92
  
  // On surveille la valeur du premier Select
  const selectedRequest = watch("requestSelect");

  // End of user code
  
  /**
   * Création d'une nouvelle demande..
   */
  async function setRequest(requestIn) {
    const result = await requests
      .setRequest(requestIn);
    return result;
  }
  
  
  // Start of user code 0a2fc978427341faec5d316c3c3ea150
  // End of user code
  
  return (
    <>
        
        
       <form onSubmit={handleSubmit(onSubmit)} 
       >
         <fieldset className="fr-fieldset fr-fieldset__legend-adjusted" aria-labelledby="text-legend-requestForm">
           <legend className="fr-fieldset__legend fr-h4" id="text-legend-requestForm">
              Formulaire de démarche administrative
              <span className="fr-hint-text">Le formulaire de démarche administrative permet de transmettre facilement une demande ou une déclaration auprès d’un service public. Il doit être rempli avec soin, en fournissant toutes les informations requises et les pièces justificatives demandées. Selon la nature de la démarche, le formulaire peut être complété en ligne ou sur papier, puis transmis à l’administration compétente. <p/>Veillez à bien vérifier les délais, les conditions d’éligibilité et les modalités d’envoi afin d’éviter tout retard ou rejet de votre dossier.</span>
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
       <Select
          label="Type de démarche"
          hint="Sélectionnez la démarche administrative que vous souhaitez effectuer dans la liste ci-dessous. Cette sélection permettra d’afficher le formulaire correspondant à votre demande." 
          
          nativeSelectProps={{
            defaultValue: "",
            ...register("requestSelect", { required: "Le champ est en erreur ou n'a pas été saisi." }),
            // Start of user code 248b0cff713a71448d9f186635a66683
            // End of user code
          }}
          state={errors.requestSelect ? "error" : dirtyFields.requestSelect ? "success" : "info"}
             stateRelatedMessage={
             errors.requestSelect?.message ||
             (dirtyFields.requestSelect ? "Le champ est valide pour soumission." : "Veuillez saisir le champ.")
          }
       >
       <option value="">Selectionnez une option</option>
       <option value="PA">Demande de passeport</option>
       <option value="CN">Demande de carte d'identité</option>
       <option value="CG">Demande de carte grise</option>
       <option value="PC">Demande de permis de conduire</option>
       <option value="CE">Demande de carte électorale</option>
       <option value="TF">Demande de timbres fiscaux</option>
      </Select>
      {/* // Start of user code 56a6a1e5971d3dd746ed1a77a5dff25a
       */}
        {selectedRequest === "PA" && (<>
        {/* // End of user code
       */}
      <p className="fr-text--lg fr-text--bold">Formulaire pour une demande de passeport  : {" "}
      </p>
       <Select
          label="Motif de la demande pour le passeport"
          hint="" 
          
          nativeSelectProps={{
            defaultValue: "",
            ...register("purposePassRequestSelect", { required: "Le champ est en erreur" }),
            // Start of user code f33cd45f2a9f1e0f08653843f7d28bee
            // End of user code
          }}
          state={errors.purposePassRequestSelect ? "error" : dirtyFields.purposePassRequestSelect ? "success" : "info"}
             stateRelatedMessage={
             errors.purposePassRequestSelect?.message ||
             (dirtyFields.purposePassRequestSelect ? "Le champ est valide" : "Veuillez saisir le champ")
          }
       >
       <option value="">Selectionnez une option</option>
       <option value="PD">Première demande</option>
       <option value="RE">Renouvellement</option>
       <option value="PE">Perte</option>
       <option value="VO">Vol</option>
      </Select>
      <ToggleSwitch
        label="Pour un mineur " 
        helperText=""
        inputTitle="Pour un mineur " 
        labelPosition="right"
        defaultChecked={false}
        nativeInputProps={{
           ...register("minorPasswordInput"),
           valueAsBoolean: true
        }}
      />
      <Input 
        label="Ancien numéro de passeport (si renouvellement)"
        
        
        
        
        
        hintText=""
        nativeInputProps={{
        ...getRegisterProps("oldPasswordInput", { 
        }),
        type:"text",
        placeholder: "",
        maxLength: 100
        }}
        state={fieldState("oldPasswordInput")}
        stateRelatedMessage={fieldMessage(
           "oldPasswordInput",
           "Veuillez saisir le champ",
           "Le champ est valide"
        )}
      />
      <Upload
        multiple
        label="Pieces justificatives pour la demande de passeport (Fichiers pdf uniquement)" 
        hint=""
        state="default"
        stateRelatedMessage="Text de validation / d'explication de l'erreur"
        nativeInputProps={{
          onChange: (e) => {
            setValue("docUpload", e.target.files, {
            shouldValidate: true,
            shouldDirty: true,
            });
          }
        }}
      />
      {/* // Start of user code a35b801de33eb554d235d989ede1627d
       */}
        </>)} {selectedRequest === "CN" && (<>
        {/* // End of user code
       */}
      <p className="fr-text--lg fr-text--bold">Formulaire pour une demande de carte d'identité : {" "}
      </p>
      <div className="fr-grid-row fr-grid-row--gutters fr-grid-row--top">
      <div className="fr-col">
      <Input 
        label="Nom de naissance"
        
        
        
        
        
        hintText=""
        nativeInputProps={{
        ...getRegisterProps("firstName", { 
        required: "Le champ est en erreur", 
        }),
        type:"text",
        placeholder: "",
        maxLength: 15
        }}
        state={fieldState("firstName")}
        stateRelatedMessage={fieldMessage(
           "firstName",
           "Veuillez saisir le champ",
           "Le champ est valide"
        )}
      />
      </div>
      <div className="fr-col">
      <Input 
        label="Nom d'usage"
        
        
        
        
        
        hintText=""
        nativeInputProps={{
        ...getRegisterProps("usageFirstName", { 
        }),
        type:"text",
        placeholder: "",
        maxLength: 15
        }}
        state={fieldState("usageFirstName")}
        stateRelatedMessage={fieldMessage(
           "usageFirstName",
           "Veuillez saisir le champ",
           "Le champ est valide"
        )}
      />
      </div></div>
      <Input 
        label="Prénoms"
        
        
        
        
        
        hintText=""
        nativeInputProps={{
        ...getRegisterProps("lastNamesForCni", { 
        required: "Le champ est en erreur", 
        }),
        type:"text",
        placeholder: "",
        maxLength: 30
        }}
        state={fieldState("lastNamesForCni")}
        stateRelatedMessage={fieldMessage(
           "lastNamesForCni",
           "Veuillez saisir le champ",
           "Le champ est valide"
        )}
      />
      <Input 
        label="Date de naissance"
        
        
        
        
        
        hintText=""
        nativeInputProps={{
        ...getRegisterProps("viewElement12", { 
        required: "Le champ est en erreur", 
        }),
        type:"text",
        placeholder: "Ex : dd/mm/aaaa",
        maxLength: 100
        }}
        state={fieldState("viewElement12")}
        stateRelatedMessage={fieldMessage(
           "viewElement12",
           "Veuillez saisir le champ",
           "Le champ est valide"
        )}
      />
       <Select
          label="Motif de la demande pour la carte d'identité"
          hint="" 
          
          nativeSelectProps={{
            defaultValue: "",
            ...register("purposeCniRequestSelect", { required: "Le champ est en erreur" }),
            // Start of user code 5c733ad8adcd33159422d21747d4091b
            // End of user code
          }}
          state={errors.purposeCniRequestSelect ? "error" : dirtyFields.purposeCniRequestSelect ? "success" : "info"}
             stateRelatedMessage={
             errors.purposeCniRequestSelect?.message ||
             (dirtyFields.purposeCniRequestSelect ? "Le champ est valide" : "Veuillez saisir le champ")
          }
       >
       <option value="">Selectionnez une option</option>
       <option value="PD">Première demande</option>
       <option value="RE">Renouvellement</option>
       <option value="PE">Perte</option>
       <option value="VO">Vol</option>
      </Select>
      {/* // Start of user code cb054538c9cb6637328f880c610e4366
       */}
           </>
      )} 
         {selectedRequest && selectedRequest !== "PA" && selectedRequest !== "CN" && (<>
        {/* // End of user code
       */}
      <p className="fr-text--lg fr-text--bold">Formulaire de démarche administrative</p>
      Le formulaire correspondant à ce type de demande n’a pas été développé dans le cadre de cette démonstration. Les champs spécifiques et le traitement associé ne sont donc pas disponibles pour le moment.
      {/* // Start of user code f5cb06ce9e385de8623ff0d9023de09c
       */}
        </>
      )} 
        {/* // End of user code
       */}
      <p/><Button type="submit">Soumettre la demande</Button>
          </div> {/* writeCloseForm */}
        </fieldset>
      </form>
    </>
  );
}
