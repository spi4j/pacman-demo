import Keycloak from "keycloak-js";

const keycloak =
  (window as any).__keycloak_instance ||
  ((window as any).__keycloak_instance = new Keycloak({
    url: "http://localhost:8085",
    realm: "pacman-demo-realm",
    clientId: "pacman-demo-id",
  }));

export default keycloak;