import { useFormik } from "formik"
import { ICreateClientData } from "../model/model"
import * as Yup from 'yup'
import { createClient } from "../service/ApiService" 



export const useFormikCreateClient = (data : ICreateClientData) => {

    const formik = useFormik({
        initialValues: {
            surname : data.surname,
            name : data.name,
            lastName : data.lastName,
            dateBirth : data.dateBirth,
            partPassport: data.partPassport,
            numberPassport : data.numberPassport,
            sourcePassport : data.sourcePassport,
            startDatePassport : data.startDatePassport,
            identifierNumberPassport : data.identifierNumberPassport,
            placeBirth : data.placeBirth,
            cityLive : data.cityLive,
            address : data.address,
            homePhone : data.homePhone,
            mobilePhone  : data.mobilePhone,
            email : data.email,
            work : data.work,
            position  : data.position,
            cityRegistration : data.cityRegistration,
            familyStatus : data.familyStatus,
            nationality : data.nationality,
            disability : data.disability,
            isPensioner : data.isPensioner,
            salaryMonth : data.salaryMonth
        },
        validateOnChange: false, // this one
        validateOnBlur: false, // and this one
        validationSchema: Yup.object().shape({
            surname : Yup.string().required("required field"),
            name : Yup.string().required("required field"),
            lastName : Yup.string().required("required field"),
            dateBirth : Yup.string().required("required field").matches(new RegExp("[0-9]{4}-[0-9]{2}-[0-9]{2}"), "not valid date"),
            partPassport: Yup.string().required("required field").length(2, "field length is 2"),
            numberPassport : Yup.string().required("required field").matches(new RegExp("[0-9]{7}"), "not valid number").length(7, "field length is 7"),
            sourcePassport : Yup.string().required("required field"),
            startDatePassport : Yup.string().required("required field").matches(new RegExp("[0-9]{4}-[0-9]{2}-[0-9]{2}"), "not valid date"),
            identifierNumberPassport : Yup.string().required("required field").matches(new RegExp("[0-9]{7}[A-Z]{1}[0-9]{3}[A-Z]{2}[0-9]{1}"), "not valid indentifier number").length(14, "field length is 14"),
            placeBirth : Yup.string().required("required field"),
            cityLive : Yup.number().required("required field").positive("wrong value"),
            address : Yup.string().required("required field"),
            homePhone : Yup.string().matches(new RegExp("[0-9]{2}-[0-9]{2}-[0-9]{2}"), "not valid phone").length(8, "field length is 8"),
            mobilePhone : Yup.string().matches(new RegExp("375-[0-9]{2}-[0-9]{3}-[0-9]{2}-[0-9]{2}"), "not valid phone"),
            email : Yup.string().email("not valid field"),
            work : Yup.string(),
            position : Yup.string(),
            cityRegistration : Yup.number().required("required field").positive("wrong value"),
            familyStatus : Yup.number().required("required field").positive("wrong value"),
            nationality : Yup.number().required("required field").positive("wrong value"),
            disability : Yup.number().required("required field").positive("wrong value"),
            isPensioner : Yup.boolean().required("required field"),
            salaryMonth : Yup.string()
        }),
        onSubmit:  async ({ surname, name, lastName, dateBirth, partPassport, numberPassport, sourcePassport, startDatePassport,
        identifierNumberPassport, placeBirth, cityLive, address, homePhone, mobilePhone, email, work, position,
         cityRegistration, familyStatus, nationality, disability, isPensioner, salaryMonth }, {setFieldError }) => {
                createClient({ surname,
                    name ,
                    lastName,
                    dateBirth,
                    partPassport,
                    numberPassport,
                    sourcePassport,
                    startDatePassport,
                    identifierNumberPassport ,
                    placeBirth,
                    cityLive,
                    address,
                    homePhone,
                    mobilePhone,
                    email,
                    work,
                    position,
                    cityRegistration,
                    familyStatus,
                    nationality,
                    disability,
                    isPensioner,
                    salaryMonth})
                    .catch(e => {
                        const {response} = e;
                        if (response?.status == 400) {
                            const { field, message } = response.data
                            setFieldError(
                                field,
                                message
                            )
                        } else if (response?.status === 409) {
                            const { message } = response.data
                            setFieldError(
                                "surname",
                                message
                            )
                            return
                        }
                    })
            },
    })

    return {...formik}
}