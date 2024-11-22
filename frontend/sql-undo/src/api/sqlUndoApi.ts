import apiClient from "../services/apiClient";
import Query from "../models/query";
import Script from "../models/script";

export const revertScript = async (script: Script): Promise<Query[]> => {
	const response = await apiClient.post("sql-undo", script);

	return response.data;
}