<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- core라이브러리 추가 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function send( f ){
		// 유효성 체크
		let name = f.name.value;
		if( name == '') {
			alert("이름을 입력하세요.");
			return;
		}
		// 입력 값을 sj_register.do 로 
		f.action = 'sj_register.do';
		f.submit();
	}
</script>
</head>
<body>
	<form>
	<table border="1">
		<tr>
		<th>이름</th>
		<td><input name="name" placeholder="이름 입력"></td>
		</tr>
		<tr>
		<th>국어</th>
		<td><input name="kor" placeholder="국어 점수 입력"></td>
		</tr>
		<tr>
		<th>영어</th>
		<td><input name="eng" placeholder="영어 점수 입력"></td>
		</tr>
		<tr>
		<th>수학</th>
		<td><input name="mat" placeholder="수학 점수 입력"></td>
		</tr>
		<tr>
		<td colspan="2"><input type="button" value="확인" onClick="send(this.form);"/></td>
		</tr>
	</table>
	
	</form>
</body>
</html>