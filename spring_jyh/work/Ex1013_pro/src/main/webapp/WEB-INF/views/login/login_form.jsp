<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/member/resources/js/httpRequest.js"></script>
<script>
	function send(f) {
		let id = f.id.value; 
		let pwd = f.pwd.value;
	
		let url = "check_login.do";
		let param = "id=" + id + "&pwd=" + encodeURIComponent(pwd);
		
		sendRequest(url, param, resultFn, "post");
	}
	
	// 콜백 메서드
	function resultFn(){
		
		if(xhr.readyState == 4 && xhr.status == 200){
			
			let data = xhr.responseText;
			let json = eval(data);
			
			if(json[0].res == 'no_id'){
				alert("존재하지 않는 아이디입니다.");
			}else if(json[0].res == 'no_pwd'){
				alert("잘못된 비밀번호 입니다.");
			}else {
				location.href = "list.do";
			} 
		}
	}
</script>
</head>
<body>
	<h1>로그인 페이지</h1>
	<form>
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input name="id" /></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input name="pwd" type="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="로그인" onClick="send(this.form)"/></td>
			</tr>
		</table>

	</form>
</body>
</html>