import React from "react";

// 회원가입 / 로그인 유효성(공란) 검사 function
// 공란 시 alert
function LoginValidation(props) {
  if (props.name == "") {
    alert("이름을 입력하세요");
    return;
  }
  if (props.email == "") {
    alert("이메일을 입력하세요");
    return;
  }

  if (props.password == "") {
    alert("비밀번호를 입력하세요");
    return;
  }
}
export default LoginValidation;
