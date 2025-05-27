// 1번 문제
function printText() {
  const div = document.querySelector("#result1");
  div.textContent = "안녕하세요";
  //   const p = document.createElement("p");
  //   p.textContent = "안녕하세요";
  //   div.appendChild(p);
}

// 2번 문제
const customer = document.querySelector("#customer");
function printInputValue() {
  const div = document.querySelector("#result2");
  const p = document.createElement("p");
  p.textContent = customer.value;
  div.appendChild(p);
}

// 3번 문제
function changeColor() {
  const div = document.querySelector(".div-test");
  div.style.backgroundColor = "red";
}

// 4번 문제

function stringLength() {
  const arr = [];
  const text = document.querySelector("#text");
  const div = document.querySelector("#result4");
  arr.push(text.value);
  div.textContent = arr[0].length;
}

// 5번 문제
function stringSplit() {
  const la = document.querySelector("#la");
  const div = document.querySelector("#result5");
  const strToArr = la.innerHTML.split(",");
  const ul = document.createElement("ul");

  for (let i = 0; i < strToArr.length; i++) {
    ul.innerHTML += `<li>${strToArr[i]}</li>`;
  }
  div.appendChild(ul);
}

// 6번 문제
const preview = document.querySelector("#preview");
function arrayTest() {
  console.log(preview.innerHTML);
}

// 7번 문제 :prompt로 이름, 나이 주소 순으로 입력받아 출력 3명
function addStudent() {}

// 8번
function addItem() {}

// 9번
function toggleClass() {}

// 10번
function addToCart() {}
