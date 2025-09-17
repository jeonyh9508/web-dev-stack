import { useState } from "react";

function TodoList(props) {
  return (
    <table border="1px">
      <thead>
        <tr>
          <th>할 일</th>
          <th>마감일</th>
          <th>작업</th>
        </tr>
      </thead>
      <tbody>
        {props.todoList.map((todoList, index) => (
          <tr>
            <td>{todoList.todo}</td>
            <td>{todoList.due}</td>
            <td>
              <input
                type="button"
                value="삭제"
                onClick={(e) => {
                  e.preventDefault();
                  console.log(index);
                  props.removeTodo(index);
                }}
              />
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}
export default TodoList;
