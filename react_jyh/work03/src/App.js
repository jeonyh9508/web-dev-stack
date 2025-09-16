import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";

function App() {
  let [count, setCount] = useState(0);
  let [msg, setMsg] = useState(null);
  function down() {
    setCount(count - 1);
  }
  function reset() {
    setCount(0);
  }
  function up() {
    setCount(count + 1);
  }
  function set(event) {
    setCount(Number(event.target.value));
  }
  // let set = (e) => {
  //   setCount(Number(e.target.value));
  // };

  // let calc = (e) => {
  //   if (e.target.value == "-") setCount(count - 1);
  //   if (e.target.value == "+") setCount(count + 1);
  //   if (e.target.value == "0") setCount(0);
  // };

  function checkEvenOdd() {
    if (count === 0) {
      setMsg(<p>"현재 카운트는 0입니다."</p>);
    } else if (count % 2 === 0) {
      setMsg(<p>"현재 카운트는 짝수입니다."</p>);
    } else if (count % 2 === 1) {
      setMsg(<p>"현재 카운트는 홀수입니다."</p>);
    }
  }

  return (
    <div className="App">
      <input type="button" value="-" onClick={down} />
      <input type="button" value="0" onClick={reset} />
      <input type="button" value="+" onClick={up} />

      <input type="number" onChange={set} value={count} />
      <span>{count}</span>
      <br />
      <input type="button" value="짝수/홀수 확인" onClick={checkEvenOdd} />
      <br />
      <span>{msg}</span>
    </div>
    // <div className="App">
    //   <form>
    //     <input type="button" value="-" onClick={calc} />
    //     <input type="button" value="0" onClick={calc} />
    //     <input type="button" value="+" onClick={calc} />
    //     <span>{count}</span>
    //   </form>
    // </div>
  );
}

export default App;
