<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function send(f) {
		let dname = f.dname.value;

		if (dname == '') {
			alert("부서명을 입력하세요.");
			return;
		}

		let loc = f.loc.value;

		if (loc == '') {
			alert("부서 위치를 입력하세요.");
			return;
		}

		f.action = 'dept_list.do';
		f.submit();
	}
</script>
</head>
<body>
	<form>
		<table border="1">
			<tr>
				<th>부서명</th>
				<td><input name="dname" /></td>
			</tr>
			<tr>
				<th>부서위치</th>
				<td><input name="loc" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="등록" onClick="send(this.form);" /></td>
			</tr>
		</table>
	</form>
</body>
</html>