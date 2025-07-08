<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	회원가입페이지
	<%-- 회원 가입 로직 : 아이디, 비밀번호, 이름, 나이 입력받아서
						호출 : /register, 방식 :post
						RegisterServlet
						index.jsp로 이동
		 --%>
	<form action="/register" method = "post">
	아이디 입력 : <input type="text" name="id"> <br>
	비밀번호 입력 : <input type="password" name="pwd"> <br>
	이름 입력 : <input type="text" name="name"> <br>
	나이 입력 : <input type="text" name="age"> <br>
	<input type="submit" value="회원가입">
	</form>
</body>
</html>