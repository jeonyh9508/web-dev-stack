<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function regi(f) {
		f.action="member_insert.do";
		f.method="post";
		f.submit();
	}
</script>
</head>
<body>
	<form>
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input name="name" /></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input name="id" /></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input name="pwd" type="password"/></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input name="email" /></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input name="addr" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="등록" onClick="regi(this.form)"/>
					<input type="button" value="취소" onClick="history.back()"/>	
				</td>
			</tr>
		</table>
	</form>
</body>
</html>