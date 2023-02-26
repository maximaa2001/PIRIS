import { FC } from 'react';
import s from './Input.module.css'

interface IInput {
    placeholder : string;
    onChange : (IntrinsicAttributes) => void;
}

export const Input : FC<IInput> = ({placeholder, onChange}) => {
    return(
        <input className={s.input} placeholder={placeholder} onChange={onChange}/>
    )
}