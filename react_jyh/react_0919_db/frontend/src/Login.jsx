import React, { useState } from "react";
import { Link } from "react-router-dom";
import LoginValidation from "./LoginValidation";
import axios from "axios";
function Login() {
  // useState({}) -> json 형태로 관리
  const [values, setValues] = useState({
    email: "",
    password: "",
  });

  const [errors, setErrors] = useState();

  // 유효성 검사
  const handleSubmit = (e) => {
    // 새로고침 방지
    e.preventDefault();

    // 유효성 검사
    setErrors(LoginValidation(values));

    // 로그인 정보 서버에 전송
    axios.post("http://localhost:3000/login", values).then((res) => {
      if (res.data == "Success") {
        // 성공시 main_content
        window.location.href = "/main_content";
      } else {
        // 실패시 alert
        alert("아이디나 비밀번호가 일치하지 않습니다.");
      }
    });
  };

  const handleInput = (e) => {
    // input 값이 변경(onChange)되면 기존 values에 덮어 씌우기 -> setValues
    setValues({ ...values, [e.target.name]: [e.target.value] });
  };

  return (
    <div className="d-flex justify-content-center align-items-center bg-dark vh-100">
      <div className="bg-white p-3 rounded w-25">
        <form action="" onSubmit={handleSubmit}>
          <div className="mb-3">
            <label>Email</label>
            <input
              placeholder="enter email"
              name="email"
              onChange={handleInput}
            />
          </div>

          <div className="mb-3">
            <label>Password</label>
            <input
              type="password"
              placeholder="enter password"
              name="password"
              onChange={handleInput}
            />
          </div>

          <button type="submit" className="btn btn-success">
            로그인
          </button>

          <p>계정이 없으신가요??</p>
          <Link to="/signup" className="btn btn-default border">
            회원 가입
          </Link>
        </form>
      </div>
    </div>
  );
}
export default Login;
