<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/visit.css"></link>
<script src="resources/js/httpRequest.js"></script>
<script>
	function modify(idx, pwd){
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
			if(data == 'no'){
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

		<input type="button" value="글쓰기"
			onClick="location.href='visit_insert_form.do'" />
		<c:forEach var="list" items="${list}">
			<table>
				<tr>
					<td><pre>${list.content}</pre></td>
				</tr>
				<tr>
					<c:if test="${list.filename ne 'no_file'}">
						<td><img src="resources/upload/${list.filename}" width="200"/></td>
					</c:if>
				</tr>
				<tr>
					<td>작성자 : ${list.name}(${list.ip})</td>
				</tr>
				<tr>
					<td>작성일자 : <fmt:formatDate value="${list.regdate}"
							pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
				</tr>
				<tr>
					<td>
						<form>
							비밀번호 <input name="checkPwd" type="password"
								style="border: 1px solid #ccc;" /> <input type="button"
								value="수정"
								onClick="modify(${list.idx}, this.form.checkPwd.value)" /> <input
								type="button" value="삭제"
								onClick="del(${list.idx}, this.form.checkPwd.value)" />
						</form>
					</td>
				</tr>
			</table>
		</c:forEach>
	</div>
</body>
</html>