<!-- HTML 주석 : 소스코드 표기 -->
<%-- JSP 주석 : 소스코드 표기 X 

JSP Element
1. 지시어 %@ % : 컨테이너에게 알려줄 내용 지정 -> import
2. 스클릿틀릿 % % : 자바 코드는 이안에 지정
3. 출력문 %= % : 출력하려는 내용 지정 -> 값만 출력

--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- check 값도 바인딩 해서 jsp에서 조건을 걸 수 있다. --%>
	<% 
	boolean check = (boolean) request.getAttribute("check");
	//String name = (String) request.getAttribute("name");
	String name = request.getParameter("name");
	%>
	<%-- check 가 true 인경우 --%>
	<% if(check) { %> 
		 <h1> <%= name %> 님, 회원가입 완료😊</h1>
	<%  } else { %>
		<h1> 회원가입 실패😢 </h1>
	<% } %>
	
</body>
</html>
