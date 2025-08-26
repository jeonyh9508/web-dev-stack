const signup = document.querySelector("#register");

const fields = [
  {
    id: "id",
    exp: /^[a-zA-Z][a-zA-Z0-9]{3,11}$/,
    message: "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내",
  },
  {
    id: "pwd",
    exp: /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/,
    message: "영문자, 숫자, 특수문자 조합으로 8~15자 이내",
  },
  {
    id: "pwdCheck",
    message: "위 비밀번호와 동일하게",
  },
  {
    id: "userName",
    exp: /^[가-힣]{2,}$/,
    message: "한글 2자 이상",
  },
  {
    id: "userEmail",
    exp: /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$/,
    message: "이메일 형식",
  },
  {
    id: "userNumber",
    exp: /^010-\d{4}-\d{4}$/,
    message: "전화번호 형식 (010-0000-0000)",
  },
];

const validCheck = () => {
  let check = true; // 모든 필드가 유효하다고 가정
  fields.forEach(({ id, exp }) => {
    const input = document.querySelector(`#${id}`);
    if (input.value === "") {
      check = false;
    } else if (id !== "pwdCheck" && !exp?.test(input.value)) {
      check = false;
    }
    // password : passwordCheck.value !== e.target.value
    if (id === "pwd" && pwdCheck.value !== input.value) {
      check = false;
    }
  });

  return check;
};

const pwd = document.querySelector("#pwd");
const pwdSpan = document.querySelector("#pwd+span");
const pwdCheck = document.querySelector("#pwdCheck");
const pwdCheckSpan = document.querySelector("#pwdCheck+span");

const pwdRegExp =
  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/;
pwd.addEventListener("input", (e) => {
  if (pwdRegExp.test(e.target.value)) {
    pwdSpan.innerHTML = "OK!";
    pwdSpan.style.color = "green";
  } else if (e.target.value === "") {
    pwdSpan.innerHTML = "영문자, 숫자, 특수문자 조합으로 8~15자 이내";
    pwdSpan.style.color = "white";
  } else {
    pwdSpan.innerHTML = "영문자, 숫자, 특수문자 조합으로 8~15자 이내";
    pwdSpan.style.color = "red";
  }

  if (pwdCheck.value === e.target.value) {
    pwdCheckSpan.innerHTML = "OK";
    pwdCheckSpan.style.color = "green";
  } else {
    pwdCheckSpan.innerHTML = "위 비밀번호와 동일하게";
    pwdCheckSpan.style.color = "red";
  }
 
});

fields.forEach(({ id, exp, message }) => {
  const input = document.querySelector(`#${id}`);
  const span = document.querySelector(`#${id}+span`);
  const regExp = exp;
  const pwd = document.querySelector("#pwd");
  const pwdRegExp = fields[1].exp;
  input.addEventListener("input", (e) => {
    if (
      (id === "pwdCheck" &&
        pwdRegExp.test(pwd.value) &&
        pwd.value === e.target.value) ||
      (exp !== undefined && regExp?.test(e.target.value))
      // ? 기호를 사용할 경우, null이 아니면 조건이 돌아가게끔 한다.
      // 해당 내용에 대한 추가 탐색 필요
    ) {
      span.innerHTML = "OK!";
      span.style.color = "green";
    } else if (e.target.value === "") {
      span.innerHTML = message;
      span.style.color = "white";
    } else {
      span.innerHTML = message;
      span.style.color = "red";
    }

    // password
    const pwdCheck = document.querySelector("#pwdCheck");
    const pwdCheckSpan = document.querySelector("#pwdCheck+span");
    if (id === "pwd") {
      if (pwdCheck.value === e.target.value) {
        pwdCheckSpan.innerHTML = "OK";
        pwdCheckSpan.style.color = "green";
      } else {
        pwdCheckSpan.innerHTML = "위 비밀번호와 동일하게";
        pwdCheckSpan.style.color = "red";
      }
    }
    // every : 배열 안에 특정 조건이 모두 만족할 경우 true
	signup.disabled = !validCheck();
  });
});

const cancel = document.querySelector("#cancel");
cancel.addEventListener("click", () => {
  fields.forEach(({ id, message }) => {
    const span = document.querySelector(`#${id}+span`);
    span.innerHTML = message;
    span.style.color = "white";
  });
});
