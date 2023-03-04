import axios from "axios";
import { ICreateClientData, IRef } from "../model/model";



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

export async function createClient(data : ICreateClientData) {
    return (await axios.post<IRef>("http://localhost:8100/client", data)).data
}

export async function createDeposit(data ) {
    return (await axios.post<IRef>("http://localhost:8100/deposit", data)).data
}