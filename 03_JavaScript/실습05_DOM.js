const time = () => {
  const id1 = document.querySelector("#id1");

  const date1 = new Date();

  const day1 = date1.getDay();
  switch (day1) {
    case 1:
      id1.innerHTML = `${date1.getFullYear()}년 ${
        date1.getMonth() + 1
      }월 ${date1.getDate()}일 (월)`;
      break;

    case 2:
      id1.innerHTML = `${date1.getFullYear()}년 ${
        date1.getMonth() + 1
      }월 ${date1.getDate()}일 (화)`;
      break;

    case 3:
      id1.innerHTML = `${date1.getFullYear()}년 ${
        date1.getMonth() + 1
      }월 ${date1.getDate()}일 (수)`;
      break;

    case 4:
      id1.innerHTML = `${date1.getFullYear()}년 ${
        date1.getMonth() + 1
      }월 ${date1.getDate()}일 (목)`;
      break;

    case 5:
      id1.innerHTML = `${date1.getFullYear()}년 ${
        date1.getMonth() + 1
      }월 ${date1.getDate()}일 (금)`;
      break;

    case 6:
      id1.innerHTML = `${date1.getFullYear()}년 ${
        date1.getMonth() + 1
      }월 ${date1.getDate()}일 (토)`;
      break;

    case 0:
      id1.innerHTML = `${date1.getFullYear()}년 ${
        date1.getMonth() + 1
      }월 ${date1.getDate()}일 (일)`;
      break;
  }

  const id2 = document.querySelector("#id2");

  const time1 = new Date();
  const hour = String(time1.getHours()).padStart(2, "0");
  const minute = String(time1.getMinutes()).padStart(2, "0");
  const sec = String(time1.getSeconds()).padStart(2, "0");
  id2.innerHTML = `${hour}:${minute}:${sec}`;
};

const back = () => {
  const back = document.body;
  const num1 = Math.floor(Math.random() * 256);
  const num2 = Math.floor(Math.random() * 256);
  const num3 = Math.floor(Math.random() * 256);
  back.style.background = `rgba(${num1},${num2},${num3},0.4)`;
};

const count = () => {
  const count = new Date("2026-01-01 00:00:00");
  const day = new Date();
  const dday = count - day;
  console.log(dday);
};

count();
back();
time();

setInterval(() => {
  time();
}, 1000);
setInterval(() => {
  back();
}, 3000);
