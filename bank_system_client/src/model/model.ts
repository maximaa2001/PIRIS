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
    cities : ICity;
    disabilities : IDisability;
    familyStatuses : IFamilyStatus;
    nationalities : INationality
}