const currentTime = () => {
  const weeks = ["일", "월", "화", "수", "목", "금", "토"];
  const today = new Date(); //내장객체
  /*
console.log(today);
console.log(today.getFullYear()); // 년
console.log(today.getMonth() + 1); // 월 (0 : 1월, 1 : 2월 ~)
console.log(today.getDate()); // 일
console.log(today.getDay()); // 요일 (0 : 일, 1 : 월 ~)
console.log(weeks[today.getDay()]);
*/
  const year = today.getFullYear();
  const month = today.getMonth() + 1;
  const day = today.getDate();
  const week = weeks[today.getDay()];

  const current = document.querySelector("#current");
  current.innerHTML = `${year}년 ${month}월 ${day}일 (${week})`;

  const time = document.querySelector("#id2");
  const hour = String(today.getHours()).padStart(2, "0"); // 시
  const min = String(today.getMinutes()).padStart(2, "0"); // 분
  const sec = String(today.getSeconds()).padStart(2, "0"); // 초 padStart(최대자릿수, 빈공간을 채울 숫자)
  time.innerHTML = `${hour}:${min}:${sec}`;
};
const randomBackground = () => {
  const body = document.body;
  /*
  const backGround = [
    "#ED833A",
    "#EA839B",
    "#42B667",
    "#FFC228",
    "#005456",
    "#ACDED5",
  ];

  body.style.background =
    backGround[Math.floor(Math.random() * backGround.length)];
    */
  const r = Math.floor(Math.random() * 256); //random = 256
  const g = Math.floor(Math.random() * 256);
  const b = Math.floor(Math.random() * 256);
  body.style.background = `rgba(${r},${g},${b},0.4)`;
};

const count = () => {
  const last = new Date("2026-01-01 00:00:00"); // 목표하는 날짜
  const now = new Date(); // 현재
  // console.log(Math.floor((last - now) / 1000)); // 1초 = 밀리초 /1000
  const sec = Math.floor((last - now) / 1000);
  const min = Math.floor(sec / 60); // 60초 = 1분
  const hour = Math.floor(min / 60); //60분 = 1시간
  const day = Math.floor(hour / 24); //24시간 = 1일
  /*
  console.log(day);
  console.log(hour % 24);
  console.log(min % 60);
  console.log(sec % 60);
  */
  const count = document.querySelector("#id3");
  count.innerHTML = `올해 남은 시간 ${day}일 
                    ${String(hour % 24).padStart(2, "0")}시간 
                    ${String(min % 60).padStart(2, "0")}분
                    ${String(sec % 60).padStart(2, "0")}초`;
};

const randomQuote = () => {
  const random = quotes[Math.floor(Math.random() * quotes.length)];
  const quoteE = document.querySelector("#id4");
  const quoteK = document.querySelector("#id5");
  /*
  console.log(random.en);
  console.log(random.ko);
  */
  quoteE.textContent = random.en;
  quoteK.textContent = random.ko;
};

randomBackground();
currentTime();
count();
randomQuote();

setInterval(() => {
  currentTime();
  count();
}, 1000); // 1000 => 1초

setInterval(() => {
  randomBackground();
  randomQuote();
}, 3000);
