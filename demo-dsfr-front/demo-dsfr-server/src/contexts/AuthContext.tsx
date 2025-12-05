import React, { createContext, useContext, useState, useEffect } from "react";

type User = {
  username: string;
  roles: string[];
};

type AuthContextType = {
  user: User | null;
  loading: boolean;
  login: (username: string, password: string) => Promise<boolean>;
  logout: () => void;
  hasRole: (role: string) => boolean;
};

const AuthContext = createContext<AuthContextType | undefined>(undefined);

export const AuthProvider: React.FC<{ children: React.ReactNode }> = ({ children }) => {

  const [user, setUser] = useState<User | null>(null);
  const [loading, setLoading] = useState(true);
  
  // --------------------------------------------
  // Rechargement automatique depuis localStorage
  // --------------------------------------------
  useEffect(() => {
    const storedUser = localStorage.getItem("user");
    if (storedUser) {
      setUser(JSON.parse(storedUser));
    }
    setLoading(false);
  }, []);

  // ----------------------------------------
  // Persistance automatique de l’utilisateur
  // ----------------------------------------
  useEffect(() => {
    if (user) localStorage.setItem("user", JSON.stringify(user));
    else localStorage.removeItem("user");
  }, [user]);

  // -------------------------------
  // Connexion (fake pour l’instant)
  // -------------------------------
  async function login(username: string, password: string): Promise<boolean> {
    console.log("Tentative de connexion :", username, password);

    if (username === "12345" && password === "azerty") {
      console.log("Utilisateur connecté :", { username });
      setUser({ username, roles: ["user"] });
      return true;
    }

    if (username === "admin" && password === "admin") {
      console.log("Administrateur connecté :", { username });
      setUser({ username, roles: ["admin"] });
      return true;
    }
    console.log("Authentification échouée");
    return false;
  }
  
  // -----------
  // Déconnexion
  // -----------
  function logout() {
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
// Hook pour simplifier l’accès au contexte
// ----------------------------------------
export function useAuth(): AuthContextType {
  const context = useContext(AuthContext);
  if (!context) throw new Error("useAuth must be used within AuthProvider");
  return context;
}
