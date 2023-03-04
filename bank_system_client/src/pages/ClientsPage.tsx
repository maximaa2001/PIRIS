import { useEffect, useState, useContext } from "react"
import { AddClientButton } from "../components/button/addClient/AddClientButton"
import { AddClientModal } from "../components/modal/addClientModal/AddClientModal"
import { useModal } from "../hooks/useModal"
import { IClientMiniData } from "../model/model"
import s from './style/ClientsPage.module.css'
import { getClients } from "../service/ApiService"
import { ClientData } from "../modules/clientData/ClientData"
import { Context } from ".."

export const ClientsPage =() =>  {
    const {isModal, openModal, closeModal} = useModal()
    const [clients, setClients] = useState<IClientMiniData[]>([])

    const {globalStore} = useContext(Context)

    useEffect(() => {
        getClients().then(res =>setClients(res.clients))
    }, [])

    const closeAddModal = () => {
        closeModal()
        globalStore.setUpdatedId(null)
    }

    return(
        <section className={s.container}>
            <AddClientButton openModal={openModal}/>
            <div className={s.dataWrapper}>
                {clients.map((item : IClientMiniData) => (
                    <ClientData key={item.id} client={item} openModal={openModal}/>
                ))}
            </div>
            {isModal && <AddClientModal closeModal={closeAddModal}/>}
        </section>
    )
}