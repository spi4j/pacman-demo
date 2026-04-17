import React from "react";
import { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";
import { Link } from "react-router-dom";
import { Notice } from "@codegouvfr/react-dsfr/Notice";
import mainImg from"../assets/imgs/administratives-demarches-accelerer-comment-vos-1024x569.jpg";

// Start of user code 32057e52ef1598fbfe311a3bb0db3051
// End of user code

export default function MainPanel () {
  
  // --------------------------------
  // Gestion générique de la sécurité.
  // --------------------------------
  const { login, user, logout } = useAuth();
  
  
  // Start of user code a48b45c85fb5d20d1ae2acec0aa1881a
  // End of user code
  
  return (
    <>
        
        
      <Notice
        description="Notre site fera  l'objet d'une opération de maintenance afin d'améliorer ses performances et d'assurer un meilleur service. L'accès à certaines fonctionnalités peut être temporairement interrompu. Nous mettons tout en œuvre pour rétablir l’ensemble des services dans les plus brefs délais. Merci de votre compréhension et de votre patience."
        iconDisplayed
        
        onClose={function noRefCheck(){}}
        severity="witness"
        title="Attention, maintenance prévue Vendredi prochain de 15h00 à 15h30."
      /><p/>
      <h3>Bienvenue sur le site officiel <br/>de centralisation des démarches administratives</h3>
      <img
        src={mainImg}
        alt="Image de la page d'accueil avc un exemple des différents documents pouvant être gérés pas le biais du site."
        className="fr-responsive-img"
      /><p/>
         
      La mise à disposition d’un site unique pour l’ensemble des démarches administratives locales constitue un levier essentiel de modernisation du service public.<p/>
      Ce portail centralisé permet aux usagers d’effectuer leurs démarches en ligne à tout moment, depuis un espace sécurisé et accessible.
      Il simplifie la relation entre les citoyens et l’administration en regroupant, en un seul lieu, les services relatifs à la vie quotidienne : état civil, urbanisme, scolarité, emploi, ou encore logement.<p/>
      Grâce à une navigation claire et à des formulaires dématérialisés, le traitement des demandes devient plus rapide et plus fiable.
      Les agents municipaux disposent ainsi d’outils mieux adaptés pour accompagner les usagers et suivre l’avancement des dossiers.
      Cette approche renforce la transparence, réduit les déplacements et contribue à une gestion plus durable des ressources publiques.<p/>
      Enfin, en favorisant l’autonomie numérique de chacun, le portail local en ligne s’inscrit dans une démarche de proximité et de confiance entre l’administration et les citoyens.
    </>
  );
}
