import { FC } from "react"
import s from './Button.module.css'
import cn from 'classnames'

interface IButton {
    onClick : () => void;
    type : string;
    children: React.ReactNode;
} 

export const Button : FC<IButton>= ({ onClick, type,  children}) => {
    return(
        <button className={cn(s.button, {[s.addClientButton] : type === 'addClientButton'},
         {[s.deleteClientButton] : type === 'deleteClientButton'},
         {[s.updateClientButton] : type === 'updateClientButton'})} onClick={onClick}>
           {children}
        </button>
        )
}