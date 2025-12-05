import {API_BASE_URL} from "../config";
import axios from "axios";

export async function setUser(userId) {
  const { data } = await apiClient.post(`v0/users/${userIn}`);
  return data;
}
export async function getUser(userId) {
  const { data } = await apiClient.get(`v0/users/${id}`);
  return data;
}
