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
	<h1>회원 관리</h1>
	<ul>
	<%MemberDAO dao = new MemberDAO(); %>
		<%-- 로그인 되어 있지 않은 경우 --%>
		<li><a href="/views/register.jsp">회원가입</a></li>
		
		<li><a href="/views/login.jsp">로그인</a></li>
		
		<%
		String id = (String) request.getAttribute("id"); 
		String pwd = (String) request.getAttribute("pwd"); 
		if(dao.login(id, pwd)){
		%> 
		<%-- 로그인 된 경우 --%>
		<li><a href="/views/search.jsp">회원검색</a></li>
		
		<li><a href="/allMember">전체 회원 보기</a></li>
		<%-- 전체 회원 보기 : AllMemberServlet 
						views/allMember.jsp에 리스트 출력 --%>
		
		<li><a href="/logout">로그아웃</a></li>
		<%-- 로그아웃 : 로그아웃하고 index.jsp로 / LogoutServlet --%>
		<% } %>		
	</ul>
</body>
</html>