import axios from "axios";
import { IClientData, IClientsMiniData, IRef } from "../model/model";



export async function getRefs() {
    try{
        return (await axios.get<IRef>("http://localhost:8100/refs"))
    } catch(err) {
        console.error(err)
    } 
}

export async function createClient(data : IClientData) {
    return (await axios.post("http://localhost:8100/client", data)).data
}

export async function getClients() {
    return (await axios.get<IClientsMiniData>("http://localhost:8100/clients")).data
}

export async function getClient(id : number) {
    return (await axios.get<IClientData>("http://localhost:8100/client" + "?id=" + id)).data
}

export async function deleteClient(id : number) {
    return (await axios.delete("http://localhost:8100/client" + "?id=" + id)).data
}

export async function updateClient(data : IClientData) {
    return (await axios.put("http://localhost:8100/client", data)).data
}