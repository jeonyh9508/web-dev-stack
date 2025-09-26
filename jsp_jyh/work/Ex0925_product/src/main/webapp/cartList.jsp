<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="index.jsp" />
	<table align="center" width="600" border="1">
		<tr bgcolor="#dedede">
			<th>제품 코드</th>
			<th>이미지</th>
			<th>제품 명</th>
			<th width="25%">단가</th>
			<th>수량</th>
			<th colspan="2">금액</th>
		</tr>
		<c:forEach var="c" items="${vo}">
			<tr align="center">
				<td>${c.p_num}</td>
				<td><img src="images/${c.p_image_s}" width="75"/></td>
				<td>${c.p_name}</td>
				<td>
					단가 : <fmt:formatNumber value="${c.p_price}" />	 <br/>
					<font color="red">세일가격 : <b><fmt:formatNumber value="${c.p_saleprice}" /></b></font>
				</td>
				<td>
					<form>
						<input type="hidden" value="" />
						<input size="3" name="c_cnt" value="${c.c_cnt}"/> <br />
						<input type="submit" value="수정" />
					</form>
				</td>
				<td>${c.c_cnt * c.p_saleprice}</td>
				<td>
					<input type="button" value="삭제" />
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="right">총 결제금액 : &nbsp; </td>
			<td align="center"> <fmt:formatNumber value="${total}" /> </td>
		</tr>
	</table>
</body>
</html>