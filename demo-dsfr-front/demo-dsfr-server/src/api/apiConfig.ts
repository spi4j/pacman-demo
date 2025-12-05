import axios from "axios";

export const apiConfig = axios.create({
    baseURL: "http://localhost:8081",
    headers: {
        "Content-Type": "application/json",
      },
});