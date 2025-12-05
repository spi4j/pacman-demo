import React from "react";
import { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";
import { headerFooterDisplayItem } from "@codegouvfr/react-dsfr/Display";
import { Footer } from "@codegouvfr/react-dsfr/Footer";
import opLogo from "../assets/imgs/logo.png";

// Start of user code dc81cd04f0dd0432929066eacc434a3f
// End of user code

export default function FooterPanel () {
  
  // --------------------------------
  // Gestion générique de la sécurité.
  // --------------------------------
  const { login, user, logout } = useAuth();
  
  
  // Start of user code c557bee29cef6409e3dc0801b21707e4
  // End of user code
  
  return (
    <>
         
        <Footer
          accessibility="fully compliant"
          contentDescription="Service Public vous informe et vous oriente vers les services qui permettent de connaître vos obligations, d’exercer vos droits et de faire vos démarches du quotidien. Il est édité par la Direction de l’information légale et administrative  et réalisé en partenariat avec les administrations nationales et locales."
          operatorLogo={{
            alt: "",
            imgUrl: opLogo,
            orientation: "horizontal"
          }}
          bottomItems={[
            headerFooterDisplayItem
          ]}
          termsLinkProps={{
            href: "#"
          }}
          websiteMapLinkProps={{
            href: "#"
          }}
        />
    </>
  );
}
