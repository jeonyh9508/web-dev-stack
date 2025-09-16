import { useState } from "react";
import logo from "./logo.svg";
import "./App.css";

function App() {
  let [selColor, setSelColor] = useState("");
  let [mfont, setFont] = useState("");

  // let color_list = [
  //   { id: 0, select: "::색상 선택::", background: "black", color: "white" },
  //   { id: 1, select: "::빨강::", background: "red", color: "white" },
  //   { id: 2, select: "::파랑::", background: "blue", color: "white" },
  //   { id: 3, select: "::초록::", background: "green", color: "white" },
  //   { id: 4, select: "::노랑::", background: "yellow", color: "black" },
  // ];

  let changeBack = (event) => {
    let color = event.target.value;
    setSelColor(color);
    console.log(color);
    if (color === "yellow") {
      setFont("black");
    } else {
      setFont("white");
    }
  };
  return (
    <div className="App">
      색상선택
      <select onChange={changeBack}>
        <option value="">:::색상 선택:::</option>
        <option value="red">:::빨 강:::</option>
        <option value="blue">:::파 랑:::</option>
        <option value="green">:::초 록:::</option>
        <option value="yellow">:::노 랑:::</option>
      </select>
      <hr />
      <div id="exam_div" style={{ backgroundColor: selColor, color: mfont }}>
        <b>{selColor}　</b>
      </div>
    </div>
  );
}

// function Header(props) {
//   let color = [];
//   for (let i = 0; i < props.colors.length; i++) {
//     let j = props.colors[i];
//     color.push(<option value={j.id}>{j.select}</option>);
//   }
//   return (
//     <div style={{ fontSize: 20 }}>
//       <div>
//         색상 선택 <select onChange={(e) => {}}>{color}</select>
//       </div>
//       <div
//         style={{
//           width: 200,
//           height: 200,
//         }}
//       ></div>
//     </div>
//   );
// }

export default App;
