import { Route, Routes } from "react-router-dom";
import { ClientsPage } from "./pages/ClientsPage";
import './css/Global.css'
import {Header} from './modules/header/header/Header'
import { DepositsPage } from "./pages/DepositsPage";
import { CreditsPage } from "./pages/CreditsPage";


function App() {
  return (
    <div className="wrapper">
      <Header/>
      <main>
        <Routes>
           <Route path={"/"} element={<ClientsPage/>}/>
           <Route path={"/deposits"} element={<DepositsPage/>}/>
           <Route path={"/credits"} element={<CreditsPage/>}/>
        </Routes>
    </main>
    </div>
  );
}

export default App;
