<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function send(f) {
		
		f.action = "insert.do";
		f.submit();
		
	}
</script>
</head>
<body>
	<jsp:include page="index.jsp" />
	<form method="post">
	<!-- Byte 기반의 Stream -> post 메소드는 1바이트 씩 -->
		<table border="1" align="center" width="600">
			<tr>
				<td>제품 카테고리</td>
				<td>
					<select name="category">
						<option selected disabled>카테고리 선택</option>
						<option value="com001">컴퓨터</option>
						<option value="ele002">생활가전</option>
						<option value="sp003">스포츠</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>제품 코드</td>
				<td><input name="p_num" /></td>
			</tr>
			<tr>
				<td>제품 명</td>
				<td><input name="p_name" /></td>
			</tr>
			<tr>
				<td>제조사</td>
				<td><input name="p_company" /></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input name="p_price" /></td>
			</tr>
			<tr>
				<td>할인가</td>
				<td><input name="p_saleprice" /></td>
			</tr>
			<tr>
				<td colspan="2">제품 설명</td>
			</tr>
			<tr>
				<td colspan="2"><textarea rows="5" cols="85" name="p_content" style="resize:none"></textarea></td>
			</tr>
			<!-- <tr>
				<td>작은 사진 (썸네일)</td>
				<td><input type="file" name="p_image_s" /></td>
			</tr>
				<tr>
				<td>큰 사진 (상세 보기)</td>
				<td><input type="file" name="p_image_l" /></td>
			</tr> -->
			<tr align="right">
			<td colspan="2">
				<input type="button" value="상품 등록" onClick="send(this.form)" />
				<input type="button" value="취소" onClick="history.back()" />
			</td>
			</tr>			
		</table>
	</form>
</body>
</html>