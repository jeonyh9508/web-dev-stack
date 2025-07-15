<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<div>login</div>
<form action="/main" method="post">
<div>아이디 : <input type="text" name="id"></div>
<div>비밀번호 : <input type="password" name="pwd"></div>
<input type="submit" value="로그인"/>
</form>
<form>
	<input type="submit" value="회원가입">
</form>