import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";

// function App() {
//   let [name, setName] = useState("");
//   let [msg, setMsg] = useState("");
//   let [feel, setFeel] = useState("nomal");

//   let feeling = {
//     nomal: { condition: "선택", desc: "기분이 어떠세요?" },
//     happy: { condition: "행복", desc: "왜 행복하세요?" },
//     sad: { condition: "슬픔", desc: "울지말고 얘기해요." },
//     angry: { condition: "화남", desc: "긁히셨나요?" },
//   };

//   let selected = feeling[feel];
//   return (
//     <div className="App">
//       <input
//         type="text"
//         name="name"
//         placeholder="이름을 입력해주세요"
//         onChange={(e) => {
//           setName(e.target.value);
//         }}
//       />
//       <input
//         type="button"
//         value="인사하기"
//         onClick={(e) => {
//           setMsg("안녕하세요 ! " + name + "님! 오늘의 기분은요?");
//         }}
//       />
//       <p style={{ fontWeight: "bold" }}>{msg}</p>
//       <select
//         onChange={(e) => {
//           setFeel(e.target.value);
//         }}
//       >
//         <option value="nomal">선택하세요</option>
//         <option value="happy">행복</option>
//         <option value="sad">슬픔</option>
//         <option value="angry">화남</option>
//       </select>
//       <p>{selected.desc}</p>
//     </div>
//   );
// }

function App() {
  let [greet, setGreet] = useState("");
  let [msg, setMsg] = useState("");

  function nameChange(e) {
    e.preventDefault();
    let name = e.target.myname.value;
    setGreet("안녕하세요 " + name + "님, 오늘의 기분은? ");
  }

  function moodChange(e) {
    let mood = e.target.value;
    if (mood === "행복") {
      setMsg("왜 행복하시지");
    } else if (mood === "슬픔") {
      setMsg("슬퍼한다고 뭐가 되진 않아요.");
    } else if (mood === "화남") {
      setMsg("긁?");
    } else {
      setMsg("기분이 어떠냐고요");
    }
  }
  return (
    <div className="App">
      <form onSubmit={nameChange}>
        <input type="text" name="myname" placeholder="이름을 입력하세요" />
        <input type="submit" value="인사하기" />
      </form>
      <p>{greet}</p>
      <MyMood mood={moodChange}></MyMood>
      <p>{msg}</p>
    </div>
  );
}

function MyMood({ mood }) {
  return (
    <div>
      <select onChange={mood}>
        <option value="">기분 선택</option>
        <option value="행복">행복 </option>
        <option value="슬픔">슬픔</option>
        <option value="화남">화남</option>
      </select>
    </div>
  );
}
export default App;
