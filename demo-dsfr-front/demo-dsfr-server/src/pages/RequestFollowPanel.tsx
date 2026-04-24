import React from "react";
import { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";
import { useForm } from "react-hook-form";
import { Alert } from "@codegouvfr/react-dsfr/Alert";
import { Link } from "react-router-dom";
import { Button } from "@codegouvfr/react-dsfr/Button";
import { Input } from "@codegouvfr/react-dsfr/Input";
import { apiClient } from "../api/apiClient";
import { requests } from "../api/overrideApiClient";
import { documents } from "../api/overrideApiClient";
import { RequestDemo } from "";

// Start of user code e4236aa18ba61de56b83c57baa837e48
// End of user code

export default function RequestFollowPanel () {
  
  // --------------------------------
  // Gestion générique de la sécurité.
  // --------------------------------
  const { login, user, logout } = useAuth();
  
  // --------------------------------------------------
  // Traitement de l'événement onClick : requestDocument.
  // --------------------------------------------------
  async function handleClickRequestDocument() {
     try {
        // Start of user code 7f80cc984409157544375182fc91fccf
        
         const docName = requestDemoData?.identifier + ".pdf";
         const result = await getDocument(docName);
         
         // conversion en Blob
          const blob = result instanceof Blob
          ? result : new Blob([result], { type: "application/pdf" });

         // URL temporaire navigateur
         const url = window.URL.createObjectURL(blob);

         // lien invisible
         const a = document.createElement("a");
         a.href = url;
         a.download = docName;
         a.style.display = "none";
         document.body.appendChild(a);

         // déclenche téléchargement
         a.click();

        // nettoyage
        a.remove();
        window.URL.revokeObjectURL(url);
    
        // End of user code
     } catch (e) {
        console.error(e);
        setGlobalMessage({
            text: "Erreur lors du traitement de handleClickRequestDocument",
            severity: "error"
        });
     }
  }
  // --------------------------------------------------
  // Définition du type pour les valeurs du formulaire.
  // --------------------------------------------------
  type FormValues = {
    
    requestFollowInput : string;
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
           text: "", 
           severity: "error",
        });
        //reset(); 
        return;
       }
       
       // Start of user code a1460fde4a630861b0a736c1df10f319
       
       const requests = await getUserRequests(user.id);
       console.log("requests =", requests);
       const request = requests.find(
          r => r.identifier === data.requestFollowInput
       );
       if (!request) {
          setGlobalMessage({
            severity: "warning",
            text: "Aucune démarche trouvée avec cet identifiant"
          });
          return;
       }
       const requestId = request.id;
       requestIdRef.current = requestId ?? null;
       console.log("id de la démarche : " , requestId);
       
       // End of user code
       
       
       const payload = buildRequestFollowFormPayload(data);
       const result = await getRequest(payload);
       
       // Start of user code aaec25d2bda68b3e528e682924fc052c
       
       result.type  = REQUEST_TYPE_LABELS[result.type] ?? result.type;
       result.reason = REQUEST_REASON_LABELS[result.reason] ?? result.reason;
       result.status = REQUEST_STATUS_LABELS[result.status] ?? result.status;
       setRequestDemoData(result);
          
       // End of user code
          
       setGlobalMessage({ 
          text: "", 
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
  // Start of user code 10e0a5055314c4eefe54b0828ec8ba1b
  function buildRequestFollowFormPayload(data : FormValues) 
  {
    // Ici on bypass data et on utilise 
    // directement l'id récupéré plus haut.
    return requestIdRef.current;
  }
  // End of user code
   
        
  // Start of user code 2db3a48fc78d36b67cb4f1068ffcac92
  // End of user code
  
  /**
   * Retoure une demande en fontion de son identifiant..
   */
  async function getRequest(id) {
    const result = await requests
      .getRequest(id);
    return result;
  }
  
  /**
   * Retourne l'ensemble des demandes pour un utilisateur..
   */
  async function getUserRequests(userId) {
    const result = await requests
      .getUserRequests(userId);
    return result;
  }
  
  /**
   * DESCRIPTION A IMPLEMENTER.
   */
  async function getDocument(docName) {
    const result = await documents
      .getDocument(docName);
    return result;
  }
  
  
  // Start of user code 9b58c3be5bb6ff89df9b9c84a8c61a0f
  
  const requestIdRef = React.useRef<string | null>(null);
  const [requestDemoData, setRequestDemoData] = useState(null);
  
  const REQUEST_TYPE_LABELS: Record<string, string> = {
    PA: "Demande de passeport",
    CN: "Demande de carte d'identité",
    CG: "Demande de carte grise",
    PC: "Demande de permis de conduire",
    CE: "Demande de carte électorale",
    TF: "Demande de timbres fiscaux",
   };
  
  const REQUEST_REASON_LABELS: Record<string, string> = {
    PD: "Première demande",
    RE: "Renouvellement",
    CA: "Changement d'adresse",
    PE: "Perte",
    VO: "Vol",
   };
  
  const REQUEST_STATUS_LABELS: Record<string, string> = {
    DE: "Déposée",
    ET: "En cours",
    AC: "Acceptée",
    TE: "Traitée",
    RE: "Rejetée",
    AN: "Annulée",
   };
  
  // End of user code
  
  return (
    <>
        
        
       <form onSubmit={handleSubmit(onSubmit)} 
       >
         <fieldset className="fr-fieldset fr-fieldset__legend-adjusted" aria-labelledby="text-legend-requestFollowForm">
           <legend className="fr-fieldset__legend fr-h4" id="text-legend-requestFollowForm">
              Recherche de la démarche pour suivi
              <span className="fr-hint-text"></span>
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
      <div className="fr-grid-row fr-grid-row--gutters fr-grid-row--top">
      <div className="fr-col">
      <Input 
        label="Identifiant de la démarche"
        
        
        
        
        
        hintText=""
        nativeInputProps={{
        ...getRegisterProps("requestFollowInput", { 
        required: "Le champ est en erreur, vueillez vérifier", 
        validate: (value) => 
            new RegExp("^[A-Z][A-Z0-9]{6,}$").test(value) || "Le champ est en erreur, vueillez vérifier",
        }),
        type:"text",
        placeholder: "ex : B000COF89C",
        maxLength: 100
        }}
        state={fieldState("requestFollowInput")}
        stateRelatedMessage={fieldMessage(
           "requestFollowInput",
           "Veuillez saisir l'identifiant de la demande à rechercher",
           "Le champ est valide"
        )}
      />
      </div>
      <div className="fr-col">
      <p/><Button type="submit">Rechercher</Button>
      </div></div>
          </div> {/* writeCloseForm */}
        </fieldset>
      </form>
      {/* // Start of user code e5ef5873875421992b7299d13a3e49b6
       */}
        {requestDemoData && ( <>
        {/* // End of user code
       */}
       <div><p/>
         <h4 style={{ marginLeft: "-1rem" }}>Détail de la démarche</h4>
      <div className="fr-grid-row fr-grid-row--gutters fr-grid-row--top">
      <div className="fr-col">
      <p>Identifiant : {" "}
      {requestDemoData?.identifier ?? "-"}
      </p>
      </div>
      <div className="fr-col">
      <p>Type : {" "}
      {requestDemoData?.type ?? "-"}
      </p>
      </div></div>
      <div className="fr-grid-row fr-grid-row--gutters fr-grid-row--top">
      <div className="fr-col">
      <p>Raison  : {" "}
      {requestDemoData?.reason ?? "-"}
      </p>
      </div>
      <div className="fr-col">
      <p>Statut : {" "}
      {requestDemoData?.status ?? "-"}
      </p>
      </div></div>
       
      <p/><Button onClick={
      	   handleClickRequestDocument}>
         Charger le fichier associé à la démarche</Button> 
        </div>
      {/* // Start of user code ede83d739ab5608776481d20b880ce9e
       */}
        </>)}
        {/* // End of user code
       */}
       <div><p/>
         <h4 style={{ marginLeft: "-1rem" }}></h4>
        </div>
    </>
  );
}
