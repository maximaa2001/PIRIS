import ReactDOM from 'react-dom/client';
import { BrowserRouter } from 'react-router-dom';
import App from './App';
import { createContext } from 'react';
import GlobalStore from './context/Store';

import s from './css/Global.module.css'

export const Context = createContext(null)


const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);

root.render(
  <Context.Provider value={{
    globalStore : new GlobalStore()
  }}>
  <BrowserRouter>
    <App />
  </BrowserRouter>
  </Context.Provider>
);

