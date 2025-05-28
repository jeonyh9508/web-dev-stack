//DomContentLoaded 이벤트는 HTML 문서의 구조가 완전히 로드된 후 실행

window.addEventListener("DOMContentLoaded", () => {
  const h1 = document.querySelector("h1");
  h1.style.color = "blue";

  // 클릭 이벤트

  const click = document.querySelector("#click");
  click.addEventListener("click", () => {
    // 클릭 이벤트가 일어나면 행하고자 하는 코드 작성
    alert("클릭 이벤트 발생");
    // click 색상을 변경
    click.style.background = "red";
  });

  const double = document.querySelector("#double");
  double.addEventListener("dblclick", () => {
    alert("더블 클릭 발생");
  });

  const right = document.querySelector("#right");
  right.addEventListener("contextmenu", (event) => {
    alert("우클릭 발생");
    // console.log(event);
    event.preventDefault(); // 우클릭 방지
  });

  const hover = document.querySelector("#hover");
  hover.addEventListener("mouseenter", () => {
    console.log("mouseenter!");
    // 배경색상은 lightblue, 텍스트는 Mouse Enter! 변경
    hover.style.background = "lightblue";
    hover.innerHTML = "Mouse Enter!";
  });
  hover.addEventListener("mouseleave", () => {
    console.log("mouseleave!");
    // 배경색상은 navy, 텍스트는 Mouse Leave! 변경
    hover.style.background = "navy";
    hover.innerHTML = "Mouse Leave!";
  });

  // 폼 이벤트
  const input = document.querySelector("#input");
  input.addEventListener("input", (e) => {
    console.log(e.target.value);
    const p = document.querySelector("#inputResult");
    p.innerHTML = e.target.value;
  });
});
