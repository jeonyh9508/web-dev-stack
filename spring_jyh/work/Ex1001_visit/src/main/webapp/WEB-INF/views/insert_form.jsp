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
  width: 100%;
  height: 100%;
  box-sizing: border-box;
}
</style>
<script>
	function insert(f) {
		f.action = "visit_insert.do"
		f.submit();
	}
</script>
</head>
<body>
	<div class="visit-wrap">
	<h1>방명록 작성</h1>
		<form>
			<table>
				<tr>
					<th>내용</th>
					<td><input name="content" type = "text" /></td>
				</tr>
					<tr>
					<th>이름</th>
					<td><input name="name" type = "text" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input name="pwd" type = "password"/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="등록"
						onClick="insert(this.form)" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>