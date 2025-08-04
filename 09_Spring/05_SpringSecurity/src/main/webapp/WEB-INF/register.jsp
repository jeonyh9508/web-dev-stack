<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>register</title>
  </head>
  <body>
  	<h1>회원 가입</h1>
  	<form action="/register" method="post">
  		<p>아이디 : <input type="text" name="id"/> </p>
  		<p>비밀번호 : <input type="password" name="pwd"/> </p>
  		<p>이름 : <input type="text" name="name"/> </p>
  		<button type="submit" id="register">회원가입</button>
 	 </form>
  </body>
</html>