const login = document.querySelector("#login");

//코드 중복 ! 함수로 기능으로
const show = (info) => {
  document.body.innerHTML = `
  <h1>${username.value}님 환영합니다!</h1>

  <button type="button" id="logout">로그아웃</button>
  `;
  const logout = document.querySelector("#logout");
  logout.addEventListener("click", () => {
    localStorage.removeItem("name");
    location.reload();
  });
};

//로그인 되어있는지 아닌지 확인
const info = localStorage.getItem("name");
if (info) {
  show(info);
}

login.addEventListener("click", () => {
  // 아이디 , 비밀번호 입력받은 값들로 로그인 처리
  // 로그인 성공하고 이름을 저장
  if (username.value === "" || password.value === "") {
    alert("이름과 비밀번호를 입력해주세요!");
    return; // 조건이 true , return으로 종료
  }

  localStorage.setItem("name", username.value);
  // ~님 환영합니다! 로그아웃 버튼
  show(username.value);
});
