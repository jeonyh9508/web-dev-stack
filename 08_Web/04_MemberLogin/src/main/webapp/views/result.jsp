<%@page import="vo.Member"%>
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
회원조회 결과
<%
MemberDAO dao = new MemberDAO(); 
String id = (String) request.getAttribute("id"); 
Member member = dao.search(id);
%>
<%if (member.getId()!=null) {%>
<ul>
<li>아이디 : <%= member.getId() %></li>
<li>이름 : <%= member.getName() %></li>
<li>나이 : <%= member.getAge() %></li>
</ul>
<%} else { %>
<h4>조회결과가 없습니다</h4>
<% } %>
</body>
</html>