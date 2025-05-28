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
console.log(day1);

const id2 = document.querySelector("#id2");

const time1 = new Date();
const hour = time1.getHours();
const minute = time1.getMinutes();
const sec = time1.getSeconds();
id2.innerHTML = `${hour}:${minute}:${sec}`;
