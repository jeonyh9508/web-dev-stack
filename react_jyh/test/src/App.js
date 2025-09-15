import { useState } from "react";
import logo from "./logo.svg";

function App() {
  let [menu, setMenu] = useState(null);
  let content = null;

  let menu_list = [
    { id: 0, name: "메뉴" },
    { id: 1, name: "짜장" },
    { id: 2, name: "짬뽕" },
    { id: 3, name: "탕수육" },
    { id: 4, name: "유산슬" },
  ];

  if (menu === 0) {
    content = <Child desc="내용 없음"></Child>;
  } else if (menu !== 0) {
    for (let i = 0; i < menu_list.length; i++) {
      if (menu === menu_list[i].id) {
        content = <Child desc={menu_list[i].name + "을 선택함"}></Child>;
      }
    }
  }

  return (
    <div className="App">
      <Header />
      <Select
        menu={menu_list}
        onChangeMode={(id) => {
          setMenu(id);
        }}
      ></Select>
      {content}
    </div>
  );
}
function Header() {
  return (
    <header>
      <h1>메뉴선택</h1>
    </header>
  );
}

function Select(props) {
  let menu_select = [];
  for (let i = 0; i < props.menu.length; i++) {
    let j = props.menu[i];
    menu_select.push(<option value={j.id}>{j.name}</option>);
  }

  return (
    <select
      onChange={(e) => {
        props.onChangeMode(Number(e.target.value));
      }}
    >
      {menu_select}
    </select>
  );
}
function Child(props) {
  return (
    <div>
      <p>{props.desc}</p>
    </div>
  );
}
export default App;
