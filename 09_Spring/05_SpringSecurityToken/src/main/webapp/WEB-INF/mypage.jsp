<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>mypage</title>
  </head>
  <body>
  <!-- get, / mypage : 인증된 사람만 (로그인 된 사람만) -->
  	<h1>마이페이지</h1>
  	<!-- principal => 모든 값 -->
  	<p><sec:authentication property="principal.id" /> 님 로그인</p>
  	<p><sec:authentication property="principal.name" /> 님의 페이지입니다..</p>
  </body>
</html>