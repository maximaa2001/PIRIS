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

export interface ICreateClientData {
    surname : string;
    name : string;
    lastname : string;
    birthDay : string;
    partPassport: string;
    numberPassport : string;
    sourcePassport : string;
    startDatePassport : string;
    identidierNumber : string;
    placeBirth : string;
    cityLive : number;
    address : string;
    // homePhone : string;
    // mobilePhone  : string;
    // email : string;
    // work : string;
    // position  : string;
    // cityRegistration : number
    // familyStatus : number;
    // nationality : number;
    // disability : number;
    // isPensioner : boolean;
    // salaryMonth : string;
}