import { useState } from "react";

function App() {
  let [person, setPerson] = useState([]);
  let [myName, setMyName] = useState("");
  let [age, setAge] = useState("");

  function sign() {
    if (myName.trim() && age.trim()) {
      setPerson([...person, { myName, age }]);
      setMyName("");
      setAge("");
    }
  }

  let signTest = () => {
    if (myName.trim() && age.trim()) {
      setPerson([...person, { myName, age }]);
      setMyName("");
      setAge("");
    }
  };
  let personDel = (index) => {
    // filter 는 배열을 순회하면서 조건에 맞는 요소만 골라서 새로운 배열을 만드는 함수
    // filter 함수는 최대 두개의 파라미터(인자)
    // 첫번째 인자 res는 배열의 i 번째 요소 ( 사용하지 않는다면 '_' 언더바로 지정)
    // 두번째 인자 i는 배열의 index
    let newPerson = person.filter((res, i) => i !== index);
    setPerson(newPerson);
  };
  return (
    <div className="App">
      <h1>사용자 목록</h1>
      <input
        type="text"
        value={myName}
        placeholder="이름"
        onChange={(e) => {
          setMyName(e.target.value);
        }}
      />
      <br />
      <input
        type="number"
        value={age}
        placeholder="나이"
        onChange={(e) => {
          setAge(e.target.value);
        }}
      />
      <input type="button" onClick={signTest} value="확인" />
      <hr />
      <table border="1">
        <tr>
          <th>이름</th>
          <th>나이</th>
          <th>비고</th>
        </tr>
        {person.map((p, index) => (
          <tr>
            <td>
              {index}
              {p.myName}
            </td>
            <td>{p.age}</td>
            <td>
              <input
                type="button"
                value="삭제"
                onClick={() => {
                  personDel(index);
                }}
              />
            </td>
          </tr>
        ))}
      </table>
    </div>
  );
}

export default App;
