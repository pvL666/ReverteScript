import { Script } from "../models/script";
import apiClient from "../services/apiClient";

export const undoScript = async (script: Script): Promise<string> => {
    const response = await apiClient.post("sql-undo", script);

    return response.data;
}