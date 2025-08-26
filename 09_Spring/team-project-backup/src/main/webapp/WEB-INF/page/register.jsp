<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
	<link rel="stylesheet" href="../resources/css/reset.css" />
	<link rel="stylesheet" href="../resources/css/register.css" />
</head>
  <body>
    <h1>회원가입</h1>
    <form id="frm">
      <div>
        <input type="text" id="id" name="id" placeholder="아이디를 입력해주세요" />
        <span>영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내</span>
      </div>
      <div>
        <input
          type="text"
          id="pwd"
		  name="pwd"
          placeholder="비밀번호를 입력해주세요"
        />
        <span>영문자, 숫자, 특수문자 조합으로 8~15자 이내</span>
      </div>
      <div>
        <input
          type="text"
          id="pwdCheck"
          placeholder="비밀번호를 다시 한 번 입력해주세요"
        />
        <span>위 비밀번호와 동일하게</span>
      </div>
      <div>
        <input type="text" id="userName" name="userName" placeholder="이름을 입력해주세요" />
        <span>한글 2자 이상</span>
      </div>
	  <div>
		<div id="rrn">
			<input type="text" id="birthDate" placeholder="예:000529" maxLength="6" />
			<span>-</span>
			<input type="text" id="gender" name="gender" maxLength="1" width="20"/>
			<span>●●●●●●</span>
			<input type="hidden" id="birthDateValue" name="birthDate" />
		</div>
		<span>주민등록번호 입력</span>
	  </div>
      <div>
        <input type="text" id="userEmail" name="email" placeholder="이메일을 입력해주세요" />
        <span>이메일 형식</span>
      </div>
      <div>
        <input
          type="text"
          id="userNumber"
		  name="phone"
          placeholder="전화번호를 입력해주세요"
        />
        <span>전화번호 형식 (010-0000-0000)</span>
      </div>
      <div class="button">
        <button id="register" disabled>회원가입</button>
        <button type="reset" id="cancel">취소</button>
      </div>
	</form>
    <script>
		$("#register").click((e)=>{
			e.preventDefault(); // ajax 전에 먼저 get으로 선처리 방지
			const birthDate = $("#birthDate").val();
			const year = birthDate.substring(0, 2);
			const month = birthDate.substring(2, 4);
			const day = birthDate.substring(4, 6);
			if($("#gender").val() === "1" || $("#gender").val() === "2") {
				$("#birthDateValue").val("19" + year + "-" + month + "-" + day);
			} else if($("#gender").val() === "3" || $("#gender").val() === "4"){
				$("#birthDateValue").val("20" + year + "-" + month + "-" + day);
			}
			//if($("#gender").val() === "1" || $("#gender").val() === "3") {
			//	$("#genderValue").val("남자");
			//} else if($("#gender").val() === "2" || $("#gender").val() === "4"){
			//	$("#genderValue").val("여자");
			//}
			$.ajax({
				type: "post",
				url: "/register",
				data: $("#frm").serialize(),
				success: function(response) {
					/*
					if(response.userId != null) {
						location.href = "/login";
					}
					*/
				},
			})
		})
	</script>
	<script src="../resources/js/register.js"></script>
  </body>
</html>
