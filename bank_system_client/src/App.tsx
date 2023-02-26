import { Route, Routes } from "react-router-dom";
import { ClientsPage } from "./pages/ClientsPage";
import './css/Global.css'
import { Header } from "./components/header/Header";




function App() {
  return (
    <div className="wrapper">
      <Header/>
      <main>
        <Routes>
           <Route path={"/"} element={<ClientsPage/>}/>
        </Routes>
    </main>
    </div>
  );
}

export default App;
