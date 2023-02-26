import { useState } from "react"
import { confirmModal } from "../util/util";


export const useModal = () => {
    const [isModal, setIsModal] = useState(false);

    const openModal = () =>{
        setIsModal(true)
    }

    const closeModal = () =>{
        const result = confirmModal();
        if(result) {
            setIsModal(false)
        }
    }

    return {isModal, openModal, closeModal}
}