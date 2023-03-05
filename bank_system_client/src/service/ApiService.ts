import axios from "axios";
import { IClientData, IClientsMiniData, ICreditsMiniData, IDepositMiniData, IDepositsMiniData, IRef } from "../model/model";



export async function getClientRefs() {
    try{
        return (await axios.get<IRef>("http://localhost:8100/client/ref"))
    } catch(err) {
        console.error(err)
    } 
}

export async function getDepositRefs() {
    try{
        return (await axios.get("http://localhost:8100/deposit/ref"))
    } catch(err) {
        console.error(err)
    } 
}

export async function getCreditRefs() {
    try{
        return (await axios.get("http://localhost:8100/credit/ref"))
    } catch(err) {
        console.error(err)
    } 
}

export async function getDeposits() {
    return (await axios.get<IDepositsMiniData>("http://localhost:8100/deposits")).data
}

export async function getCredits() {
    return (await axios.get<ICreditsMiniData>("http://localhost:8100/credits")).data
}


export async function createDeposit(data) {
    return (await axios.post<IRef>("http://localhost:8100/deposit", data)).data
}

export async function createCredit(data) {
    return (await axios.post<IRef>("http://localhost:8100/credit", data)).data

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