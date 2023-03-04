import { Modal } from "../Modal"
import { FC } from "react"
import { AddDepositForm } from "../../form/addDeposit/AddDepositForm";

interface IAddDepositModal {
    closeModal : () => void;
}


export const AddDepositModal : FC<IAddDepositModal> = ({closeModal}) => {
    return(
        <Modal onClose={closeModal}>
            <AddDepositForm/>
        </Modal>
    )
}