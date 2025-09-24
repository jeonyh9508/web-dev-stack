<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/httpRequest.js"></script>
<script>
function send(f) {
	let id = f.id.value.trim();
	let pwd = f.pwd.value.trim();
	
	let url = "login.do";
	let param = "id=" + id + "&pwd=" + encodeURIComponent(pwd);
	
	sendRequest(url , param, resultFn, "post");
	}
	
	function resultFn(){
		if(xhr.readyState == 4 && xhr.status == 200) {
			
			let data = xhr.responseText;
			
			let json = eval(data);
			
			if(json[0].param == 'no_id'){
				alert("Id Incorrect");
			} else if (json[0].param == 'no_pwd'){
				alert("Password Incorrect");
			} else {
				// 로그인 성공
				location.href="main_content.jsp"
			}
			
		}
	}
</script>
</head>
<body>
	<form>
		<table>
			<caption>LogIn</caption>

			<tr>
				<th>ID</th>
				<td><input name="id" /></td>
			</tr>
			<tr>
				<th>PASSWORD</th>
				<td><input name="pwd" type="password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="LogIn" onClick="send(this.form)"/>
				<input type="reset" value="Reset" /></td>
			</tr>
		</table>
	</form>
</body>
</html>