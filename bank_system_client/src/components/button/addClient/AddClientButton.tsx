import { Button } from "../Button"
import { FC } from "react"

interface IAddClientButton {
    openModal : () => void;
}

export const AddClientButton : FC<IAddClientButton> = ({openModal}) => {

    const addClientHandler = () => {
        openModal()
    }

    return(
        <Button onClick={addClientHandler} type={"addButton"}>
            Add new client
        </Button>
    )
}