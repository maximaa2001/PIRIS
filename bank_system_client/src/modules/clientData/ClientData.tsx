import { IClientMiniData } from '../../model/model'
import s from './ClientData.module.css'
import { FC } from 'react'
import { DeleteClientButton } from '../../components/button/deleteClient/DeleteClientButton'
import { UpdateClientButton } from '../../components/button/updateButton/UpdateClientButton'

interface IData {
    client : IClientMiniData
    openModal : () => void
}


export const ClientData : FC<IData> = ({client, openModal}) => {

    return(
        <div className={s.wrapper}>
            <div className={s.nameWrapper}>
                <span>{client.surname}</span>
                <span>{client.name}</span>
                <span>{client.lastName}</span>
            </div>
            <div className={s.passportWrapper}>
                <span>{client.partPassport}</span>
                <span>{client.numberPassport}</span>
            </div>
            <DeleteClientButton clientId={client.id}/>
            <UpdateClientButton openModal={openModal} clientId={client.id}/>
        </div>
    )

}