// 아이디 : /^[a-zA-Z][a-zA-Z0-9]{3,11}$/
// 비밀번호 : /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/
// 이름 : /^[가-힣]{2,}$/
// 이메일 : /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$/
// 전화번호 : /^010-\d{4}-\d{4}$/

const id = document.querySelector("#id");
const idResult = document.querySelector("#idResult");
const pw = document.querySelector("#pw");
const pwResult = document.querySelector("#pwResult");
const pwc = document.querySelector("#pwc");
const pwcResult = document.querySelector("#pwcResult");
const name = document.querySelector("#name");
const nameResult = document.querySelector("#nameResult");
const mail = document.querySelector("#mail");
const mailResult = document.querySelector("#mailResult");
const tel = document.querySelector("#tel");
const telResult = document.querySelector("#telResult");

id.addEventListener("input", (e) => {
  const idCheck = /^[a-zA-Z][a-zA-Z0-9]{3,11}$/;

  switch (idCheck.test(e.target.value)) {
    case true:
      idResult.innerHTML = "OK!";
      idResult.style.color = "green";
      break;
    case false:
      idResult.innerHTML = "다시 입력해주세요";
      idResult.style.color = "red";
      break;
  }
});
pwc.addEventListener("");
pw.addEventListener("input", (e) => {
  const pwCheck =
    /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/;
  console.log(e.target.value);

  pw.setAttribute("type", "password");

  if (pwCheck.test(e.target.value)) {
    pwResult.innerHTML = "OK!";
    pwResult.style.color = "green";
  } else {
    pwResult.innerHTML = "다시 입력해주세요";
    pwResult.style.color = "red";
  }
  pwc.addEventListener("input", (e) => {
    console.log(pw.value);
  });
});
