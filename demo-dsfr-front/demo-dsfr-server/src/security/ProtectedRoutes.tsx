import React from "react";
import { Navigate, Outlet } from "react-router-dom";
import { useAuth } from "../contexts/AuthContext";

// --------------------------------------
// Liste des rôles autorisés (facultatif)
// --------------------------------------
type ProtectedRoutesProps = {
  roles?: string[]; 
};

/**
 * Ce composant protège les routes selon l'état de connexion et les rôles.
 * - Si aucun utilisateur n'est connecté → redirection vers /login
 * - Si roles[] est défini → vérifie que l'utilisateur a au moins un des rôles
 * - Sinon → laisse passer
 */
export default function ProtectedRoutes({ roles }: ProtectedRoutesProps) {

  const { user, hasRole, loading } = useAuth();
  
  if (loading) {
    return <div>Chargement...</div>; // ou un spinner DSFR
  }

  // -----------------------------------
  // Pas connecté → redirige vers login
  // -----------------------------------
  if (!user) {
    return <Navigate to="/login" replace />;
  }
  
  // -------------------------------
  // Vérifie les rôles si nécessaire
  // -------------------------------
  if (roles && roles.length > 0 && !roles.some((r) => hasRole(r))) {
    return <Navigate to="/unauthorized" replace />;
  }

  // ----------------------------
  // Laisse passer si tout est OK
  // ----------------------------
  return <Outlet />;
}
