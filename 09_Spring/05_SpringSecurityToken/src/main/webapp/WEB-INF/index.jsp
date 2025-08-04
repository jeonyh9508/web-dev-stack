<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>INDEX</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>

	<div id="anonymous" style="display:none;">
	<sec:authorize access="isAnonymous()">
		<a href="/login">로그인</a> <br>
		<a href="/register">회원가입</a> <br>
	</sec:authorize>
	</div>
	<div id="authenticated" style="display:none;">
	<sec:authorize access="isAuthenticated()">
		<a href="/logout">로그아웃</a>	<br>
		<a href="/mypage">마이 페이지</a> <br>
	</sec:authorize>
	<sec:authorize access="hasRole('ADMIN')">
		<a href="/admin">관리자 페이지</a>
	</sec:authorize>
	</div>
	<script>
		const token = localStorage.getItem("token");
		if(token !== null){
			$("#authenticated").show();
		} else {
		
		}
	</script>
</body>
</html>