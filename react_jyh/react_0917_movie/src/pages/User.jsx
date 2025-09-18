import axios from "axios";
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import Spinner from "../components/Spinner";
import UserList from "../components/UserList";

const User = () => {
  const [user, setUser] = useState("");
  //   const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const { id } = useParams();
  //   alert("id : " + id);

  useEffect(() => {
    // 웹에 준비되어 있는 유저 정보(JSON)를 가져온다
    axios
      .get("https://jsonplaceholder.typicode.com/users/" + id)
      .then((response) => {
        setUser(response.data);
        setLoading(false);
      });
  });

  const userDetail = loading ? (
    <Spinner />
  ) : (
    <div>
      <div>{user.name}</div>
      <div>{user.email}</div>
      <div>{user.phone}</div>
    </div>
  );

  return (
    <div>
      <h1>유저 정보</h1>
      {userDetail}
    </div>
  );
};
export default User;
