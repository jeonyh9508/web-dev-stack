const click = document.querySelector("section button:first-child");
const img = document.querySelectorAll("img");
const span = document.querySelector("button span");
const h2 = document.querySelector("h2");
const restart = document.querySelector("section button:last-child");

// click 클릭 이벤트를 걸어야함.

// img 내가 클릭을 했을 때 바뀌어야 함
let count = 0;

const game = () => {
  const random = [
    Math.floor(Math.random() * 3) + 1,
    Math.floor(Math.random() * 3) + 1,
    Math.floor(Math.random() * 3) + 1,
  ];
  for (let i = 0; i < img.length; i++) {
    img[i].setAttribute("src", `assets/spy${random[i]}.jpg`);
  }
  span.innerHTML = ++count;

  //이미지 세개가 일치할 경우 버튼 disabled
  // click.disabled = true;
  // click.setAttribute("disabled", "disabled");
  if (random[0] === random[1] && random[1] === random[2]) {
    click.setAttribute("disabled", true);
    h2.style.visibility = "visible";
    //h2에 visibility : visible로 변경
  }
};
const end = () => {
  // 이미지는 처음 그대로 1, 2 ,3 순으로
  for (let i = 0; i < img.length; i++) {
    img[i].setAttribute("src", `assets/spy${i + 1}.jpg`);
  }
  // count = 0 , span은 비우기
  count = 0;
  span.innerHTML = "";
  // h2 visibility = hidden 처리
  h2.style.visibility = "hidden";
  // click 버튼의 disabled = false 처리
  click.disabled = false;
};

click.addEventListener("click", game);
restart.addEventListener("click", () => {
  location.reload();
});
