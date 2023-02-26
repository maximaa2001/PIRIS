import { AddClientButton } from "../components/button/addClient/AddClientButton"
import { AddClientModal } from "../components/modal/addClientModal/AddClientModal"
import { useModal } from "../hooks/useModal"
import s from './style/ClientsPage.module.css'

export const ClientsPage =() =>  {
    const {isModal, openModal, closeModal} = useModal()

    return(
        <section className={s.container}>
            <AddClientButton openModal={openModal}/>
            {isModal && <AddClientModal closeModal={closeModal}/>}
        </section>
    )
}