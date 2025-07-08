<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="dao.MemberDAO"%>
<%@ page import="vo.Member"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% List<Member> list = (List<Member>) request.getAttribute("list"); %>
	<%-- SearchServlet 생성, search.jsp 에서 결과 확인 --%>
	<h1>회원 조회</h1>
	<form action ="/search">
		검색할 회원 아이디 : <input type="text" name="id">
		<input type="submit" value="조회">
		
	</form>
	<h1>전체 리스트</h1>
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<% for(Member member : list) { %>
		<tr>
			<td><%= member.getId() %></td>
			<td><%= member.getPwd() %></td>
			<td><%= member.getName() %></td>
			<td><%= member.getAge() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>