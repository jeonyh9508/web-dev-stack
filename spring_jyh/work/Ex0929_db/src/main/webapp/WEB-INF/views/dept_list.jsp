<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script>
	function del(deptno){
		location.href="delete.do?deptno=" + deptno;
	}
	
	function modify(deptno){
		location.href="modify.do?deptno=" + deptno;
	}
</script>
</head>
<body>
	<h1>부서 목록</h1>
	<table border="1">
		<tr>
			<th>부서 번호</th>
			<th>부서 명</th>
			<th>위치</th>
			<th>비고</th>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.deptno}</td>
				<td>${list.dname}</td>
				<td>${list.loc}</td>
				<td>
					<input type="button" value="수정" onClick="modify(${list.deptno})"/>
					<input type="button" value="삭제" onClick="del(${list.deptno})"/>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>