import { Input } from '../../input/Input'
import s from './AddClientForm.module.css'
import React, { useEffect, useState } from 'react';
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import MaskedInput from 'react-text-mask'
import Select from 'react-select';
import { getRefs } from '../../../service/ApiService';
import { ICity, IDisability, IFamilyStatus, INationality } from '../../../model/model';
import { useFormilCreateClient } from '../../../hooks/useFormikCreateClient';
import { ICreateClientData } from "../../../model/model"

export const AddClientForm = () => {

    const [data, setData] = useState({
        surname : null,
        name : null,
        lastname : null,
        birthDay : new Date(),
        partPassport: null,
        numberPassport : null,
        sourcePassport : null,
        startDatePassport : new Date(),
        identidierNumber : null,
        placeBirth : null,
        cityLive : -1,
        address : null,
        homePhone : null,
        mobilePhone  : null,
        email : null,
        work : null,
        position  : null,
        cityRegistration : -1,
        familyStatus : -1,
        nationality : -1,
        disability : -1,
        isPensioner : false,
        salaryMonth : null
    })

    const [allCities, setAllCities] = useState([]);
    const [allFalimyStatuses, setAllFamilyStatuses] = useState([]);
    const [allNationalities, setAllNationalities] = useState([]);
    const [allDisabilities, setAllDisaboloties] = useState([]);

    const {
        touched,
        handleSubmit,
        errors,
        values,
        handleChange,
        handleBlur,
        isValid,
        // dirty,
    } = useFormilCreateClient(data)

    console.log(errors)
 
    


    useEffect(() => {
        getRefs().then(item => {
            setAllCities(item.data.cities.map(function(entry) {
                return {
                    label : entry.name,
                    value : entry.id
                }
            }))
            setAllFamilyStatuses(item.data.familyStatuses.map(function(entry) {
                return {
                    label : entry.name,
                    value : entry.id
                }
            }))
            setAllNationalities(item.data.nationalities.map(function(entry) {
                return {
                    label : entry.name,
                    value : entry.id
                }
            }))
            setAllDisaboloties(item.data.disabilities.map(function(entry) {
                return {
                    label : entry.name,
                    value : entry.id
                }
            }))
            
        })
    }, [])



    const submitHandler = (e : React.FormEvent) => {
        e.preventDefault();
        handleSubmit()
    }

    return(
        <form onSubmit={submitHandler}>
            <div className={s.container}>
                <Input placeholder='фамилия' onChange={e => setData(prev => ({...prev, surname: e.target.value}))}/>
                <Input placeholder='имя' onChange={e => setData(prev => ({...prev, name: e.target.value}))}/>
                <Input placeholder='отчество' onChange={e => setData(prev => ({...prev, lastname: e.target.value}))}/>
                <div className={s.date}>
                   <label>дата рождения</label>
                    <DatePicker class={s.date} selected={data.birthDay} onChange={(date) => setData(prev => ({...prev, birthDay: date}))} />
                </div>
                <Input placeholder='серия паспорта' onChange={e => setData(prev => ({...prev, partPassport: e.target.value}))}/>
                <MaskedInput
                        mask={[/\d/,/\d/,/\d/,/\d/,/\d/,/\d/,/\d/]}
                        className={s.number}
                        guide={false}
                        placeholder="номер паспорта"
                        onChange={(e) => setData(prev => ({ ...prev,   numberPassport : e.target.value   }))}
                />
                <Input placeholder='кем выдан пасспорт' onChange={e => setData(prev => ({...prev, sourcePassport: e.target.value}))}/>
                <div className={s.date}>
                    <label>дата выдачи пасспорта</label>
                    <DatePicker class={s.date} selected={data.startDatePassport} onChange={(date) => setData(prev => ({...prev, startDatePassport: date}))}/>
                </div>
                <MaskedInput
                        mask={[/\d/,/\d/,/\d/,/\d/,/\d/,/\d/,/\d/,/[A-Z]/,/\d/,/\d/,/\d/,/[A-Z]/,/[A-Z]/, /\d/]}
                        className={s.number}
                        guide={true}
                        placeholder="идентификационнный номер"
                        onChange={e => setData(prev => ({...prev, identidierNumber: e.target.value}))}
                />
                 <Input placeholder='место рождения' onChange={e => setData(prev => ({...prev, placeBirth: e.target.value}))}/>
                 <div className={s.selectorDiv}>
                    <label>город фактического проживания</label>
                    <Select className={s.selector}
                    onChange={e => setData(prev => ({...prev, placeBirth : e.value}))}
                     options={allCities}
                    />
                 </div>
                <Input placeholder='адрес фактического проживания' onChange={e => setData(prev => ({...prev, address: e.target.value}))}/>
                <MaskedInput
                        mask={[/\d/,/\d/,'-',/\d/,/\d/,'-',/\d/,/\d/]}
                        className={s.number}
                        guide={true}
                        placeholder="домашний телефон"
                        onChange={e => setData(prev => ({...prev, homePhone: e.target.value}))}
                />
                <MaskedInput
                        mask={['+','(', 3, 7, 5, ')','-','(',/\d/,/\d/,')', '-', /\d/, /\d/, /\d/, '-', /\d/, /\d/,'-', /\d/, /\d/]}
                        className={s.number}
                        guide={true}
                        placeholder="номер телефона"
                        onChange={e => setData(prev => ({...prev, mobilePhone: e.target.value}))}
                />
                <Input placeholder='email' onChange={e => setData(prev => ({...prev, email: e.target.value}))}/>
                <Input placeholder='место работы' onChange={e => setData(prev => ({...prev, work: e.target.value}))}/>
                <Input placeholder='должность' onChange={e => setData(prev => ({...prev, position: e.target.value}))}/>
                <div className={s.selectorDiv}>
                    <label>город прописки</label>
                    <Select className={s.selector}
                    onChange={e => setData(prev => ({...prev, cityRegistration: e.value}))}
                     options={allCities}
                    />
                 </div>
                 <div className={s.selectorDiv}>
                    <label>семейное положение</label>
                    <Select className={s.selector}
                    onChange={e => setData(prev => ({...prev, familyStatus: e.value}))}
                     options={allFalimyStatuses}
                    />
                 </div>
                 <div className={s.selectorDiv}>
                    <label>гражданство</label>
                    <Select className={s.selector}
                    onChange={e => setData(prev => ({...prev, nationality: e.value}))}
                     options={allNationalities}
                    />
                 </div>
                 <div className={s.selectorDiv}>
                    <label>инвалидность</label>
                    <Select className={s.selector}
                    onChange={e => setData(prev => ({...prev, disability: e.value}))}
                     options={allDisabilities}
                    />
                 </div>
                 <div className={s.checkboxDiv}>
                    <label>пенсионер</label>
                 <input type="checkbox" onChange={e => setData(prev => ({...prev, isPensioner: e.target.checked}))} checked={data.isPensioner}/>
                 </div>

                 <div className={s.checkboxDiv}>
                    <label>ежемесячный доход</label>
                    <input type="number" min="0.00" max="10000.00" step="0.01" onChange={e => setData(prev => ({...prev, salaryMonth: e.target.value}))}/>
                 </div>

                 <button type="submit" className={s.btnSubmit}>Create</button>
            </div>
        </form>
    )
}