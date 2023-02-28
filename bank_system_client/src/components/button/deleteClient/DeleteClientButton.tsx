import { Button } from "../Button"
import { FC } from "react"
import { deleteClient } from "../../../service/ApiService"

interface IDeleteClientButton {
    clientId : number
}

export const DeleteClientButton : FC<IDeleteClientButton> = ({clientId}) => {

    const handle = () => {
        deleteClient(clientId)
        .catch(err => {
            console.error(err)
        })
    }

    return(
        <Button onClick={handle} type={"deleteClientButton"}>
            Delete client
        </Button>
    )
}