// 클릭을 누를때마다 클릭 옆에 숫자+
// restart를 누르면 초기화면

window.addEventListener("DOMContentLoaded", () => {
  const img1 = document.querySelector("#spy1");
  const img = document.querySelectorAll("img");
  const img2 = document.querySelector("#spy2");
  const img3 = document.querySelector("#spy3");
  const answer = document.querySelector("#answer");

  // src 속성! 속성값 변경하는 setAttribute
  // 속성 추가 ( .setAttribute(속성명, 속성값) ) & 수정
  //그림 바꾸기, 랜덤까지
  const random1 = Math.floor(Math.random() * img.length + 1);
  img1.setAttribute("src", `./assets/spy${random1}.jpg`);
  const random2 = Math.floor(Math.random() * img.length + 1);
  img2.setAttribute("src", `./assets/spy${random2}.jpg`);
  const random3 = Math.floor(Math.random() * img.length + 1);
  img3.setAttribute("src", `./assets/spy${random3}.jpg`);

  //정답 출력
  if (random1 === random2 && random2 === random3) {
    console.log("축하");
  } else {
    answer.style.display = "none";
  }
});
