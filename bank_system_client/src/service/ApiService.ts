import axios from "axios";
import { ICreateClientData, IRef } from "../model/model";



export async function getRefs() {
    try{
        return (await axios.get<IRef>("http://localhost:8100/refs"))
    } catch(err) {
        console.error(err)
    } 
}

export async function createClient(data : ICreateClientData) {
    return (await axios.post<IRef>("http://localhost:8100/client", data)).data
   
}