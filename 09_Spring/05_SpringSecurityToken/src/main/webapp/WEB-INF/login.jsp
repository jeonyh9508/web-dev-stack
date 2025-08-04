<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>login</title>
     <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  </head>
  <body>
  	<h1>로그인</h1>
  		<form action="/login" method="post" id="frm">
  		<p>아이디 : <input type="text" name="id"/> </p>
  		<p>비밀번호 : <input type="password" name="pwd"/> </p>
  		<button type="submit" id="login">로그인</button>
  		</form>
   <script>
	  $("#login").click((e)=>{
		  $.ajax({
			type: "post",
			url: "/login",
			data: $("#frm").serialize(),
			success: function(data){
				//alert(data); 토큰 값
					// localStorage 에 token 키 값으로 저장
					//  / <- index.jsp 로 이동
				localStorage.setItem("token", data);
				location.href = "/";
			}
		  });
	  });
  </script>
  </body>
</html>