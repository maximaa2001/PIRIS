import { Input } from '../../input/Input'
import s from './AddClientForm.module.css'
import { useEffect, useState } from 'react';
import "react-datepicker/dist/react-datepicker.css";
import MaskedInput from 'react-text-mask'
import Select from 'react-select';
import { getRefs } from '../../../service/ApiService';
import { useFormikCreateClient } from '../../../hooks/useFormikCreateClient';
import { getClient } from '../../../service/ApiService';
import { useContext } from 'react';
import { Context } from '../../..';
import { observer } from 'mobx-react-lite'
import { IClientData } from '../../../model/model';


export const AddClientForm = observer (() => {

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

    const [data, setData] = useState<IClientData>({
        surname : "",
        name : "",
        lastName : "",
        dateBirth : getStringDate(new Date()),
        partPassport: "",
        numberPassport : "",
        sourcePassport : "",
        startDatePassport : getStringDate(new Date()),
        identifierNumberPassport : "",
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

    const {globalStore} = useContext(Context)
    console.log(allCities)


    const {
        handleSubmit,
        errors,
        values,
        handleChange,
        handleBlur,
        setValues
    } = useFormikCreateClient(data)


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
        if(globalStore.updateClientId) {
            getClient(globalStore.updateClientId).then(res => {setData(res); setValues(res)})
        }
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
                {errors.surname && <div className={s.error}>{errors.surname}</div>}
                <Input type='text' name='name' value={values.name} placeholder='имя' onBlur={handleBlur} onChange={e => {handleChange(e)}}/>
                {errors.name && <div className={s.error}>{errors.name}</div>}
                <Input type='text' name='lastName' value={values.lastName} placeholder='отчество' onBlur={handleBlur} onChange={e => {handleChange(e)}}/>
                {errors.lastName && <div className={s.error}>{errors.lastName}</div>}
                <Input type="date" name='dateBirth' value={values.dateBirth} placeholder='дата рождения' onBlur={handleBlur} onChange={e => {handleChange(e)}}/>
                {errors.dateBirth && <div className={s.error}>{errors.dateBirth}</div>}
                <Input type='text' name='partPassport' value={values.partPassport} placeholder='серия паспорта' onBlur={handleBlur} onChange={e => handleChange(e)}/>
                {errors.partPassport && <div className={s.error}>{errors.partPassport}</div>}
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
                 {errors.numberPassport && <div className={s.error}>{errors.numberPassport}</div>}
                <Input type='text' name='sourcePassport' value={values.sourcePassport} placeholder='кем выдан пасспорт' onBlur={handleBlur} onChange={e => handleChange(e)}/>
                {errors.sourcePassport && <div className={s.error}>{errors.sourcePassport}</div>}
                <Input type="date" name='startDatePassport' value={values.startDatePassport} placeholder='дата рождения' onBlur={handleBlur} onChange={e => {handleChange(e)}}/>
                {errors.startDatePassport && <div className={s.error}>{errors.startDatePassport}</div>}
                 <MaskedInput
                        mask={[/\d/,/\d/,/\d/,/\d/,/\d/,/\d/,/\d/,/[A-Z]/,/\d/,/\d/,/\d/,/[A-Z]/,/[A-Z]/, /\d/]}
                        className={s.number}
                        guide={true}
                        placeholder="идентификационнный номер"
                        name='identifierNumberPassport'
                        value={values.identifierNumberPassport}
                        onBlur={handleBlur}
                        onChange={e => handleChange(e)}
                />
                 {errors.identifierNumberPassport && <div className={s.error}>{errors.identifierNumberPassport}</div>}
                 <Input type='text' name='placeBirth' value={values.placeBirth} placeholder='место рождения'  onBlur={handleBlur} onChange={e => handleChange(e)}/>
                 {errors.placeBirth && <div className={s.error}>{errors.placeBirth}</div>}
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
                 {errors.cityLive && <div className={s.error}>{errors.cityLive}</div>}
                <Input type='text' name='address' value={values.address} placeholder='адрес фактического проживания' onBlur={handleBlur} onChange={e => handleChange(e)}/>
                {errors.address && <div className={s.error}>{errors.address}</div>}
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
                {errors.homePhone && <div className={s.error}>{errors.homePhone}</div>}
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
                {errors.mobilePhone && <div className={s.error}>{errors.mobilePhone}</div>}
               <Input type='text' name='email' value={values.email} placeholder='email' onBlur={handleBlur} onChange={e => handleChange(e)}/>
               {errors.email && <div className={s.error}>{errors.email}</div>}
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
                 {errors.cityRegistration && <div className={s.error}>{errors.cityRegistration}</div>}
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
                 {errors.familyStatus && <div className={s.error}>{errors.familyStatus}</div>}
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
                 {errors.nationality && <div className={s.error}>{errors.nationality}</div>}
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
                 {errors.disability && <div className={s.error}>{errors.disability}</div>}
                 <div className={s.checkboxDiv}>
                    <label>пенсионер</label>
                    <Input type='checkbox' checked={data.isPensioner} name='isPensioner' placeholder='пенсионер' onBlur={handleBlur} onChange={e => setData(prev => ({...prev, isPensioner: e.target.checked}))}/>
                 </div>
                 {errors.isPensioner && <div className={s.error}>{errors.isPensioner}</div>}
                 <div className={s.checkboxDiv}>
                    <label>ежемесячный доход</label>
                    <Input type='number' name='salaryMonth' placeholder='ежемесячный доход' onBlur={handleBlur} onChange={handleChange}/>
                 </div>
            </div> 
            <button type="submit" className={s.btnSubmit}>Create</button>

        </form>
    )
})