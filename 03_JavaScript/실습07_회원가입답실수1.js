// 아이디 : /^[a-zA-Z][a-zA-Z0-9]{3,11}$/
// 비밀번호 : /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/
// 이름 : /^[가-힣]{2,}$/
// 이메일 : /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$/
// 전화번호 : /^010-\d{4}-\d{4}$/

const userId = document.querySelector("#userId");
const userSpan = document.querySelector("#userId+span");
const userRegExp = /^[a-zA-Z][a-zA-Z0-9]{3,11}$/;

userId.addEventListener("input", (e) => {
  //   console.log(userRegExp.test(e.target.value));
  if (userRegExp.test(e.target.value)) {
    userSpan.innerHTML = "OK!";
    userSpan.style.color = "green";
  } else if (e.target.value === "") {
    userSpan.innerHTML = "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내";
    userSpan.style.color = "black";
  } else {
    userSpan.innerHTML = "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내";
    userSpan.style.color = "red";
  }
});

const password = document.querySelector("#password");
const passwordSpan = document.querySelector("#password+span");
const passwordCheck = document.querySelector("#passwordCheck");
const passwordCheckSpan = document.querySelector("#passwordCheck+span");

const passwordRegExp =
  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/;

password.addEventListener("input", (e) => {
  if (passwordRegExp.test(e.target.value)) {
    passwordSpan.innerHTML = "OK!";
    passwordSpan.style.color = "green";
  } else if (e.target.value === "") {
    passwordSpan.innerHTML = "영문자, 숫자, 특수문자 조합으로 8~15자 이내";
    passwordSpan.style.color = "black";
  } else {
    passwordSpan.innerHTML = "영문자, 숫자, 특수문자 조합으로 8~15자 이내";
    passwordSpan.style.color = "red";
  }
  if (passwordRegExp.test(password.value) && passwordCheck.value !== "") {
    if (password.value === e.target.value) {
      passwordCheckSpan.innerHTML = "OK!";
      passwordCheckSpan.style.color = "green";
    } else {
      passwordCheckSpan.innerHTML = "위 비밀번호와 동일하게";
      passwordCheckSpan.style.color = "red";
    }
  }
});
/* if (passwordCheck.value !== "" && e.target.value !== passwordCheck.value) {
    passwordCheckSpan.innerHTML = "위 비밀번호와 동일하게";
    passwordCheckSpan.style.color = "red";
  }

  if (passwordCheck.value === e.target.value) {
    passwordCheckSpan.innerHTML = "OK!";
    passwordCheckSpan.style.color = "green";
  }
});*/

// passwordRegExp.test(password.value) &&
/*
if (e.target.value === "") {
      passwordCheckSpan.innerHTML = "위 비밀번호와 동일하게";
      passwordCheckSpan.style.color = "black";}
*/

passwordCheck.addEventListener("input", (e) => {
  if (passRegExp.test(password.value) && password.value === e.target.value) {
    passwordCheckSpan.innerHTML = "OK!";
    passwordCheckSpan.style.color = "green";
  } else if (e.target.value === "") {
    passwordCheckSpan.innerHTML = "위 비밀번호와 동일하게";
    passwordCheckSpan.style.color = "black";
  } else {
    passwordCheckSpan.innerHTML = "위 비밀번호와 동일하게";
    passwordCheckSpan.style.color = "red";
  }
});

const userName = document.querySelector("#userName");
const userNameSpan = document.querySelector("#userName+span");
const userNameRegExp = /^[가-힣]{2,}$/;

userName.addEventListener("input", (e) => {
  if (userNameRegExp.test(e.target.value)) {
    userNameSpan.innerHTML = "OK!";
    userNameSpan.style.color = "green";
  } else {
    userNameSpan.innerHTML = "한글 2자 이상";
    userNameSpan.style.color = "red";
  }
});
