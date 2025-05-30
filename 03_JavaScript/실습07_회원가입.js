// 아이디 : /^[a-zA-Z][a-zA-Z0-9]{3,11}$/
// 비밀번호 : /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/
// 이름 : /^[가-힣]{2,}$/
// 이메일 : /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$/
// 전화번호 : /^010-\d{4}-\d{4}$/

const id = document.querySelector("#id");
const idResult = document.querySelector(".idResult");
const pw = document.querySelector("#pw");
const pwResult = document.querySelector(".pwResult");
const pwc = document.querySelector("#pwc");
const pwcResult = document.querySelector(".pwcResult");
const name = document.querySelector("#name");
const nameResult = document.querySelector(".nameResult");
const mail = document.querySelector("#mail");
const mailResult = document.querySelector(".mailResult");
const tel = document.querySelector("#tel");
const telResult = document.querySelector(".telResult");

let check1 = false;
let check2 = false;
let check3 = false;
let check4 = false;
let check5 = false;
let check6 = false;

let allCheck = [check1, check2, check3, check4, check5, check6];

const info = () => {
  id.addEventListener("input", (e) => {
    const idCheck = /^[a-zA-Z][a-zA-Z0-9]{3,11}$/;

    switch (idCheck.test(e.target.value)) {
      case true:
        idResult.innerHTML = "OK!";
        idResult.style.color = "green";
        idResult.setAttribute("class", "ok");
        check1 = true;
        break;
      case false:
        idResult.innerHTML = "다시 입력해주세요";
        idResult.style.color = "red";
        check1 = false;
        break;
    }
  });

  pw.addEventListener("input", (e) => {
    const pwCheck =
      /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/;
    // console.log(e.target.value);

    pw.setAttribute("type", "password");

    if (pwCheck.test(e.target.value)) {
      pwResult.innerHTML = "OK!";
      pwResult.style.color = "green";
      pwResult.setAttribute("class", "ok");
      check2 = true;
    } else {
      pwResult.innerHTML = "다시 입력해주세요";
      pwResult.style.color = "red";
      check2 = false;
    }
  });

  pwc.addEventListener("input", (e) => {
    const pwcCheck =
      /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/;
    pwc.setAttribute("type", "password");

    if (pwcCheck.test(e.target.value)) {
      if (pw.value === pwc.value) {
        pwcResult.innerHTML = "OK!";
        pwcResult.style.color = "green";
        pwcResult.setAttribute("class", "ok");
        check3 = true;
      }
    } else {
      pwcResult.innerHTML = "다시 입력해주세요";
      pwcResult.style.color = "red";
      check3 = false;
    }
  });

  name.addEventListener("input", (e) => {
    const nameCheck = /^[가-힣]{2,}$/;

    if (nameCheck.test(e.target.value)) {
      nameResult.innerHTML = "OK!";
      nameResult.style.color = "green";
      nameResult.setAttribute("class", "ok");
      check4 = true;
    } else {
      nameResult.innerHTML = "다시 입력해주세요";
      nameResult.style.color = "red";
      check4 = false;
    }
  });

  mail.addEventListener("input", (e) => {
    const mailCheck = /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$/;

    if (mailCheck.test(e.target.value)) {
      mailResult.innerHTML = "OK!";
      mailResult.style.color = "green";
      mailResult.setAttribute("class", "ok");
      check5 = true;
    } else {
      mailResult.innerHTML = "다시 입력해주세요";
      mailResult.style.color = "red";
      check5 = false;
    }
  });

  tel.addEventListener("input", (e) => {
    const telCheck = /^010-\d{4}-\d{4}$/;

    if (telCheck.test(e.target.value)) {
      telResult.innerHTML = "OK!";
      telResult.style.color = "green";
      telResult.setAttribute("class", "ok");
      check6 = true;
    } else {
      telResult.innerHTML = "다시 입력해주세요";
      telResult.style.color = "red";
      check6 = false;
    }
  });
};

info();

const p = document.querySelectorAll("p");
const member = document.querySelector("#member");
const cancel = document.querySelector("#cancel");

member.addEventListener("click", () => {});
