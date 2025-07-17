// $(document).ready(function () {});
$(function () {
  //   const h1 = document.querySelector("h1");
  const pList = document.querySelectorAll("p");

  //   h1.style.color = "blue";
  //   for (p of pList) {
  // p.style.color = "white";
  // p.style.backgroundColor = "red";
  //   }
  // 제이쿼리 방식
  $("h1").css("color", "blue");
  $("p").css({
    backgroundColor: "red",
    color: "white",
  });
  $("p").first().css("font-size", "4rem");
  $("p").last().css("color", "yellow");
  $("p:eq(2)").text("eq로 수정");
  $("p").eq(3).css("font-weight", "bold");
  $(".wrap").children().css({ color: "aqua", border: "2px solid" });
  $(".wrap").find("h1").css({ color: "greenyellow" });
  $("h1").siblings("p").css("background-color", "navy");

  // DOM 객체
  // 자바스크립트
  const p = document.createElement("p");
  p.innerText = "자바스크립트 추가";
  document.querySelector("#content").appendChild(p);

  // 제이쿼리
  const p2 = $("<p>").html("제이쿼리로 추가");
  $("#content").append(p2);
  // append 해당 자식요소 뒷부분에 추가 (appendTo)
  $("#item").append("<span>append</span>");
  $("<span>appendTo</span>").appendTo("#item");
  // prepend 해당 자식요소 앞부분에 추가
  $("#item").prepend("<span>prepend</span>");
  // after 해당 형제요소로 뒷부분에 추가
  $("#item").after("<span>after</span>");
  // before 해당 형제요소로 앞부분에 추가
  $("#item").before("<span>before</span>");

  /*
  // 이벤트
  // 키 이벤트

  $("#textarea").on({
    // 키보드 눌려질 때
    keydown: (e) => {
      console.log(`keydown - e.key : ${e.key}, e.keyCode : ${e.keyCode}`);
    },
    // 키보드가 입력될 때
    keypress: (e) => {
      console.log(`keypress - e.key : ${e.key}, e.keyCode : ${e.keyCode}`);
    },
    // 키보드 떼어질 때
    keyup: (e) => {
      console.log(`keyup - e.key : ${e.key}, e.keyCode : ${e.keyCode}`);
    },
  });*/

  // 게시판등록
  $("#textarea").keyup((e) => {
    let target = $(e.target);
    let length = target.val().length; // .val(): 값 .length:글자수
    if (length > 50) {
      target.val(target.val().substr(0, 50));
    } else {
      $("#counter").text(length);
    }
  });

  $("#userId").keyup((e) => {
    let id = $(e.target).val(); // 제이쿼리
    id = e.target.value; // 자바스크립트
    const regExp = /^(?=[a-z][a-z0-9]{3,11}$)(?=.*\d)/;
    if (regExp.test(id)) {
      $("#idCheck").text("사용 가능한 아이디 입니다").css("color", "green");
    } else if (id === "") {
      $("#idCheck").text("");
    } else {
      $("#idCheck").text("사용 불가능한 아이디 입니다").css("color", "red");
    }
  });
});
