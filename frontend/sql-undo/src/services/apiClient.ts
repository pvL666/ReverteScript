import axios, { AxiosInstance } from "axios";

const apiClient: AxiosInstance = axios.create({
    baseURL: "http://192.168.0.4:8383"
});

export default apiClient;