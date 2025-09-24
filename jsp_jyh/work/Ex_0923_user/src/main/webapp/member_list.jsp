<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/httpRequest.js"></script>
<script>

	function del(idx) {

		if (!confirm("삭제하시겠습니까?")) {
			return;
		} else {
			let url = "member_del.do"
			// 특수 문자 처리
			let param = "idx=" + encodeURIComponent(idx);
			
			sendRequest( url, param, resDel,"post");
		}
			//location.href = 'member_del.do?idx=' + idx;
		}
		
		function resDel(){
			if(xhr.readyState == 4 && xhr.status == 200){
				
				// data = "[{'res' : '%s'}]"
				let data = xhr.responseText;
				
				let json = eval(data);
				
				if( json[0].res == 'yes' ){
					alert("삭제 성공");
					location.href = "list.do";
				}else{
					alert("삭제 실패");
				}
			}
		};

	
	
	function modify(idx) {
		location.href = 'modify.do?idx=' + idx;
	}
</script>
</head>
<body>
	<table border="1">
		<caption>::: 회원 목록 :::</caption>
		<tr>
			<th>회원번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>주소</th>
			<th>비고</th>
		</tr>

		<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.idx}</td>
				<td>${vo.name}</td>
				<td>${vo.id}</td>
				<td>${vo.pwd}</td>
				<td>${vo.email}</td>
				<td>${vo.addr}</td>
				<td>
				<input type="button" value="수정" onClick="modify('${vo.idx}')"/>
				<input type="button" value="삭제" onClick="del('${vo.idx}')"/>
				</td>
			</tr>
		</c:forEach>

		<tr>
			<td colspan="7"><input type="button" value="추가" onClick="location.href='insert_form.jsp'" /></td>
		</tr>
	</table>
</body>
</html>