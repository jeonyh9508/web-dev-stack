// 1번 문제
const result1 = document.querySelector("#result1");
function printText() {
  result1.textContent = "안녕하세요";
}

// 2번 문제
const result2 = document.querySelector("#result2");
const costomer = document.querySelector("#customer");
function printInputValue() {
  // input 값 (customer)을 가져오기
  console.log(customer.value);
  // 가지고 와서 result2 출력
  result2.textContent = costomer.value;
  // input 값(customer.value)을 비우기
  costomer.value = "";
}

// 3번 문제
const divTest = document.querySelector(".div-test");
function changeColor() {
  // 선택한 divTest 에 배경색을 변경
  divTest.style.backgroundColor = "yellow";
}

// 4번 문제
const text = document.querySelector("#text");
const result4 = document.querySelector("#result4");
function stringLength() {
  // 입력받은 text에서 글자를 글자수 가져오기
  // 글자수를 result4에 출력
  result4.textContent = text.value.length;
  text.value = "";
}

// 5번 문제
const la = document.querySelector("#la");
const result5 = document.querySelector("#result5");
function stringSplit() {
  // 1. "사과, 바나나, 오렌지, 포도" 문자 가져오기
  //   console.log(la.innerHTML);
  const laText = la.innerHTML;

  // 2. 가지고 온 문자열 구분자(,)분리하기 > 배열로 만들기
  //   console.log(laText.split(","));
  const laArr = laText.split(",");

  // 6. ul 태그 만들기
  const ul = document.createElement("ul");

  // 3. 배열 값 하나씩 가져오기 -> 반복문
  for (let i = 0; i < laArr.length; i++) {
    // console.log(laArr[i]);
    // 4. li 태크 만들기
    const li = document.createElement("li");
    // 5. li 태그에 값 넣기
    li.innerHTML = laArr[i];
    // console.log(li);

    // 7. ul 태그에 만들어 놓은 li 태그들 추가하기
    // ul.appendChild(li);
    // ul.innerHTML = "<li>" + laArr[i] + "</li>";
    ul.innerHTML += `<li>${laArr[i]}</li>`;
  }
  console.log(ul);
  //  8. result5에 ul 담기
  result5.appendChild(ul);
}

// 6번 문제

const preview = document.querySelector("#preview");
const remove = document.querySelector("#remove");
const acc = document.querySelector("#add");
function arrayTest() {
  // 피자 치킨 떡볶이 <- 배열로 만들기
  //   console.log(preview.innerHTML.split(" "));
  const preArr = preview.innerHTML.split(" ");

  // 1. 기억 안나면 일단 반복문
  /*
   for (let i = 0; i < preArr.length; i++) {
    // 이미 가지고 있는 값에서 내가 삭제할 값이 일치하면 배열에서 제거
    // console.log(preArr[i] === "피자");
    if (preArr[i] === remove.value) {
      preArr.splice(i, 1);
    }
  }  
  // 배열 -> 문자열
  //console.log(preArr.join(" "));
  preview.textContent = preArr.join(" ");
*/

  // 2. 배열에서 제거 : splice(인덱스, 1)

  const delIdx = preArr.indexOf(remove.value); //삭제할 인덱스
  console.log(delIdx);
  //   if (delIdx !== -1) preArr.splice(delIdx, 1);

  // +)추가
  console.log(preArr.includes(remove.value));
  if (preArr.includes(remove.value)) preArr.splice(delIdx, 1);

  // 배열 -> 문자열
  console.log(preArr.join(" "));
  preview.textContent = preArr.join(" ");
  remove.value = "";

  // 추가 -> 배열에 해당 값 추가! push
  preArr.push(add.value);
  preview.textContent = preArr.join(" ");

  add.value = "";
}

// 7번 문제
const names = document.querySelectorAll(".name");
const ages = document.querySelectorAll(".age");
const addrs = document.querySelectorAll(".addr");
function addStudent() {
  for (let i = 0; i < 3; i++) {
    const name = prompt(`${i + 1}번째 학생 이름`);
    const age = prompt(`${i + 1}번째 나이`);
    const addr = prompt(`${i + 1}번쨰 주소`);
    names[i].textContent = name;
    ages[i].textContent = age;
    addrs[i].textContent = addr;
  }
}

// 8번
const list = document.querySelector("#list");
function addItem() {
  // 1. li 태그를 만들어서 추가하는 방식
  const li = document.createElement("li");
  li.textContent = "테스트";
  list.appendChild(li);

  // 2. innerHTML로 문자로 추가하는 방식
  list.innerHTML += "<li>테스트</li>";
}

function removeItem() {
  // 1. 부모에서 제거
  console.log(list.childNodes);
  //   list.removeChild(list.childNodes[0]);

  // 2. 본인이 제거
  const li = document.querySelector("#list li");
  console.log(li);
  li.remove();
}

// 9번
const result9 = document.querySelector("#result9");
function toggleClass() {
  result9.classList.toggle("active");
}

// 10번
const item = document.querySelector("#item");
const price = document.querySelector("#price");
const cart = document.querySelector("#cart");
const total = document.querySelector("#total span");
let sum = 0;
function addToCart() {
  cart.innerHTML += `<li>${item.value} - ${price.value}</li>`;

  console.log(isNaN(Number(price.value))); //NaN
  if (!isNaN(Number(price.value))) sum += Number(price.value);
  total.innerHTML = sum;
  console.log(sum);

  item.value = "";
  price.value = "";
}

// 자바스크립트는 MDN
