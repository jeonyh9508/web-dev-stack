import React, { useState, useEffect } from "react";
import axios from "axios";
import UserList from "../components/UserList";
import Spinner from "../components/Spinner";

const Users = () => {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  useEffect(() => {
    // 웹에 준비되어 있는 유저 정보(JSON)를 가져온다
    axios.get("https://jsonplaceholder.typicode.com/users").then((response) => {
      setUsers(response.data);
      setLoading(false);
    });
  });
  return (
    <div>
      <h1>유저 목록 페이지</h1>
      {loading ? <Spinner /> : <UserList users={users} />}
    </div>
  );
};
export default Users;
