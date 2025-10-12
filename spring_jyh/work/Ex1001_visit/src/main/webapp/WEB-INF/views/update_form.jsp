<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function update(f) {
		if(f.pwd.value==''){
			alert("비밀번호를 입력해주세요.");
			return;
		}
		f.method = "post";
		f.action = "update_fin.do";
		f.submit();
	}
</script>
<link rel="stylesheet" href="resources/css/visit.css"></link>
</head>
<body>
	<div class="visit-wrap">
		<h1>게시글 수정</h1>
		<form method="post" enctype="multipart/form-data">
		<input type="hidden" name="idx" value="${vo.idx}" />
			<table>
				<tr>
					<th>내용</th>
					<td><textarea name="content" rows="13" cols="50" wrap="on" style="resize: none">${vo.content}</textarea></td>
				</tr>
				<tr>
				<th>파일</th>
					<td><img src="resources/upload/${vo.filename}" />
						<input type="file" name="file" />
					</td>
					
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
					<input type="button" value="수정" onClick="update(this.form)" />
					<input type="button" value="목록으로" onClick="history.back()" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>