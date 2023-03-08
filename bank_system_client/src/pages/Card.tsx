import {useState } from "react"
import s from './style/ClientsPage.module.css'
import { checkCard, getCreditMoneyApi } from "../service/ApiService"
import { Input } from "../components/input/Input"
import { CreditMoney } from "../modules/creditMoney/CreditMoney"

export const Card =() =>  {
    const [number, setNumber] = useState<string>('')
    const [pin, setPin] = useState('')
    const [error, setError] = useState('')
    const [isLogin, setIsLogin] = useState(false)
    const [creditMoney, setCreditMoney] = useState(false)


    const onSubmit = (e) => {
        e.preventDefault();
        setError('')
        checkCard({
            number,
            pin
        }).then(e => setIsLogin(true))
        .catch(e => {
           setError(e.response.data.message)
        })
    } 

    const getCreditMoney = (e) => {
        e.preventDefault();
        getCreditMoneyApi({number}).then(e => setCreditMoney(e.money))
    }  

    return(
        <section className={s.container}>
            <form>
                <div>
            <Input type="text"value={number} placeholder="number" onChange={e => setNumber(e.target.value)}></Input>
            <Input type="text" value={pin} placeholder="pin" onChange={e => setPin(e.target.value)}></Input>
            {error && <div className={s.error}>{error}</div>}
            </div>
            <button type="submit" onClick={onSubmit}>Check</button>
            </form>
            {isLogin && <CreditMoney numb={number}/>}
            {isLogin && <button type="button" onClick={getCreditMoney}>Get credit money</button>}
            {creditMoney && <div>{creditMoney}</div>}
        </section>
    )
}