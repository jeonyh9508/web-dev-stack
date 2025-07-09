<%@page import="vo.Member"%>
<%@page import="java.util.List"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>전체 회원 조회</h1>
<%List<Member> list = (List<Member>) request.getAttribute("list"); %>
<h1>전체 리스트</h1>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<% for(Member member : list) { %>
		<tr>
			<td><%= member.getId() %></td>
			<td><%= member.getName() %></td>
			<td><%= member.getAge() %></td>
		</tr>
		<% } %>
	</table>
<%-- 전체 회원 보기 : AllMemberServlet 
						views/allMember.jsp에 리스트 출력 --%>
</body>
</html>