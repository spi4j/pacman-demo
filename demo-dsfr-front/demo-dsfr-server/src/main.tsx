import "./api/overrideApiClient";
import React, { StrictMode } from "react";
import ReactDOM from "react-dom/client";
import dsfrConfig from "../dsfr.config.ts";
import App from './App.tsx';

import { AuthProvider } from "./contexts/AuthContext";
import { startReactDsfr } from "@codegouvfr/react-dsfr/spa";
import "@gouvfr/dsfr/dist/dsfr.min.css";
import "@gouvfr/dsfr/dist/utility/utility.min.css";
import "@gouvfr/dsfr/dist/utility/icons/icons.min.css";

// Initialisation DSFR
startReactDsfr({
  defaultColorScheme: "system",
  defaultLanguage: "fr",
   ...dsfrConfig,
});

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <AuthProvider>
      <App />
    </AuthProvider>
  </React.StrictMode>,
)
