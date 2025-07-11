<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 관리</h1>
	<ul>
		<c:choose>

			<c:when test="${empty member}">
				<%-- 로그인 되어 있지 않은 경우 --%>
				<li><a href="/views/register.jsp">회원가입</a></li>
				<li><a href="/views/login.jsp">로그인</a></li>
			</c:when>
			
			<c:otherwise>
				<%-- 로그인 된 경우 --%>
				<li><a href="/views/search.jsp">회원검색</a></li>
				<li><a href="/front?command=allMember">전체 회원 보기</a></li>
				<li><a href="/front?command=logout">로그아웃</a></li>
				<%-- ?key=value
					key = command
					value = logout
					value뒤에 & 가 붙여서 파라미터 값 추가 가능
					/front?command=logout&id=1 
				 --%>
			</c:otherwise>
			
		</c:choose>
	</ul>
</body>
</html>