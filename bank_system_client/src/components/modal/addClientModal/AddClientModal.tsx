import { Modal } from "../Modal"
import { FC } from "react"
import { AddClientForm } from "../../form/addClient/AddClientForm";

interface IAddClientModal {
    closeModal : () => void;
}


export const AddClientModal : FC<IAddClientModal> = ({closeModal}) => {
    return(
        <Modal onClose={closeModal}>
            <AddClientForm/>
        </Modal>
    )
}