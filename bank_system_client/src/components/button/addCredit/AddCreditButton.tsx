import { Button } from "../Button"
import { FC } from "react"

interface IAddDepositButton {
    openModal : () => void;
}

export const AddCreditButton : FC<IAddDepositButton> = ({openModal}) => {

    const addCreditHandler = () => {
        openModal()
    }

    return(
        <Button onClick={addCreditHandler} type={"addButton"}>
            Add new credit
        </Button>
    )
}