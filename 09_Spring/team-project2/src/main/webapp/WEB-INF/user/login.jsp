<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="../../resource/css/login.css">
</head>
<body>
	<div class="container">
	<h1>로그인</h1>
	<form action="/login" method="post">
		<div class="form-group">
			<span>아이디(이메일) : </span><input type="text" name="username">
		</div>
		<div class="form-group">
			<span>비밀번호 : </span><input type="password" name="password">
		</div>
		
		<div class="button-group">
			<button><input type="submit" value="로그인"></button>
			<button><a href="/" class="btn-home">홈</a></button>
		</div>
	</form>
</div>
</body>
</html>