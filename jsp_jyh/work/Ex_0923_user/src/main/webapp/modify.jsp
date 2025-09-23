<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function modify(f){
		f.action="member_modify.do"
		f.submit();
	}
</script>
</head>
<body>
<form>
<input type="hidden" value="${vo.idx}" name="idx"/>
	<table border="1">
		<caption>::: 정보 수정 :::</caption>
		<tr>
			<th>이름</th>
			<td><input value="${vo.name}" name="name" /></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><input value="${vo.id}" name="id" /></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input value="${vo.pwd}" name="pwd" type="password"/></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input value="${vo.email}" name="email" /></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input value="${vo.addr}" name="addr" /></td>
		</tr>
		<tr>
		<td colspan="2"><input type="button" value="수정" onClick="modify(this.form)"/></td>
		</tr>
	</table>
</form>
</body>
</html>