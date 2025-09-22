<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<caption>부서 목록</caption>
		<tr>
			<th>부서 번호</th>
			<th>부서 명</th>
			<th>부서 위치</th>
			<th>비고</th>
		</tr>
		<c:forEach var="vo" items="${list}">
		<tr>
		<td>${vo.deptno}</td>
		<td>${vo.dname}</td>
		<td>${vo.loc}</td>
		<td><input type="button" value="삭제" /></td>
		</tr>
		</c:forEach>
		<tr>
		<td colspan="4"> <input type="button" value="부서 등록" onClick="location.href='dept_insert.jsp'"/></td>
		</tr>
	</table>
</body>
</html>