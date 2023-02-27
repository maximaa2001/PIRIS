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
        address : "",
        homePhone : "",
        mobilePhone  : "",
        email : "",
        work : "",
        position  : "",
        cityRegistration : -1,
        familyStatus : -1,
        nationality : -1,
        disability : -1,
        isPensioner : false,
        salaryMonth : ""
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



    const handleCityLiveChange = (selectedCity, values) => {
        values.cityLive = selectedCity.value;
        setData(preev => ({...preev, cityLive: selectedCity}));
    }

    const handleCityRegistrationChange = (selectedCity, values) => {
        values.cityRegistration = selectedCity.value;
        setData(preev => ({...preev, cityRegistration: selectedCity}));
    }

    const handleFamilyStatusChange = (selectedCity, values) => {
        values.familyStatus = selectedCity.value;
        setData(preev => ({...preev, familyStatus: selectedCity}));
    }

    const handleNationatilyChange = (selectedCity, values) => {
        values.nationality = selectedCity.value;
        setData(preev => ({...preev, nationality: selectedCity}));
    }

    const handleDisabilityChange = (selectedCity, values) => {
        values.disability = selectedCity.value;
        setData(preev => ({...preev, disability: selectedCity}));
    }
    

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
                <div className={s.selectorDiv}>
                    <label>город фактического проживания</label>
                    <Select className={s.selector}
                    name='cityLive'
                    value={data.cityLive}
                    onChange={selectedOption => {
                        handleCityLiveChange(selectedOption, values);
                        handleChange("cityLive");
                    }}
                     onBlur={handleBlur}
                     options={allCities}
                    />
                 </div>
                <Input type='text' name='address' value={values.address} placeholder='адрес фактического проживания' onBlur={handleBlur} onChange={e => handleChange(e)}/>
                <MaskedInput
                        mask={[/\d/,/\d/,'-',/\d/,/\d/,'-',/\d/,/\d/]}
                        className={s.number}
                        guide={true}
                        placeholder="домашний телефон"
                        name='homePhone'
                        value={values.homePhone}
                        onBlur={handleBlur}
                        onChange={e => handleChange(e)}
                />
                <MaskedInput
                        mask={[ 3, 7, 5,'-',/\d/,/\d/, '-', /\d/, /\d/, /\d/, '-', /\d/, /\d/,'-', /\d/, /\d/]}
                        className={s.number}
                        guide={true}
                        placeholder="номер телефона"
                        name='mobilePhone'
                        value={values.mobilePhone}
                        onBlur={handleBlur}
                        onChange={e => handleChange(e)}
                />
               <Input type='text' name='email' value={values.email} placeholder='email' onBlur={handleBlur} onChange={e => handleChange(e)}/>
                <Input type='text' name='work'  value={values.work} placeholder='место работы' onBlur={handleBlur} onChange={e => handleChange(e)}/>
                <Input  type='text' name='position' value={values.position} placeholder='должность' onBlur={handleBlur} onChange={e => handleChange(e)}/>
                <div className={s.selectorDiv}>
                    <label>город прописки</label>
                    <Select className={s.selector}
                     name='cityRegistration'
                     value={data.cityRegistration}
                     onChange={selectedOption => {
                         handleCityRegistrationChange(selectedOption, values);
                         handleChange("cityRegistration");
                     }}
                      onBlur={handleBlur}
                      options={allCities}
                    />
                 </div>
                 <div className={s.selectorDiv}>
                    <label>семейное положение</label>
                    <Select className={s.selector}
                     name='familyStatus'
                     value={data.familyStatus}
                     onChange={selectedOption => {
                         handleFamilyStatusChange(selectedOption, values);
                         handleChange("familyStatus");
                     }}
                      onBlur={handleBlur}
                      options={allFalimyStatuses}
                    />
                 </div>
                 <div className={s.selectorDiv}>
                    <label>гражданство</label>
                    <Select className={s.selector}
                    name='nationality'
                    value={data.nationality}
                    onChange={selectedOption => {
                        handleNationatilyChange(selectedOption, values);
                        handleChange("nationality");
                    }}
                     onBlur={handleBlur}
                     options={allNationalities}
                    />
                 </div>
                   <div className={s.selectorDiv}>
                    <label>инвалидность</label>
                    <Select className={s.selector}
                   name='disability'
                   value={data.disability}
                   onChange={selectedOption => {
                       handleDisabilityChange(selectedOption, values);
                       handleChange("disability");
                   }}
                    onBlur={handleBlur}
                    options={allDisabilities}
                    />
                 </div>
                 <div className={s.checkboxDiv}>
                    <label>пенсионер</label>
                    <Input type='checkbox' checked={data.isPensioner} name='isPensioner' placeholder='пенсионер' onBlur={handleBlur} onChange={e => setData(prev => ({...prev, isPensioner: e.target.checked}))}/>
                 </div>

                 <div className={s.checkboxDiv}>
                    <label>ежемесячный доход</label>
                    <Input type='number' name='salaryMonth' placeholder='ежемесячный доход' onBlur={handleBlur} onChange={handleChange}/>

                    {/* <input type="number" min="0.00" max="10000.00" step="0.01" onChange={e => setData(prev => ({...prev, salaryMonth: e.target.value}))}/> */}
                 </div>

            </div> 
            <button type="submit" className={s.btnSubmit}>Create</button>

        </form>
    )
}