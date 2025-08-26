<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../../resource/css/layout.css">
</head>
<body>
	<h1>마이페이지</h1>
	<!--  <p>아이디 : <sec:authentication property="principal.email" /></p>
	<p><sec:authentication property="principal.name" />님의 페이지입니다.</p> -->
	
	<p>이름 : ${user.name}</p>
	<p>이메일 : ${user.email}</p>
	<p>부서 : ${user.deptName}</p>
	<p>직급 : ${user.gradeName}</p>
	<div class="changePwd">
		<span>비밀번호 변경 : <input type="text" name="password">  <!-- 기존 등록된  -->
		<button id="checkReusePwd">중복체크</button>
		<button id="changePwd">변경</button>	
		</span>
		<p id="checkPwdMsg"></p>
	</div>
	
	<a href="/">홈으로</a><br>
	<a href="/logout">로그아웃</a>
	
	<script>
		//$('#changePwd').click(()=>{
			//const pwd = 
				//if(check != null && )
				//$('#checkPwdMsg').text('')
		//});
	</script>
</body>
</html>