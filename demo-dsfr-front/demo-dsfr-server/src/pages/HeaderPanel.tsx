import React from "react";
import { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";
import { headerFooterDisplayItem } from "@codegouvfr/react-dsfr/Display";
import { Header } from "@codegouvfr/react-dsfr/Header";
import { Link } from "react-router-dom";
import { MainNavigation } from "@codegouvfr/react-dsfr/MainNavigation";
import { SearchBar } from "@codegouvfr/react-dsfr/SearchBar";
import opLogo from "../assets/imgs/logo.png";

// Start of user code 258d49857d873964a270e9f16d42ed3b
// End of user code

export default function HeaderPanel () {
  
  // --------------------------------
  // Gestion générique de la sécurité.
  // --------------------------------
  const { login, user, logout } = useAuth();
  
  // -----------------------------------
  // Gestion centralisée de la recherche. 
  // -----------------------------------
  const [searchTerm, setSearchTerm] = useState("");
  const navigate = useNavigate();
  const location = useLocation();
  
  const handleSearch = () => {
    if (!searchTerm.trim()) return;
    console.log("Recherche effectuée :", searchTerm);
    navigate(`/#?q=${encodeURIComponent(searchTerm)}`);
  };
  
  // Start of user code 81ff458cc35f5f2bacf011b54169477c
  // End of user code
  
  return (
    <>
      <Header
        allowEmptySearch
        clearSearchInputOnSearch
        brandTop={<>REPUBLIQUE<br/>FRANCAISE</>}
        homeLinkProps={{
        href: "/",
        title: "Site des démarches administratives locales"
      }}
      id="headerPanel"
      serviceTagline="Simplifiez vos démarches avec toutes les administrations à portée de clic !"
      serviceTitle="Démarches administratives"
      operatorLogo={{
        alt: "",
        imgUrl: opLogo,
        orientation: "horizontal"
      }}
      onSearchButtonClick={function noRefCheck(){}}
      navigation={[
        {  
           isActive: location.pathname === "/",
           linkProps: {
             href: "/"
           },
           text: "Accueil"
         },
       
        {  
           isActive: location.pathname === "/gotToAvailableRequests",
           linkProps: {
             href: "/gotToAvailableRequests"
           },
           text: "Démarches disponibles"
         },
       
      ...(user && ["admin"]
          .some(role => user.roles?.includes(role)) ? [
        {  
           isActive: location.pathname === "/goToAdmin",
           linkProps: {
             href: "/goToAdmin"
           },
           text: "Administration"
         },
       ] : []),
      
       ...(user && ["user"]
           .some(role => user.roles?.includes(role)) ? [
       {
         isActive: ["/goToNewRequest","/gotToListRequest","/goToFollowRequest",].includes(location.pathname),
         menuLinks: [
         ...(user && ["user"]
             .some(role => user.roles?.includes(role)) ? [
           {
             linkProps: {
             href: "goToNewRequest"
           },
           isActive: location.pathname === "/goToNewRequest",
           text: "Faire une demande"
         },
         ] : []),
         ...(user && ["user"]
             .some(role => user.roles?.includes(role)) ? [
           {
             linkProps: {
             href: "gotToListRequest"
           },
           isActive: location.pathname === "/gotToListRequest",
           text: "Lister mes demandes"
         },
         ] : []),
         ...(user && ["user"]
             .some(role => user.roles?.includes(role)) ? [
           {
             linkProps: {
             href: "goToFollowRequest"
           },
           isActive: location.pathname === "/goToFollowRequest",
           text: "Suivre une demande"
         },
         ] : []),
         ],
         text: "Mes démarches"
       },
       ] : []),
       ...(user && ["user", "admin"]
           .some(role => user.roles?.includes(role)) ? [
       {
         isActive: ["/goToProfil","/goToDisconnect",].includes(location.pathname),
         menuLinks: [
         ...(user && ["user", "admin"]
             .some(role => user.roles?.includes(role)) ? [
           {
             linkProps: {
             href: "goToProfil"
           },
           isActive: location.pathname === "/goToProfil",
           text: "Mes informations"
         },
         ] : []),
           {
             linkProps: {
             href: "goToDisconnect"
           },
           isActive: location.pathname === "/goToDisconnect",
           text: "Deconnexion"
         },
         ],
         text: "Mon compte"
       },
       ] : []),
       
      ]}
         quickAccessItems={[
         {
           iconId: "fr-icon-lock-line",
           linkProps: {
             href: "/goToConnexion"
           },
         text: "Se connecter"
         },
         {
           iconId: "fr-icon-user-add-line",
           linkProps: {
             href: "/goToRegister"
           },
         text: "S'enregistrer"
         },
         headerFooterDisplayItem
         ]}
      />
    </>
  );
}
