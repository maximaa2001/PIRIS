import { Route, Routes } from "react-router-dom";
import { ClientsPage } from "./pages/ClientsPage";
import './css/Global.css'
import { Header } from "./components/header/Header";
import { DepositsPage } from "./pages/DepositsPage";




function App() {
  return (
    <div className="wrapper">
      <Header/>
      <main>
        <Routes>
           <Route path={"/"} element={<ClientsPage/>}/>
           <Route path={"/deposits"} element={<DepositsPage/>}/>
        </Routes>
    </main>
    </div>
  );
}

export default App;
