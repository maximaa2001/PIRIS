import { AddDepositButton } from "../components/button/addDeposit/AddDepositButton"
import { AddDepositModal } from "../components/modal/addDepositModal/AddDepositModal"
import { useModal } from "../hooks/useModal"
import s from './style/ClientsPage.module.css'

export const DepositsPage =() =>  {
    const {isModal, openModal, closeModal} = useModal()

    return(
        <section className={s.container}>
             <AddDepositButton openModal={openModal}/>
             {isModal && <AddDepositModal closeModal={closeModal}/>}
        </section>
    )
}