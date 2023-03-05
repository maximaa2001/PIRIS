export interface ICity {
    id : number;
    name : string;
}

export interface IDisability {
    id : number;
    name : string;
}

export interface IFamilyStatus {
    id : number;
    name : string;
}

export interface INationality {
    id : number;
    name : string;
}

export interface IRef {
    cities : ICity[];
    disabilities : IDisability[];
    familyStatuses : IFamilyStatus[];
    nationalities : INationality[]
}

export interface IClientData {
    id? : number
    surname : string;
    name : string;
    lastName : string;
    dateBirth : string;
    partPassport: string;
    numberPassport : string;
    sourcePassport : string;
    startDatePassport : string;
    identifierNumberPassport : string;
    placeBirth : string;
    cityLive : number;
    address : string;
    homePhone : string;
    mobilePhone  : string;
    email : string;
    work : string;
    position  : string;
    cityRegistration : number
    familyStatus : number;
    nationality : number;
    disability : number;
    isPensioner : boolean;
    salaryMonth : string;
}


export interface ICreateDepositData {
    depositType : number
    contractNumber : string
    currency : string
    startDate: string
    endDate : string
    sum : string
    percent : string
    client : number
}

export interface ICreateCreditData {
    creditType : number
    contractNumber : string
    currency : string
    startDate: string
    endDate : string
    sum : string
    percent : string
    client : number
}

export interface IClientMiniData {
    id : number
    surname : string;
    name : string;
    lastName : string;
    partPassport: string;
    numberPassport : string;
}

export interface IClientsMiniData {
    clients : IClientMiniData[]
}

export interface IData {
    data : IClientData
}

export interface IDepositMiniData {
    id : number
    sum: string
    percent : number
    depositName : string
}

export interface IDepositsMiniData {
    deposits : IDepositMiniData[]
}

export interface ICreditMiniData {
    id : number
    sum: string
    percent : number
    creditName : string
}

export interface ICreditsMiniData {
    credits : ICreditMiniData[]
}

