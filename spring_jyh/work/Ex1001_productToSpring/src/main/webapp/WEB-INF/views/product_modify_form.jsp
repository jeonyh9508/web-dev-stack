<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function send(f) {
		f.action="modify_fin.do";
		f.submit();
	}
</script>
</head>
<body>
	<jsp:include page="index.jsp" />
	<form method="post" enctype="multipart/form-data">
		<input type="hidden" name="idx" value="${vo.idx}" />
		<input type="hidden" name="idx" value="${vo.category}" />
		<table border="1" align="center" width="600">
			<tr>
				<td>제품 카테고리</td>
				<td>${vo.category}</td>
			</tr>
			<tr>
				<td>제품 코드</td>
				<td>${vo.p_num}</td>
			</tr>
			<tr>
				<td>제품 명</td>
				<td>${vo.p_name}</td>
			</tr>
			<tr>
				<td>제조사</td>
				<td>${vo.p_company}</td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input name="p_price" value="${vo.p_price}"/></td>
			</tr>
			<tr>
				<td>할인가</td>
				<td><input name="p_saleprice" value="${vo.p_saleprice}"/></td>
			</tr>
			<tr>
				<td colspan="2">제품 설명</td>
			</tr>
			<tr>
				<td colspan="2"><textarea rows="5" cols="85" name="p_content"
						style="resize: none">${vo.p_content}</textarea></td>
			</tr>
			<tr>
				<td>작은 사진 (썸네일)</td>
				<td><img src="resources/images/${vo.p_image_s}" width="100"/><input type="file" name="sPhoto" /></td>
			</tr>
			<tr>
				<td>큰 사진 (상세 보기)</td>
				<td><img src="resources/images/${vo.p_image_l}"  width="100"/><input type="file" name="lPhoto" /></td>
			</tr>
			<tr align="right">
				<td colspan="2"><input type="button" value="상품 수정" onClick="send(this.form)" /> 
					<input type="button" value="취소" 	onClick="history.back()" /></td>
			</tr>
		</table>
	</form>
</body>
</html>