import { useFormik } from "formik"
import { ICreateClientData } from "../model/model"
import * as Yup from 'yup'



export const useFormilCreateClient = (data : ICreateClientData) => {

    const formik = useFormik({
        initialValues: {
            surname : data.surname,
            name : data.name,
            lastname : data.lastname,
            birthDay : data.birthDay,
            partPassport: data.partPassport,
            numberPassport : data.numberPassport,
            sourcePassport : data.sourcePassport,
            startDatePassport : data.startDatePassport,
            identidierNumber : data.identidierNumber,
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
            surname : Yup.string().required("surname is required field"),
            name : Yup.string().required("name is required field"),
            lastname : Yup.string().required("lastname is required field"),
            birthDay : Yup.string().matches(new RegExp("[0-9]{4}-[0-9]{2}-[0-9]{2}"), "not valid regex").required("birthDay is required field"),
            partPassport: Yup.string().required("partPassport is required field").length(2, "partPassport max value is 2"),
            numberPassport : Yup.string().required("numberPassport is required field").matches(new RegExp("[0-9]{7}"), "not valid regex").length(7, "numberPassport is not length 7"),
            sourcePassport : Yup.string().required("sourcePassport is required field"),
            startDatePassport : Yup.string().matches(new RegExp("[0-9]{4}-[0-9]{2}-[0-9]{2}"), "not valid regex").required("startDatePassport is required field"),
            identidierNumber : Yup.string().required("identidierNumber is required field").matches(new RegExp("[0-9]{7}[A-Z]{1}[0-9]{3}[A-Z]{2}[0-9]{1}"), "not valid regex").length(14, "identidierNumber is not length 14"),
            placeBirth : Yup.string().required("placeBirth is required field"),
            cityLive : Yup.number().required("cityLive is required field").positive("not positive"),
            address : Yup.string().required("address is required field"),
            homePhone : Yup.string().matches(new RegExp("[0-9]{2}-[0-9]{2}-[0-9]{2}"), "not valid regex").length(8, "homePhone is not length 8"),
            mobilePhone : Yup.string().matches(new RegExp("375-[0-9]{2}-[0-9]{3}-[0-9]{2}-[0-9]{2}"), "not valid regex"),
            email : Yup.string().email("not valid regex"),
            work : Yup.string(),
            position : Yup.string(),
            cityRegistration : Yup.number().required("cityRegistration is required field").positive("not positive"),
            familyStatus : Yup.number().required("familyStatus is required field").positive("not positive"),
            nationality : Yup.number().required("nationality is required field").positive("not positive"),
            disability : Yup.number().required("disability is required field").positive("not positive"),
            isPensioner : Yup.boolean().required("isPensioner is required field"),
            salaryMonth : Yup.string()
        }),
        onSubmit: (values) => {
           console.log("yeeees")
           console.log(values)
        },
    })

    return {...formik}
}