<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function insert(f) {
		let content = f.content.value;
		let name = f.name.value;
		let pwd = f.pwd.value;

		if (content == '') {
			alert("내용을 입력해주세요.");
			return;
		}
		if (name == '') {
			alert("이름을 입력해주세요.");
			return;
		}
		if (pwd == '') {
			alert("비밀번호를 입력해주세요.");
			return;
		}

		f.method = "post"
		f.action = "visit_insert.do"
		f.submit();
	}
</script>
<link rel="stylesheet" href="resources/css/visit.css"></link>
</head>
<body>
	<div class="visit-wrap">
		<h1>방명록 작성</h1>
		<form method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<th>내용</th>
					<td><textarea name="content" rows="13" cols="50" wrap="on" style="resize: none"></textarea></td>
				</tr>
				<tr>
					<th>파일</th>
					<td><input type="file" name="file" /></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input name="name" type="text" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input name="pwd" type="password" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="등록"
						onClick="insert(this.form)" /> <input type="button" value="목록으로"
						onClick="history.back()" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>