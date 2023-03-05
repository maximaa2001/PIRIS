import { ICreditMiniData, IDepositMiniData } from '../../model/model'
import s from '../clientData/ClientData.module.css'
import { FC } from 'react'

interface IData {
    credit : ICreditMiniData
}


export const CreditData : FC<IData> = ({credit}) => {

    return(
        <div className={s.wrapper}>
            <div className={s.nameWrapper}>
                <span>{credit.id}</span>
                <span>{credit.creditName}</span>
                <span>{credit.sum}</span>
                <span>{credit.percent}</span>
            </div>
        </div>
    )

}