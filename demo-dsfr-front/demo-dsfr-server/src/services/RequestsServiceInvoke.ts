import {API_BASE_URL} from "../config";
import axios from "axios";

export async function setRequest(userId) {
  const { data } = await apiClient.post(`v0/requests/${requestIn}`);
  return data;
}
export async function getRequest(userId) {
  const { data } = await apiClient.get(`v0/requests/${id}`);
  return data;
}
export async function getRequests(userId) {
  const { data } = await apiClient.get(`v0/requests/`);
  return data;
}
export async function getUserRequests(userId) {
  const { data } = await apiClient.get(`v0/requests/${userId}`);
  return data;
}
