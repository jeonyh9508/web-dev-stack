<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Ajax 사용을 위한 js 파일 참조 -->
<script src="js/httpRequest.js"></script>

<script>
	let b_idCheck = false;
	

	function regi(f) {
		
		let id = f.id.value;
		
		if(id==''){
			alert("아이디를 입력하세요.");
			return;
		}
		
		let name = f.name.value;
		if(name == ''){
			alert("이름을 입력해주세요.")
			return;
		}
		
		// 아이디 중복 체크 여부
		if( !b_idCheck ){
			alert("아이디 중복체크를 해주세요.");
			return;
		}
		
		f.action="member_regi.do";
		f.method="post";
		f.submit();
	}
	
	// 중복체크 버튼 클릭
	function check_id(){
		let id = document.getElementById("id").value.trim();
	
		if(id==''){
			alert("아이디를 입력하세요.");
			return;
		}
		
		let url = "check_id.do";
		let param = "id=" + id;
		// ajax url(Servlet)로 param 값 전송, 전송된 값을 다시 jsp로 가져와서 콜백메서드로, form메서드
		sendRequest( url, param, resFn, "post");
		
		function resFn(){
			// 콜백 메서드
			// xhr.readyState
			// 0: 초기화
			// 1 ~ 3 : 로딩
			// 4 : 로드 완료
			
			// xhr.status
			// 200: 이상 없음
			// 404, 500 : 오류 발생
			if( xhr.readyState == 4 && xhr.status == 200){
				
				// xhr.responseText -> Servlet에서 보내준 json 구조의 문자열 = [{ result : yes , id : (value) }]
				let data = xhr.responseText;
				
				// 문자열을 json 구조로 변경
				let json = eval ( data );
							
				if(json[0].result == 'no'){
					alert(" ' " + json[0].id+" ' " + "는 이미 사용 중인 아이디 입니다.");
				}else{
					alert(" ' " + json[0].id+" ' " + "는 사용 가능한 아이디 입니다.");
					// 중복 체크 성공
					b_idCheck = true;
				}
			}
		}
	}
	
	function che(){
		b_idCheck = false;
	}
</script>
</head>
<body>
	<form>
		<table border="1">
			<caption>::: 회원 추가 :::</caption>
			<tr>
				<th>이름 입력</th>
				<td><input name="name" /></td>
			<tr>
			<tr>
				<th>아이디 입력</th>
				<td><input name="id" onInput="che()" size="9" id="id"/>
					<input type="button" value="중복 체크" onClick="check_id()"/>
				</td>
			<tr>
			<tr>
				<th>비밀번호 입력</th>
				<td><input name="pwd" type="password"/></td>
			<tr>
			<tr>
				<th>이메일 입력</th>
				<td><input name="email" /></td>
			<tr>
			<tr>
				<th>주소 입력</th>
				<td><input name="addr" /></td>
			<tr>
			<tr>
				<td colspan="2">
				<input type="button" value="등록" onClick="regi(this.form)"/>
				<input type="button" value="취소" onClick="history.go(-1)"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>