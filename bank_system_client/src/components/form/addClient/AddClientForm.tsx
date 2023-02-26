import { Input } from '../../input/Input'
import s from './AddClientForm.module.css'
import React, { useEffect, useState } from 'react';
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import MaskedInput from 'react-text-mask'
import Select from 'react-select';
import { getRefs } from '../../../service/ApiService';
import { ICity, IDisability, IFamilyStatus, INationality } from '../../../model/model';

export const AddClientForm = () => {
    const [surname, setSurname] = useState(null);
    const [name, setName] = useState(null);
    const [lastname, setLastName] = useState(null);
    const [birthDay, setBirthDay] = useState(null);
    const [partPassport, setPartPassport] = useState(null);
    const [numberPassport, setNumberPassport] = useState(null);
    const [sourcePassport, setSourcePassport] = useState(null);
    const [startDatePassport, setStartDatePassport] = useState(null);
    const [identidierNumber, setIdentifierNumber] = useState(null);
    const [placeBirth, setPlaceBirth] = useState(null);
    const [cityLive, setCityLive] = useState(null);
    const [address, setAdress] = useState(null);
    const [homePhone, setHomePhone] = useState(null);
    const [mobilePhone, setMobilePhone] = useState(null);
    const [email, setEmail] = useState(null);
    const [work, setWork] = useState(null);
    const [position, setPosition] = useState(null);
    const [cityRegistration, setCityRegistration] = useState(null);
    const [familyStatus, setFamilyStatus] = useState(null);
    const [nationality, setNationality] = useState(null);
    const [disability, setDisability] = useState(null);
    const [isPensioner, setIsPensioner] = useState(false);
    const [salaryMonth, setSalaryMonth] = useState(null);

    const [allCities, setAllCities] = useState([]);
    const [allFalimyStatuses, setAllFamilyStatuses] = useState([]);
    const [allNationalities, setAllNationalities] = useState([]);
    const [allDisabilities, setAllDisaboloties] = useState([]);

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

    console.log(allCities)
    console.log("new" + allCities.map(function(entry) {
        return entry.name;
    }))

    const submitHandler = (e : React.FormEvent) => {
        e.preventDefault();
    }

    return(
        <form onSubmit={submitHandler}>
            <div className={s.container}>
                <Input placeholder='фамилия' onChange={e => setSurname(e.target.value)}/>
                <Input placeholder='имя' onChange={e => setName(e.target.value)}/>
                <Input placeholder='отчество' onChange={e => setLastName(e.target.value)}/>
                <div className={s.date}>
                   <label>дата рождения</label>
                    <DatePicker class={s.date} selected={birthDay} onChange={(date) => setBirthDay(date)} />
                </div>
                <Input placeholder='серия паспорта' onChange={e => setPartPassport(e.target.value)}/>
                <MaskedInput
                        mask={[/\d/,/\d/,/\d/,/\d/,/\d/,/\d/,/\d/]}
                        className={s.number}
                        guide={false}
                        placeholder="номер паспорта"
                        onChange={(e) => setNumberPassport(e.target.value)}
                />
                <Input placeholder='кем выдан пасспорт' onChange={setSourcePassport}/>
                <div className={s.date}>
                    <label>дата выдачи пасспорта</label>
                    <DatePicker class={s.date} selected={birthDay} onChange={(date) => setStartDatePassport(date)}/>
                </div>
                <MaskedInput
                        mask={[/\d/,/\d/,/\d/,/\d/,/\d/,/\d/,/\d/,/[A-Z]/,/\d/,/\d/,/\d/,/[A-Z]/,/[A-Z]/, /\d/]}
                        className={s.number}
                        guide={true}
                        placeholder="идентификационнный номер"
                        onChange={(e) =>  setIdentifierNumber(e.target.value)}
                />
                 <Input placeholder='место рождения' onChange={e => setPlaceBirth(e.target.value)}/>
                 <div className={s.selectorDiv}>
                    <label>город фактического проживания</label>
                    <Select className={s.selector}
                    onChange={setCityLive}
                     options={allCities}
                    />
                 </div>
                <Input placeholder='адрес фактического проживания' onChange={setAdress}/>
                <MaskedInput
                        mask={[/\d/,/\d/,'-',/\d/,/\d/,'-',/\d/,/\d/]}
                        className={s.number}
                        guide={true}
                        placeholder="домашний телефон"
                        onChange={(e) =>  setHomePhone(e.target.value)}
                />
                <MaskedInput
                        mask={['+','(', 3, 7, 5, ')','-','(',/\d/,/\d/,')', '-', /\d/, /\d/, /\d/, '-', /\d/, /\d/,'-', /\d/, /\d/]}
                        className={s.number}
                        guide={true}
                        placeholder="номер телефона"
                        onChange={(e) =>  setMobilePhone(e.target.value)}
                />
                <Input placeholder='email' onChange={setEmail}/>
                <Input placeholder='место работы' onChange={setWork}/>
                <Input placeholder='должность' onChange={setPosition}/>
                <div className={s.selectorDiv}>
                    <label>город прописки</label>
                    <Select className={s.selector}
                    onChange={setCityRegistration}
                     options={allCities}
                    />
                 </div>
                 <div className={s.selectorDiv}>
                    <label>семейное положение</label>
                    <Select className={s.selector}
                    onChange={setFamilyStatus}
                     options={allFalimyStatuses}
                    />
                 </div>
                 <div className={s.selectorDiv}>
                    <label>гражданство</label>
                    <Select className={s.selector}
                    onChange={setNationality}
                     options={allNationalities}
                    />
                 </div>
                 <div className={s.selectorDiv}>
                    <label>инвалидность</label>
                    <Select className={s.selector}
                    onChange={setDisability}
                     options={allDisabilities}
                    />
                 </div>
                 <div className={s.checkboxDiv}>
                    <label>пенсионер</label>
                 <input type="checkbox" onChange={(e) => setIsPensioner(e.target.checked)} checked={isPensioner}/>
                 </div>

                 <div className={s.checkboxDiv}>
                    <label>ежемесячный доход</label>
                    <input type="number" min="0.00" max="10000.00" step="0.01" />
                 </div>

                 <button type="submit" className={s.btnSubmit}>Create</button>
                 
            </div>
            
        </form>
    )
}