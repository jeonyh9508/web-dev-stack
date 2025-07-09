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
	<%-- c:if 사용한 경우
		1 -> 안녕하세요
		2 -> 처음 뵙겠습니다
		그 외 -> 누구세요
		--%>
	<c:if test="${param.number eq '1'}" >
		<h2>안녕하세요</h2>
	</c:if>
	<c:if test="${param.number == '2'}" >
		<h2>처음 뵙겠습니다</h2>
	</c:if>
	<c:if test="${param.number != '1' and param.number ne '2'}" >
		<h2>누구세요?</h2>
	</c:if>
	<%--
		== : eq, != : ne, < : lt, > : gt, <= :le, >=ge
		&& : and, || : of, ! : not
		== null : empty - null 이거나 빈 문자열인 경우 true
		!= null : not empty
	 --%>
	 <%-- c:choose 사용 --%>
	 <c:choose>
	 	<c:when test="${param.number eq '1'}">
	 		<h2>안녕하세요</h2>
	 	</c:when>
	 	<c:when test="${param.number eq '2'}">
	 		<h2>처음 뵙겠습니다</h2>
	 	</c:when>
	 	<c:otherwise>
			<h2>누구세요?</h2>	 	
	 	</c:otherwise>
	 </c:choose>
</body>
</html>