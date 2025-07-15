<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원관리</h1>
	<c:choose>
	<c:when test="${not empty member}">
		<h1>${member.name}님 로그인 하셨습니다.</h1>
		<!-- 로그인한 사람의 정보 수정-->
		<form action="/update" method="post">
			비밀번호 : <input type="password" name="pwd" value="${member.pwd}"><br>
			이름 : <input type="text" name="name" value="${member.name}"><br>
			나이 : <input type="text" name="age" value="${member.age}"><br>
			<input type="submit" value="회원수정">
		</form>
		<h2>비밀번호만 변경</h2>
		<form action="/update" method="post">
			비밀번호 : <input type="password" name="pwd"><br>
			<input type="submit" value="비밀번호 수정">
		</form>
		<!-- primarykey 가  id -->
		<a href="/delete">회원탈퇴</a>
	</c:when>
	<c:otherwise>
		<a href="/register">회원가입</a><br>
		<a href="/login">로그인</a>
	</c:otherwise>
	</c:choose>
	
	<form action="/search">
		<select name="select">
			<option value="all">이름 또는 아이디</option>
			<option value="id">아이디</option>
			<option value="name">이름</option>
		</select>
		<input type="text" name="keyword" value="${param.keyword}" placeholder="아이디 입력">
		<input type="submit" value="검색">
	</form>
	<!-- 회원 전체 목록이 나오고 -->
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>나이</td>
		</tr>
	
		<c:forEach items="${list}" var="item">
			<!-- model 에 저장된 list , item 변수 -->
			<tr>
				<td>${item.id}</td>
				<td>${item.pwd}</td>
				<td>${item.name}</td>
				<td>${item.age}</td>
			</tr>
		</c:forEach>

</body>
</html>