import { useFormik } from "formik"
import * as Yup from 'yup'
import { createDeposit } from "../service/ApiService" 
import { ICreateDepositData } from "../model/model"



export const useFormikCreateDeposit = (data : ICreateDepositData) => {

    const formik = useFormik({
        initialValues: {
            depositType : data.depositType,
            contractNumber : data.contractNumber,
            currency : data.currency,
            startDate: data.startDate,
            endDate : data.endDate,
            sum : data.sum,
            percent : data.percent,
            client : data.client,
        },
        validateOnChange: false, // this one
        validateOnBlur: false, // and this one
        validationSchema: Yup.object().shape({
            depositType : Yup.number().required("required field").positive("wrong value"),
            contractNumber : Yup.number().required("required field").positive("wrong value"),
            currency : Yup.string().required("required field"),
            startDate : Yup.string().required("required field").matches(new RegExp("[0-9]{4}-[0-9]{2}-[0-9]{2}"), "not valid date"),
            endDate: Yup.string().required("required field").matches(new RegExp("[0-9]{4}-[0-9]{2}-[0-9]{2}"), "not valid date"),
            sum : Yup.string().required("required field"),
            percent : Yup.string().required("required field"),
            client : Yup.number().required("required field").positive("wrong value"),
        }),
        onSubmit:  async ({ depositType, contractNumber, currency, startDate, endDate, sum, percent, client }, {setFieldError}) => {
                createDeposit({ depositType,
                contractNumber,
                currency,
                startDate,
                endDate,
                sum,
                percent,
                client})
                .catch(e => {
                const {response} = e;
                        if (response?.status == 400) {
                            const { field, message } = response.data
                            setFieldError(
                                field,
                                message
                            )
                        }
                })
            },
    })

    return {...formik}
}