import { useState } from "react";
import TodoList from "./conponents/todoList";

function App() {
  const [todoList, setTodoList] = useState([]);
  const [todo, setTodo] = useState("");
  const [due, setDue] = useState("");

  function addTodo() {
    if (todo.length && due.length) {
      setTodoList([...todoList, { todo, due }]);
      setTodo("");
      setDue("");
    }
  }

  function removeTodo(index) {
    setTodoList(todoList.filter((res, i) => i !== index));
  }
  return (
    <div className="App">
      <h1>할 일 목록</h1>
      <input
        type="text"
        value={todo}
        placeholder="할 일 입력"
        onChange={(e) => {
          setTodo(e.target.value);
        }}
      />
      <br />
      <input type="date" value={due} onChange={(e) => setDue(e.target.value)} />
      <input type="button" value="추가" onClick={addTodo} />
      <hr />
      <TodoList todoList={todoList} removeTodo={removeTodo} />
    </div>
  );
}

export default App;
