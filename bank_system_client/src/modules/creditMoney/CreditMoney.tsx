import {useState } from "react"
import { Input } from "../../components/input/Input"
import { changeCreditMoney } from "../../service/ApiService"

export const CreditMoney =(a :{numb : string}) =>  {
    const [number, setNumber] = useState(a.numb)
    const [money, setMoney] = useState('')
    const [error, setError] = useState('')

    const onSubmit = (e) => {
        e.preventDefault();
        setError('')
        changeCreditMoney({
            number,
            money
        }).catch(e => {
           setError(e.response.data.message)
        })

    }
    
    return(
        <div>
            <Input type="text" value={money} placeholder='get credit money' onChange={e => setMoney(e.target.value)}></Input>
            {error && <div>{error}</div>}
            <button type="button" onClick={onSubmit}>Change credit money</button>
        </div>
    )
}