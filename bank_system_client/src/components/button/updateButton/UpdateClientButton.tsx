import { Button } from "../Button"
import { FC } from "react"
import { deleteClient } from "../../../service/ApiService"
import { IClientData } from "../../../model/model"
import { useContext } from "react"
import { Context } from "../../.."

interface IUpdateClientButton {
    openModal : () => void
    clientId : number
}

export const UpdateClientButton : FC<IUpdateClientButton> = ({openModal, clientId}) => {

    const {globalStore} = useContext(Context);

    const handle = () => {
        globalStore.setUpdatedId(clientId)
        openModal()
    }

    return(
        <Button onClick={handle} type={"updateButton"}>
            Update client
        </Button>
    )
}