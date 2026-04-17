import { useState } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import ProtectedRoutes from "./security/ProtectedRoutes";
import { useLocation } from "react-router-dom";
import ConnectionPanel from "./pages/ConnectionPanel";
import ConnectionSelectPanel from "./pages/ConnectionSelectPanel";
import _Footer from "./pages/FooterPanel";
      
import _Header from "./pages/HeaderPanel";
import ProfilPanel from "./pages/ProfilPanel";
import RequestForm from "./pages/RequestForm";
import MainPanel from "./pages/MainPanel";
import RequestsListPanel from "./pages/RequestsListPanel";
import RequestFollowPanel from "./pages/RequestFollowPanel";
import AvailableRequestsPanel from "./pages/AvailableRequestsPanel";
import CniPanel from "./pages/CniPanel";
import RegisterPanel from "./pages/RegisterPanel";
import PassportPanel from "./pages/PassportPanel";
import LicenceDrivePanel from "./pages/LicenceDrivePanel";
import SearchResultsPanel from "./pages/SearchResultsPanel";
import DisconnectPanel from "./pages/DisconnectPanel";
import AdminPanel from "./pages/AdminPanel";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";

function Layout({ children }: { children: React.ReactNode }) {
   const location = useLocation();
   const noLayoutRoutes = ["/fdfs"]; 
   const hideLayout = noLayoutRoutes.includes(location.pathname);
   return (
   <>
   {!hideLayout && <_Header/>}
      <div className="fr-container form-page"> {children} </div>
   {!hideLayout && <_Footer/>}
   </>
  );
}

function App() {
  return (
    <Router>
      <Layout>
      <Routes>  
        <Route path="/goToInternalConnexion" element={< ConnectionPanel />}/>
        <Route path="/goToConnexion" element={< ConnectionSelectPanel />}/>
        // Double l'url pour une url fixe en provenance de AuthContext.tsx
        <Route path="/login" element={< ConnectionSelectPanel />}/>
        <Route path="/goToReconnect" element={< ConnectionSelectPanel />}/>
        <Route element={<ProtectedRoutes roles={["user", "admin"]} />}>
          <Route path="/goToProfil" element={< ProfilPanel />}/>
        </Route>
        <Route element={<ProtectedRoutes roles={["user"]} />}>
          <Route path="/goToNewRequest" element={< RequestForm />}/>
        </Route>
        <Route path="/" element={< MainPanel />}/>
        <Route element={<ProtectedRoutes roles={["user"]} />}>
          <Route path="/gotToListRequest" element={< RequestsListPanel />}/>
        </Route>
        <Route element={<ProtectedRoutes roles={["user"]} />}>
          <Route path="/goToFollowRequest" element={< RequestFollowPanel />}/>
        </Route>
        <Route path="/gotToAvailableRequests" element={< AvailableRequestsPanel />}/>
        <Route path="/gotToAvailableRequests" element={< AvailableRequestsPanel />}/>
        <Route path="/gotToAvailableRequests" element={< AvailableRequestsPanel />}/>
        <Route path="/gotToAvailableRequests" element={< AvailableRequestsPanel />}/>
        <Route path="/goToCni" element={< CniPanel />}/>
        <Route path="/goToRegister" element={< RegisterPanel />}/>
        <Route path="/goToRegister" element={< RegisterPanel />}/>
        <Route path="/gotToPassword" element={< PassportPanel />}/>
        <Route path="/gotToLicenceDrive" element={< LicenceDrivePanel />}/>
        <Route path="/gotToSearchPanel" element={< SearchResultsPanel />}/>
        <Route path="/goToDisconnect" element={< DisconnectPanel />}/>
        <Route element={<ProtectedRoutes roles={["admin"]} />}>
          <Route path="/goToAdmin" element={< AdminPanel />}/>
        </Route>
      </Routes>
      </Layout>
    </Router>
  );
}
export default App
