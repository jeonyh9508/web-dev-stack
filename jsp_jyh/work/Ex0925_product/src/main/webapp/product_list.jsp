<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function modify(idx) {
		location.href = "modify_form.do?idx=" + idx;
	}
</script>
</head>
<body>
	<jsp:include page="index.jsp" />
	
	<div align="center" width="600">
		<input type="button" value="상품등록" onClick="location.href='product_regi_form.jsp'" />
	</div>
	<hr />
	<table align="center" width="600" border="1" style="border-collapse:collapse">
		<tr bgcolor="#dedede">
			<th width="12%">제품 코드</th>
			<th width="12%">이미지</th>
			<th width="50%">제품 명</th>
			<th>가격</th>
		</tr>
		<c:forEach var="p" items="${list}">
		<tr align="center">
			<td>${p.p_num}</td>
			<td><img src="images/${p.p_image_s}" width="100" /></td>
			<td><a href="view.do?idx=${p.idx}">${p.p_name}</a></td>
			<td>
				<del><fmt:formatNumber value="${p.p_price}"/> 원</del><br />
				<fmt:formatNumber value="${p.p_saleprice}"/> 원<br />
				<font color="red">( ${p.sale_rate} % )</font><br />
				<input type="button" value="수정" name="idx" onClick="modify(${p.idx})"/>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>