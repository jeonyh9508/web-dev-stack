<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="../../resource/css/login.css">
</head>
<body>
    <div class="container">
        <h1>회원가입</h1>
        <form action="/register" method="post">
            <div class="form-group">
                <span>아이디(이메일) : </span><input type="text" name="email" id="emailInput">
            </div>
            <span id="emailCheckMsg" class="errorMsg"></span>
            <div class="form-group">
                <span>비밀번호 : </span><input type="password" name="password" id="passwordInput">
            </div>
            
            <div class="form-group">
                <span>이름 : </span><input type="text" name="name" id="nameInput">
            </div>
            <div class="form-group">
                <span>직급 : </span>
	            <select name="gradeId" id="gradeIdSelect" required>
            		<c:forEach items="${grade}" var="grade">
            			<c:if test="${grade.gradeName != '어드민'}">
	            		<option value="${grade.gradeId}">${grade.gradeName}</option>
	            		</c:if>
            		</c:forEach>
		        </select>    
		        <%--  <option value="1">사원</option>
		            <option value="2">선임</option>
		            <option value="3">책임</option>
		            <option value="4">수석</option>
		            <option value="5">파트장</option>
		            <option value="6">팀장</option>
		            <option value="7">그룹장</option>
		            <option value="8">실장</option> --%>
	        	
            </div>
            <div class="form-group">
                <span>부서 : </span>
                <select name="deptId" id="deptIdSelect" required>
                	<c:forEach items="${dept}" var="dept">
	            	<option value="${dept.deptId}">${dept.deptName}</option>
	            	</c:forEach>
	            </select>	
			    <%-- <option value="1">신약개발부</option>
				    <option value="2">임상개발부</option>
				    <option value="3">약물감시부</option>
				    <option value="4">사업개발부</option>
				    <option value="5">생산부</option>
				    <option value="6">품질관리부</option>
				    <option value="7">품질보증부</option>
				    <option value="8">규제업무부</option>
				    <option value="9">특허부</option>
				    <option value="10">인사부</option>
				    <option value="11">재무회계부</option>
				    <option value="12">총무부</option>
				    <option value="13">영업부</option>
				    <option value="14">마케팅부</option>
				    <option value="15">고객서비스부</option> --%> 
            </div>
            <div class="button-group">
			<button id="registerButton" disabled><input type="submit" value="회원등록" disabled></button>
			<button><a href="/" class="btn-home">홈</a></button>
		</div>
        </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="../resource/js/register.js"></script>
</body>
</html>