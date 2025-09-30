<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/member/resources/js/httpRequest.js"></script>
<script>
	function del(idx) {
		
		if(!confirm("정말 삭제하시겠어요?")){
			return;
		}
		let url = "member_delete.do";
		let param = "idx=" + idx;
		
		sendRequest(url, param, resultFn, "post");
	}
	
	function resultFn(){
		
		if(xhr.readyState == 4 && xhr.status == 200){
			
			let data = xhr.responseText;
//			let json = eval(data);
//			if(json[0].res == "success"){
//				alert("삭제되었습니다.");
//				location.reload();
//			}
			
			if(data == "no"){
				alert("삭제 실패 했습니다.");
			} else {
				alert("삭제 성공했습니다.");
				location.href="list.do";
			}
			
		}
	}
</script>
</head>
<body>
	<h1>회원 목록</h1>
		<table border="1">
			<tr>
				<th>회원 번호</th>
				<th>이름</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이메일</th>
				<th>주소</th>
				<th>비고</th>
			</tr>
			<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.idx}</td>
					<td>${list.name}</td>
					<td>${list.id}</td>
					<td>${list.pwd}</td>
					<td>${list.email}</td>
					<td>${list.addr}</td>
					<td><input type="button" value="수정" onClick="location.href ='member_modify_form.do?idx=${list.idx}'" />
						<input type="button" value="삭제" onClick="del(${list.idx})" /></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7"><input type="button" value="등록"
					onClick="location.href='member_regi_form.do'" /></td>
			</tr>
		</table>
</body>
</html>