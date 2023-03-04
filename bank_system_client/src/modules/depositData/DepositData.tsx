import { IDepositMiniData } from '../../model/model'
import s from '../clientData/ClientData.module.css'
import { FC } from 'react'

interface IData {
    deposit : IDepositMiniData
}


export const DeposiatData : FC<IData> = ({deposit}) => {

    return(
        <div className={s.wrapper}>
            <div className={s.nameWrapper}>
                <span>{deposit.id}</span>
                <span>{deposit.sum}</span>
                <span>{deposit.persent}</span>
            </div>
        </div>
    )

}