import { makeAutoObservable, action } from 'mobx'

class GlobalStore {
    isLoading = false;

    constructor() {
        makeAutoObservable(this)
    }

    setIsLoading(bool : boolean) {
        this.isLoading = bool;
    }
}

export default GlobalStore;