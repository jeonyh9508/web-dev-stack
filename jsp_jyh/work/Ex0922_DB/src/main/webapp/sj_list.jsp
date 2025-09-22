<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- core라이브러리 추가 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<caption>학생목록</caption>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>비고</th>
		</tr>

		<!-- 포워딩된 데이터를 jsp에서 가공 -->
		<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.no}</td>
				<td>${vo.name}</td>
				<td>${vo.kor}</td>
				<td>${vo.eng}</td>
				<td>${vo.mat}</td>
				<td><input type="button" value="삭제" onClick="location.href='sj_del.do?no=${vo.no}'"/></td>
			</tr>
		</c:forEach>

		<tr>
			<td colspan="6"><input type="button" value="등록" onClick="location.href='insert_form.jsp'"/></td>
		</tr>
	</table>
</body>
</html>