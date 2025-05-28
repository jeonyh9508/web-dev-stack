// 클릭을 누를때마다 클릭 옆에 숫자+
// restart를 누르면 초기화면
// 문제 -> 새로고침을 할땐 첫 화면 answer 출력, 클릭 -> display none 이 저장됨.
window.addEventListener("DOMContentLoaded", () => {
  const img = document.querySelectorAll("img");
  const img1 = document.querySelector("#spy1");
  const img2 = document.querySelector("#spy2");
  const img3 = document.querySelector("#spy3");
  const answer = document.querySelector("#answer");

  const game = () => {
    const random1 = Math.floor(Math.random() * img.length + 1);
    img1.setAttribute("src", `./assets/spy${random1}.jpg`);
    const random2 = Math.floor(Math.random() * img.length + 1);
    img2.setAttribute("src", `./assets/spy${random2}.jpg`);
    const random3 = Math.floor(Math.random() * img.length + 1);
    img3.setAttribute("src", `./assets/spy${random3}.jpg`);

    for (let i = 0; i < img.length; i++) {
      if (random1 !== random2 || random2 !== random3) {
        answer.innerHTML = "";
      } else {
        answer.innerHTML =
          "축하합니다! 다시 시작하려면 재시작 버튼을 눌러주세요!";
      }
    }
  };
  game();

  let count = 0;
  let tried = 1;
  const click = document.querySelector("#click");
  click.addEventListener("click", () => {
    game();
    count += tried;
    click.innerHTML = `Click ${count}`;
  });

  const restart = document.querySelector("#restart");
  restart.addEventListener("click", () => {
    location.reload();
  });
});
