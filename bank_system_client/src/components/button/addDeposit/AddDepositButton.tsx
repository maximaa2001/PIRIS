import { Button } from "../Button"
import { FC } from "react"

interface IAddDepositButton {
    openModal : () => void;
}

export const AddDepositButton : FC<IAddDepositButton> = ({openModal}) => {

    const addDepositHandler = () => {
        openModal()
    }

    return(
        <Button onClick={addDepositHandler} type={"addButton"}>
            Add new deposit
        </Button>
    )
}