import { useState } from "react";

function App() {
  let [fruit, setFruit] = useState([]);
  let [inputVal, setInputVal] = useState("");

  function addFruit() {
    // trim() > 0 숫자만 인식, length를 붙여야 문자열
    if (inputVal.trim()) {
      // set배열 -> 배열을 초기화 하고 추가하기 때문에 []...이전 배열, 추가항목]
      setFruit([...fruit, inputVal]);
      setInputVal("");
    }
  }
  return (
    <div className="App">
      <input
        type="text"
        value={inputVal}
        onChange={(e) => {
          setInputVal(e.target.value);
        }}
        placeholder="좋아하는 과일"
      />
      <input type="button" value="확인" onClick={addFruit} />

      <ul>
        {fruit.map((f) => (
          <li>{f}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
