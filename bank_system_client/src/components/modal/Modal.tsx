import { FC } from 'react'
import s from './Modal.module.css'

interface IModal {
    onClose : () => void;
    children: React.ReactNode;
}

export const Modal : FC<IModal> = ({onClose, children}) => {
    return(
        <>
        <div className={s.wrapper} onClick={onClose}></div>
        <div className={s.main}>{children}</div>
        </>
    )
}