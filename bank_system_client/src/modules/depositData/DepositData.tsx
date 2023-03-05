import { IDepositMiniData } from '../../model/model'
import s from '../clientData/ClientData.module.css'
import { FC } from 'react'

interface IData {
    deposit : IDepositMiniData
}


export const DepositData : FC<IData> = ({deposit}) => {


    return(
        <div className={s.wrapper}>
            
            <div className={s.nameWrapper}>
                <span>{deposit.id}</span>
                <span>{deposit.depositName}</span>
                <span>{deposit.sum}</span>
                <span>{deposit.percent}</span>
            </div>
        </div>
    )

}