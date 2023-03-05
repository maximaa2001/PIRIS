import { useModal } from "../hooks/useModal"
import s from './style/ClientsPage.module.css'
import { useEffect, useState } from "react"
import { ICreditMiniData, ICreditsMiniData, IDepositMiniData } from "../model/model"
import { getCredits } from "../service/ApiService"
import { AddCreditButton } from "../components/button/addCredit/AddCreditButton"
import { CreditData } from "../modules/creditData/CreditData"
import { AddCreditModal } from "../components/modal/addCreditModal/AddCreditModal"

export const CreditsPage =() =>  {
    const {isModal, openModal, closeModal} = useModal()

    const [credits, setCredits] = useState<ICreditMiniData[]>([])

    useEffect(() => {
        getCredits().then(res =>setCredits(res.credits))
    }, [])

    return(
        <section className={s.container}>
             <AddCreditButton openModal={openModal}/>
             <div className={s.dataWrapper}>
                {credits.map((item : ICreditMiniData) => (
                    <CreditData key={item.id} credit={item}/>
                ))}
            </div>
             {isModal && <AddCreditModal closeModal={closeModal}/>}
        </section>
    )
}