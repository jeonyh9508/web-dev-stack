<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function modify(f) {
		f.action = "modify_fin.do";
		f.method = "post";
		f.submit();
	}
</script>
</head>
<body>
	<form>
	<input type="hidden" name="idx" value="${vo.idx}" />
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input name="name" value="${vo.name}"/></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input name="id" value="${vo.id}" /></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input name="pwd" type="password" /></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input name="email" value="${vo.email}" /></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input name="addr" value="${vo.name}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="수정"
					onClick="modify(this.form)" /> <input type="button" value="취소"
					onClick="history.back()" /></td>
			</tr>
		</table>
	</form>
</body>
</html>