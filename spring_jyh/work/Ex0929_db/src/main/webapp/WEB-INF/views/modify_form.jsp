<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script>
	function modify(f) {
		f.action="modify_fin.do";
		f.submit();
	}
</script>

</head>
<body>
	<h1>부서 수정</h1>
	
	<form onSubmit="modify(this)">
	
	<input type="hidden" name="ori_deptno" value="${vo.deptno}">
		<table border="1">
			<tr>
 				<th>부서 번호</th>
				<td><input name="deptno" value="${vo.deptno}"></td>
			</tr>
			<tr>
				<th>부서 명</th>
				<td><input value="${vo.dname}" name="dname" /></td>
			<tr>
				<th>부서 위치</th>
				<td><input value="${vo.loc}" name="loc" /></td>
			</tr>
			<tr>
			<td colspan="2"><input type="submit" value="수정"/></td>
			<tr>
		</table>
		
	</form>
	
</body>
</html>