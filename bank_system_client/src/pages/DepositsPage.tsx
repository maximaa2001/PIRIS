import { AddDepositButton } from "../components/button/addDeposit/AddDepositButton"
import { AddDepositModal } from "../components/modal/addDepositModal/AddDepositModal"
import { useModal } from "../hooks/useModal"
import s from './style/ClientsPage.module.css'
import { useEffect, useState } from "react"
import { IDepositMiniData } from "../model/model"
import { getDeposits } from "../service/ApiService"
import { DepositData } from "../modules/depositData/DepositData"

export const DepositsPage =() =>  {
    const {isModal, openModal, closeModal} = useModal()

    const [deposits, setDeposits] = useState<IDepositMiniData[]>([])

    useEffect(() => {
        getDeposits().then(res =>setDeposits(res.deposits))
    }, [])

    return(
        <section className={s.container}>
             <AddDepositButton openModal={openModal}/>
             <div className={s.dataWrapper}>
                {deposits.map((item : IDepositMiniData) => (
                    <DepositData key={item.id} deposit={item}/>
                ))}
            </div>
             {isModal && <AddDepositModal closeModal={closeModal}/>}
        </section>
    )
}