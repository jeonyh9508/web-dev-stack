<%@page import="com.kh.vo.Member"%>
<%@page import="com.kh.dao.MemberDAO"%>
<%@page import="java.util.List"%>
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
	<h1>전체 회원 조회</h1>

	<h1>전체 리스트</h1>
	<table border="1">
		<tr>
			<th>인덱스</th>
			<th>번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<c:forEach items="${list}" var="member" varStatus="status">
			<tr>
			<%-- index : 0 부터 , count : 1 부터 --%>
				<td>${status.index}</td>
				<td>${status.count}</td>
				<td>${member.getId()}</td>
				<td>${member.pwd}</td>
				<td>${member.name}</td>
				<td>${member.getAge()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>