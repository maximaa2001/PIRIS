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
import {useFormik, ErrorMessage} from 'formik'

export const AddClientForm = () => {

    const getStringDate = (date : Date) => {
        var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) 
        month = '0' + month;
    if (day.length < 2) 
        day = '0' + day;

    return [year, month, day].join('-');
    }

    const [data, setData] = useState({
        surname : "",
        name : "",
        lastname : "",
        birthDay : getStringDate(new Date()),
        partPassport: "",
        numberPassport : "",
        sourcePassport : "",
        startDatePassport : getStringDate(new Date()),
        identidierNumber : "",
        placeBirth : "",
        cityLive : -1,
        address : null,
        // homePhone : null,
        // mobilePhone  : null,
        // email : null,
        // work : null,
        // position  : null,
        // cityRegistration : -1,
        // familyStatus : -1,
        // nationality : -1,
        // disability : -1,
        // isPensioner : false,
        // salaryMonth : null
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

    console.log(data.cityLive)



    return(
        <form onSubmit={handleSubmit}>
            <div className={s.container}>
                <Input type='text' name='surname' value={values.surname} placeholder='фамилия' onBlur={handleBlur} onChange={e => {handleChange(e)}}/>
                <Input type='text' name='name' value={values.name} placeholder='имя' onBlur={handleBlur} onChange={e => {handleChange(e)}}/>
                <Input type='text' name='lastname' value={values.lastname} placeholder='отчество' onBlur={handleBlur} onChange={e => {handleChange(e)}}/>
                <Input type="date" name='birthDay' value={values.birthDay} placeholder='дата рождения' onBlur={handleBlur} onChange={e => {handleChange(e)}}/>
                <Input type='text' name='partPassport' value={values.partPassport} placeholder='серия паспорта' onBlur={handleBlur} onChange={e => handleChange(e)}/>
                <MaskedInput
                        mask={[/\d/,/\d/,/\d/,/\d/,/\d/,/\d/,/\d/]}
                        className={s.number}
                        guide={false}
                        placeholder="номер паспорта"
                        name='numberPassport'
                        value={values.numberPassport}
                        onBlur={handleBlur}
                        onChange={e => handleChange(e)}
                />
                <Input type='text' name='sourcePassport' value={values.sourcePassport} placeholder='кем выдан пасспорт' onBlur={handleBlur} onChange={e => handleChange(e)}/>
                <Input type="date" name='startDatePassport' value={values.startDatePassport} placeholder='дата рождения' onBlur={handleBlur} onChange={e => {handleChange(e)}}/>
                 <MaskedInput
                        mask={[/\d/,/\d/,/\d/,/\d/,/\d/,/\d/,/\d/,/[A-Z]/,/\d/,/\d/,/\d/,/[A-Z]/,/[A-Z]/, /\d/]}
                        className={s.number}
                        guide={true}
                        placeholder="идентификационнный номер"
                        name='identidierNumber'
                        value={values.identidierNumber}
                        onBlur={handleBlur}
                        onChange={e => handleChange(e)}
                />
                 <Input type='text' name='placeBirth' value={values.placeBirth} placeholder='место рождения'  onBlur={handleBlur} onChange={e => handleChange(e)}/>
                 <select name='cityLive' value={values.cityLive} onBlur={handleBlur} onChange={handleChange}>
                    <option>sf</option>
                    <option>sf</option>
                 </select>
                {/* <div className={s.selectorDiv}>
                    <label>город фактического проживания</label>
                    <Select className={s.selector}
                    onChange={e => setData(prev => ({...prev, placeBirth : e.value}))}
                     options={allCities}
                    />
                 </div> */}
                {/* <Input placeholder='адрес фактического проживания' onChange={e => setData(prev => ({...prev, address: e.target.value}))}/>
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
                 </div>*/} 

            </div> 
            <button type="submit" className={s.btnSubmit}>Create</button>

        </form>
    )
}