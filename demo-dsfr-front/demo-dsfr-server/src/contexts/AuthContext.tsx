import React, { createContext, useContext, useState, useEffect } from "react";
import { apiClient } from "../api/apiClient";
import { users } from "../api/overrideApiClient";
import { UserDemo } from "demo-dsfr-client-rest";
import keycloak from "./Keycloak";
import { User } from "../types/User";

// Permet d'avoir une signature différente pour login (local/sso)
type LoginParams =
  | { type: "sso" }
  | { type: "local"; username: string; password: string };
  
type AuthContextType = {
  user: User | null;
  loading: boolean;
  login: (username: string, password: string) => Promise<boolean>;
  logout: () => void;
  hasRole: (role: string) => boolean;
};

let keycloakInitialized = false;
const AuthContext = createContext<AuthContextType | undefined>(undefined);

export const AuthProvider: React.FC<{ children: React.ReactNode }> = ({ children }) => {

  const [user, setUser] = useState<User | null>(null);
  const [loading, setLoading] = useState(true);
  
  // ---------------------------------------------
  // Affectation de l'utilisateur à partir du sso
  // ---------------------------------------------
  async function setUserFromKeycloak() {
  
    console.log("Passe dans setUserFromKeycloak...");
    console.log("TOKEN DECODE", keycloak.tokenParsed);
    const username = keycloak.tokenParsed?.preferred_username;
    if (!username) {
      console.log("Aucun username detecte, on sort de l'authentification");
      return;
    }
    const userData = await users.getUser("3");
    const roles = (keycloak.tokenParsed?.realm_access?.roles ?? [])
       .map(r => r.toLowerCase())
       .filter(r => ["admin", "user"]
       .includes(r));
  
    const user = {
      ...userData,
      roles,
    };
    console.log("ROLES NORMALISES", roles);
    console.log("USER FINAL", user);
    setUser(user);
    sessionStorage.setItem("user", JSON.stringify(user));
  }
  
  // ---------------------------------------------
  // Affectation de l'utilisateur à partir du local
  // ---------------------------------------------
  async function setUserFromLocal(role: string) {
  
    console.log("Passe dans setUserFromLocal...");
    //faux token compatible avec l'intercepteur (apiClient).
    const fakeKeycloakToken = "local.fake.token";
    console.log("faux jeton (pour connexion locale):", fakeKeycloakToken);
    sessionStorage.setItem("token", fakeKeycloakToken);
    
    const userData = await users.getUser("3");
    const user = {
      ...userData,
      roles: [role],
    };
    setUser(user);
    sessionStorage.setItem("user", JSON.stringify(user));
  }
  
  // --------------------------------------------
  // Initialisation environnement keycloak
  // --------------------------------------------
  useEffect(() => { 
    const initKeycloak = async () => {
    
      const savedMode = sessionStorage.getItem("authMode");
      if (savedMode === "local") {
        console.log("Mode local détecté → skip Keycloak");
        const storedUser = sessionStorage.getItem("user");
        if (storedUser) {
          setUser(JSON.parse(storedUser));
        }
        setLoading(false);
        return;
      }
    
      if (keycloakInitialized) return;
      keycloakInitialized = true;

      try {
        const authenticated = await keycloak.init({
          onLoad: "check-sso",
          pkceMethod: "S256",
          checkLoginIframe: false,
        });
        
        console.log("authenticated:", authenticated);
        console.log("jeton après init:", keycloak.token);

        if (authenticated && keycloak.token) {
          await keycloak.updateToken(30);
          console.log("jeton après update:", keycloak.token);
          await setUserFromKeycloak();
        } else {
          console.warn("Erreur initialisation keycloak:");
          sessionStorage.removeItem("user");
          setUser(null);
        }

      } catch (error) {
        console.warn("Keycloak silent SSO failed (normal if no session):", error);
        setUser(null);
      } finally {
        setLoading(false);
      }
    };

    initKeycloak();
  }, []);

  // -------------------------------
  // Connexion local/sso (keycloak)
  // -------------------------------
  async function login(params?: LoginParams): Promise<boolean> {
  
    if (params?.type === "local") {
      console.log("Tentative de connexion locale");
      sessionStorage.setItem("authMode", "local"); 
      if (params.username === "userdemo" 
        && params.password === "password") {
        await setUserFromLocal("user");
        return true;
      }
      if (params.username === "admindemo" 
        && params.password === "password") {
        await setUserFromLocal("admin");
        return true;
      }
      return false;
    } 
    
    else 
    {
      console.log("Tentative de connexion sso");
      sessionStorage.setItem("authMode", "sso"); 
      if (keycloak.authenticated === true) {
        console.log("SSO OK");
        await setUserFromKeycloak();
        return true;
      }
      console.log("Pas de session SSO active, routage sso");
      await keycloak.login();
      return false;
    }
  }
  
  // -----------
  // Déconnexion
  // -----------
  function logout() {
    const savedMode = sessionStorage.getItem("authMode");
    if (savedMode === "sso") {
      keycloak.logout({
        redirectUri: window.location.origin
      });
      keycloak.clearToken?.();
    }
    sessionStorage.removeItem("user");
    setUser(null);
  }
  
  // ----------------------
  // Vérification des rôles
  // ----------------------
  function hasRole(role: string): boolean {
    return user?.roles.includes(role) ?? false;
  }

  return (
    <AuthContext.Provider value={{ user, loading, login, logout, hasRole }}>
      {children}
    </AuthContext.Provider>
  );
};

// ----------------------------------------
// Hook pour simplifier l'accès au contexte
// ----------------------------------------
export function useAuth(): AuthContextType {
  const context = useContext(AuthContext);
  if (!context) throw new Error("useAuth must be used within AuthProvider");
  return context;
}
