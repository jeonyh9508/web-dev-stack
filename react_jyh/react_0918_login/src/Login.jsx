import React, { useState } from "react";
import MainPage from "./MainPage";
import LoginForm from "./LoginForm";
const User = {
  email: "test@a.com",
  pw: "1234",
};

export default function Login() {
  const [isLogin, setLogin] = useState(false);
  const [email, setEmail] = useState("");
  return (
    <div>
      {isLogin ? (
        <MainPage email={email} />
      ) : (
        <LoginForm email={setEmail} user={User} login={setLogin} />
      )}
    </div>
  );
}
