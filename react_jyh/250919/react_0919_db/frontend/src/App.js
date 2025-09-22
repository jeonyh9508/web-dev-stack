import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Login from './Login';
import logo from './logo.svg';
import Signup from './Signup';
import MainComp from './MainComp';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login/>}/>
        <Route path="/signup" element={ <Signup/> }/>
        <Route path="/main_content" element={<MainComp/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
