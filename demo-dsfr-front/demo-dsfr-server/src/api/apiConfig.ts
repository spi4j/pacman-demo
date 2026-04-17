import axios from "axios";

export const apiConfig = {
  baseURL: "http://localhost:8081",
  headers: {
    "Content-Type": "application/json",
  },
  timeout: 15000,
};