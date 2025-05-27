const id1 = document.querySelector("#id1");
const date1 = new Date();

const day1 = date1.getDay();
console.log(day1);

switch (day1) {
  case 1:
    console.log("월");
    break;
  case 2:
    console.log("화");
    break;
  case 3:
    console.log("수");
    break;
  case 4:
    console.log("목");
    break;
  case 5:
    console.log("금");
    break;
  case 6:
    console.log("토");
    break;
  case 0:
    console.log("일");
    break;
}

id1.innerHTML = `${date1.getFullYear()}년 ${
  date1.getMonth() + 1
}월 ${date1.getDate()}일 (${day1})`;

const id2 = document.querySelector("#id2");
const time1 = new Date();
console.log(time1.getSeconds());
id2.innerHTML = `${time1.getHours()}:${time1.getMinutes()}:${time1.getSeconds()}`;
