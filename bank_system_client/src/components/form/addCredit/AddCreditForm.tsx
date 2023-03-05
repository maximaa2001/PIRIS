import { Input } from '../../input/Input'
import s from './AddCreditForm.module.css'
import { useEffect, useState } from 'react';
import "react-datepicker/dist/react-datepicker.css";
import Select from 'react-select';
import { getCreditRefs} from '../../../service/ApiService';
import { ICreateCreditData, } from '../../../model/model';
import { useFormikCreateCredit } from '../../../hooks/useFormikCreateCredit';

export const AddCreditForm = () => {

    const [data, setData] = useState<ICreateCreditData>({
        creditType : -1,
        contractNumber : "",
        currency : "",
        startDate: "",
        endDate : "",
        sum : "",
        percent : "",
        client : -1
    })

    const [allCreditTypes, setAllCreditTypes] = useState([]);
    const [allCurrencies, setAllCurrencies] = useState([]);
    const [allClients, setAllClients] = useState([]);

    const {
        touched,
        handleSubmit,
        errors,
        values,
        handleChange,
        handleBlur,
        isValid,
    } = useFormikCreateCredit(data)    

    useEffect(() => {
        getCreditRefs().then(item => {
            setAllCreditTypes(item.data.creditTypes.map(function(entry) {
                return {
                    label : entry.name,
                    value : entry.id
                }
            }))
            setAllCurrencies(item.data.currencies.map(function(entry) {
                return {
                    label : entry.name,
                    value : entry.iso
                }
            }))
            setAllClients(item.data.clients.map(function(entry) {
                return {
                    label : entry.name,
                    value : entry.id
                }
            }))
        })
    }, [])

    const handleCreditTypeChange = (selectedDepositType, values) => {
        values.creditType = selectedDepositType.value;
        setData(preev => ({...preev, creditType: selectedDepositType}));
    }

    const handleCurrency = (selectedDepositType, values) => {
        values.currency = selectedDepositType.value;
        setData(preev => ({...preev, currency: selectedDepositType}));
    }

    const handleClient = (selectedDepositType, values) => {
        values.client = selectedDepositType.value;
        setData(preev => ({...preev, client: selectedDepositType}));
    }

    return(
        <form onSubmit={handleSubmit}>
            <div className={s.container}>
            <div className={s.selectorDiv}>
                    <label>тип кредита</label>
                    <Select className={s.selector}
                    name='creditType'
                    value={data.creditType}
                    onChange={selectedOption => {
                        handleCreditTypeChange(selectedOption, values);
                        handleChange("creditType");
                    }}
                     onBlur={handleBlur}
                     options={allCreditTypes}
                    />
            </div>
            {errors.creditType && <div className={s.error}>{errors.creditType}</div>}
            <Input type='number' name='contractNumber' value={values.contractNumber} placeholder='номер счета' onBlur={handleBlur} onChange={e => {handleChange(e)}}/>
            {errors.contractNumber && <div className={s.error}>{errors.contractNumber}</div>}
            <div className={s.selectorDiv}>
                    <label>валюта</label>
                    <Select className={s.selector}
                    name='currency'
                    value={data.currency}
                    onChange={selectedOption => {
                        handleCurrency(selectedOption, values);
                        handleChange("currency");
                    }}
                     onBlur={handleBlur}
                     options={allCurrencies}
                    />
            </div>
            {errors.currency && <div className={s.error}>{errors.currency}</div>}
            <Input type="date" name='startDate' value={values.startDate} placeholder='дата начала' onBlur={handleBlur} onChange={e => {handleChange(e)}}/>
            {errors.startDate && <div className={s.error}>{errors.startDate}</div>}
            <Input type="date" name='endDate' value={values.endDate} placeholder='дата конца' onBlur={handleBlur} onChange={e => {handleChange(e)}}/>
            {errors.endDate && <div className={s.error}>{errors.endDate}</div>}
            <div className={s.checkboxDiv}>
                    <label>сумма</label>
                    <Input type='number' name='sum' placeholder='сумма' onBlur={handleBlur} onChange={handleChange}/>
            </div>
            {errors.sum && <div className={s.error}>{errors.sum}</div>}
             <div className={s.checkboxDiv}>
                    <label>процент</label>
                    <Input type='text' name='percent' placeholder='процент' onBlur={handleBlur} onChange={handleChange}/>
             </div>
             {errors.percent && <div className={s.error}>{errors.percent}</div>}
             <div className={s.selectorDiv}>
                    <label>клиенты</label>
                    <Select className={s.selector}
                    name='client'
                    value={data.client}
                    onChange={selectedOption => {
                        handleClient(selectedOption, values);
                        handleChange("client");
                    }}
                     onBlur={handleBlur}
                     options={allClients}
                    />
            </div>
            {errors.client && <div className={s.error}>{errors.client}</div>}
            </div>
            <button type="submit" className={s.btnSubmit}>Create</button>
        </form>
    )


}