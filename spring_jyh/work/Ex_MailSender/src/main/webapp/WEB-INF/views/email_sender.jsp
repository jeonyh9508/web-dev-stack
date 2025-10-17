<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/mail/resources/js/httpRequest.js"></script>
<style>
body {
	background-color: grey;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
	color: #333;
}

form {
	background-color: #f9f9f9;
	padding: 15px 30px 20px 30px;
	border-radius: 10px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
	text-align: center;
	width: 350px;
}

input {
	width: 100%;
	padding: 10px;
	margin: 10px 0;
	border: 1px solid #ccc;
	border-radius: 10px;
	box-sizing: border-box;
	font-size: 14px;
}

input[type="button"] {
	width: 150px;
	background-color: #555;
	color: white;
	cursor: pointer;
	transition: background-color 0.2s;
}

input[type="button"]:hover {
	background-color: #333;
}

#mail_check_warn {
	margin-top: 10px;
	font-size: 13px;
	color: #666;
}

div{
	display: flex;
	gap: 10px;
}

.fail{
	color: red;
}

.clear{
	color: green;
}
</style>
<script>
	function mailCheck(f) {
		// ajax 로 email 파라미터를 담아 전송
		let userEmail = f.userEmail.value;
		let url = "mailCheck.do";
		let param = "email=" + userEmail;
		sendRequest(url, param, resultMail, "post");
	}

	// 인증번호를 저장할 전역 변수 지정
	let res;

	function resultMail() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let data = xhr.responseText;
			alert("인증코드가 성공적으로 발송되었습니다.");

			let check_input = document.getElementById("check_input");
			check_input.disabled = false;
			// 인증코드 발송 성공시 res에 인증번호 담기
			res = data;
		}
	}

	// 전송 받은 값과 입력 값을 비교
	function change_input() {
		let check_input = document.getElementById("check_input");
		let mail_check_warn = document.getElementById("mail_check_warn");
		// 인증번호가 담긴 res와 input.value 값 대조
		if (check_input.value == res) {
			mail_check_warn.innerHTML = "<span class='clear'>인증 성공</span>";
		} else {
			mail_check_warn.innerHTML = "<span class='fail'>인증번호가 일치 하지 않습니다.</span>"
		}
	}
</script>
</head>
<body>
	<form>
		<h3>이메일 인증</h3>
		<div>
			<input name="userEmail" placeholder="email_address" /> <input
				type="button" value="본인 인증" onClick="mailCheck(this.form)" />
		</div>
		<div>
			<input id="check_input" placeholder="인증번호 6자리" maxlength="6"
				disabled="disabled" /> <input type="button" value="인증번호 확인"
				onClick="change_input()" />
		</div>
		<div id="mail_check_warn"></div>
	</form>
</body>
</html>