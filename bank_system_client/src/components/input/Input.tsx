import { FC } from 'react';
import s from './Input.module.css'

interface IInput {
    placeholder : string;
    onChange : (IntrinsicAttributes) => void;
    onBlur? : (IntrinsicAttributes) => void;
    type : string
    name? : string;
    value? : string;
    checked? : boolean
}

export const Input : FC<IInput> = ({placeholder, onChange,onBlur, type, name, value, checked}) => {
    return(
        <input type={type} checked={checked} name={name} value={value} onBlur={onBlur} className={s.input} placeholder={placeholder} onChange={onChange}/>
    )
}