import axios from "axios";
import { IRef } from "../model/model";

export async function getRefs() {
    const response = axios.get<IRef>("http://localhost:8100/refs")
    console.log((await response).data)
}