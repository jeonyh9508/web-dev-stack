import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "./Login";
import Signup from "./Signup";
import MainComp from "./MainComp";

function App() {
  return (
    // Route path 경로 진입시 element 컴포넌트 호출
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
        <Route path="/main_content" element={<MainComp />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
