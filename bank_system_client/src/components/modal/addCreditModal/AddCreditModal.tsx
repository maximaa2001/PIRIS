import { Modal } from "../Modal"
import { FC } from "react"
import { AddCreditForm } from "../../form/addCredit/AddCreditForm";

interface IAddCreditModal {
    closeModal : () => void;
}


export const AddCreditModal : FC<IAddCreditModal> = ({closeModal}) => {
    return(
        <Modal onClose={closeModal}>
            <AddCreditForm/>
        </Modal>
    )
}