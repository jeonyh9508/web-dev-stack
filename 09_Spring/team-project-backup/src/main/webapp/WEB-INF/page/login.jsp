<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <title>login</title>
    <link rel="stylesheet" href="../resources/css/reset.css" />
    <link rel="stylesheet" href="../resources/css/login.css" />
  </head>
<body>
<div id="login">
<h2>LOGIN</h2>

<div class="inputs">
<div id="ids">아이디 <input type="text" id="id" ></div>
<div id="pwds">비밀번호 <input type="password" id="pwd"></div>
</div>

<div class="buttons">
	<!--
<form action="/" method="post">
<input id="loginBtn" type="submit" value="로그인"/></form>-->
<button type="button" id="loginBtn">로그인</button>
<button type="button" id="regiBtn">회원가입</button>

<!--<form action="/register" method="get">
<input id="regiBtn" type="submit" value="회원가입"></form>-->
</div>
</div>

<script>
	$("#regiBtn").click(() => {
		location.href = "/register";
	})
    $("#loginBtn").click(() => {
			$.ajax({
				type: "post",
				url: "/login",
				data: "id=" + $("#id").val() + "&pwd=" + $("#pwd").val()
			});
		});
</script>
</body>
</html>