<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>login</title>
  </head>
  <body>
  	<h1>로그인</h1>
	  <form action="/login" method="post">
  		<p>아이디 : <input type="text" name="username"/> </p>
  		<p>비밀번호 : <input type="password" name="password"/> </p>
  		<button type="submit" id="login">로그인</button>
 	 </form>
  </body>
</html>