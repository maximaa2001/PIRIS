import axios from "axios";
import { IRef } from "../model/model";



export async function getRefs() {
    try{
        return (await axios.get<IRef>("http://localhost:8100/refs"))
    } catch(err) {
        console.error(err)
    } 
}