import { makeAutoObservable, action } from 'mobx'
import { IClientData } from '../model/model';

class GlobalStore {
    updateClientId : number = null;
    updateClientData : IClientData = null;

    constructor() {
        makeAutoObservable(this)
    }

    setUpdatedId(id : number) {
        this.updateClientId = id;
    }

    setUpdatedData(data : IClientData) {
        this.updateClientData = data;
    }
}

export default GlobalStore;