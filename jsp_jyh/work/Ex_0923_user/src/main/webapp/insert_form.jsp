<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function regi(f) {
		
		let name = f.name.value;
		if(name == ''){
			alert("이름을 입력해주세요.")
			return;
		}
		
		f.action="member_regi.do";
		f.method="post";
		f.submit();
	}
</script>
</head>
<body>
	<form>
		<table border="1">
			<caption>::: 회원 추가 :::</caption>
			<tr>
				<th>이름 입력</th>
				<td><input name="name" /></td>
			<tr>
			<tr>
				<th>아이디 입력</th>
				<td><input name="id" /></td>
			<tr>
			<tr>
				<th>비밀번호 입력</th>
				<td><input name="pwd" type="password"/></td>
			<tr>
			<tr>
				<th>이메일 입력</th>
				<td><input name="email" /></td>
			<tr>
			<tr>
				<th>주소 입력</th>
				<td><input name="addr" /></td>
			<tr>
			<tr>
				<td colspan="2">
				<input type="button" value="등록" onClick="regi(this.form)"/>
				<input type="button" value="취소" onClick="history.go(-1)"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>