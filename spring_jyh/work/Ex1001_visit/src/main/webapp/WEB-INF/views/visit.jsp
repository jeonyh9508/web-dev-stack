<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
td{
	vertical-align: top;
}
</style>
<script src="resources/js/httpRequest.js"></script>
<script>
	function update(idx, pwd){
		let url = "update_pwd_check.do";
		let param = "idx=" + idx + "&pwd=" + pwd;
		
		sendRequest(url, param, updateFn, "post");
	}
	
	function updateFn(){
		
		if(xhr.readyState == 4 && xhr.status == 200){
			let data = xhr.responseText;
			let json = eval(data);
			if(json[0].res == 'no'){
				alert("비밀번호가 틀렸습니다.");
			}else{
				location.href="visit_update_form.do?idx=" + json[0].idx;
			}
		}
	}
	
	function del(idx, pwd){
		let url = "del_pwd_check.do";
		let param = "idx=" + idx + "&pwd=" + pwd;
		if(!confirm("정말 삭제하시겠습니까 ? ")) {
		    return;
		}
		    sendRequest(url, param, delFn, "post");
		
	}
	
	function delFn(){
		
		if(xhr.readyState == 4 && xhr.status == 200){
			let data = xhr.responseText;
			let json = eval(data);
			if(json[0].res == 'no'){
				alert("비밀번호가 틀렸습니다.");
			}else{
				location.href="list.do";
			}
		}
	}
</script>
</head>
<body>
	<div class="visit-wrap">
		<h1>::: 방명록 리스트 :::</h1>
		
		<input type="button" value="글쓰기" onClick="location.href='visit_insert_form.do'"/>
		<c:forEach var="list" items="${list}">
		<table>
			<tr>
				<td>${list.content}</td>
			</tr>
			<tr>
				<td>작성자 : ${list.name}(${list.ip})</td>
			</tr>
			<tr>
				<td>작성일자 : <fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
			</tr>
			<tr>
				<td>
					<form>
						비밀번호  
						<input name="checkPwd" type="password"/>
						<input type="button" value="수정" onClick="update(${list.idx}, this.form.checkPwd.value)"/>
						<input type="button" value="삭제" onClick="del(${list.idx}, this.form.checkPwd.value)"/>
					</form>
				</td>
			</tr>
		</table>
		</c:forEach>
	</div>
</body>
</html>