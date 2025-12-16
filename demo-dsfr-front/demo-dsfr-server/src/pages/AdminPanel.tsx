import React from "react";
import { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";
import { useForm } from "react-hook-form";
import { Alert } from "@codegouvfr/react-dsfr/Alert";
import { fr } from "@codegouvfr/react-dsfr/fr";
import { Accordion } from "@codegouvfr/react-dsfr/Accordion";
import { Table } from "@codegouvfr/react-dsfr/Table";
import { Input } from "@codegouvfr/react-dsfr/Input";
import { Select } from "@codegouvfr/react-dsfr/Select";
import { Button } from "@codegouvfr/react-dsfr/Button";
import { getFakeTableData_requestsInProgressTable } from "../mocks/AdminPanelMock";
import { getFakeTableData_requestFinalizedTable } from "../mocks/AdminPanelMock";
import { createModal } from "@codegouvfr/react-dsfr/Modal";

// --------------------------------------------------------------------
// Toujours appeler createModal hors du composant, juste après imports.
// --------------------------------------------------------------------
const modal = createModal({ 
   id: "edit-row-modal", 
   isOpenedByDefault: false 
});
import { apiClient } from "../api/apiClient";
import { requests } from "demo-dsfr-client-rest";
import { RequestDemo } from "demo-dsfr-client-rest";

// Start of user code 5adad5b103d11d932756b57cf2338a44

// ------------------------------------------------------
// On écrit la liste de correspondance dans tous les cas.
// ------------------------------------------------------
const selectColumns: Record<number, Record<string, string>> = {
   3: {
     DE:"Déposée",
     ET:"En cours",
     AC:"Acceptée",
     TE:"Traitée",
     RE:"Rejetée",
     AN:"Annulée",
  },
};
// End of user code

export default function AdminPanel () {
  
  // --------------------------------
  // Gestion générique de la sécurité.
  // --------------------------------
  const { login, user, logout } = useAuth();
  
  // --------------------------------------------------
  // Définition du type pour les valeurs du formulaire.
  // --------------------------------------------------
  type FormValues = {
    
    inRequestType : string;
    inRequestId : string;
    inRequestUser : string;
    inRequestStatus : string;
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
       
       
       // ------------------------------------------------------
       // Gestion des fenêtres modales pour les tables éditables.
       // ------------------------------------------------------
       if (!currentTable || !currentRow) return;
       const updatedRow = [    data.inRequestType,     data.inRequestId,     data.inRequestUser,     data.inRequestStatus, 
       ];
       
       if (currentTable === "requestsInProgressTable") {
          setData_requestsInProgressTable(prev =>
          prev.map(row => (row[0] === currentRow[0] ? updatedRow : row))
          );
       } 
       modal.close();
       
       // Start of user code 662e9e4f936a26d2a3b4f4353662e3eb
          
       // End of user code
          
       setGlobalMessage({ 
          text: "", 
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
  const [data_requestsInProgressTable, setData_requestsInProgressTable] = useState<any[]>([]);
  const [data_requestFinalizedTable, setData_requestFinalizedTable] = useState<any[]>([]);
  const [currentRow, setCurrentRow] = useState<any[] | null>(null);
  const [currentTable, setCurrentTable] = useState<"requestsInProgressTable"| null>(null);
  // -----------------------------------------------------
  // Centralisation du pilotage pour la fenêtre d'édition.
  // -----------------------------------------------------
  const handleEditClick = (table: "requestsInProgressTable", row: any[]) => {
    if (!modal) return;
    setGlobalMessage(null);
    setCurrentRow(row);
    setCurrentTable(table);
      
      reset({
        inRequestType: row[0],
        inRequestId: row[1],
        inRequestUser: row[2],
        inRequestStatus: row[3],
      });
    setTimeout(() => modal.open(), 0);
  };
    
  // -----------------------------------------------------
  // Centralisation du pilotage pour la fenêtre d'édition.
  // -----------------------------------------------------
  const handleClose = () => {
    if (!modal) return;
    setCurrentRow(null);
    setCurrentTable(null);
    modal.close(); 
  };
  
  // ----------------------------------------------
  // Chargement des données (appels des services).
  // ----------------------------------------------
  useEffect(() => {
    // Start of user code 437b0889bfbb91081f33fc51e544c470
    setData_requestsInProgressTable(getFakeTableData_requestsInProgressTable());
    setData_requestFinalizedTable(getFakeTableData_requestFinalizedTable());
    // End of user code
    
    // Start of user code 4f0f56ca550b4c895a23f6827b2f1aad
    // Placer ici le code pour l'initialisation des paramètres en entrée.
    // End of user code
    
    getRequests()
      .then(rows => {
        setData_requestsInProgressTable(
        requestsInProgressTableDataMap(rows));}); 
    // Start of user code dec1497ef742ce9e841a4089b4fb2fb1
    // Placer ici le code pour l'initialisation des paramètres en entrée.
    // End of user code
    
    getRequests()
      .then(rows => {
        setData_requestFinalizedTable(
        requestFinalizedTableDataMap(rows));}); 
  }, []);
  
  // ----------------------------------------------
  // Mapping des données pour requestsInProgressTable
  // ----------------------------------------------
  function requestsInProgressTableDataMap (result) {
     return result
       // Start of user code 4867ee96dbb0b03a64af598e3d38fe2c
       .filter(req => req.status !== "TE")
       // End of user code
       .map(req => { 
       const row = [
       req.type ?? "",
       req.identifier ?? "",
       req.reason ?? "",
       req.status ?? "",
       ];
       // Start of user code 44f42bebb02e5178be62e4efeb211adf
       row[0] = REQUEST_TYPE_LABELS[req.type] ?? row[0];
       row[2] = REQUEST_REASON_LABELS[req.reason] ?? row[3];
       // End of user code
       return row;
     });
   }
  // ----------------------------------------------
  // Mapping des données pour requestFinalizedTable
  // ----------------------------------------------
  function requestFinalizedTableDataMap (result) {
     return result
       // Start of user code c61d8bfbb5ad9c3e07e633f1b31d34b9
       .filter(req => req.status == "TE")
       // End of user code
       .map(req => { 
       const row = [
       req.type ?? "",
       req.identifier ?? "",
       req.reason ?? "",
       req.status ?? "",
       ];
       // Start of user code eca511d5b64f77037701e975fba2c7c8
       row[0] = REQUEST_TYPE_LABELS[req.type] ?? row[0];
       row[3] = REQUEST_STATUS_LABELS[req.status] ?? row[2];
       row[2] = REQUEST_REASON_LABELS[req.reason] ?? row[3];
       // End of user code
       return row;
     });
   }
  
  /**
   * Retourne la liste des demandes (tous utilisateurs confondus)..
   */
  async function getRequests() {
    const result = await requests
      .getRequests();
    return result;
  }
  
  
  // Start of user code a845b1bb6c48236d0e87cf5136144aef
  
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
        
        
      <div className={fr.cx("fr-accordions-group")}>
      <Accordion 
        label="Liste des demandes en cours"
      >
      <Table 
        className="table-edition"
        colorVariant="orange-terre-battue"
        caption=""
        data={
          data_requestsInProgressTable.map((row) => {
            // On clone la ligne pour ne pas modifier les données originales
            const displayRow = [...row];
            Object.entries(selectColumns).forEach(([colIndex, labelMap]) => {
              const index = Number(colIndex);
              const code = displayRow[index];
              if (labelMap && code in labelMap) {
              displayRow[index] = labelMap[code];
            }
          });
          // On ajoute le bouton d’édition à la fin
          return [
            ...displayRow,
            <Button
               key={row[0]}
               // On passe toujours la ligne brute.
               onClick={() => handleEditClick("requestsInProgressTable", row)} 
               secondary="true"
               small="true"
            >
            Éditer
            </Button>,
            ];
          })}
      headers={[
      "Type de demande",
      "Identifiant de la démarche",
      "Motif de la demande",
      "Statut de la demande",
      "Edition",
      ]}/>
      </Accordion>
      <div className="fr-grid-row fr-grid-row--gutters fr-grid-row--top">
      <div className="fr-col">
      {currentRow && currentTable && (
      <modal.Component 
        className="modal-auto-size"
        title="" 
        onClose={handleClose}>
        <div >
       <form onSubmit={handleSubmit(onSubmit)} 
       >
         <fieldset className="fr-fieldset fr-fieldset__legend-adjusted" aria-labelledby="text-legend-requestIPFormPanel">
           <legend className="fr-fieldset__legend fr-h4" id="text-legend-requestIPFormPanel">
              
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
      <Input 
        label=""
        disabled
        
        
        
        
        hintText=""
        nativeInputProps={{
        ...getRegisterProps("inRequestType", { 
        }),
        type:"text",
        placeholder: "",
        maxLength: 100
        }}
      />
      <Input 
        label=""
        disabled
        
        
        
        
        hintText=""
        nativeInputProps={{
        ...getRegisterProps("inRequestId", { 
        }),
        type:"text",
        placeholder: "",
        maxLength: 100
        }}
      />
      <Input 
        label=""
        disabled
        
        
        
        
        hintText=""
        nativeInputProps={{
        ...getRegisterProps("inRequestUser", { 
        }),
        type:"text",
        placeholder: "",
        maxLength: 100
        }}
      />
       <Select
          label=""
          hint="" 
          
          nativeSelectProps={{
            defaultValue: "",
            ...register("inRequestStatus"),
            // Start of user code e0750504a37203d30cd633bc6cb89818
            // End of user code
          }}
          state={errors.inRequestStatus ? "error" : dirtyFields.inRequestStatus ? "success" : "info"}
             stateRelatedMessage={
             errors.inRequestStatus?.message ||
             (dirtyFields.inRequestStatus ? "Le champ est valide" : "Veuillez saisir le champ")
          }
       >
       <option value="">Selectionnez une option</option>
       <option value="DE">Déposée</option>
       <option value="ET">En cours</option>
       <option value="AC">Acceptée</option>
       <option value="TE">Traitée</option>
       <option value="RE">Rejetée</option>
       <option value="AN">Annulée</option>
      </Select>
      <p/><Button type="submit">Valider</Button>
          </div> {/* writeCloseForm */}
        </fieldset>
      </form>
      </div>
      </modal.Component>
      )}  
         
      </div>
      <div className="fr-col">
      </div></div>
      <Accordion 
        label="Liste des demandes finalisées"
      >
      <Table 
        fixed
        colorVariant="green-archipel"
        caption="Liste des demandes finalisées"
        data={
            data_requestFinalizedTable
          }
      headers={[
      "Type de demande",
      "Identifiant de la démarche",
      "Motif de la demande",
      "Statut de la demande",
      ]}/>
      </Accordion>
      </div>
    </>
  );
}
