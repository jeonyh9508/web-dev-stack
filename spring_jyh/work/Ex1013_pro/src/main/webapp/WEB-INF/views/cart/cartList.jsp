<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/pro/resources/js/httpRequest.js"></script>
<script>
	function modify(f) {
		
		let c_cnt = f.c_cnt.value;
		let patt = /^[0-9]*$/;
		
		if ( !patt.test(c_cnt) || c_cnt == '' || c_cnt == 0 ){
			alert("수량은 정수로 입력하세요.");
			return;
		}
		
		f.action ="cart_update.do";
		f.submit();
		
	}
	
	function del(c_idx){
		if(!confirm("정말 삭제하시겠습니까?")){
			return;
		}
		location.href="delete_cart.do?c_idx=" +c_idx;
	}
</script>
</head>
<body>
	<jsp:include page="../index.jsp" />
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
				<td><img src="resources/images/${c.p_image_s}" width="75"/></td>
				<td>${c.p_name}</td>
				<td>
					단가 : <fmt:formatNumber value="${c.p_price}" />	 <br/>
					<font color="red">세일가격 : <b><fmt:formatNumber value="${c.p_saleprice}" /></b></font>
				</td>
				<td>
					<form>
						<input type="hidden" name="c_idx" value="${c.c_idx}" />
						<input size="3" name="c_cnt" value="${c.c_cnt}" /> <br />
						<!-- onChange="modify(this.form)" -->
						<input type="button" value="수정" onClick="modify(this.form)"/>
					</form>
				</td>
				<td><fmt:formatNumber value="${c.c_cnt * c.p_saleprice}" /></td>
				<td>
					<input type="button" value="삭제" onClick ="del(${c.c_idx})"/>
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