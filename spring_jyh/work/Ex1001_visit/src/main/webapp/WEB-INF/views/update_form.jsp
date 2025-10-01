<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.visit-wrap {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

table {
	margin-top: 50px;
	width: 600px;
	border: 1px solid;
}

tr:first-child {
	background-color: #9A3F3F;
	height: 250px;
	border-bottom: none;
	
}

tr:nth-child(2) {
	background-color: #C1856D;
}

tr:nth-child(3) {
	background-color: #E6CFA9;
}

tr:nth-child(4) {
	background-color: #FBF9D1;
}

td {
	vertical-align: top;
	padding:10px;
}
textarea,input[type = "text"],input[type="password"]{
font-size: 1rem;
background-color: inherit;
border: none;
}
</style>
<script>
	function update(f) {
		if(f.pwd.value==''){
			alert("비밀번호를 입력해주세요.");
			return;
		}
		f.action="update_fin.do";
		f.submit();
	}
</script>
</head>
<body>
	<div class="visit-wrap">
		<h1>게시글 수정</h1>
		<form>
		<input type="hidden" name="idx" value="${vo.idx}" />
			<table>
				<tr>
					<th>내용</th>
					<td><textarea name="content">${vo.content}</textarea></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="${vo.name}"/></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd"/></td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="button" value="수정" onClick="update(this.form)" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>