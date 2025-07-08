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
전체 회원 조회
<%-- 전체 회원 보기 : AllMemberServlet 
						views/allMember.jsp에 리스트 출력 --%>
<%
MemberDAO dao = new MemberDAO(); 
List<Member> list = dao.searchAll();%>
<ul>
<%for(int i = 0; i < list.size(); i ++){
	list.get(i); %>
	<li><h3><%= i + 1 %> 번 회원</h3></li>	
	<li>아이디 : <%=list.get(i).getId() %></li>
	<li>이름 : <%=list.get(i).getName() %></li>
	<li>나이 :<%=list.get(i).getAge() %></li>
<% } %>
</ul>
</body>
</html>