import React from "react";
import { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";
import { Link } from "react-router-dom";
import { Highlight } from "@codegouvfr/react-dsfr/Highlight";
import { Tile } from "@codegouvfr/react-dsfr/Tile";

// Start of user code 51e3c026b2c02569acbcba43ca3e9973
// End of user code

export default function AvailableRequestsPanel () {
  
  // --------------------------------
  // Gestion générique de la sécurité.
  // --------------------------------
  const { login, user, logout } = useAuth();
  
  
  
  // Start of user code a1f9c94255f51e4bd2425a52f9a508b8
  // End of user code
  
  return (
    <>
        
        
      <p className="fr-text--lg fr-text--bold">Liste des démarches disponibles sur le site</p>
            <p>
              Sur notre site, vous pouvez effectuer l’ensemble de vos démarches administratives locales de manière simple et sécurisée.
            </p>
            <p>Cela comprend :</p>
            <ul>
              <li>Les demandes liées à l’état civil (actes de naissance, de mariage, de décès)</li>
              <li>Les documents officiels comme les cartes d’identité, les passeports ou les titres de séjour</li>
              <li>Les inscriptions scolaire et périscolaire</li>
              <li>Les démarches relatives au logement et à l’urbanisme (certificats, autorisations de construire, déclarations préalables)</li>
              <li>Accéder aux services sociaux et d’accompagnement (aides financières, emploi, services aux personnes âgées ou en situation de handicap)</li>
              <li>Régler vos obligations fiscales locales et certaines factures ou redevances</li>
            </ul>
            <p>
              Le site permet aussi de signaler des incidents sur la voirie et de s’informer sur la culture, le sport et la vie associative.
            </p>
            <p>
              Chaque démarche est accompagnée d’instructions détaillées et d’outils de suivi pour faciliter la compréhension et le traitement rapide de vos demandes.
            </p>
      <Highlight>
        
        
        Notre objectif est de vous offrir un accès simplifié, sécurisé et centralisé à l’ensemble de vos démarches, quelles qu’elles soient. En quelques clics, vous pouvez initier, suivre et finaliser vos demandes, sans déplacement inutile et avec l’assurance d’un accompagnement clair à chaque étape.
      </Highlight>
      <h3>Fiches pratiques</h3>
      <div className="fr-grid-row fr-grid-row--gutters fr-grid-row--top">
      <div className="fr-col">
      <div
        className="container"
        style={{
          width: 300
        }}
      >
        <Tile
          detail="Demandez ou renouvelez facilement votre passeport en ligne."
          enlargeLinkOrButton
          imageSvg
          imageUrl="/dsfr/pictograms/passport.svg"
          linkProps={{
            href: "/gotToPassword"
          }}
          orientation="vertical"
          title="Passeport"
          titleAs="h3"
        />
      </div>
      </div>
      <div className="fr-col">
      <div
        className="container"
        style={{
          width: 300
        }}
      >
        <Tile
          detail="Effectuez votre demande de carte nationale d’identité."
          enlargeLinkOrButton
          imageSvg
          imageUrl="/dsfr/pictograms/national-identity-card.svg"
          linkProps={{
            href: "/goToCni"
          }}
          orientation="vertical"
          title="Carte d'identité"
          titleAs="h3"
        />
      </div>
      </div>
      <div className="fr-col">
      <div
        className="container"
        style={{
          width: 300
        }}
      >
        <Tile
          detail="Consultez, renouvelez ou échangez votre permis de conduire."
          enlargeLinkOrButton
          imageSvg
          imageUrl="/dsfr/pictograms/driving-licence.svg"
          linkProps={{
            href: "/gotToLicenceDrive"
          }}
          orientation="vertical"
          title="Permis de conduire"
          titleAs="h3"
        />
      </div>
      </div></div>
      <div className="fr-grid-row fr-grid-row--gutters fr-grid-row--top">
      <div className="fr-col">
      <div
        className="container"
        style={{
          width: 300
        }}
      >
        <Tile
          detail="Achetez vos timbres fiscaux en quelques clics."
          enlargeLinkOrButton
          imageSvg
          imageUrl="/dsfr/pictograms/tax-stamp.svg"
          linkProps={{
            href: "/#"
          }}
          orientation="vertical"
          title="Timbres fiscaux"
          titleAs="h3"
        />
      </div>
      </div>
      <div className="fr-col">
      <div
        className="container"
        style={{
          width: 300
        }}
      >
        <Tile
          detail="Déclarez un changement de propriétaire ou d’adresse."
          enlargeLinkOrButton
          imageSvg
          imageUrl="/dsfr/pictograms/vehicle-registration.svg"
          linkProps={{
            href: "/#"
          }}
          orientation="vertical"
          title="Carte grise"
          titleAs="h3"
        />
      </div>
      </div>
      <div className="fr-col">
      <div
        className="container"
        style={{
          width: 300
        }}
      >
        <Tile
          detail="Inscrivez-vous sur les listes ou mettez à jour votre carte électorale."
          enlargeLinkOrButton
          imageSvg
          imageUrl="/dsfr/pictograms/national-identity-card.svg"
          linkProps={{
            href: "/#"
          }}
          orientation="vertical"
          title="Carte électorale"
          titleAs="h3"
        />
      </div>
      </div></div>
    </>
  );
}
